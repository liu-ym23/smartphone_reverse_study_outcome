package com.ss.android.lark.inline.ai.creationai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ CreationAIDragView a;

    public h(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        Log.i("CreationAIDragView", "showAnim end, forceKeyboardWhenShowing = " + this.a.N);
        View r7 = this.a.X;
        if (r7 == null) goto L6;
        r7.setAlpha(1.0f);
    L6:
        if (Intrinsics.areEqual(this.a.N, Boolean.TRUE) == false) goto L8;
        CreationAIDragView r8 = this.a;
        r8.b.postDelayed(r8.g0, 100);
    L8:
        CreationAIDragView r9 = this.a;
        r9.N = null;
        Function0<Unit> r10 = r9.b0;
        if (r10 == null) goto L11;
        r10.invoke();
    L11:
        Log.i("CreationAIDragView", "show anim end,  syncStatusBarColor = " + this.a.Y);
        CreationAIDragView r11 = this.a;
        if (r11.Y == false) goto L15;
        r11.q(1.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Log.i("CreationAIDragView", "showAnim start");
    }
}
