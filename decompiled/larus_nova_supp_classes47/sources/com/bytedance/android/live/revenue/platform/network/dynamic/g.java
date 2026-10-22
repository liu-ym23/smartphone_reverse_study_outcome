package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements ylc.c {
    public final /* synthetic */ DynamicHostNetworkServiceImpl a;
    public final /* synthetic */ PublishProcessor b;
    public final /* synthetic */ PublishSubject c;

    public final void onClear() {
    }

    public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r3) {
        Intrinsics.checkNotNullParameter(r3, "roomDataSync");
        if (this.a.c.getEnableWRDSMethodSampling() == true) goto L5;
    L7:
        this.c.onNext(r3);
        return;
    L5:
        if (this.a.c.getEnableWRDSMethodSamplingKey().contains(r3.g) == false) goto L7;
        this.b.onNext(r3);
    }

    public g(DynamicHostNetworkServiceImpl r1, PublishProcessor r2, PublishSubject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
