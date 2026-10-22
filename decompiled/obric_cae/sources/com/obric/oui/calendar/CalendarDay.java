package com.obric.oui.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.keva.KevaImpl;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalDate f6210a;

    public class a implements Parcelable.Creator<CalendarDay> {
        @Override // android.os.Parcelable.Creator
        public final CalendarDay createFromParcel(Parcel r8) {
            return new CalendarDay(r8.readInt(), r8.readInt(), r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarDay[] newArray(int r8) {
            return new CalendarDay[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public CalendarDay(int r8, int r10, int r11) {
        this.f6210a = LocalDate.of(r8, r10, r11);
    }

    public static CalendarDay A() {
        return t(LocalDate.now());
    }

    public static CalendarDay t(LocalDate r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r8);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof CalendarDay) == false) goto L7;
        LocalDate r10 = ((CalendarDay) r8).f6210a;
        if (this.f6210a.equals(r10) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        LocalDate r8 = this.f6210a;
        int r10 = r8.getYear();
        int r11 = r8.getMonthValue();
        int r12 = r8.getDayOfMonth();
        int r13 = r11 * 100;
        return (r13 + (r10 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD)) + r12;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("CalendarDay{");
        LocalDate r10 = this.f6210a;
        r8.append(r10.getYear());
        r8.append("-");
        r8.append(r10.getMonthValue());
        r8.append("-");
        return android.aimedia.a.h(r8, r10.getDayOfMonth(), "}");
    }

    public final LocalDate u() {
        return this.f6210a;
    }

    public final int v() {
        return this.f6210a.getDayOfMonth();
    }

    public final int w() {
        return this.f6210a.getMonthValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        LocalDate r11 = this.f6210a;
        r8.writeInt(r11.getYear());
        r8.writeInt(r11.getMonthValue());
        r8.writeInt(r11.getDayOfMonth());
    }

    public final int x() {
        return this.f6210a.getYear();
    }

    public final boolean y(CalendarDay r8) {
        LocalDate r10 = r8.f6210a;
        return this.f6210a.isAfter(r10);
    }

    public final boolean z(CalendarDay r8) {
        LocalDate r10 = r8.f6210a;
        return this.f6210a.isBefore(r10);
    }

    public CalendarDay(LocalDate r8) {
        this.f6210a = r8;
    }
}
