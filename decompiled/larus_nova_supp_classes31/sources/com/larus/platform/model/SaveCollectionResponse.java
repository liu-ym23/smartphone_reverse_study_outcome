package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/SaveCollectionResponse;", "", "collectionStatus", "", "collectionId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCollectionStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/platform/model/SaveCollectionResponse;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SaveCollectionResponse {

    @SerializedName("collection_id")
    private final String collectionId;

    @SerializedName("status")
    private final Integer collectionStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public SaveCollectionResponse() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SaveCollectionResponse copy$default(SaveCollectionResponse r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.collectionStatus;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.collectionId;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.collectionStatus;
    }

    public final String component2() {
        return this.collectionId;
    }

    public final SaveCollectionResponse copy(Integer r2, String r3) {
        return new SaveCollectionResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SaveCollectionResponse) == true) goto L8;
        return false;
    L8:
        SaveCollectionResponse r6 = (SaveCollectionResponse) r5;
        if (Intrinsics.areEqual(this.collectionStatus, r6.collectionStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collectionId, r6.collectionId) == true) goto L14;
        return false;
    L14:
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
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SaveCollectionResponse(collectionStatus=" + this.collectionStatus + ", collectionId=" + this.collectionId + ')';
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final Integer getCollectionStatus() {
        return this.collectionStatus;
    }

    public SaveCollectionResponse(Integer r1, String r2) {
        this.collectionStatus = r1;
        this.collectionId = r2;
    }

    public /* synthetic */ SaveCollectionResponse(Integer r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "";
    L8:
        this(r1, r2);
    }
}
