package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeState$State implements Parcelable {
    public static final Parcelable.Creator<BadgeState$State> CREATOR = null;
    public final int A;
    public final Integer B;
    public final Boolean C;
    public final Integer D;
    public final Integer E;
    public final Integer F;
    public final Integer G;
    public final Integer H;
    public final Integer I;
    public final Integer J;
    public final Integer K;
    public final Integer L;
    public final Boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f4327b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f4328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f4329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f4330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f4331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f4332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Integer f4333r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f4334s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f4335t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f4336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Locale f4339x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f4340y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f4341z;

    public class a implements Parcelable.Creator<BadgeState$State> {
        @Override // android.os.Parcelable.Creator
        public final BadgeState$State createFromParcel(Parcel r8) {
            return new BadgeState$State(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BadgeState$State[] newArray(int r8) {
            return new BadgeState$State[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BadgeState$State() {
        this.f4334s = 255;
        this.f4336u = -2;
        this.f4337v = -2;
        this.f4338w = -2;
        this.C = Boolean.TRUE;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f4326a);
        r8.writeSerializable(this.f4327b);
        r8.writeSerializable(this.f4328m);
        r8.writeSerializable(this.f4329n);
        r8.writeSerializable(this.f4330o);
        r8.writeSerializable(this.f4331p);
        r8.writeSerializable(this.f4332q);
        r8.writeSerializable(this.f4333r);
        r8.writeInt(this.f4334s);
        r8.writeString(this.f4335t);
        r8.writeInt(this.f4336u);
        r8.writeInt(this.f4337v);
        r8.writeInt(this.f4338w);
        String r11 = this.f4340y;
        String r12 = null;
        if (r11 != null) goto L6;
        r11 = null;
    L6:
        r8.writeString(r11);
        String r13 = this.f4341z;
        if (r13 == null) goto L9;
        r12 = r13;
    L9:
        r8.writeString(r12);
        r8.writeInt(this.A);
        r8.writeSerializable(this.B);
        r8.writeSerializable(this.D);
        r8.writeSerializable(this.E);
        r8.writeSerializable(this.F);
        r8.writeSerializable(this.G);
        r8.writeSerializable(this.H);
        r8.writeSerializable(this.I);
        r8.writeSerializable(this.L);
        r8.writeSerializable(this.J);
        r8.writeSerializable(this.K);
        r8.writeSerializable(this.C);
        r8.writeSerializable(this.f4339x);
        r8.writeSerializable(this.M);
    }

    public BadgeState$State(Parcel r8) {
        this.f4334s = 255;
        this.f4336u = -2;
        this.f4337v = -2;
        this.f4338w = -2;
        this.C = Boolean.TRUE;
        this.f4326a = r8.readInt();
        this.f4327b = (Integer) r8.readSerializable();
        this.f4328m = (Integer) r8.readSerializable();
        this.f4329n = (Integer) r8.readSerializable();
        this.f4330o = (Integer) r8.readSerializable();
        this.f4331p = (Integer) r8.readSerializable();
        this.f4332q = (Integer) r8.readSerializable();
        this.f4333r = (Integer) r8.readSerializable();
        this.f4334s = r8.readInt();
        this.f4335t = r8.readString();
        this.f4336u = r8.readInt();
        this.f4337v = r8.readInt();
        this.f4338w = r8.readInt();
        this.f4340y = r8.readString();
        this.f4341z = r8.readString();
        this.A = r8.readInt();
        this.B = (Integer) r8.readSerializable();
        this.D = (Integer) r8.readSerializable();
        this.E = (Integer) r8.readSerializable();
        this.F = (Integer) r8.readSerializable();
        this.G = (Integer) r8.readSerializable();
        this.H = (Integer) r8.readSerializable();
        this.I = (Integer) r8.readSerializable();
        this.L = (Integer) r8.readSerializable();
        this.J = (Integer) r8.readSerializable();
        this.K = (Integer) r8.readSerializable();
        this.C = (Boolean) r8.readSerializable();
        this.f4339x = (Locale) r8.readSerializable();
        this.M = (Boolean) r8.readSerializable();
    }
}
