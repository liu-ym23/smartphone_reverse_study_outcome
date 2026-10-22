package androidx.transition;

import ai.j0;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] r5) {
        this.mArray = r5;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float r5, float[] r10, float[] r11) {
        return evaluate2(r5, r10, r11);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public float[] evaluate2(float r5, float[] r10, float[] r11) {
        float[] r12 = this.mArray;
        if (r12 != null) goto L5;
        r12 = new float[r10.length];
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r12.length) goto L9;
        float r14 = r10[r13];
        r12[r13] = j0.b(r11[r13], r14, r5, r14);
        r13 = r13 + 1;
        goto L7
    L9:
        return r12;
    }
}
