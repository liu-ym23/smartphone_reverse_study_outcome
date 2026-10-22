package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class k {
    private static ConcurrentHashMap<String, com.tencent.a.a.a> a;

    public k() {
    }

    public static String a(int r1) {
        if (r1 != 10103) goto L7;
        return "shareToQQ";
    L7:
        if (r1 != 10104) goto L11;
        return "shareToQzone";
    L11:
        if (r1 != 10105) goto L15;
        return "addToQQFavorites";
    L15:
        if (r1 != 10106) goto L19;
        return "sendToMyComputer";
    L19:
        if (r1 != 10107) goto L23;
        return "shareToTroopBar";
    L23:
        if (r1 != 11101) goto L27;
        return "action_login";
    L27:
        if (r1 != 10100) goto L31;
        return "action_request";
    L31:
        if (r1 == 10114) goto L34;
        return null;
    L34:
        return "action_common_channel";
    }

    private static boolean b() {
        return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
    L8:
        return false;
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a() {
        a.clear();
    }

    private static String c() {
        String r0 = com.tencent.open.b.b.b();
        if (r0 != null) goto L5;
    L6:
        SLog.e("openSDK_LOG.SystemUtils", "getAppId error: " + r0);
    L7:
        return r0;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    public static String a(Activity r5) {
        ApplicationInfo r6 = r5.getPackageManager().getApplicationInfo(r5.getApplicationContext().getPackageName(), 128);     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L8
        SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + r6.sourceDir);     // Catch: Exception -> L5 PackageManager.NameNotFoundException -> L8
        return r6.sourceDir;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
        return null;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "Exception", e);
        return null;
    }

    public static int b(String r1) {
        if ("shareToQQ".equals(r1) == false) goto L7;
        return 10103;
    L7:
        if ("shareToQzone".equals(r1) == false) goto L11;
        return 10104;
    L11:
        if ("addToQQFavorites".equals(r1) == false) goto L15;
        return 10105;
    L15:
        if ("sendToMyComputer".equals(r1) == false) goto L19;
        return 10106;
    L19:
        if ("shareToTroopBar".equals(r1) == false) goto L23;
        return 10107;
    L23:
        if ("action_login".equals(r1) == false) goto L27;
        return 11101;
    L27:
        if ("action_request".equals(r1) == false) goto L30;
        return 10100;
    L30:
        return -1;
    }

    public static boolean c(Context r3) {
        if (g(r3, "com.tencent.mobileqq") == false) goto L7;
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
        return true;
    L7:
        if (g(r3, "com.tencent.tim") == false) goto L11;
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
        return true;
    L11:
        if (g(r3, "com.tencent.minihd.qq") == false) goto L14;
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
        return true;
    L14:
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
        return false;
    }

    public static boolean d(Context r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getApplicationInfo().targetSdkVersion >= 29) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT >= 29) goto L10;
        return false;
    L10:
        if (b() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public static String a(Context r1) {
        return r1.getApplicationInfo().loadLabel(r1.getPackageManager()).toString();
    }

    public static boolean b(Context r2) {
        boolean r3 = g(r2, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + r3);
        return r3;
    }

    public static void a(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        a.remove(r1);
    }

    public static boolean a(Context r5, Intent r6) {
        boolean r1 = true;
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        List<ResolveInfo> r7 = r5.getPackageManager().queryIntentActivities(r6, 0);
        if (r7 != null) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == true) goto L18;
        StringBuilder r2 = new StringBuilder("isActivityExist false. result=");
        if (r7 != null) goto L16;
        Object r8 = "null";
    L17:
        r2.append(r8);
        r2.append(" Intent= ");
        r2.append(r6);
        SLog.e("openSDK_LOG.SystemUtils", r2.toString());
        goto L18
    L16:
        r8 = Integer.valueOf(r7.size());
    L18:
        return r1;
    L9:
        if (r7.size() <= 0) goto L11;
    L19:
        StringBuilder r3 = new StringBuilder("isActivityExist params error! [");
        if (r5 != null) goto L22;
        boolean r9 = true;
    L23:
        r3.append(r9);
        r3.append(",");
        if (r6 == null) goto L27;
        r1 = false;
    L27:
        r3.append(r1);
        r3.append("]");
        SLog.e("openSDK_LOG.SystemUtils", r3.toString());
        return false;
    L22:
        r9 = false;
        goto L23
    }

    public static String b(Context r8, String r9) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String r3 = BuildConfig.FLAVOR;
        String r5 = r8.getPackageName();     // Catch: Exception -> L5
        Signature[] r10 = r8.getPackageManager().getPackageInfo(r5, 64).signatures;     // Catch: Exception -> L5
        MessageDigest r6 = MessageDigest.getInstance(EncriptUtils.KEY_MD5);     // Catch: Exception -> L5
        r6.update(r10[0].toByteArray());     // Catch: Exception -> L5
        String r11 = m.a(r6.digest());     // Catch: Exception -> L5
        r6.reset();     // Catch: Exception -> L5
        SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + r11);     // Catch: Exception -> L5
        r6.update(m.j(r5 + "_" + r11 + "_" + r9 + BuildConfig.FLAVOR));     // Catch: Exception -> L5
        r3 = m.a(r6.digest());     // Catch: Exception -> L5
        r6.reset();     // Catch: Exception -> L5
        StringBuilder r12 = new StringBuilder("-->signEncryped: ");     // Catch: Exception -> L5
        r12.append(r3);     // Catch: Exception -> L5
        SLog.v("openSDK_LOG.SystemUtils", r12.toString());     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
        return r3;
    }

    public static boolean c(Context r4, Intent r5) {
        boolean r0 = false;
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        ComponentName r6 = r5.getComponent();
        if (r6 != null) goto L10;
        SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
        return false;
    L10:
        String r7 = r6.getPackageName();
        String r8 = a(r4, r7);
        if (r8 != null) goto L13;
    L15:
        SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + r7 + ", appVersionName= " + r8);
        goto L16
    L13:
        if (r8.isEmpty() == true) goto L15;
        r0 = true;
    L16:
        return r0;
    }

    public static int d(Context r1, String r2) {
        return a(a(r1, "com.tencent.tim"), r2);
    }

    private static PackageInfo e(Context r3, String r4) {
        if (r3 == null) goto L26;
        if (r4 == null) goto L26;
        monitor-enter(k.class);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (a.containsKey(r4) == false) goto L20;
        com.tencent.a.a.a r5 = a.get(r4);     // Catch: Throwable -> L23
        if (r5 != null) goto L15;
        SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");     // Catch: Throwable -> L23
        monitor-exit(k.class);     // Catch: Throwable -> L23
        return null;
    L15:
        PackageInfo r6 = r5.b;     // Catch: Throwable -> L23
        if (r6 != null) goto L18;
        SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");     // Catch: Throwable -> L23
    L18:
        monitor-exit(k.class);     // Catch: Throwable -> L23
        return r6;
    L20:
        PackageInfo r7 = f(r3, r4);     // Catch: Throwable -> L23
        a.put(r4, new com.tencent.a.a.a(r4, r7));     // Catch: Throwable -> L23
        monitor-exit(k.class);     // Catch: Throwable -> L23
        return r7;
    L26:
        return null;
    }

    private static PackageInfo f(Context r3, String r4) {
        PackageInfo r5 = r3.getPackageManager().getPackageInfo(r4, 0);     // Catch: Exception -> L7
        if (r5 != null) goto L6;
        SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + r4);     // Catch: Exception -> L7
    L6:
        return r5;
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e);
        return null;
    }

    private static boolean g(Context r2, String r3) {
        if (h.a(r2, c(), r3) == null) goto L6;
        return true;
    L6:
        if (e(r2, r3) != null) goto L10;
        return false;
    L10:
        return true;
    }

    public static int a(String r8, String r9) {
        if (r8 != null) goto L7;
        if (r9 != null) goto L7;
        return 0;
    L7:
        if (r8 == null) goto L11;
        if (r9 != null) goto L11;
        return 1;
    L11:
        if (r8 != null) goto L14;
        if (r9 == null) goto L14;
        return -1;
    L14:
        String[] r4 = r8.split("\\.");
        String[] r3 = r9.split("\\.");
        int r5 = 0;
    L34:
        if (r5 >= r4.length) goto L26;
        if (r5 >= r3.length) goto L26;
        int r6 = CastIntegerProtector.parseInt(r4[r5]);     // Catch: NumberFormatException -> L32
        int r7 = CastIntegerProtector.parseInt(r3[r5]);     // Catch: NumberFormatException -> L32
        if (r6 < r7) goto L21;
        if (r6 > r7) goto L23;
        r5 = r5 + 1;     // Catch: NumberFormatException -> L32
        goto L34
    L23:
        return 1;
    L21:
        return -1;
    L26:
        if (r4.length <= r5) goto L28;
        return 1;
    L28:
        if (r3.length <= r5) goto L31;
        return -1;
    L31:
        return 0;
    L33:
        return r8.compareTo(r9);
    }

    public static boolean b(Context r2, Intent r3) {
        ArrayList r0 = new ArrayList(3);
        r0.add("com.tencent.mobileqq");
        r0.add("com.tencent.tim");
        if (r2 == null) goto L8;
        if (m.c(r2) == false) goto L8;
        r0.add("com.tencent.minihd.qq");
    L8:
        return a(r2, r3, r0);
    }

    public static int c(Context r1, String r2) {
        return a(a(r1, "com.tencent.mobileqq"), r2);
    }

    public static String a(Activity r7, String r8) {
        if (r7 != null) goto L15;
        SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
        return BuildConfig.FLAVOR;
    L15:
        byte[] r9 = e.a(r8);     // Catch: Exception -> L12
        if (r9 != null) goto L10;
        SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");     // Catch: Exception -> L12
        return BuildConfig.FLAVOR;
    L10:
        byte[] r3 = new byte[8];     // Catch: Exception -> L12
        System.arraycopy(r9, 5, r3, 0, 8);     // Catch: Exception -> L12
        byte[] r6 = new byte[16];     // Catch: Exception -> L12
        System.arraycopy(r9, 8, r6, 0, 16);     // Catch: Exception -> L12
        return e.a(r7.getPackageName(), e.a(r6), r3);
    L12:
        e = move-exception;
        SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
        return BuildConfig.FLAVOR;
    }

    public static String a(Context r2, String r3) {
        String r0 = h.a(r2, c(), r3);
        if (r0 != null) goto L5;
    L8:
        PackageInfo r4 = e(r2, r3);
        if (r4 != null) goto L13;
        SLog.e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + r3);
        return null;
    L13:
        return r4.versionName;
    L5:
        if ("UNKNOWN".equals(r0) == true) goto L8;
        return r0;
    }

    private static long a(InputStream r7, OutputStream r8) throws IOException {
        byte[] r1 = new byte[8192];
        long r2 = 0;
    L3:
        int r5 = r7.read(r1, 0, 8192);
        if (r5 == (-1)) goto L6;
        r8.write(r1, 0, r5);
        r2 = r2 + ((long) r5);
        goto L3
    L6:
        SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + r2);
        return r2;
    }

    public static boolean a(String r10, String r11, int r12) {
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + r10);
        Context r0 = g.a();
        if (r0 != null) goto L6;
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
        return false;
    L6:
        SharedPreferences r3 = r0.getSharedPreferences("secure_lib", 0);
        PolarisFileWrapper r4 = new PolarisFileWrapper(r0.getFilesDir(), r11);
        if (r4.exists() == true) goto L16;
        File r5 = r4.getParentFile();
        if (r5 != null) goto L11;
    L19:
        InputStream r6 = null;
        FileOutputStream r7 = null;
        r7 = null;
        r6 = null;
        InputStream r13 = r0.getAssets().open(r10);     // Catch: Throwable -> L33 Exception -> L35
        r7 = r0.openFileOutput(r11, 0);     // Catch: Throwable -> L29 Exception -> L31
        a(r13, r7);     // Catch: Throwable -> L29 Exception -> L31
        SharedPreferences.Editor r14 = r3.edit();     // Catch: Throwable -> L29 Exception -> L31
        r14.putInt(Keys.API_RETURN_KEY_VERSION, r12);     // Catch: Throwable -> L29 Exception -> L31
        r14.commit();     // Catch: Throwable -> L29 Exception -> L31
        if (r13 != null) goto L66;
    L26:
        if (r7 != null) goto L60;
    L28:
        return true;
    L60:
        r7.close();     // Catch: IOException -> L53
        goto L28
    L66:
        r13.close();     // Catch: IOException -> L25
        goto L26
    L31:
        e = e;
        FileOutputStream r9 = r7;
        r6 = r13;
        FileOutputStream r15 = r9;
    L58:
        SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);     // Catch: Throwable -> L45
        if (r6 != null) goto L68;
    L42:
        if (r15 != null) goto L62;
    L44:
        return false;
    L62:
        r15.close();     // Catch: IOException -> L55
        goto L44
    L68:
        r6.close();     // Catch: IOException -> L41
    L45:
        th = th;
    L46:
        if (r6 != null) goto L70;
    L50:
        if (r15 == null) goto L76;
        r15.close();     // Catch: IOException -> L54
        throw th;
    L77:
        throw th;
    L76:
        throw th;
    L70:
        r6.close();     // Catch: IOException -> L49
    L29:
        th = th;
        FileOutputStream r16 = r7;
        r6 = r13;
        r15 = r16;
        goto L46
    L35:
        e = e;
        r15 = null;
    L33:
        th = th;
        r15 = null;
        goto L46
    L11:
        if (r5.mkdirs() == false) goto L19;
        r4.createNewFile();     // Catch: IOException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L16:
        int r8 = r3.getInt(Keys.API_RETURN_KEY_VERSION, 0);
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + r12 + " | oldVersion: " + r8);
        if (r12 != r8) goto L19;
        return true;
    }

    public static boolean a(Context r5, Intent r6, List<String> r7) {
        boolean r0 = true;
        if (r5 == null) goto L37;
        if (r6 == null) goto L37;
        PackageManager r8 = r5.getPackageManager();
        if (TextUtils.isEmpty(r6.getPackage()) == true) goto L21;
        List<ResolveInfo> r9 = r8.queryIntentActivities(r6, 0);
        if (r9 != null) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == true) goto L20;
        StringBuilder r10 = new StringBuilder("isTargetActivityExist false. result=");
        if (r9 != null) goto L18;
        Object r11 = "null";
    L19:
        r10.append(r11);
        SLog.e("openSDK_LOG.SystemUtils", r10.toString());
        goto L20
    L18:
        r11 = Integer.valueOf(r9.size());
    L20:
        return r0;
    L11:
        if (r9.size() <= 0) goto L13;
    L21:
        if (r7 != null) goto L24;
        SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist params error! targetPackageList is null");
        return false;
    L24:
        Iterator<String> r12 = r7.iterator();
    L26:
        if (r12.hasNext() == false) goto L35;
        String r3 = r12.next();
        if (r3 == null) goto L26;
        r6.setPackage(r3);
        List<ResolveInfo> r4 = r8.queryIntentActivities(r6, 0);
        r6.setPackage(null);
        if (r4 == null) goto L26;
        if (r4.size() <= 0) goto L26;
        return true;
    L35:
        SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist false");
        return false;
    L37:
        StringBuilder r13 = new StringBuilder("isTargetActivityExist params error! [");
        if (r5 != null) goto L40;
        boolean r14 = true;
    L41:
        r13.append(r14);
        r13.append(",");
        if (r6 == null) goto L45;
        r0 = false;
    L45:
        r13.append(r0);
        r13.append("]");
        SLog.e("openSDK_LOG.SystemUtils", r13.toString());
        return false;
    L40:
        r14 = false;
        goto L41
    }

    public static boolean a(Context r3, String r4, String r5) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        Signature[] r6 = r3.getPackageManager().getPackageInfo(r4, 64).signatures;
        int r7 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r7) goto L11;
        if (m.g(r6[r1].toCharsString()).equals(r5) == true) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }
}
