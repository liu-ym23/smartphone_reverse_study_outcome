package com.bytedance.android.live.platformplayer.room;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.i;
import com.bytedance.android.live.core.setting.t3;
import com.bytedance.android.live.core.setting.y6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.platformplayer.test.IPlayerTest;
import com.bytedance.android.live.platformplayer.utils.c;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.a4;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.a11;
import com.bytedance.android.livesdk.config.p50;
import com.bytedance.android.livesdk.config.px0;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdk.config.wh0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.m2;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.GlobalRoomCache;
import com.bytedance.android.livesdkapi.depend.model.live.IOptions;
import com.bytedance.android.livesdkapi.depend.model.live.IPullData;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSession;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger;
import com.bytedance.android.livesdkapi.model.AdaptiveGradingConfig;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.LivePullStreamDelayConfig;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.bytedance.android.livesdkapi.model.PlayerTextureRenderConfig;
import com.bytedance.android.livesdkapi.model.StreamSrConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import io.reactivex.disposables.Disposable;
import is2.h;
import j40.l3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ls2.e;
import lu2.f;
import org.json.JSONObject;
import wt2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PullStreamTask extends com.bytedance.android.live.platformplayer.room.a {
    public static final /* synthetic */ int h = 0;
    public final com.bytedance.android.live.platformplayer.extrarender.a b;
    public boolean c;
    public String d;
    public final Lazy e;
    public Disposable f;
    public final RoomBaseSession g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ PullStreamTask a;

        public a(PullStreamTask r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            LiveRequest r0 = this.a.g.getLiveRequest();
            if (r0 == null) goto L5;
            r0.setVrStrategy(r4.intValue());
        L5:
            if (r4 != null) goto L8;
            return;
        L8:
            if (r4.intValue() != 3) goto L16;
            ILivePlayerClient r5 = c.b(this.a.g);
            if ((r5 instanceof LivePlayerClient) == true) goto L12;
            r5 = null;
        L12:
            LivePlayerClient r6 = (LivePlayerClient) r5;
            if (r6 == null) goto L17;
            r6.disableVrRenderForStrategy();
            return;
        L17:
            return;
        }
    }

    public final String getSpm() {
        return "PullStreamTask";
    }

    public final int b() {
        ILivePlayerClient r0 = c.b(this.g);
        boolean r2 = true;
        if (r0 == null) goto L16;
        if (r0.extraRenderController().isEnable() == false) goto L7;
    L12:
        boolean r1 = true;
    L13:
        if (r1 != true) goto L16;
        return 1;
    L7:
        if (r0.gameExtraRenderController().isEnable() == true) goto L12;
        if (r0.multiRenderController().isEnable() == true) goto L12;
        r1 = false;
    L16:
        if (c.a(this.g) == true) goto L18;
    L21:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L25;
    L27:
        if (r3 == false) goto L37;
        int r4 = d.a;
        if (Build.VERSION.SDK_INT >= 24) goto L32;
        r2 = false;
    L32:
        if (r2 == true) goto L34;
        boolean r5 = false;
    L35:
        if (r5 == false) goto L37;
        return 2;
    L34:
        r5 = ((PlayerTextureRenderConfig) wh0.a.getValue()).mDisableInnerNormal;
    L37:
        return 0;
    L25:
        if (this.g.disableTextureRender() == false) goto L27;
        return 2;
    L18:
        if (d.a() == true) goto L21;
        r3 = false;
        goto L23
    }

    public final StreamSrConfig.SrScale c() {
        if (((LiveUnifyBoxConfig) this.e.getValue()).getSrMove() == false) goto L5;
        return null;
    L5:
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 == null) goto L11;
        LiveData r1 = IStrategyService.a.a(r0, "sr_scale_init_value", 0, false, 8);
        if (r1 == null) goto L11;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L11;
    L12:
        int r3 = r2.intValue();
        IStrategyService r4 = k.f(IStrategyService.class);
        if (r4 == null) goto L18;
        LiveData r5 = IStrategyService.a.a(r4, "sr_scale_start_value", 0, true, 8);
        if (r5 == null) goto L18;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L18;
    L19:
        int r7 = r6.intValue();
        if (r3 > 0) goto L24;
        if (r7 > 0) goto L24;
        return null;
    L24:
        StreamSrConfig.SrScale r8 = new StreamSrConfig.SrScale();
        r8.setInitValue(r3);
        r8.setProcessValue(r7);
        return r8;
    L18:
        r6 = 0;
    L11:
        r2 = 0;
        goto L12
    }

    public final int e() {
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 != null) goto L5;
        return 0;
    L5:
        LiveData r1 = r0.getFactor("vr_stream_downgrade_level", 0, false, true);
        LifecycleOwner r2 = this.g.getLifecycleOwner();
        if (r2 == null) goto L9;
        if (r1 == null) goto L9;
        r1.observe(r2, new a(this));
    L9:
        if (r1 == null) goto L14;
        Integer r3 = (Integer) r1.getValue();
        if (r3 != null) goto L13;
        return 0;
    L13:
        return r3.intValue();
    L14:
        return 0;
    }

    public final Map<String, Object> getPropertyParams() {
        HashMap r0 = new HashMap();
        r0.put("room_id", Long.valueOf(this.g.getRoomId()));
        r0.put("stream_type", this.g.getStreamType());
        r0.put("use_new_stream_data", Boolean.valueOf(this.c));
        r0.put("share_player", Boolean.valueOf(c.a(this.g)));
        boolean r2 = false;
        if (this.g.getScreenOrientation() != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.put("screen_orientation", Boolean.valueOf(r1));
        r0.put("in_pk_mode", Boolean.valueOf(this.g.getInPkMode()));
        LiveRequest r3 = this.g.getLiveRequest();
        if (r3 == null) goto L10;
        String r4 = r3.getResolution();
        if (r4 == null) goto L10;
    L11:
        r0.put("resolution_key", r4);
        LiveRequest r5 = this.g.getLiveRequest();
        if (r5 == null) goto L14;
        boolean r6 = r5.getMute();
    L15:
        r0.put("mute", Boolean.valueOf(r6));
        if (this.d.length() <= 0) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L20;
        r0.put("error_status", this.d);
    L20:
        return r0;
    L14:
        r6 = false;
    L10:
        r4 = "";
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public PullStreamTask(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.g = r2;
        this.b = new com.bytedance.android.live.platformplayer.extrarender.a(r2);
        this.d = "";
        this.e = LazyKt.lazy(PullStreamTask$unifyBoxConfig$2.INSTANCE);
    }

    public static VideoEffectInitConfigBuilder d(ILivePlayerClient r2) {
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L5;
        return null;
    L5:
        if (r2 == null) goto L12;
        com.bytedance.android.live.platformplayer.service.a r0 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r0 == null) goto L13;
        VrEffectDownloader r1 = r0.T0();
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.f(r2);
    L13:
        return null;
    L12:
        return null;
    }

    public final void a(final Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r18, "extra");
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_LIVE_PLAYER.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        ILivePlayerClient r0 = c.b(this.g);
        boolean r1 = false;
        if (r0 == null) goto L9;
        r0.setStopBarrier(false);
    L9:
        if (LivePlatformPlayerManager.g().getEnableV1() == true) goto L13;
        ILivePlayerClient r2 = c.b(this.g);
        if (r2 == null) goto L13;
        r2.setUseScene(LivePlayerScene.INSTANCE.getINNER_DRAW());
    L13:
        RoomBaseSession r3 = this.g;
        Object r4 = null;
        if (r3 == null) goto L36;
        IExternalConfigJudger r5 = r3.getExternalConfigJudger();
        if (r5 == null) goto L36;
        if (r5.isInExternalMode() != true) goto L36;
        RoomBaseSession r6 = this.g;
        if (r6 == null) goto L24;
        IExternalConfigJudger r7 = r6.getExternalConfigJudger();
        if (r7 == null) goto L24;
        ILivePlayerScene r8 = r7.getPlayerScene();
    L25:
        if (r8 == null) goto L36;
        ILivePlayerClient r9 = c.b(this.g);
        if (r9 == null) goto L36;
        RoomBaseSession r10 = this.g;
        if (r10 == null) goto L34;
        IExternalConfigJudger r11 = r10.getExternalConfigJudger();
        if (r11 == null) goto L34;
        ILivePlayerScene r12 = r11.getPlayerScene();
        if (r12 == null) goto L34;
    L35:
        r9.setUseScene(r12);
    L34:
        r12 = LivePlayerScene.INSTANCE.getINNER_DRAW();
    L24:
        r8 = null;
    L36:
        String r13 = "";
        this.d = "";
        Object r14 = r18.get("key_pre_pull");
        if ((r14 instanceof Boolean) == true) goto L39;
        r14 = null;
    L39:
        Boolean r15 = (Boolean) r14;
        if (r15 == null) goto L42;
        final boolean r16 = r15.booleanValue();
    L43:
        Object r17 = r18.get("key_pull_in_background");
        if ((r17 instanceof Boolean) == true) goto L46;
        r17 = null;
    L46:
        Boolean r19 = (Boolean) r17;
        if (r19 == null) goto L49;
        final boolean r20 = r19.booleanValue();
    L50:
        if (r16 == false) goto L54;
        this.g.getEventHub().getPrePull().setValue(Boolean.TRUE);
        this.g.getEventHub().getStartPull().setValue(Boolean.FALSE);
        ILivePlayerClient r21 = c.b(this.g);
        if (r21 == null) goto L54;
        r21.mute("PullStreamTask.processV2");
    L54:
        StreamUrl r22 = this.b.a.getStreamUrl();
        if (r22 != null) goto L57;
    L59:
        boolean r23 = false;
    L60:
        if (r23 == false) goto L125;
        if (this.b.b() == true) goto L72;
        StreamUrl r24 = this.b.a.getStreamUrl();
        if (r24 != null) goto L66;
    L68:
        boolean r25 = false;
    L69:
        if (r25 == true) goto L72;
        boolean r26 = false;
    L73:
        if (r16 == false) goto L82;
        if (r26 == true) goto L82;
        ILivePlayerClient r27 = c.b(this.g);
        if (r27 == null) goto L168;
        IPlayerLogger r28 = r27.logger();
        if (r28 == null) goto L169;
        r28.logExtraRender("extra render room jump pre pull stream task ");
        return;
    L169:
        return;
    L168:
        return;
    L82:
        if (this.g.getRoom() != null) goto L90;
        if (r26 == true) goto L90;
        ILivePlayerClient r29 = c.b(this.g);
        if (r29 == null) goto L170;
        IPlayerLogger r30 = r29.logger();
        if (r30 == null) goto L171;
        r30.logExtraRender("jump pull stream task : extra render room with room info is null! ");
        return;
    L171:
        return;
    L170:
        return;
    L90:
        ILivePlayerClient r110 = c.b(this.g);
        if (r110 != null) goto L93;
    L107:
        com.bytedance.android.live.platformplayer.extrarender.a r31 = this.b;
        Room r111 = r31.a.getRoom();
        StreamUrl r112 = r31.a.getStreamUrl();
        ILivePlayerClient r113 = c.b(r31.a);
        StreamUrl r114 = r31.a.getStreamUrl();
        if (r114 != null) goto L110;
    L112:
        if (r1 == true) goto L125;
        if (r113 == null) goto L125;
    L120:
        e = move-exception;
        IPlayerLogger r32 = r113.logger();
        if (r32 == null) goto L125;
        r32.logExtraRender("PlayerExtraRenderTask onStartPullStream error! " + e.getMessage());
        goto L125
    L116:
        if (r31.b() == false) goto L118;
        com.bytedance.android.live.platformplayer.extrarender.a.d(r111, r112, r113);     // Catch: Exception -> L120
    L165:
        goto L125
    L118:
        com.bytedance.android.live.platformplayer.extrarender.a.c(r31, r111, r112, r113);     // Catch: Exception -> L120
        goto L165
    L110:
        if (r114.getCompoundSceneType() != 3) goto L112;
        r1 = true;
        goto L112
    L93:
        if (r110.gameExtraRenderController().isEnable() == false) goto L95;
    L99:
        boolean r115 = false;
    L100:
        if (r115 != true) goto L107;
        if (r26 == false) goto L103;
        this.g.setNeedRePullStream(true);
        goto L107
    L103:
        ILivePlayerClient r33 = c.b(this.g);
        if (r33 == null) goto L106;
        r33.release();
    L106:
        this.g.getEventHub().getStartPull().setValue(Boolean.FALSE);
        goto L107
    L95:
        if (r110.extraRenderController().isEnable() == true) goto L99;
        if (r110.multiRenderController().isEnable() == true) goto L99;
        r115 = true;
        goto L100
    L66:
        if (r24.getCompoundSceneType() != 3) goto L68;
        r25 = true;
    L72:
        r26 = true;
    L125:
        if (this.g.getPaidStreamUrlInvalid() == false) goto L132;
        if (r16 == false) goto L128;
    L129:
        ALogger.i("PaidLiveTraceMonitorPaidRefreshStreamAbility", "jump pull stream task for paid room, prePull=" + r16 + ", room=" + this.g.getRoom());
        return;
    L128:
        if (this.g.getRoom() == null) goto L129;
    L132:
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == true) goto L134;
    L136:
        m2 r34 = m2.a;
        if (((LivePullStreamDelayConfig) r34.getValue()).getInnerPullStream().getEnable() != 1) goto L139;
        final Ref.LongRef r35 = new Ref.LongRef();
        long r36 = (long) (((LivePullStreamDelayConfig) r34.getValue()).getInnerPullStream().getDelayDuration() * 1000);
        r35.element = r36;
        long r116 = Math.min(r36, 2000);
        r35.element = r116;
        UtilityKotlinExtentionsKt.s(r116, false, false, new PullStreamTask$processV2$2(this, r35, r16, r20, r18), 6);
    L155:
        AtomicBoolean r37 = x50.a.a;
        IMiddleWareHostContext r38 = k.f(IMiddleWareHostContext.class);     // Catch: Throwable -> L162
        if (r38 != null) goto L159;
        return;
    L159:
        if (x50.a.a.getAndSet(true) == true) goto L173;
        JSONObject r39 = new JSONObject();     // Catch: Throwable -> L162
        r39.put("sdk_aid", 1729);     // Catch: Throwable -> L162
        r39.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: Throwable -> L162
        r39.put("app_version", r38.getVersionName());     // Catch: Throwable -> L162
        r39.put("update_version_code", String.valueOf(r38.getUpdateVersionCode()));     // Catch: Throwable -> L162
        r39.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L162
        AppLogNewUtils.onEventV3("sdk_session_launch", r39);     // Catch: Throwable -> L162
        return;
    L173:
        return;
    L174:
        return;
    L139:
        Object r40 = r18.get("key_need_set_as_current_player");
        if ((r40 instanceof Boolean) == true) goto L142;
        r40 = null;
    L142:
        Boolean r41 = (Boolean) r40;
        if (r41 == null) goto L145;
        boolean r42 = r41.booleanValue();
    L146:
        Object r43 = r18.get("trigger_type");
        if ((r43 instanceof String) == false) goto L150;
        r4 = r43;
    L150:
        String r44 = (String) r4;
        if (r44 == null) goto L154;
        r13 = r44;
    L154:
        g(r16, r20, r42, r13);
        goto L155
    L145:
        r42 = true;
        goto L146
    L134:
        if (((Boolean) i.a.getValue()).booleanValue() == true) goto L136;
        return;
    L57:
        if (r22.isCompoundScene() != true) goto L59;
        r23 = true;
        goto L60
    L49:
        r20 = false;
        goto L50
    L42:
        r16 = false;
        goto L43
    }

    public final void g(boolean r11, boolean r12, boolean r13, String r14) {
        if (this.g.isMediaRoomEnding() == false) goto L52;
        this.d = "media_room_ending";
        return;
    L52:
        RoomBaseSession r0 = this.g;     // Catch: Exception -> L37
        String r1 = r0.getSharePullStreamData();     // Catch: Exception -> L37
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L24;
        String r4 = r0.getDefaultMultiPullStreamData();     // Catch: Exception -> L37
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L24;
        boolean r6 = false;
    L25:
        this.c = r6;     // Catch: Exception -> L37
        if (r6 == false) goto L28;
        f(r11, false, r12, r13, r14);     // Catch: Exception -> L37
        return;
    L28:
        String r7 = r0.getDefaultPullStreamUrl();     // Catch: Exception -> L37
        if (r7 != null) goto L31;
    L34:
        if (r2 == true) goto L53;
        f(r11, true, r12, r13, r14);     // Catch: Exception -> L37
        return;
    L53:
        return;
    L31:
        if (StringsKt.isBlank(r7) == true) goto L34;
        r2 = false;
        goto L34
    L17:
        if (StringsKt.isBlank(r4) == true) goto L20;
        r5 = false;
    L24:
        r6 = true;
        goto L25
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r3 = false;
    L37:
        e = move-exception;
        IRoomModuleService r15 = k.f(IRoomModuleService.class);
        if (r15 == null) goto L48;
        Class r16 = r15.getRoomTaskClass(3);
        if (r16 == null) goto L48;
        is2.i r17 = ((h) this).a;
        if (r17 == null) goto L48;
        e r18 = new e(-1);
        String r8 = e.getMessage();
        if (r8 != null) goto L47;
        r8 = "";
    L47:
        r18.setErrMsgV2(r8);
        r18.setReasonV2(EndReason.PLAYER_ERROR.INSTANCE);
        Unit r9 = Unit.INSTANCE;
        r17.a(r16, MapsKt.mapOf(TuplesKt.to("key_error", r18)));
    L48:
        this.d = "play_error_" + e;
        if (v.a() == false) goto L54;
        throw e;
    }

    public final void f(boolean r23, boolean r24, boolean r25, boolean r26, String r27) {
        Boolean r0 = (Boolean) this.g.getEventHub().getStartPull().getValue();
        Boolean r4 = Boolean.TRUE;
        boolean r1 = Intrinsics.areEqual(r0, r4);
        boolean r6 = true;
        int r7 = 0;
        if (LivePlatformPlayerManager.g().getEnableV2() == true) goto L5;
    L15:
        if (r1 == true) goto L17;
        this.g.setNeedRePullStream(false);
    L17:
        Disposable r5 = null;
        if (r1 == false) goto L66;
        IMicRoomService r2 = k.f(IMicRoomService.class);
        if (r2 != null) goto L22;
    L24:
        boolean r3 = false;
    L26:
        if (this.g.getMicRoomPrePullId() == 0) goto L28;
    L40:
        boolean r8 = false;
    L41:
        if (r8 == false) goto L66;
        if (Intrinsics.areEqual((Boolean) this.g.getEventHub().getStartPull().getValue(), Boolean.FALSE) == false) goto L45;
        this.g.getEventHub().getStartPull().setValue(r4);
    L45:
        ILivePlayerClient r9 = c.b(this.g);
        if (r9 == null) goto L50;
        IPlayerLogger r13 = r9.logger();
        if (r13 == null) goto L50;
        ILivePlayerSpmLogger.DefaultImpls.logPlayerClient$default(r13, "startPull is true!, ignore pull stream", null, false, null, 14, null);
    L50:
        this.d = "has_start_pull";
        if (TextUtils.equals(r27, "room_enter") == false) goto L287;
        RoomBaseSession r10 = this.g;
        if ((r10 instanceof IRoomSession) == true) goto L55;
        r10 = null;
    L55:
        if (r10 == null) goto L288;
        Disposable r11 = this.f;
        if (r11 == null) goto L59;
        r11.dispose();
    L59:
        f r12 = k.f(f.class);
        if (r12 == null) goto L64;
        com.bytedance.android.livesdk.vscore_api.paidlive.b r14 = r12.paidLiveUtils();
        if (r14 == null) goto L64;
        r5 = r14.e(r10);
    L64:
        this.f = r5;
        return;
    L288:
        return;
    L287:
        return;
    L28:
        if (this.g.getNeedRePullStream() == true) goto L40;
        if (r3 == true) goto L40;
        ILivePlayerClient r15 = c.b(this.g);
        if (r15 != null) goto L33;
    L39:
        r8 = true;
        goto L41
    L33:
        if (r15.multiRenderController().renderInfo().isGameLink() == true) goto L35;
    L37:
        boolean r16 = false;
    L38:
        if (r16 == true) goto L40;
    L35:
        if (Intrinsics.areEqual("room_enter", r27) == false) goto L37;
        r16 = true;
        goto L38
    L22:
        if (r2.isMicRoom(this.g.getRoom()) != true) goto L24;
        r3 = true;
    L66:
        Context r17 = this.g.getContext();
        if ((r17 instanceof Activity) == true) goto L69;
        r17 = null;
    L69:
        Activity r18 = (Activity) r17;
        if (r18 == null) goto L76;
        if (r18.isFinishing() != true) goto L76;
        this.d = "activity_finishing";
        return;
    L76:
        if (Intrinsics.areEqual((Boolean) this.g.getEventHub().getShowLiveEnd().getValue(), r4) == false) goto L80;
        this.d = "live_end";
        return;
    L80:
        if (this.g.getMicRoomPrePullId() == 0) goto L82;
        long r19 = this.g.getMicRoomPrePullId();
    L83:
        if (r26 == false) goto L86;
        boolean r20 = this.g.isPseudo();
        LivePlatformPlayerManager.c = r19;
        LivePlatformPlayerManager.d = r20;
    L86:
        if (((Boolean) p50.a.getValue()).booleanValue() == false) goto L89;
        LivePlatformPlayerManager.c(r19, false).i(this.g);
    L89:
        if (r24 == false) goto L115;
        this.g.getEventHub().getLegacyPull().setValue(r4);
        RoomBaseSession r21 = this.g;
        LiveRequest r22 = com.bytedance.android.livesdk.performance.a.a(new LiveRequest.Builder().streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(this.g.getStreamType())).inBackground(r25).enableAdaptiveGrading(((AdaptiveGradingConfig) t9.a.getValue()).getEnableDraw())).build();
        r22.setLegacyPullUrl(this.g.getDefaultPullStreamUrl());
        r22.setLegacySdkParams(this.g.getSdkParams());
        ILivePlayerClient r28 = c.b(this.g);
        if (r28 == null) goto L99;
        IRoomEventHub r29 = r28.getEventHub();
        if (r29 == null) goto L99;
        MutableLiveData r30 = r29.getPlayerMute();
        if (r30 == null) goto L99;
        Boolean r31 = (Boolean) r30.getValue();
        if (r31 == null) goto L99;
        boolean r32 = r31.booleanValue();
    L100:
        r22.setMute(r32);
        r22.getInAnchorInteractMode().setValue(Boolean.valueOf(this.g.getInPkMode()));
        MutableLiveData r33 = r22.isPortrait();
        if (this.g.getScreenOrientation() == 1) goto L104;
        r6 = false;
    L104:
        r33.setValue(Boolean.valueOf(r6));
        r22.setSharePlayer(c.a(this.g));
        r22.setSrScale(c());
        r22.setTextureRenderMode(b());
        if (c.a(this.g) == true) goto L107;
        r22.setPreview(false);
    L107:
        r22.setWormholePrePlay(this.g.isWormholePrePlay());
        this.g.setWormholePrePlay(false);
        StreamUrl r34 = this.g.getStreamUrl();
        if (r34 == null) goto L110;
        int r35 = r34.getVrType();
    L111:
        r22.setVrType(r35);
        r22.setVrStrategy(e());
        r22.setVrEffectConfigBuilder(d(c.b(this.g)));
        r22.setPicoInfo(this.g.getPicoInfo());
        Unit r36 = Unit.INSTANCE;
        ILivePlayerClient r37 = c.b(this.g);
        if (r37 == null) goto L114;
        r37.stream(r22, null);
    L114:
        r21.setLiveRequest(r22);
        this.g.getEventHub().getStartPull().setValue(r4);
    L281:
        LiveRequest r38 = this.g.getLiveRequest();
        if (r38 == null) goto L289;
        r38.setCurrentIsPrePullStreaming(r23);
        return;
    L289:
        return;
    L110:
        r35 = this.g.getExtra().getInt("live.intent.extra.VR_ROOM_TYPE", 0);
    L99:
        r32 = false;
        goto L100
    L115:
        o r39 = j0.l().c(IRoom.class);
        o r110 = j0.l().c(x.class);
        HashMap r111 = new HashMap();
        if (this.g.getRoom() == null) goto L124;
        if (r39 == null) goto L119;
        r39.u(r111, this.g.getRoom());
    L119:
        Room r40 = this.g.getRoom();
        Intrinsics.checkNotNull(r40);
        if (r40.isMergeVSRoom() == false) goto L122;
        String r41 = "1";
    L123:
        r111.put("is_vs", r41);
    L126:
        if (r110 == null) goto L285;
        r110.a(r111);
    L285:
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L142
        String r43 = (String) r111.get("room_id");     // Catch: Throwable -> L142
        if (r43 != null) goto L131;
    L139:
        long r112 = 0;
    L140:
        Object r44 = Result.constructor-impl(Long.valueOf(r112));     // Catch: Throwable -> L142
    L145:
        if (Result.exceptionOrNull-impl(r44) == null) goto L148;
        r44 = 0L;
    L148:
        long r113 = ((Number) r44).longValue();
        long r114 = this.g.getRoomId();
        if (r114 > 0) goto L151;
    L153:
        String r45 = this.g.getPullData();
        DataCenter r46 = this.g.getDataCenter();
        if (r46 == null) goto L160;
        ListenLiveStatus r47 = (ListenLiveStatus) r46.get("cmd_change_listen_live_status", null);
        if (r47 == null) goto L160;
        if (r47.isOpen() != true) goto L160;
        boolean r48 = true;
    L161:
        if (r48 == false) goto L164;
        final PlayerResolution.PickResult r49 = new PlayerResolution.PickResult(((a11) a4.a.getValue()).a(), "2", null, null, null, null, 60, null);
    L222:
        r111.put("result_sdk_key", r49.getResultSdkKey());
        r111.put("resolution_strategy", r49.getPickStrategy());
        r111.put("strategy_info", r49.getShotStrategyId());
        ILivePlayerClient r50 = c.b(this.g);
        if (r50 == null) goto L229;
        IPlayerLogger r51 = r50.logger();
        if (r51 == null) goto L229;
        ILivePlayerAppLogger r52 = r51.appLog();
        if (r52 == null) goto L229;
        r52.injectPlayStartParams(r111);
    L229:
        ALogger.i("PaidLiveTraceMonitor", "roomid = " + this.g.getRoomId() + ", stream data: " + r45);
        RoomBaseSession r53 = this.g;
        LiveRequest.Builder r54 = new LiveRequest.Builder().streamData(r45).triggerType(r27).resolution(r49.getResultSdkKey());
        LivePlayerStreamTypeUtils r55 = LivePlayerStreamTypeUtils.INSTANCE;
        LiveRequest.Builder r56 = r54.streamType(r55.mapLiveModeToStreamType(this.g.getStreamType())).inBackground(r25);
        ILivePlayerClient r57 = c.b(this.g);
        if (r57 == null) goto L237;
        IRoomEventHub r58 = r57.getEventHub();
        if (r58 == null) goto L237;
        MutableLiveData r59 = r58.getPlayerMute();
        if (r59 == null) goto L237;
        Boolean r60 = (Boolean) r59.getValue();
        if (r60 == null) goto L237;
    L238:
        LiveRequest r61 = com.bytedance.android.livesdk.performance.a.a(r56.mute(r60.booleanValue()).enterLiveSource(this.g.getEnterRoomInfo().getEnterRoomSource()).enterType(this.g.getEnterRoomInfo().getEnterType()).textureRenderMode(b()).picoInfo(this.g.getPicoInfo()).vrRecenterEnable(((PlayerInnerDrawerConfig) y6.a.getValue()).getVrRecenterEnable()).enableAdaptiveGrading(((AdaptiveGradingConfig) t9.a.getValue()).getEnableDraw())).build();
        r61.getInAnchorInteractMode().setValue(Boolean.valueOf(this.g.getInPkMode()));
        MutableLiveData r62 = r61.isPortrait();
        if (this.g.getScreenOrientation() != 1) goto L241;
        boolean r63 = true;
    L242:
        r62.setValue(Boolean.valueOf(r63));
        r61.setSharePlayer(c.a(this.g));
        if (c.a(this.g) == true) goto L246;
        r61.setPreview(false);
    L246:
        if (((Boolean) t3.a.getValue()).booleanValue() == false) goto L253;
        IRoom r65 = GlobalRoomCache.INSTANCE.getRoomById(this.g.getRoomId());
        if (r65 == null) goto L251;
        LiveMode r66 = r65.getStreamType();
        if (r66 == null) goto L251;
    L252:
        r61.setStreamType(r55.mapLiveModeToStreamType(r66));
    L251:
        r66 = LiveMode.VIDEO;
    L253:
        r61.setSubStream(this.g.isSwitchingSubCamera());
        r61.setNeedRePullStream(this.g.getNeedRePullStream());
        r61.setWormholePrePlay(this.g.isWormholePrePlay());
        r61.setSrScale(c());
        this.g.setWormholePrePlay(false);
        StreamUrl r67 = this.g.getStreamUrl();
        if (r67 == null) goto L256;
        int r68 = r67.getVrType();
    L257:
        r61.setVrType(r68);
        r61.setVrStrategy(e());
        r61.setVrEffectConfigBuilder(d(c.b(this.g)));
        if (((LiveUnifyBoxConfig) this.e.getValue()).getQosConstraintMove() == true) goto L267;
        IStrategyService r69 = k.f(IStrategyService.class);
        if (r69 == null) goto L267;
        LiveData r70 = IStrategyService.a.a(r69, "pullstream_qos_constraint", 0, true, 8);
        if (r70 == null) goto L267;
        Integer r71 = (Integer) r70.getValue();
        if (r71 == null) goto L267;
        r7 = r71.intValue();
    L267:
        r61.setQosConstraintOpt(r7);
        int r72 = -1;
        if (((LiveUnifyBoxConfig) this.e.getValue()).getSrMove() == true) goto L277;
        IStrategyService r73 = k.f(IStrategyService.class);
        if (r73 == null) goto L277;
        LiveData r74 = IStrategyService.a.a(r73, "sharpen_state", -1, true, 8);
        if (r74 == null) goto L277;
        Integer r75 = (Integer) r74.getValue();
        if (r75 == null) goto L277;
        r72 = r75.intValue();
    L277:
        r61.setSharpenOption(r72);
        Unit r76 = Unit.INSTANCE;
        ILivePlayerClient r77 = c.b(this.g);
        if (r77 == null) goto L280;
        r77.stream(r61, null);
    L280:
        Object r78 = com.bytedance.android.livesdk.paas.a.a(new kjc.c(), new PullStreamTask$streamUrl$$inlined$also$lambda$1(this, r49)).a;
        r53.setLiveRequest(r61);
        this.g.getEventHub().getStartPull().setValue(Boolean.TRUE);
        goto L281
    L256:
        r68 = this.g.getExtra().getInt("live.intent.extra.VR_ROOM_TYPE", 0);
        goto L257
    L241:
        r63 = false;
    L237:
        r60 = Boolean.FALSE;
        goto L238
    L164:
        if (v.a() == true) goto L166;
    L168:
        ALogger.i("ResolutionInterceptor", "roomId:" + this.g.getRoomId() + ",pickDefaultResolution");
        IResolutionService r79 = k.f(IResolutionService.class);
        if (Intrinsics.areEqual(px0.a.getValue(), Boolean.TRUE) == true) goto L171;
    L211:
        if (r79 == null) goto L214;
        r49 = r79.getPullStreamResolution(this.g.getRoomId(), this.g.getStreamUrl(), true);
        if (r49 != null) goto L222;
    L214:
        String r115 = this.g.getDefaultResolution();
        StreamUrl r80 = this.g.getStreamUrl();
        if (r80 == null) goto L220;
        String r81 = r80.getDefaultQualityStrategy();
        if (r81 == null) goto L220;
        String r116 = r81;
    L221:
        r49 = new PlayerResolution.PickResult(r115, "4", r116, null, null, null, 56, null);
    L220:
        r116 = "";
        goto L221
    L171:
        if (this.g.getCurrentSubSteamKey().length() <= 0) goto L173;
        boolean r82 = true;
    L174:
        if (r82 == false) goto L211;
        StreamUrl r83 = this.g.getStreamUrl();
        if (r83 == null) goto L196;
        Map r84 = r83.getPullDatas();
        if (r84 == null) goto L196;
        if (r84.containsKey(this.g.getCurrentSubSteamKey()) != true) goto L196;
        StreamUrl r85 = this.g.getStreamUrl();
        if (r85 == null) goto L193;
        Map r86 = r85.getPullDatas();
        if (r86 == null) goto L193;
        IPullData r87 = (IPullData) r86.get(this.g.getCurrentSubSteamKey());
        if (r87 == null) goto L193;
        IOptions r88 = r87.getOptions();
        if (r88 == null) goto L193;
        IQuality r89 = r88.getDefaultQuality();
        if (r89 == null) goto L193;
        String r90 = r89.getSdkKey();
        if (r90 == null) goto L193;
    L201:
        if (r90 != null) goto L203;
        r90 = this.g.getDefaultResolution();
    L203:
        String r117 = r90;
        StreamUrl r91 = this.g.getStreamUrl();
        if (r91 == null) goto L209;
        String r92 = r91.getDefaultQualityStrategy();
        if (r92 == null) goto L209;
        String r118 = r92;
    L210:
        r49 = new PlayerResolution.PickResult(r117, "4", r118, null, null, null, 56, null);
    L209:
        r118 = "";
    L193:
        StreamUrl r93 = this.g.getStreamUrl();
        if (r93 == null) goto L199;
        r90 = r93.getMultiStreamDefaultQualitySdkKey();
    L199:
        r90 = null;
    L196:
        StreamUrl r94 = this.g.getStreamUrl();
        if (r94 == null) goto L199;
        r90 = r94.getMultiStreamDefaultQualitySdkKey();
        goto L201
    L173:
        r82 = false;
        goto L174
    L166:
        if (k.g(IPlayerTest.class, true) == null) goto L168;
        ((IPlayerTest) k.n(IPlayerTest.class)).getTestMockData().a();
        int r95 = ((Number) l3.a.getValue()).intValue() & 2;
    L160:
        r48 = false;
        goto L161
    L151:
        if (r113 == r114) goto L153;
        r111.put("room_id", String.valueOf(r114));
        goto L153
    L131:
        if (r43.length() <= 0) goto L133;
        boolean r119 = true;
    L134:
        if (r119 == true) goto L137;
        r43 = null;
    L137:
        if (r43 == null) goto L139;
        r112 = CastLongProtector.parseLong(r43);     // Catch: Throwable -> L142
        goto L140
    L133:
        r119 = false;
    L142:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L145
    L122:
        r41 = "0";
        goto L123
    L124:
        if (r39 == null) goto L126;
        r39.a(r111);
        goto L126
    L82:
        r19 = this.g.getRoomId();
        goto L83
    L5:
        if (((PlayerInnerDrawerConfig) y6.a.getValue()).getOptimizePullStreamTask() == false) goto L15;
        LivePlayerView r96 = LivePlatformPlayerManager.c(this.g.getRoomId(), this.g.isPseudo()).getLivePlayerView();
        if (r96 == null) goto L9;
        r96.directRunningDelayStopOrRelease();
    L9:
        ILivePlayerClient r97 = c.b(this.g);
        if (r97 != null) goto L12;
    L14:
        r1 = false;
        goto L15
    L12:
        if (r97.isPlaying() != true) goto L14;
        r1 = true;
        goto L15
    }
}
