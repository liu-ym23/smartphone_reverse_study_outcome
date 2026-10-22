package com.bytedance.android.livesdk.feedback.view.feedback;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ GlobalQuestionFeedback a;

    public a(GlobalQuestionFeedback r1) {
        this.a = r1;
    }

    public final void a() {
        GlobalQuestionFeedback r1 = this.a;
        r1.getClass();
        ArrayList r2 = new ArrayList();
        ViewGroup r3 = r1.c;
        if (r3 == null) goto L9;
        float[] r11 = new float[2];
        r11[0] = r3.getTranslationY();
        float r12 = r3.getTranslationY();
        ViewGroup r13 = r1.c;
        if (r13 == null) goto L7;
        float r14 = r1.e() - r13.getY();
    L8:
        r11[1] = r12 + r14;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, "translationY", r11);
        r4.setDuration(200);
        Unit r15 = Unit.INSTANCE;
        r2.add(r4);
        goto L9
    L7:
        r14 = 0.0f;
    L9:
        ViewGroup r5 = r1.a;
        if (r5 != null) goto L12;
    L24:
        ViewGroup r6 = r1.b;
        if (r6 != null) goto L27;
    L41:
        AnimatorSet r7 = new AnimatorSet();
        r7.addListener(new b(r1, r2));
        r7.playTogether(r2);
        r7.start();
        return;
    L27:
        if (r1.l == null) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L32;
        ViewGroup r16 = r6;
    L33:
        if (r16 == null) goto L41;
        float[] r9 = new float[2];
        r9[0] = r16.getTranslationY();
        float r10 = r16.getTranslationY();
        ViewGroup r17 = r1.b;
        if (r17 == null) goto L39;
        float r18 = r17.getY();
        ViewGroup r19 = r1.a;
        if (r19 == null) goto L39;
        float r110 = (((r1.e() * 3) + r19.getHeight()) + UtilityKotlinExtentionsKt.h(24)) - r18;
    L40:
        r9[1] = r10 + r110;
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r16, "translationY", r9);
        r20.setDuration(200);
        Unit r21 = Unit.INSTANCE;
        r2.add(r20);
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{0.0f, 1.0f});
        r22.setInterpolator(new AccelerateInterpolator());
        r22.setDuration(200);
        r2.add(r22);
    L39:
        r110 = 0.0f;
        goto L40
    L32:
        r16 = null;
        goto L33
    L29:
        r8 = false;
        goto L30
    L12:
        if (r1.k == null) goto L14;
        boolean r111 = true;
    L15:
        if (r111 == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L24;
        float[] r112 = new float[2];
        r112[0] = r5.getTranslationY();
        float r113 = r5.getTranslationY();
        ViewGroup r114 = r1.a;
        if (r114 == null) goto L22;
        float r23 = ((r1.e() * 2) + UtilityKotlinExtentionsKt.h(24)) - r114.getY();
    L23:
        r112[1] = r113 + r23;
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r5, "translationY", r112);
        r24.setDuration(200);
        Unit r25 = Unit.INSTANCE;
        r2.add(r24);
        goto L24
    L22:
        r23 = 0.0f;
        goto L23
    L14:
        r111 = false;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
