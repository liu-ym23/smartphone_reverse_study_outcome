package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $meetingStartTime;
    final /* synthetic */ String $recordingId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1(String r1, String r2, MmStandaloneAIInterpretationStateHandler r3, long r4, Continuation<? super MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1> r6) {
        this.$meetingId = r1;
        this.$recordingId = r2;
        this.this$0 = r3;
        this.$meetingStartTime = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1 r7 = new MmStandaloneAIInterpretationStateHandler$createMinutesRecordingAndInitAudioService$1$1$1(this.$meetingId, this.$recordingId, this.this$0, this.$meetingStartTime, r10);
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
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r20);
        ovb.b r2 = (ovb.b) this.L$0;
        String r3 = this.$meetingId;
        Intrinsics.checkNotNull(r3);
        String r6 = this.$recordingId;
        Intrinsics.checkNotNull(r6);
        String r9 = this.$recordingId;
        Intrinsics.checkNotNull(r9);
        k r4 = this.this$0.a.f;
        MmRecordingSource r5 = null;
        if (r4 == null) goto L9;
        MmRecordingSource r7 = r4.a;
        if (r7 == null) goto L9;
        String r8 = r7.name();
    L10:
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        String r11 = r8;
        String r12 = this.$meetingId;
        Intrinsics.checkNotNull(r12);
        String r13 = this.this$0.c.getCurrentUserId();
        MmStandaloneAIInterpretationStateHandler r10 = this.this$0;
        MmRecordingSession r14 = r10.a;
        String r15 = r14.c;
        k r16 = r14.f;
        if (r16 == null) goto L15;
        r5 = r16.a;
    L15:
        String r17 = r10.c.getTenantId();
        String r18 = this.$recordingId;
        Intrinsics.checkNotNull(r18);
        return ovb.b.a(r2, r3, this.$meetingStartTime, r6, null, new MmRecordingCommonParam("", r9, false, r11, r12, r13, r15, r5, r17, r18, this.this$0.a.a.name()), null, false, 216);
    L9:
        r8 = null;
        goto L10
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
