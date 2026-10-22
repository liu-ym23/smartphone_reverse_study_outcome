package com.bytedance.android.livesdk.interactivity.seek.v2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e a;

    public i(lmc.a.f r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.ss.ugc.live.sdk.msg.network.e r0 = this.a;
        int r1 = com.ss.ugc.live.sdk.msg.utils.g.a;
        r0.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception((Throwable) r3)));
    }
}
