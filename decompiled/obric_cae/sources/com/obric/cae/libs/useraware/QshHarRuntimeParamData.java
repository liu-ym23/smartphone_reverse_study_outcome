package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class QshHarRuntimeParamData implements Parcelable {
    public static final Parcelable.Creator<QshHarRuntimeParamData> CREATOR = null;
    public static final int POWER_MODE_HIGH_PERF = 2;
    public static final int POWER_MODE_LOW = 1;
    public static final int POWER_MODE_NORMAL = 0;
    private int mConfidenceThreshold;
    private int mPowerMode;
    private int mSampleRate;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5547c;

        public Builder() {
            this.f5547c = 0;
        }

        public QshHarRuntimeParamData build() {
            return new QshHarRuntimeParamData(this.f5545a, this.f5546b, this.f5547c);
        }

        public Builder setConfidenceThreshold(int r8) {
            this.f5546b = r8;
            return this;
        }

        public Builder setPowerMode(int r8) {
            this.f5547c = r8;
            return this;
        }

        public Builder setSampleRate(int r8) {
            this.f5545a = r8;
            return this;
        }
    }

    public class a implements Parcelable.Creator<QshHarRuntimeParamData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamData createFromParcel(Parcel r8) {
            return new QshHarRuntimeParamData(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamData[] newArray(int r8) {
            return new QshHarRuntimeParamData[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarRuntimeParamData() {
    }

    public QshHarRuntimeParamData(int r8, int r10, int r11) {
        this.mSampleRate = r8;
        this.mConfidenceThreshold = r10;
        this.mPowerMode = r11;
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

    public void readFromParcel(Parcel r8) {
        this.mSampleRate = r8.readInt();
        this.mConfidenceThreshold = r8.readInt();
        this.mPowerMode = r8.readInt();
    }

    public void setConfidenceThreshold(int r8) {
        this.mConfidenceThreshold = r8;
    }

    public void setPowerMode(int r8) {
        this.mPowerMode = r8;
    }

    public void setSampleRate(int r8) {
        this.mSampleRate = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("QshHarRuntimeParamParcel[sampleRate=");
        r8.append(this.mSampleRate);
        r8.append(", confidenceThreshold=");
        r8.append(this.mConfidenceThreshold);
        r8.append(", powerMode=");
        return android.aimedia.a.f(r8, this.mPowerMode, ']');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mSampleRate);
        r8.writeInt(this.mConfidenceThreshold);
        r8.writeInt(this.mPowerMode);
    }

    public QshHarRuntimeParamData(Parcel r8) {
        this.mSampleRate = r8.readInt();
        this.mConfidenceThreshold = r8.readInt();
        this.mPowerMode = r8.readInt();
    }

    public QshHarRuntimeParamData(QshHarRuntimeParamData r8) {
        this.mSampleRate = r8.getSampleRate();
        this.mConfidenceThreshold = r8.getConfidenceThreshold();
        this.mPowerMode = r8.getPowerMode();
    }
}
