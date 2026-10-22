package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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
        public final UnifiedDataPacket createFromParcel(Parcel r1) {
            return new UnifiedDataPacket(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final UnifiedDataPacket[] newArray(int r1) {
            return new UnifiedDataPacket[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UnifiedDataPacket(Parcel r2) {
        int r0 = r2.readInt();
        this.dataType = r0;
        switch(r0) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L13;
        };
    L5:
        Class r1 = SensorEventInfo.class;
    L11:
        this.data = r2.readParcelable(r1.getClassLoader());
        return;
    L6:
        r1 = GnssSvAwareInfo.class;
        goto L11
    L7:
        r1 = LocationAwareInfo.class;
        goto L11
    L8:
        r1 = CellAwareInfo.class;
        goto L11
    L9:
        r1 = BtAwareInfo.class;
        goto L11
    L10:
        r1 = WifiStandardData.class;
        goto L11
    }

    public UnifiedDataPacket(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        this.data = r4;
        if (ZeusTransformUtils.instanceOf(r4, WifiStandardData.class) == false) goto L7;
        int r5 = 1;
    L5:
        this.dataType = r5;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, BtAwareInfo.class) == false) goto L10;
        r5 = 2;
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r4, CellAwareInfo.class) == false) goto L13;
        r5 = 3;
        goto L5
    L13:
        if (ZeusTransformUtils.instanceOf(r4, LocationAwareInfo.class) == false) goto L16;
        r5 = 4;
        goto L5
    L16:
        if (ZeusTransformUtils.instanceOf(r4, GnssSvAwareInfo.class) == false) goto L19;
        r5 = 5;
        goto L5
    L19:
        if (ZeusTransformUtils.instanceOf(r4, SensorEventInfo.class) == false) goto L21;
        r5 = 6;
        goto L5
    L21:
        r5 = 0;
        goto L5
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
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.dataType);
        r2.writeParcelable(this.data, r3);
    }
}
