package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class VendorAttr implements Parcelable {
    public static final Parcelable.Creator<VendorAttr> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4200b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f4201m;

    public class a implements Parcelable.Creator<VendorAttr> {
        @Override // android.os.Parcelable.Creator
        public final VendorAttr createFromParcel(Parcel r8) {
            VendorAttr r10 = new VendorAttr();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L36;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4199a = r8.readInt();     // Catch: Throwable -> L37
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4200b = r8.readInt();     // Catch: Throwable -> L37
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4201m = r8.createByteArray();     // Catch: Throwable -> L37
            if (r11 > (Integer.MAX_VALUE - r12)) goto L34;
        L31:
            r8.setDataPosition(r11 + r12);
            return r10;
        L34:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L31;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L31;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L31;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L36:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L41;
            r8.setDataPosition(r11 + r12);
            throw th;
        L41:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final VendorAttr[] newArray(int r8) {
            return new VendorAttr[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public VendorAttr() {
        this.f4199a = 0;
        this.f4200b = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4199a);
        r8.writeInt(this.f4200b);
        r8.writeByteArray(this.f4201m);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
