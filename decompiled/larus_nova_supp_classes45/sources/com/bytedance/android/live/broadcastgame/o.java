package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ AudienceMagicBoxBehavior a;

    public o(AudienceMagicBoxBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        IBaseUser r2 = (IBaseUser) r1;
        this.a.f();
    }
}
