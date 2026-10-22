package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ GiftComboView a;

    public s(GiftComboView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r14) {
        Pair r15 = (Pair) r14;
        if (r15 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r15 != null) goto L10;
    L12:
        boolean r16 = false;
    L14:
        if (r2 == false) goto L45;
        GiftComboView r17 = this.a;
        if (r17.E != GiftComboView.RecommendStatus.Idle) goto L85;
        AnimatorSet r3 = r17.t;
        if (r3 == null) goto L21;
        c.a(r3);
    L21:
        AnimatorSet r4 = r17.u;
        if (r4 == null) goto L24;
        c.a(r4);
    L24:
        View r5 = r17.b;
        if (r5 == null) goto L32;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r5, "translationY", new float[]{UtilityKotlinExtentionsKt.h(16.0f)}).setDuration(250);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r5, "scaleX", new float[]{0.5f}).setDuration(250);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "scaleY", new float[]{0.5f}).setDuration(250);
        AnimatorSet r8 = new AnimatorSet();
        r8.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f));
        Unit r9 = Unit.INSTANCE;
        r17.t = r8;
        r8.playTogether(new Animator[]{r10, r7, r6});
        AnimatorSet r0 = r17.t;
        if (r0 == null) goto L29;
        r0.addListener(new w(r17));
    L29:
        AnimatorSet r1 = r17.t;
        if (r1 == null) goto L32;
        r1.start();
    L32:
        ArrayList r11 = new ArrayList();
        View r13 = r17.h;
        if (r13 == null) goto L35;
        r11.add(r17.h(r13));
    L35:
        View r18 = r17.g;
        if (r18 == null) goto L38;
        r11.add(r17.h(r18));
    L38:
        View r19 = r17.f;
        if (r19 == null) goto L41;
        r11.add(r17.h(r19));
    L41:
        View r20 = r17.e;
        if (r20 == null) goto L44;
        r11.add(r17.h(r20));
    L44:
        AnimatorSet r21 = new AnimatorSet();
        r17.u = r21;
        r21.playSequentially(r11);
        return;
    L85:
        return;
    L45:
        if (r16 == true) goto L80;
        if (r2 == true) goto L81;
        GiftComboView r110 = this.a;
        AnimatorSet r23 = r110.t;
        if (r23 == null) goto L50;
        c.a(r23);
    L50:
        AnimatorSet r24 = r110.u;
        if (r24 == null) goto L53;
        c.a(r24);
    L53:
        View r25 = r110.h;
        if (r25 == null) goto L56;
        r25.setVisibility(8);
    L56:
        View r26 = r110.g;
        if (r26 == null) goto L59;
        r26.setVisibility(8);
    L59:
        View r27 = r110.f;
        if (r27 == null) goto L62;
        r27.setVisibility(8);
    L62:
        View r28 = r110.e;
        if (r28 == null) goto L65;
        r28.setVisibility(8);
    L65:
        View r29 = r110.b;
        if (r29 != null) goto L68;
        return;
    L68:
        if (r29.getScaleX() == 1.0f) goto L70;
        boolean r111 = true;
    L71:
        if (r111 == true) goto L74;
        r29 = null;
    L74:
        if (r29 == null) goto L83;
        ObjectAnimator r30 = ObjectAnimator.ofFloat(r29, "translationY", new float[]{0.0f}).setDuration(250);
        ObjectAnimator r31 = ObjectAnimator.ofFloat(r29, "scaleX", new float[]{1.0f}).setDuration(250);
        ObjectAnimator r33 = ObjectAnimator.ofFloat(r29, "scaleY", new float[]{1.0f}).setDuration(250);
        AnimatorSet r34 = new AnimatorSet();
        r110.t = r34;
        r34.playTogether(new Animator[]{r30, r31, r33});
        AnimatorSet r112 = r110.t;
        if (r112 == null) goto L84;
        r112.start();
        return;
    L84:
        return;
    L83:
        return;
    L70:
        r111 = false;
        goto L71
    L81:
        return;
    L80:
        return;
    L10:
        if (((Boolean) r15.getSecond()).booleanValue() != true) goto L12;
        r16 = true;
        goto L14
    L5:
        if (((Boolean) r15.getFirst()).booleanValue() != true) goto L7;
        r2 = true;
        goto L8
    }
}
