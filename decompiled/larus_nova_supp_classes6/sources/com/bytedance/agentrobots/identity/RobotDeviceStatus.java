package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RobotDeviceStatus implements Parcelable {
    public static final Parcelable.Creator<RobotDeviceStatus> CREATOR = null;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final byte[] g;
    public final byte[] h;
    public final boolean i;
    public final BootState j;
    public final boolean k;

    public class a implements Parcelable.Creator<RobotDeviceStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RobotDeviceStatus createFromParcel(Parcel r2) {
            return new RobotDeviceStatus(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final RobotDeviceStatus[] newArray(int r1) {
            return new RobotDeviceStatus[r1];
        }
    }

    public RobotDeviceStatus() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotDeviceStatus(Parcel r4) {
        this.a = r4.readInt();
        this.b = r4.readString();
        this.c = r4.readString();
        this.d = r4.readString();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.e = r0;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.f = r2;
        this.g = r4.createByteArray();
        this.h = r4.createByteArray();
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.i = r3;
        String r5 = r4.readString();
        if (r5 == null) goto L17;
        BootState r6 = BootState.valueOf(r5);
    L18:
        this.j = r6;
        if (r4.readByte() != 0) goto L22;
        r1 = false;
    L22:
        this.k = r1;
        return;
    L17:
        r6 = null;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeByte(this.e ? 1 : 0);
        r1.writeByte(this.f ? 1 : 0);
        r1.writeByteArray(this.g);
        r1.writeByteArray(this.h);
        r1.writeByte(this.i ? 1 : 0);
        BootState r3 = this.j;
        if (r3 == null) goto L5;
        String r4 = r3.name();
    L6:
        r1.writeString(r4);
        r1.writeByte(this.k ? 1 : 0);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
