package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class DcParam implements Parcelable {
    public static final Parcelable.Creator<DcParam> CREATOR = null;
    public static final int DCNR_RESTRICTED = 0;
    public static final int DCNR_UNRESTRICTED = 1;
    public static final int ENDC_AVAILABLE = 1;
    public static final int ENDC_UNAVAILABLE = 0;
    public static final int INVALID = -1;
    private static final String TAG = "DcParam";
    private int mDcnr;
    private int mEndc;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DcParam(int r8, int r10) {
        this.mEndc = r8;
        this.mDcnr = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDcnr() {
        return this.mDcnr;
    }

    public int getEndc() {
        return this.mEndc;
    }

    public void readFromParcel(Parcel r8) {
        this.mEndc = r8.readInt();
        this.mDcnr = r8.readInt();
    }

    public String toString() {
        return "DcParam: Endc: " + getEndc() + " Dcnr: " + getDcnr();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mEndc);
        r8.writeInt(this.mDcnr);
    }

    public DcParam(Parcel r8) {
        this.mEndc = 0;
        this.mDcnr = 0;
        this.mEndc = r8.readInt();
        this.mDcnr = r8.readInt();
    }
}
