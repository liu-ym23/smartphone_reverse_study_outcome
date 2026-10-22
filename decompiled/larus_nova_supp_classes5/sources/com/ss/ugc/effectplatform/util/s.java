package com.ss.ugc.effectplatform.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s {
    public static final String a(String[] r4) {
        int r0 = r4.length - 1;
        if (r0 != (-1)) goto L6;
        return "[]";
    L6:
        StringBuilder r1 = new StringBuilder("[");
        int r2 = 0;
    L7:
        r1.append(r4[r2]);
        if (r2 == r0) goto L9;
        r1.append(", ");
        r2 = r2 + 1;
        goto L7
    L9:
        r1.append(']');
        return r1.toString();
    }
}
