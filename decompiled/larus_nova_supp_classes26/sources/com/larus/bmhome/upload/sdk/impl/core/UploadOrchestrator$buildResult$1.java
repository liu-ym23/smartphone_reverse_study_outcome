package com.larus.bmhome.upload.sdk.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator", f = "UploadOrchestrator.kt", i = {0, 0, 0}, l = {102}, m = "buildResult", n = {"taskId", "route", "startedAt"}, s = {"L$0", "L$1", "J$0"})
public final class UploadOrchestrator$buildResult$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadOrchestrator this$0;

    public UploadOrchestrator$buildResult$1(UploadOrchestrator r1, Continuation<? super UploadOrchestrator$buildResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, 0, null, this);
    }
}
