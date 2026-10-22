package rx1;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;

    public i(g r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        int r0 = ((Integer) r3.getAnimatedValue("x")).intValue();
        int r4 = ((Integer) r3.getAnimatedValue("y")).intValue();
        this.a.a.a(r0, r4);
        e r5 = this.a.b.s;
        if (r5 == null) goto L6;
        r5.d();
        return;
    }
}
