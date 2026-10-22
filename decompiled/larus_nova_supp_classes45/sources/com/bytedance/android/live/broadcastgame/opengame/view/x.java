package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.View;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.core.gift.IGiftCoreService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ RewardItemViewHolder a;
    public final /* synthetic */ m0 b;

    public x(RewardItemViewHolder r1, m0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        ((IGiftCoreService) jc1.k.n(IGiftCoreService.class)).openGiftDialog(5, this.b.d, "0", null, null);
        this.a.c.invoke();
    }
}
