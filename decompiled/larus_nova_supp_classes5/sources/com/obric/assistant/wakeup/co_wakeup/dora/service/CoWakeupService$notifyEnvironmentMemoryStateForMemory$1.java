package com.obric.assistant.wakeup.co_wakeup.dora.service;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService", f = "CoWakeupService.kt", i = {0, 0}, l = {463}, m = "notifyEnvironmentMemoryStateForMemory", n = {"$this$withLock_u24default$iv", DBDefinition.FORCE}, s = {"L$0", "Z$0"})
final class CoWakeupService$notifyEnvironmentMemoryStateForMemory$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoWakeupService this$0;

    public CoWakeupService$notifyEnvironmentMemoryStateForMemory$1(CoWakeupService r1, Continuation<? super CoWakeupService$notifyEnvironmentMemoryStateForMemory$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IntCompanionObject.MIN_VALUE;
        return CoWakeupService.i(this.this$0, false, this);
    }
}
