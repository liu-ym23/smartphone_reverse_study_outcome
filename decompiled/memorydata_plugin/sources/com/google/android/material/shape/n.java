package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f4058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f4059b;

    @Deprecated
    public float c;

    @Deprecated
    public float d;

    @Deprecated
    public float e;

    @Deprecated
    public float f;
    private final List<e> g;
    private final List<f> h;
    private boolean i;

    static class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f4062a;

        public a(c r1) {
            this.f4062a = r1;
        }

        @Override // com.google.android.material.shape.n.f
        public void a(Matrix r9, com.google.android.material.h.a r10, int r11, Canvas r12) {
            float r6 = c.a(this.f4062a);
            float r7 = c.b(this.f4062a);
            r10.a(r12, r9, new RectF(c.c(this.f4062a), c.d(this.f4062a), c.e(this.f4062a), c.f(this.f4062a)), r11, r6, r7);
        }
    }

    static class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f4063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f4064b;
        private final float c;

        public b(d r1, float r2, float r3) {
            this.f4063a = r1;
            this.f4064b = r2;
            this.c = r3;
        }

        float a() {
            return (float) Math.toDegrees(Math.atan((d.a(this.f4063a) - this.c) / (d.b(this.f4063a) - this.f4064b)));
        }

        @Override // com.google.android.material.shape.n.f
        public void a(Matrix r6, com.google.android.material.h.a r7, int r8, Canvas r9) {
            RectF r2 = new RectF(0.0f, 0.0f, (float) Math.hypot(d.a(this.f4063a) - this.c, d.b(this.f4063a) - this.f4064b), 0.0f);
            Matrix r0 = new Matrix(r6);
            r0.preTranslate(this.f4064b, this.c);
            r0.preRotate(a());
            r7.a(r9, r0, r2, r8);
        }
    }

    public static class c extends e {
        private static final RectF h = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public float f4065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f4066b;

        @Deprecated
        public float c;

        @Deprecated
        public float d;

        @Deprecated
        public float e;

        @Deprecated
        public float f;

        static {
            h = new RectF();
        }

        public c(float r1, float r2, float r3, float r4) {
            a(r1);
            b(r2);
            c(r3);
            d(r4);
        }

        private float a() {
            return this.f4065a;
        }

        static /* synthetic */ float a(c r0) {
            return r0.e();
        }

        private void a(float r1) {
            this.f4065a = r1;
        }

        static /* synthetic */ void a(c r0, float r1) {
            r0.e(r1);
        }

        private float b() {
            return this.f4066b;
        }

        static /* synthetic */ float b(c r0) {
            return r0.f();
        }

        private void b(float r1) {
            this.f4066b = r1;
        }

        static /* synthetic */ void b(c r0, float r1) {
            r0.f(r1);
        }

        private float c() {
            return this.c;
        }

        static /* synthetic */ float c(c r0) {
            return r0.a();
        }

        private void c(float r1) {
            this.c = r1;
        }

        private float d() {
            return this.d;
        }

        static /* synthetic */ float d(c r0) {
            return r0.b();
        }

        private void d(float r1) {
            this.d = r1;
        }

        private float e() {
            return this.e;
        }

        static /* synthetic */ float e(c r0) {
            return r0.c();
        }

        private void e(float r1) {
            this.e = r1;
        }

        private float f() {
            return this.f;
        }

        static /* synthetic */ float f(c r0) {
            return r0.d();
        }

        private void f(float r1) {
            this.f = r1;
        }

        @Override // com.google.android.material.shape.n.e
        public void a(Matrix r6, Path r7) {
            Matrix r0 = this.g;
            r6.invert(r0);
            r7.transform(r0);
            RectF r1 = h;
            r1.set(a(), b(), c(), d());
            r7.arcTo(r1, e(), f(), false);
            r7.transform(r6);
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f4067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f4068b;

        public d() {
        }

        static /* synthetic */ float a(d r0) {
            return r0.f4068b;
        }

        static /* synthetic */ float a(d r0, float r1) {
            r0.f4067a = r1;
            return r1;
        }

        static /* synthetic */ float b(d r0) {
            return r0.f4067a;
        }

        static /* synthetic */ float b(d r0, float r1) {
            r0.f4068b = r1;
            return r1;
        }

        @Override // com.google.android.material.shape.n.e
        public void a(Matrix r2, Path r3) {
            Matrix r0 = this.g;
            r2.invert(r0);
            r3.transform(r0);
            r3.lineTo(this.f4067a, this.f4068b);
            r3.transform(r2);
        }
    }

    public static abstract class e {
        protected final Matrix g;

        public e() {
            this.g = new Matrix();
        }

        public abstract void a(Matrix r1, Path r2);
    }

    static abstract class f {
        static final Matrix d = null;

        static {
            d = new Matrix();
        }

        f() {
        }

        public abstract void a(Matrix r1, com.google.android.material.h.a r2, int r3, Canvas r4);

        public final void a(com.google.android.material.h.a r2, int r3, Canvas r4) {
            a(d, r2, r3, r4);
        }
    }

    public n() {
        this.g = new ArrayList();
        this.h = new ArrayList();
        a(0.0f, 0.0f);
    }

    private void a(float r7) {
        if (f() != r7) goto L5;
        return;
    L5:
        float r0 = ((r7 - f()) + 360.0f) % 360.0f;
        if (r0 <= 180.0f) goto L8;
        return;
    L8:
        c r1 = new c(d(), e(), d(), e());
        c.a(r1, f());
        c.b(r1, r0);
        this.h.add(new a(r1));
        f(r7);
    }

    private void a(f r1, float r2, float r3) {
        a(r2);
        this.h.add(r1);
        f(r3);
    }

    private void b(float r1) {
        this.f4058a = r1;
    }

    private void c(float r1) {
        this.f4059b = r1;
    }

    private void d(float r1) {
        this.c = r1;
    }

    private void e(float r1) {
        this.d = r1;
    }

    private float f() {
        return this.e;
    }

    private void f(float r1) {
        this.e = r1;
    }

    private float g() {
        return this.f;
    }

    private void g(float r1) {
        this.f = r1;
    }

    f a(Matrix r3) {
        a(g());
        final Matrix r0 = new Matrix(r3);
        final ArrayList r4 = new ArrayList(this.h);
        return new AnonymousClass1(this, r4, r0);
    }

    public void a(float r3, float r4) {
        a(r3, r4, 270.0f, 0.0f);
    }

    public void a(float r1, float r2, float r3, float r4) {
        b(r1);
        c(r2);
        d(r1);
        e(r2);
        f(r3);
        g((r3 + r4) % 360.0f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }

    public void a(float r5, float r6, float r7, float r8, float r9, float r10) {
        c r0 = new c(r5, r6, r7, r8);
        c.a(r0, r9);
        c.b(r0, r10);
        this.g.add(r0);
        a r1 = new a(r0);
        float r2 = r9 + r10;
        if (r10 >= 0.0f) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        r9 = (r9 + 180.0f) % 360.0f;
    L9:
        if (r11 == false) goto L11;
        float r3 = (180.0f + r2) % 360.0f;
    L12:
        a(r1, r9, r3);
        double r4 = r2;
        d(((r5 + r7) * 0.5f) + (((r7 - r5) / 2.0f) * ((float) Math.cos(Math.toRadians(r4)))));
        e(((r6 + r8) * 0.5f) + (((r8 - r6) / 2.0f) * ((float) Math.sin(Math.toRadians(r4)))));
        return;
    L11:
        r3 = r2;
        goto L12
    L5:
        r11 = false;
        goto L7
    }

    public void a(Matrix r6, Path r7) {
        int r0 = this.g.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((e) ZeusTransformUtils.preCheckCast(this.g.get(r1), e.class, "com.obric.memorydata.plugin")).a(r6, r7);
        r1 = r1 + 1;
        goto L3
    }

    boolean a() {
        return this.i;
    }

    float b() {
        return this.f4058a;
    }

    public void b(float r5, float r6) {
        d r0 = new d();
        d.a(r0, r5);
        d.b(r0, r6);
        this.g.add(r0);
        b r1 = new b(r0, d(), e());
        a(r1, r1.a() + 270.0f, r1.a() + 270.0f);
        d(r5);
        e(r6);
    }

    float c() {
        return this.f4059b;
    }

    float d() {
        return this.c;
    }

    float e() {
        return this.d;
    }
}
