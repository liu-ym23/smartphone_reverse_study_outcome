package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenPanel$performPanelAnimation$1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ OpenPanel a;
    public final /* synthetic */ IntEvaluator b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public OpenPanel$performPanelAnimation$1(OpenPanel r1, IntEvaluator r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(final ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Window r0 = this.a.getWindow();
        if (r0 == null) goto L13;
        final WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r1 == null) goto L14;
        float r2 = r6.getAnimatedFraction();
        r1.y = this.b.evaluate(r2, Integer.valueOf(this.c), Integer.valueOf(this.d)).intValue();
        View r3 = this.a.a;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L9:
        Function0<Unit> r4 = new OpenPanel$performPanelAnimation$1$$special$$inlined$let$lambda$1(r1, this, r6);
        if (ViewCompat.isAttachedToWindow(r3) == false) goto L15;
        r4.invoke();
        return;
    L15:
        return;
    L14:
        return;
    }
}
