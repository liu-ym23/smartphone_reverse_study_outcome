package com.bytedance.bdinstall.dtrait;

import android.util.Base64;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public class RSAUtils {
    private static final String PKCS1PrivateFooter = "-----END RSA PRIVATE KEY-----";
    private static final String PKCS1PrivateHeader = "-----BEGIN RSA PRIVATE KEY-----";
    private static final String PKCS1PublicFooter = "-----END RSA PUBLIC KEY-----";
    private static final String PKCS1PublicHeader = "-----BEGIN RSA PUBLIC KEY-----";
    private static final String PKCS8PrivateFooter = "-----END PRIVATE KEY-----";
    private static final String PKCS8PrivateHeader = "-----BEGIN PRIVATE KEY-----";
    private static final String PKCS8PublicFooter = "-----END PUBLIC KEY-----";
    private static final String PKCS8PublicHeader = "-----BEGIN PUBLIC KEY-----";

    public RSAUtils() {
    }

    private static byte[] bytes(int... r3) {
        byte[] r0 = new byte[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = (byte) r3[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static byte[] decrypt(String r2, PrivateKey r3) {
        PrivateKey r4 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin");
        Cipher r0 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r0.init(2, r4);
        return r0.doFinal(Base64.decode(r2, 2));
    }

    private static byte[] joinBytes(byte[] r3, byte[] r4) {
        byte[] r0 = new byte[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    private static PrivateKey parsePkcs1PrivateKey(byte[] r10) {
        int r0 = r10.length;
        int r1 = r0 + 22;
        return parsePkcs8PrivateKey(joinBytes(bytes(new int[]{48, 130, (r1 >> 8) & 255, r1 & 255, 2, 1, 0, 48, 13, 6, 9, 42, 134, 72, 134, 247, 13, 1, 1, 1, 5, 0, 4, 130, (r0 >> 8) & 255, r0 & 255}), r10));
    }

    private static PublicKey parsePkcs1PublicKey(byte[] r11) {
        int r0 = r11.length + 1;
        int r2 = r0 + 19;
        return parsePkcs8PublicKey(joinBytes(bytes(new int[]{48, 130, (r2 >> 8) & 255, r2 & 255, 48, 13, 6, 9, 42, 134, 72, 134, 247, 13, 1, 1, 1, 5, 0, 3, 130, (r0 >> 8) & 255, r0 & 255, 0}), r11));
    }

    private static PrivateKey parsePkcs8PrivateKey(byte[] r1) {
        PKCS8EncodedKeySpec r0 = new PKCS8EncodedKeySpec(r1);
        return KeyFactory.getInstance("RSA").generatePrivate(r0);
    }

    private static PublicKey parsePkcs8PublicKey(byte[] r1) {
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(r1);
        return KeyFactory.getInstance("RSA").generatePublic(r0);
    }

    public static PrivateKey parsePrivateKey(String r5) {
        String r6 = r5.replaceAll("\\n", "");
        if (r6.startsWith(PKCS8PrivateHeader) == false) goto L9;
        if (r6.endsWith(PKCS8PrivateFooter) == false) goto L9;
        return parsePkcs8PrivateKey(Base64.decode(r6.replace(PKCS8PrivateHeader, "").replace(PKCS8PrivateFooter, ""), 0));
    L9:
        if (r6.startsWith(PKCS1PrivateHeader) == false) goto L15;
        if (r6.endsWith(PKCS1PrivateFooter) == false) goto L15;
        return parsePkcs1PrivateKey(Base64.decode(r6.replace(PKCS1PrivateHeader, "").replace(PKCS1PrivateFooter, ""), 0));
    L15:
        throw new InvalidKeyException();
    }

    public static PublicKey parsePublicKey(String r5) {
        String r6 = r5.replaceAll("\\n", "");
        if (r6.startsWith(PKCS8PublicHeader) == false) goto L9;
        if (r6.endsWith(PKCS8PublicFooter) == false) goto L9;
        return parsePkcs8PublicKey(Base64.decode(r6.replace(PKCS8PublicHeader, "").replace(PKCS8PublicFooter, ""), 0));
    L9:
        if (r6.startsWith(PKCS1PublicHeader) == false) goto L15;
        if (r6.endsWith(PKCS1PublicFooter) == false) goto L15;
        return parsePkcs1PublicKey(Base64.decode(r6.replace(PKCS1PublicHeader, "").replace(PKCS1PublicFooter, ""), 0));
    L15:
        throw new InvalidKeyException();
    }
}
