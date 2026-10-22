package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmUpdateAudioStatusResponse;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUpdateAudioStatusResponse;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2", f = "MmRecordingStatesSyncService.kt", i = {}, l = {410}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends MmUpdateAudioStatusResponse>>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ MmRecordingSource $source;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2(MmRecordingStatesSyncService r1, String r2, MmRecordingSource r3, Continuation<? super MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2> r4) {
        this.this$0 = r1;
        this.$recordingId = r2;
        this.$source = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingStatesSyncService$syncStandaloneDiscardUploadCompletedStatusIfNeeded$2(this.this$0, this.$recordingId, this.$source, r5);
    }

    public final Object invoke(int r1, Continuation<? super Result<MmUpdateAudioStatusResponse>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L18:
        return Result.box-impl(r12);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MmRecordingStatesSyncService.Companion r2 = MmRecordingStatesSyncService.q;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r13 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.f.getValue();
        String r3 = this.$recordingId;
        MmRecordingUpdateStatus r4 = MmRecordingUpdateStatus.UPLOAD_COMPLETED;
        MmRecordingSource r5 = this.$source;
        this.label = 1;
        if (r5 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        r12 = r2.c(r13, r3, r4, r5, null, null, r8, this);
        if (r12 != r0) goto L18;
        return r0;
    L11:
        if (r5.usesRecordingApiByDefault() != true) goto L13;
        r8 = true;
        goto L14
    }
}
