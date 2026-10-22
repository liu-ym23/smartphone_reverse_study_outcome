package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {0, 0}, l = {303, 315}, m = "operationRun", n = {"operation", "deploymentInfo"}, s = {"L$0", "L$1"})
final class AIPackageOperationGroup$operationRun$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbsAIPackageOperation f2598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageDeployment.AIPackageDeploymentItem f2599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2600c;
    public final /* synthetic */ AIPackageOperationGroup d;
    public int e;

    public AIPackageOperationGroup$operationRun$1(AIPackageOperationGroup r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2600c = r5;
        this.e |= Integer.MIN_VALUE;
        return AIPackageOperationGroup.a(this.d, null, null, this);
    }
}
