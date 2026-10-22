package com.larus.platform.model.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/comment/LikeInfo;", "Landroid/os/Parcelable;", "likeCount", "", "likeStatus", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "getLikeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLikeStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/platform/model/comment/LikeInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LikeInfo implements Parcelable {
    public static final Parcelable.Creator<LikeInfo> CREATOR = null;

    @SerializedName("like_count")
    private final Long likeCount;

    @SerializedName("like_status")
    private final Integer likeStatus;

    public static final class a implements Parcelable.Creator<LikeInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LikeInfo createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Integer r2 = null;
            if (r6.readInt() != 0) goto L5;
            Long r1 = null;
        L7:
            if (r6.readInt() == 0) goto L11;
            r2 = Integer.valueOf(r6.readInt());
        L11:
            return new LikeInfo(r1, r2);
        L5:
            r1 = Long.valueOf(r6.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LikeInfo[] newArray(int r1) {
            return new LikeInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public LikeInfo() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LikeInfo) == true) goto L8;
        return false;
    L8:
        LikeInfo r6 = (LikeInfo) r5;
        if (Intrinsics.areEqual(this.likeCount, r6.likeCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.likeStatus, r6.likeStatus) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.likeCount;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.likeStatus;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LikeInfo(likeCount=" + this.likeCount + ", likeStatus=" + this.likeStatus + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.likeCount;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.likeStatus;
        if (r8 != null) goto L9;
        r5.writeInt(0);
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        return;
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public final Long a() {
        return this.likeCount;
    }

    public final Integer b() {
        return this.likeStatus;
    }

    public /* synthetic */ LikeInfo(int r3) {
        this(0L, 0);
    }

    public LikeInfo(Long r1, Integer r2) {
        this.likeCount = r1;
        this.likeStatus = r2;
    }
}
