package androidx.biometric.auth;

import androidx.biometric.BiometricPrompt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class Class2BiometricAuthPrompt {
    private final BiometricPrompt.PromptInfo mPromptInfo;

    public static final class Builder {
        private CharSequence mDescription;
        private boolean mIsConfirmationRequired;
        private final CharSequence mNegativeButtonText;
        private CharSequence mSubtitle;
        private final CharSequence mTitle;

        public Builder(CharSequence r3, CharSequence r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            this.mSubtitle = null;
            this.mDescription = null;
            this.mIsConfirmationRequired = true;
            this.mTitle = r5;
            this.mNegativeButtonText = r6;
        }

        public Class2BiometricAuthPrompt build() {
            return new Class2BiometricAuthPrompt(new BiometricPrompt.PromptInfo.Builder().setTitle(this.mTitle).setSubtitle(this.mSubtitle).setDescription(this.mDescription).setNegativeButtonText(this.mNegativeButtonText).setConfirmationRequired(this.mIsConfirmationRequired).setAllowedAuthenticators(255).build());
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

    Class2BiometricAuthPrompt(BiometricPrompt.PromptInfo r1) {
        this.mPromptInfo = r1;
    }

    public CharSequence getDescription() {
        return this.mPromptInfo.getDescription();
    }

    public CharSequence getNegativeButtonText() {
        return this.mPromptInfo.getTitle();
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

    public AuthPrompt startAuthentication(AuthPromptHost r2, AuthPromptCallback r3) {
        return AuthPromptUtils.startAuthentication(r2, this.mPromptInfo, null, null, r3);
    }

    public AuthPrompt startAuthentication(AuthPromptHost r3, Executor r4, AuthPromptCallback r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        return AuthPromptUtils.startAuthentication(r3, this.mPromptInfo, null, r6, r5);
    }
}
