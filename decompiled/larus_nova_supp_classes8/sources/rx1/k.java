package rx1;

import android.animation.ValueAnimator;
import android.view.WindowManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;

    public k(g r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        int r4 = ((Integer) r3.getAnimatedValue()).intValue();
        f r0 = this.a.a;
        if (r0.f == true) goto L6;
        WindowManager.LayoutParams r1 = r0.b;
        r1.x = r4;
        r0.d = r4;
        r0.a.updateViewLayout(r0.c, r1);
    L6:
        g r5 = this.a;
        e r2 = r5.b.s;
        if (r2 == null) goto L10;
        int r6 = r5.a.e;
        r2.d();
        return;
    }
}
