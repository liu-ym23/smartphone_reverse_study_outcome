package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class Class3BiometricOrCredentialAuthPrompt {
    private final BiometricPrompt.PromptInfo mPromptInfo;

    public static final class Builder {
        private CharSequence mDescription;
        private boolean mIsConfirmationRequired;
        private CharSequence mSubtitle;
        private final CharSequence mTitle;

        public Builder(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.mSubtitle = null;
            this.mDescription = null;
            this.mIsConfirmationRequired = true;
            this.mTitle = r4;
        }

        public Class3BiometricOrCredentialAuthPrompt build() {
            return new Class3BiometricOrCredentialAuthPrompt(new BiometricPrompt.PromptInfo.Builder().setTitle(this.mTitle).setSubtitle(this.mSubtitle).setDescription(this.mDescription).setConfirmationRequired(this.mIsConfirmationRequired).setAllowedAuthenticators(32783).build());
        }

        public Builder setConfirmationRequired(boolean r1) {
            this.mIsConfirmationRequired = r1;
            return this;
        }

        public Builder setDescription(CharSequence r3) {
            this.mDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setSubtitle(CharSequence r3) {
            this.mSubtitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    Class3BiometricOrCredentialAuthPrompt(BiometricPrompt.PromptInfo r1) {
        this.mPromptInfo = r1;
    }

    public CharSequence getDescription() {
        return this.mPromptInfo.getDescription();
    }

    public CharSequence getSubtitle() {
        return this.mPromptInfo.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mPromptInfo.getTitle();
    }

    public boolean isConfirmationRequired() {
        return this.mPromptInfo.isConfirmationRequired();
    }

    public AuthPrompt startAuthentication(AuthPromptHost r2, BiometricPrompt.CryptoObject r3, AuthPromptCallback r4) {
        return AuthPromptUtils.startAuthentication(r2, this.mPromptInfo, r3, null, r4);
    }

    public AuthPrompt startAuthentication(AuthPromptHost r3, BiometricPrompt.CryptoObject r4, Executor r5, AuthPromptCallback r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        return AuthPromptUtils.startAuthentication(r3, this.mPromptInfo, r4, r7, r6);
    }
}
