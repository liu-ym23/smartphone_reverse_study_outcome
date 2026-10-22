package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SignalStrength implements Parcelable {
    public static final Parcelable.Creator<SignalStrength> CREATOR = null;
    public static final int INVALID = -32768;
    private static final int MAX_NR_RSRP = -44;
    private static final int MAX_NR_SNR = -160;
    private static final int MIN_NR_RSRP = -140;
    private static final int MIN_NR_SNR = -240;
    private static final String TAG = "SignalStrength";
    private int mNrRsrp;
    private int mNrSnr;

    static {
        CREATOR = new AnonymousClass1();
    }

    public SignalStrength() {
        this.mNrRsrp = -32768;
        this.mNrSnr = -32768;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRsrp() {
        return this.mNrRsrp;
    }

    public int getSnr() {
        return this.mNrSnr;
    }

    public void readFromParcel(Parcel r8) {
        this.mNrRsrp = r8.readInt();
        this.mNrSnr = r8.readInt();
    }

    public String toString() {
        return "SignalStrength: Rsrp: " + getRsrp() + " Snr: " + getSnr();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mNrRsrp);
        r8.writeInt(this.mNrSnr);
    }

    public SignalStrength(int r8, int r10) {
        this.mNrRsrp = r8;
        this.mNrSnr = r10;
    }

    public SignalStrength(Parcel r8) {
        this.mNrRsrp = r8.readInt();
        this.mNrSnr = r8.readInt();
    }
}
