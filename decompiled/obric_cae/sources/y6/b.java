package y6;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static volatile b G;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f14010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f14018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f14019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f14020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f14021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f14023n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f14024o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f14025p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f14026q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f14027r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f14028s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f14029t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f14030u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f14031v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f14032w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f14033x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f14034y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f14035z;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f14036b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f14037m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f14038n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ a[] f14039o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14040a;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_NONE, 0, 0);
            f14036b = r8;
            a r10 = new a("LAZY_INIT", 1, 1);
            a r11 = new a("PRE_INIT", 2, 2);
            f14037m = r11;
            a r12 = new a("FORCE_INIT", 3, 3);
            f14038n = r12;
            f14039o = new a[]{r8, r10, r11, r12};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f14040a = r11;
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f14039o.clone();
        }
    }

    public b() {
        this.f14010a = a.f14036b;
        this.f14011b = true;
        this.f14028s = -1;
        this.f14029t = -1;
        this.f14030u = -1;
        this.f14031v = -1;
        this.f14032w = -1;
        this.f14033x = -1;
        this.f14034y = -1;
        this.f14035z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
    }

    public static b b() {
        if (G != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (G != null) goto L9;
        G = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return G;
    }

    public static boolean c(Context r8, List r10) {
        HashMap r11 = null;
        Class<?> r12 = Class.forName("com.bytedance.mobsec.metasec.ml.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r12 != null) goto L9;
        r12 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L21
    L9:
        if (r12 != null) goto L12;
        return false;
    L12:
        if (r10 != null) goto L24;
    L16:
        r12.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r12, new Object[]{r8, 1, r11});     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        return false;
    L24:
        if (r10.size() != 2) goto L16;
        r11 = new HashMap();     // Catch: Throwable -> L18
        r11.put("http_callback", String.valueOf(r10.get(0)));     // Catch: Throwable -> L18
        r11.put("ws_callback", String.valueOf(r10.get(1)));     // Catch: Throwable -> L18
    L5:
        r12 = null;
        goto L6
    }

    public static void d(JSONObject r8, String r10, long r11, long r12) {
        if (r11 > r12) goto L5;
        r8.put(r10, r12 - r11);     // Catch: JSONException -> L8
    L9:
        return;
    L5:
        r8.put(r10, -1);     // Catch: JSONException -> L8
    }

    public final void a(Context r8, List<Long> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.size() != 2) goto L12;
        Logger.d("b", "http address: " + r10.get(0) + " ws address: " + r10.get(1));
        this.f14015f = System.currentTimeMillis();
        if (c(r8, r10) == true) goto L9;
        Logger.d("b", "init mssdk failed.");
    L9:
        this.f14016g = System.currentTimeMillis();
        return;
    }
}
