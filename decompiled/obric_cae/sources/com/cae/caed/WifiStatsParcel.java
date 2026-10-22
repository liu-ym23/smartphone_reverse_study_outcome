package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WifiStatsParcel implements Parcelable {
    public static final Parcelable.Creator<WifiStatsParcel> CREATOR = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public ArrayList H;
    public float I;
    public float J;
    public long K;
    public float L;
    public float M;
    public float N;
    public int[] O;
    public byte P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4204b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4206n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4207o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4208p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4209q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4210r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4211s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4212t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4216x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4217y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4218z;

    public class a implements Parcelable.Creator<WifiStatsParcel> {
        @Override // android.os.Parcelable.Creator
        public final WifiStatsParcel createFromParcel(Parcel r8) {
            WifiStatsParcel r10 = new WifiStatsParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L320;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4203a = r8.readString();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4204b = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4205m = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4206n = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4207o = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4208p = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4209q = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4210r = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4211s = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4212t = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4213u = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L96;
            r10.f4214v = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L104;
            r10.f4215w = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L112;
            r10.f4216x = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L120;
            r10.f4217y = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L128;
            r10.f4218z = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L136;
            r10.A = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L144;
            r10.B = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L152;
            r10.C = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L160;
            r10.D = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L168;
            r10.E = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L176;
            r10.F = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) < r12) goto L189;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L187;
        L315:
            r8.setDataPosition(r11 + r12);
            return r10;
        L187:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L189:
            if (r8.readInt() == 0) goto L191;
            boolean r13 = true;
        L192:
            r10.G = r13;     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L196;
            r10.H = r8.createTypedArrayList(LinkStatsParcel.CREATOR);     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L204;
            r10.I = r8.readFloat();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L212;
            r10.J = r8.readFloat();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L220;
            r10.K = r8.readLong();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L228;
            r10.L = r8.readFloat();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L236;
            r10.M = r8.readFloat();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L244;
            r10.N = r8.readFloat();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L252;
            r10.O = r8.createIntArray();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L260;
            r10.P = r8.readByte();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L268;
            r10.Q = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L276;
            r10.R = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L284;
            r10.S = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L292;
            r10.T = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L300;
            r10.U = r8.readInt();     // Catch: Throwable -> L321
            if ((r8.dataPosition() - r11) >= r12) goto L308;
            r10.V = r8.readInt();     // Catch: Throwable -> L321
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L308:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L300:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L292:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L284:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L276:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L268:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L260:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L252:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L244:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L236:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L228:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L220:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L212:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L204:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L196:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L191:
            r13 = false;
            goto L192
        L176:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L168:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L160:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L152:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L144:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L136:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L128:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L120:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L112:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L104:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L96:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L315;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L320:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L321
        L321:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L325;
            r8.setDataPosition(r11 + r12);
            throw th;
        L325:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final WifiStatsParcel[] newArray(int r8) {
            return new WifiStatsParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public WifiStatsParcel() {
        this.f4204b = 0;
        this.f4205m = 0;
        this.f4206n = 0;
        this.f4207o = 0;
        this.f4208p = 0;
        this.f4209q = 0;
        this.f4210r = 0;
        this.f4211s = 0;
        this.f4212t = 0;
        this.f4213u = 0;
        this.f4214v = 0;
        this.f4215w = 0;
        this.f4216x = 0;
        this.f4217y = 0;
        this.f4218z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
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
        return t(this.H) | 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        int r12 = 0;
        r8.writeInt(0);
        r8.writeString(this.f4203a);
        r8.writeInt(this.f4204b);
        r8.writeInt(this.f4205m);
        r8.writeInt(this.f4206n);
        r8.writeInt(this.f4207o);
        r8.writeInt(this.f4208p);
        r8.writeInt(this.f4209q);
        r8.writeInt(this.f4210r);
        r8.writeInt(this.f4211s);
        r8.writeInt(this.f4212t);
        r8.writeInt(this.f4213u);
        r8.writeInt(this.f4214v);
        r8.writeInt(this.f4215w);
        r8.writeInt(this.f4216x);
        r8.writeInt(this.f4217y);
        r8.writeInt(this.f4218z);
        r8.writeInt(this.A);
        r8.writeInt(this.B);
        r8.writeInt(this.C);
        r8.writeInt(this.D);
        r8.writeInt(this.E);
        r8.writeInt(this.F);
        r8.writeInt(this.G ? 1 : 0);
        ArrayList r13 = this.H;
        if (r13 != null) goto L5;
        r8.writeInt(-1);
    L8:
        r8.writeFloat(this.I);
        r8.writeFloat(this.J);
        r8.writeLong(this.K);
        r8.writeFloat(this.L);
        r8.writeFloat(this.M);
        r8.writeFloat(this.N);
        r8.writeIntArray(this.O);
        r8.writeByte(this.P);
        r8.writeInt(this.Q);
        r8.writeInt(this.R);
        r8.writeInt(this.S);
        r8.writeInt(this.T);
        r8.writeInt(this.U);
        r8.writeInt(this.V);
        int r14 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r14, r11, r8, r14);
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
