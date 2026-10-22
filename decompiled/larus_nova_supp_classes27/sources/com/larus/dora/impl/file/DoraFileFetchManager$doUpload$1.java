package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager", f = "DoraFileFetchManager.kt", i = {0}, l = {562}, m = "doUpload", n = {"task"}, s = {"L$0"})
public final class DoraFileFetchManager$doUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileFetchManager this$0;

    public DoraFileFetchManager$doUpload$1(DoraFileFetchManager r1, Continuation<? super DoraFileFetchManager$doUpload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraFileFetchManager r3 = this.this$0;
        int r0 = DoraFileFetchManager.n;
        return r3.d(null, this);
    }
}
