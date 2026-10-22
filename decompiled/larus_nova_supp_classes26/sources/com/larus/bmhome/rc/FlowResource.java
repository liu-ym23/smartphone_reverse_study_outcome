package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.upload.FlowResourceType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/rc/FlowResource;", "", "uri", "", "resourceType", "", "meta", "Lcom/larus/bmhome/rc/FlowResourceMeta;", "identifier", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/rc/FlowResourceMeta;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getResourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMeta", "()Lcom/larus/bmhome/rc/FlowResourceMeta;", "getIdentifier", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/rc/FlowResourceMeta;Ljava/lang/String;)Lcom/larus/bmhome/rc/FlowResource;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowResource {
    private final transient String identifier;

    @SerializedName("meta")
    private final FlowResourceMeta meta;

    @SerializedName("resource_type")
    private final Integer resourceType;

    @SerializedName("uri")
    private final String uri;

    public FlowResource() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FlowResource copy$default(FlowResource r0, String r1, Integer r2, FlowResourceMeta r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.uri;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.resourceType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.meta;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.identifier;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.uri;
    }

    public final Integer component2() {
        return this.resourceType;
    }

    public final FlowResourceMeta component3() {
        return this.meta;
    }

    public final String component4() {
        return this.identifier;
    }

    public final FlowResource copy(String r2, Integer r3, FlowResourceMeta r4, String r5) {
        return new FlowResource(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowResource) == true) goto L8;
        return false;
    L8:
        FlowResource r6 = (FlowResource) r5;
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceType, r6.resourceType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.meta, r6.meta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.identifier, r6.identifier) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.uri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.resourceType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        FlowResourceMeta r7 = this.meta;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.identifier;
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
        return "FlowResource(uri=" + this.uri + ", resourceType=" + this.resourceType + ", meta=" + this.meta + ", identifier=" + this.identifier + ')';
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final FlowResourceMeta getMeta() {
        return this.meta;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final String getUri() {
        return this.uri;
    }

    public FlowResource(String r1, Integer r2, FlowResourceMeta r3, String r4) {
        this.uri = r1;
        this.resourceType = r2;
        this.meta = r3;
        this.identifier = r4;
    }

    public /* synthetic */ FlowResource(String r2, Integer r3, FlowResourceMeta r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = Integer.valueOf(FlowResourceType.Unknown.getValue());
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
