package com.bytedance.ai.resource.core.bean;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPackageItem;", "", "versionCode", "", BdpAwemeConstant.KEY_APP_ID, "packageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersionCode", "()Ljava/lang/String;", "getAppId", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPackageItem {

    @SerializedName("resource_id")
    private final String appId;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("applet_version_code")
    private final String versionCode;

    public OpenPlatformPackageItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ OpenPlatformPackageItem copy$default(OpenPlatformPackageItem r0, String r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.versionCode;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.appId;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.packageName;
    L12:
        return r0.copy(r1, r10, r11);
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

    public final OpenPlatformPackageItem copy(String r10, String r11, String r12) {
        return new OpenPlatformPackageItem(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformPackageItem) == true) goto L8;
        return false;
    L8:
        OpenPlatformPackageItem r11 = (OpenPlatformPackageItem) r10;
        if (Intrinsics.areEqual(this.versionCode, r11.versionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r11.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L17;
        return false;
    L17:
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
        return "OpenPlatformPackageItem(versionCode=" + this.versionCode + ", appId=" + this.appId + ", packageName=" + this.packageName + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public OpenPlatformPackageItem(String r1, String r10, String r11) {
        this.versionCode = r1;
        this.appId = r10;
        this.packageName = r11;
    }

    public /* synthetic */ OpenPlatformPackageItem(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
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
