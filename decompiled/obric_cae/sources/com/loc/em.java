package com.loc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class em implements Parcelable {
    public static final Parcelable.Creator<em> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5198b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f5200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f5201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f5202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f5203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f5204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f5205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f5206t;

    public static class a implements Parcelable.Creator<em> {
        @Override // android.os.Parcelable.Creator
        public final em createFromParcel(Parcel r8) {
            em r10 = new em();
            r10.f5201o = r8.readString();
            r10.f5202p = r8.readString();
            r10.f5203q = r8.readString();
            r10.f5204r = r8.readString();
            r10.f5206t = r8.readString();
            r10.f5197a = r8.readLong();
            r10.f5198b = r8.readLong();
            r10.f5199m = r8.readLong();
            r10.f5200n = r8.readLong();
            r10.f5205s = r8.readString();
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final em[] newArray(int r8) {
            return new em[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public em() {
        this.f5197a = 0;
        this.f5198b = 0;
        this.f5199m = 0;
        this.f5200n = 0;
        this.f5203q = "first";
        this.f5204r = "";
        this.f5205s = "";
        this.f5206t = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f5201o);     // Catch: Throwable -> L4
        r8.writeString(this.f5202p);     // Catch: Throwable -> L4
        r8.writeString(this.f5203q);     // Catch: Throwable -> L4
        r8.writeString(this.f5204r);     // Catch: Throwable -> L4
        r8.writeString(this.f5206t);     // Catch: Throwable -> L4
        r8.writeLong(this.f5197a);     // Catch: Throwable -> L4
        r8.writeLong(this.f5198b);     // Catch: Throwable -> L4
        r8.writeLong(this.f5199m);     // Catch: Throwable -> L4
        r8.writeLong(this.f5200n);     // Catch: Throwable -> L4
        r8.writeString(this.f5205s);     // Catch: Throwable -> L4
        return;
    }
}
