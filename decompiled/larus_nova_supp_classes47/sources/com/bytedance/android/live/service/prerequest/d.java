package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        b r5 = this.a;
        m r0 = r5.h.getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.getOwner();
        if (r2 == null) goto L9;
        String r6 = r2.getIdString();
    L10:
        r5.g(String.valueOf(r6), false);
        return;
    L9:
        r6 = null;
        goto L10
    }
}
