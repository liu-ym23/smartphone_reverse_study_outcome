package com.larus.voicecall.impl.plugins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p1 extends com.larus.audio.call.arch.a<r> implements p {
    public final String f;

    @Override // com.larus.voicecall.impl.plugins.p
    public final void b0() {
        com.larus.audio.call.plugins.t0 r0 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r0 == null) goto L6;
        r0.b0();
        return;
    }

    @Override // com.larus.voicecall.impl.plugins.p
    public final void f0() {
        com.larus.audio.call.plugins.t0 r0 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r0 == null) goto L6;
        r0.f0();
        return;
    }

    public final String T2() {
        return this.f;
    }

    public p1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeContinuousTalkPlugin";
    }
}
