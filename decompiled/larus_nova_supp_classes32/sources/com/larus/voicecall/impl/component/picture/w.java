package com.larus.voicecall.impl.component.picture;

import android.view.animation.Animation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w implements Animation.AnimationListener {
    public final /* synthetic */ SimpleDraweeView a;
    public final /* synthetic */ RealtimePictureComponent b;
    public final /* synthetic */ x3a.a c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        SimpleDraweeView r3 = this.a;
        if (r3 == null) goto L5;
        e1.o(r3);
    L5:
        this.b.G3(this.c);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
        SimpleDraweeView r2 = this.a;
        if (r2 == null) goto L6;
        e1.x(r2);
        return;
    }

    public w(SimpleDraweeView r1, RealtimePictureComponent r2, x3a.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
