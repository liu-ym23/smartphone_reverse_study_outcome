package com.larus.bmhome.upload.sdk.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.core.UploadPreprocessChain", f = "UploadOrchestrator.kt", i = {0}, l = {149}, m = "process", n = {"current"}, s = {"L$0"})
public final class UploadPreprocessChain$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadPreprocessChain this$0;

    public UploadPreprocessChain$process$1(UploadPreprocessChain r1, Continuation<? super UploadPreprocessChain$process$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
