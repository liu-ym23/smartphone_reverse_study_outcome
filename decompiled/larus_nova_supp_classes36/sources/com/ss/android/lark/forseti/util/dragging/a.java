package com.ss.android.lark.forseti.util.dragging;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.forseti.util.dragging.a$a, reason: collision with other inner class name */
    public interface InterfaceC0068a extends Animator.AnimatorListener {
        void c(float r1, float r2);
    }

    static {
    }

    public static void a(ForsetiNormalChainDraggingView r2, float r3, float r4, float r5, InterfaceC0068a r6) {
        if (r2 != null) goto L5;
        Log.e("ForsetiColumnsDraggingAnimator", "current view is null, stops animation.");
        return;
    L5:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r7.addUpdateListener(new b(r2, r5, r3, r6));
        r7.setDuration(150);
        r7.setInterpolator(new DecelerateInterpolator(1.0f));
        r7.addListener(new c(r6));
        r7.start();
    }
}
