package com.google.common.hash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes2.dex */
public final class Hashing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f4713a = 0;

    /* JADX INFO: renamed from: com.google.common.hash.Hashing$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static abstract enum ChecksumType extends Enum<ChecksumType> implements h<Checksum> {
        private static final /* synthetic */ ChecksumType[] $VALUES = null;
        public static final ChecksumType ADLER_32 = null;
        public static final ChecksumType CRC_32 = null;
        public final f hashFunction;

        private static /* synthetic */ ChecksumType[] $values() {
            return new ChecksumType[]{CRC_32, ADLER_32};
        }

        static {
            final String r1 = "CRC_32";
            final int r2 = 0;
            final String r3 = "Hashing.crc32()";
            CRC_32 = new AnonymousClass1(r1, r2, r3);
            final String r4 = "ADLER_32";
            final int r5 = 1;
            final String r6 = "Hashing.adler32()";
            ADLER_32 = new AnonymousClass2(r4, r5, r6);
            $VALUES = $values();
        }

        private ChecksumType(String r1, int r2, String r3) {
            super(r1, r2);
            this.hashFunction = new ChecksumHashFunction(this, 32, r3);
        }

        /* synthetic */ ChecksumType(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public static ChecksumType valueOf(String r2) {
            return (ChecksumType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChecksumType.class, r2), ChecksumType.class, "com.obric.memorydata.plugin");
        }

        public static ChecksumType[] values() {
            return (ChecksumType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChecksumType[].class, "com.obric.memorydata.plugin");
        }
    }

    private static abstract enum Crc32CSupplier extends Enum<Crc32CSupplier> implements h<f> {
        private static final /* synthetic */ Crc32CSupplier[] $VALUES = null;
        public static final Crc32CSupplier ABSTRACT_HASH_FUNCTION = null;
        static final f HASH_FUNCTION = null;

        private static /* synthetic */ Crc32CSupplier[] $values() {
            return new Crc32CSupplier[]{ABSTRACT_HASH_FUNCTION};
        }

        static {
            final String r1 = "ABSTRACT_HASH_FUNCTION";
            final int r2 = 0;
            ABSTRACT_HASH_FUNCTION = new AnonymousClass1(r1, r2);
            $VALUES = $values();
            HASH_FUNCTION = (f) ZeusTransformUtils.preCheckCast(values()[0].get(), f.class, "com.obric.memorydata.plugin");
        }

        private Crc32CSupplier(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Crc32CSupplier(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Crc32CSupplier valueOf(String r2) {
            return (Crc32CSupplier) ZeusTransformUtils.preCheckCast(Enum.valueOf(Crc32CSupplier.class, r2), Crc32CSupplier.class, "com.obric.memorydata.plugin");
        }

        public static Crc32CSupplier[] values() {
            return (Crc32CSupplier[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Crc32CSupplier[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f4713a = (int) System.currentTimeMillis();
    }

    public static f a() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }
}
