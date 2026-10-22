package com.larus.dora.impl.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public static String a(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() == 17) goto L7;
        return null;
    L7:
        return "XX:XX:XX:XX" + r2.substring(11);
    }
}
