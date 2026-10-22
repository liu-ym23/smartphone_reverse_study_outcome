package com.larus.voicecall.impl.component.picture;

import android.view.animation.Animation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v implements Animation.AnimationListener {
    public final /* synthetic */ SimpleDraweeView a;
    public final /* synthetic */ RealtimePictureComponent b;
    public final /* synthetic */ x3a.a c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        e1.o(this.a);
        this.b.G3(this.c);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
        e1.x(this.a);
    }

    public v(SimpleDraweeView r1, RealtimePictureComponent r2, x3a.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
