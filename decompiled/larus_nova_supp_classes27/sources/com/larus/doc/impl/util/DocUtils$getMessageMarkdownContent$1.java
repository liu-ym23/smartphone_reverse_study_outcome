package com.larus.doc.impl.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.util.DocUtils", f = "DocUtils.kt", i = {0, 0, 0}, l = {186}, m = "getMessageMarkdownContent", n = {"messageId", "startTime", "findStart"}, s = {"L$0", "J$0", "J$1"})
public final class DocUtils$getMessageMarkdownContent$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocUtils this$0;

    public DocUtils$getMessageMarkdownContent$1(DocUtils r1, Continuation<? super DocUtils$getMessageMarkdownContent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
