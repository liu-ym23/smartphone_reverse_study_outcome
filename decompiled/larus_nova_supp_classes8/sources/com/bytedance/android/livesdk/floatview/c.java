package com.bytedance.android.livesdk.floatview;

import android.animation.ValueAnimator;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ double b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ double e;
    public final /* synthetic */ double f;
    public final /* synthetic */ int g;
    public final /* synthetic */ Function0 h;

    public c(b r1, double r2, int r4, int r5, double r6, double r8, int r10, Function0 r11) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
        this.h = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        Object r8 = r7.getAnimatedValue();
        if ((r8 instanceof Integer) == true) goto L5;
        r8 = null;
    L5:
        Integer r9 = (Integer) r8;
        if (r9 == null) goto L13;
        int r10 = r9.intValue();
        int r0 = (int) (((double) r10) * this.b);
        a1.p(this.a.e, r0);
        a1.k(this.a.e, r10);
        int r1 = this.c;
        if ((r1 - r0) < 0) goto L10;
        int r2 = r1 - r0;
    L11:
        int r3 = this.d - r10;
        int r11 = (int) (((double) r2) * this.e);
        int r4 = r2 - r11;
        int r5 = (int) (((double) r3) * this.f);
        int r6 = (r3 - r5) + this.g;
        a1.m(this.a.e, r11);
        a1.o(this.a.e, r6);
        a1.n(this.a.e, r4);
        a1.l(this.a.e, r5);
        return;
    L10:
        r2 = 0;
        goto L11
    }
}
