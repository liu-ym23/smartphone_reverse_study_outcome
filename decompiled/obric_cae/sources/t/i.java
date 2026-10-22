package t;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static o a(s.e r8, int r10, ArrayList<o> r11, o r12) {
        if (r10 != 0) goto L4;
        int r13 = r8.f11880q0;
    L5:
        int r14 = 0;
        if (r13 == (-1)) goto L19;
        if (r12 != null) goto L9;
    L10:
        int r15 = 0;
    L12:
        if (r15 >= r11.size()) goto L22;
        o r16 = r11.get(r15);
        if (r16.f12189b == r13) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        if (r12 == null) goto L17;
        r12.c(r10, r16);
        r11.remove(r12);
    L17:
        r12 = r16;
    L22:
        if (r12 == null) goto L24;
    L50:
        ArrayList<s.e> r17 = r12.f12188a;
        if (r17.contains(r8) == false) goto L53;
        boolean r18 = false;
    L54:
        if (r18 == true) goto L56;
    L66:
        return r12;
    L56:
        if ((r8 instanceof s.h) == false) goto L61;
        s.h r19 = (s.h) r8;
        s.d r20 = r19.f11928v0;
        if (r19.f11929w0 != 0) goto L60;
        r14 = 1;
    L60:
        r20.c(r14, r12, r11);
    L61:
        int r21 = r12.f12189b;
        if (r10 != 0) goto L64;
        r8.f11880q0 = r21;
        r8.K.c(r10, r12, r11);
        s.d r22 = r8.M;
    L65:
        r22.c(r10, r12, r11);
        r8.R.c(r10, r12, r11);
        goto L66
    L64:
        r8.f11882r0 = r21;
        r8.L.c(r10, r12, r11);
        r8.O.c(r10, r12, r11);
        r22 = r8.N;
        goto L65
    L53:
        r17.add(r8);
        r18 = true;
        goto L54
    L24:
        if ((r8 instanceof s.j) == false) goto L47;
        s.j r23 = (s.j) r8;
        int r24 = 0;
    L27:
        if (r24 >= r23.f11932t0) goto L38;
        s.e r25 = r23.f11931s0[r24];
        if (r10 != 0) goto L33;
        int r26 = r25.f11880q0;
        if (r26 == (-1)) goto L33;
    L39:
        if (r26 == (-1)) goto L47;
        int r27 = 0;
    L42:
        if (r27 >= r11.size()) goto L47;
        o r28 = r11.get(r27);
        if (r28.f12189b == r26) goto L45;
        r27 = r27 + 1;
        goto L42
    L45:
        r12 = r28;
    L33:
        if (r10 != 1) goto L37;
        r26 = r25.f11882r0;
        if (r26 != (-1)) goto L39;
    L37:
        r24 = r24 + 1;
        goto L27
    L38:
        r26 = -1;
    L47:
        if (r12 != null) goto L49;
        r12 = new o(r10);
    L49:
        r11.add(r12);
        goto L50
    L9:
        if (r13 != r12.f12189b) goto L10;
    L19:
        if (r13 == (-1)) goto L22;
        return r12;
    L4:
        r13 = r8.f11882r0;
        goto L5
    }

    public static boolean b(s.e.a r8, s.e.a r10, s.e.a r11, s.e.a r12) {
        s.e.a r13 = s.e.a.f11891a;
        if (r11 == r13) goto L11;
        s.e.a r14 = s.e.a.f11892b;
        if (r11 == r14) goto L11;
        if (r11 != s.e.a.f11894n) goto L10;
        if (r8 != r14) goto L11;
    L10:
        boolean r15 = false;
    L12:
        if (r12 == r13) goto L20;
        s.e.a r16 = s.e.a.f11892b;
        if (r12 == r16) goto L20;
        if (r12 != s.e.a.f11894n) goto L19;
        if (r10 != r16) goto L20;
    L19:
        boolean r17 = false;
    L21:
        if (r15 == true) goto L25;
        if (r17 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r17 = true;
    L11:
        r15 = true;
        goto L12
    }
}
