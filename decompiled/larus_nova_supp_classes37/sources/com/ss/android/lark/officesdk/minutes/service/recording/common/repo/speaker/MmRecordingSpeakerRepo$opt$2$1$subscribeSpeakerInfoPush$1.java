package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.NotifySpeakerInfoChange;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo$opt$2$1$subscribeSpeakerInfoPush$1", f = "MmRecordingSpeakerRepo.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSpeakerRepo$opt$2$1$subscribeSpeakerInfoPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSpeakerRepo this$0;
    final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 this$1;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 a;
        public final /* synthetic */ MmRecordingSpeakerRepo b;

        public a(MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r1, MmRecordingSpeakerRepo r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            NotifySpeakerInfoChange r5 = (NotifySpeakerInfoChange) r3;
            if (Intrinsics.areEqual(r5.mmeeting_id, this.a.a) == true) goto L6;
            lvb.a.e(this.b.l, "[speakerPush] skip, meetingId mismatch: push=" + r5.mmeeting_id + ", current=" + this.a.a);
            return Unit.INSTANCE;
        L6:
            if (r5.mspeaker_info_change.booleanValue() == true) goto L8;
            lvb.a.e(this.b.l, "[speakerPush] skip, mspeaker_info_change=false");
            return Unit.INSTANCE;
        L8:
            lvb.a.e(this.b.l, "[speakerPush] sync speaker mappings");
            Object r6 = MmRecordingSpeakerRepo$opt$2.AnonymousClass1.T0(this.a, MmSpeakerMappingSyncSource.SPEAKER_INFO_CHANGE_PUSH, r4);
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            return r6;
        L12:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSpeakerRepo$opt$2$1$subscribeSpeakerInfoPush$1(MmRecordingSpeakerRepo r1, MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSpeakerRepo$opt$2$1$subscribeSpeakerInfoPush$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSpeakerRepo$opt$2$1$subscribeSpeakerInfoPush$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        lvb.a.e(this.this$0.l, "[subscribeSpeakerInfoPush] start register");
        d1 r7 = this.this$0.j.Q().a(Command.NOTIFY_SPEAKER_INFO_CHANGE, NotifySpeakerInfoChange.class);
        a r2 = new a(this.this$1, this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
