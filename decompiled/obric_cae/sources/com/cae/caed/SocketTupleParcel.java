package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SocketTupleParcel implements Parcelable {
    public static final Parcelable.Creator<SocketTupleParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f4181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f4182b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4183m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4184n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f4185o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4186p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4187q;

    public class a implements Parcelable.Creator<SocketTupleParcel> {
        @Override // android.os.Parcelable.Creator
        public final SocketTupleParcel createFromParcel(Parcel r8) {
            SocketTupleParcel r10 = new SocketTupleParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L68;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4181a = r8.readByte();     // Catch: Throwable -> L69
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4182b = r8.readByte();     // Catch: Throwable -> L69
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4183m = r8.readString();     // Catch: Throwable -> L69
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4184n = r8.readInt();     // Catch: Throwable -> L69
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4185o = r8.readString();     // Catch: Throwable -> L69
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4186p = r8.readInt();     // Catch: Throwable -> L69
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4187q = r8.readString();     // Catch: Throwable -> L69
            if (r11 > (Integer.MAX_VALUE - r12)) goto L66;
        L63:
            r8.setDataPosition(r11 + r12);
            return r10;
        L66:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L63;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L68:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L69
        L69:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L73;
            r8.setDataPosition(r11 + r12);
            throw th;
        L73:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final SocketTupleParcel[] newArray(int r8) {
            return new SocketTupleParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public SocketTupleParcel() {
        this.f4181a = 0;
        this.f4182b = 0;
        this.f4184n = 0;
        this.f4186p = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeByte(this.f4181a);
        r8.writeByte(this.f4182b);
        r8.writeString(this.f4183m);
        r8.writeInt(this.f4184n);
        r8.writeString(this.f4185o);
        r8.writeInt(this.f4186p);
        r8.writeString(this.f4187q);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
