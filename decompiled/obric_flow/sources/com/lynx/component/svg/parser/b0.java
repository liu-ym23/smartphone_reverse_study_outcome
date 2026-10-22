package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements Cloneable {
    public SVG$Style$VectorEffect A;
    public SVG$Style$RenderQuality B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f9770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SVG$Style$FillRule f9771c;
    public Float d;
    public i0 e;
    public Float f;
    public q g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SVG$Style$LineCap f9772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SVG$Style$LineJoin f9773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Float f9774j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q[] f9775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q f9776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Float f9777m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h f9778n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f9779o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l9.l f9780p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f9781q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f9782r;
    public i0 s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Float f9783t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f9784u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SVG$Style$FillRule f9785v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i0 f9786w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Float f9787x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public i0 f9788y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Float f9789z;

    public b0() {
        this.f9769a = 0;
    }

    public static b0 a() {
        b0 r5 = new b0();
        r5.f9769a = -1;
        h r10 = h.f9811b;
        r5.f9770b = r10;
        SVG$Style$FillRule r11 = SVG$Style$FillRule.f9742a;
        r5.f9771c = r11;
        Float r12 = Float.valueOf(1.0f);
        r5.d = r12;
        r5.e = null;
        r5.f = r12;
        r5.g = new q();
        r5.f9772h = SVG$Style$LineCap.f9745a;
        r5.f9773i = SVG$Style$LineJoin.f9748a;
        r5.f9774j = Float.valueOf(4.0f);
        r5.f9775k = null;
        r5.f9776l = new q();
        r5.f9777m = r12;
        r5.f9778n = r10;
        Boolean r13 = Boolean.TRUE;
        r5.f9779o = r13;
        r5.f9780p = null;
        r5.f9781q = r13;
        r5.f9782r = r13;
        r5.s = r10;
        r5.f9783t = r12;
        r5.f9784u = null;
        r5.f9785v = r11;
        r5.f9786w = null;
        r5.f9787x = r12;
        r5.f9788y = null;
        r5.f9789z = r12;
        r5.A = SVG$Style$VectorEffect.f9754a;
        r5.B = SVG$Style$RenderQuality.f9751a;
        return r5;
    }

    public final Object clone() {
        b0 r5 = (b0) super.clone();
        q[] r10 = this.f9775k;
        if (r10 == null) goto L5;
        r5.f9775k = (q[]) r10.clone();
    L5:
        return r5;
    }
}
