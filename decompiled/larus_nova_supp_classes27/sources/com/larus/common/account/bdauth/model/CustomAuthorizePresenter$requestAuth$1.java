package com.larus.common.account.bdauth.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.model.CustomAuthorizePresenter", f = "CustomAuthorizePresenter.kt", i = {}, l = {81}, m = "requestAuth", n = {}, s = {})
final class CustomAuthorizePresenter$requestAuth$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CustomAuthorizePresenter$requestAuth$1(a r1, Continuation<? super CustomAuthorizePresenter$requestAuth$1> r2) {
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
