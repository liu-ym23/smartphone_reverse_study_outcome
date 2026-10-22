package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/o8;", "", "", "userAgreementName", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUserAgreementName", "(Ljava/lang/String;)V", "privacyPolicyName", "d", "setPrivacyPolicyName", "linkText", "b", "setLinkText", "dialogContentTemplate", "a", "setDialogContentTemplate", "", "needProtocolCheck", "Z", "c", "()Z", "setNeedProtocolCheck", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o8 {

    @SerializedName("dialog_content_template")
    private String dialogContentTemplate;

    @SerializedName("link_text")
    private String linkText;

    @SerializedName("need_protocol_check")
    private boolean needProtocolCheck;

    @SerializedName("privacy_policy_name")
    private String privacyPolicyName;

    @SerializedName("user_agreement_name")
    private String userAgreementName;

    public o8() {
        this.userAgreementName = "《抖音用户协议》";
        this.privacyPolicyName = "《抖音隐私政策》";
        this.linkText = "授权即表示已阅读并同意《抖音隐私政策》《抖音用户协议》";
        this.dialogContentTemplate = "1、同意向抖音同步当前账号所绑定的手机号【%s】，并为你绑定该手机号所登录的抖音号。\n2、如果该手机号未登录过抖音号，则会用该手机号创建新的抖音号。";
        this.needProtocolCheck = true;
    }

    public final String a() {
        return this.dialogContentTemplate;
    }

    public final String b() {
        return this.linkText;
    }

    public final boolean c() {
        return this.needProtocolCheck;
    }

    public final String d() {
        return this.privacyPolicyName;
    }

    public final String e() {
        return this.userAgreementName;
    }
}
