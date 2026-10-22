package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $meetingStartTime;
    final /* synthetic */ String $recordingId;
    /* synthetic */ Object L$0;
    int label;

    public MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1(String r1, String r2, long r3, Continuation<? super MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1> r5) {
        this.$meetingId = r1;
        this.$recordingId = r2;
        this.$meetingStartTime = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1 r6 = new MmPreMeetingNativeRecordingStateHandler$createMeetingAsync$1$1$1(this.$meetingId, this.$recordingId, this.$meetingStartTime, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ovb.b) r1, (Continuation) r2);
    }

    public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r19);
        ovb.b r2 = (ovb.b) this.L$0;
        String r3 = this.$meetingId;
        Intrinsics.checkNotNull(r3);
        MmRecordingCommonParam r4 = r2.f;
        String r9 = this.$meetingId;
        Intrinsics.checkNotNull(r9);
        String r1 = this.$recordingId;
        if (r1.length() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        r1 = r2.g;
    L10:
        MmRecordingCommonParam r8 = MmRecordingCommonParam.copy$default(r4, null, r1, false, null, r9, null, null, null, null, null, null, 2029, null);
        return ovb.b.a(r2, r3, this.$meetingStartTime, this.$recordingId, null, r8, null, true, 88);
    L7:
        r5 = false;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
