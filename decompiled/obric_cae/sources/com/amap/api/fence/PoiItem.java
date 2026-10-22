package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3624b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3625m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3626n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3627o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final double f3628p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final double f3629q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f3630r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3631s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f3632t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f3633u;

    public static class a implements Parcelable.Creator<PoiItem> {
        @Override // android.os.Parcelable.Creator
        public final PoiItem createFromParcel(Parcel r8) {
            return new PoiItem(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final PoiItem[] newArray(int r8) {
            return new PoiItem[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public PoiItem() {
        this.f3623a = "";
        this.f3624b = "";
        this.f3625m = "";
        this.f3626n = "";
        this.f3627o = "";
        this.f3628p = 0.0d;
        this.f3629q = 0.0d;
        this.f3630r = "";
        this.f3631s = "";
        this.f3632t = "";
        this.f3633u = "";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f3623a);
        r8.writeString(this.f3624b);
        r8.writeString(this.f3625m);
        r8.writeString(this.f3626n);
        r8.writeString(this.f3627o);
        r8.writeDouble(this.f3628p);
        r8.writeDouble(this.f3629q);
        r8.writeString(this.f3630r);
        r8.writeString(this.f3631s);
        r8.writeString(this.f3632t);
        r8.writeString(this.f3633u);
    }

    public PoiItem(Parcel r8) {
        this.f3623a = "";
        this.f3624b = "";
        this.f3625m = "";
        this.f3626n = "";
        this.f3627o = "";
        this.f3628p = 0.0d;
        this.f3629q = 0.0d;
        this.f3630r = "";
        this.f3631s = "";
        this.f3632t = "";
        this.f3633u = "";
        this.f3623a = r8.readString();
        this.f3624b = r8.readString();
        this.f3625m = r8.readString();
        this.f3626n = r8.readString();
        this.f3627o = r8.readString();
        this.f3628p = r8.readDouble();
        this.f3629q = r8.readDouble();
        this.f3630r = r8.readString();
        this.f3631s = r8.readString();
        this.f3632t = r8.readString();
        this.f3633u = r8.readString();
    }
}
