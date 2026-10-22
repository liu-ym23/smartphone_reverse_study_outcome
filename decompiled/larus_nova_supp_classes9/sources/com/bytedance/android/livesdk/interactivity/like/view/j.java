package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ CustomDiggTapView.c a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        CustomDiggTapView.c r3 = this.a;
        ImageView r0 = r3.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3.h.b.b(r0) == true) goto L8;
        this.a.h.removeView(r0);
    L8:
        CustomDiggTapView.c r4 = this.a;
        r4.h.a.remove(r4);
        if (this.b.element >= 5) goto L12;
        q4.j.getClass();
        q4.i = true;
        g32.d.b("CustomDiggTapView");
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ImageView r3 = this.a.d;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }

    public j(CustomDiggTapView.c r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
