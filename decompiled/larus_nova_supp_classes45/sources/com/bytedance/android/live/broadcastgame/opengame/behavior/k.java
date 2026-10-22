package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ g a;

    public k(g r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        IBaseUser r2 = (IBaseUser) r1;
        this.a.w();
    }
}
