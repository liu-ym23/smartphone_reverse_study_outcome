package com.larus.settings.performance;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import m37.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class IPerfSettings$$Impl implements IPerfSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -769644862;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private j37.a mExposedManager;
    private final m37.d mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private h37.f mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a implements m37.d {
        public a() {
        }

        public final <T> T create(Class<T> r2) {
            if (r2 == f.class) goto L5;
            return null;
        L5:
            return (T) new f();
        }
    }

    public class b extends TypeToken<SystemBatteryRecorderConfig> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.settings.performance.IPerfSettings
    public SystemBatteryRecorderConfig systemBatteryRecorderConfig() {
        this.mExposedManager.e("system_battery_recorder_settings");
        if (j37.a.g("system_battery_recorder_settings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = system_battery_recorder_settings time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("system_battery_recorder_settings") == false) goto L14;
        SystemBatteryRecorderConfig r1 = (SystemBatteryRecorderConfig) this.mCachedSettings.get("system_battery_recorder_settings");
        if (r1 != null) goto L33;
        ((f) m37.c.a(f.class, this.mInstanceCreator)).getClass();
        r1 = f.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null system_battery_recorder_settings");
    L33:
        return r1;
    L14:
        h37.f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((f) m37.c.a(f.class, this.mInstanceCreator)).getClass();
        r1 = f.a();
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("system_battery_recorder_settings", r1);
        goto L33
    L30:
        ((f) m37.c.a(f.class, this.mInstanceCreator)).getClass();
        r1 = f.a();
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = system_battery_recorder_settings");
        goto L33
    L17:
        if (r3.contains("system_battery_recorder_settings") == false) goto L27;
        String r5 = this.mStorage.getString("system_battery_recorder_settings");
        SystemBatteryRecorderConfig r6 = (SystemBatteryRecorderConfig) GSON.fromJson(r5, new b().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((f) m37.c.a(f.class, this.mInstanceCreator)).getClass();
        SystemBatteryRecorderConfig r7 = f.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    public IPerfSettings$$Impl(h37.f r2) {
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
        r0.g("perf_settings_com.larus.settings.performance.IPerfSettings", r7.getToken());
        return;
    L39:
        if (r2.has("system_battery_recorder_settings") == false) goto L41;
        this.mStorage.putString("system_battery_recorder_settings", r2.optString("system_battery_recorder_settings"));
        this.mCachedSettings.remove("system_battery_recorder_settings");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("perf_settings_com.larus.settings.performance.IPerfSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("perf_settings_com.larus.settings.performance.IPerfSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("perf_settings_com.larus.settings.performance.IPerfSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("perf_settings_com.larus.settings.performance.IPerfSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("perf_settings_com.larus.settings.performance.IPerfSettings", "") == false) goto L22;
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
        if (r0.c("perf_settings_com.larus.settings.performance.IPerfSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("perf_settings_com.larus.settings.performance.IPerfSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
