package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f4613m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f4614n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CalendarConstraints.DateValidator> f4616b;

    public class a implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final boolean a(long r8, List r10) {
            Iterator r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            CalendarConstraints.DateValidator r12 = (CalendarConstraints.DateValidator) r11.next();
            if (r12 == null) goto L4;
            if (r12.c(r8) == false) goto L4;
            return true;
        L12:
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final int getId() {
            return 1;
        }
    }

    public class b implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final boolean a(long r8, List r10) {
            Iterator r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            CalendarConstraints.DateValidator r12 = (CalendarConstraints.DateValidator) r11.next();
            if (r12 == null) goto L4;
            if (r12.c(r8) == true) goto L4;
            return false;
        L12:
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public final int getId() {
            return 2;
        }
    }

    public class c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        public final CompositeDateValidator createFromParcel(Parcel r8) {
            ArrayList r10 = r8.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int r11 = r8.readInt();
            d r12 = CompositeDateValidator.f4614n;
            if (r11 != 2) goto L6;
        L8:
            r10.getClass();
            return new CompositeDateValidator(r10, r12);
        L6:
            if (r11 != 1) goto L8;
            r12 = CompositeDateValidator.f4613m;
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final CompositeDateValidator[] newArray(int r8) {
            return new CompositeDateValidator[r8];
        }
    }

    public interface d {
        boolean a(long r8, List r10);

        int getId();
    }

    static {
        f4613m = new a();
        f4614n = new b();
        CREATOR = new c();
    }

    public CompositeDateValidator() {
        throw null;
    }

    public CompositeDateValidator(ArrayList r8, d r10) {
        this.f4616b = r8;
        this.f4615a = r10;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean c(long r8) {
        return this.f4615a.a(r8, this.f4616b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CompositeDateValidator) == true) goto L8;
        return false;
    L8:
        CompositeDateValidator r10 = (CompositeDateValidator) r8;
        List<CalendarConstraints.DateValidator> r11 = r10.f4616b;
        if (this.f4616b.equals(r11) == false) goto L14;
        if (this.f4615a.getId() != r10.f4615a.getId()) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return this.f4616b.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeList(this.f4616b);
        r8.writeInt(this.f4615a.getId());
    }
}
