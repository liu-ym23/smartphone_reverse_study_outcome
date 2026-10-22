package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ FormatGiftPanelDialogViewModel a;

    public f(FormatGiftPanelDialogViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IBaseUser r5 = (IBaseUser) r4;
        k.n(IRechargeService.class).rechargeCenter().sync(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.v(false, true, 3, false));
        FormatGiftPanelDialogViewModel r6 = this.a;
        r6.a.setValue(r6.f.b());
    }
}
