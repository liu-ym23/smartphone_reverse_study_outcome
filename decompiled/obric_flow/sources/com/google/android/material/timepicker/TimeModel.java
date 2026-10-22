package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = null;
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    final int format;
    int hour;
    private final MaxInputValidator hourInputValidator;
    int minute;
    private final MaxInputValidator minuteInputValidator;
    int period;
    int selection;

    static {
        CREATOR = new AnonymousClass1();
    }

    public TimeModel() {
        this(0);
    }

    @Nullable
    public static String formatText(Resources r5, CharSequence r10) {
        return formatText(r5, r10, ZERO_LEADING_NUMBER_FORMAT);
    }

    private static int getPeriod(int r5) {
        if (r5 < 12) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimeModel) == true) goto L8;
        return false;
    L8:
        TimeModel r10 = (TimeModel) r5;
        if (this.hour != r10.hour) goto L18;
        if (this.minute != r10.minute) goto L18;
        if (this.format != r10.format) goto L18;
        if (this.selection != r10.selection) goto L18;
        return true;
    L18:
        return false;
    }

    @StringRes
    public int getHourContentDescriptionResId() {
        if (this.format != 1) goto L6;
        return R.string.material_hour_24h_suffix;
    L6:
        return R.string.material_hour_suffix;
    }

    public int getHourForDisplay() {
        if (this.format == 1) goto L5;
        int r5 = this.hour;
        if ((r5 % 12) != 0) goto L10;
        return 12;
    L10:
        if (this.period == 1) goto L12;
        return r5;
    L12:
        return r5 - 12;
    L5:
        return this.hour % 24;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public void setHour(int r5) {
        if (this.format != 1) goto L6;
        this.hour = r5;
        return;
    L6:
        int r10 = 12;
        int r11 = r5 % 12;
        if (this.period == 1) goto L10;
        r10 = 0;
    L10:
        this.hour = r11 + r10;
    }

    public void setHourOfDay(int r5) {
        this.period = getPeriod(r5);
        this.hour = r5;
    }

    public void setMinute(@IntRange(from = 0, to = 59) int r5) {
        this.minute = r5 % 60;
    }

    public void setPeriod(int r5) {
        if (r5 == this.period) goto L13;
        this.period = r5;
        int r10 = this.hour;
        if (r10 < 12) goto L7;
    L9:
        if (r10 < 12) goto L15;
        if (r5 != 0) goto L16;
        this.hour = r10 - 12;
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r5 != 1) goto L9;
        this.hour = r10 + 12;
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.hour);
        r5.writeInt(this.minute);
        r5.writeInt(this.selection);
        r5.writeInt(this.format);
    }

    public TimeModel(int r5) {
        this(0, 0, 10, r5);
    }

    @Nullable
    public static String formatText(Resources r5, CharSequence r10, String r11) {
        return String.format(r5.getConfiguration().locale, r11, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(r10)))});
    L4:
        return null;
    }

    public TimeModel(int r5, int r10, int r11, int r12) {
        this.hour = r5;
        this.minute = r10;
        this.selection = r11;
        this.format = r12;
        this.period = getPeriod(r5);
        this.minuteInputValidator = new MaxInputValidator(59);
        if (r12 != 1) goto L5;
        int r13 = 23;
    L6:
        this.hourInputValidator = new MaxInputValidator(r13);
        return;
    L5:
        r13 = 12;
        goto L6
    }

    public TimeModel(Parcel r5) {
        this(r5.readInt(), r5.readInt(), r5.readInt(), r5.readInt());
    }
}
