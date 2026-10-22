package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/DayWeatherInfo;", "Landroid/os/Parcelable;", "date", "", "lowTemp", "", "highTemp", "weatherCode", "sunRise", "sunSet", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHighTemp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLowTemp", "getSunRise", "getSunSet", "getWeatherCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/DayWeatherInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DayWeatherInfo implements Parcelable {
    public static final Parcelable.Creator<DayWeatherInfo> CREATOR = null;
    private final String date;
    private final Integer highTemp;
    private final Integer lowTemp;
    private final String sunRise;
    private final String sunSet;
    private final String weatherCode;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DayWeatherInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayWeatherInfo createFromParcel(Parcel r11) {
            int r0 = r11.readInt();
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r3 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Integer r5 = null;
        L7:
            if (r11.readInt() != 0) goto L9;
            Integer r6 = null;
        L10:
            DayWeatherInfo r1 = new DayWeatherInfo(r3, r5, r6, r11.readString(), r11.readString(), r11.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r10 = getClass().getClassLoader();
            int r4 = 1;
        L11:
            if (r4 > r2) goto L13;
            r4 = r4 + 1;
        L13:
            if (r4 > r0) goto L15;
            a.a(r11, r10);
            r4 = r4 + 1;
            goto L13
        L15:
            return r1;
        L9:
            r6 = Integer.valueOf(r11.readInt());
            goto L10
        L5:
            r5 = Integer.valueOf(r11.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayWeatherInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DayWeatherInfo[] newArray(int r1) {
            return new DayWeatherInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DayWeatherInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public DayWeatherInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public DayWeatherInfo(String r1, Integer r2, Integer r3, String r4, String r5, String r6) {
        this.date = r1;
        this.lowTemp = r2;
        this.highTemp = r3;
        this.weatherCode = r4;
        this.sunRise = r5;
        this.sunSet = r6;
    }

    public /* synthetic */ DayWeatherInfo(String r2, Integer r3, Integer r4, String r5, String r6, String r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ DayWeatherInfo copy$default(DayWeatherInfo r4, String r5, Integer r6, Integer r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.date;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.lowTemp;
    L8:
        Integer r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.highTemp;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.weatherCode;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.sunRise;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.sunSet;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.date;
    }

    public final Integer component2() {
        return this.lowTemp;
    }

    public final Integer component3() {
        return this.highTemp;
    }

    public final String component4() {
        return this.weatherCode;
    }

    public final String component5() {
        return this.sunRise;
    }

    public final String component6() {
        return this.sunSet;
    }

    public final DayWeatherInfo copy(String r8, Integer r9, Integer r10, String r11, String r12, String r13) {
        return new DayWeatherInfo(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DayWeatherInfo.class) == true) goto L8;
        return false;
    L8:
        DayWeatherInfo r6 = (DayWeatherInfo) ZeusTransformUtils.preCheckCast(r5, DayWeatherInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lowTemp, r6.lowTemp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.highTemp, r6.highTemp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.weatherCode, r6.weatherCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sunRise, r6.sunRise) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sunSet, r6.sunSet) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getDate() {
        return this.date;
    }

    public final Integer getHighTemp() {
        return this.highTemp;
    }

    public final Integer getLowTemp() {
        return this.lowTemp;
    }

    public final String getSunRise() {
        return this.sunRise;
    }

    public final String getSunSet() {
        return this.sunSet;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public int hashCode() {
        String r0 = this.date;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.lowTemp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.highTemp;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.weatherCode;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sunRise;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.sunSet;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public String toString() {
        return "DayWeatherInfo(date=" + this.date + ", lowTemp=" + this.lowTemp + ", highTemp=" + this.highTemp + ", weatherCode=" + this.weatherCode + ", sunRise=" + this.sunRise + ", sunSet=" + this.sunSet + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        int r5 = 0;
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.date);
        Integer r0 = this.lowTemp;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r1 = this.highTemp;
        if (r1 == null) goto L10;
        r3.writeInt(1);
        r5 = r1.intValue();
    L10:
        r3.writeInt(r5);
        r3.writeString(this.weatherCode);
        r3.writeString(this.sunRise);
        r3.writeString(this.sunSet);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.intValue());
        goto L6
    }
}
