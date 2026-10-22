package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod", f = "DoraBudsTxSyncMethod.kt", i = {0, 1, 1}, l = {153, 168}, m = "executeVolumeAdaptation", n = {"deviceKey", "deviceKey", "nextState"}, s = {"L$0", "L$0", "I$0"})
public final class DoraBudsTxSyncMethod$executeVolumeAdaptation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBudsTxSyncMethod this$0;

    public DoraBudsTxSyncMethod$executeVolumeAdaptation$1(DoraBudsTxSyncMethod r1, Continuation<? super DoraBudsTxSyncMethod$executeVolumeAdaptation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraBudsTxSyncMethod r3 = this.this$0;
        IntRange r0 = DoraBudsTxSyncMethod.b;
        return r3.c(null, this);
    }
}
