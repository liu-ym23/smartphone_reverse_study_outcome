package com.obric.oui.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.writer.DaoWriter;
import com.bytedance.keva.KevaImpl;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalDate f12167a;

    static {
        CREATOR = new a5.b(17);
    }

    public CalendarDay(int r5, int r10, int r11) {
        this.f12167a = LocalDate.of(r5, r10, r11);
    }

    public static CalendarDay c(LocalDate r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r5);
    }

    public static CalendarDay d() {
        return c(LocalDate.now());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof CalendarDay) == false) goto L7;
        LocalDate r10 = ((CalendarDay) r5).f12167a;
        if (this.f12167a.equals(r10) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        LocalDate r5 = this.f12167a;
        int r10 = r5.getYear();
        int r11 = r5.getMonthValue();
        int r12 = r5.getDayOfMonth();
        int r13 = r11 * 100;
        return (r13 + (r10 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD)) + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CalendarDay{");
        LocalDate r10 = this.f12167a;
        r5.append(r10.getYear());
        r5.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r5.append(r10.getMonthValue());
        r5.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r5.append(r10.getDayOfMonth());
        r5.append("}");
        return r5.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        LocalDate r11 = this.f12167a;
        r5.writeInt(r11.getYear());
        r5.writeInt(r11.getMonthValue());
        r5.writeInt(r11.getDayOfMonth());
    }

    public CalendarDay(LocalDate r5) {
        this.f12167a = r5;
    }
}
