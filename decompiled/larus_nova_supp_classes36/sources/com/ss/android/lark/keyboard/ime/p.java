package com.ss.android.lark.keyboard.ime;

import android.animation.ValueAnimator;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ImeWrapper c;

    public p(int r1, int r2, ImeWrapper r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r11) {
        Intrinsics.checkNotNullParameter(r11, "it");
        Object r12 = r11.getAnimatedValue();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Float");
        float r13 = ((Float) r12).floatValue();
        int r0 = this.a;
        float r14 = r13 / 1000.0f;
        int r1 = Math.max(MathKt.roundToInt(r0 + ((this.b - r0) * r14)), 0);
        Log.d("ImeWrapper", "onProgress: height is " + r1);
        float r15 = RangesKt.coerceIn(r14, 0.0f, 1.0f);
        List<e> r2 = this.c.j;
        int r8 = this.a;
        int r9 = this.b;
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        e r4 = (e) r3.next();
        Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
        r4.g(1, r8, r9, r1, r15);
        goto L4
    }
}
