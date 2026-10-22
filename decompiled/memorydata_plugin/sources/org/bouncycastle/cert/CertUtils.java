package org.bouncycastle.cert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
class CertUtils {
    private static List EMPTY_LIST;
    private static Set EMPTY_SET;

    static {
        EMPTY_SET = Collections.unmodifiableSet(new HashSet());
        EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    }

    static boolean[] bitStringToBoolean(ASN1BitString r7) {
        if (r7 == null) goto L11;
        byte[] r0 = r7.getBytes();
        int r1 = (r0.length * 8) - r7.getPadBits();
        boolean[] r8 = new boolean[r1];
        int r3 = 0;
    L4:
        if (r3 == r1) goto L10;
        if ((r0[r3 / 8] & (128 >>> (r3 % 8))) == 0) goto L8;
        boolean r4 = true;
    L9:
        r8[r3] = r4;
        r3 = r3 + 1;
        goto L4
    L8:
        r4 = false;
        goto L9
    L10:
        return r8;
    L11:
        return null;
    }

    static Set getCriticalExtensionOIDs(Extensions r1) {
        if (r1 != null) goto L6;
        return EMPTY_SET;
    L6:
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(r1.getCriticalExtensionOIDs())));
    }

    static List getExtensionOIDs(Extensions r0) {
        if (r0 != null) goto L6;
        return EMPTY_LIST;
    L6:
        return Collections.unmodifiableList(Arrays.asList(r0.getExtensionOIDs()));
    }

    static Set getNonCriticalExtensionOIDs(Extensions r1) {
        if (r1 != null) goto L6;
        return EMPTY_SET;
    L6:
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(r1.getNonCriticalExtensionOIDs())));
    }

    static boolean isAlgIdEqual(AlgorithmIdentifier r3, AlgorithmIdentifier r4) {
        if (r3.getAlgorithm().equals(r4.getAlgorithm()) == true) goto L6;
        return false;
    L6:
        if (Properties.isOverrideSet("org.bouncycastle.x509.allow_absent_equiv_NULL") == false) goto L24;
        if (r3.getParameters() != null) goto L16;
        if (r4.getParameters() != null) goto L12;
    L14:
        return true;
    L12:
        if (r4.getParameters().equals(DERNull.INSTANCE) == true) goto L14;
        return false;
    L16:
        if (r4.getParameters() != null) goto L24;
        if (r3.getParameters() != null) goto L20;
    L22:
        return true;
    L20:
        if (r3.getParameters().equals(DERNull.INSTANCE) == true) goto L22;
        return false;
    L24:
        if (r3.getParameters() == null) goto L28;
        return r3.getParameters().equals(r4.getParameters());
    L28:
        if (r4.getParameters() != null) goto L30;
        return true;
    L30:
        return r4.getParameters().equals(r3.getParameters());
    }

    static ASN1Primitive parseNonEmptyASN1(byte[] r1) {
        ASN1Primitive r2 = ASN1Primitive.fromByteArray(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IOException("no content found");
    }

    static Date recoverDate(ASN1GeneralizedTime r3) {
        return r3.getDate();
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to recover date: " + e.getMessage());
    }
}
