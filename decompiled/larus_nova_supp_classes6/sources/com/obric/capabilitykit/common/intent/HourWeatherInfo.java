package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/HourWeatherInfo;", "Landroid/os/Parcelable;", "time", "", "temp", "", "weatherCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getTemp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTime", "()Ljava/lang/String;", "getWeatherCode", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/HourWeatherInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class HourWeatherInfo implements Parcelable {
    public static final Parcelable.Creator<HourWeatherInfo> CREATOR = null;
    private final Integer temp;
    private final String time;
    private final String weatherCode;

    static {
        CREATOR = new a();
    }

    public HourWeatherInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HourWeatherInfo copy$default(HourWeatherInfo r0, String r1, Integer r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.time;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.temp;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.weatherCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.time;
    }

    public final Integer component2() {
        return this.temp;
    }

    public final String component3() {
        return this.weatherCode;
    }

    public final HourWeatherInfo copy(String r2, Integer r3, String r4) {
        return new HourWeatherInfo(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HourWeatherInfo) == true) goto L8;
        return false;
    L8:
        HourWeatherInfo r6 = (HourWeatherInfo) r5;
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.temp, r6.temp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.weatherCode, r6.weatherCode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.time;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.temp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.weatherCode;
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
        return "HourWeatherInfo(time=" + this.time + ", temp=" + this.temp + ", weatherCode=" + this.weatherCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.time);
        Integer r0 = this.temp;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
        r2.writeString(this.weatherCode);
    }

    public final Integer getTemp() {
        return this.temp;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public HourWeatherInfo(String r1, Integer r2, String r3) {
        this.time = r1;
        this.temp = r2;
        this.weatherCode = r3;
    }

    public /* synthetic */ HourWeatherInfo(String r2, Integer r3, String r4, int r5, DefaultConstructorMarker r6) {
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
