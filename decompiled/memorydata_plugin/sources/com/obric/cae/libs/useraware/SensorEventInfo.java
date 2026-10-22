package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes3.dex */
public class SensorEventInfo implements Parcelable {
    public static final Parcelable.Creator<SensorEventInfo> CREATOR = null;
    private static final int VERSION = 3;
    private final int accuracy;
    private final long adspTimeStamp;
    private final String sensorName;
    private final int sensorType;
    private final long timestamp;
    private final float[] values;

    public class a implements Parcelable.Creator<SensorEventInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SensorEventInfo createFromParcel(Parcel r1) {
            return new SensorEventInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final SensorEventInfo[] newArray(int r1) {
            return new SensorEventInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorEventInfo(Parcel r3) {
        this.sensorName = r3.readString();
        this.accuracy = r3.readInt();
        this.timestamp = r3.readLong();
        this.values = r3.createFloatArray();
        this.adspTimeStamp = r3.readLong();
        if (r3.dataAvail() <= 0) goto L5;
        int r4 = r3.readInt();
    L6:
        this.sensorType = r4;
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public SensorEventInfo(String r3, int r4, int r5, long r6, float[] r8) {
        this.timestamp = System.currentTimeMillis();
        this.sensorName = r3;
        this.sensorType = r4;
        this.accuracy = r5;
        this.adspTimeStamp = r6;
        this.values = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public long getAdspTimeStamp() {
        return this.adspTimeStamp;
    }

    public String getSensorName() {
        return this.sensorName;
    }

    public int getSensorType() {
        return this.sensorType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public float[] getValues() {
        return this.values;
    }

    public int getVersion() {
        return 3;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[SensorEventInfo:3, timestamp: ");
        r0.append(this.timestamp).append(", sensor: ").append(this.sensorName).append(", sensorType: ").append(this.sensorType).append(", values: (");
        StringJoiner r1 = new StringJoiner(", ");
        float[] r2 = this.values;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        r1.add(String.valueOf(r2[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        r0.append(r1);
        r0.append("), accuracy: ").append(this.accuracy);
        r0.append(", adspTimeStamp: ").append(this.adspTimeStamp).append("]");
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.sensorName);
        r3.writeInt(this.accuracy);
        r3.writeLong(this.timestamp);
        r3.writeFloatArray(this.values);
        r3.writeLong(this.adspTimeStamp);
        r3.writeInt(this.sensorType);
    }
}
