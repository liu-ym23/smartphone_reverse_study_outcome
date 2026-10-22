package com.google.android.material.animation;

import ai.j0;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues;

    public MatrixEvaluator() {
        this.tempStartValues = new float[9];
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    @Override // android.animation.TypeEvaluator
    @NonNull
    public /* bridge */ /* synthetic */ Matrix evaluate(float r5, @NonNull Matrix r10, @NonNull Matrix r11) {
        return evaluate2(r5, r10, r11);
    }

    @NonNull
    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float r5, @NonNull Matrix r10, @NonNull Matrix r11) {
        r10.getValues(this.tempStartValues);
        r11.getValues(this.tempEndValues);
        int r12 = 0;
    L4:
        if (r12 >= 9) goto L6;
        float[] r13 = this.tempEndValues;
        float r14 = r13[r12];
        float r15 = this.tempStartValues[r12];
        r13[r12] = j0.b(r14, r15, r5, r15);
        r12 = r12 + 1;
        goto L4
    L6:
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
