package com.larus.audio.call.arch;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b0 implements Function1 {
    public /* synthetic */ b0() {
    }

    public final Object invoke(Object r6) {
        a r7 = (a) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        long r0 = SystemClock.elapsedRealtime();
        r7.V2();
        long r2 = SystemClock.elapsedRealtime() - r0;
        com.larus.audio.call.util.e.a.i("LLMPluginContainer", "onAfterStart " + r7.T2() + " cost: " + r2);
        return Unit.INSTANCE;
    }
}
