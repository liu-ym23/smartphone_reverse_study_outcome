package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Animator.AnimatorListener {
    public final /* synthetic */ AppFloatManager a;
    public final /* synthetic */ AppFloatManager.b b;
    public final /* synthetic */ View c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.b.j = false;
        AppFloatManager.b r5 = this.b;
        if (r5 == null) goto L5;
        r5.a();
    L5:
        d r6 = this.a.e;
        if (r6 == null) goto L9;
        int[] r0 = new int[2];
        r6.getLocationOnScreen(r0);
        Log.i("AppFloatManager", "onAnimationEnd, ParentFrameLayout@" + r6.hashCode() + ". rawY: " + r0[1] + ", width: " + r6.getWidth() + ", height: " + r6.getHeight());
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.c.setVisibility(0);
        this.a.b.j = true;
    }

    public a(AppFloatManager r1, AppFloatManager$addView$1$3.a r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
