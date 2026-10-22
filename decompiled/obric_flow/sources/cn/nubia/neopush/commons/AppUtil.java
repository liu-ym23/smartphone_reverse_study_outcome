package cn.nubia.neopush.commons;

import ai.j0;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.writer.DaoWriter;
import cn.nubia.neopush.commons.deviceid.DeviceId;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppUtil {
    public static final long MILLIS_IN_DAYS = 86400000;
    private static final String PROVIDER_URI_NUBIA_PUSH = "content://cn.nubia.provider.deviceid.dataid/grndid";
    private static final String PROVIDER_URI_ZTE_PUSH = "content://cn.nubia.provider.deviceid.dataid.zte/grndid";
    static int addWhiteListcount = 0;
    static boolean hasresumePolicy = true;
    private static DeviceId mDid = null;
    private static String mOaid = "";
    private static String mVaid = "";
    public static StrictMode.ThreadPolicy prepolicy;
    public static PowerManager.WakeLock wakelock;

    public AppUtil() {
    }

    public static String InputStream2String(InputStream r5) {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(r5, "utf-8"));     // Catch: Exception -> L7
        StringBuffer r11 = new StringBuffer();     // Catch: Exception -> L7
    L3:
        String r12 = r10.readLine();     // Catch: Exception -> L7
        if (r12 == null) goto L5;
        r11.append(r12);     // Catch: Exception -> L7
        r11.append("\n");     // Catch: Exception -> L7
        goto L3
    L5:
        return r11.toString();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void SaveCrashInfo(Context r5, String r10, Properties r11) {
        String r12 = r5.getPackageName();
        if (r10 != null) goto L5;
    L7:
        r11.put("packagename", r12);
        NeoLog.i("luzhi", "Crash info devicemodel " + getDeviceModel());
        r11.put("Version", getDeviceModel());
        r11.put("time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        FileOutputStream r13 = r5.openFileOutput("neoPushCrash_" + new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date()) + ".log", 0);     // Catch: IOException -> L10 FileNotFoundException -> L12
        r11.store(r13, "");     // Catch: IOException -> L10 FileNotFoundException -> L12
        r13.flush();     // Catch: IOException -> L10 FileNotFoundException -> L12
        r13.close();     // Catch: IOException -> L10 FileNotFoundException -> L12
    L20:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r10.contains("\n") == false) goto L7;
        r11.put("CrashInfo", r10.replace("\n", "#"));
        goto L7
    }

    public static void UploadVersion(final Context r5) {
        if (isSdkChange(r5) == false) goto L5;
    L6:
        new AnonymousClass2(r5).start();
        return;
    L5:
        if (isUploadVersionSuccess(r5) == false) goto L6;
    }

    public static /* synthetic */ String access$0(Context r5) {
        return getVaid(r5);
    }

    public static void acqureLock(Context r5) {
        NeoLog.i("luzhi", "acqure lock");
        PowerManager.WakeLock r10 = ((PowerManager) r5.getSystemService("power")).newWakeLock(1, r5.getClass().getCanonicalName());
        wakelock = r10;
        r10.acquire(15000);
    }

    public static void addCanNotConnect(Context r5) {
        SharedPreferences r10 = r5.getSharedPreferences(Constant.SP_FILE_NAME, 0);
        int r11 = r10.getInt(Constant.CAN_NOT_CONNECT_COUNT, 0);
        SharedPreferences.Editor r12 = r10.edit();
        r12.putInt(Constant.CAN_NOT_CONNECT_COUNT, r11 + 1);
        r12.commit();
    }

    public static void addWhiteList() {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equals(Thread.currentThread().getName()) == false) goto L17;
        addWhiteListcount++;     // Catch: Exception -> L7
        if (prepolicy != null) goto L10;
        prepolicy = StrictMode.getThreadPolicy();     // Catch: Exception -> L7
    L10:
        if (hasresumePolicy == false) goto L18;
        StrictMode.allowThreadDiskReads();     // Catch: Exception -> L7
        hasresumePolicy = false;     // Catch: Exception -> L7
        return;
    L18:
        return;
    }

    private static int bytesToInt(byte[] r5) {
        NeoLog.i("bytesToInt length=" + r5.length);
        if (r5.length >= 4) goto L5;
        return 0;
    L5:
        return (((r5[3] & UByte.MAX_VALUE) | ((r5[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) | ((r5[1] << 16) & 16711680)) | ((r5[0] << 24) & ViewCompat.MEASURED_STATE_MASK);
    }

    public static void clearAppInfo(Context r5) {
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).edit();
        r10.putString(Constant.CLIENT_APPID, "");
        r10.putString(Constant.CLIENT_APPKEY, "");
        r10.putString(Constant.CLIENT_PACKNAME, "");
        r10.commit();
    }

    public static void clearCanNotConnect(Context r5) {
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SP_FILE_NAME, 0).edit();
        r10.putInt(Constant.CAN_NOT_CONNECT_COUNT, 0);
        r10.commit();
    }

    public static void deleteLogs(Context r5, String[] r10) {
        File r11 = r5.getFilesDir();     // Catch: Exception -> L10
        if (r10 == null) goto L16;
        int r12 = 0;
    L6:
        if (r12 >= r10.length) goto L17;
        new File(r11, r10[r12]).delete();     // Catch: Exception -> L10
        r12 = r12 + 1;
        goto L6
    L17:
        return;
    L16:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public static int generateActualNotifyId(String r5, int r10, int r11) {
        int r12 = generateNotifyId(r5) + r11;
        if (r10 >= 0) goto L5;
        return r12;
    L5:
        return r12 + r10;
    }

    public static int generateNotifyId(String r5) {
        int r10 = 0;
        if (r5 != null) goto L11;
        return 0;
    L11:
        int r11 = r5.length() / 2;     // Catch: Exception -> L6
        return Integer.parseInt(String.valueOf(String.valueOf(r5.substring(0, r11).hashCode())) + String.valueOf(r5.substring(r11).hashCode()));
    L6:
        int r12 = r5.length();
        int r13 = 0;
    L7:
        if (r10 >= r12) goto L14;
        r13 = r13 + r5.charAt(r10);
        r10 = r10 + 1;
        goto L7
    L14:
        return r13;
    }

    public static List<String> getAllImei(Context r5) {
        return new ArrayList();
    }

    private static String getAndroidId(Context r5) {
        return "";
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getAppID(Context r5) {
        return r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).getString(Constant.CLIENT_APPID, null);
    }

    public static Bitmap getAppIcon(Context r5, String r10) {
        PackageManager r11 = r5.getPackageManager();
        List<PackageInfo> r12 = r11.getInstalledPackages(0);
        if (r12 == null) goto L11;
        Iterator<PackageInfo> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        PackageInfo r14 = r13.next();
        if (r10.equals(r14.packageName) == false) goto L6;
    L12:
        if (r14 == null) goto L19;
        Drawable r15 = r14.applicationInfo.loadIcon(r11);
        int r16 = r15.getIntrinsicWidth();
        int r17 = r15.getIntrinsicHeight();
        if (r15.getOpacity() == (-1)) goto L16;
        Bitmap.Config r18 = Bitmap.Config.ARGB_8888;
    L17:
        Bitmap r19 = Bitmap.createBitmap(r16, r17, r18);
        Canvas r20 = new Canvas(r19);
        r15.setBounds(0, 0, r15.getIntrinsicWidth(), r15.getIntrinsicHeight());
        r15.draw(r20);
        return r19;
    L16:
        r18 = Bitmap.Config.RGB_565;
        goto L17
    L19:
        return null;
    L11:
        r14 = null;
        goto L12
    }

    public static int getAppIconResourceId(Context r5, String r10) {
        List<PackageInfo> r11 = r5.getPackageManager().getInstalledPackages(0);
        if (r11 == null) goto L11;
        Iterator<PackageInfo> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        PackageInfo r13 = r12.next();
        if (r10.equals(r13.packageName) == false) goto L6;
    L12:
        if (r13 != null) goto L14;
        return -1;
    L14:
        return r13.applicationInfo.icon;
    L11:
        r13 = null;
        goto L12
    }

    public static PackageInfo getAppInfo(Context r5, String r10) {
        List<PackageInfo> r11 = r5.getPackageManager().getInstalledPackages(0);
        if (r11 == null) goto L15;
        Iterator<PackageInfo> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        PackageInfo r13 = r12.next();
        if (r10.equals(r13.packageName) == false) goto L6;
        return r13;
    L16:
        return null;
    L15:
        return null;
    }

    public static String getAppKey(Context r5) {
        return r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).getString(Constant.CLIENT_APPKEY, null);
    }

    public static String getAppPackName(Context r5) {
        return r5.getSharedPreferences(Constant.SAVE_TICKET_INFO, 4).getString(Constant.CLIENT_PACKNAME, null);
    }

    private static String getBuildId() {
        return Build.ID;
    }

    public static int getCanNotConnect(Context r5) {
        return r5.getSharedPreferences(Constant.SP_FILE_NAME, 0).getInt(Constant.CAN_NOT_CONNECT_COUNT, 0);
    }

    public static String getCanUploadLogs(Context r10, String[] r11) {
        String r5 = "";
        int r12 = 0;
    L26:
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r12 >= r11.length) goto L22;
        r5 = r5 + "&*&" + InputStream2String(r10.openFileInput(r11[r12]));     // Catch: Exception -> L20
        if (r5.getBytes().length > 204800) goto L9;
        r12 = r12 + 1;
        goto L26
    L9:
        int r13 = r5.lastIndexOf("&*&");     // Catch: Exception -> L20
        boolean r14 = true;
        if (r13 == (-1)) goto L12;
        boolean r15 = true;
    L13:
        if (r13 != 0) goto L17;
        r14 = false;
    L17:
        if ((r15 & r14) == false) goto L30;
        return r5.substring(0, r13);
    L30:
        return r5;
    L12:
        r15 = false;
        goto L13
    L22:
        return r5;
    }

    public static String[] getCrashLogs(Context r5) {
        return r5.getFilesDir().list(new AnonymousClass1());
    }

    public static String getDeviceId(Context r14) {
        List<String> r5 = getAllImei(r14);
        if (r5 != null) goto L5;
    L23:
        String r10 = getImei(r14);
        NeoLog.i("luzhi", "onlyimei " + r10);
        if (Long.valueOf(r10).longValue() != 0) goto L30;
        boolean r11 = true;
        long r12 = 0;
    L32:
        if (r12 != 0) goto L35;
        r12 = 0;
    L35:
        String r13 = getDeviceModel();
        if (TextUtils.isEmpty(r13) == false) goto L39;
        r13 = getBuildId();
    L39:
        if (r13 != null) goto L51;
        SharedPreferences r15 = r14.getSharedPreferences(Constant.SaveDeviceID, 0);
        String r16 = r15.getString("uuid", "");
        if (r16 != null) goto L43;
    L45:
        r16 = getUUID();
        SharedPreferences.Editor r17 = r15.edit();
        r17.putString("uuid", r16);
        r17.apply();
    L44:
        r13 = r16;
        if (r13 != null) goto L48;
    L50:
        r13 = "nubia";
        goto L51
    L48:
        if (r13.equals("") == true) goto L50;
    L43:
        if (r16.equals("") == true) goto L45;
    L51:
        StringBuilder r18 = j0.t(r12, "getDeviceId:", "_");
        r18.append(r13.hashCode());
        NeoLog.e(r18.toString());
        if (r12 != 0) goto L54;
        if (r10 != null) goto L57;
    L61:
        String r19 = getAndroidId(r14);
        if (r19 != null) goto L64;
    L67:
        SharedPreferences r110 = r14.getSharedPreferences(Constant.SaveDeviceID, 0);
        String r20 = r110.getString("uuid", "");
        if (r20 != null) goto L70;
    L72:
        r20 = getUUID();
        SharedPreferences.Editor r111 = r110.edit();
        r111.putString("uuid", r20);
        r111.apply();
    L74:
        return String.valueOf(r20) + "_" + r13.hashCode();
    L70:
        if (r20.equals("") == true) goto L72;
    L64:
        if (r19.equals("") == true) goto L67;
        return r19 + "_" + r13.hashCode();
    L57:
        if (r10.length() <= 10) goto L61;
        if (r11 == true) goto L61;
        return r10 + "_" + r13.hashCode();
    L54:
        return String.valueOf(r12) + "_" + r13.hashCode();
    L30:
        r12 = 0;
    L10:
        r11 = false;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L5:
        if (r5.size() <= 0) goto L23;
        r12 = 0;
        int r21 = 0;
    L8:
        if (r21 >= r5.size()) goto L9;
        long r22 = Long.parseLong(r5.get(r21));     // Catch: Exception -> L20
        if (r12 != 0) goto L16;
    L18:
        if (r12 != 0) goto L22;
    L19:
        r12 = r22;
    L22:
        r21 = r21 + 1;
        goto L8
    L16:
        if (r22 >= r12) goto L18;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L9:
        r10 = "";
        goto L10
    }

    private static DeviceId getDeviceIdType(Context r5) {
        if (mDid != null) goto L13;
        Uri r10 = Uri.parse("content://cn.nubia.provider.deviceid.dataid/grndid");
        Uri r11 = Uri.parse(PROVIDER_URI_ZTE_PUSH);
        if (r5.getPackageManager().resolveContentProvider(r11.getAuthority(), 0) == null) goto L9;
        NeoLog.i("NeoPushZteClient", "getDeviceId deviceId zte provider =content://cn.nubia.provider.deviceid.dataid.zte/grndid");
        DeviceId r12 = new DeviceId("content://cn.nubia.provider.deviceid.dataid.zte/grndid?mids&&altoaid&udid", 1);
        mDid = r12;
        return r12;
    L9:
        if (r5.getPackageManager().resolveContentProvider(r10.getAuthority(), 0) == null) goto L13;
        NeoLog.i("NeoPushZteClient", "getDeviceId deviceId nubia provider =content://cn.nubia.provider.deviceid.dataid/grndid");
        DeviceId r13 = new DeviceId("content://cn.nubia.provider.deviceid.dataid/grndid?mids&&altoaid&udid", 1);
        mDid = r13;
        return r13;
    L13:
        return mDid;
    }

    public static String getDeviceInternal() {
        Class<?> r5 = Class.forName("android.os.SystemProperties");     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        String r10 = (String) r5.getDeclaredMethod("get", new Class[]{String.class, String.class}).invoke(r5, new Object[]{"ro.build.internal.id", ""});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
    L19:
        if (TextUtils.isEmpty(r10) == false) goto L22;
        return "unKnown";
    L22:
        return r10;
    L11:
        e = move-exception;
        e.printStackTrace();
    L17:
        r10 = "unKnown";
    L5:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String getDeviceManufature() {
        StringBuilder r5 = new StringBuilder("getDeviceManufature:");
        String r10 = Build.MANUFACTURER;
        r5.append(r10);
        NeoLog.i(r5.toString());
        return r10;
    }

    public static String getDeviceModel() {
        StringBuilder r5 = new StringBuilder("getDeviceModel:");
        String r10 = Build.MODEL;
        r5.append(r10);
        NeoLog.i(r5.toString());
        return r10;
    }

    public static String getErrorinfo(Throwable r5) {
        StringWriter r10 = new StringWriter();
        PrintWriter r11 = new PrintWriter(r10);
        Throwable r12 = r5.getCause();
        NeoLog.i("luzhi", "error total " + r5.getMessage());
        if (r12 == null) goto L5;
    L4:
        r12.printStackTrace(r11);
        r12 = r12.getCause();
        NeoLog.i("luzhi", "error cause " + r12.getMessage());
        goto L4
    L5:
        r5.printStackTrace(r11);
        r11.close();
        String r13 = r10.toString();
        NeoLog.i("luzhi", "error result" + r13);
        return r13;
    }

    public static long getFirstUploadTime(Context r5) {
        return r5.getSharedPreferences(Constant.SaveCrashLog, 0).getLong("firstuploadTime", 0);
    }

    public static String getHasSavedDeviceID(Context r5) {
        String r10 = r5.getSharedPreferences(Constant.SaveDeviceID, 0).getString("DeviceIDs", "");
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.equals("") == true) goto L9;
        return r10;
    L9:
        return null;
    }

    public static String getHasSavedSDKDeviceID(Context r5) {
        String r10 = r5.getSharedPreferences(Constant.SaveDeviceID, 0).getString("SDKDeviceIDs", "");
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.equals("") == true) goto L9;
        return r10;
    L9:
        return null;
    }

    public static String[] getHaveUploadLogs(Context r10, String[] r11) {
        String r5 = "";
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L31:
        if (r13 >= r11.length) goto L19;
        r5 = r5 + "&*&" + InputStream2String(r10.openFileInput(r11[r13]));     // Catch: Exception -> L30
        if (r5.getBytes().length > 204800) goto L9;
        r14 = r13 + 1;
        r13 = r14;
        goto L31
    L9:
        int r15 = r5.lastIndexOf("&*&");     // Catch: Exception -> L30
        boolean r16 = true;
        if (r15 == (-1)) goto L12;
        boolean r17 = true;
    L13:
        if (r15 != 0) goto L17;
        r16 = false;
    L17:
        if ((r17 & r16) == false) goto L19;
        r5.substring(0, r15);     // Catch: Exception -> L30
        goto L19
    L12:
        r17 = false;
    L19:
        if (r14 == 0) goto L28;
        String[] r18 = new String[r14];     // Catch: Exception -> L30
    L21:
        if (r12 >= r14) goto L22;
        int r19 = r12 + 1;     // Catch: Exception -> L30
        if (r11.length < r19) goto L26;
        r18[r12] = r11[r12];     // Catch: Exception -> L30
    L26:
        r12 = r19;
        goto L21
    L22:
        return r18;
    L28:
        return null;
    L38:
        return null;
    }

    public static String getImei(Context r5) {
        return "";
    }

    private static int getIpFromNetworkInterface() {
        int r5 = 0;
        Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L17
    L5:
        if (r10.hasMoreElements() == false) goto L19;
        Enumeration<InetAddress> r11 = r10.nextElement().getInetAddresses();     // Catch: Exception -> L17
    L9:
        if (r11.hasMoreElements() == false) goto L5;
        InetAddress r12 = r11.nextElement();     // Catch: Exception -> L17
        if (r12.isLoopbackAddress() == true) goto L9;
        if ((r12 instanceof Inet4Address) == false) goto L9;
        r5 = bytesToInt(r12.getAddress());     // Catch: Exception -> L17
    L19:
        NeoLog.i("getIpFromNetworkInterface:" + r5);
        return r5;
    L17:
        e = move-exception;
        NeoLog.e("getIpFromNetworkInterface  " + e.toString());
        goto L19
    }

    private static int getIpFromWifi(Context r5) {
        WifiInfo r10 = ((WifiManager) r5.getApplicationContext().getSystemService("wifi")).getConnectionInfo();     // Catch: Exception -> L6
        if (r10 == null) goto L8;
        int r11 = r10.getIpAddress();     // Catch: Exception -> L6
    L9:
        NeoLog.i("getIp:" + r11);
        return r11;
    L8:
        r11 = 0;
    L6:
        e = move-exception;
        NeoLog.e("getIpFromWifi  " + e.toString());
        goto L8
    }

    public static long getLastLogsUploadTime(Context r5) {
        return r5.getSharedPreferences(Constant.SaveCrashLog, 0).getLong("time", 0);
    }

    public static long getLastRequestUpdateTime(Context r5) {
        addWhiteList();
        long r10 = r5.getSharedPreferences(Constant.SaveCrashLog, 0).getLong("RequestUpdateTime", 0);
        resumeWhiteList();
        return r10;
    }

    public static long getLastUploadVersionTime(Context r5) {
        return r5.getSharedPreferences(Constant.SaveCrashLog, 0).getLong("UploadVersionTime", 0);
    }

    public static String getMEID(Context r5) {
        return "";
    }

    private static String getMacAddress(Context r5) {
        return getMacHighM();
    }

    public static String getMacHighM() {
        StringBuilder r5 = new StringBuilder();
        byte[] r10 = NetworkInterface.getByName("wlan0").getHardwareAddress();     // Catch: Exception -> L12
        if (r10 != null) goto L7;
        return "";
    L7:
        int r11 = r10.length;     // Catch: Exception -> L12
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        r5.append(String.format("%02X:", new Object[]{Byte.valueOf(r10[r12])}));     // Catch: Exception -> L12
        r12 = r12 + 1;
        goto L8
    L10:
        if (r5.length() <= 0) goto L17;
        r5.deleteCharAt(r5.length() - 1);     // Catch: Exception -> L12
    L17:
        NeoLog.i("getMacHighM:" + r5.toString());
        return r5.toString();
    L12:
        e = move-exception;
        NeoLog.e("getMacHighM  " + e.toString());
        goto L17
    }

    public static String getMacLowM(Context r5) {
        String r10 = "unknown";
        WifiInfo r11 = ((WifiManager) r5.getApplicationContext().getSystemService("wifi")).getConnectionInfo();     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        String r12 = r11.getMacAddress();     // Catch: Exception -> L7
    L21:
        if (TextUtils.isEmpty(r12) == true) goto L17;
        r10 = r12;
    L17:
        NeoLog.i("getMacLowM:" + r10);
        return r10;
    L14:
        e = move-exception;
        r10 = r12;
        e = e;
    L16:
        NeoLog.e("getMacLowM  " + e.toString());
        goto L17
    L9:
        r12 = "unknown";
    L7:
        e = e;
        goto L16
    }

    public static int getNubiaId(Context r5) {
        AccountManager r10 = AccountManager.get(r5);     // Catch: Exception -> L13
        Account[] r11 = r10.getAccountsByType(Constant.NUBIA_ACCOUNT_TYPE);     // Catch: Exception -> L13
        if (r11 != null) goto L6;
    L8:
        String r12 = null;
    L10:
        if (TextUtils.isEmpty(r12) == false) goto L16;
        return Integer.parseInt(r12);
    L16:
        return 0;
    L6:
        if (r11.length <= 0) goto L8;
        r12 = r10.getUserData(r11[0], Constant.NUBIA_ACCOUNT_FIELD_USER_ID);     // Catch: Exception -> L13
        NeoLog.e("getNubiaId uid:" + r12);     // Catch: Exception -> L13
    L17:
        return 0;
    }

    public static String getNubiaUid(Context r5) {
        String r10 = null;
        AccountManager r11 = AccountManager.get(r5);     // Catch: Exception -> L9
        Account[] r12 = r11.getAccountsByType(Constant.NUBIA_ACCOUNT_TYPE);     // Catch: Exception -> L9
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.length <= 0) goto L15;
        r10 = r11.getUserData(r12[0], Constant.NUBIA_ACCOUNT_FIELD_USER_ID);     // Catch: Exception -> L9
        NeoLog.e("getNubiaId uid:" + r10);     // Catch: Exception -> L9
        return r10;
    L15:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    public static String getOaid(Context r5) {
        if (TextUtils.isEmpty(mOaid) == false) goto L5;
        DeviceId r10 = getDeviceIdType(r5);
        if (r10 != null) goto L9;
        return "";
    L9:
        r10.refresh(r5, true, false);
        String r11 = r10.getALTID();
        mOaid = r11;
        if (r11 != null) goto L12;
        mOaid = "";
    L12:
        NeoLog.i("NeoPushZteClient", "getOaid mOaid =" + mOaid);
        return mOaid;
    L5:
        return mOaid;
    }

    public static int getPackageCode(Context r5, String r10) {
        int r11 = 0;
        PackageInfo r12 = r5.getPackageManager().getPackageInfo(r10, 16384);     // Catch: PackageManager.NameNotFoundException -> L5
        r11 = r12.versionCode;     // Catch: PackageManager.NameNotFoundException -> L5
        NeoLog.i("luzhi", "neopush packageinfo  " + r12.versionCode + "   " + r12.packageName);     // Catch: PackageManager.NameNotFoundException -> L5
        return r11;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r11;
    }

    public static PackageInfo getPackageInfo(Context r5, String r10) {
        return r5.getApplicationContext().getPackageManager().getPackageInfo(r10, 16384);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getPackageVersionName(Context r5, String r10) {
        return r5.getPackageManager().getPackageInfo(r10, 16384).versionName;
    L5:
        return "";
    }

    public static ComponentName getPushServiceComponentName(Context r5) {
        if (r5 == null) goto L9;
        if (Constant.CONTROL_APP_PACKAGES_NAME.equals(r5.getPackageName()) == false) goto L9;
        return new ComponentName(Constant.CONTROL_APP_PACKAGES_NAME, "cn.nubia.neopush.service.NeoPushService");
    L9:
        if (r5 == null) goto L15;
        if ("com.zte.aliveupdate".equals(r5.getPackageName()) == false) goto L15;
        return new ComponentName("com.zte.aliveupdate", "cn.nubia.neopush.service.NeoPushService");
    L15:
        if (r5 == null) goto L21;
        if ("com.zte.dbneopush".equals(r5.getPackageName()) == false) goto L21;
        return new ComponentName("com.zte.dbneopush", "cn.nubia.neopush.service.NeoPushService");
    L21:
        if (shouldUseNubiaPush(r5) == false) goto L25;
        return new ComponentName(Constant.CONTROL_APP_PACKAGES_NAME, "cn.nubia.neopush.service.NeoPushService");
    L25:
        if (shouldUseNewZtePush(r5) == false) goto L29;
        return new ComponentName("com.zte.dbneopush", "cn.nubia.neopush.service.NeoPushService");
    L29:
        if (shouldUseZtePush(r5) == false) goto L33;
        return new ComponentName("com.zte.aliveupdate", "cn.nubia.neopush.service.NeoPushService");
    L33:
        return new ComponentName(r5.getPackageName(), "cn.nubia.neopush.service.NeoPushService");
    }

    public static String getSolidDeviceID(Context r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        addWhiteList();
        if (isHasDeviceID(r5) == true) goto L8;
        String r10 = getDeviceId(r5);
    L9:
        resumeWhiteList();
        return r10;
    L8:
        r10 = getHasSavedDeviceID(r5);
        goto L9
    }

    public static String getUUID() {
        String r5 = getmd5(UUID.randomUUID().toString().replaceAll(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, ""));
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length() > 24) goto L7;
        return null;
    L7:
        return r5.substring(8, 24);
    }

    public static String getUiVersion() {
        String r5 = "unknown";
        Class<?> r10 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        r5 = (String) r10.getDeclaredMethod("get", new Class[]{String.class, String.class}).invoke(r10, new Object[]{"ro.build.rom.id", "unknown"});     // Catch: Exception -> L5
    L7:
        NeoLog.e("getUiVersion:" + r5);
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static int getUploadCrashLogMin(Context r5) {
        return r5.getSharedPreferences(Constant.SaveCrashLog, 0).getInt("hour", -1);
    }

    private static String getVaid(Context r5) {
        if (TextUtils.isEmpty(mVaid) == false) goto L5;
        DeviceId r10 = getDeviceIdType(r5);
        if (r10 != null) goto L9;
        return "";
    L9:
        r10.refresh(r5, true, false);
        mVaid = r10.getRemoteRNDID();
        NeoLog.i("NeoPushZteClient", "getVaid mVaid =" + mVaid);
        if (mVaid != null) goto L13;
        mVaid = "";
    L13:
        return mVaid;
    L5:
        return mVaid;
    }

    public static String getmd5(String r10) {
        char[] r5 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] r11 = r10.getBytes();     // Catch: Exception -> L7
        MessageDigest r12 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L7
        r12.update(r11);     // Catch: Exception -> L7
        byte[] r13 = r12.digest();     // Catch: Exception -> L7
        int r14 = r13.length;     // Catch: Exception -> L7
        char[] r15 = new char[r14 * 2];     // Catch: Exception -> L7
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r16 >= r14) goto L5;
        byte r18 = r13[r16];     // Catch: Exception -> L7
        int r19 = r17 + 1;     // Catch: Exception -> L7
        r15[r17] = r5[(r18 >>> 4) & 15];     // Catch: Exception -> L7
        r17 = r17 + 2;     // Catch: Exception -> L7
        r15[r19] = r5[r18 & 15];     // Catch: Exception -> L7
        r16 = r16 + 1;
        goto L4
    L5:
        return new String(r15);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean isAppInstall(Context r5, String r10) {
        if (getPackageInfo(r5, r10) == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isAppRuning(Context r10, String r11) {
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();
    L3:
        int r5 = 0;
        if (r12.hasNext() == false) goto L5;
        String[] r13 = r12.next().pkgList;
        boolean r14 = false;
    L8:
        if (r5 >= r13.length) goto L9;
        NeoLog.i("luzhi", "get progress package name " + r13[r5]);
        String r15 = r13[r5];
        if (r15 == null) goto L17;
        if (r15.equals(r11) == false) goto L17;
        r14 = true;
    L17:
        r5 = r5 + 1;
        goto L8
    L9:
        if (r14 == false) goto L3;
        NeoLog.i("luzhi", String.valueOf(r11).concat("   isrunning"));
        return true;
    L5:
        return false;
    }

    public static boolean isCanUpload(Context r5) {
        return r5.getSharedPreferences(Constant.SaveCrashLog, 0).getBoolean("iscanupload", false);
    }

    public static boolean isChargeing(Context r5) {
        if (r5 == null) goto L9;
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.BATTERY_CHANGED");
        Intent r11 = r5.registerReceiver(null, r10);
        if (r11 == null) goto L9;
        if (r11.getIntExtra(NotificationCompat.CATEGORY_STATUS, 1) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isDeviceChange(Context r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        SharedPreferences r5 = r10.getSharedPreferences(Constant.SP_FILE_NAME, 0);
        String r11 = r5.getString(Constant.DEVICE_INFO_DEVICE_BRAND, "");
        String r12 = r5.getString(Constant.DEVICE_INFO_IMEI, "");
        String r13 = r5.getString(Constant.DEVICE_INFO_MODEL, "");
        String r14 = r5.getString(Constant.DEVICE_INFO_OS_VERSION, "");
        String r15 = r5.getString(Constant.DEVICE_INFO_SOFTWARE, "");
        String r16 = r5.getString(Constant.DEVICE_INFO_UI_VERSION, "");
        if (TextUtils.equals(r11, getDeviceManufature()) == true) goto L8;
    L18:
        return true;
    L8:
        if (TextUtils.equals(r12, getImei(r10)) == false) goto L18;
        if (TextUtils.equals(r13, getDeviceModel()) == false) goto L18;
        if (TextUtils.equals(r14, getAndroidVersion()) == false) goto L18;
        if (TextUtils.equals(r15, getDeviceInternal()) == false) goto L18;
        if (TextUtils.equals(r16, getUiVersion()) == false) goto L18;
        return false;
    }

    public static boolean isGameRunning(Context r5) {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("cn.nubia.action.GAME_MODE");
        Intent r11 = r5.registerReceiver(null, r10);
        if (r11 == null) goto L6;
        NeoLog.i("luzhi", "game runnig is " + r11.getBooleanExtra("isRunning", false));
        return r11.getBooleanExtra("isRunning", false);
    L6:
        NeoLog.i("luzhi", "Cannot read Game Mode");
        return false;
    }

    public static boolean isHasDeviceID(Context r5) {
        String r10 = r5.getSharedPreferences(Constant.SaveDeviceID, 0).getString("DeviceIDs", "");
        if (r10 != null) goto L5;
    L10:
        return false;
    L5:
        if (r10.equals("") == true) goto L10;
        if (r10.startsWith("0_") == true) goto L10;
        return true;
    }

    public static boolean isHasLock() {
        PowerManager.WakeLock r5 = wakelock;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isHeld() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isHasSDKDeviceID(Context r5) {
        String r10 = r5.getSharedPreferences(Constant.SaveDeviceID, 0).getString("SDKDeviceIDs", "");
        if (r10 != null) goto L5;
    L10:
        return false;
    L5:
        if (r10.equals("") == true) goto L10;
        if (r10.startsWith("0_") == true) goto L10;
        return true;
    }

    public static boolean isKeyguardLocked(Context r5) {
        return !((PowerManager) r5.getSystemService("power")).isScreenOn();
    }

    public static boolean isNight() {
        long r5 = System.currentTimeMillis();
        Calendar r10 = Calendar.getInstance();
        r10.setTime(new Date(r5));
        int r11 = r10.get(11);
        NeoLog.e("llxie", "isNight " + r11);
        if (r11 >= 6) goto L5;
        return true;
    L5:
        if (r11 > 22) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isNubiaRom(Context r5) {
        if (isAppInstall(r5, Constant.NUBIA_ACCOUNT_APP_NAME) == false) goto L5;
        return true;
    L5:
        if (getDeviceManufature() != null) goto L7;
        return false;
    L7:
        if ("nubia".toLowerCase().equals(getDeviceManufature().toLowerCase()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isScreenOn(Context r5) {
        return ((PowerManager) r5.getSystemService("power")).isScreenOn();
    }

    public static boolean isSdkChange(Context r5) {
        addWhiteList();
        boolean r10 = false;
        if (217 == r5.getSharedPreferences(Constant.SaveCrashLog, 0).getInt("SDKVersion", 0)) goto L5;
        r10 = true;
    L5:
        resumeWhiteList();
        return r10;
    }

    public static boolean isUploadVersionSuccess(Context r5) {
        addWhiteList();
        boolean r10 = r5.getSharedPreferences(Constant.SaveCrashLog, 0).getBoolean("result", false);
        resumeWhiteList();
        return r10;
    }

    public static Map<String, String> parseExtra(String r5) {
        HashMap r10 = new HashMap();
        JSONObject r11 = new JSONObject(r5);     // Catch: Exception -> L10
        Iterator<String> r12 = r11.keys();     // Catch: Exception -> L10
    L5:
        if (r12.hasNext() == false) goto L9;
        String r13 = r12.next();     // Catch: Exception -> L10
        r10.put(r13, r11.optString(r13));     // Catch: Exception -> L10
    L9:
        return r10;
    }

    public static void releaseLock() {
        PowerManager.WakeLock r5 = wakelock;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isHeld() == false) goto L9;
        NeoLog.i("luzhi", "release lock");
        wakelock.release();
        wakelock = null;
        return;
    }

    public static void resumeWhiteList() {
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equals(Thread.currentThread().getName()) == false) goto L17;
        int r5 = addWhiteListcount - 1;     // Catch: Exception -> L12
        addWhiteListcount = r5;     // Catch: Exception -> L12
        if (r5 != 0) goto L18;
        StrictMode.ThreadPolicy r10 = prepolicy;     // Catch: Exception -> L12
        if (r10 != null) goto L9;
        return;
    L9:
        if (hasresumePolicy == true) goto L20;
        hasresumePolicy = true;     // Catch: Exception -> L12
        StrictMode.setThreadPolicy(r10);     // Catch: Exception -> L12
        return;
    L20:
        return;
    L18:
        return;
    }

    public static void saveDeviceID(Context r5, String r10) {
        SharedPreferences r11 = r5.getSharedPreferences(Constant.SaveDeviceID, 0);
        String r12 = r11.getString("DeviceIDs", "");
        if (r12 != null) goto L5;
    L9:
        SharedPreferences.Editor r13 = r11.edit();
        r13.putString("DeviceIDs", r10);
        r13.commit();
        NeoLog.i("luzhi", "deviceid is null ,deviceid save success");
        return;
    L5:
        if (r12.equals("") == true) goto L9;
        if (r12.startsWith("0_") == true) goto L9;
    }

    public static void saveDeviceID_InSDK(Context r5, String r10) {
        SharedPreferences r11 = r5.getSharedPreferences(Constant.SaveDeviceID, 0);
        String r12 = r11.getString("SDKDeviceIDs", "");
        if (r12 != null) goto L5;
    L9:
        SharedPreferences.Editor r13 = r11.edit();
        r13.putString("SDKDeviceIDs", r10);
        r13.apply();
        NeoLog.i("luzhi", "deviceid is null ,deviceid save success");
        return;
    L5:
        if (r12.equals("") == true) goto L9;
        if (r12.startsWith("0_") == true) goto L9;
    }

    public static void saveDeviceInfo(Context r5) {
        if (r5 == null) goto L5;
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SP_FILE_NAME, 0).edit();
        r10.putString(Constant.DEVICE_INFO_DEVICE_BRAND, getDeviceManufature());
        r10.putString(Constant.DEVICE_INFO_IMEI, getImei(r5));
        r10.putString(Constant.DEVICE_INFO_MODEL, getDeviceModel());
        r10.putString(Constant.DEVICE_INFO_OS_VERSION, getAndroidVersion());
        r10.putString(Constant.DEVICE_INFO_SOFTWARE, getDeviceInternal());
        r10.putString(Constant.DEVICE_INFO_UI_VERSION, getUiVersion());
        r10.commit();
        return;
    }

    public static void setCanUpload(Context r5, boolean r10) {
        SharedPreferences.Editor r11 = r5.getSharedPreferences(Constant.SaveCrashLog, 0).edit();
        r11.putBoolean("iscanupload", r10);
        r11.putLong("firstuploadTime", System.currentTimeMillis());
        r11.commit();
    }

    public static void setLogsUploadTime(Context r5) {
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SaveCrashLog, 0).edit();
        r10.putLong("time", System.currentTimeMillis());
        r10.commit();
    }

    public static void setRequestUpdateTime(Context r5) {
        SharedPreferences.Editor r10 = r5.getSharedPreferences(Constant.SaveCrashLog, 0).edit();
        r10.putLong("RequestUpdateTime", System.currentTimeMillis());
        r10.apply();
    }

    public static void setUploadVersionTime(Context r5, boolean r10) {
        SharedPreferences.Editor r11 = r5.getSharedPreferences(Constant.SaveCrashLog, 0).edit();
        r11.putLong("UploadVersionTime", System.currentTimeMillis());
        r11.putInt("SDKVersion", Constant.SDK_VERSION);
        r11.putBoolean("result", r10);
        r11.commit();
    }

    public static boolean shouldUseNewZtePush(Context r5) {
        boolean r10 = isAppInstall(r5, "com.zte.dbneopush");     // Catch: Exception -> L4
    L6:
        NeoLog.i("shouldUseZtePush = " + r10);
        return r10;
    L4:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L6
    }

    public static boolean shouldUseNubiaPush(Context r5) {
        boolean r10 = isAppInstall(r5, Constant.CONTROL_APP_PACKAGES_NAME);     // Catch: Exception -> L4
    L6:
        NeoLog.i("shouldUseNubiaPush = " + r10);
        return r10;
    L4:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L6
    }

    public static boolean shouldUseZtePush(Context r5) {
        boolean r10 = isAppInstall(r5, "com.zte.aliveupdate");     // Catch: Exception -> L4
    L6:
        NeoLog.i("shouldUseZtePush = " + r10);
        return r10;
    L4:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L6
    }

    public static long toDay(long r5) {
        long r10 = (((long) TimeZone.getDefault().getOffset(r5)) + r5) / MILLIS_IN_DAYS;
        StringBuilder r11 = j0.t(r10, "toDay day:", ",curtime:");
        r11.append(r5);
        NeoLog.i(r11.toString());
        return r10;
    }

    public static void trackAppEvent(Context r5, String r10, String r11, String r12, Bundle r13) {
    }
}
