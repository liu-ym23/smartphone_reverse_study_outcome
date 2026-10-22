package com.ss.ugc.live.sdk.platform.network.ws.base;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LiveWsMessage implements Parcelable {
    public static final Parcelable.Creator<LiveWsMessage> CREATOR = null;
    public final long a;
    public final long b;
    public final int c;
    public final int d;
    public final List<MsgHeader> e;
    public final String f;
    public final String g;
    public byte[] h;
    public final ComponentName i;
    public final int j;
    public final int k;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;
        public String a;
        public String b;

        public static class a implements Parcelable.Creator<MsgHeader> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MsgHeader createFromParcel(Parcel r3) {
                MsgHeader r0 = new MsgHeader();
                r0.a = r3.readString();
                r0.b = r3.readString();
                return r0;
            }

            @Override // android.os.Parcelable.Creator
            public final MsgHeader[] newArray(int r1) {
                return new MsgHeader[r1];
            }
        }

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "MsgHeader{key='" + this.a + "', value='" + this.b + "'}";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.a);
            r1.writeString(this.b);
        }
    }

    public static class a implements Parcelable.Creator<LiveWsMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LiveWsMessage createFromParcel(Parcel r2) {
            return new LiveWsMessage(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LiveWsMessage[] newArray(int r1) {
            return new LiveWsMessage[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
        new LiveWsMessage();
    }

    public final String toString() {
        return "LiveWsMessage{, channelId = " + this.j + ", logId=" + this.b + ", service=" + this.c + ", method=" + this.d + ", msgHeaders=" + this.e + ", payloadEncoding='" + this.f + "', payloadType='" + this.g + "', payload=" + Arrays.toString(this.h) + ", from= " + this.k + ", replayToComponentName=" + this.i + '}';
    }

    public LiveWsMessage() {
        this.k = 0;
    }

    public LiveWsMessage(Parcel r3) {
        this.k = 0;
        this.a = r3.readLong();
        this.b = r3.readLong();
        this.c = r3.readInt();
        this.d = r3.readInt();
        this.e = r3.createTypedArrayList(MsgHeader.CREATOR);
        this.f = r3.readString();
        this.g = r3.readString();
        this.h = r3.createByteArray();
        this.i = (ComponentName) r3.readParcelable(ComponentName.class.getClassLoader());
        this.j = r3.readInt();
        this.k = r3.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.a);
        r3.writeLong(this.b);
        r3.writeInt(this.c);
        r3.writeInt(this.d);
        r3.writeTypedList(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeByteArray(this.h);
        r3.writeParcelable(this.i, r4);
        r3.writeInt(this.j);
        r3.writeInt(this.k);
    }
}
