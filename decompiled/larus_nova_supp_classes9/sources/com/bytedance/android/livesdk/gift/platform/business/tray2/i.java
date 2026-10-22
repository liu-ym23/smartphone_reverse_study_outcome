package com.bytedance.android.livesdk.gift.platform.business.tray2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MatchRoomGiftTrayAnimationView a;

    public i(MatchRoomGiftTrayAnimationView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        if (r5.intValue() <= 0) goto L5;
        int r6 = r5.intValue() + MatchRoomGiftTrayAnimationView.p(this.a);
    L6:
        MatchRoomGiftTrayAnimationView.o(this.a, r6);
        if (this.a.getChildCount() <= 0) goto L10;
        this.a.m(20, false);
        return;
    L10:
        return;
    L5:
        r6 = MatchRoomGiftTrayAnimationView.q(this.a);
        goto L6
    }
}
