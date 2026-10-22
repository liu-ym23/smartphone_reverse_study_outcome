package tp9;

import android.animation.TypeEvaluator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements TypeEvaluator<float[]> {
    public final float[] a;

    public a(float[] r2) {
        Intrinsics.checkNotNullParameter(r2, "mArray");
        this.a = r2;
    }

    @Override // android.animation.TypeEvaluator
    public final float[] evaluate(float r6, float[] r7, float[] r8) {
        float[] r9 = r7;
        float[] r10 = r8;
        Intrinsics.checkNotNullParameter(r9, "startValue");
        Intrinsics.checkNotNullParameter(r10, "endValue");
        float[] r0 = this.a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        float r3 = r9[r2];
        r0[r2] = r3 + ((r10[r2] - r3) * r6);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
