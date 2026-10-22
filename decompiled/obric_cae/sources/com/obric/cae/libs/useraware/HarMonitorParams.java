package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HarMonitorParams implements Parcelable {
    public static final Parcelable.Creator<HarMonitorParams> CREATOR = null;
    public int accStateDurationThreshold;
    public int accStateDurationThreshold2;
    public int accStateMonitorWindow;
    public int accelOccurrenceThreshold;
    public int runningContinuousThreshold;
    public int runningStateDurationThreshold;
    public int runningStateDurationThreshold2;
    public int runningStateMonitorWindow;
    public int stateVoteWindowSize;
    public int stationaryOccurrenceThreshold;
    public int walkingContinuousThreshold;
    public int walkingStateDurationThreshold;
    public int walkingStateDurationThreshold2;
    public int walkingStateMonitorWindow;

    public class a implements Parcelable.Creator<HarMonitorParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParams createFromParcel(Parcel r8) {
            return new HarMonitorParams(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParams[] newArray(int r8) {
            return new HarMonitorParams[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarMonitorParams() {
        this.stateVoteWindowSize = 5;
        this.walkingContinuousThreshold = 2;
        this.runningContinuousThreshold = 3;
        this.accelOccurrenceThreshold = 4;
        this.stationaryOccurrenceThreshold = 3;
        this.accStateDurationThreshold = 10;
        this.accStateMonitorWindow = 15;
        this.accStateDurationThreshold2 = 12;
        this.runningStateDurationThreshold = 10;
        this.runningStateMonitorWindow = 15;
        this.runningStateDurationThreshold2 = 12;
        this.walkingStateMonitorWindow = 15;
        this.walkingStateDurationThreshold = 10;
        this.walkingStateDurationThreshold2 = 12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.stateVoteWindowSize);
        r8.writeInt(this.walkingContinuousThreshold);
        r8.writeInt(this.runningContinuousThreshold);
        r8.writeInt(this.accelOccurrenceThreshold);
        r8.writeInt(this.stationaryOccurrenceThreshold);
        r8.writeInt(this.accStateDurationThreshold);
        r8.writeInt(this.accStateMonitorWindow);
        r8.writeInt(this.accStateDurationThreshold2);
        r8.writeInt(this.runningStateDurationThreshold);
        r8.writeInt(this.runningStateMonitorWindow);
        r8.writeInt(this.runningStateDurationThreshold2);
        r8.writeInt(this.walkingStateMonitorWindow);
        r8.writeInt(this.walkingStateDurationThreshold);
        r8.writeInt(this.walkingStateDurationThreshold2);
    }

    public HarMonitorParams(Parcel r8) {
        this.stateVoteWindowSize = r8.readInt();
        this.walkingContinuousThreshold = r8.readInt();
        this.runningContinuousThreshold = r8.readInt();
        this.accelOccurrenceThreshold = r8.readInt();
        this.stationaryOccurrenceThreshold = r8.readInt();
        this.accStateDurationThreshold = r8.readInt();
        this.accStateMonitorWindow = r8.readInt();
        this.accStateDurationThreshold2 = r8.readInt();
        this.runningStateDurationThreshold = r8.readInt();
        this.runningStateMonitorWindow = r8.readInt();
        this.runningStateDurationThreshold2 = r8.readInt();
        this.walkingStateMonitorWindow = r8.readInt();
        this.walkingStateDurationThreshold = r8.readInt();
        this.walkingStateDurationThreshold2 = r8.readInt();
    }
}
