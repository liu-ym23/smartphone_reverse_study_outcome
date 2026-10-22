package com.bytedance.ai.resource.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {}, l = {161}, m = "queryInactiveAIPackageById", n = {}, s = {})
public final class AIPackageStorage$queryInactiveAIPackageById$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$queryInactiveAIPackageById$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$queryInactiveAIPackageById$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, 0, this);
    }
}
