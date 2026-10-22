package com.obric.cae.utils;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelUtils$loadAndCacheModel$updateResult$1", f = "AIKernelUtils.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class AIKernelUtils$d extends SuspendLambda implements Function2<al, Continuation<? super Result<? extends PackageResource>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PackageResource f7348b;
    public final /* synthetic */ RequestParams c;

    public AIKernelUtils$d(PackageResource r3, RequestParams r4, Continuation<? super AIKernelUtils$d> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.f7348b = r3;
        this.c = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelUtils$d(this.f7348b, this.c, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(al r3, Continuation<? super Result<? extends PackageResource>> r4) {
        return ((AIKernelUtils$d) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelUtils$d.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7347a;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r4 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L12:
        return Result.m1420boximpl(r4);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AIKernelManager r6 = AIKernelManager.INSTANCE;
        PackageResource r2 = this.f7348b;
        RequestParams r3 = this.c;
        this.f7347a = 1;
        r4 = r6.mo189updatePackage0E7RQCE(r2, r3, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
