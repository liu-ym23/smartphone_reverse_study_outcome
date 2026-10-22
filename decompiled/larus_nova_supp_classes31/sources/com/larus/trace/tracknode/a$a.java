package com.larus.trace.tracknode;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a$a {
    public static void a(a r1, TrackParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        String r3 = r1.k();
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r2.put("current_page", r3);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
