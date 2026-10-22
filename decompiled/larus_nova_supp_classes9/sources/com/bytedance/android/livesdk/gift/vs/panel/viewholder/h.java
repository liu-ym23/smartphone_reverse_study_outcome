package com.bytedance.android.livesdk.gift.vs.panel.viewholder;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends o12.b {
    public final /* synthetic */ VSGiftDialogViewHolder a;
    public final /* synthetic */ View b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        VSGiftDialogViewHolder r4 = this.a;
        View r0 = this.b;
        int r1 = VSGiftDialogViewHolder.E;
        r4.i4(r0);
    }

    public h(VSGiftDialogViewHolder r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
