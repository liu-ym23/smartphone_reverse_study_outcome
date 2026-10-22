package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<f> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a$a, reason: collision with other inner class name */
    public static final class C0047a {
        public static /* synthetic */ Object a(a r2, h r3, Continuation r4) {
            return r2.X(r3, new IMmRecordingLanguageOperator$setSpokenLanguageAndAwait$2(null), r4);
        }
    }

    void F(h r1);

    void K(String r1);

    Object X(h r1, Function1<? super Continuation<? super Boolean>, ? extends Object> r2, Continuation<? super Boolean> r3);

    void Y(boolean r1);

    Object a0(h r1, long r2, Continuation<? super MmAutoLanguageSettingResult> r4);

    void e0(h r1, boolean r2);

    long i0();

    Object k0(long r1, Continuation<? super MmAutoLanguageSettingResult> r3);

    void l0();

    void u(String r1, String r2, String r3);
}
