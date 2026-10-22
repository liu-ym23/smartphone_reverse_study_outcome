package qa;

import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes.dex */
public final enum j extends Enum<j> {
    public static final j A = null;
    public static final j B = null;
    public static final /* synthetic */ j[] C = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final j f10594p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final j f10595q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final j f10596r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j f10597s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final j f10598t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f10599u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j f10600v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f10601w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final j f10602x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final j f10603y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final j f10604z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10606b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f10607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10608n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f10609o;

    static {
        j r8 = new j("MIUI", 0, t4.n("IeGlhb21p"));
        f10594p = r8;
        j r10 = new j("Flyme", 1, t4.n("IbWVpenU"));
        f10595q = r10;
        j r11 = new j("RH", 2, t4.n("IaHVhd2Vp"));
        f10596r = r11;
        j r12 = new j("ColorOS", 3, t4.n("Ib3Bwbw"));
        f10597s = r12;
        j r13 = new j("FuntouchOS", 4, t4.n("Idml2bw"));
        f10598t = r13;
        j r14 = new j("SmartisanOS", 5, t4.n("Mc21hcnRpc2Fu"));
        f10599u = r14;
        j r15 = new j("AmigoOS", 6, t4.n("IYW1pZ28"));
        f10600v = r15;
        j r16 = new j("EUI", 7, t4.n("IbGV0dg"));
        f10601w = r16;
        j r17 = new j("Sense", 8, t4.n("EaHRj"));
        f10602x = r17;
        j r18 = new j("LG", 9, t4.n("EbGdl"));
        f10603y = r18;
        j r19 = new j(LocationInfoConst.GOOGLE, 10, t4.n("IZ29vZ2xl"));
        f10604z = r19;
        j r110 = new j("NubiaUI", 11, t4.n("IbnViaWE"));
        A = r110;
        j r111 = new j("Other", 12, "");
        B = r111;
        C = new j[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
    }

    public j(String r8, int r10, String r11) {
        super(r8, r10);
        this.f10609o = Build.MANUFACTURER;
        this.f10605a = r11;
    }

    public static j valueOf(String r8) {
        return (j) Enum.valueOf(j.class, r8);
    }

    public static j[] values() {
        return (j[]) C.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder r8 = new StringBuilder("ROM{name='");
        r8.append(name());
        r8.append("',versionCode=");
        r8.append(this.f10606b);
        r8.append(", versionName='");
        r8.append(this.f10608n);
        r8.append("',ma=");
        r8.append(this.f10605a);
        r8.append("',manufacturer=");
        return android.aimedia.a.i(r8, this.f10609o, "'}");
    }
}
