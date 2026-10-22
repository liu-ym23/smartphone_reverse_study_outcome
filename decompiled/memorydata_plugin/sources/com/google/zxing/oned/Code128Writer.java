package com.google.zxing.oned;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class Code128Writer extends a {

    private static final enum CType extends Enum<CType> {
        private static final /* synthetic */ CType[] $VALUES = null;
        public static final CType FNC_1 = null;
        public static final CType ONE_DIGIT = null;
        public static final CType TWO_DIGITS = null;
        public static final CType UNCODABLE = null;

        static {
            CType r0 = new CType("UNCODABLE", 0);
            UNCODABLE = r0;
            CType r1 = new CType("ONE_DIGIT", 1);
            ONE_DIGIT = r1;
            CType r3 = new CType("TWO_DIGITS", 2);
            TWO_DIGITS = r3;
            CType r5 = new CType("FNC_1", 3);
            FNC_1 = r5;
            $VALUES = new CType[]{r0, r1, r3, r5};
        }

        private CType(String r1, int r2) {
            super(r1, r2);
        }

        public static CType valueOf(String r2) {
            return (CType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CType.class, r2), CType.class, "com.obric.memorydata.plugin");
        }

        public static CType[] values() {
            return (CType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CType[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final class MinimalEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f5085a = false;

        private static final enum Charset extends Enum<Charset> {
            private static final /* synthetic */ Charset[] $VALUES = null;
            public static final Charset A = null;
            public static final Charset B = null;
            public static final Charset C = null;
            public static final Charset NONE = null;

            static {
                Charset r0 = new Charset(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
                A = r0;
                Charset r1 = new Charset("B", 1);
                B = r1;
                Charset r3 = new Charset("C", 2);
                C = r3;
                Charset r5 = new Charset("NONE", 3);
                NONE = r5;
                $VALUES = new Charset[]{r0, r1, r3, r5};
            }

            private Charset(String r1, int r2) {
                super(r1, r2);
            }

            public static Charset valueOf(String r2) {
                return (Charset) ZeusTransformUtils.preCheckCast(Enum.valueOf(Charset.class, r2), Charset.class, "com.obric.memorydata.plugin");
            }

            public static Charset[] values() {
                return (Charset[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Charset[].class, "com.obric.memorydata.plugin");
            }
        }

        private static final enum Latch extends Enum<Latch> {
            private static final /* synthetic */ Latch[] $VALUES = null;
            public static final Latch A = null;
            public static final Latch B = null;
            public static final Latch C = null;
            public static final Latch NONE = null;
            public static final Latch SHIFT = null;

            static {
                Latch r0 = new Latch(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
                A = r0;
                Latch r1 = new Latch("B", 1);
                B = r1;
                Latch r3 = new Latch("C", 2);
                C = r3;
                Latch r5 = new Latch("SHIFT", 3);
                SHIFT = r5;
                Latch r7 = new Latch("NONE", 4);
                NONE = r7;
                $VALUES = new Latch[]{r0, r1, r3, r5, r7};
            }

            private Latch(String r1, int r2) {
                super(r1, r2);
            }

            public static Latch valueOf(String r2) {
                return (Latch) ZeusTransformUtils.preCheckCast(Enum.valueOf(Latch.class, r2), Latch.class, "com.obric.memorydata.plugin");
            }

            public static Latch[] values() {
                return (Latch[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Latch[].class, "com.obric.memorydata.plugin");
            }
        }

        static {
            f5085a = true;
        }
    }

    public Code128Writer() {
    }
}
