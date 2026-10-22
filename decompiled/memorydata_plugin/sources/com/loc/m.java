package com.loc;

import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile al f5613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Properties f5614b;

    private m() {
    }

    public static al a() {
        if (f5613a != null) goto L28;
        monitor-enter(m.class);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (f5613a == null) goto L31;
    L22:
        monitor-exit(m.class);     // Catch: Throwable -> L24
        goto L28
    L31:
        al r1 = a(Build.MANUFACTURER);     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r1.a()) == false) goto L18;
        Iterator r2 = Arrays.asList(new String[]{al.f5294a.a(), al.f5295b.a(), al.c.a(), al.d.a(), al.e.a(), al.f.a(), al.g.a(), al.i.a(), al.j.a(), al.k.a(), al.l.a()}).iterator();     // Catch: Exception -> L20 Throwable -> L24
    L13:
        if (r2.hasNext() == false) goto L17;
        al r3 = a((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L20 Throwable -> L24
        if ("".equals(r3.a()) == true) goto L13;
        r1 = r3;
        goto L18
    L17:
        r1 = al.m;     // Catch: Exception -> L20 Throwable -> L24
    L18:
        f5613a = r1;     // Catch: Exception -> L20 Throwable -> L24
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L28:
        return f5613a;
    }

    private static al a(String r1) {
        if (r1 == null) goto L69;
        if (r1.length() <= 0) goto L69;
        if (r1.equalsIgnoreCase(al.f5294a.a()) == false) goto L12;
        al r2 = al.f5294a;
        if (a(r2) == false) goto L67;
        return r2;
    L67:
        return al.m;
    L12:
        if (r1.equalsIgnoreCase(al.f5295b.a()) == false) goto L17;
        al r3 = al.f5295b;
        if (b(r3) == false) goto L67;
        return r3;
    L17:
        if (r1.equalsIgnoreCase(al.c.a()) == false) goto L22;
        al r4 = al.c;
        if (c(r4) == false) goto L67;
        return r4;
    L22:
        if (r1.equalsIgnoreCase(al.d.a()) == false) goto L27;
        al r5 = al.d;
        if (d(r5) == false) goto L67;
        return r5;
    L27:
        if (r1.equalsIgnoreCase(al.e.a()) == false) goto L32;
        al r6 = al.e;
        if (e(r6) == false) goto L67;
        return r6;
    L32:
        if (r1.equalsIgnoreCase(al.f.a()) == false) goto L37;
        al r7 = al.f;
        if (f(r7) == false) goto L67;
        return r7;
    L37:
        if (r1.equalsIgnoreCase(al.g.a()) == false) goto L42;
        al r8 = al.g;
        if (g(r8) == false) goto L67;
        return r8;
    L42:
        if (r1.equalsIgnoreCase(al.h.a()) == false) goto L47;
        al r9 = al.h;
        if (h(r9) == false) goto L67;
        return r9;
    L47:
        if (r1.equalsIgnoreCase(al.i.a()) == false) goto L52;
        al r10 = al.i;
        if (i(r10) == false) goto L67;
        return r10;
    L52:
        if (r1.equalsIgnoreCase(al.j.a()) == false) goto L57;
        al r11 = al.j;
        if (j(r11) == false) goto L67;
        return r11;
    L57:
        if (r1.equalsIgnoreCase(al.k.a()) == false) goto L62;
        al r12 = al.k;
        if (k(r12) == false) goto L67;
        return r12;
    L62:
        if (r1.equalsIgnoreCase(al.l.a()) == false) goto L67;
        al r13 = al.l;
        if (l(r13) == false) goto L67;
        return r13;
    L69:
        return al.m;
    }

    private static void a(al r1, String r2) {
        Matcher r3 = Pattern.compile("([\\d.]+)[^\\d]*").matcher(r2);
        if (r3.find() == true) goto L10;
        return;
    L10:
        String r4 = r3.group(1);     // Catch: Exception -> L7
        r1.a(r4);     // Catch: Exception -> L7
        r1.a(Integer.parseInt(r4.split("\\.")[0]));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private static boolean a(al r1) {
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name")) == true) goto L6;
        String r0 = b("ro.build.version.incremental");
        a(r1, r0);
        r1.b(r0);
        return true;
    L6:
        return false;
    }

    private static String b(String r5) {
        Properties r0 = f5614b;
        String r3 = null;
        if (r0 == null) goto L6;
        r3 = r0.getProperty("[" + r5 + "]", null);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return c(r5);
    L10:
        return r3.replace("[", "").replace("]", "");
    }

    private static boolean b(al r2) {
        String r0 = b("ro.flyme.published");
        String r1 = b("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L9:
        String r3 = b("ro.build.display.id");
        a(r2, r3);
        r2.b(r3);
        return true;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return false;
    }

    private static String c(String r3) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(r3))).getInputStream()), 1024);     // Catch: Throwable -> L9 IOException -> L13
        String r4 = r1.readLine();     // Catch: Throwable -> L7 IOException -> L19
        r1.close();     // Catch: Throwable -> L7 IOException -> L19
        r1.close();     // Catch: IOException -> L17
    L6:
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        if (r0 != null) goto L21;
    L12:
        throw th;
    L21:
        r0.close();     // Catch: IOException -> L18
    L14:
        if (r1 != null) goto L25;
    L16:
        return null;
    L25:
        r1.close();     // Catch: IOException -> L20
        goto L16
    L13:
        r1 = null;
    L9:
        th = th;
        goto L10
    }

    private static boolean c(al r2) {
        String r0 = b("ro.build.version.emui");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean d(al r2) {
        String r0 = b("ro.build.version.opporom");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean e(al r2) {
        String r0 = b("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean f(al r2) {
        String r0 = b("ro.smartisan.version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean g(al r2) {
        String r0 = b("ro.build.display.id");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        if (r0.matches("amigo([\\d.]+)[a-zA-Z]*") == false) goto L10;
        a(r2, r0);
        r2.b(r0);
        return true;
    L10:
        return false;
    }

    private static boolean h(al r2) {
        String r0 = b("ro.letv.release.version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean i(al r2) {
        String r0 = b("ro.build.sense.version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean j(al r2) {
        String r0 = b("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean k(al r2) {
        if ("android-google".equals(b("ro.com.google.clientidbase")) == false) goto L6;
        String r0 = b("ro.build.version.release");
        r2.a(Build.VERSION.SDK_INT);
        r2.b(r0);
        return true;
    L6:
        return false;
    }

    private static boolean l(al r2) {
        String r0 = b("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        a(r2, r0);
        r2.b(r0);
        return true;
    L6:
        return false;
    }
}
