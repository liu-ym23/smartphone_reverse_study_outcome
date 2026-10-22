package com.bytedance.ai.process;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.AISDKRemoteServiceProxy", f = "AISDKRemoteServiceProxy.kt", i = {}, l = {174}, m = "getRemoteService", n = {}, s = {})
final class AISDKRemoteServiceProxy$getRemoteService$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2412c;

    public AISDKRemoteServiceProxy$getRemoteService$1(d r5, ContinuationImpl r10) {
        this.f2411b = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2410a = r5;
        this.f2412c |= Integer.MIN_VALUE;
        return this.f2411b.e(this);
    }
}
