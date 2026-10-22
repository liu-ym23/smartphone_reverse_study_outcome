package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CellAwareInfo implements Parcelable {
    public static final Parcelable.Creator<CellAwareInfo> CREATOR = null;
    private static final String LTE = "LTE";
    private static final long MAX_NCI = 68719476735L;
    private static final int MAX_NRARFCN = 3279165;
    private static final int MAX_PCI = 1007;
    private static final int MAX_TAC = 16777215;
    private static final String NR = "NR";
    private static final int VERSION = 2;
    private int mArfcn;
    private int[] mBands;
    private long mCi;
    private int mLevel;
    private String mMcc;
    private String mMnc;
    private int mPci;
    private boolean mRegistered;
    private int mSignalQuality;
    private int mSignalStrength;
    private String mStandard;
    private int mTac;
    private String mTimestamp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersion() {
        return 2;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=" + this.mTac + ", mCi=" + this.mCi + ", mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
    }

    public CellAwareInfo() {
        this.mTimestamp = String.valueOf(System.currentTimeMillis());
        this.mStandard = "";
        this.mArfcn = 0;
        this.mPci = 0;
        this.mTac = 0;
        this.mCi = 0;
        this.mBands = new int[0];
        this.mMcc = "";
        this.mMnc = "";
        this.mSignalStrength = 0;
        this.mSignalQuality = 0;
        this.mLevel = 0;
        this.mRegistered = false;
    }

    public int getArfcn() {
        return this.mArfcn;
    }

    public int[] getBands() {
        return this.mBands;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getMcc() {
        return this.mMcc;
    }

    public long getMci() {
        return this.mCi;
    }

    public String getMnc() {
        return this.mMnc;
    }

    public int getPci() {
        return this.mPci;
    }

    public int getSignalQuality() {
        return this.mSignalQuality;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public String getStandard() {
        return this.mStandard;
    }

    public int getTac() {
        return this.mTac;
    }

    public String getTimestamp() {
        return this.mTimestamp;
    }

    public boolean isRegistered() {
        return this.mRegistered;
    }

    public CellAwareInfo(Parcel r3) {
        this.mTimestamp = r3.readString();
        this.mStandard = r3.readString();
        this.mArfcn = r3.readInt();
        this.mPci = r3.readInt();
        this.mTac = r3.readInt();
        this.mCi = r3.readLong();
        this.mBands = r3.createIntArray();
        this.mMcc = r3.readString();
        this.mMnc = r3.readString();
        this.mSignalStrength = r3.readInt();
        this.mSignalQuality = r3.readInt();
        this.mLevel = r3.readInt();
        this.mRegistered = r3.readBoolean();
    }

    public boolean compareTo(CellAwareInfo r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L25;
        if (this.mArfcn == r8.mArfcn) goto L13;
    L23:
        return false;
    L13:
        if (this.mPci != r8.mPci) goto L23;
        if (this.mTac != r8.mTac) goto L23;
        if (this.mCi != r8.mCi) goto L23;
        if (this.mRegistered != r8.mRegistered) goto L23;
        if (Objects.equals(this.mStandard, r8.mStandard) == false) goto L23;
        return true;
    }

    public void readFromParcel(Parcel r3) {
        this.mTimestamp = r3.readString();
        this.mStandard = r3.readString();
        this.mArfcn = r3.readInt();
        this.mPci = r3.readInt();
        this.mTac = r3.readInt();
        this.mCi = r3.readLong();
        this.mBands = r3.createIntArray();
        this.mMcc = r3.readString();
        this.mMnc = r3.readString();
        this.mSignalStrength = r3.readInt();
        this.mSignalQuality = r3.readInt();
        this.mLevel = r3.readInt();
        this.mRegistered = r3.readBoolean();
    }

    public void setArfcn(int r1) {
        this.mArfcn = r1;
    }

    public void setBands(int[] r1) {
        this.mBands = r1;
    }

    public void setLevel(int r1) {
        this.mLevel = r1;
    }

    public void setMcc(String r1) {
        this.mMcc = r1;
    }

    public void setMci(long r1) {
        this.mCi = r1;
    }

    public void setMnc(String r1) {
        this.mMnc = r1;
    }

    public void setPci(int r1) {
        this.mPci = r1;
    }

    public void setRegistered(boolean r1) {
        this.mRegistered = r1;
    }

    public void setSignalQuality(int r1) {
        this.mSignalQuality = r1;
    }

    public void setSignalStrength(int r1) {
        this.mSignalStrength = r1;
    }

    public void setStandard(String r1) {
        this.mStandard = r1;
    }

    public void setTac(int r1) {
        this.mTac = r1;
    }

    public void setTimestamp(String r1) {
        this.mTimestamp = r1;
    }

    public CellAwareInfo(Builder r3) {
        this.mTimestamp = Builder.a(r3);
        this.mStandard = Builder.b(r3);
        this.mArfcn = Builder.f(r3);
        this.mPci = Builder.g(r3);
        this.mTac = Builder.h(r3);
        this.mCi = Builder.i(r3);
        this.mBands = Builder.j(r3);
        this.mMcc = Builder.k(r3);
        this.mMnc = Builder.l(r3);
        this.mSignalStrength = Builder.m(r3);
        this.mSignalQuality = Builder.c(r3);
        this.mLevel = Builder.d(r3);
        this.mRegistered = Builder.e(r3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.mTimestamp);
        r3.writeString(this.mStandard);
        r3.writeInt(this.mArfcn);
        r3.writeInt(this.mPci);
        r3.writeInt(this.mTac);
        r3.writeLong(this.mCi);
        r3.writeIntArray(this.mBands);
        r3.writeString(this.mMcc);
        r3.writeString(this.mMnc);
        r3.writeInt(this.mSignalStrength);
        r3.writeInt(this.mSignalQuality);
        r3.writeInt(this.mLevel);
        r3.writeBoolean(this.mRegistered);
    }
}
