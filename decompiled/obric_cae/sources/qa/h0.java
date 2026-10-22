package qa;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h0 f10493a;

    public h0() {
        i4.w();
    }

    public static n0 a(m0 r14) {
        boolean r8 = r14.f10804h;
        e(r14);
        if (r8 == false) goto L5;
        m0.c r10 = m0.c.f10822b;
    L6:
        r14.b(r10);
        int r11 = 5000;
        boolean r12 = false;
        long r13 = 0;
        n0 r15 = null;
        if (d(r14) == false) goto L57;
        e(r14);
        if (d(r14) == false) goto L21;
        if (r14.c().equals(r14.e()) == false) goto L16;
    L20:
        boolean r16 = false;
    L99:
        long r17 = SystemClock.elapsedRealtime();     // Catch: g4 -> L46
        m0.a r18 = r14.f10805i;     // Catch: g4 -> L44
        m0.a r19 = m0.a.f10809m;     // Catch: g4 -> L44
        if (r18 != r19) goto L27;
        m0.b r20 = m0.b.f10816p;     // Catch: g4 -> L44
    L97:
        e(r14);     // Catch: Throwable -> L41
        int r110 = r14.f10797a;     // Catch: Throwable -> L41
        int r111 = i4.f10555o;     // Catch: Throwable -> L41
        m0.a r112 = r14.f10805i;     // Catch: Throwable -> L41
        if (r112 == r19) goto L42;
        if (r112 == m0.a.f10810n) goto L42;
        if (r110 < r111) goto L42;
        if (r16 == false) goto L42;
        r110 = r111;
    L42:
        r15 = b(r14, r20, r110);     // Catch: g4 -> L44
    L58:
        if (r15 == null) goto L63;
        byte[] r21 = r15.f10842a;
        if (r21 == null) goto L63;
        if (r21.length <= 0) goto L63;
        return r15;
    L63:
        m0.a r22 = r14.f10805i;
        m0.a r23 = m0.a.f10809m;
        if (r22 != r23) goto L68;
        if (r12 == false) goto L67;
        m0.b r24 = m0.b.f10817q;
    L101:
        e(r14);     // Catch: Throwable -> L91
        if (r17 == 0) goto L75;
        r13 = SystemClock.elapsedRealtime() - r17;     // Catch: Throwable -> L91
    L75:
        int r25 = r14.f10797a;     // Catch: Throwable -> L91
        m0.a r26 = r14.f10805i;     // Catch: Throwable -> L91
        if (r26 != r23) goto L78;
    L88:
        r11 = r25;
        goto L90
    L78:
        if (r26 == m0.a.f10810n) goto L88;
        long r27 = r25;
        if (r13 >= r27) goto L86;
        long r28 = r27 - r13;     // Catch: Throwable -> L91
        if (r28 < 1000) goto L86;
        r11 = (int) r28;     // Catch: Throwable -> L91
    L86:
        r11 = Math.min(1000, r25);     // Catch: Throwable -> L91
    L90:
        return b(r14, r24, r11);
    L67:
        r24 = m0.b.f10818r;
        goto L101
    L68:
        if (r12 == false) goto L70;
        r24 = m0.b.f10814n;
        goto L101
    L70:
        r24 = m0.b.f10815o;
    L41:
        r110 = 5000;
        goto L42
    L27:
        if (r18 == m0.a.f10810n) goto L31;
        if (r16 == false) goto L31;
        r20 = m0.b.f10812b;     // Catch: g4 -> L44
    L31:
        r20 = m0.b.f10813m;     // Catch: g4 -> L44
    L44:
        e = e;
    L49:
        if (e.f10482p == 21) goto L51;
    L54:
        if (r16 == false) goto L56;
        r12 = true;
        goto L58
    L56:
        throw e;
    L51:
        if (r14.f10805i != m0.a.f10808b) goto L54;
        throw e;
    L46:
        e = e;
        r17 = 0;
        goto L49
    L16:
        if (r14.f10805i == m0.a.f10810n) goto L20;
        if (i4.f10559s == false) goto L20;
    L21:
        r16 = true;
        goto L99
    L57:
        r17 = 0;
        goto L58
    L5:
        r10 = m0.c.f10821a;
        goto L6
    }

    public static n0 b(m0 r8, m0.b r10, int r11) {
        e(r8);     // Catch: Throwable -> L4 g4 -> L7
        r8.f10806j = r10;     // Catch: Throwable -> L4 g4 -> L7
        r8.f10800d = r11;     // Catch: Throwable -> L4 g4 -> L7
        return new k0().d(r8);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new g4("未知的错误");
    }

    public static void c() {
        if (f10493a != null) goto L6;
        f10493a = new h0();
        return;
    }

    public static boolean d(m0 r8) {
        e(r8);
        String r10 = r8.e();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return false;
    L7:
        String r11 = new URL(r10).getHost();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r8.j()) == true) goto L10;
        r11 = r8.j();     // Catch: Throwable -> L12
    L10:
        return i4.A(r11);
    L12:
        return true;
    }

    public static void e(m0 r8) {
        if (r8.c() == null) goto L8;
        if ("".equals(r8.c()) == true) goto L8;
        return;
    L8:
        throw new g4("request url is empty");
    }
}
