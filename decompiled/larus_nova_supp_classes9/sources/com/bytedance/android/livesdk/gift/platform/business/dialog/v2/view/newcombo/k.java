package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends o12.b {
    public final /* synthetic */ ComboWaveView a;
    public final /* synthetic */ View b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.removeView(this.b);
    }

    public k(ComboWaveView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
