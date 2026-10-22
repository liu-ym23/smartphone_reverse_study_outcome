package com.bytedance.ai.process.resource;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$markInUseFromClient$1", f = "AIManagerRemoteProxy.kt", i = {0, 0}, l = {129}, m = "invokeSuspend$tryCallRemote", n = {"$packageName", "$appId"}, s = {"L$0", "L$1"})
final class AIManagerRemoteProxy$markInUseFromClient$1$tryCallRemote$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2445c;
    public int d;

    public AIManagerRemoteProxy$markInUseFromClient$1$tryCallRemote$1(ContinuationImpl r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2445c = r5;
        this.d |= Integer.MIN_VALUE;
        return AIManagerRemoteProxy$markInUseFromClient$1.a(null, null, this);
    }
}
