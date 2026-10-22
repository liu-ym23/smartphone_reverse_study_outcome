package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QRadioResponseInfo implements Parcelable {
    public static final Parcelable.Creator<QRadioResponseInfo> CREATOR = null;
    public static final int GENERIC_FAILURE = 2;
    public static final int NONE = 0;
    public static final int RADIO_NOT_AVAILABLE = 1;
    public static final int SOLICITED = 0;
    public static final int SOLICITED_ACK = 1;
    public static final int SOLICITED_ACK_EXP = 2;
    private static final String TAG = "QRadioResponseInfo";
    private int mError;
    private int mResponseType;
    private int mSerial;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QRadioResponseInfo(int r8, int r10, int r11) {
        this.mResponseType = r8;
        this.mSerial = r10;
        this.mError = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getError() {
        return this.mError;
    }

    public int getResponseType() {
        return this.mResponseType;
    }

    public int getSerial() {
        return this.mSerial;
    }

    public void readFromParcel(Parcel r8) {
        this.mResponseType = r8.readInt();
        this.mSerial = r8.readInt();
        this.mError = r8.readInt();
    }

    public String toString() {
        return "QRadioResponseInfo: ResponseType: " + getResponseType() + " Serial: " + getSerial() + " Error: " + getError();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mResponseType);
        r8.writeInt(this.mSerial);
        r8.writeInt(this.mError);
    }

    public QRadioResponseInfo(Parcel r8) {
        this.mResponseType = r8.readInt();
        this.mSerial = r8.readInt();
        this.mError = r8.readInt();
    }
}
