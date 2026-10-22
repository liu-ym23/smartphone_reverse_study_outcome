package com.bytedance.ai.resource.core.bean;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"Jj\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageResponseItem;", "", BdpAwemeConstant.KEY_APP_ID, "", "packageName", "versionCode", "digest", "resourceUrl", "resourceUrls", "", "signaturePublicKeyVersion", "verifySignature", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getPackageName", "setPackageName", "getVersionCode", "setVersionCode", "getDigest", "setDigest", "getResourceUrl", "setResourceUrl", "getResourceUrls", "()Ljava/util/List;", "setResourceUrls", "(Ljava/util/List;)V", "getSignaturePublicKeyVersion", "setSignaturePublicKeyVersion", "getVerifySignature", "()Ljava/lang/Boolean;", "setVerifySignature", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ai/resource/core/bean/AIPackageResponseItem;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageResponseItem {
    private String appId;
    private String digest;
    private String packageName;
    private String resourceUrl;
    private List<String> resourceUrls;
    private String signaturePublicKeyVersion;
    private Boolean verifySignature;
    private String versionCode;

    public AIPackageResponseItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageResponseItem copy$default(AIPackageResponseItem r10, String r11, String r12, String r13, String r14, String r15, List r16, String r17, Boolean r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.appId;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.packageName;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.versionCode;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.digest;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.resourceUrl;
    L23:
        if ((r19 & 32) == 0) goto L25;
        List r25 = r10.resourceUrls;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.signaturePublicKeyVersion;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Boolean r1 = r10.verifySignature;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r1);
    L33:
        r1 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.versionCode;
    }

    public final String component4() {
        return this.digest;
    }

    public final String component5() {
        return this.resourceUrl;
    }

    public final List<String> component6() {
        return this.resourceUrls;
    }

    public final String component7() {
        return this.signaturePublicKeyVersion;
    }

    public final Boolean component8() {
        return this.verifySignature;
    }

    public final AIPackageResponseItem copy(String r11, String r12, String r13, String r14, String r15, List<String> r16, String r17, Boolean r18) {
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Intrinsics.checkNotNullParameter(r13, "versionCode");
        Intrinsics.checkNotNullParameter(r14, "digest");
        Intrinsics.checkNotNullParameter(r15, "resourceUrl");
        return new AIPackageResponseItem(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIPackageResponseItem) == true) goto L8;
        return false;
    L8:
        AIPackageResponseItem r11 = (AIPackageResponseItem) r10;
        if (Intrinsics.areEqual(this.appId, r11.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versionCode, r11.versionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.digest, r11.digest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceUrl, r11.resourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceUrls, r11.resourceUrls) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.signaturePublicKeyVersion, r11.signaturePublicKeyVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verifySignature, r11.verifySignature) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.appId.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.versionCode.hashCode()) * 31) + this.digest.hashCode()) * 31) + this.resourceUrl.hashCode()) * 31;
        List<String> r1 = this.resourceUrls;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.signaturePublicKeyVersion;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.verifySignature;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AIPackageResponseItem(appId=" + this.appId + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", digest=" + this.digest + ", resourceUrl=" + this.resourceUrl + ", resourceUrls=" + this.resourceUrls + ", signaturePublicKeyVersion=" + this.signaturePublicKeyVersion + ", verifySignature=" + this.verifySignature + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final List<String> getResourceUrls() {
        return this.resourceUrls;
    }

    public final String getSignaturePublicKeyVersion() {
        return this.signaturePublicKeyVersion;
    }

    public final Boolean getVerifySignature() {
        return this.verifySignature;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final void setAppId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.appId = r10;
    }

    public final void setDigest(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.digest = r10;
    }

    public final void setPackageName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.packageName = r10;
    }

    public final void setResourceUrl(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.resourceUrl = r10;
    }

    public final void setResourceUrls(List<String> r1) {
        this.resourceUrls = r1;
    }

    public final void setSignaturePublicKeyVersion(String r1) {
        this.signaturePublicKeyVersion = r1;
    }

    public final void setVerifySignature(Boolean r1) {
        this.verifySignature = r1;
    }

    public final void setVersionCode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.versionCode = r10;
    }

    public AIPackageResponseItem(String r10, String r11, String r12, String r13, String r14, List<String> r15, String r16, Boolean r17) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r12, "versionCode");
        Intrinsics.checkNotNullParameter(r13, "digest");
        Intrinsics.checkNotNullParameter(r14, "resourceUrl");
        this.appId = r10;
        this.packageName = r11;
        this.versionCode = r12;
        this.digest = r13;
        this.resourceUrl = r14;
        this.resourceUrls = r15;
        this.signaturePublicKeyVersion = r16;
        this.verifySignature = r17;
    }

    public /* synthetic */ AIPackageResponseItem(String r10, String r11, String r12, String r13, String r14, List r15, String r16, Boolean r17, int r18, DefaultConstructorMarker r19) {
        String r20 = "";
        if ((r18 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r21 = "";
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r22 = "";
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r23 = "";
    L19:
        if ((r18 & 16) != 0) goto L22;
        r20 = r14;
    L22:
        String r24 = null;
        if ((r18 & 32) == 0) goto L25;
        List r25 = null;
    L27:
        if ((r18 & 64) != 0) goto L31;
        r24 = r16;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Boolean r0 = Boolean.FALSE;
    L34:
        this(r1, r21, r22, r23, r20, r25, r24, r0);
        return;
    L33:
        r0 = r17;
        goto L34
    L25:
        r25 = r15;
        goto L27
    L17:
        r23 = r13;
        goto L19
    L13:
        r22 = r12;
        goto L15
    L9:
        r21 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
