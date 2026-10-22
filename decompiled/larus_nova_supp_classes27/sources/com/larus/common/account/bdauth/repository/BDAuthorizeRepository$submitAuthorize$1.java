package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository", f = "BDAuthorizeRepository.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {213, 242, 251, 257, 257}, m = "submitAuthorize", n = {"request", "selectedAccount", "request", "targetAccount", "sceneSnapshot", "targetAccount", "sceneSnapshot"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class BDAuthorizeRepository$submitAuthorize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDAuthorizeRepository this$0;

    public BDAuthorizeRepository$submitAuthorize$1(BDAuthorizeRepository r1, Continuation<? super BDAuthorizeRepository$submitAuthorize$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, this);
    }
}
