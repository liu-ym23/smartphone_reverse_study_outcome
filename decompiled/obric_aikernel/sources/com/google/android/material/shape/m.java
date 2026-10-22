package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n[] f3669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f3670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f3671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f3672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f3673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f3674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n f3675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f3676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f3677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f3678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f3679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3680l;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final m f3681a = null;

        static {
            f3681a = new m();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface b {
        void a(n r10, Matrix r11, int r12);

        void b(n r10, Matrix r11, int r12);
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final l f3682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final Path f3683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final RectF f3684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final b f3685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f3686e;

        c(@NonNull l r10, float r11, RectF r12, @Nullable b r13, Path r14) {
            this.f3685d = r13;
            this.f3682a = r10;
            this.f3686e = r11;
            this.f3684c = r12;
            this.f3683b = r14;
        }
    }

    public m() {
        this.f3669a = new n[4];
        this.f3670b = new Matrix[4];
        this.f3671c = new Matrix[4];
        this.f3672d = new PointF();
        this.f3673e = new Path();
        this.f3674f = new Path();
        this.f3675g = new n();
        this.f3676h = new float[2];
        this.f3677i = new float[2];
        this.f3678j = new Path();
        this.f3679k = new Path();
        this.f3680l = true;
        int r10 = 0;
    L3:
        if (r10 >= 4) goto L5;
        this.f3669a[r10] = new n();
        this.f3670b[r10] = new Matrix();
        this.f3671c[r10] = new Matrix();
        r10 = r10 + 1;
        goto L3
    }

    private float a(int r10) {
        return (r10 + 1) * 90;
    }

    private void b(@NonNull c r10, int r11) {
        this.f3676h[0] = this.f3669a[r11].k();
        this.f3676h[1] = this.f3669a[r11].l();
        this.f3670b[r11].mapPoints(this.f3676h);
        Path r12 = r10.f3683b;
        float[] r13 = this.f3676h;
        if (r11 != 0) goto L5;
        r12.moveTo(r13[0], r13[1]);
    L6:
        this.f3669a[r11].d(this.f3670b[r11], r10.f3683b);
        b r14 = r10.f3685d;
        if (r14 == null) goto L10;
        r14.a(this.f3669a[r11], this.f3670b[r11], r11);
        return;
    L10:
        return;
    L5:
        r12.lineTo(r13[0], r13[1]);
        goto L6
    }

    private void c(@NonNull c r10, int r11) {
        int r12 = (r11 + 1) % 4;
        this.f3676h[0] = this.f3669a[r11].i();
        this.f3676h[1] = this.f3669a[r11].j();
        this.f3670b[r11].mapPoints(this.f3676h);
        this.f3677i[0] = this.f3669a[r12].k();
        this.f3677i[1] = this.f3669a[r12].l();
        this.f3670b[r12].mapPoints(this.f3677i);
        float[] r13 = this.f3676h;
        float r14 = r13[0];
        float[] r15 = this.f3677i;
        float r16 = Math.max(((float) Math.hypot(r14 - r15[0], r13[1] - r15[1])) - 0.001f, 0.0f);
        float r17 = i(r10.f3684c, r11);
        this.f3675g.n(0.0f, 0.0f);
        f r18 = j(r11, r10.f3682a);
        r18.d(r16, r17, r10.f3686e, this.f3675g);
        this.f3678j.reset();
        this.f3675g.d(this.f3671c[r11], this.f3678j);
        if (this.f3680l == true) goto L5;
    L13:
        n r19 = this.f3675g;
        Matrix r20 = this.f3671c[r11];
        Path r21 = r10.f3683b;
    L14:
        r19.d(r20, r21);
        b r22 = r10.f3685d;
        if (r22 == null) goto L18;
        r22.b(this.f3675g, this.f3671c[r11], r11);
        return;
    L18:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L13;
        if (r18.b() == false) goto L9;
    L12:
        Path r23 = this.f3678j;
        r23.op(r23, this.f3674f, Path.Op.DIFFERENCE);
        this.f3676h[0] = this.f3675g.k();
        this.f3676h[1] = this.f3675g.l();
        this.f3671c[r11].mapPoints(this.f3676h);
        Path r24 = this.f3673e;
        float[] r25 = this.f3676h;
        r24.moveTo(r25[0], r25[1]);
        r19 = this.f3675g;
        r20 = this.f3671c[r11];
        r21 = this.f3673e;
        goto L14
    L9:
        if (l(this.f3678j, r11) == true) goto L12;
        if (l(this.f3678j, r12) == false) goto L13;
        goto L12
    }

    private void f(int r10, @NonNull RectF r11, @NonNull PointF r12) {
        if (r10 != 1) goto L5;
        float r13 = r11.right;
    L14:
        float r14 = r11.bottom;
    L10:
        r12.set(r13, r14);
        return;
    L5:
        if (r10 != 2) goto L7;
        r13 = r11.left;
        goto L14
    L7:
        if (r10 == 3) goto L11;
        r13 = r11.right;
    L9:
        r14 = r11.top;
        goto L10
    L11:
        r13 = r11.left;
        goto L9
    }

    private com.google.android.material.shape.c g(int r10, @NonNull l r11) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L11;
        return r11.t();
    L11:
        return r11.r();
    L13:
        return r11.j();
    L15:
        return r11.l();
    }

    private d h(int r10, @NonNull l r11) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L11;
        return r11.s();
    L11:
        return r11.q();
    L13:
        return r11.i();
    L15:
        return r11.k();
    }

    private float i(@NonNull RectF r10, int r11) {
        float[] r12 = this.f3676h;
        n[] r13 = this.f3669a;
        r12[0] = r13[r11].f3689c;
        r12[1] = r13[r11].f3690d;
        this.f3670b[r11].mapPoints(r12);
        if (r11 != 1) goto L5;
    L9:
        float r14 = r10.centerX();
        float r15 = this.f3676h[0];
    L8:
        return Math.abs(r14 - r15);
    L5:
        if (r11 == 3) goto L9;
        r14 = r10.centerY();
        r15 = this.f3676h[1];
        goto L8
    }

    private f j(int r10, @NonNull l r11) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L11;
        return r11.o();
    L11:
        return r11.p();
    L13:
        return r11.n();
    L15:
        return r11.h();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static m k() {
        return a.f3681a;
    }

    @RequiresApi(19)
    private boolean l(Path r10, int r11) {
        this.f3679k.reset();
        this.f3669a[r11].d(this.f3670b[r11], this.f3679k);
        RectF r12 = new RectF();
        r10.computeBounds(r12, true);
        this.f3679k.computeBounds(r12, true);
        r10.op(this.f3679k, Path.Op.INTERSECT);
        r10.computeBounds(r12, true);
        if (r12.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r12.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r12.height() <= 1.0f) goto L9;
        return true;
    }

    private void m(@NonNull c r10, int r11) {
        com.google.android.material.shape.c r12 = g(r11, r10.f3682a);
        h(r11, r10.f3682a).b(this.f3669a[r11], 90.0f, r10.f3686e, r10.f3684c, r12);
        float r13 = a(r11);
        this.f3670b[r11].reset();
        f(r11, r10.f3684c, this.f3672d);
        Matrix r14 = this.f3670b[r11];
        PointF r15 = this.f3672d;
        r14.setTranslate(r15.x, r15.y);
        this.f3670b[r11].preRotate(r13);
    }

    private void o(int r10) {
        this.f3676h[0] = this.f3669a[r10].i();
        this.f3676h[1] = this.f3669a[r10].j();
        this.f3670b[r10].mapPoints(this.f3676h);
        float r11 = a(r10);
        this.f3671c[r10].reset();
        Matrix r12 = this.f3671c[r10];
        float[] r13 = this.f3676h;
        r12.setTranslate(r13[0], r13[1]);
        this.f3671c[r10].preRotate(r11);
    }

    public void d(l r10, float r11, RectF r12, @NonNull Path r13) {
        e(r10, r11, r12, null, r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(l r10, float r11, RectF r12, b r13, @NonNull Path r14) {
        r14.rewind();
        this.f3673e.rewind();
        this.f3674f.rewind();
        this.f3674f.addRect(r12, Path.Direction.CW);
        c r15 = new c(r10, r11, r12, r13, r14);
        int r16 = 0;
        int r17 = 0;
    L4:
        if (r17 >= 4) goto L6;
        m(r15, r17);
        o(r17);
        r17 = r17 + 1;
    L6:
        if (r16 >= 4) goto L8;
        b(r15, r16);
        c(r15, r16);
        r16 = r16 + 1;
        goto L6
    L8:
        r14.close();
        this.f3673e.close();
        if (Build.VERSION.SDK_INT >= 19) goto L11;
        return;
    L11:
        if (this.f3673e.isEmpty() == true) goto L17;
        r14.op(this.f3673e, Path.Op.UNION);
        return;
    }

    void n(boolean r10) {
        this.f3680l = r10;
    }
}
