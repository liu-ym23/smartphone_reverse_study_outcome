package yl0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static Animator a(View r8, long r9, Pair r11, long r12, Pair r14) {
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r8, "ScaleX", new float[]{((Number) r11.getFirst()).floatValue(), ((Number) r11.getSecond()).floatValue()});
        r2.setDuration(r9);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r8, "ScaleY", new float[]{((Number) r11.getFirst()).floatValue(), ((Number) r11.getSecond()).floatValue()});
        r6.setDuration(r9);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r8, "ScaleX", new float[]{((Number) r14.getFirst()).floatValue(), ((Number) r14.getSecond()).floatValue()});
        r10.setDuration(r12);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r8, "ScaleY", new float[]{((Number) r14.getFirst()).floatValue(), ((Number) r14.getSecond()).floatValue()});
        r13.setDuration(r12);
        r0.play(r2).with(r6).before(r10).before(r13);
        return r0;
    }
}
