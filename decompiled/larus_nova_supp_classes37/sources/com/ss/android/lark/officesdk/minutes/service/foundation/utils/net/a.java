package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPullSubtitlesResponse;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingSyncSubtitlesResponse;
import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    Object a(String r1, MmQuotaType r2, MmRecordingSource r3, String r4, Continuation<? super Result<MmQuotaData>> r5);

    Object b(String r1, boolean r2, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r3);

    Object c(String r1, Continuation<? super Result<GetLiveRecordingSettingResponse>> r2);

    Object d(String r1, h r2, boolean r3, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r4);

    Object e(String r1, h r2, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r3);

    Object f(String r1, Continuation<? super Result<GetLiveRecordingSettingResponse>> r2);

    Object g(String r1, String r2, Long r3, boolean r4, long r5, boolean r7, Continuation<? super Result<MinutesRecordingPullSubtitlesResponse>> r8);

    Object h(String r1, boolean r2, String r3, Continuation<? super Result<MinutesRecordingSyncSubtitlesResponse>> r4);

    Object i(String r1, boolean r2, boolean r3, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r4);

    Object j(String r1, Continuation<? super Result<GetLiveRecordingSettingResponse>> r2);
}
