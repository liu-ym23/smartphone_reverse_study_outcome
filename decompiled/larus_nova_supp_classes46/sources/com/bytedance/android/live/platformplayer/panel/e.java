package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdk.message.model.nk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements vlc.l {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r2) {
        if ((r2 instanceof nk) == true) goto L5;
        return;
    L5:
        this.a.a((nk) r2);
    }
}
