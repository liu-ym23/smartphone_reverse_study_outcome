package com.larus.voicecall.impl.component.picture;

import android.view.animation.Animation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u implements Animation.AnimationListener {
    public final /* synthetic */ SimpleDraweeView a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    public u(SimpleDraweeView r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
        SimpleDraweeView r2 = this.a;
        if (r2 == null) goto L6;
        e1.o(r2);
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
        SimpleDraweeView r2 = this.a;
        if (r2 == null) goto L6;
        e1.x(r2);
        return;
    }
}
