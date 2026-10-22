package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$schedulePendingSubtitleFailed$timeoutJob$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {319, 328, 337}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$schedulePendingSubtitleFailed$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SubtitleFailedQuotaDecision.values().length];
            r0[SubtitleFailedQuotaDecision.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SubtitleFailedQuotaDecision.SEND_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SubtitleFailedQuotaDecision.PEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SubtitleFailedQuotaDecision.NOOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$schedulePendingSubtitleFailed$timeoutJob$1(MmRecordingSubtitleRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$schedulePendingSubtitleFailed$timeoutJob$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSubtitleRepo$opt$2$1$schedulePendingSubtitleFailed$timeoutJob$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L46:
        lvb.a.e(this.this$0.m, "[schedulePendingSubtitleFailed] timeout send subtitle failed");
    L52:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L50:
        lvb.a.e(this.this$0.m, "[schedulePendingSubtitleFailed] timeout clear, degraded=" + ((d) this.this$1.m()).g + " or asr quota blocked");
        goto L52
    L11:
        ResultKt.throwOnFailure(r8);
    L15:
        MmRecordingQuotaCtaRepo r9 = this.this$0.k.i();
        if (r9 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r10 = r9.l();
        if (r10 == null) goto L22;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> r11 = r10.b();
        if (r11 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c) r11.getValue();
    L23:
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2 = this.this$1;
        boolean r5 = r2.p.a;
        boolean r3 = ((d) r2.m()).g;
        if (r5 == true) goto L26;
        SubtitleFailedQuotaDecision r13 = SubtitleFailedQuotaDecision.NOOP;
    L34:
        int r14 = a.a[r13.ordinal()];
        if (r14 == 1) goto L47;
        if (r14 == 2) goto L43;
        if (r14 == 3) goto L52;
        if (r14 == 4) goto L52;
        throw new NoWhenBranchMatchedException();
    L43:
        this.this$1.p = new k(0);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.a r15 = this.this$0.k;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b.c r4 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b.c(true);
        this.label = 3;
        if (r15.j(r4, this) != r0) goto L46;
        return r0;
    L47:
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r16 = this.this$1;
        this.label = 2;
        if (r16.Z0(false, this) != r0) goto L50;
        return r0;
    L26:
        if (r3 == false) goto L28;
        r13 = SubtitleFailedQuotaDecision.CLEAR;
        goto L34
    L28:
        if (r12 != null) goto L31;
        r13 = SubtitleFailedQuotaDecision.SEND_FAILED;
        goto L34
    L31:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r12.a) == false) goto L33;
        r13 = SubtitleFailedQuotaDecision.CLEAR;
        goto L34
    L33:
        r13 = SubtitleFailedQuotaDecision.SEND_FAILED;
    L22:
        r12 = null;
        goto L23
    L12:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r0) goto L15;
        return r0;
    }
}
