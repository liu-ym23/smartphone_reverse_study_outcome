package com.obric.memorydata.middleware.api.settings;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/NetworkInterceptConfig;", "", "enable", "", "networkHostWhiteList", "", "", "networkPathWhiteList", "collectBackgroundOsResourceApply", "<init>", "(ZLjava/util/List;Ljava/util/List;Z)V", "getEnable", "()Z", "getNetworkHostWhiteList", "()Ljava/util/List;", "getNetworkPathWhiteList", "getCollectBackgroundOsResourceApply", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkInterceptConfig {

    @SerializedName("collect_background_os_resource_apply")
    private final boolean collectBackgroundOsResourceApply;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("network_host_white_list")
    private final List<String> networkHostWhiteList;

    @SerializedName("network_path_white_list")
    private final List<String> networkPathWhiteList;

    public NetworkInterceptConfig() {
        this(false, null, null, false, 15, null);
    }

    public NetworkInterceptConfig(boolean r3, List<String> r4, List<String> r5, boolean r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "networkHostWhiteList");
        Intrinsics.checkNotNullParameter(r8, "networkPathWhiteList");
        this.enable = r3;
        this.networkHostWhiteList = r7;
        this.networkPathWhiteList = r8;
        this.collectBackgroundOsResourceApply = r6;
    }

    public /* synthetic */ NetworkInterceptConfig(boolean r2, List r3, List r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r8, r9, r5);
    }

    public static /* synthetic */ NetworkInterceptConfig copy$default(NetworkInterceptConfig r1, boolean r2, List r3, List r4, boolean r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.enable;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.networkHostWhiteList;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.networkPathWhiteList;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.collectBackgroundOsResourceApply;
    L15:
        return r1.copy(r2, r8, r9, r5);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.networkHostWhiteList;
    }

    public final List<String> component3() {
        return this.networkPathWhiteList;
    }

    public final boolean component4() {
        return this.collectBackgroundOsResourceApply;
    }

    public final NetworkInterceptConfig copy(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "networkHostWhiteList");
        Intrinsics.checkNotNullParameter(r6, "networkPathWhiteList");
        return new NetworkInterceptConfig(r2, r1, r6, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetworkInterceptConfig.class) == true) goto L8;
        return false;
    L8:
        NetworkInterceptConfig r6 = (NetworkInterceptConfig) ZeusTransformUtils.preCheckCast(r5, NetworkInterceptConfig.class, "com.obric.memorydata.plugin");
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.networkHostWhiteList, r6.networkHostWhiteList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.networkPathWhiteList, r6.networkPathWhiteList) == true) goto L18;
        return false;
    L18:
        if (this.collectBackgroundOsResourceApply == r6.collectBackgroundOsResourceApply) goto L20;
        return false;
    L20:
        return true;
    }

    public final boolean getCollectBackgroundOsResourceApply() {
        return this.collectBackgroundOsResourceApply;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getNetworkHostWhiteList() {
        return this.networkHostWhiteList;
    }

    public final List<String> getNetworkPathWhiteList() {
        return this.networkPathWhiteList;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enable) * 31) + this.networkHostWhiteList.hashCode()) * 31) + this.networkPathWhiteList.hashCode()) * 31) + Boolean.hashCode(this.collectBackgroundOsResourceApply);
    }

    public String toString() {
        return "NetworkInterceptConfig(enable=" + this.enable + ", networkHostWhiteList=" + this.networkHostWhiteList + ", networkPathWhiteList=" + this.networkPathWhiteList + ", collectBackgroundOsResourceApply=" + this.collectBackgroundOsResourceApply + ')';
    }
}
