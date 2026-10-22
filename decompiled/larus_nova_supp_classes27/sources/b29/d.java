package b29;

import android.animation.TypeEvaluator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements TypeEvaluator<int[]> {
    public d() {
    }

    @Override // android.animation.TypeEvaluator
    public final int[] evaluate(float r7, int[] r8, int[] r9) {
        int[] r10 = r8;
        int[] r11 = r9;
        Intrinsics.checkNotNullParameter(r10, "startValue");
        Intrinsics.checkNotNullParameter(r11, "endValue");
        int r0 = r10.length;
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r3 = r10[r2];
        r1[r2] = (int) (r3 + ((r11[r2] - r3) * r7));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
