package com.larus.bmhome.upload.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.ApiCredentialProviderAdapter", f = "ImageUploadSdkBuilder.kt", i = {}, l = {185}, m = "fetch", n = {}, s = {})
public final class ApiCredentialProviderAdapter$fetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApiCredentialProviderAdapter this$0;

    public ApiCredentialProviderAdapter$fetch$1(ApiCredentialProviderAdapter r1, Continuation<? super ApiCredentialProviderAdapter$fetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
