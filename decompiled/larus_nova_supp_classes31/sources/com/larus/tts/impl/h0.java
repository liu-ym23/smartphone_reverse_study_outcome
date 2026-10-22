package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 implements Function1<Throwable, Unit> {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    public h0() {
    }

    public final Object invoke(Object r4) {
        Throwable r5 = (Throwable) r4;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[TTS] cancel by scope will callback, ");
        if (r5 == null) goto L5;
        Throwable r6 = r5.getCause();
    L6:
        r1.append(r6);
        r0.i("TtsReader", r1.toString());
        return Unit.INSTANCE;
    L5:
        r6 = null;
        goto L6
    }
}
