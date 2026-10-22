package com.bytedance.ai.process.resource;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$onMarkOutOfUseFromClient$1", f = "AIManagerRemoteProxy.kt", i = {0, 0}, l = {158}, m = "invokeSuspend$tryCallRemote", n = {"$packageName", "$appId"}, s = {"L$0", "L$1"})
final class AIManagerRemoteProxy$onMarkOutOfUseFromClient$1$tryCallRemote$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2451c;
    public int d;

    public AIManagerRemoteProxy$onMarkOutOfUseFromClient$1$tryCallRemote$1(ContinuationImpl r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2451c = r5;
        this.d |= Integer.MIN_VALUE;
        return AIManagerRemoteProxy$onMarkOutOfUseFromClient$1.a(null, null, this);
    }
}
