package com.larus.community.impl.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.service.CreationServiceImpl", f = "CreationServiceImpl.kt", i = {}, l = {125}, m = "getUserAvatarUrl", n = {}, s = {})
public final class CreationServiceImpl$getUserAvatarUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationServiceImpl this$0;

    public CreationServiceImpl$getUserAvatarUrl$1(CreationServiceImpl r1, Continuation<? super CreationServiceImpl$getUserAvatarUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p1(null, this);
    }
}
