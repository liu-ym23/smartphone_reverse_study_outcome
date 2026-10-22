package com.obric.cae.libs.useraware;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
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

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5514f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int[] f5515g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f5516h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f5517i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f5518j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5519k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f5520l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f5521m;

        public Builder() {
        }

        public static /* synthetic */ String a(Builder r8) {
            return r8.f5509a;
        }

        public static /* synthetic */ String b(Builder r8) {
            return r8.f5510b;
        }

        public static /* synthetic */ int c(Builder r8) {
            return r8.f5519k;
        }

        public static /* synthetic */ int d(Builder r8) {
            return r8.f5520l;
        }

        public static /* synthetic */ boolean e(Builder r8) {
            return r8.f5521m;
        }

        public static /* synthetic */ int f(Builder r8) {
            return r8.f5511c;
        }

        public static /* synthetic */ int g(Builder r8) {
            return r8.f5512d;
        }

        public static /* synthetic */ int h(Builder r8) {
            return r8.f5513e;
        }

        public static /* synthetic */ long i(Builder r8) {
            return r8.f5514f;
        }

        public static /* synthetic */ int[] j(Builder r8) {
            return r8.f5515g;
        }

        public static /* synthetic */ String k(Builder r8) {
            return r8.f5516h;
        }

        public static /* synthetic */ String l(Builder r8) {
            return r8.f5517i;
        }

        public static /* synthetic */ int m(Builder r8) {
            return r8.f5518j;
        }

        public Builder arfcn(int r8) {
            this.f5511c = r8;
            return this;
        }

        public Builder bands(int[] r8) {
            this.f5515g = r8;
            return this;
        }

        public CellAwareInfo build() {
            return new CellAwareInfo(this);
        }

        public Builder ci(long r8) {
            this.f5514f = r8;
            return this;
        }

        public Builder level(int r8) {
            this.f5520l = r8;
            return this;
        }

        public Builder mcc(String r8) {
            this.f5516h = r8;
            return this;
        }

        public Builder mnc(String r8) {
            this.f5517i = r8;
            return this;
        }

        public Builder pci(int r8) {
            this.f5512d = r8;
            return this;
        }

        public Builder registered(boolean r8) {
            this.f5521m = r8;
            return this;
        }

        public Builder signalQuality(int r8) {
            this.f5519k = r8;
            return this;
        }

        public Builder signalStrength(int r8) {
            this.f5518j = r8;
            return this;
        }

        public Builder standard(String r8) {
            this.f5510b = r8;
            return this;
        }

        public Builder tac(int r8) {
            this.f5513e = r8;
            return this;
        }

        public Builder timestamp(String r8) {
            this.f5509a = r8;
            return this;
        }
    }

    public class a implements Parcelable.Creator<CellAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo createFromParcel(Parcel r8) {
            return new CellAwareInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo[] newArray(int r8) {
            return new CellAwareInfo[r8];
        }
    }

    static {
        CREATOR = new a();
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

    public boolean compareTo(CellAwareInfo r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L25;
        if (this.mArfcn != r8.mArfcn) goto L24;
        if (this.mPci != r8.mPci) goto L24;
        if (this.mTac != r8.mTac) goto L24;
        if (this.mCi != r8.mCi) goto L24;
        if (this.mRegistered != r8.mRegistered) goto L24;
        if (Objects.equals(this.mStandard, r8.mStandard) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public int getVersion() {
        return 2;
    }

    public boolean isRegistered() {
        return this.mRegistered;
    }

    @SuppressLint({"NewApi"})
    public void readFromParcel(Parcel r8) {
        this.mTimestamp = r8.readString();
        this.mStandard = r8.readString();
        this.mArfcn = r8.readInt();
        this.mPci = r8.readInt();
        this.mTac = r8.readInt();
        this.mCi = r8.readLong();
        this.mBands = r8.createIntArray();
        this.mMcc = r8.readString();
        this.mMnc = r8.readString();
        this.mSignalStrength = r8.readInt();
        this.mSignalQuality = r8.readInt();
        this.mLevel = r8.readInt();
        this.mRegistered = r8.readBoolean();
    }

    public void setArfcn(int r8) {
        this.mArfcn = r8;
    }

    public void setBands(int[] r8) {
        this.mBands = r8;
    }

    public void setLevel(int r8) {
        this.mLevel = r8;
    }

    public void setMcc(String r8) {
        this.mMcc = r8;
    }

    public void setMci(long r8) {
        this.mCi = r8;
    }

    public void setMnc(String r8) {
        this.mMnc = r8;
    }

    public void setPci(int r8) {
        this.mPci = r8;
    }

    public void setRegistered(boolean r8) {
        this.mRegistered = r8;
    }

    public void setSignalQuality(int r8) {
        this.mSignalQuality = r8;
    }

    public void setSignalStrength(int r8) {
        this.mSignalStrength = r8;
    }

    public void setStandard(String r8) {
        this.mStandard = r8;
    }

    public void setTac(int r8) {
        this.mTac = r8;
    }

    public void setTimestamp(String r8) {
        this.mTimestamp = r8;
    }

    public String toString() {
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=***, mCi=***, mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.mTimestamp);
        r8.writeString(this.mStandard);
        r8.writeInt(this.mArfcn);
        r8.writeInt(this.mPci);
        r8.writeInt(this.mTac);
        r8.writeLong(this.mCi);
        r8.writeIntArray(this.mBands);
        r8.writeString(this.mMcc);
        r8.writeString(this.mMnc);
        r8.writeInt(this.mSignalStrength);
        r8.writeInt(this.mSignalQuality);
        r8.writeInt(this.mLevel);
        r8.writeBoolean(this.mRegistered);
    }

    @SuppressLint({"NewApi"})
    public CellAwareInfo(Parcel r8) {
        this.mTimestamp = r8.readString();
        this.mStandard = r8.readString();
        this.mArfcn = r8.readInt();
        this.mPci = r8.readInt();
        this.mTac = r8.readInt();
        this.mCi = r8.readLong();
        this.mBands = r8.createIntArray();
        this.mMcc = r8.readString();
        this.mMnc = r8.readString();
        this.mSignalStrength = r8.readInt();
        this.mSignalQuality = r8.readInt();
        this.mLevel = r8.readInt();
        this.mRegistered = r8.readBoolean();
    }

    public CellAwareInfo(Builder r8) {
        this.mTimestamp = Builder.a(r8);
        this.mStandard = Builder.b(r8);
        this.mArfcn = Builder.f(r8);
        this.mPci = Builder.g(r8);
        this.mTac = Builder.h(r8);
        this.mCi = Builder.i(r8);
        this.mBands = Builder.j(r8);
        this.mMcc = Builder.k(r8);
        this.mMnc = Builder.l(r8);
        this.mSignalStrength = Builder.m(r8);
        this.mSignalQuality = Builder.c(r8);
        this.mLevel = Builder.d(r8);
        this.mRegistered = Builder.e(r8);
    }
}
