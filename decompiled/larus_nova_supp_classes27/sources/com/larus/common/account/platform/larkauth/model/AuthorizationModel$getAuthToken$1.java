package com.larus.common.account.platform.larkauth.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.model.AuthorizationModel", f = "AuthorizationModel.kt", i = {}, l = {19}, m = "getAuthToken", n = {}, s = {})
public final class AuthorizationModel$getAuthToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthorizationModel this$0;

    public AuthorizationModel$getAuthToken$1(AuthorizationModel r1, Continuation<? super AuthorizationModel$getAuthToken$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
