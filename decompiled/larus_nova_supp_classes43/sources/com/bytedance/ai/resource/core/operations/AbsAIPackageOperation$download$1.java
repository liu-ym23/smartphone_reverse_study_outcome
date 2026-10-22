package com.bytedance.ai.resource.core.operations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AbsAIPackageOperation", f = "AbsAIPackageOperation.kt", i = {0}, l = {142}, m = "download", n = {"path"}, s = {"L$0"})
public final class AbsAIPackageOperation$download$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsAIPackageOperation this$0;

    public AbsAIPackageOperation$download$1(AbsAIPackageOperation r1, Continuation<? super AbsAIPackageOperation$download$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
