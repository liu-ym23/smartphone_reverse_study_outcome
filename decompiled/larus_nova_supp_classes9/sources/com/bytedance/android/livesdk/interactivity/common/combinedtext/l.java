package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements qb2.e {
    public final /* synthetic */ DisplayTextView a;
    public final /* synthetic */ n b;

    @Override // qb2.e
    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r8) {
        Intrinsics.checkNotNullParameter(r8, "rendResult");
        DisplayTextView.x(this.a, r8.a);
        DisplayTextView r9 = this.a;
        k r0 = new k(this);
        int r1 = a.a;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r9, "scaleX", new float[]{1.0f, 1.25f, 1.0f});
        r2.setDuration(150);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r9, "scaleY", new float[]{1.0f, 1.25f, 1.0f});
        r5.setDuration(150);
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{a.b(r9, null), r2, r5});
        r3.setDuration(300);
        r3.addListener(new d(r0));
        r3.start();
    }

    public l(DisplayTextView r1, n r2) {
        this.a = r1;
        this.b = r2;
    }
}
