package com.ss.android.lark.feed.cardcomponent.preview;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function1<ValueAnimator, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Ref.LongRef r1, long r2, Function1<? super ValueAnimator, Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r9) {
        Intrinsics.checkNotNullParameter(r9, "animator");
        long r0 = SystemClock.uptimeMillis();
        Ref.LongRef r2 = this.a;
        if ((r0 - r2.element) < this.b) goto L6;
        r2.element = r0;
        this.c.invoke(r9);
        return;
    }
}
