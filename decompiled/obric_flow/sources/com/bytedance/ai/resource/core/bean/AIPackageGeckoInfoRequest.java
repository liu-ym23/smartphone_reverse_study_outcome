package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoRequest;", "", "appList", "", "Lcom/bytedance/ai/resource/core/bean/PackageRequestItem;", WsConstants.KEY_APP_ID, "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppList", "()Ljava/util/List;", "getAid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageGeckoInfoRequest {
    private final String aid;
    private final List<PackageRequestItem> appList;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageGeckoInfoRequest() {
        Object[] r5 = 0 == true ? 1 : 0;
        this(null, r5, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageGeckoInfoRequest copy$default(AIPackageGeckoInfoRequest r5, List r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.appList;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.aid;
    L9:
        return r5.copy(r10, r11);
    }

    public final List<PackageRequestItem> component1() {
        return this.appList;
    }

    public final String component2() {
        return this.aid;
    }

    public final AIPackageGeckoInfoRequest copy(List<PackageRequestItem> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "appList");
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_APP_ID);
        return new AIPackageGeckoInfoRequest(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPackageGeckoInfoRequest) == true) goto L8;
        return false;
    L8:
        AIPackageGeckoInfoRequest r10 = (AIPackageGeckoInfoRequest) r5;
        if (Intrinsics.areEqual(this.appList, r10.appList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aid, r10.aid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAid() {
        return this.aid;
    }

    public final List<PackageRequestItem> getAppList() {
        return this.appList;
    }

    public int hashCode() {
        int r5 = this.appList.hashCode() * 31;
        return this.aid.hashCode() + r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("AIPackageGeckoInfoRequest(appList=");
        r5.append(this.appList);
        r5.append(", aid=");
        return j0.p(r5, this.aid, ')');
    }

    public AIPackageGeckoInfoRequest(List<PackageRequestItem> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "appList");
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_APP_ID);
        this.appList = r5;
        this.aid = r10;
    }

    public /* synthetic */ AIPackageGeckoInfoRequest(List r5, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = new ArrayList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = "";
    L8:
        this(r5, r10);
    }
}
