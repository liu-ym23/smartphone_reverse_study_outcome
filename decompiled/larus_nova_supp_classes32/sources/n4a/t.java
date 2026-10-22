package n4a;

import android.content.Context;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t {
    public static boolean a = true;
    public static WeakReference<h1> b;
    public static WeakReference<h1> c;
    public static final String[] d = null;
    public static int e;
    public static boolean f;
    public static int g;
    public static e5 h;

    static {
        d = new String[10];
    }

    public t() {
    }

    public static void a(Context r15) {
        Vector<e5> r1 = p.b;
        Looper r2 = Looper.getMainLooper();     // Catch: Throwable -> L11
        monitor-enter(r2);     // Catch: Throwable -> L11
        Vector<e5> r3 = p.b;     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
    L13:
        if (r3 != null) goto L15;
        return;
    L15:
        if (r3.size() == 0) goto L173;
        String[] r4 = d;
        int r5 = 0;
        String r7 = null;
        PolarisFileWrapper r8 = new PolarisFileWrapper("/data/anr/traces.txt");     // Catch: Throwable -> L68 FileNotFoundException -> L90
        if (r8.exists() == false) goto L116;
        PolarisFileInputStreamWrapper r9 = new PolarisFileInputStreamWrapper(r8);     // Catch: Throwable -> L68 FileNotFoundException -> L90
    L151:
        int r10 = r9.available();     // Catch: Throwable -> L65 FileNotFoundException -> L67
        if (r10 <= 1024000) goto L25;
        r9.skip(r10 - 1024000);     // Catch: Throwable -> L65 FileNotFoundException -> L67
    L25:
        i0 r11 = new i0(r9, h0.p);     // Catch: Throwable -> L65 FileNotFoundException -> L67
        boolean r12 = false;
    L147:
        String r13 = r11.a().trim();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        if (r13.contains("pid") == false) goto L34;
    L30:
        if (r13.startsWith("\"main\"") == true) goto L32;
        r13 = r11.a();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        goto L30
    L32:
        r12 = true;
    L34:
        if (r13.equals(NameKeys.UnloadStrategy_No_Strategy) == false) goto L37;
        if (r12 == true) goto L129;
    L37:
        if (r12 == false) goto L147;
        if (e <= 9) goto L41;
        e = 0;     // Catch: Throwable -> L43
    L41:
        int r14 = e;     // Catch: Throwable -> L43
        r4[r14] = r13;     // Catch: Throwable -> L43
        e = r14 + 1;     // Catch: Throwable -> L43
    L45:
        int r16 = g;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        if (r16 == 5) goto L129;
        if (f == false) goto L50;
        g = r16 + 1;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        goto L147
    L50:
        Iterator<e5> r17 = r3.iterator();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
    L52:
        if (r17.hasNext() == false) goto L147;
        e5 r18 = r17.next();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        boolean r19 = p.b(r18.d(), r13);     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        f = r19;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        if (r19 == false) goto L52;
        h = r18;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
    L43:
        th = move-exception;
        r.f(th, "alg", "aDa");     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        goto L45
    L58:
        th = th;
    L127:
        r.f(th, "alg", "getA");     // Catch: Throwable -> L78
        if (r11 != null) goto L145;
    L76:
        if (r9 == null) goto L102;
    L137:
        r9.close();     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        r.f(th, "alg", "getA");
    L102:
        if (f == false) goto L116;
        StringBuilder r6 = new StringBuilder();
        int r20 = e;     // Catch: Throwable -> L113
    L106:
        if (r20 >= 10) goto L109;
        if (r20 > 9) goto L109;
        r6.append(r4[r20]);     // Catch: Throwable -> L113
        r20 = r20 + 1;     // Catch: Throwable -> L113
    L109:
        if (r5 >= e) goto L115;
        r6.append(r4[r5]);     // Catch: Throwable -> L113
        r5 = r5 + 1;
    L115:
        r7 = r6.toString();
    L113:
        th = move-exception;
        r.f(th, "alg", "gLI");
        goto L115
    L145:
        r11.close();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        r.f(th, "alg", "getA");
    L78:
        th = move-exception;
        if (r11 != null) goto L133;
    L84:
        if (r9 == null) goto L168;
        r9.close();     // Catch: Throwable -> L87
        throw th;
    L87:
        th = move-exception;
        r.f(th, "alg", "getA");
        throw th;
    L168:
        throw th;
    L133:
        r11.close();     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        r.f(th, "alg", "getA");
    L129:
        r11.close();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        r.f(th, "alg", "getA");
    L91:
        if (r11 != null) goto L125;
    L96:
        if (r9 == null) goto L102;
    L125:
        r11.close();     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        r.f(th, "alg", "getA");
        goto L96
    L67:
        r11 = null;
    L65:
        th = th;
        r11 = null;
    L116:
        if (r7 != null) goto L118;
        return;
    L118:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r7) == false) goto L120;
        return;
    L120:
        if (h == null) goto L174;
        b(r15, h, 2, "ANR", r7);
        return;
    L174:
        return;
    L90:
        r11 = null;
        r9 = null;
    L68:
        th = th;
        r11 = null;
        r9 = null;
        goto L127
    L173:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        r3 = p.b;
        goto L13
    }

    public static void c(Context r5) {
        WeakReference<h1> r0 = b;
        if (r0 != null) goto L5;
    L6:
        b = new WeakReference(new g1(r5, 3600000, "hKey", new i1(r5)));
    L7:
        h1 r1 = b.get();
        Vector<e5> r2 = p.b;
        k1.d.b(new s(r5, "d", r1));
        return;
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }

    public static void d(Context r5) {
        WeakReference<h1> r0 = c;
        if (r0 != null) goto L5;
    L6:
        c = new WeakReference(new g1(r5, 3600000, "gKey", new i1(r5)));
    L7:
        h1 r1 = c.get();
        Vector<e5> r2 = p.b;
        k1.d.b(new s(r5, "b", r1));
        return;
    L5:
        if (r0.get() != null) goto L7;
        goto L6
    }

    public static void b(Context r6, e5 r7, int r8, String r9, String r10) {
        String r2 = f5.b(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
        StringBuilder r3 = new StringBuilder();
        r3.append("\"sim\":\"");     // Catch: Throwable -> L21
        r3.append(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L21
        r3.append("\",\"sdkversion\":\"");     // Catch: Throwable -> L21
        r3.append(r7.b());     // Catch: Throwable -> L21
        r3.append("\",\"product\":\"");     // Catch: Throwable -> L21
        r3.append(r7.a());     // Catch: Throwable -> L21
        r3.append("\",\"ed\":\"");     // Catch: Throwable -> L21
        r3.append(r7.c());     // Catch: Throwable -> L21
        r3.append("\",\"nt\":\"");     // Catch: Throwable -> L21
        int r11 = -1;
        int r4 = x4.d(r6);     // Catch: Throwable -> L7
    L9:
        r3.append(r4);     // Catch: Throwable -> L21
        r3.append("\",\"np\":\"");     // Catch: Throwable -> L21
        String r5 = x4.b(r6);     // Catch: Throwable -> L12
    L14:
        r3.append(r5);     // Catch: Throwable -> L21
        r3.append("\",\"mnc\":\"");     // Catch: Throwable -> L21
        r3.append(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L21
        r3.append("\",\"ant\":\"");     // Catch: Throwable -> L21
        r11 = x4.c(r6);     // Catch: Throwable -> L17
    L19:
        r3.append(r11);     // Catch: Throwable -> L21
        r3.append("\"");     // Catch: Throwable -> L21
    L23:
        String r12 = r3.toString();
        v4.h(r6);     // Catch: Throwable -> L26
    L28:
        StringBuffer r13 = new StringBuffer();
        r13.append(r12);
        r13.append(",\"timestamp\":\"");
        r13.append(r2);
        r13.append("\",\"et\":\"");
        r13.append(r8);
        r13.append("\",\"classname\":\"");
        r13.append(r9);
        r13.append("\",\"detail\":\"");
        r13.append(r10);
        r13.append("\"");
        String r14 = r13.toString();
        if (r14 != null) goto L31;
        return;
    L31:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r14) == true) goto L77;
        String r15 = null;
        if (r10 != null) goto L63;
        byte[] r16 = null;
    L59:
        r15 = f5.s(r16);     // Catch: Throwable -> L42
    L45:
        if (r8 != 1) goto L49;
        Vector<e5> r17 = p.b;
        String r18 = "b";
    L47:
        String r19 = r18;
        n0 r20 = t0.a();
        t0.b(r6, r20, r19, 1000, 4096000, "1");
        if (r20.e != null) goto L69;
        r20.e = new b0(new c0(new e0(new f0())));
    L69:
        o0.a(r15, f5.j(r14.replaceAll("\n", "<br/>")), r20);     // Catch: Throwable -> L58
        return;
    L78:
        return;
    L49:
        if (r8 != 2) goto L51;
        Vector<e5> r21 = p.b;
        r18 = "d";
        goto L47
    L51:
        if (r8 != 0) goto L76;
        Vector<e5> r22 = p.b;
        r18 = "c";
        goto L47
    L76:
        return;
    L42:
        th = move-exception;
        n.a(th, "ut", "csb2h");
        goto L45
    L63:
        MessageDigest r0 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L38
        r0.update(f5.j(r10));     // Catch: Throwable -> L38
        r16 = r0.digest();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();
        r16 = new byte[0];
        goto L59
    L77:
        return;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L19
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        r5 = NameKeys.UnloadStrategy_No_Strategy;
        goto L14
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        r4 = -1;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }
}
