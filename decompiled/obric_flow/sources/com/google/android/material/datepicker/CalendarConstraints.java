package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;

    @NonNull
    private final Month end;
    private final int firstDayOfWeek;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = 0;
        static final long DEFAULT_START = 0;
        private long end;
        private int firstDayOfWeek;
        private Long openAt;
        private long start;
        private DateValidator validator;

        static {
            DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
            DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        }

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints build() {
            Bundle r5 = new Bundle();
            r5.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month r10 = Month.create(this.start);
            Month r11 = Month.create(this.end);
            DateValidator r12 = (DateValidator) r5.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long r13 = this.openAt;
            if (r13 != null) goto L6;
            Month r14 = null;
        L5:
            Month r15 = r14;
            return new CalendarConstraints(r10, r11, r12, r15, this.firstDayOfWeek, null);
        L6:
            r14 = Month.create(r13.longValue());
            goto L5
        }

        @NonNull
        public Builder setEnd(long r5) {
            this.end = r5;
            return this;
        }

        @NonNull
        public Builder setFirstDayOfWeek(int r5) {
            this.firstDayOfWeek = r5;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long r5) {
            this.openAt = Long.valueOf(r5);
            return this;
        }

        @NonNull
        public Builder setStart(long r5) {
            this.start = r5;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator r5) {
            Objects.requireNonNull(r5, "validator cannot be null");
            this.validator = r5;
            return this;
        }

        public Builder(@NonNull CalendarConstraints r5) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = CalendarConstraints.access$100(r5).timeInMillis;
            this.end = CalendarConstraints.access$200(r5).timeInMillis;
            this.openAt = Long.valueOf(CalendarConstraints.access$300(r5).timeInMillis);
            this.firstDayOfWeek = CalendarConstraints.access$400(r5);
            this.validator = CalendarConstraints.access$500(r5);
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long r5);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ CalendarConstraints(Month r5, Month r10, DateValidator r11, Month r12, int r13, AnonymousClass1 r14) {
        this(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ Month access$100(CalendarConstraints r5) {
        return r5.start;
    }

    public static /* synthetic */ Month access$200(CalendarConstraints r5) {
        return r5.end;
    }

    public static /* synthetic */ Month access$300(CalendarConstraints r5) {
        return r5.openAt;
    }

    public static /* synthetic */ int access$400(CalendarConstraints r5) {
        return r5.firstDayOfWeek;
    }

    public static /* synthetic */ DateValidator access$500(CalendarConstraints r5) {
        return r5.validator;
    }

    public Month clamp(Month r5) {
        if (r5.compareTo2(this.start) >= 0) goto L7;
        return this.start;
    L7:
        if (r5.compareTo2(this.end) > 0) goto L9;
        return r5;
    L9:
        return this.end;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CalendarConstraints) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r10 = (CalendarConstraints) r5;
        if (this.start.equals(r10.start) == false) goto L20;
        if (this.end.equals(r10.end) == false) goto L20;
        if (ObjectsCompat.equals(this.openAt, r10.openAt) == false) goto L20;
        if (this.firstDayOfWeek != r10.firstDayOfWeek) goto L20;
        if (this.validator.equals(r10.validator) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public long getEndMs() {
        return this.end.timeInMillis;
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @Nullable
    public Long getOpenAtMs() {
        Month r5 = this.openAt;
        if (r5 != null) goto L6;
        return null;
    L6:
        return Long.valueOf(r5.timeInMillis);
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public long getStartMs() {
        return this.start.timeInMillis;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    public boolean isWithinBounds(long r5) {
        if (this.start.getDay(1) > r5) goto L7;
        Month r10 = this.end;
        if (r5 > r10.getDay(r10.daysInMonth)) goto L7;
        return true;
    L7:
        return false;
    }

    public void setOpenAt(@Nullable Month r5) {
        this.openAt = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        r5.writeParcelable(this.start, 0);
        r5.writeParcelable(this.end, 0);
        r5.writeParcelable(this.openAt, 0);
        r5.writeParcelable(this.validator, 0);
        r5.writeInt(this.firstDayOfWeek);
    }

    private CalendarConstraints(@NonNull Month r5, @NonNull Month r10, @NonNull DateValidator r11, @Nullable Month r12, int r13) {
        Objects.requireNonNull(r5, "start cannot be null");
        Objects.requireNonNull(r10, "end cannot be null");
        Objects.requireNonNull(r11, "validator cannot be null");
        this.start = r5;
        this.end = r10;
        this.openAt = r12;
        this.firstDayOfWeek = r13;
        this.validator = r11;
        if (r12 != null) goto L5;
    L9:
        if (r12 != null) goto L11;
    L15:
        if (r13 < 0) goto L21;
        if (r13 > UtcDates.getUtcCalendar().getMaximum(7)) goto L21;
        this.monthSpan = r5.monthsUntil(r10) + 1;
        this.yearSpan = (r10.year - r5.year) + 1;
        return;
    L21:
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    L11:
        if (r12.compareTo2(r10) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r5.compareTo2(r12) <= 0) goto L9;
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }
}
