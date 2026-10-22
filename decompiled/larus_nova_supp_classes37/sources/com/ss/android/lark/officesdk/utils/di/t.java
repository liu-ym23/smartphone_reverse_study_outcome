package com.ss.android.lark.officesdk.utils.di;

import java.security.SecureRandom;
import java.util.UUID;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t {
    public static final ThreadLocal<String> a = null;
    public static final ThreadLocal<SecureRandom> b = null;

    static {
        a = new ThreadLocal();
        b = new ThreadLocal();
    }

    @JvmStatic
    public static final UUID a() {
        ThreadLocal<SecureRandom> r0 = b;
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
        r2[8] = (byte) (r4 | (-128));
        int r5 = 0;
        long r6 = 0;
    L7:
        if (r5 >= 8) goto L9;
        r6 = (r6 << 8) | (255 & (((long) r2[r5]) + 0));
        r5 = r5 + 1;
        goto L7
    L9:
        long r10 = 0;
        int r7 = 8;
    L10:
        if (r7 >= 16) goto L13;
        r10 = (r10 << 8) | ((((long) r2[r7]) + 0) & 255);
        r7 = r7 + 1;
        goto L10
    L13:
        return new UUID(r6, r10);
    }
}
