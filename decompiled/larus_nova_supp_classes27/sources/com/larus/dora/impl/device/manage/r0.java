package com.larus.dora.impl.device.manage;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r0 {
    public static final boolean a(Integer r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (new IntRange(0, 100).contains(r3.intValue()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static final String b(Integer r1) {
        if (a(r1) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        r0.append('%');
        return r0.toString();
    L5:
        return "-";
    }
}
