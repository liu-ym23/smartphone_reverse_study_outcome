package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("cronet")
public class TTCompressManager {

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType BROTLI = null;
        public static final CompressType GZIP = null;
        public static final CompressType ZSTD = null;
        final int mType;

        static {
            CompressType r0 = new CompressType("GZIP", 0, 1);
            GZIP = r0;
            CompressType r1 = new CompressType("BROTLI", 1, 2);
            BROTLI = r1;
            CompressType r4 = new CompressType("ZSTD", 2, 3);
            ZSTD = r4;
            $VALUES = new CompressType[]{r0, r1, r4};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.mType = r3;
        }

        public static CompressType valueOf(String r2) {
            return (CompressType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CompressType.class, r2), CompressType.class, "com.obric.memorydata.plugin");
        }

        public static CompressType[] values() {
            return (CompressType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CompressType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.mType;
        }
    }

    public TTCompressManager() {
    }

    public static byte[] compressData(byte[] r0, int r1, int r2, CompressType r3) {
        return nativeCompressData(r0, r1, r2, r3.getValue());
    }

    public static byte[] decompressData(byte[] r0, int r1, CompressType r2) {
        return nativeDecompressData(r0, r1, r2.getValue());
    }

    private static native byte[] nativeCompressData(byte[] r0, int r1, int r2, int r3);

    private static native byte[] nativeDecompressData(byte[] r0, int r1, int r2);
}
