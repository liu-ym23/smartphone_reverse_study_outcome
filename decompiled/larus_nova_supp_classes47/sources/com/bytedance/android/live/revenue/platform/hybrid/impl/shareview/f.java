package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements Action {
    public final /* synthetic */ RevShareViewServiceImpl.c a;
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c b;

    public f(RevShareViewServiceImpl.c r1, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        Map<String, ? extends Object> r0 = MapsKt.mapOf(TuplesKt.to("id", this.a.b));
        this.b.a("share-view-unload", r0);
        RevShareViewServiceImpl.c r1 = this.a;
        r1.a.a.remove(r1.b);
    }
}
