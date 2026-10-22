package com.larus.dora.impl.file.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.upload.DoraFileUploaderImpl", f = "DoraFileUploaderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {231}, m = "uploadFile", n = {"task", "trigger", "file", "uploadUrl", "uploadTextSem", "uploadResult", "attempt", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "J$0"})
public final class DoraFileUploaderImpl$uploadFile$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileUploaderImpl this$0;

    public DoraFileUploaderImpl$uploadFile$1(DoraFileUploaderImpl r1, Continuation<? super DoraFileUploaderImpl$uploadFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraFileUploaderImpl r3 = this.this$0;
        int r0 = DoraFileUploaderImpl.e;
        return r3.e(null, null, this);
    }
}
