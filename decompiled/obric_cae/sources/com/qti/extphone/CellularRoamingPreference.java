package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class CellularRoamingPreference implements Parcelable {
    public static final Parcelable.Creator<CellularRoamingPreference> CREATOR = null;
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    public static final int INVALID = -1;
    private static final String TAG = "CellularRoamingPreference";
    private int mDomesticPref;
    private int mInternationalPref;

    static {
        CREATOR = new AnonymousClass1();
    }

    public CellularRoamingPreference(int r8, int r10) {
        this.mInternationalPref = r8;
        this.mDomesticPref = r10;
    }

    public String convertCellularRoamingModeToString(int r8) {
        if (r8 != 0) goto L4;
        return "DISABLED";
    L4:
        if (r8 == 1) goto L7;
        return "INVALID";
    L7:
        return "ENABLED";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDomesticCellularRoamingPref() {
        return this.mDomesticPref;
    }

    public int getInternationalCellularRoamingPref() {
        return this.mInternationalPref;
    }

    public boolean isValid() {
        if (this.mInternationalPref != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.mDomesticPref == (-1)) goto L7;
        return true;
    }

    public String toString() {
        return "CellularRoamingPreference internationalPref = " + convertCellularRoamingModeToString(this.mInternationalPref) + ", domesticPref = " + convertCellularRoamingModeToString(this.mDomesticPref);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mInternationalPref);
        r8.writeInt(this.mDomesticPref);
    }

    public CellularRoamingPreference(Parcel r8) {
        this.mInternationalPref = -1;
        this.mDomesticPref = -1;
        this.mInternationalPref = r8.readInt();
        this.mDomesticPref = r8.readInt();
    }
}
