package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class BiometricFragment extends Fragment {
    private static final String ARG_HAS_FACE = "has_face";
    private static final String ARG_HAS_FINGERPRINT = "has_fingerprint";
    private static final String ARG_HAS_IRIS = "has_iris";
    private static final String ARG_HOST_ACTIVITY = "host_activity";
    static final int CANCELED_FROM_CLIENT = 3;
    static final int CANCELED_FROM_INTERNAL = 0;
    static final int CANCELED_FROM_NEGATIVE_BUTTON = 2;
    static final int CANCELED_FROM_USER = 1;
    private static final int DISMISS_INSTANTLY_DELAY_MS = 500;
    private static final String FINGERPRINT_DIALOG_FRAGMENT_TAG = "androidx.biometric.FingerprintDialogFragment";
    private static final int HIDE_DIALOG_DELAY_MS = 2000;
    private static final int REQUEST_CONFIRM_CREDENTIAL = 1;
    private static final int SHOW_PROMPT_DELAY_MS = 600;
    private static final String TAG = "BiometricFragment";
    private Handler mHandler;
    private BiometricViewModel mViewModel;

    private static class Api21Impl {
        private Api21Impl() {
        }

        static Intent createConfirmDeviceCredentialIntent(KeyguardManager r2, CharSequence r3, CharSequence r4) {
            return r2.createConfirmDeviceCredentialIntent((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static void authenticate(android.hardware.biometrics.BiometricPrompt r2, android.hardware.biometrics.BiometricPrompt.CryptoObject r3, CancellationSignal r4, Executor r5, android.hardware.biometrics.BiometricPrompt.AuthenticationCallback r6) {
            r2.authenticate(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"), r6);
        }

        static void authenticate(android.hardware.biometrics.BiometricPrompt r2, CancellationSignal r3, Executor r4, android.hardware.biometrics.BiometricPrompt.AuthenticationCallback r5) {
            r2.authenticate(r3, (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin"), r5);
        }

        static android.hardware.biometrics.BiometricPrompt buildPrompt(android.hardware.biometrics.BiometricPrompt.Builder r0) {
            return r0.build();
        }

        static android.hardware.biometrics.BiometricPrompt.Builder createPromptBuilder(Context r2) {
            return new android.hardware.biometrics.BiometricPrompt.Builder((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        }

        static void setDescription(android.hardware.biometrics.BiometricPrompt.Builder r2, CharSequence r3) {
            r2.setDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static void setNegativeButton(android.hardware.biometrics.BiometricPrompt.Builder r2, CharSequence r3, Executor r4, DialogInterface.OnClickListener r5) {
            r2.setNegativeButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
        }

        static void setSubtitle(android.hardware.biometrics.BiometricPrompt.Builder r2, CharSequence r3) {
            r2.setSubtitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static void setTitle(android.hardware.biometrics.BiometricPrompt.Builder r2, CharSequence r3) {
            r2.setTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static void setConfirmationRequired(android.hardware.biometrics.BiometricPrompt.Builder r0, boolean r1) {
            r0.setConfirmationRequired(r1);
        }

        static void setDeviceCredentialAllowed(android.hardware.biometrics.BiometricPrompt.Builder r0, boolean r1) {
            r0.setDeviceCredentialAllowed(r1);
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static void setAllowedAuthenticators(android.hardware.biometrics.BiometricPrompt.Builder r0, int r1) {
            r0.setAllowedAuthenticators(r1);
        }
    }

    private static class PromptExecutor implements Executor {
        private final Handler mPromptHandler;

        PromptExecutor() {
            this.mPromptHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.mPromptHandler.post(r4);
        }
    }

    private static class ShowPromptForAuthenticationRunnable implements Runnable {
        private final WeakReference<BiometricFragment> mFragmentRef;

        ShowPromptForAuthenticationRunnable(BiometricFragment r2) {
            this.mFragmentRef = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mFragmentRef.get() == null) goto L6;
            ((BiometricFragment) ZeusTransformUtils.preCheckCast(this.mFragmentRef.get(), BiometricFragment.class, "com.obric.memorydata.plugin")).showPromptForAuthentication();
            return;
        }
    }

    private static class StopDelayingPromptRunnable implements Runnable {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        StopDelayingPromptRunnable(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mViewModelRef.get() == null) goto L6;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setDelayingPrompt(false);
            return;
        }
    }

    private static class StopIgnoringCancelRunnable implements Runnable {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        StopIgnoringCancelRunnable(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mViewModelRef.get() == null) goto L6;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setIgnoringCancel(false);
            return;
        }
    }

    public BiometricFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private static int checkForFingerprintPreAuthenticationErrors(FingerprintManagerCompat r1) {
        if (r1.isHardwareDetected() == true) goto L7;
        return 12;
    L7:
        if (r1.hasEnrolledFingerprints() == true) goto L10;
        return 11;
    L10:
        return 0;
    }

    private void connectViewModel() {
        this.mViewModel.setClientActivity((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"));
        this.mViewModel.getAuthenticationResult().observe(this, new $$Lambda$BiometricFragment$2ddWOuiWQaPGa7VPDq_MEcohs(this));
        this.mViewModel.getAuthenticationError().observe(this, new $$Lambda$BiometricFragment$QKCS5hOlTHrKpvsmlEeV2U158dk(this));
        this.mViewModel.getAuthenticationHelpMessage().observe(this, new $$Lambda$BiometricFragment$_e8dMN1EVeECrppIXmVq2JfJp0w(this));
        this.mViewModel.isAuthenticationFailurePending().observe(this, new $$Lambda$BiometricFragment$aP8x2hxE1QV3raJbLq0T6xigFLI(this));
        this.mViewModel.isNegativeButtonPressPending().observe(this, new $$Lambda$BiometricFragment$Rn90qzTs4QevOiBa1e4dXBLWW8(this));
        this.mViewModel.isFingerprintDialogCancelPending().observe(this, new $$Lambda$BiometricFragment$blBcEICmBmIkqPeixCuCZ5ObnQ(this));
    }

    private void dismissFingerprintDialog() {
        this.mViewModel.setPromptShowing(false);
        if (isAdded() == false) goto L11;
        FragmentManager r3 = getParentFragmentManager();
        FingerprintDialogFragment r0 = (FingerprintDialogFragment) ZeusTransformUtils.preCheckCast(r3.findFragmentByTag(FINGERPRINT_DIALOG_FRAGMENT_TAG), FingerprintDialogFragment.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isAdded() == false) goto L9;
        r0.dismissAllowingStateLoss();
        return;
    L9:
        r3.beginTransaction().remove(r0).commitAllowingStateLoss();
        return;
    }

    private int getDismissDialogDelay() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return 2000;
    L5:
        if (DeviceUtils.shouldHideFingerprintDialog(r2, Build.MODEL) == false) goto L7;
        return 0;
    }

    private void handleConfirmCredentialResult(int r4) {
        int r0 = -1;
        if (r4 == (-1)) goto L5;
        sendErrorAndDismiss(10, getString(ZeusTransformUtils.mapRes(R.string.generic_error_user_canceled, TypedValues.Custom.S_STRING, "generic_error_user_canceled")));
        return;
    L5:
        if (this.mViewModel.isUsingKeyguardManagerForBiometricAndCredential() == false) goto L7;
        this.mViewModel.setUsingKeyguardManagerForBiometricAndCredential(false);
    L8:
        sendSuccessAndDismiss(new BiometricPrompt.AuthenticationResult(null, r0));
        return;
    L7:
        r0 = 1;
        goto L8
    }

    private boolean hasFace() {
        return getArguments().getBoolean(ARG_HAS_FACE, PackageUtils.hasSystemFeatureFace((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
    }

    private boolean hasFingerprint() {
        return getArguments().getBoolean(ARG_HAS_FINGERPRINT, PackageUtils.hasSystemFeatureFingerprint((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
    }

    private boolean hasIris() {
        return getArguments().getBoolean(ARG_HAS_IRIS, PackageUtils.hasSystemFeatureIris((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
    }

    private boolean isChangingConfigurations() {
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isChangingConfigurations() == false) goto L7;
        return true;
    }

    private boolean isFingerprintDialogNeededForCrypto() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mViewModel.getCryptoObject() == null) goto L9;
        if (DeviceUtils.shouldUseFingerprintForCrypto(r0, Build.MANUFACTURER, Build.MODEL) == false) goto L9;
        return true;
    }

    private boolean isFingerprintDialogNeededForErrorHandling() {
        if (Build.VERSION.SDK_INT == 28) goto L5;
    L7:
        return false;
    L5:
        if (hasFingerprint() == true) goto L7;
        return true;
    }

    private boolean isHostedInActivity() {
        return getArguments().getBoolean(ARG_HOST_ACTIVITY, true);
    }

    private boolean isKeyguardManagerNeededForBiometricAndCredential() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (DeviceUtils.shouldUseKeyguardManagerForBiometricAndCredential(r0, Build.MANUFACTURER) == false) goto L14;
        int r1 = this.mViewModel.getAllowedAuthenticators();
        if (AuthenticatorUtils.isWeakBiometricAllowed(r1) == true) goto L9;
        return false;
    L9:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r1) == false) goto L16;
        this.mViewModel.setUsingKeyguardManagerForBiometricAndCredential(true);
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    private boolean isKeyguardManagerNeededForCredential() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT != 29) goto L12;
        if (hasFingerprint() == true) goto L12;
        if (hasFace() == true) goto L12;
        if (hasIris() == true) goto L12;
        return true;
    L12:
        if (isManagingDeviceCredentialButton() == true) goto L14;
    L16:
        return false;
    L14:
        if (BiometricManager.from(r0).canAuthenticate(255) == 0) goto L16;
        return true;
    }

    private boolean isUsingFingerprintDialog() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L10:
        return true;
    L5:
        if (isFingerprintDialogNeededForCrypto() == true) goto L10;
        if (isFingerprintDialogNeededForErrorHandling() == true) goto L10;
        return false;
    }

    private void launchConfirmCredentialActivity() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        KeyguardManager r1 = KeyguardUtils.getKeyguardManager(r0);
    L7:
        if (r1 != null) goto L10;
        sendErrorAndDismiss(12, getString(ZeusTransformUtils.mapRes(R.string.generic_error_no_keyguard, TypedValues.Custom.S_STRING, "generic_error_no_keyguard")));
        return;
    L10:
        CharSequence r3 = this.mViewModel.getTitle();
        CharSequence r4 = this.mViewModel.getSubtitle();
        CharSequence r5 = this.mViewModel.getDescription();
        if (r4 != null) goto L14;
        r4 = r5;
    L14:
        Intent r2 = Api21Impl.createConfirmDeviceCredentialIntent(r1, r3, r4);
        if (r2 != null) goto L18;
        sendErrorAndDismiss(14, getString(ZeusTransformUtils.mapRes(R.string.generic_error_no_device_credential, TypedValues.Custom.S_STRING, "generic_error_no_device_credential")));
        return;
    L18:
        this.mViewModel.setConfirmingDeviceCredential(true);
        if (isUsingFingerprintDialog() == false) goto L21;
        dismissFingerprintDialog();
    L21:
        r2.setFlags(134742016);
        ZeusTransformUtils.startActivityForResult(this, r2, 1, "com.obric.memorydata.plugin");
        return;
    L5:
        r1 = null;
        goto L7
    }

    static BiometricFragment newInstance(Handler r2, BiometricViewModel r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        BiometricFragment r0 = new BiometricFragment();
        Bundle r1 = new Bundle();
        r0.mHandler = r2;
        r0.mViewModel = r3;
        r1.putBoolean(ARG_HOST_ACTIVITY, r4);
        r1.putBoolean(ARG_HAS_FINGERPRINT, r5);
        r1.putBoolean(ARG_HAS_FACE, r6);
        r1.putBoolean(ARG_HAS_IRIS, r7);
        r0.setArguments(r1);
        return r0;
    }

    static BiometricFragment newInstance(boolean r3) {
        BiometricFragment r0 = new BiometricFragment();
        Bundle r1 = new Bundle();
        r1.putBoolean(ARG_HOST_ACTIVITY, r3);
        r0.setArguments(r1);
        return r0;
    }

    private void sendErrorToClient(final int r3, CharSequence r4) {
        final CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mViewModel.isConfirmingDeviceCredential() == false) goto L7;
        Log.v(TAG, "Error not sent to client. User is confirming their device credential.");
        return;
    L7:
        if (this.mViewModel.isAwaitingResult() == true) goto L10;
        Log.w(TAG, "Error not sent to client. Client is not awaiting a result.");
        return;
    L10:
        this.mViewModel.setAwaitingResult(false);
        this.mViewModel.getClientExecutor().execute(new $$Lambda$BiometricFragment$xi7Z9PFs6q9GB7xPQh59l1NxCpE(this, r3, r5));
    }

    private void sendFailureToClient() {
        if (this.mViewModel.isAwaitingResult() == true) goto L6;
        Log.w(TAG, "Failure not sent to client. Client is not awaiting a result.");
        return;
    L6:
        this.mViewModel.getClientExecutor().execute(new $$Lambda$BiometricFragment$fvUEFcXU5inIB8iWh6oRvzTGk(this));
    }

    private void sendSuccessAndDismiss(BiometricPrompt.AuthenticationResult r1) {
        sendSuccessToClient(r1);
        dismiss();
    }

    private void sendSuccessToClient(final BiometricPrompt.AuthenticationResult r3) {
        if (this.mViewModel.isAwaitingResult() == true) goto L6;
        Log.w(TAG, "Success not sent to client. Client is not awaiting a result.");
        return;
    L6:
        this.mViewModel.setAwaitingResult(false);
        this.mViewModel.getClientExecutor().execute(new $$Lambda$BiometricFragment$KJ5vvu3wbmVB3JOrGMAhphLNgRw(this, r3));
    }

    private void showBiometricPromptForAuthentication() {
        android.hardware.biometrics.BiometricPrompt.Builder r0 = Api28Impl.createPromptBuilder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        CharSequence r2 = this.mViewModel.getTitle();
        CharSequence r3 = this.mViewModel.getSubtitle();
        CharSequence r4 = this.mViewModel.getDescription();
        if (r2 == null) goto L5;
        Api28Impl.setTitle(r0, r2);
    L5:
        if (r3 == null) goto L7;
        Api28Impl.setSubtitle(r0, r3);
    L7:
        if (r4 == null) goto L9;
        Api28Impl.setDescription(r0, r4);
    L9:
        CharSequence r5 = this.mViewModel.getNegativeButtonText();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        Api28Impl.setNegativeButton(r0, r5, this.mViewModel.getClientExecutor(), this.mViewModel.getNegativeButtonListener());
    L13:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        Api29Impl.setConfirmationRequired(r0, this.mViewModel.isConfirmationRequired());
    L15:
        int r6 = this.mViewModel.getAllowedAuthenticators();
        if (Build.VERSION.SDK_INT < 30) goto L19;
        Api30Impl.setAllowedAuthenticators(r0, r6);
    L21:
        authenticateWithBiometricPrompt(Api28Impl.buildPrompt(r0), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Api29Impl.setDeviceCredentialAllowed(r0, AuthenticatorUtils.isDeviceCredentialAllowed(r6));
        goto L21
    }

    private void showFingerprintDialogForAuthentication() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        FingerprintManagerCompat r1 = FingerprintManagerCompat.from(r0);
        int r2 = checkForFingerprintPreAuthenticationErrors(r1);
        if (r2 == 0) goto L7;
        sendErrorAndDismiss(r2, ErrorUtils.getFingerprintErrorString(r0, r2));
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L11;
        Log.e(TAG, "Unable to show fingerprint dialog on API <19.");
        return;
    L11:
        if (isAdded() == false) goto L17;
        this.mViewModel.setFingerprintDialogDismissedInstantly(true);
        if (DeviceUtils.shouldHideFingerprintDialog(r0, Build.MODEL) == true) goto L15;
        this.mHandler.postDelayed(new $$Lambda$BiometricFragment$l7dyx7GptXdNjM5fdCquf0LQ3o(this), 500);
        FingerprintDialogFragment.newInstance(isHostedInActivity()).show(getParentFragmentManager(), FINGERPRINT_DIALOG_FRAGMENT_TAG);
    L15:
        this.mViewModel.setCanceledFrom(0);
        authenticateWithFingerprint(r1, r0);
        return;
    }

    private void showFingerprintErrorMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        r4 = getString(ZeusTransformUtils.mapRes(R.string.default_error_msg, TypedValues.Custom.S_STRING, "default_error_msg"));
    L6:
        this.mViewModel.setFingerprintDialogState(2);
        this.mViewModel.setFingerprintDialogHelpMessage(r4);
    }

    void authenticate(BiometricPrompt.PromptInfo r3, BiometricPrompt.CryptoObject r4) {
        this.mViewModel.setPromptInfo(r3);
        int r5 = AuthenticatorUtils.getConsolidatedAuthenticators(r3, r4);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L10:
        BiometricViewModel r6 = this.mViewModel;
    L11:
        r6.setCryptoObject(r4);
        if (isManagingDeviceCredentialButton() == false) goto L14;
        BiometricViewModel r7 = this.mViewModel;
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.confirm_device_credential_password, TypedValues.Custom.S_STRING, "confirm_device_credential_password"));
    L15:
        r7.setNegativeButtonTextOverride(r8);
        if (Build.VERSION.SDK_INT < 21) goto L22;
        if (isKeyguardManagerNeededForCredential() == false) goto L22;
        this.mViewModel.setAwaitingResult(true);
        launchConfirmCredentialActivity();
        return;
    L22:
        if (this.mViewModel.isDelayingPrompt() == false) goto L24;
        this.mHandler.postDelayed(new ShowPromptForAuthenticationRunnable(this), 600);
        return;
    L24:
        showPromptForAuthentication();
        return;
    L14:
        r7 = this.mViewModel;
        r8 = null;
        goto L15
    L5:
        if (Build.VERSION.SDK_INT >= 30) goto L10;
        if (r5 != 15) goto L10;
        if (r4 != null) goto L10;
        r6 = this.mViewModel;
        r4 = CryptoObjectUtils.createFakeCryptoObject();
        goto L11
    }

    void authenticateWithBiometricPrompt(android.hardware.biometrics.BiometricPrompt r5, Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        android.hardware.biometrics.BiometricPrompt.CryptoObject r0 = CryptoObjectUtils.wrapForBiometricPrompt(this.mViewModel.getCryptoObject());
        CancellationSignal r1 = this.mViewModel.getCancellationSignalProvider().getBiometricCancellationSignal();
        PromptExecutor r2 = new PromptExecutor();
        android.hardware.biometrics.BiometricPrompt.AuthenticationCallback r3 = this.mViewModel.getAuthenticationCallbackProvider().getBiometricCallback();
        if (r0 != null) goto L5;
        Api28Impl.authenticate(r5, r1, r2, r3);     // Catch: NullPointerException -> L7
    L14:
        return;
    L5:
        Api28Impl.authenticate(r5, r0, r1, r2, r3);     // Catch: NullPointerException -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Got NPE while authenticating with biometric prompt.", e);
        if (r7 == null) goto L11;
        String r8 = r7.getString(ZeusTransformUtils.mapRes(R.string.default_error_msg, TypedValues.Custom.S_STRING, "default_error_msg"));
    L12:
        sendErrorAndDismiss(1, r8);
        return;
    L11:
        r8 = "";
        goto L12
    }

    void authenticateWithFingerprint(FingerprintManagerCompat r8, Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        r8.authenticate(CryptoObjectUtils.wrapForFingerprintManager(this.mViewModel.getCryptoObject()), 0, this.mViewModel.getCancellationSignalProvider().getFingerprintCancellationSignal(), this.mViewModel.getAuthenticationCallbackProvider().getFingerprintCallback(), null);     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Got NPE while authenticating with fingerprint.", e);
        sendErrorAndDismiss(1, ErrorUtils.getFingerprintErrorString(r10, 1));
    }

    void cancelAuthentication(int r3) {
        if (r3 == 3) goto L8;
        if (this.mViewModel.isIgnoringCancel() == false) goto L8;
        return;
    L8:
        if (isUsingFingerprintDialog() == false) goto L12;
        this.mViewModel.setCanceledFrom(r3);
        if (r3 != 1) goto L12;
        sendErrorToClient(10, ErrorUtils.getFingerprintErrorString((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 10));
    L12:
        this.mViewModel.getCancellationSignalProvider().cancel();
    }

    void dismiss() {
        dismissFingerprintDialog();
        this.mViewModel.setPromptShowing(false);
        if (this.mViewModel.isConfirmingDeviceCredential() == false) goto L5;
    L7:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return;
    L10:
        if (DeviceUtils.shouldDelayShowingPrompt(r0, Build.MODEL) == false) goto L14;
        this.mViewModel.setDelayingPrompt(true);
        this.mHandler.postDelayed(new StopDelayingPromptRunnable(this.mViewModel), 600);
        return;
    L14:
        return;
    L5:
        if (isAdded() == false) goto L7;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        goto L7
    }

    BiometricViewModel getViewModel() {
        return this.mViewModel;
    }

    boolean isManagingDeviceCredentialButton() {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
    L7:
        return false;
    L5:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L7;
        return true;
    }

    public /* synthetic */ void lambda$connectViewModel$0$BiometricFragment(BiometricPrompt.AuthenticationResult r1) {
        if (r1 == null) goto L5;
        onAuthenticationSucceeded(r1);
        this.mViewModel.setAuthenticationResult(null);
        return;
    }

    public /* synthetic */ void lambda$connectViewModel$1$BiometricFragment(BiometricErrorData r2) {
        if (r2 == null) goto L5;
        onAuthenticationError(r2.getErrorCode(), r2.getErrorMessage());
        this.mViewModel.setAuthenticationError(null);
        return;
    }

    public /* synthetic */ void lambda$connectViewModel$2$BiometricFragment(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        onAuthenticationHelp(r4);
        this.mViewModel.setAuthenticationError(null);
        return;
    }

    public /* synthetic */ void lambda$connectViewModel$3$BiometricFragment(Boolean r1) {
        if (r1.booleanValue() == false) goto L6;
        onAuthenticationFailed();
        this.mViewModel.setAuthenticationFailurePending(false);
        return;
    }

    public /* synthetic */ void lambda$connectViewModel$4$BiometricFragment(Boolean r1) {
        if (r1.booleanValue() == true) goto L5;
        return;
    L5:
        if (isManagingDeviceCredentialButton() == false) goto L7;
        onDeviceCredentialButtonPressed();
    L8:
        this.mViewModel.setNegativeButtonPressPending(false);
        return;
    L7:
        onCancelButtonPressed();
        goto L8
    }

    public /* synthetic */ void lambda$connectViewModel$5$BiometricFragment(Boolean r1) {
        if (r1.booleanValue() == false) goto L6;
        cancelAuthentication(1);
        dismiss();
        this.mViewModel.setFingerprintDialogCancelPending(false);
        return;
    }

    public /* synthetic */ void lambda$onAuthenticationError$7$BiometricFragment(int r3, CharSequence r4) {
        sendErrorAndDismiss(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ void lambda$sendErrorToClient$9$BiometricFragment(int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        this.mViewModel.getClientCallback().onAuthenticationError(r3, r5);
    }

    public /* synthetic */ void lambda$sendFailureToClient$10$BiometricFragment() {
        this.mViewModel.getClientCallback().onAuthenticationFailed();
    }

    public /* synthetic */ void lambda$sendSuccessToClient$8$BiometricFragment(BiometricPrompt.AuthenticationResult r1) {
        this.mViewModel.getClientCallback().onAuthenticationSucceeded(r1);
    }

    public /* synthetic */ void lambda$showFingerprintDialogForAuthentication$6$BiometricFragment() {
        this.mViewModel.setFingerprintDialogDismissedInstantly(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 != 1) goto L6;
        this.mViewModel.setConfirmingDeviceCredential(false);
        handleConfirmCredentialResult(r2);
        return;
    }

    void onAuthenticationError(final int r5, CharSequence r6) {
        final CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (ErrorUtils.isKnownError(r5) == true) goto L6;
        r5 = 8;
    L6:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L20;
        if (Build.VERSION.SDK_INT >= 29) goto L20;
        if (ErrorUtils.isLockoutError(r5) == false) goto L20;
        if (r0 == null) goto L20;
        if (KeyguardUtils.isDeviceSecuredWithCredential(r0) == false) goto L20;
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L20;
        launchConfirmCredentialActivity();
        return;
    L20:
        if (isUsingFingerprintDialog() == false) goto L37;
        if (r7 != null) goto L25;
        r7 = ErrorUtils.getFingerprintErrorString((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    L25:
        if (r5 != 5) goto L33;
        int r1 = this.mViewModel.getCanceledFrom();
        if (r1 != 0) goto L29;
    L30:
        sendErrorToClient(r5, r7);
    L31:
        dismiss();
        return;
    L29:
        if (r1 != 3) goto L31;
    L33:
        if (this.mViewModel.isFingerprintDialogDismissedInstantly() == false) goto L35;
        sendErrorAndDismiss(r5, r7);
    L36:
        this.mViewModel.setFingerprintDialogDismissedInstantly(true);
        return;
    L35:
        showFingerprintErrorMessage(r7);
        this.mHandler.postDelayed(new $$Lambda$BiometricFragment$rdb3FsyRS2bKMO0xWduHFgXmpfQ(this, r5, r7), getDismissDialogDelay());
        goto L36
    L37:
        if (r7 != null) goto L40;
        r7 = getString(ZeusTransformUtils.mapRes(R.string.default_error_msg, TypedValues.Custom.S_STRING, "default_error_msg")) + " " + r5;
    L40:
        sendErrorAndDismiss(r5, r7);
    }

    void onAuthenticationFailed() {
        if (isUsingFingerprintDialog() == false) goto L5;
        showFingerprintErrorMessage(getString(ZeusTransformUtils.mapRes(R.string.fingerprint_not_recognized, TypedValues.Custom.S_STRING, "fingerprint_not_recognized")));
    L5:
        sendFailureToClient();
    }

    void onAuthenticationHelp(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (isUsingFingerprintDialog() == false) goto L6;
        showFingerprintErrorMessage(r4);
        return;
    }

    void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult r1) {
        sendSuccessAndDismiss(r1);
    }

    void onCancelButtonPressed() {
        CharSequence r0 = this.mViewModel.getNegativeButtonText();
        if (r0 != null) goto L6;
        r0 = getString(ZeusTransformUtils.mapRes(R.string.default_error_msg, TypedValues.Custom.S_STRING, "default_error_msg"));
    L6:
        sendErrorAndDismiss(13, r0);
        cancelAuthentication(2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (this.mViewModel != null) goto L5;
        this.mViewModel = BiometricPrompt.getViewModel(this, isHostedInActivity());
    L5:
        connectViewModel();
    }

    void onDeviceCredentialButtonPressed() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        Log.e(TAG, "Failed to check device credential. Not supported prior to API 21.");
        return;
    L6:
        launchConfirmCredentialActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29) goto L5;
        return;
    L5:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L9;
        this.mViewModel.setIgnoringCancel(true);
        this.mHandler.postDelayed(new StopIgnoringCancelRunnable(this.mViewModel), 250);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return;
    L5:
        if (this.mViewModel.isConfirmingDeviceCredential() == false) goto L7;
        return;
    L7:
        if (isChangingConfigurations() == true) goto L12;
        cancelAuthentication(0);
        return;
    }

    void sendErrorAndDismiss(int r3, CharSequence r4) {
        sendErrorToClient(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        dismiss();
    }

    void showPromptForAuthentication() {
        if (this.mViewModel.isPromptShowing() == false) goto L5;
        return;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L8;
        Log.w(TAG, "Not showing biometric prompt. Context is null.");
        return;
    L8:
        this.mViewModel.setPromptShowing(true);
        this.mViewModel.setAwaitingResult(true);
        if (Build.VERSION.SDK_INT < 21) goto L14;
        if (isKeyguardManagerNeededForBiometricAndCredential() == false) goto L14;
        launchConfirmCredentialActivity();
        return;
    L14:
        if (isUsingFingerprintDialog() == false) goto L16;
        showFingerprintDialogForAuthentication();
        return;
    L16:
        showBiometricPromptForAuthentication();
    }
}
