package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(AnimatorSet r11, List<Animator> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        int r0 = r13.size();
        long r3 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L5;
        Animator r6 = (Animator) ZeusTransformUtils.preCheckCast(r13.get(r5), Animator.class, "com.obric.memorydata.plugin");
        r3 = Math.max(r3, r6.getStartDelay() + r6.getDuration());
        r5 = r5 + 1;
        goto L3
    L5:
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, 0});
        r1.setDuration(r3);
        r13.add(0, r1);
        r11.playTogether(r13);
    }
}
