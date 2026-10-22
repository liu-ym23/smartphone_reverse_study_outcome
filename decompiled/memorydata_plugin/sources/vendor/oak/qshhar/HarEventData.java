package vendor.oak.qshhar;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class HarEventData implements Parcelable {
    public static final Parcelable.Creator<HarEventData> CREATOR = null;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_STATIONARY = 0;
    public int event;
    public long timestamp;

    public class a implements Parcelable.Creator<HarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData createFromParcel(Parcel r1) {
            return new HarEventData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData[] newArray(int r1) {
            return new HarEventData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarEventData() {
    }

    public HarEventData(Parcel r5) {
        int r0 = r5.readInt();
        int r1 = r5.dataPosition();
        if ((r5.dataPosition() - r1) >= r0) goto L6;
        this.event = r5.readInt();
    L6:
        if ((r5.dataPosition() - r1) >= r0) goto L8;
        this.timestamp = r5.readLong();
    L8:
        r5.setDataPosition(r1 + r0);
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
        r3.writeLong(this.timestamp);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
