package com.bytedance.common.wschannel.model;

import a5.b;
import ai.j0;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final WsChannelMsg f4005k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4008c;
    public int d;
    public ArrayList e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f4009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ComponentName f4010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4011j;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4013b;

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("MsgHeader{key='");
            r5.append(this.f4012a);
            r5.append("', value='");
            return j0.q(r5, this.f4013b, "'}");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            r5.writeString(this.f4012a);
            r5.writeString(this.f4013b);
        }
    }

    static {
        CREATOR = new b(16);
        f4005k = new WsChannelMsg();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "WsChannelMsg{, channelId = " + this.f4011j + ", logId=" + this.f4007b + ", service=" + this.f4008c + ", method=" + this.d + ", msgHeaders=" + this.e + ", payloadEncoding='" + this.f + "', payloadType='" + this.g + "', payload=" + Arrays.toString(this.f4009h) + ", replayToComponentName=" + this.f4010i + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeLong(this.f4006a);
        r5.writeLong(this.f4007b);
        r5.writeInt(this.f4008c);
        r5.writeInt(this.d);
        r5.writeTypedList(this.e);
        r5.writeString(this.f);
        r5.writeString(this.g);
        r5.writeByteArray(this.f4009h);
        r5.writeParcelable(this.f4010i, r10);
        r5.writeInt(this.f4011j);
    }
}
