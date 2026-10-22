package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.livesdk.message.model.na;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 implements vlc.b {
    public o0() {
    }

    public final boolean onMessage(tlc.d r3) {
        if ((r3 instanceof na) == true) goto L6;
        return false;
    L6:
        if (w2.e().enabled == 1) goto L8;
        return true;
    L8:
        return false;
    }
}
