package androidx.biometric;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class AuthenticatorUtils {
    private static final int BIOMETRIC_CLASS_MASK = 32767;

    private AuthenticatorUtils() {
    }

    static String convertToString(int r1) {
        if (r1 != 15) goto L5;
        return "BIOMETRIC_STRONG";
    L5:
        if (r1 != 255) goto L7;
        return "BIOMETRIC_WEAK";
    L7:
        if (r1 != 32768) goto L9;
        return "DEVICE_CREDENTIAL";
    L9:
        if (r1 != 32783) goto L11;
        return "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
    L11:
        if (r1 != 33023) goto L13;
        return "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
    L13:
        return String.valueOf(r1);
    }

    static int getBiometricAuthenticators(int r0) {
        return r0 & BIOMETRIC_CLASS_MASK;
    }

    static int getConsolidatedAuthenticators(BiometricPrompt.PromptInfo r1, BiometricPrompt.CryptoObject r2) {
        if (r1.getAllowedAuthenticators() != 0) goto L13;
        if (r2 == null) goto L7;
        int r3 = 15;
    L9:
        if (r1.isDeviceCredentialAllowed() == false) goto L12;
        return 32768 | r3;
    L12:
        return r3;
    L7:
        r3 = 255;
        goto L9
    L13:
        return r1.getAllowedAuthenticators();
    }

    static boolean isDeviceCredentialAllowed(int r1) {
        if ((r1 & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isSomeBiometricAllowed(int r0) {
        if (getBiometricAuthenticators(r0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isSupportedCombination(int r3) {
        if (r3 != 15) goto L5;
        return true;
    L5:
        if (r3 != 255) goto L7;
        return true;
    L7:
        if (r3 == 32768) goto L24;
        if (r3 == 32783) goto L17;
        if (r3 == 33023) goto L33;
        if (r3 != 0) goto L15;
        return true;
    L15:
        return false;
    L33:
        return true;
    L17:
        if (Build.VERSION.SDK_INT >= 28) goto L19;
        return true;
    L19:
        if (Build.VERSION.SDK_INT <= 29) goto L22;
        return true;
    L22:
        return false;
    L24:
        if (Build.VERSION.SDK_INT < 30) goto L27;
        return true;
    L27:
        return false;
    }

    static boolean isWeakBiometricAllowed(int r1) {
        if ((r1 & 255) != 255) goto L5;
        return true;
    L5:
        return false;
    }
}
