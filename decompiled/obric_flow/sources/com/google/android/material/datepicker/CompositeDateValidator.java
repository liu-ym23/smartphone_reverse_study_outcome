package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final Operator ALL_OPERATOR = null;
    private static final Operator ANY_OPERATOR = null;
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = null;

    @NonNull
    private final Operator operator;

    @NonNull
    private final List<CalendarConstraints.DateValidator> validators;

    public interface Operator {
        int getId();

        boolean isValid(@NonNull List<CalendarConstraints.DateValidator> r5, long r10);
    }

    static {
        ANY_OPERATOR = new AnonymousClass1();
        ALL_OPERATOR = new AnonymousClass2();
        CREATOR = new AnonymousClass3();
    }

    public /* synthetic */ CompositeDateValidator(List r5, Operator r10, AnonymousClass1 r11) {
        this(r5, r10);
    }

    public static /* synthetic */ Operator access$000() {
        return ALL_OPERATOR;
    }

    public static /* synthetic */ Operator access$100() {
        return ANY_OPERATOR;
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> r5) {
        return new CompositeDateValidator(r5, ALL_OPERATOR);
    }

    @NonNull
    public static CalendarConstraints.DateValidator anyOf(@NonNull List<CalendarConstraints.DateValidator> r5) {
        return new CompositeDateValidator(r5, ANY_OPERATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CompositeDateValidator) == true) goto L8;
        return false;
    L8:
        CompositeDateValidator r10 = (CompositeDateValidator) r5;
        if (this.validators.equals(r10.validators) == false) goto L14;
        if (this.operator.getId() != r10.operator.getId()) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r5) {
        return this.operator.isValid(this.validators, r5);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        r5.writeList(this.validators);
        r5.writeInt(this.operator.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> r5, Operator r10) {
        this.validators = r5;
        this.operator = r10;
    }
}
