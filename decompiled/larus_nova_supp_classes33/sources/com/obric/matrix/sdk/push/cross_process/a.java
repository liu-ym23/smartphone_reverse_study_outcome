package com.obric.matrix.sdk.push.cross_process;

import java.util.List;
import kka.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements jka.a {
    public a() {
    }

    public final void onCallback(List<Object> r3) {
        String r4 = "sdk event: " + r3;
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r4, "msg");
        b.a("", r4);
    }
}
