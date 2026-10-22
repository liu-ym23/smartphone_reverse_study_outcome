package com.larus.platform.api.creation;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zp9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "", "creationRecommendType", "", "listData", "Lcom/larus/platform/api/creation/CommonCreationFeedData;", "randomSeed", "", "timeStamp", "<init>", "(Ljava/lang/String;Lcom/larus/platform/api/creation/CommonCreationFeedData;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreationRecommendType", "()Ljava/lang/String;", "getListData", "()Lcom/larus/platform/api/creation/CommonCreationFeedData;", "getRandomSeed", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimeStamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/larus/platform/api/creation/CommonCreationFeedData;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationFeedCacheEntity {

    @SerializedName("creation_recommend_type")
    private final String creationRecommendType;

    @SerializedName("list_data")
    private final c listData;

    @SerializedName("random_seed")
    private final Long randomSeed;

    @SerializedName("time_stamp")
    private final Long timeStamp;

    public CreationFeedCacheEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CreationFeedCacheEntity copy$default(CreationFeedCacheEntity r0, String r1, c r2, Long r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.creationRecommendType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.listData;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.randomSeed;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.timeStamp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.creationRecommendType;
    }

    public final c component2() {
        return this.listData;
    }

    public final Long component3() {
        return this.randomSeed;
    }

    public final Long component4() {
        return this.timeStamp;
    }

    public final CreationFeedCacheEntity copy(String r2, c r3, Long r4, Long r5) {
        return new CreationFeedCacheEntity(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationFeedCacheEntity) == true) goto L8;
        return false;
    L8:
        CreationFeedCacheEntity r6 = (CreationFeedCacheEntity) r5;
        if (Intrinsics.areEqual(this.creationRecommendType, r6.creationRecommendType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.listData, r6.listData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.randomSeed, r6.randomSeed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timeStamp, r6.timeStamp) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationRecommendType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        c r4 = this.listData;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.randomSeed;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.timeStamp;
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
        return "CreationFeedCacheEntity(creationRecommendType=" + this.creationRecommendType + ", listData=" + this.listData + ", randomSeed=" + this.randomSeed + ", timeStamp=" + this.timeStamp + ')';
    }

    public final String getCreationRecommendType() {
        return this.creationRecommendType;
    }

    public final c getListData() {
        return this.listData;
    }

    public final Long getRandomSeed() {
        return this.randomSeed;
    }

    public final Long getTimeStamp() {
        return this.timeStamp;
    }

    public CreationFeedCacheEntity(String r1, c r2, Long r3, Long r4) {
        this.creationRecommendType = r1;
        this.listData = r2;
        this.randomSeed = r3;
        this.timeStamp = r4;
    }

    public /* synthetic */ CreationFeedCacheEntity(String r3, c r4, Long r5, Long r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0L;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 0L;
    L14:
        this(r3, r4, r5, r6);
    }
}
