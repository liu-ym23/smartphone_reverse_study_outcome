package ag;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements TypeEvaluator<PointF> {
    public final PointF a;

    public c(PointF r10) {
        Intrinsics.checkNotNullParameter(r10, "controlPoint");
        this.a = r10;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r10, PointF r11, PointF r12) {
        PointF r13 = r11;
        PointF r14 = r12;
        Intrinsics.checkNotNullParameter(r13, "startValue");
        Intrinsics.checkNotNullParameter(r14, "endValue");
        PointF r0 = new PointF();
        float r1 = 1 - r10;
        float r15 = r1 * r1;
        float r16 = r13.x * r15;
        float r17 = (2 * r10) * r1;
        PointF r18 = this.a;
        float r19 = r10 * r10;
        r0.x = (r16 + (r18.x * r17)) + (r14.x * r19);
        r0.y = ((r15 * r13.y) + (r17 * r18.y)) + (r19 * r14.y);
        return r0;
    }
}
