package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingRequest;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/pb/videochat/UpdateLiveRecordingSettingResponse;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper$setSpokenLanguage$2", f = "MmRecordingNetHelper.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingNetHelper$setSpokenLanguage$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Result<? extends UpdateLiveRecordingSettingResponse>>, Object> {
    final /* synthetic */ h $language;
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$setSpokenLanguage$2(String r1, h r2, MmRecordingNetHelper r3, Continuation<? super MmRecordingNetHelper$setSpokenLanguage$2> r4) {
        this.$meetingId = r1;
        this.$language = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingNetHelper$setSpokenLanguage$2(this.$meetingId, this.$language, this.this$0, r5);
    }

    public final Object invoke(int r1, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r2) {
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
        return Result.box-impl(r7);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        UpdateLiveRecordingSettingRequest r8 = new UpdateLiveRecordingSettingRequest.Builder().meeting_id(this.$meetingId).action(UpdateLiveRecordingSettingRequest.Action.SET_SPOKEN_LANGUAGE).spoken_language(this.$language.a).m3197build();
        MmMockAwareRequestService r2 = this.this$0.a.M();
        Command r3 = Command.UPDATE_LIVE_RECORDING_SETTING;
        Intrinsics.checkNotNull(r8);
        this.label = 1;
        r7 = r2.a(r3, UpdateLiveRecordingSettingResponse.class, r8, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
