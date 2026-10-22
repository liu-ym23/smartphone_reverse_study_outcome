package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RenewFansClub;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ GiftMVIFanClubTopView a;

    public y(GiftMVIFanClubTopView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if ((((com.bytedance.android.live.profit.fansclub.c) r4) instanceof com.bytedance.android.live.profit.fansclub.c.h) == false) goto L6;
        GiftMVIFanClubTopView r5 = this.a;
        r5.t(r5.t.c(), s1.B(2131917126), 2131253201);
        this.a.o(new RenewFansClub());
        return;
    }
}
