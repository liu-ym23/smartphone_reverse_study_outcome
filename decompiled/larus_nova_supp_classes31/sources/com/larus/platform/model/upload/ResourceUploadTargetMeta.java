package com.larus.platform.model.upload;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadTargetMeta;", "Ljava/io/Serializable;", "targetUri", "", "targetResourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTargetUri", "()Ljava/lang/String;", "getTargetResourceId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ResourceUploadTargetMeta implements Serializable {
    private final String targetResourceId;
    private final String targetUri;

    public ResourceUploadTargetMeta() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ResourceUploadTargetMeta copy$default(ResourceUploadTargetMeta r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targetUri;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.targetResourceId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.targetUri;
    }

    public final String component2() {
        return this.targetResourceId;
    }

    public final ResourceUploadTargetMeta copy(String r2, String r3) {
        return new ResourceUploadTargetMeta(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceUploadTargetMeta) == true) goto L8;
        return false;
    L8:
        ResourceUploadTargetMeta r6 = (ResourceUploadTargetMeta) r5;
        if (Intrinsics.areEqual(this.targetUri, r6.targetUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetResourceId, r6.targetResourceId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.targetUri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.targetResourceId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceUploadTargetMeta(targetUri=" + this.targetUri + ", targetResourceId=" + this.targetResourceId + ')';
    }

    public final String getTargetResourceId() {
        return this.targetResourceId;
    }

    public final String getTargetUri() {
        return this.targetUri;
    }

    public ResourceUploadTargetMeta(String r1, String r2) {
        this.targetUri = r1;
        this.targetResourceId = r2;
    }

    public /* synthetic */ ResourceUploadTargetMeta(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
