package androidx.core.app;

import ai.j0;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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
import android.service.notification.StatusBarNotification;
import android.support.v4.app.c;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import cn.nubia.neopush.commons.Constant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
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

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static List<StatusBarNotification> getActiveNotifications(NotificationManager r5) {
            StatusBarNotification[] r10 = r5.getActiveNotifications();
            if (r10 != null) goto L7;
            return new ArrayList();
        L7:
            return Arrays.asList(r10);
        }

        @DoNotInline
        public static int getCurrentInterruptionFilter(NotificationManager r5) {
            return r5.getCurrentInterruptionFilter();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static boolean areNotificationsEnabled(NotificationManager r5) {
            return r5.areNotificationsEnabled();
        }

        @DoNotInline
        public static int getImportance(NotificationManager r5) {
            return r5.getImportance();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void createNotificationChannel(NotificationManager r5, NotificationChannel r10) {
            r5.createNotificationChannel(r10);
        }

        @DoNotInline
        public static void createNotificationChannelGroup(NotificationManager r5, NotificationChannelGroup r10) {
            r5.createNotificationChannelGroup(r10);
        }

        @DoNotInline
        public static void createNotificationChannelGroups(NotificationManager r5, List<NotificationChannelGroup> r10) {
            r5.createNotificationChannelGroups(r10);
        }

        @DoNotInline
        public static void createNotificationChannels(NotificationManager r5, List<NotificationChannel> r10) {
            r5.createNotificationChannels(r10);
        }

        @DoNotInline
        public static void deleteNotificationChannel(NotificationManager r5, String r10) {
            r5.deleteNotificationChannel(r10);
        }

        @DoNotInline
        public static void deleteNotificationChannelGroup(NotificationManager r5, String r10) {
            r5.deleteNotificationChannelGroup(r10);
        }

        @DoNotInline
        public static String getId(NotificationChannel r5) {
            return r5.getId();
        }

        @DoNotInline
        public static NotificationChannel getNotificationChannel(NotificationManager r5, String r10) {
            return r5.getNotificationChannel(r10);
        }

        @DoNotInline
        public static List<NotificationChannelGroup> getNotificationChannelGroups(NotificationManager r5) {
            return r5.getNotificationChannelGroups();
        }

        @DoNotInline
        public static List<NotificationChannel> getNotificationChannels(NotificationManager r5) {
            return r5.getNotificationChannels();
        }

        @DoNotInline
        public static String getId(NotificationChannelGroup r5) {
            return r5.getId();
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static NotificationChannelGroup getNotificationChannelGroup(NotificationManager r5, String r10) {
            return r5.getNotificationChannelGroup(r10);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static NotificationChannel getNotificationChannel(NotificationManager r5, String r10, String r11) {
            return r5.getNotificationChannel(r10, r11);
        }

        @DoNotInline
        public static String getParentChannelId(NotificationChannel r5) {
            return r5.getParentChannelId();
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static boolean canUseFullScreenIntent(NotificationManager r5) {
            return r5.canUseFullScreenIntent();
        }
    }

    public static class CancelTask implements Task {
        final boolean all;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f444id;
        final String packageName;
        final String tag;

        public CancelTask(String r5) {
            this.packageName = r5;
            this.f444id = 0;
            this.tag = null;
            this.all = true;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(c r5) throws RemoteException {
            if (this.all == false) goto L5;
            r5.cancelAll(this.packageName);
            return;
        L5:
            r5.cancel(this.packageName, this.f444id, this.tag);
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("CancelTask[packageName:");
            r5.append(this.packageName);
            r5.append(", id:");
            r5.append(this.f444id);
            r5.append(", tag:");
            r5.append(this.tag);
            r5.append(", all:");
            return j0.r(r5, this.all, "]");
        }

        public CancelTask(String r5, int r10, String r11) {
            this.packageName = r5;
            this.f444id = r10;
            this.tag = r11;
            this.all = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {
        final int mId;
        Notification mNotification;
        final String mTag;

        public NotificationWithIdAndTag(@Nullable String r5, int r10, @NonNull Notification r11) {
            this.mTag = r5;
            this.mId = r10;
            this.mNotification = r11;
        }

        public NotificationWithIdAndTag(int r5, @NonNull Notification r10) {
            this(null, r5, r10);
        }
    }

    public static class NotifyTask implements Task {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f445id;
        final Notification notif;
        final String packageName;
        final String tag;

        public NotifyTask(String r5, int r10, String r11, Notification r12) {
            this.packageName = r5;
            this.f445id = r10;
            this.tag = r11;
            this.notif = r12;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(c r5) throws RemoteException {
            r5.notify(this.packageName, this.f445id, this.tag, this.notif);
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("NotifyTask[packageName:");
            r5.append(this.packageName);
            r5.append(", id:");
            r5.append(this.f445id);
            r5.append(", tag:");
            return j0.q(r5, this.tag, "]");
        }
    }

    public static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName r5, IBinder r10) {
            this.componentName = r5;
            this.iBinder = r10;
        }
    }

    public static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap;

        public static class ListenerRecord {
            boolean bound;
            final ComponentName componentName;
            int retryCount;
            c service;
            ArrayDeque<Task> taskQueue;

            public ListenerRecord(ComponentName r5) {
                this.bound = false;
                this.taskQueue = new ArrayDeque();
                this.retryCount = 0;
                this.componentName = r5;
            }
        }

        public SideChannelManager(Context r5) {
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = r5;
            HandlerThread r10 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = r10;
            r10.start();
            this.mHandler = new Handler(r10.getLooper(), this);
        }

        private boolean ensureServiceBound(ListenerRecord r5) {
            if (r5.bound == false) goto L6;
            return true;
        L6:
            boolean r10 = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(r5.componentName), this, 33);
            r5.bound = r10;
            if (r10 == false) goto L9;
            r5.retryCount = 0;
        L11:
            return r5.bound;
        L9:
            Log.w(NotificationManagerCompat.TAG, "Unable to bind to listener " + r5.componentName);
            this.mContext.unbindService(this);
            goto L11
        }

        private void ensureServiceUnbound(ListenerRecord r5) {
            if (r5.bound == false) goto L5;
            this.mContext.unbindService(this);
            r5.bound = false;
        L5:
            r5.service = null;
        }

        private void handleQueueTask(Task r5) {
            updateListenerMap();
            Iterator<ListenerRecord> r10 = this.mRecordMap.values().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ListenerRecord r11 = r10.next();
            r11.taskQueue.add(r5);
            processListenerQueue(r11);
            goto L4
        }

        private void handleRetryListenerQueue(ComponentName r5) {
            ListenerRecord r10 = this.mRecordMap.get(r5);
            if (r10 == null) goto L6;
            processListenerQueue(r10);
            return;
        }

        private void handleServiceConnected(ComponentName r5, IBinder r10) {
            ListenerRecord r11 = this.mRecordMap.get(r5);
            if (r11 == null) goto L6;
            r11.service = android.support.v4.app.b.asInterface(r10);
            r11.retryCount = 0;
            processListenerQueue(r11);
            return;
        }

        private void handleServiceDisconnected(ComponentName r5) {
            ListenerRecord r10 = this.mRecordMap.get(r5);
            if (r10 == null) goto L6;
            ensureServiceUnbound(r10);
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
        L31:
            scheduleListenerRetry(r10);
            return;
        L11:
            if (r10.service == null) goto L31;
        L13:
            Task r5 = r10.taskQueue.peek();
            if (r5 == null) goto L28;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L21;
            Log.d(NotificationManagerCompat.TAG, "Sending task " + r5);     // Catch: RemoteException -> L19 DeadObjectException -> L24
        L21:
            r5.send(r10.service);     // Catch: RemoteException -> L19 DeadObjectException -> L24
            r10.taskQueue.remove();     // Catch: RemoteException -> L19 DeadObjectException -> L24
            goto L13
        L19:
            e = move-exception;
            Log.w(NotificationManagerCompat.TAG, "RemoteException communicating with " + r10.componentName, e);
        L25:
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L28;
            Log.d(NotificationManagerCompat.TAG, "Remote service has died: " + r10.componentName);
        L28:
            if (r10.taskQueue.isEmpty() == true) goto L38;
            scheduleListenerRetry(r10);
            return;
        }

        private void scheduleListenerRetry(ListenerRecord r10) {
            if (this.mHandler.hasMessages(3, r10.componentName) == false) goto L5;
            return;
        L5:
            int r5 = r10.retryCount;
            int r11 = r5 + 1;
            r10.retryCount = r11;
            if (r11 <= 6) goto L9;
            Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + r10.taskQueue.size() + " tasks to " + r10.componentName + " after " + r10.retryCount + " retries");
            r10.taskQueue.clear();
            return;
        L9:
            int r12 = (1 << r5) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L12;
            Log.d(NotificationManagerCompat.TAG, "Scheduling retry for " + r12 + " ms");
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r10.componentName), r12);
        }

        private void updateListenerMap() {
            Set<String> r5 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (r5.equals(this.mCachedEnabledPackages) == false) goto L5;
            return;
        L5:
            this.mCachedEnabledPackages = r5;
            List<ResolveInfo> r10 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet r11 = new HashSet();
            Iterator<ResolveInfo> r12 = r10.iterator();
        L7:
            if (r12.hasNext() == false) goto L15;
            ResolveInfo r13 = r12.next();
            if (r5.contains(r13.serviceInfo.packageName) == false) goto L7;
            ServiceInfo r14 = r13.serviceInfo;
            ComponentName r15 = new ComponentName(r14.packageName, r14.name);
            if (r13.serviceInfo.permission != null) goto L13;
            r11.add(r15);
            goto L7
        L13:
            Log.w(NotificationManagerCompat.TAG, "Permission present on component " + r15 + ", not adding listener record.");
            goto L7
        L15:
            Iterator r16 = r11.iterator();
        L17:
            if (r16.hasNext() == false) goto L24;
            ComponentName r17 = (ComponentName) r16.next();
            if (this.mRecordMap.containsKey(r17) == true) goto L17;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            Log.d(NotificationManagerCompat.TAG, "Adding listener record for " + r17);
        L23:
            this.mRecordMap.put(r17, new ListenerRecord(r17));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, ListenerRecord>> r18 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r18.hasNext() == false) goto L33;
            Map.Entry<ComponentName, ListenerRecord> r19 = r18.next();
            if (r11.contains(r19.getKey()) == true) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            Log.d(NotificationManagerCompat.TAG, "Removing listener record for " + r19.getKey());
        L32:
            ensureServiceUnbound(r19.getValue());
            r18.remove();
            goto L26
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r5) {
            int r10 = r5.what;
            if (r10 == 0) goto L17;
            if (r10 != 1) goto L6;
            ServiceConnectedEvent r11 = (ServiceConnectedEvent) r5.obj;
            handleServiceConnected(r11.componentName, r11.iBinder);
            return true;
        L6:
            if (r10 != 2) goto L8;
            handleServiceDisconnected((ComponentName) r5.obj);
            return true;
        L8:
            if (r10 == 3) goto L11;
            return false;
        L11:
            handleRetryListenerQueue((ComponentName) r5.obj);
            return true;
        L17:
            handleQueueTask((Task) r5.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r5, IBinder r10) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Connected to service " + r5);
        L5:
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(r5, r10)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r5) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Disconnected from service " + r5);
        L5:
            this.mHandler.obtainMessage(2, r5).sendToTarget();
        }

        public void queueTask(Task r5) {
            this.mHandler.obtainMessage(0, r5).sendToTarget();
        }
    }

    public interface Task {
        void send(c r5) throws RemoteException;
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    private NotificationManagerCompat(Context r5) {
        this.mContext = r5;
        this.mNotificationManager = (NotificationManager) r5.getSystemService(Constant.NOTIFICATION);
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context r5) {
        return new NotificationManagerCompat(r5);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context r10) {
        String r11 = Settings.Secure.getString(r10.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object r5 = sEnabledNotificationListenersLock;
        monitor-enter(r5);
        if (r11 != null) goto L21;
    L16:
        Set<String> r12 = sEnabledNotificationListenerPackages;     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        return r12;
    L12:
        th = move-exception;
        throw th;
    L21:
        if (r11.equals(sEnabledNotificationListeners) == true) goto L16;
        String[] r13 = r11.split(":", -1);     // Catch: Throwable -> L12
        HashSet r14 = new HashSet(r13.length);     // Catch: Throwable -> L12
        int r15 = r13.length;     // Catch: Throwable -> L12
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L15;
        ComponentName r17 = ComponentName.unflattenFromString(r13[r16]);     // Catch: Throwable -> L12
        if (r17 == null) goto L14;
        r14.add(r17.getPackageName());     // Catch: Throwable -> L12
    L14:
        r16 = r16 + 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        sEnabledNotificationListenerPackages = r14;     // Catch: Throwable -> L12
        sEnabledNotificationListeners = r11;     // Catch: Throwable -> L12
        goto L16
    }

    private void pushSideChannelQueue(Task r5) {
        Object r10 = sLock;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sSideChannelManager != null) goto L9;
        sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());     // Catch: Throwable -> L7
    L9:
        sSideChannelManager.queueTask(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
    }

    private static boolean useSideChannelForNotification(Notification r5) {
        Bundle r10 = NotificationCompat.getExtras(r5);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getBoolean(EXTRA_USE_SIDE_CHANNEL) == false) goto L7;
        return true;
    }

    public boolean areNotificationsEnabled() {
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public boolean canUseFullScreenIntent() {
        if (Build.VERSION.SDK_INT >= 34) goto L10;
        if (this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancel(int r5) {
        cancel(null, r5);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(@NonNull NotificationChannel r5) {
        Api26Impl.createNotificationChannel(this.mNotificationManager, r5);
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup r5) {
        Api26Impl.createNotificationChannelGroup(this.mNotificationManager, r5);
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> r5) {
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r5);
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> r5) {
        if (r5.isEmpty() == true) goto L11;
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<NotificationChannelGroupCompat> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(r11.next().getNotificationChannelGroup());
        goto L6
    L8:
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r10);
        return;
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> r5) {
        Api26Impl.createNotificationChannels(this.mNotificationManager, r5);
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> r5) {
        if (r5.isEmpty() == true) goto L11;
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<NotificationChannelCompat> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(r11.next().getNotificationChannel());
        goto L6
    L8:
        Api26Impl.createNotificationChannels(this.mNotificationManager, r10);
        return;
    }

    public void deleteNotificationChannel(@NonNull String r5) {
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, r5);
    }

    public void deleteNotificationChannelGroup(@NonNull String r5) {
        Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, r5);
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> r5) {
        Iterator<NotificationChannel> r10 = Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        NotificationChannel r11 = r10.next();
        if (r5.contains(Api26Impl.getId(r11)) == true) goto L4;
        if (r5.contains(Api30Impl.getParentChannelId(r11)) == true) goto L4;
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(r11));
        goto L4
    }

    @NonNull
    public List<StatusBarNotification> getActiveNotifications() {
        return Api23Impl.getActiveNotifications(this.mNotificationManager);
    }

    public int getCurrentInterruptionFilter() {
        return Api23Impl.getCurrentInterruptionFilter(this.mNotificationManager);
    }

    public int getImportance() {
        return Api24Impl.getImportance(this.mNotificationManager);
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String r5) {
        return Api26Impl.getNotificationChannel(this.mNotificationManager, r5);
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String r5) {
        NotificationChannel r10 = getNotificationChannel(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new NotificationChannelCompat(r10);
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String r5) {
        return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, r5);
    }

    @Nullable
    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(@NonNull String r5) {
        NotificationChannelGroup r10 = getNotificationChannelGroup(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new NotificationChannelGroupCompat(r10);
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    }

    @NonNull
    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        List<NotificationChannelGroup> r5 = getNotificationChannelGroups();
        if (r5.isEmpty() == true) goto L10;
        Collections.emptyList();
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<NotificationChannelGroup> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(new NotificationChannelGroupCompat(r11.next()));
        goto L6
    L8:
        return r10;
    L10:
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        return Api26Impl.getNotificationChannels(this.mNotificationManager);
    }

    @NonNull
    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        List<NotificationChannel> r5 = getNotificationChannels();
        if (r5.isEmpty() == true) goto L10;
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<NotificationChannel> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(new NotificationChannelCompat(r11.next()));
        goto L6
    L8:
        return r10;
    L10:
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(int r5, @NonNull Notification r10) {
        notify(null, r5, r10);
    }

    public void cancel(@Nullable String r5, int r10) {
        this.mNotificationManager.cancel(r5, r10);
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat r5) {
        createNotificationChannel(r5.getNotificationChannel());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat r5) {
        createNotificationChannelGroup(r5.getNotificationChannelGroup());
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String r5, @NonNull String r10) {
        return Api30Impl.getNotificationChannel(this.mNotificationManager, r5, r10);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@Nullable String r5, int r10, @NonNull Notification r11) {
        if (useSideChannelForNotification(r11) == false) goto L5;
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), r10, r5, r11));
        this.mNotificationManager.cancel(r5, r10);
        return;
    L5:
        this.mNotificationManager.notify(r5, r10, r11);
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String r5, @NonNull String r10) {
        NotificationChannel r11 = getNotificationChannel(r5, r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return new NotificationChannelCompat(r11);
    }

    @VisibleForTesting
    public NotificationManagerCompat(@NonNull NotificationManager r5, @NonNull Context r10) {
        this.mContext = r10;
        this.mNotificationManager = r5;
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@NonNull List<NotificationWithIdAndTag> r10) {
        int r5 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        NotificationWithIdAndTag r12 = r10.get(r11);
        notify(r12.mTag, r12.mId, r12.mNotification);
        r11 = r11 + 1;
        goto L3
    }
}
