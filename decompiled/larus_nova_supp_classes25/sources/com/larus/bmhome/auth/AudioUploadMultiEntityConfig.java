package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011JD\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\bJ\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006."}, d2 = {"Lcom/larus/bmhome/auth/AudioUploadMultiEntityConfig;", "Landroid/os/Parcelable;", "allowedTypes", "", "", "maxFileSize", "", "maxFileCount", "", "maxDuration", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)V", "getAllowedTypes", "()Ljava/util/List;", "setAllowedTypes", "(Ljava/util/List;)V", "getMaxFileSize", "()Ljava/lang/Long;", "setMaxFileSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxFileCount", "()Ljava/lang/Integer;", "setMaxFileCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaxDuration", "setMaxDuration", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/larus/bmhome/auth/AudioUploadMultiEntityConfig;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AudioUploadMultiEntityConfig implements Parcelable {
    public static final Parcelable.Creator<AudioUploadMultiEntityConfig> CREATOR = null;

    @SerializedName("allow_types")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<String> allowedTypes;

    @SerializedName("max_duration")
    private Long maxDuration;

    @SerializedName("max_cnt")
    private Integer maxFileCount;

    @SerializedName("max_size")
    private Long maxFileSize;

    public static final class a implements Parcelable.Creator<AudioUploadMultiEntityConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AudioUploadMultiEntityConfig createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            ArrayList<String> r1 = r8.createStringArrayList();
            Long r3 = null;
            if (r8.readInt() != 0) goto L5;
            Long r2 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Integer r4 = null;
        L11:
            if (r8.readInt() == 0) goto L15;
            r3 = Long.valueOf(r8.readLong());
        L15:
            return new AudioUploadMultiEntityConfig(r1, r2, r4, r3);
        L9:
            r4 = Integer.valueOf(r8.readInt());
            goto L11
        L5:
            r2 = Long.valueOf(r8.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AudioUploadMultiEntityConfig[] newArray(int r1) {
            return new AudioUploadMultiEntityConfig[r1];
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
        if ((r5 instanceof AudioUploadMultiEntityConfig) == true) goto L8;
        return false;
    L8:
        AudioUploadMultiEntityConfig r6 = (AudioUploadMultiEntityConfig) r5;
        if (Intrinsics.areEqual(this.allowedTypes, r6.allowedTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxFileSize, r6.maxFileSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxFileCount, r6.maxFileCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDuration, r6.maxDuration) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.allowedTypes;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.maxFileSize;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.maxFileCount;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.maxDuration;
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

    public final String toString() {
        return "AudioUploadMultiEntityConfig(allowedTypes=" + this.allowedTypes + ", maxFileSize=" + this.maxFileSize + ", maxFileCount=" + this.maxFileCount + ", maxDuration=" + this.maxDuration + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeStringList(this.allowedTypes);
        Long r7 = this.maxFileSize;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.maxFileCount;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Long r9 = this.maxDuration;
        if (r9 != null) goto L13;
        r5.writeInt(0);
        return;
    L13:
        r5.writeInt(1);
        r5.writeLong(r9.longValue());
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public AudioUploadMultiEntityConfig() {
        this(null, 0L, 0, 0L);
    }

    public AudioUploadMultiEntityConfig(List<String> r1, Long r2, Integer r3, Long r4) {
        this.allowedTypes = r1;
        this.maxFileSize = r2;
        this.maxFileCount = r3;
        this.maxDuration = r4;
    }
}
