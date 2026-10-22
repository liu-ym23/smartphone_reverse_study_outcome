package androidx.core.content;

import ai.j0;
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
import android.view.Display;
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
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.bpea.entry.common.DataType;
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
    private static final Object sSync = null;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static File getCodeCacheDir(Context r5) {
            return r5.getCodeCacheDir();
        }

        @DoNotInline
        public static Drawable getDrawable(Context r5, int r10) {
            return r5.getDrawable(r10);
        }

        @DoNotInline
        public static File getNoBackupFilesDir(Context r5) {
            return r5.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int getColor(Context r5, int r10) {
            return r5.getColor(r10);
        }

        @DoNotInline
        public static <T> T getSystemService(Context r5, Class<T> r10) {
            return (T) r5.getSystemService(r10);
        }

        @DoNotInline
        public static String getSystemServiceName(Context r5, Class<?> r10) {
            return r5.getSystemServiceName(r10);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Context createDeviceProtectedStorageContext(Context r5) {
            return r5.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        public static File getDataDir(Context r5) {
            return r5.getDataDir();
        }

        @DoNotInline
        public static boolean isDeviceProtectedStorage(Context r5) {
            return r5.isDeviceProtectedStorage();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Intent registerReceiver(Context r10, @Nullable BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
            if ((r15 & 4) == 0) goto L8;
            if (r13 != null) goto L8;
            return r10.registerReceiver(r11, r12, ContextCompat.obtainAndCheckReceiverPermission(r10), r14);
        L8:
            return r10.registerReceiver(r11, r12, r13, r14, r15 & 1);
        }

        @DoNotInline
        public static ComponentName startForegroundService(Context r5, Intent r10) {
            return r5.startForegroundService(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Executor getMainExecutor(Context r5) {
            return r5.getMainExecutor();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        @DoNotInline
        public static Context createAttributionContext(@NonNull Context r5, @Nullable String r10) {
            return r5.createAttributionContext(r10);
        }

        @DoNotInline
        public static String getAttributionTag(Context r5) {
            return r5.getAttributionTag();
        }

        @DoNotInline
        public static Display getDisplayOrDefault(Context r5) {
            return r5.getDisplay();
        L4:
            Log.w(ContextCompat.TAG, "The context:" + r5 + " is not associated with any display. Return a fallback display instead.");
            return ((DisplayManager) r5.getSystemService(DisplayManager.class)).getDisplay(0);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static Intent registerReceiver(Context r5, @Nullable BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14) {
            return r5.registerReceiver(r10, r11, r12, r13, r14);
        }
    }

    public static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

        static {
            HashMap<Class<?>, String> r5 = new HashMap();
            SERVICES = r5;
            r5.put(SubscriptionManager.class, "telephony_subscription_service");
            r5.put(UsageStatsManager.class, "usagestats");
            r5.put(AppWidgetManager.class, "appwidget");
            r5.put(BatteryManager.class, "batterymanager");
            r5.put(CameraManager.class, "camera");
            r5.put(JobScheduler.class, "jobscheduler");
            r5.put(LauncherApps.class, "launcherapps");
            r5.put(MediaProjectionManager.class, "media_projection");
            r5.put(MediaSessionManager.class, "media_session");
            r5.put(RestrictionsManager.class, "restrictions");
            r5.put(TelecomManager.class, "telecom");
            r5.put(TvInputManager.class, "tv_input");
            r5.put(AppOpsManager.class, "appops");
            r5.put(CaptioningManager.class, "captioning");
            r5.put(ConsumerIrManager.class, "consumer_ir");
            r5.put(PrintManager.class, "print");
            r5.put(BluetoothManager.class, "bluetooth");
            r5.put(DisplayManager.class, "display");
            r5.put(UserManager.class, "user");
            r5.put(InputManager.class, "input");
            r5.put(MediaRouter.class, "media_router");
            r5.put(NsdManager.class, "servicediscovery");
            r5.put(AccessibilityManager.class, "accessibility");
            r5.put(AccountManager.class, "account");
            r5.put(ActivityManager.class, "activity");
            r5.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            r5.put(AudioManager.class, "audio");
            r5.put(ClipboardManager.class, DataType.CLIPBOARD);
            r5.put(ConnectivityManager.class, "connectivity");
            r5.put(DevicePolicyManager.class, "device_policy");
            r5.put(DownloadManager.class, "download");
            r5.put(DropBoxManager.class, "dropbox");
            r5.put(InputMethodManager.class, "input_method");
            r5.put(KeyguardManager.class, "keyguard");
            r5.put(LayoutInflater.class, "layout_inflater");
            r5.put(LocationManager.class, "location");
            r5.put(NfcManager.class, "nfc");
            r5.put(NotificationManager.class, Constant.NOTIFICATION);
            r5.put(PowerManager.class, "power");
            r5.put(SearchManager.class, "search");
            r5.put(SensorManager.class, "sensor");
            r5.put(StorageManager.class, "storage");
            r5.put(TelephonyManager.class, "phone");
            r5.put(TextServicesManager.class, "textservices");
            r5.put(UiModeManager.class, "uimode");
            r5.put(UsbManager.class, "usb");
            r5.put(Vibrator.class, "vibrator");
            r5.put(WallpaperManager.class, "wallpaper");
            r5.put(WifiP2pManager.class, "wifip2p");
            r5.put(WifiManager.class, "wifi");
            r5.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RegisterReceiverFlags {
    }

    static {
        sSync = new Object();
    }

    public ContextCompat() {
    }

    public static int checkSelfPermission(@NonNull Context r5, @NonNull String r10) {
        ObjectsCompat.requireNonNull(r10, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r10) == false) goto L12;
        if (NotificationManagerCompat.from(r5).areNotificationsEnabled() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return r5.checkPermission(r10, Process.myPid(), Process.myUid());
    }

    @NonNull
    public static Context createAttributionContext(@NonNull Context r5, @Nullable String r10) {
        return Api30Impl.createAttributionContext(r5, r10);
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context r5) {
        return Api24Impl.createDeviceProtectedStorageContext(r5);
    }

    private static File createFilesDir(File r5) {
        Object r10 = sSync;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5.exists() == false) goto L7;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r5;
    L7:
        if (r5.mkdirs() == false) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r5;
    L12:
        Log.w(TAG, "Unable to create files subdir " + r5.getPath());     // Catch: Throwable -> L10
        goto L13
    }

    @Nullable
    public static String getAttributionTag(@NonNull Context r5) {
        return Api30Impl.getAttributionTag(r5);
    }

    @NonNull
    public static File getCodeCacheDir(@NonNull Context r5) {
        return Api21Impl.getCodeCacheDir(r5);
    }

    @ColorInt
    public static int getColor(@NonNull Context r5, @ColorRes int r10) {
        return Api23Impl.getColor(r5, r10);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r5, @ColorRes int r10) {
        return ResourcesCompat.getColorStateList(r5.getResources(), r10, r5.getTheme());
    }

    @NonNull
    public static Context getContextForLanguage(@NonNull Context r5) {
        LocaleListCompat r10 = LocaleManagerCompat.getApplicationLocales(r5);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r5;
    L5:
        if (r10.isEmpty() == true) goto L9;
        Configuration r11 = new Configuration(r5.getResources().getConfiguration());
        ConfigurationCompat.setLocales(r11, r10);
        return r5.createConfigurationContext(r11);
    L9:
        return r5;
    }

    @Nullable
    public static File getDataDir(@NonNull Context r5) {
        return Api24Impl.getDataDir(r5);
    }

    @NonNull
    public static Display getDisplayOrDefault(@NonNull Context r5) {
        return Api30Impl.getDisplayOrDefault(r5);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r5, @DrawableRes int r10) {
        return Api21Impl.getDrawable(r5, r10);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context r5) {
        return r5.getExternalCacheDirs();
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context r5, @Nullable String r10) {
        return r5.getExternalFilesDirs(r10);
    }

    @NonNull
    public static Executor getMainExecutor(@NonNull Context r5) {
        return Api28Impl.getMainExecutor(r5);
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context r5) {
        return Api21Impl.getNoBackupFilesDir(r5);
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context r5) {
        return r5.getObbDirs();
    }

    @NonNull
    public static String getString(@NonNull Context r5, int r10) {
        return getContextForLanguage(r5).getString(r10);
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context r5, @NonNull Class<T> r10) {
        return (T) Api23Impl.getSystemService(r5, r10);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context r5, @NonNull Class<?> r10) {
        return Api23Impl.getSystemServiceName(r5, r10);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context r5) {
        return Api24Impl.isDeviceProtectedStorage(r5);
    }

    public static String obtainAndCheckReceiverPermission(Context r5) {
        String r10 = r5.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(r5, r10) != 0) goto L6;
        return r10;
    L6:
        throw new RuntimeException(j0.k("Permission ", r10, " is required by your application to receive broadcasts, please add it to your manifest"));
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context r10, @Nullable BroadcastReceiver r11, @NonNull IntentFilter r12, int r13) {
        return registerReceiver(r10, r11, r12, null, null, r13);
    }

    public static boolean startActivities(@NonNull Context r5, @NonNull Intent[] r10) {
        return startActivities(r5, r10, null);
    }

    public static void startActivity(@NonNull Context r5, @NonNull Intent r10, @Nullable Bundle r11) {
        r5.startActivity(r10, r11);
    }

    public static void startForegroundService(@NonNull Context r5, @NonNull Intent r10) {
        Api26Impl.startForegroundService(r5, r10);
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context r10, @Nullable BroadcastReceiver r11, @NonNull IntentFilter r12, @Nullable String r13, @Nullable Handler r14, int r15) {
        int r5 = r15 & 1;
        if (r5 != 0) goto L5;
    L9:
        if (r5 == 0) goto L11;
        r15 = r15 | 2;
    L11:
        int r16 = r15;
        int r17 = r16 & 2;
        if (r17 == 0) goto L14;
    L18:
        if (r17 == 0) goto L25;
        if ((r16 & 4) == 0) goto L25;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    L25:
        if (Build.VERSION.SDK_INT < 33) goto L29;
        return Api33Impl.registerReceiver(r10, r11, r12, r13, r14, r16);
    L29:
        return Api26Impl.registerReceiver(r10, r11, r12, r13, r14, r16);
    L14:
        if ((r16 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r15 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static boolean startActivities(@NonNull Context r5, @NonNull Intent[] r10, @Nullable Bundle r11) {
        r5.startActivities(r10, r11);
        return true;
    }
}
