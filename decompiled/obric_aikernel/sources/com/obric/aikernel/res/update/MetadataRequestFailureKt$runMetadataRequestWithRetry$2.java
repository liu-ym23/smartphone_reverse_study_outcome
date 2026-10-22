package com.obric.aikernel.res.update;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequestFailureKt$runMetadataRequestWithRetry$2", f = "MetadataRequestFailure.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
final class MetadataRequestFailureKt$runMetadataRequestWithRetry$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;

    MetadataRequestFailureKt$runMetadataRequestWithRetry$2(Continuation<? super MetadataRequestFailureKt$runMetadataRequestWithRetry$2> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        MetadataRequestFailureKt$runMetadataRequestWithRetry$2 r12 = new MetadataRequestFailureKt$runMetadataRequestWithRetry$2(r11);
        r12.J$0 = ((Number) r10).longValue();
        return r12;
    }

    public final Object invoke(long r10, Continuation<? super Unit> r11) {
        return ((MetadataRequestFailureKt$runMetadataRequestWithRetry$2) create(Long.valueOf(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long r10, Continuation<? super Unit> r11) {
        return invoke(r10.longValue(), r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r13 = this.J$0;
        this.label = 1;
        if (DelayKt.b(r13, this) != r11) goto L12;
        return r11;
    }
}
