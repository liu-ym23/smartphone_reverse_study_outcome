package com.larus.bmhome.upload.sdk.impl.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.engine.SkeletonUploadEngine", f = "UploadEngine.kt", i = {0, 0, 0}, l = {93}, m = "upload", n = {"taskId", "route", "credential"}, s = {"L$0", "L$1", "L$2"})
public final class SkeletonUploadEngine$upload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkeletonUploadEngine this$0;

    public SkeletonUploadEngine$upload$1(SkeletonUploadEngine r1, Continuation<? super SkeletonUploadEngine$upload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, null, this);
    }
}
