package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QshHarWifiStandardData implements Parcelable {
    public static final Parcelable.Creator<QshHarWifiStandardData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12938b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12939m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f12940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f12941o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f12942p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f12943q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f12944r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f12945s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f12946t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12947u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12948v;

    public class a implements Parcelable.Creator<QshHarWifiStandardData> {
        @Override // android.os.Parcelable.Creator
        public final QshHarWifiStandardData createFromParcel(Parcel r8) {
            return new QshHarWifiStandardData(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final QshHarWifiStandardData[] newArray(int r8) {
            return new QshHarWifiStandardData[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public QshHarWifiStandardData() {
    }

    public QshHarWifiStandardData(Parcel r8) {
        int r10 = r8.readInt();
        int r11 = r8.dataPosition();
        if (r10 < 4) goto L5;
    L52:
        th = move-exception;
        if (r11 > (Integer.MAX_VALUE - r10)) goto L56;
        r8.setDataPosition(r11 + r10);
        throw th;
    L56:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r8.dataPosition() - r11) >= r10) goto L14;
        this.f12937a = r8.readString();     // Catch: Throwable -> L52
    L14:
        if ((r8.dataPosition() - r11) >= r10) goto L17;
        this.f12938b = r8.readString();     // Catch: Throwable -> L52
    L17:
        if ((r8.dataPosition() - r11) >= r10) goto L20;
        this.f12939m = r8.readInt();     // Catch: Throwable -> L52
    L20:
        if ((r8.dataPosition() - r11) >= r10) goto L23;
        this.f12940n = r8.readInt();     // Catch: Throwable -> L52
    L23:
        if ((r8.dataPosition() - r11) >= r10) goto L26;
        this.f12941o = r8.readInt();     // Catch: Throwable -> L52
    L26:
        if ((r8.dataPosition() - r11) >= r10) goto L29;
        this.f12942p = r8.readInt();     // Catch: Throwable -> L52
    L29:
        if ((r8.dataPosition() - r11) >= r10) goto L32;
        this.f12943q = r8.readLong();     // Catch: Throwable -> L52
    L32:
        if ((r8.dataPosition() - r11) >= r10) goto L35;
        this.f12944r = r8.readLong();     // Catch: Throwable -> L52
    L35:
        if ((r8.dataPosition() - r11) >= r10) goto L38;
        this.f12945s = r8.readLong();     // Catch: Throwable -> L52
    L38:
        if ((r8.dataPosition() - r11) >= r10) goto L41;
        this.f12946t = r8.readInt();     // Catch: Throwable -> L52
    L41:
        if ((r8.dataPosition() - r11) >= r10) goto L44;
        this.f12947u = r8.readInt();     // Catch: Throwable -> L52
    L44:
        if ((r8.dataPosition() - r11) >= r10) goto L47;
        this.f12948v = r8.readInt();     // Catch: Throwable -> L52
    L47:
        if (r11 > (Integer.MAX_VALUE - r10)) goto L51;
        r8.setDataPosition(r11 + r10);
        return;
    L51:
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
        r8.writeString(this.f12937a);
        r8.writeString(this.f12938b);
        r8.writeInt(this.f12939m);
        r8.writeInt(this.f12940n);
        r8.writeInt(this.f12941o);
        r8.writeInt(this.f12942p);
        r8.writeLong(this.f12943q);
        r8.writeLong(this.f12944r);
        r8.writeLong(this.f12945s);
        r8.writeInt(this.f12946t);
        r8.writeInt(this.f12947u);
        r8.writeInt(this.f12948v);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
