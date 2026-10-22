package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends d {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.util.d, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.invoke(r2);
    }
}
