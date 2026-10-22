package qa;

import android.content.Context;
import android.os.Looper;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11003a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<i1> f11004b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<i1> f11005c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f11006d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f11007e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f11008f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f11009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static s4 f11010h;

    static {
        f11006d = new String[10];
    }

    public s() {
    }

    public static void a(Context r15) {
        Vector<s4> r8 = n.f10841b;
        Looper r10 = Looper.getMainLooper();     // Catch: Throwable -> L11
        monitor-enter(r10);     // Catch: Throwable -> L11
        Vector<s4> r11 = n.f10841b;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    L13:
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.size() == 0) goto L173;
        String[] r12 = f11006d;
        int r13 = 0;
        String r14 = null;
        File r16 = new File("/data/anr/traces.txt");     // Catch: Throwable -> L67 FileNotFoundException -> L89
        if (r16.exists() == false) goto L115;
        FileInputStream r17 = new FileInputStream(r16);     // Catch: Throwable -> L67 FileNotFoundException -> L89
    L149:
        int r18 = r17.available();     // Catch: Throwable -> L64 FileNotFoundException -> L66
        if (r18 <= 1024000) goto L25;
        r17.skip(r18 - 1024000);     // Catch: Throwable -> L64 FileNotFoundException -> L66
    L25:
        f0 r19 = new f0(r17, e0.f10340z);     // Catch: Throwable -> L64 FileNotFoundException -> L66
        boolean r110 = false;
    L151:
        String r111 = r19.a().trim();     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        if (r111.contains("pid") == false) goto L34;
    L30:
        if (r111.startsWith("\"main\"") == true) goto L32;
        r111 = r19.a();     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        goto L30
    L32:
        r110 = true;
    L34:
        if (r111.equals("") == false) goto L37;
        if (r110 == true) goto L129;
    L37:
        if (r110 == false) goto L151;
        if (f11007e <= 9) goto L41;
        f11007e = 0;     // Catch: Throwable -> L43
    L41:
        int r112 = f11007e;     // Catch: Throwable -> L43
        r12[r112] = r111;     // Catch: Throwable -> L43
        f11007e = r112 + 1;     // Catch: Throwable -> L43
    L45:
        int r113 = f11009g;     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        if (r113 == 5) goto L129;
        if (f11008f == false) goto L50;
        f11009g = r113 + 1;     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        goto L151
    L50:
        Iterator<s4> r114 = r11.iterator();     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
    L52:
        if (r114.hasNext() == false) goto L151;
        s4 r115 = r114.next();     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        boolean r116 = n.a(r111, r115.d());     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        f11008f = r116;     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        if (r116 == false) goto L52;
        f11010h = r115;     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
    L43:
        th = move-exception;
        q.f("alg", "aDa", th);     // Catch: Throwable -> L58 EOFException -> L123 FileNotFoundException -> L124
        goto L45
    L58:
        th = th;
    L127:
        q.f("alg", "getA", th);     // Catch: Throwable -> L77
        if (r19 != null) goto L145;
    L75:
        if (r17 == null) goto L101;
    L133:
        r17.close();     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        q.f("alg", "getA", th);
    L101:
        if (f11008f == false) goto L115;
        StringBuilder r20 = new StringBuilder();
        int r21 = f11007e;     // Catch: Throwable -> L112
    L105:
        if (r21 >= 10) goto L108;
        if (r21 > 9) goto L108;
        r20.append(r12[r21]);     // Catch: Throwable -> L112
        r21 = r21 + 1;     // Catch: Throwable -> L112
    L108:
        if (r13 >= f11007e) goto L114;
        r20.append(r12[r13]);     // Catch: Throwable -> L112
        r13 = r13 + 1;
    L114:
        r14 = r20.toString();
    L112:
        th = move-exception;
        q.f("alg", "gLI", th);
        goto L114
    L145:
        r19.close();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        q.f("alg", "getA", th);
    L77:
        th = move-exception;
        if (r19 != null) goto L131;
    L83:
        if (r17 == null) goto L168;
        r17.close();     // Catch: Throwable -> L86
        throw th;
    L86:
        th = move-exception;
        q.f("alg", "getA", th);
        throw th;
    L168:
        throw th;
    L131:
        r19.close();     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        q.f("alg", "getA", th);
    L129:
        r19.close();     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        q.f("alg", "getA", th);
    L90:
        if (r19 != null) goto L125;
    L95:
        if (r17 == null) goto L101;
    L125:
        r19.close();     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        q.f("alg", "getA", th);
        goto L95
    L66:
        r19 = null;
    L64:
        th = th;
        r19 = null;
    L115:
        if (r14 != null) goto L117;
        return;
    L117:
        if ("".equals(r14) == true) goto L172;
        s4 r22 = f11010h;
        if (r22 == null) goto L174;
        b(r15, r22, 2, "ANR", r14);
        return;
    L174:
        return;
    L172:
        return;
    L89:
        r19 = null;
        r17 = null;
    L67:
        th = th;
        r19 = null;
        r17 = null;
        goto L127
    L173:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        r11 = n.f10841b;
        goto L13
    }

    public static void b(Context r8, s4 r10, int r11, String r12, String r13) {
        String r14 = t4.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
        StringBuilder r15 = new StringBuilder();
        r15.append("\"sim\":\"");     // Catch: Throwable -> L21
        r15.append("");     // Catch: Throwable -> L21
        r15.append("\",\"sdkversion\":\"");     // Catch: Throwable -> L21
        r15.append(r10.b());     // Catch: Throwable -> L21
        r15.append("\",\"product\":\"");     // Catch: Throwable -> L21
        r15.append(r10.a());     // Catch: Throwable -> L21
        r15.append("\",\"ed\":\"");     // Catch: Throwable -> L21
        r15.append(r10.c());     // Catch: Throwable -> L21
        r15.append("\",\"nt\":\"");     // Catch: Throwable -> L21
        int r16 = -1;
        int r17 = k4.d(r8);     // Catch: Throwable -> L7
    L9:
        r15.append(r17);     // Catch: Throwable -> L21
        r15.append("\",\"np\":\"");     // Catch: Throwable -> L21
        String r18 = k4.b(r8);     // Catch: Throwable -> L12
    L14:
        r15.append(r18);     // Catch: Throwable -> L21
        r15.append("\",\"mnc\":\"");     // Catch: Throwable -> L21
        r15.append("");     // Catch: Throwable -> L21
        r15.append("\",\"ant\":\"");     // Catch: Throwable -> L21
        r16 = k4.c(r8);     // Catch: Throwable -> L17
    L19:
        r15.append(r16);     // Catch: Throwable -> L21
        r15.append("\"");     // Catch: Throwable -> L21
    L23:
        String r19 = r15.toString();
        h4.h(r8);     // Catch: Throwable -> L26
    L28:
        StringBuffer r20 = new StringBuffer();
        r20.append(r19);
        r20.append(",\"timestamp\":\"");
        r20.append(r14);
        r20.append("\",\"et\":\"");
        r20.append(r11);
        r20.append("\",\"classname\":\"");
        r20.append(r12);
        r20.append("\",\"detail\":\"");
        r20.append(r13);
        r20.append("\"");
        String r21 = r20.toString();
        if (r21 != null) goto L31;
        return;
    L31:
        if ("".equals(r21) == true) goto L77;
        String r110 = null;
        if (r13 != null) goto L63;
        byte[] r111 = null;
    L59:
        r110 = t4.r(r111);     // Catch: Throwable -> L42
    L45:
        if (r11 != 1) goto L49;
        Vector<s4> r22 = n.f10841b;
        String r23 = "b";
    L47:
        String r24 = r23;
        p0 r25 = v0.a();
        v0.b(r8, r25, r24, 1000, 4096000, "1");
        if (r25.f10888e != null) goto L67;
        r25.f10888e = new b0(new c0(new a0(new b0())), 0);
    L67:
        q0.a(r110, t4.i(r21.replaceAll("\n", "<br/>")), r25);     // Catch: Throwable -> L58
        return;
    L78:
        return;
    L49:
        if (r11 != 2) goto L51;
        Vector<s4> r26 = n.f10841b;
        r23 = "d";
        goto L47
    L51:
        if (r11 != 0) goto L76;
        Vector<s4> r27 = n.f10841b;
        r23 = "c";
        goto L47
    L76:
        return;
    L42:
        th = move-exception;
        l.a("ut", "csb2h", th);
        goto L45
    L63:
        MessageDigest r28 = MessageDigest.getInstance(t4.n("ETUQ1"));     // Catch: Throwable -> L38
        r28.update(t4.i(r13));     // Catch: Throwable -> L38
        r111 = r28.digest();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();
        r111 = new byte[0];
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
        r18 = "";
        goto L14
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        r17 = -1;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }

    public static void c(Context r8) {
        WeakReference<i1> r10 = f11004b;
        if (r10 != null) goto L5;
    L6:
        f11004b = new WeakReference(new h1(r8, 3600000, "hKey", new j1(r8)));
    L7:
        i1 r11 = f11004b.get();
        Vector<s4> r12 = n.f10841b;
        l1.f10784d.a(new r(r8, r11, "d"));
        return;
    L5:
        if (r10.get() != null) goto L7;
        goto L6
    }

    public static void d(Context r8) {
        WeakReference<i1> r10 = f11005c;
        if (r10 != null) goto L5;
    L6:
        f11005c = new WeakReference(new h1(r8, 3600000, "gKey", new j1(r8)));
    L7:
        i1 r11 = f11005c.get();
        Vector<s4> r12 = n.f10841b;
        l1.f10784d.a(new r(r8, r11, "b"));
        return;
    L5:
        if (r10.get() != null) goto L7;
        goto L6
    }
}
