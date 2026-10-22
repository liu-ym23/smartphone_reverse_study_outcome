package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.SIBizScene;
import com.ss.android.lark.pb.videochat.UpdateSISettingRequest;
import com.ss.android.lark.pb.videochat.UpdateSISettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationUpdateResult;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.RustMmAIInterpretationGateway$updateSetting$2", f = "RustMmAIInterpretationGateway.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class RustMmAIInterpretationGateway$updateSetting$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends p>>, Object> {
    final /* synthetic */ String $breakoutRoomId;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ g $language;
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ RustMmAIInterpretationGateway this$0;

    public RustMmAIInterpretationGateway$updateSetting$2(RustMmAIInterpretationGateway r1, String r2, String r3, boolean r4, g r5, Continuation<? super RustMmAIInterpretationGateway$updateSetting$2> r6) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$breakoutRoomId = r3;
        this.$enabled = r4;
        this.$language = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RustMmAIInterpretationGateway$updateSetting$2(this.this$0, this.$meetingId, this.$breakoutRoomId, this.$enabled, this.$language, r9);
    }

    public final Object invoke(int r1, Continuation<? super Result<p>> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L17:
        RustMmAIInterpretationGateway r2 = this.this$0;
        boolean r3 = this.$enabled;
        g r4 = this.$language;
        if (Result.isSuccess-impl(r8) == false) goto L23;
        UpdateSISettingResponse r9 = (UpdateSISettingResponse) r8;
        String r5 = r9.mchannel;
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        p r6 = new p(r5, r9.mstatus.getValue());
        lvb.a.e(r2.b, "[updateSetting] status=" + r6.b + ", channel=" + r6.a + ", enabled=" + r3 + ", language=" + r4.a);
        Object r10 = Result.constructor-impl(r6);
    L25:
        return Result.box-impl(r10);
    L23:
        r10 = Result.constructor-impl(r8);
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        lvb.a.e(this.this$0.b, "[updateSetting] request, meetingId=" + this.$meetingId + ", breakoutRoomId=" + this.$breakoutRoomId + ", enabled=" + this.$enabled + ", targetLang=" + this.$language.a);
        UpdateSISettingRequest.Builder r11 = new UpdateSISettingRequest.Builder().meeting_id(this.$meetingId).turn_on(Boxing.boxBoolean(this.$enabled)).target_lang(this.$language.a).biz_scene(SIBizScene.MINUTES);
        if (this.$breakoutRoomId.length() <= 0) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L14;
        r11.breakout_room_id(this.$breakoutRoomId);
    L14:
        MmMockAwareRequestService r13 = this.this$0.a.M();
        Command r14 = Command.UPDATE_MEETING_SI_SETTING;
        UpdateSISettingRequest r15 = r11.m3203build();
        this.label = 1;
        r8 = r13.a(r14, UpdateSISettingResponse.class, r15, this);
        if (r8 != r0) goto L17;
        return r0;
    L11:
        r12 = false;
        goto L12
    }
}
