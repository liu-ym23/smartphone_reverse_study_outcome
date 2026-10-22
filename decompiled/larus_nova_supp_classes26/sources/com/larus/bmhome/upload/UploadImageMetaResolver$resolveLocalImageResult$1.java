package com.larus.bmhome.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.UploadImageMetaResolver", f = "UploadImageMetaResolver.kt", i = {}, l = {41}, m = "resolveLocalImageResult", n = {}, s = {})
public final class UploadImageMetaResolver$resolveLocalImageResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadImageMetaResolver this$0;

    public UploadImageMetaResolver$resolveLocalImageResult$1(UploadImageMetaResolver r1, Continuation<? super UploadImageMetaResolver$resolveLocalImageResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
