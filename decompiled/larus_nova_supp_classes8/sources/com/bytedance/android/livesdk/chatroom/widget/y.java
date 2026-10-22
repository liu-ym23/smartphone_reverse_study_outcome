package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y extends BaseAnimationListener {
    public final /* synthetic */ z a;

    public y(z r1) {
        this.a = r1;
    }

    public final void onAnimationStart(AnimatedDrawable2 r12) {
        FansRankListAnimationWidget r13 = this.a.a;
        TextView r0 = r13.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L5:
        UIUtils.setViewVisibility(r0, 0);
        r13.k = new ArrayList();
        TextView r1 = r13.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L8:
        r1.setText(r13.l);
        TextView r2 = r13.d;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L11:
        r2.setAlpha(0.0f);
        TextView r3 = r13.d;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L14:
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{0.0f, 1.0f});
        if (r4 != null) goto L17;
    L21:
        TextView r5 = r13.d;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mAwardTextView");
    L24:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f});
        if (r6 == null) goto L27;
        r6.setStartDelay(3300);
        r6.setDuration(700);
    L27:
        RelativeLayout r7 = r13.c;
        if (r7 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationContainer");
    L30:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r7, "alpha", new float[]{1.0f, 0.0f});
        if (r8 == null) goto L33;
        r8.setStartDelay(3300);
        r8.setDuration(700);
    L33:
        AnimatorSet r9 = new AnimatorSet();
        r9.playTogether(new Animator[]{r4, r6, r8});
        r9.start();
        ArrayList<Animator> r14 = r13.k;
        if (r14 == null) goto L36;
        r14.add(r9);
    L36:
        com.bytedance.android.livesdk.log.u.l().b("livesdk_fansranklist_endanimation_show");
        return;
    L17:
        if (tb1.c.a == false) goto L19;
        long r10 = 1300;
    L20:
        r4.setStartDelay(r10);
        r4.setDuration(200);
        goto L21
    L19:
        r10 = 1000;
        goto L20
    }
}
