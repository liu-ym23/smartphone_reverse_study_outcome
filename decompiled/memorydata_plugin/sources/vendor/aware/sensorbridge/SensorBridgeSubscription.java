package vendor.aware.sensorbridge;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class SensorBridgeSubscription implements Parcelable {
    public static final Parcelable.Creator<SensorBridgeSubscription> CREATOR = null;
    public SensorBridgeBatch batch;
    public SensorBridgeDelivery delivery;
    public int[] eventMessageIds;
    public byte[] payload;
    public SensorBridgeSensor sensor;

    public class a implements Parcelable.Creator<SensorBridgeSubscription> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeSubscription createFromParcel(Parcel r1) {
            SensorBridgeSubscription r0 = new SensorBridgeSubscription();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeSubscription[] newArray(int r1) {
            return new SensorBridgeSubscription[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorBridgeSubscription() {
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
        int r0 = (describeContents(this.sensor) | 0) | describeContents(this.delivery);
        return describeContents(this.batch) | r0;
    }

    public final void readFromParcel(Parcel r9) {
        int r1 = r9.dataPosition();
        int r2 = r9.readInt();
        if (r2 < 4) goto L63;
        if ((r9.dataPosition() - r1) >= r2) goto L8;
        Parcelable.Creator<SensorBridgeSensor> r5 = SensorBridgeSensor.CREATOR;     // Catch: Throwable -> L64
        SensorBridgeBatch r7 = null;
        if (r9.readInt() == 0) goto L16;
        SensorBridgeSensor r6 = r5.createFromParcel(r9);     // Catch: Throwable -> L64
    L17:
        this.sensor = (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(r6, SensorBridgeSensor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if ((r9.dataPosition() - r1) >= r2) goto L21;
        this.eventMessageIds = r9.createIntArray();     // Catch: Throwable -> L64
        if ((r9.dataPosition() - r1) >= r2) goto L29;
        Parcelable.Creator<SensorBridgeDelivery> r8 = SensorBridgeDelivery.CREATOR;     // Catch: Throwable -> L64
        if (r9.readInt() == 0) goto L36;
        SensorBridgeDelivery r10 = r8.createFromParcel(r9);     // Catch: Throwable -> L64
    L37:
        this.delivery = (SensorBridgeDelivery) ZeusTransformUtils.preCheckCast(r10, SensorBridgeDelivery.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if ((r9.dataPosition() - r1) >= r2) goto L41;
        Parcelable.Creator<SensorBridgeBatch> r11 = SensorBridgeBatch.CREATOR;     // Catch: Throwable -> L64
        if (r9.readInt() == 0) goto L48;
        r7 = r11.createFromParcel(r9);     // Catch: Throwable -> L64
    L48:
        this.batch = (SensorBridgeBatch) ZeusTransformUtils.preCheckCast(r7, SensorBridgeBatch.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if ((r9.dataPosition() - r1) >= r2) goto L52;
        this.payload = r9.createByteArray();     // Catch: Throwable -> L64
        if (r1 > (Integer.MAX_VALUE - r2)) goto L61;
    L9:
        r9.setDataPosition(r1 + r2);
        return;
    L61:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L52:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L36:
        r10 = null;
        goto L37
    L29:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L21:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L16:
        r6 = null;
        goto L17
    L8:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L63:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        if (r1 > (Integer.MAX_VALUE - r2)) goto L68;
        r9.setDataPosition(r1 + r2);
        throw th;
    L68:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        int r0 = r5.dataPosition();
        r5.writeInt(0);
        SensorBridgeSensor r2 = this.sensor;
        if (r2 == null) goto L5;
        r5.writeInt(1);
        r2.writeToParcel(r5, r6);
    L6:
        r5.writeIntArray(this.eventMessageIds);
        SensorBridgeDelivery r3 = this.delivery;
        if (r3 == null) goto L9;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
    L10:
        SensorBridgeBatch r4 = this.batch;
        if (r4 == null) goto L13;
        r5.writeInt(1);
        r4.writeToParcel(r5, r6);
    L14:
        r5.writeByteArray(this.payload);
        int r7 = r5.dataPosition();
        r5.setDataPosition(r0);
        r5.writeInt(r7 - r0);
        r5.setDataPosition(r7);
        return;
    L13:
        r5.writeInt(0);
        goto L14
    L9:
        r5.writeInt(0);
        goto L10
    L5:
        r5.writeInt(0);
        goto L6
    }
}
