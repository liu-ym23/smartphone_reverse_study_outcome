package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = null;
    private final long point;

    class a implements Parcelable.Creator<DateValidatorPointBackward> {
        a() {
        }

        @NonNull
        public DateValidatorPointBackward a(@NonNull Parcel r10) {
            return new DateValidatorPointBackward(r10.readLong(), null);
        }

        @NonNull
        public DateValidatorPointBackward[] b(int r10) {
            return new DateValidatorPointBackward[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ DateValidatorPointBackward createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ DateValidatorPointBackward[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    private DateValidatorPointBackward(long r10) {
        this.point = r10;
    }

    /* synthetic */ DateValidatorPointBackward(long r10, a r11) {
        this(r10);
    }

    @NonNull
    public static DateValidatorPointBackward before(long r10) {
        return new DateValidatorPointBackward(r10);
    }

    @NonNull
    public static DateValidatorPointBackward now() {
        return before(j.o().getTimeInMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof DateValidatorPointBackward) == true) goto L9;
        return false;
    L9:
        if (this.point != ((DateValidatorPointBackward) r10).point) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r10) {
        if (r10 > this.point) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeLong(this.point);
    }
}
