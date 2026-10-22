package com.bytedance.android.live.broadcast;

import com.bytedance.android.live.broadcast.effect.EffectHostLiveService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BroadcastEffectService implements h {
    public EffectHostLiveService a;
    public final Lazy b;

    @Override // com.bytedance.android.live.broadcast.h
    public final EffectHostLiveService a() {
        if (this.a != null) goto L5;
        this.a = new EffectHostLiveService();
    L5:
        EffectHostLiveService r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public BroadcastEffectService() {
        this.b = LazyKt.lazy(BroadcastEffectService$commonService$2.INSTANCE);
    }
}
