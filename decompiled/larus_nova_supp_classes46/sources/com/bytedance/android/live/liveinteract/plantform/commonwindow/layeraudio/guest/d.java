package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public d(h r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.B;
        if (r3 == null) goto L5;
        CharSequence r4 = r3.getText();
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        LinearLayout r5 = this.a.z;
        if (r5 == null) goto L11;
        r5.setVisibility(0);
    L11:
        LinearLayout r6 = this.a.z;
        if (r6 == null) goto L16;
        r6.setAlpha(0.0f);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
