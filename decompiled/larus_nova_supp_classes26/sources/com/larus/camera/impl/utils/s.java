package com.larus.camera.impl.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    public static final Rect b(View r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Rect r0 = new Rect();
        int[] r1 = new int[2];
        r6.getLocationInWindow(r1);
        int r2 = r1[0];
        r0.set(r2, r1[1], r6.getWidth() + r2, r1[1] + r6.getHeight());
        return r0;
    }

    public static final void a(View r9, int r10, float r11) {
        Intrinsics.checkNotNullParameter(r9, "view");
        float r12 = r10;
        if (r9.getRotation() >= r12) goto L5;
        float r0 = r9.getRotation() + 360;
    L6:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r9, View.ROTATION, new float[]{r0, r12});
        r13.setDuration(300);
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r9, View.SCALE_X, new float[]{r9.getScaleX(), r11});
        r1.setDuration(300);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r9, View.SCALE_Y, new float[]{r9.getScaleY(), r11});
        r14.setDuration(300);
        AnimatorSet r15 = new AnimatorSet();
        r15.playTogether(new Animator[]{r13, r1, r14});
        r15.start();
        return;
    L5:
        r0 = r9.getRotation();
        goto L6
    }
}
