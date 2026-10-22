package com.bytedance.android.live.core.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.ac;
import com.bytedance.android.livesdk.config.an;
import com.bytedance.android.livesdk.config.b01;
import com.bytedance.android.livesdk.config.bg0;
import com.bytedance.android.livesdk.config.ca;
import com.bytedance.android.livesdk.config.df;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.ea;
import com.bytedance.android.livesdk.config.f70;
import com.bytedance.android.livesdk.config.fa;
import com.bytedance.android.livesdk.config.gj0;
import com.bytedance.android.livesdk.config.hz;
import com.bytedance.android.livesdk.config.ia;
import com.bytedance.android.livesdk.config.in;
import com.bytedance.android.livesdk.config.ka;
import com.bytedance.android.livesdk.config.kg1;
import com.bytedance.android.livesdk.config.mc0;
import com.bytedance.android.livesdk.config.pg1;
import com.bytedance.android.livesdk.config.pi0;
import com.bytedance.android.livesdk.config.rr0;
import com.bytedance.android.livesdk.config.t10;
import com.bytedance.android.livesdk.config.wf0;
import com.bytedance.android.livesdk.config.z7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TTLiveSettingUtil {
    private static final String TAG = "TTLiveSettingUtil";
    private static Disposable settingLiteRequestDisposable;

    public TTLiveSettingUtil() {
    }

    public static /* synthetic */ JsonObject a(JsonObject r0, JsonObject r1) {
        return lambda$updateSettingsV2$0(r0, r1);
    }

    public static /* synthetic */ void b(Throwable r0) {
        lambda$updateSettingsV2FromFrontier$5(r0);
    }

    public static /* synthetic */ void c(Throwable r0) {
        lambda$requestLite$7(r0);
    }

    public static /* synthetic */ void d(Context r0, JsonObject r1) {
        lambda$updateSettingsV2$1(r0, r1);
    }

    public static /* synthetic */ void e(Boolean r0) {
        lambda$updateSettingsV2FromFrontier$4(r0);
    }

    public static /* synthetic */ void f(Throwable r0) {
        lambda$updateSettingsV2$2(r0);
    }

    public static /* synthetic */ void g(Response r0) {
        lambda$requestLite$6(r0);
    }

    public static /* synthetic */ Boolean h(JsonObject r0) {
        return lambda$updateSettingsV2FromFrontier$3(r0);
    }

    private static /* synthetic */ void lambda$updateSettingsV2FromFrontier$4(Boolean r0) throws Exception {
    }

    public static void setLocalTest(boolean r0) {
    }

    public static Map<String, String> getSettingExtraParams() {
        if (tb1.c.a == true) goto L5;
        HashMap r0 = new HashMap(f7.b());
        boolean r1 = PadConfigUtils.a();
        if (r1 == false) goto L9;
        String r2 = "true";
    L10:
        r0.put("is_pad", r2);
        if (r1 == false) goto L13;
        String r3 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L14:
        r0.put("is_android_pad", r3);
        return r0;
    L13:
        r3 = "0";
        goto L14
    L9:
        r2 = "false";
        goto L10
    L5:
        return f7.b();
    }

    private static void lambda$requestLite$6(Response r3) throws Exception {
        if (((BaseResponse) r3).statusCode != 0) goto L27;
        JsonObject r0 = (JsonObject) ((BaseResponse) r3).data;
        String r4 = ((BaseResponse) r3).logId;
        JsonObject r1 = a7.a;
        Intrinsics.checkNotNullParameter(r4, "logId");
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.has("_setting_extra") == true) goto L25;
    L17:
        ILiveRoomService r5 = jc1.k.f(ILiveRoomService.class);
        if (r5 == null) goto L20;
        boolean r6 = r5.inLivingRoom();
    L21:
        if (r6 == true) goto L23;
        e7.a("direct update setting lite, in living room: " + r6);
        updateSettingsV2FromFrontier(r0);
        return;
    L23:
        a7.a = r0;
        return;
    L20:
        r6 = false;
        goto L21
    L25:
        JsonElement r2 = r0.get("_setting_extra");     // Catch: IllegalStateException -> L16
        if (r2 == null) goto L17;
        JsonObject r7 = r2.getAsJsonObject();     // Catch: IllegalStateException -> L16
        if (TextUtils.isEmpty(r4) == true) goto L17;
        r7.addProperty("log_id", r4);     // Catch: IllegalStateException -> L16
        goto L17
    }

    private static /* synthetic */ void lambda$requestLite$7(Throwable r2) throws Exception {
        if (r2 == null) goto L4;
        e7.a("request lite error: " + r2.getMessage());
        return;
    L4:
        e7.a("request lite error: unknown");
    }

    private static /* synthetic */ void lambda$updateSettingsV2$2(Throwable r8) throws Exception {
        d7.a("update_annie_failed", r8);
        a70.c.a(1, "incr", "clod", 0L, 0, 0, "update数据" + r8.getCause());
    }

    private static Boolean lambda$updateSettingsV2FromFrontier$3(JsonObject r4) throws Exception {
        JsonElement r0 = r4.get("_setting_extra");
        if (r0 == null) goto L20;
        if (r0.isJsonObject() == false) goto L20;
        SharedPreferences r1 = f7.a;
        JsonObject r2 = r0.getAsJsonObject();
        if (r2 != null) goto L10;
    L11:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L20;
        e7.a("update setting v2 from frontier, setting extra: " + r0);
        JsonObject r5 = r0.getAsJsonObject();
        w60.b r6 = SettingIncStrategy.a;
        boolean r7 = SettingIncStrategy.b(SettingIncStrategy.IncScene.FRONTIER, r4, r5);
        e7.a("update setting v2, result: " + r7 + " thread = " + ThreadMethodProxy.currentThread().getId());
        if (r7 == false) goto L18;
        f7.d(r5);
        a7.a(r5, "lite");
    L18:
        return Boolean.valueOf(r7);
    L10:
        if (r2.has("setting_update_mode") == false) goto L11;
        r3 = TextUtils.equals("incr", r2.get("setting_update_mode").getAsString());
    L20:
        return Boolean.FALSE;
    }

    private static /* synthetic */ void lambda$updateSettingsV2FromFrontier$5(Throwable r8) throws Exception {
        d7.a("updateSettingsV2FromFrontier failed", r8);
        a70.c.a(1, "incr", "frontier", 0L, 0, 0, "update数据");
    }

    public static void requestLite(Map<String, String> r2) {
        Disposable r0 = settingLiteRequestDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
        settingLiteRequestDisposable = null;
    L5:
        settingLiteRequestDisposable = ((ISettingApi) com.bytedance.android.live.network.c.b().e(ISettingApi.class)).settingLite(f7.b(), r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new n7(), new o7());
    }

    public static void updateSettingsV2FromFrontier(final JsonObject r2) {
        Observable.fromCallable(new h7(r2)).subscribeOn(Schedulers.io()).subscribe(new i7(), new j7());
    }

    private static void copySetingToOuter(SharedPreferences.Editor r2, JsonObject r3) {
        if (r2 == null) goto L114;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.get("live_fresco_config_key") == null) goto L8;
        r2.putString("live_fresco_config_key", r3.get("live_fresco_config_key").toString());
    L10:
        if (r3.get("live_fresco_webp_frame_align_opt") == null) goto L12;
        r2.putInt("live_fresco_webp_frame_align_opt", r3.get("live_fresco_webp_frame_align_opt").getAsInt());
    L14:
        if (r3.get("live_sdk_init_duration_opt_v2") == null) goto L16;
        r2.putString("live_sdk_init_duration_opt_v2", r3.get("live_sdk_init_duration_opt_v2").toString());
    L18:
        if (r3.get("live_equal_talk_room_top_margin_ratio") == null) goto L20;
        r2.putFloat("live_equal_talk_room_top_margin_ratio", r3.get("live_equal_talk_room_top_margin_ratio").getAsFloat());
    L22:
        if (r3.get("webcast_monitor_config") == null) goto L24;
        r2.putString("webcast_monitor_config", r3.get("webcast_monitor_config").toString());
    L26:
        if (r3.get("live_webview_use_monitor") == null) goto L28;
        r2.putBoolean("live_webview_use_monitor", r3.get("live_webview_use_monitor").getAsBoolean());
    L30:
        if (r3.get("tt_live_webview_monitor_config_slardar_android") == null) goto L32;
        r2.putString("tt_live_webview_monitor_config_slardar_android", r3.get("tt_live_webview_monitor_config_slardar_android").toString());
    L34:
        if (r3.get("cj_schema_risk_info_hosts") == null) goto L36;
        r2.putString("cj_schema_risk_info_hosts", r3.get("cj_schema_risk_info_hosts").toString());
    L38:
        if (r3.get("live_performance_setting") == null) goto L40;
        r2.putString("live_performance_setting", r3.get("live_performance_setting").toString());
    L42:
        if (r3.get("live_performance_resource_config") == null) goto L44;
        r2.putString("live_performance_resource_config", r3.get("live_performance_resource_config").toString());
    L46:
        if (r3.get("ttlive_pad_setting_mock") == null) goto L48;
        r2.putInt("ttlive_pad_setting_mock", r3.get("ttlive_pad_setting_mock").getAsInt());
    L50:
        if (r3.get("ttlive_pad_opt_disable_control") == null) goto L52;
        r2.putBoolean("ttlive_pad_opt_disable_control", r3.get("ttlive_pad_opt_disable_control").getAsBoolean());
    L54:
        if (r3.get("live_gift_panel_style") == null) goto L56;
        r2.putInt("live_gift_panel_style", r3.get("live_gift_panel_style").getAsInt());
    L58:
        if (r3.get("enable_record_download_info") == null) goto L60;
        r2.putBoolean("enable_record_download_info", r3.get("enable_record_download_info").getAsBoolean());
    L62:
        if (r3.get("live_enable_pull_stream_so_plugin") == null) goto L64;
        r2.putBoolean("live_enable_pull_stream_so_plugin", r3.get("live_enable_pull_stream_so_plugin").getAsBoolean());
    L66:
        if (r3.get("live_enable_download_bmf_so_plugin") == null) goto L68;
        r2.putBoolean("live_enable_download_bmf_so_plugin", r3.get("live_enable_download_bmf_so_plugin").getAsBoolean());
    L70:
        if (r3.get("live_skin_pull_times_every_day") == null) goto L72;
        r2.putInt("live_skin_pull_times_every_day", r3.get("live_skin_pull_times_every_day").getAsInt());
    L74:
        if (r3.get("live_ai_config") == null) goto L76;
        r2.putString("live_ai_config", r3.get("live_ai_config").toString());
    L78:
        if (r3.get("live_feature_config") == null) goto L80;
        r2.putString("live_feature_config", r3.get("live_feature_config").toString());
    L82:
        if (r3.get("live_enable_setting_monitor") == null) goto L84;
        r2.putBoolean("live_enable_setting_monitor", r3.get("live_enable_setting_monitor").getAsBoolean());
    L86:
        if (r3.get("live_logsdk_config") == null) goto L88;
        r2.putString("live_logsdk_config", r3.get("live_logsdk_config").toString());
    L90:
        if (r3.get("live_log_sdk_spm_black_list") == null) goto L92;
        r2.putString("live_log_sdk_spm_black_list", r3.get("live_log_sdk_spm_black_list").toString());
    L94:
        if (r3.get("live_io_pre_start") == null) goto L96;
        r2.putBoolean("live_io_pre_start", r3.get("live_io_pre_start").getAsBoolean());
    L98:
        if (r3.get("live_enable_host_reflect_opt") == null) goto L100;
        r2.putBoolean("live_enable_host_reflect_opt", r3.get("live_enable_host_reflect_opt").getAsBoolean());
    L102:
        if (r3.get("live_audio_and_video_privacy_config") == null) goto L104;
        r2.putString("live_audio_and_video_privacy_config", r3.get("live_audio_and_video_privacy_config").toString());
    L106:
        if (r3.get("live_stream_strategy_sdk_enable") == null) goto L108;
        r2.putInt("live_stream_strategy_sdk_enable", r3.get("live_stream_strategy_sdk_enable").getAsInt());
    L110:
        if (r3.get("live_lite_enable_plugin_env_load") == null) goto L112;
        r2.putBoolean("live_lite_enable_plugin_env_load", r3.get("live_lite_enable_plugin_env_load").getAsBoolean());
        return;
    L112:
        r2.remove("live_lite_enable_plugin_env_load");
        return;
    L108:
        r2.remove("live_stream_strategy_sdk_enable");
        goto L110
    L104:
        r2.remove("live_audio_and_video_privacy_config");
        goto L106
    L100:
        r2.remove("live_enable_host_reflect_opt");
        goto L102
    L96:
        r2.remove("live_io_pre_start");
        goto L98
    L92:
        r2.remove("live_log_sdk_spm_black_list");
        goto L94
    L88:
        r2.remove("live_logsdk_config");
        goto L90
    L84:
        r2.remove("live_enable_setting_monitor");
        goto L86
    L80:
        r2.remove("live_feature_config");
        goto L82
    L76:
        r2.remove("live_ai_config");
        goto L78
    L72:
        r2.remove("live_skin_pull_times_every_day");
        goto L74
    L68:
        r2.remove("live_enable_download_bmf_so_plugin");
        goto L70
    L64:
        r2.remove("live_enable_pull_stream_so_plugin");
        goto L66
    L60:
        r2.remove("enable_record_download_info");
        goto L62
    L56:
        r2.remove("live_gift_panel_style");
        goto L58
    L52:
        r2.remove("ttlive_pad_opt_disable_control");
        goto L54
    L48:
        r2.remove("ttlive_pad_setting_mock");
        goto L50
    L44:
        r2.remove("live_performance_resource_config");
        goto L46
    L40:
        r2.remove("live_performance_setting");
        goto L42
    L36:
        r2.remove("cj_schema_risk_info_hosts");
        goto L38
    L32:
        r2.remove("tt_live_webview_monitor_config_slardar_android");
        goto L34
    L28:
        r2.remove("live_webview_use_monitor");
        goto L30
    L24:
        r2.remove("webcast_monitor_config");
        goto L26
    L20:
        r2.remove("live_equal_talk_room_top_margin_ratio");
        goto L22
    L16:
        r2.remove("live_sdk_init_duration_opt_v2");
        goto L18
    L12:
        r2.remove("live_fresco_webp_frame_align_opt");
        goto L14
    L8:
        r2.remove("live_fresco_config_key");
        goto L10
    }

    private static JsonObject lambda$updateSettingsV2$0(JsonObject r5, JsonObject r6) throws Exception {
        e7.a("update setting v2 from cold launch");
        w60.b r0 = SettingIncStrategy.a;
        e7.a("update setting v2, result: " + SettingIncStrategy.b(SettingIncStrategy.IncScene.COLD_LAUNCH, r5, r6) + " thread = " + ThreadMethodProxy.currentThread().getId());
        f7.d(r6);
        a7.a(r6, "cold_launch");
        e7.a("update annie setting");
        int r7 = e6.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L11
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (com.bytedance.android.livesdk.config.setting.w.a.a() == 0) goto L6;
        boolean r9 = true;
    L7:
        if (r9 == false) goto L9;
        e6.a();     // Catch: Throwable -> L11
    L9:
        h0.a.getValue();     // Catch: Throwable -> L11
        an.a.getValue();     // Catch: Throwable -> L11
        e81.g.getValue();     // Catch: Throwable -> L11
        ac.a.getValue();     // Catch: Throwable -> L11
        fa.a.getValue();     // Catch: Throwable -> L11
        bg0.a.getValue();     // Catch: Throwable -> L11
        ea.a.getValue();     // Catch: Throwable -> L11
        ca.a.getValue();     // Catch: Throwable -> L11
        com.bytedance.android.livesdk.config.b1.a.getValue();     // Catch: Throwable -> L11
        df.a.getValue();     // Catch: Throwable -> L11
        ia.a.getValue();     // Catch: Throwable -> L11
        mc0.a.getValue();     // Catch: Throwable -> L11
        y6.a.getValue();     // Catch: Throwable -> L11
        kg1.a.getValue();     // Catch: Throwable -> L11
        LiveInfraSettingKeys.LIVE_PLAYER_MONITOR_LOG.getValue();     // Catch: Throwable -> L11
        wf0.a.getValue();     // Catch: Throwable -> L11
        LiveInfraSettingKeys.PLAYER_CONFIG.getValue();     // Catch: Throwable -> L11
        pg1.a.getValue();     // Catch: Throwable -> L11
        in.a.getValue();     // Catch: Throwable -> L11
        LiveInfraSettingKeys.LIVE_PLAYER_DISABLE_TEXTURE_RENDER_CONFIG.getValue();     // Catch: Throwable -> L11
        gj0.a.getValue();     // Catch: Throwable -> L11
        z7.a.getValue();     // Catch: Throwable -> L11
        b01.a.getValue();     // Catch: Throwable -> L11
        f70.a.getValue();     // Catch: Throwable -> L11
        LiveInfraSettingKeys.PLAYER_SPM_LOGGER.getValue();     // Catch: Throwable -> L11
        e81.a.getValue();     // Catch: Throwable -> L11
        ka.a.getValue();     // Catch: Throwable -> L11
        pi0.a.getValue();     // Catch: Throwable -> L11
        LiveInfraSettingKeys.LIVE_PLAYER_BLACK_SCREEN_MONITOR_CONFIG.getValue();     // Catch: Throwable -> L11
        com.bytedance.android.live.core.tetris.widgets.d.f();     // Catch: Throwable -> L11
        hz.a.getValue();     // Catch: Throwable -> L11
        j0.a.getValue();     // Catch: Throwable -> L11
        t10.a.getValue();     // Catch: Throwable -> L11
        ALogger.i("LiveSettingPreloadUtils", "preloadSetting cost = " + (System.currentTimeMillis() - r1));     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        return (JsonObject) GsonProtectorUtils.fromJson(GsonHelper.get(), GsonProtectorUtils.toJson(GsonHelper.get(), SettingIncStrategy.a.c()), JsonObject.class);
    L6:
        r9 = false;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private static /* synthetic */ void lambda$updateSettingsV2$1(Context r2, JsonObject r3) throws Exception {
        Annie.getService(y9.o.class, "webcast").x1(r2, r3);
    }

    public static void updateSettings(Context r3, JsonObject r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L23;
        JsonElement r0 = r4.get("setting_degrade_flag");
        if (r0 != null) goto L25;
    L13:
        JsonElement r1 = r4.get("_setting_extra");
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.isJsonObject() == true) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty("update setting v2") == true) goto L21;
        d6.c("SettingGuard", "update setting v2");
    L21:
        f7.c();
        updateSettingsV2(r3, r4, r1.getAsJsonObject());
        return;
    L25:
        if (r0.isJsonPrimitive() == false) goto L13;
        if (r0.getAsInt() != 1) goto L13;
        return;
    L23:
        d7.a("updateSettings; context or setting is empty", null);
    }

    public static void updateSettingsV2(final Context r3, final JsonObject r4, final JsonObject r5) {
        LiveInitAssistant r0 = LiveInitAssistant.INSTANCE;
        if (r0.isInitFinish() == true) goto L6;
        r0.markInfo("update_setting_in_init", "true");
    L6:
        if (((Boolean) rr0.a.getValue()).booleanValue() == true) goto L10;
        Observable.fromCallable(new k7(r4, r5)).subscribeOn(Schedulers.io()).subscribe(new l7(r3), new m7());
        return;
    }
}
