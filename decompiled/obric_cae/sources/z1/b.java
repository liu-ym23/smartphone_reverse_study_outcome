package z1;

import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationOption f14175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f14176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f14178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LocationExtraBean f14182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f14187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f14188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LocationTraceLogger f14189p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f14190q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BDLocationExtraDataServer f14191r;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14192a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f14193b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f14194m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ a[] f14195n = null;

        static {
            a r8 = new a("Battery_Saving", 0);
            f14192a = r8;
            a r10 = new a("Device_Sensors", 1);
            f14193b = r10;
            a r11 = new a("Hight_Accuracy", 2);
            f14194m = r11;
            f14195n = new a[]{r8, r10, r11};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f14195n.clone();
        }
    }

    public b(LocationOption r8) {
        this.f14176c = 0;
        this.f14177d = 0;
        this.f14178e = a.f14192a;
        this.f14179f = 10000;
        this.f14184k = 1;
        this.f14185l = true;
        this.f14175b = r8;
    }

    public final String a() {
        int r8 = this.f14176c;
        if (r8 != 0) goto L5;
        return "init";
    L5:
        if (r8 != 1) goto L7;
        return "requesting_network";
    L7:
        if (r8 != 2) goto L9;
        return "requesting_gps";
    L9:
        if (r8 != 3) goto L11;
        return "requesting_both";
    L11:
        if (r8 != 5) goto L13;
        return "cancel";
    L13:
        if (r8 != 6) goto L15;
        return "end";
    L15:
        return String.valueOf(this.f14176c);
    }
}
