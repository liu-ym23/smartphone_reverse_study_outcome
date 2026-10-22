package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final d ALL_OPERATOR = null;
    private static final d ANY_OPERATOR = null;
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = null;

    @NonNull
    private final d operator;

    @NonNull
    private final List<CalendarConstraints.DateValidator> validators;

    class a implements d {
        a() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> r10, long r11) {
            Iterator<CalendarConstraints.DateValidator> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            CalendarConstraints.DateValidator r13 = r12.next();
            if (r13 == null) goto L4;
            if (r13.isValid(r11) == false) goto L4;
            return true;
        L12:
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    class b implements d {
        b() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> r10, long r11) {
            Iterator<CalendarConstraints.DateValidator> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            CalendarConstraints.DateValidator r13 = r12.next();
            if (r13 == null) goto L4;
            if (r13.isValid(r11) == true) goto L4;
            return false;
        L12:
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    class c implements Parcelable.Creator<CompositeDateValidator> {
        c() {
        }

        @NonNull
        public CompositeDateValidator a(@NonNull Parcel r10) {
            ArrayList r11 = r10.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int r12 = r10.readInt();
            if (r12 != 2) goto L6;
        L4:
            d r13 = CompositeDateValidator.access$000();
        L9:
            return new CompositeDateValidator((List) Preconditions.checkNotNull(r11), r13, null);
        L6:
            if (r12 != 1) goto L4;
            r13 = CompositeDateValidator.access$100();
            goto L9
        }

        @NonNull
        public CompositeDateValidator[] b(int r10) {
            return new CompositeDateValidator[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ CompositeDateValidator createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ CompositeDateValidator[] newArray(int r10) {
            return b(r10);
        }
    }

    private interface d {
        boolean a(@NonNull List<CalendarConstraints.DateValidator> r10, long r11);

        int getId();
    }

    static {
        ANY_OPERATOR = new a();
        ALL_OPERATOR = new b();
        CREATOR = new c();
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> r10, d r11) {
        this.validators = r10;
        this.operator = r11;
    }

    /* synthetic */ CompositeDateValidator(List r10, d r11, a r12) {
        this(r10, r11);
    }

    static /* synthetic */ d access$000() {
        return ALL_OPERATOR;
    }

    static /* synthetic */ d access$100() {
        return ANY_OPERATOR;
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> r10) {
        return new CompositeDateValidator(r10, ALL_OPERATOR);
    }

    @NonNull
    public static CalendarConstraints.DateValidator anyOf(@NonNull List<CalendarConstraints.DateValidator> r10) {
        return new CompositeDateValidator(r10, ANY_OPERATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CompositeDateValidator) == true) goto L8;
        return false;
    L8:
        CompositeDateValidator r11 = (CompositeDateValidator) r10;
        if (this.validators.equals(r11.validators) == false) goto L14;
        if (this.operator.getId() != r11.operator.getId()) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r10) {
        return this.operator.a(this.validators, r10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeList(this.validators);
        r10.writeInt(this.operator.getId());
    }
}
