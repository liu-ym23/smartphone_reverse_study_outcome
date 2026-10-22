package com.bytedance.android.live.platformplayer.init;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.bytedance.android.annie.resource.m;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.setting.a4;
import com.bytedance.android.live.core.setting.a5;
import com.bytedance.android.live.core.setting.g7;
import com.bytedance.android.live.core.setting.m0;
import com.bytedance.android.live.core.setting.u3;
import com.bytedance.android.live.core.setting.u5;
import com.bytedance.android.live.core.setting.v3;
import com.bytedance.android.live.core.setting.y6;
import com.bytedance.android.live.core.setting.z4;
import com.bytedance.android.live.core.utils.rxutils.StreamDataUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig;
import com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.ea;
import com.bytedance.android.livesdk.config.h2;
import com.bytedance.android.livesdk.config.lp0;
import com.bytedance.android.livesdk.config.n81;
import com.bytedance.android.livesdk.config.p3;
import com.bytedance.android.livesdk.config.tt0;
import com.bytedance.android.livesdk.config.w0;
import com.bytedance.android.livesdk.config.w51;
import com.bytedance.android.livesdk.config.wh0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.player.c0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.host.HostDataKey;
import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.host.ILivePlayerNetwork;
import com.bytedance.android.livesdkapi.model.LiveDynamicSRConfig;
import com.bytedance.android.livesdkapi.model.LivePlayerHostFlavor;
import com.bytedance.android.livesdkapi.model.NewPlayerTrafficMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerApplogConfig;
import com.bytedance.android.livesdkapi.model.PlayerBlackScreenMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerDnsOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderConfig;
import com.bytedance.android.livesdkapi.model.PlayerFeatureConfig;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.bytedance.android.livesdkapi.model.PlayerLivePlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerModularizationConfig;
import com.bytedance.android.livesdkapi.model.PlayerMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerNetAdapterConfig;
import com.bytedance.android.livesdkapi.model.PlayerOffScreenRenderConfig;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerShareConfig;
import com.bytedance.android.livesdkapi.model.PlayerSpmLoggerConfig;
import com.bytedance.android.livesdkapi.model.PlayerSurfaceRenderConfig;
import com.bytedance.android.livesdkapi.model.PlayerTextureRenderConfig;
import com.bytedance.android.livesdkapi.model.PlayerTraceLogData;
import com.bytedance.android.livesdkapi.model.PlayerTraceMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerTrafficMonitorConfig;
import com.bytedance.android.livesdkapi.model.SettingsExtraInfo;
import com.bytedance.android.livesdkapi.model.SurfaceViewSmoothConfig;
import com.bytedance.android.livesdkapi.performance.IPowerPerfManager;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveBusiness;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerBusiness;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.android.livesdkapi.service.ILibraryService;
import com.bytedance.android.livesdkapi.service.ILiveCellularService;
import com.bytedance.android.livesdkapi.service.ILiveNetworkPredict;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.common.applog.AppLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import jta.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wt2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlayerHostServiceImpl implements ILivePlayerHostService {
    public final Lazy a;
    public final Lazy b;

    public final LivePlayerBaseHostService a() {
        return (LivePlayerBaseHostService) this.b.getValue();
    }

    public final String appName() {
        return "";
    }

    public final String appRegion() {
        return "";
    }

    public final float deviceScore() {
        return z0.b(false);
    }

    public final String tobLicenseDir() {
        return "";
    }

    public final void updateSetting() {
    }

    public final ILivePlayerALogger alog() {
        so2.a r0 = so2.a.d;
        if (so2.a.c.getEnableNewLog() == false) goto L6;
        return r0;
    L6:
        return (a) a().b.getValue();
    }

    public final int audienceCount() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L12;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L12;
        DataCenter r2 = r1.getDataCenter();
        if (r2 == null) goto L12;
        Integer r3 = (Integer) r2.get("data_member_count");
        if (r3 == null) goto L12;
        return r3.intValue();
    L12:
        return 0;
    }

    public final void doJatoBigCore() {
        IPowerPerfManager r0 = k.f(IPowerPerfManager.class);
        if (r0 == null) goto L6;
        r0.doJatoBigCore();
        return;
    }

    public final void doJatoRestCore() {
        IPowerPerfManager r0 = k.f(IPowerPerfManager.class);
        if (r0 == null) goto L6;
        r0.doJatoRestCore();
        return;
    }

    public final <T extends IPlayerBusiness> HashMap<Class<T>, T> getBusiness() {
        if (((PlayerInnerDrawerConfig) y6.a.getValue()).getFixPaidLifeCycleError() == false) goto L6;
        HashMap<Class<T>, T> r0 = new HashMap();
        r0.put(IPaidLiveBusiness.class, new c0());
        return r0;
    L6:
        HashMap<Class<T>, T> r1 = new HashMap();
        r1.put(IPaidLiveBusiness.class, new c0());
        Unit r2 = Unit.INSTANCE;
        return r1;
    }

    public final String getGeckoRootDirPath() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(b(m.c()));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L11;
        r1 = b("");
    L11:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean shouldResetVrEnable() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L50;
        Object r5 = null;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L51;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L52;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 != null) goto L11;
        return false;
    L11:
        if (RoomKt.hasMultiCamera(r3) == true) goto L13;
        return false;
    L13:
        IBaseStreamUrl r4 = r3.getStreamUrl();
        if (r4 != null) goto L16;
    L17:
        IBaseStreamUrl r6 = r3.getStreamUrl();
        if (r6 != null) goto L20;
    L22:
        IEpisodeExtraInfo r7 = r3.getEpisodeComponentData();
        if (r7 == null) goto L42;
        List r8 = r7.getCameraInfos();
        if (r8 == null) goto L42;
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L41;
        Object r10 = r9.next();
        IVSCameraInfo r11 = (IVSCameraInfo) r10;
        IBaseStreamUrl r12 = r11.getStreamUrl();
        if (r12 != null) goto L32;
    L33:
        IBaseStreamUrl r13 = r11.getStreamUrl();
        if (r13 != null) goto L36;
    L38:
        boolean r14 = false;
    L39:
        if (r14 == false) goto L28;
        r5 = r10;
        goto L41
    L36:
        if (r13.getVrType() != 2) goto L38;
    L37:
        r14 = true;
        goto L39
    L32:
        if (r12.getVrType() == 1) goto L37;
    L41:
        r5 = (IVSCameraInfo) r5;
    L42:
        if (r5 == null) goto L54;
        return true;
    L54:
        return false;
    L20:
        if (r6.getVrType() != 2) goto L22;
    L21:
        return true;
    L16:
        if (r4.getVrType() == 1) goto L21;
    L52:
        return false;
    L51:
        return false;
    L50:
        return false;
    }

    public LivePlayerHostServiceImpl() {
        this.a = LazyKt.lazy(LivePlayerHostServiceImpl$monitorService$2.INSTANCE);
        this.b = LazyKt.lazy(LivePlayerHostServiceImpl$basePlayerService$2.INSTANCE);
        new HashMap();
    }

    public final int appId() {
        a().getClass();
        boolean r0 = AppLog.L;
        return g.c();
    }

    public final String appLogServerDeviceID() {
        a().getClass();
        String r0 = AppLog.v();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String channel() {
        a().getClass();
        return k.n(IMiddleWareHostContext.class).getChannel();
    }

    public final Context context() {
        a().getClass();
        IMiddleWareHostContext r0 = k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L7;
        Context r1 = r0.context();
        if (r1 == null) goto L7;
        return r1.getApplicationContext();
    L7:
        return null;
    }

    public final String currentUserId() {
        a().getClass();
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        e r1 = r0.user();
        if (r1 == null) goto L8;
        String r2 = r1.n();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final boolean enableLiveIO() {
        a().getClass();
        Integer r0 = (Integer) p3.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public final xu1.a getColorWeakModelEffectInfo() {
        a().getClass();
        IMiddlewareHostAction r0 = k.f(IMiddlewareHostAction.class);
        if (r0 == null) goto L7;
        r0.getColorWeakModelEffectInfo();
        return null;
    L7:
        return null;
    }

    public final LivePlayerHostFlavor hostFlavor() {
        a().getClass();
        return LivePlayerHostFlavor.SAAS;
    }

    public final boolean isFoldScreen() {
        return FoldScreenUtils.f();
    }

    public final boolean isFreeFlow() {
        a().getClass();
        IMiddleHostService r0 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r0 == null) goto L9;
        IMiddlewareHostConfig r1 = r0.config();
        if (r1 == null) goto L9;
        IMiddlewareHostAppConfig r2 = r1.appConfig();
        if (r2 == null) goto L9;
        return r2.isFreeFlow();
    L9:
        return false;
    }

    public final boolean isLocalTest() {
        a().getClass();
        return v.a();
    }

    public final boolean isPad() {
        a().getClass();
        return PadConfigUtils.a();
    }

    public final ILivePlayerNetwork livePlayerNetwork() {
        return (d) a().c.getValue();
    }

    public final Map<String, String> nqeParams() {
        a().getClass();
        IMiddlewareHostApp r0 = k.f(IMiddlewareHostApp.class);
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.getNQEParams();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new HashMap();
    }

    public final int updateVersionCode() {
        a().getClass();
        return k.n(IMiddleWareHostContext.class).getUpdateVersionCode();
    }

    public final String versionName() {
        a().getClass();
        return k.n(IMiddleWareHostContext.class).getVersionName();
    }

    public final String b(String r11) {
        a().getClass();
        IMiddleWareHostContext r0 = k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L7;
        Context r1 = r0.context();
        if (r1 == null) goto L7;
        Context r2 = r1.getApplicationContext();
    L8:
        if (r2 != null) goto L10;
    L24:
        return "";
    L10:
        if (r11.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        r11 = r2.getFilesDir().getAbsolutePath() + File.separator + "offlineX/";
    L15:
        String r4 = File.separator;
        if (StringsKt.endsWith$default(r11, r4, false, 2, null) == true) goto L18;
        r11 = r11 + r4;
    L18:
        int r5 = StringsKt.indexOf$default(r11, r2.getPackageName(), 0, false, 6, null);
        if (r5 >= 1) goto L21;
    L23:
        if (r11 == null) goto L24;
        return r11;
    L21:
        if (r5 >= r11.length()) goto L23;
        r11 = r11.substring(r5 - 1);
        goto L23
    L12:
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final long dnsDelayLoadTime(String r3) {
        Intrinsics.checkNotNullParameter(r3, "apiName");
        a().getClass();
        Intrinsics.checkNotNullParameter(r3, "apiName");
        IMiddlewareHostApp r0 = k.f(IMiddlewareHostApp.class);
        if (r0 == null) goto L7;
        Long r4 = r0.getDelayTimeDirect(r3);
        if (r4 == null) goto L7;
        return r4.longValue();
    L7:
        return 0;
    }

    public final void doJatoBoostCpu(long r2) {
        IPowerPerfManager r0 = k.f(IPowerPerfManager.class);
        if (r0 == null) goto L6;
        r0.doJatoBoostCpu(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, com.bytedance.android.livesdkapi.model.LiveDynamicSRConfig] */
    public final <T> T getConfig(Class<T> r25) {
        Intrinsics.checkNotNullParameter(r25, "type");
        if (Intrinsics.areEqual(r25, PlayerOptimizeConfig.class) == false) goto L9;
        Object r0 = LiveInfraSettingKeys.LIVE_PLAYER_OPTIMIZE_CONFIG.getValue();
        boolean r1 = r0 instanceof Object;
        Object r2 = r0;
        if (r1 == true) goto L140;
        return null;
    L140:
        return (T) r2;
    L9:
        if (Intrinsics.areEqual(r25, PlayerBlackScreenMonitorConfig.class) == false) goto L14;
        Object r3 = LiveInfraSettingKeys.LIVE_PLAYER_BLACK_SCREEN_MONITOR_CONFIG.getValue();
        boolean r4 = r3 instanceof Object;
        r2 = r3;
        if (r4 == true) goto L140;
        return null;
    L14:
        if (Intrinsics.areEqual(r25, PlayerTrafficMonitorConfig.class) == false) goto L19;
        Object r5 = LiveInfraSettingKeys.LIVE_PLAYER_TRAFFIC_MONITOR_CONFIG.getValue();
        boolean r6 = r5 instanceof Object;
        r2 = r5;
        if (r6 == true) goto L140;
        return null;
    L19:
        if (Intrinsics.areEqual(r25, PlayerFeatureConfig.class) == false) goto L24;
        Object r7 = LiveInfraSettingKeys.LIVE_PLAYER_FEATURE_CONFIG.getValue();
        boolean r8 = r7 instanceof Object;
        r2 = r7;
        if (r8 == true) goto L140;
        return null;
    L24:
        if (Intrinsics.areEqual(r25, PlayerMonitorConfig.class) == false) goto L29;
        Object r9 = LiveInfraSettingKeys.LIVE_PLAYER_MONITOR_LOG.getValue();
        boolean r10 = r9 instanceof Object;
        r2 = r9;
        if (r10 == true) goto L140;
        return null;
    L29:
        if (Intrinsics.areEqual(r25, PlayerConfig.class) == false) goto L34;
        Object r11 = LiveInfraSettingKeys.PLAYER_CONFIG.getValue();
        boolean r12 = r11 instanceof Object;
        r2 = r11;
        if (r12 == true) goto L140;
        return null;
    L34:
        if (Intrinsics.areEqual(r25, PlayerModularizationConfig.class) == false) goto L39;
        Object r13 = LiveInfraSettingKeys.PLAYER_MODULARIZATION_CONFIG.getValue();
        boolean r14 = r13 instanceof Object;
        r2 = r13;
        if (r14 == true) goto L140;
        return null;
    L39:
        if (Intrinsics.areEqual(r25, PlayerShareConfig.class) == false) goto L44;
        Object r15 = LiveInfraSettingKeys.LIVE_PLAYER_SHARE_CONFIG_NEW.getValue();
        boolean r16 = r15 instanceof Object;
        r2 = r15;
        if (r16 == true) goto L140;
        return null;
    L44:
        if (Intrinsics.areEqual(r25, PlayerSpmLoggerConfig.class) == false) goto L48;
        Object r17 = LiveInfraSettingKeys.PLAYER_SPM_LOGGER.getValue();
        boolean r18 = r17 instanceof Object;
        r2 = r17;
        if (r18 == true) goto L140;
        return null;
    L48:
        boolean r19 = false;
        if (Intrinsics.areEqual(r25, PlayerDnsOptimizeConfig.class) == false) goto L58;
        Map r20 = g7.a;
        Class r21 = Integer.TYPE;
        Intrinsics.checkNotNull(r21);
        int r22 = ((Number) g7.a("dns_opt_method", r21, -1)).intValue();
        if (r22 != (-1)) goto L54;
        r22 = ((Number) LiveInfraSettingKeys.DNS_OPT_METHOD.getValue()).intValue();
    L54:
        if (r22 != 1) goto L141;
        r19 = true;
    L141:
        return (T) new PlayerDnsOptimizeConfig(r19, ((Boolean) LiveInfraSettingKeys.DNS_OPT_FREE_FLOW_ENABLE.getValue()).booleanValue());
    L58:
        if (Intrinsics.areEqual(r25, PlayerNetAdapterConfig.class) == false) goto L61;
        return (T) new PlayerNetAdapterConfig(((Boolean) LiveInfraSettingKeys.LIVE_NET_ADAPTIVE_ENABLE.getValue()).booleanValue(), ((Number) LiveInfraSettingKeys.LIVE_NET_ADAPTIVE_HURRY_SPEED.getValue()).floatValue(), ((Number) LiveInfraSettingKeys.LIVE_NET_ADAPTIVE_HURRY_TIME.getValue()).intValue(), ((Number) LiveInfraSettingKeys.LIVE_NET_ADAPTIVE_SLOW_SPEED.getValue()).floatValue(), ((Number) LiveInfraSettingKeys.LIVE_NET_ADAPTIVE_SLOW_TIME.getValue()).intValue());
    L61:
        if (Intrinsics.areEqual(r25, PlayerSurfaceRenderConfig.class) == false) goto L70;
        boolean r23 = h.d();
        boolean r24 = h.c();
        boolean r26 = h.f();
        if (h.a() == true) goto L65;
    L67:
        boolean r27 = false;
    L143:
        return (T) new PlayerSurfaceRenderConfig(r23, r24, r26, r27, false, false, 48, null);
    L65:
        if (((n81) tt0.a.getValue()).mCheckAbnormalCase == false) goto L67;
        r27 = true;
        goto L143
    L70:
        if (Intrinsics.areEqual(r25, w0.class) == false) goto L75;
        Object r28 = LiveInfraSettingKeys.LIVE_BROADCAST_PAUSE_NEW_STYLE.getValue();
        boolean r29 = r28 instanceof Object;
        r2 = r28;
        if (r29 == true) goto L140;
        return null;
    L75:
        if (Intrinsics.areEqual(r25, LiveDynamicSRConfig.class) == false) goto L78;
        ?? r30 = (T) new LiveDynamicSRConfig();
        r30.setPreviewEnableSr(((Boolean) a4.a.getValue()).booleanValue());
        return r30;
    L78:
        if (Intrinsics.areEqual(r25, PlayerLivePlayerConfig.class) == false) goto L109;
        Integer r31 = (Integer) LiveInfraSettingKeys.LIVE_HARDWARD_DECODE_H264_ENABLE.getValue();
        if (r31 != null) goto L83;
    L85:
        boolean r32 = false;
    L86:
        Integer r33 = (Integer) LiveInfraSettingKeys.LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE.getValue();
        if (r33 != null) goto L90;
    L92:
        boolean r34 = false;
    L93:
        Integer r35 = (Integer) LiveInfraSettingKeys.LIVE_SDK_NTP_ENABLE.getValue();
        if (r35 != null) goto L97;
    L99:
        boolean r36 = false;
    L100:
        Integer r37 = (Integer) LiveInfraSettingKeys.LIVE_SDK_FAST_OPEN_DISABLE.getValue();
        if (r37 != null) goto L104;
    L106:
        boolean r38 = false;
    L145:
        return (T) new PlayerLivePlayerConfig(r32, r34, r36, r38, false, ((Boolean) LiveInfraSettingKeys.ENABLE_LIVE_HTTPK_DEGRADE.getValue()).booleanValue(), false, false, false, ((Boolean) LiveInfraSettingKeys.LIVE_SDK_TFO_PRECONNECT_ENABLE.getValue()).booleanValue(), 0, 0, false, false, false, 0, 64960, null);
    L104:
        if (r37.intValue() != 0) goto L106;
        r38 = true;
        goto L145
    L97:
        if (r35.intValue() != 1) goto L99;
        r36 = true;
        goto L100
    L90:
        if (r33.intValue() != 1) goto L92;
        r34 = true;
        goto L93
    L83:
        if (r31.intValue() != 1) goto L85;
        r32 = true;
        goto L86
    L109:
        if (Intrinsics.areEqual(r25, PlayerExtraRenderConfig.class) == false) goto L114;
        Object r39 = LiveInfraSettingKeys.LIVE_PLAYER_EXTRA_RENDER_CONFIG.getValue();
        boolean r40 = r39 instanceof Object;
        r2 = r39;
        if (r40 == true) goto L140;
        return null;
    L114:
        if (Intrinsics.areEqual(r25, PlayerOffScreenRenderConfig.class) == false) goto L117;
        SettingKey r41 = LiveInfraSettingKeys.LIVE_PLAYER_DISABLE_TEXTURE_RENDER_CONFIG;
        return (T) new PlayerOffScreenRenderConfig(((PlayerTextureRenderConfig) r41.getValue()).enableDynamicOpen, ((PlayerTextureRenderConfig) r41.getValue()).enableCustom);
    L117:
        if (Intrinsics.areEqual(r25, SurfaceViewSmoothConfig.class) == false) goto L120;
        return (T) new SurfaceViewSmoothConfig(((Boolean) LiveInfraSettingKeys.SUPPORT_SURFACE_SMOOTH_ENTER.getValue()).booleanValue());
    L120:
        if (Intrinsics.areEqual(r25, PlayerApplogConfig.class) == false) goto L129;
        PlayerApplogConfig r42 = (PlayerApplogConfig) LiveInfraSettingKeys.LIVE_PLAYER_APPLOG_CONFIG.getValue();
        if (r42 == null) goto L124;
        r42.setAudiencePlayerInternalUseAppLog(((Boolean) LiveInfraSettingKeys.LIVE_SETTING_APPLOG_KEY.getValue()).booleanValue());
        PlayerApplogConfig r43 = r42;
    L125:
        boolean r44 = r43 instanceof Object;
        r2 = r43;
        if (r44 == true) goto L140;
        return null;
    L124:
        r43 = null;
        goto L125
    L129:
        if (Intrinsics.areEqual(r25, PlayerTraceMonitorConfig.class) == false) goto L134;
        Object r45 = LiveInfraSettingKeys.LIVE_PLAYER_TRACE_CONFIG.getValue();
        boolean r46 = r45 instanceof Object;
        r2 = r45;
        if (r46 == true) goto L140;
        return null;
    L134:
        if (Intrinsics.areEqual(r25, NewPlayerTrafficMonitorConfig.class) == false) goto L138;
        Object r47 = LiveInfraSettingKeys.LIVE_PLAYER_TRAFFIC_MONITOR_CONFIG_NEW.getValue();
        boolean r48 = r47 instanceof Object;
        r2 = r47;
        if (r48 == true) goto L140;
        return null;
    L138:
        ALogger.d("live_player_middle", "get " + r25.getSimpleName() + " config failed");
        return null;
    }

    public final int getDalvikPss(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        c r1 = (c) this.a.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        Map<String, Long> r0 = r1.a(false, false);
        if (r0 == null) goto L8;
        Long r2 = r0.get("mem_pss_dalvik");
        if (r2 != null) goto L7;
        return 0;
    L7:
        return (int) r2.longValue();
    L8:
        return 0;
    }

    public final String getEffectModelFilePath(String r4) {
        Intrinsics.checkNotNullParameter(r4, "modelName");
        boolean r1 = qo2.a.a;
        Intrinsics.checkNotNullParameter(r4, "modelName");
        if (((com.bytedance.android.livesdk.config.setting.m) u3.a.getValue()).b() == false) goto L11;
        qo2.a.a r0 = (qo2.a.a) qo2.a.b.get(r4);
        if (r0 != null) goto L8;
    L9:
        boolean r2 = qo2.a.a;
        qo2.a.b(CollectionsKt.listOf(r4), "getModel");
    L10:
        if (r0 == null) goto L11;
        Pair r5 = new Pair(Integer.valueOf(r0.a), r0.b);
    L13:
        if (r5 != null) goto L15;
    L17:
        if (r5 != null) goto L19;
        return null;
    L19:
        return (String) r5.getSecond();
    L15:
        if (((Number) r5.getFirst()).intValue() != 0) goto L17;
        return null;
    L8:
        if (r0.a != 0) goto L10;
    L11:
        r5 = null;
        goto L13
    }

    public final Object getHostData(HostDataKey r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (b.a[r2.ordinal()] == 1) goto L5;
        return "";
    L5:
        Map r3 = k.n(IMiddlewareHostApp.class).getNQEParams();
        if (r3 == null) goto L10;
        String r4 = (String) r3.get("net_effective_connection_type");
        if (r4 == null) goto L10;
        int r5 = CastIntegerProtector.parseInt(r4);
    L12:
        return Integer.valueOf(r5);
    L10:
        r5 = -1;
        goto L12
    }

    public final JSONObject getStreamDataJsonObject(String r2) {
        Intrinsics.checkNotNullParameter(r2, "streamData");
        return StreamDataUtil.INSTANCE.getStreamDataObject(r2);
    }

    public final int loadLibrary(String r2) {
        Intrinsics.checkNotNullParameter(r2, "shortName");
        ILibraryService r0 = k.f(ILibraryService.class);
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.loadLibrary(r2);
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [T, com.bytedance.android.livesdkapi.model.PlayerSurfaceRenderConfig] */
    /* JADX WARN: Type inference failed for: r4v12, types: [T, com.bytedance.android.livesdkapi.model.PlayerLivePlayerConfig] */
    /* JADX WARN: Type inference failed for: r4v14, types: [T, com.bytedance.android.livesdkapi.model.PlayerDnsOptimizeConfig] */
    /* JADX WARN: Type inference failed for: r4v16, types: [T, com.bytedance.android.livesdkapi.model.PlayerApplogConfig] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, com.bytedance.android.livesdkapi.model.LiveDynamicSRConfig] */
    public final <T> T onGetConfig(T r4) {
        if ((r4 instanceof PlayerApplogConfig) == false) goto L9;
        if (r4 == null) goto L7;
        ?? r5 = (T) ((PlayerApplogConfig) r4);
        r5.setAudiencePlayerInternalUseAppLog(((Boolean) z4.a.getValue()).booleanValue());
        r5.setAudiencePlayerInternalUseAppLogEventMask(((Long) a5.a.getValue()).longValue());
        return r5;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.PlayerApplogConfig");
    L9:
        if ((r4 instanceof PlayerDnsOptimizeConfig) == false) goto L15;
        if (r4 == null) goto L13;
        ?? r6 = (T) ((PlayerDnsOptimizeConfig) r4);
        r6.setFreeFlowEnable(((Boolean) h2.a.getValue()).booleanValue());
        return r6;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.PlayerDnsOptimizeConfig");
    L15:
        if ((r4 instanceof PlayerLivePlayerConfig) == false) goto L20;
        if (r4 == null) goto L19;
        ?? r7 = (T) ((PlayerLivePlayerConfig) r4);
        r7.setRtsPreload(((Boolean) lp0.a.getValue()).booleanValue());
        return r7;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.PlayerLivePlayerConfig");
    L20:
        boolean r1 = true;
        boolean r2 = false;
        if ((r4 instanceof PlayerSurfaceRenderConfig) == false) goto L45;
        if (r4 == null) goto L43;
        ?? r8 = (T) ((PlayerSurfaceRenderConfig) r4);
        r8.setEnableClick(h.d());
        r8.setHasSurfaceRender(h.c());
        r8.setEnableFeed(h.f());
        if (h.a() == true) goto L26;
    L28:
        boolean r0 = false;
    L29:
        r8.setCheckAbnormalCase(r0);
        if (h.a() == true) goto L32;
    L34:
        boolean r3 = false;
    L35:
        r8.setCheckAbnormalCaseAdd(r3);
        if (h.a() == true) goto L38;
    L40:
        r1 = false;
    L41:
        r8.setSurfaceScrollRefactor(r1);
        return r8;
    L38:
        if (((n81) tt0.a.getValue()).surfaceScrollRefactor == false) goto L40;
    L32:
        if (((n81) tt0.a.getValue()).isCheckAbnormalCaseAdd == false) goto L34;
        r3 = true;
        goto L35
    L26:
        if (((n81) tt0.a.getValue()).mCheckAbnormalCase == false) goto L28;
        r0 = true;
        goto L29
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.PlayerSurfaceRenderConfig");
    L45:
        if ((r4 instanceof w0) == false) goto L48;
        return (T) LiveInfraSettingKeys.LIVE_BROADCAST_PAUSE_NEW_STYLE.getValue();
    L48:
        if ((r4 instanceof LiveDynamicSRConfig) == false) goto L57;
        ?? r9 = (T) ((LiveDynamicSRConfig) ea.a.getValue());
        r9.setPreviewEnableSr(((Boolean) a4.a.getValue()).booleanValue());
        IAiService r10 = k.f(IAiService.class);
        if (r10 != null) goto L52;
    L54:
        r1 = false;
    L55:
        r9.setAiServiceSrEnable(r1);
        return r9;
    L52:
        if (r10.isDynamicSREnable() != true) goto L54;
    L57:
        if ((r4 instanceof PlayerOffScreenRenderConfig) == false) goto L60;
        wh0 r11 = wh0.a;
        return (T) new PlayerOffScreenRenderConfig(((PlayerTextureRenderConfig) r11.getValue()).enableDynamicOpen, ((PlayerTextureRenderConfig) r11.getValue()).enableCustom);
    L60:
        if ((r4 instanceof PlayerOptimizeConfig) == false) goto L77;
        if (r4 == null) goto L69;
        ?? r12 = (T) ((PlayerOptimizeConfig) r4);
        if (((Boolean) u5.a.getValue()).booleanValue() == false) goto L78;
        IPerformanceManager r13 = k.f(IPerformanceManager.class);
        if (r13 == null) goto L67;
        r2 = r13.hasDegrade();
    L67:
        r12.setDisableVoiceBalanceOpt(r2);
        return r12;
    L78:
        return r12;
    L69:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig");
    L77:
        return r4;
    }

    public final void postRxBusEvent(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "any");
        xs2.b.a().post(r2);
    }

    public final JSONObject readSeiJsonCache(String r2) {
        Intrinsics.checkNotNullParameter(r2, "seiJsonString");
        LiveSeiUtil.i.getClass();
        return LiveSeiUtil.g(r2);
    }

    public final void reportDataToDiagnoseDataManager(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (((Boolean) m0.a.getValue()).booleanValue() == true) goto L16;
        IDiagnoseDataManager r0 = k.f(IDiagnoseDataManager.class);
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isInit() == false) goto L18;
        String r1 = r4.optString("event_key");
        if (TextUtils.equals(r1, "playing") == false) goto L11;
    L14:
        r4.put("diagnoseDataType", 2);
        r0.addDiagnoseData(r4);
        return;
    L11:
        if (TextUtils.equals(r1, "render_stall") == true) goto L14;
        if (TextUtils.equals(r1, "stall") == true) goto L14;
        return;
    L18:
        return;
    }

    public final void traceLog(PlayerTraceLogData r10) {
        Intrinsics.checkNotNullParameter(r10, "traceLogData");
        a().getClass();
        Intrinsics.checkNotNullParameter(r10, "traceLogData");
        int r0 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r1 = com.bytedance.android.live.core.monitor.trace.e.b.a(r10.getEventType(), r10.getBusinessType());
        r1.c = "webcast_client_ttliveplayer";
        IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
        IMiddleWareHostContext r3 = null;
        if (r2 == null) goto L14;
        e r4 = r2.user();
        if (r4 == null) goto L14;
        String r5 = r4.n();
        if (r5 == null) goto L14;
        if (q0.a(r5) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L14;
        r1.g = r5;
    L14:
        String r6 = r10.getRoomId();
        if (r6.length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L23;
        r1.e = r6;
    L23:
        Map r8 = r10.getIndexes();
        if (r8 == null) goto L26;
        Intrinsics.checkNotNullParameter(r8, "index");
        r1.j = r8;
    L26:
        com.bytedance.android.live.core.monitor.trace.e r9 = r1.a();
        JSONObject r11 = r10.getExtras();
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L43
        Iterator r15 = ((List) v3.a.getValue()).iterator();     // Catch: Throwable -> L43
    L29:
        if (r15.hasNext() == false) goto L38;
        String r16 = (String) r15.next();     // Catch: Throwable -> L43
        String r17 = "unknown";
        if (r11 == null) goto L37;
        String r18 = r11.optString(r16, "unknown");     // Catch: Throwable -> L43
        if (r18 == null) goto L37;
        r17 = r18;
    L37:
        r12.put(r16, r17);     // Catch: Throwable -> L43
        goto L29
    L38:
        IMiddleWareHostContext r19 = k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L43
        if (r19 == null) goto L41;
        r12.put("appid", String.valueOf(r19.appId()));     // Catch: Throwable -> L43
        r12.put("os", "Android");     // Catch: Throwable -> L43
        r3 = r19;
    L41:
        Result.constructor-impl(r3);     // Catch: Throwable -> L43
    L45:
        JSONObject r110 = r10.getExtras();
        a60.e r20 = com.bytedance.android.live.core.monitor.trace.c.a;
        Intrinsics.checkNotNullParameter(r9, "traceMeta");
        TraceMonitor.i(r9, r12, r13, r110);
        return;
    L43:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L17:
        r7 = false;
        goto L18
    }

    public final Map<String, Double> getCpuRateAndSpeed(Context r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "appContext");
        c r1 = (c) this.a.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "appContext");
        Map<String, Double> r3 = null;
        if (r10 == false) goto L41;
    L19:
        if (r3 != null) goto L23;
        IHostPerformanceMonitor r11 = TTMiddlewareLiveSDK.hostMiddlewareService().hostPerformanceMonitor();     // Catch: Exception -> L17
        if (r11 == null) goto L23;
        r3 = r11.getCpuRate();     // Catch: Exception -> L17
    L23:
        if (r3 != null) goto L43;
        HashMap r12 = new HashMap();     // Catch: Exception -> L17
        r9.getPackageName();     // Catch: Exception -> L35
        String r13 = i60.e.b();     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r13) == false) goto L28;
        double r5 = -2;
    L29:
        r12.put("cpu_rate", Double.valueOf(r5));     // Catch: Exception -> L35
        String r14 = i60.e.a();     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r14) == false) goto L32;
        double r2 = -2;
    L33:
        r12.put("cpu_speed", Double.valueOf(r2));     // Catch: Exception -> L35
        return r12;
    L35:
        e = e;
        r3 = r12;
    L37:
        ALogger.e(r1.a, e);
        return r3;
    L32:
        r2 = CastDoubleProtector.parseDouble(r14);     // Catch: Exception -> L35
        goto L33
    L28:
        r5 = CastDoubleProtector.parseDouble(r13);     // Catch: Exception -> L35
    L17:
        e = e;
        goto L37
    L43:
        return r3;
    L41:
        if (k.n(IPerformanceManager.class).getCpuRate() < 0) goto L19;
        r12 = new HashMap();     // Catch: Exception -> L17
        IPerformanceManager r4 = k.f(IPerformanceManager.class);     // Catch: Exception -> L35
        if (r4 == null) goto L10;
        double r6 = r4.getCpuRate();     // Catch: Exception -> L35
    L11:
        r12.put("cpu_rate", Double.valueOf(r6));     // Catch: Exception -> L35
        IPerformanceManager r7 = k.f(IPerformanceManager.class);     // Catch: Exception -> L35
        if (r7 == null) goto L14;
        double r8 = r7.getCpuSpeed();     // Catch: Exception -> L35
    L15:
        r12.put("cpu_speed", Double.valueOf(r8));     // Catch: Exception -> L35
        r3 = r12;
        goto L19
    L14:
        r8 = 0.0f;
        goto L15
    L10:
        r6 = 0.0f;
        goto L11
    }

    public final Map<String, Long> getPssInfo(boolean r2, boolean r3) {
        return ((c) this.a.getValue()).a(r2, r3);
    }

    public final Map<String, Object> getQualityBySdkKey(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "identifier");
        Intrinsics.checkNotNullParameter(r7, "sdkKey");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L28;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L29;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L30;
        StreamUrl r3 = r2.getStreamUrl();
        if (r3 == null) goto L31;
        LiveCoreSDKData r4 = r3.getLiveCoreSDKData();
        if (r4 == null) goto L32;
        List r5 = r4.getQualityList();
        if (r5 == null) goto L33;
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((IQuality) r9).getSdkKey(), r7) == false) goto L16;
    L21:
        IQuality r10 = (IQuality) r9;
        if (r10 == null) goto L34;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("name", r10.getName());
        r11.put("fps", Integer.valueOf(r10.getFps()));
        r11.put("sdkKey", r10.getSdkKey());
        r11.put("resolution", r10.getResolution());
        return r11;
    L34:
        return null;
    L20:
        r9 = null;
        goto L21
    L33:
        return null;
    L32:
        return null;
    L31:
        return null;
    L30:
        return null;
    L29:
        return null;
    L28:
        return null;
    }

    public final JSONObject getResolutionSdkParamsObj(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "streamDataString");
        Intrinsics.checkNotNullParameter(r3, "sdkKey");
        return StreamDataUtil.INSTANCE.getResolutionSdkParamsObj(r2, r3);
    }

    public final <T> T getSettingsValueForKey(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        return (T) SettingUtil.getValue("key_ttlive_sdk_setting", r3, r4.getClass(), r4);
    }

    public final <T> T getStrategyServiceFactor(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 == null) goto L7;
        LiveData r6 = IStrategyService.a.a(r0, r4, r5, false, 12);
        if (r6 == null) goto L7;
        return (T) r6.getValue();
    L7:
        return null;
    }

    public final void onNetworkQualityChanged(int r3, String r4) {
        ALogger.i("LiveCellularService", "onNetworkQualityChanged? behavior:" + r3);
        if (r3 != (-6)) goto L7;
        ILiveCellularService r5 = k.f(ILiveCellularService.class);
        if (r5 == null) goto L17;
        r5.acquireUserNotify();
        return;
    L17:
        return;
    L7:
        ILiveCellularService r0 = k.f(ILiveCellularService.class);
        if (r0 == null) goto L10;
        r0.triggerSwitchingToCellular();
    L10:
        IMiddlewareHostBusiness r1 = k.f(IMiddlewareHostBusiness.class);
        if (r1 == null) goto L13;
        r1.onNetworkQualityChanged(r3, r4);
    L13:
        ILiveNetworkPredict r2 = k.f(ILiveNetworkPredict.class);
        if (r2 == null) goto L19;
        r2.onStreamQualityChanged(r3, r4);
        return;
    }

    public final String readSharedPreferences(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return r3;
    L5:
        return SharedPrefHelper.b(r0).j(r2, r3);
    }

    public final void slardarLog(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "info");
        a().getClass();
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "info");
        int r0 = w51.a;
        wm0.a r1 = om0.c.h();
        if (r1 == null) goto L5;
        r1.monitorCommonLog(r4, r5);
        return;
    L5:
        LiveSlardarMonitor.monitorCommonLog(r4, null, r5);
    }

    public final void teaLog(String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        LivePlayerBaseHostService r2 = a();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        PlayerApplogConfig r0 = (PlayerApplogConfig) is0.c.c().getConfig(PlayerApplogConfig.class);
        if (Intrinsics.areEqual(r6, "livesdk_live_client_monitor_log") == false) goto L14;
        if (r0.getStreamLogUseHostAppLog() == false) goto L9;
        IHostLog r1 = k.f(IHostLog.class);
        if (r1 == null) goto L26;
        r1.logV3(r6, r7);
        return;
    L26:
        return;
    L9:
        int r3 = w51.a;
        qm0.b r4 = om0.c.g();
        if (r4 == null) goto L12;
        r4.sendLog(r6, r7, new Object[0]);
        return;
    L12:
        j0.l().sendLog(r6, r7, new Object[0]);
        return;
    L14:
        if (r0.getPlayerLogUseHostAppLog() == true) goto L16;
        int r5 = w51.a;
        qm0.b r8 = om0.c.g();
        if (r8 == null) goto L24;
        r8.sendLog(r6, r7, new Object[0]);
        return;
    L24:
        j0.l().sendLog(r6, r7, new Object[0]);
        return;
    L16:
        if (StringsKt.startsWith$default(r6, r2.a, false, 2, null) == true) goto L18;
        r6 = r2.a + r6;
    L18:
        IHostLog r9 = k.f(IHostLog.class);
        if (r9 == null) goto L30;
        r9.logV3(r6, r7);
        return;
    }

    public final void writeSharedPreferences(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        Context r0 = s1.getContext();
        if (r0 == null) goto L6;
        SharedPrefHelper.b(r0).l(r3, r4);
        SharedPrefHelper.b(r0).a();
        return;
    }

    public final void writeToSeiJsonCache(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "seiJsonString");
        LiveSeiUtil.i.getClass();
        Intrinsics.checkNotNullParameter(r3, "seiJsonString");
        if (((Boolean) LiveSeiUtil.e.getValue()).booleanValue() == false) goto L6;
        if (r4 == null) goto L8;
        LiveSeiUtil.h.put(Integer.valueOf(r3.hashCode()), r4);
        return;
    L8:
        return;
    L6:
        LiveSeiUtil.d.put(Integer.valueOf(r3.hashCode()), r4);
    }

    public final <T> T getSettingsValueForKey(String r2, T r3, SettingsExtraInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        Intrinsics.checkNotNullParameter(r4, "settingsExtraInfo");
        T r5 = (T) k.n(IHostBusiness.class).getHostSettings(r2, r3, r4);
        if ((r5 instanceof Object) == true) goto L5;
        T r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r5;
    L8:
        Map r6 = g7.a;
        T r7 = (T) g7.a(r2, r3.getClass(), r3);
        if ((!Intrinsics.areEqual(r7, r3)) == false) goto L12;
        return r7;
    L12:
        return (T) SettingUtil.getValue("key_ttlive_sdk_setting", r2, r3.getClass(), r3);
    L5:
        r0 = r5;
        goto L6
    }
}
