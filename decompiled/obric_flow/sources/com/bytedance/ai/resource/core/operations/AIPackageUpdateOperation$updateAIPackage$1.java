package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AIPackageUpdateOperation", f = "AIPackageUpdateOperation.kt", i = {0, 0}, l = {58}, m = "updateAIPackage", n = {"this", "aiPackage"}, s = {"L$0", "L$1"})
final class AIPackageUpdateOperation$updateAIPackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackageUpdateOperation f2684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackage f2685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2686c;
    public final /* synthetic */ AIPackageUpdateOperation d;
    public int e;

    public AIPackageUpdateOperation$updateAIPackage$1(AIPackageUpdateOperation r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2686c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.b(this);
    }
}
