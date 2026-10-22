package com.larus.bmhome.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.ResourceUploader", f = "ResourceUploader.kt", i = {0, 0, 0, 1, 1, 1}, l = {159, 166}, m = "upload", n = {"runtimeParam", "uploadScene", "instantUploadConfig", "runtimeParam", "uploadScene", "instantUploadConfig"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ResourceUploader$upload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceUploader this$0;

    public ResourceUploader$upload$1(ResourceUploader r1, Continuation<? super ResourceUploader$upload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
