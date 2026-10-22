package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class HarMonitorParam implements Parcelable {
    public static final Parcelable.Creator<HarMonitorParam> CREATOR = null;
    public static final int STATE_VOTE_WINDOWS_SIZE = 5;
    public static final int WALKING_CONTINUOUS_THRESHOLD = 2;
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

    public class a implements Parcelable.Creator<HarMonitorParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParam createFromParcel(Parcel r1) {
            return new HarMonitorParam(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParam[] newArray(int r1) {
            return new HarMonitorParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarMonitorParam() {
    }

    public HarMonitorParam(Parcel r6) {
        int r0 = r6.readInt();
        int r1 = r6.dataPosition();
        if (r0 < 4) goto L5;
    L57:
        th = move-exception;
        if (r1 > (Integer.MAX_VALUE - r0)) goto L61;
        r6.setDataPosition(r1 + r0);
        throw th;
    L61:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r6.dataPosition() - r1) >= r0) goto L14;
        this.stateVoteWindowSize = r6.readInt();     // Catch: Throwable -> L57
    L14:
        if ((r6.dataPosition() - r1) >= r0) goto L17;
        this.walkingContinuousThreshold = r6.readInt();     // Catch: Throwable -> L57
    L17:
        if ((r6.dataPosition() - r1) >= r0) goto L20;
        this.runningContinuousThreshold = r6.readInt();     // Catch: Throwable -> L57
    L20:
        if ((r6.dataPosition() - r1) >= r0) goto L23;
        this.accelOccurrenceThreshold = r6.readInt();     // Catch: Throwable -> L57
    L23:
        if ((r6.dataPosition() - r1) >= r0) goto L26;
        this.stationaryOccurrenceThreshold = r6.readInt();     // Catch: Throwable -> L57
    L26:
        if ((r6.dataPosition() - r1) >= r0) goto L29;
        this.accStateDurationThreshold = r6.readInt();     // Catch: Throwable -> L57
    L29:
        if ((r6.dataPosition() - r1) >= r0) goto L32;
        this.accStateMonitorWindow = r6.readInt();     // Catch: Throwable -> L57
    L32:
        if ((r6.dataPosition() - r1) >= r0) goto L35;
        this.accStateDurationThreshold2 = r6.readInt();     // Catch: Throwable -> L57
    L35:
        if ((r6.dataPosition() - r1) >= r0) goto L38;
        this.runningStateDurationThreshold = r6.readInt();     // Catch: Throwable -> L57
    L38:
        if ((r6.dataPosition() - r1) >= r0) goto L41;
        this.runningStateMonitorWindow = r6.readInt();     // Catch: Throwable -> L57
    L41:
        if ((r6.dataPosition() - r1) >= r0) goto L44;
        this.runningStateDurationThreshold2 = r6.readInt();     // Catch: Throwable -> L57
    L44:
        if ((r6.dataPosition() - r1) >= r0) goto L47;
        this.walkingStateMonitorWindow = r6.readInt();     // Catch: Throwable -> L57
    L47:
        if ((r6.dataPosition() - r1) >= r0) goto L50;
        this.walkingStateDurationThreshold = r6.readInt();     // Catch: Throwable -> L57
    L50:
        if ((r6.dataPosition() - r1) >= r0) goto L53;
        this.walkingStateDurationThreshold2 = r6.readInt();     // Catch: Throwable -> L57
    L53:
        if (r1 > (Integer.MAX_VALUE - r0)) goto L56;
    L6:
        r6.setDataPosition(r1 + r0);
        return;
    L56:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L5:
        if (r1 <= (Integer.MAX_VALUE - r0)) goto L6;
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = r2.dataPosition();
        r2.writeInt(0);
        r2.writeInt(this.stateVoteWindowSize);
        r2.writeInt(this.walkingContinuousThreshold);
        r2.writeInt(this.runningContinuousThreshold);
        r2.writeInt(this.accelOccurrenceThreshold);
        r2.writeInt(this.stationaryOccurrenceThreshold);
        r2.writeInt(this.accStateDurationThreshold);
        r2.writeInt(this.accStateMonitorWindow);
        r2.writeInt(this.accStateDurationThreshold2);
        r2.writeInt(this.runningStateDurationThreshold);
        r2.writeInt(this.runningStateMonitorWindow);
        r2.writeInt(this.runningStateDurationThreshold2);
        r2.writeInt(this.walkingStateMonitorWindow);
        r2.writeInt(this.walkingStateDurationThreshold);
        r2.writeInt(this.walkingStateDurationThreshold2);
        int r1 = r2.dataPosition();
        r2.setDataPosition(r4);
        r2.writeInt(r1 - r4);
        r2.setDataPosition(r1);
    }
}
