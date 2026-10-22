package org.bouncycastle.crypto.params;

import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class DESParameters extends KeyParameter {
    private static byte[] DES_weak_keys;

    static {
        DES_weak_keys = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, 14, 14, 14, 14, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, MessagePack.Code.NEGFIXINT_PREFIX, 31, MessagePack.Code.NEGFIXINT_PREFIX, 14, -15, 14, -15, 1, MessagePack.Code.NEGFIXINT_PREFIX, 1, MessagePack.Code.NEGFIXINT_PREFIX, 1, -15, 1, -15, 31, -2, 31, -2, 14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 1, 14, MessagePack.Code.NEGFIXINT_PREFIX, -2, MessagePack.Code.NEGFIXINT_PREFIX, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, MessagePack.Code.NEGFIXINT_PREFIX, 31, MessagePack.Code.NEGFIXINT_PREFIX, 31, -15, 14, -15, 14, MessagePack.Code.NEGFIXINT_PREFIX, 1, MessagePack.Code.NEGFIXINT_PREFIX, 1, -15, 1, -15, 1, -2, 31, -2, 31, -2, 14, -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, -2, MessagePack.Code.NEGFIXINT_PREFIX, -2, MessagePack.Code.NEGFIXINT_PREFIX, -2, -15, -2, -15};
    }

    public static void setOddParity(byte[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        byte r1 = r5[r0];
        int r2 = r1 & 254;
        int r3 = (((((r1 >> 1) ^ (r1 >> 2)) ^ (r1 >> 3)) ^ (r1 >> 4)) ^ (r1 >> 5)) ^ (r1 >> 6);
        r5[r0] = (byte) (((((r1 >> 7) ^ r3) ^ 1) & 1) | r2);
        r0 = r0 + 1;
        goto L4
    }
}
