package com.bytedance.ai.resource.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {}, l = {161}, m = "queryInactiveAIPackageById", n = {}, s = {})
final class AIPackageStorage$queryInactiveAIPackageById$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIPackageStorage f2641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2642c;

    public AIPackageStorage$queryInactiveAIPackageById$1(AIPackageStorage r5, ContinuationImpl r10) {
        this.f2641b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.f2640a = r10;
        this.f2642c |= Integer.MIN_VALUE;
        return this.f2641b.a(null, null, 0, this);
    }
}
