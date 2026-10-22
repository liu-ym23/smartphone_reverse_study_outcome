package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f3748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f3749b;
    private final Matrix c;

    public g() {
        this.f3748a = new float[9];
        this.f3749b = new float[9];
        this.c = new Matrix();
    }

    public Matrix a(float r4, Matrix r5, Matrix r6) {
        r5.getValues(this.f3748a);
        r6.getValues(this.f3749b);
        int r7 = 0;
    L4:
        if (r7 >= 9) goto L6;
        float[] r8 = this.f3749b;
        float r0 = r8[r7];
        float[] r1 = this.f3748a;
        float r2 = r0 - r1[r7];
        r8[r7] = r1[r7] + (r2 * r4);
        r7 = r7 + 1;
        goto L4
    L6:
        this.c.setValues(this.f3749b);
        return this.c;
    }

    @Override // android.animation.TypeEvaluator
    public /* synthetic */ Matrix evaluate(float r3, Matrix r4, Matrix r5) {
        return a(r3, (Matrix) ZeusTransformUtils.preCheckCast(r4, Matrix.class, "com.obric.memorydata.plugin"), (Matrix) ZeusTransformUtils.preCheckCast(r5, Matrix.class, "com.obric.memorydata.plugin"));
    }
}
