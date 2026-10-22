package u6a;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LynxBaseUI a;

    public c(LynxBaseUI r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L6;
        int r4 = ((Integer) r3).intValue();
        this.a.getLynxBackground().n(r4);
        this.a.invalidate();
        return;
    }
}
