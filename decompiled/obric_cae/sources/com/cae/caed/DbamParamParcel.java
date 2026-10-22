package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DbamParamParcel implements Parcelable {
    public static final Parcelable.Creator<DbamParamParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4103b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4106o;

    public class a implements Parcelable.Creator<DbamParamParcel> {
        @Override // android.os.Parcelable.Creator
        public final DbamParamParcel createFromParcel(Parcel r8) {
            DbamParamParcel r10 = new DbamParamParcel();
            r10.t(r8);
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final DbamParamParcel[] newArray(int r8) {
            return new DbamParamParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public DbamParamParcel() {
        this.f4102a = 0;
        this.f4103b = 0;
        this.f4104m = 0;
        this.f4105n = 0;
        this.f4106o = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void t(Parcel r8) {
        int r10 = r8.dataPosition();
        int r11 = r8.readInt();
        if (r11 < 4) goto L55;
        if ((r8.dataPosition() - r10) >= r11) goto L8;
        this.f4102a = r8.readInt();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r10) >= r11) goto L17;
        this.f4103b = r8.readInt();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r10) >= r11) goto L25;
        this.f4104m = r8.readInt();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r10) >= r11) goto L33;
        this.f4105n = r8.readInt();     // Catch: Throwable -> L52
        if ((r8.dataPosition() - r10) >= r11) goto L41;
        this.f4106o = r8.readInt();     // Catch: Throwable -> L52
        if (r10 > (Integer.MAX_VALUE - r11)) goto L51;
        r8.setDataPosition(r10 + r11);
        return;
    L51:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L41:
        if (r10 > (Integer.MAX_VALUE - r11)) goto L44;
    L9:
        r8.setDataPosition(r10 + r11);
        return;
    L44:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r10 <= (Integer.MAX_VALUE - r11)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L55:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if (r10 > (Integer.MAX_VALUE - r11)) goto L59;
        r8.setDataPosition(r10 + r11);
        throw th;
    L59:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4102a);
        r8.writeInt(this.f4103b);
        r8.writeInt(this.f4104m);
        r8.writeInt(this.f4105n);
        r8.writeInt(this.f4106o);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
