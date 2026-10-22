package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NrIconType implements Parcelable {
    public static final Parcelable.Creator<NrIconType> CREATOR = null;
    public static final int INVALID = -1;
    private static final String TAG = "NrIconType";
    public static final int TYPE_5G_BASIC = 1;
    public static final int TYPE_5G_PLUS_PLUS = 3;
    public static final int TYPE_5G_UWB = 2;
    public static final int TYPE_NONE = 0;
    private int mValue;

    static {
        CREATOR = new AnonymousClass1();
    }

    public NrIconType(int r8) {
        this.mValue = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void readFromParcel(Parcel r8) {
        this.mValue = r8.readInt();
    }

    public String toString() {
        return "NrIconType: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mValue);
    }

    public NrIconType(Parcel r8) {
        this.mValue = r8.readInt();
    }
}
