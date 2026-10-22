package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $meetingStartTime;
    final /* synthetic */ String $recordingId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1(String r1, String r2, MmSoftwareCurrentRecordingStateHandler r3, long r4, Continuation<? super MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1> r6) {
        this.$meetingId = r1;
        this.$recordingId = r2;
        this.this$0 = r3;
        this.$meetingStartTime = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1 r7 = new MmSoftwareCurrentRecordingStateHandler$createMinutesRecordingAndInitAudioService$1$2$1(this.$meetingId, this.$recordingId, this.this$0, this.$meetingStartTime, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ovb.b) r1, (Continuation) r2);
    }

    public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r19);
        ovb.b r2 = (ovb.b) this.L$0;
        String r3 = this.$meetingId;
        Intrinsics.checkNotNull(r3);
        String r1 = this.$recordingId;
        String r4 = this.$meetingId;
        if (r1.length() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        String r7 = r4;
    L11:
        boolean r8 = this.this$0.a.a.isHardwareRecording();
        k r5 = this.this$0.a.f;
        if (r5 == null) goto L19;
        MmRecordingSource r9 = r5.a;
        if (r9 == null) goto L19;
        String r10 = r9.name();
        if (r10 == null) goto L19;
        String r11 = r10;
    L20:
        String r12 = this.$meetingId;
        Intrinsics.checkNotNull(r12);
        String r13 = this.this$0.c.getCurrentUserId();
        MmSoftwareCurrentRecordingStateHandler r14 = this.this$0;
        MmRecordingSession r15 = r14.a;
        String r16 = r15.c;
        k r17 = r15.f;
        String r18 = null;
        if (r17 == null) goto L23;
        MmRecordingSource r110 = r17.a;
    L24:
        String r20 = r14.c.getTenantId();
        if (this.this$0.a.a.isHardwareRecording() == true) goto L31;
        DoubaoBizInfo r111 = this.this$0.l;
        if (r111 == null) goto L30;
        r18 = r111.getRecordingId();
    L30:
        if (r18 == null) goto L31;
        String r112 = r18;
    L34:
        return ovb.b.a(r2, r3, this.$meetingStartTime, this.$recordingId, null, new MmRecordingCommonParam("", r7, r8, r11, r12, r13, r16, r110, r20, r112, this.this$0.a.a.name()), null, false, 216);
    L31:
        r112 = "";
        goto L34
    L23:
        r110 = null;
    L19:
        r11 = "";
        goto L20
    L10:
        r7 = r1;
        goto L11
    L7:
        r6 = false;
        goto L8
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
