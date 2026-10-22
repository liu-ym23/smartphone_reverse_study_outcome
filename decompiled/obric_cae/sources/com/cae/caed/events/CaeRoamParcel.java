package com.cae.caed.events;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CaeRoamParcel implements Parcelable {
    public static final Parcelable.Creator<CaeRoamParcel> CREATOR = null;
    public int[] A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4229b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f4235r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f4236s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4237t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4238u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f4239v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String[] f4240w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f4241x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f4242y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int[] f4243z;

    public class a implements Parcelable.Creator<CaeRoamParcel> {
        @Override // android.os.Parcelable.Creator
        public final CaeRoamParcel createFromParcel(Parcel r8) {
            CaeRoamParcel r10 = new CaeRoamParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L148;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4228a = r8.readString();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4229b = r8.readString();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4230m = r8.readInt();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4231n = r8.readString();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4232o = r8.readInt();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4233p = r8.readInt();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4234q = r8.readInt();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4235r = r8.createIntArray();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4236s = r8.readString();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4237t = r8.readString();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4238u = r8.readInt();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L96;
            r10.f4239v = r8.readLong();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L104;
            r10.f4240w = r8.createStringArray();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L112;
            r10.f4241x = r8.createIntArray();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L120;
            r10.f4242y = r8.createIntArray();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L128;
            r10.f4243z = r8.createIntArray();     // Catch: Throwable -> L149
            if ((r8.dataPosition() - r11) >= r12) goto L136;
            r10.A = r8.createIntArray();     // Catch: Throwable -> L149
            if (r11 > (Integer.MAX_VALUE - r12)) goto L146;
        L143:
            r8.setDataPosition(r11 + r12);
            return r10;
        L146:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L136:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L128:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L120:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L112:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L104:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L96:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L143;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L148:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L149
        L149:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L153;
            r8.setDataPosition(r11 + r12);
            throw th;
        L153:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final CaeRoamParcel[] newArray(int r8) {
            return new CaeRoamParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeRoamParcel() {
        this.f4230m = 0;
        this.f4232o = 0;
        this.f4233p = 0;
        this.f4234q = 0;
        this.f4238u = 0;
        this.f4239v = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.f4228a);
        r8.writeString(this.f4229b);
        r8.writeInt(this.f4230m);
        r8.writeString(this.f4231n);
        r8.writeInt(this.f4232o);
        r8.writeInt(this.f4233p);
        r8.writeInt(this.f4234q);
        r8.writeIntArray(this.f4235r);
        r8.writeString(this.f4236s);
        r8.writeString(this.f4237t);
        r8.writeInt(this.f4238u);
        r8.writeLong(this.f4239v);
        r8.writeStringArray(this.f4240w);
        r8.writeIntArray(this.f4241x);
        r8.writeIntArray(this.f4242y);
        r8.writeIntArray(this.f4243z);
        r8.writeIntArray(this.A);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
