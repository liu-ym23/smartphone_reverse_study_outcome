package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.MmSummaryWebHelper;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat_my_ai.PushMeetingAILayoutData;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$observeFishBonePush$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSummaryRepo$opt$2$1$observeFishBonePush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSummaryRepo this$0;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$1;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 a;

        public a(MmRecordingSummaryRepo$opt$2.AnonymousClass1 r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            PushMeetingAILayoutData r10 = (PushMeetingAILayoutData) r8;
            MmRecordingSummaryRepo$opt$2.AnonymousClass1 r11 = this.a;
            if (r11.U0() == false) goto L21;
            PushMeetingAILayoutData.Type r0 = r10.mtype;
            int r1 = e.a;
            Intrinsics.checkNotNullParameter(r10, "<this>");
            String r2 = r10.mmeeting_id;
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            Long r3 = r10.mtimestamp;
            if (r3 == null) goto L11;
            long r4 = r3.longValue();
        L12:
            MmAILayoutDataType.a r5 = MmAILayoutDataType.Companion;
            PushMeetingAILayoutData.Type r6 = r10.mtype;
            if (r6 == null) goto L15;
            int r7 = r6.getValue();
        L16:
            r5.getClass();
            MmAISummaryLayoutData r12 = new MmAISummaryLayoutData(r2, r4, MmAILayoutDataType.a.a(r7));
            lvb.a.e(r11.h.l, "[onPushAILayoutData] actionType=" + r0 + ", timestamp=" + r10.mtimestamp);
            MmSummaryWebHelper r13 = r11.f;
            if (r13 == null) goto L19;
            r13.f(r12);
        L19:
            MmRecordingSummaryRepo r14 = r11.h;
            r14.j(new MmRecordingSummaryRepo$opt$2$1$onPushAILayoutData$1(r11, r14, r12, null));
            goto L21
        L15:
            r7 = 0;
            goto L16
        L11:
            r4 = 0;
        L21:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSummaryRepo$opt$2$1$observeFishBonePush$1(MmRecordingSummaryRepo r1, MmRecordingSummaryRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSummaryRepo$opt$2$1$observeFishBonePush$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSummaryRepo$opt$2$1$observeFishBonePush$1(this.this$0, this.this$1, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1 r6 = this.this$0.k.Q().a(Command.PUSH_MEETING_AI_LAYOUT_DATA, PushMeetingAILayoutData.class);
        a r2 = new a(this.this$1);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
