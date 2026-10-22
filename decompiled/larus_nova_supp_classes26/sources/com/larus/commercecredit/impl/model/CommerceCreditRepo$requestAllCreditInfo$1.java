package com.larus.commercecredit.impl.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.model.CommerceCreditRepo", f = "CommerceCreditRepo.kt", i = {0, 0, 0}, l = {85}, m = "requestAllCreditInfo", n = {"postActionProcessor", "keva", "needTasks"}, s = {"L$0", "L$1", "Z$0"})
final class CommerceCreditRepo$requestAllCreditInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public CommerceCreditRepo$requestAllCreditInfo$1(c r1, Continuation<? super CommerceCreditRepo$requestAllCreditInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(false, null, this);
    }
}
