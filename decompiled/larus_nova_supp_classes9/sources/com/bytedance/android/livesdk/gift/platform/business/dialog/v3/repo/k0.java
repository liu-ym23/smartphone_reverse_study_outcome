package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UserLogin;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ n0 a;

    public k0(n0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ds2.d r3 = (ds2.d) r2;
        this.a.d.a(new UserLogin());
    }
}
