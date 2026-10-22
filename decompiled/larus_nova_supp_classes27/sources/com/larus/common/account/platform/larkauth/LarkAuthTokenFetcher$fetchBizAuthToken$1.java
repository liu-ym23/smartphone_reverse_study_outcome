package com.larus.common.account.platform.larkauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.LarkAuthTokenFetcher", f = "LarkAuthTokenFetcher.kt", i = {}, l = {68}, m = "fetchBizAuthToken", n = {}, s = {})
public final class LarkAuthTokenFetcher$fetchBizAuthToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkAuthTokenFetcher this$0;

    public LarkAuthTokenFetcher$fetchBizAuthToken$1(LarkAuthTokenFetcher r1, Continuation<? super LarkAuthTokenFetcher$fetchBizAuthToken$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        LarkAuthTokenFetcher r3 = this.this$0;
        LarkAuthTokenFetcher r0 = LarkAuthTokenFetcher.a;
        return r3.b(null, null, this);
    }
}
