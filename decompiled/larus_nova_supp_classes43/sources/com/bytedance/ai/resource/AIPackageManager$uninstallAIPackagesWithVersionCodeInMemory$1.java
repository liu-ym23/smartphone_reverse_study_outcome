package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {1}, l = {241, 810}, m = "uninstallAIPackagesWithVersionCodeInMemory", n = {"fileListToDelete"}, s = {"L$0"})
public final class AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageManager this$0;

    public AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1(AIPackageManager r1, Continuation<? super AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, this);
    }
}
