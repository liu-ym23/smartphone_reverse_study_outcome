package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ RtcManager a;

    public k0(RtcManager r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        tf0.i r7 = this.a.J;
        int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r7, "dataHolder");
        HashMap r1 = new HashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.x.a(r1);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_start_time_out", r1, r7, true);
        InteractLinkFullLinkMonitor.d0(-12301, "start rtc time out");
        v r2 = this.a.c;
        if (r2 == null) goto L6;
        r2.R(-12301, new IllegalStateException("start time out"));
        return;
    }
}
