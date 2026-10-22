package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HarEventData implements Parcelable {
    public static final Parcelable.Creator<HarEventData> CREATOR = null;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_CAR = 8;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_CYCLING = 6;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_ELECTRIC_BIKE = 7;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_OTHER = 4;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_RUNNING = 1;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_STATIONARY = 0;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_SUBWAY = 5;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_WALKING = 2;
    private int mEvent;
    private long mTimestamp;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5523b;

        public Builder() {
        }

        public HarEventData build() {
            return new HarEventData(this.f5522a, this.f5523b);
        }

        public Builder setEvent(int r8) {
            this.f5522a = r8;
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.f5523b = r8;
            return this;
        }
    }

    public class a implements Parcelable.Creator<HarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData createFromParcel(Parcel r8) {
            return new HarEventData(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData[] newArray(int r8) {
            return new HarEventData[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarEventData() {
    }

    public HarEventData(int r8, long r10) {
        this.mEvent = r8;
        this.mTimestamp = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void readFromParcel(Parcel r8) {
        this.mEvent = r8.readInt();
        this.mTimestamp = r8.readLong();
    }

    public String toString() {
        return "HarEventData{event=" + this.mEvent + ", timestamp=" + this.mTimestamp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mEvent);
        r8.writeLong(this.mTimestamp);
    }

    public HarEventData(Parcel r8) {
        this.mEvent = r8.readInt();
        this.mTimestamp = r8.readLong();
    }

    public HarEventData(HarEventData r8) {
        this.mEvent = r8.getEvent();
        this.mTimestamp = r8.getTimestamp();
    }
}
