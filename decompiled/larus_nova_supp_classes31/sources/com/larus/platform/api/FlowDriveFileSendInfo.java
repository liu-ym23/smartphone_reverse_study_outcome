package com.larus.platform.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/api/FlowDriveFileSendInfo;", "Ljava/io/Serializable;", "collectionId", "", "collectionName", "contentType", "contentSecType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCollectionId", "()Ljava/lang/String;", "getCollectionName", "getContentType", "getContentSecType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FlowDriveFileSendInfo implements Serializable {

    @SerializedName("collection_id")
    private final String collectionId;

    @SerializedName("collection_name")
    private final String collectionName;

    @SerializedName("content_sec_type")
    private final String contentSecType;

    @SerializedName("content_type")
    private final String contentType;

    public FlowDriveFileSendInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FlowDriveFileSendInfo copy$default(FlowDriveFileSendInfo r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.collectionId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.collectionName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.contentType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.contentSecType;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.collectionId;
    }

    public final String component2() {
        return this.collectionName;
    }

    public final String component3() {
        return this.contentType;
    }

    public final String component4() {
        return this.contentSecType;
    }

    public final FlowDriveFileSendInfo copy(String r2, String r3, String r4, String r5) {
        return new FlowDriveFileSendInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowDriveFileSendInfo) == true) goto L8;
        return false;
    L8:
        FlowDriveFileSendInfo r6 = (FlowDriveFileSendInfo) r5;
        if (Intrinsics.areEqual(this.collectionId, r6.collectionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collectionName, r6.collectionName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.contentType, r6.contentType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentSecType, r6.contentSecType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.collectionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.collectionName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.contentType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.contentSecType;
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
        return "FlowDriveFileSendInfo(collectionId=" + this.collectionId + ", collectionName=" + this.collectionName + ", contentType=" + this.contentType + ", contentSecType=" + this.contentSecType + ')';
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getCollectionName() {
        return this.collectionName;
    }

    public final String getContentSecType() {
        return this.contentSecType;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public FlowDriveFileSendInfo(String r1, String r2, String r3, String r4) {
        this.collectionId = r1;
        this.collectionName = r2;
        this.contentType = r3;
        this.contentSecType = r4;
    }

    public /* synthetic */ FlowDriveFileSendInfo(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
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
