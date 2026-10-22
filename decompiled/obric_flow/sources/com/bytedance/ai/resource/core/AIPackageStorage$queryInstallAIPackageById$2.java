package com.bytedance.ai.resource.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {}, l = {148}, m = "queryInstallAIPackageById", n = {}, s = {})
final class AIPackageStorage$queryInstallAIPackageById$2 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIPackageStorage f2647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2648c;

    public AIPackageStorage$queryInstallAIPackageById$2(AIPackageStorage r5, ContinuationImpl r10) {
        this.f2647b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.f2646a = r10;
        this.f2648c |= Integer.MIN_VALUE;
        return this.f2647b.a(null, null, false, 0, this);
    }
}
