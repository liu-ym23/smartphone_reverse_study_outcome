package com.larus.drive.sdk.impl.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator", f = "AiFilePreviewCoordinator.kt", i = {0}, l = {153}, m = "resolveResourceUri", n = {"startedAtMs"}, s = {"J$0"})
public final class AiFilePreviewCoordinator$resolveResourceUri$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiFilePreviewCoordinator this$0;

    public AiFilePreviewCoordinator$resolveResourceUri$1(AiFilePreviewCoordinator r1, Continuation<? super AiFilePreviewCoordinator$resolveResourceUri$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AiFilePreviewCoordinator r3 = this.this$0;
        AiFilePreviewCoordinator r0 = AiFilePreviewCoordinator.a;
        return r3.e(null, this);
    }
}
