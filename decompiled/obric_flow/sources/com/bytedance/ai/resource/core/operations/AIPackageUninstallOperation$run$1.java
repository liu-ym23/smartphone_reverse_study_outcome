package com.bytedance.ai.resource.core.operations;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AIPackageUninstallOperation", f = "AIPackageUnInstallOperation.kt", i = {0}, l = {31}, m = "run", n = {"this"}, s = {"L$0"})
final class AIPackageUninstallOperation$run$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackageUninstallOperation f2681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageUninstallOperation f2683c;
    public int d;

    public AIPackageUninstallOperation$run$1(AIPackageUninstallOperation r5, ContinuationImpl r10) {
        this.f2683c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2682b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f2683c.a(this);
    }
}
