package com.bytedance.crypto.engine;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class HKDFHelper {
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    public HKDFHelper() {
    }

    public static byte[] deriveKey(byte[] r0, byte[] r1, byte[] r2) {
        return expand(extract(r1, r0), r2, 32);
    }

    private static byte[] expand(byte[] r8, byte[] r9, int r10) {
        Mac r1 = Mac.getInstance(HMAC_ALGORITHM);
        r1.init(new SecretKeySpec(r8, HMAC_ALGORITHM));
        byte[] r11 = new byte[r10];
        byte[] r2 = new byte[0];
        int r3 = (int) Math.ceil(((double) r10) / ((double) r1.getMacLength()));
        int r4 = 1;
        int r5 = 0;
    L3:
        if (r4 > r3) goto L5;
        r1.reset();
        r1.update(r2);
        r1.update(r9);
        r1.update((byte) r4);
        r2 = r1.doFinal();
        System.arraycopy(r2, 0, r11, r5, Math.min(r2.length, r10 - r5));
        r5 = r5 + r2.length;
        r4 = r4 + 1;
        goto L3
    L5:
        return r11;
    }

    private static byte[] extract(byte[] r3, byte[] r4) {
        if (r3 != null) goto L4;
    L5:
        r3 = new byte[32];
    L6:
        Mac r1 = Mac.getInstance(HMAC_ALGORITHM);
        r1.init(new SecretKeySpec(r3, HMAC_ALGORITHM));
        return r1.doFinal(r4);
    L4:
        if (r3.length != 0) goto L6;
        goto L5
    }
}
