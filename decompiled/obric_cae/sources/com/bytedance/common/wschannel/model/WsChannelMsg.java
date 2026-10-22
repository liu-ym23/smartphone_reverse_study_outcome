package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final WsChannelMsg f3903u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3905b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<MsgHeader> f3908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f3910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f3911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ComponentName f3912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3913t;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3915b;

        public static class a implements Parcelable.Creator<MsgHeader> {
            @Override // android.os.Parcelable.Creator
            public final MsgHeader createFromParcel(Parcel r8) {
                MsgHeader r10 = new MsgHeader();
                r10.f3914a = r8.readString();
                r10.f3915b = r8.readString();
                return r10;
            }

            @Override // android.os.Parcelable.Creator
            public final MsgHeader[] newArray(int r8) {
                return new MsgHeader[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("MsgHeader{key='");
            r8.append(this.f3914a);
            r8.append("', value='");
            return android.aimedia.a.i(r8, this.f3915b, "'}");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeString(this.f3914a);
            r8.writeString(this.f3915b);
        }
    }

    public static class a implements Parcelable.Creator<WsChannelMsg> {
        @Override // android.os.Parcelable.Creator
        public final WsChannelMsg createFromParcel(Parcel r8) {
            return new WsChannelMsg(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final WsChannelMsg[] newArray(int r8) {
            return new WsChannelMsg[r8];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f3917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3920e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f3921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f3922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f3923h;

        public b() {
            this.f3917b = new HashMap();
            this.f3922g = "";
            this.f3923h = "";
            this.f3916a = Integer.MAX_VALUE;
        }
    }

    static {
        CREATOR = new a();
        f3903u = new WsChannelMsg();
    }

    @Deprecated
    public WsChannelMsg() {
    }

    public WsChannelMsg(int r8, long r10, int r11, int r12, ArrayList r13, String r14, String r15, byte[] r16) {
        this.f3913t = r8;
        this.f3904a = 0;
        this.f3905b = r10;
        this.f3906m = r11;
        this.f3907n = r12;
        this.f3908o = r13;
        this.f3909p = r14;
        this.f3910q = r15;
        this.f3911r = r16;
        this.f3912s = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "WsChannelMsg{, channelId = " + this.f3913t + ", logId=" + this.f3905b + ", service=" + this.f3906m + ", method=" + this.f3907n + ", msgHeaders=" + this.f3908o + ", payloadEncoding='" + this.f3909p + "', payloadType='" + this.f3910q + "', payload=" + Arrays.toString(this.f3911r) + ", replayToComponentName=" + this.f3912s + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.f3904a);
        r8.writeLong(this.f3905b);
        r8.writeInt(this.f3906m);
        r8.writeInt(this.f3907n);
        r8.writeTypedList(this.f3908o);
        r8.writeString(this.f3909p);
        r8.writeString(this.f3910q);
        r8.writeByteArray(this.f3911r);
        r8.writeParcelable(this.f3912s, r10);
        r8.writeInt(this.f3913t);
    }

    public WsChannelMsg(Parcel r8) {
        this.f3904a = r8.readLong();
        this.f3905b = r8.readLong();
        this.f3906m = r8.readInt();
        this.f3907n = r8.readInt();
        this.f3908o = r8.createTypedArrayList(MsgHeader.CREATOR);
        this.f3909p = r8.readString();
        this.f3910q = r8.readString();
        this.f3911r = r8.createByteArray();
        this.f3912s = (ComponentName) r8.readParcelable(ComponentName.class.getClassLoader());
        this.f3913t = r8.readInt();
    }
}
