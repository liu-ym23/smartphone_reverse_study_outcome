package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements Animator.AnimatorListener {
    public Long a;
    public Long b;
    public boolean c;
    public final /* synthetic */ GiftComboView d;
    public final /* synthetic */ Runnable e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.c = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        if (this.c == false) goto L5;
        return;
    L5:
        Runnable r7 = this.e;
        if (r7 == null) goto L8;
        r7.run();
    L8:
        this.d.setVisibility(8);
        this.b = Long.valueOf(System.currentTimeMillis());
        this.c = false;
        StringBuilder r8 = new StringBuilder("show time:");
        Long r0 = this.b;
        long r1 = 0;
        if (r0 == null) goto L11;
        long r3 = r0.longValue();
    L12:
        Long r2 = this.a;
        if (r2 == null) goto L15;
        r1 = r2.longValue();
    L15:
        r8.append(r3 - r1);
        r8.append("ms");
        jy0.b.d("GiftComboViewOpt", r8.toString());
        return;
    L11:
        r3 = 0;
        goto L12
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a = Long.valueOf(System.currentTimeMillis());
    }

    public v(GiftComboView r1, Runnable r2) {
        this.d = r1;
        this.e = r2;
    }
}
