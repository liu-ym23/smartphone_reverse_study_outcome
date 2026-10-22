package com.bytedance.ai.resource.core.bean;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkRequest;", "", "appList", "", "Lcom/bytedance/ai/resource/core/bean/AppRequestItem;", WsConstants.KEY_APP_ID, "", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/bytedance/ai/resource/core/bean/ExtraInfo;)V", "getAppList", "()Ljava/util/List;", "getAid", "()Ljava/lang/String;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/ExtraInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageNetworkRequest {
    private final String aid;
    private final List<AppRequestItem> appList;
    private final ExtraInfo extraInfo;

    public AIPackageNetworkRequest() {
        List r5 = null;
        String r10 = null;
        ExtraInfo r11 = null;
        this(r5, r10, r11, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageNetworkRequest copy$default(AIPackageNetworkRequest r5, List r10, String r11, ExtraInfo r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.appList;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.aid;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.extraInfo;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final List<AppRequestItem> component1() {
        return this.appList;
    }

    public final String component2() {
        return this.aid;
    }

    public final ExtraInfo component3() {
        return this.extraInfo;
    }

    public final AIPackageNetworkRequest copy(List<AppRequestItem> r5, String r10, ExtraInfo r11) {
        Intrinsics.checkNotNullParameter(r5, "appList");
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_APP_ID);
        return new AIPackageNetworkRequest(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPackageNetworkRequest) == true) goto L8;
        return false;
    L8:
        AIPackageNetworkRequest r10 = (AIPackageNetworkRequest) r5;
        if (Intrinsics.areEqual(this.appList, r10.appList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aid, r10.aid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraInfo, r10.extraInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAid() {
        return this.aid;
    }

    public final List<AppRequestItem> getAppList() {
        return this.appList;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public int hashCode() {
        int r5 = this.appList.hashCode() * 31;
        int r10 = a.b(this.aid, r5, 31);
        ExtraInfo r11 = this.extraInfo;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "AIPackageNetworkRequest(appList=" + this.appList + ", aid=" + this.aid + ", extraInfo=" + this.extraInfo + ')';
    }

    public AIPackageNetworkRequest(List<AppRequestItem> r5, String r10, ExtraInfo r11) {
        Intrinsics.checkNotNullParameter(r5, "appList");
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_APP_ID);
        this.appList = r5;
        this.aid = r10;
        this.extraInfo = r11;
    }

    public /* synthetic */ AIPackageNetworkRequest(List r5, String r10, ExtraInfo r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = new ArrayList();
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = null;
    L11:
        this(r5, r10, r11);
    }
}
