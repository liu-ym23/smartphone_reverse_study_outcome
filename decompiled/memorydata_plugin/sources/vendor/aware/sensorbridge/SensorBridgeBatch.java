package vendor.aware.sensorbridge;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class SensorBridgeBatch implements Parcelable {
    public static final Parcelable.Creator<SensorBridgeBatch> CREATOR = null;
    public int batchPeriodUs;
    public boolean flushOnly;
    public int flushPeriodUs;
    public boolean maxBatch;

    public class a implements Parcelable.Creator<SensorBridgeBatch> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeBatch createFromParcel(Parcel r1) {
            SensorBridgeBatch r0 = new SensorBridgeBatch();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeBatch[] newArray(int r1) {
            return new SensorBridgeBatch[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorBridgeBatch() {
        this.batchPeriodUs = 0;
        this.flushPeriodUs = 0;
        this.flushOnly = false;
        this.maxBatch = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L52;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.batchPeriodUs = r8.readInt();     // Catch: Throwable -> L53
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.flushPeriodUs = r8.readInt();     // Catch: Throwable -> L53
        if ((r8.dataPosition() - r0) >= r1) goto L25;
        boolean r5 = true;
        if (r8.readInt() == 0) goto L32;
        boolean r4 = true;
    L33:
        this.flushOnly = r4;     // Catch: Throwable -> L53
        if ((r8.dataPosition() - r0) < r1) goto L42;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L40;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L40:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L42:
        if (r8.readInt() != 0) goto L45;
        r5 = false;
    L45:
        this.maxBatch = r5;     // Catch: Throwable -> L53
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L32:
        r4 = false;
        goto L33
    L25:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L52:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L57;
        r8.setDataPosition(r0 + r1);
        throw th;
    L57:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        int r4 = r2.dataPosition();
        r2.writeInt(0);
        r2.writeInt(this.batchPeriodUs);
        r2.writeInt(this.flushPeriodUs);
        r2.writeInt(this.flushOnly ? 1 : 0);
        r2.writeInt(this.maxBatch ? 1 : 0);
        int r1 = r2.dataPosition();
        r2.setDataPosition(r4);
        r2.writeInt(r1 - r4);
        r2.setDataPosition(r1);
    }
}
