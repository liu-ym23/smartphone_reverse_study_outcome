package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4618a;

    public class a implements Parcelable.Creator<DateValidatorPointForward> {
        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointForward createFromParcel(Parcel r8) {
            return new DateValidatorPointForward(r8.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointForward[] newArray(int r8) {
            return new DateValidatorPointForward[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public DateValidatorPointForward(long r8) {
        this.f4618a = r8;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean c(long r8) {
        if (r8 < this.f4618a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DateValidatorPointForward) == true) goto L9;
        return false;
    L9:
        if (this.f4618a != ((DateValidatorPointForward) r8).f4618a) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4618a)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.f4618a);
    }
}
