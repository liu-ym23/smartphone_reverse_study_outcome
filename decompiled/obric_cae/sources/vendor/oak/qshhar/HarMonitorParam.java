package vendor.oak.qshhar;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class HarMonitorParam implements Parcelable {
    public static final Parcelable.Creator<HarMonitorParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12909b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12910m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12911n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12912o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12913p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12914q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12915r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12916s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12917t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12918u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12919v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12920w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12921x;

    public class a implements Parcelable.Creator<HarMonitorParam> {
        @Override // android.os.Parcelable.Creator
        public final HarMonitorParam createFromParcel(Parcel r8) {
            return new HarMonitorParam(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final HarMonitorParam[] newArray(int r8) {
            return new HarMonitorParam[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarMonitorParam() {
    }

    public HarMonitorParam(Parcel r8) {
        int r10 = r8.readInt();
        int r11 = r8.dataPosition();
        if (r10 < 4) goto L5;
    L58:
        th = move-exception;
        if (r11 > (Integer.MAX_VALUE - r10)) goto L62;
        r8.setDataPosition(r11 + r10);
        throw th;
    L62:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L11:
        if ((r8.dataPosition() - r11) >= r10) goto L14;
        this.f12908a = r8.readInt();     // Catch: Throwable -> L58
    L14:
        if ((r8.dataPosition() - r11) >= r10) goto L17;
        this.f12909b = r8.readInt();     // Catch: Throwable -> L58
    L17:
        if ((r8.dataPosition() - r11) >= r10) goto L20;
        this.f12910m = r8.readInt();     // Catch: Throwable -> L58
    L20:
        if ((r8.dataPosition() - r11) >= r10) goto L23;
        this.f12911n = r8.readInt();     // Catch: Throwable -> L58
    L23:
        if ((r8.dataPosition() - r11) >= r10) goto L26;
        this.f12912o = r8.readInt();     // Catch: Throwable -> L58
    L26:
        if ((r8.dataPosition() - r11) >= r10) goto L29;
        this.f12913p = r8.readInt();     // Catch: Throwable -> L58
    L29:
        if ((r8.dataPosition() - r11) >= r10) goto L32;
        this.f12914q = r8.readInt();     // Catch: Throwable -> L58
    L32:
        if ((r8.dataPosition() - r11) >= r10) goto L35;
        this.f12915r = r8.readInt();     // Catch: Throwable -> L58
    L35:
        if ((r8.dataPosition() - r11) >= r10) goto L38;
        this.f12916s = r8.readInt();     // Catch: Throwable -> L58
    L38:
        if ((r8.dataPosition() - r11) >= r10) goto L41;
        this.f12917t = r8.readInt();     // Catch: Throwable -> L58
    L41:
        if ((r8.dataPosition() - r11) >= r10) goto L44;
        this.f12918u = r8.readInt();     // Catch: Throwable -> L58
    L44:
        if ((r8.dataPosition() - r11) >= r10) goto L47;
        this.f12919v = r8.readInt();     // Catch: Throwable -> L58
    L47:
        if ((r8.dataPosition() - r11) >= r10) goto L50;
        this.f12920w = r8.readInt();     // Catch: Throwable -> L58
    L50:
        if ((r8.dataPosition() - r11) >= r10) goto L53;
        this.f12921x = r8.readInt();     // Catch: Throwable -> L58
    L53:
        if (r11 > (Integer.MAX_VALUE - r10)) goto L57;
        r8.setDataPosition(r11 + r10);
        return;
    L57:
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
        r8.writeInt(this.f12908a);
        r8.writeInt(this.f12909b);
        r8.writeInt(this.f12910m);
        r8.writeInt(this.f12911n);
        r8.writeInt(this.f12912o);
        r8.writeInt(this.f12913p);
        r8.writeInt(this.f12914q);
        r8.writeInt(this.f12915r);
        r8.writeInt(this.f12916s);
        r8.writeInt(this.f12917t);
        r8.writeInt(this.f12918u);
        r8.writeInt(this.f12919v);
        r8.writeInt(this.f12920w);
        r8.writeInt(this.f12921x);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
