package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ CompositeImagePreviewDialog a;

    public b(CompositeImagePreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        CompositeImagePreviewDialog r14 = this.a;
        if (r14.Y == false) goto L22;
        r14.Y = false;
        View r1 = r14.N;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.A(r1, false);
    L8:
        TextView r2 = r14.J;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r2, true);
    L11:
        TextView r3 = r14.K;
        if (r3 == null) goto L14;
        UtilityKotlinExtentionsKt.A(r3, true);
    L14:
        Animator r4 = r14.W;
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        HSImageView r5 = r14.I;
        if (r5 == null) goto L21;
        float r6 = r5.getScaleX();
        float r7 = r5.getTranslationY();
        float r8 = r5.getTranslationX();
        AnimatorSet r9 = new AnimatorSet();
        AnimatorSet.Builder r10 = r9.play(ObjectAnimator.ofFloat(r5, View.TRANSLATION_Y, new float[]{r7, 0.0f}));
        r10.with(ObjectAnimator.ofFloat(r5, View.TRANSLATION_X, new float[]{r8, 0.0f}));
        r10.with(ObjectAnimator.ofFloat(r5, View.SCALE_X, new float[]{r6, 1.0f}));
        r10.with(ObjectAnimator.ofFloat(r5, View.SCALE_Y, new float[]{r6, 1.0f}));
        r10.with(ObjectAnimator.ofFloat(r14.M, View.ALPHA, new float[]{1.0f, 0.0f}));
        r10.with(ObjectAnimator.ofFloat(r14.J, View.ALPHA, new float[]{0.0f, 1.0f}));
        r10.with(ObjectAnimator.ofFloat(r14.K, View.ALPHA, new float[]{0.0f, 1.0f}));
        r9.setDuration(500);
        r9.setInterpolator(new DecelerateInterpolator());
        r9.addListener(new i(r5, r14));
        r9.start();
        Unit r0 = Unit.INSTANCE;
        r14.W = r9;
        return;
    L21:
        return;
    }
}
