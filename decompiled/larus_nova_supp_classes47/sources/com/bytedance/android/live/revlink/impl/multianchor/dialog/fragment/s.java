package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.animation.Animation;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoInviteView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements Animation.AnimationListener {
    public final /* synthetic */ AnchorLinkMatchInviteFragment a;
    public final /* synthetic */ AnchorLinkInfoInviteView b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.b.getIvAvatar() != null) goto L5;
        return;
    L5:
        if (this.a.i == null) goto L9;
        this.b.getIvAvatar().startAnimation(this.a.i);
        return;
    }

    public s(AnchorLinkMatchInviteFragment r1, AnchorLinkInfoInviteView r2) {
        this.a = r1;
        this.b = r2;
    }
}
