package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ CompositeImagePreviewDialog b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.b.N;
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r3, true);
    L5:
        TextView r4 = this.b.J;
        if (r4 == null) goto L8;
        UtilityKotlinExtentionsKt.A(r4, false);
    L8:
        TextView r5 = this.b.K;
        if (r5 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r5, false);
    L11:
        this.b.W = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        CompositeImagePreviewDialog r3 = this.b;
        r3.W = null;
        View r4 = r3.M;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r4, false);
    L5:
        View r5 = this.b.O;
        if (r5 == null) goto L9;
        UtilityKotlinExtentionsKt.A(r5, true);
        return;
    }

    public i(HSImageView r1, CompositeImagePreviewDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}
