package com.byted.cast.render.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Process;
import android.view.WindowManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Utils {
    private static final String TAG = null;

    public Utils() {
    }

    static {
        TAG = "Utils";
    }

    private static String deviceId() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    private static String getNetworkInterfaceName() {
        return getProperty("wifi.interface", "wlan0");
    }

    public static String osVersion() {
        return Build.VERSION.RELEASE;
    }

    public static boolean checkCameraHardware(Context r1) {
        if (r1.getPackageManager().hasSystemFeature("android.hardware.camera") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static String getAppName(Context r10) {
        ApplicationInfo r0 = r10.getApplicationInfo();
        int r1 = r0.labelRes;
        if (r1 != 0) goto L6;
        return r0.nonLocalizedLabel.toString();
    L6:
        return r10.getString(r1);
    }

    public static String getAppVersion(Context r10) {
        return r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionName;
    L4:
        return "";
    }

    public static int getDeviceDefaultOrientation(Context r10) {
        WindowManager r0 = (WindowManager) r10.getSystemService("window");
        Configuration r11 = r10.getResources().getConfiguration();
        int r1 = r0.getDefaultDisplay().getRotation();
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L10;
    L15:
        return 1;
    L10:
        if (r11.orientation != 1) goto L15;
        return 2;
    L13:
        if (r11.orientation != 2) goto L15;
        return 2;
    }

    public static String getDeviceId(Context r10) {
        SharedPreferences r11 = r10.getSharedPreferences("bytelink", 0);
        String r12 = r11.getString("deviceId", "");
        if ("".equals(r12) == false) goto L6;
        String r13 = deviceId();
        SharedPreferences.Editor r14 = r11.edit();
        r14.putString("deviceId", r13);
        r14.apply();
        return r13;
    L6:
        return r12;
    }

    public static int getDeviceRotationDegree(Context r1) {
        int r10 = getDisplayDefaultRotation(r1);
        if (r10 != 1) goto L5;
        return 90;
    L5:
        if (r10 != 2) goto L7;
        return 180;
    L7:
        if (r10 == 3) goto L10;
        return 0;
    L10:
        return 270;
    }

    public static int getDisplayDefaultRotation(Context r1) {
        return ((WindowManager) r1.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static String getPackageName(Context r10) {
        return r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).packageName;
    L4:
        return "";
    }

    public static Point getScreenSize(Context r10) {
        Point r0 = new Point();
        ((WindowManager) r10.getSystemService("window")).getDefaultDisplay().getRealSize(r0);
        return r0;
    }

    public static boolean isLandscape(Context r1) {
        Point r10 = getScreenSize(r1);
        if (r10.x <= r10.y) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isSystemApp(Context r10) {
        if ((r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).applicationInfo.flags & 1) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static String getProperty(String r10, String r11) {
        String r12 = (String) ReflectMethods.invokeStaticMethod("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{r10, r11});
        Logger.i(TAG, "getProp, version is: " + Build.VERSION.SDK_INT + " platform: " + r12);
        return r12;
    }

    public static boolean hasPermission(Context r10, String r11) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (com_byted_cast_render_utils_Utils_android_content_Context_checkPermission(r10, r11, Process.myPid(), Process.myUid()) != 0) goto L6;
        return true;
    }

    private static int com_byted_cast_render_utils_Utils_android_content_Context_checkPermission(Context r18, String r19, int r20, int r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, Integer.valueOf(r20), Integer.valueOf(r21)};
        b r11 = new b("auto_cert_com_byted_cast_render_utils_Utils_android_content_Context_checkPermission");
        a r10 = (a) ApiHookConfig.b.get(102607);
        if (r10 == null) goto L5;
        f06.a[] r12 = r10.i;
    L6:
        f06.a[] r15 = r12;
        int r13 = r15.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L15;
        f06.a r16 = r15[r14];
        int r17 = r14;
        int r110 = r13;
        d r22 = r16.preInvoke(102607, "android/content/Context", "checkPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r22.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L22
    L17:
        if (r22.a == false) goto L21;
        return ((Integer) r22.b).intValue();
    L21:
        return r18.checkPermission(r19, r20, r21);
    L14:
        r14 = r17 + 1;
        r13 = r110;
        goto L8
    L15:
        r22 = new d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
