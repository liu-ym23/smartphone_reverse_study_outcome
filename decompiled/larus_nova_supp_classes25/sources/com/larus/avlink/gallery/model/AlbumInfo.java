package com.larus.avlink.gallery.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.MediaInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0013\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/gallery/model/AlbumInfo;", "Ljava/io/Serializable;", "list", "", "Lcom/larus/dora/api/model/MediaInfo;", "pictureCount", "", "videoCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getList", "()Ljava/util/List;", "getPictureCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoCount", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/avlink/gallery/model/AlbumInfo;", "equals", "", "other", "", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumInfo implements Serializable {
    public static final int $stable = 8;

    @SerializedName("list")
    private final List<MediaInfo> list;

    @SerializedName("picture_count")
    private final Integer pictureCount;

    @SerializedName("video_count")
    private final Integer videoCount;

    public AlbumInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumInfo copy$default(AlbumInfo r0, List r1, Integer r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.list;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.pictureCount;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.videoCount;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<MediaInfo> component1() {
        return this.list;
    }

    public final Integer component2() {
        return this.pictureCount;
    }

    public final Integer component3() {
        return this.videoCount;
    }

    public final AlbumInfo copy(List<MediaInfo> r2, Integer r3, Integer r4) {
        return new AlbumInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AlbumInfo) == true) goto L8;
        return false;
    L8:
        AlbumInfo r6 = (AlbumInfo) r5;
        if (Intrinsics.areEqual(this.list, r6.list) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pictureCount, r6.pictureCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoCount, r6.videoCount) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<MediaInfo> r0 = this.list;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.pictureCount;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.videoCount;
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
        return "AlbumInfo(list=" + this.list + ", pictureCount=" + this.pictureCount + ", videoCount=" + this.videoCount + ')';
    }

    public final List<MediaInfo> getList() {
        return this.list;
    }

    public final Integer getPictureCount() {
        return this.pictureCount;
    }

    public final Integer getVideoCount() {
        return this.videoCount;
    }

    public AlbumInfo(List<MediaInfo> r1, Integer r2, Integer r3) {
        this.list = r1;
        this.pictureCount = r2;
        this.videoCount = r3;
    }

    public /* synthetic */ AlbumInfo(List r2, Integer r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
