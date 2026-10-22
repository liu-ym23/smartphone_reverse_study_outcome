package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f4599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Month f4600b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DateValidator f4601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Month f4602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f4603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f4604p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f4605q;

    public interface DateValidator extends Parcelable {
        boolean c(long r8);
    }

    public class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints createFromParcel(Parcel r8) {
            Month r10 = (Month) r8.readParcelable(Month.class.getClassLoader());
            Month r11 = (Month) r8.readParcelable(Month.class.getClassLoader());
            Month r12 = (Month) r8.readParcelable(Month.class.getClassLoader());
            return new CalendarConstraints(r10, r11, (DateValidator) r8.readParcelable(DateValidator.class.getClassLoader()), r12, r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints[] newArray(int r8) {
            return new CalendarConstraints[r8];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f4606f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final long f4607g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f4608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f4609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f4610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final DateValidator f4612e;

        static {
            f4606f = g0.a(Month.t(1900, 0).f4626p);
            f4607g = g0.a(Month.t(2100, 11).f4626p);
        }

        public b(CalendarConstraints r8) {
            this.f4608a = f4606f;
            this.f4609b = f4607g;
            this.f4612e = new DateValidatorPointForward(Long.MIN_VALUE);
            this.f4608a = r8.f4599a.f4626p;
            this.f4609b = r8.f4600b.f4626p;
            this.f4610c = Long.valueOf(r8.f4602n.f4626p);
            this.f4611d = r8.f4603o;
            this.f4612e = r8.f4601m;
        }
    }

    static {
        CREATOR = new a();
    }

    public CalendarConstraints(Month r8, Month r10, DateValidator r11, Month r12, int r13) {
        Objects.requireNonNull(r8, "start cannot be null");
        Objects.requireNonNull(r10, "end cannot be null");
        Objects.requireNonNull(r11, "validator cannot be null");
        this.f4599a = r8;
        this.f4600b = r10;
        this.f4602n = r12;
        this.f4603o = r13;
        this.f4601m = r11;
        Calendar r14 = r8.f4621a;
        if (r12 != null) goto L5;
    L9:
        if (r12 != null) goto L11;
    L15:
        if (r13 < 0) goto L25;
        if (r13 > g0.g(null).getMaximum(7)) goto L25;
        if ((r14 instanceof GregorianCalendar) == false) goto L23;
        int r15 = r10.f4623m;
        int r16 = r8.f4623m;
        int r17 = r10.f4622b - r8.f4622b;
        this.f4605q = (r17 + ((r15 - r16) * 12)) + 1;
        this.f4604p = (r15 - r16) + 1;
        return;
    L23:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    L25:
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    L11:
        if (r12.f4621a.compareTo(r10.f4621a) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r14.compareTo(r12.f4621a) <= 0) goto L9;
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CalendarConstraints) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r10 = (CalendarConstraints) r8;
        Month r11 = r10.f4599a;
        if (this.f4599a.equals(r11) == false) goto L20;
        if (this.f4600b.equals(r10.f4600b) == false) goto L20;
        if (i0.b.a(this.f4602n, r10.f4602n) == false) goto L20;
        if (this.f4603o != r10.f4603o) goto L20;
        if (this.f4601m.equals(r10.f4601m) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r8 = Integer.valueOf(this.f4603o);
        DateValidator r10 = this.f4601m;
        return Arrays.hashCode(new Object[]{this.f4599a, this.f4600b, this.f4602n, r8, r10});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.f4599a, 0);
        r8.writeParcelable(this.f4600b, 0);
        r8.writeParcelable(this.f4602n, 0);
        r8.writeParcelable(this.f4601m, 0);
        r8.writeInt(this.f4603o);
    }
}
