package fd0;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ View b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        this.a.update(this.b, ((Float) r3.getAnimatedValue()).floatValue());
    }

    public e(d r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
