package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmCreateAudioRequest;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$createRecordingObject$1", f = "MmRecordingStatesSyncService.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$createRecordingObject$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<MmCreateAudioRequest.CreateMinutesStatus> $audioStatus;
    final /* synthetic */ DoubaoBizInfo $doubaoBizInfo;
    final /* synthetic */ int $maxRetryTimes;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingStatesSyncService$createRecordingObject$1(MmRecordingStatesSyncService r1, String r2, int r3, Function0<? extends MmCreateAudioRequest.CreateMinutesStatus> r4, DoubaoBizInfo r5, String r6, Continuation<? super MmRecordingStatesSyncService$createRecordingObject$1> r7) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$maxRetryTimes = r3;
        this.$audioStatus = r4;
        this.$doubaoBizInfo = r5;
        this.$recordingId = r6;
        super(1, r7);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new MmRecordingStatesSyncService$createRecordingObject$1(this.this$0, this.$meetingId, this.$maxRetryTimes, this.$audioStatus, this.$doubaoBizInfo, this.$recordingId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        MmRecordingStatesSyncService r2 = this.this$0;
        String r10 = this.$meetingId;
        int r3 = this.$maxRetryTimes;
        Function0<MmCreateAudioRequest.CreateMinutesStatus> r4 = this.$audioStatus;
        DoubaoBizInfo r5 = this.$doubaoBizInfo;
        String r6 = this.$recordingId;
        this.label = 1;
        MmRecordingStatesSyncService.Companion r7 = MmRecordingStatesSyncService.q;
        if (r2.k(r10, r3, r4, r5, r6, this) != r0) goto L12;
        return r0;
    }
}
