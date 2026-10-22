package ye;

import af.f;
import we.a0;
import we.c;
import we.q;
import we.s;
import we.v;
import we.w;
import we.y;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {
    public static boolean b(String r8) {
        if ("Content-Length".equalsIgnoreCase(r8) == false) goto L5;
    L10:
        return true;
    L5:
        if ("Content-Encoding".equalsIgnoreCase(r8) == true) goto L10;
        if ("Content-Type".equalsIgnoreCase(r8) == true) goto L10;
        return false;
    }

    public static boolean c(String r8) {
        if ("Connection".equalsIgnoreCase(r8) == false) goto L5;
    L19:
        return false;
    L5:
        if ("Keep-Alive".equalsIgnoreCase(r8) == true) goto L19;
        if ("Proxy-Authenticate".equalsIgnoreCase(r8) == true) goto L19;
        if ("Proxy-Authorization".equalsIgnoreCase(r8) == true) goto L19;
        if ("TE".equalsIgnoreCase(r8) == true) goto L19;
        if ("Trailers".equalsIgnoreCase(r8) == true) goto L19;
        if ("Transfer-Encoding".equalsIgnoreCase(r8) == true) goto L19;
        if ("Upgrade".equalsIgnoreCase(r8) == true) goto L19;
        return true;
    }

    public static a0 d(a0 r8) {
        if (r8 != null) goto L4;
        return r8;
    L4:
        if (r8.f13120q == null) goto L8;
        a0.a r10 = new a0.a(r8);
        r10.f13132g = null;
        return r10.b();
    L8:
        return r8;
    }

    @Override // we.s
    public final a0 a(f r14) {
        System.currentTimeMillis();
        y r13 = r14.f364f;
        b r8 = new b(r13, null);
        if (r13 == null) goto L11;
        c r10 = r13.f13343g;
        if (r10 != null) goto L9;
        r10 = c.a(r13.f13340d);
        r13.f13343g = r10;
    L9:
        if (r10.f13151j == false) goto L11;
        r8 = new b(null, null);
    L11:
        y r15 = r8.f14122a;
        a0 r11 = r8.f14123b;
        if (r15 != null) goto L17;
        if (r11 != null) goto L17;
        a0.a r16 = new a0.a();
        r16.f13126a = r14.f364f;
        r16.f13127b = w.f13320m;
        r16.f13128c = 504;
        r16.f13129d = "Unsatisfiable Request (only-if-cached)";
        r16.f13132g = xe.c.f13882c;
        r16.f13136k = -1;
        r16.f13137l = System.currentTimeMillis();
        return r16.b();
    L17:
        if (r15 != null) goto L23;
        r11.getClass();
        a0.a r17 = new a0.a(r11);
        a0 r18 = d(r11);
        if (r18 == null) goto L21;
        a0.a.c("cacheResponse", r18);
    L21:
        r17.f13134i = r18;
        return r17.b();
    L23:
        a0 r19 = r14.e(r15);
        if (r11 != null) goto L26;
    L60:
        r19.getClass();
        a0.a r12 = new a0.a(r19);
        a0 r20 = d(r11);
        if (r20 == null) goto L63;
        a0.a.c("cacheResponse", r20);
    L63:
        r12.f13134i = r20;
        a0 r110 = d(r19);
        if (r110 == null) goto L66;
        a0.a.c("networkResponse", r110);
    L66:
        r12.f13133h = r110;
        return r12.b();
    L26:
        if (r19.f13116m != 304) goto L59;
        a0.a r21 = new a0.a(r11);
        q.a r22 = new q.a();
        q r23 = r11.f13119p;
        int r24 = r23.f13238a.length / 2;
        int r25 = 0;
        int r26 = 0;
    L28:
        q r27 = r19.f13119p;
        if (r26 >= r24) goto L43;
        String r111 = r23.e(r26);
        String r112 = r23.j(r26);
        if ("Warning".equalsIgnoreCase(r111) == false) goto L36;
        if (r112.startsWith("1") == false) goto L36;
    L42:
        r26 = r26 + 1;
    L36:
        if (b(r111) == false) goto L38;
    L41:
        xe.a.f13878a.getClass();
        r22.b(r111, r112);
        goto L42
    L38:
        if (c(r111) == false) goto L41;
        if (r27.d(r111) != null) goto L42;
    L43:
        int r28 = r27.f13238a.length / 2;
    L44:
        if (r25 >= r28) goto L51;
        String r29 = r27.e(r25);
        if (b(r29) == true) goto L50;
        if (c(r29) == false) goto L50;
        v.a r30 = xe.a.f13878a;
        String r113 = r27.j(r25);
        r30.getClass();
        r22.b(r29, r113);
    L50:
        r25 = r25 + 1;
        goto L44
    L51:
        r21.f13131f = new q(r22).g();
        r21.f13136k = r19.f13124u;
        r21.f13137l = r19.f13125v;
        a0 r31 = d(r11);
        if (r31 == null) goto L54;
        a0.a.c("cacheResponse", r31);
    L54:
        r21.f13134i = r31;
        a0 r32 = d(r19);
        if (r32 == null) goto L57;
        a0.a.c("networkResponse", r32);
    L57:
        r21.f13133h = r32;
        r21.b();
        r19.f13120q.close();
        throw null;
    L59:
        xe.c.f(r11.f13120q);
        goto L60
    }
}
