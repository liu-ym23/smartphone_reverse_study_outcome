package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
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

    class a implements Parcelable.Creator<Month> {
        a() {
        }

        @NonNull
        public Month a(@NonNull Parcel r10) {
            return Month.create(r10.readInt(), r10.readInt());
        }

        @NonNull
        public Month[] b(int r10) {
            return new Month[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ Month createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ Month[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    private Month(@NonNull Calendar r10) {
        r10.set(5, 1);
        Calendar r11 = j.f(r10);
        this.firstOfMonth = r11;
        this.month = r11.get(2);
        this.year = r11.get(1);
        this.daysInWeek = r11.getMaximum(7);
        this.daysInMonth = r11.getActualMaximum(5);
        this.timeInMillis = r11.getTimeInMillis();
    }

    @NonNull
    static Month create(int r10, int r11) {
        Calendar r12 = j.q();
        r12.set(1, r10);
        r12.set(2, r11);
        return new Month(r12);
    }

    @NonNull
    static Month create(long r10) {
        Calendar r11 = j.q();
        r11.setTimeInMillis(r10);
        return new Month(r11);
    }

    @NonNull
    static Month current() {
        return new Month(j.o());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull Month r10) {
        return this.firstOfMonth.compareTo(r10.firstOfMonth);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Month r10) {
        return compareTo2(r10);
    }

    int daysFromStartOfWeekToFirstOfMonth() {
        int r10 = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        if (r10 < 0) goto L5;
        return r10;
    L5:
        return r10 + this.daysInWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Month) == true) goto L8;
        return false;
    L8:
        Month r11 = (Month) r10;
        if (this.month != r11.month) goto L14;
        if (this.year != r11.year) goto L14;
        return true;
    L14:
        return false;
    }

    long getDay(int r10) {
        Calendar r11 = j.f(this.firstOfMonth);
        r11.set(5, r10);
        return r11.getTimeInMillis();
    }

    int getDayOfMonth(long r10) {
        Calendar r11 = j.f(this.firstOfMonth);
        r11.setTimeInMillis(r10);
        return r11.get(5);
    }

    @NonNull
    String getLongName() {
        if (this.longName != null) goto L6;
        this.longName = d.i(this.firstOfMonth.getTimeInMillis());
    L6:
        return this.longName;
    }

    long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    Month monthsLater(int r10) {
        Calendar r11 = j.f(this.firstOfMonth);
        r11.add(2, r10);
        return new Month(r11);
    }

    int monthsUntil(@NonNull Month r10) {
        if ((this.firstOfMonth instanceof GregorianCalendar) == false) goto L7;
        return ((r10.year - this.year) * 12) + (r10.month - this.month);
    L7:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeInt(this.year);
        r10.writeInt(this.month);
    }
}
