package com.larus.setting.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController", f = "ManualCacheCleanUiController.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {278, 284}, m = "executeAndReportClean", n = {"operationId", "currentPage", "beforeBytes", "startTime", "operationId", "currentPage", "result", "beforeBytes", "startTime"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"})
final class ManualCacheCleanUiController$executeAndReportClean$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManualCacheCleanUiController this$0;

    public ManualCacheCleanUiController$executeAndReportClean$1(ManualCacheCleanUiController r1, Continuation<? super ManualCacheCleanUiController$executeAndReportClean$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return ManualCacheCleanUiController.b(this.this$0, 0, null, null, 0, this);
    }
}
