package com.larus.doc.impl.operation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager", f = "DocOpManager.kt", i = {0, 0, 1, 1}, l = {390, 407}, m = "getShareLink", n = {"resourceId", "bizExtra", "resourceId", "shareLink"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class DocOpManager$getShareLink$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocOpManager this$0;

    public DocOpManager$getShareLink$1(DocOpManager r1, Continuation<? super DocOpManager$getShareLink$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DocOpManager.b(this.this$0, null, null, this);
    }
}
