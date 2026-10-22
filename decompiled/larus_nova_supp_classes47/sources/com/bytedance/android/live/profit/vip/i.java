package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ VipDataService a;

    public i(VipDataService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        this.a.e.d("enter");
    }
}
