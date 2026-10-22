package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {}, l = {1135, 1135, 1135}, m = "ensureInitialize", n = {}, s = {})
final class AIManager$ensureInitialize$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f2460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2461c;

    public AIManager$ensureInitialize$1(j r5, ContinuationImpl r10) {
        this.f2460b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2459a = r5;
        this.f2461c |= Integer.MIN_VALUE;
        return this.f2460b.h(this);
    }
}
