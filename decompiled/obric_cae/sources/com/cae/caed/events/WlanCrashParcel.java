package com.cae.caed.events;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class WlanCrashParcel implements Parcelable {
    public static final Parcelable.Creator<WlanCrashParcel> CREATOR = null;
    public String A;
    public int B;
    public String C;
    public int D;
    public String E;
    public int F;
    public String G;
    public String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4261b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4265p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4266q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f4267r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f4268s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4269t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f4270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f4271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f4272w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f4273x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4274y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f4275z;

    public class a implements Parcelable.Creator<WlanCrashParcel> {
        @Override // android.os.Parcelable.Creator
        public final WlanCrashParcel createFromParcel(Parcel r8) {
            WlanCrashParcel r10 = new WlanCrashParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L204;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4260a = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4261b = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4262m = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4263n = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4264o = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4265p = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4266q = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4267r = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4268s = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4269t = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4270u = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L96;
            r10.f4271v = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L104;
            r10.f4272w = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L112;
            r10.f4273x = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L120;
            r10.f4274y = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L128;
            r10.f4275z = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L136;
            r10.A = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L144;
            r10.B = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L152;
            r10.C = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L160;
            r10.D = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L168;
            r10.E = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L176;
            r10.F = r8.readInt();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L184;
            r10.G = r8.readString();     // Catch: Throwable -> L205
            if ((r8.dataPosition() - r11) >= r12) goto L192;
            r10.H = r8.readString();     // Catch: Throwable -> L205
            if (r11 > (Integer.MAX_VALUE - r12)) goto L202;
        L199:
            r8.setDataPosition(r11 + r12);
            return r10;
        L202:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L192:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L184:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L176:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L168:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L160:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L152:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L144:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L136:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L128:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L120:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L112:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L104:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L96:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L199;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L204:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L205
        L205:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L209;
            r8.setDataPosition(r11 + r12);
            throw th;
        L209:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final WlanCrashParcel[] newArray(int r8) {
            return new WlanCrashParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public WlanCrashParcel() {
        this.f4260a = 0;
        this.f4261b = 0;
        this.f4262m = 0;
        this.f4263n = 0;
        this.f4264o = 0;
        this.f4265p = 0;
        this.f4266q = 0;
        this.f4274y = 0;
        this.B = 0;
        this.D = 0;
        this.F = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4260a);
        r8.writeInt(this.f4261b);
        r8.writeInt(this.f4262m);
        r8.writeInt(this.f4263n);
        r8.writeInt(this.f4264o);
        r8.writeInt(this.f4265p);
        r8.writeInt(this.f4266q);
        r8.writeString(this.f4267r);
        r8.writeString(this.f4268s);
        r8.writeString(this.f4269t);
        r8.writeString(this.f4270u);
        r8.writeString(this.f4271v);
        r8.writeString(this.f4272w);
        r8.writeString(this.f4273x);
        r8.writeInt(this.f4274y);
        r8.writeString(this.f4275z);
        r8.writeString(this.A);
        r8.writeInt(this.B);
        r8.writeString(this.C);
        r8.writeInt(this.D);
        r8.writeString(this.E);
        r8.writeInt(this.F);
        r8.writeString(this.G);
        r8.writeString(this.H);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
