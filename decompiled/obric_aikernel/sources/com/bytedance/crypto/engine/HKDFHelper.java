package com.bytedance.crypto.engine;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class HKDFHelper {
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    public HKDFHelper() {
    }

    public static byte[] deriveKey(byte[] r10, byte[] r11, byte[] r12) {
        return expand(extract(r11, r10), r12, 32);
    }

    private static byte[] expand(byte[] r10, byte[] r11, int r12) {
        Mac r13 = Mac.getInstance(HMAC_ALGORITHM);
        r13.init(new SecretKeySpec(r10, HMAC_ALGORITHM));
        byte[] r14 = new byte[r12];
        byte[] r15 = new byte[0];
        int r16 = (int) Math.ceil(((double) r12) / ((double) r13.getMacLength()));
        int r17 = 1;
        int r18 = 0;
    L3:
        if (r17 > r16) goto L5;
        r13.reset();
        r13.update(r15);
        r13.update(r11);
        r13.update((byte) r17);
        r15 = r13.doFinal();
        System.arraycopy(r15, 0, r14, r18, Math.min(r15.length, r12 - r18));
        r18 = r18 + r15.length;
        r17 = r17 + 1;
        goto L3
    L5:
        return r14;
    }

    private static byte[] extract(byte[] r10, byte[] r11) {
        if (r10 != null) goto L4;
    L5:
        r10 = new byte[32];
    L6:
        Mac r12 = Mac.getInstance(HMAC_ALGORITHM);
        r12.init(new SecretKeySpec(r10, HMAC_ALGORITHM));
        return r12.doFinal(r11);
    L4:
        if (r10.length != 0) goto L6;
        goto L5
    }
}
