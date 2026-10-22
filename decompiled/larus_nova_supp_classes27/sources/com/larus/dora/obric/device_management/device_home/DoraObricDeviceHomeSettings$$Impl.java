package com.larus.dora.obric.device_management.device_home;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class DoraObricDeviceHomeSettings$$Impl implements DoraObricDeviceHomeSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -1954755945;
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
            if (r2 == q1.class) goto L5;
            return null;
        L5:
            return (T) new q1();
        }
    }

    public class b extends TypeToken<DoraObricDeviceHomeQuickActionConfig> {
        public b() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings
    public DoraObricDeviceHomeQuickActionConfig doraObricDeviceHomeQuickActionConfig() {
        this.mExposedManager.e("dora_obric_device_home_quick_action_config");
        if (j37.a.g("dora_obric_device_home_quick_action_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = dora_obric_device_home_quick_action_config time = " + j37.a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("dora_obric_device_home_quick_action_config") == false) goto L14;
        DoraObricDeviceHomeQuickActionConfig r1 = (DoraObricDeviceHomeQuickActionConfig) this.mCachedSettings.get("dora_obric_device_home_quick_action_config");
        if (r1 != null) goto L33;
        ((q1) m37.c.a(q1.class, this.mInstanceCreator)).getClass();
        r1 = new DoraObricDeviceHomeQuickActionConfig(null, 1, null);
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null dora_obric_device_home_quick_action_config");
    L33:
        return r1;
    L14:
        h37.f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((q1) m37.c.a(q1.class, this.mInstanceCreator)).getClass();
        r1 = new DoraObricDeviceHomeQuickActionConfig(null, 1, null);
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("dora_obric_device_home_quick_action_config", r1);
        goto L33
    L30:
        ((q1) m37.c.a(q1.class, this.mInstanceCreator)).getClass();
        r1 = new DoraObricDeviceHomeQuickActionConfig(null, 1, null);
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = dora_obric_device_home_quick_action_config");
        goto L33
    L17:
        if (r3.contains("dora_obric_device_home_quick_action_config") == false) goto L27;
        String r5 = this.mStorage.getString("dora_obric_device_home_quick_action_config");
        DoraObricDeviceHomeQuickActionConfig r6 = (DoraObricDeviceHomeQuickActionConfig) GSON.fromJson(r5, new b().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((q1) m37.c.a(q1.class, this.mInstanceCreator)).getClass();
        DoraObricDeviceHomeQuickActionConfig r7 = new DoraObricDeviceHomeQuickActionConfig(null, 1, null);
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    public DoraObricDeviceHomeSettings$$Impl(h37.f r2) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new a();
        this.mStorage = r2;
        this.mExposedManager = j37.a.b(m37.a.getContext());
        this.iEnsure = IEnsureWrapper.getInstance();
    }

    public void updateSettings(SettingsData r7) {
        m37.h r0 = m37.h.a(m37.a.getContext());
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
        r0.g("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings", r7.getToken());
        return;
    L39:
        if (r2.has("dora_obric_device_home_quick_action_config") == false) goto L41;
        this.mStorage.putString("dora_obric_device_home_quick_action_config", r2.optString("dora_obric_device_home_quick_action_config"));
        this.mCachedSettings.remove("dora_obric_device_home_quick_action_config");
        goto L41
    L49:
        return;
    L5:
        if (VERSION == r0.b("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d("");
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings", VERSION);
    L16:
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (j37.a.i == false) goto L11;
        if (r7 == null) goto L45;
        r0.f("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings", VERSION);     // Catch: Throwable -> L13
    L45:
        goto L33
    L11:
        r0.f("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings", VERSION);     // Catch: Throwable -> L13
        goto L45
    L20:
        if (r0.d("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings", "") == false) goto L22;
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
        if (r0.c("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d("");     // Catch: Throwable -> L29
        r0.e("dora_obric_device_home_settings_com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
