package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements IPlayerController.FirstGLFrameListener {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final void a() {
        IPlayerActionListener r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.onFirstFrame();
        return;
    }
}
