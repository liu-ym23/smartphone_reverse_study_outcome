package com.larus.praise.settings;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h37.f;
import java.util.concurrent.ConcurrentHashMap;
import m37.d;
import m37.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class IPraiseSdkSettings$$Impl implements IPraiseSdkSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -1457481621;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private j37.a mExposedManager;
    private final d mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private f mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a implements d {
        public final <T> T create(Class<T> r1) {
            return null;
        }

        public a() {
        }
    }

    public class b extends TypeToken<JsonObject> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.praise.settings.IPraiseSdkSettings
    public JsonObject getPraiseSdkConfig() {
        this.mExposedManager.e("praise_sdk_settings");
        if (j37.a.g("praise_sdk_settings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = praise_sdk_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("praise_sdk_settings") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("praise_sdk_settings");
    L11:
        if (this.mCachedSettings.containsKey("praise_sdk_settings") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("praise_sdk_settings");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("praise_sdk_settings", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("praise_sdk_settings", r1);
        goto L25
    L16:
        if (r2.contains("praise_sdk_settings") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("praise_sdk_settings"), new b().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public IPraiseSdkSettings$$Impl(f r2) {
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
        r0.g("nova_settings_com.larus.praise.settings.IPraiseSdkSettings", r7.getToken());
        return;
    L39:
        if (r2.has("praise_sdk_settings") == false) goto L41;
        this.mStorage.putString("praise_sdk_settings", r2.optString("praise_sdk_settings"));
        this.mCachedSettings.remove("praise_sdk_settings");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("nova_settings_com.larus.praise.settings.IPraiseSdkSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("nova_settings_com.larus.praise.settings.IPraiseSdkSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("nova_settings_com.larus.praise.settings.IPraiseSdkSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("nova_settings_com.larus.praise.settings.IPraiseSdkSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("nova_settings_com.larus.praise.settings.IPraiseSdkSettings", "") == false) goto L22;
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
        if (r0.c("nova_settings_com.larus.praise.settings.IPraiseSdkSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("nova_settings_com.larus.praise.settings.IPraiseSdkSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
