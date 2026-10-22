package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CompositeImagePreviewDialog a;

    public a(CompositeImagePreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        if (this.a.k0.length() <= 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L48;
        CompositeImagePreviewDialog r16 = this.a;
        if (r16.Y == true) goto L50;
        r16.Y = true;
        View r2 = r16.M;
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.A(r2, true);
    L13:
        View r3 = r16.O;
        if (r3 == null) goto L16;
        UtilityKotlinExtentionsKt.A(r3, false);
    L16:
        HSImageView r4 = r16.I;
        if (r4 == null) goto L49;
        Animator r5 = r16.W;
        if (r5 == null) goto L21;
        r5.cancel();
    L21:
        boolean r6 = PadConfigUtils.c();
        boolean r7 = e5.n();
        Activity r8 = ContextUtil.contextToActivity(r4.getContext());
        if (r8 != null) goto L24;
        r8 = com.bytedance.android.live.core.utils.a.d();
    L24:
        if (r6 == false) goto L27;
        if (r7 == false) goto L27;
        int r9 = x1.h();
    L28:
        if (r6 == false) goto L33;
        if (r7 == false) goto L33;
        if (r8 != null) goto L32;
        int r10 = x1.g();
    L34:
        int[] r11 = new int[2];
        r4.getLocationOnScreen(r11);
        int r13 = r11[1] + (r4.getHeight() / 2);
        if (r6 == false) goto L37;
        int r17 = (r9 / 2) - (UtilityKotlinExtentionsKt.i(78) / 2);
    L38:
        float r18 = r17 - r13;
        float r19 = (r10 / 2) - (r11[0] + (r4.getWidth() / 2));
        int r20 = r4.getWidth();
        if (r6 == false) goto L42;
        if (r7 == false) goto L42;
        float r21 = r9;
    L44:
        float r23 = (r21 / 2) * 1.2f;
    L46:
        float r24 = r23 / r20;
        float r25 = r24 * r4.getHeight();
        AnimatorSet r26 = new AnimatorSet();
        AnimatorSet.Builder r27 = r26.play(ObjectAnimator.ofFloat(r4, View.TRANSLATION_Y, new float[]{0.0f, r18}));
        r27.with(ObjectAnimator.ofFloat(r4, View.TRANSLATION_X, new float[]{0.0f, r19}));
        r27.with(ObjectAnimator.ofFloat(r4, View.SCALE_X, new float[]{1.0f, r24}));
        r27.with(ObjectAnimator.ofFloat(r4, View.SCALE_Y, new float[]{1.0f, r24}));
        r27.with(ObjectAnimator.ofFloat(r16.M, View.ALPHA, new float[]{0.0f, 1.0f}));
        r27.with(ObjectAnimator.ofFloat(r16.J, View.ALPHA, new float[]{1.0f, 0.0f}));
        r27.with(ObjectAnimator.ofFloat(r16.K, View.ALPHA, new float[]{1.0f, 0.0f}));
        r26.setDuration(500);
        r26.setInterpolator(new DecelerateInterpolator());
        r26.addListener(new h(r4, r4, r17, r25, r16));
        r26.start();
        Unit r0 = Unit.INSTANCE;
        r16.W = r26;
        return;
    L42:
        if (r6 == false) goto L45;
        r21 = r10;
        goto L44
    L45:
        r23 = r10 - (UtilityKotlinExtentionsKt.i(32) * 2.0f);
        goto L46
    L37:
        r17 = r9 / 2;
        goto L38
    L32:
        r10 = x1.i(r8).widthPixels;
    L33:
        r10 = x1.h();
    L27:
        r9 = x1.g();
        goto L28
    L49:
        return;
    L50:
        return;
    L48:
        return;
    L5:
        r15 = false;
        goto L6
    }
}
