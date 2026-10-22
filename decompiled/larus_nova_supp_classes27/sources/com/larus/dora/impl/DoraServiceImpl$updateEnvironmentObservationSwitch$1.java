package com.larus.dora.impl;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl", f = "DoraServiceImpl.kt", i = {0, 0}, l = {767}, m = "updateEnvironmentObservationSwitch", n = {"pageConfig", "enable"}, s = {"L$0", "Z$0"})
public final class DoraServiceImpl$updateEnvironmentObservationSwitch$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$updateEnvironmentObservationSwitch$1(DoraServiceImpl r1, Continuation<? super DoraServiceImpl$updateEnvironmentObservationSwitch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        DoraServiceImpl r4 = this.this$0;
        AtomicBoolean r0 = DoraServiceImpl.V0;
        return r4.J1(null, false, this);
    }
}
