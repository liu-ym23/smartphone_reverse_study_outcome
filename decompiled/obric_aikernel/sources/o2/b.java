package o2;

import android.text.TextUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import o2.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b<T extends c> {
    private static volatile InterfaceC0254b R;
    public String A;
    public JSONObject B;
    public boolean C;
    public boolean D;
    public long E;
    public boolean F;
    public String G;
    public boolean H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f11393J;
    public i K;
    public long L;
    public volatile AtomicBoolean M;
    public String N;
    public RetrofitMetrics O;
    public String P;
    public boolean Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f11394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f11398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f11399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f11403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f11405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f11407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11408o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f11409p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f11410q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f11411r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11412s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11413t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f11414u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f11415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f11416w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11417x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11418y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f11419z;

    class a implements InterfaceC0254b {
        a() {
        }

        @Override // o2.b.InterfaceC0254b
        public b create() {
            return new b();
        }
    }

    /* JADX INFO: renamed from: o2.b$b, reason: collision with other inner class name */
    public interface InterfaceC0254b {
        b create();
    }

    static {
        R = new a();
    }

    public b() {
        this.f11395b = false;
        this.f11396c = -1;
        this.f11406m = -1;
        this.f11417x = -1;
        this.f11418y = -1;
        this.f11419z = "";
        this.B = new JSONObject();
        this.C = false;
        this.D = false;
        this.E = -1;
        this.F = false;
        this.H = false;
        this.I = -1;
        this.f11393J = false;
        this.M = new AtomicBoolean(false);
        this.N = "";
        this.P = "";
    }

    public static b a() {
        return R.create();
    }

    public static JSONObject b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        String[] r11 = r10.split(",");
        JSONArray r12 = new JSONArray();
        int r13 = r11.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r12.put(r11[r14]);
        r14 = r14 + 1;
        goto L7
    L9:
        JSONObject r15 = new JSONObject();
        r15.put("hit", r12);     // Catch: JSONException -> L12
    L14:
        return r15;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void c(InterfaceC0254b r10) {
        if (r10 == null) goto L5;
        R = r10;
        return;
    }
}
