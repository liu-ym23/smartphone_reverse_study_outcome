package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.ValueAnimator;
import android.graphics.PathMeasure;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CommonDynamicIslandLayoutManager a;
    public final /* synthetic */ PathMeasure b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Integer d;

    public b(CommonDynamicIslandLayoutManager r1, PathMeasure r2, View r3, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L7;
        float[] r0 = new float[2];
        this.b.getPosTan(((Float) r6).floatValue(), r0, null);
        View r7 = this.c;
        Float r1 = this.a.q(Float.valueOf(r0[0]), this.c);
        Intrinsics.checkNotNull(r1);
        r7.setX(r1.floatValue());
        View r8 = this.c;
        Float r2 = CommonDynamicIslandLayoutManager.r(this.a, Float.valueOf(r0[1]), this.c);
        Intrinsics.checkNotNull(r2);
        r8.setY(r2.floatValue());
        ALogger.i(this.a.a, "bezier update to(" + this.c.getX() + ',' + this.c.getY() + "), pos=" + this.d);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
