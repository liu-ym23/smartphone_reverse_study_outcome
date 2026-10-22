package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4049a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f4050b;
    d c;
    d d;
    d e;
    c f;
    c g;
    c h;
    c i;
    f j;
    f k;
    f l;
    f m;

    /* JADX INFO: renamed from: com.google.android.material.shape.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f4051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f4052b;
        private d c;
        private d d;
        private c e;
        private c f;
        private c g;
        private c h;
        private f i;
        private f j;
        private f k;
        private f l;

        public a() {
            this.f4051a = h.a();
            this.f4052b = h.a();
            this.c = h.a();
            this.d = h.a();
            this.e = new com.google.android.material.shape.a(0.0f);
            this.f = new com.google.android.material.shape.a(0.0f);
            this.g = new com.google.android.material.shape.a(0.0f);
            this.h = new com.google.android.material.shape.a(0.0f);
            this.i = h.b();
            this.j = h.b();
            this.k = h.b();
            this.l = h.b();
        }

        public a(l r3) {
            this.f4051a = h.a();
            this.f4052b = h.a();
            this.c = h.a();
            this.d = h.a();
            this.e = new com.google.android.material.shape.a(0.0f);
            this.f = new com.google.android.material.shape.a(0.0f);
            this.g = new com.google.android.material.shape.a(0.0f);
            this.h = new com.google.android.material.shape.a(0.0f);
            this.i = h.b();
            this.j = h.b();
            this.k = h.b();
            this.l = h.b();
            this.f4051a = r3.f4050b;
            this.f4052b = r3.c;
            this.c = r3.d;
            this.d = r3.e;
            this.e = r3.f;
            this.f = r3.g;
            this.g = r3.h;
            this.h = r3.i;
            this.i = r3.j;
            this.j = r3.k;
            this.k = r3.l;
            this.l = r3.m;
        }

        static /* synthetic */ d a(a r0) {
            return r0.f4051a;
        }

        static /* synthetic */ d b(a r0) {
            return r0.f4052b;
        }

        static /* synthetic */ d c(a r0) {
            return r0.c;
        }

        static /* synthetic */ d d(a r0) {
            return r0.d;
        }

        static /* synthetic */ c e(a r0) {
            return r0.e;
        }

        private static float f(d r2) {
            if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L7;
            return ((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.memorydata.plugin")).f4048a;
        L7:
            if (ZeusTransformUtils.instanceOf(r2, e.class) == true) goto L9;
            return -1.0f;
        L9:
            return ((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin")).f4043a;
        }

        static /* synthetic */ c f(a r0) {
            return r0.f;
        }

        static /* synthetic */ c g(a r0) {
            return r0.g;
        }

        static /* synthetic */ c h(a r0) {
            return r0.h;
        }

        static /* synthetic */ f i(a r0) {
            return r0.i;
        }

        static /* synthetic */ f j(a r0) {
            return r0.j;
        }

        static /* synthetic */ f k(a r0) {
            return r0.k;
        }

        static /* synthetic */ f l(a r0) {
            return r0.l;
        }

        public a a(float r1) {
            return b(r1).c(r1).d(r1).e(r1);
        }

        public a a(int r1, float r2) {
            return a(h.a(r1)).a(r2);
        }

        public a a(int r3, c r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            return b(h.a(r3)).b(r5);
        }

        public a a(c r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            return b(r4).c(r4).d(r4).e(r4);
        }

        public a a(d r1) {
            return b(r1).c(r1).d(r1).e(r1);
        }

        public a a(f r1) {
            this.i = r1;
            return this;
        }

        public l a() {
            return new l(this, null);
        }

        public a b(float r2) {
            this.e = new com.google.android.material.shape.a(r2);
            return this;
        }

        public a b(int r3, c r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            return c(h.a(r3)).c(r5);
        }

        public a b(c r3) {
            this.e = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a b(d r2) {
            this.f4051a = r2;
            float r3 = f(r2);
            if (r3 == (-1.0f)) goto L5;
            b(r3);
        L5:
            return this;
        }

        public a b(f r1) {
            this.k = r1;
            return this;
        }

        public a c(float r2) {
            this.f = new com.google.android.material.shape.a(r2);
            return this;
        }

        public a c(int r3, c r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            return d(h.a(r3)).d(r5);
        }

        public a c(c r3) {
            this.f = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a c(d r2) {
            this.f4052b = r2;
            float r3 = f(r2);
            if (r3 == (-1.0f)) goto L5;
            c(r3);
        L5:
            return this;
        }

        public a d(float r2) {
            this.g = new com.google.android.material.shape.a(r2);
            return this;
        }

        public a d(int r3, c r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            return e(h.a(r3)).e(r5);
        }

        public a d(c r3) {
            this.g = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a d(d r2) {
            this.c = r2;
            float r3 = f(r2);
            if (r3 == (-1.0f)) goto L5;
            d(r3);
        L5:
            return this;
        }

        public a e(float r2) {
            this.h = new com.google.android.material.shape.a(r2);
            return this;
        }

        public a e(c r3) {
            this.h = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a e(d r2) {
            this.d = r2;
            float r3 = f(r2);
            if (r3 == (-1.0f)) goto L5;
            e(r3);
        L5:
            return this;
        }
    }

    public interface b {
        c a(c r1);
    }

    static {
        f4049a = new j(0.5f);
    }

    public l() {
        this.f4050b = h.a();
        this.c = h.a();
        this.d = h.a();
        this.e = h.a();
        this.f = new com.google.android.material.shape.a(0.0f);
        this.g = new com.google.android.material.shape.a(0.0f);
        this.h = new com.google.android.material.shape.a(0.0f);
        this.i = new com.google.android.material.shape.a(0.0f);
        this.j = h.b();
        this.k = h.b();
        this.l = h.b();
        this.m = h.b();
    }

    private l(a r2) {
        this.f4050b = a.a(r2);
        this.c = a.b(r2);
        this.d = a.c(r2);
        this.e = a.d(r2);
        this.f = a.e(r2);
        this.g = a.f(r2);
        this.h = a.g(r2);
        this.i = a.h(r2);
        this.j = a.i(r2);
        this.k = a.j(r2);
        this.l = a.k(r2);
        this.m = a.l(r2);
    }

    /* synthetic */ l(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    private static c a(TypedArray r3, int r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        TypedValue r7 = r3.peekValue(r4);
        if (r7 != null) goto L6;
        return r6;
    L6:
        if (r7.type != 5) goto L10;
        return new com.google.android.material.shape.a(TypedValue.complexToDimensionPixelSize(r7.data, ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics()));
    L10:
        if (r7.type == 6) goto L12;
        return r6;
    L12:
        return new j(r7.getFraction(1.0f, 1.0f));
    }

    public static a a() {
        return new a();
    }

    public static a a(Context r2, int r3, int r4) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, 0);
    }

    private static a a(Context r2, int r3, int r4, int r5) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, new com.google.android.material.shape.a(r5));
    }

    private static a a(Context r8, int r9, int r10, c r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r11, c.class, "com.obric.memorydata.plugin");
        if (r10 == 0) goto L5;
        ContextThemeWrapper r1 = new ContextThemeWrapper(r12, r9);
        r9 = r10;
        r12 = r1;
    L5:
        TypedArray r14 = r12.obtainStyledAttributes(r9, R.styleable.ShapeAppearance);
        int r15 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerFamily, "styleable", "ShapeAppearance_cornerFamily"), 0);     // Catch: Throwable -> L9
        int r16 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerFamilyTopLeft, "styleable", "ShapeAppearance_cornerFamilyTopLeft"), r15);     // Catch: Throwable -> L9
        int r2 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerFamilyTopRight, "styleable", "ShapeAppearance_cornerFamilyTopRight"), r15);     // Catch: Throwable -> L9
        int r3 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerFamilyBottomRight, "styleable", "ShapeAppearance_cornerFamilyBottomRight"), r15);     // Catch: Throwable -> L9
        int r17 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, "styleable", "ShapeAppearance_cornerFamilyBottomLeft"), r15);     // Catch: Throwable -> L9
        c r18 = a(r14, ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerSize, "styleable", "ShapeAppearance_cornerSize"), r13);     // Catch: Throwable -> L9
        c r4 = a(r14, ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerSizeTopLeft, "styleable", "ShapeAppearance_cornerSizeTopLeft"), r18);     // Catch: Throwable -> L9
        c r5 = a(r14, ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerSizeTopRight, "styleable", "ShapeAppearance_cornerSizeTopRight"), r18);     // Catch: Throwable -> L9
        c r6 = a(r14, ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerSizeBottomRight, "styleable", "ShapeAppearance_cornerSizeBottomRight"), r18);     // Catch: Throwable -> L9
        c r19 = a(r14, ZeusTransformUtils.mapRes(R.styleable.ShapeAppearance_cornerSizeBottomLeft, "styleable", "ShapeAppearance_cornerSizeBottomLeft"), r18);     // Catch: Throwable -> L9
        a r20 = new a().a(r16, r4).b(r2, r5).c(r3, r6).d(r17, r19);     // Catch: Throwable -> L9
        r14.recycle();
        return r20;
    L9:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    public static a a(Context r2, AttributeSet r3, int r4, int r5) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), r4, r5, 0);
    }

    public static a a(Context r2, AttributeSet r3, int r4, int r5, int r6) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), r4, r5, new com.google.android.material.shape.a(r6));
    }

    public static a a(Context r3, AttributeSet r4, int r5, int r6, c r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        TypedArray r11 = r8.obtainStyledAttributes(r9, R.styleable.MaterialShape, r5, r6);
        int r12 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialShape_shapeAppearance, "styleable", "MaterialShape_shapeAppearance"), 0);
        int r13 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialShape_shapeAppearanceOverlay, "styleable", "MaterialShape_shapeAppearanceOverlay"), 0);
        r11.recycle();
        return a(r8, r12, r13, r10);
    }

    public l a(float r1) {
        return n().a(r1).a();
    }

    public l a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        return n().a(r4).a();
    }

    public l a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        return n().b(r4.a(f())).c(r4.a(g())).e(r4.a(i())).d(r4.a(h())).a();
    }

    public boolean a(RectF r6) {
        if (this.m.getClass().equals(f.class) == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        float r3 = this.f.a(r6);
        if (this.g.a(r6) == r3) goto L15;
    L19:
        boolean r7 = false;
    L21:
        if (ZeusTransformUtils.instanceOf(this.c, k.class) == true) goto L23;
    L29:
        boolean r5 = false;
    L30:
        if (r0 == false) goto L35;
        if (r7 == false) goto L35;
        if (r5 == false) goto L35;
        return true;
    L35:
        return false;
    L23:
        if (ZeusTransformUtils.instanceOf(this.f4050b, k.class) == false) goto L29;
        if (ZeusTransformUtils.instanceOf(this.d, k.class) == false) goto L29;
        if (ZeusTransformUtils.instanceOf(this.e, k.class) == false) goto L29;
        r5 = true;
        goto L30
    L15:
        if (this.i.a(r6) != r3) goto L19;
        if (this.h.a(r6) != r3) goto L19;
        r7 = true;
        goto L21
    L5:
        if (this.k.getClass().equals(f.class) == false) goto L11;
        if (this.j.getClass().equals(f.class) == false) goto L11;
        if (this.l.getClass().equals(f.class) == false) goto L11;
        r0 = true;
        goto L12
    }

    public d b() {
        return this.f4050b;
    }

    public d c() {
        return this.c;
    }

    public d d() {
        return this.d;
    }

    public d e() {
        return this.e;
    }

    public c f() {
        return this.f;
    }

    public c g() {
        return this.g;
    }

    public c h() {
        return this.h;
    }

    public c i() {
        return this.i;
    }

    public f j() {
        return this.m;
    }

    public f k() {
        return this.j;
    }

    public f l() {
        return this.k;
    }

    public f m() {
        return this.l;
    }

    public a n() {
        return new a(this);
    }
}
