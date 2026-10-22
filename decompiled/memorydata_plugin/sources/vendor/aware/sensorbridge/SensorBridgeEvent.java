package vendor.aware.sensorbridge;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class SensorBridgeEvent implements Parcelable {
    public static final Parcelable.Creator<SensorBridgeEvent> CREATOR = null;
    public int messageId;
    public byte[] payload;
    public SensorBridgeSensor sensor;
    public int sequence;
    public long timestampTicks;

    public class a implements Parcelable.Creator<SensorBridgeEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeEvent createFromParcel(Parcel r1) {
            SensorBridgeEvent r0 = new SensorBridgeEvent();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeEvent[] newArray(int r1) {
            return new SensorBridgeEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorBridgeEvent() {
        this.messageId = 0;
        this.timestampTicks = 0;
        this.sequence = 0;
    }

    private int describeContents(Object r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Parcelable.class) == true) goto L8;
        return 0;
    L8:
        return ((Parcelable) ZeusTransformUtils.preCheckCast(r2, Parcelable.class, "com.obric.memorydata.plugin")).describeContents();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return describeContents(this.sensor) | 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L56;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        Parcelable.Creator<SensorBridgeSensor> r4 = SensorBridgeSensor.CREATOR;     // Catch: Throwable -> L57
        if (r8.readInt() == 0) goto L16;
        SensorBridgeSensor r5 = r4.createFromParcel(r8);     // Catch: Throwable -> L57
    L17:
        this.sensor = (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(r5, SensorBridgeSensor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        if ((r8.dataPosition() - r0) >= r1) goto L21;
        this.messageId = r8.readInt();     // Catch: Throwable -> L57
        if ((r8.dataPosition() - r0) >= r1) goto L29;
        this.timestampTicks = r8.readLong();     // Catch: Throwable -> L57
        if ((r8.dataPosition() - r0) >= r1) goto L37;
        this.payload = r8.createByteArray();     // Catch: Throwable -> L57
        if ((r8.dataPosition() - r0) >= r1) goto L45;
        this.sequence = r8.readInt();     // Catch: Throwable -> L57
        if (r0 > (Integer.MAX_VALUE - r1)) goto L54;
    L9:
        r8.setDataPosition(r0 + r1);
        return;
    L54:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L45:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L37:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L29:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L21:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L16:
        r5 = null;
        goto L17
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L56:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L61;
        r8.setDataPosition(r0 + r1);
        throw th;
    L61:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        int r0 = r4.dataPosition();
        r4.writeInt(0);
        SensorBridgeSensor r2 = this.sensor;
        if (r2 == null) goto L5;
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
    L6:
        r4.writeInt(this.messageId);
        r4.writeLong(this.timestampTicks);
        r4.writeByteArray(this.payload);
        r4.writeInt(this.sequence);
        int r3 = r4.dataPosition();
        r4.setDataPosition(r0);
        r4.writeInt(r3 - r0);
        r4.setDataPosition(r3);
        return;
    L5:
        r4.writeInt(0);
        goto L6
    }
}
