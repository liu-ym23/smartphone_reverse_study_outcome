package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class MsimPreference implements Parcelable {
    public static final Parcelable.Creator<MsimPreference> CREATOR = null;
    public static final int DSDA = 0;
    public static final int DSDS = 1;
    private static final String TAG = "MsimPreference";
    private int mMsimPreference;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MsimPreference(int r8) {
        this.mMsimPreference = r8;
    }

    public static boolean isValid(int r8) {
        if (r8 == 0) goto L7;
        if (r8 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mMsimPreference;
    }

    public String toString() {
        return "MsimPreference: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mMsimPreference);
    }

    public MsimPreference(Parcel r8) {
        this.mMsimPreference = r8.readInt();
    }
}
