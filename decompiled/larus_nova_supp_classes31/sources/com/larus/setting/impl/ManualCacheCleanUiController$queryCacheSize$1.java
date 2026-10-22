package com.larus.setting.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController", f = "ManualCacheCleanUiController.kt", i = {0}, l = {318}, m = "queryCacheSize", n = {"uiTimeoutMs"}, s = {"J$0"})
public final class ManualCacheCleanUiController$queryCacheSize$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ManualCacheCleanUiController this$0;

    public ManualCacheCleanUiController$queryCacheSize$1(ManualCacheCleanUiController r1, Continuation<? super ManualCacheCleanUiController$queryCacheSize$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ManualCacheCleanUiController r3 = this.this$0;
        ManualCacheCleanUiController r0 = ManualCacheCleanUiController.a;
        return r3.e(this);
    }
}
