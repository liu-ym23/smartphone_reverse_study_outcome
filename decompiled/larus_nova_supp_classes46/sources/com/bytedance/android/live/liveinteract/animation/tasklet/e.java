package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ IconMoveAnimationTasklet a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ EPointF c;
    public final /* synthetic */ EPointF d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Animatable g;

    public e(IconMoveAnimationTasklet r1, HSImageView r2, EPointF r3, EPointF r4, Ref.BooleanRef r5, int r6, Animatable r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animator");
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L16;
        PointF r7 = (PointF) r6;
        HSImageView r0 = this.b;
        r0.setX(r7.x - (r0.getLayoutParams().width / 2));
        HSImageView r1 = this.b;
        r1.setY(r7.y - (r1.getLayoutParams().height / 2));
        if (this.a.m.ha(com.bytedance.android.live.liveinteract.utils.v.b(r7), this.c, this.d) == false) goto L8;
        UtilityKotlinExtentionsKt.t(this.b);
        ALogger.d("InteractAnimation.IconMoveAnimationTasklet", this.a + " force gone");
    L8:
        if (this.e.element == true) goto L11;
        return;
    L11:
        if (this.a.m.Mk(com.bytedance.android.live.liveinteract.utils.v.b(r7), this.c, this.d) == true) goto L13;
        UtilityKotlinExtentionsKt.t(this.b);
        ALogger.d("InteractAnimation.IconMoveAnimationTasklet", this.a + " show path gone");
        this.e.element = false;
        return;
    L13:
        this.a.d(this.b, this.f);
        this.e.element = false;
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
