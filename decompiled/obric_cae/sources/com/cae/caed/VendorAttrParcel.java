package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class VendorAttrParcel implements Parcelable {
    public static final Parcelable.Creator<VendorAttrParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VendorAttr[] f4202a;

    public class a implements Parcelable.Creator<VendorAttrParcel> {
        @Override // android.os.Parcelable.Creator
        public final VendorAttrParcel createFromParcel(Parcel r8) {
            VendorAttrParcel r10 = new VendorAttrParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L20;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4202a = (VendorAttr[]) r8.createTypedArray(VendorAttr.CREATOR);     // Catch: Throwable -> L21
            if (r11 > (Integer.MAX_VALUE - r12)) goto L18;
        L15:
            r8.setDataPosition(r11 + r12);
            return r10;
        L18:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L15;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L20:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L25;
            r8.setDataPosition(r11 + r12);
            throw th;
        L25:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final VendorAttrParcel[] newArray(int r8) {
            return new VendorAttrParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public VendorAttrParcel() {
    }

    public static int t(Object r8) {
        int r10 = 0;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if ((r8 instanceof Object[]) == false) goto L12;
        Object[] r11 = (Object[]) r8;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r10 >= r12) goto L10;
        r13 = r13 | t(r11[r10]);
        r10 = r10 + 1;
        goto L8
    L10:
        return r13;
    L12:
        if ((r8 instanceof Parcelable) == true) goto L14;
        return 0;
    L14:
        return ((Parcelable) r8).describeContents();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return t(this.f4202a) | 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeTypedArray(this.f4202a, r10);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        r8.writeInt(r12 - r11);
        r8.setDataPosition(r12);
    }
}
