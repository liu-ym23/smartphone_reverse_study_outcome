package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DeltaInfoParcel implements Parcelable {
    public static final Parcelable.Creator<DeltaInfoParcel> CREATOR = null;
    public int A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4108b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4111o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4112p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4113q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4114r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4115s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4116t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4117u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4118v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4119w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4122z;

    public class a implements Parcelable.Creator<DeltaInfoParcel> {
        @Override // android.os.Parcelable.Creator
        public final DeltaInfoParcel createFromParcel(Parcel r8) {
            DeltaInfoParcel r10 = new DeltaInfoParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L156;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4107a = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4108b = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4109m = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4110n = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4111o = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4112p = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4113q = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4114r = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4115s = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4116t = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4117u = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L96;
            r10.f4118v = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L104;
            r10.f4119w = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L112;
            r10.f4120x = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L120;
            r10.f4121y = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L128;
            r10.f4122z = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L136;
            r10.A = r8.readInt();     // Catch: Throwable -> L157
            if ((r8.dataPosition() - r11) >= r12) goto L144;
            r10.B = r8.readInt();     // Catch: Throwable -> L157
            if (r11 > (Integer.MAX_VALUE - r12)) goto L154;
        L151:
            r8.setDataPosition(r11 + r12);
            return r10;
        L154:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L144:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L136:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L128:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L120:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L112:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L104:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L96:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L151;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L156:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L157
        L157:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L161;
            r8.setDataPosition(r11 + r12);
            throw th;
        L161:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final DeltaInfoParcel[] newArray(int r8) {
            return new DeltaInfoParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public DeltaInfoParcel() {
        this.f4107a = 0;
        this.f4108b = 0;
        this.f4109m = 0;
        this.f4110n = 0;
        this.f4111o = 0;
        this.f4112p = 0;
        this.f4113q = 0;
        this.f4114r = 0;
        this.f4115s = 0;
        this.f4116t = 0;
        this.f4117u = 0;
        this.f4118v = 0;
        this.f4119w = 0;
        this.f4120x = 0;
        this.f4121y = 0;
        this.f4122z = 0;
        this.A = 0;
        this.B = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4107a);
        r8.writeInt(this.f4108b);
        r8.writeInt(this.f4109m);
        r8.writeInt(this.f4110n);
        r8.writeInt(this.f4111o);
        r8.writeInt(this.f4112p);
        r8.writeInt(this.f4113q);
        r8.writeInt(this.f4114r);
        r8.writeInt(this.f4115s);
        r8.writeInt(this.f4116t);
        r8.writeInt(this.f4117u);
        r8.writeInt(this.f4118v);
        r8.writeInt(this.f4119w);
        r8.writeInt(this.f4120x);
        r8.writeInt(this.f4121y);
        r8.writeInt(this.f4122z);
        r8.writeInt(this.A);
        r8.writeInt(this.B);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
