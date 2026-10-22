package com.obric.aikernel;

import com.bytedance.crash.event.EnsureReportData;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.RequestTracker", f = "RequestTracker.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {133}, m = "trackBizCall", n = {"this", EnsureReportData.METHOD, "biz", "ret", "builder", "handled", "start$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
final class RequestTracker$trackBizCall$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestTracker this$0;

    RequestTracker$trackBizCall$1(RequestTracker r10, Continuation<? super RequestTracker$trackBizCall$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return RequestTracker.j(this.this$0, null, null, null, this);
    }
}
