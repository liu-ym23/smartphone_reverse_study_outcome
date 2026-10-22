package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager", f = "DoraFileFetchManager.kt", i = {0, 0, 1, 1, 1}, l = {579, 582}, m = "sink", n = {"maxRetries", "retryCount", "currentWrapper", "maxRetries", "retryCount"}, s = {"I$0", "I$1", "L$0", "I$0", "I$1"})
public final class DoraFileFetchManager$sink$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileFetchManager this$0;

    public DoraFileFetchManager$sink$1(DoraFileFetchManager r1, Continuation<? super DoraFileFetchManager$sink$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraFileFetchManager r3 = this.this$0;
        int r0 = DoraFileFetchManager.n;
        return r3.i(null, this);
    }
}
