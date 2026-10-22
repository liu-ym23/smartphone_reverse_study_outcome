package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.PushRecordingStartResult;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {774}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSubtitleRepo a;
        public final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 b;

        public AnonymousClass1(MmRecordingSubtitleRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object a(PushRecordingStartResult r12, Continuation<? super Unit> r13) {
            if ((r13 instanceof MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1) == false) goto L7;
            MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1 r0 = (MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1) r13;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r14 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(r0.label) {
                case 0: goto L18;
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            ResultKt.throwOnFailure(r14);
        L70:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r14);
        L66:
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r15 = this.b;
            r0.label = 6;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r15, true, r0) != r2) goto L70;
            return r2;
        L14:
            MmRecordingSource r16 = (MmRecordingSource) r0.L$1;
            PushRecordingStartResult r3 = (PushRecordingStartResult) r0.L$0;
            ResultKt.throwOnFailure(r14);
        L59:
            lvb.a.e(this.a.m, "[subtitleOpenPush] degraded, status=" + r3.mstatus + ", source=" + r16);
        L73:
            return Unit.INSTANCE;
        L15:
            MmRecordingSource r17 = (MmRecordingSource) r0.L$1;
            PushRecordingStartResult r4 = (PushRecordingStartResult) r0.L$0;
            ResultKt.throwOnFailure(r14);
            MmRecordingSource r5 = r17;
            r12 = r4;
        L55:
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r18 = this.b;
            r0.L$0 = r12;
            r0.L$1 = r5;
            r0.label = 4;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r18, false, r0) != r2) goto L58;
            return r2;
        L58:
            r3 = r12;
            r16 = r5;
            goto L59
        L16:
            ResultKt.throwOnFailure(r14);
        L47:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r14);
        L43:
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r19 = this.b;
            r0.label = 2;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r19, false, r0) != r2) goto L47;
            return r2;
        L18:
            ResultKt.throwOnFailure(r14);
            MmRecordingSubtitleRepo r110 = this.a;
            iub.k r6 = r110.j.f;
            SubtitleOpenResult r7 = null;
            if (r6 == null) goto L21;
            r5 = r6.a;
        L22:
            lvb.a.e(r110.m, "[subtitleOpenPush] status=" + r12.mstatus + ", error=" + r12.merror + ", pushMeetingId=" + r12.mmeeting_id + ", expectedMeetingId=" + this.b.a + ", source=" + r5);
            if (Intrinsics.areEqual(r12.mmeeting_id, this.b.a) == false) goto L71;
            int r111 = r12.mstatus.intValue();
            if (r111 != UpdateLiveRecordingSettingResponse.Status.SUCCESS.getValue()) goto L28;
            r7 = SubtitleOpenResult.SUCCESS;
        L35:
            if (r7 != null) goto L39;
            lvb.a.b(this.a.m, "[subtitleOpenPush] ignored unknown status=" + r12.mstatus + ", source=" + r5);
            return Unit.INSTANCE;
        L39:
            if (r7 != SubtitleOpenResult.SUCCESS) goto L49;
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r112 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.d();
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r113 = this.b;
            r0.label = 1;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r113, true, r7, r0) != r2) goto L43;
            return r2;
        L49:
            if (r7 == SubtitleOpenResult.DEGRADED) goto L51;
        L60:
            qvb.a r114 = qvb.a.a;
            StringBuilder r8 = new StringBuilder("status=");
            r8.append(r12.mstatus);
            r8.append(", error=");
            String r115 = r12.merror;
            if (r115 != null) goto L63;
            r115 = "";
        L63:
            r8.append(r115);
            r114.h(r8.toString());
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r116 = this.b;
            r0.label = 5;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r116, true, r7, r0) != r2) goto L66;
            return r2;
        L51:
            if (g.b(r5) == false) goto L60;
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r117 = this.b;
            r0.L$0 = r12;
            r0.L$1 = r5;
            r0.label = 3;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r117, true, r7, r0) != r2) goto L55;
            return r2;
        L28:
            if (r111 != UpdateLiveRecordingSettingResponse.Status.FAIL.getValue()) goto L31;
            r7 = SubtitleOpenResult.FAILURE;
            goto L35
        L31:
            if (r111 != UpdateLiveRecordingSettingResponse.Status.LIMIT_REACHED.getValue()) goto L33;
        L34:
            r7 = SubtitleOpenResult.DEGRADED;
            goto L35
        L33:
            if (r111 != UpdateLiveRecordingSettingResponse.Status.RECORDING_DEGRADED.getValue()) goto L35;
        L71:
            lvb.a.e(this.a.m, "[subtitleOpenPush] ignored because meetingId does not match");
            goto L73
        L21:
            r5 = null;
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L7:
            r0 = new MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1(this, r13);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((PushRecordingStartResult) r1, r2);
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1(MmRecordingSubtitleRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1(this.this$0, this.this$1, r4);
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
        d1 r7 = this.this$0.l.Q().a(Command.PUSH_RECORDING_START_RESULT, PushRecordingStartResult.class);
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.this$1);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
