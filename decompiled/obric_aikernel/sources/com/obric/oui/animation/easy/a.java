package com.obric.oui.animation.easy;

import i9.d;
import i9.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f6191r = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f6193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f6197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f6199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f6200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f6202k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f6203l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i9.b.q f6204m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private i9.b.p f6205n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f6206o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f6207p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f6208q;

    /* JADX INFO: renamed from: com.obric.oui.animation.easy.a$a, reason: collision with other inner class name */
    public static final class C0127a {
        private C0127a() {
        }

        public /* synthetic */ C0127a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0127a(null);
        f6191r = Float.MAX_VALUE;
    }

    public a(float r10) {
        this.f6208q = r10;
        float r11 = f6191r;
        this.f6193b = r11;
        this.f6195d = r11;
        this.f6196e = Float.MAX_VALUE;
        this.f6197f = -Float.MAX_VALUE;
        this.f6199h = 0.5f;
        this.f6200i = 0.5f;
        this.f6202k = 1500.0f;
        this.f6203l = 1500.0f;
    }

    public final void a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        if (this.f6206o == false) goto L6;
        r10.y();
    L8:
        r10.m(this.f6197f);
        r10.l(this.f6196e);
        if (this.f6192a == false) goto L12;
        r10.o(this.f6193b);
    L12:
        if (this.f6194c == false) goto L15;
        r10.p(this.f6195d);
    L15:
        if (r10.u() != null) goto L17;
        r10.x(new e());
    L17:
        e r11 = r10.u();
        Intrinsics.checkNotNullExpressionValue(r11, "animation.spring");
        r11.d(b());
        e r12 = r10.u();
        Intrinsics.checkNotNullExpressionValue(r12, "animation.spring");
        r12.f(c());
        e r13 = r10.u();
        Intrinsics.checkNotNullExpressionValue(r13, "animation.spring");
        r13.e(this.f6208q);
        if (r10.g() == true) goto L23;
        i9.b.q r14 = this.f6204m;
        if (r14 == null) goto L23;
        r10.b(r14);
    L23:
        if (r10.g() == true) goto L28;
        i9.b.p r15 = this.f6205n;
        if (r15 == null) goto L29;
        r10.a(r15);
        return;
    L29:
        return;
    L28:
        return;
    L6:
        if (this.f6207p == false) goto L8;
        r10.c();
        goto L8
    }

    public final float b() {
        if (this.f6198g == false) goto L6;
        return this.f6200i;
    L6:
        return this.f6199h;
    }

    public final float c() {
        if (this.f6201j == false) goto L6;
        return this.f6203l;
    L6:
        return this.f6202k;
    }

    public final void d(float r10) {
        this.f6198g = true;
        this.f6200i = r10;
    }

    public final void e(float r10) {
        this.f6199h = r10;
    }

    public final void f(float r10) {
        this.f6202k = r10;
    }

    public final void g(float r10) {
        this.f6192a = true;
        this.f6193b = r10;
    }

    public final void h(float r10) {
        this.f6201j = true;
        this.f6203l = r10;
    }
}
