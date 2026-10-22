package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k9<T> implements Consumer {
    public final /* synthetic */ m9 a;
    public final /* synthetic */ w20.vc b;

    public k9(m9 r1, w20.vc r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        this.a.j(this.b);
    }
}
