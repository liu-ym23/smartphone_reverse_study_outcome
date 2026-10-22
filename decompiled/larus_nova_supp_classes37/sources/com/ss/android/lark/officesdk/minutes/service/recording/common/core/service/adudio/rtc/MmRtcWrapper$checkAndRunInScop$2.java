package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcWrapper$checkAndRunInScop$2", f = "MmRtcWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRtcWrapper$checkAndRunInScop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<nub.b, Unit> $onComplete;
    final /* synthetic */ Function1<Throwable, Unit> $onFailure;
    final /* synthetic */ nub.b $rtcService;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRtcWrapper$checkAndRunInScop$2(Function1<? super nub.b, Unit> r1, nub.b r2, Function1<? super Throwable, Unit> r3, Continuation<? super MmRtcWrapper$checkAndRunInScop$2> r4) {
        this.$onComplete = r1;
        this.$rtcService = r2;
        this.$onFailure = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRtcWrapper$checkAndRunInScop$2(this.$onComplete, this.$rtcService, this.$onFailure, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        Function1<nub.b, Unit> r5 = this.$onComplete;
        nub.b r0 = this.$rtcService;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        r5.invoke(r0);     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Function1<Throwable, Unit> r2 = this.$onFailure;
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L15;
        lvb.a.b("MmRtcWrapper", "runTask error: " + r7);
        if ((r7 instanceof CancellationException) == true) goto L15;
        r2.invoke(r7);
    L15:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
