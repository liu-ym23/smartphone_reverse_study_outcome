package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.pb.minutes.v1.MinutesMgetChattersRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesMgetChattersResponse;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPullSubtitlesResponse;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingSyncSubtitlesResponse;
import com.ss.android.lark.pb.videochat.CreateSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.GetSpeakerInfoListResponse;
import com.ss.android.lark.pb.videochat.GetSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.MeetingAICapabilityControlResponse;
import com.ss.android.lark.pb.videochat.SetSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat_my_ai.GetMeetingAISummaryResponse;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingNetHelper implements a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final l b;
    public final Lazy c;

    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a r() {
        return (com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a) this.c.getValue();
    }

    public MmRecordingNetHelper(MinutesUCCImpl r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new MmRecordingNetHelper$mmWebNetworkProxy$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object c(String r5, Continuation<? super Result<GetLiveRecordingSettingResponse>> r6) {
        if ((r6 instanceof MmRecordingNetHelper$fetchTranslateLanguageList$1) == false) goto L7;
        MmRecordingNetHelper$fetchTranslateLanguageList$1 r0 = (MmRecordingNetHelper$fetchTranslateLanguageList$1) r6;
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
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper$fetchTranslateLanguageList$2 r8 = new MmRecordingNetHelper$fetchTranslateLanguageList$2(r5, this, null);
        r0.label = 1;
        Object r9 = MmCustomExceptionKt.a(3, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmRecordingNetHelper$fetchTranslateLanguageList$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object f(String r5, Continuation<? super Result<GetLiveRecordingSettingResponse>> r6) {
        if ((r6 instanceof MmRecordingNetHelper$fetchLanguageSettings$1) == false) goto L7;
        MmRecordingNetHelper$fetchLanguageSettings$1 r0 = (MmRecordingNetHelper$fetchLanguageSettings$1) r6;
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
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper$fetchLanguageSettings$2 r8 = new MmRecordingNetHelper$fetchLanguageSettings$2(r5, this, null);
        r0.label = 1;
        Object r9 = MmCustomExceptionKt.a(3, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmRecordingNetHelper$fetchLanguageSettings$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object j(String r5, Continuation<? super Result<GetLiveRecordingSettingResponse>> r6) {
        if ((r6 instanceof MmRecordingNetHelper$fetchSpokenLanguageList$1) == false) goto L7;
        MmRecordingNetHelper$fetchSpokenLanguageList$1 r0 = (MmRecordingNetHelper$fetchSpokenLanguageList$1) r6;
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
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper$fetchSpokenLanguageList$2 r8 = new MmRecordingNetHelper$fetchSpokenLanguageList$2(r5, this, null);
        r0.label = 1;
        Object r9 = MmCustomExceptionKt.a(3, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmRecordingNetHelper$fetchSpokenLanguageList$1(this, r6);
        goto L8
    }

    public final Object l(String r5, Continuation<? super Result<GetMeetingAISummaryResponse>> r6) {
        if ((r6 instanceof MmRecordingNetHelper$fetchMeetingAISummary$1) == false) goto L7;
        MmRecordingNetHelper$fetchMeetingAISummary$1 r0 = (MmRecordingNetHelper$fetchMeetingAISummary$1) r6;
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
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper$fetchMeetingAISummary$2 r8 = new MmRecordingNetHelper$fetchMeetingAISummary$2(r5, this, null);
        r0.label = 1;
        Object r9 = MmCustomExceptionKt.a(3, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmRecordingNetHelper$fetchMeetingAISummary$1(this, r6);
        goto L8
    }

    public final Object p(String r5, Continuation<? super Result<String>> r6) {
        if ((r6 instanceof MmRecordingNetHelper$fetchTitle$1) == false) goto L7;
        MmRecordingNetHelper$fetchTitle$1 r0 = (MmRecordingNetHelper$fetchTitle$1) r6;
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
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper$fetchTitle$2 r8 = new MmRecordingNetHelper$fetchTitle$2(r5, this, null);
        r0.label = 1;
        Object r9 = MmCustomExceptionKt.a(3, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmRecordingNetHelper$fetchTitle$1(this, r6);
        goto L8
    }

    public final Object q(MmRecordingSource r5, Continuation<? super Result<kvb.a>> r6) {
        if ((r6 instanceof MmRecordingNetHelper$getUserGuide$1) == false) goto L7;
        MmRecordingNetHelper$getUserGuide$1 r0 = (MmRecordingNetHelper$getUserGuide$1) r6;
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
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper$getUserGuide$2 r8 = new MmRecordingNetHelper$getUserGuide$2(this, r5, null);
        r0.label = 1;
        Object r9 = MmCustomExceptionKt.a(3, r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new MmRecordingNetHelper$getUserGuide$1(this, r6);
        goto L8
    }

    public final Object t(List r6, Continuation r7) {
        if ((r7 instanceof MmRecordingNetHelper$pullUserInfo$1) == false) goto L7;
        MmRecordingNetHelper$pullUserInfo$1 r0 = (MmRecordingNetHelper$pullUserInfo$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MinutesMgetChattersRequest r9 = new MinutesMgetChattersRequest.Builder().chatter_ids(r6).m1847build();
        MmMockAwareRequestService r10 = this.a.M();
        Command r4 = Command.MINUTES_MGET_CHATTERS;
        Intrinsics.checkNotNull(r9);
        r0.label = 1;
        Object r11 = r10.b(r4, MinutesMgetChattersResponse.class, r9, r0);
        if (r11 != r2) goto L18;
        return r2;
    L18:
        return r11;
    L7:
        r0 = new MmRecordingNetHelper$pullUserInfo$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object b(String r5, boolean r6, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r7) {
        if ((r7 instanceof MmRecordingNetHelper$setSubtitleOn$1) == false) goto L7;
        MmRecordingNetHelper$setSubtitleOn$1 r0 = (MmRecordingNetHelper$setSubtitleOn$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingNetHelper$setSubtitleOn$2 r9 = new MmRecordingNetHelper$setSubtitleOn$2(r6, r5, this, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new MmRecordingNetHelper$setSubtitleOn$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object e(String r5, h r6, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r7) {
        if ((r7 instanceof MmRecordingNetHelper$setSpokenLanguage$1) == false) goto L7;
        MmRecordingNetHelper$setSpokenLanguage$1 r0 = (MmRecordingNetHelper$setSpokenLanguage$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingNetHelper$setSpokenLanguage$2 r9 = new MmRecordingNetHelper$setSpokenLanguage$2(r5, r6, this, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new MmRecordingNetHelper$setSpokenLanguage$1(this, r7);
        goto L8
    }

    public final Object o(String r5, String r6, Continuation<? super Result<GetLiveRecordingSettingResponse>> r7) {
        if ((r7 instanceof MmRecordingNetHelper$fetchSpeakerMarkingAvailability$1) == false) goto L7;
        MmRecordingNetHelper$fetchSpeakerMarkingAvailability$1 r0 = (MmRecordingNetHelper$fetchSpeakerMarkingAvailability$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingNetHelper$fetchSpeakerMarkingAvailability$2 r9 = new MmRecordingNetHelper$fetchSpeakerMarkingAvailability$2(r5, r6, this, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new MmRecordingNetHelper$fetchSpeakerMarkingAvailability$1(this, r7);
        goto L8
    }

    public final Object s(String r5, boolean r6, Continuation<? super Result<MeetingAICapabilityControlResponse>> r7) {
        if ((r7 instanceof MmRecordingNetHelper$meetingAISwitch$1) == false) goto L7;
        MmRecordingNetHelper$meetingAISwitch$1 r0 = (MmRecordingNetHelper$meetingAISwitch$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingNetHelper$meetingAISwitch$2 r9 = new MmRecordingNetHelper$meetingAISwitch$2(r6, r5, this, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new MmRecordingNetHelper$meetingAISwitch$1(this, r7);
        goto L8
    }

    public final Object v(String r5, MmRecordingSource r6, Continuation<? super Result<Boolean>> r7) {
        if ((r7 instanceof MmRecordingNetHelper$saveUserGuide$1) == false) goto L7;
        MmRecordingNetHelper$saveUserGuide$1 r0 = (MmRecordingNetHelper$saveUserGuide$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingNetHelper$saveUserGuide$2 r9 = new MmRecordingNetHelper$saveUserGuide$2(this, r5, r6, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new MmRecordingNetHelper$saveUserGuide$1(this, r7);
        goto L8
    }

    public final Object y(String r5, String r6, Continuation<? super Result<String>> r7) {
        if ((r7 instanceof MmRecordingNetHelper$updateTitle2$1) == false) goto L7;
        MmRecordingNetHelper$updateTitle2$1 r0 = (MmRecordingNetHelper$updateTitle2$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        MmRecordingNetHelper$updateTitle2$2 r9 = new MmRecordingNetHelper$updateTitle2$2(r6, r5, this, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new MmRecordingNetHelper$updateTitle2$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object d(String r11, h r12, boolean r13, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r14) {
        if ((r14 instanceof MmRecordingNetHelper$setTranslateLanguage$1) == false) goto L7;
        MmRecordingNetHelper$setTranslateLanguage$1 r0 = (MmRecordingNetHelper$setTranslateLanguage$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingNetHelper$setTranslateLanguage$2 r16 = new MmRecordingNetHelper$setTranslateLanguage$2(r11, r12, r13, this, null);
        r0.label = 1;
        Object r17 = MmCustomExceptionKt.a(3, r16, r0);
        if (r17 != r2) goto L18;
        return r2;
    L18:
        return r17;
    L7:
        r0 = new MmRecordingNetHelper$setTranslateLanguage$1(this, r14);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object h(String r11, boolean r12, String r13, Continuation<? super Result<MinutesRecordingSyncSubtitlesResponse>> r14) {
        if ((r14 instanceof MmRecordingNetHelper$syncSubtitles$1) == false) goto L7;
        MmRecordingNetHelper$syncSubtitles$1 r0 = (MmRecordingNetHelper$syncSubtitles$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingNetHelper$syncSubtitles$2 r16 = new MmRecordingNetHelper$syncSubtitles$2(r11, r12, r13, this, null);
        r0.label = 1;
        Object r17 = MmCustomExceptionKt.a(3, r16, r0);
        if (r17 != r2) goto L18;
        return r2;
    L18:
        return r17;
    L7:
        r0 = new MmRecordingNetHelper$syncSubtitles$1(this, r14);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object i(String r11, boolean r12, boolean r13, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r14) {
        if ((r14 instanceof MmRecordingNetHelper$setBilingual$1) == false) goto L7;
        MmRecordingNetHelper$setBilingual$1 r0 = (MmRecordingNetHelper$setBilingual$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingNetHelper$setBilingual$2 r16 = new MmRecordingNetHelper$setBilingual$2(r11, r12, r13, this, null);
        r0.label = 1;
        Object r17 = MmCustomExceptionKt.a(3, r16, r0);
        if (r17 != r2) goto L18;
        return r2;
    L18:
        return r17;
    L7:
        r0 = new MmRecordingNetHelper$setBilingual$1(this, r14);
        goto L8
    }

    public final Object k(String r11, String r12, String r13, Continuation<? super Result<CreateSpeakerInfoResponse>> r14) {
        if ((r14 instanceof MmRecordingNetHelper$createSpeakerInfo$1) == false) goto L7;
        MmRecordingNetHelper$createSpeakerInfo$1 r0 = (MmRecordingNetHelper$createSpeakerInfo$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingNetHelper$createSpeakerInfo$2 r16 = new MmRecordingNetHelper$createSpeakerInfo$2(r11, r12, r13, this, null);
        r0.label = 1;
        Object r17 = MmCustomExceptionKt.a(3, r16, r0);
        if (r17 != r2) goto L18;
        return r2;
    L18:
        return r17;
    L7:
        r0 = new MmRecordingNetHelper$createSpeakerInfo$1(this, r14);
        goto L8
    }

    public final Object w(jvb.a r11, boolean r12, MmRecordingSource r13, Continuation<? super Result<Unit>> r14) {
        if ((r14 instanceof MmRecordingNetHelper$setAudioSaveStatus$1) == false) goto L7;
        MmRecordingNetHelper$setAudioSaveStatus$1 r0 = (MmRecordingNetHelper$setAudioSaveStatus$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingNetHelper$setAudioSaveStatus$2 r16 = new MmRecordingNetHelper$setAudioSaveStatus$2(this, r11, r12, r13, null);
        r0.label = 1;
        Object r17 = MmCustomExceptionKt.a(3, r16, r0);
        if (r17 != r2) goto L18;
        return r2;
    L18:
        return r17;
    L7:
        r0 = new MmRecordingNetHelper$setAudioSaveStatus$1(this, r14);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object a(String r13, MmQuotaType r14, MmRecordingSource r15, String r16, Continuation<? super Result<MmQuotaData>> r17) {
        if ((r17 instanceof MmRecordingNetHelper$fetchQuotaData$1) == false) goto L7;
        MmRecordingNetHelper$fetchQuotaData$1 r1 = (MmRecordingNetHelper$fetchQuotaData$1) r17;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$fetchQuotaData$2 r4 = new MmRecordingNetHelper$fetchQuotaData$2(this, r13, r14, r15, r16, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r10) goto L18;
        return r10;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$fetchQuotaData$1(this, r17);
        goto L8
    }

    public final Object m(String r13, String r14, String r15, List<String> r16, Continuation<? super Result<GetSpeakerInfoResponse>> r17) {
        if ((r17 instanceof MmRecordingNetHelper$fetchSpeakerInfo$1) == false) goto L7;
        MmRecordingNetHelper$fetchSpeakerInfo$1 r1 = (MmRecordingNetHelper$fetchSpeakerInfo$1) r17;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$fetchSpeakerInfo$2 r4 = new MmRecordingNetHelper$fetchSpeakerInfo$2(r13, r14, r15, r16, this, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r10) goto L18;
        return r10;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$fetchSpeakerInfo$1(this, r17);
        goto L8
    }

    public final Object n(String r13, String r14, String r15, String r16, Continuation<? super Result<GetSpeakerInfoListResponse>> r17) {
        if ((r17 instanceof MmRecordingNetHelper$fetchSpeakerInfoList$1) == false) goto L7;
        MmRecordingNetHelper$fetchSpeakerInfoList$1 r1 = (MmRecordingNetHelper$fetchSpeakerInfoList$1) r17;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$fetchSpeakerInfoList$2 r4 = new MmRecordingNetHelper$fetchSpeakerInfoList$2(r13, r14, r15, r16, this, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r10) goto L18;
        return r10;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$fetchSpeakerInfoList$1(this, r17);
        goto L8
    }

    public final Object u(String r14, MmQuotaType r15, String r16, String r17, MmRecordingSource r18, Continuation<? super Result<Unit>> r19) {
        if ((r19 instanceof MmRecordingNetHelper$reportUpgradeEvent$1) == false) goto L7;
        MmRecordingNetHelper$reportUpgradeEvent$1 r1 = (MmRecordingNetHelper$reportUpgradeEvent$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$reportUpgradeEvent$2 r4 = new MmRecordingNetHelper$reportUpgradeEvent$2(this, r14, r15, r16, r17, r18, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r11) goto L18;
        return r11;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$reportUpgradeEvent$1(this, r19);
        goto L8
    }

    public final Object x(String r15, String r16, String r17, long r18, d r20, Continuation<? super Result<SetSpeakerInfoResponse>> r21) {
        if ((r21 instanceof MmRecordingNetHelper$setSpeakerInfo$1) == false) goto L7;
        MmRecordingNetHelper$setSpeakerInfo$1 r1 = (MmRecordingNetHelper$setSpeakerInfo$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$setSpeakerInfo$2 r4 = new MmRecordingNetHelper$setSpeakerInfo$2(r15, r16, r17, r18, r20, this, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r12) goto L18;
        return r12;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$setSpeakerInfo$1(this, r21);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a
    public final Object g(String r16, String r17, Long r18, boolean r19, long r20, boolean r22, Continuation<? super Result<MinutesRecordingPullSubtitlesResponse>> r23) {
        if ((r23 instanceof MmRecordingNetHelper$fetchSubtitles$1) == false) goto L7;
        MmRecordingNetHelper$fetchSubtitles$1 r1 = (MmRecordingNetHelper$fetchSubtitles$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$fetchSubtitles$2 r4 = new MmRecordingNetHelper$fetchSubtitles$2(r16, r20, r19, r18, r17, r22, this, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r13) goto L18;
        return r13;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$fetchSubtitles$1(this, r23);
        goto L8
    }

    public final Object z(String r17, double r18, double r20, String r22, MmRecordingSource r23, boolean r24, Continuation<? super Result<MmUploadLocationResponse>> r25) {
        if ((r25 instanceof MmRecordingNetHelper$uploadMMLocation$1) == false) goto L7;
        MmRecordingNetHelper$uploadMMLocation$1 r1 = (MmRecordingNetHelper$uploadMMLocation$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MmRecordingNetHelper$uploadMMLocation$2 r4 = new MmRecordingNetHelper$uploadMMLocation$2(this, r17, r18, r20, r22, r23, r24, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r14) goto L18;
        return r14;
    L18:
        return r5;
    L7:
        r1 = new MmRecordingNetHelper$uploadMMLocation$1(this, r25);
        goto L8
    }
}
