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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "", "appKey", "", BdpAwemeConstant.KEY_APP_NAME, "iconUrl", "defaultEnabled", "", "testVersions", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "auditVersions", "formalVersions", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;)V", "getAppKey", "()Ljava/lang/String;", "getAppName", "getIconUrl", "getDefaultEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTestVersions", "()Ljava/util/List;", "getAuditVersions", "getFormalVersions", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppInfo {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("app_name")
    private final String appName;

    @SerializedName("audit_versions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewVersion> auditVersions;

    @SerializedName("default_enabled")
    private final Boolean defaultEnabled;

    @SerializedName("formal_versions")
    private final OpenPlatformPreviewVersionPage formalVersions;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("test_versions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewVersion> testVersions;

    public OpenPlatformPreviewAppInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewAppInfo copy$default(OpenPlatformPreviewAppInfo r10, String r11, String r12, String r13, Boolean r14, List r15, List r16, OpenPlatformPreviewVersionPage r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.appKey;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.appName;
    L8:
        String r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.iconUrl;
    L11:
        String r0 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.defaultEnabled;
    L14:
        Boolean r1 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.testVersions;
    L17:
        List r20 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.auditVersions;
    L20:
        List r21 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.formalVersions;
    L23:
        String r22 = r11;
        return r10.copy(r22, r110, r0, r1, r20, r21, r17);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final Boolean component4() {
        return this.defaultEnabled;
    }

    public final List<OpenPlatformPreviewVersion> component5() {
        return this.testVersions;
    }

    public final List<OpenPlatformPreviewVersion> component6() {
        return this.auditVersions;
    }

    public final OpenPlatformPreviewVersionPage component7() {
        return this.formalVersions;
    }

    public final OpenPlatformPreviewAppInfo copy(String r10, String r11, String r12, Boolean r13, List<OpenPlatformPreviewVersion> r14, List<OpenPlatformPreviewVersion> r15, OpenPlatformPreviewVersionPage r16) {
        return new OpenPlatformPreviewAppInfo(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformPreviewAppInfo) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppInfo r11 = (OpenPlatformPreviewAppInfo) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r11.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r11.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultEnabled, r11.defaultEnabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.testVersions, r11.testVersions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.auditVersions, r11.auditVersions) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.formalVersions, r11.formalVersions) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.appKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.appName;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.iconUrl;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.defaultEnabled;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        List<OpenPlatformPreviewVersion> r21 = this.testVersions;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        List<OpenPlatformPreviewVersion> r24 = this.auditVersions;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        OpenPlatformPreviewVersionPage r27 = this.formalVersions;
        if (r27 == null) goto L31;
        r1 = r27.hashCode();
    L31:
        return r26 + r1;
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
        return "OpenPlatformPreviewAppInfo(appKey=" + this.appKey + ", appName=" + this.appName + ", iconUrl=" + this.iconUrl + ", defaultEnabled=" + this.defaultEnabled + ", testVersions=" + this.testVersions + ", auditVersions=" + this.auditVersions + ", formalVersions=" + this.formalVersions + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final List<OpenPlatformPreviewVersion> getAuditVersions() {
        return this.auditVersions;
    }

    public final Boolean getDefaultEnabled() {
        return this.defaultEnabled;
    }

    public final OpenPlatformPreviewVersionPage getFormalVersions() {
        return this.formalVersions;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<OpenPlatformPreviewVersion> getTestVersions() {
        return this.testVersions;
    }

    public OpenPlatformPreviewAppInfo(String r1, String r10, String r11, Boolean r12, List<OpenPlatformPreviewVersion> r13, List<OpenPlatformPreviewVersion> r14, OpenPlatformPreviewVersionPage r15) {
        this.appKey = r1;
        this.appName = r10;
        this.iconUrl = r11;
        this.defaultEnabled = r12;
        this.testVersions = r13;
        this.auditVersions = r14;
        this.formalVersions = r15;
    }

    public /* synthetic */ OpenPlatformPreviewAppInfo(String r10, String r11, String r12, Boolean r13, List r14, List r15, OpenPlatformPreviewVersionPage r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        String r19 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r20 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        Boolean r21 = null;
    L19:
        if ((r17 & 16) == 0) goto L21;
        r14 = CollectionsKt.emptyList();
    L21:
        List r22 = r14;
        if ((r17 & 32) == 0) goto L24;
        r15 = CollectionsKt.emptyList();
    L24:
        List r23 = r15;
        if ((r17 & 64) == 0) goto L27;
        OpenPlatformPreviewVersionPage r110 = null;
    L28:
        this(r19, r1, r20, r21, r22, r23, r110);
        return;
    L27:
        r110 = r16;
        goto L28
    L17:
        r21 = r13;
        goto L19
    L13:
        r20 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r19 = r10;
        goto L7
    }
}
