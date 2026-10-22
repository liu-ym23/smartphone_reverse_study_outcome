package com.obric.cae.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelJavaBridge$runModelInferenceAsync$1", f = "AIKernelJavaBridge.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class AIKernelJavaBridge$c extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7326b;
    public final /* synthetic */ String c;
    public final /* synthetic */ float[] d;
    public final /* synthetic */ Function1<Float, Unit> e;

    public AIKernelJavaBridge$c(String r3, String r4, float[] r5, Function1<? super Float, Unit> r6, Continuation<? super AIKernelJavaBridge$c> r7) {
        Function1<Float, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.f7326b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r8;
        super(1, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r7) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelJavaBridge$c(this.f7326b, this.c, this.d, this.e, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> r3) {
        return ((AIKernelJavaBridge$c) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin")), AIKernelJavaBridge$c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7325a;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L15
    L13:
        this.e.invoke((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        c r2 = c.f7367a;     // Catch: Exception -> L15
        String r9 = this.f7326b;     // Catch: Exception -> L15
        String r3 = this.c;     // Catch: Exception -> L15
        float[] r4 = this.d;     // Catch: Exception -> L15
        this.f7325a = 1;     // Catch: Exception -> L15
        r8 = r2.a(r9, r3, r4, false, this);     // Catch: Exception -> L15
        if (r8 != r0) goto L13;
        return r0;
    L15:
        e = move-exception;
        com.obric.cae.log.a.i("AIKernelJavaBridge", "model inference exception: " + e.getMessage());
        this.e.invoke(null);
        goto L18
    }
}
