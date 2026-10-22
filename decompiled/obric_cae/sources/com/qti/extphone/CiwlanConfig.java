package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class CiwlanConfig implements Parcelable {
    public static final Parcelable.Creator<CiwlanConfig> CREATOR = null;
    public static final int INVALID = -1;
    public static final int ONLY = 0;
    public static final int PREFERRED = 1;
    private static final String TAG = "CiwlanConfig";
    public static final int UNSUPPORTED = 2;
    private int mHomeMode;
    private int mRoamMode;

    static {
        CREATOR = new AnonymousClass1();
    }

    public CiwlanConfig(int r8, int r10) {
        this.mHomeMode = r8;
        this.mRoamMode = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCiwlanHomeMode() {
        return this.mHomeMode;
    }

    public int getCiwlanRoamMode() {
        return this.mRoamMode;
    }

    public String getHomeCiwlanMode() {
        int r8 = this.mHomeMode;
        if (r8 != 0) goto L5;
        return "ONLY";
    L5:
        if (r8 != 1) goto L7;
        return "PREFERRED";
    L7:
        if (r8 == 2) goto L10;
        return "INVALID";
    L10:
        return "UNSUPPORTED";
    }

    public String getRoamCiwlanMode() {
        int r8 = this.mRoamMode;
        if (r8 != 0) goto L5;
        return "ONLY";
    L5:
        if (r8 != 1) goto L7;
        return "PREFERRED";
    L7:
        if (r8 == 2) goto L10;
        return "INVALID";
    L10:
        return "UNSUPPORTED";
    }

    public boolean isCiwlanModeSupported() {
        if (this.mHomeMode != 2) goto L5;
    L7:
        return false;
    L5:
        if (this.mRoamMode == 2) goto L7;
        return true;
    }

    public boolean isCiwlanOnlyInHome() {
        if (this.mHomeMode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCiwlanOnlyInRoam() {
        if (this.mRoamMode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValid() {
        if (this.mHomeMode != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.mRoamMode == (-1)) goto L7;
        return true;
    }

    public String toString() {
        return "CiwlanConfig homeMode = " + getHomeCiwlanMode() + ", roamMode = " + getRoamCiwlanMode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mHomeMode);
        r8.writeInt(this.mRoamMode);
    }

    public CiwlanConfig(Parcel r8) {
        this.mHomeMode = -1;
        this.mRoamMode = -1;
        this.mHomeMode = r8.readInt();
        this.mRoamMode = r8.readInt();
    }
}
