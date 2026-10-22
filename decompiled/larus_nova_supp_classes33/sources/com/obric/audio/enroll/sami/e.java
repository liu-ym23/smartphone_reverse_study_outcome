package com.obric.audio.enroll.sami;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ e(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        String r0 = this.a;
        SpeechFingerPrintEnrollService r11 = (SpeechFingerPrintEnrollService) r10;
        Intrinsics.checkNotNullParameter(r11, "service");
        SamiEnrollEngine.a.getClass();
        SamiEnrollEngine.B("attempt", true, r0, null, null);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(Integer.valueOf(r11.forceReEnrollWakeupSid()));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r12);
        if (r2 == null) goto L11;
        FLogger.a.e("SamiEnrollEngine", "forceReEnrollWakeupSid failed reason=" + r0 + ' ' + r2.getMessage());
    L11:
        if (Result.isFailure-impl(r12) == false) goto L13;
        r12 = Integer.MIN_VALUE;
    L13:
        int r13 = ((Number) r12).intValue();
        if (r13 != 0) goto L16;
        FLogger.a.i("SamiEnrollEngine", "forceReEnrollWakeupSid success reason=" + r0);
        SamiEnrollEngine r4 = SamiEnrollEngine.a;
        Integer r5 = Integer.valueOf(r13);
        r4.getClass();
        SamiEnrollEngine.B(WindowEvent.Params.RESULT, true, r0, r5, null);
    L18:
        return Integer.valueOf(r13);
    L16:
        FLogger.a.e("SamiEnrollEngine", "forceReEnrollWakeupSid failed reason=" + r0 + " ret=" + r13);
        SamiEnrollEngine r3 = SamiEnrollEngine.a;
        Integer r6 = Integer.valueOf(r13);
        r3.getClass();
        SamiEnrollEngine.B(WindowEvent.Params.RESULT, false, r0, r6, "force_reenroll_api_failed");
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
