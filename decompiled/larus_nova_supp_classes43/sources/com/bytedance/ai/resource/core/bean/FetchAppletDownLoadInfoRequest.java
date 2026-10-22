package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/FetchAppletDownLoadInfoRequest;", "", "parentAppId", "", "packageList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPackageItem;", "extraInfo", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;)V", "getParentAppId", "()Ljava/lang/String;", "getPackageList", "()Ljava/util/List;", "getExtraInfo", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformExtraInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FetchAppletDownLoadInfoRequest {

    @SerializedName("extra_info")
    private final OpenPlatformExtraInfo extraInfo;

    @SerializedName("package_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPackageItem> packageList;

    @SerializedName("parent_app_id")
    private final String parentAppId;

    public FetchAppletDownLoadInfoRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FetchAppletDownLoadInfoRequest copy$default(FetchAppletDownLoadInfoRequest r0, String r1, List r10, OpenPlatformExtraInfo r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.parentAppId;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.packageList;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.extraInfo;
    L12:
        return r0.copy(r1, r10, r11);
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

    public final FetchAppletDownLoadInfoRequest copy(String r10, List<OpenPlatformPackageItem> r11, OpenPlatformExtraInfo r12) {
        return new FetchAppletDownLoadInfoRequest(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FetchAppletDownLoadInfoRequest) == true) goto L8;
        return false;
    L8:
        FetchAppletDownLoadInfoRequest r11 = (FetchAppletDownLoadInfoRequest) r10;
        if (Intrinsics.areEqual(this.parentAppId, r11.parentAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageList, r11.packageList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraInfo, r11.extraInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.parentAppId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        List<OpenPlatformPackageItem> r12 = this.packageList;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        OpenPlatformExtraInfo r15 = this.extraInfo;
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
        return "FetchAppletDownLoadInfoRequest(parentAppId=" + this.parentAppId + ", packageList=" + this.packageList + ", extraInfo=" + this.extraInfo + ')';
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

    public FetchAppletDownLoadInfoRequest(String r1, List<OpenPlatformPackageItem> r10, OpenPlatformExtraInfo r11) {
        this.parentAppId = r1;
        this.packageList = r10;
        this.extraInfo = r11;
    }

    public /* synthetic */ FetchAppletDownLoadInfoRequest(String r10, List r11, OpenPlatformExtraInfo r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = CollectionsKt.emptyList();
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
