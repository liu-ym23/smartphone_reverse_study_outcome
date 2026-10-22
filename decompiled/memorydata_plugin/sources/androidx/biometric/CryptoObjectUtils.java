package androidx.biometric;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.identity.PresentationSession;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyStore;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
class CryptoObjectUtils {
    private static final String FAKE_KEY_NAME = "androidxBiometric";
    private static final String KEYSTORE_INSTANCE = "AndroidKeyStore";
    private static final String TAG = "CryptoObjectUtils";

    private static class Api23Impl {
        private Api23Impl() {
        }

        static KeyGenParameterSpec buildKeyGenParameterSpec(KeyGenParameterSpec.Builder r0) {
            return r0.build();
        }

        static KeyGenParameterSpec.Builder createKeyGenParameterSpecBuilder(String r1, int r2) {
            return new KeyGenParameterSpec.Builder(r1, r2);
        }

        static void initKeyGenerator(KeyGenerator r0, KeyGenParameterSpec r1) {
            r0.init(r1);
        }

        static void setBlockModeCBC(KeyGenParameterSpec.Builder r1) {
            r1.setBlockModes(new String[]{"CBC"});
        }

        static void setEncryptionPaddingPKCS7(KeyGenParameterSpec.Builder r1) {
            r1.setEncryptionPaddings(new String[]{"PKCS7Padding"});
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static android.hardware.biometrics.BiometricPrompt.CryptoObject create(Signature r1) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r1);
        }

        static android.hardware.biometrics.BiometricPrompt.CryptoObject create(Cipher r1) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r1);
        }

        static android.hardware.biometrics.BiometricPrompt.CryptoObject create(Mac r1) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r1);
        }

        static Cipher getCipher(android.hardware.biometrics.BiometricPrompt.CryptoObject r0) {
            return r0.getCipher();
        }

        static Mac getMac(android.hardware.biometrics.BiometricPrompt.CryptoObject r0) {
            return r0.getMac();
        }

        static Signature getSignature(android.hardware.biometrics.BiometricPrompt.CryptoObject r0) {
            return r0.getSignature();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static android.hardware.biometrics.BiometricPrompt.CryptoObject create(IdentityCredential r1) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r1);
        }

        static IdentityCredential getIdentityCredential(android.hardware.biometrics.BiometricPrompt.CryptoObject r0) {
            return r0.getIdentityCredential();
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static android.hardware.biometrics.BiometricPrompt.CryptoObject create(PresentationSession r1) {
            return new android.hardware.biometrics.BiometricPrompt.CryptoObject(r1);
        }

        static PresentationSession getPresentationSession(android.hardware.biometrics.BiometricPrompt.CryptoObject r0) {
            return r0.getPresentationSession();
        }
    }

    private CryptoObjectUtils() {
    }

    static BiometricPrompt.CryptoObject createFakeCryptoObject() {
        KeyStore r3 = KeyStore.getInstance(KEYSTORE_INSTANCE);     // Catch: Throwable -> L5
        r3.load(null);     // Catch: Throwable -> L5
        KeyGenParameterSpec.Builder r4 = Api23Impl.createKeyGenParameterSpecBuilder(FAKE_KEY_NAME, 3);     // Catch: Throwable -> L5
        Api23Impl.setBlockModeCBC(r4);     // Catch: Throwable -> L5
        Api23Impl.setEncryptionPaddingPKCS7(r4);     // Catch: Throwable -> L5
        KeyGenerator r1 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, KEYSTORE_INSTANCE);     // Catch: Throwable -> L5
        Api23Impl.initKeyGenerator(r1, Api23Impl.buildKeyGenParameterSpec(r4));     // Catch: Throwable -> L5
        r1.generateKey();     // Catch: Throwable -> L5
        SecretKey r0 = (SecretKey) ZeusTransformUtils.preCheckCast(r3.getKey(FAKE_KEY_NAME, null), SecretKey.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Cipher r2 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L5
        r2.init(1, r0);     // Catch: Throwable -> L5
        return new BiometricPrompt.CryptoObject(r2);
    L5:
        e = move-exception;
        Log.w(TAG, "Failed to create fake crypto object.", e);
        return null;
    }

    static BiometricPrompt.CryptoObject unwrapFromBiometricPrompt(android.hardware.biometrics.BiometricPrompt.CryptoObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Cipher r1 = Api28Impl.getCipher(r3);
        if (r1 != null) goto L8;
        Signature r2 = Api28Impl.getSignature(r3);
        if (r2 != null) goto L12;
        Mac r4 = Api28Impl.getMac(r3);
        if (r4 == null) goto L18;
        return new BiometricPrompt.CryptoObject(r4);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L24;
        IdentityCredential r5 = Api30Impl.getIdentityCredential(r3);
        if (r5 == null) goto L24;
        return new BiometricPrompt.CryptoObject(r5);
    L24:
        if (Build.VERSION.SDK_INT < 33) goto L29;
        PresentationSession r6 = Api33Impl.getPresentationSession(r3);
        if (r6 != null) goto L28;
        return null;
    L28:
        return new BiometricPrompt.CryptoObject(r6);
    L29:
        return null;
    L12:
        return new BiometricPrompt.CryptoObject(r2);
    L8:
        return new BiometricPrompt.CryptoObject(r1);
    }

    static BiometricPrompt.CryptoObject unwrapFromFingerprintManager(FingerprintManagerCompat.CryptoObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Cipher r1 = r2.getCipher();
        if (r1 != null) goto L8;
        Signature r3 = r2.getSignature();
        if (r3 != null) goto L12;
        Mac r4 = r2.getMac();
        if (r4 != null) goto L16;
        return null;
    L16:
        return new BiometricPrompt.CryptoObject(r4);
    L12:
        return new BiometricPrompt.CryptoObject(r3);
    L8:
        return new BiometricPrompt.CryptoObject(r1);
    }

    static android.hardware.biometrics.BiometricPrompt.CryptoObject wrapForBiometricPrompt(BiometricPrompt.CryptoObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Cipher r1 = r3.getCipher();
        if (r1 != null) goto L8;
        Signature r2 = r3.getSignature();
        if (r2 != null) goto L12;
        Mac r4 = r3.getMac();
        if (r4 == null) goto L18;
        return Api28Impl.create(r4);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L24;
        IdentityCredential r5 = r3.getIdentityCredential();
        if (r5 == null) goto L24;
        return Api30Impl.create(r5);
    L24:
        if (Build.VERSION.SDK_INT < 33) goto L29;
        PresentationSession r6 = r3.getPresentationSession();
        if (r6 == null) goto L29;
        return Api33Impl.create(r6);
    L29:
        return null;
    L12:
        return Api28Impl.create(r2);
    L8:
        return Api28Impl.create(r1);
    }

    static FingerprintManagerCompat.CryptoObject wrapForFingerprintManager(BiometricPrompt.CryptoObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Cipher r1 = r4.getCipher();
        if (r1 != null) goto L8;
        Signature r2 = r4.getSignature();
        if (r2 != null) goto L12;
        Mac r3 = r4.getMac();
        if (r3 == null) goto L18;
        return new FingerprintManagerCompat.CryptoObject(r3);
    L18:
        if (Build.VERSION.SDK_INT < 30) goto L25;
        if (r4.getIdentityCredential() == null) goto L25;
        String r5 = "Identity credential is not supported by FingerprintManager.";
    L22:
        Log.e(TAG, r5);
        return null;
    L25:
        if (Build.VERSION.SDK_INT >= 33) goto L27;
    L29:
        return null;
    L27:
        if (r4.getPresentationSession() == null) goto L29;
        r5 = "Presentation session is not supported by FingerprintManager.";
        goto L22
    L12:
        return new FingerprintManagerCompat.CryptoObject(r2);
    L8:
        return new FingerprintManagerCompat.CryptoObject(r1);
    }
}
