package com.bytedance.android.live.profit.livepet.utils;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.live.revenue.common.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends f {
    public final /* synthetic */ View a;
    public final /* synthetic */ DebugModeKt$enableLivePetDebugView$8.c b;

    @Override // com.bytedance.android.live.revenue.common.f, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.a.$petContainer.removeView(this.a);
    }

    public b(View r1, DebugModeKt$enableLivePetDebugView$8.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
