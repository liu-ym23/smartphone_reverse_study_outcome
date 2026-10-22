package com.obric.cae.utils;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelUtils$loadAndCacheModel$model$1", f = "AIKernelUtils.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class AIKernelUtils$b extends SuspendLambda implements Function2<al, Continuation<? super IBaseModel>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7344b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ RequestParams d;

    public AIKernelUtils$b(String r3, boolean r4, RequestParams r5, Continuation<? super AIKernelUtils$b> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.f7344b = r3;
        this.c = r4;
        this.d = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelUtils$b(this.f7344b, this.c, this.d, r5);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(al r3, Continuation<? super IBaseModel> r4) {
        return ((AIKernelUtils$b) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelUtils$b.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7343a;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        AIKernelManager r7 = AIKernelManager.INSTANCE;
        String r2 = this.f7344b;
        boolean r3 = this.c;
        RequestParams r4 = this.d;
        this.f7343a = 1;
        r6 = r7.loadPackage(r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
