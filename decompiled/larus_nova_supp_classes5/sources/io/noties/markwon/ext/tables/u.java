package io.noties.markwon.ext.tables;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u extends t {
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final float k;
    public final float l;
    public final float m;
    public final int n;
    public final boolean o;
    public final c p;
    public final int q;

    public static final class a {
    }

    static {
    }

    public u(t.a r1, int r2, int r3, int r4, int r5, float r6, float r7, float r8, int r9, boolean r10, com.larus.business.markdown.impl.markwon.l r11) {
        super(r1);
        this.g = r2;
        this.h = 0;
        this.i = r3;
        this.j = 0;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = 1;
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        this.e = r4;
        if (r5 >= 0) goto L8;
        r5 = 0;
    L8:
        this.f = r5;
        if ((r5 * 2) > r3) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Padding(0) can't larger than width(" + r3 + ')');
    }
}
