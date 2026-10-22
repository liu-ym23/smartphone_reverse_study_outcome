package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ Function2<Float, a, Unit> f;

    /* JADX WARN: Multi-variable type inference failed */
    public r(a r1, float r2, float r3, float r4, float r5, Function2<? super Float, ? super a, Unit> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        Float r5 = (Float) r4.getAnimatedValue();
        if (r5 == null) goto L5;
        float r6 = r5.floatValue();
    L6:
        float r7 = r6 / 1000.0f;
        this.a.b.setTranslationY(this.b + (this.c * r7));
        float r0 = this.d + (this.e * r7);
        this.f.invoke(Float.valueOf(r0), this.a);
        return;
    L5:
        r6 = 0.0f;
        goto L6
    }
}
