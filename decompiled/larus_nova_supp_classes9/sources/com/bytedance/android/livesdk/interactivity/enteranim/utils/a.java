package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.enteranim.utils.a$a, reason: collision with other inner class name */
    public class C0161a extends AnimatorListenerAdapter {
        public final /* synthetic */ s72.c a;

        public C0161a(s72.c r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            s72.c r2 = this.a;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            s72.c r0 = this.a;
            if (r0 == null) goto L6;
            r0.onAnimationStart(r2);
            return;
        }
    }

    public static Animator a(View r1, String r2, float... r3) {
        if (((Integer) InteractivityOpt.c(LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT)).intValue() <= 0) goto L7;
        return LiveDegradeFpsAnimator.ofFloat(r1, r2, r3);
    L7:
        return ObjectAnimator.ofFloat(r1, r2, r3);
    }

    public static Animator c(View r7, s72.c r8, boolean r9) {
        return b(r7, r8, -1, -1, -1, r9, false);
    }

    public static Animator b(View r16, s72.c r17, int r18, int r19, int r20, boolean r21, boolean r23) {
        View r0 = r16;
        if (r0 == null) goto L5;
        int r4 = (s1.y() * 375) / 375;
        if (r18 <= 0) goto L13;
        int r6 = r18;
    L14:
        if (r19 <= 0) goto L16;
        int r7 = r19;
    L17:
        int r5 = -((s1.y() * 375) / 375);
        float r8 = r6;
        Animator r9 = a(r0, "translationX", new float[]{r4, r8}).setDuration(600);
        float r10 = r7;
        Animator r11 = a(r0, "translationX", new float[]{r8, r10});
        if (r20 <= 0) goto L20;
        long r13 = r20;
    L21:
        Animator r2 = r11.setDuration(r13);
        Animator r14 = a(r0, "translationX", new float[]{r10, r5}).setDuration(400);
        r9.addListener(new C0161a(r17));
        r9.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.8f, 0.74f, 1.0f));
        r2.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r14.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.6f, 0.2f));
        AnimatorSet r15 = new AnimatorSet();
        r15.playSequentially(new Animator[]{r9, r2, r14});
        if (r23 == true) goto L24;
    L26:
        r0.setAlpha(0.0f);
        Animator r1 = a(r0, "alpha", new float[]{0.0f, 1.0f}).setDuration(600);
        if (r21 == false) goto L29;
        r1.setStartDelay(400);
    L29:
        r1.setInterpolator(new LinearInterpolator());
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r15, r1});
        r3.addListener(r17);
        return r3;
    L24:
        if (r16.getParent() == null) goto L26;
        r0 = (View) r16.getParent();
        goto L26
    L20:
        r13 = 1700;
        goto L21
    L16:
        r7 = (6 * s1.y()) / 375;
        goto L17
    L13:
        r6 = (16 * s1.y()) / 375;
        goto L14
    L5:
        if (((Integer) InteractivityOpt.c(LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT)).intValue() <= 0) goto L7;
        LiveDegradeFpsAnimator r24 = LiveDegradeFpsAnimator.ofFloat(new float[]{0.0f, 1.0f});
    L8:
        r24.setDuration(100);
        r24.addListener(r17);
        return r24;
    L7:
        r24 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        goto L8
    }
}
