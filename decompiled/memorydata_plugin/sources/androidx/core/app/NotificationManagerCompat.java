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
import android.support.v4.app.a;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.apache.logging.log4j.message.ParameterizedMessage;

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
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = null;
    private static final Object sLock = null;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    static class Api23Impl {
        private Api23Impl() {
        }

        static List<StatusBarNotification> getActiveNotifications(NotificationManager r0) {
            StatusBarNotification[] r1 = r0.getActiveNotifications();
            if (r1 != null) goto L7;
            return new ArrayList();
        L7:
            return Arrays.asList(r1);
        }

        static int getCurrentInterruptionFilter(NotificationManager r0) {
            return r0.getCurrentInterruptionFilter();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean areNotificationsEnabled(NotificationManager r0) {
            return r0.areNotificationsEnabled();
        }

        static int getImportance(NotificationManager r0) {
            return r0.getImportance();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void createNotificationChannel(NotificationManager r0, NotificationChannel r1) {
            r0.createNotificationChannel(r1);
        }

        static void createNotificationChannelGroup(NotificationManager r0, NotificationChannelGroup r1) {
            r0.createNotificationChannelGroup(r1);
        }

        static void createNotificationChannelGroups(NotificationManager r2, List<NotificationChannelGroup> r3) {
            r2.createNotificationChannelGroups((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        static void createNotificationChannels(NotificationManager r2, List<NotificationChannel> r3) {
            r2.createNotificationChannels((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        static void deleteNotificationChannel(NotificationManager r0, String r1) {
            r0.deleteNotificationChannel(r1);
        }

        static void deleteNotificationChannelGroup(NotificationManager r0, String r1) {
            r0.deleteNotificationChannelGroup(r1);
        }

        static String getId(NotificationChannel r0) {
            return r0.getId();
        }

        static String getId(NotificationChannelGroup r0) {
            return r0.getId();
        }

        static NotificationChannel getNotificationChannel(NotificationManager r0, String r1) {
            return r0.getNotificationChannel(r1);
        }

        static List<NotificationChannelGroup> getNotificationChannelGroups(NotificationManager r0) {
            return r0.getNotificationChannelGroups();
        }

        static List<NotificationChannel> getNotificationChannels(NotificationManager r0) {
            return r0.getNotificationChannels();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static NotificationChannelGroup getNotificationChannelGroup(NotificationManager r0, String r1) {
            return r0.getNotificationChannelGroup(r1);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static NotificationChannel getNotificationChannel(NotificationManager r0, String r1, String r2) {
            return r0.getNotificationChannel(r1, r2);
        }

        static String getParentChannelId(NotificationChannel r0) {
            return r0.getParentChannelId();
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static boolean canUseFullScreenIntent(NotificationManager r0) {
            return r0.canUseFullScreenIntent();
        }
    }

    private static class CancelTask implements Task {
        final boolean all;
        final int id;
        final String packageName;
        final String tag;

        CancelTask(String r1) {
            this.packageName = r1;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        CancelTask(String r1, int r2, String r3) {
            this.packageName = r1;
            this.id = r2;
            this.tag = r3;
            this.all = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            if (this.all == false) goto L5;
            r4.cancelAll(this.packageName);
            return;
        L5:
            r4.cancel(this.packageName, this.id, this.tag);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("CancelTask[");
            r0.append("packageName:").append(this.packageName);
            r0.append(", id:").append(this.id);
            r0.append(", tag:").append(this.tag);
            r0.append(", all:").append(this.all);
            r0.append("]");
            return r0.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {
        final int mId;
        Notification mNotification;
        final String mTag;

        public NotificationWithIdAndTag(int r2, Notification r3) {
            this(null, r2, r3);
        }

        public NotificationWithIdAndTag(String r1, int r2, Notification r3) {
            this.mTag = r1;
            this.mId = r2;
            this.mNotification = r3;
        }
    }

    private static class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String r1, int r2, String r3, Notification r4) {
            this.packageName = r1;
            this.id = r2;
            this.tag = r3;
            this.notif = r4;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(a r4) {
            ((a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin")).notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("NotifyTask[");
            r0.append("packageName:").append(this.packageName);
            r0.append(", id:").append(this.id);
            r0.append(", tag:").append(this.tag);
            r0.append("]");
            return r0.toString();
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            this.componentName = r3;
            this.iBinder = r5;
        }
    }

    private static class SideChannelManager implements ServiceConnection, Handler.Callback {
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
            a service;
            ArrayDeque<Task> taskQueue;

            ListenerRecord(ComponentName r3) {
                this.bound = false;
                this.taskQueue = new ArrayDeque();
                this.retryCount = 0;
                this.componentName = r3;
            }
        }

        SideChannelManager(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
            HandlerThread r5 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = r5;
            r5.start();
            this.mHandler = new Handler(r5.getLooper(), this);
        }

        private boolean ensureServiceBound(ListenerRecord r5) {
            if (r5.bound == false) goto L6;
            return true;
        L6:
            r5.bound = ZeusTransformUtils.bindService(this.mContext, new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(r5.componentName), this, 33, "com.obric.memorydata.plugin");
            if (r5.bound == false) goto L9;
            r5.retryCount = 0;
        L11:
            return r5.bound;
        L9:
            Log.w(NotificationManagerCompat.TAG, "Unable to bind to listener " + r5.componentName);
            ZeusTransformUtils.unbindService(this.mContext, this, "com.obric.memorydata.plugin");
            goto L11
        }

        private void ensureServiceUnbound(ListenerRecord r3) {
            if (r3.bound == false) goto L5;
            ZeusTransformUtils.unbindService(this.mContext, this, "com.obric.memorydata.plugin");
            r3.bound = false;
        L5:
            r3.service = null;
        }

        private void handleQueueTask(Task r5) {
            Task r6 = (Task) ZeusTransformUtils.wrapperContextForParams(r5, Task.class, "com.obric.memorydata.plugin");
            updateListenerMap();
            Iterator<ListenerRecord> r0 = this.mRecordMap.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ListenerRecord r2 = (ListenerRecord) ZeusTransformUtils.preCheckCast(r0.next(), ListenerRecord.class, "com.obric.memorydata.plugin");
            r2.taskQueue.add(r6);
            processListenerQueue(r2);
            goto L4
        }

        private void handleRetryListenerQueue(ComponentName r3) {
            ListenerRecord r4 = (ListenerRecord) ZeusTransformUtils.preCheckCast(this.mRecordMap.get(r3), ListenerRecord.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L6;
            processListenerQueue(r4);
            return;
        }

        private void handleServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            ListenerRecord r6 = (ListenerRecord) ZeusTransformUtils.preCheckCast(this.mRecordMap.get(r3), ListenerRecord.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L6;
            r6.service = a.AbstractBinderC0005a.asInterface(r5);
            r6.retryCount = 0;
            processListenerQueue(r6);
            return;
        }

        private void handleServiceDisconnected(ComponentName r3) {
            ListenerRecord r4 = (ListenerRecord) ZeusTransformUtils.preCheckCast(this.mRecordMap.get(r3), ListenerRecord.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L6;
            ensureServiceUnbound(r4);
            return;
        }

        private void processListenerQueue(ListenerRecord r6) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L6;
            Log.d(NotificationManagerCompat.TAG, "Processing component " + r6.componentName + ", " + r6.taskQueue.size() + " queued tasks");
        L6:
            if (r6.taskQueue.isEmpty() == false) goto L9;
            return;
        L9:
            if (ensureServiceBound(r6) == true) goto L11;
        L30:
            scheduleListenerRetry(r6);
            return;
        L11:
            if (r6.service == null) goto L30;
        L13:
            Task r2 = (Task) ZeusTransformUtils.preCheckCast(r6.taskQueue.peek(), Task.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L27;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L19;
            Log.d(NotificationManagerCompat.TAG, "Sending task " + r2);     // Catch: RemoteException -> L21 DeadObjectException -> L23
        L19:
            r2.send(r6.service);     // Catch: RemoteException -> L21 DeadObjectException -> L23
            r6.taskQueue.remove();     // Catch: RemoteException -> L21 DeadObjectException -> L23
            goto L13
        L21:
            e = move-exception;
            Log.w(NotificationManagerCompat.TAG, "RemoteException communicating with " + r6.componentName, e);
        L24:
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L27;
            Log.d(NotificationManagerCompat.TAG, "Remote service has died: " + r6.componentName);
        L27:
            if (r6.taskQueue.isEmpty() == true) goto L37;
            scheduleListenerRetry(r6);
            return;
        }

        private void scheduleListenerRetry(ListenerRecord r6) {
            if (this.mHandler.hasMessages(3, r6.componentName) == false) goto L5;
            return;
        L5:
            r6.retryCount++;
            if (r6.retryCount <= 6) goto L9;
            Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + r6.taskQueue.size() + " tasks to " + r6.componentName + " after " + r6.retryCount + " retries");
            r6.taskQueue.clear();
            return;
        L9:
            int r0 = (1 << (r6.retryCount - 1)) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L12;
            Log.d(NotificationManagerCompat.TAG, "Scheduling retry for " + r0 + " ms");
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r6.componentName), r0);
        }

        private void updateListenerMap() {
            Set<String> r0 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (r0.equals(this.mCachedEnabledPackages) == false) goto L5;
            return;
        L5:
            this.mCachedEnabledPackages = r0;
            List<ResolveInfo> r1 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet r2 = new HashSet();
            Iterator<ResolveInfo> r3 = r1.iterator();
        L7:
            if (r3.hasNext() == false) goto L15;
            ResolveInfo r4 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r3.next(), ResolveInfo.class, "com.obric.memorydata.plugin");
            if (r0.contains(r4.serviceInfo.packageName) == false) goto L7;
            ComponentName r5 = new ComponentName(r4.serviceInfo.packageName, r4.serviceInfo.name);
            if (r4.serviceInfo.permission != null) goto L13;
            r2.add(r5);
            goto L7
        L13:
            Log.w(NotificationManagerCompat.TAG, "Permission present on component " + r5 + ", not adding listener record.");
            goto L7
        L15:
            Iterator r6 = r2.iterator();
        L17:
            if (r6.hasNext() == false) goto L24;
            ComponentName r7 = (ComponentName) ZeusTransformUtils.preCheckCast(r6.next(), ComponentName.class, "com.obric.memorydata.plugin");
            if (this.mRecordMap.containsKey(r7) == true) goto L17;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            Log.d(NotificationManagerCompat.TAG, "Adding listener record for " + r7);
        L23:
            this.mRecordMap.put(r7, new ListenerRecord(r7));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, ListenerRecord>> r8 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r8.hasNext() == false) goto L33;
            Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r2.contains(r9.getKey()) == true) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            Log.d(NotificationManagerCompat.TAG, "Removing listener record for " + r9.getKey());
        L32:
            ensureServiceUnbound((ListenerRecord) ZeusTransformUtils.preCheckCast(r9.getValue(), ListenerRecord.class, "com.obric.memorydata.plugin"));
            r8.remove();
            goto L26
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r5) {
            int r0 = r5.what;
            if (r0 == 0) goto L17;
            if (r0 != 1) goto L6;
            ServiceConnectedEvent r6 = (ServiceConnectedEvent) ZeusTransformUtils.preCheckCast(r5.obj, ServiceConnectedEvent.class, "com.obric.memorydata.plugin");
            handleServiceConnected(r6.componentName, r6.iBinder);
            return true;
        L6:
            if (r0 != 2) goto L8;
            handleServiceDisconnected((ComponentName) ZeusTransformUtils.preCheckCast(r5.obj, ComponentName.class, "com.obric.memorydata.plugin"));
            return true;
        L8:
            if (r0 == 3) goto L11;
            return false;
        L11:
            handleRetryListenerQueue((ComponentName) ZeusTransformUtils.preCheckCast(r5.obj, ComponentName.class, "com.obric.memorydata.plugin"));
            return true;
        L17:
            handleQueueTask((Task) ZeusTransformUtils.preCheckCast(r5.obj, Task.class, "com.obric.memorydata.plugin"));
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Connected to service " + r4);
        L5:
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(r4, r6)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Log.d(NotificationManagerCompat.TAG, "Disconnected from service " + r4);
        L5:
            this.mHandler.obtainMessage(2, r4).sendToTarget();
        }

        public void queueTask(Task r3) {
            Task r4 = (Task) ZeusTransformUtils.wrapperContextForParams(r3, Task.class, "com.obric.memorydata.plugin");
            this.mHandler.obtainMessage(0, r4).sendToTarget();
        }
    }

    private interface Task {
        void send(a r1);
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    NotificationManagerCompat(NotificationManager r3, Context r4) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mNotificationManager = r3;
    }

    private NotificationManagerCompat(Context r3) {
        Context r4 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r4;
        this.mNotificationManager = (NotificationManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("notification"), NotificationManager.class, "com.obric.memorydata.plugin");
    }

    public static NotificationManagerCompat from(Context r2) {
        return new NotificationManagerCompat((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static Set<String> getEnabledListenerPackages(Context r6) {
        String r7 = Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object r0 = sEnabledNotificationListenersLock;
        monitor-enter(r0);
        if (r7 != null) goto L20;
    L14:
        Set<String> r8 = sEnabledNotificationListenerPackages;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r8;
    L17:
        th = move-exception;
        throw th;
    L20:
        if (r7.equals(sEnabledNotificationListeners) == true) goto L14;
        String[] r1 = r7.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, -1);     // Catch: Throwable -> L17
        HashSet r2 = new HashSet(r1.length);     // Catch: Throwable -> L17
        int r3 = r1.length;     // Catch: Throwable -> L17
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L13;
        ComponentName r5 = ComponentName.unflattenFromString(r1[r4]);     // Catch: Throwable -> L17
        if (r5 == null) goto L12;
        r2.add(r5.getPackageName());     // Catch: Throwable -> L17
    L12:
        r4 = r4 + 1;     // Catch: Throwable -> L17
        goto L8
    L13:
        sEnabledNotificationListenerPackages = r2;     // Catch: Throwable -> L17
        sEnabledNotificationListeners = r7;     // Catch: Throwable -> L17
        goto L14
    }

    private void pushSideChannelQueue(Task r5) {
        Task r6 = (Task) ZeusTransformUtils.wrapperContextForParams(r5, Task.class, "com.obric.memorydata.plugin");
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSideChannelManager != null) goto L7;
        sSideChannelManager = new SideChannelManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L7:
        sSideChannelManager.queueTask(r6);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private static boolean useSideChannelForNotification(Notification r1) {
        Bundle r2 = NotificationCompat.getExtras(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getBoolean(EXTRA_USE_SIDE_CHANNEL) == false) goto L7;
        return true;
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    L7:
        if (Build.VERSION.SDK_INT < 19) goto L17;
        AppOpsManager r0 = (AppOpsManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("appops"), AppOpsManager.class, "com.obric.memorydata.plugin");
        ApplicationInfo r1 = this.mContext.getApplicationInfo();
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        int r2 = r1.uid;
        Class r4 = ZeusTransformUtils.forName(AppOpsManager.class.getName(), "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (((Integer) ZeusTransformUtils.preCheckCast(r4.getMethod(CHECK_OP_NO_THROW, new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(r0, new Object[]{Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r4.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class), Integer.class, "com.obric.memorydata.plugin")).intValue()), Integer.valueOf(r2), r11}), Integer.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L13;
        return true;
    L13:
        return false;
    L19:
        return true;
    L17:
        return true;
    }

    public boolean canUseFullScreenIntent() {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 34) goto L13;
        if (this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0) goto L14;
        return false;
    L14:
        return true;
    L13:
        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancel(int r2) {
        cancel(null, r2);
    }

    public void cancel(String r3, int r4) {
        this.mNotificationManager.cancel(r3, r4);
        if (Build.VERSION.SDK_INT > 19) goto L6;
        pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), r4, r3));
        return;
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
        if (Build.VERSION.SDK_INT > 19) goto L6;
        pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
        return;
    }

    public void createNotificationChannel(NotificationChannel r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannel(this.mNotificationManager, r3);
        return;
    }

    public void createNotificationChannel(NotificationChannelCompat r1) {
        createNotificationChannel(r1.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroup(this.mNotificationManager, r3);
        return;
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat r1) {
        createNotificationChannelGroup(r1.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r4);
        return;
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L14;
        ArrayList r0 = new ArrayList(r6.size());
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r0.add(((NotificationChannelGroupCompat) ZeusTransformUtils.preCheckCast(r7.next(), NotificationChannelGroupCompat.class, "com.obric.memorydata.plugin")).getNotificationChannelGroup());
        goto L8
    L10:
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r0);
        return;
    }

    public void createNotificationChannels(List<NotificationChannel> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannels(this.mNotificationManager, r4);
        return;
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L14;
        ArrayList r0 = new ArrayList(r6.size());
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r0.add(((NotificationChannelCompat) ZeusTransformUtils.preCheckCast(r7.next(), NotificationChannelCompat.class, "com.obric.memorydata.plugin")).getNotificationChannel());
        goto L8
    L10:
        Api26Impl.createNotificationChannels(this.mNotificationManager, r0);
        return;
    }

    public void deleteNotificationChannel(String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, r3);
        return;
    }

    public void deleteNotificationChannelGroup(String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, r3);
        return;
    }

    public void deleteUnlistedNotificationChannels(Collection<String> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L16;
        Iterator<NotificationChannel> r0 = Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
    L6:
        if (r0.hasNext() == false) goto L25;
        NotificationChannel r2 = (NotificationChannel) ZeusTransformUtils.preCheckCast(r0.next(), NotificationChannel.class, "com.obric.memorydata.plugin");
        if (r7.contains(Api26Impl.getId(r2)) == true) goto L6;
        if (Build.VERSION.SDK_INT < 30) goto L15;
        if (r7.contains(Api30Impl.getParentChannelId(r2)) == true) goto L6;
    L15:
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(r2));
        goto L6
    L25:
        return;
    }

    public List<StatusBarNotification> getActiveNotifications() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getActiveNotifications(this.mNotificationManager);
    L7:
        return new ArrayList();
    }

    public int getCurrentInterruptionFilter() {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return 0;
    L7:
        return Api23Impl.getCurrentInterruptionFilter(this.mNotificationManager);
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return -1000;
    L5:
        return Api24Impl.getImportance(this.mNotificationManager);
    }

    public NotificationChannel getNotificationChannel(String r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getNotificationChannel(this.mNotificationManager, r3);
    }

    public NotificationChannel getNotificationChannel(String r3, String r4) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getNotificationChannel(this.mNotificationManager, r3, r4);
    L7:
        return getNotificationChannel(r3);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r2 = getNotificationChannel(r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r2);
    L8:
        return null;
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r3, String r4) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r2 = getNotificationChannel(r3, r4);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r2);
    L8:
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String r5) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, r5);
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        Iterator<NotificationChannelGroup> r4 = getNotificationChannelGroups().iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        NotificationChannelGroup r0 = (NotificationChannelGroup) ZeusTransformUtils.preCheckCast(r4.next(), NotificationChannelGroup.class, "com.obric.memorydata.plugin");
        if (Api26Impl.getId(r0).equals(r5) == false) goto L10;
        return r0;
    L14:
        return null;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String r3) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        NotificationChannelGroup r2 = getNotificationChannelGroup(r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelGroupCompat(r2);
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        NotificationChannelGroup r4 = getNotificationChannelGroup(r3);
        if (r4 != null) goto L13;
        return null;
    L13:
        return new NotificationChannelGroupCompat(r4, getNotificationChannels());
    L16:
        return null;
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L20;
        List<NotificationChannelGroup> r0 = getNotificationChannelGroups();
        if (r0.isEmpty() == true) goto L20;
        if (Build.VERSION.SDK_INT < 28) goto L9;
        List<NotificationChannel> r6 = Collections.emptyList();
    L10:
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<NotificationChannelGroup> r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L18;
        NotificationChannelGroup r3 = (NotificationChannelGroup) ZeusTransformUtils.preCheckCast(r2.next(), NotificationChannelGroup.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L16;
        NotificationChannelGroupCompat r4 = new NotificationChannelGroupCompat(r3);
    L17:
        r1.add(r4);
        goto L12
    L16:
        r4 = new NotificationChannelGroupCompat(r3, r6);
        goto L17
    L18:
        return r1;
    L9:
        r6 = getNotificationChannels();
    L20:
        return Collections.emptyList();
    }

    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannels(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        List<NotificationChannel> r4 = getNotificationChannels();
        if (r4.isEmpty() == true) goto L12;
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<NotificationChannel> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r0.add(new NotificationChannelCompat((NotificationChannel) ZeusTransformUtils.preCheckCast(r5.next(), NotificationChannel.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        return r0;
    L12:
        return Collections.emptyList();
    }

    public void notify(int r2, Notification r3) {
        notify(null, r2, r3);
    }

    public void notify(String r3, int r4, Notification r5) {
        if (useSideChannelForNotification(r5) == false) goto L5;
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), r4, r3, r5));
        this.mNotificationManager.cancel(r3, r4);
        return;
    L5:
        this.mNotificationManager.notify(r3, r4, r5);
    }

    public void notify(List<NotificationWithIdAndTag> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        NotificationWithIdAndTag r3 = (NotificationWithIdAndTag) ZeusTransformUtils.preCheckCast(r8.get(r2), NotificationWithIdAndTag.class, "com.obric.memorydata.plugin");
        notify(r3.mTag, r3.mId, r3.mNotification);
        r2 = r2 + 1;
        goto L3
    }
}
