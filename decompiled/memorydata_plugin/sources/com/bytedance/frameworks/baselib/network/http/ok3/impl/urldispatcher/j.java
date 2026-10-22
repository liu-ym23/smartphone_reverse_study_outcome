package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2522a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2523b = "j";
    private static volatile j c;
    private static AtomicBoolean p;
    private Context d;
    private AtomicBoolean e;
    private AtomicLong f;
    private List<i> g;
    private final ReentrantReadWriteLock h;
    private List<b> i;
    private final ReentrantReadWriteLock j;
    private AtomicInteger k;
    private AtomicLong l;
    private ConcurrentMap<String, String> m;
    private String n;
    private String o;

    static class a implements Comparator<BaseDispatchAction> {
        a() {
        }

        public int a(BaseDispatchAction r1, BaseDispatchAction r2) {
            return r1.a() - r2.a();
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(BaseDispatchAction r3, BaseDispatchAction r4) {
            return a((BaseDispatchAction) ZeusTransformUtils.preCheckCast(r3, BaseDispatchAction.class, "com.obric.memorydata.plugin"), (BaseDispatchAction) ZeusTransformUtils.preCheckCast(r4, BaseDispatchAction.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        p = new AtomicBoolean(false);
    }

    public j() {
        this.d = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.e = new AtomicBoolean(true);
        this.f = new AtomicLong(0);
        this.g = new ArrayList();
        this.h = new ReentrantReadWriteLock();
        this.i = new ArrayList();
        this.j = new ReentrantReadWriteLock();
        this.k = new AtomicInteger(0);
        this.l = new AtomicLong(0);
        this.m = new ConcurrentHashMap();
    }

    public static j a() {
        if (c != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    private void a(JSONObject r21) {
        String r3 = r21.optString("action");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        int r5 = r21.optInt("act_priority", -1);
        if (r5 >= 0) goto L8;
        return;
    L8:
        JSONObject r4 = r21.optJSONObject(AutoTestConstant.PARAM);
        if (r4 != null) goto L11;
        return;
    L11:
        String r2 = r21.optString("lifecycle");
        int r7 = 0;
        long r8 = 0;
        long r10 = -1;
        if ("".equals(r2) == false) goto L14;
        r10 = 0;
    L20:
        long r12 = r21.optInt("rule_id");
        String r6 = r21.optString("sign");
        ArrayList r14 = new ArrayList();
        JSONArray r9 = r21.optJSONArray("request_method");
        if (r9 != null) goto L23;
    L28:
        int r1 = r21.optInt("set_req_priority", r5);
        BaseDispatchAction r11 = BaseDispatchAction.a(r3, r4, r5, r8, r10, r12, r6, this.f.get(), r14, r1);
        if (ZeusTransformUtils.instanceOf(r11, i.class) == false) goto L35;
        this.g.add((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.memorydata.plugin"));
        return;
    L35:
        return;
    L23:
        if (r7 >= r9.length()) goto L28;
        String r15 = r9.optString(r7);
        if (TextUtils.isEmpty(r15) == true) goto L27;
        r14.add(r15);
    L27:
        r7 = r7 + 1;
        goto L23
    L14:
        ArrayList r13 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.f.a(r2, r13) == true) goto L17;
    L19:
        r8 = -1;
        goto L20
    L17:
        if (r13.size() != 2) goto L19;
        r8 = ((Long) ZeusTransformUtils.preCheckCast(r13.get(0), Long.class, "com.obric.memorydata.plugin")).longValue();
        r10 = ((Long) ZeusTransformUtils.preCheckCast(r13.get(1), Long.class, "com.obric.memorydata.plugin")).longValue();
        goto L20
    }

    private d b(k r13) {
        String r0 = r13.b();
        d r1 = new d();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r3.add(0, r0);
        this.h.readLock().lock();
        Iterator<i> r5 = this.g.iterator();
        String r6 = r0;
    L4:
        if (r5.hasNext() == false) goto L21;
        i r7 = (i) ZeusTransformUtils.preCheckCast(r5.next(), i.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L8;
        String r9 = f2523b;
        Logger.d(r9, "action url = " + r3);
        Logger.d(r9, "current action priority is " + r7.a());
    L8:
        BaseDispatchAction.DispatchResultEnum r8 = r7.a(r13, r6, r3, r2);
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.memorydata.plugin");
        if (r8 == BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP) goto L11;
        r6 = r10;
        goto L4
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(f2523b, "the url has been dropped by urldispatcher, skip follow-up actions");
    L13:
        r1.d = r7.f();
        if (f2522a == true) goto L21;
        if (((String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.memorydata.plugin")).length() == 0) goto L21;
        throw new AssertionError();
    L21:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.memorydata.plugin");
        this.h.readLock().unlock();
        ArrayList r12 = new ArrayList();
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L31
        r4.put("origin_url", r0);     // Catch: JSONException -> L31
        r4.put("dispatched_url", r14);     // Catch: JSONException -> L31
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L31
        Iterator r15 = r2.iterator();     // Catch: JSONException -> L31
    L24:
        if (r15.hasNext() == false) goto L29;
        c r16 = (c) ZeusTransformUtils.preCheckCast(r15.next(), c.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L31
        if (r16.d == false) goto L24;
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L31
        r12.add(Long.valueOf(r16.f2515b));     // Catch: JSONException -> L31
        r17.put("rule_id", r16.f2515b);     // Catch: JSONException -> L31
        r17.put("service_name", r16.f2514a);     // Catch: JSONException -> L31
        r17.put("priority", r16.c);     // Catch: JSONException -> L31
        r11.put(r17);     // Catch: JSONException -> L31
        goto L24
    L29:
        r4.put("action_info_list", r11);     // Catch: JSONException -> L31
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L31
        r18.put("dispatch", r4);     // Catch: JSONException -> L31
        new JSONObject().put("dispatchersdk", r18);     // Catch: JSONException -> L31
    L33:
        r1.f2517b = r12;
        r1.f2516a = r14;
        r1.c = r2;
        return r1;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    private void b(JSONObject r19) {
        int r6 = r19.optInt("act_priority", -1);
        if (r6 >= 0) goto L5;
        return;
    L5:
        JSONObject r5 = r19.optJSONObject(AutoTestConstant.PARAM);
        if (r5 != null) goto L8;
        return;
    L8:
        String r1 = r19.optString("lifecycle");
        long r7 = -1;
        if ("".equals(r1) == false) goto L11;
        r7 = 0;
    L16:
        long r9 = r7;
    L17:
        BaseDispatchAction r2 = BaseDispatchAction.a("delay", r5, r6, r7, r9, 0, "", this.f.get(), null, 0);
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L21;
        this.i.add((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin"));
        return;
    L21:
        return;
    L11:
        ArrayList r3 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.f.a(r1, r3) != true) goto L16;
        if (r3.size() != 2) goto L16;
        r7 = ((Long) ZeusTransformUtils.preCheckCast(r3.get(0), Long.class, "com.obric.memorydata.plugin")).longValue();
        r9 = ((Long) ZeusTransformUtils.preCheckCast(r3.get(1), Long.class, "com.obric.memorydata.plugin")).longValue();
        goto L17
    }

    public int a(String r9, String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2523b, "getDelayResultForUrl: " + r9);
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.k.b(r9) == false) goto L8;
        this.j.readLock().lock();
        ArrayList r0 = new ArrayList();
        r0.add(0, 0);
        Iterator<b> r2 = this.i.iterator();
    L13:
        if (r2.hasNext() == false) goto L22;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L18;
        Logger.d(f2523b, "current action priority is " + r3.a());
    L18:
        if (r3.a(r9, r10, r0) != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L13;
        if (Logger.debug() == false) goto L22;
        Logger.d(f2523b, "the url has been delayed by delay action, skip follow-up actions");
    L22:
        this.j.readLock().unlock();
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(0), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(f2523b, "illegal url");
    L10:
        return 0;
    }

    public d a(k r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2523b, "getDispatchResultForUrl: " + r4.b());
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.k.b(r4.b()) == true) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(f2523b, "illegal url");
    L10:
        return null;
    L12:
        if (this.e.get() == true) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.d(f2523b, "dispatch is unabled by tnc");
    L16:
        return null;
    L18:
        return b(r4);
    }

    public void a(Context r3) {
        this.d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public void a(String r1) {
        this.o = r1;
    }

    public void a(JSONObject r6, int r7, String r8, String r9, long r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2523b, "URLDispatcher::onServerConfigChanged, tnc source is " + r7 + "etag is " + r8);
    L5:
        this.k.set(r7);
        this.n = r8;
        this.o = r9;
        this.l.set(r10);
        int r11 = r6.optInt("ignore_retrofit_slash_enabled_v2", -1);
        int r12 = 0;
        boolean r13 = true;
        if (r11 < (-1)) goto L11;
        if (r11 != 1) goto L9;
        boolean r14 = true;
    L10:
        TTConfigManager.setIgnoreSlashEnabledV2(r14);
        goto L11
    L9:
        r14 = false;
    L11:
        JSONArray r15 = r6.optJSONArray("request_delay_actions");
        this.j.writeLock().lock();     // Catch: Throwable -> L62
        this.i.clear();     // Catch: Throwable -> L62
        if (r15 == null) goto L22;
        int r16 = 0;
    L16:
        if (r16 >= r15.length()) goto L22;
        JSONObject r2 = r15.optJSONObject(r16);     // Catch: Throwable -> L62
        if (r2 == null) goto L20;
        b(r2);     // Catch: Throwable -> L62
    L20:
        r16 = r16 + 1;     // Catch: Throwable -> L62
    L22:
        if (this.i.isEmpty() == true) goto L24;
        Collections.sort(this.i, new a());     // Catch: Throwable -> L62
    L24:
        this.j.writeLock().unlock();
        if (Logger.debug() == false) goto L27;
        Logger.d(f2523b, "parse delay actions completed, actions size is " + this.i.size());
    L27:
        int r17 = r6.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r17 < 0) goto L34;
        AtomicBoolean r18 = this.e;
        if (r17 == 1) goto L33;
        r13 = false;
    L33:
        r18.set(r13);
    L34:
        long r19 = r6.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r19 == this.f.get()) goto L37;
        this.f.set(r19);
        JSONArray r20 = r6.optJSONArray("ttnet_dispatch_actions");
        if (r20 != null) goto L67;
        return;
    L67:
        this.h.writeLock().lock();     // Catch: Throwable -> L57
        this.g.clear();     // Catch: Throwable -> L57
    L45:
        if (r12 >= r20.length()) goto L51;
        JSONObject r21 = r20.optJSONObject(r12);     // Catch: Throwable -> L57
        if (r21 == null) goto L49;
        a(r21);     // Catch: Throwable -> L57
    L49:
        r12 = r12 + 1;     // Catch: Throwable -> L57
        goto L45
    L51:
        if (this.g.isEmpty() == true) goto L53;
        Collections.sort(this.g, new a());     // Catch: Throwable -> L57
    L53:
        this.h.writeLock().unlock();
        if (Logger.debug() == false) goto L78;
        Logger.d(f2523b, "parse dispatch actions completed, actions size is " + this.g.size());
        return;
    L78:
        return;
    L57:
        th = move-exception;
        this.h.writeLock().unlock();
        if (Logger.debug() == false) goto L61;
        Logger.d(f2523b, "parse dispatch actions completed, actions size is " + this.g.size());
    L61:
        throw th;
    L37:
        if (Logger.debug() == false) goto L77;
        Logger.d(f2523b, "dispatch action epoch not changed");
        return;
    L77:
        return;
    L62:
        th = move-exception;
        this.j.writeLock().unlock();
        if (Logger.debug() == false) goto L66;
        Logger.d(f2523b, "parse delay actions completed, actions size is " + this.i.size());
    L66:
        throw th;
    }

    public String b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L50:
        return r6;
    L5:
        if (r6.contains("/network/get_network") == true) goto L50;
        if (r6.contains("/get_domains/v5") == true) goto L50;
        if (r6.contains("/ies/speed") == true) goto L50;
        String r0 = null;
        URL r1 = new URL(r6);     // Catch: Throwable -> L17
        String r2 = r1.getProtocol();     // Catch: Throwable -> L17
        r0 = r1.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L50;
        if ("http".equals(r2) == true) goto L27;
        if (LocationInfoConst.HTTPS.equals(r2) == false) goto L50;
    L27:
        if (TextUtils.isEmpty(r0) == true) goto L50;
        ConcurrentMap<String, String> r3 = this.m;
        if (r3 == null) goto L48;
        if (r3.containsKey(r0) == false) goto L48;
        String r5 = (String) ZeusTransformUtils.preCheckCast(this.m.get(r0), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L38;
        return r6;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d(f2523b, "handleHostMapping, match, origin: " + r6);
    L40:
        String r4 = r2 + "://" + r0;
        String r7 = r2 + "://" + r5;
        if (r6.startsWith(r4) == false) goto L44;
        r6 = r6.replaceFirst(r4, r7);
    L44:
        if (Logger.debug() == false) goto L46;
        Logger.d(f2523b, "handleHostMapping, target: " + r6);
    L46:
        return r6;
    L48:
        if (Logger.debug() == false) goto L50;
        Logger.d(f2523b, "handleHostMapping, nomatch: " + r0);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r2 = null;
        goto L19
    }

    public void b(Context r11) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (com.bytedance.frameworks.baselib.network.http.util.g.b(r10) == true) goto L5;
        return;
    L5:
        if (p.get() == true) goto L23;
        SharedPreferences r12 = r10.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r13 = r12.getBoolean("is_full_config", false);
        String r0 = r12.getString("tnc_config_str", null);
        String r6 = r12.getString("ttnet_tnc_etag", null);
        String r7 = r12.getString("ttnet_tnc_abtest", null);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        p.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L18;
        JSONObject r14 = new JSONObject(r0);     // Catch: JSONException -> L16
        if (r13 == false) goto L14;
        JSONObject r15 = r14.optJSONObject("data");     // Catch: JSONException -> L16
        if (r15 == null) goto L14;
        r14 = r15;
    L14:
        j r3 = a();     // Catch: JSONException -> L16
        r3.a(r14, 0, r6, r7, System.currentTimeMillis());     // Catch: JSONException -> L16
        goto L18
    }

    public boolean b() {
        return this.g.isEmpty();
    }

    public long c() {
        return this.f.get();
    }

    public int d() {
        return this.k.get();
    }

    public long e() {
        return this.l.get();
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return this.o;
    }

    public Context getContext() {
        return this.d;
    }

    public ConcurrentMap<String, String> h() {
        return this.m;
    }
}
