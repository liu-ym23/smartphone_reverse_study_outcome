package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class QshHarEventParcel implements Parcelable {
    public static final int ACTIVITY_ALL = 7;
    public static final int ACTIVITY_BIKING = 6;
    public static final int ACTIVITY_DRIVING = 4;
    public static final int ACTIVITY_RUNNING = 3;
    public static final int ACTIVITY_STATIONARY = 1;
    public static final int ACTIVITY_TRANSIT = 5;
    public static final int ACTIVITY_UNKNOWN = 0;
    public static final int ACTIVITY_WALKING = 2;
    public static final Parcelable.Creator<QshHarEventParcel> CREATOR = null;
    public static final int EVENT_TYPE_ALL = 3;
    public static final int EVENT_TYPE_MOTION_OTHER = 2;
    public static final int EVENT_TYPE_MOTION_STATE = 1;
    public float confidence;
    public long duration_ms;
    public int event;
    public float frequency;
    public float speed;
    public long timestamp;
    public int trigger_reason;
    public float value;

    public class a implements Parcelable.Creator<QshHarEventParcel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventParcel createFromParcel(Parcel r1) {
            return new QshHarEventParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventParcel[] newArray(int r1) {
            return new QshHarEventParcel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarEventParcel() {
    }

    public QshHarEventParcel(Parcel r7) {
        int r0 = r7.readInt();
        int r1 = r7.dataPosition();
        if (r0 < 4) goto L5;
    L39:
        th = move-exception;
        if (r1 > (Integer.MAX_VALUE - r0)) goto L43;
        r7.setDataPosition(r1 + r0);
        throw th;
    L43:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r7.dataPosition() - r1) >= r0) goto L14;
        this.event = r7.readInt();     // Catch: Throwable -> L39
    L14:
        if ((r7.dataPosition() - r1) >= r0) goto L17;
        this.confidence = r7.readFloat();     // Catch: Throwable -> L39
    L17:
        if ((r7.dataPosition() - r1) >= r0) goto L20;
        this.value = r7.readFloat();     // Catch: Throwable -> L39
    L20:
        if ((r7.dataPosition() - r1) >= r0) goto L23;
        this.trigger_reason = r7.readInt();     // Catch: Throwable -> L39
    L23:
        if ((r7.dataPosition() - r1) >= r0) goto L26;
        this.speed = r7.readFloat();     // Catch: Throwable -> L39
    L26:
        if ((r7.dataPosition() - r1) >= r0) goto L29;
        this.frequency = r7.readFloat();     // Catch: Throwable -> L39
    L29:
        if ((r7.dataPosition() - r1) >= r0) goto L32;
        this.duration_ms = r7.readLong();     // Catch: Throwable -> L39
    L32:
        if ((r7.dataPosition() - r1) >= r0) goto L35;
        this.timestamp = r7.readLong();     // Catch: Throwable -> L39
    L35:
        if (r1 > (Integer.MAX_VALUE - r0)) goto L38;
    L6:
        r7.setDataPosition(r1 + r0);
        return;
    L38:
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
    public void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeInt(this.event);
        r3.writeFloat(this.confidence);
        r3.writeFloat(this.value);
        r3.writeInt(this.trigger_reason);
        r3.writeFloat(this.speed);
        r3.writeFloat(this.frequency);
        r3.writeLong(this.duration_ms);
        r3.writeLong(this.timestamp);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
