package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LinearLayout r3 = this.a.z;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        TextView r4 = this.a.B;
        if (r4 == null) goto L9;
        r4.setText("");
        return;
    }
}
