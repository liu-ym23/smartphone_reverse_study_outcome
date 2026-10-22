package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationResultSubmitter", f = "ClarificationResultSubmitter.kt", i = {}, l = {68}, m = "submitByAskHumanResult", n = {}, s = {})
public final class ClarificationResultSubmitter$submitByAskHumanResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ClarificationResultSubmitter this$0;

    public ClarificationResultSubmitter$submitByAskHumanResult$1(ClarificationResultSubmitter r1, Continuation<? super ClarificationResultSubmitter$submitByAskHumanResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ClarificationResultSubmitter r3 = this.this$0;
        int r0 = ClarificationResultSubmitter.b;
        return r3.b(null, this);
    }
}
