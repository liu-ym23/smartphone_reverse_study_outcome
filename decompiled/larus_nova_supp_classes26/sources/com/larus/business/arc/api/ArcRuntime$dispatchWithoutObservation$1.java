package com.larus.business.arc.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.arc.api.ArcRuntime", f = "ArcRuntime.kt", i = {0, 0}, l = {108}, m = "dispatchWithoutObservation", n = {"argvJson", "context"}, s = {"L$0", "L$1"})
final class ArcRuntime$dispatchWithoutObservation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public ArcRuntime$dispatchWithoutObservation$1(u r1, Continuation<? super ArcRuntime$dispatchWithoutObservation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        u r3 = this.this$0;
        u r0 = u.a;
        return r3.b(null, this);
    }
}
