package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ChannelStatsParcel implements Parcelable {
    public static final Parcelable.Creator<ChannelStatsParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4098b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4101o;

    public class a implements Parcelable.Creator<ChannelStatsParcel> {
        @Override // android.os.Parcelable.Creator
        public final ChannelStatsParcel createFromParcel(Parcel r8) {
            ChannelStatsParcel r10 = new ChannelStatsParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L52;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4097a = r8.readInt();     // Catch: Throwable -> L53
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4098b = r8.readInt();     // Catch: Throwable -> L53
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4099m = r8.readInt();     // Catch: Throwable -> L53
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4100n = r8.readInt();     // Catch: Throwable -> L53
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4101o = r8.readInt();     // Catch: Throwable -> L53
            if (r11 > (Integer.MAX_VALUE - r12)) goto L50;
        L47:
            r8.setDataPosition(r11 + r12);
            return r10;
        L50:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L47;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L47;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L47;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L47;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L47;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L52:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L53
        L53:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L57;
            r8.setDataPosition(r11 + r12);
            throw th;
        L57:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final ChannelStatsParcel[] newArray(int r8) {
            return new ChannelStatsParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChannelStatsParcel() {
        this.f4097a = 0;
        this.f4098b = 0;
        this.f4099m = 0;
        this.f4100n = 0;
        this.f4101o = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4097a);
        r8.writeInt(this.f4098b);
        r8.writeInt(this.f4099m);
        r8.writeInt(this.f4100n);
        r8.writeInt(this.f4101o);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
