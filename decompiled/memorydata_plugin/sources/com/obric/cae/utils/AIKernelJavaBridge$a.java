package com.obric.cae.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelJavaBridge$executeBackground$1$1", f = "AIKernelJavaBridge.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class AIKernelJavaBridge$a extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Unit>, Object> f7322b;

    public AIKernelJavaBridge$a(Function1<? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super AIKernelJavaBridge$a> r4) {
        Function1<Continuation<? super Unit>, Object> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.f7322b = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelJavaBridge$a(this.f7322b, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(al r3, Continuation<? super Unit> r4) {
        return ((AIKernelJavaBridge$a) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelJavaBridge$a.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7321a;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Function1<Continuation<? super Unit>, Object> r5 = this.f7322b;
        this.f7321a = 1;
        if (r5.invoke(this) != r0) goto L12;
        return r0;
    }
}
