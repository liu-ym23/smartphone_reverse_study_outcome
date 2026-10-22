package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<b> {
    Object G(Continuation<? super Unit> r1);

    void J0();

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    i1<b> b();

    Object c0(String r1, c r2, Continuation<? super g> r3);

    Object f0(String r1, c r2, Continuation<? super g> r3);

    void i(byte[] r1);

    Object j0(String r1, c r2, Continuation<? super g> r3);

    Object n(String r1, c r2, c r3, Continuation<? super g> r4);

    @Override // fvb.a
    void onDestroy();

    Object p0(boolean r1, Continuation<? super Unit> r2);

    boolean s0();

    Object z0(boolean r1, Continuation<? super f> r2);
}
