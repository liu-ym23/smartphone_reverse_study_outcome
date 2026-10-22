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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/AppletPermissionQuery;", "Ljava/io/Serializable;", "appletId", "", "scopes", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getAppletId", "()Ljava/lang/String;", "getScopes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPermissionQuery implements Serializable {

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("scopes")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> scopes;

    /* JADX WARN: Multi-variable type inference failed */
    public AppletPermissionQuery() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppletPermissionQuery copy$default(AppletPermissionQuery r0, String r1, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.appletId;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.scopes;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.appletId;
    }

    public final List<String> component2() {
        return this.scopes;
    }

    public final AppletPermissionQuery copy(String r10, List<String> r11) {
        return new AppletPermissionQuery(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppletPermissionQuery) == true) goto L8;
        return false;
    L8:
        AppletPermissionQuery r11 = (AppletPermissionQuery) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scopes, r11.scopes) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.appletId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        List<String> r12 = this.scopes;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletPermissionQuery(appletId=" + this.appletId + ", scopes=" + this.scopes + ')';
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public AppletPermissionQuery(String r1, List<String> r10) {
        this.appletId = r1;
        this.scopes = r10;
    }

    public /* synthetic */ AppletPermissionQuery(String r1, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        this(r1, r10);
    }
}
