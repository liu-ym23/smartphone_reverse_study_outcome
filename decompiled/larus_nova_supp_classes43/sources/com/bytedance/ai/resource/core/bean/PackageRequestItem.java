package com.bytedance.ai.resource.core.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/PackageRequestItem;", "", "packageName", "", "versionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getVersionCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackageRequestItem {
    private final String packageName;
    private final String versionCode;

    public PackageRequestItem() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ PackageRequestItem copy$default(PackageRequestItem r0, String r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.versionCode;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionCode;
    }

    public final PackageRequestItem copy(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "versionCode");
        return new PackageRequestItem(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PackageRequestItem) == true) goto L8;
        return false;
    L8:
        PackageRequestItem r11 = (PackageRequestItem) r10;
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionCode, r11.versionCode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.versionCode.hashCode();
    }

    public String toString() {
        return "PackageRequestItem(packageName=" + this.packageName + ", versionCode=" + this.versionCode + ')';
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public PackageRequestItem(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "versionCode");
        this.packageName = r10;
        this.versionCode = r11;
    }

    public /* synthetic */ PackageRequestItem(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        this(r10, r11);
    }
}
