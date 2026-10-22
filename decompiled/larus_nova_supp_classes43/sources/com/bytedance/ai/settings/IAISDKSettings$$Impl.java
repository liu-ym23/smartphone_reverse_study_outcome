package com.bytedance.ai.settings;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import t5.m;
import t5.n;
import t5.p;
import t5.q;
import t5.r;
import t5.s;
import t5.t;
import t5.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class IAISDKSettings$$Impl implements IAISDKSettings {
    private static final Gson GSON = null;
    private static final int VERSION = 1014820163;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private j37.a mExposedManager;
    private final m37.d mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private h37.f mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a extends TypeToken<r> {
        public a() {
        }
    }

    public class b implements m37.d {
        public b() {
        }

        public final <T> T create(Class<T> r10) {
            if (r10 != q.class) goto L7;
            return (T) new q();
        L7:
            if (r10 != t5.f.class) goto L11;
            return (T) new t5.f();
        L11:
            if (r10 != u.class) goto L15;
            return (T) new u();
        L15:
            if (r10 != t5.h.class) goto L19;
            return (T) new t5.h();
        L19:
            if (r10 != t5.j.class) goto L23;
            return (T) new t5.j();
        L23:
            if (r10 != t5.b.class) goto L27;
            return (T) new t5.b();
        L27:
            if (r10 != n.class) goto L31;
            return (T) new n();
        L31:
            if (r10 != t5.d.class) goto L35;
            return (T) new t5.d();
        L35:
            if (r10 == s.class) goto L37;
            return null;
        L37:
            return (T) new s();
        }
    }

    public class c extends TypeToken<p> {
        public c() {
        }
    }

    public class d extends TypeToken<t5.e> {
        public d() {
        }
    }

    public class e extends TypeToken<t> {
        public e() {
        }
    }

    public class f extends TypeToken<t5.g> {
        public f() {
        }
    }

    public class g extends TypeToken<t5.i> {
        public g() {
        }
    }

    public class h extends TypeToken<t5.a> {
        public h() {
        }
    }

    public class i extends TypeToken<m> {
        public i() {
        }
    }

    public class j extends TypeToken<t5.c> {
        public j() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.a aiBridgeConfig() {
        if (j37.a.g("ai_bridge_settings") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = ai_bridge_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("ai_bridge_settings") == false) goto L11;
        return (t5.a) this.mStickySettings.get("ai_bridge_settings");
    L11:
        if (this.mCachedSettings.containsKey("ai_bridge_settings") == false) goto L17;
        t5.a r10 = (t5.a) this.mCachedSettings.get("ai_bridge_settings");
        if (r10 != null) goto L35;
        ((t5.b) m37.c.a(t5.b.class, this.mInstanceCreator)).getClass();
        r10 = new t5.a();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null ai_bridge_settings");
    L35:
        this.mStickySettings.put("ai_bridge_settings", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((t5.b) m37.c.a(t5.b.class, this.mInstanceCreator)).getClass();
        t5.a r13 = new t5.a();
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("ai_bridge_settings", r13);
        r10 = r13;
        goto L35
    L32:
        ((t5.b) m37.c.a(t5.b.class, this.mInstanceCreator)).getClass();
        r10 = new t5.a();
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = ai_bridge_settings");
        goto L35
    L20:
        if (r12.contains("ai_bridge_settings") == false) goto L29;
        String r15 = this.mStorage.getString("ai_bridge_settings");
        r13 = (t5.a) GSON.fromJson(r15, new h().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((t5.b) m37.c.a(t5.b.class, this.mInstanceCreator)).getClass();
        t5.a r16 = new t5.a();
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.c appletSettings() {
        if (j37.a.g("applet_settings") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = applet_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("applet_settings") == false) goto L11;
        return (t5.c) this.mStickySettings.get("applet_settings");
    L11:
        if (this.mCachedSettings.containsKey("applet_settings") == false) goto L17;
        t5.c r10 = (t5.c) this.mCachedSettings.get("applet_settings");
        if (r10 != null) goto L35;
        ((t5.d) m37.c.a(t5.d.class, this.mInstanceCreator)).getClass();
        r10 = new t5.c(null);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null applet_settings");
    L35:
        this.mStickySettings.put("applet_settings", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((t5.d) m37.c.a(t5.d.class, this.mInstanceCreator)).getClass();
        t5.c r13 = new t5.c(null);
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("applet_settings", r13);
        r10 = r13;
        goto L35
    L32:
        ((t5.d) m37.c.a(t5.d.class, this.mInstanceCreator)).getClass();
        r10 = new t5.c(null);
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = applet_settings");
        goto L35
    L20:
        if (r12.contains("applet_settings") == false) goto L29;
        String r15 = this.mStorage.getString("applet_settings");
        r13 = (t5.c) GSON.fromJson(r15, new j().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((t5.d) m37.c.a(t5.d.class, this.mInstanceCreator)).getClass();
        t5.c r16 = new t5.c(null);
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public r embedWebviewSettings() {
        if (j37.a.g("embed_webview_settings") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = embed_webview_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("embed_webview_settings") == false) goto L14;
        r r0 = (r) this.mCachedSettings.get("embed_webview_settings");
        if (r0 != null) goto L36;
        ((s) m37.c.a(s.class, this.mInstanceCreator)).getClass();
        r r10 = new r(0);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L37;
        r11.ensureNotReachHere("value == null embed_webview_settings");
        return r10;
    L37:
        return r10;
    L36:
        return r0;
    L14:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L17;
    L27:
        ((s) m37.c.a(s.class, this.mInstanceCreator)).getClass();
        r r13 = new r(0);
    L28:
        if (r13 == null) goto L30;
        this.mCachedSettings.put("embed_webview_settings", r13);
        return r13;
    L30:
        ((s) m37.c.a(s.class, this.mInstanceCreator)).getClass();
        r r14 = new r(0);
        IEnsure r15 = this.iEnsure;
        if (r15 == null) goto L40;
        r15.ensureNotReachHere("value == null key = embed_webview_settings");
        return r14;
    L40:
        return r14;
    L17:
        if (r12.contains("embed_webview_settings") == false) goto L27;
        String r16 = this.mStorage.getString("embed_webview_settings");
        r r17 = (r) GSON.fromJson(r16, new a().getType());     // Catch: Exception -> L21
    L26:
        r13 = r17;
    L21:
        e = move-exception;
        ((s) m37.c.a(s.class, this.mInstanceCreator)).getClass();
        r r18 = new r(0);
        IEnsure r19 = this.iEnsure;
        if (r19 == null) goto L25;
        r19.ensureNotReachHere(e, "gson from json error" + r16);
    L25:
        e.printStackTrace();
        r17 = r18;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.e frontierConfig() {
        if (j37.a.g("frontier_config") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = frontier_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("frontier_config") == false) goto L11;
        return (t5.e) this.mStickySettings.get("frontier_config");
    L11:
        if (this.mCachedSettings.containsKey("frontier_config") == false) goto L17;
        t5.e r10 = (t5.e) this.mCachedSettings.get("frontier_config");
        if (r10 != null) goto L35;
        ((t5.f) m37.c.a(t5.f.class, this.mInstanceCreator)).getClass();
        r10 = new t5.e();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null frontier_config");
    L35:
        this.mStickySettings.put("frontier_config", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((t5.f) m37.c.a(t5.f.class, this.mInstanceCreator)).getClass();
        t5.e r13 = new t5.e();
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("frontier_config", r13);
        r10 = r13;
        goto L35
    L32:
        ((t5.f) m37.c.a(t5.f.class, this.mInstanceCreator)).getClass();
        r10 = new t5.e();
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = frontier_config");
        goto L35
    L20:
        if (r12.contains("frontier_config") == false) goto L29;
        String r15 = this.mStorage.getString("frontier_config");
        r13 = (t5.e) GSON.fromJson(r15, new d().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((t5.f) m37.c.a(t5.f.class, this.mInstanceCreator)).getClass();
        t5.e r16 = new t5.e();
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.g lynxTemplateVerifyConfig() {
        if (j37.a.g("template_verify") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = template_verify time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("template_verify") == false) goto L11;
        return (t5.g) this.mStickySettings.get("template_verify");
    L11:
        if (this.mCachedSettings.containsKey("template_verify") == false) goto L17;
        t5.g r10 = (t5.g) this.mCachedSettings.get("template_verify");
        if (r10 != null) goto L35;
        ((t5.h) m37.c.a(t5.h.class, this.mInstanceCreator)).getClass();
        r10 = new t5.g(null);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null template_verify");
    L35:
        this.mStickySettings.put("template_verify", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((t5.h) m37.c.a(t5.h.class, this.mInstanceCreator)).getClass();
        t5.g r13 = new t5.g(null);
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("template_verify", r13);
        r10 = r13;
        goto L35
    L32:
        ((t5.h) m37.c.a(t5.h.class, this.mInstanceCreator)).getClass();
        r10 = new t5.g(null);
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = template_verify");
        goto L35
    L20:
        if (r12.contains("template_verify") == false) goto L29;
        String r15 = this.mStorage.getString("template_verify");
        r13 = (t5.g) GSON.fromJson(r15, new f().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((t5.h) m37.c.a(t5.h.class, this.mInstanceCreator)).getClass();
        t5.g r16 = new t5.g(null);
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t5.i lynxViewReusedConfig() {
        if (j37.a.g("lynx_view_reused") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = lynx_view_reused time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("lynx_view_reused") == false) goto L11;
        return (t5.i) this.mStickySettings.get("lynx_view_reused");
    L11:
        if (this.mCachedSettings.containsKey("lynx_view_reused") == false) goto L17;
        t5.i r10 = (t5.i) this.mCachedSettings.get("lynx_view_reused");
        if (r10 != null) goto L35;
        ((t5.j) m37.c.a(t5.j.class, this.mInstanceCreator)).getClass();
        r10 = new t5.i(null);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null lynx_view_reused");
    L35:
        this.mStickySettings.put("lynx_view_reused", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((t5.j) m37.c.a(t5.j.class, this.mInstanceCreator)).getClass();
        t5.i r13 = new t5.i(null);
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("lynx_view_reused", r13);
        r10 = r13;
        goto L35
    L32:
        ((t5.j) m37.c.a(t5.j.class, this.mInstanceCreator)).getClass();
        r10 = new t5.i(null);
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = lynx_view_reused");
        goto L35
    L20:
        if (r12.contains("lynx_view_reused") == false) goto L29;
        String r15 = this.mStorage.getString("lynx_view_reused");
        r13 = (t5.i) GSON.fromJson(r15, new g().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((t5.j) m37.c.a(t5.j.class, this.mInstanceCreator)).getClass();
        t5.i r16 = new t5.i(null);
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public m optimizeSettings() {
        if (j37.a.g("optimize_settings") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = optimize_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("optimize_settings") == false) goto L11;
        return (m) this.mStickySettings.get("optimize_settings");
    L11:
        if (this.mCachedSettings.containsKey("optimize_settings") == false) goto L17;
        m r10 = (m) this.mCachedSettings.get("optimize_settings");
        if (r10 != null) goto L35;
        ((n) m37.c.a(n.class, this.mInstanceCreator)).getClass();
        r10 = new m(null);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null optimize_settings");
    L35:
        this.mStickySettings.put("optimize_settings", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((n) m37.c.a(n.class, this.mInstanceCreator)).getClass();
        m r13 = new m(null);
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("optimize_settings", r13);
        r10 = r13;
        goto L35
    L32:
        ((n) m37.c.a(n.class, this.mInstanceCreator)).getClass();
        r10 = new m(null);
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = optimize_settings");
        goto L35
    L20:
        if (r12.contains("optimize_settings") == false) goto L29;
        String r15 = this.mStorage.getString("optimize_settings");
        r13 = (m) GSON.fromJson(r15, new i().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((n) m37.c.a(n.class, this.mInstanceCreator)).getClass();
        m r16 = new m(null);
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public p resourcesManagerConfig() {
        if (j37.a.g("resources_manager_settings") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = resources_manager_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("resources_manager_settings") == false) goto L11;
        return (p) this.mStickySettings.get("resources_manager_settings");
    L11:
        if (this.mCachedSettings.containsKey("resources_manager_settings") == false) goto L17;
        p r10 = (p) this.mCachedSettings.get("resources_manager_settings");
        if (r10 != null) goto L35;
        ((q) m37.c.a(q.class, this.mInstanceCreator)).getClass();
        r10 = new p();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null resources_manager_settings");
    L35:
        this.mStickySettings.put("resources_manager_settings", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((q) m37.c.a(q.class, this.mInstanceCreator)).getClass();
        p r13 = new p();
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("resources_manager_settings", r13);
        r10 = r13;
        goto L35
    L32:
        ((q) m37.c.a(q.class, this.mInstanceCreator)).getClass();
        r10 = new p();
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = resources_manager_settings");
        goto L35
    L20:
        if (r12.contains("resources_manager_settings") == false) goto L29;
        String r15 = this.mStorage.getString("resources_manager_settings");
        r13 = (p) GSON.fromJson(r15, new c().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((q) m37.c.a(q.class, this.mInstanceCreator)).getClass();
        p r16 = new p();
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public t widgetSettingsConfig() {
        if (j37.a.g("widget_settings") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = widget_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("widget_settings") == false) goto L11;
        return (t) this.mStickySettings.get("widget_settings");
    L11:
        if (this.mCachedSettings.containsKey("widget_settings") == false) goto L17;
        t r10 = (t) this.mCachedSettings.get("widget_settings");
        if (r10 != null) goto L35;
        ((u) m37.c.a(u.class, this.mInstanceCreator)).getClass();
        r10 = u.a();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L35;
        r11.ensureNotReachHere("value == null widget_settings");
    L35:
        this.mStickySettings.put("widget_settings", r10);
        return r10;
    L17:
        h37.f r12 = this.mStorage;
        if (r12 != null) goto L20;
    L29:
        ((u) m37.c.a(u.class, this.mInstanceCreator)).getClass();
        t r13 = u.a();
    L30:
        if (r13 == null) goto L32;
        this.mCachedSettings.put("widget_settings", r13);
        r10 = r13;
        goto L35
    L32:
        ((u) m37.c.a(u.class, this.mInstanceCreator)).getClass();
        r10 = u.a();
        IEnsure r14 = this.iEnsure;
        if (r14 == null) goto L35;
        r14.ensureNotReachHere("value == null key = widget_settings");
        goto L35
    L20:
        if (r12.contains("widget_settings") == false) goto L29;
        String r15 = this.mStorage.getString("widget_settings");
        r13 = (t) GSON.fromJson(r15, new e().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((u) m37.c.a(u.class, this.mInstanceCreator)).getClass();
        t r16 = u.a();
        IEnsure r17 = this.iEnsure;
        if (r17 == null) goto L28;
        r17.ensureNotReachHere(e, "gson from json error" + r15);
    L28:
        e.printStackTrace();
        r13 = r16;
        goto L30
    }

    public IAISDKSettings$$Impl(h37.f r10) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new b();
        this.mStorage = r10;
        this.mExposedManager = j37.a.b(m37.a.getContext());
        this.iEnsure = IEnsureWrapper.getInstance();
    }

    public void updateSettings(SettingsData r10) {
        m37.h r0 = m37.h.a(m37.a.getContext());
        if (r10 == null) goto L5;
    L33:
        if (r10 != null) goto L35;
        return;
    L35:
        if (this.mStorage == null) goto L73;
        JSONObject r11 = r10.getAppSettings();
        if (r11 != null) goto L39;
    L65:
        this.mStorage.apply();
        r0.g("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", r10.getToken());
        return;
    L39:
        if (r11.has("resources_manager_settings") == false) goto L42;
        this.mStorage.putString("resources_manager_settings", r11.optString("resources_manager_settings"));
        this.mCachedSettings.remove("resources_manager_settings");
    L42:
        if (r11.has("frontier_config") == false) goto L45;
        this.mStorage.putString("frontier_config", r11.optString("frontier_config"));
        this.mCachedSettings.remove("frontier_config");
    L45:
        if (r11.has("widget_settings") == false) goto L48;
        this.mStorage.putString("widget_settings", r11.optString("widget_settings"));
        this.mCachedSettings.remove("widget_settings");
    L48:
        if (r11.has("template_verify") == false) goto L51;
        this.mStorage.putString("template_verify", r11.optString("template_verify"));
        this.mCachedSettings.remove("template_verify");
    L51:
        if (r11.has("lynx_view_reused") == false) goto L54;
        this.mStorage.putString("lynx_view_reused", r11.optString("lynx_view_reused"));
        this.mCachedSettings.remove("lynx_view_reused");
    L54:
        if (r11.has("ai_bridge_settings") == false) goto L57;
        this.mStorage.putString("ai_bridge_settings", r11.optString("ai_bridge_settings"));
        this.mCachedSettings.remove("ai_bridge_settings");
    L57:
        if (r11.has("optimize_settings") == false) goto L60;
        this.mStorage.putString("optimize_settings", r11.optString("optimize_settings"));
        this.mCachedSettings.remove("optimize_settings");
    L60:
        if (r11.has("applet_settings") == false) goto L63;
        this.mStorage.putString("applet_settings", r11.optString("applet_settings"));
        this.mCachedSettings.remove("applet_settings");
    L63:
        if (r11.has("embed_webview_settings") == false) goto L65;
        this.mStorage.putString("embed_webview_settings", r11.optString("embed_webview_settings"));
        this.mCachedSettings.remove("embed_webview_settings");
        goto L65
    L73:
        return;
    L5:
        if (VERSION == r0.b("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings")) goto L20;
        r10 = m37.f.b(m37.a.getContext()).d("flow_ai_sdk");
    L13:
        th = move-exception;
        if (r10 == null) goto L16;
        r0.f("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", VERSION);
    L16:
        IEnsure r12 = this.iEnsure;
        if (r12 == null) goto L33;
        r12.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r10 == null) goto L69;
        r0.f("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", VERSION);     // Catch: Throwable -> L13
    L69:
        goto L33
    L11:
        r0.f("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", VERSION);     // Catch: Throwable -> L13
        goto L69
    L20:
        if (r0.d("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", "flow_ai_sdk") == false) goto L22;
        r10 = m37.f.b(m37.a.getContext()).d("flow_ai_sdk");
        goto L33
    L22:
        if (r10 != null) goto L33;
    L29:
        th = move-exception;
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L33;
        r13.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L24:
        if (j37.a.i == false) goto L33;
        if (r0.c("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings") == true) goto L33;
        r10 = m37.f.b(m37.a.getContext()).d("flow_ai_sdk");     // Catch: Throwable -> L29
        r0.e("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
