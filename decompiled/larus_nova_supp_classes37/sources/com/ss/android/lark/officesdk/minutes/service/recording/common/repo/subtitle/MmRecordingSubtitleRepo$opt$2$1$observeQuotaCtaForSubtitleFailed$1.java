package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleFailed$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingQuotaCtaRepo $quotaCtaRepo;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 a;

        public a(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r0 = this.a;
            Object r4 = MmRecordingSubtitleRepo$opt$2.AnonymousClass1.T0(r0, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleFailed$1(MmRecordingQuotaCtaRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleFailed$1> r3) {
        this.$quotaCtaRepo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleFailed$1(this.$quotaCtaRepo, this.this$0, r4);
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
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> r6 = this.$quotaCtaRepo.l().b();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
