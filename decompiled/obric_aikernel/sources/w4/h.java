package w4;

import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.n;
import com.bytedance.ttnet.TTNetInit;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class h implements o2.f.j, g3.a.InterfaceC0172a, com.bytedance.ttnet.c.InterfaceC0072c, i.b, i.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile h f13384l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13385c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13390k;

    private h() {
        a();
    }

    private boolean b(String r10, List<String> r11) {
        if (com.bytedance.common.utility.g.b(r10) == false) goto L5;
    L14:
        return false;
    L5:
        if (com.bytedance.common.utility.c.a(r11) == true) goto L14;
        Iterator<String> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if (r10.endsWith(r12.next()) == false) goto L9;
        return true;
    }

    public static h c() {
        if (f13384l != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13384l != null) goto L9;
        f13384l = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f13384l;
    }

    public void a() {
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L23
        Logger.w("SyncMainProcessConfig", "Sync main process config in current process.");
        this.f13385c = TTNetInit.getTTNetDepend().h(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().e(this.f13385c);
        boolean r10 = false;
        this.f13386g = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
        int r11 = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
        this.f13387h = r11;
        if (this.f13386g > 0) goto L6;
        if (r11 > 0) goto L6;
    L7:
        this.f13388i = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
        this.f13389j = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
        this.f13390k = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
        int r12 = TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "query_filter_enabled", Integer.MIN_VALUE);
        String r13 = TTNetInit.getTTNetDepend().h(TTNetInit.getTTNetDepend().getContext(), "query_filter_actions", "");
        d3.d.f().k(TTNetInit.getTTNetDepend().h(TTNetInit.getTTNetDepend().getContext(), "L0_params", ""));
        if (r12 == Integer.MIN_VALUE) goto L15;
        d3.d r14 = d3.d.f();
        if (r12 <= 0) goto L12;
        boolean r15 = true;
    L13:
        r14.d(r15);
        d3.d.f().g(r13);
        goto L15
    L12:
        r15 = false;
    L15:
        if (TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "private_protocol_enabled", 1) < 1) goto L17;
        boolean r16 = true;
    L18:
        o2.f.R(r16);
        if (TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "disable_rotating_host_path_retry", -1) < 1) goto L21;
        r10 = true;
    L21:
        o2.f.P(r10);
        return;
    L17:
        r16 = false;
    L6:
        e5.a.e(true);
    }

    @Override // g3.a.InterfaceC0172a
    public boolean d() {
        if (this.f13387h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // g3.a.InterfaceC0172a
    public boolean e() {
        if (this.f13388i <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // o2.f.j
    public List<String> f(CookieManager r10, com.bytedance.frameworks.baselib.network.http.impl.b r11, URI r12) {
        if (r12 == null) goto L47;
        if (r10 != null) goto L48;
        if (r11 == null) goto L47;
    L48:
        String r13 = r12.getHost();     // Catch: Exception -> L9
    L10:
        ArrayList r14 = new ArrayList();
        String[] r15 = this.f13385c.split(",");
        int r16 = r15.length;
        int r17 = 0;
    L11:
        if (r17 >= r16) goto L17;
        String r18 = r15[r17];
        if (com.bytedance.common.utility.g.b(r18) == true) goto L15;
        r14.add(r18);
    L15:
        r17 = r17 + 1;
        goto L11
    L17:
        if (com.bytedance.common.utility.g.b(r13) == true) goto L47;
        if (b(r13, r14) == false) goto L47;
        if (com.bytedance.common.utility.g.b(TTNetInit.getTTNetDepend().k()) == false) goto L24;
        return null;
    L24:
        ArrayList r19 = new ArrayList();
        if (r10 == null) goto L30;
        String r110 = r10.getCookie(TTNetInit.getTTNetDepend().k());
        if (com.bytedance.common.utility.g.b(r110) == true) goto L30;
        r19.add(r110);
    L30:
        if (com.bytedance.common.utility.c.a(r19) == false) goto L57;
        if (r11 == null) goto L58;
        Map<String, List<String>> r111 = r11.get(URI.create(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().k()), new LinkedHashMap());     // Catch: Throwable -> L42
        if (r111 != null) goto L35;
        return r19;
    L35:
        if (r111.isEmpty() == true) goto L60;
        List<String> r112 = r111.get("Cookie");     // Catch: Throwable -> L42
        if (r112 == null) goto L46;
        r112.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L40
    L40:
        Throwable th = th;
    L44:
        th.printStackTrace();
    L46:
        return r112;
    L60:
        return r19;
    L42:
        th = move-exception;
        r112 = r19;
        th = th;
        goto L44
    L58:
        return r19;
    L57:
        return r19;
    L9:
        r13 = null;
    L47:
        return null;
    }

    @Override // o2.f.j
    public List<String> g(String r10) {
        ArrayList r11 = new ArrayList();
        String[] r12 = this.f13385c.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        String r15 = r12[r14];
        if (com.bytedance.common.utility.g.b(r15) == true) goto L7;
        r11.add(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        String r16 = TTNetInit.getTTNetDepend().k();
        if (com.bytedance.common.utility.g.b(r16) == true) goto L14;
        if (b(r16, r11) == true) goto L14;
        r11.add(r16);
    L14:
        if (b(r10, r11) == false) goto L16;
        return r11;
    L16:
        return null;
    }

    @Override // r2.i.b
    public boolean h() {
        if (a.N == false) goto L6;
        return false;
    L6:
        if (this.f13389j <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ttnet.c.InterfaceC0072c
    public boolean i() {
        if (a.N == false) goto L7;
        n.v(0);
        return false;
    L7:
        if (a.P == false) goto L11;
        n.v(8);
        return false;
    L11:
        if (a.x() == false) goto L14;
        return false;
    L14:
        if (a.L == true) goto L20;
        if (this.f13390k <= 5) goto L20;
        n.v(3);
        Logger.e("SyncMainProcessConfig", "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L20:
        if (TTNetInit.getTTNetDepend().g() == true) goto L23;
        n.v(6);
        return false;
    L23:
        return true;
    }

    @Override // r2.i.a
    public boolean isCronetBootFailureExpected() {
        if (a.L == false) goto L6;
        return true;
    L6:
        if (TTNetInit.getTTNetDepend().i(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) > 5) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // g3.a.InterfaceC0172a
    public boolean k() {
        if (this.f13386g <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
