package com.obric.assistant.wakeup.co_wakeup.dora.service;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService", f = "CoWakeupService.kt", i = {0, 0, 0}, l = {463}, m = "notifyDoraGStatesForMemory", n = {"connect", "wear", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
public final class CoWakeupService$notifyDoraGStatesForMemory$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoWakeupService this$0;

    public CoWakeupService$notifyDoraGStatesForMemory$1(CoWakeupService r1, Continuation<? super CoWakeupService$notifyDoraGStatesForMemory$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IntCompanionObject.MIN_VALUE;
        CoWakeupService r3 = this.this$0;
        Set<String> r0 = CoWakeupService.r;
        return r3.m(null, null, this);
    }
}
