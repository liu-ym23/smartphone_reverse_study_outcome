package androidx.biometric;

import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class BiometricPrompt {
    public static final int AUTHENTICATION_RESULT_TYPE_BIOMETRIC = 2;
    public static final int AUTHENTICATION_RESULT_TYPE_DEVICE_CREDENTIAL = 1;
    public static final int AUTHENTICATION_RESULT_TYPE_UNKNOWN = -1;
    private static final String BIOMETRIC_FRAGMENT_TAG = "androidx.biometric.BiometricFragment";
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

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r1, CharSequence r2) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r1) {
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

            public Builder() {
                this.mTitle = null;
                this.mSubtitle = null;
                this.mDescription = null;
                this.mNegativeButtonText = null;
                this.mIsConfirmationRequired = true;
                this.mIsDeviceCredentialAllowed = false;
                this.mAllowedAuthenticators = 0;
            }

            public Builder setAllowedAuthenticators(int r1) {
                this.mAllowedAuthenticators = r1;
                return this;
            }

            public Builder setConfirmationRequired(boolean r1) {
                this.mIsConfirmationRequired = r1;
                return this;
            }

            public Builder setDescription(CharSequence r1) {
                this.mDescription = r1;
                return this;
            }

            public Builder setDeviceCredentialAllowed(boolean r1) {
                this.mIsDeviceCredentialAllowed = r1;
                return this;
            }

            public Builder setNegativeButtonText(CharSequence r1) {
                this.mNegativeButtonText = r1;
                return this;
            }

            public Builder setSubtitle(CharSequence r1) {
                this.mSubtitle = r1;
                return this;
            }

            public Builder setTitle(CharSequence r1) {
                this.mTitle = r1;
                return this;
            }
        }

        public CharSequence getNegativeButtonText() {
            CharSequence r0 = this.mNegativeButtonText;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        public int getAllowedAuthenticators() {
            return this.mAllowedAuthenticators;
        }

        public CharSequence getDescription() {
            return this.mDescription;
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

        public boolean isDeviceCredentialAllowed() {
            return this.mIsDeviceCredentialAllowed;
        }

        public PromptInfo(CharSequence r1, CharSequence r2, CharSequence r3, CharSequence r4, boolean r5, boolean r6, int r7) {
            this.mTitle = r1;
            this.mSubtitle = r2;
            this.mDescription = r3;
            this.mNegativeButtonText = r4;
            this.mIsConfirmationRequired = r5;
            this.mIsDeviceCredentialAllowed = r6;
            this.mAllowedAuthenticators = r7;
        }
    }

    public void cancelAuthentication() {
        FragmentManager r0 = this.mClientFragmentManager;
        if (r0 != null) goto L5;
        return;
    L5:
        BiometricFragment r1 = findBiometricFragment(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        r1.cancelAuthentication(3);
    }

    private static BiometricFragment findBiometricFragment(FragmentManager r1) {
        return r1.findFragmentByTag(BIOMETRIC_FRAGMENT_TAG);
    }

    private static BiometricFragment findOrAddBiometricFragment(FragmentManager r3) {
        BiometricFragment r0 = findBiometricFragment(r3);
        if (r0 != null) goto L6;
        BiometricFragment r1 = BiometricFragment.newInstance();
        INVOKEVIRTUAL_androidx_biometric_BiometricPrompt_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r3.beginTransaction(), r1, BIOMETRIC_FRAGMENT_TAG).commitAllowingStateLoss();
        r3.executePendingTransactions();
        return r1;
    L6:
        return r0;
    }

    private static BiometricViewModel getViewModel(FragmentActivity r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new ViewModelProvider(r1).get(BiometricViewModel.class);
    }

    public void authenticate(PromptInfo r2) {
        if (r2 == null) goto L6;
        authenticateInternal(r2, null);
        return;
    L6:
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    public BiometricPrompt(Fragment r3, AuthenticationCallback r4) {
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        FragmentActivity r0 = r3.getActivity();
        FragmentManager r1 = r3.getChildFragmentManager();
        BiometricViewModel r2 = getViewModel(r0);
        addObservers(r3, r2);
        init(r1, r2, null, r4);
        return;
    L8:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L10:
        throw new IllegalArgumentException("Fragment must not be null.");
    }

    private static void addObservers(Fragment r1, BiometricViewModel r2) {
        if (r2 == null) goto L5;
        r1.getLifecycle().addObserver(new ResetCallbackObserver(r2));
        return;
    }

    private void authenticateInternal(PromptInfo r2, CryptoObject r3) {
        FragmentManager r0 = this.mClientFragmentManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isStateSaved() == false) goto L8;
        return;
    L8:
        findOrAddBiometricFragment(this.mClientFragmentManager).authenticate(r2, r3);
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

    public BiometricPrompt(FragmentActivity r3, AuthenticationCallback r4) {
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        init(r3.getSupportFragmentManager(), getViewModel(r3), null, r4);
        return;
    L8:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L10:
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    public BiometricPrompt(Fragment r3, Executor r4, AuthenticationCallback r5) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L11;
        if (r5 == null) goto L9;
        FragmentActivity r0 = r3.getActivity();
        FragmentManager r1 = r3.getChildFragmentManager();
        BiometricViewModel r2 = getViewModel(r0);
        addObservers(r3, r2);
        init(r1, r2, r4, r5);
        return;
    L9:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L11:
        throw new IllegalArgumentException("Executor must not be null.");
    L13:
        throw new IllegalArgumentException("Fragment must not be null.");
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_biometric_BiometricPrompt_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    public BiometricPrompt(FragmentActivity r2, Executor r3, AuthenticationCallback r4) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L11;
        if (r4 == null) goto L9;
        init(r2.getSupportFragmentManager(), getViewModel(r2), r3, r4);
        return;
    L9:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L11:
        throw new IllegalArgumentException("Executor must not be null.");
    L13:
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    private void init(FragmentManager r1, BiometricViewModel r2, Executor r3, AuthenticationCallback r4) {
        this.mClientFragmentManager = r1;
        if (r2 == null) goto L8;
        if (r3 == null) goto L6;
        r2.setClientExecutor(r3);
    L6:
        r2.setClientCallback(r4);
        return;
    }
}
