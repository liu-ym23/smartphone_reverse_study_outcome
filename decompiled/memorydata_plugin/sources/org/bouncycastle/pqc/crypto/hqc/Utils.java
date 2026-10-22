package org.bouncycastle.pqc.crypto.hqc;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static int getByte64SizeFromBitSize(int r0) {
        return (r0 + 63) / 64;
    }

    static int getByteSizeFromBitSize(int r0) {
        return (r0 + 7) / 8;
    }
}
