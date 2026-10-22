package com.ss.ugc.effectplatform.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(String r2) {
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r3 = false;
        goto L8
    }

    public static boolean a(String r1, String r2) {
        if (b(r1) == false) goto L9;
        if (b(r2) == false) goto L9;
        return true;
    L9:
        return Intrinsics.areEqual(r1, r2);
    }
}
