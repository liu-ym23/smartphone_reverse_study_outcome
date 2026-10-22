package com.bytedance.android.live.matchroom;

import android.animation.Animator;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements Animator.AnimatorListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ View b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "animation");
        boolean r9 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.e.removeListener(this);
        if (this.a == true) goto L5;
        return;
    L5:
        View r10 = this.b;
        if (r10 == null) goto L24;
        ViewParent r0 = r10.getParent();
        if ((r0 instanceof FrameLayout) == true) goto L10;
        r0 = null;
    L10:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L25;
        float r2 = r1.getWidth();
        float r3 = r1.getHeight();
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), parentWidth is " + r2 + ", parentHeight is " + r3);
        float r4 = (float) 2;
        float r5 = r2 / r4;
        if (Math.abs(r10.getPivotX() - r5) <= 1.0f) goto L15;
    L16:
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), pivotX and pivotY are set to half of parent size.");
        r10.setPivotX(r5);
        r10.setPivotY(r3 / r4);
    L17:
        float r6 = 0;
        if (Math.abs(r10.getTranslationX() - r6) <= 1.0f) goto L21;
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), translationX is set to 0.");
        r10.setTranslationX(0.0f);
    L21:
        if (Math.abs(r10.getTranslationY() - r6) <= 1.0f) goto L26;
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), translationY is set to 0.");
        r10.setTranslationY(0.0f);
        return;
    L26:
        return;
    L15:
        if (Math.abs(r10.getPivotY() - (r3 / r4)) <= 1.0f) goto L17;
    L25:
        return;
    }

    public l(boolean r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
