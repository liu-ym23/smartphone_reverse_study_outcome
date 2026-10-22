package com.obric.cae.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.EventsUtils;
import android.util.Log;
import android.widget.Toast;
import com.obric.cae.BuildConfig;
import com.obric.cae.R;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import defpackage.b;
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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xc.a;

/* JADX INFO: loaded from: classes2.dex */
public class CaeUtil {
    private static final int A2DP_JITTER_ML_HISTORY_SEVERE_JITTER_OPTIMIZE_TRIGGER_THRESHOLD_DEFAULT = 2;
    private static final String A2DP_JITTER_ML_PREFS = "a2dp_jitter_ml_prefs";
    private static final float A2DP_JITTER_ML_PROB_HEAVY_DEFAULT = 0.8f;
    private static final int A2DP_JITTER_ML_SEVERE_JITTER_TRIGGER_THRESHOLD_DEFAULT = 3;
    public static final int BAND_2_4_GHZ = 1;
    public static final int BAND_5_GHZ = 2;
    public static final int BAND_UNKNOWN = 0;
    public static final String CHANGE_INTO_COMPANY = "into_company";
    public static final String CHANGE_INTO_HOME = "into_home";
    public static final String CHANGE_OUT_COMPANY = "out_company";
    public static final String CHANGE_OUT_HOME = "out_home";
    private static final String DBAM_CONFIG_PREFS = "dbam_config_prefs";
    public static final String DEFAULT_OBSERVER_GAME_PACKAGE_NAMES = "com.tencent.tmgp.pubgmhd,com.tencent.tmgp.sgame";
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
    public static final String KEY_A2DP_JITTER_ML_HISTORY_SEVERE_JITTER_OPTIMIZE_TRIGGER_THRESHOLD = "a2dp_jitter_ml_history_severe_jitter_optimize_trigger_threshold";
    public static final String KEY_A2DP_JITTER_ML_PROB_HEAVY = "a2dp_jitter_ml_prob_heavy";
    public static final String KEY_A2DP_JITTER_ML_SEVERE_JITTER_TRIGGER_THRESHOLD = "a2dp_jitter_ml_severe_jitter_trigger_threshold";
    public static final String KEY_DBAM_ANTENNA_ISOLATION = "antenna_isolation";
    public static final String KEY_DBAM_BT_LOW_RSSI_THRESHOLD = "bt_low_rssi_threshold";
    public static final String KEY_DBAM_MAX_TX_POWER_FOR_BTC = "max_tx_power_for_btc";
    public static final String KEY_DBAM_MODE = "dbam_mode";
    public static final String KEY_DBAM_WIFI_LOW_RSSI_THRESHOLD = "wifi_low_rssi_threshold";
    public static final String KEY_LOW_LATENCY_PACKAGE_NAMES = "low_latency_package_names";
    private static final String KEY_THRESHOLD = "threshold";
    private static final String KEY_VERSION = "version";
    public static final String KEY_ZTE_FEATURE_ABROAD = "ro.vendor.feature.zte_feature_abroad";
    private static final String LOW_LATENCY_PREFS = "low_latency_prefs";
    private static final String MAIN_PROCESS_NAME = "com.obric.cae";
    public static final int MODULE_BLUETOOTH = 1;
    public static final String NON_EEA = "NON_EEA";
    private static final String PACKAGE_NAME_PUBG = "com.tencent.tmgp.pubgmhd";
    private static final String PACKAGE_NAME_SQAME = "com.tencent.tmgp.sgame";
    public static final int SCREEN_OFF = 0;
    public static final int SCREEN_ON = 1;
    public static final int STATE_COMPANY_CODE = 12;
    public static final String STATE_COMPANY_DOOR = "company_door";
    public static final String STATE_COMPANY_INDOOR = "company_indoor";
    public static final int STATE_DEFAULT_CODE = 255;
    public static final int STATE_HOME_CODE = 11;
    public static final String STATE_HOME_DOOR = "home_door";
    public static final String STATE_HOME_INDOOR = "home_indoor";
    public static final int STATE_OTHER_CODE = 13;
    public static final String STATE_OUTSIDE = "outside";
    private static final String TAG = "CaeUtil";
    private static final int THRESHOLD_DEFAULT = 3;
    private static final char[] UPPER_CASE_DIGITS = null;
    private static final String VERSION_DEFAULT = "0";
    public static AtomicReference<String> mCellularNetif;
    private static String mLogStr;
    private static int mLogStrCnt;
    private static a mToast;
    private static final AtomicReference<ForegroundProcessInfo> sForegroundProcessInfo = null;
    private static volatile boolean sIsNetworkCallbackRegistered;
    private static volatile boolean sIsProcessObserverRegistered;
    private static final ConcurrentHashMap<String, Boolean> sNetifStatusMap = null;
    private static final ConcurrentHashMap<Network, String> sNetworkToIfNameMap = null;

    /* JADX INFO: renamed from: com.obric.cae.utils.CaeUtil$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState = null;
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType = null;

        static {
            int[] r8 = new int[StarGeofence.GeoState.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState = r8;
            r8[StarGeofence.GeoState.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L25:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState[StarGeofence.GeoState.INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState[StarGeofence.GeoState.OUTSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            int[] r10 = new int[StarGeofence.GeoType.values().length];
            $SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType = r10;
            r10[StarGeofence.GeoType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
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

    public static class ForegroundProcessInfo {
        public int pid;
        public int uid;

        public ForegroundProcessInfo(int r8, int r10) {
            this.uid = r8;
            this.pid = r10;
        }
    }

    static {
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        UPPER_CASE_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        mToast = null;
        sForegroundProcessInfo = new AtomicReference(null);
        sIsProcessObserverRegistered = false;
        sNetifStatusMap = new ConcurrentHashMap();
        sNetworkToIfNameMap = new ConcurrentHashMap();
        sIsNetworkCallbackRegistered = false;
        mCellularNetif = new AtomicReference(null);
    }

    public CaeUtil() {
    }

    public static byte LocationStateValueToByte(Context r8, String r10) {
        if (r10.contains(r8.getString(R.string.user_aware_aware_local_state_home)) == false) goto L8;
        StarGeofence.GeoType r11 = StarGeofence.GeoType.HOME;
    L6:
        return (byte) r11.ordinal();
    L8:
        if (r10.contains(r8.getString(R.string.user_aware_aware_local_state_company)) == false) goto L10;
        r11 = StarGeofence.GeoType.COMPANY;
        goto L6
    L10:
        r11 = StarGeofence.GeoType.UNKNOWN;
        goto L6
    }

    public static void MLog(String r8, String r10) {
        mLogStrCnt++;
        String r11 = mLogStr + String.format("%s %s", new Object[]{r8, r10}) + "        ";
        mLogStr = r11;
        if (mLogStrCnt <= 1) goto L6;
        mLogStrCnt = 0;
        CaeLog.i(TAG, r11);
        mLogStr = "";
        return;
    }

    public static /* synthetic */ ForegroundProcessInfo access$000(Context r8) {
        return getMainDisplayTopProcessInfo(r8);
    }

    public static /* synthetic */ AtomicReference access$100() {
        return sForegroundProcessInfo;
    }

    public static /* synthetic */ ConcurrentHashMap access$200() {
        return sNetworkToIfNameMap;
    }

    public static /* synthetic */ ConcurrentHashMap access$300() {
        return sNetifStatusMap;
    }

    public static String byteArrayToHex(byte[] r8) {
        StringBuilder r10 = new StringBuilder(r8.length * 2);
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L7;
        r10.append(toHexString(r8[r11], true));
        r11 = r11 + 1;
        goto L4
    L7:
        return r10.toString();
    }

    public static int calculateBluetoothIssueId(CaeBluetoothEvent r10) {
        int r8 = r10.getProfile();
        int r11 = r10.getCategory();
        double r12 = Math.pow(10.0d, 8.0d) * 1.0d;
        double r13 = Math.pow(10.0d, 6.0d);
        double r14 = (r13 * ((double) r8)) + r12;
        double r15 = Math.pow(10.0d, 3.0d);
        return (int) ((r15 * ((double) r11)) + r14);
    }

    private static boolean checkNetworkManagedProvisioningPermission(Context r8, int r10, int r11) {
        if (r8.checkPermission("android.permission.NETWORK_MANAGED_PROVISIONING", r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean checkNetworkSettingsPermission(Context r8, int r10, int r11) {
        if (r8.checkPermission("android.permission.NETWORK_SETTINGS", r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean checkNetworkSetupWizardPermission(Context r8, int r10, int r11) {
        if (r8.checkPermission("android.permission.NETWORK_SETUP_WIZARD", r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean checkNetworkStackPermission(Context r8, int r10, int r11) {
        if (r8.checkPermission("android.permission.NETWORK_STACK", r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void clearCellularNetif() {
        mCellularNetif.set(null);
    }

    public static byte[] concatByteArrays(byte[]... r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        int r11 = r8.length;     // Catch: IOException -> L11
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L10;
        byte[] r13 = r8[r12];     // Catch: IOException -> L11
        if (r13 == null) goto L8;
        r10.write(r13);     // Catch: IOException -> L11
    L8:
        r12 = r12 + 1;
        goto L4
    L10:
        return r10.toByteArray();
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String convertMacToUpperIfNeed(String r8) {
        if (r8 == null) goto L14;
        if (r8.isEmpty() == true) goto L14;
        if (r8.matches("([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}") == false) goto L12;
        if (r8.matches(".*[a-f].*") == true) goto L10;
        return r8;
    L10:
        return r8.toUpperCase();
    L12:
        throw new IllegalArgumentException("Invalid MAC address format: ".concat(r8));
    L14:
        throw new IllegalArgumentException("MAC address cannot be null or empty");
    }

    @SuppressLint({"NewApi"})
    public static boolean copyFile(File r8, File r10) {
        if (r8 == null) goto L49;
        if (r10 == null) goto L49;
        if (r8.exists() == false) goto L49;
        if (r10.isDirectory() == false) goto L11;
        r10 = new File(r10, r8.getName());
    L11:
        File r11 = r10.getParentFile();
        if (r11 != null) goto L14;
    L56:
        InputStream r12 = Files.newInputStream(r8.toPath(), new OpenOption[0]);     // Catch: IOException -> L46
        OutputStream r13 = Files.newOutputStream(r10.toPath(), new OpenOption[0]);     // Catch: Throwable -> L39
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L32
    L23:
        int r15 = r12.read(r14);     // Catch: Throwable -> L32
        if (r15 <= 0) goto L26;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L32
        goto L23
    L26:
        CaeLog.i(TAG, "File copied successfully from " + r8.getAbsolutePath() + " to " + r10.getAbsolutePath());     // Catch: Throwable -> L32
        if (r13 == null) goto L29;
        r13.close();     // Catch: Throwable -> L39
    L29:
        r12.close();     // Catch: IOException -> L46
        return true;
    L32:
        th = move-exception;
        if (r13 != null) goto L57;
    L38:
        throw th;     // Catch: Throwable -> L39
    L57:
        r13.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r12 != null) goto L54;
    L45:
        throw th;     // Catch: IOException -> L46
    L54:
        r12.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L46
    L46:
        e = move-exception;
        CaeLog.e(TAG, "Failed to copy file from " + r8.getAbsolutePath() + " to " + r10.getAbsolutePath(), e);
        return false;
    L14:
        if (r11.exists() == true) goto L56;
        if (r11.mkdirs() == true) goto L56;
        CaeLog.e(TAG, "Failed to create destination directory: " + r11.getAbsolutePath());
        return false;
    L49:
        CaeLog.e(TAG, "copyFile: source or destination is null, or source does not exist.");
        return false;
    }

    public static void deleteEmptySubdirectories(File r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isDirectory() == true) goto L6;
        return;
    L6:
        if (r8.exists() == false) goto L31;
        File[] r10 = r8.listFiles();
        if (r10 == null) goto L30;
        int r11 = r10.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L32;
        File r13 = r10[r12];
        if (r13.isDirectory() == false) goto L22;
        deleteEmptySubdirectories(r13);
        File[] r14 = r13.listFiles();
        if (r14 == null) goto L19;
        if (r14.length != 0) goto L22;
    L19:
        if (r13.delete() == false) goto L21;
        CaeLog.d(TAG, "Deleted empty directory: " + r13.getAbsolutePath());
        goto L22
    L21:
        CaeLog.w(TAG, "Failed to delete empty directory: " + r13.getAbsolutePath());
    L22:
        r12 = r12 + 1;
        goto L11
    L32:
        return;
    L30:
        return;
    }

    public static long extractValue(String r8, String r10) {
        Matcher r11 = Pattern.compile(r10 + ": (\\d+)").matcher(r8);
        if (r11.find() == true) goto L5;
        return 0;
    L5:
        return Long.parseLong(r11.group(1));
    }

    public static void findFilesRecursively(File r8, List<File> r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isDirectory() == false) goto L25;
        File[] r11 = r8.listFiles();
        if (r11 == null) goto L24;
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L26;
        File r14 = r11[r13];
        if (r14.isFile() == false) goto L16;
        if (r14.length() <= 0) goto L16;
        r10.add(r14);
    L18:
        r13 = r13 + 1;
    L16:
        if (r14.isDirectory() == false) goto L18;
        findFilesRecursively(r14, r10);
        goto L18
    L26:
        return;
    L24:
        return;
    }

    public static String formatDateToFullString(Date r8) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(r8);
    }

    public static String formatDateToShort(Date r8) {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(r8);
    }

    public static int getA2dpJitterMlHistorySevereJitterOptimizeTriggerThreshold(Context r8) {
        return r8.getSharedPreferences(A2DP_JITTER_ML_PREFS, 0).getInt(KEY_A2DP_JITTER_ML_HISTORY_SEVERE_JITTER_OPTIMIZE_TRIGGER_THRESHOLD, 2);
    }

    public static float getA2dpJitterMlProbHeavy(Context r8) {
        return r8.getSharedPreferences(A2DP_JITTER_ML_PREFS, 0).getFloat(KEY_A2DP_JITTER_ML_PROB_HEAVY, A2DP_JITTER_ML_PROB_HEAVY_DEFAULT);
    }

    public static int getA2dpJitterMlSevereJitterTriggerThreshold(Context r8) {
        return r8.getSharedPreferences(A2DP_JITTER_ML_PREFS, 0).getInt(KEY_A2DP_JITTER_ML_SEVERE_JITTER_TRIGGER_THRESHOLD, 3);
    }

    public static ApplicationInfo getAppInfoByUid(Context r8, int r10) {
        PackageManager r11 = r8.getPackageManager();
        String[] r12 = r11.getPackagesForUid(r10);
        if (r12 != null) goto L5;
    L9:
        return null;
    L5:
        if (r12.length <= 0) goto L9;
        return r11.getApplicationInfo(r12[0], 0);
    }

    public static String getAppNameByAppInfo(Context r8, ApplicationInfo r10) {
        return r8.getPackageManager().getApplicationLabel(r10).toString();
    }

    public static String getCaePostInfoHash(byte[] r8) {
        return byteArrayToHex(MessageDigest.getInstance("MD5").digest(r8));
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getCaeVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static String getCellularIfName() {
        return mCellularNetif.get();
    }

    public static String getCellularIfNameByNetwork(Context r8, Network r10) {
        ConnectivityManager r11 = (ConnectivityManager) r8.getSystemService("connectivity");
        if (r11 == null) goto L8;
        LinkProperties r12 = r11.getLinkProperties(r10);
        if (r12 == null) goto L10;
        mCellularNetif.set(r12.getInterfaceName());
        return mCellularNetif.get();
    L10:
        return null;
    L8:
        return null;
    }

    public static int getCurrentLocationInteger(String r8) {
        r8.getClass();
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -1106037339: goto L22;
            case -527125069: goto L18;
            case -406175659: goto L14;
            case 1429595696: goto L10;
            case 2117737230: goto L6;
            default: goto L25;
        };
    L25:
        switch(r10) {
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
        if (r8.equals("home_door") == false) goto L25;
        r10 = 4;
        goto L25
    L10:
        if (r8.equals("company_door") == false) goto L25;
        r10 = 3;
        goto L25
    L14:
        if (r8.equals("company_indoor") == false) goto L25;
        r10 = 2;
        goto L25
    L18:
        if (r8.equals("home_indoor") == false) goto L25;
        r10 = 1;
        goto L25
    L22:
        if (r8.equals("outside") == false) goto L25;
        r10 = 0;
        goto L25
    }

    public static String getCurrentLocationString(Context r8, String r10) {
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1106037339: goto L22;
            case -527125069: goto L18;
            case -406175659: goto L14;
            case 1429595696: goto L10;
            case 2117737230: goto L6;
            default: goto L25;
        };
    L25:
        switch(r11) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            default: goto L26;
        };
    L26:
        int r12 = R.string.user_aware_aware_local_state_other;
    L28:
        return getStringValueFromXML(r8, r12);
    L29:
        r12 = R.string.user_aware_aware_local_state_home_door;
        goto L28
    L30:
        r12 = R.string.user_aware_aware_local_state_company_door;
        goto L28
    L31:
        r12 = R.string.user_aware_aware_local_state_company_indoor;
        goto L28
    L32:
        r12 = R.string.user_aware_aware_local_state_home_indoor;
        goto L28
    L33:
        r12 = R.string.user_aware_aware_local_state_outside;
        goto L28
    L6:
        if (r10.equals("home_door") == false) goto L25;
        r11 = 4;
        goto L25
    L10:
        if (r10.equals("company_door") == false) goto L25;
        r11 = 3;
        goto L25
    L14:
        if (r10.equals("company_indoor") == false) goto L25;
        r11 = 2;
        goto L25
    L18:
        if (r10.equals("home_indoor") == false) goto L25;
        r11 = 1;
        goto L25
    L22:
        if (r10.equals("outside") == false) goto L25;
        r11 = 0;
        goto L25
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static String getCurrentTimeFormatted() {
        Date r8 = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(r8);
    }

    public static int getCurrentWifiBand(int r8) {
        if (r8 < 2400) goto L9;
        if (r8 > 2500) goto L9;
        return 1;
    L9:
        if (r8 >= 4900) goto L11;
        return 0;
    L11:
        if (r8 > 5900) goto L16;
        return 2;
    L16:
        return 0;
    }

    public static int getDbamConfigPrefs(Context r8, String r10) {
        return r8.getSharedPreferences(DBAM_CONFIG_PREFS, 0).getInt(r10, 255);
    }

    public static String getDeviceIMEI(Context r8) {
    L15:
        e = move-exception;
        CaeLog.e(TAG, "Permission denied for getting IMEI", e);
        return "1111111111";
    L4:
        if (Settings.Global.getInt(r8.getContentResolver(), "device_provisioned", 0) != 0) goto L7;
        CaeLog.w(TAG, "can not get IMEI when device initializing");     // Catch: SecurityException -> L15
        return "1111111111";
    L7:
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");     // Catch: SecurityException -> L15
        if (r10 != null) goto L11;
        CaeLog.e(TAG, "TelephonyManager is null");     // Catch: SecurityException -> L15
        return "1111111111";
    L11:
        String r11 = r10.getImei();     // Catch: SecurityException -> L15
        if (r11 != null) goto L14;
        return "1111111111";
    L14:
        return r11;
    }

    public static ForegroundProcessInfo getForegroundProcessInfo(Context r8) {
        registerProcessObserverIfNeeded(r8);
        AtomicReference<ForegroundProcessInfo> r10 = sForegroundProcessInfo;
        ForegroundProcessInfo r11 = r10.get();
        ForegroundProcessInfo r12 = getMainDisplayTopProcessInfo(r8);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r11 != null) goto L7;
    L10:
        r10.set(r12);
        return r12;
    L7:
        if (r12.uid != r11.uid) goto L10;
        return r11;
    }

    public static String getGeofenceStateString(Context r12, StarGeofence r13) {
        StringBuilder r8 = new StringBuilder();
        int r10 = AnonymousClass3.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoState[r13.getGeoState().ordinal()];
        if (r10 != 1) goto L5;
    L26:
        String r14 = r12.getString(R.string.user_aware_aware_geo_fence_unknown);
    L27:
        r8.append(r14);
    L29:
        return r8.toString();
    L5:
        if (r10 == 2) goto L19;
        if (r10 != 3) goto L29;
        r8.append(r12.getString(R.string.user_aware_aware_geo_fence_out));
        int r15 = AnonymousClass3.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[r13.getGeoType().ordinal()];
        if (r15 == 1) goto L26;
        if (r15 == 2) goto L18;
        if (r15 == 3) goto L17;
        if (r15 == 4) goto L16;
        if (r15 != 5) goto L29;
    L15:
        r14 = r12.getString(R.string.user_aware_aware_geo_fence_mall);
    L16:
        r14 = r12.getString(R.string.user_aware_aware_geo_fence_traffic);
    L17:
        r14 = r12.getString(R.string.user_aware_aware_geo_fence_company);
    L18:
        r14 = r12.getString(R.string.user_aware_aware_geo_fence_home);
        goto L27
    L19:
        r8.append(r12.getString(R.string.user_aware_aware_geo_fence_in));
        int r16 = AnonymousClass3.$SwitchMap$com$obric$cae$libs$location$geofence$StarGeofence$GeoType[r13.getGeoType().ordinal()];
        if (r16 == 1) goto L26;
        if (r16 == 2) goto L18;
        if (r16 == 3) goto L17;
        if (r16 == 4) goto L16;
        if (r16 == 5) goto L15;
        goto L15
    }

    public static String getHarStateString(Context r8, int r10) {
        switch(r10) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L13;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        int r11 = R.string.user_aware_har_state_other;
    L5:
        return r8.getString(r11);
    L6:
        r11 = R.string.user_aware_har_state_car;
        goto L5
    L7:
        r11 = R.string.user_aware_har_state_electric_bike;
        goto L5
    L8:
        r11 = R.string.user_aware_har_state_cycling;
        goto L5
    L9:
        r11 = R.string.user_aware_har_state_subway;
        goto L5
    L10:
        r11 = R.string.user_aware_har_state_accel;
        goto L5
    L11:
        r11 = R.string.user_aware_har_state_walking;
        goto L5
    L12:
        r11 = R.string.user_aware_har_state_running;
        goto L5
    L13:
        r11 = R.string.user_aware_har_state_stationary;
        goto L5
    }

    public static int getIssueCheckingThreshold(Context r8) {
        return r8.getSharedPreferences(ISSUE_CHECKING_THRESHOLD_PREFS, 0).getInt("threshold", 3);
    }

    public static String getLatestIssueVersion(Context r8) {
        return r8.getSharedPreferences(ISSUE_VERSION_PREFS, 0).getString("version", "0");
    }

    public static File getLocalDir(Context r8, String r10) {
        File r11 = new File(r8.getFilesDir(), r10);
        if (r11.exists() == true) goto L5;
        r11.mkdirs();
    L5:
        return r11;
    }

    public static String getLowLatencyPackageNamesPrefs(Context r8, String r10) {
        return r8.getSharedPreferences(LOW_LATENCY_PREFS, 0).getString(r10, "com.tencent.tmgp.pubgmhd,com.tencent.tmgp.sgame");
    }

    private static ForegroundProcessInfo getMainDisplayTopProcessInfo(Context r8) {
        ActivityTaskManager r10 = (ActivityTaskManager) r8.getSystemService("activity_task");
        if (r10 != null) goto L5;
        return null;
    L5:
        List r11 = r10.getTasks(5);
        if (r11 != null) goto L8;
    L22:
        return null;
    L8:
        if (r11.isEmpty() == true) goto L22;
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L22;
        ActivityManager.RunningTaskInfo r13 = (ActivityManager.RunningTaskInfo) r12.next();
        if (r13.displayId != 0) goto L12;
        ComponentName r14 = r13.topActivity;
        if (r14 == null) goto L22;
        String r15 = r14.getPackageName();
        int r16 = r8.getPackageManager().getPackageUid(r15, 0);     // Catch: PackageManager.NameNotFoundException -> L23
        return new ForegroundProcessInfo(r16, getPidByUidAndPackageName(r8, r16, r15));
    }

    public static File getNearbyLogPathFile(Context r8) {
        File r10 = new File(r8.getExternalFilesDir(null), "nearby");
        if (r10.exists() == true) goto L5;
        r10.mkdirs();
    L5:
        return r10;
    }

    public static String getPackageNameByPid(Context r8, int r10) {
        ActivityManager r11 = (ActivityManager) r8.getSystemService("activity");
        if (r11 == null) goto L11;
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = r11.getRunningAppProcesses().iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();
        if (r13.pid != r10) goto L6;
        return r13.processName;
    L16:
        return null;
    L11:
        return null;
    }

    private static int getPidByUidAndPackageName(Context r8, int r10, String r11) {
        ActivityManager r12 = (ActivityManager) r8.getSystemService("activity");
        if (r12 != null) goto L5;
        return -1;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r13 = r12.getRunningAppProcesses();
        if (r13 != null) goto L8;
        return -1;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L27;
        ActivityManager.RunningAppProcessInfo r15 = r14.next();
        if (r15.uid != r10) goto L10;
        String[] r16 = r15.pkgList;
        if (r16 != null) goto L16;
        if (r11.equals(r15.processName) == false) goto L10;
        return r15.pid;
    L16:
        int r17 = r16.length;
        int r18 = 0;
    L17:
        if (r18 >= r17) goto L10;
        if (r16[r18].equals(r11) == true) goto L21;
        r18 = r18 + 1;
        goto L17
    L21:
        return r15.pid;
    L27:
        return -1;
    }

    public static int getSceneCorrectionCode(Context r8, String r10) {
        if (r8.getString(R.string.user_aware_aware_local_state_home).equals(r10) == false) goto L7;
        return 11;
    L7:
        if (r8.getString(R.string.user_aware_aware_local_state_company).equals(r10) == false) goto L11;
        return 12;
    L11:
        if (r8.getString(R.string.user_aware_aware_local_state_other).equals(r10) == false) goto L14;
        return 13;
    L14:
        return 255;
    }

    public static String getSceneTitle(Context r8, String r10, String r11) {
        String r12 = r10.split(";")[0];     // Catch: Exception -> L15
        String r13 = r10.split(";")[1];     // Catch: Exception -> L15
        String r14 = r8.getString(R.string.user_aware_aware_learning_home_in_progress);     // Catch: Exception -> L15
        if (r12.equals(r8.getString(R.string.user_aware_aware_learning_company_in_progress)) == true) goto L6;
    L9:
        if (r11 == null) goto L14;
        if (r11.isEmpty() == true) goto L14;
        return r11;
    L14:
        return r8.getString(R.string.user_aware_aware_local_state_other);
    L6:
        if (r13.equals(r14) == false) goto L9;
        return r8.getString(R.string.user_aware_aware_local_state_learning);
    L16:
        return r8.getString(R.string.user_aware_aware_local_state_learning);
    }

    public static int getScreenState(Context r8) {
        return ((PowerManager) r8.getSystemService("power")).isInteractive() ? 1 : 0;
    }

    public static int getStateChangeInteger(String r8) {
        r8.getClass();
        switch(r8.hashCode()) {
            case -498341474: goto L18;
            case 54091568: goto L14;
            case 687039628: goto L10;
            case 771441502: goto L6;
            default: goto L4;
        };
    L4:
        byte r10 = -1;
    L21:
        switch(r10) {
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
        if (r8.equals("into_home") == false) goto L27;
        r10 = 3;
        goto L21
    L27:
        r10 = -1;
        goto L21
    L10:
        if (r8.equals("out_company") == false) goto L28;
        r10 = 2;
        goto L21
    L28:
        r10 = -1;
        goto L21
    L14:
        if (r8.equals("out_home") == false) goto L29;
        r10 = 1;
        goto L21
    L29:
        r10 = -1;
        goto L21
    L18:
        if (r8.equals("into_company") == false) goto L30;
        r10 = 0;
        goto L21
    L30:
        r10 = -1;
        goto L21
    }

    public static String getStateChangeString(Context r8, String r10) {
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -498341474: goto L18;
            case 54091568: goto L14;
            case 687039628: goto L10;
            case 771441502: goto L6;
            default: goto L21;
        };
    L21:
        switch(r11) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            default: goto L22;
        };
    L22:
        int r12 = R.string.user_aware_aware_local_state_change_unknown;
    L24:
        return getStringValueFromXML(r8, r12);
    L25:
        r12 = R.string.user_aware_aware_local_state_change_into_home;
        goto L24
    L26:
        r12 = R.string.user_aware_aware_local_state_change_out_company;
        goto L24
    L27:
        r12 = R.string.user_aware_aware_local_state_change_out_home;
        goto L24
    L28:
        r12 = R.string.user_aware_aware_local_state_change_into_company;
        goto L24
    L6:
        if (r10.equals("into_home") == false) goto L21;
        r11 = 3;
        goto L21
    L10:
        if (r10.equals("out_company") == false) goto L21;
        r11 = 2;
        goto L21
    L14:
        if (r10.equals("out_home") == false) goto L21;
        r11 = 1;
        goto L21
    L18:
        if (r10.equals("into_company") == false) goto L21;
        r11 = 0;
        goto L21
    }

    public static String getStringValueFromXML(Context r8, int r10) {
        return r8.getString(r10);
    }

    public static int getWiFiAuthTypeFromWifiInfo(WifiInfo r8) {
        switch(r8.getCurrentSecurityType()) {
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

    public static void handleFileDeletion(File r8) {
        if (r8.delete() == false) goto L5;
        CaeLog.i(TAG, "File deleted successfully: " + r8.getName());
        return;
    L5:
        CaeLog.e(TAG, "Failed to delete file: " + r8.getName());
    }

    public static Object invokeMethod(Object r8, String r10, Class[] r11, Object[] r12) {
        if (r11 != null) goto L5;
        Method r13 = r8.getClass().getDeclaredMethod(r10, new Class[0]);     // Catch: Throwable -> L13
    L6:
        r13.setAccessible(true);     // Catch: Throwable -> L13
        if (r13.getReturnType() == Void.class) goto L18;
        if (r12 != null) goto L12;
        return r13.invoke(r8, new Object[0]);
    L12:
        return r13.invoke(r8, r12);
    L18:
        return null;
    L5:
        r13 = r8.getClass().getDeclaredMethod(r10, r11);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CaeLog.e(TAG, "invokeMethod error!" + r8.getClass().getName() + "." + r10, th);
        return null;
    }

    public static boolean isAppMainProcess(Context r8) {
        return "com.obric.cae".equalsIgnoreCase(CaelibUtils.getAppNameByPID(r8, Process.myPid()));
    }

    public static boolean isBleAlwaysOnSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_ble_always_on);
    }

    public static boolean isFileExist(File r8, File r10) {
        if (r8 == null) goto L7;
        if (r10 != null) goto L6;
        return false;
    L6:
        return new File(r8.getAbsolutePath(), r10.getName()).exists();
    L7:
        return false;
    }

    public static boolean isL4NetworkEvaluateSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_l4_network_evaluate);
    }

    public static boolean isMethodAvailable(Object r8, String r10, Class[] r11) {
        if (r8 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        if (r11 != null) goto L10;
        Method r12 = r8.getClass().getDeclaredMethod(r10, new Class[0]);     // Catch: Throwable -> L15 NoSuchMethodException -> L18
    L11:
        if (r12 == null) goto L14;
        return true;
    L14:
        return false;
    L10:
        r12 = r8.getClass().getDeclaredMethod(r10, r11);     // Catch: Throwable -> L15 NoSuchMethodException -> L18
    L18:
        StringBuilder r13 = new StringBuilder("Could not find method: ");
    L16:
        r13.append(r10);
        CaeLog.i(TAG, r13.toString());
        return false;
    L15:
        r13 = new StringBuilder("Unexpected exception when checking if method: ");
        r13.append(r10);
        r10 = " exists at runtime";
        goto L16
    }

    public static boolean isNetifUp(Context r8, String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        registerNetworkCallbackIfNeeded(r8);
        if (r10.equals("tun0") == true) goto L33;
        Boolean r12 = sNetifStatusMap.get(r10);
        CaeLog.d(TAG, "isNetifUp: " + r10 + " cachedStatus=" + r12);
        if (r12 == null) goto L33;
        if (r12.booleanValue() == true) goto L14;
        if (r11 == 0) goto L14;
        CaeLog.i(TAG, "netif " + r10 + " cachedStatus is false, but have packets send recv");
    L14:
        return r12.booleanValue();
    L33:
        NetworkInterface r13 = NetworkInterface.getByName(r10);     // Catch: SocketException -> L30
        if (r13 != null) goto L21;
        Log.d(TAG, "Interface " + r10 + " does not exist.");     // Catch: SocketException -> L30
        return false;
    L21:
        if (r13.isUp() == true) goto L25;
        Log.d(TAG, "Interface " + r10 + " exists but is down.");     // Catch: SocketException -> L30
        sNetifStatusMap.put(r10, Boolean.FALSE);     // Catch: SocketException -> L30
        return false;
    L25:
        if (r10.equals("tun0") == false) goto L27;
        CaeLog.d(TAG, "netif tun0 is up");     // Catch: SocketException -> L30
    L27:
        sNetifStatusMap.put(r10, Boolean.TRUE);     // Catch: SocketException -> L30
        return true;
    L30:
        e = move-exception;
        Log.e(TAG, "SocketException while getting interface ".concat(r10), e);
        return false;
    }

    public static boolean isNetworkRateLimitSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_network_rate_limit);
    }

    public static boolean isNonEeaAbroad() {
        return NON_EEA.equals(SystemProperties.get(KEY_ZTE_FEATURE_ABROAD, ""));
    }

    public static boolean isOverseaRomVersion() {
        Field r8 = Class.forName("bytedanceos.config.ProductConfig").getDeclaredField("FEAT_OVERSEA");     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return ((Boolean) r8.get(null)).booleanValue();
    L4:
        e = move-exception;
        CaeLog.e(TAG, "isOverseaRomVersion error!" + e);
        return false;
    }

    public static boolean isPrivileged(Context r8, int r10, int r11) {
        if (checkNetworkSettingsPermission(r8, r10, r11) == false) goto L5;
    L14:
        return true;
    L5:
        if (checkNetworkSetupWizardPermission(r8, r10, r11) == true) goto L14;
        if (checkNetworkStackPermission(r8, r10, r11) == true) goto L14;
        if (checkNetworkManagedProvisioningPermission(r8, r10, r11) == true) goto L14;
        if (isSignedWithPlatformKey(r8, r11) == true) goto L14;
        return false;
    }

    public static boolean isSignedWithPlatformKey(Context r8, int r10) {
        if (r8.getPackageManager().checkSignatures(r10, 1000) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSystemAppByInfo(ApplicationInfo r8) {
        if (r8.packageName.equals("com.android.settings") == false) goto L6;
        return false;
    L6:
        if (r8.packageName.startsWith("android") == false) goto L8;
    L21:
        return true;
    L8:
        if (r8.packageName.startsWith("com.android") == true) goto L21;
        if (r8.packageName.equals("com.obric.quicksearch") == true) goto L21;
        if (r8.packageName.equals("com.obric.notes") == true) goto L21;
        if (r8.packageName.equals("com.obric.calculator") == true) goto L21;
        if (r8.packageName.equals("com.obric.filemanager") == true) goto L21;
        if (r8.packageName.equals("com.obric.clock") == true) goto L21;
        if (r8.packageName.equals(VipAppManager.PACKAGE_NAME_APPSTORE) == true) goto L21;
        return false;
    }

    public static boolean isTicketGrabbingSupported(Context r8) {
        return r8.getResources().getBoolean(R.bool.cae_supported_ticket_grabbing);
    }

    public static boolean isTimeDiffLessThanMillis(Date r8, Date r10, long r11) {
        if (r8 == null) goto L10;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (Math.abs(r8.getTime() - r10.getTime()) >= r11) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static boolean isWifiConnectedAndValidated(Context r8) {
        ConnectivityManager r10 = (ConnectivityManager) r8.getSystemService("connectivity");     // Catch: Exception -> L20
        if (r10 != null) goto L6;
        return false;
    L6:
        Network r11 = r10.getActiveNetwork();     // Catch: Exception -> L20
        if (r11 != null) goto L9;
        return false;
    L9:
        NetworkCapabilities r12 = r10.getNetworkCapabilities(r11);     // Catch: Exception -> L20
        if (r12 != null) goto L13;
        return false;
    L13:
        if (r12.hasTransport(1) == true) goto L15;
        return false;
    L15:
        if (r12.hasCapability(12) == false) goto L26;
        if (r12.hasCapability(16) == true) goto L19;
        return false;
    L19:
        return true;
    L26:
        return false;
    L20:
        e = move-exception;
        b.k(e, new StringBuilder("Error checking network connectivity: "), TAG);
        return false;
    }

    public static String maskMacOrBssid(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        String[] r10 = r8.split(BdimCategoryConstants.SEPARATOR_COLON);
        if (r10.length == 6) goto L10;
        return r8;
    L10:
        return r10[0] + BdimCategoryConstants.SEPARATOR_COLON + r10[1] + ":**:**:" + r10[4] + BdimCategoryConstants.SEPARATOR_COLON + r10[5];
    }

    public static Date parseFullDateString(String r8) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(r8);
    L5:
        return null;
    }

    public static String readFileByFullPath(String r8) {
        StringBuilder r10 = new StringBuilder(1024);
        FileInputStream r11 = new FileInputStream(r8);     // Catch: IOException -> L37
        InputStreamReader r12 = new InputStreamReader(r11, StandardCharsets.UTF_8);     // Catch: Throwable -> L31
        BufferedReader r13 = new BufferedReader(r12);     // Catch: Throwable -> L25
    L40:
        String r14 = r13.readLine();     // Catch: Throwable -> L19
        if (r14 == null) goto L10;
        r10.append(r14);     // Catch: Throwable -> L19
        r10.append('\n');     // Catch: Throwable -> L19
        goto L40
    L10:
        if (r10.length() > 0) goto L12;
    L14:
        r13.close();     // Catch: Throwable -> L25
        r12.close();     // Catch: Throwable -> L31
        r11.close();     // Catch: IOException -> L37
        return r10.toString();
    L12:
        if (r10.charAt(r10.length() - 1) != '\n') goto L14;
        r10.setLength(r10.length() - 1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: IOException -> L37
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37
    L37:
        e = move-exception;
        CaeLog.e(TAG, "readFileByFullPath error! e=" + e);
        return "";
    }

    private static void registerNetworkCallbackIfNeeded(Context r8) {
        if (sIsNetworkCallbackRegistered == false) goto L6;
        return;
    L6:
        monitor-enter(CaeUtil.class);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (sIsNetworkCallbackRegistered == false) goto L31;
        monitor-exit(CaeUtil.class);     // Catch: Throwable -> L27
        return;
    L31:
        Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L19 Throwable -> L27
        if (r10 != null) goto L14;
    L21:
        final ConnectivityManager r11 = (ConnectivityManager) r8.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L27
        if (r11 == null) goto L24;
        r11.registerNetworkCallback(new NetworkRequest.Builder().build(), new AnonymousClass2(r11));     // Catch: Throwable -> L27
    L24:
        sIsNetworkCallbackRegistered = true;     // Catch: Throwable -> L27
        monitor-exit(CaeUtil.class);     // Catch: Throwable -> L27
        return;
    L14:
        if (r10.hasMoreElements() == false) goto L21;
        NetworkInterface r12 = r10.nextElement();     // Catch: SocketException -> L19 Throwable -> L27
        if (r12 == null) goto L14;
        sNetifStatusMap.put(r12.getName(), Boolean.valueOf(r12.isUp()));     // Catch: SocketException -> L19 Throwable -> L27
    L19:
        e = move-exception;
        Log.e(TAG, "Failed to get initial network interfaces", e);     // Catch: Throwable -> L27
        goto L21
    }

    private static void registerProcessObserverIfNeeded(final Context r8) {
        if (sIsProcessObserverRegistered == false) goto L6;
        return;
    L6:
        monitor-enter(CaeUtil.class);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (sIsProcessObserverRegistered == false) goto L28;
        monitor-exit(CaeUtil.class);     // Catch: Throwable -> L24
        return;
    L28:
        IActivityManager r10 = ActivityManager.getService();     // Catch: Throwable -> L17 RemoteException -> L20
        if (r10 != null) goto L15;
        monitor-exit(CaeUtil.class);     // Catch: Throwable -> L24
        return;
    L15:
        r10.registerProcessObserver(new AnonymousClass1(r8));     // Catch: Throwable -> L17 RemoteException -> L20
        sIsProcessObserverRegistered = true;     // Catch: Throwable -> L17 RemoteException -> L20
    L22:
        monitor-exit(CaeUtil.class);     // Catch: Throwable -> L24
        return;
    L20:
        e = e;
        String r11 = TAG;
        String r12 = "registerProcessObserver failed";
    L19:
        CaeLog.e(r11, r12, e);     // Catch: Throwable -> L24
    L17:
        e = th;
        r11 = TAG;
        r12 = "registerProcessObserver unexpected error";
        goto L19
    }

    public static String removeDoubleQuotes(String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        int r10 = r8.length();
        if (r10 > 1) goto L8;
        return r8;
    L8:
        if (r8.charAt(0) != '\"') goto L14;
        int r11 = r10 - 1;
        if (r8.charAt(r11) == '\"') goto L12;
        return r8;
    L12:
        return r8.substring(1, r11);
    L14:
        return r8;
    }

    public static void sendMessageWithBundle(Handler r8, int r10, Bundle r11) {
        Message r12 = Message.obtain(r8, r10);
        r12.setData(r11);
        r12.sendToTarget();
    }

    public static void sendMessageWithParam(Handler r8, int r10, Object r11) {
        Message.obtain(r8, r10, r11).sendToTarget();
    }

    public static void setA2dpJitterMlHistorySevereJitterOptimizeTriggerThreshold(Context r8, int r10) {
        SharedPreferences.Editor r11 = r8.getSharedPreferences(A2DP_JITTER_ML_PREFS, 0).edit();
        r11.putInt(KEY_A2DP_JITTER_ML_HISTORY_SEVERE_JITTER_OPTIMIZE_TRIGGER_THRESHOLD, r10);
        r11.apply();
    }

    public static void setA2dpJitterMlProbHeavy(Context r8, float r10) {
        SharedPreferences.Editor r11 = r8.getSharedPreferences(A2DP_JITTER_ML_PREFS, 0).edit();
        r11.putFloat(KEY_A2DP_JITTER_ML_PROB_HEAVY, r10);
        r11.apply();
    }

    public static void setA2dpJitterMlSevereJitterTriggerThreshold(Context r8, int r10) {
        SharedPreferences.Editor r11 = r8.getSharedPreferences(A2DP_JITTER_ML_PREFS, 0).edit();
        r11.putInt(KEY_A2DP_JITTER_ML_SEVERE_JITTER_TRIGGER_THRESHOLD, r10);
        r11.apply();
    }

    public static void setDbamConfigPrefs(Context r8, String r10, int r11) {
        SharedPreferences.Editor r12 = r8.getSharedPreferences(DBAM_CONFIG_PREFS, 0).edit();
        r12.putInt(r10, r11);
        r12.apply();
    }

    public static void setIssueCheckingThreshold(Context r8, int r10) {
        SharedPreferences.Editor r11 = r8.getSharedPreferences(ISSUE_CHECKING_THRESHOLD_PREFS, 0).edit();
        r11.putInt("threshold", r10);
        r11.apply();
    }

    public static void setLatestIssueVersion(Context r8, String r10) {
        SharedPreferences.Editor r11 = r8.getSharedPreferences(ISSUE_VERSION_PREFS, 0).edit();
        r11.putString("version", r10);
        r11.apply();
    }

    public static void setLightStatusBarIcon(Activity r8, boolean r10) {
        int r11 = r8.getWindow().getDecorView().getSystemUiVisibility();
        if (r10 == false) goto L5;
        int r12 = r11 | 8192;
    L6:
        r8.getWindow().getDecorView().setSystemUiVisibility(r12);
        return;
    L5:
        r12 = r11 & (-8193);
        goto L6
    }

    public static void setLowLatencyPackageNamesPrefs(Context r8, String r10, String r11) {
        SharedPreferences.Editor r12 = r8.getSharedPreferences(LOW_LATENCY_PREFS, 0).edit();
        r12.putString(r10, r11);
        r12.apply();
    }

    public static void setProperty(String r8, String r10) {
        SystemProperties.set(r8, r10);
    }

    public static void showShortToast(Activity r8, String r10) {
        a r11 = mToast;
        if (r11 == null) goto L8;
        a.c r12 = r11.f13844a;
        r12.getClass();
        Log.v("OToast", "HIDE: " + r12);
        r12.f13858b.sendEmptyMessage(2);
        Toast r13 = r11.f13845b;
        if (r13 == null) goto L7;
        r13.cancel();
    L7:
        mToast = null;
    L8:
        a r14 = new a(r8, r10);
        mToast = r14;
        r14.a();
    }

    public static String stringToMD5(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L16;
        return "";
    L16:
        byte[] r10 = MessageDigest.getInstance("MD5").digest(r8.getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r11 = new StringBuilder(32);     // Catch: NoSuchAlgorithmException -> L13
        int r12 = r10.length;     // Catch: NoSuchAlgorithmException -> L13
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        String r14 = Integer.toHexString(Byte.toUnsignedInt(r10[r13]));     // Catch: NoSuchAlgorithmException -> L13
        if (r14.length() != 1) goto L10;
        r11.append('0');     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r11.append(r14);     // Catch: NoSuchAlgorithmException -> L13
        r13 = r13 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r11.toString();
    L13:
        e = move-exception;
        CaeLog.e(TAG, "MD5 algorithm not available: " + e);
        return "";
    }

    public static String timeMillisToDateString(long r8) {
        SimpleDateFormat r10 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: IllegalArgumentException -> L4
        Date r11 = new Date(r8);     // Catch: IllegalArgumentException -> L4
        return r10.format(r11) + "." + String.format("%03d", new Object[]{Long.valueOf(r8 % 1000)});
    L4:
        e = move-exception;
        Log.e(TAG, "fail: e=" + e);
        return "";
    }

    public static String toHexString(byte r8, boolean r10) {
        if (r10 == false) goto L4;
        char[] r11 = UPPER_CASE_DIGITS;
    L6:
        return new String(new char[]{r11[(r8 >> 4) & 15], r11[r8 & 15]}, 0, 2);
    L4:
        r11 = DIGITS;
        goto L6
    }

    public static void writeJsonToFile(File r8, String r10) {
        FileWriter r11 = new FileWriter(r8, true);     // Catch: IOException -> L4
        r11.write(r10 + "\n");     // Catch: IOException -> L4
        r11.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Error logging to file: " + e.getMessage());
    }

    public static boolean writePbEventSafely(long r8, int r10, byte[] r11) {
        EventsUtils.writePbEvent(r8, r10, r11);     // Catch: Throwable -> L6 RuntimeException -> L9
        return true;
    L9:
        e = move-exception;
        String r12 = e.getMessage();
        if (r12 != null) goto L13;
    L15:
        CaeLog.e(TAG, "EventsUtils.writePbEvent failed, drop event. featureId=" + r10, e);
    L16:
        return false;
    L13:
        if (r12.contains("Stub") == false) goto L15;
        android.aimedia.a.p("EventsUtils.writePbEvent is stub on this build, drop event. featureId=", r10, TAG);
    L6:
        th = move-exception;
        CaeLog.e(TAG, "EventsUtils.writePbEvent unexpected failure, drop event. featureId=" + r10, th);
        return false;
    }
}
