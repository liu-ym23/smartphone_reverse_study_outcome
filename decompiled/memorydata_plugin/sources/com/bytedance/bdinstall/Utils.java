package com.bytedance.bdinstall;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final char[] HEX_ARRAY = null;
    public static final int MAX_UDID_LENGTH = 128;
    public static final int MIN_UDID_LENGTH = 13;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static volatile Boolean isMainProcess;
    private static boolean isOffsetInstallInfo;
    private static String sProcessName;

    static {
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        isOffsetInstallInfo = false;
    }

    public Utils() {
    }

    public static String bytesToHex(byte[] r6) {
        char[] r0 = new char[r6.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L7;
        int r2 = r6[r1] & 255;
        int r3 = r1 * 2;
        char[] r4 = HEX_ARRAY;
        r0[r3] = r4[r2 >>> 4];
        r0[r3 + 1] = r4[r2 & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    public static boolean checkId(String r5) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r5) == true) goto L18;
        if ("Null".equalsIgnoreCase(r5) == true) goto L18;
        int r0 = 0;
    L10:
        if (r0 >= r5.length()) goto L15;
        if (r5.charAt(r0) != '0') goto L17;
        r0 = r0 + 1;
    L17:
        return !r1;
    L15:
        r1 = true;
        goto L17
    }

    public static void closeSafely(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r3.close();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void copy(JSONObject r5, JSONObject r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L22;
        return;
    L22:
        monitor-enter(DeviceManager.class);     // Catch: JSONException -> L17
        Iterator<String> r1 = r6.keys();     // Catch: Throwable -> L14
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r5.put(r2, r6.opt(r2));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L14
    L25:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        DrLog.ysnp(e);
    }

    public static void enanbleOffsetInstallInfo(boolean r0) {
        isOffsetInstallInfo = r0;
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L9;
        r1 = DEFAULT_CONTENT_CHARSET;
    L9:
        return URLEncoder.encode(r0, r1);
    L7:
        return "";
    }

    public static boolean equal(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        goto L6
    }

    static String format(HashMap<String, String> r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = encode((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r6);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        String r4 = encode(r3, r6);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append(PARAMETER_SEPARATOR);
    L12:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r4);
        goto L4
    L8:
        r4 = "";
        goto L10
    L14:
        return r0.toString();
    }

    static Context getApp(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == true) goto L7;
        if (r3 != null) goto L6;
        return r3;
    L6:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L7:
        return r3;
    }

    public static String getCurrentProcessNameByActivityThread() {
        Method r2 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.memorydata.plugin").getDeclaredMethod("currentProcessName", (Class[]) ZeusTransformUtils.preCheckCast(new Class[0], Class[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        r2.setAccessible(true);     // Catch: Throwable -> L8
        Object r3 = r2.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    L12:
        return null;
    }

    static String getProcessName(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = sProcessName;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        String r1 = Application.getProcessName();
        if (TextUtils.isEmpty(r1) == true) goto L11;
        sProcessName = r1;
        return r1;
    L11:
        String r2 = getCurrentProcessNameByActivityThread();
        if (TextUtils.isEmpty(r2) == true) goto L29;
        sProcessName = r2;
        return r2;
    L29:
        int r3 = Process.myPid();     // Catch: Exception -> L22
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L22
    L17:
        if (r6.hasNext() == false) goto L24;
        ActivityManager.RunningAppProcessInfo r7 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r6.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        if (r7.pid != r3) goto L17;
        sProcessName = r7.processName;     // Catch: Exception -> L22
    L24:
        sProcessName = getProcessNameFromProc();
        if (DrLog.debug() == false) goto L28;
        DrLog.d("getProcessName, " + sProcessName);
    L28:
        return sProcessName;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    private static String getProcessNameFromProc() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L18;
    L14:
        return null;
    L18:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }

    public static boolean isBadId(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return true;
    L6:
        if (r5.equalsIgnoreCase("unknown") == false) goto L9;
        return true;
    L9:
        if (r5.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        if (r5.charAt(r2) != '0') goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return false;
    L21:
        return true;
    }

    public static boolean isMainProcess(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isMainProcess != null) goto L6;
        Objects.requireNonNull(r3, "context is null");
        isMainProcess = Boolean.valueOf(TextUtils.equals(getProcessName(r3), r3.getPackageName()));
    L6:
        return isMainProcess.booleanValue();
    }

    public static boolean isOffsetInstallInfo() {
        return isOffsetInstallInfo;
    }

    public static boolean isValidUDID(String r5) {
        if (r5 == null) goto L5;
        int r1 = r5.length();
    L7:
        if (r1 >= 13) goto L9;
    L31:
        return false;
    L9:
        if (r1 > 128) goto L31;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L29;
        char r3 = r5.charAt(r2);
        if (r3 < '0') goto L18;
        if (r3 > '9') goto L18;
    L27:
        r2 = r2 + 1;
    L18:
        if (r3 < 'a') goto L22;
        if (r3 <= 'f') goto L27;
    L22:
        if (r3 < 'A') goto L26;
        if (r3 <= 'F') goto L27;
    L26:
        if (r3 == '-') goto L27;
        return false;
    L29:
        return true;
    L5:
        r1 = 0;
        goto L7
    }

    public static void putStringIfNotEmpty(JSONObject r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.put(r2, r3);
        return;
    }

    public static void removeSpValues(SharedPreferences r6, String[] r7) {
        SharedPreferences r8 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r6, SharedPreferences.class, "com.obric.memorydata.plugin");
        SharedPreferences.Editor r0 = r8.edit();
        int r1 = r7.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L8;
        String r4 = r7[r2];
        if (r8.contains(r4) == false) goto L7;
        r0.remove(r4);
        r3 = true;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3 == false) goto L14;
        r0.apply();
        return;
    }

    static void setIsMainProcess(boolean r0) {
        isMainProcess = Boolean.valueOf(r0);
    }
}
