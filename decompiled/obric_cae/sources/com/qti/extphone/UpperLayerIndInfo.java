package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class UpperLayerIndInfo implements Parcelable {
    public static final Parcelable.Creator<UpperLayerIndInfo> CREATOR = null;
    public static final int INVALID = -1;
    public static final int PLMN_INFO_LIST_AVAILABLE = 1;
    public static final int PLMN_INFO_LIST_UNAVAILABLE = 0;
    private static final String TAG = "UpperLayerIndInfo";
    public static final int UPPER_LAYER_IND_INFO_AVAILABLE = 1;
    public static final int UPPER_LAYER_IND_INFO_UNAVAILABLE = 0;
    private int mPlmnInfoListAvailable;
    private int mUpperLayerIndInfoAvailable;

    static {
        CREATOR = new AnonymousClass1();
    }

    public UpperLayerIndInfo(int r8, int r10) {
        this.mPlmnInfoListAvailable = r8;
        this.mUpperLayerIndInfoAvailable = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPlmnInfoListAvailable() {
        return this.mPlmnInfoListAvailable;
    }

    public int getUpperLayerIndInfoAvailable() {
        return this.mUpperLayerIndInfoAvailable;
    }

    public void readFromParcel(Parcel r8) {
        this.mPlmnInfoListAvailable = r8.readInt();
        this.mUpperLayerIndInfoAvailable = r8.readInt();
    }

    public String toString() {
        return "UpperLayerIndInfo: PLMN: " + getPlmnInfoListAvailable() + " UpperLayerIndInfo: " + getUpperLayerIndInfoAvailable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mPlmnInfoListAvailable);
        r8.writeInt(this.mUpperLayerIndInfoAvailable);
    }

    public UpperLayerIndInfo(Parcel r8) {
        this.mPlmnInfoListAvailable = 0;
        this.mUpperLayerIndInfoAvailable = 0;
        this.mPlmnInfoListAvailable = r8.readInt();
        this.mUpperLayerIndInfoAvailable = r8.readInt();
    }
}
