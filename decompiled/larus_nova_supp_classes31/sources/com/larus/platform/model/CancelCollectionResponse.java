package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/CancelCollectionResponse;", "", "collectionStatus", "", "collectionId", "", "collectionInfo", "Lcom/larus/platform/model/MessageCollection;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/platform/model/MessageCollection;)V", "getCollectionStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionId", "()Ljava/lang/String;", "getCollectionInfo", "()Lcom/larus/platform/model/MessageCollection;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/platform/model/MessageCollection;)Lcom/larus/platform/model/CancelCollectionResponse;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CancelCollectionResponse {

    @SerializedName("collection_id")
    private final String collectionId;

    @SerializedName("collection_info")
    private final MessageCollection collectionInfo;

    @SerializedName("status")
    private final Integer collectionStatus;

    public CancelCollectionResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CancelCollectionResponse copy$default(CancelCollectionResponse r0, Integer r1, String r2, MessageCollection r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.collectionStatus;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.collectionId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.collectionInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.collectionStatus;
    }

    public final String component2() {
        return this.collectionId;
    }

    public final MessageCollection component3() {
        return this.collectionInfo;
    }

    public final CancelCollectionResponse copy(Integer r2, String r3, MessageCollection r4) {
        return new CancelCollectionResponse(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CancelCollectionResponse) == true) goto L8;
        return false;
    L8:
        CancelCollectionResponse r6 = (CancelCollectionResponse) r5;
        if (Intrinsics.areEqual(this.collectionStatus, r6.collectionStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collectionId, r6.collectionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collectionInfo, r6.collectionInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.collectionStatus;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.collectionId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        MessageCollection r7 = this.collectionInfo;
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
        return "CancelCollectionResponse(collectionStatus=" + this.collectionStatus + ", collectionId=" + this.collectionId + ", collectionInfo=" + this.collectionInfo + ')';
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final MessageCollection getCollectionInfo() {
        return this.collectionInfo;
    }

    public final Integer getCollectionStatus() {
        return this.collectionStatus;
    }

    public CancelCollectionResponse(Integer r1, String r2, MessageCollection r3) {
        this.collectionStatus = r1;
        this.collectionId = r2;
        this.collectionInfo = r3;
    }

    public /* synthetic */ CancelCollectionResponse(Integer r1, String r2, MessageCollection r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }
}
