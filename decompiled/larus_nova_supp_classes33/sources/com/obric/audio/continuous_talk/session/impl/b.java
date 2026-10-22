package com.obric.audio.continuous_talk.session.impl;

import android.media.AudioManager;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AbsAudioPlayManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends com.larus.audio.call.play.c {
    public final String x;

    public final com.larus.audio.call.play.b l() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L10;
        r1 = 3;
    L10:
        int r2 = ((Number) r1).intValue();
        if (((AbsAudioPlayManager) this).a == true) goto L13;
    L15:
        int r3 = 1280;
    L16:
        Integer r4 = ((AbsAudioPlayManager) this).c;
        if (r4 == null) goto L19;
        int r5 = r4.intValue();
    L21:
        if (((AbsAudioPlayManager) this).a == true) goto L23;
    L25:
        int r6 = com.larus.audio.call.common.a.a;
        int r7 = 4;
    L27:
        return new com.larus.audio.call.play.b(r2, r3, r5, r7);
    L23:
        if (((AbsAudioPlayManager) this).b == false) goto L25;
        int r8 = com.larus.audio.call.common.a.a;
        r7 = 12;
        goto L27
    L19:
        r5 = 24000;
        goto L21
    L13:
        if (((AbsAudioPlayManager) this).b == false) goto L15;
        r3 = 2560;
    L4:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final String t() {
        return this.x;
    }

    public b(RealtimeCallParam r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "realtimeCallParam");
        super(r2, r3, r4);
        this.x = "ObricContAudioPlayManager" + hashCode();
    }
}
