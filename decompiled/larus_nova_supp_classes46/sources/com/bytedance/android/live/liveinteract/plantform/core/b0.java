package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ long b;

    public b0(y r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        Intrinsics.checkNotNullParameter(r10, "throwable");
        long r0 = this.b;
        long r3 = System.currentTimeMillis() - r0;
        Set<Long> r1 = InteractLinkFullLinkMonitor.a;
        JSONObject r6 = new JSONObject();
        nd0.c.r(nd0.c.a, LinkMonitorData.ListV2, null, r3, r10, r6, 34);
        com.bytedance.android.live.liveinteract.plantform.utils.x.H(r10, this.a.M.getId(), this.a.M.getOwnerUserIdString());
        y.e(this.a, r10);
        this.a.l = false;
    }
}
