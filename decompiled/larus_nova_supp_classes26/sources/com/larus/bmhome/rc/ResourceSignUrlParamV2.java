package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/rc/ResourceSignUrlParamV2;", "", "resourceId", "", "uri", "resourceType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getResourceId", "()Ljava/lang/String;", "getUri", "getResourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/rc/ResourceSignUrlParamV2;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceSignUrlParamV2 {

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("resource_type")
    private final Integer resourceType;

    @SerializedName("uri")
    private final String uri;

    public ResourceSignUrlParamV2() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ResourceSignUrlParamV2 copy$default(ResourceSignUrlParamV2 r0, String r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.resourceId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.uri;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.resourceType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final String component2() {
        return this.uri;
    }

    public final Integer component3() {
        return this.resourceType;
    }

    public final ResourceSignUrlParamV2 copy(String r2, String r3, Integer r4) {
        return new ResourceSignUrlParamV2(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceSignUrlParamV2) == true) goto L8;
        return false;
    L8:
        ResourceSignUrlParamV2 r6 = (ResourceSignUrlParamV2) r5;
        if (Intrinsics.areEqual(this.resourceId, r6.resourceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resourceType, r6.resourceType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.resourceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.uri;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.resourceType;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceSignUrlParamV2(resourceId=" + this.resourceId + ", uri=" + this.uri + ", resourceType=" + this.resourceType + ')';
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final String getUri() {
        return this.uri;
    }

    public ResourceSignUrlParamV2(String r1, String r2, Integer r3) {
        this.resourceId = r1;
        this.uri = r2;
        this.resourceType = r3;
    }

    public /* synthetic */ ResourceSignUrlParamV2(String r2, String r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
