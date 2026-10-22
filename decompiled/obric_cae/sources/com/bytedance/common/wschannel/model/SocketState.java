package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3885b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f3886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3890q;

    public static class a implements Parcelable.Creator<SocketState> {
        @Override // android.os.Parcelable.Creator
        public final SocketState createFromParcel(Parcel r8) {
            return new SocketState(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final SocketState[] newArray(int r8) {
            return new SocketState[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public SocketState() {
    }

    public SocketState(Parcel r8) {
        this.f3884a = r8.readInt();
        this.f3885b = r8.readInt();
        this.f3886m = r8.readString();
        this.f3887n = r8.readInt();
        this.f3888o = r8.readInt();
        this.f3889p = r8.readString();
        this.f3890q = r8.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("SocketState{connectionType=");
        r8.append(this.f3884a);
        r8.append(", connectionState=");
        r8.append(this.f3885b);
        r8.append(", connectionUrl='");
        r8.append(this.f3886m);
        r8.append("', channelId=");
        r8.append(this.f3887n);
        r8.append(", channelType=");
        r8.append(this.f3888o);
        r8.append(", error='");
        return android.aimedia.a.i(r8, this.f3889p, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f3884a);
        r8.writeInt(this.f3885b);
        r8.writeString(this.f3886m);
        r8.writeInt(this.f3887n);
        r8.writeInt(this.f3888o);
        r8.writeString(this.f3889p);
        r8.writeInt(this.f3890q);
    }
}
