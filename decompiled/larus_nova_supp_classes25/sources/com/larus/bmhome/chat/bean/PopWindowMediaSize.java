package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "Landroid/os/Parcelable;", "width", "", "height", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getWidth", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHeight", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowMediaSize implements Parcelable {
    public static final Parcelable.Creator<PopWindowMediaSize> CREATOR = null;

    @SerializedName("height")
    private final Long height;

    @SerializedName("width")
    private final Long width;

    public static final class a implements Parcelable.Creator<PopWindowMediaSize> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMediaSize createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Long r2 = null;
            if (r6.readInt() != 0) goto L5;
            Long r1 = null;
        L7:
            if (r6.readInt() == 0) goto L11;
            r2 = Long.valueOf(r6.readLong());
        L11:
            return new PopWindowMediaSize(r1, r2);
        L5:
            r1 = Long.valueOf(r6.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMediaSize[] newArray(int r1) {
            return new PopWindowMediaSize[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowMediaSize() {
        Long r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ PopWindowMediaSize copy$default(PopWindowMediaSize r0, Long r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        return r0.copy(r1, r2);
    }

    public final Long component1() {
        return this.width;
    }

    public final Long component2() {
        return this.height;
    }

    public final PopWindowMediaSize copy(Long r2, Long r3) {
        return new PopWindowMediaSize(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowMediaSize) == true) goto L8;
        return false;
    L8:
        PopWindowMediaSize r6 = (PopWindowMediaSize) r5;
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r0 = this.width;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.height;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowMediaSize(width=" + this.width + ", height=" + this.height + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.width;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r8 = this.height;
        if (r8 != null) goto L9;
        r5.writeInt(0);
        return;
    L9:
        r5.writeInt(1);
        r5.writeLong(r8.longValue());
        return;
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public final Long getHeight() {
        return this.height;
    }

    public final Long getWidth() {
        return this.width;
    }

    public PopWindowMediaSize(Long r1, Long r2) {
        this.width = r1;
        this.height = r2;
    }

    public /* synthetic */ PopWindowMediaSize(Long r2, Long r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
