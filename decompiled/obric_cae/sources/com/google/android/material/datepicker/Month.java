package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f4621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4622b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f4624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f4625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f4626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4627q;

    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        public final Month createFromParcel(Parcel r8) {
            return Month.t(r8.readInt(), r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Month[] newArray(int r8) {
            return new Month[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public Month(Calendar r8) {
        r8.set(5, 1);
        Calendar r10 = g0.c(r8);
        this.f4621a = r10;
        this.f4622b = r10.get(2);
        this.f4623m = r10.get(1);
        this.f4624n = r10.getMaximum(7);
        this.f4625o = r10.getActualMaximum(5);
        this.f4626p = r10.getTimeInMillis();
    }

    public static Month t(int r8, int r10) {
        Calendar r11 = g0.g(null);
        r11.set(1, r8);
        r11.set(2, r10);
        return new Month(r11);
    }

    public static Month u(long r8) {
        Calendar r10 = g0.g(null);
        r10.setTimeInMillis(r8);
        return new Month(r10);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month r8) {
        return this.f4621a.compareTo(r8.f4621a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Month) == true) goto L8;
        return false;
    L8:
        Month r10 = (Month) r8;
        int r11 = r10.f4622b;
        if (this.f4622b != r11) goto L14;
        if (this.f4623m != r10.f4623m) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4622b), Integer.valueOf(this.f4623m)});
    }

    public final String v() {
        if (this.f4627q != null) goto L6;
        long r8 = this.f4621a.getTimeInMillis();
        this.f4627q = g0.b("yMMMM", Locale.getDefault()).format(new Date(r8));
    L6:
        return this.f4627q;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f4623m);
        r8.writeInt(this.f4622b);
    }
}
