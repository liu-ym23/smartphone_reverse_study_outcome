package com.larus.platform.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.platform.service.AccountService", f = "AccountService.kt", i = {}, l = {116}, m = "queryUserInfoWhenCacheEmpty", n = {}, s = {})
public final class AccountService$queryUserInfoWhenCacheEmpty$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountService this$0;

    public AccountService$queryUserInfoWhenCacheEmpty$1(AccountService r1, Continuation<? super AccountService$queryUserInfoWhenCacheEmpty$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
