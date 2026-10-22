package com.bytedance.bdinstall;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.DeviceManager;
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
    private static String sProcessName;

    static {
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    }

    public Utils() {
    }

    public static String bytesToHex(byte[] r10) {
        char[] r11 = new char[r10.length * 2];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        int r13 = r10[r12] & 255;
        int r14 = r12 * 2;
        char[] r15 = HEX_ARRAY;
        r11[r14] = r15[r13 >>> 4];
        r11[r14 + 1] = r15[r13 & 15];
        r12 = r12 + 1;
        goto L4
    L7:
        return new String(r11);
    }

    public static boolean checkId(String r10) {
        boolean r11 = false;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r10) == true) goto L18;
        if ("Null".equalsIgnoreCase(r10) == true) goto L18;
        int r12 = 0;
    L10:
        if (r12 >= r10.length()) goto L15;
        if (r10.charAt(r12) != '0') goto L17;
        r12 = r12 + 1;
    L17:
        return !r11;
    L15:
        r11 = true;
        goto L17
    }

    public static void closeSafely(Closeable r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void copy(JSONObject r10, JSONObject r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L22;
        return;
    L22:
        monitor-enter(DeviceManager.class);     // Catch: JSONException -> L17
        Iterator<String> r12 = r11.keys();     // Catch: Throwable -> L14
    L10:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();     // Catch: Throwable -> L14
        r10.put(r13, r11.opt(r13));     // Catch: Throwable -> L14
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

    private static String encode(String r10, String r11) {
        if (r11 != null) goto L9;
        r11 = DEFAULT_CONTENT_CHARSET;
    L9:
        return URLEncoder.encode(r10, r11);
    L7:
        return "";
    }

    public static boolean equal(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
    L6:
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.equals(r11) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        goto L6
    }

    static String format(HashMap<String, String> r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<String, String> r14 = r13.next();
        String r15 = encode(r14.getKey(), r11);
        String r16 = r14.getValue();
        if (r16 == null) goto L8;
        String r17 = encode(r16, r11);
    L10:
        if (r12.length() <= 0) goto L12;
        r12.append(PARAMETER_SEPARATOR);
    L12:
        r12.append(r15);
        r12.append(NAME_VALUE_SEPARATOR);
        r12.append(r17);
        goto L4
    L8:
        r17 = "";
        goto L10
    L14:
        return r12.toString();
    }

    static Context getApp(Context r10) {
        if ((r10 instanceof Application) == true) goto L7;
        if (r10 != null) goto L6;
        return r10;
    L6:
        return r10.getApplicationContext();
    L7:
        return r10;
    }

    public static String getCurrentProcessNameByActivityThread() {
        Method r10 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L8
        r10.setAccessible(true);     // Catch: Throwable -> L8
        Object r11 = r10.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        if ((r11 instanceof String) == false) goto L11;
        return (String) r11;
    L11:
        return null;
    L12:
        return null;
    }

    static String getProcessName(Context r10) {
        String r11 = sProcessName;
        if (TextUtils.isEmpty(r11) == true) goto L6;
        return r11;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        String r12 = Application.getProcessName();
        if (TextUtils.isEmpty(r12) == true) goto L11;
        sProcessName = r12;
        return r12;
    L11:
        String r13 = getCurrentProcessNameByActivityThread();
        if (TextUtils.isEmpty(r13) == true) goto L29;
        sProcessName = r13;
        return r13;
    L29:
        int r14 = Process.myPid();     // Catch: Exception -> L22
        Iterator<ActivityManager.RunningAppProcessInfo> r15 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L22
    L17:
        if (r15.hasNext() == false) goto L24;
        ActivityManager.RunningAppProcessInfo r16 = r15.next();     // Catch: Exception -> L22
        if (r16.pid != r14) goto L17;
        sProcessName = r16.processName;     // Catch: Exception -> L22
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
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L16
        if (r12 <= 0) goto L8;
        r11.append((char) r12);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r13 = r11.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Exception -> L15
    L10:
        return r13;
    L12:
        if (r10 != null) goto L22;
    L14:
        return null;
    L22:
        r10.close();     // Catch: Exception -> L17
    L11:
        r10 = null;
        goto L12
    }

    public static boolean isBadId(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return true;
    L6:
        if (r10.equalsIgnoreCase("unknown") == false) goto L9;
        return true;
    L9:
        if (r10.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r11 = 0;
    L13:
        if (r11 >= r10.length()) goto L21;
        if (r10.charAt(r11) != '0') goto L18;
        r11 = r11 + 1;
        goto L13
    L18:
        return false;
    L21:
        return true;
    }

    public static boolean isMainProcess(Context r10) {
        if (isMainProcess != null) goto L6;
        Objects.requireNonNull(r10, "context is null");
        isMainProcess = Boolean.valueOf(TextUtils.equals(getProcessName(r10), r10.getPackageName()));
    L6:
        return isMainProcess.booleanValue();
    }

    public static boolean isValidUDID(String r10) {
        if (r10 == null) goto L5;
        int r11 = r10.length();
    L7:
        if (r11 >= 13) goto L9;
    L31:
        return false;
    L9:
        if (r11 > 128) goto L31;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L29;
        char r13 = r10.charAt(r12);
        if (r13 < '0') goto L18;
        if (r13 > '9') goto L18;
    L27:
        r12 = r12 + 1;
    L18:
        if (r13 < 'a') goto L22;
        if (r13 <= 'f') goto L27;
    L22:
        if (r13 < 'A') goto L26;
        if (r13 <= 'F') goto L27;
    L26:
        if (r13 == '-') goto L27;
        return false;
    L29:
        return true;
    L5:
        r11 = 0;
        goto L7
    }

    public static void putStringIfNotEmpty(JSONObject r10, String r11, String r12) {
        if (TextUtils.isEmpty(r12) == true) goto L6;
        r10.put(r11, r12);
        return;
    }

    public static void removeSpValues(SharedPreferences r10, String[] r11) {
        SharedPreferences.Editor r12 = r10.edit();
        int r13 = r11.length;
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r13) goto L8;
        String r16 = r11[r14];
        if (r10.contains(r16) == false) goto L7;
        r12.remove(r16);
        r15 = true;
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r15 == false) goto L14;
        r12.apply();
        return;
    }

    static void setIsMainProcess(boolean r10) {
        isMainProcess = Boolean.valueOf(r10);
    }
}
