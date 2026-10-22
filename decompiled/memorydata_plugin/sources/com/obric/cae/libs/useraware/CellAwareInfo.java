package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7001b;
        public int c;
        public int d;
        public int e;
        public long f;
        public int[] g;
        public String h;
        public String i;
        public int j;
        public int k;
        public int l;
        public boolean m;

        public a() {
        }

        public static /* synthetic */ String a(a r0) {
            return r0.f7000a;
        }

        public static /* synthetic */ String b(a r0) {
            return r0.f7001b;
        }

        public static /* synthetic */ int c(a r0) {
            return r0.c;
        }

        public static /* synthetic */ int d(a r0) {
            return r0.d;
        }

        public static /* synthetic */ int e(a r0) {
            return r0.e;
        }

        public static /* synthetic */ long f(a r2) {
            return r2.f;
        }

        public static /* synthetic */ int[] g(a r0) {
            return r0.g;
        }

        public static /* synthetic */ String h(a r0) {
            return r0.h;
        }

        public static /* synthetic */ String i(a r0) {
            return r0.i;
        }

        public static /* synthetic */ int j(a r0) {
            return r0.j;
        }

        public static /* synthetic */ int k(a r0) {
            return r0.k;
        }

        public static /* synthetic */ int l(a r0) {
            return r0.l;
        }

        public static /* synthetic */ boolean m(a r0) {
            return r0.m;
        }

        public a a(int r1) {
            this.c = r1;
            return this;
        }

        public a a(long r1) {
            this.f = r1;
            return this;
        }

        public a a(String r1) {
            this.f7000a = r1;
            return this;
        }

        public a a(boolean r1) {
            this.m = r1;
            return this;
        }

        public a a(int[] r1) {
            this.g = r1;
            return this;
        }

        public CellAwareInfo a() {
            return new CellAwareInfo(this);
        }

        public a b(int r1) {
            this.d = r1;
            return this;
        }

        public a b(String r1) {
            this.f7001b = r1;
            return this;
        }

        public a c(int r1) {
            this.e = r1;
            return this;
        }

        public a c(String r1) {
            this.h = r1;
            return this;
        }

        public a d(int r1) {
            this.j = r1;
            return this;
        }

        public a d(String r1) {
            this.i = r1;
            return this;
        }

        public a e(int r1) {
            this.k = r1;
            return this;
        }

        public a f(int r1) {
            this.l = r1;
            return this;
        }
    }

    public class b implements Parcelable.Creator<CellAwareInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo createFromParcel(Parcel r1) {
            return new CellAwareInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final CellAwareInfo[] newArray(int r1) {
            return new CellAwareInfo[r1];
        }
    }

    static {
        CREATOR = new b();
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

    public CellAwareInfo(a r3) {
        this.mTimestamp = a.a(r3);
        this.mStandard = a.b(r3);
        this.mArfcn = a.c(r3);
        this.mPci = a.d(r3);
        this.mTac = a.e(r3);
        this.mCi = a.f(r3);
        this.mBands = a.g(r3);
        this.mMcc = a.h(r3);
        this.mMnc = a.i(r3);
        this.mSignalStrength = a.j(r3);
        this.mSignalQuality = a.k(r3);
        this.mLevel = a.l(r3);
        this.mRegistered = a.m(r3);
    }

    public boolean compareTo(CellAwareInfo r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L25;
        if (this.mArfcn != r7.mArfcn) goto L24;
        if (this.mPci != r7.mPci) goto L24;
        if (this.mTac != r7.mTac) goto L24;
        if (this.mCi != r7.mCi) goto L24;
        if (this.mRegistered != r7.mRegistered) goto L24;
        if (Objects.equals(this.mStandard, r7.mStandard) == false) goto L24;
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

    public String toString() {
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=***, mCi=***, mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
    }

    public String toUnmaskedString() {
        return "CellInfo{2, mTimestamp='" + this.mTimestamp + "', mStandard='" + this.mStandard + "', mArfcn=" + this.mArfcn + ", mPci=" + this.mPci + ", mTac=" + this.mTac + ", mCi=" + this.mCi + ", mBands=" + Arrays.toString(this.mBands) + ", mMcc='" + this.mMcc + "', mMnc='" + this.mMnc + "', mSignalStrength=" + this.mSignalStrength + ", mSignalQuality=" + this.mSignalQuality + ", mLevel=" + this.mLevel + ", mRegistered=" + this.mRegistered + '}';
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
