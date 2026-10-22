package com.obric.memorydata.memory;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.MemoryManagerWrapper$onShareIntent$3", f = "MemoryManagerWrapper.kt", i = {}, l = {471}, m = "invokeSuspend", n = {}, s = {})
final class MemoryManagerWrapper$onShareIntent$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ Uri $imageUri;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    int label;

    MemoryManagerWrapper$onShareIntent$3(com.obric.memorydata.middleware.api.logging.e r3, Activity r4, Bundle r5, Uri r6, Continuation<? super MemoryManagerWrapper$onShareIntent$3> r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$logContext = r3;
        this.$activity = ZeusTransformUtils.wrapperContext2Activity(r8, "com.obric.memorydata.plugin");
        this.$bundle = r5;
        this.$imageUri = r6;
        super(2, r9);
    }

    private static final Unit invokeSuspend$lambda$0(com.obric.memorydata.middleware.api.logging.g r2) {
        r2.a("from", 5);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$FSM3rieszZcmGKWXFjINIQDsIvQ(com.obric.memorydata.middleware.api.logging.g r0) {
        return invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$onShareIntent$3(this.$logContext, this.$activity, this.$bundle, this.$imageUri, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryManagerWrapper$onShareIntent$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryManagerWrapper$onShareIntent$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r3 = r19;
    L11:
        Bitmap r9 = (Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L16;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆图片解码失败", "input_prepare_failed", "share_image_decode_failed", null, com.obric.memorydata.middleware.api.logging.e.a(this.$logContext, null, null, "route", 3, null), null, 40, null);
        v.a(v.f11572a, this.$activity);
        return Unit.INSTANCE;
    L16:
        if (v.a(v.f11572a, (Context) ZeusTransformUtils.preCheckCast(this.$activity, Context.class, "com.obric.memorydata.plugin"), 5, this.$bundle) == false) goto L21;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆等待用户确认", "confirmation_required", com.obric.memorydata.middleware.api.logging.e.a(this.$logContext, null, null, "trigger", 3, null), $$Lambda$MemoryManagerWrapper$onShareIntent$3$FSM3rieszZcmGKWXFjINIQDsIvQ.INSTANCE, null, 16, null);
        if (v.a(v.f11572a, (Context) ZeusTransformUtils.preCheckCast(this.$activity, Context.class, "com.obric.memorydata.plugin"), this.$bundle, 5, r9, this.$logContext) == false) goto L20;
        this.$activity.finish();
    L23:
        return Unit.INSTANCE;
    L20:
        v.a(v.f11572a, this.$activity);
        goto L23
    L21:
        this.$activity.finish();
        v.a(v.f11572a, new v.a(5, this.$bundle, r9, this.$logContext), "systemShareMemory");
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$onShareIntent$3$bitmap$1(this.$imageUri, this.$activity, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r3 = kotlinx.coroutines.i.a(r4, r5, r6);
        if (r3 != r1) goto L11;
        return r1;
    }
}
