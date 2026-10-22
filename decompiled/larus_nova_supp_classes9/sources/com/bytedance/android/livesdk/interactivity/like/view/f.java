package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.bytedance.android.livesdk.config.v50;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomSelfDiggOptimizeView.c a;

    public f(BottomSelfDiggOptimizeView.c r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        v50 r7 = v50.a;
        if (((Boolean) r7.getValue()).booleanValue() == false) goto L5;
        BottomSelfDiggOptimizeView.c r0 = this.a;
        ((LinkedList) r0.g.a).remove(r0);
    L5:
        BottomSelfDiggOptimizeView.c r1 = this.a;
        ImageView r2 = r1.e;
        if (r2 != null) goto L9;
        return;
    L9:
        if (r1.g.b == false) goto L12;
        r2.setLayerType(0, null);
    L12:
        if (this.a.g.c.b(r2) == true) goto L14;
        this.a.g.removeView(r2);
    L14:
        BottomSelfDiggOptimizeView.c r3 = this.a;
        ImageView r4 = r3.d;
        if (r4 != null) goto L18;
        return;
    L18:
        if (r3.g.b == false) goto L21;
        r2.setLayerType(0, null);
    L21:
        if (this.a.g.c.b(r4) == true) goto L24;
        this.a.g.removeView(r4);
    L24:
        if (((Boolean) r7.getValue()).booleanValue() == true) goto L27;
        BottomSelfDiggOptimizeView.c r8 = this.a;
        ((LinkedList) r8.g.a).remove(r8);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        ImageView r6 = this.a.d;
        if (r6 == null) goto L7;
        r6.setVisibility(0);
        if (this.a.g.b == false) goto L7;
        r6.setLayerType(2, null);
    L7:
        ImageView r7 = this.a.e;
        if (r7 == null) goto L13;
        r7.setVisibility(0);
        if (this.a.g.b == false) goto L14;
        r7.setLayerType(2, null);
        return;
    L14:
        return;
    }
}
