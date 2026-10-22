package r82;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements TypeEvaluator<PointF> {
    public b() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r9, PointF r10, PointF r11) {
        PointF r13 = r10;
        PointF r14 = r11;
        Intrinsics.checkNotNullParameter(r13, "startValue");
        Intrinsics.checkNotNullParameter(r14, "endValue");
        float r15 = r14.y - r13.y;
        if (r9 >= 0.5f) goto L5;
        float r3 = 2;
        float r4 = r3 * r9;
        float r5 = r13.x;
        float r0 = 1 - r4;
        return new PointF((((r0 * r0) * r5) + (((r3 * r4) * r0) * (r5 - 8))) + ((r4 * r4) * r5), r13.y + (r15 * r9));
    L5:
        float r6 = (float) ((((double) r9) - 0.5d) * ((double) 2));
        float r7 = r13.x;
        float r1 = 1 - r6;
        return new PointF((((r1 * r1) * r7) + (((2 * r6) * r1) * (8 + r7))) + ((r6 * r6) * r7), r13.y + (r15 * r9));
    }
}
