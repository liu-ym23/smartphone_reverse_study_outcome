package com.larus.doc.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragmentV2", f = "DocFragmentV2.kt", i = {}, l = {158, 156}, m = "createOfficeFragment", n = {}, s = {})
public final class DocFragmentV2$createOfficeFragment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocFragmentV2 this$0;

    public DocFragmentV2$createOfficeFragment$1(DocFragmentV2 r1, Continuation<? super DocFragmentV2$createOfficeFragment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.V3(null, this);
    }
}
