package com.larus.settings.ivy.lottieAdapter;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h37.f;
import java.util.concurrent.ConcurrentHashMap;
import m37.c;
import m37.d;
import m37.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class ILottieAdapterSettings$$Impl implements ILottieAdapterSettings {
    private static final Gson GSON = null;
    private static final int VERSION = 24748754;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private j37.a mExposedManager;
    private final d mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private f mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a implements d {
        public a() {
        }

        public final <T> T create(Class<T> r2) {
            if (r2 == com.larus.settings.ivy.lottieAdapter.b.class) goto L5;
            return null;
        L5:
            return (T) new com.larus.settings.ivy.lottieAdapter.b();
        }
    }

    public class b extends TypeToken<com.larus.settings.ivy.lottieAdapter.a> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings
    public com.larus.settings.ivy.lottieAdapter.a lottieAdapterConfig() {
        this.mExposedManager.e("lottie_adapter_config");
        if (j37.a.g("lottie_adapter_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = lottie_adapter_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("lottie_adapter_config") == false) goto L14;
        com.larus.settings.ivy.lottieAdapter.a r1 = (com.larus.settings.ivy.lottieAdapter.a) this.mCachedSettings.get("lottie_adapter_config");
        if (r1 != null) goto L33;
        ((com.larus.settings.ivy.lottieAdapter.b) c.a(com.larus.settings.ivy.lottieAdapter.b.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.lottieAdapter.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null lottie_adapter_config");
    L33:
        return r1;
    L14:
        f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((com.larus.settings.ivy.lottieAdapter.b) c.a(com.larus.settings.ivy.lottieAdapter.b.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.lottieAdapter.a();
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("lottie_adapter_config", r1);
        goto L33
    L30:
        ((com.larus.settings.ivy.lottieAdapter.b) c.a(com.larus.settings.ivy.lottieAdapter.b.class, this.mInstanceCreator)).getClass();
        r1 = new com.larus.settings.ivy.lottieAdapter.a();
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = lottie_adapter_config");
        goto L33
    L17:
        if (r3.contains("lottie_adapter_config") == false) goto L27;
        String r5 = this.mStorage.getString("lottie_adapter_config");
        com.larus.settings.ivy.lottieAdapter.a r6 = (com.larus.settings.ivy.lottieAdapter.a) GSON.fromJson(r5, new b().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((com.larus.settings.ivy.lottieAdapter.b) c.a(com.larus.settings.ivy.lottieAdapter.b.class, this.mInstanceCreator)).getClass();
        com.larus.settings.ivy.lottieAdapter.a r7 = new com.larus.settings.ivy.lottieAdapter.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    public ILottieAdapterSettings$$Impl(f r2) {
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
        if (this.mStorage == null) goto L49;
        JSONObject r2 = r7.getAppSettings();
        if (r2 != null) goto L39;
    L41:
        this.mStorage.apply();
        r0.g("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings", r7.getToken());
        return;
    L39:
        if (r2.has("lottie_adapter_config") == false) goto L41;
        this.mStorage.putString("lottie_adapter_config", r2.optString("lottie_adapter_config"));
        this.mCachedSettings.remove("lottie_adapter_config");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings", "") == false) goto L22;
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
        if (r0.c("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("lottie_adapter_config_com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
