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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/GetUserAppsPermissionDetailRequest;", "Ljava/io/Serializable;", "appletsList", "", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionQuery;", "language", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppletsList", "()Ljava/util/List;", "getLanguage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserAppsPermissionDetailRequest implements Serializable {

    @SerializedName("applets_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AppletPermissionQuery> appletsList;

    @SerializedName("language")
    private final String language;

    /* JADX WARN: Multi-variable type inference failed */
    public GetUserAppsPermissionDetailRequest() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetUserAppsPermissionDetailRequest copy$default(GetUserAppsPermissionDetailRequest r0, List r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.appletsList;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.language;
    L9:
        return r0.copy(r1, r10);
    }

    public final List<AppletPermissionQuery> component1() {
        return this.appletsList;
    }

    public final String component2() {
        return this.language;
    }

    public final GetUserAppsPermissionDetailRequest copy(List<AppletPermissionQuery> r10, String r11) {
        return new GetUserAppsPermissionDetailRequest(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetUserAppsPermissionDetailRequest) == true) goto L8;
        return false;
    L8:
        GetUserAppsPermissionDetailRequest r11 = (GetUserAppsPermissionDetailRequest) r10;
        if (Intrinsics.areEqual(this.appletsList, r11.appletsList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.language, r11.language) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<AppletPermissionQuery> r0 = this.appletsList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.language;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetUserAppsPermissionDetailRequest(appletsList=" + this.appletsList + ", language=" + this.language + ')';
    }

    public final List<AppletPermissionQuery> getAppletsList() {
        return this.appletsList;
    }

    public final String getLanguage() {
        return this.language;
    }

    public GetUserAppsPermissionDetailRequest(List<AppletPermissionQuery> r1, String r10) {
        this.appletsList = r1;
        this.language = r10;
    }

    public /* synthetic */ GetUserAppsPermissionDetailRequest(List r1, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, r10);
    }
}
