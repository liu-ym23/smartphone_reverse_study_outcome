package com.larksuite.framework.utils;

import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l0 {
    public static final ThreadLocal<SecureRandom> a = null;

    static {
        a = new ThreadLocal();
    }

    public static UUID a() {
        ThreadLocal<SecureRandom> r0 = a;
        SecureRandom r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new SecureRandom();
        r0.set(r1);
    L5:
        byte[] r2 = new byte[16];
        r1.nextBytes(r2);
        byte r3 = (byte) (r2[6] & 15);
        r2[6] = r3;
        r2[6] = (byte) (r3 | 64);
        byte r4 = (byte) (r2[8] & 63);
        r2[8] = r4;
        r2[8] = (byte) (r4 | 128);
        long r5 = 0;
        int r6 = 0;
        long r7 = 0;
    L6:
        if (r6 >= 8) goto L8;
        r7 = (r7 << 8) | ((long) (r2[r6] & 255));
        r6 = r6 + 1;
        goto L6
    L8:
        int r8 = 8;
    L9:
        if (r8 >= 16) goto L12;
        r5 = (r5 << 8) | ((long) (r2[r8] & 255));
        r8 = r8 + 1;
        goto L9
    L12:
        return new UUID(r7, r5);
    }
}
