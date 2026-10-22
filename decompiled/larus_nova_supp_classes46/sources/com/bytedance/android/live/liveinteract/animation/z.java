package com.bytedance.android.live.liveinteract.animation;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ y a;
    public final /* synthetic */ int b;
    public final /* synthetic */ EPointF c;
    public final /* synthetic */ EPointF d;
    public final /* synthetic */ Ref.BooleanRef e;

    public z(y r1, int r2, EPointF r3, EPointF r4, Ref.BooleanRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L25;
        PointF r8 = (PointF) r7;
        HSImageView r0 = this.a.e;
        Intrinsics.checkNotNull(r0);
        float r1 = r8.x;
        e r2 = this.a.d;
        Intrinsics.checkNotNull(r2);
        r0.setX(r1 - (r2.qq(this.b) / 2));
        HSImageView r3 = this.a.e;
        Intrinsics.checkNotNull(r3);
        float r4 = r8.y;
        e r5 = this.a.d;
        Intrinsics.checkNotNull(r5);
        r3.setY(r4 - (r5.qq(this.b) / 2));
        e r9 = this.a.d;
        Intrinsics.checkNotNull(r9);
        if (r9.ha(com.bytedance.android.live.liveinteract.utils.v.b(r8), this.c, this.d) == false) goto L8;
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", "force path emoji to invisible x=" + r8.x);
        HSImageView r10 = this.a.e;
        Intrinsics.checkNotNull(r10);
        UtilityKotlinExtentionsKt.u(r10);
    L8:
        if (this.e.element == false) goto L29;
        e r11 = this.a.d;
        Intrinsics.checkNotNull(r11);
        boolean r12 = r11.Mk(com.bytedance.android.live.liveinteract.utils.v.b(r8), this.c, this.d);
        if (r12 == true) goto L17;
        InteractAnimationController.c r13 = this.a.o;
        if (r13 == null) goto L17;
        if (r13.c != true) goto L17;
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", "change path emoji to invisible x=" + r8.x);
        HSImageView r14 = this.a.e;
        Intrinsics.checkNotNull(r14);
        UtilityKotlinExtentionsKt.u(r14);
        this.e.element = false;
    L17:
        if (r12 == false) goto L26;
        InteractAnimationController.c r15 = this.a.o;
        if (r15 != null) goto L21;
        return;
    L21:
        if (r15.c == true) goto L28;
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", "change path emoji to real size x=" + r8.x);
        this.a.p(this.b);
        this.e.element = false;
        return;
    L28:
        return;
    L26:
        return;
    L29:
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
