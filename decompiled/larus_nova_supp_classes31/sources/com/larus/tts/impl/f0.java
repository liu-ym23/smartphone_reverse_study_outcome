package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f0 implements Function0<Unit> {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> c;

    public f0(m0 r1, Ref.BooleanRef r2, kotlinx.coroutines.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        FLogger.a.i("TtsReader", "[TTS] next in queue playing tts code");
        this.a.dispose();
        Ref.BooleanRef r0 = this.b;
        if (r0.element == true) goto L6;
        r0.element = true;
        kotlinx.coroutines.i<Boolean> r1 = this.c;
        Result.Companion r2 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(Boolean.TRUE));
    L6:
        return Unit.INSTANCE;
    }
}
