package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class EC5Util {

    private static class CustomCurves {
        private static Map CURVE_MAP;

        static {
            CURVE_MAP = createCurveMap();
        }

        private static Map createCurveMap() {
            HashMap r0 = new HashMap();
            Enumeration r1 = CustomNamedCurves.getNames();
        L4:
            if (r1.hasMoreElements() == false) goto L10;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r1.nextElement(), String.class, "com.obric.memorydata.plugin");
            X9ECParametersHolder r3 = ECNamedCurveTable.getByNameLazy(r2);
            if (r3 == null) goto L4;
            ECCurve r4 = r3.getCurve();
            if (ECAlgorithms.isFpCurve(r4) == false) goto L4;
            r0.put(r4, CustomNamedCurves.getByNameLazy(r2).getCurve());
            goto L4
        L10:
            ECCurve r5 = CustomNamedCurves.getByNameLazy("Curve25519").getCurve();
            r0.put(new ECCurve.Fp(r5.getField().getCharacteristic(), r5.getA().toBigInteger(), r5.getB().toBigInteger(), r5.getOrder(), r5.getCofactor(), true), r5);
            return r0;
        }

        static ECCurve substitute(ECCurve r3) {
            ECCurve r0 = (ECCurve) ZeusTransformUtils.preCheckCast(CURVE_MAP.get(r3), ECCurve.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return r3;
        L5:
            return r0;
        }
    }

    public static EllipticCurve convertCurve(ECCurve r3, byte[] r4) {
        return new EllipticCurve(convertField(r3.getField()), r3.getA().toBigInteger(), r3.getB().toBigInteger(), null);
    }

    public static ECCurve convertCurve(EllipticCurve r8) {
        ECField r0 = r8.getField();
        BigInteger r6 = r8.getA();
        BigInteger r7 = r8.getB();
        if (ZeusTransformUtils.instanceOf(r0, ECFieldFp.class) == true) goto L5;
        ECFieldF2m r9 = (ECFieldF2m) ZeusTransformUtils.preCheckCast(r0, ECFieldF2m.class, "com.obric.memorydata.plugin");
        int r2 = r9.getM();
        int[] r10 = ECUtil.convertMidTerms(r9.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(r2, r10[0], r10[1], r10[2], r6, r7);
    L5:
        return CustomCurves.substitute(new ECCurve.Fp(((ECFieldFp) ZeusTransformUtils.preCheckCast(r0, ECFieldFp.class, "com.obric.memorydata.plugin")).getP(), r6, r7));
    }

    public static ECField convertField(FiniteField r3) {
        FiniteField r4 = (FiniteField) ZeusTransformUtils.wrapperContextForParams(r3, FiniteField.class, "com.obric.memorydata.plugin");
        if (ECAlgorithms.isFpField(r4) == true) goto L5;
        Polynomial r5 = ((PolynomialExtensionField) ZeusTransformUtils.preCheckCast(r4, PolynomialExtensionField.class, "com.obric.memorydata.plugin")).getMinimalPolynomial();
        int[] r0 = r5.getExponentsPresent();
        int[] r1 = Arrays.reverseInPlace(Arrays.copyOfRange(r0, 1, r0.length - 1));
        return new ECFieldF2m(r5.getDegree(), r1);
    L5:
        return new ECFieldFp(r4.getCharacteristic());
    }

    public static ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint r2) {
        org.bouncycastle.math.ec.ECPoint r3 = r2.normalize();
        return new ECPoint(r3.getAffineXCoord().toBigInteger(), r3.getAffineYCoord().toBigInteger());
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECParameterSpec r0, ECPoint r1) {
        return convertPoint(convertCurve(r0.getCurve()), r1);
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve r1, ECPoint r2) {
        return r1.createPoint(r2.getAffineX(), r2.getAffineY());
    }

    public static ECParameterSpec convertSpec(EllipticCurve r7, org.bouncycastle.jce.spec.ECParameterSpec r8) {
        ECPoint r4 = convertPoint(r8.getG());
        if (ZeusTransformUtils.instanceOf(r8, ECNamedCurveParameterSpec.class) == false) goto L7;
        return new ECNamedCurveSpec(((ECNamedCurveParameterSpec) ZeusTransformUtils.preCheckCast(r8, ECNamedCurveParameterSpec.class, "com.obric.memorydata.plugin")).getName(), r7, r4, r8.getN(), r8.getH());
    L7:
        return new ECParameterSpec(r7, r4, r8.getN(), r8.getH().intValue());
    }

    public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec r9) {
        ECCurve r0 = convertCurve(r9.getCurve());
        org.bouncycastle.math.ec.ECPoint r4 = convertPoint(r0, r9.getGenerator());
        BigInteger r5 = r9.getOrder();
        BigInteger r6 = BigInteger.valueOf(r9.getCofactor());
        byte[] r7 = r9.getCurve().getSeed();
        if (ZeusTransformUtils.instanceOf(r9, ECNamedCurveSpec.class) == false) goto L7;
        return new ECNamedCurveParameterSpec(((ECNamedCurveSpec) ZeusTransformUtils.preCheckCast(r9, ECNamedCurveSpec.class, "com.obric.memorydata.plugin")).getName(), r0, r4, r5, r6, r7);
    L7:
        return new org.bouncycastle.jce.spec.ECParameterSpec(r0, r4, r5, r6, r7);
    }

    public static ECParameterSpec convertToSpec(X962Parameters r8, ECCurve r9) {
        if (r8.isNamedCurve() == false) goto L11;
        ASN1ObjectIdentifier r10 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r8.getParameters(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        X9ECParameters r0 = ECUtil.getNamedCurveByOid(r10);
        if (r0 != null) goto L9;
        Map r2 = BouncyCastleProvider.CONFIGURATION.getAdditionalECParameters();
        if (r2.isEmpty() == true) goto L9;
        r0 = (X9ECParameters) ZeusTransformUtils.preCheckCast(r2.get(r10), X9ECParameters.class, "com.obric.memorydata.plugin");
    L9:
        EllipticCurve r4 = convertCurve(r9, r0.getSeed());
        return new ECNamedCurveSpec(ECUtil.getCurveName(r10), r4, convertPoint(r0.getG()), r0.getN(), r0.getH());
    L11:
        if (r8.isImplicitlyCA() == false) goto L13;
        return null;
    L13:
        ASN1Sequence r11 = ASN1Sequence.getInstance(r8.getParameters());
        if (r11.size() <= 3) goto L19;
        X9ECParameters r12 = X9ECParameters.getInstance(r11);
        EllipticCurve r13 = convertCurve(r9, r12.getSeed());
        if (r12.getH() == null) goto L18;
        ECParameterSpec r1 = new ECParameterSpec(r13, convertPoint(r12.getG()), r12.getN(), r12.getH().intValue());
    L21:
        return r1;
    L18:
        r1 = new ECParameterSpec(r13, convertPoint(r12.getG()), r12.getN(), 1);
        goto L21
    L19:
        GOST3410PublicKeyAlgParameters r14 = GOST3410PublicKeyAlgParameters.getInstance(r11);
        ECNamedCurveParameterSpec r15 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r14.getPublicKeyParamSet()));
        EllipticCurve r5 = convertCurve(r15.getCurve(), r15.getSeed());
        r1 = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(r14.getPublicKeyParamSet()), r5, convertPoint(r15.getG()), r15.getN(), r15.getH());
        goto L21
    }

    public static ECParameterSpec convertToSpec(X9ECParameters r4) {
        return new ECParameterSpec(convertCurve(r4.getCurve(), null), convertPoint(r4.getG()), r4.getN(), r4.getH().intValue());
    }

    public static ECCurve getCurve(ProviderConfiguration r3, X962Parameters r4) {
        ProviderConfiguration r5 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r3, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        Set r0 = r5.getAcceptableNamedCurves();
        if (r4.isNamedCurve() == false) goto L16;
        ASN1ObjectIdentifier r6 = ASN1ObjectIdentifier.getInstance(r4.getParameters());
        if (r0.isEmpty() == false) goto L7;
    L11:
        X9ECParameters r1 = ECUtil.getNamedCurveByOid(r6);
        if (r1 != null) goto L28;
        r1 = (X9ECParameters) ZeusTransformUtils.preCheckCast(r5.getAdditionalECParameters().get(r6), X9ECParameters.class, "com.obric.memorydata.plugin");
    L28:
        return r1.getCurve();
    L7:
        if (r0.contains(r6) == true) goto L11;
        throw new IllegalStateException("named curve not acceptable");
    L16:
        if (r4.isImplicitlyCA() == true) goto L29;
        ASN1Sequence r7 = ASN1Sequence.getInstance(r4.getParameters());
        if (r0.isEmpty() == false) goto L27;
        if (r7.size() <= 3) goto L23;
        X9ECParameters r8 = X9ECParameters.getInstance(r7);
    L25:
        return r8.getCurve();
    L23:
        r8 = ECGOST3410NamedCurves.getByOIDX9(ASN1ObjectIdentifier.getInstance(r7.getObjectAt(0)));
        goto L25
    L27:
        throw new IllegalStateException("encoded parameters not acceptable");
    L29:
        return r5.getEcImplicitlyCa().getCurve();
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration r6, ECParameterSpec r7) {
        ProviderConfiguration r8 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        org.bouncycastle.jce.spec.ECParameterSpec r9 = r8.getEcImplicitlyCa();
        return new ECDomainParameters(r9.getCurve(), r9.getG(), r9.getN(), r9.getH(), r9.getSeed());
    L6:
        return ECUtil.getDomainParameters(r8, convertSpec(r7));
    }
}
