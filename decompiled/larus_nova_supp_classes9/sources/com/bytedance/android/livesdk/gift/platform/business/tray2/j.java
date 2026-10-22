package com.bytedance.android.livesdk.gift.platform.business.tray2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ MatchRoomGiftTrayAnimationView a;

    public j(MatchRoomGiftTrayAnimationView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        hq2.c r3 = (hq2.c) r2;
        if (r3.b == false) goto L7;
        int r4 = r3.a;
        if (r4 <= 0) goto L7;
    L8:
        MatchRoomGiftTrayAnimationView.o(this.a, r4);
        return;
    L7:
        r4 = MatchRoomGiftTrayAnimationView.q(this.a);
        goto L8
    }
}
