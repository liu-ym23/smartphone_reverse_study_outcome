package com.ss.android.lark.opmonitor.config;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class OPMonitorHeartBeatConfig implements Parcelable {
    public static final Parcelable.Creator<OPMonitorHeartBeatConfig> CREATOR = null;
    public int a;
    public boolean b;
    public int c;

    public class a implements Parcelable.Creator<OPMonitorHeartBeatConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatConfig createFromParcel(Parcel r2) {
            return new OPMonitorHeartBeatConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OPMonitorHeartBeatConfig[] newArray(int r1) {
            return new OPMonitorHeartBeatConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.a), Boolean.valueOf(this.b), Integer.valueOf(this.c)});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "OPMonitorHeartBeatConfig{heartBeatInterval=" + this.a + ", enableHeartBeatMonitor=" + this.b + ", maxReportCount=" + this.c + '}';
    }

    public OPMonitorHeartBeatConfig() {
        this.c = 240;
    }

    public OPMonitorHeartBeatConfig(Parcel r3) {
        this.c = 240;
        this.a = r3.readInt();
        boolean r1 = true;
        if (r3.readInt() == 1) goto L6;
        r1 = false;
    L6:
        this.b = r1;
        this.c = r3.readInt();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        OPMonitorHeartBeatConfig r6 = (OPMonitorHeartBeatConfig) r5;
        if (this.a == r6.a) goto L13;
    L17:
        return false;
    L13:
        if (this.b != r6.b) goto L17;
        if (this.c != r6.c) goto L17;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a);
        if (this.b == false) goto L5;
        r1.writeInt(1);
    L6:
        r1.writeInt(this.c);
        return;
    L5:
        r1.writeInt(0);
        goto L6
    }
}
