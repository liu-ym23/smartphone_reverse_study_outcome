package com.google.crypto.tink.subtle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;

/* JADX INFO: loaded from: classes2.dex */
public final class EllipticCurves {

    public static final enum CurveType extends Enum<CurveType> {
        private static final /* synthetic */ CurveType[] $VALUES = null;
        public static final CurveType NIST_P256 = null;
        public static final CurveType NIST_P384 = null;
        public static final CurveType NIST_P521 = null;

        static {
            CurveType r0 = new CurveType("NIST_P256", 0);
            NIST_P256 = r0;
            CurveType r1 = new CurveType("NIST_P384", 1);
            NIST_P384 = r1;
            CurveType r3 = new CurveType("NIST_P521", 2);
            NIST_P521 = r3;
            $VALUES = new CurveType[]{r0, r1, r3};
        }

        private CurveType(String r1, int r2) {
            super(r1, r2);
        }

        public static CurveType valueOf(String r2) {
            return (CurveType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CurveType.class, r2), CurveType.class, "com.obric.memorydata.plugin");
        }

        public static CurveType[] values() {
            return (CurveType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CurveType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EcdsaEncoding extends Enum<EcdsaEncoding> {
        private static final /* synthetic */ EcdsaEncoding[] $VALUES = null;
        public static final EcdsaEncoding DER = null;
        public static final EcdsaEncoding IEEE_P1363 = null;

        static {
            EcdsaEncoding r0 = new EcdsaEncoding("IEEE_P1363", 0);
            IEEE_P1363 = r0;
            EcdsaEncoding r1 = new EcdsaEncoding("DER", 1);
            DER = r1;
            $VALUES = new EcdsaEncoding[]{r0, r1};
        }

        private EcdsaEncoding(String r1, int r2) {
            super(r1, r2);
        }

        public static EcdsaEncoding valueOf(String r2) {
            return (EcdsaEncoding) ZeusTransformUtils.preCheckCast(Enum.valueOf(EcdsaEncoding.class, r2), EcdsaEncoding.class, "com.obric.memorydata.plugin");
        }

        public static EcdsaEncoding[] values() {
            return (EcdsaEncoding[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EcdsaEncoding[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PointFormatType extends Enum<PointFormatType> {
        private static final /* synthetic */ PointFormatType[] $VALUES = null;
        public static final PointFormatType COMPRESSED = null;
        public static final PointFormatType DO_NOT_USE_CRUNCHY_UNCOMPRESSED = null;
        public static final PointFormatType UNCOMPRESSED = null;

        static {
            PointFormatType r0 = new PointFormatType("UNCOMPRESSED", 0);
            UNCOMPRESSED = r0;
            PointFormatType r1 = new PointFormatType("COMPRESSED", 1);
            COMPRESSED = r1;
            PointFormatType r3 = new PointFormatType("DO_NOT_USE_CRUNCHY_UNCOMPRESSED", 2);
            DO_NOT_USE_CRUNCHY_UNCOMPRESSED = r3;
            $VALUES = new PointFormatType[]{r0, r1, r3};
        }

        private PointFormatType(String r1, int r2) {
            super(r1, r2);
        }

        public static PointFormatType valueOf(String r2) {
            return (PointFormatType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PointFormatType.class, r2), PointFormatType.class, "com.obric.memorydata.plugin");
        }

        public static PointFormatType[] values() {
            return (PointFormatType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PointFormatType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static BigInteger a(EllipticCurve r0) {
        return com.google.crypto.tink.internal.a.a(r0);
    }

    public static boolean a(ECParameterSpec r0) {
        return com.google.crypto.tink.internal.a.a(r0);
    }

    public static int b(EllipticCurve r1) {
        return a(r1).subtract(BigInteger.ONE).bitLength();
    }
}
