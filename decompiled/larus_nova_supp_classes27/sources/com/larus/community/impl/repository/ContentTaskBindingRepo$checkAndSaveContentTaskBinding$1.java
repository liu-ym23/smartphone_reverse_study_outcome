package com.larus.community.impl.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.repository.ContentTaskBindingRepo", f = "ContentTaskBindingRepo.kt", i = {}, l = {19}, m = "checkAndSaveContentTaskBinding", n = {}, s = {})
public final class ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContentTaskBindingRepo this$0;

    public ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1(ContentTaskBindingRepo r1, Continuation<? super ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
