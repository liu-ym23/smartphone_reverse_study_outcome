package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import io.reactivex.functions.Consumer;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        int r0 = k.a;
        String r1 = r5.getMessage();
        if (r1 != null) goto L5;
        r1 = DSLType.Unknown;
    L5:
        k.a("fetch cloud factor failed trigger by cold start due to ".concat(r1));
        int r2 = DynamicStrategyMonitor.a;
        boolean r3 = a.a;
        String r6 = a.c;
        if ((r5 instanceof ApiServerException) == true) goto L8;
        ApiServerException r7 = null;
    L9:
        ApiServerException r8 = r7;
        if (r8 == null) goto L12;
        int r9 = r8.getErrorCode();
    L13:
        String r10 = r5.getMessage();
        if (r10 != null) goto L16;
        r10 = "api error";
    L16:
        DynamicStrategyMonitor.b(1, r6, r9, r10);
        return;
    L12:
        r9 = 999;
        goto L13
    L8:
        r7 = r5;
        goto L9
    }
}
