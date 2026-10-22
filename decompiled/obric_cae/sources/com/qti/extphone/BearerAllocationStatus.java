package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class BearerAllocationStatus implements Parcelable {
    public static final int ALLOCATED = 1;
    public static final Parcelable.Creator<BearerAllocationStatus> CREATOR = null;
    public static final int INVALID = -1;
    public static final int MMW_ALLOCATED = 2;
    public static final int NOT_ALLOCATED = 0;
    private static final String TAG = "BearerAllocationStatus";
    private int mValue;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BearerAllocationStatus(int r8) {
        this.mValue = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBearerAllocationStatus() {
        return this.mValue;
    }

    public void readFromParcel(Parcel r8) {
        this.mValue = r8.readInt();
    }

    public String toString() {
        return "BearerAllocationStatus: " + getBearerAllocationStatus();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mValue);
    }

    public BearerAllocationStatus(Parcel r8) {
        this.mValue = r8.readInt();
    }
}
