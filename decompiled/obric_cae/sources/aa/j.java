package aa;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import pe.d0;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f191l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d0 f192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d0 f193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d0 f194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d0 f195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f196e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f197f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f198g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f199h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e f200i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final e f201j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final e f202k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final e f203l;

        public a() {
            this.f192a = new i();
            this.f193b = new i();
            this.f194c = new i();
            this.f195d = new i();
            this.f196e = new aa.a(0.0f);
            this.f197f = new aa.a(0.0f);
            this.f198g = new aa.a(0.0f);
            this.f199h = new aa.a(0.0f);
            this.f200i = new e();
            this.f201j = new e();
            this.f202k = new e();
            this.f203l = new e();
        }

        public static float b(d0 r8) {
            if ((r8 instanceof i) == false) goto L7;
            return ((i) r8).f179a;
        L7:
            if ((r8 instanceof d) == true) goto L9;
            return -1.0f;
        L9:
            return ((d) r8).f138a;
        }

        public final j a() {
            return new j(this);
        }

        public final void c(float r8) {
            this.f199h = new aa.a(r8);
        }

        public final void d(float r8) {
            this.f198g = new aa.a(r8);
        }

        public final void e(float r8) {
            this.f196e = new aa.a(r8);
        }

        public final void f(float r8) {
            this.f197f = new aa.a(r8);
        }

        public a(j r8) {
            this.f192a = new i();
            this.f193b = new i();
            this.f194c = new i();
            this.f195d = new i();
            this.f196e = new aa.a(0.0f);
            this.f197f = new aa.a(0.0f);
            this.f198g = new aa.a(0.0f);
            this.f199h = new aa.a(0.0f);
            this.f200i = new e();
            this.f201j = new e();
            this.f202k = new e();
            this.f203l = new e();
            this.f192a = r8.f180a;
            this.f193b = r8.f181b;
            this.f194c = r8.f182c;
            this.f195d = r8.f183d;
            this.f196e = r8.f184e;
            this.f197f = r8.f185f;
            this.f198g = r8.f186g;
            this.f199h = r8.f187h;
            this.f200i = r8.f188i;
            this.f201j = r8.f189j;
            this.f202k = r8.f190k;
            this.f203l = r8.f191l;
        }
    }

    public j() {
        this.f180a = new i();
        this.f181b = new i();
        this.f182c = new i();
        this.f183d = new i();
        this.f184e = new aa.a(0.0f);
        this.f185f = new aa.a(0.0f);
        this.f186g = new aa.a(0.0f);
        this.f187h = new aa.a(0.0f);
        this.f188i = new e();
        this.f189j = new e();
        this.f190k = new e();
        this.f191l = new e();
    }

    public static a a(Context r8, int r10, int r11, aa.a r12) {
        ContextThemeWrapper r13 = new ContextThemeWrapper(r8, r10);
        if (r11 == 0) goto L5;
        r13 = new ContextThemeWrapper(r13, r11);
    L5:
        TypedArray r14 = r13.obtainStyledAttributes(g9.a.f7782w);
        int r15 = r14.getInt(0, 0);     // Catch: Throwable -> L21
        int r16 = r14.getInt(3, r15);     // Catch: Throwable -> L21
        int r17 = r14.getInt(4, r15);     // Catch: Throwable -> L21
        int r18 = r14.getInt(2, r15);     // Catch: Throwable -> L21
        int r19 = r14.getInt(1, r15);     // Catch: Throwable -> L21
        c r110 = c(r14, 5, r12);     // Catch: Throwable -> L21
        c r20 = c(r14, 8, r110);     // Catch: Throwable -> L21
        c r21 = c(r14, 9, r110);     // Catch: Throwable -> L21
        c r22 = c(r14, 7, r110);     // Catch: Throwable -> L21
        c r111 = c(r14, 6, r110);     // Catch: Throwable -> L21
        a r23 = new a();     // Catch: Throwable -> L21
        d0 r112 = defpackage.c.C(r16);     // Catch: Throwable -> L21
        r23.f192a = r112;     // Catch: Throwable -> L21
        float r113 = a.b(r112);     // Catch: Throwable -> L21
        if (r113 == (-1.0f)) goto L9;
        r23.e(r113);     // Catch: Throwable -> L21
    L9:
        r23.f196e = r20;     // Catch: Throwable -> L21
        d0 r114 = defpackage.c.C(r17);     // Catch: Throwable -> L21
        r23.f193b = r114;     // Catch: Throwable -> L21
        float r115 = a.b(r114);     // Catch: Throwable -> L21
        if (r115 == (-1.0f)) goto L12;
        r23.f(r115);     // Catch: Throwable -> L21
    L12:
        r23.f197f = r21;     // Catch: Throwable -> L21
        d0 r116 = defpackage.c.C(r18);     // Catch: Throwable -> L21
        r23.f194c = r116;     // Catch: Throwable -> L21
        float r117 = a.b(r116);     // Catch: Throwable -> L21
        if (r117 == (-1.0f)) goto L15;
        r23.d(r117);     // Catch: Throwable -> L21
    L15:
        r23.f198g = r22;     // Catch: Throwable -> L21
        d0 r24 = defpackage.c.C(r19);     // Catch: Throwable -> L21
        r23.f195d = r24;     // Catch: Throwable -> L21
        float r25 = a.b(r24);     // Catch: Throwable -> L21
        if (r25 == (-1.0f)) goto L18;
        r23.c(r25);     // Catch: Throwable -> L21
    L18:
        r23.f199h = r111;     // Catch: Throwable -> L21
        r14.recycle();
        return r23;
    L21:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    public static a b(Context r8, AttributeSet r10, int r11, int r12) {
        aa.a r13 = new aa.a(0);
        TypedArray r14 = r8.obtainStyledAttributes(r10, g9.a.f7776q, r11, r12);
        int r15 = r14.getResourceId(0, 0);
        int r16 = r14.getResourceId(1, 0);
        r14.recycle();
        return a(r8, r15, r16, r13);
    }

    public static c c(TypedArray r8, int r10, c r11) {
        TypedValue r12 = r8.peekValue(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        int r13 = r12.type;
        if (r13 != 5) goto L10;
        return new aa.a(TypedValue.complexToDimensionPixelSize(r12.data, r8.getResources().getDisplayMetrics()));
    L10:
        if (r13 == 6) goto L12;
        return r11;
    L12:
        return new h(r12.getFraction(1.0f, 1.0f));
    }

    public final boolean d(RectF r8) {
        if (this.f191l.getClass().equals(e.class) == true) goto L5;
    L11:
        boolean r10 = false;
    L12:
        float r11 = this.f184e.a(r8);
        if (this.f185f.a(r8) == r11) goto L15;
    L19:
        boolean r12 = false;
    L21:
        if ((this.f181b instanceof i) == true) goto L23;
    L29:
        boolean r13 = false;
    L30:
        if (r10 == false) goto L35;
        if (r12 == false) goto L35;
        if (r13 == false) goto L35;
        return true;
    L35:
        return false;
    L23:
        if ((this.f180a instanceof i) == false) goto L29;
        if ((this.f182c instanceof i) == false) goto L29;
        if ((this.f183d instanceof i) == false) goto L29;
        r13 = true;
        goto L30
    L15:
        if (this.f187h.a(r8) != r11) goto L19;
        if (this.f186g.a(r8) != r11) goto L19;
        r12 = true;
        goto L21
    L5:
        if (this.f189j.getClass().equals(e.class) == false) goto L11;
        if (this.f188i.getClass().equals(e.class) == false) goto L11;
        if (this.f190k.getClass().equals(e.class) == false) goto L11;
        r10 = true;
        goto L12
    }

    public j(a r8) {
        this.f180a = r8.f192a;
        this.f181b = r8.f193b;
        this.f182c = r8.f194c;
        this.f183d = r8.f195d;
        this.f184e = r8.f196e;
        this.f185f = r8.f197f;
        this.f186g = r8.f198g;
        this.f187h = r8.f199h;
        this.f188i = r8.f200i;
        this.f189j = r8.f201j;
        this.f190k = r8.f202k;
        this.f191l = r8.f203l;
    }
}
