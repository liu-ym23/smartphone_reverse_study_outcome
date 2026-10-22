package com.obric.assistant.chat.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.internal.SingleImageWithTextHandler", f = "SingleImageWithTextHandler.kt", i = {0}, l = {190}, m = "restoreImage", n = {"startTime"}, s = {"J$0"})
public final class SingleImageWithTextHandler$restoreImage$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleImageWithTextHandler this$0;

    public SingleImageWithTextHandler$restoreImage$1(SingleImageWithTextHandler r1, Continuation<? super SingleImageWithTextHandler$restoreImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
