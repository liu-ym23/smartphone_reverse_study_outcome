package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.IAppDiskServiceImpl", f = "IAppDiskServiceImpl.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, l = {311, 313, 315, 320, 367}, m = "cleanManualCache", n = {"operationId", "failureStage", "beforeBytes", "operationId", "failureStage", "beforeBytes", "operationId", "failureStage", "beforeBytes", "operationId", "failureStage", "executionResult", "beforeBytes", "operationId", "failureStage", "beforeBytes"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0"})
public final class IAppDiskServiceImpl$cleanManualCache$2 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAppDiskServiceImpl this$0;

    public IAppDiskServiceImpl$cleanManualCache$2(IAppDiskServiceImpl r1, Continuation<? super IAppDiskServiceImpl$cleanManualCache$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
