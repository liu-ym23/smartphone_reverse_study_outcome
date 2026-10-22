package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.annotations.SerializedName;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPackageItem;", "", "versionCode", "", Constant.APPID, "packageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersionCode", "()Ljava/lang/String;", "getAppId", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenPlatformPackageItem {

    @SerializedName("resource_id")
    private final String appId;

    @SerializedName(Constant.PACKAGE_NAME)
    private final String packageName;

    @SerializedName("applet_version_code")
    private final String versionCode;

    public OpenPlatformPackageItem() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        this(r5, r10, r11, 7, null);
    }

    public static /* synthetic */ OpenPlatformPackageItem copy$default(OpenPlatformPackageItem r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.versionCode;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.appId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.packageName;
    L12:
        return r5.copy(r10, r11, r12);
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

    public final OpenPlatformPackageItem copy(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "versionCode");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "packageName");
        return new OpenPlatformPackageItem(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenPlatformPackageItem) == true) goto L8;
        return false;
    L8:
        OpenPlatformPackageItem r10 = (OpenPlatformPackageItem) r5;
        if (Intrinsics.areEqual(this.versionCode, r10.versionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r10.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L17;
        return false;
    L17:
        return true;
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

    public int hashCode() {
        int r5 = this.versionCode.hashCode() * 31;
        int r10 = a.b(this.appId, r5, 31);
        return this.packageName.hashCode() + r10;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("OpenPlatformPackageItem(versionCode=");
        r5.append(this.versionCode);
        r5.append(", appId=");
        r5.append(this.appId);
        r5.append(", packageName=");
        return j0.p(r5, this.packageName, ')');
    }

    public OpenPlatformPackageItem(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "versionCode");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "packageName");
        this.versionCode = r5;
        this.appId = r10;
        this.packageName = r11;
    }

    public /* synthetic */ OpenPlatformPackageItem(String r5, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = "";
    L11:
        this(r5, r10, r11);
    }
}
