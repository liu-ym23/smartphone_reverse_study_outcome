package u6a;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends a.g {
    public final /* synthetic */ LynxBaseUI d;
    public final /* synthetic */ int e;
    public final /* synthetic */ a f;

    @Override // u6a.a.g, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.d.getLynxBackground().n(this.e);
        this.d.invalidate();
        this.f.h.remove(64);
    }

    public b(a r1, LynxBaseUI r2, int r3, LynxBaseUI r4, int r5) {
        this.f = r1;
        this.d = r4;
        this.e = r5;
        super(r2, r3);
    }
}
