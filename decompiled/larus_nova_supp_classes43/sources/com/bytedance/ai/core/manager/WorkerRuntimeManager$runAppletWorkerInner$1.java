package com.bytedance.ai.core.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {184}, m = "runAppletWorkerInner", n = {"appletId", "application", "conversationId", "botId", "msgId", "replyFor", "sessionType", "traceInfo", "runtime", "traceId", "eventType", "startTime", "loadStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "J$1"})
final class WorkerRuntimeManager$runAppletWorkerInner$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
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

    public WorkerRuntimeManager$runAppletWorkerInner$1(WorkerRuntimeManager r1, Continuation<? super WorkerRuntimeManager$runAppletWorkerInner$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return WorkerRuntimeManager.a(this.this$0, null, null, null, null, null, null, null, null, this);
    }
}
