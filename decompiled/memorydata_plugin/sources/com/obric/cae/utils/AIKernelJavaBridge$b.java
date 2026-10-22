package com.obric.cae.utils;

import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.obric.cae.utils.AIKernelJavaBridge$initAndLoadModel$1", f = "AIKernelJavaBridge.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class AIKernelJavaBridge$b extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7324b;
    public final /* synthetic */ Function2<PackageResource, Boolean, Object> c;
    public final /* synthetic */ int d;

    public AIKernelJavaBridge$b(String r3, Function2<? super PackageResource, ? super Boolean, ? extends Object> r4, int r5, Continuation<? super AIKernelJavaBridge$b> r6) {
        Function2<PackageResource, Boolean, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.f7324b = r3;
        this.c = r7;
        this.d = r5;
        super(1, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return new AIKernelJavaBridge$b(this.f7324b, this.c, this.d, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> r3) {
        return ((AIKernelJavaBridge$b) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin")), AIKernelJavaBridge$b.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r16) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.f7323a;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L36
        Object r2 = r16;
    L16:
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L36
        if (r3 != null) goto L20;
        com.obric.cae.log.a.i("AIKernelJavaBridge", "model load failed: " + this.f7324b);     // Catch: Exception -> L36
        Function2<PackageResource, Boolean, Object> r0 = this.c;     // Catch: Exception -> L36
        if (r0 == null) goto L41;
        r0.invoke(null, Boxing.boxBoolean(false));     // Catch: Exception -> L36
    L41:
        return Unit.INSTANCE;
    L20:
        if (((IBaseModel) ZeusTransformUtils.preCheckCast(r3.getSecond(), IBaseModel.class, "com.obric.memorydata.plugin")) == null) goto L27;
        com.obric.cae.log.a.c("AIKernelJavaBridge", "model load success: " + this.f7324b);     // Catch: Exception -> L36
        PackageResource r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r3.getFirst(), PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L36
        if (r4 == null) goto L41;
        Function2<PackageResource, Boolean, Object> r5 = this.c;     // Catch: Exception -> L36
        if (r5 == null) goto L41;
        Boolean r6 = Boxing.boxBoolean(true);     // Catch: Exception -> L36
    L26:
        r5.invoke(r4, r6);     // Catch: Exception -> L36
        goto L41
    L27:
        com.obric.cae.log.a.i("AIKernelJavaBridge", "model load failed: " + this.f7324b);     // Catch: Exception -> L36
        r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r3.getFirst(), PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L36
        if (r4 == null) goto L41;
        r5 = this.c;     // Catch: Exception -> L36
        if (r5 == null) goto L41;
        r6 = Boxing.boxBoolean(false);     // Catch: Exception -> L36
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r16);
        RequestParams r7 = new RequestParams(null, null, 3, null);     // Catch: Exception -> L36
        int r8 = this.d;     // Catch: Exception -> L36
        if (r8 <= 0) goto L13;
        ParamsKt.setPreloadSeconds(r7, r8);     // Catch: Exception -> L36
    L13:
        c r9 = c.f7367a;     // Catch: Exception -> L36
        String r11 = this.f7324b;     // Catch: Exception -> L36
        this.f7323a = 1;     // Catch: Exception -> L36
        r2 = c.a(r9, r11, false, r7, this, 2, null);     // Catch: Exception -> L36
        if (r2 != r10) goto L16;
        return r10;
    L36:
        e = move-exception;
        com.obric.cae.log.a.i("AIKernelJavaBridge", "model load exception: " + e.getMessage());
        Function2<PackageResource, Boolean, Object> r12 = this.c;
        if (r12 == null) goto L41;
        r12.invoke(null, Boxing.boxBoolean(false));
        goto L41
    }
}
