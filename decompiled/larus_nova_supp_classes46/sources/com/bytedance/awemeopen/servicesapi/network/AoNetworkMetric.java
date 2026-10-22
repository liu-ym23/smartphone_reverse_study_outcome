package com.bytedance.awemeopen.servicesapi.network;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class AoNetworkMetric implements Parcelable {
    public static final Parcelable.Creator<AoNetworkMetric> CREATOR = null;
    public int A;
    public int B;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public String u;
    public String v;
    public String w;
    public int x;
    public int y;
    public int z;

    public static class a implements Parcelable.Creator<AoNetworkMetric> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AoNetworkMetric createFromParcel(Parcel r2) {
            return new AoNetworkMetric(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AoNetworkMetric[] newArray(int r1) {
            return new AoNetworkMetric[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "BdpNetworkMetric{dnsDuration=" + this.a + ", connectDuration=" + this.b + ", sslDuration=" + this.c + ", sendDuration=" + this.d + ", waitDuration=" + this.e + ", receiveDuration=" + this.f + ", exeDuration=" + this.g + ", socketReused=" + this.h + ", requestStart=" + this.i + ", requestEnd=" + this.j + ", domainLookupStart=" + this.k + ", domainLookupEnd=" + this.l + ", connectStart=" + this.m + ", connectEnd=" + this.n + ", sslConnectionStart=" + this.o + ", sslConnectionEnd=" + this.p + ", responseStart=" + this.q + ", responseEnd=" + this.r + ", sentBytesCount=" + this.s + ", receivedBytesCount=" + this.t + ", estimateNetType='" + this.u + "', protocol='" + this.v + "', peerIP='" + this.w + "', port=" + this.x + ", rtt=" + this.y + ", throughputKbps=" + this.z + ", httpClientType=" + this.A + ", metricDuration=" + this.B + '}';
    }

    public AoNetworkMetric() {
        this.A = -1;
    }

    public AoNetworkMetric(Parcel r3) {
        this.A = -1;
        this.a = r3.readInt();
        this.b = r3.readInt();
        this.c = r3.readInt();
        this.d = r3.readInt();
        this.e = r3.readInt();
        this.f = r3.readInt();
        this.g = r3.readInt();
        if (r3.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.h = r0;
        this.i = r3.readLong();
        this.j = r3.readLong();
        this.k = r3.readLong();
        this.l = r3.readLong();
        this.m = r3.readLong();
        this.n = r3.readLong();
        this.o = r3.readLong();
        this.p = r3.readLong();
        this.q = r3.readLong();
        this.r = r3.readLong();
        this.s = r3.readLong();
        this.t = r3.readLong();
        this.u = r3.readString();
        this.v = r3.readString();
        this.w = r3.readString();
        this.x = r3.readInt();
        this.y = r3.readInt();
        this.z = r3.readInt();
        this.A = r3.readInt();
        this.B = r3.readInt();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void update(AoNetworkMetric r3) {
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
        this.l = r3.l;
        this.m = r3.m;
        this.n = r3.n;
        this.o = r3.o;
        this.p = r3.p;
        this.q = r3.q;
        this.r = r3.r;
        this.s = r3.s;
        this.t = r3.t;
        this.u = r3.u;
        this.v = r3.v;
        this.w = r3.w;
        this.x = r3.x;
        this.y = r3.y;
        this.z = r3.z;
        this.A = r3.A;
        this.B = r3.B;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.a);
        r3.writeInt(this.b);
        r3.writeInt(this.c);
        r3.writeInt(this.d);
        r3.writeInt(this.e);
        r3.writeInt(this.f);
        r3.writeInt(this.g);
        r3.writeByte(this.h ? 1 : 0);
        r3.writeLong(this.i);
        r3.writeLong(this.j);
        r3.writeLong(this.k);
        r3.writeLong(this.l);
        r3.writeLong(this.m);
        r3.writeLong(this.n);
        r3.writeLong(this.o);
        r3.writeLong(this.p);
        r3.writeLong(this.q);
        r3.writeLong(this.r);
        r3.writeLong(this.s);
        r3.writeLong(this.t);
        r3.writeString(this.u);
        r3.writeString(this.v);
        r3.writeString(this.w);
        r3.writeInt(this.x);
        r3.writeInt(this.y);
        r3.writeInt(this.z);
        r3.writeInt(this.A);
        r3.writeInt(this.B);
    }
}
