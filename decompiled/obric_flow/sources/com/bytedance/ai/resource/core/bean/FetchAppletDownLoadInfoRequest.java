package com.bytedance.ai.resource.core.bean;

import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/FetchAppletDownLoadInfoRequest;", "", "parentAppId", "", "packageList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPackageItem;", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;)V", "getParentAppId", "()Ljava/lang/String;", "getPackageList", "()Ljava/util/List;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FetchAppletDownLoadInfoRequest {

    @SerializedName("extra_info")
    private final OpenPlatformExtraInfo extraInfo;

    @SerializedName("package_list")
    private final List<OpenPlatformPackageItem> packageList;

    @SerializedName("parent_app_id")
    private final String parentAppId;

    public FetchAppletDownLoadInfoRequest() {
        String r5 = null;
        List r10 = null;
        OpenPlatformExtraInfo r11 = null;
        this(r5, r10, r11, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FetchAppletDownLoadInfoRequest copy$default(FetchAppletDownLoadInfoRequest r5, String r10, List r11, OpenPlatformExtraInfo r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.parentAppId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.packageList;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.extraInfo;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.parentAppId;
    }

    public final List<OpenPlatformPackageItem> component2() {
        return this.packageList;
    }

    public final OpenPlatformExtraInfo component3() {
        return this.extraInfo;
    }

    public final FetchAppletDownLoadInfoRequest copy(String r5, List<OpenPlatformPackageItem> r10, OpenPlatformExtraInfo r11) {
        Intrinsics.checkNotNullParameter(r5, "parentAppId");
        Intrinsics.checkNotNullParameter(r10, "packageList");
        return new FetchAppletDownLoadInfoRequest(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FetchAppletDownLoadInfoRequest) == true) goto L8;
        return false;
    L8:
        FetchAppletDownLoadInfoRequest r10 = (FetchAppletDownLoadInfoRequest) r5;
        if (Intrinsics.areEqual(this.parentAppId, r10.parentAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageList, r10.packageList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraInfo, r10.extraInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final OpenPlatformExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final List<OpenPlatformPackageItem> getPackageList() {
        return this.packageList;
    }

    public final String getParentAppId() {
        return this.parentAppId;
    }

    public int hashCode() {
        int r5 = this.parentAppId.hashCode() * 31;
        int r10 = a.f(this.packageList, r5, 31);
        OpenPlatformExtraInfo r11 = this.extraInfo;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "FetchAppletDownLoadInfoRequest(parentAppId=" + this.parentAppId + ", packageList=" + this.packageList + ", extraInfo=" + this.extraInfo + ')';
    }

    public FetchAppletDownLoadInfoRequest(String r5, List<OpenPlatformPackageItem> r10, OpenPlatformExtraInfo r11) {
        Intrinsics.checkNotNullParameter(r5, "parentAppId");
        Intrinsics.checkNotNullParameter(r10, "packageList");
        this.parentAppId = r5;
        this.packageList = r10;
        this.extraInfo = r11;
    }

    public /* synthetic */ FetchAppletDownLoadInfoRequest(String r5, List r10, OpenPlatformExtraInfo r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = new ArrayList();
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = null;
    L11:
        this(r5, r10, r11);
    }
}
