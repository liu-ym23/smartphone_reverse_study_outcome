package kk0;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public b(HSImageView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L7;
        PointF r5 = (PointF) r4;
        this.a.setX(r5.x);
        this.a.setY(r5.y);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
