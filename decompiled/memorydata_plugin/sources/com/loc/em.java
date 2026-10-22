package com.loc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class em implements Parcelable {
    public static final Parcelable.Creator<em> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5500b;
    private long c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    static {
        CREATOR = new AnonymousClass1();
    }

    public em() {
        this.f5499a = 0;
        this.f5500b = 0;
        this.c = 0;
        this.d = 0;
        this.g = "first";
        this.h = "";
        this.i = "";
        this.j = null;
    }

    public final long a() {
        long r0 = this.d;
        long r2 = this.c;
        if ((r0 - r2) > 0) goto L6;
        return 0;
    L6:
        return r0 - r2;
    }

    public final void a(long r1) {
        this.c = r1;
    }

    public final void a(String r1) {
        this.i = r1;
    }

    public final String b() {
        return this.i;
    }

    public final void b(long r1) {
        this.d = r1;
    }

    public final void b(String r1) {
        this.j = r1;
    }

    public final String c() {
        return this.j;
    }

    public final void c(long r1) {
        this.f5499a = r1;
    }

    public final void c(String r1) {
        this.e = r1;
    }

    public final String d() {
        return this.e;
    }

    public final void d(long r1) {
        this.f5500b = r1;
    }

    public final void d(String r1) {
        this.f = r1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f;
    }

    public final void e(String r1) {
        this.g = r1;
    }

    public final String f() {
        return this.g;
    }

    public final void f(String r1) {
        this.h = r1;
    }

    public final String g() {
        return this.h;
    }

    public final long h() {
        long r0 = this.f5500b;
        long r2 = this.f5499a;
        if (r0 > r2) goto L7;
        return 0;
    L7:
        return r0 - r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.e);     // Catch: Throwable -> L4
        r3.writeString(this.f);     // Catch: Throwable -> L4
        r3.writeString(this.g);     // Catch: Throwable -> L4
        r3.writeString(this.h);     // Catch: Throwable -> L4
        r3.writeString(this.j);     // Catch: Throwable -> L4
        r3.writeLong(this.f5499a);     // Catch: Throwable -> L4
        r3.writeLong(this.f5500b);     // Catch: Throwable -> L4
        r3.writeLong(this.c);     // Catch: Throwable -> L4
        r3.writeLong(this.d);     // Catch: Throwable -> L4
        r3.writeString(this.i);     // Catch: Throwable -> L4
        return;
    }
}
