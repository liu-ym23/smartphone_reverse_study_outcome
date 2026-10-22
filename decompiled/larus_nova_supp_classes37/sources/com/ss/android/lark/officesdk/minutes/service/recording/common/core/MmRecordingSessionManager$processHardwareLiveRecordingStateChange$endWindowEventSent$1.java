package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1", f = "MmRecordingSessionManager.kt", i = {}, l = {2040}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    int label;

    public MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1(MmRecordingSession r1, Continuation<? super MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1> r2) {
        this.$session = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingSessionManager$processHardwareLiveRecordingStateChange$endWindowEventSent$1(this.$session, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L17:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MmRecordingRepo r5 = this.$session.f();
        if (r5 == null) goto L17;
        this.label = 1;
        Object r6 = r5.C.await(this);
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        r6 = Unit.INSTANCE;
    L14:
        if (r6 != r0) goto L17;
        return r0;
    }
}
