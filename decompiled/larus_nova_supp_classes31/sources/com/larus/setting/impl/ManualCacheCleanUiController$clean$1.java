package com.larus.setting.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController", f = "ManualCacheCleanUiController.kt", i = {0, 0, 0, 0, 0}, l = {202}, m = "clean", n = {"fragment", "item", "operationId", "formatSize", "uiTimeoutMs"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
final class ManualCacheCleanUiController$clean$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManualCacheCleanUiController this$0;

    public ManualCacheCleanUiController$clean$1(ManualCacheCleanUiController r1, Continuation<? super ManualCacheCleanUiController$clean$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ManualCacheCleanUiController.a(this.this$0, null, null, 0, null, null, null, this);
    }
}
