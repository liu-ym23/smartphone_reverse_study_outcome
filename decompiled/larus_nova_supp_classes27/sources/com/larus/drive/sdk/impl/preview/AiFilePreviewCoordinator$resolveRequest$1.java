package com.larus.drive.sdk.impl.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator", f = "AiFilePreviewCoordinator.kt", i = {0}, l = {136}, m = "resolveRequest", n = {"request"}, s = {"L$0"})
final class AiFilePreviewCoordinator$resolveRequest$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiFilePreviewCoordinator this$0;

    public AiFilePreviewCoordinator$resolveRequest$1(AiFilePreviewCoordinator r1, Continuation<? super AiFilePreviewCoordinator$resolveRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AiFilePreviewCoordinator.c(this.this$0, null, this);
    }
}
