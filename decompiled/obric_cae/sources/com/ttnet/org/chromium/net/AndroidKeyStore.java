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
    private static byte[] encryptWithPrivateKey(PrivateKey r8, String r10, byte[] r11) {
        Cipher r12 = Cipher.getInstance(r10);     // Catch: Throwable -> L10
        r12.init(1, r8);     // Catch: Exception -> L7
        return r12.doFinal(r11);
    L7:
        e = move-exception;
        StringBuilder r13 = defpackage.b.h("Exception while encrypting input with ", r10, " and ");
        r13.append(r8.getAlgorithm());
        r13.append(" private key (");
        r13.append(r8.getClass().getName());
        r13.append("): ");
        r13.append(e);
        Log.e(TAG, r13.toString(), new Object[0]);
        return null;
    L10:
        e = move-exception;
        Log.e(TAG, "Cipher " + r10 + " not supported: " + e, new Object[0]);
        return null;
    }

    @CalledByNative
    private static String getPrivateKeyClassName(PrivateKey r8) {
        return r8.getClass().getName();
    }

    @CalledByNative
    private static boolean privateKeySupportsCipher(PrivateKey r8, String r10) {
        Cipher.getInstance(r10).init(1, r8);     // Catch: Exception -> L5 Throwable -> L8
        return true;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r10 + ": " + e, new Object[0]);
    L7:
        return false;
    }

    @CalledByNative
    private static boolean privateKeySupportsSignature(PrivateKey r8, String r10) {
        Signature.getInstance(r10).initSign(r8);     // Catch: Exception -> L6 Throwable -> L9
        return true;
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r10 + ": " + e, new Object[0]);
    L8:
        return false;
    }

    @CalledByNative
    private static byte[] signWithPrivateKey(PrivateKey r8, String r10, byte[] r11) {
        Signature r12 = Signature.getInstance(r10);     // Catch: NoSuchAlgorithmException -> L9
        r12.initSign(r8);     // Catch: Exception -> L6
        r12.update(r11);     // Catch: Exception -> L6
        return r12.sign();
    L6:
        e = move-exception;
        StringBuilder r13 = defpackage.b.h("Exception while signing message with ", r10, " and ");
        r13.append(r8.getAlgorithm());
        r13.append(" private key (");
        r13.append(r8.getClass().getName());
        r13.append("): ");
        r13.append(e);
        Log.e(TAG, r13.toString(), new Object[0]);
        return null;
    L9:
        e = move-exception;
        Log.e(TAG, "Signature algorithm " + r10 + " not supported: " + e, new Object[0]);
        return null;
    }
}
