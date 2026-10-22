package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes7.dex */
public class X509Extension {
    public static final ASN1ObjectIdentifier auditIdentity = null;
    public static final ASN1ObjectIdentifier authorityInfoAccess = null;
    public static final ASN1ObjectIdentifier authorityKeyIdentifier = null;
    public static final ASN1ObjectIdentifier basicConstraints = null;
    public static final ASN1ObjectIdentifier biometricInfo = null;
    public static final ASN1ObjectIdentifier cRLDistributionPoints = null;
    public static final ASN1ObjectIdentifier cRLNumber = null;
    public static final ASN1ObjectIdentifier certificateIssuer = null;
    public static final ASN1ObjectIdentifier certificatePolicies = null;
    public static final ASN1ObjectIdentifier deltaCRLIndicator = null;
    public static final ASN1ObjectIdentifier extendedKeyUsage = null;
    public static final ASN1ObjectIdentifier freshestCRL = null;
    public static final ASN1ObjectIdentifier inhibitAnyPolicy = null;
    public static final ASN1ObjectIdentifier instructionCode = null;
    public static final ASN1ObjectIdentifier invalidityDate = null;
    public static final ASN1ObjectIdentifier issuerAlternativeName = null;
    public static final ASN1ObjectIdentifier issuingDistributionPoint = null;
    public static final ASN1ObjectIdentifier keyUsage = null;
    public static final ASN1ObjectIdentifier logoType = null;
    public static final ASN1ObjectIdentifier nameConstraints = null;
    public static final ASN1ObjectIdentifier noRevAvail = null;
    public static final ASN1ObjectIdentifier policyConstraints = null;
    public static final ASN1ObjectIdentifier policyMappings = null;
    public static final ASN1ObjectIdentifier privateKeyUsagePeriod = null;
    public static final ASN1ObjectIdentifier qCStatements = null;
    public static final ASN1ObjectIdentifier reasonCode = null;
    public static final ASN1ObjectIdentifier subjectAlternativeName = null;
    public static final ASN1ObjectIdentifier subjectDirectoryAttributes = null;
    public static final ASN1ObjectIdentifier subjectInfoAccess = null;
    public static final ASN1ObjectIdentifier subjectKeyIdentifier = null;
    public static final ASN1ObjectIdentifier targetInformation = null;
    boolean critical;
    ASN1OctetString value;

    static {
        subjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
        subjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
        keyUsage = new ASN1ObjectIdentifier("2.5.29.15");
        privateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
        subjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
        issuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
        basicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
        cRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
        reasonCode = new ASN1ObjectIdentifier("2.5.29.21");
        instructionCode = new ASN1ObjectIdentifier("2.5.29.23");
        invalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
        deltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
        issuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
        certificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
        nameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
        cRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
        certificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
        policyMappings = new ASN1ObjectIdentifier("2.5.29.33");
        authorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
        policyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
        extendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
        freshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
        inhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
        authorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
        subjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        logoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        biometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        qCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
        auditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
        noRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
        targetInformation = new ASN1ObjectIdentifier("2.5.29.55");
    }

    public static ASN1Primitive convertValueToObject(X509Extension r3) {
        return ASN1Primitive.fromByteArray(r3.getValue().getOctets());
    L4:
        e = move-exception;
        throw new IllegalArgumentException("can't convert extension: " + e);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, X509Extension.class) == true) goto L5;
        return false;
    L5:
        X509Extension r5 = (X509Extension) ZeusTransformUtils.preCheckCast(r4, X509Extension.class, "com.obric.memorydata.plugin");
        if (r5.getValue().equals(getValue()) == true) goto L8;
        return false;
    L8:
        if (r5.isCritical() != isCritical()) goto L12;
        return true;
    L12:
        return false;
    }

    public ASN1OctetString getValue() {
        return this.value;
    }

    public int hashCode() {
        boolean r0 = isCritical();
        int r1 = getValue().hashCode();
        if (r0 == false) goto L6;
        return r1;
    L6:
        return ~r1;
    }

    public boolean isCritical() {
        return this.critical;
    }
}
