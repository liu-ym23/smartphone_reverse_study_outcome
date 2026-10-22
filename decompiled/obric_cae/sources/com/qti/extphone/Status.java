package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class Status implements Parcelable {
    public static final Parcelable.Creator<Status> CREATOR = null;
    public static final int EXCEPTION = -1;
    public static final int FAILURE = 0;
    public static final int SUCCESS = 1;
    private static final String TAG = "Status";
    private int mStatus;

    static {
        CREATOR = new AnonymousClass1();
    }

    public Status(int r8) {
        this.mStatus = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mStatus;
    }

    public void readFromParcel(Parcel r8) {
        this.mStatus = r8.readInt();
    }

    public String toString() {
        return "Status: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mStatus);
    }

    public Status(Parcel r8) {
        this.mStatus = r8.readInt();
    }
}
