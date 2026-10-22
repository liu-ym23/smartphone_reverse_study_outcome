package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g0 implements Function1<String, Unit> {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ TtsReader c;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> d;

    public g0(m0 r1, Ref.BooleanRef r2, TtsReader r3, kotlinx.coroutines.j r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r4) {
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "message");
        FLogger.a.i("TtsReader", "[TTS] failed in queue playing tts message " + r5);
        this.a.dispose();
        Ref.BooleanRef r6 = this.b;
        if (r6.element == true) goto L6;
        r6.element = true;
        this.c.f.clear();
        kotlinx.coroutines.i<Boolean> r7 = this.d;
        Result.Companion r0 = Result.Companion;
        r7.resumeWith(Result.constructor-impl(Boolean.FALSE));
    L6:
        return Unit.INSTANCE;
    }
}
