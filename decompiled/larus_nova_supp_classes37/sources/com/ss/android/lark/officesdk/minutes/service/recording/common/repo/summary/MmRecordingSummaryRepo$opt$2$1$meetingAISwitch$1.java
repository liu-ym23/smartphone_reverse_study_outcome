package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.pb.videochat.MeetingAICapabilityControlResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingSummaryRepo this$0;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1(MmRecordingSummaryRepo r1, String r2, MmRecordingSummaryRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1(this.this$0, this.$meetingId, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L11:
        MmRecordingSummaryRepo$opt$2.AnonymousClass1 r2 = this.this$1;
        String r3 = this.$meetingId;
        MmRecordingSummaryRepo r4 = this.this$0;
        if (Result.isSuccess-impl(r10) == false) goto L17;
        MeetingAICapabilityControlResponse r5 = (MeetingAICapabilityControlResponse) r10;
        r2.b = false;
        if (Intrinsics.areEqual(r2.a, r3) == false) goto L16;
        r2.c = r3;
    L16:
        lvb.a.e(r4.l, "[meetingAISwitch] success, meetingId=" + r3);
        r2.e.a();
        r4.j(new MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1$1$1(r2, r4, null));
        r2.x("meetingAISwitch_success");
    L17:
        MmRecordingSummaryRepo$opt$2.AnonymousClass1 r6 = this.this$1;
        MmRecordingSummaryRepo r7 = this.this$0;
        String r8 = this.$meetingId;
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L21;
        r6.b = false;
        lvb.a.b(r7.l, "[meetingAISwitch] fail, meetingId=" + r8 + ", " + r11);
        r7.j(new MmRecordingSummaryRepo$opt$2$1$meetingAISwitch$1$2$1(r6, r7, null));
        r6.e.b();
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        MmRecordingNetHelper r12 = this.this$0.k.G();
        String r13 = this.$meetingId;
        this.label = 1;
        r10 = r12.s(r13, true, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
