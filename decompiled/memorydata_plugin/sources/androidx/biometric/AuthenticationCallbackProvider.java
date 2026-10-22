package androidx.biometric;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AuthenticationCallbackProvider {
    private android.hardware.biometrics.BiometricPrompt.AuthenticationCallback mBiometricCallback;
    private FingerprintManagerCompat.AuthenticationCallback mFingerprintCallback;
    final Listener mListener;

    private static class Api28Impl {
        private Api28Impl() {
        }

        static android.hardware.biometrics.BiometricPrompt.AuthenticationCallback createCallback(final Listener r1) {
            return new AnonymousClass1(r1);
        }

        static android.hardware.biometrics.BiometricPrompt.CryptoObject getCryptoObject(android.hardware.biometrics.BiometricPrompt.AuthenticationResult r0) {
            return r0.getCryptoObject();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getAuthenticationType(android.hardware.biometrics.BiometricPrompt.AuthenticationResult r0) {
            return r0.getAuthenticationType();
        }
    }

    static class Listener {
        Listener() {
        }

        void onError(int r1, CharSequence r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        void onFailure() {
        }

        void onHelp(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        void onSuccess(BiometricPrompt.AuthenticationResult r1) {
        }
    }

    AuthenticationCallbackProvider(Listener r1) {
        this.mListener = r1;
    }

    android.hardware.biometrics.BiometricPrompt.AuthenticationCallback getBiometricCallback() {
        if (this.mBiometricCallback != null) goto L6;
        this.mBiometricCallback = Api28Impl.createCallback(this.mListener);
    L6:
        return this.mBiometricCallback;
    }

    FingerprintManagerCompat.AuthenticationCallback getFingerprintCallback() {
        if (this.mFingerprintCallback != null) goto L6;
        this.mFingerprintCallback = new AnonymousClass1(this);
    L6:
        return this.mFingerprintCallback;
    }
}
