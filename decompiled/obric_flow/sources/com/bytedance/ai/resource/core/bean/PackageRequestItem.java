package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/PackageRequestItem;", "", "packageName", "", "versionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getVersionCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PackageRequestItem {
    private final String packageName;
    private final String versionCode;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageRequestItem() {
        Object[] r5 = 0 == true ? 1 : 0;
        this(null, r5, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PackageRequestItem copy$default(PackageRequestItem r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.packageName;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.versionCode;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionCode;
    }

    public final PackageRequestItem copy(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "versionCode");
        return new PackageRequestItem(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PackageRequestItem) == true) goto L8;
        return false;
    L8:
        PackageRequestItem r10 = (PackageRequestItem) r5;
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionCode, r10.versionCode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        int r5 = this.packageName.hashCode() * 31;
        return this.versionCode.hashCode() + r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("PackageRequestItem(packageName=");
        r5.append(this.packageName);
        r5.append(", versionCode=");
        return j0.p(r5, this.versionCode, ')');
    }

    public PackageRequestItem(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "versionCode");
        this.packageName = r5;
        this.versionCode = r10;
    }

    public /* synthetic */ PackageRequestItem(String r5, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = "";
    L8:
        this(r5, r10);
    }
}
