package pn0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends d {
    public final int k;
    public final int l;
    public final int m;
    public final boolean n;
    public final List<Integer> o;
    public final boolean p;
    public final d.a q;
    public final boolean r;
    public final List<Integer> s;
    public final Long t;

    public c() {
        throw null;
    }

    @Override // pn0.d
    public final String toString() {
        return "{uiLayout = " + this.k + ", windowCount = " + this.l + ", orientation = " + this.m + ", isStatusBarVisible = " + this.n + ", playMode = " + this.o + ", isAnchor = " + this.p + '}';
    }

    @Override // pn0.d
    public final boolean a() {
        return this.r;
    }

    @Override // pn0.d
    public final int b() {
        return this.m;
    }

    @Override // pn0.d
    public final List<Integer> c() {
        return this.o;
    }

    @Override // pn0.d
    public final Long d() {
        return this.t;
    }

    @Override // pn0.d
    public final d.a e() {
        return this.q;
    }

    @Override // pn0.d
    public final List<Integer> f() {
        return this.s;
    }

    @Override // pn0.d
    public final int g() {
        return this.k;
    }

    @Override // pn0.d
    public final boolean h() {
        return this.p;
    }

    @Override // pn0.d
    public final boolean i() {
        return this.n;
    }

    public c(int r25, int r26, int r27, boolean r28, boolean r29, i r30, boolean r31, List r32, Long r33, Object r34, int r35) {
        if ((r35 & 4) == 0) goto L5;
        int r13 = 0;
    L7:
        if ((r35 & 8) == 0) goto L9;
        boolean r14 = true;
    L11:
        if ((r35 & 32) == 0) goto L13;
        boolean r11 = false;
    L15:
        if ((r35 & 128) == 0) goto L17;
        d.a r10 = new d.a(new StringBuilder());
    L19:
        if ((r35 & 256) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r35 & 512) == 0) goto L25;
        List r8 = null;
    L27:
        if ((r35 & 1024) == 0) goto L29;
        Long r7 = null;
    L30:
        Intrinsics.checkNotNullParameter(r10, "traceInfo");
        super(r25, r13, r14, null, r11, r10, r9, null, null, r34, 768);
        this.k = r25;
        this.l = r26;
        this.m = r13;
        this.n = r14;
        this.o = null;
        this.p = r11;
        this.q = r10;
        this.r = r9;
        this.s = r8;
        this.t = r7;
        return;
    L29:
        r7 = r33;
        goto L30
    L25:
        r8 = r32;
        goto L27
    L21:
        r9 = r31;
        goto L23
    L17:
        r10 = null;
        goto L19
    L13:
        r11 = r29;
        goto L15
    L9:
        r14 = r28;
        goto L11
    L5:
        r13 = r27;
        goto L7
    }
}
