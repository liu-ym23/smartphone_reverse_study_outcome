package com.qti.extphone;

import android.aimedia.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QtiCallForwardInfo implements Parcelable {
    public static final Parcelable.Creator<QtiCallForwardInfo> CREATOR = null;
    private static final String TAG = "QtiCallForwardInfo";
    public String number;
    public int reason;
    public int serviceClass;
    public int status;
    public int timeSeconds;
    public int toa;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QtiCallForwardInfo() {
    }

    public QtiCallForwardInfo(Parcel r8) {
        this.status = r8.readInt();
        this.reason = r8.readInt();
        this.serviceClass = r8.readInt();
        this.toa = r8.readInt();
        this.number = r8.readString();
        this.timeSeconds = r8.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel r8) {
        this.status = r8.readInt();
        this.reason = r8.readInt();
        this.serviceClass = r8.readInt();
        this.toa = r8.readInt();
        this.number = r8.readString();
        this.timeSeconds = r8.readInt();
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("[QtiCallForwardInfo: status=");
        if (this.status != 0) goto L5;
        String r10 = " not active ";
    L6:
        r8.append(r10);
        r8.append(", reason= ");
        r8.append(this.reason);
        r8.append(", serviceClass= ");
        r8.append(this.serviceClass);
        r8.append(", timeSec= ");
        return a.h(r8, this.timeSeconds, " seconds]");
    L5:
        r10 = " active ";
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.status);
        r8.writeInt(this.reason);
        r8.writeInt(this.serviceClass);
        r8.writeInt(this.toa);
        r8.writeString(this.number);
        r8.writeInt(this.timeSeconds);
    }
}
