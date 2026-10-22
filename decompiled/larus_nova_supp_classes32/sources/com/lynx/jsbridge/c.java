package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.core.JSProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final String a;
    public final JSProxy b;

    public c(String r1, JSProxy r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r3, JavaOnlyArray r4) {
        if (r4 != null) goto L5;
        r4 = new JavaOnlyArray();
    L5:
        this.b.b(this.a, r3, r4);
    }
}
