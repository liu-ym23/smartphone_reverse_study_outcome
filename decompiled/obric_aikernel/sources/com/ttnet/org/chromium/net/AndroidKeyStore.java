package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class AndroidKeyStore {
    private static final String TAG = "AndroidKeyStore";

    public AndroidKeyStore() {
    }

    @CalledByNative
    private static byte[] encryptWithPrivateKey(PrivateKey r10, String r11, byte[] r12) {
        Cipher r13 = Cipher.getInstance(r11);     // Catch: Throwable -> L10
        r13.init(1, r10);     // Catch: Exception -> L7
        return r13.doFinal(r12);
    L7:
        e = move-exception;
        Log.e(TAG, "Exception while encrypting input with " + r11 + " and " + r10.getAlgorithm() + " private key (" + r10.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L10:
        e = move-exception;
        Log.e(TAG, "Cipher " + r11 + " not supported: " + e, new Object[0]);
        return null;
    }

    @CalledByNative
    private static String getPrivateKeyClassName(PrivateKey r10) {
        return r10.getClass().getName();
    }

    @CalledByNative
    private static boolean privateKeySupportsCipher(PrivateKey r10, String r11) {
        Cipher.getInstance(r11).init(1, r10);     // Catch: Exception -> L5 Throwable -> L8
        return true;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r11 + ": " + e, new Object[0]);
    L7:
        return false;
    }

    @CalledByNative
    private static boolean privateKeySupportsSignature(PrivateKey r10, String r11) {
        Signature.getInstance(r11).initSign(r10);     // Catch: Exception -> L6 Throwable -> L9
        return true;
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r11 + ": " + e, new Object[0]);
    L8:
        return false;
    }

    @CalledByNative
    private static byte[] signWithPrivateKey(PrivateKey r10, String r11, byte[] r12) {
        Signature r13 = Signature.getInstance(r11);     // Catch: NoSuchAlgorithmException -> L9
        r13.initSign(r10);     // Catch: Exception -> L6
        r13.update(r12);     // Catch: Exception -> L6
        return r13.sign();
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while signing message with " + r11 + " and " + r10.getAlgorithm() + " private key (" + r10.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L9:
        e = move-exception;
        Log.e(TAG, "Signature algorithm " + r11 + " not supported: " + e, new Object[0]);
        return null;
    }
}
