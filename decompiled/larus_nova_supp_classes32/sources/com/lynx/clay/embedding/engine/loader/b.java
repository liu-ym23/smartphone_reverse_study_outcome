package com.lynx.clay.embedding.engine.loader;

import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;

    public b(String r1, String r2, String r3) {
        if (r1 != null) goto L5;
        r1 = "flutter_assets";
    L5:
        this.a = r1;
        this.c = r3;
        if (r2 != null) goto L8;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        this.b = r2;
    }
}
