package u6a;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends a.g {
    public final /* synthetic */ LynxUI d;
    public final /* synthetic */ int e;
    public final /* synthetic */ float f;
    public final /* synthetic */ a g;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        super.onAnimationCancel(r2);
        this.g.e = false;
    }

    @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.d.setVisibilityForView(this.e);
        this.d.getView().setAlpha(this.f);
        this.g.h.remove(Integer.valueOf(LynxTouchEvent.kPseudoStateFocusTransition));
    }

    @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        super.onAnimationStart(r2);
        this.d.getView().setVisibility(0);
        this.g.e = false;
    }

    public i(a r1, LynxBaseUI r2, int r3, LynxUI r4, int r5, float r6) {
        this.g = r1;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        super(r2, r3);
    }
}
