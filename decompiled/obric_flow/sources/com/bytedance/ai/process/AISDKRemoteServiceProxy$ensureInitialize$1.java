package com.bytedance.ai.process;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.AISDKRemoteServiceProxy", f = "AISDKRemoteServiceProxy.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3}, l = {209, 255, 260, 278}, m = "ensureInitialize", n = {"this", "config", "this", "context", "attempt", "this", "context", "attempt", "startMs", "this", "context", "attempt"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "J$0", "L$0", "L$1", "I$0"})
final class AISDKRemoteServiceProxy$ensureInitialize$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f2407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2409c;
    public long d;
    public /* synthetic */ Object e;
    public final /* synthetic */ d f;
    public int g;

    public AISDKRemoteServiceProxy$ensureInitialize$1(d r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        d r10 = this.f;
        d r11 = d.f2415a;
        return r10.a(this);
    }
}
