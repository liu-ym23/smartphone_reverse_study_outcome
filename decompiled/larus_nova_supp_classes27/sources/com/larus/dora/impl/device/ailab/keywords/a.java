package com.larus.dora.impl.device.ailab.keywords;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static final String a(DoraWakeupKeywords r3, String r4) {
        List<DoraWakeupKeyword> r5 = r3.getWakeupKeywords();
        DoraWakeupKeyword r0 = null;
        Object r1 = null;
        if (r5 == null) goto L16;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r2 = r6.next();
        DoraWakeupKeyword r7 = (DoraWakeupKeyword) r2;
        if (r7 == null) goto L10;
        String r8 = r7.getKeyword();
    L12:
        if (Intrinsics.areEqual(r8, r4) == false) goto L6;
        r1 = r2;
        goto L14
    L10:
        r8 = null;
    L14:
        r0 = (DoraWakeupKeyword) r1;
    L16:
        if (r0 == null) goto L35;
        Integer r9 = r0.getStatus();
        if (r9 != null) goto L22;
    L24:
        if (r9 != null) goto L27;
        return "none";
    L27:
        if (r9.intValue() != 0) goto L34;
        return "off";
    L34:
        return "none";
    L22:
        if (r9.intValue() != 1) goto L24;
        return "on";
    L35:
        return "none";
    }
}
