package com.larus.bmhome.video;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/video/InteractionStatistic;", "", "likedCount", "", "formattedLikedCount", "", "<init>", "(JLjava/lang/String;)V", "getLikedCount", "()J", "getFormattedLikedCount", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionStatistic {

    @SerializedName("formatted_liked_count")
    private final String formattedLikedCount;

    @SerializedName("liked_count")
    private final long likedCount;

    public InteractionStatistic() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ InteractionStatistic copy$default(InteractionStatistic r0, long r1, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.likedCount;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.formattedLikedCount;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.likedCount;
    }

    public final String component2() {
        return this.formattedLikedCount;
    }

    public final InteractionStatistic copy(long r2, String r4) {
        return new InteractionStatistic(r2, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof InteractionStatistic) == true) goto L8;
        return false;
    L8:
        InteractionStatistic r9 = (InteractionStatistic) r8;
        if (this.likedCount == r9.likedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.formattedLikedCount, r9.formattedLikedCount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = this.likedCount;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.formattedLikedCount;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "InteractionStatistic(likedCount=" + this.likedCount + ", formattedLikedCount=" + this.formattedLikedCount + ')';
    }

    public final String getFormattedLikedCount() {
        return this.formattedLikedCount;
    }

    public final long getLikedCount() {
        return this.likedCount;
    }

    public InteractionStatistic(long r1, String r3) {
        this.likedCount = r1;
        this.formattedLikedCount = r3;
    }

    public /* synthetic */ InteractionStatistic(long r1, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r3);
    }
}
