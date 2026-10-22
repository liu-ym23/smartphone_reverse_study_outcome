package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1", f = "MmRecordingSpeakerRepo.kt", i = {}, l = {121, 132}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $operatorId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmRecordingSpeakerRepo this$0;
    final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1(MmRecordingSpeakerRepo r1, String r2, String r3, MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r4, Continuation<? super MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1> r5) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$operatorId = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1(this.this$0, this.$meetingId, this.$operatorId, this.this$1, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r2 = (MmRecordingSpeakerRepo$opt$2.AnonymousClass1) this.L$1;
        Object r3 = this.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        BuildersKt.launch$default(r2.c.f(), null, null, new MmRecordingSpeakerRepo$opt$2$1$subscribeSpeakerInfoPush$1(r2.c, r2, null), 3, null);
    L23:
        MmRecordingSpeakerRepo r12 = this.this$0;
        MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r4 = this.this$1;
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L27;
        lvb.a.b(r12.l, "[fetchSpeakerMarkingAvailability] error=" + r5);
        r12.j(new MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1$2$1(r12, r4, null));
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        Object r13 = ((Result) r11).unbox-impl();
    L13:
        r3 = r13;
        MmRecordingSpeakerRepo r14 = this.this$0;
        String r6 = this.$meetingId;
        MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r7 = this.this$1;
        if (Result.isSuccess-impl(r3) == false) goto L23;
        boolean r8 = Intrinsics.areEqual(((GetLiveRecordingSettingResponse) r3).mcan_recording_mark, Boxing.boxBoolean(true));
        lvb.a.e(r14.l, "[fetchSpeakerMarkingAvailability] success, enabled=" + r8 + ", meetingId=" + r6);
        r14.j(new MmRecordingSpeakerRepo$opt$2$1$fetchSpeakerMarkingAvailability$1$1$1(r14, r7, r8, null));
        if (r8 == false) goto L22;
        MmSpeakerMappingSyncSource r15 = MmSpeakerMappingSyncSource.MEETING_INFO_READY;
        this.L$0 = r3;
        this.L$1 = r7;
        this.label = 2;
        if (MmRecordingSpeakerRepo$opt$2.AnonymousClass1.T0(r7, r15, this) != r0) goto L20;
        return r0;
    L20:
        r2 = r7;
        goto L21
    L22:
        lvb.a.e(r14.l, "[fetchSpeakerMarkingAvailability] speaker marking disabled by server");
        goto L23
    L10:
        ResultKt.throwOnFailure(r11);
        lvb.a.e(this.this$0.l, "[fetchSpeakerMarkingAvailability] start, meetingId=" + this.$meetingId + ", operatorId=" + this.$operatorId);
        MmRecordingNetHelper r16 = this.this$0.j.G();
        String r9 = this.$meetingId;
        String r10 = this.$operatorId;
        this.label = 1;
        r13 = r16.o(r9, r10, this);
        if (r13 != r0) goto L13;
        return r0;
    }
}
