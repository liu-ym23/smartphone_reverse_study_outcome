package com.bytedance.ies.bullet.settings.data;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.ies.bullet.base.settings.m;
import com.bytedance.ies.bullet.base.settings.n;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class IBulletSettings$$Impl implements IBulletSettings {
    private static final Gson GSON = null;
    private static final int VERSION = 1516787273;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private tg.a mExposedManager;
    private final ug.c mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private qg.d mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class a extends TypeToken<com.bytedance.ies.bullet.base.settings.d> {
        public a() {
        }
    }

    public class b extends TypeToken<com.bytedance.pia.core.setting.c> {
        public b() {
        }
    }

    public class c extends TypeToken<com.bytedance.ies.bullet.base.settings.a> {
        public c() {
        }
    }

    public class d extends TypeToken<com.bytedance.ies.bullet.base.settings.c> {
        public d() {
        }
    }

    public class e extends TypeToken<xc.h> {
        public e() {
        }
    }

    public class f extends TypeToken<xc.d> {
        public f() {
        }
    }

    public class g extends TypeToken<n> {
        public g() {
        }
    }

    public class h extends TypeToken<xc.f> {
        public h() {
        }
    }

    public class i extends TypeToken<xc.g> {
        public i() {
        }
    }

    public class j extends TypeToken<com.bytedance.ies.bullet.base.settings.j> {
        public j() {
        }
    }

    public class k extends TypeToken<SccConfig> {
        public k() {
        }
    }

    public class l extends TypeToken<m> {
        public l() {
        }
    }

    static {
        GSON = new Gson();
    }

    public IBulletSettings$$Impl(qg.d r5) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new s6.b(6);
        this.mStorage = r5;
        this.mExposedManager = tg.a.a(ug.a.b());
        this.iEnsure = IEnsureWrapper.a();
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public xb.c getAnnieXPredefineConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("predefine_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        xb.c r11 = null;
        if (r10 != null) goto L9;
    L22:
        if (r11 == null) goto L24;
        this.mCachedSettings.put("predefine_config", r11);
    L24:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("predefine_config") == false) goto L22;
        String r12 = ((vg.b) this.mStorage).a("predefine_config");
        ((wb.a) ug.b.a(wb.a.class, this.mInstanceCreator)).getClass();
        if (r12 == null) goto L22;
        if (r12.length() == 0) goto L22;
        r11 = new xb.c(new JSONObject(r12));     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        String r14 = e.getMessage();
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "MetaConverter error:".concat(r14), null, 12);
        goto L22
    L5:
        return (xb.c) this.mCachedSettings.get("predefine_config");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public xb.d getAnnieXPredefineWasmConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("predefine_wasm_disable_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        xb.d r11 = null;
        if (r10 != null) goto L9;
    L22:
        if (r11 == null) goto L24;
        this.mCachedSettings.put("predefine_wasm_disable_config", r11);
    L24:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("predefine_wasm_disable_config") == false) goto L22;
        String r12 = ((vg.b) this.mStorage).a("predefine_wasm_disable_config");
        ((wb.b) ug.b.a(wb.b.class, this.mInstanceCreator)).getClass();
        if (r12 == null) goto L22;
        if (r12.length() == 0) goto L22;
        r11 = new xb.d(new JSONObject(r12));     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        String r14 = e.getMessage();
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "PredefineConfigConverter error:".concat(r14), null, 12);
        goto L22
    L5:
        return (xb.d) this.mCachedSettings.get("predefine_wasm_disable_config");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public com.bytedance.ies.bullet.base.settings.a getAnnieXRedirectConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("redirect") == true) goto L5;
        qg.d r10 = this.mStorage;
        com.bytedance.ies.bullet.base.settings.a r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("redirect", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("redirect") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("redirect");
        r11 = (com.bytedance.ies.bullet.base.settings.a) GSON.fromJson(r12, new c().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (com.bytedance.ies.bullet.base.settings.a) this.mCachedSettings.get("redirect");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public com.bytedance.ies.bullet.base.settings.b getArgusSecuritySettingConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("argus_security") == true) goto L5;
        qg.d r10 = this.mStorage;
        if (r10 != null) goto L9;
    L11:
        com.bytedance.ies.bullet.base.settings.b r11 = null;
    L12:
        if (r11 == null) goto L14;
        this.mCachedSettings.put("argus_security", r11);
    L14:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("argus_security") == false) goto L11;
        String r12 = ((vg.b) this.mStorage).a("argus_security");
        ((com.bytedance.ies.bullet.base.settings.b) ug.b.a(com.bytedance.ies.bullet.base.settings.b.class, this.mInstanceCreator)).getClass();
        r11 = new com.bytedance.ies.bullet.base.settings.b();
        r11.f5195a = r12;
        goto L12
    L5:
        return (com.bytedance.ies.bullet.base.settings.b) this.mCachedSettings.get("argus_security");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public com.bytedance.ies.bullet.base.settings.c getClientAiConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("annie_client_ai") == true) goto L5;
        qg.d r10 = this.mStorage;
        com.bytedance.ies.bullet.base.settings.c r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("annie_client_ai", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("annie_client_ai") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("annie_client_ai");
        r11 = (com.bytedance.ies.bullet.base.settings.c) GSON.fromJson(r12, new d().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (com.bytedance.ies.bullet.base.settings.c) this.mCachedSettings.get("annie_client_ai");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public xc.d getCommonConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("common") == true) goto L5;
        qg.d r10 = this.mStorage;
        xc.d r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("common", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("common") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("common");
        r11 = (xc.d) GSON.fromJson(r12, new f().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (xc.d) this.mCachedSettings.get("common");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public com.bytedance.ies.bullet.base.settings.d getForestSettingConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("forest") == true) goto L5;
        qg.d r10 = this.mStorage;
        com.bytedance.ies.bullet.base.settings.d r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("forest", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("forest") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("forest");
        r11 = (com.bytedance.ies.bullet.base.settings.d) GSON.fromJson(r12, new a().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (com.bytedance.ies.bullet.base.settings.d) this.mCachedSettings.get("forest");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public com.bytedance.ies.bullet.base.settings.j getMixConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("mix") == true) goto L5;
        qg.d r10 = this.mStorage;
        com.bytedance.ies.bullet.base.settings.j r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("mix", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("mix") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("mix");
        r11 = (com.bytedance.ies.bullet.base.settings.j) GSON.fromJson(r12, new j().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (com.bytedance.ies.bullet.base.settings.j) this.mCachedSettings.get("mix");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public xc.f getMonitorConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("monitor") == true) goto L5;
        qg.d r10 = this.mStorage;
        xc.f r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("monitor", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("monitor") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("monitor");
        r11 = (xc.f) GSON.fromJson(r12, new h().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (xc.f) this.mCachedSettings.get("monitor");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public com.bytedance.pia.core.setting.c getPIAConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("piasdk") == true) goto L5;
        qg.d r10 = this.mStorage;
        com.bytedance.pia.core.setting.c r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("piasdk", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("piasdk") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("piasdk");
        r11 = (com.bytedance.pia.core.setting.c) GSON.fromJson(r12, new b().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (com.bytedance.pia.core.setting.c) this.mCachedSettings.get("piasdk");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public xc.g getPineappleConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("pineapple") == true) goto L5;
        qg.d r10 = this.mStorage;
        xc.g r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("pineapple", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("pineapple") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("pineapple");
        r11 = (xc.g) GSON.fromJson(r12, new i().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (xc.g) this.mCachedSettings.get("pineapple");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public xc.h getResourceLoaderConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("resourceloader") == true) goto L5;
        qg.d r10 = this.mStorage;
        xc.h r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("resourceloader", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("resourceloader") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("resourceloader");
        r11 = (xc.h) GSON.fromJson(r12, new e().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (xc.h) this.mCachedSettings.get("resourceloader");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public SccConfig getSccSettingsConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("scc_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        SccConfig r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("scc_config", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("scc_config") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("scc_config");
        r11 = (SccConfig) GSON.fromJson(r12, new k().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (SccConfig) this.mCachedSettings.get("scc_config");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public m getSecuritySettingConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("SecuritySetting") == true) goto L5;
        qg.d r10 = this.mStorage;
        m r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("SecuritySetting", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("SecuritySetting") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("SecuritySetting");
        r11 = (m) GSON.fromJson(r12, new l().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (m) this.mCachedSettings.get("SecuritySetting");
    }

    @Override // com.bytedance.ies.bullet.settings.data.IBulletSettings
    @Nullable
    public n getWebConfig() {
        tg.a r5 = tg.a.f22131a;
        if (this.mCachedSettings.containsKey("web_config") == true) goto L5;
        qg.d r10 = this.mStorage;
        n r11 = null;
        if (r10 != null) goto L9;
    L15:
        if (r11 == null) goto L17;
        this.mCachedSettings.put("web_config", r11);
    L17:
        return r11;
    L9:
        if (((vg.b) r10).f22578a.contains("web_config") == false) goto L15;
        String r12 = ((vg.b) this.mStorage).a("web_config");
        r11 = (n) GSON.fromJson(r12, new g().getType());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return (n) this.mCachedSettings.get("web_config");
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ISettings
    public void updateSettings(qg.c r10) {
        ug.e r5 = ug.e.c(ug.a.b());
        if (r10 == null) goto L5;
    L29:
        if (r10 != null) goto L31;
        return;
    L31:
        if (this.mStorage == null) goto L86;
        JSONObject r11 = r10.f21511a;
        if (r11 != null) goto L35;
    L79:
        ((vg.b) this.mStorage).f22579b.apply();
        ((SharedPreferences) r5.f22361b).edit().putString("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", r10.f21513c).apply();
        return;
    L35:
        if (r11.has("resourceloader") == false) goto L38;
        qg.d r12 = this.mStorage;
        vg.b r13 = (vg.b) r12;
        r13.b("resourceloader", r11.optString("resourceloader"));
        this.mCachedSettings.remove("resourceloader");
    L38:
        if (r11.has("common") == false) goto L41;
        qg.d r14 = this.mStorage;
        vg.b r15 = (vg.b) r14;
        r15.b("common", r11.optString("common"));
        this.mCachedSettings.remove("common");
    L41:
        if (r11.has("web_config") == false) goto L44;
        qg.d r16 = this.mStorage;
        vg.b r17 = (vg.b) r16;
        r17.b("web_config", r11.optString("web_config"));
        this.mCachedSettings.remove("web_config");
    L44:
        if (r11.has("monitor") == false) goto L47;
        qg.d r18 = this.mStorage;
        vg.b r19 = (vg.b) r18;
        r19.b("monitor", r11.optString("monitor"));
        this.mCachedSettings.remove("monitor");
    L47:
        if (r11.has("pineapple") == false) goto L50;
        qg.d r20 = this.mStorage;
        vg.b r21 = (vg.b) r20;
        r21.b("pineapple", r11.optString("pineapple"));
        this.mCachedSettings.remove("pineapple");
    L50:
        if (r11.has("mix") == false) goto L53;
        qg.d r22 = this.mStorage;
        vg.b r23 = (vg.b) r22;
        r23.b("mix", r11.optString("mix"));
        this.mCachedSettings.remove("mix");
    L53:
        if (r11.has("scc_config") == false) goto L56;
        qg.d r24 = this.mStorage;
        vg.b r25 = (vg.b) r24;
        r25.b("scc_config", r11.optString("scc_config"));
        this.mCachedSettings.remove("scc_config");
    L56:
        if (r11.has("SecuritySetting") == false) goto L59;
        qg.d r26 = this.mStorage;
        vg.b r27 = (vg.b) r26;
        r27.b("SecuritySetting", r11.optString("SecuritySetting"));
        this.mCachedSettings.remove("SecuritySetting");
    L59:
        if (r11.has("forest") == false) goto L62;
        qg.d r28 = this.mStorage;
        vg.b r29 = (vg.b) r28;
        r29.b("forest", r11.optString("forest"));
        this.mCachedSettings.remove("forest");
    L62:
        if (r11.has("piasdk") == false) goto L65;
        qg.d r30 = this.mStorage;
        vg.b r31 = (vg.b) r30;
        r31.b("piasdk", r11.optString("piasdk"));
        this.mCachedSettings.remove("piasdk");
    L65:
        if (r11.has("redirect") == false) goto L68;
        qg.d r32 = this.mStorage;
        vg.b r33 = (vg.b) r32;
        r33.b("redirect", r11.optString("redirect"));
        this.mCachedSettings.remove("redirect");
    L68:
        if (r11.has("predefine_config") == false) goto L71;
        qg.d r34 = this.mStorage;
        vg.b r35 = (vg.b) r34;
        r35.b("predefine_config", r11.optString("predefine_config"));
        this.mCachedSettings.remove("predefine_config");
    L71:
        if (r11.has("predefine_wasm_disable_config") == false) goto L74;
        qg.d r36 = this.mStorage;
        vg.b r37 = (vg.b) r36;
        r37.b("predefine_wasm_disable_config", r11.optString("predefine_wasm_disable_config"));
        this.mCachedSettings.remove("predefine_wasm_disable_config");
    L74:
        if (r11.has("argus_security") == false) goto L77;
        qg.d r38 = this.mStorage;
        vg.b r39 = (vg.b) r38;
        r39.b("argus_security", r11.optString("argus_security"));
        this.mCachedSettings.remove("argus_security");
    L77:
        if (r11.has("annie_client_ai") == false) goto L79;
        qg.d r40 = this.mStorage;
        vg.b r41 = (vg.b) r40;
        r41.b("annie_client_ai", r11.optString("annie_client_ai"));
        this.mCachedSettings.remove("annie_client_ai");
        goto L79
    L86:
        return;
    L5:
        if (VERSION == r5.a("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings")) goto L15;
        r10 = ug.d.f(ug.a.b()).e("Bullet");
        tg.a r42 = tg.a.f22131a;     // Catch: Throwable -> L9
        r5.d(VERSION, "bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r10 == null) goto L12;
        r5.d(VERSION, "bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings");
    L12:
        IEnsure r43 = this.iEnsure;
        if (r43 == null) goto L29;
        r43.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L29
    L15:
        SharedPreferences r44 = (SharedPreferences) r5.f22361b;
        String r45 = r44.getString("bullet_com.bytedance.ies.bullet.settings.data.IBulletSettings", "");
        if (TextUtils.isEmpty("Bullet") == false) goto L18;
        String r46 = "key_latest_update_token";
    L20:
        if (TextUtils.equals(r45, r44.getString(r46, "")) == true) goto L22;
        r10 = ug.d.f(ug.a.b()).e("Bullet");
        goto L29
    L22:
        if (r10 != null) goto L29;
        tg.a r47 = tg.a.f22131a;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        IEnsure r48 = this.iEnsure;
        if (r48 == null) goto L29;
        r48.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L29
    L18:
        r46 = "key_latest_update_token_".concat("Bullet");
        goto L20
    }
}
