package com.larus.dora.api.model;

import b49.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/api/model/AlbumNotify;", "Ljava/io/Serializable;", "notifyType", "", "media", "Lcom/larus/dora/api/model/MediaInfo;", "count", "Lcom/larus/dora/api/model/AlbumCount;", "<init>", "(Ljava/lang/Long;Lcom/larus/dora/api/model/MediaInfo;Lcom/larus/dora/api/model/AlbumCount;)V", "getNotifyType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMedia", "()Lcom/larus/dora/api/model/MediaInfo;", "getCount", "()Lcom/larus/dora/api/model/AlbumCount;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Lcom/larus/dora/api/model/MediaInfo;Lcom/larus/dora/api/model/AlbumCount;)Lcom/larus/dora/api/model/AlbumNotify;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumNotify implements Serializable {

    @SerializedName("count")
    private final a count;

    @SerializedName("item")
    private final MediaInfo media;

    @SerializedName("notify_type")
    private final Long notifyType;

    public AlbumNotify() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AlbumNotify copy$default(AlbumNotify r0, Long r1, MediaInfo r2, a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.notifyType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.media;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.count;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Long component1() {
        return this.notifyType;
    }

    public final MediaInfo component2() {
        return this.media;
    }

    public final a component3() {
        return this.count;
    }

    public final AlbumNotify copy(Long r2, MediaInfo r3, a r4) {
        return new AlbumNotify(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AlbumNotify) == true) goto L8;
        return false;
    L8:
        AlbumNotify r6 = (AlbumNotify) r5;
        if (Intrinsics.areEqual(this.notifyType, r6.notifyType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.media, r6.media) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.count, r6.count) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r0 = this.notifyType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        MediaInfo r4 = this.media;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.count;
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
        return "AlbumNotify(notifyType=" + this.notifyType + ", media=" + this.media + ", count=" + this.count + ')';
    }

    public final a getCount() {
        return this.count;
    }

    public final MediaInfo getMedia() {
        return this.media;
    }

    public final Long getNotifyType() {
        return this.notifyType;
    }

    public AlbumNotify(Long r1, MediaInfo r2, a r3) {
        this.notifyType = r1;
        this.media = r2;
        this.count = r3;
    }

    public /* synthetic */ AlbumNotify(Long r2, MediaInfo r3, a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
