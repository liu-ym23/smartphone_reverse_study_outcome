package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class UnifiedDataPacket implements Parcelable {
    public static final Parcelable.Creator<UnifiedDataPacket> CREATOR = null;
    public static final int TYPE_BT = 2;
    public static final int TYPE_CELL = 3;
    public static final int TYPE_GNSS = 5;
    public static final int TYPE_LOCATION = 4;
    public static final int TYPE_SENSOR = 6;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WIFI = 1;
    private Parcelable data;
    private final int dataType;

    public class a implements Parcelable.Creator<UnifiedDataPacket> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UnifiedDataPacket createFromParcel(Parcel r8) {
            return new UnifiedDataPacket(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final UnifiedDataPacket[] newArray(int r8) {
            return new UnifiedDataPacket[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public UnifiedDataPacket(Parcel r8) {
        int r10 = r8.readInt();
        this.dataType = r10;
        switch(r10) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L13;
        };
    L5:
        Class r11 = SensorEventInfo.class;
    L11:
        this.data = r8.readParcelable(r11.getClassLoader());
        return;
    L6:
        r11 = GnssSvAwareInfo.class;
        goto L11
    L7:
        r11 = LocationAwareInfo.class;
        goto L11
    L8:
        r11 = CellAwareInfo.class;
        goto L11
    L9:
        r11 = BtAwareInfo.class;
        goto L11
    L10:
        r11 = WifiStandardData.class;
        goto L11
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends Parcelable> T getData() {
        return (T) this.data;
    }

    public int getDataType() {
        return this.dataType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.dataType);
        r8.writeParcelable(this.data, r10);
    }

    public UnifiedDataPacket(Parcelable r8) {
        this.data = r8;
        if ((r8 instanceof WifiStandardData) == false) goto L7;
        int r10 = 1;
    L5:
        this.dataType = r10;
        return;
    L7:
        if ((r8 instanceof BtAwareInfo) == false) goto L10;
        r10 = 2;
        goto L5
    L10:
        if ((r8 instanceof CellAwareInfo) == false) goto L13;
        r10 = 3;
        goto L5
    L13:
        if ((r8 instanceof LocationAwareInfo) == false) goto L16;
        r10 = 4;
        goto L5
    L16:
        if ((r8 instanceof GnssSvAwareInfo) == false) goto L19;
        r10 = 5;
        goto L5
    L19:
        if ((r8 instanceof SensorEventInfo) == false) goto L21;
        r10 = 6;
        goto L5
    L21:
        r10 = 0;
        goto L5
    }
}
