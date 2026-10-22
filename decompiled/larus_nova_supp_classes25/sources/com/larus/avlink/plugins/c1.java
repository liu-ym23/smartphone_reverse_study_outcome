package com.larus.avlink.plugins;

import com.larus.audio.call.plugins.CommonHelloPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c1 extends CommonHelloPlugin<n4> {
    public final String n;

    public final boolean b1() {
        return j3();
    }

    public final String T2() {
        return this.n;
    }

    public c1(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.n = "DoraHelloPlugin";
    }
}
