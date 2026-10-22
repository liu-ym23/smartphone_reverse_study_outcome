package androidx.biometric;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BiometricManager {
    private static final int AUTH_MODALITY_CREDENTIAL = 1;
    private static final int AUTH_MODALITY_FACE = 8;
    private static final int AUTH_MODALITY_FINGERPRINT = 4;
    private static final int AUTH_MODALITY_NONE = 0;
    private static final int AUTH_MODALITY_UNKNOWN_BIOMETRIC = 2;
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

    private static class Api29Impl {
        private Api29Impl() {
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager r0) {
            return r0.canAuthenticate();
        }

        static android.hardware.biometrics.BiometricManager create(Context r2) {
            return (android.hardware.biometrics.BiometricManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(android.hardware.biometrics.BiometricManager.class), android.hardware.biometrics.BiometricManager.class, "com.obric.memorydata.plugin");
        }

        static Method getCanAuthenticateWithCryptoMethod() {
            return android.hardware.biometrics.BiometricManager.class.getMethod("canAuthenticate", new Class[]{android.hardware.biometrics.BiometricPrompt.CryptoObject.class});
        L4:
            return null;
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager r0, int r1) {
            return r0.canAuthenticate(r1);
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        static CharSequence getButtonLabel(android.hardware.biometrics.BiometricManager.Strings r0) {
            return r0.getButtonLabel();
        }

        static CharSequence getPromptMessage(android.hardware.biometrics.BiometricManager.Strings r0) {
            return r0.getPromptMessage();
        }

        static CharSequence getSettingName(android.hardware.biometrics.BiometricManager.Strings r0) {
            return r0.getSettingName();
        }

        static android.hardware.biometrics.BiometricManager.Strings getStrings(android.hardware.biometrics.BiometricManager r0, int r1) {
            return r0.getStrings(r1);
        }
    }

    public interface Authenticators {
        public static final int BIOMETRIC_STRONG = 15;
        public static final int BIOMETRIC_WEAK = 255;
        public static final int DEVICE_CREDENTIAL = 32768;
    }

    private static class DefaultInjector implements Injector {
        private final Context mContext;

        DefaultInjector(Context r3) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public android.hardware.biometrics.BiometricManager getBiometricManager() {
            return Api29Impl.create(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public FingerprintManagerCompat getFingerprintManager() {
            return FingerprintManagerCompat.from(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public Resources getResources() {
            return ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin");
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecurable() {
            if (KeyguardUtils.getKeyguardManager(this.mContext) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isDeviceSecuredWithCredential() {
            return KeyguardUtils.isDeviceSecuredWithCredential(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isFaceHardwarePresent() {
            return PackageUtils.hasSystemFeatureFace(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isFingerprintHardwarePresent() {
            return PackageUtils.hasSystemFeatureFingerprint(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isIrisHardwarePresent() {
            return PackageUtils.hasSystemFeatureIris(this.mContext);
        }

        @Override // androidx.biometric.BiometricManager.Injector
        public boolean isStrongBiometricGuaranteed() {
            return DeviceUtils.canAssumeStrongBiometrics(this.mContext, Build.MODEL);
        }
    }

    interface Injector {
        android.hardware.biometrics.BiometricManager getBiometricManager();

        FingerprintManagerCompat getFingerprintManager();

        Resources getResources();

        boolean isDeviceSecurable();

        boolean isDeviceSecuredWithCredential();

        boolean isFaceHardwarePresent();

        boolean isFingerprintHardwarePresent();

        boolean isIrisHardwarePresent();

        boolean isStrongBiometricGuaranteed();
    }

    public static class Strings {
        private final android.hardware.biometrics.BiometricManager.Strings mStrings;
        private final StringsCompat mStringsCompat;

        Strings(android.hardware.biometrics.BiometricManager.Strings r1) {
            this.mStrings = r1;
            this.mStringsCompat = null;
        }

        Strings(StringsCompat r2) {
            this.mStrings = null;
            this.mStringsCompat = r2;
        }

        public CharSequence getButtonLabel() {
            if (Build.VERSION.SDK_INT < 31) goto L8;
            android.hardware.biometrics.BiometricManager.Strings r0 = this.mStrings;
            if (r0 == null) goto L8;
            return Api31Impl.getButtonLabel(r0);
        L8:
            StringsCompat r2 = this.mStringsCompat;
            if (r2 != null) goto L11;
            Log.e(BiometricManager.TAG, "Failure in Strings.getButtonLabel(). No available string provider.");
            return null;
        L11:
            return r2.getButtonLabel();
        }

        public CharSequence getPromptMessage() {
            if (Build.VERSION.SDK_INT < 31) goto L8;
            android.hardware.biometrics.BiometricManager.Strings r0 = this.mStrings;
            if (r0 == null) goto L8;
            return Api31Impl.getPromptMessage(r0);
        L8:
            StringsCompat r2 = this.mStringsCompat;
            if (r2 != null) goto L11;
            Log.e(BiometricManager.TAG, "Failure in Strings.getPromptMessage(). No available string provider.");
            return null;
        L11:
            return r2.getPromptMessage();
        }

        public CharSequence getSettingName() {
            if (Build.VERSION.SDK_INT < 31) goto L8;
            android.hardware.biometrics.BiometricManager.Strings r0 = this.mStrings;
            if (r0 == null) goto L8;
            return Api31Impl.getSettingName(r0);
        L8:
            StringsCompat r2 = this.mStringsCompat;
            if (r2 != null) goto L11;
            Log.e(BiometricManager.TAG, "Failure in Strings.getSettingName(). No available string provider.");
            return null;
        L11:
            return r2.getSettingName();
        }
    }

    private class StringsCompat {
        private final int mAuthenticators;
        private final int mPossibleModalities;
        private final Resources mResources;
        final /* synthetic */ BiometricManager this$0;

        StringsCompat(BiometricManager r1, Resources r2, int r3, boolean r4, boolean r5, boolean r6, boolean r7) {
            this.this$0 = r1;
            this.mResources = r2;
            this.mAuthenticators = r3;
            if (r7 == true) goto L5;
        L7:
            int r8 = 0;
        L9:
            if (AuthenticatorUtils.isSomeBiometricAllowed(r3) == false) goto L16;
            if (r4 == false) goto L12;
            r8 = r8 | 4;
        L12:
            if (r5 == false) goto L14;
            r8 = r8 | 8;
        L14:
            if (r6 == false) goto L16;
            r8 = r8 | 2;
        L16:
            this.mPossibleModalities = r8;
            return;
        L5:
            if (AuthenticatorUtils.isDeviceCredentialAllowed(r3) == false) goto L7;
            r8 = 1;
            goto L9
        }

        CharSequence getButtonLabel() {
            int r0 = AuthenticatorUtils.getBiometricAuthenticators(this.mAuthenticators);
            if (this.this$0.canAuthenticate(r0) != 0) goto L14;
            int r1 = this.mPossibleModalities & (-2);
            if (r1 == 4) goto L12;
            Resources r3 = this.mResources;
            if (r1 == 8) goto L11;
            int r2 = R.string.use_biometric_label;
            String r4 = "use_biometric_label";
        L10:
            return r3.getString(ZeusTransformUtils.mapRes(r2, TypedValues.Custom.S_STRING, r4));
        L11:
            r2 = R.string.use_face_label;
            r4 = "use_face_label";
            goto L10
        L12:
            r3 = this.mResources;
            r2 = R.string.use_fingerprint_label;
            r4 = "use_fingerprint_label";
            goto L10
        L14:
            if ((this.mPossibleModalities & 1) == 0) goto L16;
            r3 = this.mResources;
            r2 = R.string.use_screen_lock_label;
            r4 = "use_screen_lock_label";
            goto L10
        L16:
            return null;
        }

        CharSequence getPromptMessage() {
            int r0 = AuthenticatorUtils.getBiometricAuthenticators(this.mAuthenticators);
            if (this.this$0.canAuthenticate(r0) != 0) goto L25;
            int r1 = this.mPossibleModalities & (-2);
            if (r1 == 4) goto L18;
            if (r1 == 8) goto L14;
            if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mAuthenticators) == false) goto L11;
            int r2 = R.string.biometric_or_screen_lock_prompt_message;
            String r3 = "biometric_or_screen_lock_prompt_message";
        L12:
            int r4 = ZeusTransformUtils.mapRes(r2, TypedValues.Custom.S_STRING, r3);
            Resources r5 = this.mResources;
        L23:
            return r5.getString(r4);
        L11:
            r2 = R.string.biometric_prompt_message;
            r3 = "biometric_prompt_message";
            goto L12
        L14:
            if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mAuthenticators) == false) goto L16;
            r2 = R.string.face_or_screen_lock_prompt_message;
            r3 = "face_or_screen_lock_prompt_message";
            goto L12
        L16:
            r2 = R.string.face_prompt_message;
            r3 = "face_prompt_message";
            goto L12
        L18:
            if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mAuthenticators) == false) goto L20;
            r2 = R.string.fingerprint_or_screen_lock_prompt_message;
            r3 = "fingerprint_or_screen_lock_prompt_message";
            goto L12
        L20:
            r2 = R.string.fingerprint_prompt_message;
            r3 = "fingerprint_prompt_message";
            goto L12
        L25:
            if ((this.mPossibleModalities & 1) == 0) goto L27;
            r5 = this.mResources;
            r4 = ZeusTransformUtils.mapRes(R.string.screen_lock_prompt_message, TypedValues.Custom.S_STRING, "screen_lock_prompt_message");
            goto L23
        L27:
            return null;
        }

        CharSequence getSettingName() {
            int r0 = this.mPossibleModalities;
            if (r0 != 0) goto L5;
            return null;
        L5:
            if (r0 != 1) goto L7;
            Resources r6 = this.mResources;
            int r1 = R.string.use_screen_lock_label;
            String r2 = "use_screen_lock_label";
        L25:
            int r3 = ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r2);
        L29:
            return r6.getString(r3);
        L7:
            if (r0 != 2) goto L9;
        L23:
            r6 = this.mResources;
            r3 = ZeusTransformUtils.mapRes(R.string.use_biometric_label, TypedValues.Custom.S_STRING, "use_biometric_label");
            goto L29
        L9:
            if (r0 != 4) goto L11;
            r6 = this.mResources;
            r1 = R.string.use_fingerprint_label;
            r2 = "use_fingerprint_label";
            goto L25
        L11:
            if (r0 != 8) goto L13;
            r6 = this.mResources;
            r1 = R.string.use_face_label;
            r2 = "use_face_label";
            goto L25
        L13:
            if ((r0 & 1) == 0) goto L23;
            int r4 = r0 & (-2);
            r6 = this.mResources;
            if (r4 == 4) goto L20;
            if (r4 == 8) goto L19;
            r1 = R.string.use_biometric_or_screen_lock_label;
            r2 = "use_biometric_or_screen_lock_label";
            goto L25
        L19:
            r1 = R.string.use_face_or_screen_lock_label;
            r2 = "use_face_or_screen_lock_label";
            goto L25
        L20:
            r1 = R.string.use_fingerprint_or_screen_lock_label;
            r2 = "use_fingerprint_or_screen_lock_label";
            goto L25
        }
    }

    BiometricManager(Injector r4) {
        Injector r5 = (Injector) ZeusTransformUtils.wrapperContextForParams(r4, Injector.class, "com.obric.memorydata.plugin");
        this.mInjector = r5;
        FingerprintManagerCompat r1 = null;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        android.hardware.biometrics.BiometricManager r0 = r5.getBiometricManager();
    L6:
        this.mBiometricManager = r0;
        if (Build.VERSION.SDK_INT > 29) goto L9;
        r1 = r5.getFingerprintManager();
    L9:
        this.mFingerprintManager = r1;
        return;
    L5:
        r0 = null;
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
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r4) == false) goto L20;
        if (this.mInjector.isDeviceSecuredWithCredential() == false) goto L17;
        return 0;
    L17:
        return 11;
    L20:
        if (Build.VERSION.SDK_INT != 29) goto L27;
        if (AuthenticatorUtils.isWeakBiometricAllowed(r4) == false) goto L25;
        return canAuthenticateWithWeakBiometricOnApi29();
    L25:
        return canAuthenticateWithStrongBiometricOnApi29();
    L27:
        if (Build.VERSION.SDK_INT != 28) goto L33;
        if (this.mInjector.isFingerprintHardwarePresent() == true) goto L31;
        return 12;
    L31:
        return canAuthenticateWithFingerprintOrUnknownBiometric();
    L33:
        return canAuthenticateWithFingerprint();
    }

    private int canAuthenticateWithFingerprint() {
        FingerprintManagerCompat r0 = this.mFingerprintManager;
        if (r0 != null) goto L7;
        Log.e(TAG, "Failure in canAuthenticate(). FingerprintManager was null.");
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
        boolean r0 = this.mInjector.isDeviceSecuredWithCredential();
        int r1 = canAuthenticateWithFingerprint();
        if (r0 == true) goto L5;
        return r1;
    L5:
        if (r1 != 0) goto L7;
        return 0;
    L7:
        return -1;
    }

    private int canAuthenticateWithStrongBiometricOnApi29() {
        Method r1 = Api29Impl.getCanAuthenticateWithCryptoMethod();
        if (r1 == null) goto L18;
        android.hardware.biometrics.BiometricPrompt.CryptoObject r2 = CryptoObjectUtils.wrapForBiometricPrompt(CryptoObjectUtils.createFakeCryptoObject());
        if (r2 == null) goto L18;
    L16:
        e = move-exception;
        Log.w(TAG, "Failed to invoke canAuthenticate(CryptoObject).", e);
        goto L18
    L7:
        if (Build.VERSION.SDK_INT != 29) goto L9;
        Object r3 = r1.invoke(this.mBiometricManager, new Object[]{r2});     // Catch: Throwable -> L16
    L11:
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == true) goto L13;
        Log.w(TAG, "Invalid return type for canAuthenticate(CryptoObject).");     // Catch: Throwable -> L16
        goto L18
    L13:
        return ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L9:
        r3 = null;
    L18:
        int r0 = canAuthenticateWithWeakBiometricOnApi29();
        if (this.mInjector.isStrongBiometricGuaranteed() == true) goto L24;
        if (r0 != 0) goto L24;
        return canAuthenticateWithFingerprintOrUnknownBiometric();
    L24:
        return r0;
    }

    private int canAuthenticateWithWeakBiometricOnApi29() {
        android.hardware.biometrics.BiometricManager r1 = this.mBiometricManager;
        if (r1 != null) goto L7;
        Log.e(TAG, "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    L7:
        return Api29Impl.canAuthenticate(r1);
    }

    public static BiometricManager from(Context r2) {
        return new BiometricManager(new DefaultInjector((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")));
    }

    @Deprecated
    public int canAuthenticate() {
        return canAuthenticate(255);
    }

    public int canAuthenticate(int r3) {
        if (Build.VERSION.SDK_INT < 30) goto L11;
        android.hardware.biometrics.BiometricManager r2 = this.mBiometricManager;
        if (r2 != null) goto L9;
        Log.e(TAG, "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    L9:
        return Api30Impl.canAuthenticate(r2, r3);
    L11:
        return canAuthenticateCompat(r3);
    }

    public Strings getStrings(int r10) {
        if (Build.VERSION.SDK_INT < 31) goto L11;
        if (this.mBiometricManager != null) goto L9;
        Log.e(TAG, "Failure in getStrings(). BiometricManager was null.");
        return null;
    L9:
        return new Strings(Api31Impl.getStrings(this.mBiometricManager, r10));
    L11:
        return new Strings(new StringsCompat(this, this.mInjector.getResources(), r10, this.mInjector.isFingerprintHardwarePresent(), this.mInjector.isFaceHardwarePresent(), this.mInjector.isIrisHardwarePresent(), this.mInjector.isDeviceSecuredWithCredential()));
    }
}
