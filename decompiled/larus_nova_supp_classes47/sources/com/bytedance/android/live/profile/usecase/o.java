package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ boolean b;

    public o(n r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Response r3 = (Response) r2;
        NewProfileUser r4 = this.a.c.getTargetUser();
        boolean r0 = this.b;
        r4.isMuted = r0;
        this.a.b(r0);
    }
}
