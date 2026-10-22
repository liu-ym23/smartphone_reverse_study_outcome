package com.bytedance.ai.core.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {354, 100, 119}, m = "runAppletWorker", n = {"appletId", "application", "conversationId", "botId", "msgId", "replyFor", "sessionType", "traceInfo", "$this$withLock_u24default$iv", "appletId", "application", "conversationId", "botId", "msgId", "replyFor", "sessionType", "traceInfo", "$this$withLock_u24default$iv", "runtime", "deferred", "existingDeferred", "appletId", "$this$withLock_u24default$iv", "runtime", "deferred"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3"})
public final class WorkerRuntimeManager$runAppletWorker$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerRuntimeManager this$0;

    public WorkerRuntimeManager$runAppletWorker$1(WorkerRuntimeManager r1, Continuation<? super WorkerRuntimeManager$runAppletWorker$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, null, null, null, null, this);
    }
}
