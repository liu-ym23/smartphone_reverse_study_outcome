package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f3677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f3678b;

    public static class a implements Parcelable.Creator<DPoint> {
        @Override // android.os.Parcelable.Creator
        public final DPoint createFromParcel(Parcel r8) {
            return new DPoint(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final DPoint[] newArray(int r8) {
            return new DPoint[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public DPoint() {
        this.f3677a = 0.0d;
        this.f3678b = 0.0d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof DPoint) == true) goto L5;
        return false;
    L5:
        DPoint r10 = (DPoint) r8;
        if (this.f3678b == r10.f3678b) goto L9;
        return false;
    L9:
        if (this.f3677a == r10.f3677a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Double.valueOf((this.f3678b + this.f3677a) * 1000000.0d).intValue();
    }

    public final void t(double r8) {
        if (r8 <= 90.0d) goto L6;
        r8 = 90.0d;
    L6:
        if (r8 >= (-90.0d)) goto L8;
        r8 = -90.0d;
    L8:
        this.f3678b = r8;
    }

    public final void u(double r8) {
        if (r8 <= 180.0d) goto L6;
        r8 = 180.0d;
    L6:
        if (r8 >= (-180.0d)) goto L8;
        r8 = -180.0d;
    L8:
        this.f3677a = r8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeDouble(this.f3677a);
        r8.writeDouble(this.f3678b);
    }

    public DPoint(double r8, double r10) {
        this.f3677a = 0.0d;
        this.f3678b = 0.0d;
        if (r10 <= 180.0d) goto L6;
        r10 = 180.0d;
    L6:
        if (r10 >= (-180.0d)) goto L9;
        r10 = -180.0d;
    L9:
        if (r8 <= 90.0d) goto L12;
        r8 = 90.0d;
    L12:
        if (r8 >= (-90.0d)) goto L14;
        r8 = -90.0d;
    L14:
        this.f3677a = r10;
        this.f3678b = r8;
    }

    public DPoint(Parcel r8) {
        this.f3677a = 0.0d;
        this.f3678b = 0.0d;
        this.f3677a = r8.readDouble();
        this.f3678b = r8.readDouble();
    }
}
