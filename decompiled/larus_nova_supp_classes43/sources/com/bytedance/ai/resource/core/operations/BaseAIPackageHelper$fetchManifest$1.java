package com.bytedance.ai.resource.core.operations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.BaseAIPackageHelper", f = "BaseAIPackageHelper.kt", i = {}, l = {37, 42}, m = "fetchManifest", n = {}, s = {})
public final class BaseAIPackageHelper$fetchManifest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseAIPackageHelper this$0;

    public BaseAIPackageHelper$fetchManifest$1(BaseAIPackageHelper r1, Continuation<? super BaseAIPackageHelper$fetchManifest$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
