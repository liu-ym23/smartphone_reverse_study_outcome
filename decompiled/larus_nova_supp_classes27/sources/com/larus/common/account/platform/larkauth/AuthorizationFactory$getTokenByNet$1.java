package com.larus.common.account.platform.larkauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.AuthorizationFactory", f = "AuthorizationFactory.kt", i = {0, 1, 1}, l = {354, 288}, m = "getTokenByNet", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "cacheKey"}, s = {"L$0", "L$0", "L$1"})
final class AuthorizationFactory$getTokenByNet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthorizationFactory this$0;

    public AuthorizationFactory$getTokenByNet$1(AuthorizationFactory r1, Continuation<? super AuthorizationFactory$getTokenByNet$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(this);
    }
}
