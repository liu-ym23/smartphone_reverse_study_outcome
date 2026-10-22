package com.bytedance.ai.resource.core.operations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AIPackageInstallOperation", f = "AIPackageInstallOperation.kt", i = {0, 1}, l = {51, 63}, m = "installAIPackage", n = {"aiPackage", "aiPackage"}, s = {"L$0", "L$0"})
public final class AIPackageInstallOperation$installAIPackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageInstallOperation this$0;

    public AIPackageInstallOperation$installAIPackage$1(AIPackageInstallOperation r1, Continuation<? super AIPackageInstallOperation$installAIPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, this);
    }
}
