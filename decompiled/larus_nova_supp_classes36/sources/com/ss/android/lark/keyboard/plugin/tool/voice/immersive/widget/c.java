package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ VoiceWaveBar a;
    public final /* synthetic */ ArrayList<Float> b;
    public final /* synthetic */ ArrayList<Float> c;

    public c(VoiceWaveBar r1, ArrayList<Float> r2, ArrayList<Float> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        if ((this.a.p.isEmpty() | this.b.isEmpty()) == false) goto L5;
        return;
    L5:
        Iterator r0 = CollectionsKt.zip(this.b, this.c).iterator();
        int r1 = 0;
    L7:
        if (r0.hasNext() == false) goto L12;
        int r2 = r1 + 1;
        Pair r3 = (Pair) r0.next();
        float r4 = ((Number) r3.component1()).floatValue();
        float r5 = ((Number) r3.component2()).floatValue() - r4;
        Object r6 = r8.getAnimatedValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
        float r7 = (r4 + ((r5 * ((Float) r6).floatValue()) / 12)) / 2;
        if (this.a.p.size() <= r1) goto L11;
        RectF r9 = (RectF) ListProtector.get(this.a.p, r1);
        VoiceWaveBar r10 = this.a;
        r9.bottom = r10.f + r7;
        ((RectF) ListProtector.get(r10.p, r1)).top = this.a.f - r7;
    L11:
        r1 = r2;
        goto L7
    L12:
        this.a.invalidate();
    }
}
