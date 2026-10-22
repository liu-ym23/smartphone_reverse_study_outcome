package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class DualDataRecommendation implements Parcelable {
    public static final int ACTION_DATA_ALLOW = 1;
    public static final int ACTION_DATA_NOT_ALLOW = 0;
    public static final Parcelable.Creator<DualDataRecommendation> CREATOR = null;
    public static final int DDS = 1;
    public static final int NON_DDS = 2;
    private static final String TAG = "DualDataRecommendation";
    private int mAction;
    private int mSub;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DualDataRecommendation(int r8, int r10) {
        this.mSub = r8;
        this.mAction = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getRecommendedSub() {
        return this.mSub;
    }

    public String toString() {
        return "DualDataRecommendation: getRecommendedSub(): " + getRecommendedSub() + " getAction: " + getAction();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mSub);
        r8.writeInt(this.mAction);
    }

    public DualDataRecommendation(Parcel r8) {
        this.mSub = r8.readInt();
        this.mAction = r8.readInt();
    }
}
