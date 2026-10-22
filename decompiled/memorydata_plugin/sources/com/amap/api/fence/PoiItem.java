package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f473b;
    private String c;
    private String d;
    private String e;
    private double f;
    private double g;
    private String h;
    private String i;
    private String j;
    private String k;

    static {
        CREATOR = new AnonymousClass1();
    }

    public PoiItem() {
        this.f472a = "";
        this.f473b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
    }

    public PoiItem(Parcel r4) {
        this.f472a = "";
        this.f473b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.f472a = r4.readString();
        this.f473b = r4.readString();
        this.c = r4.readString();
        this.d = r4.readString();
        this.e = r4.readString();
        this.f = r4.readDouble();
        this.g = r4.readDouble();
        this.h = r4.readString();
        this.i = r4.readString();
        this.j = r4.readString();
        this.k = r4.readString();
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.e;
    }

    public String getAdname() {
        return this.k;
    }

    public String getCity() {
        return this.j;
    }

    public double getLatitude() {
        return this.f;
    }

    public double getLongitude() {
        return this.g;
    }

    public String getPoiId() {
        return this.f473b;
    }

    public String getPoiName() {
        return this.f472a;
    }

    public String getPoiType() {
        return this.c;
    }

    public String getProvince() {
        return this.i;
    }

    public String getTel() {
        return this.h;
    }

    public String getTypeCode() {
        return this.d;
    }

    public void setAddress(String r1) {
        this.e = r1;
    }

    public void setAdname(String r1) {
        this.k = r1;
    }

    public void setCity(String r1) {
        this.j = r1;
    }

    public void setLatitude(double r1) {
        this.f = r1;
    }

    public void setLongitude(double r1) {
        this.g = r1;
    }

    public void setPoiId(String r1) {
        this.f473b = r1;
    }

    public void setPoiName(String r1) {
        this.f472a = r1;
    }

    public void setPoiType(String r1) {
        this.c = r1;
    }

    public void setProvince(String r1) {
        this.i = r1;
    }

    public void setTel(String r1) {
        this.h = r1;
    }

    public void setTypeCode(String r1) {
        this.d = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f472a);
        r3.writeString(this.f473b);
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeDouble(this.f);
        r3.writeDouble(this.g);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j);
        r3.writeString(this.k);
    }
}
