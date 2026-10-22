package com.larus.doc.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl", f = "DocServiceImpl.kt", i = {}, l = {396}, m = "refreshFloatChatRemoteBinding", n = {}, s = {})
final class DocServiceImpl$refreshFloatChatRemoteBinding$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocServiceImpl this$0;

    public DocServiceImpl$refreshFloatChatRemoteBinding$1(DocServiceImpl r1, Continuation<? super DocServiceImpl$refreshFloatChatRemoteBinding$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R9(null, null, this);
    }
}
