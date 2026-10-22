package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0005J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006/"}, d2 = {"Lcom/larus/bmhome/auth/UploadMultiEntityConfig;", "Landroid/os/Parcelable;", "maxFileSize", "", "maxFileCount", "", "maxImageSize", "maxImageCount", "maxTotalCount", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxFileSize", "()Ljava/lang/Long;", "setMaxFileSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxFileCount", "()Ljava/lang/Integer;", "setMaxFileCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaxImageSize", "setMaxImageSize", "getMaxImageCount", "setMaxImageCount", "getMaxTotalCount", "setMaxTotalCount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/auth/UploadMultiEntityConfig;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class UploadMultiEntityConfig implements Parcelable {
    public static final Parcelable.Creator<UploadMultiEntityConfig> CREATOR = null;

    @SerializedName("max_file_cnt")
    private Integer maxFileCount;

    @SerializedName("max_file_size")
    private Long maxFileSize;

    @SerializedName("max_image_cnt")
    private Integer maxImageCount;

    @SerializedName("max_image_size")
    private Long maxImageSize;

    @SerializedName("max_total_cnt")
    private Integer maxTotalCount;

    public static final class a implements Parcelable.Creator<UploadMultiEntityConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UploadMultiEntityConfig createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            if (r8.readInt() != 0) goto L5;
            Long r3 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Integer r4 = null;
        L11:
            if (r8.readInt() != 0) goto L13;
            Long r5 = null;
        L15:
            if (r8.readInt() != 0) goto L17;
            Integer r6 = null;
        L19:
            if (r8.readInt() != 0) goto L21;
            Integer r9 = null;
        L23:
            return new UploadMultiEntityConfig(r3, r4, r5, r6, r9);
        L21:
            r9 = Integer.valueOf(r8.readInt());
            goto L23
        L17:
            r6 = Integer.valueOf(r8.readInt());
            goto L19
        L13:
            r5 = Long.valueOf(r8.readLong());
            goto L15
        L9:
            r4 = Integer.valueOf(r8.readInt());
            goto L11
        L5:
            r3 = Long.valueOf(r8.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UploadMultiEntityConfig[] newArray(int r1) {
            return new UploadMultiEntityConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UploadMultiEntityConfig) == true) goto L8;
        return false;
    L8:
        UploadMultiEntityConfig r6 = (UploadMultiEntityConfig) r5;
        if (Intrinsics.areEqual(this.maxFileSize, r6.maxFileSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxFileCount, r6.maxFileCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxImageSize, r6.maxImageSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxImageCount, r6.maxImageCount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxTotalCount, r6.maxTotalCount) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.maxFileSize;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.maxFileCount;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.maxImageSize;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.maxImageCount;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.maxTotalCount;
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

    public final String toString() {
        return "UploadMultiEntityConfig(maxFileSize=" + this.maxFileSize + ", maxFileCount=" + this.maxFileCount + ", maxImageSize=" + this.maxImageSize + ", maxImageCount=" + this.maxImageCount + ", maxTotalCount=" + this.maxTotalCount + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.maxFileSize;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.maxFileCount;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Long r9 = this.maxImageSize;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L14:
        Integer r10 = this.maxImageCount;
        if (r10 != null) goto L17;
        r5.writeInt(0);
    L18:
        Integer r11 = this.maxTotalCount;
        if (r11 != null) goto L21;
        r5.writeInt(0);
        return;
    L21:
        r5.writeInt(1);
        r5.writeInt(r11.intValue());
        return;
    L17:
        r5.writeInt(1);
        r5.writeInt(r10.intValue());
        goto L18
    L13:
        r5.writeInt(1);
        r5.writeLong(r9.longValue());
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public UploadMultiEntityConfig() {
        this(0L, 0, 0L, 0, 0);
    }

    public UploadMultiEntityConfig(Long r1, Integer r2, Long r3, Integer r4, Integer r5) {
        this.maxFileSize = r1;
        this.maxFileCount = r2;
        this.maxImageSize = r3;
        this.maxImageCount = r4;
        this.maxTotalCount = r5;
    }
}
