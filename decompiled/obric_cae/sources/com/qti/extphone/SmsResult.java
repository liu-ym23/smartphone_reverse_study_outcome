package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SmsResult implements Parcelable {
    public static final Parcelable.Creator<SmsResult> CREATOR = null;
    private static final String TAG = "SmsResult";
    private String mAckPDU;
    private int mErrorCode;
    private int mMessageRef;

    static {
        CREATOR = new AnonymousClass1();
    }

    public SmsResult(int r8, String r10, int r11) {
        this.mMessageRef = r8;
        this.mAckPDU = r10;
        this.mErrorCode = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAckPDU() {
        return this.mAckPDU;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getMessageRef() {
        return this.mMessageRef;
    }

    public void readFromParcel(Parcel r8) {
        this.mMessageRef = r8.readInt();
        this.mAckPDU = r8.readString();
        this.mErrorCode = r8.readInt();
    }

    public String toString() {
        return "SmsResult{mMessageRef=" + getMessageRef() + ", mErrorCode=" + getErrorCode() + ", mAckPDU='" + getAckPDU() + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mMessageRef);
        r8.writeString(this.mAckPDU);
        r8.writeInt(this.mErrorCode);
    }

    public SmsResult(Parcel r8) {
        this.mMessageRef = r8.readInt();
        this.mAckPDU = r8.readString();
        this.mErrorCode = r8.readInt();
    }
}
