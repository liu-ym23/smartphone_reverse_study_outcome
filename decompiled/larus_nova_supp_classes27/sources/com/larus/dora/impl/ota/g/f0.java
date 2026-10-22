package com.larus.dora.impl.ota.g;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 {
    public static final boolean a(String r3, String r4, String r5) {
        if (r4 != null) goto L5;
    L11:
        if (r5 != null) goto L13;
    L15:
        r5 = null;
    L16:
        if (r5 != null) goto L18;
    L20:
        return false;
    L18:
        if (Intrinsics.areEqual(r3, r5) == false) goto L20;
        return true;
    L13:
        if ((!StringsKt.isBlank(r5)) == false) goto L15;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        r5 = r4;
        goto L16
    }

    public static final u.c b(boolean r1, d49.a r2, d49.a r3) {
        Intrinsics.checkNotNullParameter(r3, "current");
        u.c r0 = u.c.a;
        if (r1 == true) goto L5;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L16;
        return null;
    L16:
        return r0;
    L5:
        if ((r2 instanceof d49.a.m) == true) goto L11;
        if ((r3 instanceof d49.a.m) == false) goto L11;
        if (Intrinsics.areEqual(((d49.a.m) r3).d, "PERIPHERAL_LOW_BATTERY".toLowerCase(Locale.ROOT)) == false) goto L11;
        r4 = true;
        goto L12
    }
}
