package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/Agreements;", "Ljava/io/Serializable;", "mainText", "", "termsOfServiceUrl", "privacyPolicyUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMainText", "()Ljava/lang/String;", "getTermsOfServiceUrl", "getPrivacyPolicyUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Agreements implements Serializable {

    @SerializedName("main_text")
    private final String mainText;

    @SerializedName("privacy_policy_url")
    private final String privacyPolicyUrl;

    @SerializedName("terms_of_service_url")
    private final String termsOfServiceUrl;

    public Agreements() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Agreements copy$default(Agreements r0, String r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.mainText;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.termsOfServiceUrl;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.privacyPolicyUrl;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.mainText;
    }

    public final String component2() {
        return this.termsOfServiceUrl;
    }

    public final String component3() {
        return this.privacyPolicyUrl;
    }

    public final Agreements copy(String r10, String r11, String r12) {
        return new Agreements(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Agreements) == true) goto L8;
        return false;
    L8:
        Agreements r11 = (Agreements) r10;
        if (Intrinsics.areEqual(this.mainText, r11.mainText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.termsOfServiceUrl, r11.termsOfServiceUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.privacyPolicyUrl, r11.privacyPolicyUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.mainText;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.termsOfServiceUrl;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.privacyPolicyUrl;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Agreements(mainText=" + this.mainText + ", termsOfServiceUrl=" + this.termsOfServiceUrl + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ')';
    }

    public final String getMainText() {
        return this.mainText;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    public Agreements(String r1, String r10, String r11) {
        this.mainText = r1;
        this.termsOfServiceUrl = r10;
        this.privacyPolicyUrl = r11;
    }

    public /* synthetic */ Agreements(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
