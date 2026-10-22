package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements qh0.d<rh0.a> {
    public final /* synthetic */ BaseAnchorLinkWidget a;
    public final /* synthetic */ com.bytedance.android.live.network.response.e b;

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        ALogger.d("ttlive_link", "check anchor bluetooth permission failed skip");
        this.a.Bq(this.b);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r2) {
        ALogger.d("ttlive_link", "check anchor bluetooth permission!");
        this.a.Bq(this.b);
    }

    public p(BaseAnchorLinkWidget r1, com.bytedance.android.live.network.response.e r2) {
        this.a = r1;
        this.b = r2;
    }
}
