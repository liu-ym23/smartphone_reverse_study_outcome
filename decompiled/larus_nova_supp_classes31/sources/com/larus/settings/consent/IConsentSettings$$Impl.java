package com.larus.settings.consent;

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
public class IConsentSettings$$Impl implements IConsentSettings {
    private static final Gson GSON = null;
    private static final int VERSION = 1606461742;
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
            if (r2 == com.larus.settings.consent.b.class) goto L5;
            return null;
        L5:
            return (T) new com.larus.settings.consent.b();
        }
    }

    public class b extends TypeToken<com.larus.settings.consent.a> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.settings.consent.IConsentSettings
    public com.larus.settings.consent.a getMdaRegions() {
        this.mExposedManager.e("dma_consent_config");
        if (j37.a.g("dma_consent_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = dma_consent_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("dma_consent_config") == false) goto L14;
        com.larus.settings.consent.a r1 = (com.larus.settings.consent.a) this.mCachedSettings.get("dma_consent_config");
        if (r1 != null) goto L33;
        ((com.larus.settings.consent.b) c.a(com.larus.settings.consent.b.class, this.mInstanceCreator)).getClass();
        r1 = com.larus.settings.consent.b.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null dma_consent_config");
    L33:
        return r1;
    L14:
        f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((com.larus.settings.consent.b) c.a(com.larus.settings.consent.b.class, this.mInstanceCreator)).getClass();
        r1 = com.larus.settings.consent.b.a();
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("dma_consent_config", r1);
        goto L33
    L30:
        ((com.larus.settings.consent.b) c.a(com.larus.settings.consent.b.class, this.mInstanceCreator)).getClass();
        r1 = com.larus.settings.consent.b.a();
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = dma_consent_config");
        goto L33
    L17:
        if (r3.contains("dma_consent_config") == false) goto L27;
        String r5 = this.mStorage.getString("dma_consent_config");
        com.larus.settings.consent.a r6 = (com.larus.settings.consent.a) GSON.fromJson(r5, new b().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((com.larus.settings.consent.b) c.a(com.larus.settings.consent.b.class, this.mInstanceCreator)).getClass();
        com.larus.settings.consent.a r7 = com.larus.settings.consent.b.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    public IConsentSettings$$Impl(f r2) {
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
        r0.g("consent_settings_com.larus.settings.consent.IConsentSettings", r7.getToken());
        return;
    L39:
        if (r2.has("dma_consent_config") == false) goto L41;
        this.mStorage.putString("dma_consent_config", r2.optString("dma_consent_config"));
        this.mCachedSettings.remove("dma_consent_config");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("consent_settings_com.larus.settings.consent.IConsentSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("consent_settings_com.larus.settings.consent.IConsentSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("consent_settings_com.larus.settings.consent.IConsentSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("consent_settings_com.larus.settings.consent.IConsentSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("consent_settings_com.larus.settings.consent.IConsentSettings", "") == false) goto L22;
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
        if (r0.c("consent_settings_com.larus.settings.consent.IConsentSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("consent_settings_com.larus.settings.consent.IConsentSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
