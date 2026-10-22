package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.dumper.Scraps;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sLock = null;
    private static final Object sSync = null;
    private static TypedValue sTempValue;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void startActivities(Context r2, Intent[] r3, Bundle r4) {
            ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).startActivities(r3, r4);
        }

        static void startActivity(Context r2, Intent r3, Bundle r4) {
            ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, "com.obric.memorydata.plugin");
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context createConfigurationContext(Context r2, Configuration r3) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).createConfigurationContext(r3), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static File[] getExternalCacheDirs(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getExternalCacheDirs();
        }

        static File[] getExternalFilesDirs(Context r2, String r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getExternalFilesDirs(r3);
        }

        static File[] getObbDirs(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getObbDirs();
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static File getCodeCacheDir(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getCodeCacheDir();
        }

        static Drawable getDrawable(Context r2, int r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getDrawable(r3);
        }

        static File getNoBackupFilesDir(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getNoBackupFilesDir();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getColor(Context r2, int r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getColor(r3);
        }

        static <T> T getSystemService(Context r2, Class<T> r3) {
            return (T) ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(r3);
        }

        static String getSystemServiceName(Context r2, Class<?> r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemServiceName(r3);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Context createDeviceProtectedStorageContext(Context r2) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).createDeviceProtectedStorageContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }

        static File getDataDir(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getDataDir();
        }

        static boolean isDeviceProtectedStorage(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).isDeviceProtectedStorage();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            if ((r12 & 4) == 0) goto L8;
            if (r10 != null) goto L8;
            return ZeusTransformUtils.registerReceiver(r0, r8, r9, ContextCompat.obtainAndCheckReceiverPermission(r0), r11, "com.obric.memorydata.plugin");
        L8:
            return ZeusTransformUtils.registerReceiver(r0, r8, r9, r10, r11, r12 & 1, "com.obric.memorydata.plugin");
        }

        static ComponentName startForegroundService(Context r2, Intent r3) {
            return ZeusTransformUtils.startService((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, "com.obric.memorydata.plugin");
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Executor getMainExecutor(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getMainExecutor();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static String getAttributionTag(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getAttributionTag();
        }

        static Display getDisplayOrDefault(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            return r4.getDisplay();
        L5:
            Log.w(ContextCompat.TAG, "The context:" + r4 + " is not associated with any display. Return a fallback display instead.");
            return ((DisplayManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(DisplayManager.class), DisplayManager.class, "com.obric.memorydata.plugin")).getDisplay(0);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
            return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, "com.obric.memorydata.plugin");
        }
    }

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

        static {
            HashMap<Class<?>, String> r0 = new HashMap();
            SERVICES = r0;
            if (Build.VERSION.SDK_INT < 22) goto L6;
            r0.put(SubscriptionManager.class, "telephony_subscription_service");
            r0.put(UsageStatsManager.class, "usagestats");
        L6:
            if (Build.VERSION.SDK_INT < 21) goto L9;
            r0.put(AppWidgetManager.class, "appwidget");
            r0.put(BatteryManager.class, "batterymanager");
            r0.put(CameraManager.class, "camera");
            r0.put(JobScheduler.class, "jobscheduler");
            r0.put(LauncherApps.class, "launcherapps");
            r0.put(MediaProjectionManager.class, "media_projection");
            r0.put(MediaSessionManager.class, "media_session");
            r0.put(RestrictionsManager.class, "restrictions");
            r0.put(TelecomManager.class, "telecom");
            r0.put(TvInputManager.class, "tv_input");
        L9:
            if (Build.VERSION.SDK_INT < 19) goto L12;
            r0.put(AppOpsManager.class, "appops");
            r0.put(CaptioningManager.class, "captioning");
            r0.put(ConsumerIrManager.class, "consumer_ir");
            r0.put(PrintManager.class, "print");
        L12:
            if (Build.VERSION.SDK_INT < 18) goto L15;
            r0.put(BluetoothManager.class, "bluetooth");
        L15:
            if (Build.VERSION.SDK_INT < 17) goto L18;
            r0.put(DisplayManager.class, "display");
            r0.put(UserManager.class, "user");
        L18:
            if (Build.VERSION.SDK_INT < 16) goto L20;
            r0.put(InputManager.class, "input");
            r0.put(MediaRouter.class, "media_router");
            r0.put(NsdManager.class, "servicediscovery");
        L20:
            r0.put(AccessibilityManager.class, "accessibility");
            r0.put(AccountManager.class, "account");
            r0.put(ActivityManager.class, "activity");
            r0.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            r0.put(AudioManager.class, "audio");
            r0.put(ClipboardManager.class, "clipboard");
            r0.put(ConnectivityManager.class, "connectivity");
            r0.put(DevicePolicyManager.class, "device_policy");
            r0.put(DownloadManager.class, "download");
            r0.put(DropBoxManager.class, "dropbox");
            r0.put(InputMethodManager.class, "input_method");
            r0.put(KeyguardManager.class, "keyguard");
            r0.put(LayoutInflater.class, "layout_inflater");
            r0.put(LocationManager.class, "location");
            r0.put(NfcManager.class, "nfc");
            r0.put(NotificationManager.class, "notification");
            r0.put(PowerManager.class, "power");
            r0.put(SearchManager.class, "search");
            r0.put(SensorManager.class, "sensor");
            r0.put(StorageManager.class, Scraps.STORAGE);
            r0.put(TelephonyManager.class, MemoryKeyInfoEntity.KEY_PHONE);
            r0.put(TextServicesManager.class, "textservices");
            r0.put(UiModeManager.class, "uimode");
            r0.put(UsbManager.class, "usb");
            r0.put(Vibrator.class, "vibrator");
            r0.put(WallpaperManager.class, "wallpaper");
            r0.put(WifiP2pManager.class, "wifip2p");
            r0.put(WifiManager.class, LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
            r0.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    static {
        sLock = new Object();
        sSync = new Object();
    }

    public ContextCompat() {
    }

    public static int checkSelfPermission(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ObjectsCompat.requireNonNull(r3, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r3) == false) goto L12;
        if (NotificationManagerCompat.from(r4).areNotificationsEnabled() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return r4.checkPermission(r3, Process.myPid(), Process.myUid());
    }

    public static Context createDeviceProtectedStorageContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Api24Impl.createDeviceProtectedStorageContext(r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    private static File createFilesDir(File r4) {
        Object r0 = sSync;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r4.exists() == false) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L7:
        if (r4.mkdirs() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L10:
        Log.w(TAG, "Unable to create files subdir " + r4.getPath());     // Catch: Throwable -> L13
        goto L11
    }

    public static String getAttributionTag(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        return Api30Impl.getAttributionTag(r3);
    }

    public static File getCodeCacheDir(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCodeCacheDir(r3);
    L7:
        return createFilesDir(new File(r3.getApplicationInfo().dataDir, "code_cache"));
    }

    public static int getColor(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r5, r4);
    L7:
        return ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getColor(r4);
    }

    public static ColorStateList getColorStateList(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return ResourcesCompat.getColorStateList(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), r3, r4.getTheme());
    }

    public static Context getContextForLanguage(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        LocaleListCompat r0 = LocaleManagerCompat.getApplicationLocales(r5);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r5;
    L5:
        if (Build.VERSION.SDK_INT >= 17) goto L7;
        return r5;
    L7:
        if (r0.isEmpty() == true) goto L12;
        Configuration r2 = new Configuration(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getConfiguration());
        ConfigurationCompat.setLocales(r2, r0);
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Api17Impl.createConfigurationContext(r5, r2), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L12:
        return r5;
    }

    public static File getDataDir(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        String r4 = r3.getApplicationInfo().dataDir;
        if (r4 != null) goto L11;
        return null;
    L11:
        return new File(r4);
    L5:
        return Api24Impl.getDataDir(r3);
    }

    public static Display getDisplayOrDefault(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getDisplayOrDefault(r4);
    L7:
        return ((WindowManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
    }

    public static Drawable getDrawable(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getDrawable(r6, r5);
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        Object r0 = sLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (sTempValue != null) goto L15;
        sTempValue = new TypedValue();     // Catch: Throwable -> L18
    L15:
        ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getValue(r5, sTempValue, true);     // Catch: Throwable -> L18
        r5 = sTempValue.resourceId;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    L9:
        return ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDrawable(r5);
    }

    public static File[] getExternalCacheDirs(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExternalCacheDirs(r3);
    L7:
        return new File[]{r3.getExternalCacheDir()};
    }

    public static File[] getExternalFilesDirs(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExternalFilesDirs(r4, r3);
    L7:
        return new File[]{r4.getExternalFilesDir(r3)};
    }

    public static Executor getMainExecutor(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getMainExecutor(r3);
    L7:
        return ExecutorCompat.create(new Handler(r3.getMainLooper()));
    }

    public static File getNoBackupFilesDir(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getNoBackupFilesDir(r3);
    L7:
        return createFilesDir(new File(r3.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File[] getObbDirs(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getObbDirs(r3);
    L7:
        return new File[]{r3.getObbDir()};
    }

    public static String getString(Context r2, int r3) {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContextForLanguage((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3);
    }

    public static <T> T getSystemService(Context r2, Class<T> r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r5 = getSystemServiceName(r4, r3);
        if (r5 != null) goto L11;
        return null;
    L11:
        return (T) r4.getSystemService(r5);
    L5:
        return (T) Api23Impl.getSystemService(r4, r3);
    }

    public static String getSystemServiceName(Context r3, Class<?> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSystemServiceName(r5, r4);
    L7:
        return (String) ZeusTransformUtils.preCheckCast(LegacyServiceMapHolder.SERVICES.get(r4), String.class, "com.obric.memorydata.plugin");
    }

    public static boolean isDeviceProtectedStorage(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return Api24Impl.isDeviceProtectedStorage(r3);
    }

    static String obtainAndCheckReceiverPermission(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = r4.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(r4, r0) != 0) goto L6;
        return r0;
    L6:
        throw new RuntimeException("Permission " + r0 + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static Intent registerReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, int r9) {
        return registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, null, null, r9);
    }

    public static Intent registerReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        int r12 = r11 & 1;
        if (r12 != 0) goto L5;
    L9:
        if (r12 == 0) goto L11;
        r11 = r11 | 2;
    L11:
        int r5 = r11;
        int r13 = r5 & 2;
        if (r13 == 0) goto L14;
    L18:
        if (r13 == 0) goto L25;
        if ((r5 & 4) == 0) goto L25;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    L25:
        if (Build.VERSION.SDK_INT < 33) goto L29;
        return Api33Impl.registerReceiver(r0, r7, r8, r9, r10, r5);
    L29:
        if (Build.VERSION.SDK_INT < 26) goto L33;
        return Api26Impl.registerReceiver(r0, r7, r8, r9, r10, r5);
    L33:
        if ((r5 & 4) == 0) goto L38;
        if (r9 != null) goto L38;
        return ZeusTransformUtils.registerReceiver(r0, r7, r8, obtainAndCheckReceiverPermission(r0), r10, "com.obric.memorydata.plugin");
    L38:
        return ZeusTransformUtils.registerReceiver(r0, r7, r8, r9, r10, "com.obric.memorydata.plugin");
    L14:
        if ((r5 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r11 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static boolean startActivities(Context r2, Intent[] r3) {
        return startActivities((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, null);
    }

    public static boolean startActivities(Context r2, Intent[] r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivities(r5, r3, r4);
        return true;
    L5:
        r5.startActivities(r3);
        return true;
    }

    public static void startActivity(Context r3, Intent r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivity(r6, r4, r5);
        return;
    L5:
        ZeusTransformUtils.startActivity(r6, r4, "com.obric.memorydata.plugin");
    }

    public static void startForegroundService(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.startForegroundService(r5, r4);
        return;
    L5:
        ZeusTransformUtils.startService(r5, r4, "com.obric.memorydata.plugin");
    }
}
