package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f1839m = "h";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile h f1840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static AtomicBoolean f1841o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f1843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicLong f1844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<g> f1845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantReadWriteLock f1846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<b> f1847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ReentrantReadWriteLock f1848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f1849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicLong f1850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConcurrentMap<String, String> f1851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f1852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f1853l;

    static class a implements Comparator<BaseDispatchAction> {
        a() {
        }

        public int a(BaseDispatchAction r10, BaseDispatchAction r11) {
            return r10.b() - r11.b();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(BaseDispatchAction r10, BaseDispatchAction r11) {
            return a(r10, r11);
        }
    }

    static {
        f1841o = new AtomicBoolean(false);
    }

    public h() {
        this.f1842a = null;
        this.f1843b = new AtomicBoolean(true);
        this.f1844c = new AtomicLong(0);
        this.f1845d = new ArrayList();
        this.f1846e = new ReentrantReadWriteLock();
        this.f1847f = new ArrayList();
        this.f1848g = new ReentrantReadWriteLock();
        this.f1849h = new AtomicInteger(0);
        this.f1850i = new AtomicLong(0);
        this.f1851j = new ConcurrentHashMap();
    }

    private y2.b a(y2.c r12) {
        String r10 = r12.d();
        y2.b r11 = new y2.b();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        r14.add(0, r10);
        this.f1846e.readLock().lock();
        Iterator<g> r15 = this.f1845d.iterator();
        String r16 = r10;
    L4:
        if (r15.hasNext() == false) goto L15;
        g r17 = r15.next();
        if (Logger.debug() == false) goto L8;
        String r18 = f1839m;
        Logger.d(r18, "action url = " + r14);
        Logger.d(r18, "current action priority is " + r17.b());
    L8:
        BaseDispatchAction.DispatchResultEnum r19 = r17.w(r12, r16, r14, r13);
        String r20 = (String) r14.get(0);
        if (r19 == BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP) goto L11;
        r16 = r20;
        goto L4
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(f1839m, "the url has been dropped by urldispatcher, skip follow-up actions");
    L13:
        r11.f13669d = r17.t();
    L15:
        String r110 = (String) r14.get(0);
        this.f1846e.readLock().unlock();
        ArrayList r111 = new ArrayList();
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L25
        r21.put("origin_url", r10);     // Catch: JSONException -> L25
        r21.put("dispatched_url", r110);     // Catch: JSONException -> L25
        JSONArray r22 = new JSONArray();     // Catch: JSONException -> L25
        Iterator r23 = r13.iterator();     // Catch: JSONException -> L25
    L18:
        if (r23.hasNext() == false) goto L23;
        y2.a r24 = (y2.a) r23.next();     // Catch: JSONException -> L25
        if (r24.f13662d == false) goto L18;
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L25
        r111.add(Long.valueOf(r24.f13660b));     // Catch: JSONException -> L25
        r25.put("rule_id", r24.f13660b);     // Catch: JSONException -> L25
        r25.put("service_name", r24.f13659a);     // Catch: JSONException -> L25
        r25.put("priority", r24.f13661c);     // Catch: JSONException -> L25
        r22.put(r25);     // Catch: JSONException -> L25
        goto L18
    L23:
        r21.put("action_info_list", r22);     // Catch: JSONException -> L25
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L25
        r26.put("dispatch", r21);     // Catch: JSONException -> L25
        new JSONObject().put("dispatchersdk", r26);     // Catch: JSONException -> L25
    L27:
        r11.f13667b = r111;
        r11.f13666a = r110;
        r11.f13668c = r13;
        return r11;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    public static h l() {
        if (f1840n != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1840n != null) goto L9;
        f1840n = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f1840n;
    }

    private void p(JSONObject r20) {
        String r10 = r20.optString("action");
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        int r11 = r20.optInt("act_priority", -1);
        if (r11 >= 0) goto L8;
        return;
    L8:
        JSONObject r12 = r20.optJSONObject("param");
        if (r12 != null) goto L11;
        return;
    L11:
        String r13 = r20.optString("lifecycle");
        int r14 = 0;
        long r15 = 0;
        long r16 = -1;
        if ("".equals(r13) == false) goto L14;
        r16 = 0;
    L20:
        long r17 = r20.optInt("rule_id");
        String r18 = r20.optString("sign");
        ArrayList r19 = new ArrayList();
        JSONArray r21 = r20.optJSONArray("request_method");
        if (r21 != null) goto L23;
    L28:
        long r22 = r15;
        long r23 = r16;
        BaseDispatchAction r24 = BaseDispatchAction.a(r10, r12, r11, r22, r23, r17, r18, this.f1844c.get(), r19, r20.optInt("set_req_priority", r11));
        if ((r24 instanceof g) == false) goto L35;
        this.f1845d.add((g) r24);
        return;
    L35:
        return;
    L23:
        if (r14 >= r21.length()) goto L28;
        String r110 = r21.optString(r14);
        if (TextUtils.isEmpty(r110) == true) goto L27;
        r19.add(r110);
    L27:
        r14 = r14 + 1;
        goto L23
    L14:
        ArrayList r25 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.f.e(r13, r25) == true) goto L17;
    L19:
        r15 = -1;
        goto L20
    L17:
        if (r25.size() != 2) goto L19;
        r15 = ((Long) r25.get(0)).longValue();
        r16 = ((Long) r25.get(1)).longValue();
        goto L20
    }

    private void q(JSONObject r19) {
        int r10 = r19.optInt("act_priority", -1);
        if (r10 >= 0) goto L5;
        return;
    L5:
        JSONObject r11 = r19.optJSONObject("param");
        if (r11 != null) goto L8;
        return;
    L8:
        String r12 = r19.optString("lifecycle");
        long r13 = -1;
        if ("".equals(r12) == false) goto L11;
        r13 = 0;
    L16:
        long r14 = r13;
    L17:
        BaseDispatchAction r15 = BaseDispatchAction.a("delay", r11, r10, r13, r14, 0, "", this.f1844c.get(), null, 0);
        if ((r15 instanceof b) == false) goto L21;
        this.f1847f.add((b) r15);
        return;
    L21:
        return;
    L11:
        ArrayList r16 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.f.e(r12, r16) != true) goto L16;
        if (r16.size() != 2) goto L16;
        r13 = ((Long) r16.get(0)).longValue();
        r14 = ((Long) r16.get(1)).longValue();
        goto L17
    }

    public Context b() {
        return this.f1842a;
    }

    public int c(String r10, String r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1839m, "getDelayResultForUrl: " + r10);
    L6:
        if (k.f(r10) == false) goto L8;
        this.f1848g.readLock().lock();
        ArrayList r12 = new ArrayList();
        r12.add(0, 0);
        Iterator<b> r13 = this.f1847f.iterator();
    L13:
        if (r13.hasNext() == false) goto L22;
        b r14 = r13.next();
        if (Logger.debug() == false) goto L18;
        Logger.d(f1839m, "current action priority is " + r14.b());
    L18:
        if (r14.t(r10, r11, r12) != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L13;
        if (Logger.debug() == false) goto L22;
        Logger.d(f1839m, "the url has been delayed by delay action, skip follow-up actions");
    L22:
        this.f1848g.readLock().unlock();
        return ((Integer) r12.get(0)).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(f1839m, "illegal url");
    L10:
        return 0;
    }

    public y2.b d(y2.c r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1839m, "getDispatchResultForUrl: " + r10.d());
    L6:
        if (k.f(r10.d()) == true) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(f1839m, "illegal url");
    L10:
        return null;
    L12:
        if (this.f1843b.get() == true) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.d(f1839m, "dispatch is unabled by tnc");
    L16:
        return null;
    L18:
        return a(r10);
    }

    public long e() {
        return this.f1844c.get();
    }

    public ConcurrentMap<String, String> f() {
        return this.f1851j;
    }

    public String g() {
        return this.f1853l;
    }

    public String h() {
        return this.f1852k;
    }

    public int i() {
        return this.f1849h.get();
    }

    public long j() {
        return this.f1850i.get();
    }

    public String k(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L50:
        return r10;
    L5:
        if (r10.contains("/network/get_network") == true) goto L50;
        if (r10.contains("/get_domains/v5") == true) goto L50;
        if (r10.contains("/ies/speed") == true) goto L50;
        String r11 = null;
        URL r12 = new URL(r10);     // Catch: Throwable -> L17
        String r13 = r12.getProtocol();     // Catch: Throwable -> L17
        r11 = r12.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r13) == true) goto L50;
        if ("http".equals(r13) == true) goto L27;
        if ("https".equals(r13) == false) goto L50;
    L27:
        if (TextUtils.isEmpty(r11) == true) goto L50;
        ConcurrentMap<String, String> r14 = this.f1851j;
        if (r14 == null) goto L48;
        if (r14.containsKey(r11) == false) goto L48;
        String r15 = this.f1851j.get(r11);
        if (TextUtils.isEmpty(r15) == false) goto L38;
        return r10;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d(f1839m, "handleHostMapping, match, origin: " + r10);
    L40:
        String r16 = r13 + "://" + r11;
        String r17 = r13 + "://" + r15;
        if (r10.startsWith(r16) == false) goto L44;
        r10 = r10.replaceFirst(r16, r17);
    L44:
        if (Logger.debug() == false) goto L46;
        Logger.d(f1839m, "handleHostMapping, target: " + r10);
    L46:
        return r10;
    L48:
        if (Logger.debug() == false) goto L50;
        Logger.d(f1839m, "handleHostMapping, nomatch: " + r11);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r13 = null;
        goto L19
    }

    public boolean m() {
        return this.f1845d.isEmpty();
    }

    public void n(Context r11) {
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(r11) == true) goto L5;
        return;
    L5:
        if (f1841o.get() == true) goto L23;
        SharedPreferences r10 = r11.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r12 = r10.getBoolean("is_full_config", false);
        String r13 = r10.getString("tnc_config_str", null);
        String r14 = r10.getString("ttnet_tnc_etag", null);
        String r15 = r10.getString("ttnet_tnc_abtest", null);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        f1841o.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r13) == true) goto L18;
        JSONObject r16 = new JSONObject(r13);     // Catch: JSONException -> L16
        if (r12 == false) goto L14;
        JSONObject r17 = r16.optJSONObject("data");     // Catch: JSONException -> L16
        if (r17 == null) goto L14;
        r16 = r17;
    L14:
        h r18 = l();     // Catch: JSONException -> L16
        r18.o(r16, 0, r14, r15, System.currentTimeMillis());     // Catch: JSONException -> L16
        goto L18
    }

    public void o(JSONObject r10, int r11, String r12, String r13, long r14) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1839m, "URLDispatcher::onServerConfigChanged, tnc source is " + r11 + "etag is " + r12);
    L5:
        this.f1849h.set(r11);
        this.f1852k = r12;
        this.f1853l = r13;
        this.f1850i.set(r14);
        int r15 = r10.optInt("ignore_retrofit_slash_enabled_v2", -1);
        int r16 = 0;
        boolean r17 = true;
        if (r15 < (-1)) goto L11;
        if (r15 != 1) goto L9;
        boolean r18 = true;
    L10:
        sc.a.j(r18);
        goto L11
    L9:
        r18 = false;
    L11:
        JSONArray r19 = r10.optJSONArray("request_delay_actions");
        this.f1848g.writeLock().lock();     // Catch: Throwable -> L62
        this.f1847f.clear();     // Catch: Throwable -> L62
        if (r19 == null) goto L22;
        int r110 = 0;
    L16:
        if (r110 >= r19.length()) goto L22;
        JSONObject r20 = r19.optJSONObject(r110);     // Catch: Throwable -> L62
        if (r20 == null) goto L20;
        q(r20);     // Catch: Throwable -> L62
    L20:
        r110 = r110 + 1;     // Catch: Throwable -> L62
    L22:
        if (this.f1847f.isEmpty() == true) goto L24;
        Collections.sort(this.f1847f, new a());     // Catch: Throwable -> L62
    L24:
        this.f1848g.writeLock().unlock();
        if (Logger.debug() == false) goto L27;
        Logger.d(f1839m, "parse delay actions completed, actions size is " + this.f1847f.size());
    L27:
        int r21 = r10.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r21 < 0) goto L34;
        AtomicBoolean r111 = this.f1843b;
        if (r21 == 1) goto L33;
        r17 = false;
    L33:
        r111.set(r17);
    L34:
        long r22 = r10.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r22 == this.f1844c.get()) goto L37;
        this.f1844c.set(r22);
        JSONArray r23 = r10.optJSONArray("ttnet_dispatch_actions");
        if (r23 != null) goto L69;
        return;
    L69:
        this.f1846e.writeLock().lock();     // Catch: Throwable -> L57
        this.f1845d.clear();     // Catch: Throwable -> L57
    L45:
        if (r16 >= r23.length()) goto L51;
        JSONObject r24 = r23.optJSONObject(r16);     // Catch: Throwable -> L57
        if (r24 == null) goto L49;
        p(r24);     // Catch: Throwable -> L57
    L49:
        r16 = r16 + 1;     // Catch: Throwable -> L57
        goto L45
    L51:
        if (this.f1845d.isEmpty() == true) goto L53;
        Collections.sort(this.f1845d, new a());     // Catch: Throwable -> L57
    L53:
        this.f1846e.writeLock().unlock();
        if (Logger.debug() == false) goto L78;
        Logger.d(f1839m, "parse dispatch actions completed, actions size is " + this.f1845d.size());
        return;
    L78:
        return;
    L57:
        th = move-exception;
        this.f1846e.writeLock().unlock();
        if (Logger.debug() == false) goto L61;
        Logger.d(f1839m, "parse dispatch actions completed, actions size is " + this.f1845d.size());
    L61:
        throw th;
    L37:
        if (Logger.debug() == false) goto L77;
        Logger.d(f1839m, "dispatch action epoch not changed");
        return;
    L77:
        return;
    L62:
        th = move-exception;
        this.f1848g.writeLock().unlock();
        if (Logger.debug() == false) goto L66;
        Logger.d(f1839m, "parse delay actions completed, actions size is " + this.f1847f.size());
    L66:
        throw th;
    }

    public void r(Context r10) {
        this.f1842a = r10;
    }

    public void s(String r10) {
        this.f1853l = r10;
    }
}
