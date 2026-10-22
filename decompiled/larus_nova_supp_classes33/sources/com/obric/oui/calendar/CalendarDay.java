package com.obric.oui.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;
    public final LocalDate a;

    public class a implements Parcelable.Creator<CalendarDay> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarDay createFromParcel(Parcel r4) {
            return new CalendarDay(r4.readInt(), r4.readInt(), r4.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarDay[] newArray(int r1) {
            return new CalendarDay[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int b() {
        return this.a.getDayOfMonth();
    }

    public final int c() {
        return this.a.getMonthValue();
    }

    public final int d() {
        return this.a.getYear();
    }

    public final int hashCode() {
        int r0 = this.a.getYear();
        int r1 = this.a.getMonthValue();
        int r2 = (r0 * 10000) + (r1 * 100);
        return r2 + this.a.getDayOfMonth();
    }

    public final String toString() {
        return "CalendarDay{" + this.a.getYear() + "-" + this.a.getMonthValue() + "-" + this.a.getDayOfMonth() + "}";
    }

    public static CalendarDay e() {
        return a(LocalDate.now());
    }

    public CalendarDay(LocalDate r1) {
        this.a = r1;
    }

    public static CalendarDay a(LocalDate r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r1);
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof CalendarDay) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.equals(((CalendarDay) r2).a) == false) goto L7;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a.getYear());
        r1.writeInt(this.a.getMonthValue());
        r1.writeInt(this.a.getDayOfMonth());
    }

    public CalendarDay(int r1, int r2, int r3) {
        this.a = LocalDate.of(r1, r2, r3);
    }
}
