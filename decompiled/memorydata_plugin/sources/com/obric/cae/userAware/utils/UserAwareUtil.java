package com.obric.cae.userAware.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.log.a;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.ui.settings.SmartMemorySettingsViewModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class UserAwareUtil {
    public static final int BAND_2_4_GHZ = 1;
    public static final int BAND_5_GHZ = 2;
    public static final int BAND_UNKNOWN = 0;
    public static final String CHANGE_INTO_COMPANY = "into_company";
    public static final String CHANGE_INTO_HOME = "into_home";
    public static final String CHANGE_OUT_COMPANY = "out_company";
    public static final String CHANGE_OUT_HOME = "out_home";
    private static final String DBAM_CONFIG_PREFS = "dbam_config_prefs";
    public static final int DBAM_CONFIG_VALUE_DEFAULT = 255;
    public static final String DEFAULT_OBSERVER_GAME_PACKAGE_NAMES = "com.tencent.tmgp.pubgmhd,com.tencent.tmgp.sgame";
    private static final int DEFAULT_PNO_PERIOD_MS = 5000;
    public static final String DEFULT_DEVICE_IMEI = "1111111111";
    private static final char[] DIGITS = null;
    public static final int HAR_STATE_ACCEL = 3;
    public static final int HAR_STATE_CAR = 8;
    public static final int HAR_STATE_CYCLING = 6;
    public static final int HAR_STATE_ELECTRIC_BIKE = 7;
    public static final int HAR_STATE_RUNNING = 1;
    public static final int HAR_STATE_STATIONARY = 0;
    public static final int HAR_STATE_SUBWAY = 5;
    public static final int HAR_STATE_UNKNOWN = 4;
    public static final int HAR_STATE_WALKING = 2;
    private static final String ISSUE_CHECKING_THRESHOLD_PREFS = "issue_checking_threshold_prefs";
    private static final String ISSUE_VERSION_PREFS = "issue_version_prefs";
    public static final String KEY_DBAM_ANTENNA_ISOLATION = "antenna_isolation";
    public static final String KEY_DBAM_BT_LOW_RSSI_THRESHOLD = "bt_low_rssi_threshold";
    public static final String KEY_DBAM_MAX_TX_POWER_FOR_BTC = "max_tx_power_for_btc";
    public static final String KEY_DBAM_MODE = "dbam_mode";
    public static final String KEY_DBAM_WIFI_LOW_RSSI_THRESHOLD = "wifi_low_rssi_threshold";
    public static final String KEY_LOW_LATENCY_PACKAGE_NAMES = "low_latency_package_names";
    private static final String KEY_PNO_DAY = "pno_day";
    private static final String KEY_PNO_EST_ROUNDS_TODAY = "pno_estimated_rounds_today";
    private static final String KEY_PNO_LAST_START_WALL = "pno_last_start_wall";
    private static final String KEY_PNO_SESSION_COUNT_TODAY = "pno_session_count_today";
    private static final String KEY_PNO_TOTAL_DURATION_TODAY_MS = "pno_total_duration_today_ms";
    private static final String KEY_THRESHOLD = "threshold";
    private static final String KEY_VERSION = "version";
    private static final String KEY_WIFI_SCAN_BUDGET_ATTEMPT_COUNT = "wifi_scan_budget_attempt_count";
    private static final String KEY_WIFI_SCAN_BUDGET_DAY = "wifi_scan_budget_day";
    private static final String KEY_WIFI_SCAN_BUDGET_DROP_COUNT = "wifi_scan_budget_drop_count";
    private static final String KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT = "wifi_scan_budget_success_count";
    private static final String LOW_LATENCY_PREFS = "low_latency_prefs";
    private static final String MAIN_PROCESS_NAME = "com.obric.cae";
    public static final int MODULE_BLUETOOTH = 1;
    public static final String PACKAGE_NAME_CAE = "com.obric.cae";
    public static final String PACKAGE_NAME_DOUBAO = "com.larus.nova";
    private static final String PACKAGE_NAME_PUBG = "com.tencent.tmgp.pubgmhd";
    private static final String PACKAGE_NAME_SQAME = "com.tencent.tmgp.sgame";
    private static final String PREF_PNO_STATS = "cae_user_aware_wifi_pno_stats_prefs";
    private static final String PREF_WIFI_SCAN_BUDGET = "cae_user_aware_wifi_scan_budget_prefs";
    public static final int SCREEN_OFF = 0;
    public static final int SCREEN_ON = 1;
    private static final String SETTINGS_SCOPE_GLOBAL = "Global";
    private static final String SETTINGS_SCOPE_SYSTEM = "System";
    public static final int STATE_COMPANY_CODE = 12;
    public static final String STATE_COMPANY_DOOR = "company_door";
    public static final String STATE_COMPANY_INDOOR = "company_indoor";
    public static final int STATE_DEFAULT_CODE = 255;
    public static final int STATE_HOME_CODE = 11;
    public static final String STATE_HOME_DOOR = "home_door";
    public static final String STATE_HOME_INDOOR = "home_indoor";
    public static final int STATE_OTHER_CODE = 13;
    public static final String STATE_OUTSIDE = "outside";
    private static final String TAG = "UserAwareUtil";
    private static final int THRESHOLD_DEFAULT = 3;
    private static final ThreadLocal<SimpleDateFormat> TL_DAY_FMT = null;
    private static final char[] UPPER_CASE_DIGITS = null;
    private static final String VERSION_DEFAULT = "0";
    private static String mLogStr = null;
    private static int mLogStrCnt = 0;
    private static int sWifiScanAttemptCount = 0;
    private static String sWifiScanAttemptDay = "";

    /* JADX INFO: renamed from: com.obric.cae.userAware.utils.UserAwareUtil$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState = null;
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType = null;

        static {
            int[] r0 = new int[StarGeofence.GeoState.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState = r0;
            r0[StarGeofence.GeoState.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState[StarGeofence.GeoState.INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState[StarGeofence.GeoState.OUTSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            int[] r3 = new int[StarGeofence.GeoType.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType = r3;
            r3[StarGeofence.GeoType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[StarGeofence.GeoType.HOME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L23:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[StarGeofence.GeoType.COMPANY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L27:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[StarGeofence.GeoType.TRAFFIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[StarGeofence.GeoType.MALL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    public static final class PnoStateSnapshot {
        public long durationMs;
        public int estimatedRounds;
        public int estimatedRoundsToday;
        public int periodMs;
        public int sessionCountToday;
        public long startWallClockMs;
        public long stopWallClockMs;
        public long totalDurationTodayMs;

        public PnoStateSnapshot() {
        }
    }

    static {
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        UPPER_CASE_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        TL_DAY_FMT = new AnonymousClass1();
    }

    public UserAwareUtil() {
    }

    public static byte LocationStateValueToByte(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4.contains(r5.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_home, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_home"))) == false) goto L8;
        StarGeofence.GeoType r6 = StarGeofence.GeoType.HOME;
    L6:
        return (byte) r6.ordinal();
    L8:
        if (r4.contains(r5.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_company, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_company"))) == false) goto L10;
        r6 = StarGeofence.GeoType.COMPANY;
        goto L6
    L10:
        r6 = StarGeofence.GeoType.UNKNOWN;
        goto L6
    }

    public static void MLog(String r4, String r5) {
        mLogStrCnt++;
        String r6 = mLogStr + String.format("%s %s", new Object[]{r4, r5}) + "        ";
        mLogStr = r6;
        if (mLogStrCnt <= 1) goto L6;
        mLogStrCnt = 0;
        a.e(TAG, r6);
        mLogStr = "";
        return;
    }

    public static String byteArrayToHex(byte[] r4) {
        StringBuilder r0 = new StringBuilder(r4.length * 2);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L7;
        r0.append(toHexString(r4[r1], true));
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }

    public static int calculateBluetoothIssueId(CaeBluetoothEvent r9) {
        int r0 = r9.getProfile();
        int r10 = r9.getCategory();
        double r3 = Math.pow(10.0d, 8.0d) * 1.0d;
        double r7 = Math.pow(10.0d, 6.0d);
        double r8 = (r7 * ((double) r0)) + r3;
        double r1 = Math.pow(10.0d, 3.0d);
        return (int) ((r1 * ((double) r10)) + r8);
    }

    private static boolean checkNetworkManagedProvisioningPermission(Context r2, int r3, int r4) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).checkPermission("android.permission.NETWORK_MANAGED_PROVISIONING", r3, r4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean checkNetworkSettingsPermission(Context r2, int r3, int r4) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).checkPermission("android.permission.NETWORK_SETTINGS", r3, r4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean checkNetworkSetupWizardPermission(Context r2, int r3, int r4) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).checkPermission("android.permission.NETWORK_SETUP_WIZARD", r3, r4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean checkNetworkStackPermission(Context r2, int r3, int r4) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).checkPermission("android.permission.NETWORK_STACK", r3, r4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static byte[] concatByteArrays(byte[]... r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = r4.length;     // Catch: IOException -> L11
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L10;
        byte[] r3 = r4[r2];     // Catch: IOException -> L11
        if (r3 == null) goto L8;
        r0.write(r3);     // Catch: IOException -> L11
    L8:
        r2 = r2 + 1;
        goto L4
    L10:
        return r0.toByteArray();
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String convertMacToUpperIfNeed(String r2) {
        if (r2 == null) goto L14;
        if (r2.isEmpty() == true) goto L14;
        if (r2.matches("([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}") == false) goto L12;
        if (r2.matches(".*[a-f].*") == true) goto L10;
        return r2;
    L10:
        return r2.toUpperCase();
    L12:
        throw new IllegalArgumentException("Invalid MAC address format: ".concat(r2));
    L14:
        throw new IllegalArgumentException("MAC address cannot be null or empty");
    }

    public static boolean copyFile(File r7, File r8) {
        if (r7 == null) goto L49;
        if (r8 == null) goto L49;
        if (r7.exists() == false) goto L49;
        if (r8.isDirectory() == false) goto L11;
        r8 = new File(r8, r7.getName());
    L11:
        File r3 = r8.getParentFile();
        if (r3 != null) goto L14;
    L53:
        InputStream r4 = Files.newInputStream(r7.toPath(), new OpenOption[0]);     // Catch: IOException -> L46
        OutputStream r5 = Files.newOutputStream(r8.toPath(), new OpenOption[0]);     // Catch: Throwable -> L39
        byte[] r6 = new byte[4096];     // Catch: Throwable -> L32
    L23:
        int r9 = r4.read(r6);     // Catch: Throwable -> L32
        if (r9 <= 0) goto L26;
        r5.write(r6, 0, r9);     // Catch: Throwable -> L32
        goto L23
    L26:
        a.e(TAG, "File copied successfully from " + r7.getAbsolutePath() + " to " + r8.getAbsolutePath());     // Catch: Throwable -> L32
    L28:
        if (r5 == null) goto L30;
        r5.close();     // Catch: Throwable -> L39
    L30:
        r4.close();     // Catch: IOException -> L46
        return true;
    L32:
        th = move-exception;
        if (r5 != null) goto L51;
    L38:
        throw th;     // Catch: Throwable -> L39
    L51:
        r5.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r4 != null) goto L57;
    L45:
        throw th;     // Catch: IOException -> L46
    L57:
        r4.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L46
    L46:
        e = move-exception;
        a.a(TAG, "Failed to copy file from " + r7.getAbsolutePath() + " to " + r8.getAbsolutePath(), e);
        return false;
    L14:
        if (r3.exists() == true) goto L53;
        if (r3.mkdirs() == true) goto L53;
        a.i(TAG, "Failed to create destination directory: " + r3.getAbsolutePath());
        return false;
    L49:
        a.i(TAG, "copyFile: source or destination is null, or source does not exist.");
        return false;
    }

    public static void deleteEmptySubdirectories(File r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isDirectory() == true) goto L6;
        return;
    L6:
        if (r6.exists() == false) goto L31;
        File[] r7 = r6.listFiles();
        if (r7 == null) goto L30;
        int r0 = r7.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L32;
        File r2 = r7[r1];
        if (r2.isDirectory() == false) goto L22;
        deleteEmptySubdirectories(r2);
        File[] r3 = r2.listFiles();
        if (r3 == null) goto L19;
        if (r3.length != 0) goto L22;
    L19:
        if (r2.delete() == false) goto L21;
        a.c(TAG, "Deleted empty directory: " + r2.getAbsolutePath());
        goto L22
    L21:
        a.g(TAG, "Failed to delete empty directory: " + r2.getAbsolutePath());
    L22:
        r1 = r1 + 1;
        goto L11
    L32:
        return;
    L30:
        return;
    }

    public static long extractValue(String r1, String r2) {
        Matcher r3 = Pattern.compile(r2 + ": (\\d+)").matcher(r1);
        if (r3.find() == true) goto L5;
        return 0;
    L5:
        return Long.parseLong(r3.group(1));
    }

    public static void findFilesRecursively(File r7, List<File> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isDirectory() == false) goto L26;
        File[] r10 = r7.listFiles();
        if (r10 == null) goto L25;
        int r0 = r10.length;
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L27;
        File r2 = r10[r1];
        if (r2.isFile() == false) goto L17;
        if (r2.length() <= 0) goto L17;
        r9.add(r2);
    L19:
        r1 = r1 + 1;
    L17:
        if (r2.isDirectory() == false) goto L19;
        findFilesRecursively(r2, r9);
        goto L19
    L27:
        return;
    L25:
        return;
    }

    public static String formatDateToFullString(Date r3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(r3);
    }

    public static String formatDateToShort(Date r3) {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(r3);
    }

    public static ApplicationInfo getAppInfoByUid(Context r2, int r3) {
        PackageManager r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        String[] r5 = r4.getPackagesForUid(r3);
        if (r5 != null) goto L5;
    L9:
        return null;
    L5:
        if (r5.length <= 0) goto L9;
        return r4.getApplicationInfo(r5[0], 0);
    }

    public static String getAppNameByAppInfo(Context r2, ApplicationInfo r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationLabel(r3).toString();
    }

    public static String getCaePostInfoHash(byte[] r1) {
        return byteArrayToHex(MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r1));
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getCellularIfNameByNetwork(Context r2, Network r3) {
        ConnectivityManager r4 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        LinkProperties r5 = r4.getLinkProperties(r3);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getInterfaceName();
    L8:
        return null;
    }

    public static int getCurrentLocationInteger(String r7) {
        r7.getClass();
        r7.hashCode();
        byte r6 = -1;
        switch(r7.hashCode()) {
            case -1106037339: goto L22;
            case -527125069: goto L18;
            case -406175659: goto L14;
            case 1429595696: goto L10;
            case 2117737230: goto L6;
            default: goto L25;
        };
    L25:
        switch(r6) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        return 6;
    L28:
        return 2;
    L29:
        return 3;
    L30:
        return 1;
    L31:
        return 0;
    L32:
        return 4;
    L6:
        if (r7.equals(STATE_HOME_DOOR) == false) goto L25;
        r6 = 4;
        goto L25
    L10:
        if (r7.equals(STATE_COMPANY_DOOR) == false) goto L25;
        r6 = 3;
        goto L25
    L14:
        if (r7.equals(STATE_COMPANY_INDOOR) == false) goto L25;
        r6 = 2;
        goto L25
    L18:
        if (r7.equals(STATE_HOME_INDOOR) == false) goto L25;
        r6 = 1;
        goto L25
    L22:
        if (r7.equals(STATE_OUTSIDE) == false) goto L25;
        r6 = 0;
        goto L25
    }

    public static String getCurrentLocationString(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        r3.getClass();
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1106037339: goto L22;
            case -527125069: goto L18;
            case -406175659: goto L14;
            case 1429595696: goto L10;
            case 2117737230: goto L6;
            default: goto L26;
        };
    L6:
        if (r3.equals(STATE_HOME_DOOR) == false) goto L26;
        r1 = 4;
        goto L26
    L10:
        if (r3.equals(STATE_COMPANY_DOOR) == false) goto L26;
        r1 = 3;
        goto L26
    L14:
        if (r3.equals(STATE_COMPANY_INDOOR) == false) goto L26;
        r1 = 2;
        goto L26
    L18:
        if (r3.equals(STATE_HOME_INDOOR) == false) goto L26;
        r1 = 1;
        goto L26
    L22:
        if (r3.equals(STATE_OUTSIDE) == false) goto L26;
        r1 = 0;
    L26:
        switch(r1) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            default: goto L27;
        };
    L27:
        int r0 = R.string.user_aware_aware_local_state_other;
        String r5 = "user_aware_aware_local_state_other";
    L29:
        return getStringValueFromXML(r4, ZeusTransformUtils.mapRes(r0, TypedValues.Custom.S_STRING, r5));
    L30:
        r0 = R.string.user_aware_aware_local_state_home_door;
        r5 = "user_aware_aware_local_state_home_door";
        goto L29
    L31:
        r0 = R.string.user_aware_aware_local_state_company_door;
        r5 = "user_aware_aware_local_state_company_door";
        goto L29
    L32:
        r0 = R.string.user_aware_aware_local_state_company_indoor;
        r5 = "user_aware_aware_local_state_company_indoor";
        goto L29
    L33:
        r0 = R.string.user_aware_aware_local_state_home_indoor;
        r5 = "user_aware_aware_local_state_home_indoor";
        goto L29
    L34:
        r0 = R.string.user_aware_aware_local_state_outside;
        r5 = "user_aware_aware_local_state_outside";
        goto L29
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static String getCurrentTimeFormatted() {
        Date r0 = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(r0);
    }

    public static int getCurrentWifiBand(int r1) {
        if (r1 < 2400) goto L9;
        if (r1 > 2500) goto L9;
        return 1;
    L9:
        if (r1 >= 4900) goto L11;
        return 0;
    L11:
        if (r1 > 5900) goto L16;
        return 2;
    L16:
        return 0;
    }

    public static int getDbamConfigPrefs(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(DBAM_CONFIG_PREFS, 0).getInt(r3, 255);
    }

    public static String getDeviceIMEI(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
    L15:
        e = move-exception;
        a.a(TAG, "Permission denied for getting IMEI", e);
        return DEFULT_DEVICE_IMEI;
    L4:
        if (Settings.Global.getInt(r7.getContentResolver(), "device_provisioned", 0) != 0) goto L7;
        a.g(TAG, "can not get IMEI when device initializing");     // Catch: SecurityException -> L15
        return DEFULT_DEVICE_IMEI;
    L7:
        TelephonyManager r8 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L15
        if (r8 != null) goto L11;
        a.i(TAG, "TelephonyManager is null");     // Catch: SecurityException -> L15
        return DEFULT_DEVICE_IMEI;
    L11:
        String r9 = r8.getImei();     // Catch: SecurityException -> L15
        if (r9 != null) goto L14;
        return DEFULT_DEVICE_IMEI;
    L14:
        return r9;
    }

    public static int getForegroundUid(Context r4) {
        List<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses();
        if (r5 == null) goto L11;
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r0 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r6.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (r0.importance != 100) goto L6;
        return r0.uid;
    L16:
        return -1;
    L11:
        return -1;
    }

    public static String getGeofenceStateString(Context r14, StarGeofence r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        int r1 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState[r15.getGeoState().ordinal()];
        if (r1 != 1) goto L5;
    L26:
        int r17 = ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_unknown, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_unknown");
    L27:
        r0.append(r16.getString(r17));
    L29:
        return r0.toString();
    L5:
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L29;
        r0.append(r16.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_out, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_out")));
        int r18 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[r15.getGeoType().ordinal()];
        if (r18 == 1) goto L26;
        if (r18 == 2) goto L25;
        if (r18 == 3) goto L24;
        if (r18 == 4) goto L23;
        if (r18 != 5) goto L29;
    L22:
        r17 = ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_mall, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_mall");
    L23:
        r17 = ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_traffic, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_traffic");
    L24:
        r17 = ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_company, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_company");
    L25:
        r17 = ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_home, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_home");
        goto L27
    L15:
        r0.append(r16.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_geo_fence_in, TypedValues.Custom.S_STRING, "user_aware_aware_geo_fence_in")));
        int r19 = AnonymousClass2.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[r15.getGeoType().ordinal()];
        if (r19 == 1) goto L26;
        if (r19 == 2) goto L25;
        if (r19 == 3) goto L24;
        if (r19 == 4) goto L23;
        if (r19 == 5) goto L22;
        goto L22
    }

    public static String getHarStateString(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        switch(r3) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L14;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        int r5 = R.string.user_aware_har_state_other;
        String r1 = "user_aware_har_state_other";
    L6:
        return r4.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r1));
    L7:
        r5 = R.string.user_aware_har_state_car;
        r1 = "user_aware_har_state_car";
        goto L6
    L8:
        r5 = R.string.user_aware_har_state_electric_bike;
        r1 = "user_aware_har_state_electric_bike";
        goto L6
    L9:
        r5 = R.string.user_aware_har_state_cycling;
        r1 = "user_aware_har_state_cycling";
        goto L6
    L10:
        r5 = R.string.user_aware_har_state_subway;
        r1 = "user_aware_har_state_subway";
        goto L6
    L11:
        r5 = R.string.user_aware_har_state_accel;
        r1 = "user_aware_har_state_accel";
        goto L6
    L12:
        r5 = R.string.user_aware_har_state_walking;
        r1 = "user_aware_har_state_walking";
        goto L6
    L13:
        r5 = R.string.user_aware_har_state_running;
        r1 = "user_aware_har_state_running";
        goto L6
    L14:
        r5 = R.string.user_aware_har_state_stationary;
        r1 = "user_aware_har_state_stationary";
        goto L6
    }

    public static int getHostSettingsInt(Context r2, ContentResolver r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return r5;
    L6:
        if (isFirstPartyDevice() == false) goto L10;
        return Settings.Global.getInt(r3, r4, r5);
    L10:
        return Settings.System.getInt(r3, r4, r5);
    }

    public static String getHostSettingsScope(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isFirstPartyDevice() == false) goto L5;
        return SETTINGS_SCOPE_GLOBAL;
    L5:
        return SETTINGS_SCOPE_SYSTEM;
    }

    public static String getHostSettingsString(Context r2, ContentResolver r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        if (isFirstPartyDevice() == false) goto L11;
        return Settings.Global.getString(r3, r4);
    L11:
        return Settings.System.getString(r3, r4);
    }

    public static Uri getHostSettingsUri(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isFirstPartyDevice() == false) goto L7;
        return Settings.Global.getUriFor(r3);
    L7:
        return Settings.System.getUriFor(r3);
    }

    public static int getIssueCheckingThreshold(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(ISSUE_CHECKING_THRESHOLD_PREFS, 0).getInt(KEY_THRESHOLD, 3);
    }

    public static String getLatestIssueVersion(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(ISSUE_VERSION_PREFS, 0).getString("version", "0");
    }

    public static File getLocalDir(Context r2, String r3) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getFilesDir(), r3);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    public static String getLowLatencyPackageNamesPrefs(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(LOW_LATENCY_PREFS, 0).getString(r3, DEFAULT_OBSERVER_GAME_PACKAGE_NAMES);
    }

    public static File getNearbyLogPathFile(Context r2) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getExternalFilesDir(null), "nearby");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    public static String getPackageNameByPid(Context r3, int r4) {
        ActivityManager r5 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = r5.getRunningAppProcesses().iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r0 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r6.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (r0.pid != r4) goto L6;
        return r0.processName;
    L16:
        return null;
    L11:
        return null;
    }

    public static int getSceneCorrectionCode(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_home, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_home")).equals(r4) == false) goto L7;
        return 11;
    L7:
        if (r5.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_company, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_company")).equals(r4) == false) goto L11;
        return 12;
    L11:
        if (r5.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_other, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_other")).equals(r4) == false) goto L14;
        return 13;
    L14:
        return 255;
    }

    public static String getSceneTitle(Context r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        String r3 = r7.split(";")[0];     // Catch: Exception -> L15
        String r10 = r7.split(";")[1];     // Catch: Exception -> L15
        String r1 = r9.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_learning_home_in_progress, TypedValues.Custom.S_STRING, "user_aware_aware_learning_home_in_progress"));     // Catch: Exception -> L15
        if (r3.equals(r9.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_learning_company_in_progress, TypedValues.Custom.S_STRING, "user_aware_aware_learning_company_in_progress"))) == true) goto L6;
    L9:
        if (r8 == null) goto L14;
        if (r8.isEmpty() == true) goto L14;
        return r8;
    L14:
        return r9.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_other, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_other"));
    L6:
        if (r10.equals(r1) == false) goto L9;
        return r9.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_learning, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_learning"));
    L16:
        return r9.getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_learning, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_learning"));
    }

    public static int getScreenState(Context r2) {
        return ((PowerManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin")).isInteractive() ? 1 : 0;
    }

    public static int getStateChangeInteger(String r6) {
        r6.getClass();
        r6.hashCode();
        switch(r6.hashCode()) {
            case -498341474: goto L18;
            case 54091568: goto L14;
            case 687039628: goto L10;
            case 771441502: goto L6;
            default: goto L4;
        };
    L4:
        byte r7 = -1;
    L21:
        switch(r7) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        return -1;
    L23:
        return 0;
    L24:
        return 3;
    L25:
        return 1;
    L26:
        return 2;
    L6:
        if (r6.equals(CHANGE_INTO_HOME) == false) goto L27;
        r7 = 3;
        goto L21
    L27:
        r7 = -1;
        goto L21
    L10:
        if (r6.equals(CHANGE_OUT_COMPANY) == false) goto L28;
        r7 = 2;
        goto L21
    L28:
        r7 = -1;
        goto L21
    L14:
        if (r6.equals(CHANGE_OUT_HOME) == false) goto L29;
        r7 = 1;
        goto L21
    L29:
        r7 = -1;
        goto L21
    L18:
        if (r6.equals(CHANGE_INTO_COMPANY) == false) goto L30;
        r7 = 0;
        goto L21
    L30:
        r7 = -1;
        goto L21
    }

    public static String getStateChangeString(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        r3.getClass();
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -498341474: goto L18;
            case 54091568: goto L14;
            case 687039628: goto L10;
            case 771441502: goto L6;
            default: goto L22;
        };
    L6:
        if (r3.equals(CHANGE_INTO_HOME) == false) goto L22;
        r1 = 3;
        goto L22
    L10:
        if (r3.equals(CHANGE_OUT_COMPANY) == false) goto L22;
        r1 = 2;
        goto L22
    L14:
        if (r3.equals(CHANGE_OUT_HOME) == false) goto L22;
        r1 = 1;
        goto L22
    L18:
        if (r3.equals(CHANGE_INTO_COMPANY) == false) goto L22;
        r1 = 0;
    L22:
        switch(r1) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            default: goto L23;
        };
    L23:
        int r0 = R.string.user_aware_aware_local_state_change_unknown;
        String r5 = "user_aware_aware_local_state_change_unknown";
    L25:
        return getStringValueFromXML(r4, ZeusTransformUtils.mapRes(r0, TypedValues.Custom.S_STRING, r5));
    L26:
        r0 = R.string.user_aware_aware_local_state_change_into_home;
        r5 = "user_aware_aware_local_state_change_into_home";
        goto L25
    L27:
        r0 = R.string.user_aware_aware_local_state_change_out_company;
        r5 = "user_aware_aware_local_state_change_out_company";
        goto L25
    L28:
        r0 = R.string.user_aware_aware_local_state_change_out_home;
        r5 = "user_aware_aware_local_state_change_out_home";
        goto L25
    L29:
        r0 = R.string.user_aware_aware_local_state_change_into_company;
        r5 = "user_aware_aware_local_state_change_into_company";
        goto L25
    }

    public static String getStringValueFromXML(Context r2, int r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getString(r3);
    }

    public static String getSubwayStateString(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L5;
        int r5 = R.string.user_aware_subway_action_exit;
        String r1 = "user_aware_subway_action_exit";
    L8:
        return r4.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r1));
    L5:
        if (r3 == 1) goto L9;
        r5 = R.string.user_aware_aware_local_state_unknown;
        r1 = "user_aware_aware_local_state_unknown";
        goto L8
    L9:
        r5 = R.string.user_aware_subway_action_enter;
        r1 = "user_aware_subway_action_enter";
        goto L8
    }

    public static String getTodayString() {
        SimpleDateFormat r1 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(TL_DAY_FMT.get(), SimpleDateFormat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        if (r1 == null) goto L10;
        return r1.format(new Date(System.currentTimeMillis()));
    L10:
        return "";
    L11:
        return "";
    }

    public static int getUserAwareWifiScanAttemptCountToday(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return 0;
    L6:
        monitor-enter(UserAwareUtil.class);
        SharedPreferences r7 = r6.getSharedPreferences(PREF_WIFI_SCAN_BUDGET, 0);     // Catch: Throwable -> L18
        String r2 = getTodayString();     // Catch: Throwable -> L18
        if (Objects.equals(r2, r7.getString(KEY_WIFI_SCAN_BUDGET_DAY, "")) == true) goto L13;
        resetWifiScanBudgetIfNewDayLocked(r7, r2);     // Catch: Throwable -> L18
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L18
        return 0;
    L13:
        if (Objects.equals(r2, sWifiScanAttemptDay) == true) goto L15;
        sWifiScanAttemptDay = r2;     // Catch: Throwable -> L18
        sWifiScanAttemptCount = 0;     // Catch: Throwable -> L18
    L15:
        int r8 = sWifiScanAttemptCount;     // Catch: Throwable -> L18
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L18
        return r8;
    L18:
        th = move-exception;
        throw th;
    }

    public static int getUserAwareWifiScanDailyCap(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        return 300;
    L8:
        return Settings.Global.getInt(r3.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP, 300);
    L7:
        return 300;
    }

    public static int getUserAwareWifiScanDropCountToday(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return 0;
    L6:
        monitor-enter(UserAwareUtil.class);
        SharedPreferences r7 = r6.getSharedPreferences(PREF_WIFI_SCAN_BUDGET, 0);     // Catch: Throwable -> L15
        String r2 = getTodayString();     // Catch: Throwable -> L15
        if (Objects.equals(r2, r7.getString(KEY_WIFI_SCAN_BUDGET_DAY, "")) == true) goto L12;
        resetWifiScanBudgetIfNewDayLocked(r7, r2);     // Catch: Throwable -> L15
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L15
        return 0;
    L12:
        int r8 = r7.getInt(KEY_WIFI_SCAN_BUDGET_DROP_COUNT, 0);     // Catch: Throwable -> L15
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    public static int getUserAwareWifiScanSuccessCountToday(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return 0;
    L6:
        monitor-enter(UserAwareUtil.class);
        SharedPreferences r7 = r6.getSharedPreferences(PREF_WIFI_SCAN_BUDGET, 0);     // Catch: Throwable -> L15
        String r2 = getTodayString();     // Catch: Throwable -> L15
        if (Objects.equals(r2, r7.getString(KEY_WIFI_SCAN_BUDGET_DAY, "")) == true) goto L12;
        resetWifiScanBudgetIfNewDayLocked(r7, r2);     // Catch: Throwable -> L15
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L15
        return 0;
    L12:
        int r8 = r7.getInt(KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT, 0);     // Catch: Throwable -> L15
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    public static int getWiFiAuthTypeFromWifiInfo(WifiInfo r0) {
        switch(r0.getCurrentSecurityType()) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L6;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L10;
            case 11: goto L6;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 1;
    L8:
        return 2;
    L10:
        return 3;
    }

    public static void handleFileDeletion(File r3) {
        if (r3.delete() == false) goto L5;
        a.e(TAG, "File deleted successfully: " + r3.getName());
        return;
    L5:
        a.i(TAG, "Failed to delete file: " + r3.getName());
    }

    public static Object invokeMethod(Object r3, String r4, Class[] r5, Object[] r6) {
        if (r5 != null) goto L5;
        Method r7 = r3.getClass().getDeclaredMethod(r4, new Class[0]);     // Catch: Throwable -> L13
    L6:
        r7.setAccessible(true);     // Catch: Throwable -> L13
        if (r7.getReturnType() == Void.class) goto L18;
        if (r6 != null) goto L12;
        return r7.invoke(r3, new Object[0]);
    L12:
        return r7.invoke(r3, r6);
    L18:
        return null;
    L5:
        r7 = r3.getClass().getDeclaredMethod(r4, r5);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        a.a(TAG, "invokeMethod error!" + r3.getClass().getName() + "." + r4, th);
        return null;
    }

    public static boolean isAppMainProcess(Context r2) {
        return "com.obric.cae".equalsIgnoreCase(com.obric.cae.libs.utils.a.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), Process.myPid()));
    }

    public static boolean isFileExist(File r1, File r2) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return false;
    L6:
        return new File(r1.getAbsolutePath(), r2.getName()).exists();
    L7:
        return false;
    }

    public static boolean isFirstPartyDevice() {
        return true ^ HonorKeys.NAME.equalsIgnoreCase(SystemProperties.get(PlatformConst.PROP_MANUFACTURER, ""));
    L9:
        return true;
    }

    public static boolean isHarEventTestToolEnabled(Context r4) {
        String r5 = Settings.Global.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_EVENT_TEST_TOOL_ENABLE);     // Catch: Exception -> L5
        boolean r2 = "1".equals(r5);     // Catch: Exception -> L5
        a.c(TAG, "isHarEventTestToolEnabled: " + r5 + ", enabled=" + r2);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        a.g(TAG, "Failed to check HAR event test tool enable: " + e.getMessage());
        return false;
    }

    public static boolean isMethodAvailable(Object r2, String r3, Class[] r4) {
        if (r2 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (r4 != null) goto L10;
        Method r5 = r2.getClass().getDeclaredMethod(r3, new Class[0]);     // Catch: Throwable -> L15 NoSuchMethodException -> L18
    L11:
        if (r5 == null) goto L14;
        return true;
    L14:
        return false;
    L10:
        r5 = r2.getClass().getDeclaredMethod(r3, r4);     // Catch: Throwable -> L15 NoSuchMethodException -> L18
    L18:
        StringBuilder r6 = new StringBuilder("Could not find method: ");
    L16:
        a.e(TAG, r6.append(r3).toString());
        return false;
    L15:
        r6 = new StringBuilder("Unexpected exception when checking if method: ").append(r3);
        r3 = " exists at runtime";
        goto L16
    }

    public static boolean isNearElevatorWifiMatchSupported(Context r3) {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getBoolean(ZeusTransformUtils.mapRes(R.bool.cae_supported_near_elevator_wifi_match, "bool", "cae_supported_near_elevator_wifi_match"));
    }

    public static boolean isNetifUp(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        NetworkInterface r1 = NetworkInterface.getByName(r5);     // Catch: SocketException -> L14
        if (r1 != null) goto L9;
        Log.d(TAG, "Interface " + r5 + " does not exist.");     // Catch: SocketException -> L14
        return false;
    L9:
        if (r1.isUp() == true) goto L12;
        Log.d(TAG, "Interface " + r5 + " exists but is down.");     // Catch: SocketException -> L14
        return false;
    L12:
        return true;
    L14:
        e = move-exception;
        Log.e(TAG, "SocketException while getting interface " + r5, e);
        return false;
    }

    public static boolean isOverseaRomVersion() {
        Field r1 = ZeusTransformUtils.forName("bytedanceos.config.ProductConfig", "com.obric.memorydata.plugin").getDeclaredField("FEAT_OVERSEA");     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r1.get(null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        e = move-exception;
        a.i(TAG, "isOverseaRomVersion error!" + e);
        return false;
    }

    public static boolean isPrivileged(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (checkNetworkSettingsPermission(r5, r3, r4) == false) goto L5;
    L14:
        return true;
    L5:
        if (checkNetworkSetupWizardPermission(r5, r3, r4) == true) goto L14;
        if (checkNetworkStackPermission(r5, r3, r4) == true) goto L14;
        if (checkNetworkManagedProvisioningPermission(r5, r3, r4) == true) goto L14;
        if (isSignedWithPlatformKey(r5, r4) == true) goto L14;
        return false;
    }

    public static boolean isSignedWithPlatformKey(Context r2, int r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().checkSignatures(r3, 1000) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSubwayTestToolEnabled(Context r4) {
        String r5 = Settings.Global.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_SUBWAY_TEST_TOOL_ENABLE);     // Catch: Exception -> L5
        boolean r2 = "1".equals(r5);     // Catch: Exception -> L5
        a.c(TAG, "isSubwayTestToolEnabled: " + r5 + ", enabled=" + r2);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        a.g(TAG, "Failed to check subway test tool enable: " + e.getMessage());
        return false;
    }

    public static boolean isSystemAppByInfo(ApplicationInfo r3) {
        if (r3.packageName.equals("com.android.settings") == false) goto L6;
        return false;
    L6:
        if (r3.packageName.startsWith("android") == false) goto L8;
    L21:
        return true;
    L8:
        if (r3.packageName.startsWith("com.android") == true) goto L21;
        if (r3.packageName.equals("com.obric.quicksearch") == true) goto L21;
        if (r3.packageName.equals("com.obric.notes") == true) goto L21;
        if (r3.packageName.equals("com.obric.calculator") == true) goto L21;
        if (r3.packageName.equals("com.obric.filemanager") == true) goto L21;
        if (r3.packageName.equals("com.obric.clock") == true) goto L21;
        if (r3.packageName.equals(SmartMemorySettingsViewModel.STORE_PACKAGE_NAME) == true) goto L21;
        return false;
    }

    public static boolean isTimeDiffLessThanMillis(Date r3, Date r4, long r5) {
        if (r3 == null) goto L10;
        if (r4 != null) goto L7;
        return false;
    L7:
        if (Math.abs(r3.getTime() - r4.getTime()) >= r5) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static boolean isWifiConnectedAndValidated(Context r3) {
        ConnectivityManager r4 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        if (r4 != null) goto L6;
        return false;
    L6:
        Network r1 = r4.getActiveNetwork();     // Catch: Exception -> L20
        if (r1 != null) goto L9;
        return false;
    L9:
        NetworkCapabilities r5 = r4.getNetworkCapabilities(r1);     // Catch: Exception -> L20
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r5.hasTransport(1) == true) goto L15;
        return false;
    L15:
        if (r5.hasCapability(12) == false) goto L26;
        if (r5.hasCapability(16) == true) goto L19;
        return false;
    L19:
        return true;
    L26:
        return false;
    L20:
        e = move-exception;
        a.i(TAG, "Error checking network connectivity: " + e.getMessage());
        return false;
    }

    public static PnoStateSnapshot onUserAwarePnoStateChanged(Context r20, boolean r21) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        PnoStateSnapshot r1 = new PnoStateSnapshot();
        if (r0 != null) goto L5;
        return r1;
    L5:
        long r2 = System.currentTimeMillis();
        String r4 = getTodayString();
        r1.periodMs = 5000;
        monitor-enter(UserAwareUtil.class);
        SharedPreferences r3 = r0.getSharedPreferences(PREF_PNO_STATS, 0);     // Catch: Throwable -> L32
        if (Objects.equals(r4, r3.getString(KEY_PNO_DAY, "")) == true) goto L10;
        r3.edit().putString(KEY_PNO_DAY, r4).putLong(KEY_PNO_LAST_START_WALL, 0).putLong(KEY_PNO_TOTAL_DURATION_TODAY_MS, 0).putInt(KEY_PNO_SESSION_COUNT_TODAY, 0).putInt(KEY_PNO_EST_ROUNDS_TODAY, 0).apply();     // Catch: Throwable -> L32
    L10:
        long r10 = r3.getLong(KEY_PNO_TOTAL_DURATION_TODAY_MS, 0);     // Catch: Throwable -> L32
        int r6 = r3.getInt(KEY_PNO_SESSION_COUNT_TODAY, 0);     // Catch: Throwable -> L32
        int r12 = r3.getInt(KEY_PNO_EST_ROUNDS_TODAY, 0);     // Catch: Throwable -> L32
        if (r21 == false) goto L15;
        r1.startWallClockMs = r2;     // Catch: Throwable -> L32
        r1.stopWallClockMs = 0;     // Catch: Throwable -> L32
        r1.durationMs = 0;     // Catch: Throwable -> L32
        r1.estimatedRounds = 0;     // Catch: Throwable -> L32
        r1.totalDurationTodayMs = r10;     // Catch: Throwable -> L32
        r1.sessionCountToday = r6;     // Catch: Throwable -> L32
        r1.estimatedRoundsToday = r12;     // Catch: Throwable -> L32
        r3.edit().putString(KEY_PNO_DAY, r4).putLong(KEY_PNO_LAST_START_WALL, r2).apply();     // Catch: Throwable -> L32
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L32
        return r1;
    L15:
        long r13 = r3.getLong(KEY_PNO_LAST_START_WALL, 0);     // Catch: Throwable -> L32
        if (r13 > 0) goto L19;
    L21:
        long r7 = 0;
    L23:
        int r5 = (int) (r7 / 5000);     // Catch: Throwable -> L36
        if (r5 >= 0) goto L26;
        r5 = 0;
    L26:
        long r11 = r10 + r7;     // Catch: Throwable -> L36
        if (r7 <= 0) goto L29;
        r6 = r6 + 1;     // Catch: Throwable -> L36
        r12 = r12 + r5;     // Catch: Throwable -> L36
    L29:
        r1.startWallClockMs = r13;     // Catch: Throwable -> L36
        r1.stopWallClockMs = r2;     // Catch: Throwable -> L36
        r1.durationMs = r7;     // Catch: Throwable -> L36
        r1.estimatedRounds = r5;     // Catch: Throwable -> L36
        r1.totalDurationTodayMs = r11;     // Catch: Throwable -> L36
        r1.sessionCountToday = r6;     // Catch: Throwable -> L36
        r1.estimatedRoundsToday = r12;     // Catch: Throwable -> L36
        r3.edit().putString(KEY_PNO_DAY, r4).putLong(KEY_PNO_LAST_START_WALL, 0).putLong(KEY_PNO_TOTAL_DURATION_TODAY_MS, r11).putInt(KEY_PNO_SESSION_COUNT_TODAY, r6).putInt(KEY_PNO_EST_ROUNDS_TODAY, r12).apply();     // Catch: Throwable -> L36
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L36
        return r1;
    L19:
        if (r2 < r13) goto L21;
        r7 = r2 - r13;
    L32:
        th = th;
    L34:
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L36
        throw th;
    L36:
        th = th;
        goto L34
    }

    public static void onUserAwareWifiScanSuccess(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return;
    L6:
        monitor-enter(UserAwareUtil.class);
        SharedPreferences r7 = r6.getSharedPreferences(PREF_WIFI_SCAN_BUDGET, 0);     // Catch: Throwable -> L13
        String r1 = getTodayString();     // Catch: Throwable -> L13
        if (Objects.equals(r1, r7.getString(KEY_WIFI_SCAN_BUDGET_DAY, "")) == true) goto L10;
        resetWifiScanBudgetIfNewDayLocked(r7, r1);     // Catch: Throwable -> L13
    L10:
        int r2 = r7.getInt(KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT, 0) + 1;     // Catch: Throwable -> L13
        r7.edit().putString(KEY_WIFI_SCAN_BUDGET_DAY, r1).putInt(KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT, r2).apply();     // Catch: Throwable -> L13
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static Date parseFullDateString(String r3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(r3);
    L5:
        return null;
    }

    public static String readFileByFullPath(String r5) {
        StringBuilder r0 = new StringBuilder(1024);
        FileInputStream r1 = new FileInputStream(r5);     // Catch: IOException -> L37
        InputStreamReader r6 = new InputStreamReader(r1, StandardCharsets.UTF_8);     // Catch: Throwable -> L31
        BufferedReader r2 = new BufferedReader(r6);     // Catch: Throwable -> L25
    L42:
        String r3 = r2.readLine();     // Catch: Throwable -> L19
        if (r3 == null) goto L10;
        r0.append(r3).append('\n');     // Catch: Throwable -> L19
        goto L42
    L10:
        if (r0.length() > 0) goto L12;
    L14:
        r2.close();     // Catch: Throwable -> L25
        r6.close();     // Catch: Throwable -> L31
        r1.close();     // Catch: IOException -> L37
        return r0.toString();
    L12:
        if (r0.charAt(r0.length() - 1) != '\n') goto L14;
        r0.setLength(r0.length() - 1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: IOException -> L37
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37
    L37:
        e = move-exception;
        a.i(TAG, "readFileByFullPath error! e=" + e);
        return "";
    }

    public static String removeDoubleQuotes(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.length();
        if (r0 > 1) goto L8;
        return r4;
    L8:
        if (r4.charAt(0) != '\"') goto L14;
        int r1 = r0 - 1;
        if (r4.charAt(r1) == '\"') goto L12;
        return r4;
    L12:
        return r4.substring(1, r1);
    L14:
        return r4;
    }

    private static void resetWifiScanBudgetIfNewDayLocked(SharedPreferences r2, String r3) {
        ((SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.class, "com.obric.memorydata.plugin")).edit().putString(KEY_WIFI_SCAN_BUDGET_DAY, r3).putInt(KEY_WIFI_SCAN_BUDGET_ATTEMPT_COUNT, 0).putInt(KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT, 0).putInt(KEY_WIFI_SCAN_BUDGET_DROP_COUNT, 0).apply();
        sWifiScanAttemptDay = r3;
        sWifiScanAttemptCount = 0;
    }

    public static void sendMessageWithBundle(Handler r0, int r1, Bundle r2) {
        Message r3 = Message.obtain(r0, r1);
        r3.setData(r2);
        r3.sendToTarget();
    }

    public static void sendMessageWithParam(Handler r0, int r1, Object r2) {
        Message.obtain(r0, r1, r2).sendToTarget();
    }

    public static void setDbamConfigPrefs(Context r2, String r3, int r4) {
        SharedPreferences.Editor r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(DBAM_CONFIG_PREFS, 0).edit();
        r5.putInt(r3, r4);
        r5.apply();
    }

    public static void setIssueCheckingThreshold(Context r2, int r3) {
        SharedPreferences.Editor r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(ISSUE_CHECKING_THRESHOLD_PREFS, 0).edit();
        r4.putInt(KEY_THRESHOLD, r3);
        r4.apply();
    }

    public static void setLatestIssueVersion(Context r2, String r3) {
        SharedPreferences.Editor r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(ISSUE_VERSION_PREFS, 0).edit();
        r4.putString("version", r3);
        r4.apply();
    }

    public static void setLightStatusBarIcon(Activity r2, boolean r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin").getDecorView().getSystemUiVisibility();
        if (r3 == false) goto L5;
        int r5 = r0 | 8192;
    L6:
        ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin").getDecorView().setSystemUiVisibility(r5);
        return;
    L5:
        r5 = r0 & (-8193);
        goto L6
    }

    public static void setLowLatencyPackageNamesPrefs(Context r2, String r3, String r4) {
        SharedPreferences.Editor r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(LOW_LATENCY_PREFS, 0).edit();
        r5.putString(r3, r4);
        r5.apply();
    }

    public static void setProperty(String r0, String r1) {
        SystemProperties.set(r0, r1);
    }

    public static String stringToMD5(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return "";
    L16:
        byte[] r8 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r7.getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r0 = new StringBuilder(32);     // Catch: NoSuchAlgorithmException -> L13
        int r2 = r8.length;     // Catch: NoSuchAlgorithmException -> L13
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String r4 = Integer.toHexString(Byte.toUnsignedInt(r8[r3]));     // Catch: NoSuchAlgorithmException -> L13
        if (r4.length() != 1) goto L10;
        r0.append('0');     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r0.append(r4);     // Catch: NoSuchAlgorithmException -> L13
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r0.toString();
    L13:
        e = move-exception;
        a.i(TAG, "MD5 algorithm not available: " + e);
        return "";
    }

    public static String timeMillisToDateString(long r7) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(r7)) + "." + String.format("%03d", new Object[]{Long.valueOf(r7 % 1000)});
    L4:
        e = move-exception;
        Log.e(TAG, "fail: e=" + e);
        return "";
    }

    public static String toHexString(byte r4, boolean r5) {
        if (r5 == false) goto L4;
        char[] r6 = UPPER_CASE_DIGITS;
    L6:
        return new String(new char[]{r6[(r4 >> 4) & 15], r6[r4 & 15]}, 0, 2);
    L4:
        r6 = DIGITS;
        goto L6
    }

    public static boolean tryAcquireUserAwareWifiScanBudget(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
        return true;
    L5:
        int r2 = getUserAwareWifiScanDailyCap(r11);
        if (r2 > 0) goto L9;
        return true;
    L9:
        monitor-enter(UserAwareUtil.class);
        SharedPreferences r12 = r11.getSharedPreferences(PREF_WIFI_SCAN_BUDGET, 0);     // Catch: Throwable -> L24
        String r4 = getTodayString();     // Catch: Throwable -> L24
        String r6 = r12.getString(KEY_WIFI_SCAN_BUDGET_DAY, "");     // Catch: Throwable -> L24
        if (Objects.equals(r4, r6) == true) goto L13;
        resetWifiScanBudgetIfNewDayLocked(r12, r4);     // Catch: Throwable -> L24
        int r7 = 0;
        int r8 = 0;
    L15:
        if (Objects.equals(r4, sWifiScanAttemptDay) == true) goto L17;
        sWifiScanAttemptDay = r4;     // Catch: Throwable -> L24
        sWifiScanAttemptCount = 0;     // Catch: Throwable -> L24
    L17:
        int r9 = sWifiScanAttemptCount + 1;     // Catch: Throwable -> L24
        sWifiScanAttemptCount = r9;     // Catch: Throwable -> L24
        if (r7 < r2) goto L22;
        int r13 = r8 + 1;     // Catch: Throwable -> L24
        r12.edit().putString(KEY_WIFI_SCAN_BUDGET_DAY, r4).putInt(KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT, r7).putInt(KEY_WIFI_SCAN_BUDGET_DROP_COUNT, r13).apply();     // Catch: Throwable -> L24
        a.c(TAG, "UA wifi scan budget blocked: cap=" + r2 + ", successToday=" + r7 + ", attemptsToday=" + r9 + ", dropsToday=" + r13 + ", today=" + r4 + ", savedDay=" + r6);     // Catch: Throwable -> L24
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L24
        return false;
    L22:
        monitor-exit(UserAwareUtil.class);     // Catch: Throwable -> L24
        return true;
    L13:
        r7 = r12.getInt(KEY_WIFI_SCAN_BUDGET_SUCCESS_COUNT, 0);     // Catch: Throwable -> L24
        r8 = r12.getInt(KEY_WIFI_SCAN_BUDGET_DROP_COUNT, 0);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static void writeJsonToFile(File r2, String r3) {
        FileWriter r0 = new FileWriter(r2, true);     // Catch: IOException -> L4
        r0.write(r3 + "\n");     // Catch: IOException -> L4
        r0.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        a.i(TAG, "Error logging to file: " + e.getMessage());
    }
}
