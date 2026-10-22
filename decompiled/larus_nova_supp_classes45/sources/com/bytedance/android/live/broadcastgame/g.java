package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ a a;

    public g(a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        IBaseUser r2 = (IBaseUser) r1;
        this.a.g();
    }
}
