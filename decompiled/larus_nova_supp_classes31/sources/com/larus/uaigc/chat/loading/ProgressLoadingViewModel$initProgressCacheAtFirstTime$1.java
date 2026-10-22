package com.larus.uaigc.chat.loading;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel", f = "ProgressLoadingViewModel.kt", i = {}, l = {423}, m = "initProgressCacheAtFirstTime", n = {}, s = {})
public final class ProgressLoadingViewModel$initProgressCacheAtFirstTime$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProgressLoadingViewModel this$0;

    public ProgressLoadingViewModel$initProgressCacheAtFirstTime$1(ProgressLoadingViewModel r1, Continuation<? super ProgressLoadingViewModel$initProgressCacheAtFirstTime$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ProgressLoadingViewModel.access$initProgressCacheAtFirstTime(this.this$0, null, this);
    }
}
