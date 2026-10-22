package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends BaseAnimationListener {
    public final /* synthetic */ m.a a;

    public l(m.a r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        this.a.a.setVisibility(8);
    }
}
