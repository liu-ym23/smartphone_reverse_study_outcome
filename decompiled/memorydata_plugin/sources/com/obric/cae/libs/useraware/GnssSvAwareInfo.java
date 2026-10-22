package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
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
        public final GnssSvAwareInfo createFromParcel(Parcel r1) {
            return new GnssSvAwareInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final GnssSvAwareInfo[] newArray(int r1) {
            return new GnssSvAwareInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public GnssSvAwareInfo(int r3, int[] r4, float[] r5, float[] r6, float[] r7, float[] r8, int[] r9, int[] r10, boolean[] r11) {
        this.mVisibleSvs = 0;
        this.mVisibleSvsMeanCn0 = 0.0f;
        this.mTimestamp = System.currentTimeMillis();
        this.mSvCount = r3;
        this.mSvId = r4;
        this.mCn0DbHzs = r5;
        this.mElevations = r6;
        this.mAzimuths = r7;
        this.mCarrierFrequencies = r8;
        this.mConstellationType = r9;
        this.mHasAidingData = r10;
        this.mIsUsedInFix = r11;
        a();
    }

    public GnssSvAwareInfo(Parcel r3) {
        this.mVisibleSvs = 0;
        this.mVisibleSvsMeanCn0 = 0.0f;
        this.mTimestamp = r3.readLong();
        int r0 = r3.readInt();
        this.mSvCount = r0;
        float[] r1 = new float[r0];
        this.mCn0DbHzs = r1;
        r3.readFloatArray(r1);
        float[] r2 = new float[r0];
        this.mElevations = r2;
        r3.readFloatArray(r2);
        float[] r4 = new float[r0];
        this.mAzimuths = r4;
        r3.readFloatArray(r4);
        float[] r5 = new float[r0];
        this.mCarrierFrequencies = r5;
        r3.readFloatArray(r5);
        int[] r6 = new int[r0];
        this.mConstellationType = r6;
        r3.readIntArray(r6);
        int[] r7 = new int[r0];
        this.mHasAidingData = r7;
        r3.readIntArray(r7);
        boolean[] r8 = new boolean[r0];
        this.mIsUsedInFix = r8;
        r3.readBooleanArray(r8);
        this.mVisibleSvs = r3.readInt();
        this.mVisibleSvsMeanCn0 = r3.readFloat();
        int[] r9 = new int[r0];
        this.mSvId = r9;
        if (r3.dataAvail() <= 0) goto L6;
        r3.readIntArray(r9);
        return;
    }

    public final void a() {
        int r0 = 0;
    L4:
        if (r0 >= this.mSvCount) goto L9;
        float r1 = this.mCn0DbHzs[r0];
        if (r1 <= 0.0f) goto L8;
        this.mVisibleSvs++;
        this.mVisibleSvsMeanCn0 += r1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        int r2 = this.mVisibleSvs;
        if (r2 <= 0) goto L12;
        this.mVisibleSvsMeanCn0 /= r2;
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
        StringBuilder r0 = new StringBuilder("GnssSvAwareInfo[2,").append(this.mTimestamp).append(",").append(this.mVisibleSvs).append(",").append(this.mVisibleSvsMeanCn0);
        if (this.mVisibleSvs <= 0) goto L9;
        int r2 = 0;
    L6:
        if (r2 >= this.mSvCount) goto L9;
        r0.append("|").append(this.mSvId[r2]).append(",").append(this.mCn0DbHzs[r2]).append(",").append(this.mElevations[r2]).append(",").append(this.mAzimuths[r2]).append(",").append(this.mCarrierFrequencies[r2]).append(",").append(this.mConstellationType[r2]).append(",").append(this.mHasAidingData[r2]).append(",").append(this.mIsUsedInFix[r2]);
        r2 = r2 + 1;
    L9:
        return r0.append(']').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mTimestamp);
        r3.writeInt(this.mSvCount);
        r3.writeFloatArray(this.mCn0DbHzs);
        r3.writeFloatArray(this.mElevations);
        r3.writeFloatArray(this.mAzimuths);
        r3.writeFloatArray(this.mCarrierFrequencies);
        r3.writeIntArray(this.mConstellationType);
        r3.writeIntArray(this.mHasAidingData);
        r3.writeBooleanArray(this.mIsUsedInFix);
        r3.writeInt(this.mVisibleSvs);
        r3.writeFloat(this.mVisibleSvsMeanCn0);
        r3.writeIntArray(this.mSvId);
    }
}
