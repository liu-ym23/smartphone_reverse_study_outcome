package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "Landroid/os/Parcelable;", "startHour", "", "endHour", "maxShowCountPerDay", "maxShowCountTotal", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getStartHour", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndHour", "getMaxShowCountPerDay", "getMaxShowCountTotal", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowFrequencyConf implements Parcelable {
    public static final Parcelable.Creator<PopWindowFrequencyConf> CREATOR = null;

    @SerializedName("end_hour")
    private final Long endHour;

    @SerializedName("max_show_count_per_day")
    private final Long maxShowCountPerDay;

    @SerializedName("max_show_count_total")
    private final Long maxShowCountTotal;

    @SerializedName("start_hour")
    private final Long startHour;

    public static final class a implements Parcelable.Creator<PopWindowFrequencyConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowFrequencyConf createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            Long r2 = null;
            if (r8.readInt() != 0) goto L5;
            Long r1 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Long r3 = null;
        L11:
            if (r8.readInt() != 0) goto L13;
            Long r4 = null;
        L15:
            if (r8.readInt() == 0) goto L19;
            r2 = Long.valueOf(r8.readLong());
        L19:
            return new PopWindowFrequencyConf(r1, r3, r4, r2);
        L13:
            r4 = Long.valueOf(r8.readLong());
            goto L15
        L9:
            r3 = Long.valueOf(r8.readLong());
            goto L11
        L5:
            r1 = Long.valueOf(r8.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowFrequencyConf[] newArray(int r1) {
            return new PopWindowFrequencyConf[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowFrequencyConf() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PopWindowFrequencyConf copy$default(PopWindowFrequencyConf r0, Long r1, Long r2, Long r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.startHour;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.endHour;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.maxShowCountPerDay;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.maxShowCountTotal;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Long component1() {
        return this.startHour;
    }

    public final Long component2() {
        return this.endHour;
    }

    public final Long component3() {
        return this.maxShowCountPerDay;
    }

    public final Long component4() {
        return this.maxShowCountTotal;
    }

    public final PopWindowFrequencyConf copy(Long r2, Long r3, Long r4, Long r5) {
        return new PopWindowFrequencyConf(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowFrequencyConf) == true) goto L8;
        return false;
    L8:
        PopWindowFrequencyConf r6 = (PopWindowFrequencyConf) r5;
        if (Intrinsics.areEqual(this.startHour, r6.startHour) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endHour, r6.endHour) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxShowCountPerDay, r6.maxShowCountPerDay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxShowCountTotal, r6.maxShowCountTotal) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r0 = this.startHour;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.endHour;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.maxShowCountPerDay;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.maxShowCountTotal;
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
        return "PopWindowFrequencyConf(startHour=" + this.startHour + ", endHour=" + this.endHour + ", maxShowCountPerDay=" + this.maxShowCountPerDay + ", maxShowCountTotal=" + this.maxShowCountTotal + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.startHour;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r8 = this.endHour;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Long r9 = this.maxShowCountPerDay;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L14:
        Long r10 = this.maxShowCountTotal;
        if (r10 != null) goto L17;
        r5.writeInt(0);
        return;
    L17:
        r5.writeInt(1);
        r5.writeLong(r10.longValue());
        return;
    L13:
        r5.writeInt(1);
        r5.writeLong(r9.longValue());
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeLong(r8.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public final Long getEndHour() {
        return this.endHour;
    }

    public final Long getMaxShowCountPerDay() {
        return this.maxShowCountPerDay;
    }

    public final Long getMaxShowCountTotal() {
        return this.maxShowCountTotal;
    }

    public final Long getStartHour() {
        return this.startHour;
    }

    public PopWindowFrequencyConf(Long r1, Long r2, Long r3, Long r4) {
        this.startHour = r1;
        this.endHour = r2;
        this.maxShowCountPerDay = r3;
        this.maxShowCountTotal = r4;
    }

    public /* synthetic */ PopWindowFrequencyConf(Long r2, Long r3, Long r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
