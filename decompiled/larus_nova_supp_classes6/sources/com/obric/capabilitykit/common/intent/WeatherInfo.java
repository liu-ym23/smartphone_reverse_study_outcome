package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJÚ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\t\u0010A\u001a\u00020\bHÖ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\bHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\u0019\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\bHÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b.\u0010\u001a¨\u0006M"}, d2 = {"Lcom/obric/capabilitykit/common/intent/WeatherInfo;", "Landroid/os/Parcelable;", "timezone", "", "location", "windDirection", "", "windSpeed", "", "uvLevel", "humidity", "aqi", "temp", "feelTemp", "lowTemp", "highTemp", "weatherCode", "hourlyWeather", "", "Lcom/obric/capabilitykit/common/intent/HourWeatherInfo;", "dailyWeather", "Lcom/obric/capabilitykit/common/intent/DayWeatherInfo;", "minuteRainDesc", "minuteRainShortDesc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAqi", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDailyWeather", "()Ljava/util/List;", "getFeelTemp", "getHighTemp", "getHourlyWeather", "getHumidity", "getLocation", "()Ljava/lang/String;", "getLowTemp", "getMinuteRainDesc", "getMinuteRainShortDesc", "getTemp", "getTimezone", "getUvLevel", "getWeatherCode", "getWindDirection", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getWindSpeed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/WeatherInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WeatherInfo implements Parcelable {
    public static final Parcelable.Creator<WeatherInfo> CREATOR = null;
    private final Integer aqi;
    private final List<DayWeatherInfo> dailyWeather;
    private final Integer feelTemp;
    private final Integer highTemp;
    private final List<HourWeatherInfo> hourlyWeather;
    private final Integer humidity;
    private final String location;
    private final Integer lowTemp;
    private final String minuteRainDesc;
    private final String minuteRainShortDesc;
    private final Integer temp;
    private final String timezone;
    private final String uvLevel;
    private final String weatherCode;
    private final Double windDirection;
    private final Integer windSpeed;

    static {
        CREATOR = new a();
    }

    public WeatherInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WeatherInfo copy$default(WeatherInfo r17, String r18, String r19, Double r20, Integer r21, String r22, Integer r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, String r29, List r30, List r31, String r32, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.timezone;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.location;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Double r4 = r17.windDirection;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Integer r5 = r17.windSpeed;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = r17.uvLevel;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Integer r7 = r17.humidity;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Integer r8 = r17.aqi;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Integer r9 = r17.temp;
    L35:
        if ((r34 & ISmModel.VERSION_0100) == 0) goto L37;
        Integer r10 = r17.feelTemp;
    L39:
        if ((r34 & ISmModel.VERSION_0200) == 0) goto L41;
        Integer r11 = r17.lowTemp;
    L43:
        if ((r34 & ISmModel.VERSION_0400) == 0) goto L45;
        Integer r12 = r17.highTemp;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = r17.weatherCode;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        List r14 = r17.hourlyWeather;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        List r15 = r17.dailyWeather;
    L58:
        List r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        String r16 = r17.minuteRainDesc;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = r17.minuteRainShortDesc;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.timezone;
    }

    public final Integer component10() {
        return this.lowTemp;
    }

    public final Integer component11() {
        return this.highTemp;
    }

    public final String component12() {
        return this.weatherCode;
    }

    public final List<HourWeatherInfo> component13() {
        return this.hourlyWeather;
    }

    public final List<DayWeatherInfo> component14() {
        return this.dailyWeather;
    }

    public final String component15() {
        return this.minuteRainDesc;
    }

    public final String component16() {
        return this.minuteRainShortDesc;
    }

    public final String component2() {
        return this.location;
    }

    public final Double component3() {
        return this.windDirection;
    }

    public final Integer component4() {
        return this.windSpeed;
    }

    public final String component5() {
        return this.uvLevel;
    }

    public final Integer component6() {
        return this.humidity;
    }

    public final Integer component7() {
        return this.aqi;
    }

    public final Integer component8() {
        return this.temp;
    }

    public final Integer component9() {
        return this.feelTemp;
    }

    public final WeatherInfo copy(String r19, String r20, Double r21, Integer r22, String r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, Integer r29, String r30, List<HourWeatherInfo> r31, List<DayWeatherInfo> r32, String r33, String r34) {
        return new WeatherInfo(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WeatherInfo) == true) goto L8;
        return false;
    L8:
        WeatherInfo r6 = (WeatherInfo) r5;
        if (Intrinsics.areEqual(this.timezone, r6.timezone) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.location, r6.location) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.windDirection, r6.windDirection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.windSpeed, r6.windSpeed) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uvLevel, r6.uvLevel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.humidity, r6.humidity) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.aqi, r6.aqi) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.temp, r6.temp) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.feelTemp, r6.feelTemp) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lowTemp, r6.lowTemp) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.highTemp, r6.highTemp) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.weatherCode, r6.weatherCode) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hourlyWeather, r6.hourlyWeather) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.dailyWeather, r6.dailyWeather) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.minuteRainDesc, r6.minuteRainDesc) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.minuteRainShortDesc, r6.minuteRainShortDesc) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r0 = this.timezone;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.location;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.windDirection;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.windSpeed;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.uvLevel;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.humidity;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.aqi;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.temp;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.feelTemp;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.lowTemp;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.highTemp;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.weatherCode;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        List<HourWeatherInfo> r37 = this.hourlyWeather;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<DayWeatherInfo> r40 = this.dailyWeather;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.minuteRainDesc;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.minuteRainShortDesc;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "WeatherInfo(timezone=" + this.timezone + ", location=" + this.location + ", windDirection=" + this.windDirection + ", windSpeed=" + this.windSpeed + ", uvLevel=" + this.uvLevel + ", humidity=" + this.humidity + ", aqi=" + this.aqi + ", temp=" + this.temp + ", feelTemp=" + this.feelTemp + ", lowTemp=" + this.lowTemp + ", highTemp=" + this.highTemp + ", weatherCode=" + this.weatherCode + ", hourlyWeather=" + this.hourlyWeather + ", dailyWeather=" + this.dailyWeather + ", minuteRainDesc=" + this.minuteRainDesc + ", minuteRainShortDesc=" + this.minuteRainShortDesc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(0);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeString(this.timezone);
        r6.writeString(this.location);
        Double r1 = this.windDirection;
        if (r1 != null) goto L5;
        r6.writeInt(0);
    L6:
        Integer r2 = this.windSpeed;
        if (r2 != null) goto L9;
        r6.writeInt(0);
    L10:
        r6.writeString(this.uvLevel);
        Integer r3 = this.humidity;
        if (r3 != null) goto L13;
        r6.writeInt(0);
    L14:
        Integer r4 = this.aqi;
        if (r4 != null) goto L17;
        r6.writeInt(0);
    L18:
        Integer r5 = this.temp;
        if (r5 != null) goto L21;
        r6.writeInt(0);
    L22:
        Integer r8 = this.feelTemp;
        if (r8 != null) goto L25;
        r6.writeInt(0);
    L26:
        Integer r9 = this.lowTemp;
        if (r9 != null) goto L29;
        r6.writeInt(0);
    L30:
        Integer r10 = this.highTemp;
        if (r10 != null) goto L33;
        r6.writeInt(0);
    L34:
        r6.writeString(this.weatherCode);
        List<HourWeatherInfo> r11 = this.hourlyWeather;
        if (r11 != null) goto L37;
        r6.writeInt(0);
    L41:
        List<DayWeatherInfo> r12 = this.dailyWeather;
        if (r12 != null) goto L44;
        r6.writeInt(0);
    L48:
        r6.writeString(this.minuteRainDesc);
        r6.writeString(this.minuteRainShortDesc);
        return;
    L44:
        r6.writeInt(1);
        r6.writeInt(r12.size());
        Iterator<DayWeatherInfo> r0 = r12.iterator();
    L46:
        if (r0.hasNext() == false) goto L48;
        r0.next().writeToParcel(r6, r7);
        goto L46
    L37:
        r6.writeInt(1);
        r6.writeInt(r11.size());
        Iterator<HourWeatherInfo> r13 = r11.iterator();
    L39:
        if (r13.hasNext() == false) goto L41;
        r13.next().writeToParcel(r6, r7);
        goto L39
    L33:
        r6.writeInt(1);
        r6.writeInt(r10.intValue());
        goto L34
    L29:
        r6.writeInt(1);
        r6.writeInt(r9.intValue());
        goto L30
    L25:
        r6.writeInt(1);
        r6.writeInt(r8.intValue());
        goto L26
    L21:
        r6.writeInt(1);
        r6.writeInt(r5.intValue());
        goto L22
    L17:
        r6.writeInt(1);
        r6.writeInt(r4.intValue());
        goto L18
    L13:
        r6.writeInt(1);
        r6.writeInt(r3.intValue());
        goto L14
    L9:
        r6.writeInt(1);
        r6.writeInt(r2.intValue());
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeDouble(r1.doubleValue());
        goto L6
    }

    public final Integer getAqi() {
        return this.aqi;
    }

    public final List<DayWeatherInfo> getDailyWeather() {
        return this.dailyWeather;
    }

    public final Integer getFeelTemp() {
        return this.feelTemp;
    }

    public final Integer getHighTemp() {
        return this.highTemp;
    }

    public final List<HourWeatherInfo> getHourlyWeather() {
        return this.hourlyWeather;
    }

    public final Integer getHumidity() {
        return this.humidity;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Integer getLowTemp() {
        return this.lowTemp;
    }

    public final String getMinuteRainDesc() {
        return this.minuteRainDesc;
    }

    public final String getMinuteRainShortDesc() {
        return this.minuteRainShortDesc;
    }

    public final Integer getTemp() {
        return this.temp;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getUvLevel() {
        return this.uvLevel;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public final Double getWindDirection() {
        return this.windDirection;
    }

    public final Integer getWindSpeed() {
        return this.windSpeed;
    }

    public WeatherInfo(String r3, String r4, Double r5, Integer r6, String r7, Integer r8, Integer r9, Integer r10, Integer r11, Integer r12, Integer r13, String r14, List<HourWeatherInfo> r15, List<DayWeatherInfo> r16, String r17, String r18) {
        this.timezone = r3;
        this.location = r4;
        this.windDirection = r5;
        this.windSpeed = r6;
        this.uvLevel = r7;
        this.humidity = r8;
        this.aqi = r9;
        this.temp = r10;
        this.feelTemp = r11;
        this.lowTemp = r12;
        this.highTemp = r13;
        this.weatherCode = r14;
        this.hourlyWeather = r15;
        this.dailyWeather = r16;
        this.minuteRainDesc = r17;
        this.minuteRainShortDesc = r18;
    }

    public /* synthetic */ WeatherInfo(String r18, String r19, Double r20, Integer r21, String r22, Integer r23, Integer r24, Integer r25, Integer r26, Integer r27, Integer r28, String r29, List r30, List r31, String r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Double r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r34 & ISmModel.VERSION_0100) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r34 & ISmModel.VERSION_0200) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r34 & ISmModel.VERSION_0400) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        List r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        List r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
