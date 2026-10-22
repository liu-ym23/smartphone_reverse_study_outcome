package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public HarMonitorParams(Parcel r2) {
        this.stateVoteWindowSize = r2.readInt();
        this.walkingContinuousThreshold = r2.readInt();
        this.runningContinuousThreshold = r2.readInt();
        this.accelOccurrenceThreshold = r2.readInt();
        this.stationaryOccurrenceThreshold = r2.readInt();
        this.accStateDurationThreshold = r2.readInt();
        this.accStateMonitorWindow = r2.readInt();
        this.accStateDurationThreshold2 = r2.readInt();
        this.runningStateDurationThreshold = r2.readInt();
        this.runningStateMonitorWindow = r2.readInt();
        this.runningStateDurationThreshold2 = r2.readInt();
        this.walkingStateMonitorWindow = r2.readInt();
        this.walkingStateDurationThreshold = r2.readInt();
        this.walkingStateDurationThreshold2 = r2.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.stateVoteWindowSize);
        r1.writeInt(this.walkingContinuousThreshold);
        r1.writeInt(this.runningContinuousThreshold);
        r1.writeInt(this.accelOccurrenceThreshold);
        r1.writeInt(this.stationaryOccurrenceThreshold);
        r1.writeInt(this.accStateDurationThreshold);
        r1.writeInt(this.accStateMonitorWindow);
        r1.writeInt(this.accStateDurationThreshold2);
        r1.writeInt(this.runningStateDurationThreshold);
        r1.writeInt(this.runningStateMonitorWindow);
        r1.writeInt(this.runningStateDurationThreshold2);
        r1.writeInt(this.walkingStateMonitorWindow);
        r1.writeInt(this.walkingStateDurationThreshold);
        r1.writeInt(this.walkingStateDurationThreshold2);
    }
}
