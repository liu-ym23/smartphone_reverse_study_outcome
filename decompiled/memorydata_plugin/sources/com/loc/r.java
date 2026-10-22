package com.loc;

import android.content.Context;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakReference<as> f5626a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5627b = true;
    private static WeakReference<bl> c = null;
    private static WeakReference<bl> d = null;
    private static String[] e = null;
    private static int f = 0;
    private static boolean g = false;
    private static int h;
    private static fw i;

    static {
        e = new String[10];
    }

    public r() {
    }

    private static fw a(String r5) {
        List r0 = o.a();
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        if (r5 != null) goto L8;
    L32:
        return null;
    L8:
        if ("".equals(r5) == true) goto L32;
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L17;
        fw r2 = (fw) ZeusTransformUtils.preCheckCast(r1.next(), fw.class, "com.obric.memorydata.plugin");
        if (o.a(r2.f(), r5) == false) goto L12;
        return r2;
    L17:
        if (r5.contains("com.amap.api.col") == false) goto L23;
        return fx.a();
    L20:
        e = move-exception;
        e.printStackTrace();
    L23:
        if (r5.contains("com.amap.co") == false) goto L25;
    L33:
        fw r6 = fx.b();     // Catch: l -> L30
        r6.a(true);     // Catch: l -> L30
        return r6;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L25:
        if (r5.contains("com.amap.opensdk.co") == true) goto L33;
        if (r5.contains("com.amap.location") == false) goto L32;
        goto L32
    }

    private static String a(List<fw> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        File r4 = new File("/data/anr/traces.txt");     // Catch: Throwable -> L54 FileNotFoundException -> L77
        if (r4.exists() == true) goto L6;
        return null;
    L6:
        FileInputStream r5 = new FileInputStream(r4);     // Catch: Throwable -> L54 FileNotFoundException -> L77
    L113:
        int r6 = r5.available();     // Catch: Throwable -> L51 FileNotFoundException -> L53
        if (r6 <= 1024000) goto L10;
        r5.skip(r6 - 1024000);     // Catch: Throwable -> L51 FileNotFoundException -> L53
    L10:
        ai r7 = new ai(r5, ah.f5277b);     // Catch: Throwable -> L51 FileNotFoundException -> L53
        boolean r8 = false;
    L115:
        String r9 = r7.a().trim();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        if (r9.contains(CrashBody.PID) == false) goto L19;
    L15:
        if (r9.startsWith("\"main\"") == true) goto L17;
        r9 = r7.a();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        goto L15
    L17:
        r8 = true;
    L19:
        if (r9.equals("") == false) goto L22;
        if (r8 == true) goto L104;
    L22:
        if (r8 == false) goto L115;
        if (f <= 9) goto L26;
        f = 0;     // Catch: Throwable -> L28
    L26:
        String[] r10 = e;     // Catch: Throwable -> L28
        int r11 = f;     // Catch: Throwable -> L28
        r10[r11] = r9;     // Catch: Throwable -> L28
        f = r11 + 1;     // Catch: Throwable -> L28
    L30:
        int r14 = h;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        if (r14 == 5) goto L104;
        if (g == false) goto L35;
        h = r14 + 1;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        goto L115
    L35:
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
    L37:
        if (r15.hasNext() == false) goto L115;
        fw r16 = (fw) ZeusTransformUtils.preCheckCast(r15.next(), fw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        boolean r17 = o.b(r16.f(), r9);     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        g = r17;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        if (r17 == false) goto L37;
        i = r16;     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
    L28:
        th = move-exception;
        q.b(th, "alg", "aDa");     // Catch: Throwable -> L43 EOFException -> L93 FileNotFoundException -> L94
        goto L30
    L43:
        th = th;
    L110:
        q.b(th, "alg", "getA");     // Catch: Throwable -> L65
        if (r7 != null) goto L102;
    L62:
        if (r5 == null) goto L89;
        r5.close();     // Catch: Throwable -> L86
    L97:
    L89:
        if (g == true) goto L91;
        return null;
    L91:
        return b();
    L102:
        r7.close();     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        q.b(th, "alg", "getA");
    L65:
        th = move-exception;
        if (r7 != null) goto L95;
    L71:
        if (r5 == null) goto L128;
        r5.close();     // Catch: Throwable -> L74
        throw th;
    L74:
        th = move-exception;
        q.b(th, "alg", "getA");
        throw th;
    L128:
        throw th;
    L95:
        r7.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        q.b(th, "alg", "getA");
    L104:
        r7.close();     // Catch: Throwable -> L47
    L49:
        r5.close();     // Catch: Throwable -> L86
    L47:
        th = move-exception;
        q.b(th, "alg", "getA");
    L78:
        if (r7 != null) goto L108;
    L83:
        if (r5 == null) goto L89;
        r5.close();     // Catch: Throwable -> L86
        goto L97
    L108:
        r7.close();     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        q.b(th, "alg", "getA");
        goto L83
    L53:
        r7 = null;
    L51:
        th = th;
        r7 = null;
    L86:
        th = move-exception;
        q.b(th, "alg", "getA");
    L77:
        r7 = null;
        r5 = null;
    L54:
        th = th;
        r7 = null;
        r5 = null;
        goto L110
    }

    static /* synthetic */ WeakReference a() {
        return f5626a;
    }

    static void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        List<fw> r0 = o.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L19;
        String r1 = a(r0);
        if (r1 != null) goto L10;
        return;
    L10:
        if ("".equals(r1) == true) goto L18;
        fw r2 = i;
        if (r2 == null) goto L20;
        a(r5, r2, 2, "ANR", r1);
        return;
    L20:
        return;
    L18:
        return;
    }

    private static void a(Context r2, final bl r3, final String r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        bp.a().b(new AnonymousClass1(r5, r4, r3));
    }

    private static void a(Context r6, fw r7, int r8, String r9, String r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        String r11 = ay.a();
        String r12 = ay.a(r0, r7);
        fm.a(r0);
        String r13 = ay.a(r12, r11, r8, r9, r10);
        if (r13 != null) goto L5;
        return;
    L5:
        if ("".equals(r13) == true) goto L26;
        String r14 = ft.b(r10);
        if (r8 != 1) goto L12;
        String r15 = o.f5618b;
    L10:
        String r2 = r15;
        as r16 = ay.a(f5626a);
        ay.a(r0, r16, r2, 1000, 4096000, "1");
        if (r16.e != null) goto L22;
        r16.e = new ab(new ac(new ae(new af())));
    L22:
        at.a(r14, fx.a(r13.replaceAll("\n", "<br/>")), r16);     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L12:
        if (r8 != 2) goto L14;
        r15 = o.d;
        goto L10
    L14:
        if (r8 != 0) goto L25;
        r15 = o.c;
        goto L10
    L25:
        return;
    }

    public static void a(Context r4, Throwable r5, int r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = fx.a(r5);
        fw r1 = a(r0);
        if (a(r1) == true) goto L5;
        return;
    L5:
        String r2 = r0.replaceAll("\n", "<br/>");
        String r10 = r5.toString();
        if (r10 != null) goto L8;
        return;
    L8:
        if ("".equals(r10) == true) goto L18;
        StringBuilder r3 = new StringBuilder();
        if (r7 == null) goto L13;
        r3.append("class:").append(r7);
    L13:
        if (r8 == null) goto L15;
        r3.append(" method:").append(r8).append("$<br/>");
    L15:
        r3.append(r2);
        a(r9, r1, r6, r10, r3.toString());
        return;
    }

    static void a(fw r2, Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (a(r2) == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if ("".equals(r4) == true) goto L12;
        a(r6, r2, 1, r4, r5);
        return;
    }

    private static boolean a(fw r0) {
        if (r0 != null) goto L4;
        return false;
    L4:
        if (r0.e() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static String b() {
        StringBuilder r0 = new StringBuilder();
        int r1 = f;     // Catch: Throwable -> L14
    L5:
        if (r1 >= 10) goto L9;
        if (r1 > 9) goto L9;
        r0.append(e[r1]);     // Catch: Throwable -> L14
        r1 = r1 + 1;     // Catch: Throwable -> L14
    L9:
        int r2 = 0;
    L10:
        if (r2 >= f) goto L17;
        r0.append(e[r2]);     // Catch: Throwable -> L14
        r2 = r2 + 1;
    L17:
        return r0.toString();
    L14:
        th = move-exception;
        q.b(th, "alg", "gLI");
        goto L17
    }

    static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        bj r0 = new bj(f5627b);
        f5627b = false;
        a(r3, r0, o.c);
    }

    static void c(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        WeakReference<bl> r0 = c;
        if (r0 != null) goto L5;
    L6:
        c = new WeakReference(new bk(r7, 3600000, "hKey", new bm(r7)));
    L7:
        a(r7, (bl) ZeusTransformUtils.preCheckCast(c.get(), bl.class, "com.obric.memorydata.plugin"), o.d);
        return;
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }

    static void d(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        WeakReference<bl> r0 = d;
        if (r0 != null) goto L5;
    L6:
        d = new WeakReference(new bk(r7, 3600000, "gKey", new bm(r7)));
    L7:
        a(r7, (bl) ZeusTransformUtils.preCheckCast(d.get(), bl.class, "com.obric.memorydata.plugin"), o.f5618b);
        return;
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }
}
