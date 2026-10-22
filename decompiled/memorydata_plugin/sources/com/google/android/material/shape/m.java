package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n[] f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f4054b;
    private final Matrix[] c;
    private final PointF d;
    private final Path e;
    private final Path f;
    private final n g;
    private final float[] h;
    private final float[] i;
    private final Path j;
    private final Path k;
    private boolean l;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final m f4055a = null;

        static {
            f4055a = new m();
        }
    }

    public interface b {
        void a(n r1, Matrix r2, int r3);

        void b(n r1, Matrix r2, int r3);
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f4056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f4057b;
        public final RectF c;
        public final b d;
        public final float e;

        c(l r3, float r4, RectF r5, b r6, Path r7) {
            this.d = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
            this.f4056a = r3;
            this.e = r4;
            this.c = r5;
            this.f4057b = r7;
        }
    }

    public m() {
        this.f4053a = new n[4];
        this.f4054b = new Matrix[4];
        this.c = new Matrix[4];
        this.d = new PointF();
        this.e = new Path();
        this.f = new Path();
        this.g = new n();
        this.h = new float[2];
        this.i = new float[2];
        this.j = new Path();
        this.k = new Path();
        this.l = true;
        int r1 = 0;
    L3:
        if (r1 >= 4) goto L5;
        this.f4053a[r1] = new n();
        this.f4054b[r1] = new Matrix();
        this.c[r1] = new Matrix();
        r1 = r1 + 1;
        goto L3
    }

    private float a(RectF r5, int r6) {
        this.h[0] = this.f4053a[r6].c;
        this.h[1] = this.f4053a[r6].d;
        this.f4054b[r6].mapPoints(this.h);
        if (r6 != 1) goto L5;
    L9:
        float r7 = r5.centerX();
        float r4 = this.h[0];
    L8:
        return Math.abs(r7 - r4);
    L5:
        if (r6 == 3) goto L9;
        r7 = r5.centerY();
        r4 = this.h[1];
        goto L8
    }

    private d a(int r1, l r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.c();
    L11:
        return r2.b();
    L13:
        return r2.e();
    L15:
        return r2.d();
    }

    public static m a() {
        return a.f4055a;
    }

    private void a(int r6) {
        this.h[0] = this.f4053a[r6].d();
        this.h[1] = this.f4053a[r6].e();
        this.f4054b[r6].mapPoints(this.h);
        float r0 = b(r6);
        this.c[r6].reset();
        Matrix r1 = this.c[r6];
        float[] r4 = this.h;
        r1.setTranslate(r4[0], r4[1]);
        this.c[r6].preRotate(r0);
    }

    private void a(int r1, RectF r2, PointF r3) {
        if (r1 != 1) goto L5;
        float r0 = r2.right;
    L14:
        float r4 = r2.bottom;
    L10:
        r3.set(r0, r4);
        return;
    L5:
        if (r1 != 2) goto L7;
        r0 = r2.left;
        goto L14
    L7:
        if (r1 == 3) goto L11;
        r0 = r2.right;
    L9:
        r4 = r2.top;
        goto L10
    L11:
        r0 = r2.left;
        goto L9
    }

    private void a(c r8, int r9) {
        com.google.android.material.shape.c r6 = b(r9, r8.f4056a);
        a(r9, r8.f4056a).a(this.f4053a[r9], 90.0f, r8.e, r8.c, r6);
        float r0 = b(r9);
        this.f4054b[r9].reset();
        a(r9, r8.c, this.d);
        this.f4054b[r9].setTranslate(this.d.x, this.d.y);
        this.f4054b[r9].preRotate(r0);
    }

    private boolean a(Path r3, int r4) {
        this.k.reset();
        this.f4053a[r4].a(this.f4054b[r4], this.k);
        RectF r5 = new RectF();
        r3.computeBounds(r5, true);
        this.k.computeBounds(r5, true);
        r3.op(this.k, Path.Op.INTERSECT);
        r3.computeBounds(r5, true);
        if (r5.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r5.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r5.height() <= 1.0f) goto L9;
        return true;
    }

    private float b(int r1) {
        return (r1 + 1) * 90;
    }

    private com.google.android.material.shape.c b(int r1, l r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.g();
    L11:
        return r2.f();
    L13:
        return r2.i();
    L15:
        return r2.h();
    }

    private void b(c r5, int r6) {
        this.h[0] = this.f4053a[r6].b();
        this.h[1] = this.f4053a[r6].c();
        this.f4054b[r6].mapPoints(this.h);
        Path r0 = r5.f4057b;
        float[] r1 = this.h;
        if (r6 != 0) goto L5;
        r0.moveTo(r1[0], r1[1]);
    L6:
        this.f4053a[r6].a(this.f4054b[r6], r5.f4057b);
        if (r5.d == null) goto L10;
        r5.d.a(this.f4053a[r6], this.f4054b[r6], r6);
        return;
    L10:
        return;
    L5:
        r0.lineTo(r1[0], r1[1]);
        goto L6
    }

    private f c(int r1, l r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.l();
    L11:
        return r2.k();
    L13:
        return r2.j();
    L15:
        return r2.m();
    }

    private void c(c r9, int r10) {
        int r0 = (r10 + 1) % 4;
        this.h[0] = this.f4053a[r10].d();
        this.h[1] = this.f4053a[r10].e();
        this.f4054b[r10].mapPoints(this.h);
        this.i[0] = this.f4053a[r0].b();
        this.i[1] = this.f4053a[r0].c();
        this.f4054b[r0].mapPoints(this.i);
        float[] r1 = this.h;
        float r2 = r1[0];
        float[] r5 = this.i;
        float r3 = Math.max(((float) Math.hypot(r2 - r5[0], r1[1] - r5[1])) - 0.001f, 0.0f);
        float r6 = a(r9.c, r10);
        this.g.a(0.0f, 0.0f);
        f r4 = c(r10, r9.f4056a);
        r4.a(r3, r6, r9.e, this.g);
        this.j.reset();
        this.g.a(this.c[r10], this.j);
        if (this.l == true) goto L5;
    L13:
        n r7 = this.g;
        Matrix r8 = this.c[r10];
        Path r11 = r9.f4057b;
    L14:
        r7.a(r8, r11);
        if (r9.d == null) goto L18;
        r9.d.b(this.g, this.c[r10], r10);
        return;
    L18:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L13;
        if (r4.g() == false) goto L9;
    L12:
        Path r12 = this.j;
        r12.op(r12, this.f, Path.Op.DIFFERENCE);
        this.h[0] = this.g.b();
        this.h[1] = this.g.c();
        this.c[r10].mapPoints(this.h);
        Path r13 = this.e;
        float[] r14 = this.h;
        r13.moveTo(r14[0], r14[1]);
        r7 = this.g;
        r8 = this.c[r10];
        r11 = this.e;
        goto L14
    L9:
        if (a(this.j, r10) == true) goto L12;
        if (a(this.j, r0) == false) goto L13;
        goto L12
    }

    public void a(l r7, float r8, RectF r9, Path r10) {
        a(r7, r8, r9, null, r10);
    }

    public void a(l r7, float r8, RectF r9, b r10, Path r11) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.memorydata.plugin");
        r11.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(r9, Path.Direction.CW);
        c r12 = new c(r7, r8, r9, r4, r11);
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= 4) goto L6;
        a(r12, r14);
        a(r14);
        r14 = r14 + 1;
    L6:
        if (r13 >= 4) goto L8;
        b(r12, r13);
        c(r12, r13);
        r13 = r13 + 1;
        goto L6
    L8:
        r11.close();
        this.e.close();
        if (Build.VERSION.SDK_INT >= 19) goto L11;
        return;
    L11:
        if (this.e.isEmpty() == true) goto L17;
        r11.op(this.e, Path.Op.UNION);
        return;
    }

    void a(boolean r1) {
        this.l = r1;
    }
}
