package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    FloatArrayEvaluator(float[] r10) {
        this.mArray = r10;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float r10, float[] r11, float[] r12) {
        return evaluate2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public float[] evaluate2(float r10, float[] r11, float[] r12) {
        float[] r13 = this.mArray;
        if (r13 != null) goto L5;
        r13 = new float[r11.length];
    L5:
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L9;
        float r15 = r11[r14];
        r13[r14] = r15 + ((r12[r14] - r15) * r10);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    }
}
