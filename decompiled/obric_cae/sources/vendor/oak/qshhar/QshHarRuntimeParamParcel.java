package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QshHarRuntimeParamParcel implements Parcelable {
    public static final Parcelable.Creator<QshHarRuntimeParamParcel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12935b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12936m;

    public class a implements Parcelable.Creator<QshHarRuntimeParamParcel> {
        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamParcel createFromParcel(Parcel r8) {
            return new QshHarRuntimeParamParcel(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarRuntimeParamParcel[] newArray(int r8) {
            return new QshHarRuntimeParamParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarRuntimeParamParcel() {
    }

    public QshHarRuntimeParamParcel(Parcel r8) {
        int r10 = r8.readInt();
        int r11 = r8.dataPosition();
        if (r10 < 4) goto L5;
    L25:
        th = move-exception;
        if (r11 > (Integer.MAX_VALUE - r10)) goto L29;
        r8.setDataPosition(r11 + r10);
        throw th;
    L29:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r8.dataPosition() - r11) >= r10) goto L14;
        this.f12934a = r8.readInt();     // Catch: Throwable -> L25
    L14:
        if ((r8.dataPosition() - r11) >= r10) goto L17;
        this.f12935b = r8.readInt();     // Catch: Throwable -> L25
    L17:
        if ((r8.dataPosition() - r11) >= r10) goto L20;
        this.f12936m = r8.readInt();     // Catch: Throwable -> L25
    L20:
        if (r11 > (Integer.MAX_VALUE - r10)) goto L24;
        r8.setDataPosition(r11 + r10);
        return;
    L24:
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
        r8.writeInt(this.f12934a);
        r8.writeInt(this.f12935b);
        r8.writeInt(this.f12936m);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
