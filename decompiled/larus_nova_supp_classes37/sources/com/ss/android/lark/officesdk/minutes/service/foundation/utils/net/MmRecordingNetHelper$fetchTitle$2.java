package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat_my_ai.CustomSummaryAction;
import com.ss.android.lark.pb.videochat_my_ai.CustomSummaryInfo;
import com.ss.android.lark.pb.videochat_my_ai.CustomSummaryMinutesMeetingInfo;
import com.ss.android.lark.pb.videochat_my_ai.CustomType;
import com.ss.android.lark.pb.videochat_my_ai.GetMeetingAISummaryRequest;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$fetchTitle$2", f = "MmRecordingNetHelper.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$fetchTitle$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$fetchTitle$2(String r1, MmRecordingNetHelper r2, Continuation<? super MmRecordingNetHelper$fetchTitle$2> r3) {
        this.$meetingId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingNetHelper$fetchTitle$2(this.$meetingId, this.this$0, r4);
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
    L12:
        if (Result.isSuccess-impl(r7) == false) goto L21;
        CustomSummaryInfo r8 = ((GetMeetingAISummaryResponse) r7).mcustom_summary;
        if (r8 == null) goto L19;
        CustomSummaryMinutesMeetingInfo r9 = r8.mminutes_meeting_info;
        if (r9 == null) goto L19;
        r7 = r9.mtitle;
        if (r7 != null) goto L21;
    L19:
        r7 = "";
    L21:
        return Result.box-impl(Result.constructor-impl(r7));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CustomSummaryAction r10 = new CustomSummaryAction.Builder().custom_type(CustomType.CUSTOM_PULL_TITLE).m3239build();
        GetMeetingAISummaryRequest r11 = new GetMeetingAISummaryRequest.Builder().meeting_id(this.$meetingId).action_type(GetMeetingAISummaryRequest.ActionType.CUSTOM_SUMMARY_ACTION).custom_summary_action(r10).m3284build();
        MmMockAwareRequestService r2 = this.this$0.a.M();
        Command r3 = Command.GET_MEETING_AI_SUMMARY;
        Intrinsics.checkNotNull(r11);
        this.label = 1;
        r7 = r2.a(r3, GetMeetingAISummaryResponse.class, r11, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
