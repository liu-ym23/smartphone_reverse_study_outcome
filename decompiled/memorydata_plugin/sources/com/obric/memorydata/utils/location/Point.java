package com.obric.memorydata.utils.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class Point implements Parcelable {
    public static final Parcelable.Creator<Point> CREATOR = null;
    private double latitude;
    private double longitude;

    static {
        CREATOR = new AnonymousClass1();
    }

    public Point(double r1, double r3) {
        this.latitude = r1;
        this.longitude = r3;
    }

    public Point(Parcel r3) {
        this.latitude = r3.readDouble();
        this.longitude = r3.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double r1) {
        this.latitude = r1;
    }

    public void setLongitude(double r1) {
        this.longitude = r1;
    }

    public String toString() {
        return "(" + this.latitude + ", " + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeDouble(this.latitude);
        r3.writeDouble(this.longitude);
    }
}
