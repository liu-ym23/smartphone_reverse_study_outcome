package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
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

    public class a implements Parcelable.Creator<HarLevel2DataReq> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarLevel2DataReq createFromParcel(Parcel r8) {
            return new HarLevel2DataReq(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final HarLevel2DataReq[] newArray(int r8) {
            return new HarLevel2DataReq[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarLevel2DataReq(int r8, int r10, int r11, int r12) {
        this.requestType = r8;
        this.count = r10;
        this.interval = r11;
        this.timeout = r12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.requestType);
        r8.writeInt(this.count);
        r8.writeInt(this.interval);
        r8.writeInt(this.timeout);
    }

    public HarLevel2DataReq(Parcel r8) {
        this.requestType = r8.readInt();
        this.count = r8.readInt();
        this.interval = r8.readInt();
        this.timeout = r8.readInt();
    }
}
