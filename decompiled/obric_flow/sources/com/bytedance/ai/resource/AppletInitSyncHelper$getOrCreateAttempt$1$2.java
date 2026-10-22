package com.bytedance.ai.resource;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletInitSyncHelper$getOrCreateAttempt$1$2", f = "AppletInitSyncHelper.kt", i = {}, l = {94, 96}, m = "invokeSuspend", n = {}, s = {})
final class AppletInitSyncHelper$getOrCreateAttempt$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2545a;

    public AppletInitSyncHelper$getOrCreateAttempt$1$2(Continuation r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletInitSyncHelper$getOrCreateAttempt$1$2(r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return new AppletInitSyncHelper$getOrCreateAttempt$1$2(r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2545a;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L7;
        ResultKt.throwOnFailure(r5);
    L25:
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L14:
        if (j.g.isCompleted() == true) goto L16;
    L21:
        this.f2545a = 2;
        if (DelayKt.awaitCancellation(this) != r10) goto L25;
    L23:
        return r10;
    L16:
        if (j.f.isCompleted() == false) goto L21;
        if (j.f2737h.isCompleted() == false) goto L21;
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        j r12 = j.f2734a;
        this.f2545a = 1;
        if (r12.h(this) != r10) goto L14;
        goto L23
    }
}
