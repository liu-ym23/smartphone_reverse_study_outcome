package com.larus.commercemembership.impl.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercemembership.impl.model.CommerceMembershipRepo", f = "CommerceMembershipRepo.kt", i = {0, 0}, l = {56}, m = "requestSubscriptionEntryConfig", n = {"from", "postActionProcessor"}, s = {"L$0", "L$1"})
final class CommerceMembershipRepo$requestSubscriptionEntryConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public CommerceMembershipRepo$requestSubscriptionEntryConfig$1(c r1, Continuation<? super CommerceMembershipRepo$requestSubscriptionEntryConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
