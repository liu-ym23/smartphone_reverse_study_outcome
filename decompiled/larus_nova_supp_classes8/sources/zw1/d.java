package zw1;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.feed.ui.XiguaLivingTagView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ XiguaLivingTagView a;

    public d(XiguaLivingTagView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r6 = ((Integer) r5.getAnimatedValue()).intValue();
        XiguaLivingTagView r0 = this.a;
        r0.j.set(0.0f, 0.0f, r0.c, r6);
        r0.invalidate();
    }
}
