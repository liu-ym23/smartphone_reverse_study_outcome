package com.bytedance.ai.settings;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ai.settings.provider.AIBridgeSettingsConfig;
import com.bytedance.ai.settings.provider.AIBridgeSettingsProvider;
import com.bytedance.ai.settings.provider.FrontierConfig;
import com.bytedance.ai.settings.provider.FrontierDefaultProvider;
import com.bytedance.ai.settings.provider.LynxTemplateVerifyConfig;
import com.bytedance.ai.settings.provider.LynxTemplateVerifyConfigProvider;
import com.bytedance.ai.settings.provider.LynxViewReusedConfig;
import com.bytedance.ai.settings.provider.LynxViewReusedConfigDefaultProvider;
import com.bytedance.ai.settings.provider.OptimizeSettings;
import com.bytedance.ai.settings.provider.OptimizeSettingsDefaultProvider;
import com.bytedance.ai.settings.provider.RelaxConfig;
import com.bytedance.ai.settings.provider.RelaxConfigDefaultProvider;
import com.bytedance.ai.settings.provider.ResourcesManagerConfig;
import com.bytedance.ai.settings.provider.ResourcesManagerDefaultProvider;
import com.bytedance.ai.settings.provider.WidgetSettingsConfig;
import com.bytedance.ai.settings.provider.WidgetSettingsDefaultProvider;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import qg.d;
import tg.a;
import ug.b;
import ug.c;
import ug.e;

/* JADX INFO: loaded from: classes2.dex */
public class IAISDKSettings$$Impl implements IAISDKSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -1778633394;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private a mExposedManager;
    private final c mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private d mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    static {
        GSON = new Gson();
    }

    public IAISDKSettings$$Impl(d r5) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new AnonymousClass1();
        this.mStorage = r5;
        this.mExposedManager = a.a(ug.a.b());
        this.iEnsure = IEnsureWrapper.a();
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public AIBridgeSettingsConfig aiBridgeConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("ai_bridge_settings") == false) goto L7;
        return (AIBridgeSettingsConfig) this.mStickySettings.get("ai_bridge_settings");
    L7:
        if (this.mCachedSettings.containsKey("ai_bridge_settings") == false) goto L13;
        AIBridgeSettingsConfig r10 = (AIBridgeSettingsConfig) this.mCachedSettings.get("ai_bridge_settings");
        if (r10 != null) goto L31;
        ((AIBridgeSettingsProvider) b.a(AIBridgeSettingsProvider.class, this.mInstanceCreator)).getClass();
        r10 = new AIBridgeSettingsConfig();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null ai_bridge_settings");
    L31:
        this.mStickySettings.put("ai_bridge_settings", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((AIBridgeSettingsProvider) b.a(AIBridgeSettingsProvider.class, this.mInstanceCreator)).getClass();
        r10 = new AIBridgeSettingsConfig();
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("ai_bridge_settings", r10);
        goto L31
    L28:
        ((AIBridgeSettingsProvider) b.a(AIBridgeSettingsProvider.class, this.mInstanceCreator)).getClass();
        r10 = new AIBridgeSettingsConfig();
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = ai_bridge_settings");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("ai_bridge_settings") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("ai_bridge_settings");
        r10 = (AIBridgeSettingsConfig) GSON.fromJson(r14, new AnonymousClass7().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((AIBridgeSettingsProvider) b.a(AIBridgeSettingsProvider.class, this.mInstanceCreator)).getClass();
        AIBridgeSettingsConfig r15 = new AIBridgeSettingsConfig();
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public FrontierConfig frontierConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("frontier_config") == false) goto L7;
        return (FrontierConfig) this.mStickySettings.get("frontier_config");
    L7:
        if (this.mCachedSettings.containsKey("frontier_config") == false) goto L13;
        FrontierConfig r10 = (FrontierConfig) this.mCachedSettings.get("frontier_config");
        if (r10 != null) goto L31;
        ((FrontierDefaultProvider) b.a(FrontierDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new FrontierConfig();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null frontier_config");
    L31:
        this.mStickySettings.put("frontier_config", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((FrontierDefaultProvider) b.a(FrontierDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new FrontierConfig();
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("frontier_config", r10);
        goto L31
    L28:
        ((FrontierDefaultProvider) b.a(FrontierDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new FrontierConfig();
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = frontier_config");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("frontier_config") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("frontier_config");
        r10 = (FrontierConfig) GSON.fromJson(r14, new AnonymousClass3().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((FrontierDefaultProvider) b.a(FrontierDefaultProvider.class, this.mInstanceCreator)).getClass();
        FrontierConfig r15 = new FrontierConfig();
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public LynxTemplateVerifyConfig lynxTemplateVerifyConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("template_verify") == false) goto L7;
        return (LynxTemplateVerifyConfig) this.mStickySettings.get("template_verify");
    L7:
        if (this.mCachedSettings.containsKey("template_verify") == false) goto L13;
        LynxTemplateVerifyConfig r10 = (LynxTemplateVerifyConfig) this.mCachedSettings.get("template_verify");
        if (r10 != null) goto L31;
        ((LynxTemplateVerifyConfigProvider) b.a(LynxTemplateVerifyConfigProvider.class, this.mInstanceCreator)).getClass();
        r10 = new LynxTemplateVerifyConfig(0);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null template_verify");
    L31:
        this.mStickySettings.put("template_verify", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((LynxTemplateVerifyConfigProvider) b.a(LynxTemplateVerifyConfigProvider.class, this.mInstanceCreator)).getClass();
        r10 = new LynxTemplateVerifyConfig(0);
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("template_verify", r10);
        goto L31
    L28:
        ((LynxTemplateVerifyConfigProvider) b.a(LynxTemplateVerifyConfigProvider.class, this.mInstanceCreator)).getClass();
        r10 = new LynxTemplateVerifyConfig(0);
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = template_verify");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("template_verify") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("template_verify");
        r10 = (LynxTemplateVerifyConfig) GSON.fromJson(r14, new AnonymousClass5().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((LynxTemplateVerifyConfigProvider) b.a(LynxTemplateVerifyConfigProvider.class, this.mInstanceCreator)).getClass();
        LynxTemplateVerifyConfig r15 = new LynxTemplateVerifyConfig(0);
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public LynxViewReusedConfig lynxViewReusedConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("lynx_view_reused") == false) goto L7;
        return (LynxViewReusedConfig) this.mStickySettings.get("lynx_view_reused");
    L7:
        if (this.mCachedSettings.containsKey("lynx_view_reused") == false) goto L13;
        LynxViewReusedConfig r10 = (LynxViewReusedConfig) this.mCachedSettings.get("lynx_view_reused");
        if (r10 != null) goto L31;
        ((LynxViewReusedConfigDefaultProvider) b.a(LynxViewReusedConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new LynxViewReusedConfig(0);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null lynx_view_reused");
    L31:
        this.mStickySettings.put("lynx_view_reused", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((LynxViewReusedConfigDefaultProvider) b.a(LynxViewReusedConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new LynxViewReusedConfig(0);
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("lynx_view_reused", r10);
        goto L31
    L28:
        ((LynxViewReusedConfigDefaultProvider) b.a(LynxViewReusedConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new LynxViewReusedConfig(0);
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = lynx_view_reused");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("lynx_view_reused") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("lynx_view_reused");
        r10 = (LynxViewReusedConfig) GSON.fromJson(r14, new AnonymousClass6().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((LynxViewReusedConfigDefaultProvider) b.a(LynxViewReusedConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        LynxViewReusedConfig r15 = new LynxViewReusedConfig(0);
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public OptimizeSettings optimizeSettings() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("optimize_settings") == false) goto L7;
        return (OptimizeSettings) this.mStickySettings.get("optimize_settings");
    L7:
        if (this.mCachedSettings.containsKey("optimize_settings") == false) goto L13;
        OptimizeSettings r10 = (OptimizeSettings) this.mCachedSettings.get("optimize_settings");
        if (r10 != null) goto L31;
        ((OptimizeSettingsDefaultProvider) b.a(OptimizeSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new OptimizeSettings(0);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null optimize_settings");
    L31:
        this.mStickySettings.put("optimize_settings", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((OptimizeSettingsDefaultProvider) b.a(OptimizeSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new OptimizeSettings(0);
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("optimize_settings", r10);
        goto L31
    L28:
        ((OptimizeSettingsDefaultProvider) b.a(OptimizeSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new OptimizeSettings(0);
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = optimize_settings");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("optimize_settings") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("optimize_settings");
        r10 = (OptimizeSettings) GSON.fromJson(r14, new AnonymousClass8().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((OptimizeSettingsDefaultProvider) b.a(OptimizeSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        OptimizeSettings r15 = new OptimizeSettings(0);
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public RelaxConfig relaxConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("relax_settings") == false) goto L7;
        return (RelaxConfig) this.mStickySettings.get("relax_settings");
    L7:
        if (this.mCachedSettings.containsKey("relax_settings") == false) goto L13;
        RelaxConfig r10 = (RelaxConfig) this.mCachedSettings.get("relax_settings");
        if (r10 != null) goto L27;
        ((RelaxConfigDefaultProvider) b.a(RelaxConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new RelaxConfig(0);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L27;
        r11.ensureNotReachHere("value == null relax_settings");
    L27:
        this.mStickySettings.put("relax_settings", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((RelaxConfigDefaultProvider) b.a(RelaxConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new RelaxConfig(0);
    L26:
        this.mCachedSettings.put("relax_settings", r10);
        goto L27
    L16:
        if (((vg.b) r12).f22578a.contains("relax_settings") == false) goto L25;
        String r13 = ((vg.b) this.mStorage).a("relax_settings");
        ((RelaxSettingsConverter) b.a(RelaxSettingsConverter.class, this.mInstanceCreator)).getClass();     // Catch: Exception -> L20
        r10 = RelaxSettingsConverter.a(r13);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((RelaxConfigDefaultProvider) b.a(RelaxConfigDefaultProvider.class, this.mInstanceCreator)).getClass();
        RelaxConfig r14 = new RelaxConfig(0);
        IEnsure r15 = this.iEnsure;
        if (r15 == null) goto L24;
        r15.ensureNotReachHere(e, td.d.b("gson from json error", r13));
    L24:
        e.printStackTrace();
        r10 = r14;
        goto L26
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public ResourcesManagerConfig resourcesManagerConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("resources_manager_settings") == false) goto L7;
        return (ResourcesManagerConfig) this.mStickySettings.get("resources_manager_settings");
    L7:
        if (this.mCachedSettings.containsKey("resources_manager_settings") == false) goto L13;
        ResourcesManagerConfig r10 = (ResourcesManagerConfig) this.mCachedSettings.get("resources_manager_settings");
        if (r10 != null) goto L31;
        ((ResourcesManagerDefaultProvider) b.a(ResourcesManagerDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new ResourcesManagerConfig();
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null resources_manager_settings");
    L31:
        this.mStickySettings.put("resources_manager_settings", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((ResourcesManagerDefaultProvider) b.a(ResourcesManagerDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new ResourcesManagerConfig();
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("resources_manager_settings", r10);
        goto L31
    L28:
        ((ResourcesManagerDefaultProvider) b.a(ResourcesManagerDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new ResourcesManagerConfig();
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = resources_manager_settings");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("resources_manager_settings") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("resources_manager_settings");
        r10 = (ResourcesManagerConfig) GSON.fromJson(r14, new AnonymousClass2().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((ResourcesManagerDefaultProvider) b.a(ResourcesManagerDefaultProvider.class, this.mInstanceCreator)).getClass();
        ResourcesManagerConfig r15 = new ResourcesManagerConfig();
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ISettings
    public void updateSettings(qg.c r10) {
        e r5 = e.c(ug.a.b());
        if (r10 == null) goto L5;
    L29:
        if (r10 != null) goto L31;
        return;
    L31:
        if (this.mStorage == null) goto L65;
        JSONObject r11 = r10.f21511a;
        if (r11 != null) goto L35;
    L58:
        ((vg.b) this.mStorage).f22579b.apply();
        ((SharedPreferences) r5.f22361b).edit().putString("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", r10.f21513c).apply();
        return;
    L35:
        if (r11.has("resources_manager_settings") == false) goto L38;
        d r12 = this.mStorage;
        vg.b r13 = (vg.b) r12;
        r13.b("resources_manager_settings", r11.optString("resources_manager_settings"));
        this.mCachedSettings.remove("resources_manager_settings");
    L38:
        if (r11.has("frontier_config") == false) goto L41;
        d r14 = this.mStorage;
        vg.b r15 = (vg.b) r14;
        r15.b("frontier_config", r11.optString("frontier_config"));
        this.mCachedSettings.remove("frontier_config");
    L41:
        if (r11.has("widget_settings") == false) goto L44;
        d r16 = this.mStorage;
        vg.b r17 = (vg.b) r16;
        r17.b("widget_settings", r11.optString("widget_settings"));
        this.mCachedSettings.remove("widget_settings");
    L44:
        if (r11.has("template_verify") == false) goto L47;
        d r18 = this.mStorage;
        vg.b r19 = (vg.b) r18;
        r19.b("template_verify", r11.optString("template_verify"));
        this.mCachedSettings.remove("template_verify");
    L47:
        if (r11.has("lynx_view_reused") == false) goto L50;
        d r20 = this.mStorage;
        vg.b r21 = (vg.b) r20;
        r21.b("lynx_view_reused", r11.optString("lynx_view_reused"));
        this.mCachedSettings.remove("lynx_view_reused");
    L50:
        if (r11.has("ai_bridge_settings") == false) goto L53;
        d r22 = this.mStorage;
        vg.b r23 = (vg.b) r22;
        r23.b("ai_bridge_settings", r11.optString("ai_bridge_settings"));
        this.mCachedSettings.remove("ai_bridge_settings");
    L53:
        if (r11.has("relax_settings") == false) goto L56;
        d r24 = this.mStorage;
        vg.b r25 = (vg.b) r24;
        r25.b("relax_settings", r11.optString("relax_settings"));
        this.mCachedSettings.remove("relax_settings");
    L56:
        if (r11.has("optimize_settings") == false) goto L58;
        d r26 = this.mStorage;
        vg.b r27 = (vg.b) r26;
        r27.b("optimize_settings", r11.optString("optimize_settings"));
        this.mCachedSettings.remove("optimize_settings");
        goto L58
    L65:
        return;
    L5:
        if (VERSION == r5.a("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings")) goto L15;
        r10 = ug.d.f(ug.a.b()).e("flow_ai_sdk");
        a r28 = a.f22131a;     // Catch: Throwable -> L9
        r5.d(VERSION, "ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r10 == null) goto L12;
        r5.d(VERSION, "ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings");
    L12:
        IEnsure r29 = this.iEnsure;
        if (r29 == null) goto L29;
        r29.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L29
    L15:
        SharedPreferences r30 = (SharedPreferences) r5.f22361b;
        String r31 = r30.getString("ai_sdk_settings_com.bytedance.ai.settings.IAISDKSettings", "");
        if (TextUtils.isEmpty("flow_ai_sdk") == false) goto L18;
        String r32 = "key_latest_update_token";
    L20:
        if (TextUtils.equals(r31, r30.getString(r32, "")) == true) goto L22;
        r10 = ug.d.f(ug.a.b()).e("flow_ai_sdk");
        goto L29
    L22:
        if (r10 != null) goto L29;
        a r33 = a.f22131a;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        IEnsure r34 = this.iEnsure;
        if (r34 == null) goto L29;
        r34.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L29
    L18:
        r32 = "key_latest_update_token_".concat("flow_ai_sdk");
        goto L20
    }

    @Override // com.bytedance.ai.settings.IAISDKSettings
    public WidgetSettingsConfig widgetSettingsConfig() {
        a r5 = a.f22131a;
        if (this.mStickySettings.containsKey("widget_settings") == false) goto L7;
        return (WidgetSettingsConfig) this.mStickySettings.get("widget_settings");
    L7:
        if (this.mCachedSettings.containsKey("widget_settings") == false) goto L13;
        WidgetSettingsConfig r10 = (WidgetSettingsConfig) this.mCachedSettings.get("widget_settings");
        if (r10 != null) goto L31;
        ((WidgetSettingsDefaultProvider) b.a(WidgetSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new WidgetSettingsConfig(0);
        IEnsure r11 = this.iEnsure;
        if (r11 == null) goto L31;
        r11.ensureNotReachHere("value == null widget_settings");
    L31:
        this.mStickySettings.put("widget_settings", r10);
        return r10;
    L13:
        d r12 = this.mStorage;
        if (r12 != null) goto L16;
    L25:
        ((WidgetSettingsDefaultProvider) b.a(WidgetSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new WidgetSettingsConfig(0);
    L26:
        if (r10 == null) goto L28;
        this.mCachedSettings.put("widget_settings", r10);
        goto L31
    L28:
        ((WidgetSettingsDefaultProvider) b.a(WidgetSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        r10 = new WidgetSettingsConfig(0);
        IEnsure r13 = this.iEnsure;
        if (r13 == null) goto L31;
        r13.ensureNotReachHere("value == null key = widget_settings");
        goto L31
    L16:
        if (((vg.b) r12).f22578a.contains("widget_settings") == false) goto L25;
        String r14 = ((vg.b) this.mStorage).a("widget_settings");
        r10 = (WidgetSettingsConfig) GSON.fromJson(r14, new AnonymousClass4().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ((WidgetSettingsDefaultProvider) b.a(WidgetSettingsDefaultProvider.class, this.mInstanceCreator)).getClass();
        WidgetSettingsConfig r15 = new WidgetSettingsConfig(0);
        IEnsure r16 = this.iEnsure;
        if (r16 == null) goto L24;
        r16.ensureNotReachHere(e, td.d.b("gson from json error", r14));
    L24:
        e.printStackTrace();
        r10 = r15;
        goto L26
    }
}
