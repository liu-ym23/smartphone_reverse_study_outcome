package com.bytedance.ai.core.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0}, l = {69}, m = "safeRun", n = {"$this$safeRun"}, s = {"L$0"})
public final class WorkerRuntimeManager$safeRun$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerRuntimeManager this$0;

    public WorkerRuntimeManager$safeRun$1(WorkerRuntimeManager r1, Continuation<? super WorkerRuntimeManager$safeRun$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        WorkerRuntimeManager r11 = this.this$0;
        int r0 = WorkerRuntimeManager.e;
        return r11.c(null, null, this);
    }
}
