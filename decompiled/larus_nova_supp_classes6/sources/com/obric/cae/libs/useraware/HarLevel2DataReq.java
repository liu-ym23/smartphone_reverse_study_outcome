package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class HarLevel2DataReq implements Parcelable {
    public static final Parcelable.Creator<HarLevel2DataReq> CREATOR = null;
    public static final int TYPE_BT = 2;
    public static final int TYPE_CELL = 3;
    public static final int TYPE_LOCATION = 4;
    public static final int TYPE_SENSOR = 5;
    public static final int TYPE_WIFI = 1;
    private final int count;
    private final int interval;
    private final int requestType;
    private final int timeout;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int getCount() {
        return this.count;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public HarLevel2DataReq(Parcel r2) {
        this.requestType = r2.readInt();
        this.count = r2.readInt();
        this.interval = r2.readInt();
        this.timeout = r2.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.requestType);
        r1.writeInt(this.count);
        r1.writeInt(this.interval);
        r1.writeInt(this.timeout);
    }

    public HarLevel2DataReq(int r1, int r2, int r3, int r4) {
        this.requestType = r1;
        this.count = r2;
        this.interval = r3;
        this.timeout = r4;
    }
}
