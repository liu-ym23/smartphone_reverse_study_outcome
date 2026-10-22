package com.bytedance.android.ec.core.utils;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends h {
    public final /* synthetic */ Function1 a;

    public e(Function1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.ec.core.utils.h, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.invoke(r10);
    }
}
