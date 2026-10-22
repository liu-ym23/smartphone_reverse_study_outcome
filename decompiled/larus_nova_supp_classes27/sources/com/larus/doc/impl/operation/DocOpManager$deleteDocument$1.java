package com.larus.doc.impl.operation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager", f = "DocOpManager.kt", i = {0, 1, 1, 2}, l = {983, 1263, 999, 1006}, m = "deleteDocument", n = {"resourceId", "resourceId", "loadingDialog", "result"}, s = {"L$0", "L$0", "L$1", "I$0"})
final class DocOpManager$deleteDocument$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocOpManager this$0;

    public DocOpManager$deleteDocument$1(DocOpManager r1, Continuation<? super DocOpManager$deleteDocument$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DocOpManager.a(this.this$0, null, null, null, this);
    }
}
