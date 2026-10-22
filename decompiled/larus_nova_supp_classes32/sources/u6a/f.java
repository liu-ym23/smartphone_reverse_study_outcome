package u6a;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends a.g {
    public final /* synthetic */ LynxUI d;
    public final /* synthetic */ float e;
    public final /* synthetic */ a f;

    @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.d.getView().setAlpha(this.e);
        if ((this.d.getParent() instanceof UIShadowProxy) == false) goto L5;
        ((UIShadowProxy) this.d.getParent()).N();
    L5:
        this.f.h.remove(1);
    }

    public f(a r1, LynxUI r2, int r3, LynxUI r4, float r5) {
        this.f = r1;
        this.d = r4;
        this.e = r5;
        super(r2, r3);
    }
}
