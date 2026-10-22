package androidx.core.content;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
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
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
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
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BuildCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.crash.dumper.Scraps;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sLock = null;
    private static final Object sSync = null;
    private static TypedValue sTempValue;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void startActivities(Context r10, Intent[] r11, Bundle r12) {
            r10.startActivities(r11, r12);
        }

        @DoNotInline
        static void startActivity(Context r10, Intent r11, Bundle r12) {
            r10.startActivity(r11, r12);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static File[] getExternalCacheDirs(Context r10) {
            return r10.getExternalCacheDirs();
        }

        @DoNotInline
        static File[] getExternalFilesDirs(Context r10, String r11) {
            return r10.getExternalFilesDirs(r11);
        }

        @DoNotInline
        static File[] getObbDirs(Context r10) {
            return r10.getObbDirs();
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static File getCodeCacheDir(Context r10) {
            return r10.getCodeCacheDir();
        }

        @DoNotInline
        static Drawable getDrawable(Context r10, int r11) {
            return r10.getDrawable(r11);
        }

        @DoNotInline
        static File getNoBackupFilesDir(Context r10) {
            return r10.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getColor(Context r10, int r11) {
            return r10.getColor(r11);
        }

        @DoNotInline
        static <T> T getSystemService(Context r10, Class<T> r11) {
            return (T) r10.getSystemService(r11);
        }

        @DoNotInline
        static String getSystemServiceName(Context r10, Class<?> r11) {
            return r10.getSystemServiceName(r11);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Context createDeviceProtectedStorageContext(Context r10) {
            return r10.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        static File getDataDir(Context r10) {
            return r10.getDataDir();
        }

        @DoNotInline
        static boolean isDeviceProtectedStorage(Context r10) {
            return r10.isDeviceProtectedStorage();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Intent registerReceiver(Context r10, @Nullable BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
            if ((r15 & 4) == 0) goto L8;
            if (r13 != null) goto L8;
            return r10.registerReceiver(r11, r12, ContextCompat.obtainAndCheckReceiverPermission(r10), r14);
        L8:
            return r10.registerReceiver(r11, r12, r13, r14, r15 & 1);
        }

        @DoNotInline
        static ComponentName startForegroundService(Context r10, Intent r11) {
            return r10.startForegroundService(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Executor getMainExecutor(Context r10) {
            return r10.getMainExecutor();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static String getAttributionTag(Context r10) {
            return r10.getAttributionTag();
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static Intent registerReceiver(Context r10, @Nullable BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
            return r10.registerReceiver(r11, r12, r13, r14, r15);
        }
    }

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

        static {
            HashMap<Class<?>, String> r10 = new HashMap();
            SERVICES = r10;
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 22) goto L6;
            r10.put(SubscriptionManager.class, "telephony_subscription_service");
            r10.put(UsageStatsManager.class, "usagestats");
        L6:
            if (r11 < 21) goto L9;
            r10.put(AppWidgetManager.class, "appwidget");
            r10.put(BatteryManager.class, "batterymanager");
            r10.put(CameraManager.class, "camera");
            r10.put(JobScheduler.class, "jobscheduler");
            r10.put(LauncherApps.class, "launcherapps");
            r10.put(MediaProjectionManager.class, "media_projection");
            r10.put(MediaSessionManager.class, "media_session");
            r10.put(RestrictionsManager.class, "restrictions");
            r10.put(TelecomManager.class, "telecom");
            r10.put(TvInputManager.class, "tv_input");
        L9:
            if (r11 < 19) goto L12;
            r10.put(AppOpsManager.class, "appops");
            r10.put(CaptioningManager.class, "captioning");
            r10.put(ConsumerIrManager.class, "consumer_ir");
            r10.put(PrintManager.class, "print");
        L12:
            if (r11 < 18) goto L15;
            r10.put(BluetoothManager.class, "bluetooth");
        L15:
            if (r11 < 17) goto L18;
            r10.put(DisplayManager.class, "display");
            r10.put(UserManager.class, "user");
        L18:
            if (r11 < 16) goto L20;
            r10.put(InputManager.class, "input");
            r10.put(MediaRouter.class, "media_router");
            r10.put(NsdManager.class, "servicediscovery");
        L20:
            r10.put(AccessibilityManager.class, "accessibility");
            r10.put(AccountManager.class, "account");
            r10.put(ActivityManager.class, "activity");
            r10.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            r10.put(AudioManager.class, "audio");
            r10.put(ClipboardManager.class, "clipboard");
            r10.put(ConnectivityManager.class, "connectivity");
            r10.put(DevicePolicyManager.class, "device_policy");
            r10.put(DownloadManager.class, "download");
            r10.put(DropBoxManager.class, "dropbox");
            r10.put(InputMethodManager.class, "input_method");
            r10.put(KeyguardManager.class, "keyguard");
            r10.put(LayoutInflater.class, "layout_inflater");
            r10.put(LocationManager.class, "location");
            r10.put(NfcManager.class, "nfc");
            r10.put(NotificationManager.class, "notification");
            r10.put(PowerManager.class, "power");
            r10.put(SearchManager.class, "search");
            r10.put(SensorManager.class, "sensor");
            r10.put(StorageManager.class, Scraps.STORAGE);
            r10.put(TelephonyManager.class, "phone");
            r10.put(TextServicesManager.class, "textservices");
            r10.put(UiModeManager.class, "uimode");
            r10.put(UsbManager.class, "usb");
            r10.put(Vibrator.class, "vibrator");
            r10.put(WallpaperManager.class, "wallpaper");
            r10.put(WifiP2pManager.class, "wifip2p");
            r10.put(WifiManager.class, "wifi");
            r10.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RegisterReceiverFlags {
    }

    static {
        sLock = new Object();
        sSync = new Object();
    }

    protected ContextCompat() {
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static int checkSelfPermission(@NonNull Context r10, @NonNull String r11) {
        ObjectsCompat.requireNonNull(r11, "permission must be non-null");
        if (BuildCompat.isAtLeastT() == true) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r11) == false) goto L12;
        if (NotificationManagerCompat.from(r10).areNotificationsEnabled() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return r10.checkPermission(r11, Process.myPid(), Process.myUid());
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.createDeviceProtectedStorageContext(r10);
    }

    private static File createFilesDir(File r10) {
        Object r11 = sSync;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r10.exists() == false) goto L7;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r10;
    L7:
        if (r10.mkdirs() == false) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r10;
    L10:
        Log.w(TAG, "Unable to create files subdir " + r10.getPath());     // Catch: Throwable -> L13
        goto L11
    }

    @Nullable
    public static String getAttributionTag(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        return Api30Impl.getAttributionTag(r10);
    }

    @NonNull
    public static File getCodeCacheDir(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCodeCacheDir(r10);
    L7:
        return createFilesDir(new File(r10.getApplicationInfo().dataDir, "code_cache"));
    }

    @ColorInt
    public static int getColor(@NonNull Context r10, @ColorRes int r11) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r10, r11);
    L7:
        return r10.getResources().getColor(r11);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r10, @ColorRes int r11) {
        return ResourcesCompat.getColorStateList(r10.getResources(), r11, r10.getTheme());
    }

    @Nullable
    public static File getDataDir(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        String r11 = r10.getApplicationInfo().dataDir;
        if (r11 != null) goto L11;
        return null;
    L11:
        return new File(r11);
    L5:
        return Api24Impl.getDataDir(r10);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r10, @DrawableRes int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L7;
        return Api21Impl.getDrawable(r10, r11);
    L7:
        if (r12 >= 16) goto L9;
        Object r13 = sLock;
        monitor-enter(r13);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (sTempValue != null) goto L15;
        sTempValue = new TypedValue();     // Catch: Throwable -> L18
    L15:
        r10.getResources().getValue(r11, sTempValue, true);     // Catch: Throwable -> L18
        r11 = sTempValue.resourceId;     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
    L9:
        return r10.getResources().getDrawable(r11);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExternalCacheDirs(r10);
    L7:
        return new File[]{r10.getExternalCacheDir()};
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context r10, @Nullable String r11) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExternalFilesDirs(r10, r11);
    L7:
        return new File[]{r10.getExternalFilesDir(r11)};
    }

    @NonNull
    public static Executor getMainExecutor(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getMainExecutor(r10);
    L7:
        return ExecutorCompat.create(new Handler(r10.getMainLooper()));
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getNoBackupFilesDir(r10);
    L7:
        return createFilesDir(new File(r10.getApplicationInfo().dataDir, "no_backup"));
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getObbDirs(r10);
    L7:
        return new File[]{r10.getObbDir()};
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r12 = getSystemServiceName(r10, r11);
        if (r12 != null) goto L11;
        return null;
    L11:
        return (T) r10.getSystemService(r12);
    L5:
        return (T) Api23Impl.getSystemService(r10, r11);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context r10, @NonNull Class<?> r11) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSystemServiceName(r10, r11);
    L7:
        return LegacyServiceMapHolder.SERVICES.get(r11);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return Api24Impl.isDeviceProtectedStorage(r10);
    }

    static String obtainAndCheckReceiverPermission(Context r10) {
        String r11 = r10.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(r10, r11) != 0) goto L6;
        return r11;
    L6:
        throw new RuntimeException("Permission " + r11 + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context r10, @Nullable BroadcastReceiver r11, @NonNull IntentFilter r12, int r13) {
        return registerReceiver(r10, r11, r12, null, null, r13);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static Intent registerReceiver(@NonNull Context r10, @Nullable BroadcastReceiver r11, @NonNull IntentFilter r12, @Nullable String r13, @Nullable Handler r14, int r15) {
        int r16 = r15 & 1;
        if (r16 != 0) goto L5;
    L9:
        if (r16 == 0) goto L11;
        r15 = r15 | 2;
    L11:
        int r17 = r15;
        int r18 = r17 & 2;
        if (r18 == 0) goto L14;
    L18:
        if (r18 == 0) goto L25;
        if ((r17 & 4) == 0) goto L25;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    L25:
        if (BuildCompat.isAtLeastT() == false) goto L29;
        return Api33Impl.registerReceiver(r10, r11, r12, r13, r14, r17);
    L29:
        if (Build.VERSION.SDK_INT < 26) goto L33;
        return Api26Impl.registerReceiver(r10, r11, r12, r13, r14, r17);
    L33:
        if ((r17 & 4) == 0) goto L38;
        if (r13 != null) goto L38;
        return r10.registerReceiver(r11, r12, obtainAndCheckReceiverPermission(r10), r14);
    L38:
        return r10.registerReceiver(r11, r12, r13, r14);
    L14:
        if ((r17 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r15 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static boolean startActivities(@NonNull Context r10, @NonNull Intent[] r11) {
        return startActivities(r10, r11, null);
    }

    public static boolean startActivities(@NonNull Context r10, @NonNull Intent[] r11, @Nullable Bundle r12) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivities(r10, r11, r12);
        return true;
    L5:
        r10.startActivities(r11);
        return true;
    }

    public static void startActivity(@NonNull Context r10, @NonNull Intent r11, @Nullable Bundle r12) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivity(r10, r11, r12);
        return;
    L5:
        r10.startActivity(r11);
    }

    public static void startForegroundService(@NonNull Context r10, @NonNull Intent r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.startForegroundService(r10, r11);
        return;
    L5:
        r10.startService(r11);
    }
}
