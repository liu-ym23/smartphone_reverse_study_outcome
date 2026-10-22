package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ CompositeImagePreviewDialog e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        CompositeImagePreviewDialog r3 = this.e;
        r3.W = null;
        View r4 = r3.M;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r4, false);
    L5:
        View r5 = this.e.O;
        if (r5 == null) goto L9;
        UtilityKotlinExtentionsKt.A(r5, true);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (PadConfigUtils.c() == false) goto L7;
        int r0 = (x1.e(this.a.getContext()) - x1.f()) - ((((int) (this.c + (this.d / 2))) + UtilityKotlinExtentionsKt.i(48)) + UtilityKotlinExtentionsKt.i(30));
        View r4 = this.e.N;
        if (r4 == null) goto L7;
        a1.l(r4, r0);
    L7:
        View r5 = this.e.N;
        if (r5 == null) goto L10;
        UtilityKotlinExtentionsKt.A(r5, true);
    L10:
        TextView r6 = this.e.J;
        if (r6 == null) goto L13;
        UtilityKotlinExtentionsKt.A(r6, false);
    L13:
        TextView r7 = this.e.K;
        if (r7 == null) goto L16;
        UtilityKotlinExtentionsKt.A(r7, false);
    L16:
        this.e.W = null;
    }

    public h(HSImageView r1, HSImageView r2, int r3, float r4, CompositeImagePreviewDialog r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
