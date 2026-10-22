package com.obric.cae.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelUtils", f = "AIKernelUtils.kt", i = {0, 0, 0, 0}, l = {92, 100}, m = "runModelInference", n = {"this", "biz", "featureKey", "features"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class AIKernelUtils$e extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f7349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7350b;
    public String c;
    public float[] d;
    public /* synthetic */ Object e;
    public final /* synthetic */ c f;
    public int g;

    public AIKernelUtils$e(c r3, Continuation<? super AIKernelUtils$e> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.f = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.e = r7;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, null, null, false, this);
    }
}
