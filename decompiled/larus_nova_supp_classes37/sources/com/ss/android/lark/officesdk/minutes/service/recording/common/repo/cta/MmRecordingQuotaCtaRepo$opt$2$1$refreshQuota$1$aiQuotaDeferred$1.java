package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1", f = "MmRecordingQuotaCtaRepo.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends MmQuotaData>>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a $netHelper;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ MmRecordingQuotaCtaRepo this$0;

    public MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1(com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r1, String r2, MmRecordingQuotaCtaRepo r3, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1> r4) {
        this.$netHelper = r1;
        this.$token = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1(this.$netHelper, this.$token, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<MmQuotaData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L12:
        return Result.box-impl(r9);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r2 = this.$netHelper;
        String r10 = this.$token;
        MmQuotaType r3 = MmQuotaType.AI_SUMMARY;
        MmRecordingSource r4 = this.this$0.k;
        this.label = 1;
        r9 = r2.a(r10, r3, r4, "minutes_recording_notes_page", this);
        if (r9 != r0) goto L12;
        return r0;
    }
}
