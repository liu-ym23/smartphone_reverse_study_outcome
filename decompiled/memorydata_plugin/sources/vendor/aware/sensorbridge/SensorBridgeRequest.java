package vendor.aware.sensorbridge;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class SensorBridgeRequest implements Parcelable {
    public static final Parcelable.Creator<SensorBridgeRequest> CREATOR = null;
    public SensorBridgeBatch batch;
    public SensorBridgeDelivery delivery;
    public int messageId;
    public boolean passive;
    public byte[] payload;
    public int requestId;
    public int requestScope;
    public SensorBridgeSensor sensor;

    public class a implements Parcelable.Creator<SensorBridgeRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeRequest createFromParcel(Parcel r1) {
            SensorBridgeRequest r0 = new SensorBridgeRequest();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SensorBridgeRequest[] newArray(int r1) {
            return new SensorBridgeRequest[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorBridgeRequest() {
        this.messageId = 0;
        this.requestId = 0;
        this.requestScope = 0;
        this.passive = false;
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
        if (r2 < 4) goto L91;
        if ((r9.dataPosition() - r1) >= r2) goto L8;
        Parcelable.Creator<SensorBridgeSensor> r5 = SensorBridgeSensor.CREATOR;     // Catch: Throwable -> L92
        SensorBridgeBatch r7 = null;
        if (r9.readInt() == 0) goto L15;
        SensorBridgeSensor r6 = r5.createFromParcel(r9);     // Catch: Throwable -> L92
    L16:
        this.sensor = (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(r6, SensorBridgeSensor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) >= r2) goto L20;
        this.messageId = r9.readInt();     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) >= r2) goto L28;
        this.payload = r9.createByteArray();     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) >= r2) goto L36;
        this.requestId = r9.readInt();     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) >= r2) goto L44;
        this.requestScope = r9.readInt();     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) >= r2) goto L52;
        Parcelable.Creator<SensorBridgeDelivery> r8 = SensorBridgeDelivery.CREATOR;     // Catch: Throwable -> L92
        if (r9.readInt() == 0) goto L59;
        SensorBridgeDelivery r10 = r8.createFromParcel(r9);     // Catch: Throwable -> L92
    L60:
        this.delivery = (SensorBridgeDelivery) ZeusTransformUtils.preCheckCast(r10, SensorBridgeDelivery.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) >= r2) goto L64;
        Parcelable.Creator<SensorBridgeBatch> r11 = SensorBridgeBatch.CREATOR;     // Catch: Throwable -> L92
        if (r9.readInt() == 0) goto L71;
        r7 = r11.createFromParcel(r9);     // Catch: Throwable -> L92
    L71:
        this.batch = (SensorBridgeBatch) ZeusTransformUtils.preCheckCast(r7, SensorBridgeBatch.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92
        if ((r9.dataPosition() - r1) < r2) goto L81;
        if (r1 > (Integer.MAX_VALUE - r2)) goto L79;
    L76:
        r9.setDataPosition(r1 + r2);
        return;
    L79:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L81:
        if (r9.readInt() == 0) goto L83;
        boolean r0 = true;
    L84:
        this.passive = r0;     // Catch: Throwable -> L92
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L83:
        r0 = false;
        goto L84
    L64:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L59:
        r10 = null;
        goto L60
    L52:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L44:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L36:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L28:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L20:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L15:
        r6 = null;
        goto L16
    L8:
        if (r1 <= (Integer.MAX_VALUE - r2)) goto L76;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L91:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        if (r1 > (Integer.MAX_VALUE - r2)) goto L96;
        r9.setDataPosition(r1 + r2);
        throw th;
    L96:
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
        r5.writeInt(this.messageId);
        r5.writeByteArray(this.payload);
        r5.writeInt(this.requestId);
        r5.writeInt(this.requestScope);
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
        r5.writeInt(this.passive ? 1 : 0);
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
