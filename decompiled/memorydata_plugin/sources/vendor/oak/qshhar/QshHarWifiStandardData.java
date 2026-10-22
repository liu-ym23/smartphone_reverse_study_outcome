package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class QshHarWifiStandardData implements Parcelable {
    public static final Parcelable.Creator<QshHarWifiStandardData> CREATOR = null;
    public static final int WIFI_BAND_UNKNOWN = 0;
    public int apStandard;
    public int apType;
    public int authType;
    public int band;
    public String bssid;
    public long dataflow;
    public int frequency;
    public int rssi;
    public int signalLevel;
    public String ssid;
    public long timestamp;
    public long useTime;

    public class a implements Parcelable.Creator<QshHarWifiStandardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarWifiStandardData createFromParcel(Parcel r1) {
            return new QshHarWifiStandardData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarWifiStandardData[] newArray(int r1) {
            return new QshHarWifiStandardData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarWifiStandardData() {
    }

    public QshHarWifiStandardData(Parcel r7) {
        int r0 = r7.readInt();
        int r1 = r7.dataPosition();
        if (r0 < 4) goto L5;
    L51:
        th = move-exception;
        if (r1 > (Integer.MAX_VALUE - r0)) goto L55;
        r7.setDataPosition(r1 + r0);
        throw th;
    L55:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r7.dataPosition() - r1) >= r0) goto L14;
        this.bssid = r7.readString();     // Catch: Throwable -> L51
    L14:
        if ((r7.dataPosition() - r1) >= r0) goto L17;
        this.ssid = r7.readString();     // Catch: Throwable -> L51
    L17:
        if ((r7.dataPosition() - r1) >= r0) goto L20;
        this.signalLevel = r7.readInt();     // Catch: Throwable -> L51
    L20:
        if ((r7.dataPosition() - r1) >= r0) goto L23;
        this.rssi = r7.readInt();     // Catch: Throwable -> L51
    L23:
        if ((r7.dataPosition() - r1) >= r0) goto L26;
        this.frequency = r7.readInt();     // Catch: Throwable -> L51
    L26:
        if ((r7.dataPosition() - r1) >= r0) goto L29;
        this.band = r7.readInt();     // Catch: Throwable -> L51
    L29:
        if ((r7.dataPosition() - r1) >= r0) goto L32;
        this.timestamp = r7.readLong();     // Catch: Throwable -> L51
    L32:
        if ((r7.dataPosition() - r1) >= r0) goto L35;
        this.dataflow = r7.readLong();     // Catch: Throwable -> L51
    L35:
        if ((r7.dataPosition() - r1) >= r0) goto L38;
        this.useTime = r7.readLong();     // Catch: Throwable -> L51
    L38:
        if ((r7.dataPosition() - r1) >= r0) goto L41;
        this.authType = r7.readInt();     // Catch: Throwable -> L51
    L41:
        if ((r7.dataPosition() - r1) >= r0) goto L44;
        this.apType = r7.readInt();     // Catch: Throwable -> L51
    L44:
        if ((r7.dataPosition() - r1) >= r0) goto L47;
        this.apStandard = r7.readInt();     // Catch: Throwable -> L51
    L47:
        if (r1 > (Integer.MAX_VALUE - r0)) goto L50;
    L6:
        r7.setDataPosition(r1 + r0);
        return;
    L50:
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
        r3.writeString(this.bssid);
        r3.writeString(this.ssid);
        r3.writeInt(this.signalLevel);
        r3.writeInt(this.rssi);
        r3.writeInt(this.frequency);
        r3.writeInt(this.band);
        r3.writeLong(this.timestamp);
        r3.writeLong(this.dataflow);
        r3.writeLong(this.useTime);
        r3.writeInt(this.authType);
        r3.writeInt(this.apType);
        r3.writeInt(this.apStandard);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
