package u6a;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LynxUI a;

    public g(LynxUI r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L8;
        float r4 = ((Float) r3).floatValue();
        this.a.getView().setAlpha(r4);
        if ((this.a.getParent() instanceof UIShadowProxy) == false) goto L9;
        ((UIShadowProxy) this.a.getParent()).N();
        return;
    L9:
        return;
    }
}
