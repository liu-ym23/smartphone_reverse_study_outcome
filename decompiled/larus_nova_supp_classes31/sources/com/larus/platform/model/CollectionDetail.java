package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/platform/model/CollectionDetail;", "", "referenceId", "", "status", "", "collectionType", "snapshot", "isLike", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getReferenceId", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionType", "getSnapshot", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/platform/model/CollectionDetail;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CollectionDetail {

    @SerializedName("collection_type")
    private final Integer collectionType;

    @SerializedName("is_like")
    private final Boolean isLike;

    @SerializedName("reference_id")
    private final String referenceId;

    @SerializedName("snapshot")
    private final String snapshot;

    @SerializedName("status")
    private final Integer status;

    public CollectionDetail() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CollectionDetail copy$default(CollectionDetail r3, String r4, Integer r5, Integer r6, String r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.referenceId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.status;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.collectionType;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.snapshot;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isLike;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.referenceId;
    }

    public final Integer component2() {
        return this.status;
    }

    public final Integer component3() {
        return this.collectionType;
    }

    public final String component4() {
        return this.snapshot;
    }

    public final Boolean component5() {
        return this.isLike;
    }

    public final CollectionDetail copy(String r8, Integer r9, Integer r10, String r11, Boolean r12) {
        return new CollectionDetail(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CollectionDetail) == true) goto L8;
        return false;
    L8:
        CollectionDetail r6 = (CollectionDetail) r5;
        if (Intrinsics.areEqual(this.referenceId, r6.referenceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collectionType, r6.collectionType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.snapshot, r6.snapshot) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isLike, r6.isLike) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.referenceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.status;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.collectionType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.snapshot;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isLike;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "CollectionDetail(referenceId=" + this.referenceId + ", status=" + this.status + ", collectionType=" + this.collectionType + ", snapshot=" + this.snapshot + ", isLike=" + this.isLike + ')';
    }

    public final Integer getCollectionType() {
        return this.collectionType;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final String getSnapshot() {
        return this.snapshot;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Boolean isLike() {
        return this.isLike;
    }

    public CollectionDetail(String r1, Integer r2, Integer r3, String r4, Boolean r5) {
        this.referenceId = r1;
        this.status = r2;
        this.collectionType = r3;
        this.snapshot = r4;
        this.isLike = r5;
    }

    public /* synthetic */ CollectionDetail(String r4, Integer r5, Integer r6, String r7, Boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = 0;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = null;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = Boolean.FALSE;
    L17:
        String r12 = r4;
        this(r12, r11, r0, r1, r8);
    }
}
