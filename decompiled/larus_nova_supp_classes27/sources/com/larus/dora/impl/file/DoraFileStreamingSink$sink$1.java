package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileStreamingSink", f = "DoraFileStreamingSink.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {323, 332}, m = "sink", n = {"deferred", "assembler", "callback", "requestId", "startTime", "assembler", "callback", "requestId", "startTime"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "L$0", "L$1", "I$0", "J$0"})
public final class DoraFileStreamingSink$sink$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileStreamingSink this$0;

    public DoraFileStreamingSink$sink$1(DoraFileStreamingSink r1, Continuation<? super DoraFileStreamingSink$sink$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
