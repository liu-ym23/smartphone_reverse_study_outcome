package com.obric.aikernel.sdk.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import he.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import yd.l;

/* JADX INFO: loaded from: classes.dex */
public final class ExtraAppInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5353b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f5354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f5355n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f5356o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f5357p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f5358q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f5359r;

    public static final class a implements Parcelable.Creator<ExtraAppInfo> {
        @Override // android.os.Parcelable.Creator
        public final ExtraAppInfo createFromParcel(Parcel r8) {
            i.f(r8, "parcel");
            return new ExtraAppInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ExtraAppInfo[] newArray(int r8) {
            return new ExtraAppInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ExtraAppInfo() {
        throw null;
    }

    public ExtraAppInfo(Parcel r13) {
        i.f(r13, "parcel");
        String r8 = r13.readString();
        String r10 = "";
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        String r11 = r13.readString();
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        String r12 = r13.readString();
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        String r14 = r13.readString();
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        String r15 = r13.readString();
        if (r15 != null) goto L17;
        r15 = "";
    L17:
        String r16 = r13.readString();
        if (r16 != null) goto L20;
        r16 = "";
    L20:
        Bundle r17 = r13.readBundle();
        if (r17 == null) goto L29;
        Map<String, String> r18 = new LinkedHashMap();
        Set<String> r19 = r17.keySet();
        i.e(r19, "bundle.keySet()");
        Iterator<T> r20 = r19.iterator();
    L24:
        if (r20.hasNext() == false) goto L30;
        String r110 = (String) r20.next();
        i.e(r110, "key");
        String r111 = r17.getString(r110);
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        r18.put(r110, r111);
    L30:
        String r112 = r13.readString();
        if (r112 == null) goto L34;
        r10 = r112;
    L34:
        this.f5352a = r8;
        this.f5353b = r11;
        this.f5354m = r12;
        this.f5355n = r14;
        this.f5356o = r15;
        this.f5357p = r16;
        this.f5358q = r18;
        this.f5359r = r10;
        return;
    L29:
        r18 = l.f14120a;
        goto L30
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r10 = r8.getClass();
    L10:
        if (i.a(ExtraAppInfo.class, r10) == true) goto L12;
        return false;
    L12:
        i.d(r8, "null cannot be cast to non-null type com.obric.aikernel.sdk.data.ExtraAppInfo");
        ExtraAppInfo r11 = (ExtraAppInfo) r8;
        if (i.a(this.f5352a, r11.f5352a) == true) goto L16;
        return false;
    L16:
        if (i.a(this.f5353b, r11.f5353b) == true) goto L19;
        return false;
    L19:
        if (i.a(this.f5354m, r11.f5354m) == true) goto L22;
        return false;
    L22:
        if (i.a(this.f5355n, r11.f5355n) == true) goto L25;
        return false;
    L25:
        if (i.a(this.f5356o, r11.f5356o) == true) goto L28;
        return false;
    L28:
        if (i.a(this.f5357p, r11.f5357p) == true) goto L31;
        return false;
    L31:
        if (i.a(this.f5358q, r11.f5358q) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r10 = null;
        goto L10
    }

    public final int hashCode() {
        int r8 = this.f5352a.hashCode() * 31;
        int r10 = defpackage.a.b(this.f5353b, r8, 31);
        int r11 = defpackage.a.b(this.f5354m, r10, 31);
        int r12 = defpackage.a.b(this.f5355n, r11, 31);
        int r13 = defpackage.a.b(this.f5356o, r12, 31);
        int r14 = defpackage.a.b(this.f5357p, r13, 31);
        return this.f5358q.hashCode() + r14;
    }

    public final String toString() {
        return "ExtraAppInfo(aid=" + this.f5352a + ", appVersionName=" + this.f5353b + ", sdkVersion=" + this.f5354m + ", bridgeVersion=" + this.f5355n + ", foundationVersion=" + this.f5356o + ", vmVersion=" + this.f5357p + ", libsVersion=" + this.f5358q + ", extraInfo=" + this.f5359r + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        i.f(r8, "parcel");
        r8.writeString(this.f5352a);
        r8.writeString(this.f5353b);
        r8.writeString(this.f5354m);
        r8.writeString(this.f5355n);
        r8.writeString(this.f5356o);
        r8.writeString(this.f5357p);
        Bundle r11 = new Bundle();
        Iterator<Map.Entry<String, String>> r12 = this.f5358q.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        r11.putString(r13.getKey(), r13.getValue());
        goto L4
    L6:
        r8.writeBundle(r11);
        r8.writeString(this.f5359r);
    }
}
