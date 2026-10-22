package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ AudienceLaunchMgContextService a;

    public e(AudienceLaunchMgContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        int r0 = qo0.a.a;
        String r1 = this.a.a;
        qo0.a.b(r1, "request report live sum failed", (Throwable) r3);
    }
}
