package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ LikeEggView a;

    public e(LikeEggView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        HSImageView r0 = this.a.b;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r0, false);
    L5:
        HSImageView r1 = this.a.b;
        if (r1 == null) goto L8;
        r1.setController(null);
    L8:
        HSImageView r2 = this.a.c;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r2, false);
    L11:
        HSImageView r3 = this.a.c;
        if (r3 == null) goto L14;
        r3.setController(null);
    L14:
        super.onAnimationStart(r4);
    }
}
