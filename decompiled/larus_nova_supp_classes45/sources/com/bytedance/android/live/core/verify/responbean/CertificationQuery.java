package com.bytedance.android.live.core.verify.responbean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CertificationQuery {
    public static final int NOT_PASSED = 0;
    public static final int PASSED = 1;

    @SerializedName("children_cert_token")
    private String childrenCertToken;

    @SerializedName("failed_reason")
    private String failedReason;

    @SerializedName("msg")
    private String message;

    @SerializedName("is_verified")
    private boolean passed;

    @SerializedName("prompts_type")
    private int promptsType;

    @SerializedName("sdk_verified")
    private boolean sdkVerified;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("use_manual_verify")
    private boolean useManualVerify;

    public CertificationQuery() {
    }

    public String toString() {
        return "CertificationQuery{statusCode=" + this.statusCode + ", message='" + this.message + "', passed=" + this.passed + ", failedReason='" + this.failedReason + "', useManualVerify=" + this.useManualVerify + ", promptsType=" + this.promptsType + ", sdkVerified=" + this.sdkVerified + '}';
    }

    public String getChildrenCertToken() {
        return this.childrenCertToken;
    }

    public String getFailedReason() {
        return this.failedReason;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean getPassed() {
        return this.passed;
    }

    public int getPromptsType() {
        return this.promptsType;
    }

    public boolean getSdkVerified() {
        return this.sdkVerified;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isUseManualVerify() {
        return this.useManualVerify;
    }
}
