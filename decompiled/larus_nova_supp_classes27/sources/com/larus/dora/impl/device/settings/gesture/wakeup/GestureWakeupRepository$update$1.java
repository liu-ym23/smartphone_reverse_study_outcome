package com.larus.dora.impl.device.settings.gesture.wakeup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository", f = "GestureWakeupRepository.kt", i = {0, 0, 0, 1, 1, 2, 2, 3}, l = {300, 129, 130, 132}, m = "update", n = {"type", "$this$withLock_u24default$iv", "side", "$this$withLock_u24default$iv", "result", "$this$withLock_u24default$iv", "result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0"})
public final class GestureWakeupRepository$update$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureWakeupRepository this$0;

    public GestureWakeupRepository$update$1(GestureWakeupRepository r1, Continuation<? super GestureWakeupRepository$update$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.update(0, null, this);
    }
}
