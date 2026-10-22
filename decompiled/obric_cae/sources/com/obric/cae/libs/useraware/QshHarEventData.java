package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f5538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f5539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f5541e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f5542f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f5543g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f5544h;

        public Builder() {
        }

        public QshHarEventData build() {
            return new QshHarEventData(this.f5537a, this.f5538b, this.f5539c, this.f5540d, this.f5541e, this.f5542f, this.f5543g, this.f5544h);
        }

        public Builder setConfidence(float r8) {
            this.f5538b = r8;
            return this;
        }

        public Builder setDurationMs(long r8) {
            this.f5543g = r8;
            return this;
        }

        public Builder setEvent(int r8) {
            this.f5537a = r8;
            return this;
        }

        public Builder setFrequency(float r8) {
            this.f5542f = r8;
            return this;
        }

        public Builder setSpeed(float r8) {
            this.f5541e = r8;
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.f5544h = r8;
            return this;
        }

        public Builder setTriggerReason(int r8) {
            this.f5540d = r8;
            return this;
        }

        public Builder setValue(float r8) {
            this.f5539c = r8;
            return this;
        }
    }

    public class a implements Parcelable.Creator<QshHarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventData createFromParcel(Parcel r8) {
            return new QshHarEventData(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventData[] newArray(int r8) {
            return new QshHarEventData[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarEventData() {
    }

    public QshHarEventData(int r8, float r10, float r11, int r12, float r13, float r14, long r15, long r16) {
        this.mEvent = r8;
        this.mConfidence = r10;
        this.mValue = r11;
        this.mTriggerReason = r12;
        this.mSpeed = r13;
        this.mFrequency = r14;
        this.mDurationMs = r15;
        this.mTimestamp = r16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public void readFromParcel(Parcel r8) {
        this.mEvent = r8.readInt();
        this.mConfidence = r8.readFloat();
        this.mValue = r8.readFloat();
        this.mTriggerReason = r8.readInt();
        this.mSpeed = r8.readFloat();
        this.mFrequency = r8.readFloat();
        this.mDurationMs = r8.readLong();
        this.mTimestamp = r8.readLong();
    }

    public String toString() {
        return "QshHarEventParcel[event=" + this.mEvent + ", confidence=" + this.mConfidence + ", value=" + this.mValue + ", triggerReason=" + this.mTriggerReason + ", speed=" + this.mSpeed + ", frequency=" + this.mFrequency + ", durationMs=" + this.mDurationMs + ", timestamp=" + this.mTimestamp + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mEvent);
        r8.writeFloat(this.mConfidence);
        r8.writeFloat(this.mValue);
        r8.writeInt(this.mTriggerReason);
        r8.writeFloat(this.mSpeed);
        r8.writeFloat(this.mFrequency);
        r8.writeLong(this.mDurationMs);
        r8.writeLong(this.mTimestamp);
    }

    public QshHarEventData(Parcel r8) {
        this.mEvent = r8.readInt();
        this.mConfidence = r8.readFloat();
        this.mValue = r8.readFloat();
        this.mTriggerReason = r8.readInt();
        this.mSpeed = r8.readFloat();
        this.mFrequency = r8.readFloat();
        this.mDurationMs = r8.readLong();
        this.mTimestamp = r8.readLong();
    }

    public QshHarEventData(QshHarEventData r8) {
        this.mEvent = r8.getEvent();
        this.mConfidence = r8.getConfidence();
        this.mValue = r8.getValue();
        this.mTriggerReason = r8.getTriggerReason();
        this.mSpeed = r8.getSpeed();
        this.mFrequency = r8.getFrequency();
        this.mDurationMs = r8.getDurationMs();
        this.mTimestamp = r8.getTimestamp();
    }
}
