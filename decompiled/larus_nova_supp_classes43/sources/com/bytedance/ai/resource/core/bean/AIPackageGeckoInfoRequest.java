package com.bytedance.ai.resource.core.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;", "", "appList", "", "Lcom/bytedance/ai/resource/core/bean/PackageRequestItem;", "aid", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppList", "()Ljava/util/List;", "getAid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageGeckoInfoRequest {
    private final String aid;
    private final List<PackageRequestItem> appList;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageGeckoInfoRequest() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageGeckoInfoRequest copy$default(AIPackageGeckoInfoRequest r0, List r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.appList;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.aid;
    L9:
        return r0.copy(r1, r10);
    }

    public final List<PackageRequestItem> component1() {
        return this.appList;
    }

    public final String component2() {
        return this.aid;
    }

    public final AIPackageGeckoInfoRequest copy(List<PackageRequestItem> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "appList");
        Intrinsics.checkNotNullParameter(r11, "aid");
        return new AIPackageGeckoInfoRequest(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIPackageGeckoInfoRequest) == true) goto L8;
        return false;
    L8:
        AIPackageGeckoInfoRequest r11 = (AIPackageGeckoInfoRequest) r10;
        if (Intrinsics.areEqual(this.appList, r11.appList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aid, r11.aid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.appList.hashCode() * 31) + this.aid.hashCode();
    }

    public String toString() {
        return "AIPackageGeckoInfoRequest(appList=" + this.appList + ", aid=" + this.aid + ')';
    }

    public final String getAid() {
        return this.aid;
    }

    public final List<PackageRequestItem> getAppList() {
        return this.appList;
    }

    public AIPackageGeckoInfoRequest(List<PackageRequestItem> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "appList");
        Intrinsics.checkNotNullParameter(r11, "aid");
        this.appList = r10;
        this.aid = r11;
    }

    public /* synthetic */ AIPackageGeckoInfoRequest(List r1, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = new ArrayList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = "";
    L8:
        this(r1, r10);
    }
}
