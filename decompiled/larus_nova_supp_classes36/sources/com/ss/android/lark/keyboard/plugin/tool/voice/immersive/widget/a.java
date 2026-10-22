package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ VoiceOvalBackground a;
    public final /* synthetic */ boolean b;

    public a(VoiceOvalBackground r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        float r6 = r5.getAnimatedFraction();
        VoiceOvalBackground r0 = this.a;
        boolean r1 = this.b;
        if (r1 == false) goto L5;
        float r2 = r0.i;
        float r3 = r0.k;
    L6:
        r0.m = r2 + ((r3 - r2) * r6);
        if (r1 == false) goto L9;
        float r4 = r0.j;
        float r7 = r0.l;
    L10:
        r0.n = r4 + ((r7 - r4) * r6);
        r0.c();
        this.a.e();
        this.a.invalidate();
        return;
    L9:
        r4 = r0.l;
        r7 = r0.j;
        goto L10
    L5:
        r2 = r0.k;
        r3 = r0.i;
        goto L6
    }
}
