package com.bytedance.android.live.effect.gift;

import com.bytedance.android.livesdk.revenue.service.effect.k;
import com.ss.android.ugc.effectmanager.IFetchModelListener;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements IFetchModelListener {
    public final /* synthetic */ Map a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.a b;

    public final void onFailed(Exception r2) {
        com.bytedance.android.live.effect.api.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailure(r2);
        return;
    }

    public final void onSuccess(String[] r1) {
        com.bytedance.android.live.effect.api.a r2 = this.b;
        if (r2 == null) goto L6;
        r2.onSuccess();
        return;
    }

    public b(Map r1, k.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
