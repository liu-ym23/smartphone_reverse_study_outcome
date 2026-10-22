package sc;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f12792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f12793d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0291a f12794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f12795b;

    /* JADX INFO: renamed from: sc.a$a, reason: collision with other inner class name */
    public static class C0291a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f12796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f12797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f12798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f12799d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f12800e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f12801f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f12802g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicBoolean f12803h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<String> f12804i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<String> f12805j;

        public C0291a() {
            this.f12796a = new CopyOnWriteArrayList();
            this.f12797b = new CopyOnWriteArrayList();
            this.f12798c = new AtomicBoolean(false);
            this.f12799d = new CopyOnWriteArrayList();
            this.f12800e = new AtomicBoolean(false);
            this.f12801f = new AtomicBoolean(false);
            this.f12802g = new AtomicBoolean(false);
            this.f12803h = new AtomicBoolean(false);
            this.f12804i = new ArrayList();
            this.f12805j = new ArrayList();
        }
    }

    static {
        f12793d = new AtomicBoolean(false);
    }

    public a() {
        this.f12794a = new C0291a();
        this.f12795b = new CopyOnWriteArrayList();
    }

    public static boolean b(String r10) {
        return c(r10, d().f12795b);
    }

    public static boolean c(String r10, List<String> r11) {
        if (TextUtils.isEmpty(r10) == true) goto L18;
        if (r11 == null) goto L18;
        if (r11.isEmpty() == true) goto L18;
        Iterator<String> r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L18;
        String r13 = r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L10;
        if (r10.endsWith(r13) == false) goto L10;
        return true;
    L18:
        return false;
    }

    public static a d() {
        if (f12792c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12792c != null) goto L9;
        f12792c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12792c;
    }

    public static boolean e() {
        return f12793d.get();
    }

    public static void g(JSONObject r10, String r11, List<String> r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L22;
        JSONArray r13 = r10.optJSONArray(r11);
        if (r13 != null) goto L9;
        return;
    L9:
        ArrayList r14 = new ArrayList();
        int r15 = 0;
    L11:
        if (r15 >= r13.length()) goto L16;
        String r16 = r13.optString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L15;
        r14.add(r16);
    L15:
        r15 = r15 + 1;
        goto L11
    L16:
        r12.clear();
        r12.addAll(r14);
        return;
    }

    public static void i(String r10, List<String> r11) {
        if (TextUtils.isEmpty(r10) == true) goto L14;
        if (r11 == null) goto L19;
        String[] r12 = r10.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L20;
        String r15 = r12[r14];
        if (TextUtils.isEmpty(r15) == true) goto L13;
        if (c(r15, r11) == true) goto L13;
        r11.add(r15.trim());
    L13:
        r14 = r14 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void j(boolean r10) {
        f12793d.set(r10);
    }

    public C0291a a() {
        return this.f12794a;
    }

    public void f(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        h(r10);
    }

    public void h(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r11 = r10.optJSONObject("rect_request_control");
        if (r11 != null) goto L7;
        return;
    L7:
        g(r11, "scy_headers", this.f12794a.f12796a);
        g(r11, "scy_rect_wl", this.f12794a.f12797b);
        int r12 = r11.optInt("rm_inscy_out_wl", -1);
        boolean r13 = false;
        if (r12 < 0) goto L14;
        AtomicBoolean r14 = this.f12794a.f12798c;
        if (r12 != 1) goto L12;
        boolean r15 = true;
    L13:
        r14.set(r15);
        goto L14
    L12:
        r15 = false;
    L14:
        g(r11, "scy_rect_bl", this.f12794a.f12799d);
        int r16 = r11.optInt("disable_report_inscy_rect", -1);
        if (r16 < 0) goto L21;
        AtomicBoolean r17 = this.f12794a.f12800e;
        if (r16 != 1) goto L19;
        boolean r18 = true;
    L20:
        r17.set(r18);
        goto L21
    L19:
        r18 = false;
    L21:
        int r19 = r11.optInt("only_control_webview", -1);
        if (r19 < 0) goto L28;
        AtomicBoolean r20 = this.f12794a.f12801f;
        if (r19 != 1) goto L26;
        boolean r21 = true;
    L27:
        r20.set(r21);
        goto L28
    L26:
        r21 = false;
    L28:
        int r22 = r11.optInt("enable_report_full_url", -1);
        if (r22 < 0) goto L35;
        AtomicBoolean r23 = this.f12794a.f12802g;
        if (r22 != 1) goto L33;
        boolean r24 = true;
    L34:
        r23.set(r24);
        goto L35
    L33:
        r24 = false;
    L35:
        int r25 = r11.optInt("v2_on", -1);
        if (r25 < 0) goto L41;
        AtomicBoolean r26 = this.f12794a.f12803h;
        if (r25 != 1) goto L40;
        r13 = true;
    L40:
        r26.set(r13);
    L41:
        g(r11, "keep_headers_v2", this.f12794a.f12804i);
        g(r11, "rm_std_keep_headers_v2", this.f12794a.f12805j);
        i(r10.optString("share_cookie_host_list"), this.f12795b);
    }

    public boolean k(IOException r10, x r11, int r12) {
        return false;
    }
}
