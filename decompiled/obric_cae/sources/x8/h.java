package x8;

import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import d7.p;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h implements w6.e.InterfaceC0187e, n7.a.InterfaceC0119a, w8.b.InterfaceC0189b, a7.i.b, a7.i.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile h f13709q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13711b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13715p;

    public h() {
        h();
    }

    public static boolean i(String r8, ArrayList r10) {
        if (r5.f.b(r8) == false) goto L5;
        return false;
    L5:
        if (l6.a.g0(r10) == true) goto L19;
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L20;
        if (r8.endsWith((String) r11.next()) == false) goto L9;
        return true;
    L20:
        return false;
    L19:
        return false;
    }

    @Override // w6.e.InterfaceC0187e
    public final List<String> a(CookieManager r8, c7.a r10, URI r11) {
        if (r11 == null) goto L38;
        if (r8 != null) goto L39;
        if (r10 == null) goto L38;
    L39:
        String r12 = r11.getHost();     // Catch: Exception -> L9
    L10:
        ArrayList r13 = new ArrayList();
        String[] r14 = this.f13710a.split(",");
        int r15 = r14.length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L17;
        String r17 = r14[r16];
        if (r5.f.b(r17) == true) goto L15;
        r13.add(r17);
    L15:
        r16 = r16 + 1;
        goto L11
    L17:
        if (r5.f.b(r12) == true) goto L38;
        if (i(r12, r13) == false) goto L38;
        ArrayList r18 = new ArrayList();
        if (r8 == null) goto L27;
        String r19 = r8.getCookie(TTNetInit.getTTNetDepend().getShareCookieMainDomain());
        if (r5.f.b(r19) == true) goto L27;
        r18.add(r19);
    L27:
        if (l6.a.g0(r18) == false) goto L46;
        if (r10 == null) goto L47;
        Map<String, List<String>> r20 = r10.get(URI.create(r11.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());     // Catch: Throwable -> L35
        if (r20 != null) goto L32;
        return r18;
    L32:
        if (r20.isEmpty() == true) goto L49;
        return r20.get("Cookie");
    L49:
        return r18;
    L35:
        th = move-exception;
        th.printStackTrace();
        return r18;
    L47:
        return r18;
    L46:
        return r18;
    L9:
        r12 = null;
    L38:
        return null;
    }

    @Override // w6.e.InterfaceC0187e
    public final List<String> b(String r8) {
        ArrayList r10 = new ArrayList();
        String[] r11 = this.f13710a.split(",");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        String r14 = r11[r13];
        if (r5.f.b(r14) == true) goto L7;
        r10.add(r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        String r15 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (r5.f.b(r15) == true) goto L14;
        if (i(r15, r10) == true) goto L14;
        r10.add(r15);
    L14:
        if (i(r8, r10) == false) goto L16;
        return r10;
    L16:
        return null;
    }

    @Override // w8.b.InterfaceC0189b
    public final boolean c() {
        if (c.O == false) goto L7;
        p.f6905b = 8;
        return false;
    L7:
        if (c.n() == false) goto L10;
        return false;
    L10:
        if (this.f13715p <= 5) goto L14;
        p.f6905b = 3;
        Logger.e("SyncMainProcessConfig", "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L14:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L17;
        p.f6905b = 6;
        return false;
    L17:
        return true;
    }

    @Override // n7.a.InterfaceC0119a
    public final boolean d() {
        if (this.f13711b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // n7.a.InterfaceC0119a
    public final boolean e() {
        if (this.f13712m <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // n7.a.InterfaceC0119a
    public final boolean f() {
        if (this.f13713n <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // a7.i.b
    public final boolean g() {
        c r8 = c.J;
        if (this.f13714o <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        Logger.w("SyncMainProcessConfig", "Sync main process config in current process.");
        this.f13710a = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(this.f13710a);
        boolean r8 = false;
        this.f13711b = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
        int r10 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
        this.f13712m = r10;
        if (this.f13711b > 0) goto L5;
        if (r10 > 0) goto L5;
    L6:
        this.f13713n = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
        this.f13714o = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
        this.f13715p = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
        int r11 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "query_filter_enabled", Integer.MIN_VALUE);
        String r12 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "query_filter_actions", "");
        m7.c.c().g(TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "L0_params", ""));
        if (r11 == Integer.MIN_VALUE) goto L13;
        m7.c r13 = m7.c.c();
        if (r11 <= 0) goto L11;
        r8 = true;
    L11:
        r13.f9294b = r8;
        m7.c.c().d(r12);
        return;
    L13:
        return;
    L5:
        c9.a.f3424a = true;
        goto L6
    }

    @Override // a7.i.a
    public final boolean isCronetBootFailureExpected() {
        c r8 = c.J;
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) > 5) goto L6;
        return true;
    L6:
        return false;
    }
}
