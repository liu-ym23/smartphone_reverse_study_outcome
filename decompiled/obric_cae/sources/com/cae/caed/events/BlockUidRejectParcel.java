package com.cae.caed.events;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BlockUidRejectParcel implements Parcelable {
    public static final Parcelable.Creator<BlockUidRejectParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4225b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4227n;

    public class a implements Parcelable.Creator<BlockUidRejectParcel> {
        @Override // android.os.Parcelable.Creator
        public final BlockUidRejectParcel createFromParcel(Parcel r8) {
            BlockUidRejectParcel r10 = new BlockUidRejectParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L44;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4224a = r8.readInt();     // Catch: Throwable -> L45
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4225b = r8.readString();     // Catch: Throwable -> L45
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4226m = r8.readString();     // Catch: Throwable -> L45
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4227n = r8.readLong();     // Catch: Throwable -> L45
            if (r11 > (Integer.MAX_VALUE - r12)) goto L42;
        L39:
            r8.setDataPosition(r11 + r12);
            return r10;
        L42:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L39;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L39;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L39;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L39;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L44:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L45
        L45:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L49;
            r8.setDataPosition(r11 + r12);
            throw th;
        L49:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final BlockUidRejectParcel[] newArray(int r8) {
            return new BlockUidRejectParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BlockUidRejectParcel() {
        this.f4224a = 0;
        this.f4227n = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4224a);
        r8.writeString(this.f4225b);
        r8.writeString(this.f4226m);
        r8.writeLong(this.f4227n);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
