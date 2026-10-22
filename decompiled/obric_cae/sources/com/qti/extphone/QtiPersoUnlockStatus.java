package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QtiPersoUnlockStatus implements Parcelable {
    public static final Parcelable.Creator<QtiPersoUnlockStatus> CREATOR = null;
    public static final int PERMANENT_UNLOCKED = 2;
    private static final String TAG = "QtiPersoUnlockStatus";
    public static final int TEMPORARY_UNLOCKED = 1;
    public static final int UNKNOWN = 0;
    private int mPersoUnlockStatus;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QtiPersoUnlockStatus(int r8) {
        this.mPersoUnlockStatus = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mPersoUnlockStatus;
    }

    public String toString() {
        return "QtiPersoUnlockStatus: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mPersoUnlockStatus);
    }

    public QtiPersoUnlockStatus(Parcel r8) {
        this.mPersoUnlockStatus = r8.readInt();
    }
}
