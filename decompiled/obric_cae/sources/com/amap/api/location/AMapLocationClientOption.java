package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdlocation.entity.region.RegionBean;

/* JADX INFO: loaded from: classes.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = null;
    public static c L;
    public static final String M = null;
    public static boolean N;
    public static long O;
    public long A;
    public e B;
    public boolean C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public float J;
    public d K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3651b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f3656q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f3657r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3658s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3659t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3660u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3661v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3662w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3663x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3664y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f3665z;

    public static class a implements Parcelable.Creator<AMapLocationClientOption> {
        @Override // android.os.Parcelable.Creator
        public final AMapLocationClientOption createFromParcel(Parcel r8) {
            return new AMapLocationClientOption(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final AMapLocationClientOption[] newArray(int r8) {
            return new AMapLocationClientOption[r8];
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f3666a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3667b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f3668m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ b[] f3669n = null;

        static {
            b r8 = new b("Battery_Saving", 0);
            f3666a = r8;
            b r10 = new b("Device_Sensors", 1);
            f3667b = r10;
            b r11 = new b("Hight_Accuracy", 2);
            f3668m = r11;
            f3669n = new b[]{r8, r10, r11};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f3669n.clone();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f3670a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f3671b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ c[] f3672m = null;

        static {
            c r8 = new c("HTTP", 0);
            f3670a = r8;
            c r10 = new c("HTTPS", 1);
            f3671b = r10;
            f3672m = new c[]{r8, r10};
        }

        public c(String r8, int r10) {
            super(r8, r10);
        }

        public static c valueOf(String r8) {
            return (c) Enum.valueOf(c.class, r8);
        }

        public static c[] values() {
            return (c[]) f3672m.clone();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d[] f3673a = null;

        static {
            f3673a = new d[]{new d("SignIn", 0), new d("Transport", 1), new d("Sport", 2)};
        }

        public d(String r8, int r10) {
            super(r8, r10);
        }

        public static d valueOf(String r8) {
            return (d) Enum.valueOf(d.class, r8);
        }

        public static d[] values() {
            return (d[]) f3673a.clone();
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f3674a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f3675b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ e[] f3676m = null;

        static {
            e r8 = new e("DEFAULT", 0);
            f3674a = r8;
            e r10 = new e("ZH", 1);
            e r11 = new e("EN", 2);
            f3675b = r11;
            f3676m = new e[]{r8, r10, r11};
        }

        public e(String r8, int r10) {
            super(r8, r10);
        }

        public static e valueOf(String r8) {
            return (e) Enum.valueOf(e.class, r8);
        }

        public static e[] values() {
            return (e[]) f3676m.clone();
        }
    }

    static {
        L = c.f3670a;
        M = "";
        CREATOR = new a();
        N = true;
        O = 30000;
    }

    public AMapLocationClientOption() {
        this.f3650a = 2000;
        this.f3651b = 30000;
        this.f3652m = false;
        this.f3653n = true;
        this.f3654o = true;
        this.f3655p = true;
        this.f3656q = true;
        this.f3657r = b.f3668m;
        this.f3658s = false;
        this.f3659t = false;
        this.f3660u = true;
        this.f3661v = true;
        this.f3662w = false;
        this.f3663x = false;
        this.f3664y = true;
        this.f3665z = 30000;
        this.A = 30000;
        this.B = e.f3674a;
        this.C = false;
        this.D = 1500;
        this.E = RegionBean.DEFAULT_EXPIRE_TIME;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = 0.0f;
        this.K = null;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return t();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final AMapLocationClientOption t() {
        super.clone();     // Catch: Throwable -> L4
    L6:
        AMapLocationClientOption r8 = new AMapLocationClientOption();
        r8.f3650a = this.f3650a;
        r8.f3652m = this.f3652m;
        r8.f3657r = this.f3657r;
        r8.f3653n = this.f3653n;
        r8.f3658s = this.f3658s;
        r8.f3659t = this.f3659t;
        r8.F = this.F;
        r8.f3654o = this.f3654o;
        r8.f3655p = this.f3655p;
        r8.f3651b = this.f3651b;
        r8.f3660u = this.f3660u;
        r8.f3661v = this.f3661v;
        r8.f3662w = this.f3662w;
        r8.f3663x = this.f3663x;
        r8.f3664y = this.f3664y;
        r8.f3665z = this.f3665z;
        L = L;
        r8.B = this.B;
        r8.J = this.J;
        r8.K = this.K;
        N = N;
        O = O;
        r8.A = this.A;
        r8.E = this.E;
        r8.C = this.C;
        r8.D = this.D;
        r8.G = this.G;
        r8.H = this.H;
        r8.I = this.I;
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        goto L6
    }

    public final String toString() {
        return "interval:" + String.valueOf(this.f3650a) + "#isOnceLocation:" + String.valueOf(this.f3652m) + "#locationMode:" + String.valueOf(this.f3657r) + "#locationProtocol:" + String.valueOf(L) + "#isMockEnable:" + String.valueOf(this.f3653n) + "#isKillProcess:" + String.valueOf(this.f3658s) + "#isGpsFirst:" + String.valueOf(this.f3659t) + "#isBeidouFirst:" + String.valueOf(this.F) + "#isSelfStartServiceEnable:" + String.valueOf(this.G) + "#noLocReqCgiEnable:" + String.valueOf(this.H) + "#sysNetworkLocEnable:" + String.valueOf(this.I) + "#isNeedAddress:" + String.valueOf(this.f3654o) + "#isWifiActiveScan:" + String.valueOf(this.f3655p) + "#wifiScan:" + String.valueOf(this.f3664y) + "#httpTimeOut:" + String.valueOf(this.f3651b) + "#isLocationCacheEnable:" + String.valueOf(this.f3661v) + "#isOnceLocationLatest:" + String.valueOf(this.f3662w) + "#sensorEnable:" + String.valueOf(this.f3663x) + "#geoLanguage:" + String.valueOf(this.B) + "#locationPurpose:" + String.valueOf(this.K) + "#callback:" + String.valueOf(this.C) + "#time:" + String.valueOf(this.D) + "#";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.f3650a);
        r8.writeLong(this.f3651b);
        r8.writeByte(this.f3652m ? 1 : 0);
        r8.writeByte(this.f3653n ? 1 : 0);
        r8.writeByte(this.f3654o ? 1 : 0);
        r8.writeByte(this.f3655p ? 1 : 0);
        r8.writeByte(this.f3656q ? 1 : 0);
        b r11 = this.f3657r;
        int r12 = -1;
        if (r11 != null) goto L5;
        int r13 = -1;
    L6:
        r8.writeInt(r13);
        r8.writeByte(this.f3658s ? 1 : 0);
        r8.writeByte(this.f3659t ? 1 : 0);
        r8.writeByte(this.F ? 1 : 0);
        r8.writeByte(this.G ? 1 : 0);
        r8.writeByte(this.H ? 1 : 0);
        r8.writeByte(this.I ? 1 : 0);
        r8.writeByte(this.f3660u ? 1 : 0);
        r8.writeByte(this.f3661v ? 1 : 0);
        r8.writeByte(this.f3662w ? 1 : 0);
        r8.writeByte(this.f3663x ? 1 : 0);
        r8.writeByte(this.f3664y ? 1 : 0);
        r8.writeLong(this.f3665z);
        c r14 = L;
        if (r14 != null) goto L9;
        int r15 = -1;
    L10:
        r8.writeInt(r15);
        e r16 = this.B;
        if (r16 != null) goto L13;
        int r17 = -1;
    L14:
        r8.writeInt(r17);
        r8.writeFloat(this.J);
        d r18 = this.K;
        if (r18 == null) goto L18;
        r12 = r18.ordinal();
    L18:
        r8.writeInt(r12);
        r8.writeInt(N ? 1 : 0);
        r8.writeLong(this.A);
        return;
    L13:
        r17 = r16.ordinal();
        goto L14
    L9:
        r15 = r14.ordinal();
        goto L10
    L5:
        r13 = r11.ordinal();
        goto L6
    }

    public AMapLocationClientOption(Parcel r10) {
        this.f3650a = 2000;
        this.f3651b = 30000;
        boolean r8 = false;
        this.f3652m = false;
        this.f3653n = true;
        this.f3654o = true;
        this.f3655p = true;
        this.f3656q = true;
        b r11 = b.f3668m;
        this.f3657r = r11;
        this.f3658s = false;
        this.f3659t = false;
        this.f3660u = true;
        this.f3661v = true;
        this.f3662w = false;
        this.f3663x = false;
        this.f3664y = true;
        this.f3665z = 30000;
        this.A = 30000;
        e r12 = e.f3674a;
        this.B = r12;
        this.C = false;
        this.D = 1500;
        this.E = RegionBean.DEFAULT_EXPIRE_TIME;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = 0.0f;
        d r13 = null;
        this.K = null;
        this.f3650a = r10.readLong();
        this.f3651b = r10.readLong();
        if (r10.readByte() == 0) goto L5;
        boolean r14 = true;
    L6:
        this.f3652m = r14;
        if (r10.readByte() == 0) goto L9;
        boolean r15 = true;
    L10:
        this.f3653n = r15;
        if (r10.readByte() == 0) goto L13;
        boolean r16 = true;
    L14:
        this.f3654o = r16;
        if (r10.readByte() == 0) goto L17;
        boolean r17 = true;
    L18:
        this.f3655p = r17;
        if (r10.readByte() == 0) goto L21;
        boolean r18 = true;
    L22:
        this.f3656q = r18;
        int r19 = r10.readInt();
        if (r19 == (-1)) goto L26;
        r11 = b.values()[r19];
    L26:
        this.f3657r = r11;
        if (r10.readByte() == 0) goto L29;
        boolean r20 = true;
    L30:
        this.f3658s = r20;
        if (r10.readByte() == 0) goto L33;
        boolean r21 = true;
    L34:
        this.f3659t = r21;
        if (r10.readByte() == 0) goto L37;
        boolean r22 = true;
    L38:
        this.F = r22;
        if (r10.readByte() == 0) goto L41;
        boolean r23 = true;
    L42:
        this.G = r23;
        if (r10.readByte() == 0) goto L45;
        boolean r24 = true;
    L46:
        this.H = r24;
        if (r10.readByte() == 0) goto L49;
        boolean r25 = true;
    L50:
        this.I = r25;
        if (r10.readByte() == 0) goto L53;
        boolean r26 = true;
    L54:
        this.f3660u = r26;
        if (r10.readByte() == 0) goto L57;
        boolean r27 = true;
    L58:
        this.f3661v = r27;
        if (r10.readByte() == 0) goto L61;
        boolean r28 = true;
    L62:
        this.f3662w = r28;
        if (r10.readByte() == 0) goto L65;
        boolean r29 = true;
    L66:
        this.f3663x = r29;
        if (r10.readByte() == 0) goto L69;
        boolean r30 = true;
    L70:
        this.f3664y = r30;
        this.f3665z = r10.readLong();
        int r31 = r10.readInt();
        if (r31 != (-1)) goto L73;
        c r32 = c.f3670a;
    L74:
        L = r32;
        int r33 = r10.readInt();
        if (r33 == (-1)) goto L78;
        r12 = e.values()[r33];
    L78:
        this.B = r12;
        this.J = r10.readFloat();
        int r34 = r10.readInt();
        if (r34 == (-1)) goto L82;
        r13 = d.values()[r34];
    L82:
        this.K = r13;
        if (r10.readByte() == 0) goto L85;
        r8 = true;
    L85:
        N = r8;
        this.A = r10.readLong();
        return;
    L73:
        r32 = c.values()[r31];
        goto L74
    L69:
        r30 = false;
        goto L70
    L65:
        r29 = false;
        goto L66
    L61:
        r28 = false;
        goto L62
    L57:
        r27 = false;
        goto L58
    L53:
        r26 = false;
        goto L54
    L49:
        r25 = false;
        goto L50
    L45:
        r24 = false;
        goto L46
    L41:
        r23 = false;
        goto L42
    L37:
        r22 = false;
        goto L38
    L33:
        r21 = false;
        goto L34
    L29:
        r20 = false;
        goto L30
    L21:
        r18 = false;
        goto L22
    L17:
        r17 = false;
        goto L18
    L13:
        r16 = false;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L6
    }
}
