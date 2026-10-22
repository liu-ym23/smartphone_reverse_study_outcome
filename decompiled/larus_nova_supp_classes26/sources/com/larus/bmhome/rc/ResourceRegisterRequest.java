package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/rc/ResourceRegisterRequest;", "", "tenantId", "", "sceneId", "resourceList", "", "Lcom/larus/bmhome/rc/FlowResource;", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getTenantId", "()Ljava/lang/String;", "getSceneId", "getResourceList", "()Ljava/util/List;", "getExtra", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceRegisterRequest {

    @SerializedName("extra")
    private final String extra;

    @SerializedName("resource_list")
    private final List<FlowResource> resourceList;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName("tenant_id")
    private final String tenantId;

    public ResourceRegisterRequest() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceRegisterRequest copy$default(ResourceRegisterRequest r0, String r1, String r2, List r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.tenantId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.sceneId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.resourceList;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extra;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.tenantId;
    }

    public final String component2() {
        return this.sceneId;
    }

    public final List<FlowResource> component3() {
        return this.resourceList;
    }

    public final String component4() {
        return this.extra;
    }

    public final ResourceRegisterRequest copy(String r2, String r3, List<FlowResource> r4, String r5) {
        return new ResourceRegisterRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceRegisterRequest) == true) goto L8;
        return false;
    L8:
        ResourceRegisterRequest r6 = (ResourceRegisterRequest) r5;
        if (Intrinsics.areEqual(this.tenantId, r6.tenantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneId, r6.sceneId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resourceList, r6.resourceList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.tenantId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sceneId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<FlowResource> r7 = this.resourceList;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.extra;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceRegisterRequest(tenantId=" + this.tenantId + ", sceneId=" + this.sceneId + ", resourceList=" + this.resourceList + ", extra=" + this.extra + ')';
    }

    public final String getExtra() {
        return this.extra;
    }

    public final List<FlowResource> getResourceList() {
        return this.resourceList;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public ResourceRegisterRequest(String r1, String r2, List<FlowResource> r3, String r4) {
        this.tenantId = r1;
        this.sceneId = r2;
        this.resourceList = r3;
        this.extra = r4;
    }

    public /* synthetic */ ResourceRegisterRequest(String r2, String r3, List r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
