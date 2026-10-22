package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession$safeUpdateRecordingData$2", f = "MmRecordingSession.kt", i = {}, l = {426}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSession$safeUpdateRecordingData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ovb.b, Continuation<? super ovb.b>, Object> $updateData;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingSession this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingSession$safeUpdateRecordingData$2(MmRecordingSession r1, Function2<? super ovb.b, ? super Continuation<? super ovb.b>, ? extends Object> r2, Continuation<? super MmRecordingSession$safeUpdateRecordingData$2> r3) {
        this.this$0 = r1;
        this.$updateData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSession$safeUpdateRecordingData$2(this.this$0, this.$updateData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MmRecordingSession r2 = (MmRecordingSession) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        r2.w = (ovb.b) r5;
        MmRecordingSession r6 = this.this$0;
        r6.p(r6.w.f);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmRecordingSession r7 = this.this$0;
        Function2<ovb.b, Continuation<? super ovb.b>, Object> r3 = this.$updateData;
        ovb.b r4 = r7.w;
        this.L$0 = r7;
        this.label = 1;
        Object r8 = r3.invoke(r4, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r5 = r8;
        goto L12
    }
}
