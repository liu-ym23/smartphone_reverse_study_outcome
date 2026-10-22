package com.larus.bmhome.upload.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.ApiUploadEngineAdapter", f = "ImageUploadSdkBuilder.kt", i = {}, l = {206}, m = "upload", n = {}, s = {})
public final class ApiUploadEngineAdapter$upload$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApiUploadEngineAdapter this$0;

    public ApiUploadEngineAdapter$upload$1(ApiUploadEngineAdapter r1, Continuation<? super ApiUploadEngineAdapter$upload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, null, this);
    }
}
