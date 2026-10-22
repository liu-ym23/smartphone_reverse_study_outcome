package com.bytedance.android.monitorV2.settings;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class IMonitorSettings$$Impl implements IMonitorSettings {
    private static final Gson GSON = null;
    private static final int VERSION = 1649816078;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private tg.a mExposedManager;
    private final ug.c mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private qg.d mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a extends TypeToken<h> {
        public a() {
        }
    }

    public class b extends TypeToken<d> {
        public b() {
        }
    }

    public class c extends TypeToken<com.bytedance.android.monitorV2.settings.c> {
        public c() {
        }
    }

    static {
        GSON = new Gson();
    }

    public IMonitorSettings$$Impl(qg.d r5) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new e();
        this.mStorage = r5;
        this.mExposedManager = tg.a.a(ug.a.b());
        this.iEnsure = IEnsureWrapper.a();
    }

    @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
    @Nullable
    public com.bytedance.android.monitorV2.settings.c getLynxBlankConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("lynx_blank_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        com.bytedance.android.monitorV2.settings.c r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("lynx_blank_config", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("lynx_blank_config") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("lynx_blank_config");
        r11 = (com.bytedance.android.monitorV2.settings.c) GSON.fromJson(r12, new c().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (com.bytedance.android.monitorV2.settings.c) this.mCachedSettings.get("lynx_blank_config");
    }

    @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
    @Nullable
    public d getMonitorConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("monitor_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        d r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("monitor_config", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("monitor_config") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("monitor_config");
        r11 = (d) GSON.fromJson(r12, new b().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (d) this.mCachedSettings.get("monitor_config");
    }

    @Override // com.bytedance.android.monitorV2.settings.IMonitorSettings
    @Nullable
    public h getWebBlankConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("web_blank_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        h r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("web_blank_config", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("web_blank_config") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("web_blank_config");
        r11 = (h) GSON.fromJson(r12, new a().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (h) this.mCachedSettings.get("web_blank_config");
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ISettings
    public void updateSettings(qg.c r10) {
        ug.e r5 = ug.e.c(ug.a.b());
        if (r10 == null) goto L5;
    L29:
        if (r10 != null) goto L31;
        return;
    L31:
        if (this.mStorage == null) goto L50;
        JSONObject r11 = r10.f21511a;
        if (r11 != null) goto L35;
    L43:
        ((vg.b) this.mStorage).f22579b.apply();
        ((SharedPreferences) r5.f22361b).edit().putString("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", r10.f21513c).apply();
        return;
    L35:
        if (r11.has("web_blank_config") == false) goto L38;
        qg.d r12 = this.mStorage;
        vg.b r13 = (vg.b) r12;
        r13.b("web_blank_config", r11.optString("web_blank_config"));
        this.mCachedSettings.remove("web_blank_config");
    L38:
        if (r11.has("monitor_config") == false) goto L41;
        qg.d r14 = this.mStorage;
        vg.b r15 = (vg.b) r14;
        r15.b("monitor_config", r11.optString("monitor_config"));
        this.mCachedSettings.remove("monitor_config");
    L41:
        if (r11.has("lynx_blank_config") == false) goto L43;
        qg.d r16 = this.mStorage;
        vg.b r17 = (vg.b) r16;
        r17.b("lynx_blank_config", r11.optString("lynx_blank_config"));
        this.mCachedSettings.remove("lynx_blank_config");
        goto L43
    L50:
        return;
    L5:
        if (VERSION == r5.a("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings")) goto L15;
        r10 = ug.d.f(ug.a.b()).e("hybrid_monitor");
        tg.a r18 = tg.a.f22131a;     // Catch: Throwable -> L9
        r5.d(VERSION, "hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r10 == null) goto L12;
        r5.d(VERSION, "hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings");
    L12:
        IEnsure r19 = this.iEnsure;
        if (r19 == null) goto L29;
        r19.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L29
    L15:
        SharedPreferences r20 = (SharedPreferences) r5.f22361b;
        String r21 = r20.getString("hybrid_monitor_com.bytedance.android.monitorV2.settings.IMonitorSettings", "");
        if (TextUtils.isEmpty("hybrid_monitor") == false) goto L18;
        String r22 = "key_latest_update_token";
    L20:
        if (TextUtils.equals(r21, r20.getString(r22, "")) == true) goto L22;
        r10 = ug.d.f(ug.a.b()).e("hybrid_monitor");
        goto L29
    L22:
        if (r10 != null) goto L29;
        tg.a r23 = tg.a.f22131a;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        IEnsure r24 = this.iEnsure;
        if (r24 == null) goto L29;
        r24.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L29
    L18:
        r22 = "key_latest_update_token_".concat("hybrid_monitor");
        goto L20
    }
}
