package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003Jv\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "Ljava/io/Serializable;", "appletId", "", "iconUrl", "appletName", "appletType", "", "scopesStatus", "", "Lcom/bytedance/ai/bridge/remote/model/ScopePermissionInfo;", "recentGrantedTime", "", "grantedScopeNames", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;)V", "getAppletId", "()Ljava/lang/String;", "getIconUrl", "getAppletName", "getAppletType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScopesStatus", "()Ljava/util/Map;", "getRecentGrantedTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGrantedScopeNames", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Long;Ljava/util/List;)Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "equals", "", "other", "", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPermissionDetail implements Serializable {

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("applet_name")
    private final String appletName;

    @SerializedName("applet_type")
    private final Integer appletType;

    @SerializedName("granted_scope_names")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> grantedScopeNames;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("recent_granted_time")
    private final Long recentGrantedTime;

    @SerializedName("scopes_status")
    private final Map<String, ScopePermissionInfo> scopesStatus;

    public AppletPermissionDetail() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppletPermissionDetail copy$default(AppletPermissionDetail r10, String r11, String r12, String r13, Integer r14, Map r15, Long r16, List r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.appletId;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.iconUrl;
    L8:
        String r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.appletName;
    L11:
        String r0 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.appletType;
    L14:
        Integer r1 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.scopesStatus;
    L17:
        Map r20 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.recentGrantedTime;
    L20:
        Long r21 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.grantedScopeNames;
    L23:
        String r22 = r11;
        return r10.copy(r22, r110, r0, r1, r20, r21, r17);
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.appletName;
    }

    public final Integer component4() {
        return this.appletType;
    }

    public final Map<String, ScopePermissionInfo> component5() {
        return this.scopesStatus;
    }

    public final Long component6() {
        return this.recentGrantedTime;
    }

    public final List<String> component7() {
        return this.grantedScopeNames;
    }

    public final AppletPermissionDetail copy(String r10, String r11, String r12, Integer r13, Map<String, ScopePermissionInfo> r14, Long r15, List<String> r16) {
        return new AppletPermissionDetail(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppletPermissionDetail) == true) goto L8;
        return false;
    L8:
        AppletPermissionDetail r11 = (AppletPermissionDetail) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r11.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletName, r11.appletName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appletType, r11.appletType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scopesStatus, r11.scopesStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recentGrantedTime, r11.recentGrantedTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.grantedScopeNames, r11.grantedScopeNames) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.appletId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.iconUrl;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.appletName;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.appletType;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        Map<String, ScopePermissionInfo> r21 = this.scopesStatus;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        Long r24 = this.recentGrantedTime;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        List<String> r27 = this.grantedScopeNames;
        if (r27 == null) goto L31;
        r1 = r27.hashCode();
    L31:
        return r26 + r1;
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletPermissionDetail(appletId=" + this.appletId + ", iconUrl=" + this.iconUrl + ", appletName=" + this.appletName + ", appletType=" + this.appletType + ", scopesStatus=" + this.scopesStatus + ", recentGrantedTime=" + this.recentGrantedTime + ", grantedScopeNames=" + this.grantedScopeNames + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getAppletName() {
        return this.appletName;
    }

    public final Integer getAppletType() {
        return this.appletType;
    }

    public final List<String> getGrantedScopeNames() {
        return this.grantedScopeNames;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Long getRecentGrantedTime() {
        return this.recentGrantedTime;
    }

    public final Map<String, ScopePermissionInfo> getScopesStatus() {
        return this.scopesStatus;
    }

    public AppletPermissionDetail(String r1, String r10, String r11, Integer r12, Map<String, ScopePermissionInfo> r13, Long r14, List<String> r15) {
        this.appletId = r1;
        this.iconUrl = r10;
        this.appletName = r11;
        this.appletType = r12;
        this.scopesStatus = r13;
        this.recentGrantedTime = r14;
        this.grantedScopeNames = r15;
    }

    public /* synthetic */ AppletPermissionDetail(String r10, String r11, String r12, Integer r13, Map r14, Long r15, List r16, int r17, DefaultConstructorMarker r18) {
        Long r0 = null;
        if ((r17 & 1) == 0) goto L5;
        String r19 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r20 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        Integer r21 = null;
    L19:
        if ((r17 & 16) == 0) goto L21;
        Map r22 = null;
    L23:
        if ((r17 & 32) != 0) goto L27;
        r0 = r15;
    L27:
        if ((r17 & 64) == 0) goto L29;
        r16 = CollectionsKt.emptyList();
    L29:
        this(r19, r1, r20, r21, r22, r0, r16);
        return;
    L21:
        r22 = r14;
        goto L23
    L17:
        r21 = r13;
        goto L19
    L13:
        r20 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r19 = r10;
        goto L7
    }
}
