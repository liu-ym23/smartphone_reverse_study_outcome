package com.ttnet.org.chromium.net.impl;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum TTCompressManager$CompressType extends Enum<TTCompressManager$CompressType> {
    private static final /* synthetic */ TTCompressManager$CompressType[] $VALUES = null;
    public static final TTCompressManager$CompressType BROTLI = null;
    public static final TTCompressManager$CompressType GZIP = null;
    public static final TTCompressManager$CompressType ZSTD = null;
    final int mType;

    static {
        TTCompressManager$CompressType r0 = new TTCompressManager$CompressType("GZIP", 0, 1);
        GZIP = r0;
        TTCompressManager$CompressType r1 = new TTCompressManager$CompressType("BROTLI", 1, 2);
        BROTLI = r1;
        TTCompressManager$CompressType r4 = new TTCompressManager$CompressType("ZSTD", 2, 3);
        ZSTD = r4;
        $VALUES = new TTCompressManager$CompressType[]{r0, r1, r4};
    }

    public static TTCompressManager$CompressType[] values() {
        return (TTCompressManager$CompressType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.mType;
    }

    public static TTCompressManager$CompressType valueOf(String r1) {
        return (TTCompressManager$CompressType) a.a(TTCompressManager$CompressType.class, r1);
    }

    private TTCompressManager$CompressType(String r1, int r2, int r3) {
        super(r1, r2);
        this.mType = r3;
    }
}
