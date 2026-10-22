package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;

    @NonNull
    private final Month end;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long r10);
    }

    class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        @NonNull
        public CalendarConstraints a(@NonNull Parcel r10) {
            Month r11 = (Month) r10.readParcelable(Month.class.getClassLoader());
            Month r12 = (Month) r10.readParcelable(Month.class.getClassLoader());
            Month r13 = (Month) r10.readParcelable(Month.class.getClassLoader());
            return new CalendarConstraints(r11, r12, (DateValidator) r10.readParcelable(DateValidator.class.getClassLoader()), r13, null);
        }

        @NonNull
        public CalendarConstraints[] b(int r10) {
            return new CalendarConstraints[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ CalendarConstraints createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ CalendarConstraints[] newArray(int r10) {
            return b(r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f3160e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f3161f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f3163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f3164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DateValidator f3165d;

        static {
            f3160e = j.a(Month.create(1900, 0).timeInMillis);
            f3161f = j.a(Month.create(2100, 11).timeInMillis);
        }

        b(@NonNull CalendarConstraints r10) {
            this.f3162a = f3160e;
            this.f3163b = f3161f;
            this.f3165d = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.f3162a = CalendarConstraints.access$100(r10).timeInMillis;
            this.f3163b = CalendarConstraints.access$200(r10).timeInMillis;
            this.f3164c = Long.valueOf(CalendarConstraints.access$300(r10).timeInMillis);
            this.f3165d = CalendarConstraints.access$400(r10);
        }

        @NonNull
        public CalendarConstraints a() {
            Bundle r10 = new Bundle();
            r10.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f3165d);
            Month r11 = Month.create(this.f3162a);
            Month r12 = Month.create(this.f3163b);
            DateValidator r13 = (DateValidator) r10.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long r14 = this.f3164c;
            if (r14 != null) goto L5;
            Month r15 = null;
        L7:
            return new CalendarConstraints(r11, r12, r13, r15, null);
        L5:
            r15 = Month.create(r14.longValue());
            goto L7
        }

        @NonNull
        public b b(long r10) {
            this.f3164c = Long.valueOf(r10);
            return this;
        }
    }

    static {
        CREATOR = new a();
    }

    private CalendarConstraints(@NonNull Month r10, @NonNull Month r11, @NonNull DateValidator r12, @Nullable Month r13) {
        this.start = r10;
        this.end = r11;
        this.openAt = r13;
        this.validator = r12;
        if (r13 != null) goto L5;
    L9:
        if (r13 != null) goto L11;
    L15:
        this.monthSpan = r10.monthsUntil(r11) + 1;
        this.yearSpan = (r11.year - r10.year) + 1;
        return;
    L11:
        if (r13.compareTo2(r11) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r10.compareTo2(r13) <= 0) goto L9;
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }

    /* synthetic */ CalendarConstraints(Month r10, Month r11, DateValidator r12, Month r13, a r14) {
        this(r10, r11, r12, r13);
    }

    static /* synthetic */ Month access$100(CalendarConstraints r10) {
        return r10.start;
    }

    static /* synthetic */ Month access$200(CalendarConstraints r10) {
        return r10.end;
    }

    static /* synthetic */ Month access$300(CalendarConstraints r10) {
        return r10.openAt;
    }

    static /* synthetic */ DateValidator access$400(CalendarConstraints r10) {
        return r10.validator;
    }

    Month clamp(Month r10) {
        if (r10.compareTo2(this.start) >= 0) goto L7;
        return this.start;
    L7:
        if (r10.compareTo2(this.end) > 0) goto L9;
        return r10;
    L9:
        return this.end;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CalendarConstraints) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r11 = (CalendarConstraints) r10;
        if (this.start.equals(r11.start) == false) goto L18;
        if (this.end.equals(r11.end) == false) goto L18;
        if (ObjectsCompat.equals(this.openAt, r11.openAt) == false) goto L18;
        if (this.validator.equals(r11.validator) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    Month getEnd() {
        return this.end;
    }

    int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    Month getStart() {
        return this.start;
    }

    int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    boolean isWithinBounds(long r10) {
        if (this.start.getDay(1) > r10) goto L7;
        Month r11 = this.end;
        if (r10 > r11.getDay(r11.daysInMonth)) goto L7;
        return true;
    L7:
        return false;
    }

    void setOpenAt(@Nullable Month r10) {
        this.openAt = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(this.start, 0);
        r10.writeParcelable(this.end, 0);
        r10.writeParcelable(this.openAt, 0);
        r10.writeParcelable(this.validator, 0);
    }
}
