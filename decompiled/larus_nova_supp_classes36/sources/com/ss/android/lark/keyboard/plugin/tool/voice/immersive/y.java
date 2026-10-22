package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ImmersiveVoiceInputView a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ int[] c;

    public y(ImmersiveVoiceInputView r1, int[] r2, int[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r18) {
        Intrinsics.checkNotNullParameter(r18, "it");
        float r1 = r18.getAnimatedFraction();
        GradientDrawable r2 = this.a.g;
        int[] r3 = this.b;
        int[] r4 = new int[r3.length];
        int[] r5 = this.c;
        int r6 = r3.length;
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r7 >= r6) goto L5;
        int r9 = r3[r7];
        int r10 = r3[r8];
        int r11 = r5[r8];
        r4[r8] = Color.argb((int) (Color.alpha(r10) + ((Color.alpha(r11) - Color.alpha(r10)) * r1)), (int) (Color.red(r10) + ((Color.red(r11) - Color.red(r10)) * r1)), (int) (Color.green(r10) + ((Color.green(r11) - Color.green(r10)) * r1)), (int) (Color.blue(r10) + ((Color.blue(r11) - Color.blue(r10)) * r1)));
        r7 = r7 + 1;
        r8 = r8 + 1;
        goto L3
    L5:
        if (r2 == null) goto L9;
        r2.setColors(r4);
        return;
    }
}
