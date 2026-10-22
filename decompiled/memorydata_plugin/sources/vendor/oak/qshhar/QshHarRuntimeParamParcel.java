package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class QshHarRuntimeParamParcel implements Parcelable {
    public static final Parcelable.Creator<QshHarRuntimeParamParcel> CREATOR = null;
    public static final int POWER_MODE_HIGH_PERF = 2;
    public static final int POWER_MODE_LOW = 1;
    public static final int POWER_MODE_NORMAL = 0;
    public int confidence_threshold;
    public int power_mode;
    public int sample_rate_hz;

    public class a implements Parcelable.Creator<QshHarRuntimeParamParcel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamParcel createFromParcel(Parcel r1) {
            return new QshHarRuntimeParamParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamParcel[] newArray(int r1) {
            return new QshHarRuntimeParamParcel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarRuntimeParamParcel() {
    }

    public QshHarRuntimeParamParcel(Parcel r6) {
        int r0 = r6.readInt();
        int r1 = r6.dataPosition();
        if (r0 < 4) goto L5;
    L24:
        th = move-exception;
        if (r1 > (Integer.MAX_VALUE - r0)) goto L28;
        r6.setDataPosition(r1 + r0);
        throw th;
    L28:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r6.dataPosition() - r1) >= r0) goto L14;
        this.sample_rate_hz = r6.readInt();     // Catch: Throwable -> L24
    L14:
        if ((r6.dataPosition() - r1) >= r0) goto L17;
        this.confidence_threshold = r6.readInt();     // Catch: Throwable -> L24
    L17:
        if ((r6.dataPosition() - r1) >= r0) goto L20;
        this.power_mode = r6.readInt();     // Catch: Throwable -> L24
    L20:
        if (r1 > (Integer.MAX_VALUE - r0)) goto L23;
    L6:
        r6.setDataPosition(r1 + r0);
        return;
    L23:
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
        r2.writeInt(this.sample_rate_hz);
        r2.writeInt(this.confidence_threshold);
        r2.writeInt(this.power_mode);
        int r1 = r2.dataPosition();
        r2.setDataPosition(r4);
        r2.writeInt(r1 - r4);
        r2.setDataPosition(r1);
    }
}
