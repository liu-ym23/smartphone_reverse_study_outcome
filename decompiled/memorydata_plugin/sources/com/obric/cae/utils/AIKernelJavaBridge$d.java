package com.obric.cae.utils;

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
@DebugMetadata(c = "com.obric.cae.utils.AIKernelJavaBridge$runModelInferenceSync$1", f = "AIKernelJavaBridge.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class AIKernelJavaBridge$d extends SuspendLambda implements Function2<al, Continuation<? super Float>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7328b;
    public final /* synthetic */ String c;
    public final /* synthetic */ float[] d;

    public AIKernelJavaBridge$d(String r3, String r4, float[] r5, Continuation<? super AIKernelJavaBridge$d> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.f7328b = r3;
        this.c = r4;
        this.d = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelJavaBridge$d(this.f7328b, this.c, this.d, r5);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(al r3, Continuation<? super Float> r4) {
        return ((AIKernelJavaBridge$d) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), AIKernelJavaBridge$d.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7327a;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        c r2 = c.f7367a;
        String r9 = this.f7328b;
        String r3 = this.c;
        float[] r4 = this.d;
        this.f7327a = 1;
        r8 = r2.a(r9, r3, r4, true, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
