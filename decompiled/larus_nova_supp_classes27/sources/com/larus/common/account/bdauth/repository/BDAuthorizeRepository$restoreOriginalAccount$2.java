package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository", f = "BDAuthorizeRepository.kt", i = {0, 0, 0}, l = {572, 575}, m = "restoreOriginalAccount", n = {"originalAccount", "sceneSnapshot", "retryIndex"}, s = {"L$0", "L$1", "I$2"})
public final class BDAuthorizeRepository$restoreOriginalAccount$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BDAuthorizeRepository this$0;

    public BDAuthorizeRepository$restoreOriginalAccount$2(BDAuthorizeRepository r1, Continuation<? super BDAuthorizeRepository$restoreOriginalAccount$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, this);
    }
}
