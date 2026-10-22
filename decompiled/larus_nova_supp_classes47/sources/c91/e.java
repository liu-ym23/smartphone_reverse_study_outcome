package c91;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        ImageView r0 = this.a.c;
        Object r1 = r5.getAnimatedValue();
        if (r1 == null) goto L23;
        r0.setAlpha(((Float) r1).floatValue());
        HSImageView r2 = this.a.g;
        Object r3 = r5.getAnimatedValue();
        if (r3 == null) goto L21;
        r2.setAlpha(((Float) r3).floatValue());
        TextView r4 = this.a.e;
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L19;
        r4.setAlpha(((Float) r6).floatValue() * 0.9f);
        TextView r7 = this.a.f;
        Object r8 = r5.getAnimatedValue();
        if (r8 == null) goto L17;
        r7.setAlpha(((Float) r8).floatValue() * 0.7f);
        ImageView r9 = this.a.i;
        Object r10 = r5.getAnimatedValue();
        if (r10 == null) goto L15;
        r9.setAlpha(((Float) r10).floatValue());
        this.a.c.requestLayout();
        this.a.g.requestLayout();
        this.a.e.requestLayout();
        this.a.f.requestLayout();
        this.a.i.requestLayout();
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
