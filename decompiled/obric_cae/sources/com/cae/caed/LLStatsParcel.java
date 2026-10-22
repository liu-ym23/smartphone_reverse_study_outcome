package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class LLStatsParcel implements Parcelable {
    public static final Parcelable.Creator<LLStatsParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AcStatsParcel f4130b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AcStatsParcel f4131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AcStatsParcel f4132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AcStatsParcel f4133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f4138t;

    public class a implements Parcelable.Creator<LLStatsParcel> {
        @Override // android.os.Parcelable.Creator
        public final LLStatsParcel createFromParcel(Parcel r8) {
            LLStatsParcel r10 = new LLStatsParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L92;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4129a = r8.readInt();     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            Parcelable.Creator<AcStatsParcel> r13 = AcStatsParcel.CREATOR;     // Catch: Throwable -> L93
            r10.f4130b = (AcStatsParcel) r8.readTypedObject(r13);     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4131m = (AcStatsParcel) r8.readTypedObject(r13);     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4132n = (AcStatsParcel) r8.readTypedObject(r13);     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4133o = (AcStatsParcel) r8.readTypedObject(r13);     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4134p = r8.readInt();     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4135q = r8.readInt();     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4136r = r8.readInt();     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4137s = r8.readInt();     // Catch: Throwable -> L93
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4138t = r8.createTypedArrayList(ChannelStatsParcel.CREATOR);     // Catch: Throwable -> L93
            if (r11 > (Integer.MAX_VALUE - r12)) goto L90;
        L87:
            r8.setDataPosition(r11 + r12);
            return r10;
        L90:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L87;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L92:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L93
        L93:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L97;
            r8.setDataPosition(r11 + r12);
            throw th;
        L97:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final LLStatsParcel[] newArray(int r8) {
            return new LLStatsParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public LLStatsParcel() {
        this.f4129a = 0;
        this.f4134p = 0;
        this.f4135q = 0;
        this.f4136r = 0;
        this.f4137s = 0;
    }

    public static int t(Object r8) {
        int r10 = 0;
        if (r8 != null) goto L6;
        return 0;
    L6:
        if ((r8 instanceof Collection) == false) goto L13;
        Iterator r11 = ((Collection) r8).iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r10 = r10 | t(r11.next());
        goto L9
    L11:
        return r10;
    L13:
        if ((r8 instanceof Parcelable) == true) goto L15;
        return 0;
    L15:
        return ((Parcelable) r8).describeContents();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        int r8 = (((t(this.f4130b) | 0) | t(this.f4131m)) | t(this.f4132n)) | t(this.f4133o);
        return t(this.f4138t) | r8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        int r12 = 0;
        r8.writeInt(0);
        r8.writeInt(this.f4129a);
        r8.writeTypedObject(this.f4130b, r10);
        r8.writeTypedObject(this.f4131m, r10);
        r8.writeTypedObject(this.f4132n, r10);
        r8.writeTypedObject(this.f4133o, r10);
        r8.writeInt(this.f4134p);
        r8.writeInt(this.f4135q);
        r8.writeInt(this.f4136r);
        r8.writeInt(this.f4137s);
        ArrayList r13 = this.f4138t;
        if (r13 != null) goto L5;
        r8.writeInt(-1);
    L8:
        int r14 = r8.dataPosition();
        r8.setDataPosition(r11);
        r8.writeInt(r14 - r11);
        r8.setDataPosition(r14);
        return;
    L5:
        int r15 = r13.size();
        r8.writeInt(r15);
    L6:
        if (r12 >= r15) goto L8;
        r8.writeTypedObject((Parcelable) r13.get(r12), r10);
        r12 = r12 + 1;
        goto L6
    }
}
