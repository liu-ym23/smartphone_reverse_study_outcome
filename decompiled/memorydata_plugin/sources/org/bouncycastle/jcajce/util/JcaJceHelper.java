package org.bouncycastle.jcajce.util;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface JcaJceHelper {
    AlgorithmParameters createAlgorithmParameters(String r1);

    CertificateFactory createCertificateFactory(String r1);

    Cipher createCipher(String r1);

    KeyAgreement createKeyAgreement(String r1);

    KeyFactory createKeyFactory(String r1);

    Mac createMac(String r1);

    SecretKeyFactory createSecretKeyFactory(String r1);

    Signature createSignature(String r1);
}
