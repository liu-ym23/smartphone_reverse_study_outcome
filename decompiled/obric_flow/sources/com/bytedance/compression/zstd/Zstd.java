package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class Zstd {
    static {
        u8.a.w();
    }

    public Zstd() {
    }

    public static native long errGeneric();

    public static final byte[] extractArray(ByteBuffer r5) {
        if (r5.hasArray() == false) goto L9;
        if (r5.arrayOffset() != 0) goto L9;
        return r5.array();
    L9:
        throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
    }

    public static native long getErrorCode(long r5);

    public static native String getErrorName(long r5);

    public static long getFunAddressBySymbol(String r5) {
        long[] r10 = getFunAddressesBySymbols(new String[]{r5});
        if (r10 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r10.length != 1) goto L7;
        return r10[0];
    }

    public static native long[] getFunAddressesBySymbols(String[] r5);

    public static native boolean isError(long r5);
}
