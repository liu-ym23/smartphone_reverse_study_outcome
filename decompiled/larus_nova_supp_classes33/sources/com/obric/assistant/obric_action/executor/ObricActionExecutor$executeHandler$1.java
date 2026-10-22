package com.obric.assistant.obric_action.executor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.executor.ObricActionExecutor", f = "ObricActionExecutor.kt", i = {}, l = {55}, m = "executeHandler", n = {}, s = {})
public final class ObricActionExecutor$executeHandler$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricActionExecutor this$0;

    public ObricActionExecutor$executeHandler$1(ObricActionExecutor r1, Continuation<? super ObricActionExecutor$executeHandler$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ObricActionExecutor r3 = this.this$0;
        int r0 = ObricActionExecutor.b;
        return r3.b(null, null, null, this);
    }
}
