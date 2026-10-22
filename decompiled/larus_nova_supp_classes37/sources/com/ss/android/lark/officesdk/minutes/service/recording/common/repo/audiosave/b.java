package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<f> {
    Object A(Continuation<? super Unit> r1);

    void C0();

    void D0();

    Object E0(c r1, boolean r2, Continuation<? super e> r3);

    void e(MmCreateAudioResponse r1);

    void f(MmCreateAudioResponse r1);

    void l();
}
