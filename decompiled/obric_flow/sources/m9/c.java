package m9;

import android.app.Application;
import com.bytedance.crash.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import l9.o;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static long A = -1;
    public static volatile c B = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f20029v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f20030w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f20031x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f20032y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f20033z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f20034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f20035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f20036c;
    public final ArrayList d;
    public final LinkedList e;
    public final ArrayList f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f20037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f20038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f20039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f20040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f20041l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference f20042m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f20043n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f20044o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f20045p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f20046q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f20047r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f20048t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f20049u;

    public c(Application r5) {
        this.f20034a = new ArrayList();
        this.f20035b = new ArrayList();
        this.f20036c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedList();
        this.f = new ArrayList();
        this.s = -1;
        this.f20048t = 50;
        if (r5 != null) goto L8;
    L5:
        k.f23303a = new io.reactivex.internal.functions.d(1);
        return;
    L8:
        r5.registerActivityLifecycleCallbacks(new com.bytedance.android.monitorV2.f(this));     // Catch: Throwable -> L7
        goto L5
    }

    public static JSONObject c(long r5, String r10) {
        JSONObject r11 = new JSONObject();
        mh.e.g(r10, "name", r11);
        mh.e.g(Long.valueOf(r5), "time", r11);
        return r11;
    }

    public static void d(int r10, long r11, String r12, String r13, c r14) {
        r14.getClass();
        o.e().b(new a(r10, r11, r12, r13, r14));
    }

    public static c e() {
        if (B != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (B != null) goto L11;
        B = new c(n.f4058b);     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return B;
    }

    public final JSONArray a() {
        JSONArray r5 = new JSONArray();
        Iterator r10 = new ArrayList(this.e).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.put(((b) r10.next()).toString());
        goto L4
    L6:
        return r5;
    }

    public final JSONArray b(ArrayList r10, ArrayList r11) {
        JSONArray r5 = new JSONArray();
        if (this.f20034a != null) goto L5;
    L12:
        return r5;
    L5:
        if (r10.isEmpty() == true) goto L12;
        int r12 = 0;
    L9:
        if (r12 >= r10.size()) goto L12;
        String r13 = (String) r10.get(r12);     // Catch: Throwable -> L13
        Long r14 = (Long) r11.get(r12);     // Catch: Throwable -> L13
        r14.getClass();     // Catch: Throwable -> L13
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L13
        mh.e.g(r13, "name", r15);     // Catch: Throwable -> L13
        mh.e.g(r14, "time", r15);     // Catch: Throwable -> L13
        r5.put(r15);     // Catch: Throwable -> L13
        r12 = r12 + 1;
        goto L9
    }
}
