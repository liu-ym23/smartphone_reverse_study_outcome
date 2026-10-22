package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageUploadResult;", "", "entityType", "", "entityId", "", "imageUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getEntityType", "()I", "getEntityId", "()Ljava/lang/String;", "getImageUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageUploadResult {
    private final String entityId;
    private final int entityType;
    private final String imageUrl;

    public ImageUploadResult(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r4, "imageUrl");
        this.entityType = r2;
        this.entityId = r3;
        this.imageUrl = r4;
    }

    public static /* synthetic */ ImageUploadResult copy$default(ImageUploadResult r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.entityType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.entityId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.imageUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.entityType;
    }

    public final String component2() {
        return this.entityId;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final ImageUploadResult copy(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r3, "imageUrl");
        return new ImageUploadResult(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ImageUploadResult.class) == true) goto L8;
        return false;
    L8:
        ImageUploadResult r6 = (ImageUploadResult) ZeusTransformUtils.preCheckCast(r5, ImageUploadResult.class, "com.obric.memorydata.plugin");
        if (this.entityType == r6.entityType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUrl, r6.imageUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.entityType) * 31) + this.entityId.hashCode()) * 31) + this.imageUrl.hashCode();
    }

    public String toString() {
        return "ImageUploadResult(entityType=" + this.entityType + ", entityId=" + this.entityId + ", imageUrl=" + this.imageUrl + ')';
    }
}
