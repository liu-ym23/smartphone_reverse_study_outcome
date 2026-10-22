package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/GetUserAppsPermissionDetailResponse;", "Ljava/io/Serializable;", "errCode", "", "errMsg", "", "appletsScopeManageInfo", "", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getAppletsScopeManageInfo", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserAppsPermissionDetailResponse implements Serializable {

    @SerializedName("applets_scope_manage_info")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AppletPermissionDetail> appletsScopeManageInfo;

    @SerializedName("err_code")
    private final int errCode;

    @SerializedName("err_msg")
    private final String errMsg;

    public GetUserAppsPermissionDetailResponse() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetUserAppsPermissionDetailResponse copy$default(GetUserAppsPermissionDetailResponse r0, int r1, String r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.errCode;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.errMsg;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.appletsScopeManageInfo;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final int component1() {
        return this.errCode;
    }

    public final String component2() {
        return this.errMsg;
    }

    public final List<AppletPermissionDetail> component3() {
        return this.appletsScopeManageInfo;
    }

    public final GetUserAppsPermissionDetailResponse copy(int r10, String r11, List<AppletPermissionDetail> r12) {
        return new GetUserAppsPermissionDetailResponse(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetUserAppsPermissionDetailResponse) == true) goto L8;
        return false;
    L8:
        GetUserAppsPermissionDetailResponse r11 = (GetUserAppsPermissionDetailResponse) r10;
        if (this.errCode == r11.errCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errMsg, r11.errMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletsScopeManageInfo, r11.appletsScopeManageInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.errCode * 31;
        String r1 = this.errMsg;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        List<AppletPermissionDetail> r13 = this.appletsScopeManageInfo;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "GetUserAppsPermissionDetailResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", appletsScopeManageInfo=" + this.appletsScopeManageInfo + ')';
    }

    public final List<AppletPermissionDetail> getAppletsScopeManageInfo() {
        return this.appletsScopeManageInfo;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public GetUserAppsPermissionDetailResponse(int r1, String r10, List<AppletPermissionDetail> r11) {
        this.errCode = r1;
        this.errMsg = r10;
        this.appletsScopeManageInfo = r11;
    }

    public /* synthetic */ GetUserAppsPermissionDetailResponse(int r1, String r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = CollectionsKt.emptyList();
    L11:
        this(r1, r10, r11);
    }
}
