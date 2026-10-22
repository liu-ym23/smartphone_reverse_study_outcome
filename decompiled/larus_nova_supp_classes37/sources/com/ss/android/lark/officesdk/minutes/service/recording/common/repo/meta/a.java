package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<b> {
    void N(MmRecordingWindowMode r1);

    Object O(String r1, String r2, Continuation<? super Unit> r3);

    void Q0(long r1);

    void c(String r1, long r2);

    void e(MmCreateAudioResponse r1);

    void f(MmCreateAudioResponse r1);

    void k(MmRecordingUITab r1);
}
