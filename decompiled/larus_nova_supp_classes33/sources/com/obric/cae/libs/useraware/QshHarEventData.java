package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class QshHarEventData implements Parcelable {
    public static final int ACTIVITY_ALL = 7;
    public static final int ACTIVITY_BIKING = 6;
    public static final int ACTIVITY_DRIVING = 4;
    public static final int ACTIVITY_RUNNING = 3;
    public static final int ACTIVITY_STATIONARY = 1;
    public static final int ACTIVITY_TRANSIT = 5;
    public static final int ACTIVITY_UNKNOWN = 0;
    public static final int ACTIVITY_WALKING = 2;
    public static final Parcelable.Creator<QshHarEventData> CREATOR = null;
    public static final int EVENT_TYPE_ALL = 3;
    public static final int EVENT_TYPE_MOTION_OTHER = 2;
    public static final int EVENT_TYPE_MOTION_STATE = 1;
    private float mConfidence;
    private long mDurationMs;
    private int mEvent;
    private float mFrequency;
    private float mSpeed;
    private long mTimestamp;
    private int mTriggerReason;
    private float mValue;

    public static class Builder {
        public int a;
        public float b;
        public float c;
        public int d;
        public float e;
        public float f;
        public long g;
        public long h;

        public Builder() {
        }

        public QshHarEventData build() {
            return new QshHarEventData(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public Builder setConfidence(float r1) {
            this.b = r1;
            return this;
        }

        public Builder setDurationMs(long r1) {
            this.g = r1;
            return this;
        }

        public Builder setEvent(int r1) {
            this.a = r1;
            return this;
        }

        public Builder setFrequency(float r1) {
            this.f = r1;
            return this;
        }

        public Builder setSpeed(float r1) {
            this.e = r1;
            return this;
        }

        public Builder setTimestamp(long r1) {
            this.h = r1;
            return this;
        }

        public Builder setTriggerReason(int r1) {
            this.d = r1;
            return this;
        }

        public Builder setValue(float r1) {
            this.c = r1;
            return this;
        }
    }

    public class a implements Parcelable.Creator<QshHarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventData createFromParcel(Parcel r2) {
            return new QshHarEventData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventData[] newArray(int r1) {
            return new QshHarEventData[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "QshHarEventParcel[event=" + this.mEvent + ", confidence=" + this.mConfidence + ", value=" + this.mValue + ", triggerReason=" + this.mTriggerReason + ", speed=" + this.mSpeed + ", frequency=" + this.mFrequency + ", durationMs=" + this.mDurationMs + ", timestamp=" + this.mTimestamp + ']';
    }

    public QshHarEventData() {
    }

    public float getConfidence() {
        return this.mConfidence;
    }

    public long getDurationMs() {
        return this.mDurationMs;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public float getFrequency() {
        return this.mFrequency;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getTriggerReason() {
        return this.mTriggerReason;
    }

    public float getValue() {
        return this.mValue;
    }

    public QshHarEventData(Parcel r3) {
        this.mEvent = r3.readInt();
        this.mConfidence = r3.readFloat();
        this.mValue = r3.readFloat();
        this.mTriggerReason = r3.readInt();
        this.mSpeed = r3.readFloat();
        this.mFrequency = r3.readFloat();
        this.mDurationMs = r3.readLong();
        this.mTimestamp = r3.readLong();
    }

    public void readFromParcel(Parcel r3) {
        this.mEvent = r3.readInt();
        this.mConfidence = r3.readFloat();
        this.mValue = r3.readFloat();
        this.mTriggerReason = r3.readInt();
        this.mSpeed = r3.readFloat();
        this.mFrequency = r3.readFloat();
        this.mDurationMs = r3.readLong();
        this.mTimestamp = r3.readLong();
    }

    public QshHarEventData(QshHarEventData r3) {
        this.mEvent = r3.getEvent();
        this.mConfidence = r3.getConfidence();
        this.mValue = r3.getValue();
        this.mTriggerReason = r3.getTriggerReason();
        this.mSpeed = r3.getSpeed();
        this.mFrequency = r3.getFrequency();
        this.mDurationMs = r3.getDurationMs();
        this.mTimestamp = r3.getTimestamp();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.mEvent);
        r3.writeFloat(this.mConfidence);
        r3.writeFloat(this.mValue);
        r3.writeInt(this.mTriggerReason);
        r3.writeFloat(this.mSpeed);
        r3.writeFloat(this.mFrequency);
        r3.writeLong(this.mDurationMs);
        r3.writeLong(this.mTimestamp);
    }

    public QshHarEventData(int r1, float r2, float r3, int r4, float r5, float r6, long r7, long r9) {
        this.mEvent = r1;
        this.mConfidence = r2;
        this.mValue = r3;
        this.mTriggerReason = r4;
        this.mSpeed = r5;
        this.mFrequency = r6;
        this.mDurationMs = r7;
        this.mTimestamp = r9;
    }
}
