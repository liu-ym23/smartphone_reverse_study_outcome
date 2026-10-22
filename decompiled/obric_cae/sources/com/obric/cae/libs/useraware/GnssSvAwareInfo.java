package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class GnssSvAwareInfo implements Parcelable {
    public static final Parcelable.Creator<GnssSvAwareInfo> CREATOR = null;
    public static final int MASK_AIDING_DATA_ALMANAC = 2;
    public static final int MASK_AIDING_DATA_EPHEMERIS = 1;
    public static final int MASK_AIDING_DATA_NONE = 0;
    private static final int VERSION = 2;
    private final float[] mAzimuths;
    private final float[] mCarrierFrequencies;
    private final float[] mCn0DbHzs;
    private final int[] mConstellationType;
    private final float[] mElevations;
    private final int[] mHasAidingData;
    private final boolean[] mIsUsedInFix;
    private final int mSvCount;
    private final int[] mSvId;
    private final long mTimestamp;
    private int mVisibleSvs;
    private float mVisibleSvsMeanCn0;

    public class a implements Parcelable.Creator<GnssSvAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GnssSvAwareInfo createFromParcel(Parcel r8) {
            return new GnssSvAwareInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final GnssSvAwareInfo[] newArray(int r8) {
            return new GnssSvAwareInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public GnssSvAwareInfo(int r8, int[] r10, float[] r11, float[] r12, float[] r13, float[] r14, int[] r15, int[] r16, boolean[] r17) {
        this.mVisibleSvs = 0;
        this.mVisibleSvsMeanCn0 = 0.0f;
        this.mTimestamp = System.currentTimeMillis();
        this.mSvCount = r8;
        this.mSvId = r10;
        this.mCn0DbHzs = r11;
        this.mElevations = r12;
        this.mAzimuths = r13;
        this.mCarrierFrequencies = r14;
        this.mConstellationType = r15;
        this.mHasAidingData = r16;
        this.mIsUsedInFix = r17;
        a();
    }

    public final void a() {
        int r8 = 0;
    L4:
        if (r8 >= this.mSvCount) goto L9;
        float r10 = this.mCn0DbHzs[r8];
        if (r10 <= 0.0f) goto L8;
        this.mVisibleSvs++;
        this.mVisibleSvsMeanCn0 += r10;
    L8:
        r8 = r8 + 1;
        goto L4
    L9:
        int r11 = this.mVisibleSvs;
        if (r11 <= 0) goto L12;
        this.mVisibleSvsMeanCn0 /= r11;
        return;
    L12:
        this.mVisibleSvsMeanCn0 = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float[] getAzimuths() {
        return this.mAzimuths;
    }

    public float[] getCarrierFrequencies() {
        return this.mCarrierFrequencies;
    }

    public float[] getCn0DbHzs() {
        return this.mCn0DbHzs;
    }

    public int[] getConstellationType() {
        return this.mConstellationType;
    }

    public float[] getElevations() {
        return this.mElevations;
    }

    public int[] getHasAidingData() {
        return this.mHasAidingData;
    }

    public boolean[] getIsUsedInFix() {
        return this.mIsUsedInFix;
    }

    public int getSvCount() {
        return this.mSvCount;
    }

    public int[] getSvId() {
        return this.mSvId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getVersion() {
        return 2;
    }

    public int getVisibleSvCount() {
        return this.mVisibleSvs;
    }

    public float getVisibleSvMeanCn0() {
        return this.mVisibleSvsMeanCn0;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("GnssSvAwareInfo[2,");
        r8.append(this.mTimestamp);
        r8.append(",");
        r8.append(this.mVisibleSvs);
        r8.append(",");
        r8.append(this.mVisibleSvsMeanCn0);
        if (this.mVisibleSvs <= 0) goto L8;
        int r10 = 0;
    L6:
        if (r10 >= this.mSvCount) goto L8;
        r8.append("|");
        r8.append(this.mSvId[r10]);
        r8.append(",");
        r8.append(this.mCn0DbHzs[r10]);
        r8.append(",");
        r8.append(this.mElevations[r10]);
        r8.append(",");
        r8.append(this.mAzimuths[r10]);
        r8.append(",");
        r8.append(this.mCarrierFrequencies[r10]);
        r8.append(",");
        r8.append(this.mConstellationType[r10]);
        r8.append(",");
        r8.append(this.mHasAidingData[r10]);
        r8.append(",");
        r8.append(this.mIsUsedInFix[r10]);
        r10 = r10 + 1;
    L8:
        r8.append(']');
        return r8.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.mTimestamp);
        r8.writeInt(this.mSvCount);
        r8.writeFloatArray(this.mCn0DbHzs);
        r8.writeFloatArray(this.mElevations);
        r8.writeFloatArray(this.mAzimuths);
        r8.writeFloatArray(this.mCarrierFrequencies);
        r8.writeIntArray(this.mConstellationType);
        r8.writeIntArray(this.mHasAidingData);
        r8.writeBooleanArray(this.mIsUsedInFix);
        r8.writeInt(this.mVisibleSvs);
        r8.writeFloat(this.mVisibleSvsMeanCn0);
        r8.writeIntArray(this.mSvId);
    }

    public GnssSvAwareInfo(Parcel r8) {
        this.mVisibleSvs = 0;
        this.mVisibleSvsMeanCn0 = 0.0f;
        this.mTimestamp = r8.readLong();
        int r10 = r8.readInt();
        this.mSvCount = r10;
        float[] r11 = new float[r10];
        this.mCn0DbHzs = r11;
        r8.readFloatArray(r11);
        float[] r12 = new float[r10];
        this.mElevations = r12;
        r8.readFloatArray(r12);
        float[] r13 = new float[r10];
        this.mAzimuths = r13;
        r8.readFloatArray(r13);
        float[] r14 = new float[r10];
        this.mCarrierFrequencies = r14;
        r8.readFloatArray(r14);
        int[] r15 = new int[r10];
        this.mConstellationType = r15;
        r8.readIntArray(r15);
        int[] r16 = new int[r10];
        this.mHasAidingData = r16;
        r8.readIntArray(r16);
        boolean[] r17 = new boolean[r10];
        this.mIsUsedInFix = r17;
        r8.readBooleanArray(r17);
        this.mVisibleSvs = r8.readInt();
        this.mVisibleSvsMeanCn0 = r8.readFloat();
        int[] r18 = new int[r10];
        this.mSvId = r18;
        if (r8.dataAvail() <= 0) goto L6;
        r8.readIntArray(r18);
        return;
    }
}
