package com.larus.voicecall.impl;

import com.larus.voicecall.impl.plugins.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class y implements Function2 {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ RealtimeCallService b;

    public /* synthetic */ y(Function2 r1, RealtimeCallService r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4, Object r5) {
        Function2 r0 = this.a;
        RealtimeCallService r1 = this.b;
        r r6 = (r) r4;
        com.larus.audio.call.arch.d r7 = (com.larus.audio.call.arch.d) r5;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "registry");
        if (r0 == null) goto L5;
        r0.invoke(r6, r7);
    L5:
        r7.a(new RealtimeCallService.a(r1, r6));
        return Unit.INSTANCE;
    }
}
