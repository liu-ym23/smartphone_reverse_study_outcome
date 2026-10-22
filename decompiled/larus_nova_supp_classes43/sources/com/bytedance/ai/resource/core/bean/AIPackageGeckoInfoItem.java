package com.bytedance.ai.resource.core.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoItem;", "", "packageName", "", "versionCode", "baseUrls", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getVersionCode", "setVersionCode", "getBaseUrls", "()Ljava/util/List;", "setBaseUrls", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageGeckoInfoItem {
    private List<String> baseUrls;
    private String packageName;
    private String versionCode;

    public AIPackageGeckoInfoItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageGeckoInfoItem copy$default(AIPackageGeckoInfoItem r0, String r1, String r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.versionCode;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.baseUrls;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionCode;
    }

    public final List<String> component3() {
        return this.baseUrls;
    }

    public final AIPackageGeckoInfoItem copy(String r10, String r11, List<String> r12) {
        return new AIPackageGeckoInfoItem(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIPackageGeckoInfoItem) == true) goto L8;
        return false;
    L8:
        AIPackageGeckoInfoItem r11 = (AIPackageGeckoInfoItem) r10;
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionCode, r11.versionCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.baseUrls, r11.baseUrls) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.packageName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.versionCode;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        List<String> r15 = this.baseUrls;
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
        return "AIPackageGeckoInfoItem(packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", baseUrls=" + this.baseUrls + ')';
    }

    public final List<String> getBaseUrls() {
        return this.baseUrls;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final void setBaseUrls(List<String> r1) {
        this.baseUrls = r1;
    }

    public final void setPackageName(String r1) {
        this.packageName = r1;
    }

    public final void setVersionCode(String r1) {
        this.versionCode = r1;
    }

    public AIPackageGeckoInfoItem(String r1, String r10, List<String> r11) {
        this.packageName = r1;
        this.versionCode = r10;
        this.baseUrls = r11;
    }

    public /* synthetic */ AIPackageGeckoInfoItem(String r10, String r11, List r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
