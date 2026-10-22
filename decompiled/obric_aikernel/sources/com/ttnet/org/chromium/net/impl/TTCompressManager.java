package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public class TTCompressManager {

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType BROTLI = null;
        public static final CompressType GZIP = null;
        public static final CompressType ZSTD = null;
        final int mType;

        static {
            CompressType r10 = new CompressType("GZIP", 0, 1);
            GZIP = r10;
            CompressType r11 = new CompressType("BROTLI", 1, 2);
            BROTLI = r11;
            CompressType r12 = new CompressType("ZSTD", 2, 3);
            ZSTD = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.mType = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mType;
        }
    }

    public TTCompressManager() {
    }

    public static byte[] compressData(byte[] r10, int r11, int r12, CompressType r13) {
        return nativeCompressData(r10, r11, r12, r13.getValue());
    }

    public static byte[] decompressData(byte[] r10, int r11, CompressType r12) {
        return nativeDecompressData(r10, r11, r12.getValue());
    }

    private static native byte[] nativeCompressData(byte[] r10, int r11, int r12, int r13);

    private static native byte[] nativeDecompressData(byte[] r10, int r11, int r12);
}
