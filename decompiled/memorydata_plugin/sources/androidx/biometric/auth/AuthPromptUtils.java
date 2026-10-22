package androidx.biometric.auth;

import android.os.Handler;
import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.BiometricViewModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class AuthPromptUtils {

    private static class AuthPromptWrapper implements AuthPrompt {
        private final WeakReference<BiometricPrompt> mBiometricPromptRef;

        AuthPromptWrapper(BiometricPrompt r2) {
            this.mBiometricPromptRef = new WeakReference(r2);
        }

        @Override // androidx.biometric.auth.AuthPrompt
        public void cancelAuthentication() {
            if (this.mBiometricPromptRef.get() == null) goto L6;
            ((BiometricPrompt) ZeusTransformUtils.preCheckCast(this.mBiometricPromptRef.get(), BiometricPrompt.class, "com.obric.memorydata.plugin")).cancelAuthentication();
            return;
        }
    }

    private static class AuthenticationCallbackWrapper extends BiometricPrompt.AuthenticationCallback {
        private final AuthPromptCallback mClientCallback;
        private final WeakReference<BiometricViewModel> mViewModelRef;

        AuthenticationCallbackWrapper(AuthPromptCallback r1, BiometricViewModel r2) {
            this.mClientCallback = r1;
            this.mViewModelRef = new WeakReference(r2);
        }

        private static FragmentActivity getActivity(WeakReference<BiometricViewModel> r2) {
            if (r2.get() != null) goto L7;
            return null;
        L7:
            return (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((BiometricViewModel) ZeusTransformUtils.preCheckCast(r2.get(), BiometricViewModel.class, "com.obric.memorydata.plugin")).getClientActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int r4, CharSequence r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            this.mClientCallback.onAuthenticationError((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(this.mViewModelRef), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), r4, r6);
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.mClientCallback.onAuthenticationFailed((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(this.mViewModelRef), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult r4) {
            this.mClientCallback.onAuthenticationSucceeded((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(this.mViewModelRef), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), r4);
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

    private AuthPromptUtils() {
    }

    private static BiometricPrompt createBiometricPrompt(AuthPromptHost r4, Executor r5, AuthPromptCallback r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        r7 = new DefaultExecutor();
    L7:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L10;
        AuthenticationCallbackWrapper r8 = wrapCallback(r6, new ViewModelProvider((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")));
        return new BiometricPrompt((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), r7, r8);
    L10:
        if (r4.getFragment() == null) goto L16;
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getFragment().getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")) == null) goto L16;
        AuthenticationCallbackWrapper r9 = wrapCallback(r6, new ViewModelProvider((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getFragment().getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")));
        return new BiometricPrompt(r4.getFragment(), r7, r9);
    L16:
        throw new IllegalArgumentException("AuthPromptHost must contain a FragmentActivity or an attached Fragment.");
    }

    static AuthPrompt startAuthentication(AuthPromptHost r2, BiometricPrompt.PromptInfo r3, BiometricPrompt.CryptoObject r4, Executor r5, AuthPromptCallback r6) {
        BiometricPrompt r7 = createBiometricPrompt(r2, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"), r6);
        if (r4 != null) goto L5;
        r7.authenticate(r3);
    L7:
        return new AuthPromptWrapper(r7);
    L5:
        r7.authenticate(r3, r4);
        goto L7
    }

    private static AuthenticationCallbackWrapper wrapCallback(AuthPromptCallback r3, ViewModelProvider r4) {
        return new AuthenticationCallbackWrapper(r3, (BiometricViewModel) ZeusTransformUtils.preCheckCast(r4.get(BiometricViewModel.class), BiometricViewModel.class, "com.obric.memorydata.plugin"));
    }
}
