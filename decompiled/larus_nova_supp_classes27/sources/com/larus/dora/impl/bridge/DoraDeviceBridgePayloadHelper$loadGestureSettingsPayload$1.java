package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraDeviceBridgePayloadHelper", f = "DoraDeviceBridgePayloadHelper.kt", i = {0, 0, 1, 1}, l = {36, 37}, m = "loadGestureSettingsPayload", n = {"device", "supportAbilities", "device", "supportAbilities"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraDeviceBridgePayloadHelper this$0;

    public DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1(DoraDeviceBridgePayloadHelper r1, Continuation<? super DoraDeviceBridgePayloadHelper$loadGestureSettingsPayload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
