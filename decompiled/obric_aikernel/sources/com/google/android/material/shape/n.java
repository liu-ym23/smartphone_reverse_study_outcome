package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f3687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f3688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f3689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f3690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f3691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f3692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f3693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f3694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3695i;

    class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f3696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f3697c;

        a(n r10, List r11, Matrix r12) {
            this.f3696b = r11;
            this.f3697c = r12;
        }

        @Override // com.google.android.material.shape.n.g
        public void b(Matrix r10, a6.a r11, int r12, Canvas r13) {
            Iterator r14 = this.f3696b.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            ((g) r14.next()).b(this.f3697c, r11, r12, r13);
            goto L4
        }
    }

    static class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f3698b;

        public b(d r10) {
            this.f3698b = r10;
        }

        @Override // com.google.android.material.shape.n.g
        public void b(Matrix r10, @NonNull a6.a r11, int r12, @NonNull Canvas r13) {
            float r14 = d.h(this.f3698b);
            float r15 = d.i(this.f3698b);
            r11.a(r13, r10, new RectF(d.b(this.f3698b), d.c(this.f3698b), d.d(this.f3698b), d.e(this.f3698b)), r12, r14, r15);
        }
    }

    static class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f3699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f3700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f3701d;

        public c(e r10, float r11, float r12) {
            this.f3699b = r10;
            this.f3700c = r11;
            this.f3701d = r12;
        }

        @Override // com.google.android.material.shape.n.g
        public void b(Matrix r10, @NonNull a6.a r11, int r12, @NonNull Canvas r13) {
            RectF r14 = new RectF(0.0f, 0.0f, (float) Math.hypot(e.d(this.f3699b) - this.f3701d, e.b(this.f3699b) - this.f3700c), 0.0f);
            Matrix r15 = new Matrix(r10);
            r15.preTranslate(this.f3700c, this.f3701d);
            r15.preRotate(c());
            r11.b(r13, r15, r14, r12);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((e.d(this.f3699b) - this.f3701d) / (e.b(this.f3699b) - this.f3700c)));
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f3702h = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f3703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f3704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f3705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f3706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f3707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f3708g;

        static {
            f3702h = new RectF();
        }

        public d(float r10, float r11, float r12, float r13) {
            q(r10);
            u(r11);
            r(r12);
            p(r13);
        }

        static /* synthetic */ float b(d r10) {
            return r10.k();
        }

        static /* synthetic */ float c(d r10) {
            return r10.o();
        }

        static /* synthetic */ float d(d r10) {
            return r10.l();
        }

        static /* synthetic */ float e(d r10) {
            return r10.j();
        }

        static /* synthetic */ void f(d r10, float r11) {
            r10.s(r11);
        }

        static /* synthetic */ void g(d r10, float r11) {
            r10.t(r11);
        }

        static /* synthetic */ float h(d r10) {
            return r10.m();
        }

        static /* synthetic */ float i(d r10) {
            return r10.n();
        }

        private float j() {
            return this.f3706e;
        }

        private float k() {
            return this.f3703b;
        }

        private float l() {
            return this.f3705d;
        }

        private float m() {
            return this.f3707f;
        }

        private float n() {
            return this.f3708g;
        }

        private float o() {
            return this.f3704c;
        }

        private void p(float r10) {
            this.f3706e = r10;
        }

        private void q(float r10) {
            this.f3703b = r10;
        }

        private void r(float r10) {
            this.f3705d = r10;
        }

        private void s(float r10) {
            this.f3707f = r10;
        }

        private void t(float r10) {
            this.f3708g = r10;
        }

        private void u(float r10) {
            this.f3704c = r10;
        }

        @Override // com.google.android.material.shape.n.f
        public void a(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r12 = this.f3711a;
            r10.invert(r12);
            r11.transform(r12);
            RectF r13 = f3702h;
            r13.set(k(), o(), l(), j());
            r11.arcTo(r13, m(), n(), false);
            r11.transform(r10);
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f3709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f3710c;

        public e() {
        }

        static /* synthetic */ float b(e r10) {
            return r10.f3709b;
        }

        static /* synthetic */ float c(e r10, float r11) {
            r10.f3709b = r11;
            return r11;
        }

        static /* synthetic */ float d(e r10) {
            return r10.f3710c;
        }

        static /* synthetic */ float e(e r10, float r11) {
            r10.f3710c = r11;
            return r11;
        }

        @Override // com.google.android.material.shape.n.f
        public void a(@NonNull Matrix r10, @NonNull Path r11) {
            Matrix r12 = this.f3711a;
            r10.invert(r12);
            r11.transform(r12);
            r11.lineTo(this.f3709b, this.f3710c);
            r11.transform(r10);
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f3711a;

        public f() {
            this.f3711a = new Matrix();
        }

        public abstract void a(Matrix r10, Path r11);
    }

    static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Matrix f3712a = null;

        static {
            f3712a = new Matrix();
        }

        g() {
        }

        public final void a(a6.a r10, int r11, Canvas r12) {
            b(f3712a, r10, r11, r12);
        }

        public abstract void b(Matrix r10, a6.a r11, int r12, Canvas r13);
    }

    public n() {
        this.f3693g = new ArrayList();
        this.f3694h = new ArrayList();
        n(0.0f, 0.0f);
    }

    private void b(float r10) {
        if (g() != r10) goto L5;
        return;
    L5:
        float r11 = ((r10 - g()) + 360.0f) % 360.0f;
        if (r11 <= 180.0f) goto L8;
        return;
    L8:
        d r12 = new d(i(), j(), i(), j());
        d.f(r12, g());
        d.g(r12, r11);
        this.f3694h.add(new b(r12));
        p(r10);
    }

    private void c(g r10, float r11, float r12) {
        b(r11);
        this.f3694h.add(r10);
        p(r12);
    }

    private float g() {
        return this.f3691e;
    }

    private float h() {
        return this.f3692f;
    }

    private void p(float r10) {
        this.f3691e = r10;
    }

    private void q(float r10) {
        this.f3692f = r10;
    }

    private void r(float r10) {
        this.f3689c = r10;
    }

    private void s(float r10) {
        this.f3690d = r10;
    }

    private void t(float r10) {
        this.f3687a = r10;
    }

    private void u(float r10) {
        this.f3688b = r10;
    }

    public void a(float r10, float r11, float r12, float r13, float r14, float r15) {
        d r16 = new d(r10, r11, r12, r13);
        d.f(r16, r14);
        d.g(r16, r15);
        this.f3693g.add(r16);
        b r17 = new b(r16);
        float r18 = r14 + r15;
        if (r15 >= 0.0f) goto L5;
        boolean r19 = true;
    L7:
        if (r19 == false) goto L9;
        r14 = (r14 + 180.0f) % 360.0f;
    L9:
        if (r19 == false) goto L11;
        float r20 = (180.0f + r18) % 360.0f;
    L12:
        c(r17, r14, r20);
        double r21 = r18;
        r(((r10 + r12) * 0.5f) + (((r12 - r10) / 2.0f) * ((float) Math.cos(Math.toRadians(r21)))));
        s(((r11 + r13) * 0.5f) + (((r13 - r11) / 2.0f) * ((float) Math.sin(Math.toRadians(r21)))));
        return;
    L11:
        r20 = r18;
        goto L12
    L5:
        r19 = false;
        goto L7
    }

    public void d(Matrix r10, Path r11) {
        int r12 = this.f3693g.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.f3693g.get(r13).a(r10, r11);
        r13 = r13 + 1;
        goto L3
    }

    boolean e() {
        return this.f3695i;
    }

    @NonNull
    g f(Matrix r10) {
        b(h());
        Matrix r11 = new Matrix(r10);
        return new a(this, new ArrayList(this.f3694h), r11);
    }

    float i() {
        return this.f3689c;
    }

    float j() {
        return this.f3690d;
    }

    float k() {
        return this.f3687a;
    }

    float l() {
        return this.f3688b;
    }

    public void m(float r10, float r11) {
        e r12 = new e();
        e.c(r12, r10);
        e.e(r12, r11);
        this.f3693g.add(r12);
        c r13 = new c(r12, i(), j());
        c(r13, r13.c() + 270.0f, r13.c() + 270.0f);
        r(r10);
        s(r11);
    }

    public void n(float r10, float r11) {
        o(r10, r11, 270.0f, 0.0f);
    }

    public void o(float r10, float r11, float r12, float r13) {
        t(r10);
        u(r11);
        r(r10);
        s(r11);
        p(r12);
        q((r12 + r13) % 360.0f);
        this.f3693g.clear();
        this.f3694h.clear();
        this.f3695i = false;
    }
}
