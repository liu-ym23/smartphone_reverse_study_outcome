package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QtiSimType implements Parcelable {
    public static final Parcelable.Creator<QtiSimType> CREATOR = null;
    public static final int SIM_TYPE_ESIM = 1;
    public static final int SIM_TYPE_ESIM_IUICC = 5;
    public static final int SIM_TYPE_INVALID = -1;
    public static final int SIM_TYPE_IUICC = 2;
    public static final int SIM_TYPE_PHYSICAL = 0;
    public static final int SIM_TYPE_PHYSICAL_ESIM = 3;
    public static final int SIM_TYPE_PHYSICAL_ESIM_IUICC = 6;
    public static final int SIM_TYPE_PHYSICAL_IUICC = 4;
    private static final String TAG = "QtiSimType";
    private int mType;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QtiSimType(int r8) {
        this.mType = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mType;
    }

    public String toString() {
        return "QtiSimType: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mType);
    }

    public QtiSimType(Parcel r8) {
        this.mType = r8.readInt();
    }
}
