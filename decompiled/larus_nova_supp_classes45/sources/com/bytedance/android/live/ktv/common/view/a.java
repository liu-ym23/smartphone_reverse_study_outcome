package com.bytedance.android.live.ktv.common.view;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.view.a$a, reason: collision with other inner class name */
    public static final class C0219a implements TypeEvaluator<PointF> {
        public final PointF a;
        public final PointF b;

        public C0219a(PointF r2, PointF r3) {
            Intrinsics.checkNotNullParameter(r2, "controlPointF1");
            Intrinsics.checkNotNullParameter(r3, "controlPointF2");
            this.a = r2;
            this.b = r3;
        }

        @Override // android.animation.TypeEvaluator
        public final PointF evaluate(float r11, PointF r12, PointF r13) {
            PointF r14 = r12;
            PointF r15 = r13;
            Intrinsics.checkNotNullParameter(r14, "startValue");
            Intrinsics.checkNotNullParameter(r15, "endValue");
            PointF r0 = new PointF();
            float r1 = 1 - r11;
            float r2 = r1 * r1;
            float r3 = r2 * r1;
            float r4 = r11 * r11;
            float r5 = r4 * r11;
            float r6 = r14.x * r3;
            float r7 = 3;
            float r8 = (r2 * r7) * r11;
            PointF r16 = this.a;
            float r9 = r6 + (r16.x * r8);
            float r17 = (r7 * r1) * r4;
            PointF r18 = this.b;
            r0.x = (r9 + (r18.x * r17)) + (r15.x * r5);
            r0.y = (((r3 * r14.y) + (r8 * r16.y)) + (r17 * r18.y)) + (r5 * r15.y);
            return r0;
        }
    }
}
