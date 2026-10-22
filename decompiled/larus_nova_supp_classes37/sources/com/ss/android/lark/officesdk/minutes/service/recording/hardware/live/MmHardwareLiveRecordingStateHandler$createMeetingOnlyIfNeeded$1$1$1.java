package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1", f = "MmHardwareLiveRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $meetingStartTime;
    final /* synthetic */ MmRecordingSource $source;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmHardwareLiveRecordingStateHandler this$0;

    public MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1(String r1, MmHardwareLiveRecordingStateHandler r2, MmRecordingSource r3, long r4, Continuation<? super MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1> r6) {
        this.$meetingId = r1;
        this.this$0 = r2;
        this.$source = r3;
        this.$meetingStartTime = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1 r7 = new MmHardwareLiveRecordingStateHandler$createMeetingOnlyIfNeeded$1$1$1(this.$meetingId, this.this$0, this.$source, this.$meetingStartTime, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ovb.b) r1, (Continuation) r2);
    }

    public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r20);
        ovb.b r2 = (ovb.b) this.L$0;
        String r3 = this.$meetingId;
        Intrinsics.checkNotNull(r3);
        String r6 = this.$meetingId;
        Intrinsics.checkNotNull(r6);
        String r9 = this.$meetingId;
        Intrinsics.checkNotNull(r9);
        boolean r10 = this.this$0.b.a.isHardwareRecording();
        MmRecordingSource r4 = this.$source;
        if (r4 == null) goto L7;
        String r5 = r4.name();
    L8:
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        String r11 = r5;
        String r12 = this.$meetingId;
        Intrinsics.checkNotNull(r12);
        String r13 = this.this$0.e.getCurrentUserId();
        MmHardwareLiveRecordingStateHandler r7 = this.this$0;
        MmRecordingCommonParam r1 = new MmRecordingCommonParam("", r9, r10, r11, r12, r13, r7.b.c, this.$source, r7.e.getTenantId(), "", this.this$0.b.a.name());
        return ovb.b.a(r2, r3, this.$meetingStartTime, r6, null, r1, null, true, 88);
    L7:
        r5 = null;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
