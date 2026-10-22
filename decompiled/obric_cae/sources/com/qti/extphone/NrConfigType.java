package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NrConfigType implements Parcelable {
    public static final Parcelable.Creator<NrConfigType> CREATOR = null;
    public static final int INVALID = -1;
    public static final int NSA_CONFIGURATION = 0;
    public static final int SA_CONFIGURATION = 1;
    private static final String TAG = "NrConfigType";
    private int mValue;

    static {
        CREATOR = new AnonymousClass1();
    }

    public NrConfigType(int r8) {
        this.mValue = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getNrConfigType() {
        return this.mValue;
    }

    public void readFromParcel(Parcel r8) {
        this.mValue = r8.readInt();
    }

    public String toString() {
        return "NrConfigType: " + getNrConfigType();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mValue);
    }

    public NrConfigType(Parcel r8) {
        this.mValue = r8.readInt();
    }
}
