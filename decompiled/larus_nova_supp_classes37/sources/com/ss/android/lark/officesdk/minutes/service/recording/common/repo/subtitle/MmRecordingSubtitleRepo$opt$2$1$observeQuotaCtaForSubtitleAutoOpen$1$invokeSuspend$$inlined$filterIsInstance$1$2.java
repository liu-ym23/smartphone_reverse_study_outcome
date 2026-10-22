package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleAutoOpen$1$invokeSuspend$$inlined$filterIsInstance$1$2<T> implements FlowCollector {
    public final /* synthetic */ FlowCollector a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleAutoOpen$1$invokeSuspend$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleAutoOpen$1$invokeSuspend$$inlined$filterIsInstance$1$2", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleAutoOpen$1$invokeSuspend$$inlined$filterIsInstance$1$2 this$0;

        public AnonymousClass1(MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleAutoOpen$1$invokeSuspend$$inlined$filterIsInstance$1$2 r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$observeQuotaCtaForSubtitleAutoOpen$1$invokeSuspend$$inlined$filterIsInstance$1$2(FlowCollector r1) {
        this.a = r1;
    }

    public final Object emit(Object r5, Continuation r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        FlowCollector r8 = this.a;
        if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.d.a) == false) goto L20;
        r0.label = 1;
        if (r8.emit(r5, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
