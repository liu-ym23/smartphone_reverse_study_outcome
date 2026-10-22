package com.bytedance.ai.resource.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {286, 291, 296, 299}, m = "queryInstalledAIPackagesByType", n = {"packageType", "aiPackages", "packageType", "aiPackages", "packageType", "aiPackages", "packageType", "aiPackages"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class AIPackageStorage$queryInstalledAIPackagesByType$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$queryInstalledAIPackagesByType$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$queryInstalledAIPackagesByType$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
