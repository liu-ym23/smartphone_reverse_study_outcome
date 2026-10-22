package androidx.biometric;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class BiometricViewModel extends ViewModel {
    private AuthenticationCallbackProvider mAuthenticationCallbackProvider;
    private MutableLiveData<BiometricErrorData> mAuthenticationError;
    private MutableLiveData<CharSequence> mAuthenticationHelpMessage;
    private MutableLiveData<BiometricPrompt.AuthenticationResult> mAuthenticationResult;
    private int mCanceledFrom;
    private CancellationSignalProvider mCancellationSignalProvider;
    private WeakReference<FragmentActivity> mClientActivity;
    private BiometricPrompt.AuthenticationCallback mClientCallback;
    private Executor mClientExecutor;
    private BiometricPrompt.CryptoObject mCryptoObject;
    private MutableLiveData<CharSequence> mFingerprintDialogHelpMessage;
    private int mFingerprintDialogPreviousState;
    private MutableLiveData<Integer> mFingerprintDialogState;
    private MutableLiveData<Boolean> mIsAuthenticationFailurePending;
    private boolean mIsAwaitingResult;
    private boolean mIsConfirmingDeviceCredential;
    private boolean mIsDelayingPrompt;
    private MutableLiveData<Boolean> mIsFingerprintDialogCancelPending;
    private boolean mIsFingerprintDialogDismissedInstantly;
    private boolean mIsIgnoringCancel;
    private MutableLiveData<Boolean> mIsNegativeButtonPressPending;
    private boolean mIsPromptShowing;
    private boolean mIsUsingKeyguardManagerForBiometricAndCredential;
    private DialogInterface.OnClickListener mNegativeButtonListener;
    private CharSequence mNegativeButtonTextOverride;
    private BiometricPrompt.PromptInfo mPromptInfo;

    private static final class CallbackListener extends AuthenticationCallbackProvider.Listener {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        CallbackListener(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void onError(int r4, CharSequence r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.mViewModelRef.get() != null) goto L5;
            return;
        L5:
            if (((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).isConfirmingDeviceCredential() == false) goto L7;
            return;
        L7:
            if (((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).isAwaitingResult() == false) goto L12;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setAuthenticationError(new BiometricErrorData(r4, r6));
            return;
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void onFailure() {
            if (this.mViewModelRef.get() != null) goto L5;
            return;
        L5:
            if (((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).isAwaitingResult() == false) goto L9;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setAuthenticationFailurePending(true);
            return;
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void onHelp(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.mViewModelRef.get() == null) goto L6;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setAuthenticationHelpMessage(r4);
            return;
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void onSuccess(BiometricPrompt.AuthenticationResult r5) {
            if (this.mViewModelRef.get() != null) goto L5;
            return;
        L5:
            if (((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).isAwaitingResult() == true) goto L7;
            return;
        L7:
            if (r5.getAuthenticationType() != (-1)) goto L9;
            r5 = new BiometricPrompt.AuthenticationResult(r5.getCryptoObject(), ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).getInferredAuthenticationResultType());
        L9:
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setAuthenticationResult(r5);
        }
    }

    private static class DefaultExecutor implements Executor {
        private final Handler mHandler;

        DefaultExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.mHandler.post(r4);
        }
    }

    private static class NegativeButtonListener implements DialogInterface.OnClickListener {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        NegativeButtonListener(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
            if (this.mViewModelRef.get() == null) goto L6;
            ((BiometricViewModel) ZeusTransformUtils.preCheckCast(this.mViewModelRef.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).setNegativeButtonPressPending(true);
            return;
        }
    }

    public BiometricViewModel() {
        this.mCanceledFrom = 0;
        this.mIsFingerprintDialogDismissedInstantly = true;
        this.mFingerprintDialogPreviousState = 0;
    }

    private static <T> void updateValue(MutableLiveData<T> r2, T r3) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L5;
        r2.setValue(r3);
        return;
    L5:
        r2.postValue(r3);
    }

    int getAllowedAuthenticators() {
        BiometricPrompt.PromptInfo r0 = this.mPromptInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return AuthenticatorUtils.getConsolidatedAuthenticators(r0, this.mCryptoObject);
    }

    AuthenticationCallbackProvider getAuthenticationCallbackProvider() {
        if (this.mAuthenticationCallbackProvider != null) goto L6;
        this.mAuthenticationCallbackProvider = new AuthenticationCallbackProvider(new CallbackListener(this));
    L6:
        return this.mAuthenticationCallbackProvider;
    }

    MutableLiveData<BiometricErrorData> getAuthenticationError() {
        if (this.mAuthenticationError != null) goto L6;
        this.mAuthenticationError = new MutableLiveData();
    L6:
        return this.mAuthenticationError;
    }

    LiveData<CharSequence> getAuthenticationHelpMessage() {
        if (this.mAuthenticationHelpMessage != null) goto L6;
        this.mAuthenticationHelpMessage = new MutableLiveData();
    L6:
        return this.mAuthenticationHelpMessage;
    }

    LiveData<BiometricPrompt.AuthenticationResult> getAuthenticationResult() {
        if (this.mAuthenticationResult != null) goto L6;
        this.mAuthenticationResult = new MutableLiveData();
    L6:
        return this.mAuthenticationResult;
    }

    int getCanceledFrom() {
        return this.mCanceledFrom;
    }

    CancellationSignalProvider getCancellationSignalProvider() {
        if (this.mCancellationSignalProvider != null) goto L6;
        this.mCancellationSignalProvider = new CancellationSignalProvider();
    L6:
        return this.mCancellationSignalProvider;
    }

    public FragmentActivity getClientActivity() {
        WeakReference<FragmentActivity> r2 = this.mClientActivity;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (FragmentActivity) ZeusTransformUtils.preCheckCast(r2.get(), FragmentActivity.class, "com.obric.memorydata.plugin");
    }

    BiometricPrompt.AuthenticationCallback getClientCallback() {
        if (this.mClientCallback != null) goto L6;
        this.mClientCallback = new AnonymousClass1(this);
    L6:
        return this.mClientCallback;
    }

    Executor getClientExecutor() {
        Executor r0 = this.mClientExecutor;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new DefaultExecutor();
    }

    BiometricPrompt.CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }

    CharSequence getDescription() {
        BiometricPrompt.PromptInfo r0 = this.mPromptInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDescription();
    }

    LiveData<CharSequence> getFingerprintDialogHelpMessage() {
        if (this.mFingerprintDialogHelpMessage != null) goto L6;
        this.mFingerprintDialogHelpMessage = new MutableLiveData();
    L6:
        return this.mFingerprintDialogHelpMessage;
    }

    int getFingerprintDialogPreviousState() {
        return this.mFingerprintDialogPreviousState;
    }

    LiveData<Integer> getFingerprintDialogState() {
        if (this.mFingerprintDialogState != null) goto L6;
        this.mFingerprintDialogState = new MutableLiveData();
    L6:
        return this.mFingerprintDialogState;
    }

    int getInferredAuthenticationResultType() {
        int r1 = getAllowedAuthenticators();
        if (AuthenticatorUtils.isSomeBiometricAllowed(r1) == true) goto L5;
        return -1;
    L5:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r1) == true) goto L10;
        return 2;
    L10:
        return -1;
    }

    DialogInterface.OnClickListener getNegativeButtonListener() {
        if (this.mNegativeButtonListener != null) goto L6;
        this.mNegativeButtonListener = new NegativeButtonListener(this);
    L6:
        return this.mNegativeButtonListener;
    }

    CharSequence getNegativeButtonText() {
        CharSequence r0 = this.mNegativeButtonTextOverride;
        if (r0 == null) goto L5;
        return r0;
    L5:
        BiometricPrompt.PromptInfo r1 = this.mPromptInfo;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getNegativeButtonText();
    }

    CharSequence getSubtitle() {
        BiometricPrompt.PromptInfo r0 = this.mPromptInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSubtitle();
    }

    CharSequence getTitle() {
        BiometricPrompt.PromptInfo r0 = this.mPromptInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTitle();
    }

    LiveData<Boolean> isAuthenticationFailurePending() {
        if (this.mIsAuthenticationFailurePending != null) goto L6;
        this.mIsAuthenticationFailurePending = new MutableLiveData();
    L6:
        return this.mIsAuthenticationFailurePending;
    }

    boolean isAwaitingResult() {
        return this.mIsAwaitingResult;
    }

    boolean isConfirmationRequired() {
        BiometricPrompt.PromptInfo r0 = this.mPromptInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isConfirmationRequired() == true) goto L8;
        return false;
    }

    boolean isConfirmingDeviceCredential() {
        return this.mIsConfirmingDeviceCredential;
    }

    boolean isDelayingPrompt() {
        return this.mIsDelayingPrompt;
    }

    LiveData<Boolean> isFingerprintDialogCancelPending() {
        if (this.mIsFingerprintDialogCancelPending != null) goto L6;
        this.mIsFingerprintDialogCancelPending = new MutableLiveData();
    L6:
        return this.mIsFingerprintDialogCancelPending;
    }

    boolean isFingerprintDialogDismissedInstantly() {
        return this.mIsFingerprintDialogDismissedInstantly;
    }

    boolean isIgnoringCancel() {
        return this.mIsIgnoringCancel;
    }

    LiveData<Boolean> isNegativeButtonPressPending() {
        if (this.mIsNegativeButtonPressPending != null) goto L6;
        this.mIsNegativeButtonPressPending = new MutableLiveData();
    L6:
        return this.mIsNegativeButtonPressPending;
    }

    boolean isPromptShowing() {
        return this.mIsPromptShowing;
    }

    boolean isUsingKeyguardManagerForBiometricAndCredential() {
        return this.mIsUsingKeyguardManagerForBiometricAndCredential;
    }

    void resetClientCallback() {
        this.mClientCallback = null;
    }

    void setAuthenticationError(BiometricErrorData r2) {
        if (this.mAuthenticationError != null) goto L5;
        this.mAuthenticationError = new MutableLiveData();
    L5:
        updateValue(this.mAuthenticationError, r2);
    }

    void setAuthenticationFailurePending(boolean r2) {
        if (this.mIsAuthenticationFailurePending != null) goto L5;
        this.mIsAuthenticationFailurePending = new MutableLiveData();
    L5:
        updateValue(this.mIsAuthenticationFailurePending, Boolean.valueOf(r2));
    }

    void setAuthenticationHelpMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mAuthenticationHelpMessage != null) goto L5;
        this.mAuthenticationHelpMessage = new MutableLiveData();
    L5:
        updateValue(this.mAuthenticationHelpMessage, r4);
    }

    void setAuthenticationResult(BiometricPrompt.AuthenticationResult r2) {
        if (this.mAuthenticationResult != null) goto L5;
        this.mAuthenticationResult = new MutableLiveData();
    L5:
        updateValue(this.mAuthenticationResult, r2);
    }

    void setAwaitingResult(boolean r1) {
        this.mIsAwaitingResult = r1;
    }

    void setCanceledFrom(int r1) {
        this.mCanceledFrom = r1;
    }

    void setClientActivity(FragmentActivity r3) {
        this.mClientActivity = new WeakReference((FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin"));
    }

    void setClientCallback(BiometricPrompt.AuthenticationCallback r1) {
        this.mClientCallback = r1;
    }

    void setClientExecutor(Executor r3) {
        this.mClientExecutor = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
    }

    void setConfirmingDeviceCredential(boolean r1) {
        this.mIsConfirmingDeviceCredential = r1;
    }

    void setCryptoObject(BiometricPrompt.CryptoObject r1) {
        this.mCryptoObject = r1;
    }

    void setDelayingPrompt(boolean r1) {
        this.mIsDelayingPrompt = r1;
    }

    void setFingerprintDialogCancelPending(boolean r2) {
        if (this.mIsFingerprintDialogCancelPending != null) goto L5;
        this.mIsFingerprintDialogCancelPending = new MutableLiveData();
    L5:
        updateValue(this.mIsFingerprintDialogCancelPending, Boolean.valueOf(r2));
    }

    void setFingerprintDialogDismissedInstantly(boolean r1) {
        this.mIsFingerprintDialogDismissedInstantly = r1;
    }

    void setFingerprintDialogHelpMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mFingerprintDialogHelpMessage != null) goto L5;
        this.mFingerprintDialogHelpMessage = new MutableLiveData();
    L5:
        updateValue(this.mFingerprintDialogHelpMessage, r4);
    }

    void setFingerprintDialogPreviousState(int r1) {
        this.mFingerprintDialogPreviousState = r1;
    }

    void setFingerprintDialogState(int r2) {
        if (this.mFingerprintDialogState != null) goto L5;
        this.mFingerprintDialogState = new MutableLiveData();
    L5:
        updateValue(this.mFingerprintDialogState, Integer.valueOf(r2));
    }

    void setIgnoringCancel(boolean r1) {
        this.mIsIgnoringCancel = r1;
    }

    void setNegativeButtonPressPending(boolean r2) {
        if (this.mIsNegativeButtonPressPending != null) goto L5;
        this.mIsNegativeButtonPressPending = new MutableLiveData();
    L5:
        updateValue(this.mIsNegativeButtonPressPending, Boolean.valueOf(r2));
    }

    void setNegativeButtonTextOverride(CharSequence r3) {
        this.mNegativeButtonTextOverride = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    void setPromptInfo(BiometricPrompt.PromptInfo r1) {
        this.mPromptInfo = r1;
    }

    void setPromptShowing(boolean r1) {
        this.mIsPromptShowing = r1;
    }

    void setUsingKeyguardManagerForBiometricAndCredential(boolean r1) {
        this.mIsUsingKeyguardManagerForBiometricAndCredential = r1;
    }
}
