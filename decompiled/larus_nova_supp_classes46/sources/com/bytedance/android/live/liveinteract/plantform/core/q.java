package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ String a;

    public q(String r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        String r5 = this.a;
        int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r5, "token");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("token", r5);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("notify_join_rtc_success", r1);
    }
}
