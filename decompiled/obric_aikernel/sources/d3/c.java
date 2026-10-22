package d3;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8453h = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f8456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f8457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f8458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f8459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set<Pattern> f8460g;

    static {
    }

    public c(int r10) {
        this.f8456c = false;
        this.f8457d = new HashSet();
        this.f8458e = new HashSet();
        this.f8459f = new HashSet();
        this.f8460g = new HashSet();
        this.f8454a = r10;
        this.f8455b = r10;
    }

    protected static c a(String r10, int r11, int r12, JSONObject r13) {
        if (r10.equals("rm") == false) goto L6;
        c r14 = new f(r11);
    L8:
        r14.i(r13);
        r14.m(r12);
        return r14;
    L6:
        if (r10.equals("encrypt") == false) goto L10;
        r14 = new b(r11);
        goto L8
    L10:
        return null;
    }

    private boolean c(n4.c r10, Map<String, List<String>> r11) {
        if (e(r10) == true) goto L7;
        return false;
    L7:
        return b(r10, r11);
    }

    private boolean e(n4.c r10) {
        if (r10.C() <= this.f8454a) goto L6;
        return false;
    L6:
        return true;
    }

    private static boolean f(Set<?> r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean g(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        Iterator<String> r11 = this.f8457d.iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        if (k.i(r10, r11.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static void k(JSONArray r10, Set<Pattern> r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L23;
        int r12 = 0;
    L16:
        if (r12 >= r10.length()) goto L25;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r13) == true) goto L12;
        r11.add(Pattern.compile(r13, 2));     // Catch: Throwable -> L14
    L12:
        r12 = r12 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private void l(JSONArray r10, Set<String> r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r10.length()) goto L21;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r11.add(r13);     // Catch: JSONException -> L13
    L11:
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private void m(int r10) {
        this.f8455b = r10;
    }

    protected abstract boolean b(n4.c r10, Map<String, List<String>> r11);

    public int d() {
        return this.f8454a;
    }

    protected boolean h(n4.c r10) {
        if (this.f8456c == false) goto L8;
        if (e.f().f8469c.get() == true) goto L8;
        return false;
    L8:
        if (f(this.f8457d) == false) goto L10;
    L12:
        String r11 = r10.A();
        if (TextUtils.isEmpty(r11) == true) goto L15;
        int r12 = r11.length();
        if (r12 <= 1) goto L24;
        int r13 = r12 - 1;
        if (r11.substring(r13).equals("/") == false) goto L24;
        r11 = r11.substring(0, r13);
    L24:
        if (f(this.f8458e) == true) goto L29;
        if (this.f8458e.contains(r11) == false) goto L29;
        return true;
    L29:
        if (f(this.f8459f) == true) goto L37;
        Iterator<String> r14 = this.f8459f.iterator();
    L32:
        if (r14.hasNext() == false) goto L37;
        if (r11.startsWith(r14.next()) == false) goto L32;
        return true;
    L37:
        if (f(this.f8460g) == true) goto L46;
        Iterator<Pattern> r15 = this.f8460g.iterator();
    L40:
        if (r15.hasNext() == false) goto L46;
        Pattern r16 = r15.next();
        if (r16 == null) goto L40;
        if (r16.matcher(r11).matches() == false) goto L40;
        return true;
    L46:
        return false;
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d(f8453h, "Path is empty: " + r11);
    L17:
        return false;
    L10:
        if (g(r10.w()) == true) goto L12;
        return false;
    }

    protected abstract void i(JSONObject r10);

    protected void j(JSONObject r10) {
        l(r10.optJSONArray("host_group"), this.f8457d);
        l(r10.optJSONArray("equal_group"), this.f8458e);
        l(r10.optJSONArray("prefix_group"), this.f8459f);
        k(r10.optJSONArray("pattern_group"), this.f8460g);
    }

    protected boolean n(n4.c r10, Map<String, List<String>> r11, List<a> r12) {
        a r13 = new a();
        r13.g(SystemClock.uptimeMillis());
        boolean r14 = c(r10, r11);
        if (r14 == false) goto L5;
        r10.U(this.f8455b);
    L5:
        r13.e(r14);
        r13.f(this.f8454a);
        r13.d(SystemClock.uptimeMillis());
        r12.add(r13);
        return r14;
    }
}
