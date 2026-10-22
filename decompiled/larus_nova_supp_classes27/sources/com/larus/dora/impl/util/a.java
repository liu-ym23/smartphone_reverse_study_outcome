package com.larus.dora.impl.util;

import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static String a(byte[] r6) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L11
        r0.update(r6);     // Catch: Exception -> L11
        byte[] r7 = r0.digest();     // Catch: Exception -> L11
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L11
        int r2 = r7.length;     // Catch: Exception -> L11
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = Integer.toHexString(r7[r3] & 255);     // Catch: Exception -> L11
    L6:
        if (r4.length() >= 2) goto L8;
        r4 = "0" + r4;     // Catch: Exception -> L11
        goto L6
    L8:
        r1.append(r4);     // Catch: Exception -> L11
        r3 = r3 + 1;     // Catch: Exception -> L11
        goto L3
    L9:
        return r1.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
