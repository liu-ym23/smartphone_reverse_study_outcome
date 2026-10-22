package com.larus.voicecall.impl.plugins;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q1 extends com.larus.audio.call.arch.a<r> implements t {
    public Function0<? extends Map<String, ? extends Object>> f;

    public final String T2() {
        return "RealtimeDenoisePlugin";
    }

    @Override // com.larus.voicecall.impl.plugins.t
    public final Function0<Map<String, Object>> X1() {
        return this.f;
    }

    public q1(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.larus.voicecall.impl.plugins.t
    public final void F0(com.larus.voicecall.impl.component.denoise.j r1) {
        this.f = r1;
    }
}
