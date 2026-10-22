package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IUser r4 = (IUser) r3;
        g r0 = this.a;
        if ((r4 instanceof User) == true) goto L5;
        r4 = null;
    L5:
        r0.i((User) r4);
    }
}
