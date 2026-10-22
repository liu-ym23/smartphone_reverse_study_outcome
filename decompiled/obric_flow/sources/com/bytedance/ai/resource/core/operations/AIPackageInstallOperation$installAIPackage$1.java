package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AIPackageInstallOperation", f = "AIPackageInstallOperation.kt", i = {0, 0, 1, 1}, l = {57, 71}, m = "installAIPackage", n = {"this", "aiPackage", "this", "aiPackage"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class AIPackageInstallOperation$installAIPackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackageInstallOperation f2678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackage f2679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2680c;
    public final /* synthetic */ AIPackageInstallOperation d;
    public int e;

    public AIPackageInstallOperation$installAIPackage$1(AIPackageInstallOperation r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2680c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
