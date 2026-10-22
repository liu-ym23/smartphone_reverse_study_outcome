package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f5553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f5554b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    static {
    }

    public static String a(Context r2) {
        return h((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        th.printStackTrace();
        return f;
    }

    static void a(Context r2, final String r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        f = r3;
        if (r4 == null) goto L9;
        bp.a().b(new AnonymousClass1(r4, r3));
        return;
    }

    public static void a(String r0) {
        d = r0;
    }

    static boolean a() {
        if (f5554b == false) goto L7;
        return true;
    L7:
        if (b(f5553a) == false) goto L11;
        f5554b = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(f5553a) == true) goto L15;
        f5554b = false;     // Catch: Throwable -> L23
        f5553a = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (b(d) == false) goto L19;
        f5554b = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(d) == true) goto L22;
        f5554b = false;     // Catch: Throwable -> L23
        d = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    public static String b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        n.a(th, "AI", "gAN");
    L12:
        return c;
    L4:
        if ("".equals(c) == false) goto L6;
        PackageManager r0 = r4.getPackageManager();     // Catch: Throwable -> L9
        c = (String) ZeusTransformUtils.preCheckCast(r0.getApplicationLabel(r0.getApplicationInfo(r4.getPackageName(), 0)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        goto L12
    L6:
        return c;
    }

    private static boolean b(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L21;
        r6.toCharArray();
        char[] r0 = r6.toCharArray();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L19;
        char r4 = r0[r3];
        if ('A' > r4) goto L11;
        if (r4 > 'z') goto L11;
    L18:
        r3 = r3 + 1;
    L11:
        if ('0' > r4) goto L15;
        if (r4 <= ':') goto L18;
    L15:
        if (r4 == '.') goto L18;
        q.b(fx.a(), r6, "errorPackage");     // Catch: Throwable -> L22
    L17:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        String r0 = d;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L9:
        String r1 = r3.getPackageName();     // Catch: Throwable -> L13
        d = r1;     // Catch: Throwable -> L13
        if (b(r1) == true) goto L16;
        d = r3.getPackageName();     // Catch: Throwable -> L13
    L16:
        return d;
    L6:
        if ("".equals(r0) == true) goto L9;
        return d;
    L13:
        th = move-exception;
        n.a(th, "AI", "gpck");
        goto L16
    }

    public static String d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        n.a(th, "AI", "gAV");
    L11:
        String r5 = e;
        if (r5 != null) goto L14;
        return "";
    L14:
        return r5;
    L4:
        if ("".equals(e) == false) goto L6;
        e = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return e;
    }

    public static String e(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        PackageInfo r0 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 64);     // Catch: Throwable -> L19
        int r2 = 0;
        byte[] r1 = r0.signatures[0].toByteArray();     // Catch: Throwable -> L19
        byte[] r3 = MessageDigest.getInstance(fx.c("IU0hBMQ")).digest(r1);     // Catch: Throwable -> L19
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L19
    L5:
        if (r2 >= r3.length) goto L10;
        String r5 = Integer.toHexString(r3[r2] & 255).toUpperCase(Locale.US);     // Catch: Throwable -> L19
        if (r5.length() != 1) goto L9;
        r4.append("0");     // Catch: Throwable -> L19
    L9:
        r4.append(r5);     // Catch: Throwable -> L19
        r4.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);     // Catch: Throwable -> L19
        r2 = r2 + 1;     // Catch: Throwable -> L19
        goto L5
    L10:
        String r6 = r0.packageName;     // Catch: Throwable -> L19
        if (b(r6) == false) goto L14;
        r6 = r0.packageName;     // Catch: Throwable -> L19
    L14:
        if (TextUtils.isEmpty(d) == true) goto L17;
        r6 = c(r8);     // Catch: Throwable -> L19
    L17:
        r4.append(r6);     // Catch: Throwable -> L19
        String r9 = r4.toString();     // Catch: Throwable -> L19
        f5553a = r9;     // Catch: Throwable -> L19
        return r9;
    L19:
        th = move-exception;
        n.a(th, "AI", "gsp");
        return f5553a;
    }

    public static String f(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        fn.a(r3);     // Catch: Throwable -> L9
    L10:
        return h(r3);
    L6:
        th = move-exception;
        n.a(th, "AI", "gKy");
        return f;
    }

    private static String g(Context r6) {
        File r0 = new File(o.c((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), "k.store"));
        String r1 = "";
        if (r0.exists() == true) goto L46;
        return "";
    L46:
        FileInputStream r2 = new FileInputStream(r0);     // Catch: Throwable -> L18
        byte[] r7 = new byte[r2.available()];     // Catch: Throwable -> L16
        r2.read(r7);     // Catch: Throwable -> L16
        String r8 = fx.a(r7);     // Catch: Throwable -> L16
        if (r8.length() != 32) goto L51;
        r1 = r8;
    L51:
        r2.close();     // Catch: Throwable -> L13
    L15:
        return r1;
    L13:
        th = move-exception;
        th.printStackTrace();
    L16:
        Throwable th = th;
    L48:
        n.a(th, "AI", "gKe");     // Catch: Throwable -> L33
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
    L27:
        if (r2 != null) goto L44;
    L32:
        return "";
    L44:
        r2.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L22:
        if (r0.exists() == false) goto L27;
        r0.delete();     // Catch: Throwable -> L25
    L33:
        th = move-exception;
        if (r2 != null) goto L40;
    L39:
        throw th;
    L40:
        r2.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = move-exception;
        r2 = null;
        th = th;
        goto L48
    }

    private static String h(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = f;
        if (r0 != null) goto L5;
    L6:
        ApplicationInfo r1 = r4.getPackageManager().getApplicationInfo(r4.getPackageName(), 128);
        if (r1 == null) goto L17;
        if (r1.metaData == null) goto L17;
        String r2 = r1.metaData.getString("com.amap.api.v2.apikey");
        f = r2;
        if (r2 != null) goto L15;
        f = g(r4);
    L15:
        return f;
    L17:
        return f;
    L5:
        if (r0.equals("") == false) goto L15;
        goto L6
    }
}
