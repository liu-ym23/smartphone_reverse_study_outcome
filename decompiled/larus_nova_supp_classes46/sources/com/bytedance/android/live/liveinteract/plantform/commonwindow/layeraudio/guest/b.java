package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public b(h r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        MultiLinkMicSeatGiftIconElement r3 = this.a.m;
        if (r3 == null) goto L8;
        LinkMicQuickInteractView r4 = r3.c;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    L9:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TextView r3 = this.a.G;
        if (r3 == null) goto L5;
        CharSequence r4 = r3.getText();
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L12;
        TextView r5 = this.a.G;
        if (r5 == null) goto L13;
        r5.setVisibility(0);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
