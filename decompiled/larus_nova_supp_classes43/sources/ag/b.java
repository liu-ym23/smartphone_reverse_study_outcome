package ag;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements TypeEvaluator<PointF> {
    public b() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r10, PointF r11, PointF r12) {
        PointF r13 = r11;
        PointF r14 = r12;
        Intrinsics.checkNotNullParameter(r13, "startValue");
        Intrinsics.checkNotNullParameter(r14, "endValue");
        PointF r0 = new PointF();
        float r1 = r13.x;
        float r15 = 1.0f - r10;
        r0.x = r1 + ((r14.x - r1) * (1.0f - (r15 * r15)));
        float r16 = r13.y;
        r0.y = r16 + ((r14.y - r16) * (r10 * r10));
        return r0;
    }
}
