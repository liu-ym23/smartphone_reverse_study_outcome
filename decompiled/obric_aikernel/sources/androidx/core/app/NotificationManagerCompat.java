package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";

    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> sEnabledNotificationListenerPackages;

    @GuardedBy("sEnabledNotificationListenersLock")
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = null;
    private static final Object sLock = null;

    @GuardedBy("sLock")
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean areNotificationsEnabled(NotificationManager r10) {
            return r10.areNotificationsEnabled();
        }

        @DoNotInline
        static int getImportance(NotificationManager r10) {
            return r10.getImportance();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void createNotificationChannel(NotificationManager r10, NotificationChannel r11) {
            r10.createNotificationChannel(r11);
        }

        @DoNotInline
        static void createNotificationChannelGroup(NotificationManager r10, NotificationChannelGroup r11) {
            r10.createNotificationChannelGroup(r11);
        }

        @DoNotInline
        static void createNotificationChannelGroups(NotificationManager r10, List<NotificationChannelGroup> r11) {
            r10.createNotificationChannelGroups(r11);
        }

        @DoNotInline
        static void createNotificationChannels(NotificationManager r10, List<NotificationChannel> r11) {
            r10.createNotificationChannels(r11);
        }

        @DoNotInline
        static void deleteNotificationChannel(NotificationManager r10, String r11) {
            r10.deleteNotificationChannel(r11);
        }

        @DoNotInline
        static void deleteNotificationChannelGroup(NotificationManager r10, String r11) {
            r10.deleteNotificationChannelGroup(r11);
        }

        @DoNotInline
        static String getId(NotificationChannel r10) {
            return r10.getId();
        }

        @DoNotInline
        static String getId(NotificationChannelGroup r10) {
            return r10.getId();
        }

        @DoNotInline
        static NotificationChannel getNotificationChannel(NotificationManager r10, String r11) {
            return r10.getNotificationChannel(r11);
        }

        @DoNotInline
        static List<NotificationChannelGroup> getNotificationChannelGroups(NotificationManager r10) {
            return r10.getNotificationChannelGroups();
        }

        @DoNotInline
        static List<NotificationChannel> getNotificationChannels(NotificationManager r10) {
            return r10.getNotificationChannels();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static NotificationChannelGroup getNotificationChannelGroup(NotificationManager r10, String r11) {
            return r10.getNotificationChannelGroup(r11);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static NotificationChannel getNotificationChannel(NotificationManager r10, String r11, String r12) {
            return r10.getNotificationChannel(r11, r12);
        }

        @DoNotInline
        static String getParentChannelId(NotificationChannel r10) {
            return r10.getParentChannelId();
        }
    }

    private static class CancelTask implements Task {
        final boolean all;
        final int id;
        final String packageName;
        final String tag;

        CancelTask(String r10) {
            this.packageName = r10;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        CancelTask(String r10, int r11, String r12) {
            this.packageName = r10;
            this.id = r11;
            this.tag = r12;
            this.all = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(android.support.v4.app.a r10) {
            if (this.all == false) goto L5;
            r10.cancelAll(this.packageName);
            return;
        L5:
            r10.cancel(this.packageName, this.id, this.tag);
        }

        @NonNull
        public String toString() {
            return "CancelTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + ", all:" + this.all + "]";
        }
    }

    private static class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String r10, int r11, String r12, Notification r13) {
            this.packageName = r10;
            this.id = r11;
            this.tag = r12;
            this.notif = r13;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(android.support.v4.app.a r10) {
            r10.notify(this.packageName, this.id, this.tag, this.notif);
        }

        @NonNull
        public String toString() {
            return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + "]";
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName r10, IBinder r11) {
            this.componentName = r10;
            this.iBinder = r11;
        }
    }

    private static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap;

        private static class ListenerRecord {
            boolean bound;
            final ComponentName componentName;
            int retryCount;
            android.support.v4.app.a service;
            ArrayDeque<Task> taskQueue;

            ListenerRecord(ComponentName r10) {
                this.bound = false;
                this.taskQueue = new ArrayDeque();
                this.retryCount = 0;
                this.componentName = r10;
            }
        }

        SideChannelManager(Context r10) {
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = r10;
            HandlerThread r11 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = r11;
            r11.start();
            this.mHandler = new Handler(r11.getLooper(), this);
        }

        private boolean ensureServiceBound(ListenerRecord r10) {
            if (r10.bound == false) goto L6;
            return true;
        L6:
            boolean r11 = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(r10.componentName), this, 33);
            r10.bound = r11;
            if (r11 == false) goto L9;
            r10.retryCount = 0;
        L11:
            return r10.bound;
        L9:
            Log.w(NotificationManagerCompat.TAG, "Unable to bind to listener " + r10.componentName);
            this.mContext.unbindService(this);
            goto L11
        }

        private void ensureServiceUnbound(ListenerRecord r10) {
            if (r10.bound == false) goto L5;
            this.mContext.unbindService(this);
            r10.bound = false;
        L5:
            r10.service = null;
        }

        private void handleQueueTask(Task r10) {
            updateListenerMap();
            Iterator<ListenerRecord> r11 = this.mRecordMap.values().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ListenerRecord r12 = r11.next();
            r12.taskQueue.add(r10);
            processListenerQueue(r12);
            goto L4
        }

        private void handleRetryListenerQueue(ComponentName r10) {
            ListenerRecord r11 = this.mRecordMap.get(r10);
            if (r11 == null) goto L6;
            processListenerQueue(r11);
            return;
        }

        private void handleServiceConnected(ComponentName r10, IBinder r11) {
            ListenerRecord r12 = this.mRecordMap.get(r10);
            if (r12 == null) goto L6;
            r12.service = android.support.v4.app.a.AbstractBinderC0004a.asInterface(r11);
            r12.retryCount = 0;
            processListenerQueue(r12);
            return;
        }

        private void handleServiceDisconnected(ComponentName r10) {
            ListenerRecord r11 = this.mRecordMap.get(r10);
            if (r11 == null) goto L6;
            ensureServiceUnbound(r11);
            return;
        }

        private void processListenerQueue(ListenerRecord r10) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L6;
            Log.d(NotificationManagerCompat.TAG, "Processing component " + r10.componentName + ", " + r10.taskQueue.size() + " queued tasks");
        L6:
            if (r10.taskQueue.isEmpty() == false) goto L9;
            return;
        L9:
            if (ensureServiceBound(r10) == true) goto L11;
        L30:
            scheduleListenerRetry(r10);
            return;
        L11:
            if (r10.service == null) goto L30;
        L13:
            Task r11 = r10.taskQueue.peek();
            if (r11 == null) goto L27;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L19;
            Log.d(NotificationManagerCompat.TAG, "Sending task " + r11);     // Catch: RemoteException -> L21 DeadObjectException -> L23
        L19:
            r11.send(r10.service);     // Catch: RemoteException -> L21 DeadObjectException -> L23
            r10.taskQueue.remove();     // Catch: RemoteException -> L21 DeadObjectException -> L23
            goto L13
        L21:
            e = move-exception;
            Log.w(NotificationManagerCompat.TAG, "RemoteException communicating with " + r10.componentName, e);
        L24:
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L27;
            Log.d(NotificationManagerCompat.TAG, "Remote service has died: " + r10.componentName);
        L27:
            if (r10.taskQueue.isEmpty() == true) goto L37;
            scheduleListenerRetry(r10);
            return;
        }

        private void scheduleListenerRetry(ListenerRecord r10) {
            if (this.mHandler.hasMessages(3, r10.componentName) == false) goto L5;
            return;
        L5:
            int r11 = r10.retryCount + 1;
            r10.retryCount = r11;
            if (r11 <= 6) goto L9;
            Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + r10.taskQueue.size() + " tasks to " + r10.componentName + " after " + r10.retryCount + " retries");
            r10.taskQueue.clear();
            return;
        L9:
            int r12 = (1 << (r11 - 1)) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L12;
            Log.d(NotificationManagerCompat.TAG, "Scheduling retry for " + r12 + " ms");
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r10.componentName), r12);
        }

        private void updateListenerMap() {
            Set<String> r10 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (r10.equals(this.mCachedEnabledPackages) == false) goto L5;
            return;
        L5:
            this.mCachedEnabledPackages = r10;
            List<ResolveInfo> r11 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet r12 = new HashSet();
            Iterator<ResolveInfo> r13 = r11.iterator();
        L7:
            if (r13.hasNext() == false) goto L15;
            ResolveInfo r14 = r13.next();
            if (r10.contains(r14.serviceInfo.packageName) == false) goto L7;
            ServiceInfo r15 = r14.serviceInfo;
            ComponentName r16 = new ComponentName(r15.packageName, r15.name);
            if (r14.serviceInfo.permission != null) goto L13;
            r12.add(r16);
            goto L7
        L13:
            Log.w(NotificationManagerCompat.TAG, "Permission present on component " + r16 + ", not adding listener record.");
            goto L7
        L15:
            Iterator r17 = r12.iterator();
        L17:
            if (r17.hasNext() == false) goto L24;
            ComponentName r18 = (ComponentName) r17.next();
            if (this.mRecordMap.containsKey(r18) == true) goto L17;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            Log.d(NotificationManagerCompat.TAG, "Adding listener record for " + r18);
        L23:
            this.mRecordMap.put(r18, new ListenerRecord(r18));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, ListenerRecord>> r19 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r19.hasNext() == false) goto L33;
            Map.Entry<ComponentName, ListenerRecord> r20 = r19.next();
            if (r12.contains(r20.getKey()) == true) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            Log.d(NotificationManagerCompat.TAG, "Removing listener record for " + r20.getKey());
        L32:
            ensureServiceUnbound(r20.getValue());
            r19.remove();
            goto L26
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 == 0) goto L17;
            if (r11 != 1) goto L6;
            ServiceConnectedEvent r12 = (ServiceConnectedEvent) r10.obj;
            handleServiceConnected(r12.componentName, r12.iBinder);
            return true;
        L6:
            if (r11 != 2) goto L8;
            handleServiceDisconnected((ComponentName) r10.obj);
            return true;
        L8:
            if (r11 == 3) goto L11;
            return false;
        L11:
            handleRetryListenerQueue((ComponentName) r10.obj);
            return true;
        L17:
            handleQueueTask((Task) r10.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Connected to service " + r10);
        L5:
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(r10, r11)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Disconnected from service " + r10);
        L5:
            this.mHandler.obtainMessage(2, r10).sendToTarget();
        }

        public void queueTask(Task r10) {
            this.mHandler.obtainMessage(0, r10).sendToTarget();
        }
    }

    private interface Task {
        void send(android.support.v4.app.a r10);
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    private NotificationManagerCompat(Context r10) {
        this.mContext = r10;
        this.mNotificationManager = (NotificationManager) r10.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context r10) {
        return new NotificationManagerCompat(r10);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context r10) {
        String r11 = Settings.Secure.getString(r10.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object r12 = sEnabledNotificationListenersLock;
        monitor-enter(r12);
        if (r11 != null) goto L20;
    L14:
        Set<String> r13 = sEnabledNotificationListenerPackages;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r13;
    L17:
        th = move-exception;
        throw th;
    L20:
        if (r11.equals(sEnabledNotificationListeners) == true) goto L14;
        String[] r14 = r11.split(":", -1);     // Catch: Throwable -> L17
        HashSet r15 = new HashSet(r14.length);     // Catch: Throwable -> L17
        int r16 = r14.length;     // Catch: Throwable -> L17
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L13;
        ComponentName r18 = ComponentName.unflattenFromString(r14[r17]);     // Catch: Throwable -> L17
        if (r18 == null) goto L12;
        r15.add(r18.getPackageName());     // Catch: Throwable -> L17
    L12:
        r17 = r17 + 1;     // Catch: Throwable -> L17
        goto L8
    L13:
        sEnabledNotificationListenerPackages = r15;     // Catch: Throwable -> L17
        sEnabledNotificationListeners = r11;     // Catch: Throwable -> L17
        goto L14
    }

    private void pushSideChannelQueue(Task r10) {
        Object r11 = sLock;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSideChannelManager != null) goto L7;
        sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        sSideChannelManager.queueTask(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    }

    private static boolean useSideChannelForNotification(Notification r10) {
        Bundle r11 = NotificationCompat.getExtras(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.getBoolean(EXTRA_USE_SIDE_CHANNEL) == false) goto L7;
        return true;
    }

    public boolean areNotificationsEnabled() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 24) goto L7;
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    L7:
        if (r10 < 19) goto L17;
        AppOpsManager r11 = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo r12 = this.mContext.getApplicationInfo();
        String r13 = this.mContext.getApplicationContext().getPackageName();
        int r14 = r12.uid;
        Class<?> r15 = Class.forName(AppOpsManager.class.getName());     // Catch: Throwable -> L14
        Class<?> r16 = Integer.TYPE;     // Catch: Throwable -> L14
        if (((Integer) r15.getMethod(CHECK_OP_NO_THROW, new Class[]{r16, r16, String.class}).invoke(r11, new Object[]{Integer.valueOf(((Integer) r15.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(r14), r13})).intValue() != 0) goto L13;
        return true;
    L13:
        return false;
    L19:
        return true;
    L17:
        return true;
    }

    public void cancel(int r10) {
        cancel(null, r10);
    }

    public void cancel(@Nullable String r10, int r11) {
        this.mNotificationManager.cancel(r10, r11);
        if (Build.VERSION.SDK_INT > 19) goto L6;
        pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), r11, r10));
        return;
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
        if (Build.VERSION.SDK_INT > 19) goto L6;
        pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
        return;
    }

    public void createNotificationChannel(@NonNull NotificationChannel r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannel(this.mNotificationManager, r10);
        return;
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat r10) {
        createNotificationChannel(r10.getNotificationChannel());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroup(this.mNotificationManager, r10);
        return;
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat r10) {
        createNotificationChannelGroup(r10.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r10);
        return;
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L14;
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<NotificationChannelGroupCompat> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add(r12.next().getNotificationChannelGroup());
        goto L8
    L10:
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r11);
        return;
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannels(this.mNotificationManager, r10);
        return;
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L14;
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<NotificationChannelCompat> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add(r12.next().getNotificationChannel());
        goto L8
    L10:
        Api26Impl.createNotificationChannels(this.mNotificationManager, r11);
        return;
    }

    public void deleteNotificationChannel(@NonNull String r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, r10);
        return;
    }

    public void deleteNotificationChannelGroup(@NonNull String r10) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, r10);
        return;
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> r10) {
        if (Build.VERSION.SDK_INT < 26) goto L16;
        Iterator<NotificationChannel> r11 = Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
    L6:
        if (r11.hasNext() == false) goto L25;
        NotificationChannel r12 = r11.next();
        if (r10.contains(Api26Impl.getId(r12)) == true) goto L6;
        if (Build.VERSION.SDK_INT < 30) goto L15;
        if (r10.contains(Api30Impl.getParentChannelId(r12)) == true) goto L6;
    L15:
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(r12));
        goto L6
    L25:
        return;
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return -1000;
    L5:
        return Api24Impl.getImportance(this.mNotificationManager);
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getNotificationChannel(this.mNotificationManager, r10);
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getNotificationChannel(this.mNotificationManager, r10, r11);
    L7:
        return getNotificationChannel(r10);
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String r10) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r11 = getNotificationChannel(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r11);
    L8:
        return null;
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r12 = getNotificationChannel(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r12);
    L8:
        return null;
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L7;
        return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, r10);
    L7:
        if (r11 < 26) goto L14;
        Iterator<NotificationChannelGroup> r12 = getNotificationChannelGroups().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        NotificationChannelGroup r13 = r12.next();
        if (Api26Impl.getId(r13).equals(r10) == false) goto L10;
        return r13;
    L14:
        return null;
    }

    @Nullable
    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(@NonNull String r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L9;
        NotificationChannelGroup r12 = getNotificationChannelGroup(r10);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelGroupCompat(r12);
    L9:
        if (r11 < 26) goto L16;
        NotificationChannelGroup r13 = getNotificationChannelGroup(r10);
        if (r13 != null) goto L13;
        return null;
    L13:
        return new NotificationChannelGroupCompat(r13, getNotificationChannels());
    L16:
        return null;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 26) goto L20;
        List<NotificationChannelGroup> r11 = getNotificationChannelGroups();
        if (r11.isEmpty() == true) goto L20;
        if (r10 < 28) goto L9;
        List<NotificationChannel> r12 = Collections.emptyList();
    L10:
        ArrayList r13 = new ArrayList(r11.size());
        Iterator<NotificationChannelGroup> r14 = r11.iterator();
    L12:
        if (r14.hasNext() == false) goto L18;
        NotificationChannelGroup r15 = r14.next();
        if (Build.VERSION.SDK_INT < 28) goto L16;
        NotificationChannelGroupCompat r16 = new NotificationChannelGroupCompat(r15);
    L17:
        r13.add(r16);
        goto L12
    L16:
        r16 = new NotificationChannelGroupCompat(r15, r12);
        goto L17
    L18:
        return r13;
    L9:
        r12 = getNotificationChannels();
    L20:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannels(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        List<NotificationChannel> r10 = getNotificationChannels();
        if (r10.isEmpty() == true) goto L12;
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<NotificationChannel> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add(new NotificationChannelCompat(r12.next()));
        goto L8
    L10:
        return r11;
    L12:
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(int r10, @NonNull Notification r11) {
        notify(null, r10, r11);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@Nullable String r10, int r11, @NonNull Notification r12) {
        if (useSideChannelForNotification(r12) == false) goto L5;
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), r11, r10, r12));
        this.mNotificationManager.cancel(r10, r11);
        return;
    L5:
        this.mNotificationManager.notify(r10, r11, r12);
    }
}
