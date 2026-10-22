package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public j(g r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        wr1.b r3 = this.a.c;
        if (r3 == null) goto L7;
        LiveBlurAnimView r4 = r3.getView();
        if (r4 == null) goto L7;
        r4.setVisibility(8);
    L7:
        wr1.b r5 = this.a.c;
        if (r5 == null) goto L11;
        r5.b(1.0f);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        wr1.b r3 = this.a.c;
        if (r3 == null) goto L7;
        LiveBlurAnimView r4 = r3.getView();
        if (r4 == null) goto L7;
        r4.setVisibility(0);
    L7:
        wr1.b r5 = this.a.c;
        if (r5 == null) goto L11;
        r5.b(1.0f);
        return;
    }
}
