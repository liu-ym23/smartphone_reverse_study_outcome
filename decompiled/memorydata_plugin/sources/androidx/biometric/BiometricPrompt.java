package androidx.biometric;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.identity.PresentationSession;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public class BiometricPrompt {
    public static final int AUTHENTICATION_RESULT_TYPE_BIOMETRIC = 2;
    public static final int AUTHENTICATION_RESULT_TYPE_DEVICE_CREDENTIAL = 1;
    public static final int AUTHENTICATION_RESULT_TYPE_UNKNOWN = -1;
    static final String BIOMETRIC_FRAGMENT_TAG = "androidx.biometric.BiometricFragment";
    static final int BIOMETRIC_SUCCESS = 0;
    public static final int ERROR_CANCELED = 5;
    public static final int ERROR_HW_NOT_PRESENT = 12;
    public static final int ERROR_HW_UNAVAILABLE = 1;
    public static final int ERROR_LOCKOUT = 7;
    public static final int ERROR_LOCKOUT_PERMANENT = 9;
    public static final int ERROR_NEGATIVE_BUTTON = 13;
    public static final int ERROR_NO_BIOMETRICS = 11;
    public static final int ERROR_NO_DEVICE_CREDENTIAL = 14;
    public static final int ERROR_NO_SPACE = 4;
    public static final int ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int ERROR_TIMEOUT = 3;
    public static final int ERROR_UNABLE_TO_PROCESS = 2;
    public static final int ERROR_USER_CANCELED = 10;
    public static final int ERROR_VENDOR = 8;
    private static final String TAG = "BiometricPromptCompat";
    private FragmentManager mClientFragmentManager;
    private boolean mHostedInActivity;

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r1, CharSequence r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r1) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AuthenticationError {
    }

    public static class AuthenticationResult {
        private final int mAuthenticationType;
        private final CryptoObject mCryptoObject;

        AuthenticationResult(CryptoObject r1, int r2) {
            this.mCryptoObject = r1;
            this.mAuthenticationType = r2;
        }

        public int getAuthenticationType() {
            return this.mAuthenticationType;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final IdentityCredential mIdentityCredential;
        private final Mac mMac;
        private final PresentationSession mPresentationSession;
        private final Signature mSignature;

        public CryptoObject(IdentityCredential r2) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = r2;
            this.mPresentationSession = null;
        }

        public CryptoObject(PresentationSession r2) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = null;
            this.mPresentationSession = r2;
        }

        public CryptoObject(Signature r1) {
            this.mSignature = r1;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = null;
            this.mPresentationSession = null;
        }

        public CryptoObject(Cipher r2) {
            this.mSignature = null;
            this.mCipher = r2;
            this.mMac = null;
            this.mIdentityCredential = null;
            this.mPresentationSession = null;
        }

        public CryptoObject(Mac r2) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = r2;
            this.mIdentityCredential = null;
            this.mPresentationSession = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public IdentityCredential getIdentityCredential() {
            return this.mIdentityCredential;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public PresentationSession getPresentationSession() {
            return this.mPresentationSession;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    public static class PromptInfo {
        private final int mAllowedAuthenticators;
        private final CharSequence mDescription;
        private final boolean mIsConfirmationRequired;
        private final boolean mIsDeviceCredentialAllowed;
        private final CharSequence mNegativeButtonText;
        private final CharSequence mSubtitle;
        private final CharSequence mTitle;

        public static class Builder {
            private int mAllowedAuthenticators;
            private CharSequence mDescription;
            private boolean mIsConfirmationRequired;
            private boolean mIsDeviceCredentialAllowed;
            private CharSequence mNegativeButtonText;
            private CharSequence mSubtitle;
            private CharSequence mTitle;

            public Builder() {
                this.mTitle = null;
                this.mSubtitle = null;
                this.mDescription = null;
                this.mNegativeButtonText = null;
                this.mIsConfirmationRequired = true;
                this.mIsDeviceCredentialAllowed = false;
                this.mAllowedAuthenticators = 0;
            }

            public PromptInfo build() {
                if (TextUtils.isEmpty(this.mTitle) == true) goto L27;
                if (AuthenticatorUtils.isSupportedCombination(this.mAllowedAuthenticators) == false) goto L25;
                int r0 = this.mAllowedAuthenticators;
                if (r0 == 0) goto L9;
                boolean r1 = AuthenticatorUtils.isDeviceCredentialAllowed(r0);
            L11:
                if (TextUtils.isEmpty(this.mNegativeButtonText) == false) goto L17;
                if (r1 == true) goto L17;
                throw new IllegalArgumentException("Negative text must be set and non-empty.");
            L17:
                if (TextUtils.isEmpty(this.mNegativeButtonText) == true) goto L23;
                if (r1 == false) goto L23;
                throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
            L23:
                return new PromptInfo(this.mTitle, this.mSubtitle, this.mDescription, this.mNegativeButtonText, this.mIsConfirmationRequired, this.mIsDeviceCredentialAllowed, this.mAllowedAuthenticators);
            L9:
                r1 = this.mIsDeviceCredentialAllowed;
                goto L11
            L25:
                throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + AuthenticatorUtils.convertToString(this.mAllowedAuthenticators));
            L27:
                throw new IllegalArgumentException("Title must be set and non-empty.");
            }

            public Builder setAllowedAuthenticators(int r1) {
                this.mAllowedAuthenticators = r1;
                return this;
            }

            public Builder setConfirmationRequired(boolean r1) {
                this.mIsConfirmationRequired = r1;
                return this;
            }

            public Builder setDescription(CharSequence r3) {
                this.mDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }

            @Deprecated
            public Builder setDeviceCredentialAllowed(boolean r1) {
                this.mIsDeviceCredentialAllowed = r1;
                return this;
            }

            public Builder setNegativeButtonText(CharSequence r3) {
                this.mNegativeButtonText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }

            public Builder setSubtitle(CharSequence r3) {
                this.mSubtitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }

            public Builder setTitle(CharSequence r3) {
                this.mTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                return this;
            }
        }

        PromptInfo(CharSequence r3, CharSequence r4, CharSequence r5, CharSequence r6, boolean r7, boolean r8, int r9) {
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
            this.mTitle = r10;
            this.mSubtitle = r11;
            this.mDescription = r12;
            this.mNegativeButtonText = r13;
            this.mIsConfirmationRequired = r7;
            this.mIsDeviceCredentialAllowed = r8;
            this.mAllowedAuthenticators = r9;
        }

        public int getAllowedAuthenticators() {
            return this.mAllowedAuthenticators;
        }

        public CharSequence getDescription() {
            return this.mDescription;
        }

        public CharSequence getNegativeButtonText() {
            CharSequence r0 = this.mNegativeButtonText;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public boolean isConfirmationRequired() {
            return this.mIsConfirmationRequired;
        }

        @Deprecated
        public boolean isDeviceCredentialAllowed() {
            return this.mIsDeviceCredentialAllowed;
        }
    }

    private static class ResetCallbackObserver implements DefaultLifecycleObserver {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        ResetCallbackObserver(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner r3) {
            LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
            if (this.mViewModelRef.get() == null) goto L6;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).resetClientCallback();
            return;
        }
    }

    public BiometricPrompt(Fragment r7, AuthenticationCallback r8) {
        if (r7 == null) goto L10;
        if (r8 == null) goto L8;
        FragmentManager r2 = r7.getChildFragmentManager();
        BiometricViewModel r3 = (BiometricViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r7).get(BiometricViewModel.class), BiometricViewModel.class, "com.obric.memorydata.plugin");
        addObservers(r7, r3);
        init(false, r2, r3, null, r8);
        return;
    L8:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L10:
        throw new IllegalArgumentException("Fragment must not be null.");
    }

    public BiometricPrompt(Fragment r9, Executor r10, AuthenticationCallback r11) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        if (r6 == null) goto L11;
        if (r11 == null) goto L9;
        FragmentManager r4 = r9.getChildFragmentManager();
        BiometricViewModel r5 = (BiometricViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r9).get(BiometricViewModel.class), BiometricViewModel.class, "com.obric.memorydata.plugin");
        addObservers(r9, r5);
        init(false, r4, r5, r6, r11);
        return;
    L9:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L11:
        throw new IllegalArgumentException("Executor must not be null.");
    L13:
        throw new IllegalArgumentException("Fragment must not be null.");
    }

    public BiometricPrompt(FragmentActivity r9, AuthenticationCallback r10) {
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r9, FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L10;
        if (r10 == null) goto L8;
        init(true, r11.getSupportFragmentManager(), (BiometricViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r11).get(BiometricViewModel.class), BiometricViewModel.class, "com.obric.memorydata.plugin"), null, r10);
        return;
    L8:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L10:
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    public BiometricPrompt(FragmentActivity r9, Executor r10, AuthenticationCallback r11) {
        FragmentActivity r12 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r9, FragmentActivity.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L13;
        if (r6 == null) goto L11;
        if (r11 == null) goto L9;
        init(true, r12.getSupportFragmentManager(), (BiometricViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r12).get(BiometricViewModel.class), BiometricViewModel.class, "com.obric.memorydata.plugin"), r6, r11);
        return;
    L9:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L11:
        throw new IllegalArgumentException("Executor must not be null.");
    L13:
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    private static void addObservers(Fragment r1, BiometricViewModel r2) {
        r1.getLifecycle().addObserver(new ResetCallbackObserver(r2));
    }

    private void authenticateInternal(PromptInfo r3, CryptoObject r4) {
        FragmentManager r0 = this.mClientFragmentManager;
        if (r0 != null) goto L7;
        Log.e(TAG, "Unable to start authentication. Client fragment manager was null.");
        return;
    L7:
        if (r0.isStateSaved() == false) goto L10;
        Log.e(TAG, "Unable to start authentication. Called after onSaveInstanceState().");
        return;
    L10:
        findOrAddBiometricFragment().authenticate(r3, r4);
    }

    private static BiometricFragment findBiometricFragment(FragmentManager r2) {
        return (BiometricFragment) ZeusTransformUtils.preCheckCast(r2.findFragmentByTag(BIOMETRIC_FRAGMENT_TAG), BiometricFragment.class, "com.obric.memorydata.plugin");
    }

    private BiometricFragment findOrAddBiometricFragment() {
        BiometricFragment r0 = findBiometricFragment(this.mClientFragmentManager);
        if (r0 != null) goto L6;
        BiometricFragment r1 = BiometricFragment.newInstance(this.mHostedInActivity);
        this.mClientFragmentManager.beginTransaction().add(r1, BIOMETRIC_FRAGMENT_TAG).commitAllowingStateLoss();
        this.mClientFragmentManager.executePendingTransactions();
        return r1;
    L6:
        return r0;
    }

    static BiometricViewModel getViewModel(Fragment r2, boolean r3) {
        if (r3 == false) goto L5;
        ViewModelStoreOwner r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L8;
        r4 = r2.getParentFragment();
    L8:
        if (r4 == null) goto L12;
        return (BiometricViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r4).get(BiometricViewModel.class), BiometricViewModel.class, "com.obric.memorydata.plugin");
    L12:
        throw new IllegalStateException("view model not found");
    L5:
        r4 = null;
        goto L6
    }

    private void init(boolean r3, FragmentManager r4, BiometricViewModel r5, Executor r6, AuthenticationCallback r7) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        this.mHostedInActivity = r3;
        this.mClientFragmentManager = r4;
        if (r8 == null) goto L5;
        r5.setClientExecutor(r8);
    L5:
        r5.setClientCallback(r7);
    }

    public void authenticate(PromptInfo r2) {
        if (r2 == null) goto L6;
        authenticateInternal(r2, null);
        return;
    L6:
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    public void authenticate(PromptInfo r4, CryptoObject r5) {
        if (r4 == null) goto L20;
        if (r5 == null) goto L18;
        int r0 = AuthenticatorUtils.getConsolidatedAuthenticators(r4, r5);
        if (AuthenticatorUtils.isWeakBiometricAllowed(r0) == true) goto L16;
        if (Build.VERSION.SDK_INT < 30) goto L9;
    L13:
        authenticateInternal(r4, r5);
        return;
    L9:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r0) == false) goto L13;
        throw new IllegalArgumentException("Crypto-based authentication is not supported for device credential prior to API 30.");
    L16:
        throw new IllegalArgumentException("Crypto-based authentication is not supported for Class 2 (Weak) biometrics.");
    L18:
        throw new IllegalArgumentException("CryptoObject cannot be null.");
    L20:
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    public void cancelAuthentication() {
        FragmentManager r1 = this.mClientFragmentManager;
        if (r1 != null) goto L6;
        Log.e(TAG, "Unable to start authentication. Client fragment manager was null.");
        return;
    L6:
        BiometricFragment r2 = findBiometricFragment(r1);
        if (r2 != null) goto L10;
        Log.e(TAG, "Unable to cancel authentication. BiometricFragment not found.");
        return;
    L10:
        r2.cancelAuthentication(3);
    }
}
