package vendor.aware.sensorbridge;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class SensorBridgeDelivery implements Parcelable {
    public static final Parcelable.Creator<SensorBridgeDelivery> CREATOR = null;
    public int clientProcessor;
    public int deliveryType;
    public int[] noWakeupMessageIds;

    public class a implements Parcelable.Creator<SensorBridgeDelivery> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeDelivery createFromParcel(Parcel r1) {
            SensorBridgeDelivery r0 = new SensorBridgeDelivery();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeDelivery[] newArray(int r1) {
            return new SensorBridgeDelivery[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorBridgeDelivery() {
        this.clientProcessor = 0;
        this.deliveryType = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r6) {
        int r0 = r6.dataPosition();
        int r1 = r6.readInt();
        if (r1 < 4) goto L36;
        if ((r6.dataPosition() - r0) >= r1) goto L8;
        this.clientProcessor = r6.readInt();     // Catch: Throwable -> L37
        if ((r6.dataPosition() - r0) >= r1) goto L17;
        this.deliveryType = r6.readInt();     // Catch: Throwable -> L37
        if ((r6.dataPosition() - r0) >= r1) goto L25;
        this.noWakeupMessageIds = r6.createIntArray();     // Catch: Throwable -> L37
        if (r0 > (Integer.MAX_VALUE - r1)) goto L34;
    L9:
        r6.setDataPosition(r0 + r1);
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
        r6.setDataPosition(r0 + r1);
        throw th;
    L41:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        int r4 = r2.dataPosition();
        r2.writeInt(0);
        r2.writeInt(this.clientProcessor);
        r2.writeInt(this.deliveryType);
        r2.writeIntArray(this.noWakeupMessageIds);
        int r1 = r2.dataPosition();
        r2.setDataPosition(r4);
        r2.writeInt(r1 - r4);
        r2.setDataPosition(r1);
    }
}
