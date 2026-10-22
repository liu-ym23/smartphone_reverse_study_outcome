package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f490b;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DPoint() {
        this.f489a = 0.0d;
        this.f490b = 0.0d;
    }

    public DPoint(double r4, double r6) {
        this.f489a = 0.0d;
        this.f490b = 0.0d;
        if (r6 <= 180.0d) goto L6;
        r6 = 180.0d;
    L6:
        if (r6 >= (-180.0d)) goto L9;
        r6 = -180.0d;
    L9:
        if (r4 <= 90.0d) goto L12;
        r4 = 90.0d;
    L12:
        if (r4 >= (-90.0d)) goto L14;
        r4 = -90.0d;
    L14:
        this.f489a = r6;
        this.f490b = r4;
    }

    public DPoint(Parcel r3) {
        this.f489a = 0.0d;
        this.f490b = 0.0d;
        this.f489a = r3.readDouble();
        this.f490b = r3.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, DPoint.class) == true) goto L5;
        return false;
    L5:
        DPoint r7 = (DPoint) ZeusTransformUtils.preCheckCast(r6, DPoint.class, "com.obric.memorydata.plugin");
        if (this.f490b == r7.f490b) goto L9;
        return false;
    L9:
        if (this.f489a == r7.f489a) goto L11;
        return false;
    L11:
        return true;
    }

    public double getLatitude() {
        return this.f490b;
    }

    public double getLongitude() {
        return this.f489a;
    }

    public int hashCode() {
        return Double.valueOf((this.f490b + this.f489a) * 1000000.0d).intValue();
    }

    public void setLatitude(double r4) {
        if (r4 <= 90.0d) goto L6;
        r4 = 90.0d;
    L6:
        if (r4 >= (-90.0d)) goto L8;
        r4 = -90.0d;
    L8:
        this.f490b = r4;
    }

    public void setLongitude(double r4) {
        if (r4 <= 180.0d) goto L6;
        r4 = 180.0d;
    L6:
        if (r4 >= (-180.0d)) goto L8;
        r4 = -180.0d;
    L8:
        this.f489a = r4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeDouble(this.f489a);
        r3.writeDouble(this.f490b);
    }
}
