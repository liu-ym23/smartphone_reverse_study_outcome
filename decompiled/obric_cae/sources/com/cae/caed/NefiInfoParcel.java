package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class NefiInfoParcel implements Parcelable {
    public static final Parcelable.Creator<NefiInfoParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StaInfoParcel f4156b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f4158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f4159o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f4160p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4161q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4162r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f4164t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f4165u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f4166v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte f4167w;

    public class a implements Parcelable.Creator<NefiInfoParcel> {
        @Override // android.os.Parcelable.Creator
        public final NefiInfoParcel createFromParcel(Parcel r8) {
            NefiInfoParcel r10 = new NefiInfoParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L120;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4155a = r8.readString();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4156b = (StaInfoParcel) r8.readTypedObject(StaInfoParcel.CREATOR);     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) < r12) goto L29;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L27;
        L115:
            r8.setDataPosition(r11 + r12);
            return r10;
        L27:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L29:
            if (r8.readInt() == 0) goto L31;
            boolean r13 = true;
        L32:
            r10.f4157m = r13;     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L36;
            r10.f4158n = r8.createTypedArrayList(LLStatsParcel.CREATOR);     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L44;
            r10.f4159o = r8.createTypedArrayList(ChannelStatsParcel.CREATOR);     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L52;
            r10.f4160p = r8.createTypedArrayList(DeltaInfoParcel.CREATOR);     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L60;
            r10.f4161q = r8.readFloat();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L68;
            r10.f4162r = r8.readFloat();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L76;
            r10.f4163s = r8.readLong();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L84;
            r10.f4164t = r8.readFloat();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L92;
            r10.f4165u = r8.readFloat();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L100;
            r10.f4166v = r8.readFloat();     // Catch: Throwable -> L121
            if ((r8.dataPosition() - r11) >= r12) goto L108;
            r10.f4167w = r8.readByte();     // Catch: Throwable -> L121
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L108:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L100:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L92:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L84:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L76:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L68:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L60:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L52:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L44:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L36:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L31:
            r13 = false;
            goto L32
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L115;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L120:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L121
        L121:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L125;
            r8.setDataPosition(r11 + r12);
            throw th;
        L125:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final NefiInfoParcel[] newArray(int r8) {
            return new NefiInfoParcel[r8];
        }
    }

    public static class b {
        public static void a(Parcel r8, ArrayList r10, int r11) {
            if (r10 != null) goto L4;
            r8.writeInt(-1);
            return;
        L4:
            int r12 = r10.size();
            r8.writeInt(r12);
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L9;
            r8.writeTypedObject((Parcelable) r10.get(r13), r11);
            r13 = r13 + 1;
            goto L5
        }
    }

    static {
        CREATOR = new a();
    }

    public NefiInfoParcel() {
        this.f4157m = false;
        this.f4161q = 0.0f;
        this.f4162r = 0.0f;
        this.f4163s = 0;
        this.f4164t = 0.0f;
        this.f4165u = 0.0f;
        this.f4166v = 0.0f;
        this.f4167w = 0;
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
        int r8 = ((t(this.f4156b) | 0) | t(this.f4158n)) | t(this.f4159o);
        return t(this.f4160p) | r8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeString(this.f4155a);
        r8.writeTypedObject(this.f4156b, r10);
        r8.writeInt(this.f4157m ? 1 : 0);
        b.a(r8, this.f4158n, r10);
        b.a(r8, this.f4159o, r10);
        b.a(r8, this.f4160p, r10);
        r8.writeFloat(this.f4161q);
        r8.writeFloat(this.f4162r);
        r8.writeLong(this.f4163s);
        r8.writeFloat(this.f4164t);
        r8.writeFloat(this.f4165u);
        r8.writeFloat(this.f4166v);
        r8.writeByte(this.f4167w);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
