package qc8;

import android.animation.ValueAnimator;
import android.view.View;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ View b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;

    public /* synthetic */ e(BubbleBannerComponent r1, View r2, float r3, float r4, float r5, float r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        BubbleBannerComponent r0 = this.a;
        View r1 = this.b;
        float r2 = this.c;
        float r3 = this.d;
        float r4 = this.e;
        float r5 = this.f;
        int r6 = BubbleBannerComponent.S;
        Intrinsics.checkNotNullParameter(r8, "animator");
        Object r9 = r8.getAnimatedValue();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Float");
        float r10 = ((Float) r9).floatValue();
        BubbleBannerComponent.h3(r1, r2, r3, r4, r5, r0.O.getInterpolation(r10));
    }
}
