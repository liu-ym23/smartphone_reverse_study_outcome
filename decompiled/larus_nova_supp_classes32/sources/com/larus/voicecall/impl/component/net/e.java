package com.larus.voicecall.impl.component.net;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements a {
    @Override // com.larus.voicecall.impl.component.net.a
    public final String getLogTag() {
        return "NormalNetViewState";
    }

    public e() {
    }

    @Override // com.larus.voicecall.impl.component.net.a
    public final void a(int r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "transitionTo");
        if (r2 != 4) goto L6;
        r3.invoke(new f());
        return;
    L6:
        if (r2 < 5) goto L10;
        r3.invoke(new p());
        return;
    }
}
