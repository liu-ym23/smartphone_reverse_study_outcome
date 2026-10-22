package com.ss.ugc.live.barrage.controller;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.ugc.live.barrage.view.SurfaceBarrageLayout;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AbsBarrageController a;
    public final /* synthetic */ Ref.IntRef b;

    public a(AbsBarrageController r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        float r0 = this.a.e;
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L21;
        float r7 = ((Float) r6).floatValue();
        AbsBarrageController r1 = this.a;
        r1.e = r7;
        float r2 = r7 - r0;
        if (r7 >= r0) goto L7;
        r2 = (AudioViewModel.ASR_SESSION_IDLE - r0) + r7;
    L7:
        r1.j(r1.a, r2);
        if (this.a.b.isEmpty() == true) goto L10;
    L14:
        View r8 = this.a.k;
        if ((r8 instanceof SurfaceBarrageLayout) == false) goto L17;
        ((SurfaceBarrageLayout) r8).c();
    L18:
        this.b.element++;
        return;
    L17:
        r8.invalidate();
        goto L18
    L10:
        if (this.a.c.isEmpty() == false) goto L14;
        if (this.a.a.isEmpty() == false) goto L14;
        this.a.p();
        goto L14
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
