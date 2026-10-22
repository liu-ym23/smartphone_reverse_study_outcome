package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.pb.videochat.GetSpeakerInfoListResponse;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/pb/videochat/GetSpeakerInfoListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1", f = "MmSpeakerMarkViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends GetSpeakerInfoListResponse>>, Object> {
    final /* synthetic */ String $operatorId;
    final /* synthetic */ String $query;
    final /* synthetic */ String $tenantId;
    int label;
    final /* synthetic */ MmSpeakerMarkViewModel this$0;

    public MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1(MmSpeakerMarkViewModel r1, String r2, String r3, String r4, Continuation<? super MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1> r5) {
        this.this$0 = r1;
        this.$operatorId = r2;
        this.$tenantId = r3;
        this.$query = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmSpeakerMarkViewModel$searchSpeakerCandidates$1$result$1(this.this$0, this.$operatorId, this.$tenantId, this.$query, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<GetSpeakerInfoListResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L12:
        return Result.box-impl(r11);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MmRecordingNetHelper r3 = this.this$0.getMmUccApi$officesdk_minutes_base_ui_release().G();
        String r4 = this.this$0.getMeetingId$officesdk_minutes_base_ui_release();
        String r5 = this.$operatorId;
        String r6 = this.$tenantId;
        String r7 = this.$query;
        this.label = 1;
        r11 = r3.n(r4, r5, r6, r7, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
