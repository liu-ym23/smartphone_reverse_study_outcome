package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {0, 0, 0}, l = {516}, m = "setManifestData", n = {"this", "deploymentInfo", "operation"}, s = {"L$0", "L$1", "L$2"})
final class AIPackageOperationGroup$setManifestData$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackageOperationGroup f2607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageDeployment.AIPackageDeploymentItem f2608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbsAIPackageOperation f2609c;
    public /* synthetic */ Object d;
    public final /* synthetic */ AIPackageOperationGroup e;
    public int f;

    public AIPackageOperationGroup$setManifestData$1(AIPackageOperationGroup r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        return AIPackageOperationGroup.b(this.e, null, null, this);
    }
}
