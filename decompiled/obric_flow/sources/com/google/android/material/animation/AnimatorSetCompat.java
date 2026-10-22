package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorSetCompat {
    public AnimatorSetCompat() {
    }

    public static void playTogether(@NonNull AnimatorSet r10, @NonNull List<Animator> r11) {
        int r5 = r11.size();
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L5;
        Animator r14 = r11.get(r13);
        r12 = Math.max(r12, r14.getDuration() + r14.getStartDelay());
        r13 = r13 + 1;
        goto L3
    L5:
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{0, 0});
        r15.setDuration(r12);
        r11.add(0, r15);
        r10.playTogether(r11);
    }
}
