package r2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile f f12620c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12621d = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f12622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<a> f12623b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f12624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<String> f12625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<String> f12626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<String> f12627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        List<Pattern> f12628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Set<Integer> f12629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f12630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f12631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f12632i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile int f12633j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile long f12634k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f12635l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f12636m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f12637n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f12638o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f12639p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f12640q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f12641r;

        public a(List<String> r10, List<String> r11) {
            this.f12640q = false;
            this.f12641r = 0;
            this.f12624a = r10;
            this.f12625b = r11;
            this.f12634k = SystemClock.uptimeMillis();
            this.f12633j = 0;
            this.f12631h = Integer.MAX_VALUE;
            this.f12630g = 0;
            this.f12635l = false;
            this.f12632i = UUID.randomUUID().toString();
            this.f12637n = false;
            this.f12636m = 4000;
            this.f12638o = true;
            this.f12639p = null;
        }

        public List<String> a() {
            return this.f12625b;
        }

        public String b() {
            return this.f12632i;
        }
    }

    static {
    }

    private f() {
        this.f12622a = 0;
        this.f12623b = new CopyOnWriteArrayList();
    }

    private a a(String r10) {
        Iterator<a> r11 = this.f12623b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        a r12 = r11.next();
        if (r12.b().equals(r10) == false) goto L4;
        return r12;
    L8:
        return null;
    }

    public static f d() {
        if (f12620c != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12620c != null) goto L9;
        f12620c = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f12620c;
    }

    private static boolean f(List<?> r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean g(n4.c r10, a r11) {
        if (r11.f12630g > 0) goto L5;
    L7:
        String r12 = r10.G();
        if (TextUtils.isEmpty(r12) == false) goto L10;
        return false;
    L10:
        Iterator<String> r13 = r11.f12624a.iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        if (k.i(r10.w(), r13.next()) == false) goto L12;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L19;
        String r15 = r10.A();
        if (TextUtils.isEmpty(r15) == false) goto L26;
        return false;
    L26:
        if (f(r11.f12626c) == true) goto L34;
        Iterator<String> r16 = r11.f12626c.iterator();
    L29:
        if (r16.hasNext() == false) goto L34;
        if (r15.equals(r16.next()) == false) goto L29;
        return true;
    L34:
        if (f(r11.f12627d) == true) goto L42;
        Iterator<String> r17 = r11.f12627d.iterator();
    L37:
        if (r17.hasNext() == false) goto L42;
        if (r15.startsWith(r17.next()) == false) goto L37;
        return true;
    L42:
        if (f(r11.f12628e) == true) goto L51;
        Iterator<Pattern> r18 = r11.f12628e.iterator();
    L45:
        if (r18.hasNext() == false) goto L51;
        Pattern r19 = r18.next();
        if (r19 == null) goto L45;
        if (r19.matcher(r15).matches() == false) goto L45;
        return true;
    L51:
        return false;
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(f12621d, "host not match: " + r12);
    L21:
        return false;
    L16:
        r14 = false;
        goto L17
    L5:
        if (r11.f12635l == false) goto L7;
        return false;
    }

    private static boolean j(JSONObject r10, String r11, List<String> r12) {
        int r13 = 0;
        if (r10 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        if (r12 == null) goto L19;
        JSONArray r14 = r10.optJSONArray(r11);
        if (r14 != null) goto L12;
        return false;
    L12:
        if (r13 >= r14.length()) goto L17;
        String r15 = r14.optString(r13);
        if (TextUtils.isEmpty(r15) == true) goto L16;
        r12.add(r15);
    L16:
        r13 = r13 + 1;
        goto L12
    L17:
        return true;
    }

    private void k(JSONObject r10) {
        ArrayList r11 = new ArrayList();
        j(r10, "host_group", r11);
        ArrayList r12 = new ArrayList();
        j(r10, "concurrent_hosts", r12);
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        if (r12.size() < 2) goto L57;
        a r13 = new a(r11, r12);
        ArrayList r14 = new ArrayList();
        if (j(r10, "equal_group", r14) == false) goto L10;
        r13.f12626c = r14;
    L10:
        ArrayList r15 = new ArrayList();
        if (j(r10, "prefix_group", r15) == false) goto L13;
        r13.f12627d = r15;
    L13:
        ArrayList r16 = new ArrayList();
        JSONArray r17 = r10.optJSONArray("pattern_group");
        int r18 = 0;
        if (r17 == null) goto L23;
        int r19 = 0;
    L17:
        if (r19 >= r17.length()) goto L22;
        String r20 = r17.optString(r19);
        if (TextUtils.isEmpty(r20) == true) goto L21;
        r16.add(Pattern.compile(r20, 2));     // Catch: Throwable -> L49
    L21:
        r19 = r19 + 1;
        goto L17
    L22:
        r13.f12628e = r16;
    L23:
        r13.f12631h = r10.optInt("fail_count", Integer.MAX_VALUE);
        r13.f12630g = r10.optInt("forbid_seconds", 0);
        r13.f12636m = r10.optInt("connect_interval_millis", 4000);
        boolean r21 = true;
        if (r10.optInt("bypass_rs_enabled", 1) <= 0) goto L26;
        boolean r22 = true;
    L27:
        r13.f12638o = r22;
        String r23 = r10.optString("concurrent_route");
        r13.f12639p = r23;
        if (TextUtils.isEmpty(r23) == false) goto L31;
        r13.f12639p = r10.optString("rs_name", null);
    L31:
        if (r10.optInt("fin_fix_enabled", 0) <= 0) goto L33;
        boolean r24 = true;
    L34:
        r13.f12640q = r24;
        r13.f12641r = r10.optInt("max_wait_seconds", 0);
        if (r13.f12636m > 0) goto L38;
        return;
    L38:
        if (r10.optInt("retry_for_not_2xx_code", 0) > 0) goto L41;
        r21 = false;
    L41:
        r13.f12637n = r21;
        HashSet r25 = new HashSet();
        JSONArray r26 = r10.optJSONArray("block_code_list");
        if (r26 != null) goto L44;
    L47:
        this.f12623b.add(r13);
        return;
    L44:
        if (r18 >= r26.length()) goto L46;
        r25.add(Integer.valueOf(r26.optInt(r18)));
        r18 = r18 + 1;
        goto L44
    L46:
        r13.f12629f = r25;
        goto L47
    L33:
        r24 = false;
        goto L34
    L26:
        r22 = false;
        goto L27
    }

    private void l() {
        Iterator<a> r10 = this.f12623b.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        a r11 = r10.next();
        if (r11.f12635l == false) goto L4;
        long r12 = SystemClock.uptimeMillis() - r11.f12634k;
        if (r12 <= (r11.f12630g * 1000)) goto L11;
        r11.f12635l = false;
    L11:
        if (Logger.debug() == false) goto L4;
        Logger.d(f12621d, "Rule id: " + r11.f12632i + " has forbidden duration: " + r12 + " fail count: " + r11.f12633j + " forbidden duration: " + (r11.f12630g * 1000));
        goto L4
    }

    private void m(a r10, boolean r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f12621d, "Forbidden: " + r10.f12635l + " failed count: " + r10.f12633j + " max count: " + r10.f12631h);
    L5:
        int r12 = r10.f12633j;
        if (r11 == false) goto L13;
        if (r12 == 0) goto L9;
    L11:
        r10.f12633j = 0;
        r10.f12635l = false;
        return;
    L9:
        if (r10.f12635l == true) goto L11;
        return;
    L13:
        int r13 = r12 + 1;
        r10.f12633j = r13;
        if (r13 >= r10.f12631h) goto L17;
        return;
    L17:
        if (r10.f12635l == true) goto L20;
        r10.f12635l = true;
        r10.f12634k = SystemClock.uptimeMillis();
    L20:
        if (Logger.debug() == false) goto L23;
        Logger.d(f12621d, "Forbidden: " + r10.f12635l + " failed count: " + r10.f12633j);
        return;
    }

    public a b(n4.c r10) {
        l();
        Iterator<a> r11 = this.f12623b.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        a r12 = r11.next();
        if (g(r10, r12) == false) goto L4;
        return r12;
    L8:
        return null;
    }

    public boolean c(int r10, String r11) {
        if (r10 != 0) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        a r12 = a(r11);
        if (r12 == null) goto L14;
        Set<Integer> r13 = r12.f12629f;
        if (r13 == null) goto L14;
        return r13.contains(Integer.valueOf(r10));
    }

    public boolean e() {
        if (this.f12622a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void h(String r10, boolean r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        a r12 = a(r10);
        if (r12 != null) goto L8;
        return;
    L8:
        m(r12, r11);
    }

    public void i(String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f12621d, "onNetConfigChanged config: " + r10);
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return;
    L17:
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L13
        int r12 = 0;
        this.f12622a = r11.optInt("enabled_v2", 0);     // Catch: Throwable -> L13
        this.f12623b.clear();     // Catch: Throwable -> L13
        JSONArray r13 = r11.getJSONArray("match_rules");     // Catch: Throwable -> L13
    L10:
        if (r12 >= r13.length()) goto L21;
        k((JSONObject) r13.get(r12));     // Catch: Throwable -> L13
        r12 = r12 + 1;
        goto L10
    L21:
        return;
    L14:
        if (Logger.debug() == false) goto L20;
        Logger.d(f12621d, "parse json config error");
        return;
    }
}
