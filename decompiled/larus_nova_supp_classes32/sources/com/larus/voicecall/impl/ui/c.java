package com.larus.voicecall.impl.ui;

import android.media.AudioManager;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ RealtimeCallActivity a;

    public /* synthetic */ c(RealtimeCallActivity r1) {
        this.a = r1;
    }

    public final Object invoke() {
        RealtimeCallActivity r0 = this.a;
        int r1 = RealtimeCallActivity.l;
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Object r4 = r0.getSystemService(LynxResourceModule.AUDIO_TYPE);     // Catch: Throwable -> L9
        if ((r4 instanceof AudioManager) == false) goto L6;
        AudioManager r5 = (AudioManager) r4;     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r2 = r6;
    L16:
        return (AudioManager) r2;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
