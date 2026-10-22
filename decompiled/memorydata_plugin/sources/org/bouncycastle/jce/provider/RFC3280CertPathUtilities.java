package org.bouncycastle.jce.provider;

import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;

/* JADX INFO: loaded from: classes7.dex */
class RFC3280CertPathUtilities {
    public static final String AUTHORITY_KEY_IDENTIFIER = null;
    public static final String BASIC_CONSTRAINTS = null;
    public static final String CERTIFICATE_POLICIES = null;
    public static final String CRL_DISTRIBUTION_POINTS = null;
    public static final String CRL_NUMBER = null;
    public static final String DELTA_CRL_INDICATOR = null;
    public static final String FRESHEST_CRL = null;
    public static final String INHIBIT_ANY_POLICY = null;
    public static final String ISSUING_DISTRIBUTION_POINT = null;
    public static final String KEY_USAGE = null;
    public static final String NAME_CONSTRAINTS = null;
    public static final String POLICY_CONSTRAINTS = null;
    public static final String POLICY_MAPPINGS = null;
    public static final String SUBJECT_ALTERNATIVE_NAME = null;
    protected static final String[] crlReasons = null;
    private static final Class revChkClass = null;

    static {
        revChkClass = ClassUtil.loadClass(RFC3280CertPathUtilities.class, "java.security.cert.PKIXRevocationChecker");
        CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
        POLICY_MAPPINGS = Extension.policyMappings.getId();
        INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
        ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
        FRESHEST_CRL = Extension.freshestCRL.getId();
        DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
        POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
        BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
        CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
        SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
        NAME_CONSTRAINTS = Extension.nameConstraints.getId();
        AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
        KEY_USAGE = Extension.keyUsage.getId();
        CRL_NUMBER = Extension.cRLNumber.getId();
        crlReasons = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    }

    RFC3280CertPathUtilities() {
    }
}
