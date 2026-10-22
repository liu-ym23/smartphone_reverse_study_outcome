package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QshHarEventParcel implements Parcelable {
    public static final Parcelable.Creator<QshHarEventParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12927b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f12928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f12929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f12930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f12931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f12932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f12933r;

    public class a implements Parcelable.Creator<QshHarEventParcel> {
        @Override // android.os.Parcelable.Creator
        public final QshHarEventParcel createFromParcel(Parcel r8) {
            return new QshHarEventParcel(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarEventParcel[] newArray(int r8) {
            return new QshHarEventParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarEventParcel() {
    }

    public QshHarEventParcel(Parcel r8) {
        int r10 = r8.readInt();
        int r11 = r8.dataPosition();
        if (r10 < 4) goto L5;
    L40:
        th = move-exception;
        if (r11 > (Integer.MAX_VALUE - r10)) goto L44;
        r8.setDataPosition(r11 + r10);
        throw th;
    L44:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r8.dataPosition() - r11) >= r10) goto L14;
        this.f12926a = r8.readInt();     // Catch: Throwable -> L40
    L14:
        if ((r8.dataPosition() - r11) >= r10) goto L17;
        this.f12927b = r8.readFloat();     // Catch: Throwable -> L40
    L17:
        if ((r8.dataPosition() - r11) >= r10) goto L20;
        this.f12928m = r8.readFloat();     // Catch: Throwable -> L40
    L20:
        if ((r8.dataPosition() - r11) >= r10) goto L23;
        this.f12929n = r8.readInt();     // Catch: Throwable -> L40
    L23:
        if ((r8.dataPosition() - r11) >= r10) goto L26;
        this.f12930o = r8.readFloat();     // Catch: Throwable -> L40
    L26:
        if ((r8.dataPosition() - r11) >= r10) goto L29;
        this.f12931p = r8.readFloat();     // Catch: Throwable -> L40
    L29:
        if ((r8.dataPosition() - r11) >= r10) goto L32;
        this.f12932q = r8.readLong();     // Catch: Throwable -> L40
    L32:
        if ((r8.dataPosition() - r11) >= r10) goto L35;
        this.f12933r = r8.readLong();     // Catch: Throwable -> L40
    L35:
        if (r11 > (Integer.MAX_VALUE - r10)) goto L39;
        r8.setDataPosition(r11 + r10);
        return;
    L39:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L5:
        if (r11 > (Integer.MAX_VALUE - r10)) goto L9;
        r8.setDataPosition(r11 + r10);
        return;
    L9:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f12926a);
        r8.writeFloat(this.f12927b);
        r8.writeFloat(this.f12928m);
        r8.writeInt(this.f12929n);
        r8.writeFloat(this.f12930o);
        r8.writeFloat(this.f12931p);
        r8.writeLong(this.f12932q);
        r8.writeLong(this.f12933r);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
