package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Zstd {
    static {
        l6.a.m0();
    }

    public Zstd() {
    }

    public static native long errGeneric();

    public static final byte[] extractArray(ByteBuffer r8) {
        if (r8.hasArray() == false) goto L9;
        if (r8.arrayOffset() != 0) goto L9;
        return r8.array();
    L9:
        throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
    }

    public static native long getErrorCode(long r8);

    public static native String getErrorName(long r8);

    public static long getFunAddressBySymbol(String r8) {
        long[] r10 = getFunAddressesBySymbols(new String[]{r8});
        if (r10 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r10.length != 1) goto L7;
        return r10[0];
    }

    public static native long[] getFunAddressesBySymbols(String[] r8);

    public static native boolean isError(long r8);
}
