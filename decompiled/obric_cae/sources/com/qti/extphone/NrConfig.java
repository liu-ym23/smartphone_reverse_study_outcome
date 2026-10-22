package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NrConfig implements Parcelable {
    public static final Parcelable.Creator<NrConfig> CREATOR = null;
    public static final int NR_CONFIG_COMBINED_SA_NSA = 0;
    public static final int NR_CONFIG_INVALID = -1;
    public static final int NR_CONFIG_NSA = 1;
    public static final int NR_CONFIG_SA = 2;
    private static final String TAG = "NrConfig";
    private int mValue;

    static {
        CREATOR = new AnonymousClass1();
    }

    public NrConfig(int r8) {
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
        return "NrConfig: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mValue);
    }

    public NrConfig(Parcel r8) {
        this.mValue = r8.readInt();
    }
}
