package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static u a(s1 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "usageEvidence");
        boolean r1 = r4.a;
        boolean r2 = r4.b;
        if (r4.d == false) goto L5;
    L8:
        boolean r6 = true;
    L10:
        return new u(r1, r2, r6, r5);
    L5:
        if (r4.c == true) goto L8;
        r6 = false;
        goto L10
    }
}
