package org.apache.commons.codec.digest;

import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class HmacUtils {
    private final Mac mac;

    private HmacUtils(Mac r1) {
        this.mac = r1;
    }

    public byte[] hmac(byte[] r2) {
        return this.mac.doFinal(r2);
    }

    public HmacUtils(String r1, byte[] r2) {
        this(getInitializedMac(r1, r2));
    }

    public static Mac getInitializedMac(String r1, byte[] r2) {
        if (r2 == null) goto L11;
        SecretKeySpec r0 = new SecretKeySpec(r2, r1);     // Catch: InvalidKeyException -> L5 Throwable -> L7
        Mac r3 = Mac.getInstance(r1);     // Catch: InvalidKeyException -> L5 Throwable -> L7
        r3.init(r0);     // Catch: InvalidKeyException -> L5 Throwable -> L7
        return r3;
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L11:
        throw new IllegalArgumentException("Null key");
    }

    public HmacUtils(HmacAlgorithms r1, byte[] r2) {
        this(r1.getName(), r2);
    }
}
