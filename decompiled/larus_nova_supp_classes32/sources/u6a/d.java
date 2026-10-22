package u6a;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends a.g {
    public final /* synthetic */ LynxUI d;
    public final /* synthetic */ m e;
    public final /* synthetic */ a f;

    @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.d.getView().setTranslationX(this.e.h());
        this.d.getView().setTranslationY(this.e.i());
        this.d.getView().setTranslationZ(this.e.j());
        if ((this.d.getParent() instanceof UIShadowProxy) == false) goto L5;
        ((UIShadowProxy) this.d.getParent()).N();
    L5:
        this.d.getView().setRotation(this.e.c());
        this.d.getView().setRotationX(this.e.d());
        this.d.getView().setRotationY(this.e.e());
        this.d.getView().setScaleX(this.e.f());
        this.d.getView().setScaleY(this.e.g());
        this.f.h.remove(4096);
    }

    public d(a r1, LynxUI r2, int r3, LynxUI r4, m r5) {
        this.f = r1;
        this.d = r4;
        this.e = r5;
        super(r2, r3);
    }
}
