package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AcStatsParcel implements Parcelable {
    public static final Parcelable.Creator<AcStatsParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4090b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4096r;

    public class a implements Parcelable.Creator<AcStatsParcel> {
        @Override // android.os.Parcelable.Creator
        public final AcStatsParcel createFromParcel(Parcel r8) {
            AcStatsParcel r10 = new AcStatsParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L76;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4089a = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4090b = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4091m = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4092n = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4093o = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4094p = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4095q = r8.readInt();     // Catch: Throwable -> L77
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4096r = r8.readInt();     // Catch: Throwable -> L77
            if (r11 > (Integer.MAX_VALUE - r12)) goto L74;
        L71:
            r8.setDataPosition(r11 + r12);
            return r10;
        L74:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L71;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L76:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L77
        L77:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L81;
            r8.setDataPosition(r11 + r12);
            throw th;
        L81:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final AcStatsParcel[] newArray(int r8) {
            return new AcStatsParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public AcStatsParcel() {
        this.f4089a = 0;
        this.f4090b = 0;
        this.f4091m = 0;
        this.f4092n = 0;
        this.f4093o = 0;
        this.f4094p = 0;
        this.f4095q = 0;
        this.f4096r = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4089a);
        r8.writeInt(this.f4090b);
        r8.writeInt(this.f4091m);
        r8.writeInt(this.f4092n);
        r8.writeInt(this.f4093o);
        r8.writeInt(this.f4094p);
        r8.writeInt(this.f4095q);
        r8.writeInt(this.f4096r);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
