package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class Extension extends ASN1Object {
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
    public static final ASN1ObjectIdentifier expiredCertsOnCRL = null;
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
    private boolean critical;
    private ASN1ObjectIdentifier extnId;
    private ASN1OctetString value;

    static {
        subjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9").intern();
        subjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14").intern();
        keyUsage = new ASN1ObjectIdentifier("2.5.29.15").intern();
        privateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16").intern();
        subjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17").intern();
        issuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18").intern();
        basicConstraints = new ASN1ObjectIdentifier("2.5.29.19").intern();
        cRLNumber = new ASN1ObjectIdentifier("2.5.29.20").intern();
        reasonCode = new ASN1ObjectIdentifier("2.5.29.21").intern();
        instructionCode = new ASN1ObjectIdentifier("2.5.29.23").intern();
        invalidityDate = new ASN1ObjectIdentifier("2.5.29.24").intern();
        deltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27").intern();
        issuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28").intern();
        certificateIssuer = new ASN1ObjectIdentifier("2.5.29.29").intern();
        nameConstraints = new ASN1ObjectIdentifier("2.5.29.30").intern();
        cRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31").intern();
        certificatePolicies = new ASN1ObjectIdentifier("2.5.29.32").intern();
        policyMappings = new ASN1ObjectIdentifier("2.5.29.33").intern();
        authorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35").intern();
        policyConstraints = new ASN1ObjectIdentifier("2.5.29.36").intern();
        extendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37").intern();
        freshestCRL = new ASN1ObjectIdentifier("2.5.29.46").intern();
        inhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54").intern();
        authorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1").intern();
        subjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11").intern();
        logoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12").intern();
        biometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2").intern();
        qCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3").intern();
        auditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4").intern();
        noRevAvail = new ASN1ObjectIdentifier("2.5.29.56").intern();
        targetInformation = new ASN1ObjectIdentifier("2.5.29.55").intern();
        expiredCertsOnCRL = new ASN1ObjectIdentifier("2.5.29.60").intern();
    }

    private Extension(ASN1Sequence r6) {
        if (r6.size() != 2) goto L7;
        this.extnId = ASN1ObjectIdentifier.getInstance(r6.getObjectAt(0));
        this.critical = false;
        ASN1Encodable r7 = r6.getObjectAt(1);
    L5:
        this.value = ASN1OctetString.getInstance(r7);
        return;
    L7:
        if (r6.size() != 3) goto L11;
        this.extnId = ASN1ObjectIdentifier.getInstance(r6.getObjectAt(0));
        this.critical = ASN1Boolean.getInstance(r6.getObjectAt(1)).isTrue();
        r7 = r6.getObjectAt(2);
        goto L5
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r6.size());
    }

    private static ASN1Primitive convertValueToObject(Extension r3) {
        return ASN1Primitive.fromByteArray(r3.getExtnValue().getOctets());
    L4:
        e = move-exception;
        throw new IllegalArgumentException("can't convert extension: " + e);
    }

    public static Extension getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Extension.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new Extension(ASN1Sequence.getInstance(r2));
    L5:
        return (Extension) ZeusTransformUtils.preCheckCast(r2, Extension.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Extension.class) == true) goto L5;
        return false;
    L5:
        Extension r5 = (Extension) ZeusTransformUtils.preCheckCast(r4, Extension.class, "com.obric.memorydata.plugin");
        if (r5.getExtnId().equals(getExtnId()) == true) goto L8;
        return false;
    L8:
        if (r5.getExtnValue().equals(getExtnValue()) == true) goto L10;
        return false;
    L10:
        if (r5.isCritical() != isCritical()) goto L15;
        return true;
    L15:
        return false;
    }

    public ASN1ObjectIdentifier getExtnId() {
        return this.extnId;
    }

    public ASN1OctetString getExtnValue() {
        return this.value;
    }

    public ASN1Encodable getParsedValue() {
        return convertValueToObject(this);
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (isCritical() == false) goto L6;
        int r0 = getExtnValue().hashCode();
        return getExtnId().hashCode() ^ r0;
    L6:
        int r1 = getExtnValue().hashCode();
        return ~(getExtnId().hashCode() ^ r1);
    }

    public boolean isCritical() {
        return this.critical;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.extnId);
        if (this.critical == false) goto L5;
        r0.add(ASN1Boolean.getInstance(true));
    L5:
        r0.add(this.value);
        return new DERSequence(r0);
    }
}
