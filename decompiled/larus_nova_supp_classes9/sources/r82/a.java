package r82;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements TypeEvaluator<PointF> {
    public a() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r11, PointF r13, PointF r14) {
        PointF r15 = r13;
        PointF r16 = r14;
        Intrinsics.checkNotNullParameter(r15, "startValue");
        Intrinsics.checkNotNullParameter(r16, "endValue");
        float r0 = r16.y - r15.y;
        float r17 = r16.x - r15.x;
        if (r11 >= 0.5f) goto L5;
        float r2 = 2;
        float r4 = r2 * r11;
        float r5 = r15.x;
        float r1 = 1 - r4;
        return new PointF((((r1 * r1) * r5) + (((r2 * r4) * r1) * (r5 - 8))) + ((r4 * r4) * r5), r15.y + (r0 * r11));
    L5:
        double r6 = (((double) r11) - 0.5d) * ((double) 2);
        float r7 = (float) r6;
        float r8 = r15.x;
        float r3 = 1 - r7;
        return new PointF((float) (((double) ((((r3 * r3) * r8) + (((2 * r7) * r3) * (8 + r8))) + ((r7 * r7) * r8))) + (r6 * ((double) r17))), r15.y + (r0 * r11));
    }
}
