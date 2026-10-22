package com.larus.doc.impl.operation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager", f = "DocOpManager.kt", i = {}, l = {1026}, m = "getDocContent", n = {}, s = {})
public final class DocOpManager$getDocContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocOpManager this$0;

    public DocOpManager$getDocContent$1(DocOpManager r1, Continuation<? super DocOpManager$getDocContent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, 0, this);
    }
}
