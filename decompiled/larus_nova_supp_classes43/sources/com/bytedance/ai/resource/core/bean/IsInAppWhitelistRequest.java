package com.bytedance.ai.resource.core.bean;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistRequest;", "", "source", "", "deviceId", "", "packageName", "versionTag", BdpShareBaseInfo.CHANNEL_TOKEN, "parentAppId", "packageList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPackageItem;", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;)V", "getSource", "()I", "getDeviceId", "()Ljava/lang/String;", "getPackageName", "getVersionTag", "getToken", "getParentAppId", "getPackageList", "()Ljava/util/List;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsInAppWhitelistRequest {

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("extra_info")
    private final OpenPlatformExtraInfo extraInfo;

    @SerializedName("package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPackageItem> packageList;

    @SerializedName("app_key")
    private final String packageName;

    @SerializedName("parent_app_id")
    private final String parentAppId;
    private final int source;
    private final String token;

    @SerializedName("version_tag")
    private final String versionTag;

    public IsInAppWhitelistRequest() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsInAppWhitelistRequest copy$default(IsInAppWhitelistRequest r10, int r11, String r12, String r13, String r14, String r15, String r16, List r17, OpenPlatformExtraInfo r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        int r20 = r10.source;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.deviceId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.packageName;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.versionTag;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.token;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.parentAppId;
    L27:
        if ((r19 & 64) == 0) goto L29;
        List r26 = r10.packageList;
    L31:
        if ((r19 & 128) == 0) goto L33;
        OpenPlatformExtraInfo r1 = r10.extraInfo;
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

    public final int component1() {
        return this.source;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.packageName;
    }

    public final String component4() {
        return this.versionTag;
    }

    public final String component5() {
        return this.token;
    }

    public final String component6() {
        return this.parentAppId;
    }

    public final List<OpenPlatformPackageItem> component7() {
        return this.packageList;
    }

    public final OpenPlatformExtraInfo component8() {
        return this.extraInfo;
    }

    public final IsInAppWhitelistRequest copy(int r11, String r12, String r13, String r14, String r15, String r16, List<OpenPlatformPackageItem> r17, OpenPlatformExtraInfo r18) {
        return new IsInAppWhitelistRequest(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IsInAppWhitelistRequest) == true) goto L8;
        return false;
    L8:
        IsInAppWhitelistRequest r11 = (IsInAppWhitelistRequest) r10;
        if (this.source == r11.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceId, r11.deviceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.versionTag, r11.versionTag) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.token, r11.token) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parentAppId, r11.parentAppId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.packageList, r11.packageList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraInfo, r11.extraInfo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.source * 31;
        String r1 = this.deviceId;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.packageName;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.versionTag;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.token;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.parentAppId;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        List<OpenPlatformPackageItem> r25 = this.packageList;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        OpenPlatformExtraInfo r28 = this.extraInfo;
        if (r28 == null) goto L31;
        r10 = r28.hashCode();
    L31:
        return r27 + r10;
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "IsInAppWhitelistRequest(source=" + this.source + ", deviceId=" + this.deviceId + ", packageName=" + this.packageName + ", versionTag=" + this.versionTag + ", token=" + this.token + ", parentAppId=" + this.parentAppId + ", packageList=" + this.packageList + ", extraInfo=" + this.extraInfo + ')';
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final OpenPlatformExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final List<OpenPlatformPackageItem> getPackageList() {
        return this.packageList;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getParentAppId() {
        return this.parentAppId;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public IsInAppWhitelistRequest(int r1, String r10, String r11, String r12, String r13, String r14, List<OpenPlatformPackageItem> r15, OpenPlatformExtraInfo r16) {
        this.source = r1;
        this.deviceId = r10;
        this.packageName = r11;
        this.versionTag = r12;
        this.token = r13;
        this.parentAppId = r14;
        this.packageList = r15;
        this.extraInfo = r16;
    }

    public /* synthetic */ IsInAppWhitelistRequest(int r10, String r11, String r12, String r13, String r14, String r15, List r16, OpenPlatformExtraInfo r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        int r1 = 0;
    L6:
        OpenPlatformExtraInfo r20 = null;
        if ((r18 & 2) == 0) goto L9;
        String r21 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r22 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r23 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r24 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r25 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r26 = CollectionsKt.emptyList();
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
        goto L6
    }
}
