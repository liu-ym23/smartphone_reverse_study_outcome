package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = null;
    final int daysInMonth;
    final int daysInWeek;

    @NonNull
    private final Calendar firstOfMonth;

    @Nullable
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    static {
        CREATOR = new AnonymousClass1();
    }

    private Month(@NonNull Calendar r5) {
        r5.set(5, 1);
        Calendar r10 = UtcDates.getDayCopy(r5);
        this.firstOfMonth = r10;
        this.month = r10.get(2);
        this.year = r10.get(1);
        this.daysInWeek = r10.getMaximum(7);
        this.daysInMonth = r10.getActualMaximum(5);
        this.timeInMillis = r10.getTimeInMillis();
    }

    @NonNull
    public static Month create(long r5) {
        Calendar r10 = UtcDates.getUtcCalendar();
        r10.setTimeInMillis(r5);
        return new Month(r10);
    }

    @NonNull
    public static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Month r5) {
        return compareTo2(r5);
    }

    public int daysFromStartOfWeekToFirstOfMonth(int r5) {
        int r10 = this.firstOfMonth.get(7);
        if (r5 > 0) goto L6;
        r5 = this.firstOfMonth.getFirstDayOfWeek();
    L6:
        int r11 = r10 - r5;
        if (r11 < 0) goto L9;
        return r11;
    L9:
        return r11 + this.daysInWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Month) == true) goto L8;
        return false;
    L8:
        Month r10 = (Month) r5;
        if (this.month != r10.month) goto L14;
        if (this.year != r10.year) goto L14;
        return true;
    L14:
        return false;
    }

    public long getDay(int r5) {
        Calendar r10 = UtcDates.getDayCopy(this.firstOfMonth);
        r10.set(5, r5);
        return r10.getTimeInMillis();
    }

    public int getDayOfMonth(long r5) {
        Calendar r10 = UtcDates.getDayCopy(this.firstOfMonth);
        r10.setTimeInMillis(r5);
        return r10.get(5);
    }

    @NonNull
    public String getLongName() {
        if (this.longName != null) goto L6;
        this.longName = DateStrings.getYearMonth(this.firstOfMonth.getTimeInMillis());
    L6:
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    public Month monthsLater(int r5) {
        Calendar r10 = UtcDates.getDayCopy(this.firstOfMonth);
        r10.add(2, r5);
        return new Month(r10);
    }

    public int monthsUntil(@NonNull Month r5) {
        if ((this.firstOfMonth instanceof GregorianCalendar) == false) goto L7;
        int r10 = (r5.year - this.year) * 12;
        return (r5.month - this.month) + r10;
    L7:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        r5.writeInt(this.year);
        r5.writeInt(this.month);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull Month r5) {
        return this.firstOfMonth.compareTo(r5.firstOfMonth);
    }

    @NonNull
    public static Month create(int r5, int r10) {
        Calendar r11 = UtcDates.getUtcCalendar();
        r11.set(1, r5);
        r11.set(2, r10);
        return new Month(r11);
    }
}
