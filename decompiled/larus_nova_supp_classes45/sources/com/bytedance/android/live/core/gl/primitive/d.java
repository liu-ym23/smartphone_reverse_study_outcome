package com.bytedance.android.live.core.gl.primitive;

import android.opengl.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final e a;
    public final e b;
    public final e c;
    public final RotationOrder d;
    public final float[] e;
    public b f;

    public final void a() {
        Matrix.rotateM(this.e, 0, this.b.a, 1.0f, 0.0f, 0.0f);
    }

    public final void b() {
        Matrix.rotateM(this.e, 0, this.b.b, 0.0f, 1.0f, 0.0f);
    }

    public final void c() {
        Matrix.rotateM(this.e, 0, this.b.c, 0.0f, 0.0f, 1.0f);
    }

    public d() {
        this.a = new e();
        this.b = new e();
        this.c = new e(1.0f, 1.0f, 1.0f);
        this.d = RotationOrder.XYZ;
        float[] r0 = new float[16];
        this.e = r0;
        Matrix.setIdentityM(r0, 0);
    }

    public final void e(Axis r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "axis");
        int r5 = c.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        e r6 = this.a;
        r6.a = r4;
        r6.d = true;
        return;
    L5:
        if (r5 != 2) goto L7;
        e r7 = this.a;
        r7.b = r4;
        r7.d = true;
        return;
    L7:
        if (r5 != 3) goto L15;
        e r8 = this.a;
        r8.c = r4;
        r8.d = true;
        return;
    }

    public final void d(float r5, float r6, float r7) {
        b r0 = this.f;
        if (r0 == null) goto L5;
        float[] r1 = r0.a(new float[]{r5, r6});
    L6:
        if (r1 != null) goto L8;
        e r2 = this.a;
        r2.a = r5;
        r2.b = r6;
        r2.c = r7;
        r2.d = true;
        return;
    L8:
        e r8 = this.a;
        float r9 = r1[0];
        float r3 = r1[1];
        b r4 = this.f;
        if (r4 == null) goto L11;
        r7 = r4.b(r7);
    L11:
        r8.a = r9;
        r8.b = r3;
        r8.c = r7;
        r8.d = true;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
