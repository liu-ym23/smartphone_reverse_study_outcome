package com.larus.settings.tutor;

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
public class ITutorSettings$$Impl implements ITutorSettings {
    private static final Gson GSON = null;
    private static final int VERSION = 1942190101;
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
            if (r2 == com.larus.settings.tutor.a.class) goto L5;
            return null;
        L5:
            return (T) new com.larus.settings.tutor.a();
        }
    }

    public class b extends TypeToken<LiveTutorConfig> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.settings.tutor.ITutorSettings
    public LiveTutorConfig getLiveTutorConfig() {
        this.mExposedManager.e("tutor_live_tutor_config");
        if (j37.a.g("tutor_live_tutor_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = tutor_live_tutor_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("tutor_live_tutor_config") == false) goto L14;
        LiveTutorConfig r1 = (LiveTutorConfig) this.mCachedSettings.get("tutor_live_tutor_config");
        if (r1 != null) goto L33;
        ((com.larus.settings.tutor.a) m37.c.a(com.larus.settings.tutor.a.class, this.mInstanceCreator)).getClass();
        r1 = com.larus.settings.tutor.a.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null tutor_live_tutor_config");
    L33:
        return r1;
    L14:
        f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((com.larus.settings.tutor.a) m37.c.a(com.larus.settings.tutor.a.class, this.mInstanceCreator)).getClass();
        r1 = com.larus.settings.tutor.a.a();
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("tutor_live_tutor_config", r1);
        goto L33
    L30:
        ((com.larus.settings.tutor.a) m37.c.a(com.larus.settings.tutor.a.class, this.mInstanceCreator)).getClass();
        r1 = com.larus.settings.tutor.a.a();
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = tutor_live_tutor_config");
        goto L33
    L17:
        if (r3.contains("tutor_live_tutor_config") == false) goto L27;
        String r5 = this.mStorage.getString("tutor_live_tutor_config");
        LiveTutorConfig r6 = (LiveTutorConfig) GSON.fromJson(r5, new b().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((com.larus.settings.tutor.a) m37.c.a(com.larus.settings.tutor.a.class, this.mInstanceCreator)).getClass();
        LiveTutorConfig r7 = com.larus.settings.tutor.a.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    public ITutorSettings$$Impl(f r2) {
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
        r0.g("tutor_settings_com.larus.settings.tutor.ITutorSettings", r7.getToken());
        return;
    L39:
        if (r2.has("tutor_live_tutor_config") == false) goto L41;
        this.mStorage.putString("tutor_live_tutor_config", r2.optString("tutor_live_tutor_config"));
        this.mCachedSettings.remove("tutor_live_tutor_config");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("tutor_settings_com.larus.settings.tutor.ITutorSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("tutor_settings_com.larus.settings.tutor.ITutorSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("tutor_settings_com.larus.settings.tutor.ITutorSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("tutor_settings_com.larus.settings.tutor.ITutorSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("tutor_settings_com.larus.settings.tutor.ITutorSettings", "") == false) goto L22;
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
        if (r0.c("tutor_settings_com.larus.settings.tutor.ITutorSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("tutor_settings_com.larus.settings.tutor.ITutorSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
