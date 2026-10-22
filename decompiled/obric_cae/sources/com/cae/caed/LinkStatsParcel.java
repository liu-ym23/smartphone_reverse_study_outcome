package com.cae.caed;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class LinkStatsParcel implements Parcelable {
    public static final Parcelable.Creator<LinkStatsParcel> CREATOR = null;
    public long A;
    public long B;
    public int C;
    public long D;
    public long E;
    public int F;
    public long G;
    public long H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4140b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4154z;

    public class a implements Parcelable.Creator<LinkStatsParcel> {
        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel createFromParcel(Parcel r8) {
            LinkStatsParcel r10 = new LinkStatsParcel();
            int r11 = r8.dataPosition();
            int r12 = r8.readInt();
            if (r12 < 4) goto L308;
            if ((r8.dataPosition() - r11) >= r12) goto L8;
            r10.f4139a = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L16;
            r10.f4140b = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L24;
            r10.f4141m = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L32;
            r10.f4142n = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L40;
            r10.f4143o = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L48;
            r10.f4144p = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L56;
            r10.f4145q = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L64;
            r10.f4146r = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L72;
            r10.f4147s = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L80;
            r10.f4148t = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L88;
            r10.f4149u = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L96;
            r10.f4150v = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L104;
            r10.f4151w = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L112;
            r10.f4152x = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L120;
            r10.f4153y = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L128;
            r10.f4154z = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L136;
            r10.A = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L144;
            r10.B = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L152;
            r10.C = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L160;
            r10.D = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L168;
            r10.E = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L176;
            r10.F = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L184;
            r10.G = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L192;
            r10.H = r8.readLong();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L200;
            r10.I = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L208;
            r10.J = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L216;
            r10.K = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L224;
            r10.L = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L232;
            r10.M = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L240;
            r10.N = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L248;
            r10.O = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L256;
            r10.P = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L264;
            r10.Q = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L272;
            r10.R = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L280;
            r10.S = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L288;
            r10.T = r8.readInt();     // Catch: Throwable -> L309
            if ((r8.dataPosition() - r11) >= r12) goto L296;
            r10.U = r8.readFloat();     // Catch: Throwable -> L309
            if (r11 > (Integer.MAX_VALUE - r12)) goto L306;
        L303:
            r8.setDataPosition(r11 + r12);
            return r10;
        L306:
            throw new BadParcelableException("Overflow in the size of parcelable");
        L296:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L288:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L280:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L272:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L264:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L256:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L248:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L240:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L232:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L224:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L216:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L208:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L200:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L192:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L184:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L176:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L168:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L160:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L152:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L144:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L136:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L128:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L120:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L112:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L104:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L96:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L88:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L80:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L72:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L64:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L56:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L48:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L40:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L32:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L24:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L16:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L8:
            if (r11 <= (Integer.MAX_VALUE - r12)) goto L303;
            throw new BadParcelableException("Overflow in the size of parcelable");
        L308:
            throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L309
        L309:
            th = move-exception;
            if (r11 > (Integer.MAX_VALUE - r12)) goto L313;
            r8.setDataPosition(r11 + r12);
            throw th;
        L313:
            throw new BadParcelableException("Overflow in the size of parcelable");
        }

        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel[] newArray(int r8) {
            return new LinkStatsParcel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public LinkStatsParcel() {
        this.f4139a = 0;
        this.f4140b = 0;
        this.f4141m = 0;
        this.f4142n = 0;
        this.f4143o = 0;
        this.f4144p = 0;
        this.f4145q = 0;
        this.f4146r = 0;
        this.f4147s = 0;
        this.f4148t = 0;
        this.f4149u = 0;
        this.f4150v = 0;
        this.f4151w = 0;
        this.f4152x = 0;
        this.f4153y = 0;
        this.f4154z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0.0f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f4139a);
        r8.writeInt(this.f4140b);
        r8.writeInt(this.f4141m);
        r8.writeInt(this.f4142n);
        r8.writeInt(this.f4143o);
        r8.writeInt(this.f4144p);
        r8.writeLong(this.f4145q);
        r8.writeLong(this.f4146r);
        r8.writeInt(this.f4147s);
        r8.writeLong(this.f4148t);
        r8.writeInt(this.f4149u);
        r8.writeInt(this.f4150v);
        r8.writeInt(this.f4151w);
        r8.writeInt(this.f4152x);
        r8.writeInt(this.f4153y);
        r8.writeInt(this.f4154z);
        r8.writeLong(this.A);
        r8.writeLong(this.B);
        r8.writeInt(this.C);
        r8.writeLong(this.D);
        r8.writeLong(this.E);
        r8.writeInt(this.F);
        r8.writeLong(this.G);
        r8.writeLong(this.H);
        r8.writeInt(this.I);
        r8.writeInt(this.J);
        r8.writeInt(this.K);
        r8.writeInt(this.L);
        r8.writeInt(this.M);
        r8.writeInt(this.N);
        r8.writeInt(this.O);
        r8.writeInt(this.P);
        r8.writeInt(this.Q);
        r8.writeInt(this.R);
        r8.writeInt(this.S);
        r8.writeInt(this.T);
        r8.writeFloat(this.U);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
