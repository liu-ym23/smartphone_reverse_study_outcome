package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends AnimatorListenerAdapter {
    public final /* synthetic */ DiggTapOptimizeView.b a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ImageView r4 = this.a.d;
        if (r4 != null) goto L5;
        return;
    L5:
        r4.setLayerType(0, null);
        if (this.a.i.b.b(r4) == true) goto L8;
        this.a.i.removeView(r4);
    L8:
        DiggTapOptimizeView.b r5 = this.a;
        r5.i.a.remove(r5);
        if (this.b.element < 5) goto L11;
        this.a.i.c = 0;
        return;
    L11:
        if (this.a.i.c < DiggABHelper.a().d()) goto L13;
        q4.j.getClass();
        q4.i = true;
        g32.d.b("DiggTapOptimizeView");
        return;
    L13:
        this.a.i.c++;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ImageView r4 = this.a.d;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        r4.setLayerType(2, null);
        return;
    }

    public u(DiggTapOptimizeView.b r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
