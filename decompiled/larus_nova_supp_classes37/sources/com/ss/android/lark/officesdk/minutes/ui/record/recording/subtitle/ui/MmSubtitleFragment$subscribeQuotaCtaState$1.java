package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment$subscribeQuotaCtaState$1", f = "MmSubtitleFragment.kt", i = {}, l = {482}, m = "invokeSuspend", n = {}, s = {})
final class MmSubtitleFragment$subscribeQuotaCtaState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmSubtitleFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmSubtitleFragment a;

        public a(MmSubtitleFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c) r4;
            MmSubtitleFragment r7 = this.a;
            r7.q = r6;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r0 = r6.a;
            t r1 = r7.u;
            boolean r2 = r1.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r0, "quotaCtaState");
            r7.u = new t(r2, r0);
            r7.t = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r0);
            r7.ca0();
            r7.ia0(r6, false);
            return Unit.INSTANCE;
        }
    }

    public MmSubtitleFragment$subscribeQuotaCtaState$1(MmSubtitleFragment r1, Continuation<? super MmSubtitleFragment$subscribeQuotaCtaState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSubtitleFragment$subscribeQuotaCtaState$1(this.this$0, r3);
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
    L18:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmSubtitleFragment r6 = this.this$0;
        int r2 = MmSubtitleFragment.E;
        MmRecordingQuotaCtaRepo r7 = r6.ea0().getQuotaCtaRepo();
        if (r7 == null) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r8 = r7.l();
        if (r8 == null) goto L20;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> r9 = r8.b();
        if (r9 == null) goto L20;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r9.collect(r3, this) != r0) goto L18;
        return r0;
    L20:
        return Unit.INSTANCE;
    }
}
