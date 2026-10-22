package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
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
        public final SensorEventInfo createFromParcel(Parcel r8) {
            return new SensorEventInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final SensorEventInfo[] newArray(int r8) {
            return new SensorEventInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public SensorEventInfo(Parcel r8) {
        this.sensorName = r8.readString();
        this.accuracy = r8.readInt();
        this.timestamp = r8.readLong();
        this.values = r8.createFloatArray();
        this.adspTimeStamp = r8.readLong();
        if (r8.dataAvail() <= 0) goto L5;
        int r10 = r8.readInt();
    L6:
        this.sensorType = r10;
        return;
    L5:
        r10 = 0;
        goto L6
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
        StringBuilder r8 = new StringBuilder("[SensorEventInfo:3, timestamp: ");
        r8.append(this.timestamp);
        r8.append(", sensor: ");
        r8.append(this.sensorName);
        r8.append(", sensorType: ");
        r8.append(this.sensorType);
        r8.append(", values: (");
        StringJoiner r10 = new StringJoiner(", ");
        float[] r11 = this.values;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.add(String.valueOf(r11[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        r8.append(r10);
        r8.append("), accuracy: ");
        r8.append(this.accuracy);
        r8.append(", adspTimeStamp: ");
        r8.append(this.adspTimeStamp);
        r8.append("]");
        return r8.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.sensorName);
        r8.writeInt(this.accuracy);
        r8.writeLong(this.timestamp);
        r8.writeFloatArray(this.values);
        r8.writeLong(this.adspTimeStamp);
        r8.writeInt(this.sensorType);
    }

    public SensorEventInfo(String r8, int r10, int r11, long r12, float[] r13) {
        this.timestamp = System.currentTimeMillis();
        this.sensorName = r8;
        this.sensorType = r10;
        this.accuracy = r11;
        this.adspTimeStamp = r12;
        this.values = r13;
    }
}
