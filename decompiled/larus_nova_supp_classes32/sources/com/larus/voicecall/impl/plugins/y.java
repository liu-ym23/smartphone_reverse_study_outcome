package com.larus.voicecall.impl.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y extends com.larus.audio.call.plugins.u<r> {
    public final String I;

    public final u68.c m3() {
        return new x(((r) getContext()).params(), J3());
    }

    public final v68.a n3() {
        return super.n3();
    }

    public final String T2() {
        return this.I;
    }

    public y(r r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.I = "QuicAudioPlugin";
    }

    public final void P3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r2, "id");
        com.larus.voicecall.impl.q r0 = ((r) getContext()).h();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }
}
