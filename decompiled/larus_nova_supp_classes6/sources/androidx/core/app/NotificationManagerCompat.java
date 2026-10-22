package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        AppOpsManager r0 = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo r1 = this.mContext.getApplicationInfo();
        String r2 = this.mContext.getApplicationContext().getPackageName();
        int r3 = r1.uid;
        Class r4 = INVOKESTATIC_androidx_core_app_NotificationManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppOpsManager.class.getName());     // Catch: Throwable -> L12
        Class<?> r8 = Integer.TYPE;     // Catch: Throwable -> L12
        if (((Integer) r4.getMethod(CHECK_OP_NO_THROW, new Class[]{r8, r8, String.class}).invoke(r0, new Object[]{Integer.valueOf(((Integer) r4.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(r3), r2})).intValue() == 0) goto L15;
        return false;
    L15:
        return true;
    L16:
        return true;
    L5:
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public boolean canUseFullScreenIntent() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) goto L6;
        return true;
    L6:
        if (r0 >= 34) goto L13;
        if (androidx_core_app_NotificationManagerCompat_android_content_Context_checkSelfPermission(this.mContext, "android.permission.USE_FULL_SCREEN_INTENT") == 0) goto L14;
        return false;
    L14:
        return true;
    L13:
        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
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

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L19;
        List<NotificationChannelGroup> r1 = getNotificationChannelGroups();
        if (r1.isEmpty() == true) goto L19;
        if (r0 < 28) goto L9;
        List<NotificationChannel> r2 = Collections.emptyList();
    L10:
        ArrayList r3 = new ArrayList(r1.size());
        Iterator<NotificationChannelGroup> r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        NotificationChannelGroup r5 = r4.next();
        if (Build.VERSION.SDK_INT >= 28) goto L15;
        r3.add(new NotificationChannelGroupCompat(r5, r2));
        goto L12
    L15:
        r3.add(new NotificationChannelGroupCompat(r5));
        goto L12
    L17:
        return r3;
    L9:
        r2 = getNotificationChannels();
    L19:
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
        List<NotificationChannel> r0 = getNotificationChannels();
        if (r0.isEmpty() == true) goto L12;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<NotificationChannel> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1.add(new NotificationChannelCompat(r2.next()));
        goto L8
    L10:
        return r1;
    L12:
        return Collections.emptyList();
    }

    private NotificationManagerCompat(Context r2) {
        this.mContext = r2;
        this.mNotificationManager = (NotificationManager) r2.getSystemService("notification");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_app_NotificationManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static NotificationManagerCompat from(Context r1) {
        return new NotificationManagerCompat(r1);
    }

    public static Set<String> getEnabledListenerPackages(Context r6) {
        String r7 = androidx_core_app_NotificationManagerCompat_android_provider_Settings$Secure_getString(r6.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
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
        String[] r1 = r7.split(":", -1);     // Catch: Throwable -> L17
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

    private void pushSideChannelQueue(Task r4) {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSideChannelManager != null) goto L7;
        sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        sSideChannelManager.queueTask(r4);     // Catch: Throwable -> L10
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

    public void cancel(int r2) {
        cancel(null, r2);
    }

    public void createNotificationChannel(NotificationChannel r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannel(this.mNotificationManager, r3);
        return;
    }

    public void createNotificationChannelGroup(NotificationChannelGroup r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroup(this.mNotificationManager, r3);
        return;
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r3);
        return;
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L14;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelGroupCompat> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(r4.next().getNotificationChannelGroup());
        goto L8
    L10:
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r0);
        return;
    }

    public void createNotificationChannels(List<NotificationChannel> r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannels(this.mNotificationManager, r3);
        return;
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L14;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<NotificationChannelCompat> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(r4.next().getNotificationChannel());
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

    public void deleteUnlistedNotificationChannels(Collection<String> r5) {
        if (Build.VERSION.SDK_INT < 26) goto L16;
        Iterator r0 = Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
    L6:
        if (r0.hasNext() == false) goto L25;
        NotificationChannel r1 = (NotificationChannel) r0.next();
        if (r5.contains(Api26Impl.getId(r1)) == true) goto L6;
        if (Build.VERSION.SDK_INT < 30) goto L15;
        if (r5.contains(Api30Impl.getParentChannelId(r1)) == true) goto L6;
    L15:
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(r1));
        goto L6
    L25:
        return;
    }

    public NotificationChannel getNotificationChannel(String r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getNotificationChannel(this.mNotificationManager, r3);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r3) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r4 = getNotificationChannel(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r4);
    L8:
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, r5);
    L7:
        if (r0 < 26) goto L14;
        Iterator<NotificationChannelGroup> r1 = getNotificationChannelGroups().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        NotificationChannelGroup r2 = r1.next();
        if (Api26Impl.getId(r2).equals(r5) == false) goto L10;
        return r2;
    L14:
        return null;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L9;
        NotificationChannelGroup r4 = getNotificationChannelGroup(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelGroupCompat(r4);
    L9:
        if (r0 < 26) goto L16;
        NotificationChannelGroup r5 = getNotificationChannelGroup(r3);
        if (r5 != null) goto L13;
        return null;
    L13:
        return new NotificationChannelGroupCompat(r5, getNotificationChannels());
    L16:
        return null;
    }

    public void notify(List<NotificationWithIdAndTag> r6) {
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        NotificationWithIdAndTag r2 = (NotificationWithIdAndTag) ListProtector.get(r6, r1);
        notify(r2.mTag, r2.mId, r2.mNotification);
        r1 = r1 + 1;
        goto L3
    }

    public void createNotificationChannel(NotificationChannelCompat r1) {
        createNotificationChannel(r1.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat r1) {
        createNotificationChannelGroup(r1.getNotificationChannelGroup());
    }

    public NotificationManagerCompat(NotificationManager r1, Context r2) {
        this.mContext = r2;
        this.mNotificationManager = r1;
    }

    private static int androidx_core_app_NotificationManagerCompat_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_androidx_core_app_NotificationManagerCompat_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static String androidx_core_app_NotificationManagerCompat_android_provider_Settings$Secure_getString(ContentResolver r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r12, r13};
        b r10 = new b();
        d r11 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r14 = Settings.Secure.getString(r12, r13);
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r14, r10, true);
        return r14;
    }

    public void cancel(String r2, int r3) {
        this.mNotificationManager.cancel(r2, r3);
    }

    public NotificationChannel getNotificationChannel(String r3, String r4) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getNotificationChannel(this.mNotificationManager, r3, r4);
    L7:
        return getNotificationChannel(r3);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r3, String r4) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r5 = getNotificationChannel(r3, r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r5);
    L8:
        return null;
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
}
