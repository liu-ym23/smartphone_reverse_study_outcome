package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkSelectionMode implements Parcelable {
    public static final int ACCESS_MODE_INVALID = 0;
    public static final Parcelable.Creator<NetworkSelectionMode> CREATOR = null;
    private static final String TAG = "NetworkSelectionMode";
    private int mAccessMode;
    private boolean mIsManual;

    static {
        CREATOR = new AnonymousClass1();
    }

    public NetworkSelectionMode(int r8, boolean r10) {
        this.mAccessMode = r8;
        this.mIsManual = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccessMode() {
        return this.mAccessMode;
    }

    public boolean getIsManual() {
        return this.mIsManual;
    }

    public void readFromParcel(Parcel r8) {
        this.mAccessMode = r8.readInt();
        this.mIsManual = r8.readBoolean();
    }

    public String toString() {
        return TAG + this.mAccessMode + "/" + this.mIsManual;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mAccessMode);
        r8.writeBoolean(this.mIsManual);
    }

    public NetworkSelectionMode(Parcel r8) {
        this.mAccessMode = 0;
        this.mIsManual = false;
        this.mAccessMode = r8.readInt();
        this.mIsManual = r8.readBoolean();
    }
}
