package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class fo {

    private static class a {
        String A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5575b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;
        String z;

        private a() {
        }

        /* synthetic */ a(byte r1) {
            this();
        }
    }

    public static String a() {
        String r0 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        String r1 = "1";
        if (fm.a() == true) goto L6;
        r1 = "0";
    L6:
        int r2 = r0.length();     // Catch: Throwable -> L8
        return r0.substring(0, r2 - 2) + r1 + r0.substring(r2 - 1);
    L8:
        th = move-exception;
        n.a(th, "CI", "TS");
        return null;
    }

    public static String a(Context r2) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static String a(Context r3, String r4, String r5) {
        return ft.a(fm.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")) + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4.substring(0, r4.length() - 3) + ParameterizedMessage.ERROR_MSG_SEPARATOR + r5);
    L5:
        th = move-exception;
        n.a(th, "CI", "Sco");
        return null;
    }

    private static String a(a r0) {
        return fq.b(b(r0));
    }

    private static void a(ByteArrayOutputStream r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        fx.a(r2, (byte) 0, new byte[0]);
        return;
    L5:
        if (r3.getBytes().length <= 255) goto L7;
        byte r0 = -1;
    L8:
        fx.a(r2, r0, fx.a(r3));
        return;
    L7:
        r0 = (byte) r3.getBytes().length;
        goto L8
    }

    public static byte[] a(Context r2, boolean r3, boolean r4) {
        return b(b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4));
    L5:
        th = move-exception;
        n.a(th, "CI", "gz");
        return null;
    }

    public static byte[] a(byte[] r0) {
        return fq.a(r0);
    }

    private static a b(Context r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        a r0 = new a(0);
        r0.f5574a = fp.k();
        r0.f5575b = fp.h();
        String r2 = fp.f(r8);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.c = r2;
        r0.d = fm.c(r8);
        r0.e = Build.MODEL;
        r0.f = Build.MANUFACTURER;
        r0.g = Build.DEVICE;
        r0.h = fm.b(r8);
        r0.i = fm.d(r8);
        r0.j = String.valueOf(Build.VERSION.SDK_INT);
        r0.k = fp.n();
        r0.l = fp.m(r8);
        r0.m = new StringBuilder().append(fp.j(r8)).toString();
        r0.n = new StringBuilder().append(fp.i(r8)).toString();
        r0.o = fp.s(r8);
        r0.p = fp.h(r8);
        r0.q = "";
        r0.r = "";
        if (r6 == false) goto L8;
        r0.s = "";
        r0.t = "";
    L9:
        r0.w = fp.a();
        String r1 = fp.a(r8);
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r0.x = r1;
    L13:
        r0.y = "aid=" + fp.g();
        if (r7 == false) goto L18;
        if (b.d == false) goto L18;
    L19:
        String r9 = fp.e(r8);
        if (TextUtils.isEmpty(r9) == true) goto L22;
        r0.y += "|oaid=" + r9;
    L22:
        String r10 = fp.j();
        if (TextUtils.isEmpty(r10) == true) goto L25;
        r0.y += "|multiImeis=" + r10;
    L25:
        String r11 = fp.m();
        if (TextUtils.isEmpty(r11) == true) goto L28;
        r0.y += "|meid=" + r11;
    L28:
        r0.y += "|serial=" + fp.f();
        String r12 = fp.b();
        if (TextUtils.isEmpty(r12) == true) goto L31;
        r0.y += "|adiuExtras=" + r12;
    L31:
        r0.y += "|storage=" + fp.o() + "|ram=" + fp.r(r8) + "|arch=" + fp.p();
        String r13 = m.a().b();
        if (TextUtils.isEmpty(r13) == true) goto L34;
        r0.z = r13;
    L35:
        if (r6 == false) goto L39;
        com.loc.a.a(r8);
        String r14 = com.loc.a.a();
        if (TextUtils.isEmpty(r14) == true) goto L39;
        r0.A = r14;
    L39:
        return r0;
    L34:
        r0.z = "";
    L18:
        if (b.e == false) goto L22;
    L12:
        r0.x = "";
        goto L13
    L8:
        String[] r3 = fp.i();
        r0.s = r3[0];
        r0.t = r3[1];
        goto L9
    }

    private static String b(Context r2) {
        return a(b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), false, false));
    L5:
        th = move-exception;
        n.a(th, "CI", "gCXi");
        return null;
    }

    private static byte[] b(a r4) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        a(r1, r4.f5574a);     // Catch: Throwable -> L10
        a(r1, r4.f5575b);     // Catch: Throwable -> L10
        a(r1, r4.c);     // Catch: Throwable -> L10
        a(r1, r4.d);     // Catch: Throwable -> L10
        a(r1, r4.e);     // Catch: Throwable -> L10
        a(r1, r4.f);     // Catch: Throwable -> L10
        a(r1, r4.g);     // Catch: Throwable -> L10
        a(r1, r4.h);     // Catch: Throwable -> L10
        a(r1, r4.i);     // Catch: Throwable -> L10
        a(r1, r4.j);     // Catch: Throwable -> L10
        a(r1, r4.k);     // Catch: Throwable -> L10
        a(r1, r4.l);     // Catch: Throwable -> L10
        a(r1, r4.m);     // Catch: Throwable -> L10
        a(r1, r4.n);     // Catch: Throwable -> L10
        a(r1, r4.o);     // Catch: Throwable -> L10
        a(r1, r4.p);     // Catch: Throwable -> L10
        a(r1, r4.q);     // Catch: Throwable -> L10
        a(r1, r4.r);     // Catch: Throwable -> L10
        a(r1, r4.s);     // Catch: Throwable -> L10
        a(r1, r4.t);     // Catch: Throwable -> L10
        a(r1, r4.u);     // Catch: Throwable -> L10
        a(r1, r4.v);     // Catch: Throwable -> L10
        a(r1, r4.w);     // Catch: Throwable -> L10
        a(r1, r4.x);     // Catch: Throwable -> L10
        a(r1, r4.y);     // Catch: Throwable -> L10
        a(r1, r4.z);     // Catch: Throwable -> L10
        a(r1, r4.A);     // Catch: Throwable -> L10
        byte[] r5 = r1.toByteArray();     // Catch: Throwable -> L10
        new String(r5);     // Catch: Throwable -> L10
        byte[] r6 = b(fx.b(r5));     // Catch: Throwable -> L10
        r1.close();     // Catch: Throwable -> L7
    L9:
        return r6;
    L7:
        th = move-exception;
        th.printStackTrace();
    L10:
        th = th;
    L38:
        n.a(th, "CI", "gzx");     // Catch: Throwable -> L21
        if (r1 != null) goto L34;
    L20:
        return null;
    L34:
        r1.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = move-exception;
        if (r1 != null) goto L30;
    L27:
        throw th;
    L30:
        r1.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L12:
        th = th;
        r1 = null;
        goto L38
    }

    private static byte[] b(byte[] r5) {
        PublicKey r0 = fx.d();
        if (r5.length <= 117) goto L6;
        byte[] r1 = new byte[117];
        System.arraycopy(r5, 0, r1, 0, 117);
        byte[] r2 = fq.a(r1, r0);
        byte[] r3 = new byte[(r5.length + 128) - 117];
        System.arraycopy(r2, 0, r3, 0, 128);
        System.arraycopy(r5, 117, r3, 128, r5.length - 117);
        return r3;
    L6:
        return fq.a(r5, r0);
    }
}
