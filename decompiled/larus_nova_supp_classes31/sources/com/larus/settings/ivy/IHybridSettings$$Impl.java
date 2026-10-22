package com.larus.settings.ivy;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h37.f;
import java.util.concurrent.ConcurrentHashMap;
import m37.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class IHybridSettings$$Impl implements IHybridSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -308841894;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private j37.a mExposedManager;
    private final m37.d mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private f mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a implements m37.d {
        public a() {
        }

        public final <T> T create(Class<T> r2) {
            if (r2 != com.larus.settings.ivy.b.class) goto L7;
            return (T) new com.larus.settings.ivy.b();
        L7:
            if (r2 == d.class) goto L9;
            return null;
        L9:
            return (T) new d();
        }
    }

    public class b extends TypeToken<com.larus.settings.ivy.a> {
        public b() {
        }
    }

    public class c extends TypeToken<com.larus.settings.ivy.c> {
        public c() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.settings.ivy.IHybridSettings
    public com.larus.settings.ivy.a hybridCommonConfig() {
        this.mExposedManager.e("hybrid_config");
        if (j37.a.g("hybrid_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = hybrid_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("hybrid_config") == false) goto L14;
        com.larus.settings.ivy.a r1 = (com.larus.settings.ivy.a) this.mCachedSettings.get("hybrid_config");
        if (r1 != null) goto L33;
        ((com.larus.settings.ivy.b) m37.c.a(com.larus.settings.ivy.b.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null hybrid_config");
    L33:
        return r1;
    L14:
        f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((com.larus.settings.ivy.b) m37.c.a(com.larus.settings.ivy.b.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.a();
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("hybrid_config", r1);
        goto L33
    L30:
        ((com.larus.settings.ivy.b) m37.c.a(com.larus.settings.ivy.b.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.a();
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = hybrid_config");
        goto L33
    L17:
        if (r3.contains("hybrid_config") == false) goto L27;
        String r5 = this.mStorage.getString("hybrid_config");
        com.larus.settings.ivy.a r6 = (com.larus.settings.ivy.a) GSON.fromJson(r5, new b().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((com.larus.settings.ivy.b) m37.c.a(com.larus.settings.ivy.b.class, this.mInstanceCreator)).getClass();
        com.larus.settings.ivy.a r7 = new com.larus.settings.ivy.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    @Override // com.larus.settings.ivy.IHybridSettings
    public com.larus.settings.ivy.c hybridExperimentConfig() {
        this.mExposedManager.e("hybrid_experiment_config");
        if (j37.a.g("hybrid_experiment_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = hybrid_experiment_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("hybrid_experiment_config") == false) goto L14;
        com.larus.settings.ivy.c r1 = (com.larus.settings.ivy.c) this.mCachedSettings.get("hybrid_experiment_config");
        if (r1 != null) goto L33;
        ((d) m37.c.a(d.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.c();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null hybrid_experiment_config");
    L33:
        return r1;
    L14:
        f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((d) m37.c.a(d.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.c();
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("hybrid_experiment_config", r1);
        goto L33
    L30:
        ((d) m37.c.a(d.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.c();
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = hybrid_experiment_config");
        goto L33
    L17:
        if (r3.contains("hybrid_experiment_config") == false) goto L27;
        String r5 = this.mStorage.getString("hybrid_experiment_config");
        com.larus.settings.ivy.c r6 = (com.larus.settings.ivy.c) GSON.fromJson(r5, new c().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((d) m37.c.a(d.class, this.mInstanceCreator)).getClass();
        com.larus.settings.ivy.c r7 = new com.larus.settings.ivy.c();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    public IHybridSettings$$Impl(f r2) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new a();
        this.mStorage = r2;
        this.mExposedManager = j37.a.b(m37.a.getContext());
        this.iEnsure = IEnsureWrapper.getInstance();
    }

    public void updateSettings(SettingsData r7) {
        h r0 = h.a(m37.a.getContext());
        if (r7 == null) goto L5;
    L33:
        if (r7 != null) goto L35;
        return;
    L35:
        if (this.mStorage == null) goto L52;
        JSONObject r2 = r7.getAppSettings();
        if (r2 != null) goto L39;
    L44:
        this.mStorage.apply();
        r0.g("nova_settings_com.larus.settings.ivy.IHybridSettings", r7.getToken());
        return;
    L39:
        if (r2.has("hybrid_config") == false) goto L42;
        this.mStorage.putString("hybrid_config", r2.optString("hybrid_config"));
        this.mCachedSettings.remove("hybrid_config");
    L42:
        if (r2.has("hybrid_experiment_config") == false) goto L44;
        this.mStorage.putString("hybrid_experiment_config", r2.optString("hybrid_experiment_config"));
        this.mCachedSettings.remove("hybrid_experiment_config");
        goto L44
    L52:
        return;
    L5:
        if (VERSION == r0.b("nova_settings_com.larus.settings.ivy.IHybridSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("nova_settings_com.larus.settings.ivy.IHybridSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L48;
        r0.f("nova_settings_com.larus.settings.ivy.IHybridSettings", VERSION);     // Catch: Throwable -> L13
    L48:
        goto L33
    L11:
        r0.f("nova_settings_com.larus.settings.ivy.IHybridSettings", VERSION);     // Catch: Throwable -> L13
        goto L48
    L20:
        if (r0.d("nova_settings_com.larus.settings.ivy.IHybridSettings", "") == false) goto L22;
        r7 = m37.f.b(m37.a.getContext()).d("");
        goto L33
    L22:
        if (r7 != null) goto L33;
    L29:
        th = move-exception;
        IEnsure r5 = this.iEnsure;
        if (r5 == null) goto L33;
        r5.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L24:
        if (j37.a.i == false) goto L33;
        if (r0.c("nova_settings_com.larus.settings.ivy.IHybridSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("nova_settings_com.larus.settings.ivy.IHybridSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
