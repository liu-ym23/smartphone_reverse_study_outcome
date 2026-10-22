package com.bytedance.ai.core.manager;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0}, l = {69}, m = "safeRun", n = {"$this$safeRun"}, s = {"L$0"})
final class WorkerRuntimeManager$safeRun$1<T> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f2135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f2137c;
    public int d;

    public WorkerRuntimeManager$safeRun$1(b r5, ContinuationImpl r10) {
        this.f2137c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2136b = r5;
        this.d |= Integer.MIN_VALUE;
        return this.f2137c.c(null, null, this);
    }
}
