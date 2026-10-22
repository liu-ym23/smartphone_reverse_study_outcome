package com.bytedance.ai.resource.core.bean;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jt\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "", "versionCode", "", BdpAwemeConstant.KEY_APP_ID, "packageName", "resourceUrls", "", "resourceUrl", "digest", "aid", "verifySignature", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getVersionCode", "()Ljava/lang/String;", "getAppId", "getPackageName", "getResourceUrls", "()Ljava/util/List;", "getResourceUrl", "getDigest", "getAid", "getVerifySignature", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformAppletItem {

    @SerializedName("parent_applet_id")
    private final String aid;

    @SerializedName("resource_id")
    private final String appId;
    private final String digest;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("download_url")
    private final String resourceUrl;

    @SerializedName("download_url_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> resourceUrls;

    @SerializedName("sign_verify_switch")
    private final Boolean verifySignature;

    @SerializedName("applet_version_code")
    private final String versionCode;

    public OpenPlatformAppletItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformAppletItem copy$default(OpenPlatformAppletItem r10, String r11, String r12, String r13, List r14, String r15, String r16, String r17, Boolean r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.versionCode;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.appId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.packageName;
    L15:
        if ((r19 & 8) == 0) goto L17;
        List r23 = r10.resourceUrls;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.resourceUrl;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.digest;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.aid;
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
        return this.versionCode;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.packageName;
    }

    public final List<String> component4() {
        return this.resourceUrls;
    }

    public final String component5() {
        return this.resourceUrl;
    }

    public final String component6() {
        return this.digest;
    }

    public final String component7() {
        return this.aid;
    }

    public final Boolean component8() {
        return this.verifySignature;
    }

    public final OpenPlatformAppletItem copy(String r11, String r12, String r13, List<String> r14, String r15, String r16, String r17, Boolean r18) {
        return new OpenPlatformAppletItem(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformAppletItem) == true) goto L8;
        return false;
    L8:
        OpenPlatformAppletItem r11 = (OpenPlatformAppletItem) r10;
        if (Intrinsics.areEqual(this.versionCode, r11.versionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r11.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resourceUrls, r11.resourceUrls) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceUrl, r11.resourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.digest, r11.digest) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.aid, r11.aid) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verifySignature, r11.verifySignature) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.versionCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.appId;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.packageName;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.resourceUrls;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.resourceUrl;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.digest;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.aid;
        if (r27 != null) goto L29;
        int r28 = 0;
    L30:
        int r29 = (r26 + r28) * 31;
        Boolean r30 = this.verifySignature;
        if (r30 == null) goto L35;
        r1 = r30.hashCode();
    L35:
        return r29 + r1;
    L29:
        r28 = r27.hashCode();
        goto L30
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformAppletItem(versionCode=" + this.versionCode + ", appId=" + this.appId + ", packageName=" + this.packageName + ", resourceUrls=" + this.resourceUrls + ", resourceUrl=" + this.resourceUrl + ", digest=" + this.digest + ", aid=" + this.aid + ", verifySignature=" + this.verifySignature + ')';
    }

    public final String getAid() {
        return this.aid;
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

    public final Boolean getVerifySignature() {
        return this.verifySignature;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public OpenPlatformAppletItem(String r1, String r10, String r11, List<String> r12, String r13, String r14, String r15, Boolean r16) {
        this.versionCode = r1;
        this.appId = r10;
        this.packageName = r11;
        this.resourceUrls = r12;
        this.resourceUrl = r13;
        this.digest = r14;
        this.aid = r15;
        this.verifySignature = r16;
    }

    public /* synthetic */ OpenPlatformAppletItem(String r10, String r11, String r12, List r13, String r14, String r15, String r16, Boolean r17, int r18, DefaultConstructorMarker r19) {
        Boolean r20 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r21 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r22 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r23 = CollectionsKt.emptyList();
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r24 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r25 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r26 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r20 = r17;
    L34:
        this(r1, r21, r22, r23, r24, r25, r26, r20);
        return;
    L29:
        r26 = r16;
        goto L31
    L25:
        r25 = r15;
        goto L27
    L21:
        r24 = r14;
        goto L23
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
