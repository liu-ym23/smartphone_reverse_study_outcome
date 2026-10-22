package com.bytedance.privacy.e;

import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3019a = "f";

    static {
    }

    public f() {
    }

    public static String a(String r1) {
        return a(a(r1.getBytes(StandardCharsets.UTF_8), CryptoConst.ALGORITHM_SHA256));
    }

    public static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static byte[] a(byte[] r0, String r1) {
        MessageDigest r2 = MessageDigest.getInstance(r1);     // Catch: Exception -> L4
        r2.update(r0);     // Catch: Exception -> L4
        return r2.digest();
    L4:
        c.d(f3019a, "SHA256 failed.");
        return new byte[0];
    }
}
