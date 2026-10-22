package com.larus.bmhome.taskskill.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.service.TaskModeService$Companion", f = "TaskModeService.kt", i = {}, l = {55}, m = "authorizeDevice", n = {}, s = {})
public final class TaskModeService$Companion$authorizeDevice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskModeService.Companion this$0;

    public TaskModeService$Companion$authorizeDevice$1(TaskModeService.Companion r1, Continuation<? super TaskModeService$Companion$authorizeDevice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
