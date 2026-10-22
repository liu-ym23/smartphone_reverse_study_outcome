package com.larus.bmhome.chat.component.bottom.core;

import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l5 implements Function2 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ l5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r13, Object r14) {
        CoreInputComponent r0 = this.a;
        boolean r15 = ((Boolean) r13).booleanValue();
        WindowInsetsAnimationCompat r16 = (WindowInsetsAnimationCompat) r14;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r16, "animation");
        r0.getClass();
        long r2 = r16.getDurationMillis();
        long r4 = 0;
        if (r2 > 0) goto L5;
        long r3 = 280;
    L16:
        r0.X2 = Long.valueOf(r3);
        r0.b7(r15);
        r0.X2 = null;
        return Unit.INSTANCE;
    L5:
        Interpolator r17 = r16.getInterpolator();
        if (r17 != null) goto L9;
        r3 = RangesKt.coerceIn(r2, 120, 400);
    L9:
        if (r4 > r2) goto L14;
        if (r17.getInterpolation(r4 / r2) >= 0.95f) goto L12;
        r4 = r4 + ((long) 4);
        goto L9
    L12:
        long r6 = r4;
    L15:
        r3 = RangesKt.coerceIn(r6, 120, 400);
        goto L16
    L14:
        r6 = r2;
        goto L15
    }
}
