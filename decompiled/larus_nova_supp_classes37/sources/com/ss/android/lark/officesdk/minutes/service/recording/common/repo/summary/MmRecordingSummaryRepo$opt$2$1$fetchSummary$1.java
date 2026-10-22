package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.pb.videochat_my_ai.GetMeetingAISummaryResponse;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$fetchSummary$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSummaryRepo$opt$2$1$fetchSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ MmRecordingSummaryRepo this$0;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSummaryRepo$opt$2$1$fetchSummary$1(MmRecordingSummaryRepo r1, String r2, String r3, MmRecordingSummaryRepo$opt$2.AnonymousClass1 r4, Continuation<? super MmRecordingSummaryRepo$opt$2$1$fetchSummary$1> r5) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$source = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSummaryRepo$opt$2$1$fetchSummary$1(this.this$0, this.$meetingId, this.$source, this.this$1, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
        Object r13 = ((Result) r12).unbox-impl();
    L11:
        MmRecordingSummaryRepo r3 = this.this$0;
        String r4 = this.$source;
        MmRecordingSummaryRepo$opt$2.AnonymousClass1 r5 = this.this$1;
        if (Result.isSuccess-impl(r13) == false) goto L31;
        GetMeetingAISummaryResponse r6 = (GetMeetingAISummaryResponse) r13;
        int r7 = e.a;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r6.mcontent.length() != 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
    L27:
        if (r2 == false) goto L30;
        lvb.a.b(r3.l, "[fetchSummary] response is not valid, source=" + r4 + ", timestamp=" + r6.mtimestamp);
        return Unit.INSTANCE;
    L30:
        r3.j(new MmRecordingSummaryRepo$opt$2$1$fetchSummary$1$1$1(r5, r6, r3, null));
        goto L31
    L19:
        if (r6.mdigest.length() != 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L27;
        if (r6.mtimestamp.longValue() <= 0) goto L27;
        r2 = false;
        goto L27
    L21:
        r9 = false;
        goto L22
    L16:
        r8 = false;
    L31:
        MmRecordingSummaryRepo r10 = this.this$0;
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L35;
        lvb.a.b(r10.l, "[fetchSummary] failed error=" + r14);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        MmRecordingNetHelper r15 = this.this$0.k.G();
        String r11 = this.$meetingId;
        this.label = 1;
        r13 = r15.l(r11, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
