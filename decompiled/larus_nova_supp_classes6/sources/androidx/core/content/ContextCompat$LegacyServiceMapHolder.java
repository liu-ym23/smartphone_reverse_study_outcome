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
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
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
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import com.bytedance.crash.dumper.Scraps;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ContextCompat$LegacyServiceMapHolder {
    static final HashMap<Class<?>, String> SERVICES = null;

    private ContextCompat$LegacyServiceMapHolder() {
    }

    static {
        HashMap<Class<?>, String> r0 = new HashMap();
        SERVICES = r0;
        if (Build.VERSION.SDK_INT < 22) goto L5;
        r0.put(SubscriptionManager.class, "telephony_subscription_service");
        r0.put(UsageStatsManager.class, "usagestats");
    L5:
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
        r0.put(AppOpsManager.class, "appops");
        r0.put(CaptioningManager.class, "captioning");
        r0.put(ConsumerIrManager.class, "consumer_ir");
        r0.put(PrintManager.class, "print");
        r0.put(BluetoothManager.class, "bluetooth");
        r0.put(DisplayManager.class, "display");
        r0.put(UserManager.class, "user");
        r0.put(InputManager.class, "input");
        r0.put(MediaRouter.class, "media_router");
        r0.put(NsdManager.class, "servicediscovery");
        r0.put(AccessibilityManager.class, "accessibility");
        r0.put(AccountManager.class, "account");
        r0.put(ActivityManager.class, "activity");
        r0.put(AlarmManager.class, "alarm");
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
        r0.put(TelephonyManager.class, "phone");
        r0.put(TextServicesManager.class, "textservices");
        r0.put(UiModeManager.class, "uimode");
        r0.put(UsbManager.class, "usb");
        r0.put(Vibrator.class, "vibrator");
        r0.put(WallpaperManager.class, "wallpaper");
        r0.put(WifiP2pManager.class, "wifip2p");
        r0.put(WifiManager.class, "wifi");
        r0.put(WindowManager.class, "window");
    }
}
