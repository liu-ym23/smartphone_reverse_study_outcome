package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.obric.sva.sdk.data.ISmModel;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ECDHHelper {
    public ECDHHelper() {
    }

    public static PrivateKey bytesToECPrivateKey(byte[] r1) {
        PKCS8EncodedKeySpec r0 = new PKCS8EncodedKeySpec(r1);
        return KeyFactory.getInstance("EC").generatePrivate(r0);
    }

    private static PublicKey bytesToPublicKey(byte[] r1) {
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(r1);
        return KeyFactory.getInstance("EC").generatePublic(r0);
    }

    public static byte[] generateBDSharedSecret(Context r3, String r4, byte[] r5) {
        Bundle r0 = new Bundle();
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), ISmModel.VERSION_0100);
        FrameworkSecurityCompat.KmResult r6 = FrameworkSecurityCompat.keyAgreement(r3, r4, r5, r0);
        if (r6.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        return r6.getOutData();
    L7:
        throw new CloudTransException("bd keyAgreement failed, system errorCode: " + r6.getResultCode());
    }

    public static byte[] generateSharedSecret(PrivateKey r1, PublicKey r2) {
        KeyAgreement r0 = KeyAgreement.getInstance("ECDH");
        r0.init(r1);
        r0.doPhase(r2, true);
        return r0.generateSecret();
    }
}
