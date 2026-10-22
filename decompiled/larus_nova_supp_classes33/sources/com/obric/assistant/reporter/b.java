package com.obric.assistant.reporter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    static {
    }

    public b() {
    }

    public static void a(String r1, String r2, int r3) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        boolean r4 = true;
    L9:
        Intrinsics.checkNotNullParameter(r1, "launchMethod");
        IObricReporter.a.getClass();
        IObricReporter r0 = IObricReporter.a.a();
        if (r0 == null) goto L16;
        if (r2 != null) goto L14;
        r2 = r0.l();
    L14:
        r0.n(r1, r2, r4);
        return;
    L16:
        return;
    L8:
        r4 = false;
        goto L9
    }
}
