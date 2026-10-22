package i0;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.util.p;
import com.bytedance.apm.util.y;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends i0.a {
    private static long H = 17179869184L;
    private static String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static String f9304J;
    private List<String> A;
    private List<String> B;
    private List<String> C;
    private List<String> D;
    private y<c> E;
    private y<c> F;
    private y<e> G;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f9305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f9310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private d0.f f9311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f9312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f9313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f9314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f9315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f9316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f9317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f9318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List<b> f9319z;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f9320c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f9321g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f9322h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f9323i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f9324j;

        a(f r10, long r11, List r12, List r13, List r14) {
            this.f9324j = r10;
            this.f9320c = r11;
            this.f9321g = r12;
            this.f9322h = r13;
            this.f9323i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.p(this.f9324j).a(f.o(this.f9324j), this.f9320c, this.f9321g, this.f9322h, this.f9323i);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f9327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9329e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<b> f9330f;

        private b() {
            this.f9329e = "normal";
            this.f9330f = new ArrayList();
        }

        /* synthetic */ b(a r10) {
            this();
        }

        private String a() {
            String r10 = this.f9325a;
            if (r10.contains(f.A()) == false) goto L7;
            String r11 = f.A();
            String r12 = "internal";
        L9:
            return r10.replace(r11, r12);
        L7:
            if (r10.contains(f.q()) == false) goto L10;
            r11 = f.q();
            r12 = "external";
            goto L9
        L10:
            return r10;
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();
            r10.put("path", a());     // Catch: JSONException -> L11
            r10.put("size", this.f9326b);     // Catch: JSONException -> L11
            r10.put("size_rate", this.f9327c);     // Catch: JSONException -> L11
            r10.put("is_folder", this.f9328d);     // Catch: JSONException -> L11
            r10.put("report_type", this.f9329e);     // Catch: JSONException -> L11
            if (this.f9330f.isEmpty() == true) goto L13;
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L11
            Iterator<b> r12 = this.f9330f.iterator();     // Catch: JSONException -> L11
        L7:
            if (r12.hasNext() == false) goto L9;
            r11.put(r12.next().b());     // Catch: JSONException -> L11
            goto L7
        L9:
            r10.put("next_disk", r11);     // Catch: JSONException -> L11
        L13:
            return r10;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }
    }

    private static class c implements Comparable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9331c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f9332g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9333h;

        public c() {
        }

        public c(String r10, long r11, int r12) {
            this.f9331c = r10;
            this.f9332g = r11;
            this.f9333h = r12;
        }

        static /* synthetic */ String a(c r10) {
            return r10.f9331c;
        }

        private String b() {
            String r10 = this.f9331c;
            if (r10.contains(f.A()) == false) goto L7;
            String r11 = f.A();
            String r12 = "internal";
        L9:
            return r10.replace(r11, r12);
        L7:
            if (r10.contains(f.q()) == false) goto L10;
            r11 = f.q();
            r12 = "external";
            goto L9
        L10:
            return r10;
        }

        public JSONObject c() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L6
            r10.put(ActivityLifecycle.NAME, b());     // Catch: Exception -> L6
            r10.put("size", this.f9332g);     // Catch: Exception -> L6
            int r11 = this.f9333h;     // Catch: Exception -> L6
            if (r11 <= 0) goto L5;
            r10.put("num", r11);     // Catch: Exception -> L6
        L5:
            return r10;
        L6:
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.f9332g;
            long r12 = ((c) r10).f9332g;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }
    }

    private class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f9335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9338e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9339f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f9340g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9341h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f9342i;

        private d(f r10) {
            this.f9342i = r10;
        }

        /* synthetic */ d(f r10, a r11) {
            this(r10);
        }

        static /* synthetic */ String a(d r10) {
            return r10.f9334a;
        }

        static /* synthetic */ String b(d r10, String r11) {
            r10.f9334a = r11;
            return r11;
        }

        static /* synthetic */ int c(d r10, int r11) {
            r10.f9337d = r11;
            return r11;
        }

        static /* synthetic */ int d(d r10) {
            int r11 = r10.f9337d;
            r10.f9337d = r11 - 1;
            return r11;
        }

        static /* synthetic */ boolean e(d r10) {
            return r10.f9339f;
        }

        static /* synthetic */ boolean f(d r10, boolean r11) {
            r10.f9339f = r11;
            return r11;
        }

        static /* synthetic */ long g(d r10, long r11) {
            r10.f9340g = r11;
            return r11;
        }

        private void i() {
            if (TextUtils.equals(this.f9334a, f.A()) == false) goto L6;
            f.u(this.f9342i, this.f9336c);
            return;
        L6:
            if (TextUtils.equals(this.f9334a, f.q()) == false) goto L9;
            f.v(this.f9342i, this.f9336c);
            return;
        L9:
            if (TextUtils.equals(this.f9334a, f.w(this.f9342i)) == false) goto L12;
            f.x(this.f9342i, this.f9336c);
            return;
        L12:
            if (TextUtils.equals(this.f9334a, f.y(this.f9342i)) == false) goto L18;
            f.z(this.f9342i, this.f9336c);
            return;
        }

        private boolean j() {
            if (this.f9338e != this.f9337d) goto L5;
            return true;
        L5:
            return false;
        }

        public void h(long r10) {
            this.f9336c += r10;
            this.f9338e++;
            if (this.f9335b != null) goto L5;
            return;
        L5:
            if (j() == true) goto L7;
            return;
        L7:
            if (this.f9341h == false) goto L10;
            this.f9335b.f9341h = true;
        L10:
            if (this.f9336c >= f.r(this.f9342i)) goto L12;
        L14:
            this.f9335b.h(this.f9336c);
            if (this.f9339f == false) goto L17;
            f.t(this.f9342i, this.f9334a, this.f9336c, this.f9337d, this.f9340g);
        L17:
            i();
            return;
        L12:
            if (this.f9341h == true) goto L14;
            f.s(this.f9342i, this.f9334a, this.f9336c, this.f9338e, this.f9337d);
            this.f9335b.f9341h = true;
            goto L14
        }
    }

    private static class e extends c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f9343i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f9344j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f9345k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f9346l;

        public e(String r10, long r11, int r12, long r13) {
            this.f9343i = r10;
            this.f9344j = r11;
            this.f9345k = r12;
            this.f9346l = r13;
        }

        private String b() {
            String r10 = this.f9343i;
            if (r10.contains(f.A()) == false) goto L7;
            String r11 = f.A();
            String r12 = "internal";
        L9:
            return r10.replace(r11, r12);
        L7:
            if (r10.contains(f.q()) == false) goto L10;
            r11 = f.q();
            r12 = "external";
            goto L9
        L10:
            return r10;
        }

        @Override // i0.f.c
        public JSONObject c() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L7
            r10.put(ActivityLifecycle.NAME, b());     // Catch: Exception -> L7
            r10.put("size", this.f9344j);     // Catch: Exception -> L7
            int r11 = this.f9345k;     // Catch: Exception -> L7
            if (r11 <= 0) goto L5;
            r10.put("num", r11);     // Catch: Exception -> L7
        L5:
            r10.put("outdate_interval", this.f9346l);     // Catch: Exception -> L7
            return r10;
        L7:
            return null;
        }

        @Override // i0.f.c, java.lang.Comparable
        public int compareTo(Object r10) {
            long r11 = this.f9346l;
            long r12 = ((e) r10).f9346l;
            if (r11 != r12) goto L7;
            return 0;
        L7:
            if (r11 <= r12) goto L10;
            return 1;
        L10:
            return -1;
        }
    }

    static {
    }

    public f() {
        this.f9307n = 524288000;
        this.f9308o = 524288000;
        this.f9309p = 20;
        this.f9310q = 2592000000L;
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.f9290j = SlardarSettingsConstants.PERF_KEY_DISK;
    }

    static /* synthetic */ String A() {
        return I;
    }

    private void B(String r10, long r11) {
        if (com.bytedance.apm.d.D() == false) goto L6;
        e0.e.b("MonitorStorage", new String[]{"appendExceptionFileQueue: path: " + r10 + ", size: " + r11});
    L6:
        if (r11 <= H) goto L9;
        return;
    L9:
        if (this.E != null) goto L11;
        this.E = new y(this.f9309p);
    L11:
        this.E.a(new c(r10, r11, 1));
    }

    private void C(String r10, long r11, int r12, int r13) {
        if (com.bytedance.apm.d.D() == false) goto L6;
        Log.d("MonitorStorage", "appendExceptionFolderQueue: path: " + r10 + ":  size: " + r11 + " , accumulateNum: " + r12 + " , num: " + r13);
    L6:
        if (r11 <= H) goto L9;
        return;
    L9:
        if (this.F != null) goto L11;
        this.F = new y(this.f9309p);
    L11:
        this.F.a(new c(r10, r11, r13));
    }

    private void D(String r10, long r11, int r12, long r13) {
        if (com.bytedance.apm.d.D() == false) goto L6;
        e0.e.b("MonitorStorage", new String[]{"appendutdatedFileQueue: path: " + r10 + ", size: " + r11});
    L6:
        if (r11 >= WsConstants.DEFAULT_IO_LIMIT) goto L8;
        return;
    L8:
        if (r11 <= H) goto L11;
        return;
    L11:
        if (this.G != null) goto L13;
        this.G = new y(this.f9309p);
    L13:
        this.G.a(new e(r10, r11, r12, r13));
    }

    private long E(long r10) {
        return r10 / ProcInfo.GB;
    }

    private void F(File r10, int r11, boolean r12, List<b> r13) {
        if (r11 > 2) goto L49;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.exists() == true) goto L8;
        return;
    L8:
        if (this.C.contains(r10.getAbsolutePath()) == true) goto L53;
        int r14 = 0;
        a r15 = null;
        if (r10.isDirectory() == false) goto L38;
        if (r12 == false) goto L37;
        File[] r16 = r10.listFiles();
        if (r16 != null) goto L16;
        return;
    L16:
        if (r16.length == 0) goto L48;
        int r17 = r16.length;
    L19:
        if (r14 >= r17) goto L54;
        File r18 = r16[r14];
        if (r18 == null) goto L35;
        if (r18.exists() == false) goto L35;
        if (this.C.contains(r18.getAbsolutePath()) == true) goto L35;
        b r19 = new b(r15);
        r19.f9328d = r18.isDirectory();
        r19.f9325a = r18.getAbsolutePath();
        if (r18.isDirectory() == false) goto L33;
        ArrayList r20 = new ArrayList();
        r19.f9330f = r20;
        if (r11 != 2) goto L32;
        r19.f9326b = I(r18);
    L32:
        F(r18, r11 + 1, r12, r20);
    L34:
        r13.add(r19);
        goto L35
    L33:
        r19.f9326b = r18.length();
    L35:
        r14 = r14 + 1;
        goto L19
    L54:
        return;
    L48:
        return;
    L37:
        b r110 = new b(r15);
        r110.f9328d = true;
        r110.f9329e = "custom";
        r110.f9325a = r10.getAbsolutePath();
        r110.f9326b = I(r10);
        r13.add(r110);
        return;
    L38:
        b r21 = new b(r15);
        r21.f9328d = false;
        r21.f9325a = r10.getAbsolutePath();
        r21.f9326b = r10.length();
        if (r12 == true) goto L41;
        r21.f9329e = "custom";
    L41:
        r13.add(r21);
        return;
    L53:
        return;
    }

    private static List<String> H(y<? extends c> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedList r11 = new LinkedList();
        Iterator r12 = r10.d().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(c.a((c) r12.next()));
        goto L7
    L9:
        return r11;
    }

    private long I(File r10) {
        long r11 = 0;
        File[] r12 = r10.listFiles();     // Catch: Exception -> L16
        if (r12 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r12.length == 0) goto L15;
        int r13 = r12.length;     // Catch: Exception -> L16
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L18;
        File r15 = r12[r14];     // Catch: Exception -> L16
        if (r15.isDirectory() == false) goto L13;
        long r16 = I(r15);     // Catch: Exception -> L16
    L14:
        r11 = r11 + r16;
        r14 = r14 + 1;
        goto L9
    L13:
        r16 = r15.length();     // Catch: Exception -> L16
    L18:
        return r11;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    private float J(long r10, BigDecimal r11) {
        return (float) new BigDecimal(r10).divide(r11, 4, 4).doubleValue();
    }

    private void K() {
        G();     // Catch: Throwable -> L4
        P(this.f9314u + this.f9315v, this.f9316w + this.f9317x, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Throwable -> L4
        com.bytedance.apm.internal.b.a().f("check_disk_last_time", System.currentTimeMillis());     // Catch: Throwable -> L4
        return;
    }

    private void L() {
        P(com.bytedance.apm.util.b.q(com.bytedance.apm.d.g()), com.bytedance.apm.util.b.p(com.bytedance.apm.d.g()), com.bytedance.apm.util.b.e(), Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L4
        return;
    }

    private void M() {
        if (I == null) goto L5;
        return;
    L5:
        Context r10 = com.bytedance.apm.d.g();
        r10.getPackageName();     // Catch: Exception -> L35
        I = r10.getFilesDir().getParent();     // Catch: Exception -> L35
        this.f9312s = r10.getCacheDir().getAbsolutePath();     // Catch: Exception -> L35
        f9304J = r10.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L35
        File r11 = r10.getExternalCacheDir();     // Catch: Exception -> L35
        if (r11 == null) goto L9;
        this.f9313t = r11.getAbsolutePath();     // Catch: Exception -> L35
    L9:
        List<String> r12 = this.B;     // Catch: Exception -> L35
        if (r12 == null) goto L22;
        Iterator<String> r13 = r12.iterator();     // Catch: Exception -> L35
    L14:
        if (r13.hasNext() == false) goto L22;
        String r14 = r13.next();     // Catch: Exception -> L35
        if (r14.contains("internal") == true) goto L17;
        if (r14.contains("external") == false) goto L14;
        List<String> r15 = this.C;     // Catch: Exception -> L35
        String r16 = r14.replace("external", f9304J);     // Catch: Exception -> L35
    L18:
        r15.add(r16);     // Catch: Exception -> L35
        goto L14
    L17:
        r15 = this.C;     // Catch: Exception -> L35
        r16 = r14.replace("internal", I);     // Catch: Exception -> L35
    L22:
        List<String> r17 = this.A;     // Catch: Exception -> L35
        if (r17 == null) goto L51;
        Iterator<String> r18 = r17.iterator();     // Catch: Exception -> L35
    L25:
        if (r18.hasNext() == false) goto L52;
        String r19 = r18.next();     // Catch: Exception -> L35
        if (r19.contains("internal") == true) goto L29;
        if (r19.contains("external") == false) goto L25;
        List<String> r20 = this.D;     // Catch: Exception -> L35
        String r21 = r19.replace("external", f9304J);     // Catch: Exception -> L35
    L30:
        r20.add(r21);     // Catch: Exception -> L35
        goto L25
    L29:
        r20 = this.D;     // Catch: Exception -> L35
        r21 = r19.replace("internal", I);     // Catch: Exception -> L35
        goto L30
    L52:
        return;
    L51:
        return;
    L35:
        this.f9318y = true;
    }

    private boolean N(b r10) {
        Iterator<String> r11 = this.C.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r12 = r11.next();
        if (r10.f9325a.contains(r12) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private long O(long r10) {
        long r11 = System.currentTimeMillis() - r10;
        if (r11 >= this.f9310q) goto L5;
        return 0;
    L5:
        if (r11 >= 62899200000L) goto L9;
        return r11;
    L9:
        return 0;
    }

    private void P(long r10, long r11, long r12, long r14) {
        if (com.bytedance.apm.d.D() == false) goto L5;
        e0.e.d(e0.b.f8549c, new String[]{"disk: data: " + r10 + " , cache: " + r11 + " , total: " + r12 + " , free: " + r14});     // Catch: Exception -> L86
    L5:
        long r13 = H;     // Catch: Exception -> L86
        if (r10 <= r13) goto L8;
        long r15 = r13;
    L10:
        if (r11 > r13) goto L13;
        r13 = r11;
    L13:
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L86
        if (r10 <= 0) goto L17;
        r16.put("data", r15);     // Catch: Exception -> L86
    L17:
        if (r11 <= 0) goto L20;
        r16.put(CommonProcUtil.CACHE, r13);     // Catch: Exception -> L86
    L20:
        if (r12 <= 0) goto L23;
        r16.put("total", E(r12));     // Catch: Exception -> L86
    L23:
        if (r14 <= 0) goto L25;
        r16.put("rom_free", E(r14));     // Catch: Exception -> L86
    L25:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L86
        if (this.f9306m == true) goto L28;
    L84:
        k(new y.e(SlardarSettingsConstants.PERF_KEY_DISK, "storageUsed", false, r16, null, r17));     // Catch: Exception -> L86
        return;
    L28:
        if (r15 <= this.f9307n) goto L84;
        if (this.E == null) goto L39;
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L86
        Iterator r19 = this.E.d().iterator();     // Catch: Exception -> L86
    L33:
        if (r19.hasNext() == false) goto L37;
        JSONObject r110 = ((c) r19.next()).c();     // Catch: Exception -> L86
        if (r110 == null) goto L33;
        r18.put(r110);     // Catch: Exception -> L86
        goto L33
    L37:
        r17.put("top_usage", r18);     // Catch: Exception -> L86
    L39:
        if (this.F == null) goto L48;
        JSONArray r20 = new JSONArray();     // Catch: Exception -> L86
        Iterator r21 = this.F.d().iterator();     // Catch: Exception -> L86
    L42:
        if (r21.hasNext() == false) goto L46;
        JSONObject r111 = ((c) r21.next()).c();     // Catch: Exception -> L86
        if (r111 == null) goto L42;
        r20.put(r111);     // Catch: Exception -> L86
        goto L42
    L46:
        r17.put("exception_folders", r20);     // Catch: Exception -> L86
    L48:
        if (this.G == null) goto L56;
        JSONArray r22 = new JSONArray();     // Catch: Exception -> L86
        Iterator r23 = this.G.d().iterator();     // Catch: Exception -> L86
    L51:
        if (r23.hasNext() == false) goto L55;
        JSONObject r112 = ((e) r23.next()).c();     // Catch: Exception -> L86
        if (r112 == null) goto L51;
        r22.put(r112);     // Catch: Exception -> L86
        goto L51
    L55:
        r17.put("outdated_files", r22);     // Catch: Exception -> L86
    L56:
        List<b> r24 = this.f9319z;     // Catch: Exception -> L86
        if (r24 == null) goto L81;
        if (r24.isEmpty() == true) goto L81;
        BigDecimal r25 = new BigDecimal(r15);     // Catch: Exception -> L86
        JSONArray r26 = new JSONArray();     // Catch: Exception -> L86
        Iterator<b> r113 = this.f9319z.iterator();     // Catch: Exception -> L86
    L62:
        if (r113.hasNext() == false) goto L79;
        b r114 = r113.next();     // Catch: Exception -> L86
        if (N(r114) == false) goto L66;
        r114.f9327c = 0.0f;     // Catch: Exception -> L86
    L67:
        List<b> r115 = r114.f9330f;     // Catch: Exception -> L86
        if (r115 == null) goto L78;
        if (r115.size() <= 0) goto L78;
        Iterator<b> r116 = r115.iterator();     // Catch: Exception -> L86
    L73:
        if (r116.hasNext() == false) goto L78;
        b r117 = r116.next();     // Catch: Exception -> L86
        if (N(r117) == true) goto L76;
        r117.f9327c = J(r117.f9326b, r25);     // Catch: Exception -> L86
        goto L73
    L76:
        r117.f9327c = 0.0f;     // Catch: Exception -> L86
    L78:
        r26.put(r114.b());     // Catch: Exception -> L86
        goto L62
    L66:
        r114.f9327c = J(r114.f9326b, r25);     // Catch: Exception -> L86
        goto L67
    L79:
        r17.put("disk_info", r26);     // Catch: Exception -> L86
    L81:
        if (this.f9311r == null) goto L83;
        q0.b.f().p(new a(this, r15, H(this.E), H(this.F), H(this.G)));     // Catch: Exception -> L86
    L83:
        this.E = null;     // Catch: Exception -> L86
        this.F = null;     // Catch: Exception -> L86
        this.G = null;     // Catch: Exception -> L86
        this.f9319z = null;     // Catch: Exception -> L86
        goto L84
    L8:
        r15 = r10;
    }

    static /* synthetic */ long o(f r10) {
        return r10.f9307n;
    }

    static /* synthetic */ d0.f p(f r10) {
        return r10.f9311r;
    }

    static /* synthetic */ String q() {
        return f9304J;
    }

    static /* synthetic */ long r(f r10) {
        return r10.f9308o;
    }

    static /* synthetic */ void s(f r10, String r11, long r12, int r13, int r14) {
        r10.C(r11, r12, r13, r14);
    }

    static /* synthetic */ void t(f r10, String r11, long r12, int r13, long r14) {
        r10.D(r11, r12, r13, r14);
    }

    static /* synthetic */ long u(f r10, long r11) {
        r10.f9314u = r11;
        return r11;
    }

    static /* synthetic */ long v(f r10, long r11) {
        r10.f9315v = r11;
        return r11;
    }

    static /* synthetic */ String w(f r10) {
        return r10.f9312s;
    }

    static /* synthetic */ long x(f r10, long r11) {
        r10.f9316w = r11;
        return r11;
    }

    static /* synthetic */ String y(f r10) {
        return r10.f9313t;
    }

    static /* synthetic */ long z(f r10, long r11) {
        r10.f9317x = r11;
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    public void G() {
        int r10 = 2;
        int r11 = 0;
        ?? r12 = 1;
        String[] r13 = {I, f9304J};
        this.f9319z = new ArrayList();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L54;
        String r15 = r13[r14];
        F(new File(r15), r12, r12, this.f9319z);
        File r16 = new File(r15);
        a r17 = null;
        d r18 = new d(this, r17);
        d.b(r18, r15);
        r18.f9335b = new d(this, r17);
        File[] r19 = r16.listFiles();
        if (r19 == null) goto L53;
        if (r19.length == 0) goto L53;
        d.c(r18, r19.length);
        LinkedList r110 = new LinkedList();
        r110.offer(r18);
    L11:
        if (r110.isEmpty() == true) goto L53;
        int r111 = r110.size();
        int r20 = r11;
    L13:
        if (r20 >= r111) goto L11;
        d r21 = (d) r110.poll();
        if (r21 != null) goto L17;
        int r112 = r20;
        String[] r113 = r13;
    L52:
        r20 = r112 + 1;
        r13 = r113;
        r11 = 0;
        goto L13
    L17:
        String r22 = d.a(r21);
        File r23 = new File(r22);
        if (r23.exists() == true) goto L20;
    L51:
        r112 = r20;
        r113 = r13;
        d.d(r21.f9335b);
        goto L52
    L20:
        if (this.C.contains(r22) == true) goto L51;
        r113 = r13;
        if (r23.isFile() == false) goto L35;
        long r24 = r23.length();
        if (r24 <= 0) goto L27;
        B(r22, r24);
    L27:
        d r25 = r21.f9335b;
        if (r25 == null) goto L34;
        r25.h(r24);
        if (d.e(r21.f9335b) == true) goto L34;
        long r114 = O(r23.lastModified());
        if (r114 <= 0) goto L34;
        r112 = r20;
        D(r22, r24, 0, r114);
    L34:
        r112 = r20;
        goto L52
    L35:
        r112 = r20;
        File[] r26 = r23.listFiles();
        if (r26 != null) goto L38;
    L50:
        r21.f9335b.h(0);
        goto L52
    L38:
        if (r26.length == 0) goto L50;
        d.c(r21, r26.length);
        int r27 = r26.length;
        int r28 = 0;
    L41:
        if (r28 >= r27) goto L52;
        File r29 = r26[r28];
        d r30 = new d(this, r17);
        r30.f9335b = r21;
        d.b(r30, r29.getAbsolutePath());
        if (r29.isDirectory() == false) goto L49;
        if (d.e(r21) == true) goto L49;
        long r115 = O(r29.lastModified());
        if (r115 <= 0) goto L49;
        d.f(r30, true);
        d.g(r30, r115);
    L49:
        r110.offer(r30);
        r28 = r28 + 1;
    L53:
        r14 = r14 + 1;
        r13 = r13;
        r10 = 2;
        r11 = 0;
        r12 = 1;
        goto L3
    L54:
        List<String> r31 = this.D;
        if (r31 != null) goto L57;
    L62:
        Iterator<b> r32 = this.f9319z.iterator();
    L64:
        if (r32.hasNext() == false) goto L75;
        b r33 = r32.next();
        if ("normal".equals(r33.f9329e) == false) goto L64;
        List<b> r34 = r33.f9330f;
        if (r34 == null) goto L64;
        if (r34.isEmpty() == true) goto L64;
        Iterator<b> r35 = r34.iterator();
    L73:
        if (r35.hasNext() == false) goto L64;
        r33.f9326b += r35.next().f9326b;
        goto L73
    L75:
        return;
    L57:
        if (r31.size() <= 0) goto L62;
        Iterator<String> r36 = this.D.iterator();
    L60:
        if (r36.hasNext() == false) goto L62;
        F(new File(r36.next()), 1, false, this.f9319z);
        goto L60
    }

    public void Q(d0.f r10) {
        this.f9311r = r10;
    }

    @Override // i0.a
    protected void c(JSONObject r10) {
        boolean r11 = r10.optBoolean(SlardarSettingsConstants.PERF_KEY_DISK_DUMP_SWITCH, true);
        this.f9306m = r11;
        if (r11 == false) goto L22;
        long r12 = com.bytedance.apm.internal.b.a().c("check_disk_last_time");
        long r13 = System.currentTimeMillis() - r12;
        if (r13 >= 86400000) goto L10;
        if (r13 <= 0) goto L10;
        this.f9305l = true;
    L10:
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_THRESHOLD) <= 0) goto L13;
        this.f9307n = (((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_THRESHOLD)) * 1024) * 1024;
    L13:
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FOLDER_SIZE) <= 0) goto L16;
        this.f9308o = (((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_ABNORMAL_FOLDER_SIZE)) * 1024) * 1024;
    L16:
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_COUNT) <= 0) goto L19;
        this.f9309p = r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_DUMP_TOP_COUNT);
    L19:
        if (r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_OUTDATED_DAYS) <= 0) goto L21;
        this.f9310q = ((long) r10.optInt(SlardarSettingsConstants.PERF_DISK_KEY_OUTDATED_DAYS)) * 86400000;
    L21:
        this.A = p.e(r10, SlardarSettingsConstants.PERF_DISK_KEY_DISK_CUSTOMED_PATHS);
        this.B = p.d(r10, SlardarSettingsConstants.PERF_DISK_KEY_IGNORED_RELATIVE_PATHS);
    L22:
        this.f9305l = true;
    }

    @Override // i0.a
    protected boolean f() {
        return true;
    }

    @Override // i0.a
    public void i() {
        boolean r10 = e();
        if (this.f9305l == true) goto L16;
        if (r10 == false) goto L17;
        M();
        if (this.f9318y == false) goto L11;
        this.f9305l = true;
        return;
    L11:
        if (this.f9306m == false) goto L13;
        K();
    L14:
        this.f9305l = true;
        m();
        b();
        return;
    L13:
        L();
        goto L14
    L17:
        return;
    }

    @Override // i0.a
    protected long n() {
        return AnrManager.ANR_MIN_INTERVAL;
    }
}
