package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import io.reactivex.functions.Consumer;
import java.util.List;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Boolean a;

    public c(Boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        BaseResponse r4 = (BaseResponse) r3;
        String r0 = ((x) r4.extra).a();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (this.a.booleanValue() == false) goto L8;
        boolean r1 = a.a;
        y r5 = (y) r4.data;
        a.b(r0);
    L13:
        k.a("fetch cloud factor success trigger by cold start");
        int r6 = DynamicStrategyMonitor.a;
        DynamicStrategyMonitor.c(1, a.c);
        return;
    L8:
        boolean r2 = a.a;
        y r7 = (y) r4.data;
        if (r7 == null) goto L11;
        List<m> r8 = r7.featureData;
    L12:
        a.a(r8, r0);
        goto L13
    L11:
        r8 = null;
        goto L12
    }
}
