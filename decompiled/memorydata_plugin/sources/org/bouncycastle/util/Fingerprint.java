package org.bouncycastle.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes7.dex */
public class Fingerprint {
    private static char[] encodingTable;
    private final byte[] fingerprint;

    static {
        encodingTable = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public Fingerprint(byte[] r2) {
        this(r2, 160);
    }

    public Fingerprint(byte[] r1, int r2) {
        this.fingerprint = calculateFingerprint(r1, r2);
    }

    public static byte[] calculateFingerprint(byte[] r3, int r4) {
        if ((r4 % 8) != 0) goto L7;
        SHAKEDigest r0 = new SHAKEDigest(256);
        r0.update(r3, 0, r3.length);
        int r5 = r4 / 8;
        byte[] r6 = new byte[r5];
        r0.doFinal(r6, 0, r5);
        return r6;
    L7:
        throw new IllegalArgumentException("bitLength must be a multiple of 8");
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Fingerprint.class) == true) goto L9;
        return false;
    L9:
        return Arrays.areEqual(((Fingerprint) ZeusTransformUtils.preCheckCast(r3, Fingerprint.class, "com.obric.memorydata.plugin")).fingerprint, this.fingerprint);
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L4:
        if (r1 == this.fingerprint.length) goto L9;
        if (r1 <= 0) goto L7;
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
    L7:
        r0.append(encodingTable[(this.fingerprint[r1] >>> 4) & 15]);
        r0.append(encodingTable[this.fingerprint[r1] & 15]);
        r1 = r1 + 1;
        goto L4
    L9:
        return r0.toString();
    }
}
