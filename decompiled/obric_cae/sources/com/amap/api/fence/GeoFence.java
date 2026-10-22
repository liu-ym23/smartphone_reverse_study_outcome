package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeoFence implements Parcelable {
    public static final Parcelable.Creator<GeoFence> CREATOR = null;
    public final boolean A;
    public final AMapLocation B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3608b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PendingIntent f3610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f3611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PoiItem f3612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f3613q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f3614r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f3615s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f3616t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f3617u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f3618v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f3619w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DPoint f3620x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3621y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f3622z;

    public static class a implements Parcelable.Creator<GeoFence> {
        @Override // android.os.Parcelable.Creator
        public final GeoFence createFromParcel(Parcel r8) {
            return new GeoFence(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final GeoFence[] newArray(int r8) {
            return new GeoFence[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public GeoFence() {
        this.f3610n = null;
        this.f3611o = 0;
        this.f3612p = null;
        this.f3613q = null;
        this.f3615s = 0.0f;
        this.f3616t = -1;
        this.f3617u = 1;
        this.f3618v = 0.0f;
        this.f3619w = 0.0f;
        this.f3620x = null;
        this.f3621y = 0;
        this.f3622z = -1;
        this.A = true;
        this.B = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof GeoFence) == true) goto L5;
        return false;
    L5:
        GeoFence r10 = (GeoFence) r8;
        String r11 = this.f3608b;
        if (TextUtils.isEmpty(r11) == false) goto L11;
        if (TextUtils.isEmpty(r10.f3608b) == true) goto L13;
        return false;
    L13:
        DPoint r12 = this.f3620x;
        if (r12 != null) goto L19;
        if (r10.f3620x == null) goto L21;
        return false;
    L21:
        float r13 = r10.f3615s;
        if (this.f3615s == r13) goto L24;
        return false;
    L24:
        ArrayList r14 = this.f3614r;
        ArrayList r15 = r10.f3614r;
        if (r14 != null) goto L29;
        if (r15 == null) goto L31;
        return false;
    L31:
        return true;
    L29:
        if (r14.equals(r15) == true) goto L33;
        return false;
    L33:
        return true;
    L19:
        if (r12.equals(r10.f3620x) == true) goto L21;
        return false;
    L11:
        if (r11.equals(r10.f3608b) == true) goto L13;
        return false;
    }

    public final int hashCode() {
        int r8 = this.f3608b.hashCode();
        int r10 = this.f3614r.hashCode() + r8;
        return (this.f3620x.hashCode() + r10) + ((int) (this.f3615s * 100.0f));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f3607a);
        r8.writeString(this.f3608b);
        r8.writeString(this.f3609m);
        r8.writeParcelable(this.f3610n, r10);
        r8.writeInt(this.f3611o);
        r8.writeParcelable(this.f3612p, r10);
        r8.writeTypedList(this.f3613q);
        r8.writeFloat(this.f3615s);
        r8.writeLong(this.f3616t);
        r8.writeInt(this.f3617u);
        r8.writeFloat(this.f3618v);
        r8.writeFloat(this.f3619w);
        r8.writeParcelable(this.f3620x, r10);
        r8.writeInt(this.f3621y);
        r8.writeLong(this.f3622z);
        ArrayList r11 = this.f3614r;
        if (r11 != null) goto L5;
    L10:
        r8.writeByte(this.A ? 1 : 0);
        r8.writeParcelable(this.B, r10);
        return;
    L5:
        if (r11.isEmpty() == true) goto L10;
        r8.writeInt(r11.size());
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r8.writeTypedList((List) r12.next());
        goto L8
    }

    public GeoFence(Parcel r8) {
        this.f3610n = null;
        boolean r10 = false;
        this.f3611o = 0;
        this.f3612p = null;
        this.f3613q = null;
        this.f3615s = 0.0f;
        this.f3616t = -1;
        this.f3617u = 1;
        this.f3618v = 0.0f;
        this.f3619w = 0.0f;
        this.f3620x = null;
        this.f3621y = 0;
        this.f3622z = -1;
        this.A = true;
        this.B = null;
        this.f3607a = r8.readString();
        this.f3608b = r8.readString();
        this.f3609m = r8.readString();
        this.f3610n = (PendingIntent) r8.readParcelable(PendingIntent.class.getClassLoader());
        this.f3611o = r8.readInt();
        this.f3612p = (PoiItem) r8.readParcelable(PoiItem.class.getClassLoader());
        this.f3613q = r8.createTypedArrayList(DistrictItem.CREATOR);
        this.f3615s = r8.readFloat();
        this.f3616t = r8.readLong();
        this.f3617u = r8.readInt();
        this.f3618v = r8.readFloat();
        this.f3619w = r8.readFloat();
        this.f3620x = (DPoint) r8.readParcelable(DPoint.class.getClassLoader());
        this.f3621y = r8.readInt();
        this.f3622z = r8.readLong();
        int r11 = r8.readInt();
        if (r11 == 0) goto L8;
        this.f3614r = new ArrayList();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L8;
        this.f3614r.add(r8.createTypedArrayList(DPoint.CREATOR));
        r12 = r12 + 1;
    L8:
        if (r8.readByte() == 0) goto L10;
        r10 = true;
    L10:
        this.A = r10;
        this.B = (AMapLocation) r8.readParcelable(AMapLocation.class.getClassLoader());
    }
}
