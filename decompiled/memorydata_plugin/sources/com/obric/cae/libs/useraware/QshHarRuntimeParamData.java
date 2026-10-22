package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class QshHarRuntimeParamData implements Parcelable {
    public static final Parcelable.Creator<QshHarRuntimeParamData> CREATOR = null;
    public static final int POWER_MODE_HIGH_PERF = 2;
    public static final int POWER_MODE_LOW = 1;
    public static final int POWER_MODE_NORMAL = 0;
    private int mConfidenceThreshold;
    private int mPowerMode;
    private int mSampleRate;

    public class a implements Parcelable.Creator<QshHarRuntimeParamData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamData createFromParcel(Parcel r1) {
            return new QshHarRuntimeParamData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamData[] newArray(int r1) {
            return new QshHarRuntimeParamData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarRuntimeParamData() {
    }

    public QshHarRuntimeParamData(int r1, int r2, int r3) {
        this.mSampleRate = r1;
        this.mConfidenceThreshold = r2;
        this.mPowerMode = r3;
    }

    public QshHarRuntimeParamData(Parcel r2) {
        this.mSampleRate = r2.readInt();
        this.mConfidenceThreshold = r2.readInt();
        this.mPowerMode = r2.readInt();
    }

    public QshHarRuntimeParamData(QshHarRuntimeParamData r2) {
        this.mSampleRate = r2.getSampleRate();
        this.mConfidenceThreshold = r2.getConfidenceThreshold();
        this.mPowerMode = r2.getPowerMode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConfidenceThreshold() {
        return this.mConfidenceThreshold;
    }

    public int getPowerMode() {
        return this.mPowerMode;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void readFromParcel(Parcel r2) {
        this.mSampleRate = r2.readInt();
        this.mConfidenceThreshold = r2.readInt();
        this.mPowerMode = r2.readInt();
    }

    public void setConfidenceThreshold(int r1) {
        this.mConfidenceThreshold = r1;
    }

    public void setPowerMode(int r1) {
        this.mPowerMode = r1;
    }

    public void setSampleRate(int r1) {
        this.mSampleRate = r1;
    }

    public String toString() {
        return "QshHarRuntimeParamParcel[sampleRate=" + this.mSampleRate + ", confidenceThreshold=" + this.mConfidenceThreshold + ", powerMode=" + this.mPowerMode + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mSampleRate);
        r1.writeInt(this.mConfidenceThreshold);
        r1.writeInt(this.mPowerMode);
    }
}
