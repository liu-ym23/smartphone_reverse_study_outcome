package com.larus.uaigc.chat.loading;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.CreationQueuingTaskViewModel", f = "CreationQueuingTaskViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {127, 135, 145, 173, 174}, m = "refreshQueuingStatusRegularly", n = {"msg", "task", "queuingKey", "maxFetchCount", "msg", "task", "queuingKey", "taskId", "maxFetchCount", "msg", "task", "queuingKey", "maxFetchCount", "msg", "task", "queuingKey", "loadingInfo", "maxFetchCount"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
public final class CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationQueuingTaskViewModel this$0;

    public CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1(CreationQueuingTaskViewModel r1, Continuation<? super CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        CreationQueuingTaskViewModel r0 = this.this$0;
        int r9 = CreationQueuingTaskViewModel.g;
        return r0.a(null, null, null, false, 0, this);
    }
}
