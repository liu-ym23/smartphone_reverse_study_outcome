package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository", f = "DoraGGestureSettingsRepository.kt", i = {0, 1}, l = {425, 237}, m = "loadListForBuryPoint", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class DoraGGestureSettingsRepository$loadListForBuryPoint$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGGestureSettingsRepository this$0;

    public DoraGGestureSettingsRepository$loadListForBuryPoint$1(DoraGGestureSettingsRepository r1, Continuation<? super DoraGGestureSettingsRepository$loadListForBuryPoint$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraGGestureSettingsRepository.a(this.this$0, this);
    }
}
