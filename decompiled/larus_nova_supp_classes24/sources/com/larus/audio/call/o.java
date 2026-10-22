package com.larus.audio.call;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o extends p {
    public final Function0<Unit> g;

    @Override // com.larus.audio.call.p
    public final void c(long r1) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        this.g.invoke();
    }

    public o(long r2, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onFinish");
        super(r2, r2);
        this.g = r4;
    }
}
