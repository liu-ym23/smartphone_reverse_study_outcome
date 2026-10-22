package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes.dex */
public class ECDHHelper {
    public ECDHHelper() {
    }

    public static PrivateKey bytesToECPrivateKey(byte[] r10) {
        PKCS8EncodedKeySpec r11 = new PKCS8EncodedKeySpec(r10);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePrivate(r11);
    }

    private static PublicKey bytesToPublicKey(byte[] r10) {
        X509EncodedKeySpec r11 = new X509EncodedKeySpec(r10);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r11);
    }

    public static byte[] generateBDSharedSecret(Context r10, String r11, byte[] r12) {
        Bundle r13 = new Bundle();
        r13.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r13.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        FrameworkSecurityCompat.KmResult r14 = FrameworkSecurityCompat.keyAgreement(r10, r11, r12, r13);
        if (r14.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        return r14.getOutData();
    L7:
        throw new CloudTransException("bd keyAgreement failed, system errorCode: " + r14.getResultCode());
    }

    public static byte[] generateSharedSecret(PrivateKey r10, PublicKey r11) {
        KeyAgreement r12 = KeyAgreement.getInstance("ECDH");
        r12.init(r10);
        r12.doPhase(r11, true);
        return r12.generateSecret();
    }
}
