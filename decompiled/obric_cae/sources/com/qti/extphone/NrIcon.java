package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NrIcon implements Parcelable {
    public static final Parcelable.Creator<NrIcon> CREATOR = null;
    public static final int INVALID = -1;
    private static final String TAG = "NrIcon";
    private int mRxCount;
    private int mType;

    static {
        CREATOR = new AnonymousClass1();
    }

    public NrIcon(int r8, int r10) {
        this.mType = r8;
        this.mRxCount = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRxCount() {
        return this.mRxCount;
    }

    public int getType() {
        return this.mType;
    }

    public void readFromParcel(Parcel r8) {
        this.mType = r8.readInt();
        this.mRxCount = r8.readInt();
    }

    public String toString() {
        return "NrIcon: type = " + this.mType + ", Rx = " + this.mRxCount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mType);
        r8.writeInt(this.mRxCount);
    }

    public NrIcon(Parcel r8) {
        this.mRxCount = -1;
        this.mType = r8.readInt();
        this.mRxCount = r8.readInt();
    }
}
