package com.larus.doc.impl.chat.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/doc/impl/chat/data/DocArtifactInfo;", "Ljava/io/Serializable;", "artifactMetaId", "", "resourceId", "resourceType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getArtifactMetaId", "()Ljava/lang/String;", "getResourceId", "getResourceType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocArtifactInfo implements Serializable {

    @SerializedName("artifact_meta_id")
    private final String artifactMetaId;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("resource_type")
    private final int resourceType;

    public DocArtifactInfo() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ DocArtifactInfo copy$default(DocArtifactInfo r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.artifactMetaId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.resourceId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.resourceType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.artifactMetaId;
    }

    public final String component2() {
        return this.resourceId;
    }

    public final int component3() {
        return this.resourceType;
    }

    public final DocArtifactInfo copy(String r2, String r3, int r4) {
        return new DocArtifactInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocArtifactInfo) == true) goto L8;
        return false;
    L8:
        DocArtifactInfo r6 = (DocArtifactInfo) r5;
        if (Intrinsics.areEqual(this.artifactMetaId, r6.artifactMetaId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceId, r6.resourceId) == true) goto L15;
        return false;
    L15:
        if (this.resourceType == r6.resourceType) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.artifactMetaId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.resourceId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.resourceType;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DocArtifactInfo(artifactMetaId=" + this.artifactMetaId + ", resourceId=" + this.resourceId + ", resourceType=" + this.resourceType + ')';
    }

    public final String getArtifactMetaId() {
        return this.artifactMetaId;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getResourceType() {
        return this.resourceType;
    }

    public DocArtifactInfo(String r1, String r2, int r3) {
        this.artifactMetaId = r1;
        this.resourceId = r2;
        this.resourceType = r3;
    }

    public /* synthetic */ DocArtifactInfo(String r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
