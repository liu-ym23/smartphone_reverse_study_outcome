package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.utils.q4;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomSelfDiggOptimizeView.b a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        BottomSelfDiggOptimizeView.b r4 = this.a;
        ImageView r0 = r4.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4.h.b == false) goto L9;
        r0.setLayerType(0, null);
    L9:
        if (this.a.h.c.b(r0) == true) goto L11;
        this.a.h.removeView(r0);
    L11:
        BottomSelfDiggOptimizeView.b r5 = this.a;
        ((LinkedList) r5.h.a).remove(r5);
        if (this.b.element < 5) goto L14;
        this.a.h.e = 0;
        return;
    L14:
        if (this.a.h.e < DiggABHelper.a().d()) goto L16;
        q4.j.getClass();
        q4.i = true;
        g32.d.b("BottomSelfDiggOptimizeView");
        return;
    L16:
        this.a.h.e++;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        BottomSelfDiggOptimizeView.b r4 = this.a;
        if (r4.h.b == false) goto L7;
        ImageView r5 = r4.e;
        if (r5 == null) goto L7;
        r5.setLayerType(2, null);
    L7:
        ImageView r6 = this.a.e;
        if (r6 == null) goto L11;
        r6.setVisibility(0);
        return;
    }

    public c(BottomSelfDiggOptimizeView.b r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
