package com.cae.caed.events;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class WakePacketParcel implements Parcelable {
    public static final Parcelable.Creator<WakePacketParcel> CREATOR = null;
    public String A;
    public int B;
    public int C;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4245b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4247n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f4248o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4249p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4250q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4251r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4252s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4253t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4254u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4255v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f4256w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f4257x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f4258y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4259z;

    public class a implements Parcelable.Creator<WakePacketParcel> {
        @Override // android.os.Parcelable.Creator
        public final WakePacketParcel createFromParcel(Parcel r8) {
            WakePacketParcel r10 = new WakePacketParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L176;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4244a = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4245b = r8.readString();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4246m = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4247n = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4248o = r8.readString();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4249p = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4250q = r8.readString();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4251r = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4252s = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4253t = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4254u = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) < r12) goto L101;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L99;
        L171:
            r8.setDataPosition(r11 + r12);
            return r10;
        L99:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L101:
            if (r8.readInt() == 0) goto L103;
            boolean r13 = true;
        L104:
            r10.f4255v = r13;     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L108;
            r10.f4256w = r8.createByteArray();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L116;
            r10.f4257x = r8.readString();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L124;
            r10.f4258y = r8.readString();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L132;
            r10.f4259z = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L140;
            r10.A = r8.readString();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L148;
            r10.B = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L156;
            r10.C = r8.readInt();     // Catch: Throwable -> L177
            if ((r8.dataPosition() - r11) >= r12) goto L164;
            r10.D = r8.readString();     // Catch: Throwable -> L177
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L164:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L156:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L148:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L140:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L132:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L124:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L116:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L108:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L103:
            r13 = false;
            goto L104
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L171;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L176:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L177
        L177:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L181;
            r8.setDataPosition(r11 + r12);
            throw th;
        L181:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final WakePacketParcel[] newArray(int r8) {
            return new WakePacketParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public WakePacketParcel() {
        this.f4244a = 0;
        this.f4246m = 0;
        this.f4247n = 0;
        this.f4249p = 0;
        this.f4251r = 0;
        this.f4252s = 0;
        this.f4253t = 0;
        this.f4254u = 0;
        this.f4255v = false;
        this.f4259z = 0;
        this.B = 0;
        this.C = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4244a);
        r8.writeString(this.f4245b);
        r8.writeInt(this.f4246m);
        r8.writeInt(this.f4247n);
        r8.writeString(this.f4248o);
        r8.writeInt(this.f4249p);
        r8.writeString(this.f4250q);
        r8.writeInt(this.f4251r);
        r8.writeInt(this.f4252s);
        r8.writeInt(this.f4253t);
        r8.writeInt(this.f4254u);
        r8.writeInt(this.f4255v ? 1 : 0);
        r8.writeByteArray(this.f4256w);
        r8.writeString(this.f4257x);
        r8.writeString(this.f4258y);
        r8.writeInt(this.f4259z);
        r8.writeString(this.A);
        r8.writeInt(this.B);
        r8.writeInt(this.C);
        r8.writeString(this.D);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
