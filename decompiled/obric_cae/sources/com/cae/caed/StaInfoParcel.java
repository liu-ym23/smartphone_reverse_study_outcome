package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class StaInfoParcel implements Parcelable {
    public static final Parcelable.Creator<StaInfoParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4189b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4190m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4191n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4192o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4193p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4194q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4195r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4196s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4197t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4198u;

    public class a implements Parcelable.Creator<StaInfoParcel> {
        @Override // android.os.Parcelable.Creator
        public final StaInfoParcel createFromParcel(Parcel r8) {
            StaInfoParcel r10 = new StaInfoParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L100;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4188a = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4189b = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4190m = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4191n = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4192o = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4193p = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4194q = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4195r = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4196s = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4197t = r8.readInt();     // Catch: Throwable -> L101
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4198u = r8.readInt();     // Catch: Throwable -> L101
            if (r11 > (Integer.MAX_VALUE - r12)) goto L98;
        L95:
            r8.setDataPosition(r11 + r12);
            return r10;
        L98:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L95;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L100:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L101
        L101:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L105;
            r8.setDataPosition(r11 + r12);
            throw th;
        L105:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final StaInfoParcel[] newArray(int r8) {
            return new StaInfoParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public StaInfoParcel() {
        this.f4188a = 0;
        this.f4189b = 0;
        this.f4190m = 0;
        this.f4191n = 0;
        this.f4192o = 0;
        this.f4193p = 0;
        this.f4194q = 0;
        this.f4195r = 0;
        this.f4196s = 0;
        this.f4197t = 0;
        this.f4198u = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4188a);
        r8.writeInt(this.f4189b);
        r8.writeInt(this.f4190m);
        r8.writeInt(this.f4191n);
        r8.writeInt(this.f4192o);
        r8.writeInt(this.f4193p);
        r8.writeInt(this.f4194q);
        r8.writeInt(this.f4195r);
        r8.writeInt(this.f4196s);
        r8.writeInt(this.f4197t);
        r8.writeInt(this.f4198u);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
