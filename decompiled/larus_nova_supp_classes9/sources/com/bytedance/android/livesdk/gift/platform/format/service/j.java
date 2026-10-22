package com.bytedance.android.livesdk.gift.platform.format.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.recharge.IRechargeService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        jc1.k.n(IRechargeService.class).rechargeCenter().sync(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
    }
}
