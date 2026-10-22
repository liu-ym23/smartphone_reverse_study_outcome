package com.obric.miniapp.settings;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IMiniAppSettings$$Impl implements IMiniAppSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -60591096;
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
            if (r2 == ela.b.class) goto L5;
            return null;
        L5:
            return (T) new ela.b();
        }
    }

    public class b extends TypeToken<ela.a> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.obric.miniapp.settings.IMiniAppSettings
    public ela.a miniAppConfig() {
        if (j37.a.g("mini_app_config") == false) goto L8;
        IEnsure r1 = this.iEnsure;
        if (r1 == null) goto L8;
        r1.ensureNotReachHere("get settings key = mini_app_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("mini_app_config") == false) goto L14;
        ela.a r0 = (ela.a) this.mCachedSettings.get("mini_app_config");
        if (r0 != null) goto L36;
        ((ela.b) c.a(ela.b.class, this.mInstanceCreator)).getClass();
        ela.a r2 = new ela.a(null);
        IEnsure r3 = this.iEnsure;
        if (r3 == null) goto L37;
        r3.ensureNotReachHere("value == null mini_app_config");
        return r2;
    L37:
        return r2;
    L36:
        return r0;
    L14:
        f r4 = this.mStorage;
        if (r4 != null) goto L17;
    L27:
        ((ela.b) c.a(ela.b.class, this.mInstanceCreator)).getClass();
        ela.a r5 = new ela.a(null);
    L28:
        if (r5 == null) goto L30;
        this.mCachedSettings.put("mini_app_config", r5);
        return r5;
    L30:
        ((ela.b) c.a(ela.b.class, this.mInstanceCreator)).getClass();
        ela.a r6 = new ela.a(null);
        IEnsure r7 = this.iEnsure;
        if (r7 == null) goto L40;
        r7.ensureNotReachHere("value == null key = mini_app_config");
        return r6;
    L40:
        return r6;
    L17:
        if (r4.contains("mini_app_config") == false) goto L27;
        String r8 = this.mStorage.getString("mini_app_config");
        ela.a r9 = (ela.a) GSON.fromJson(r8, new b().getType());     // Catch: Exception -> L21
    L26:
        r5 = r9;
    L21:
        e = move-exception;
        ((ela.b) c.a(ela.b.class, this.mInstanceCreator)).getClass();
        ela.a r10 = new ela.a(null);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L25;
        r11.ensureNotReachHere(e, "gson from json error" + r8);
    L25:
        e.printStackTrace();
        r9 = r10;
        goto L26
    }

    public IMiniAppSettings$$Impl(f r2) {
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
        r0.g("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings", r7.getToken());
        return;
    L39:
        if (r2.has("mini_app_config") == false) goto L41;
        this.mStorage.putString("mini_app_config", r2.optString("mini_app_config"));
        this.mCachedSettings.remove("mini_app_config");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("obric-mini-app");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings", "obric-mini-app") == false) goto L22;
        r7 = m37.f.b(m37.a.getContext()).d("obric-mini-app");
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
        if (r0.c("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("obric-mini-app");     // Catch: Throwable -> L29
        r0.e("obric_mini_app_settings_com.obric.miniapp.settings.IMiniAppSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
