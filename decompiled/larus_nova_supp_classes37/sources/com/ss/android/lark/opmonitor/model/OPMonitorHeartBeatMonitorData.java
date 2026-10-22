package com.ss.android.lark.opmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class OPMonitorHeartBeatMonitorData implements Parcelable {
    public static final Parcelable.Creator<OPMonitorHeartBeatMonitorData> CREATOR = null;
    public final String a;
    public final String b;
    public int c;
    public int d;

    public class a implements Parcelable.Creator<OPMonitorHeartBeatMonitorData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatMonitorData createFromParcel(Parcel r2) {
            return new OPMonitorHeartBeatMonitorData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatMonitorData[] newArray(int r1) {
            return new OPMonitorHeartBeatMonitorData[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public OPMonitorHeartBeatMonitorData(Parcel r2) {
        this.d = 0;
        this.b = r2.readString();
        this.a = r2.readString();
        this.c = r2.readInt();
        this.d = r2.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.b);
        r1.writeString(this.a);
        r1.writeInt(this.c);
        r1.writeInt(this.d);
    }
}
