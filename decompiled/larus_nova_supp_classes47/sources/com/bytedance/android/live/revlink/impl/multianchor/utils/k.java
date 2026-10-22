package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revenuelink.connect.ConnectDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ i a;

    public k(i r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        sh6.b r8 = (sh6.b) r7;
        com.bytedance.android.livesdk.revenue.service.room.c r9 = this.a.d;
        if (r9 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r10 = r9.getRoomContext();
        if (r10 == null) goto L9;
        IRoomBase r12 = r10.getCommonRoom();
        if (r12 == null) goto L9;
        Long r13 = Long.valueOf(IRoomKtKt.getId(r12));
    L10:
        StringBuilder r1 = new StringBuilder("liveStartTime=");
        r1.append(this.a.b);
        r1.append(", current live duration=");
        i97.a r2 = i97.a.a;
        r1.append((System.currentTimeMillis() - this.a.b) / ((long) WebcastRedirectException.UNKNOWN));
        r1.append("s roomId=");
        r1.append(r13);
        jy0.b.f(ConnectDataContext.TAG, r1.toString(), null, 4);
        return;
    L9:
        r13 = null;
        goto L10
    }
}
