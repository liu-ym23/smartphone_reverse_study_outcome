package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.pb.videochat_my_ai.GetMeetingAISummaryResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$fetchSummary$1$1$1", f = "MmRecordingSummaryRepo.kt", i = {0, 1}, l = {310, 321}, m = "invokeSuspend", n = {"currentEntity", "currentTab"}, s = {"L$0", "L$0"})
public final class MmRecordingSummaryRepo$opt$2$1$fetchSummary$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ GetMeetingAISummaryResponse $response;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSummaryRepo this$1;

    public MmRecordingSummaryRepo$opt$2$1$fetchSummary$1$1$1(MmRecordingSummaryRepo$opt$2.AnonymousClass1 r1, GetMeetingAISummaryResponse r2, MmRecordingSummaryRepo r3, Continuation<? super MmRecordingSummaryRepo$opt$2$1$fetchSummary$1$1$1> r4) {
        this.this$0 = r1;
        this.$response = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingSummaryRepo$opt$2$1$fetchSummary$1$1$1(this.this$0, this.$response, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        MmRecordingUITab r3 = (MmRecordingUITab) this.L$0;
        ResultKt.throwOnFailure(r19);
    L34:
        lvb.a.e(this.this$1.l, "[onNewSummaryReceived] mark hasUnviewedSummary=true, currentTab=" + r3);
    L36:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        c r4 = (c) this.L$0;
        ResultKt.throwOnFailure(r19);
    L17:
        MmRecordingUITab r5 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b) this.this$1.j.w().l().b().getValue()).e;
        if (r4.a == true) goto L20;
    L24:
        boolean r6 = false;
    L25:
        if (r6 == false) goto L36;
        if (r5.isInSummary() == true) goto L36;
        if (r4.m != null) goto L36;
        MmRecordingSummaryRepo r7 = this.this$1;
        c r8 = c.a((c) this.this$0.m(), null, null, null, null, null, null, false, false, false, Boxing.boxBoolean(true), 4095);
        this.L$0 = r5;
        this.label = 2;
        if (r7.b(r8, this) != r1) goto L33;
        return r1;
    L33:
        r3 = r5;
        goto L34
    L20:
        if (r4.b == true) goto L22;
    L23:
        r6 = true;
        goto L25
    L22:
        if (r4.c == false) goto L24;
    L10:
        ResultKt.throwOnFailure(r19);
        r4 = (c) this.this$0.m();
        int r9 = e.a;
        GetMeetingAISummaryResponse r10 = this.$response;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.mcontent;
        Long r12 = r10.mtimestamp;
        if (r12 == null) goto L13;
        long r13 = r12.longValue();
    L14:
        b r14 = new b(r11, r13, r10.mdigest);
        lvb.a.e(this.this$1.l, "[fetchSummary] success, newSummary=" + r13);
        lvb.a.a(this.this$1.l, "[fetchSummary] newSummary=" + r11);
        MmRecordingSummaryRepo r15 = this.this$1;
        c r16 = c.a(r4, null, MmSummaryStatus.HasContent, null, null, null, r14, false, false, false, null, 7919);
        this.L$0 = r4;
        this.label = 1;
        if (r15.b(r16, this) != r1) goto L17;
        return r1;
    L13:
        r13 = 0;
        goto L14
    }
}
