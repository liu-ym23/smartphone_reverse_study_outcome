package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECPlayerView$getPlayerClient$1 extends MutablePropertyReference0Impl {
    public ECPlayerView$getPlayerClient$1(d r10) {
        super(r10, d.class, "liveClient", "getLiveClient()Lcom/bytedance/android/ec/adapter/api/player/IECLivePlayerClient;", 0);
    }

    public Object get() {
        IECLivePlayerClient r0 = ((d) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("liveClient");
    L5:
        return r0;
    }

    public void set(Object r10) {
        IECLivePlayerClient r11 = (IECLivePlayerClient) r10;
        ((d) ((CallableReference) this).receiver).a = r11;
    }
}
