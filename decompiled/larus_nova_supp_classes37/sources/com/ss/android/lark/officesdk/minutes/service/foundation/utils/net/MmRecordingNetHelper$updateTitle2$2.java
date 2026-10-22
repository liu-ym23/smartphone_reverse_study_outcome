package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat_my_ai.GetMeetingAISummaryRequest;
import com.ss.android.lark.pb.videochat_my_ai.GetMeetingAISummaryResponse;
import com.ss.android.lark.pb.videochat_my_ai.UpdateTitleInfo;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$updateTitle2$2", f = "MmRecordingNetHelper.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$updateTitle2$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $newTitle;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$updateTitle2$2(String r1, String r2, MmRecordingNetHelper r3, Continuation<? super MmRecordingNetHelper$updateTitle2$2> r4) {
        this.$newTitle = r1;
        this.$meetingId = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingNetHelper$updateTitle2$2(this.$newTitle, this.$meetingId, this.this$0, r5);
    }

    public final Object invoke(int r1, Continuation<? super Result<String>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L11:
        String r2 = this.$newTitle;
        if (Result.isSuccess-impl(r7) == false) goto L14;
        GetMeetingAISummaryResponse r8 = (GetMeetingAISummaryResponse) r7;
        Object r9 = Result.constructor-impl(r2);
    L16:
        return Result.box-impl(r9);
    L14:
        r9 = Result.constructor-impl(r7);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        UpdateTitleInfo r10 = new UpdateTitleInfo.Builder().manual_title(this.$newTitle).m3311build();
        GetMeetingAISummaryRequest r11 = new GetMeetingAISummaryRequest.Builder().meeting_id(this.$meetingId).action_type(GetMeetingAISummaryRequest.ActionType.UPDATE_MINUTES_TITLE).update_title_info(r10).m3284build();
        MmMockAwareRequestService r3 = this.this$0.a.M();
        Command r4 = Command.GET_MEETING_AI_SUMMARY;
        Intrinsics.checkNotNull(r11);
        this.label = 1;
        r7 = r3.a(r4, GetMeetingAISummaryResponse.class, r11, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
