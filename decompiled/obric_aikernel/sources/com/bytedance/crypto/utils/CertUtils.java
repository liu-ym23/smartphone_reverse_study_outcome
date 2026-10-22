package com.bytedance.crypto.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CertUtils {
    private static final String TAG = "CertUtils";

    public CertUtils() {
    }

    public static String certsToPemString(List<Certificate> r10, int r11) {
        if (r10 == null) goto L25;
        if (r10.isEmpty() == true) goto L25;
        if (r11 <= 0) goto L25;
        if (r11 > r10.size()) goto L25;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        Iterator<Certificate> r13 = r10.iterator();
        int r14 = 0;
    L10:
        if (r13.hasNext() == false) goto L23;
        Certificate r15 = r13.next();
        if (r14 >= r11) goto L23;
        if (r15 == null) goto L21;
        r12.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r16 = Base64.getEncoder().encodeToString(r15.getEncoded());
        int r17 = 0;
    L17:
        if (r17 >= r16.length()) goto L19;
        int r18 = r17 + 64;
        r12.write(r16.substring(r17, Math.min(r18, r16.length())).getBytes());
        r17 = r18;
        goto L17
    L19:
        r12.write("\\n".getBytes());
        r12.write("-----END CERTIFICATE-----\\n".getBytes());
        r14 = r14 + 1;
        goto L10
    L21:
        throw new IllegalArgumentException("Certificate is null at index " + r14);
    L23:
        return r12.toString();
    L25:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }

    public static List<X509Certificate> convertToX509Certificates(byte[] r10) {
        ArrayList r11 = new ArrayList();
        Iterator<? extends Certificate> r12 = CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(r10)).iterator();     // Catch: CertificateException -> L10
    L5:
        if (r12.hasNext() == false) goto L12;
        Certificate r13 = r12.next();     // Catch: CertificateException -> L10
        if ((r13 instanceof X509Certificate) == false) goto L5;
        r11.add((X509Certificate) r13);     // Catch: CertificateException -> L10
    L12:
        return r11;
    L10:
        e = move-exception;
        LogUtils.e(TAG, "convertToX509Certificates failed, exception: " + e.getMessage());
        goto L12
    }

    public static X509Certificate pemStringToX509(String r10) {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.getDecoder().decode(r10.replace("-----BEGIN CERTIFICATE-----", "").replace("-----END CERTIFICATE-----", "").replace("\n", ""))));
    L5:
        e = move-exception;
        LogUtils.e(TAG, "pemStringToX509 failed, exception: " + e.getMessage());
        return null;
    }

    public static boolean validateCertChain(X509Certificate r10, List<X509Certificate> r11) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        if (r11.isEmpty() == true) goto L15;
        HashSet r12 = new HashSet();
        r12.add(new TrustAnchor(r10, null));
        PKIXParameters r13 = new PKIXParameters(r12);     // Catch: Exception -> L12
        r13.setRevocationEnabled(false);     // Catch: Exception -> L12
        CertPathValidator.getInstance("PKIX").validate(CertificateFactory.getInstance("X.509").generateCertPath(r11), r13);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "validateCertChain failed, exception: " + e.getMessage());
        return false;
    L15:
        LogUtils.e(TAG, "Invalid params.");
        return false;
    }
}
