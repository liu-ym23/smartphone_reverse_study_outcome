package s;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f11933a = null;

    static {
        f11933a = new boolean[3];
    }

    public static void a(f r8, p.d r10, e r11) {
        r11.f11877p = -1;
        r11.f11879q = -1;
        e.a r12 = r8.V[0];
        e.a r13 = e.a.f11892b;
        e.a[] r14 = r11.V;
        if (r12 == r13) goto L10;
        if (r14[0] != e.a.f11894n) goto L10;
        d r15 = r11.K;
        int r16 = r15.f11836g;
        int r17 = r8.q();
        d r18 = r11.M;
        int r19 = r17 - r18.f11836g;
        r15.f11838i = r10.l(r15);
        r18.f11838i = r10.l(r18);
        r10.d(r15.f11838i, r16);
        r10.d(r18.f11838i, r19);
        r11.f11877p = 2;
        r11.f11851b0 = r16;
        int r20 = r19 - r16;
        r11.X = r20;
        int r21 = r11.f11856e0;
        if (r20 >= r21) goto L10;
        r11.X = r21;
    L10:
        if (r8.V[1] != r13) goto L12;
        return;
    L12:
        if (r14[1] != e.a.f11894n) goto L23;
        d r22 = r11.L;
        int r23 = r22.f11836g;
        int r24 = r8.l();
        d r25 = r11.N;
        int r26 = r24 - r25.f11836g;
        r22.f11838i = r10.l(r22);
        r25.f11838i = r10.l(r25);
        r10.d(r22.f11838i, r23);
        r10.d(r25.f11838i, r26);
        if (r11.d0 <= 0) goto L16;
    L17:
        d r27 = r11.O;
        r27.f11838i = r10.l(r27);
        r10.d(r27.f11838i, r11.d0 + r23);
    L18:
        r11.f11879q = 2;
        r11.f11853c0 = r23;
        int r28 = r26 - r23;
        r11.Y = r28;
        int r29 = r11.f11858f0;
        if (r28 >= r29) goto L24;
        r11.Y = r29;
        return;
    L24:
        return;
    L16:
        if (r11.f11866j0 != 8) goto L18;
    }

    public static final boolean b(int r8, int r10) {
        if ((r8 & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }
}
