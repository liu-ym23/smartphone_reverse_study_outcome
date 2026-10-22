package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PowerPredictionParcel implements Parcelable {
    public static final Parcelable.Creator<PowerPredictionParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4169b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f4172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f4176s;

    public class a implements Parcelable.Creator<PowerPredictionParcel> {
        @Override // android.os.Parcelable.Creator
        public final PowerPredictionParcel createFromParcel(Parcel r8) {
            PowerPredictionParcel r10 = new PowerPredictionParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L84;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4168a = r8.readString();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4169b = r8.readInt();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4170m = r8.readFloat();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4171n = r8.readLong();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4172o = r8.readFloat();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4173p = r8.readFloat();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4174q = r8.readFloat();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4175r = r8.readFloat();     // Catch: Throwable -> L85
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4176s = r8.readFloat();     // Catch: Throwable -> L85
            if (r11 > (Integer.MAX_VALUE - r12)) goto L82;
        L79:
            r8.setDataPosition(r11 + r12);
            return r10;
        L82:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L79;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L84:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L85
        L85:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L89;
            r8.setDataPosition(r11 + r12);
            throw th;
        L89:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final PowerPredictionParcel[] newArray(int r8) {
            return new PowerPredictionParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public PowerPredictionParcel() {
        this.f4169b = 0;
        this.f4170m = 0.0f;
        this.f4171n = 0;
        this.f4172o = 0.0f;
        this.f4173p = 0.0f;
        this.f4174q = 0.0f;
        this.f4175r = 0.0f;
        this.f4176s = 0.0f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.f4168a);
        r8.writeInt(this.f4169b);
        r8.writeFloat(this.f4170m);
        r8.writeLong(this.f4171n);
        r8.writeFloat(this.f4172o);
        r8.writeFloat(this.f4173p);
        r8.writeFloat(this.f4174q);
        r8.writeFloat(this.f4175r);
        r8.writeFloat(this.f4176s);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
