package com.bytedance.android.livesdk.gift.platform.format.panel.viewholder;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends o12.b {
    public final /* synthetic */ FormatGiftDialogViewHolder a;
    public final /* synthetic */ View b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FormatGiftDialogViewHolder r4 = this.a;
        View r0 = this.b;
        int r1 = FormatGiftDialogViewHolder.F;
        r4.g4(r0);
    }

    public d(FormatGiftDialogViewHolder r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
