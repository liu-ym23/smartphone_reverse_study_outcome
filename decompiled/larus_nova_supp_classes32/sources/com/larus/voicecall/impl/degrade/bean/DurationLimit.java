package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\""}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/DurationLimit;", "Landroid/os/Parcelable;", "dayAvailableSecs", NameKeys.UnloadStrategy_No_Strategy, "dayLimitToast", NameKeys.UnloadStrategy_No_Strategy, "monthAvailableSecs", "monthLimitToast", "<init>", "(JLjava/lang/String;JLjava/lang/String;)V", "getDayAvailableSecs", "()J", "getDayLimitToast", "()Ljava/lang/String;", "getMonthAvailableSecs", "getMonthLimitToast", "component1", "component2", "component3", "component4", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", NameKeys.UnloadStrategy_No_Strategy, "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DurationLimit implements Parcelable {
    public static final Parcelable.Creator<DurationLimit> CREATOR = null;

    @SerializedName("day_available_secs")
    private final long dayAvailableSecs;

    @SerializedName("day_limit_toast")
    private final String dayLimitToast;

    @SerializedName("month_available_secs")
    private final long monthAvailableSecs;

    @SerializedName("month_limit_toast")
    private final String monthLimitToast;

    public static final class a implements Parcelable.Creator<DurationLimit> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DurationLimit createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            return new DurationLimit(r9.readLong(), r9.readString(), r9.readLong(), r9.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DurationLimit[] newArray(int r1) {
            return new DurationLimit[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DurationLimit() {
        this(0, null, 0, null, 15, null);
    }

    public static /* synthetic */ DurationLimit copy$default(DurationLimit r7, long r8, String r10, long r11, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.dayAvailableSecs;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.dayLimitToast;
    L8:
        String r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.monthAvailableSecs;
    L11:
        long r4 = r11;
        if ((r14 & 8) == 0) goto L15;
        r13 = r7.monthLimitToast;
    L15:
        return r7.copy(r1, r3, r4, r13);
    }

    public final long component1() {
        return this.dayAvailableSecs;
    }

    public final String component2() {
        return this.dayLimitToast;
    }

    public final long component3() {
        return this.monthAvailableSecs;
    }

    public final String component4() {
        return this.monthLimitToast;
    }

    public final DurationLimit copy(long r9, String r11, long r12, String r14) {
        return new DurationLimit(r9, r11, r12, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DurationLimit) == true) goto L8;
        return false;
    L8:
        DurationLimit r9 = (DurationLimit) r8;
        if (this.dayAvailableSecs == r9.dayAvailableSecs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dayLimitToast, r9.dayLimitToast) == true) goto L15;
        return false;
    L15:
        if (this.monthAvailableSecs == r9.monthAvailableSecs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.monthLimitToast, r9.monthLimitToast) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r0 = this.dayAvailableSecs;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.dayLimitToast;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        long r5 = this.monthAvailableSecs;
        int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.monthLimitToast;
        if (r7 == null) goto L11;
        r3 = r7.hashCode();
    L11:
        return r6 + r3;
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "DurationLimit(dayAvailableSecs=" + this.dayAvailableSecs + ", dayLimitToast=" + this.dayLimitToast + ", monthAvailableSecs=" + this.monthAvailableSecs + ", monthLimitToast=" + this.monthLimitToast + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.dayAvailableSecs);
        r3.writeString(this.dayLimitToast);
        r3.writeLong(this.monthAvailableSecs);
        r3.writeString(this.monthLimitToast);
    }

    public final long getDayAvailableSecs() {
        return this.dayAvailableSecs;
    }

    public final String getDayLimitToast() {
        return this.dayLimitToast;
    }

    public final long getMonthAvailableSecs() {
        return this.monthAvailableSecs;
    }

    public final String getMonthLimitToast() {
        return this.monthLimitToast;
    }

    public DurationLimit(long r1, String r3, long r4, String r6) {
        this.dayAvailableSecs = r1;
        this.dayLimitToast = r3;
        this.monthAvailableSecs = r4;
        this.monthLimitToast = r6;
    }

    public /* synthetic */ DurationLimit(long r5, String r7, long r8, String r10, int r11, DefaultConstructorMarker r12) {
        long r0 = -1;
        if ((r11 & 1) == 0) goto L5;
        long r2 = -1;
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r11 & 4) != 0) goto L15;
        r0 = r8;
    L15:
        if ((r11 & 8) == 0) goto L17;
        String r14 = null;
    L18:
        this(r2, r13, r0, r14);
        return;
    L17:
        r14 = r10;
        goto L18
    L9:
        r13 = r7;
        goto L11
    L5:
        r2 = r5;
        goto L7
    }
}
