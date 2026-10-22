package com.bytedance.applog.k;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.c.e;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.k;
import com.bytedance.applog.util.m;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.AppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f1622b;
    private volatile boolean c;
    private volatile boolean d;
    private final b e;
    private volatile JSONObject f;
    private final SharedPreferences g;
    private final com.bytedance.applog.b h;

    static {
        f1621a = Collections.singletonList("DeviceManager");
    }

    public c(com.bytedance.applog.b r3, b r4, e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        this.d = false;
        this.h = r3;
        this.e = r4;
        this.f1622b = r6;
        this.g = r4.f();
        this.f = new JSONObject();
    }

    private Object a(JSONObject r7, String r8) {
        if ("custom".equals(r8) == false) goto L22;
        if (this.h.aR() == false) goto L22;
        JSONObject r0 = r7.optJSONObject(r8);
        if (r0 == null) goto L9;
        ArrayList r9 = new ArrayList();
        Iterator<String> r10 = r0.keys();
    L12:
        if (r10.hasNext() == false) goto L16;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (this.e.a(r1) == true) goto L12;
        r9.add(r1);
        goto L12
    L16:
        Iterator r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        r0.remove(r12);
        this.h.aA().a(f1621a, "custom header:{} removed by header control ", new Object[]{r12});
        this.h.ab().a(StatsCountKeys.REMOVE_CUSTOM_HEADER_COUNT);
        goto L18
    L20:
        return r0;
    L9:
        return r7.opt(r8);
    L22:
        return r7.opt(r8);
    }

    private String a(Set<String> r4) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder();
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        r5.append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        if (r6.hasNext() == false) goto L4;
        r5.append(",");
        goto L4
    L9:
        return r5.toString();
    }

    static /* synthetic */ JSONObject a(c r0) {
        return r0.f;
    }

    private boolean a(String r9, Object r10) {
        if (this.h.aP().contains(r9) == false) goto L6;
        this.h.aA().c(f1621a, "update header failed for header: {} is blocked!", new Object[]{r9});
        return false;
    L6:
        Object r0 = this.f.opt(r9);
        if (r10 != null) goto L9;
    L10:
        if (r10 != null) goto L27;
        if (r0 == null) goto L27;
    L12:
        monitor-enter(this);
        JSONObject r3 = this.f;     // Catch: Throwable -> L19 JSONException -> L21
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L19 JSONException -> L21
        o.b(r4, r3);     // Catch: Throwable -> L19 JSONException -> L21
        r4.put(r9, r10);     // Catch: Throwable -> L19 JSONException -> L21
        this.f = r4;     // Catch: Throwable -> L19 JSONException -> L21
        if ("device_id".equals(r9) == false) goto L16;
    L17:
        j();     // Catch: Throwable -> L19 JSONException -> L21
    L23:
        monitor-exit(this);     // Catch: Throwable -> L19
        boolean r5 = true;
    L28:
        this.h.aA().b(f1621a, "updateHeader -> key:{}, old:{}, new:{}", new Object[]{r9, r0, r10});
        return r5;
    L16:
        if ("install_id".equals(r9) == false) goto L23;
    L19:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        this.h.aA().a(f1621a, "update header failed", e, new Object[0]);     // Catch: Throwable -> L19
    L27:
        r5 = false;
        goto L28
    L9:
        if (r10.equals(r0) == false) goto L12;
        goto L10
    }

    static /* synthetic */ com.bytedance.applog.b b(c r0) {
        return r0.h;
    }

    private Set<String> c(String r5) {
        HashSet r4 = new HashSet();
        if (TextUtils.isEmpty(r5) == true) goto L14;
        String[] r6 = r5.split(",");
        if (r6 == null) goto L14;
        if (r6.length <= 0) goto L14;
        int r0 = r6.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L14;
        String r2 = r6[r1];
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r4.add(r2);
    L13:
        r1 = r1 + 1;
    L14:
        return r4;
    }

    private void c(JSONObject r8) {
        boolean r1 = k.a();
        if (r1 == false) goto L6;
        String r4 = "Harmony";
    L18:
        r8.put(WsConstants.KEY_PLATFORM, r4);     // Catch: JSONException -> L9
    L11:
        if (r1 == true) goto L20;
        return;
    L20:
        r8.put("harmony_os_api", SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r8.put("harmony_os_version", SystemPropertiesWithCache.get("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r8.put("harmony_release_type", SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        this.h.aA().b(f1621a, "loadHarmonyInfo failed", new Object[]{th});
        return;
    L9:
        e = move-exception;
        this.h.aA().a(f1621a, "loadHarmonyInfo failed", e, new Object[0]);
        goto L11
    L6:
        r4 = LocationInfoConst.SYSTEM;
        goto L18
    }

    private void d(String r2) {
        if (a("ab_sdk_version", r2) == false) goto L6;
        this.e.c(r2);
        return;
    }

    private void j() {
        this.d = a(this.f);
    }

    public <T> T a(String r2, T r3, Class<T> r4) {
        return (T) this.h.av().a(this.f, r2, r3, r4);
    }

    public JSONObject a() {
        return o.a(this.f);
    }

    public synchronized void a(String r4) {
        monitor-enter(this);
        Set<String> r0 = c(this.e.r());     // Catch: Throwable -> L6
        Set<String> r1 = c(this.f.optString("ab_sdk_version"));     // Catch: Throwable -> L6
        r1.removeAll(r0);     // Catch: Throwable -> L6
        r1.addAll(c(r4));     // Catch: Throwable -> L6
        this.e.e(r4);     // Catch: Throwable -> L6
        d(a(r1));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean a(JSONObject r4) {
        if (r4 == null) goto L10;
        String r0 = r4.optString("device_id", "");
        String r5 = r4.optString("install_id", "");
        if (o.c(r0) == true) goto L7;
        return false;
    L7:
        if (o.c(r5) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public long b() {
        InstallOptions r2 = this.f1622b.j();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.getVersionCode();
    }

    public void b(String r1) {
        this.e.d(r1);
    }

    public void b(JSONObject r11) {
        this.h.aA().b(f1621a, "updateHeader: {}", new Object[]{r11});
        JSONObject r0 = new JSONObject();
        String r1 = this.h.i();
        monitor-enter(this);
        o.b(r0, this.f);     // Catch: Throwable -> L32
        Iterator<String> r2 = r11.keys();     // Catch: Throwable -> L32
    L6:
        if (r2.hasNext() == false) goto L35;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r0.put(r4, a(r11, r4));     // Catch: JSONException -> L12 Throwable -> L32
    L12:
        e = move-exception;
        this.h.aA().e("updateHeader put header key:{} value failed", new Object[]{r4, e});     // Catch: Throwable -> L32
        goto L6
    L35:
        r0.put("sdk_version", 5071590);     // Catch: Throwable -> L20
        r0.put(Api.KEY_SDK_VERSION_CODE, m.c);     // Catch: Throwable -> L20
        r0.put(AppInfo.KEY_NPTH_VERSION_NAME, "5.7.15");     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r1) == true) goto L18;
        r0.put("ab_sdk_version", r1);     // Catch: Throwable -> L20
    L18:
        c(r0);     // Catch: Throwable -> L20
    L22:
        Iterator<String> r12 = this.h.aP().iterator();     // Catch: Throwable -> L32
    L24:
        if (r12.hasNext() == false) goto L26;
        r0.remove((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
        goto L24
    L26:
        this.f = r0;     // Catch: Throwable -> L32
        this.c = true;     // Catch: Throwable -> L32
        j();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        SharedPreferences.Editor r13 = this.g.edit();
        r13.putLong("version_code", this.f.optLong("version_code", 0));
        r13.putString("channel", this.f.optString("channel", ""));
        r13.apply();
        if (p.a() == true) goto L46;
        p.a("set_header", new AnonymousClass1(this));
        return;
    L46:
        return;
    L20:
        th = move-exception;
        this.h.aA().a("updateHeader put header sdk version or load harmony info failed", th, new Object[0]);     // Catch: Throwable -> L32
        this.h.ab().a(StatsCountKeys.JSON_ERROR_COUNT);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public String c() {
        InstallOptions r0 = this.f1622b.j();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getVersion();
    }

    public String d() {
        if (this.c == true) goto L9;
        b r2 = this.e;
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.p();
    L9:
        return this.f.optString(Api.KEY_USER_UNIQUE_ID, "");
    }

    public boolean e() {
        return this.d;
    }

    public String f() {
        return this.e.o();
    }

    public long g() {
        return this.g.getLong("version_code", 0);
    L5:
        long r1 = this.g.getInt("version_code", 0);
        this.g.edit().putLong("version_code", r1).apply();
        return r1;
    }

    public void h() {
        b(this.f);
    }

    public boolean i() {
        if (this.c == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == false) goto L7;
        return true;
    }
}
