package androidx.biometric;

import android.content.Context;
import android.os.Build;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class BiometricManager {
    public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1;
    public static final int BIOMETRIC_ERROR_NONE_ENROLLED = 11;
    public static final int BIOMETRIC_ERROR_NO_HARDWARE = 12;
    public static final int BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int BIOMETRIC_ERROR_UNSUPPORTED = -2;
    public static final int BIOMETRIC_STATUS_UNKNOWN = -1;
    public static final int BIOMETRIC_SUCCESS = 0;
    private static final String TAG = "BiometricManager";
    private final android.hardware.biometrics.BiometricManager mBiometricManager;
    private final FingerprintManagerCompat mFingerprintManager;
    private final Injector mInjector;

    private int canAuthenticateWithFingerprint() {
        FingerprintManagerCompat r0 = this.mFingerprintManager;
        if (r0 != null) goto L7;
        return 1;
    L7:
        if (r0.isHardwareDetected() == true) goto L11;
        return 12;
    L11:
        if (this.mFingerprintManager.hasEnrolledFingerprints() == true) goto L14;
        return 11;
    L14:
        return 0;
    }

    private int canAuthenticateWithFingerprintOrUnknownBiometric() {
        if (this.mInjector.isDeviceSecuredWithCredential() == true) goto L7;
        return canAuthenticateWithFingerprint();
    L7:
        if (canAuthenticateWithFingerprint() != 0) goto L9;
        return 0;
    L9:
        return -1;
    }

    private int canAuthenticateWithWeakBiometricOnApi29() {
        android.hardware.biometrics.BiometricManager r0 = this.mBiometricManager;
        if (r0 != null) goto L7;
        return 1;
    L7:
        return Api29Impl.canAuthenticate(r0);
    }

    public int canAuthenticate() {
        return canAuthenticate(255);
    }

    private int canAuthenticateWithStrongBiometricOnApi29() {
        Method r0 = Api29Impl.getCanAuthenticateWithCryptoMethod();
        if (r0 == null) goto L11;
        android.hardware.biometrics.BiometricPrompt.CryptoObject r1 = CryptoObjectUtils.wrapForBiometricPrompt(CryptoObjectUtils.createFakeCryptoObject());
        if (r1 == null) goto L11;
        Object r2 = r0.invoke(this.mBiometricManager, new Object[]{r1});     // Catch: Throwable -> L10
        if ((r2 instanceof Integer) == false) goto L11;
        return ((Integer) r2).intValue();
    L11:
        int r3 = canAuthenticateWithWeakBiometricOnApi29();
        if (this.mInjector.isStrongBiometricGuaranteed() == true) goto L19;
        if (r3 == 0) goto L16;
        return r3;
    L16:
        return canAuthenticateWithFingerprintOrUnknownBiometric();
    L19:
        return r3;
    }

    public BiometricManager(Injector r5) {
        this.mInjector = r5;
        int r0 = Build.VERSION.SDK_INT;
        FingerprintManagerCompat r1 = null;
        if (r0 < 29) goto L5;
        android.hardware.biometrics.BiometricManager r3 = r5.getBiometricManager();
    L6:
        this.mBiometricManager = r3;
        if (r0 > 29) goto L9;
        r1 = r5.getFingerprintManager();
    L9:
        this.mFingerprintManager = r1;
        return;
    L5:
        r3 = null;
        goto L6
    }

    private int canAuthenticateCompat(int r4) {
        if (AuthenticatorUtils.isSupportedCombination(r4) == true) goto L7;
        return -2;
    L7:
        if (r4 != 0) goto L10;
        return 12;
    L10:
        if (this.mInjector.isDeviceSecurable() == true) goto L13;
        return 12;
    L13:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r4) == true) goto L15;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 != 29) goto L27;
        if (AuthenticatorUtils.isWeakBiometricAllowed(r4) == false) goto L25;
        return canAuthenticateWithWeakBiometricOnApi29();
    L25:
        return canAuthenticateWithStrongBiometricOnApi29();
    L27:
        if (r1 != 28) goto L33;
        if (this.mInjector.isFingerprintHardwarePresent() == true) goto L31;
        return 12;
    L31:
        return canAuthenticateWithFingerprintOrUnknownBiometric();
    L33:
        return canAuthenticateWithFingerprint();
    L15:
        if (this.mInjector.isDeviceSecuredWithCredential() == false) goto L17;
        return 0;
    L17:
        return 11;
    }

    public static BiometricManager from(Context r2) {
        return new BiometricManager(new DefaultInjector(r2));
    }

    public int canAuthenticate(int r3) {
        if (Build.VERSION.SDK_INT < 30) goto L11;
        android.hardware.biometrics.BiometricManager r0 = this.mBiometricManager;
        if (r0 != null) goto L9;
        return 1;
    L9:
        return Api30Impl.canAuthenticate(r0, r3);
    L11:
        return canAuthenticateCompat(r3);
    }
}
