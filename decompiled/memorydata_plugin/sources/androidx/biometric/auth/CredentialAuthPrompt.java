package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class CredentialAuthPrompt {
    private final BiometricPrompt.PromptInfo mPromptInfo;

    public static final class Builder {
        private CharSequence mDescription;
        private final CharSequence mTitle;

        public Builder(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.mDescription = null;
            this.mTitle = r4;
        }

        public CredentialAuthPrompt build() {
            return new CredentialAuthPrompt(new BiometricPrompt.PromptInfo.Builder().setTitle(this.mTitle).setDescription(this.mDescription).setAllowedAuthenticators(32768).build());
        }

        public Builder setDescription(CharSequence r3) {
            this.mDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    CredentialAuthPrompt(BiometricPrompt.PromptInfo r1) {
        this.mPromptInfo = r1;
    }

    public CharSequence getDescription() {
        return this.mPromptInfo.getDescription();
    }

    public CharSequence getTitle() {
        return this.mPromptInfo.getTitle();
    }

    public AuthPrompt startAuthentication(AuthPromptHost r2, BiometricPrompt.CryptoObject r3, AuthPromptCallback r4) {
        return AuthPromptUtils.startAuthentication(r2, this.mPromptInfo, r3, null, r4);
    }

    public AuthPrompt startAuthentication(AuthPromptHost r3, BiometricPrompt.CryptoObject r4, Executor r5, AuthPromptCallback r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        return AuthPromptUtils.startAuthentication(r3, this.mPromptInfo, r4, r7, r6);
    }
}
