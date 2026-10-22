package u6a;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LynxUI a;

    public h(LynxUI r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L6;
        this.a.getView().setAlpha(((Float) r3).floatValue());
        return;
    }
}
