package com.bytedance.android.live.effect.gift;

import com.bytedance.android.livesdk.revenue.service.effect.k;
import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements IFetchResourceListener {
    public final /* synthetic */ Map a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.a b;

    public final void onFailure(Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        com.bytedance.android.live.effect.api.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailure(r2);
        return;
    }

    public final void onSuccess(long r1) {
        com.bytedance.android.live.effect.api.a r2 = this.b;
        if (r2 == null) goto L6;
        r2.onSuccess();
        return;
    }

    public a(Map r1, k.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
