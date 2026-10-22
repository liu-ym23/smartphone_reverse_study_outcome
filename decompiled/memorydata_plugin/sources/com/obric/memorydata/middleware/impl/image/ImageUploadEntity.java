package com.obric.memorydata.middleware.impl.image;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageUploadEntity;", "", "entityType", "", "entityId", "", "uri", ObricMemoryConstants.KEY_PACKAGE_NAME, "needDelete", "", "tempFilePath", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getEntityType", "()I", "getEntityId", "()Ljava/lang/String;", "getUri", "getPackageName", "getNeedDelete", "()Z", "getTempFilePath", "setTempFilePath", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageUploadEntity {
    private final String entityId;
    private final int entityType;
    private final boolean needDelete;
    private final String packageName;
    private String tempFilePath;
    private final String uri;

    public ImageUploadEntity(int r2, String r3, String r4, String r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.entityType = r2;
        this.entityId = r3;
        this.uri = r4;
        this.packageName = r5;
        this.needDelete = r6;
        this.tempFilePath = r7;
    }

    public /* synthetic */ ImageUploadEntity(int r8, String r9, String r10, String r11, boolean r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = false;
    L5:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = null;
    L8:
        this(r8, r9, r10, r11, r5, r13);
    }

    public static /* synthetic */ ImageUploadEntity copy$default(ImageUploadEntity r4, int r5, String r6, String r7, String r8, boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.entityType;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.entityId;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.uri;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.packageName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.needDelete;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.tempFilePath;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.entityType;
    }

    public final String component2() {
        return this.entityId;
    }

    public final String component3() {
        return this.uri;
    }

    public final String component4() {
        return this.packageName;
    }

    public final boolean component5() {
        return this.needDelete;
    }

    public final String component6() {
        return this.tempFilePath;
    }

    public final ImageUploadEntity copy(int r8, String r9, String r10, String r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "entityId");
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return new ImageUploadEntity(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ImageUploadEntity.class) == true) goto L8;
        return false;
    L8:
        ImageUploadEntity r6 = (ImageUploadEntity) ZeusTransformUtils.preCheckCast(r5, ImageUploadEntity.class, "com.obric.memorydata.plugin");
        if (this.entityType == r6.entityType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L21;
        return false;
    L21:
        if (this.needDelete == r6.needDelete) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tempFilePath, r6.tempFilePath) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final boolean getNeedDelete() {
        return this.needDelete;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getTempFilePath() {
        return this.tempFilePath;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.entityType) * 31) + this.entityId.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Boolean.hashCode(this.needDelete)) * 31;
        String r2 = this.tempFilePath;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final void setTempFilePath(String r1) {
        this.tempFilePath = r1;
    }

    public String toString() {
        return "ImageUploadEntity(entityType=" + this.entityType + ", entityId=" + this.entityId + ", uri=" + this.uri + ", packageName=" + this.packageName + ", needDelete=" + this.needDelete + ", tempFilePath=" + this.tempFilePath + ')';
    }
}
