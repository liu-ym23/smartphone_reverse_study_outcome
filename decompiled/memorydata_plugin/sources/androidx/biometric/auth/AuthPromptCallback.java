package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class AuthPromptCallback {
    public AuthPromptCallback() {
    }

    public void onAuthenticationError(FragmentActivity r1, int r2, CharSequence r3) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r1, FragmentActivity.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public void onAuthenticationFailed(FragmentActivity r2) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin");
    }

    public void onAuthenticationSucceeded(FragmentActivity r1, BiometricPrompt.AuthenticationResult r2) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r1, FragmentActivity.class, "com.obric.memorydata.plugin");
    }
}
