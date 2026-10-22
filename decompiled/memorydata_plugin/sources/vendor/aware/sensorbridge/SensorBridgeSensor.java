package vendor.aware.sensorbridge;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class SensorBridgeSensor implements Parcelable {
    public static final Parcelable.Creator<SensorBridgeSensor> CREATOR = null;
    public String sensorName;
    public long suidHigh;
    public long suidLow;

    public class a implements Parcelable.Creator<SensorBridgeSensor> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeSensor createFromParcel(Parcel r1) {
            SensorBridgeSensor r0 = new SensorBridgeSensor();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeSensor[] newArray(int r1) {
            return new SensorBridgeSensor[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorBridgeSensor() {
        this.suidLow = 0;
        this.suidHigh = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r7) {
        int r0 = r7.dataPosition();
        int r1 = r7.readInt();
        if (r1 < 4) goto L36;
        if ((r7.dataPosition() - r0) >= r1) goto L8;
        this.sensorName = r7.readString();     // Catch: Throwable -> L37
        if ((r7.dataPosition() - r0) >= r1) goto L17;
        this.suidLow = r7.readLong();     // Catch: Throwable -> L37
        if ((r7.dataPosition() - r0) >= r1) goto L25;
        this.suidHigh = r7.readLong();     // Catch: Throwable -> L37
        if (r0 > (Integer.MAX_VALUE - r1)) goto L34;
    L9:
        r7.setDataPosition(r0 + r1);
        return;
    L34:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L36:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L41;
        r7.setDataPosition(r0 + r1);
        throw th;
    L41:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeString(this.sensorName);
        r3.writeLong(this.suidLow);
        r3.writeLong(this.suidHigh);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
