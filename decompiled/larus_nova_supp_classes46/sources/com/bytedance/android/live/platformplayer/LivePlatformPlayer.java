package com.bytedance.android.live.platformplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.util.t;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.y6;
import com.bytedance.android.live.core.utils.rxutils.StreamDataUtil;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.config.fn;
import com.bytedance.android.livesdk.config.mu;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdk.config.wh0;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger;
import com.bytedance.android.livesdkapi.model.AdaptiveGradingConfig;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.bytedance.android.livesdkapi.model.PlayerShareConfig;
import com.bytedance.android.livesdkapi.model.PlayerTextureRenderConfig;
import com.bytedance.android.livesdkapi.model.StreamSrConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.AESDecryptLiveUrlUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerService;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.PlayerClientType;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.view.IExtraRenderView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import wt2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlatformPlayer implements as0.a {
    public final c a;
    public ILivePlayerClient b;
    public boolean c;
    public Context d;
    public boolean e;
    public LivePlayerConfig f;
    public final Lazy g;
    public final Lazy h;
    public WeakReference<LivePlayerView> i;
    public LivePlayerView j;
    public final Lazy k;
    public RoomBaseSession l;
    public IBaseStreamUrl m;
    public as0.a.c n;
    public final long o;

    public final ILivePlayerService z() {
        return (ILivePlayerService) this.g.getValue();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.ViewRootImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.ViewRootImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.ViewRootImpl");
    }

    public final LivePlayerView A() {
        WeakReference<LivePlayerView> r0 = this.i;
        if (r0 == null) goto L7;
        LivePlayerView r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.j;
    }

    public final StreamSrConfig.SrScale B() {
        if (((LiveUnifyBoxConfig) this.h.getValue()).getSrMove() == false) goto L5;
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

    public final void D() {
        as0.a.c r0 = this.n;
        if (r0 == null) goto L11;
        ILivePlayerClient r1 = this.b;
        if (r1 == null) goto L7;
        int r3 = is0.b.a;
        r1.registerPlayerFeature(is0.b.a.c("same_room_id", 1, String.valueOf(r0.a)));
    L7:
        ILivePlayerClient r2 = this.b;
        if (r2 == null) goto L12;
        int r4 = is0.b.a;
        r2.registerPlayerFeature(is0.b.a.c("same_room_reason", 1, r0.c));
        return;
    L12:
        return;
    }

    @Override // as0.a
    public final void h() {
        if (((PlayerInnerDrawerConfig) y6.a.getValue()).getStopPreviewSharePlayer() == true) goto L6;
        return;
    L6:
        if (k() == true) goto L13;
        Iterator r0 = z().getPreviewClientListWithIdentifier(String.valueOf(this.o)).iterator();
    L9:
        if (r0.hasNext() == false) goto L19;
        ILivePlayerClient r1 = (ILivePlayerClient) r0.next();
        if (r1.isPlaying() == false) goto L9;
        r1.stop();
        goto L9
    L19:
        return;
    }

    @Override // as0.a
    public final LivePlayerView getLivePlayerView() {
        return A();
    }

    @Override // as0.a
    public final boolean k() {
        if (LivePlatformPlayerManager.g().getEnableV2() == false) goto L13;
        ILivePlayerClient r0 = this.b;
        if (r0 == null) goto L11;
        LivePlayerClientContext r1 = r0.context();
        if (r1 == null) goto L11;
        if (r1.isSharedClient() != true) goto L11;
        return true;
    L11:
        return false;
    L13:
        return this.c;
    }

    @Override // as0.a
    public final boolean m() {
        PlayerShareConfig r0 = (PlayerShareConfig) z().getConfig(PlayerShareConfig.class);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.getSmoothLeaveRoom());
    L7:
        return r1.booleanValue();
    L5:
        r1 = null;
        goto L7
    }

    @Override // as0.a
    public final RoomBaseSession d() {
        return this.l;
    }

    @Override // as0.a
    public final IBaseStreamUrl n() {
        return this.m;
    }

    @Override // as0.a
    public final ILivePlayerClient player() {
        return this.b;
    }

    @Override // as0.a
    public final long roomId() {
        return this.o;
    }

    @Override // as0.a
    public final LivePlayerConfig w() {
        return this.f;
    }

    @Override // as0.a
    public final Context y() {
        return this.d;
    }

    public LivePlatformPlayer(long r1) {
        this.o = r1;
        this.a = new c();
        this.g = LazyKt.lazy(LivePlatformPlayer$livePlayerService$2.INSTANCE);
        this.h = LazyKt.lazy(LivePlatformPlayer$unifyBoxConfig$2.INSTANCE);
        this.k = LazyKt.lazy(LivePlatformPlayer$innerDrawerConfig$2.INSTANCE);
    }

    public static VideoEffectInitConfigBuilder C(ILivePlayerClient r2) {
        VideoEffectInitConfigBuilder r1 = null;
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L5;
        return null;
    L5:
        if (r2 == null) goto L13;
        com.bytedance.android.live.platformplayer.service.a r0 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r0 == null) goto L11;
        VrEffectDownloader r3 = r0.T0();
        if (r3 == null) goto L11;
        r1 = r3.f(r2);
    L11:
        if (r1 != null) goto L13;
        Logger.d("LiveVrEffect", "inner get builder=null");
    L13:
        return r1;
    }

    @Override // as0.a
    public final ILivePlayerClient g(boolean r5) {
        ILivePlayerClient r0 = this.b;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ILivePlayerClient r6 = z().createClient(b(this.o, r5, false));
        this.b = r6;
        D();
        return r6;
    }

    @Override // as0.a
    public final void i(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.l = r2;
        Iterator<T> r3 = this.a.a.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((as0.b) r3.next()).a();
        goto L4
    }

    @Override // as0.a
    public final void j(as0.a.c r1) {
        this.n = r1;
        D();
    }

    @Override // as0.a
    public final void log(String r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        ALogger.d("ttlive_logger_player_lifecycle", "[player_context@" + hashCode() + "][" + this.o + "]:" + r4);
    }

    @Override // as0.a
    public final void o(as0.a.b r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        this.d = r4.getContext();
        log("init activity context : " + r4.getContext());
        Activity r0 = (Activity) this.d;
        if (r0 == null) goto L7;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L7;
        r1.putExtra("extra_smooth_leave", false);
    L7:
        this.e = r4.b;
    }

    @Override // as0.a
    public final boolean p(EndReason.USER_CLOSE r2) {
        if (r2 == null) goto L17;
        ILivePlayerClient r0 = this.b;
        if (r0 == null) goto L17;
        if (r0.isPlaying() == false) goto L17;
        if (m() == false) goto L17;
        if (k() == false) goto L17;
        if (this.e == false) goto L17;
        if (Intrinsics.areEqual(r2, EndReason.USER_CLOSE.INSTANCE) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // as0.a
    public final boolean q(Context r4) {
        if (this.b != null) goto L5;
        return true;
    L5:
        if (r4 != null) goto L7;
    L10:
        ILivePlayerClient r5 = this.b;
        if (r5 == null) goto L13;
        State r6 = r5.getCurrentState();
    L15:
        if ((r6 instanceof State.Released) == false) goto L17;
    L19:
        log("set player client as null on fragment destroy");
        this.b = null;
        return true;
    L17:
        if ((r6 instanceof State.Stopped) == true) goto L19;
        f(true, null);
        goto L19
    L13:
        r6 = null;
        goto L15
    L7:
        if ((!Intrinsics.areEqual(r4, this.d)) == false) goto L10;
        log("remove player context failed! cur activity context : " + this.d + " ; fragment destroy context : " + r4);
        return false;
    }

    @Override // as0.a
    public final boolean r(Bundle r30) {
        String r0 = "0";
        Boolean r8 = (Boolean) mu.a.getValue();
        if (r30 == null) goto L5;
        boolean r10 = r30.getBoolean("live.intent.extra.USE_PRE_PULL_STREAM", true);
    L7:
        if (r8.booleanValue() == false) goto L266;
        if (this.o <= 0) goto L266;
        if (r30 == null) goto L266;
        if (r10 == false) goto L266;
        LiveMode r9 = LiveMode.Companion.valueOf(r30.getInt("live.intent.extra.STREAM_TYPE", 0));
        AESDecryptLiveUrlUtils r11 = AESDecryptLiveUrlUtils.INSTANCE;
        String r13 = yt2.a.e(r30, "live.intent.extra.PULL_STREAM_DATA");
        LiveSdkApiForSaaS.Companion.getClass();
        String r14 = r11.getDecryptPullUrl(r13, LiveSdkApiForSaaS.a.a().getSecKey());
        String r15 = "";
        String r12 = r11.getDecryptPullUrl(yt2.a.e(r30, "live.intent.extra.PULL_SHARE_URL"), "");
        String r16 = r30.getString("live.intent.extra.PULL_DEFAULT_RESOLUTION", "origin");
        String r17 = r30.getString("live.intent.extra.PULL_STREAM_URL");
        String r18 = r30.getString("live.intent.extra.PULL_SDK_PARAMS");
        if (TextUtils.isEmpty(r12) == true) goto L16;
        r14 = r12;
    L16:
        Serializable r19 = yt2.a.c(r30);
        String r110 = r14;
        Serializable r20 = r19;
        if ((r19 instanceof IBaseStreamUrl) == true) goto L19;
        r20 = null;
    L19:
        IBaseStreamUrl r111 = (IBaseStreamUrl) r20;
        if (r111 == null) goto L22;
        String r112 = r111.getCompoundStreamData();
    L23:
        if (r111 == null) goto L40;
        LiveMode r22 = r9;
        if (r111.isCompoundScene() != true) goto L41;
        if (r112 != null) goto L28;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == true) goto L41;
        yt2.a.g(r30, "live.intent.extra.PULL_STREAM_DATA", r112);
        if (r111.getCompoundSceneType() != 1) goto L36;
    L39:
        boolean r21 = false;
        r110 = r112;
    L43:
        if (r30.getBoolean("is_live_streaming", r21) == false) goto L46;
        return r21;
    L46:
        if (TextUtils.isEmpty(r110) == true) goto L50;
        if (TextUtils.isEmpty(r16) == true) goto L50;
    L54:
        this.m = r111;
        v(r30);
        if (k() == false) goto L57;
    L61:
        r30.putLong("live.intent.extra.EXTRA_START_PULL_STREAM", System.currentTimeMillis());
        String r23 = r30.getString("live.intent.extra.ENTER_TYPE");
        if (r23 == null) goto L64;
    L75:
        String r24 = r30.getString("live.intent.extra.ENTER_LIVE_SOURCE");
        if (r30.containsKey("enter_from") == false) goto L78;
        r24 = r30.getString("enter_from");
    L78:
        if (r24 != null) goto L80;
    L83:
        boolean r113 = true;
    L85:
        if (r113 == false) goto L105;
        r24 = r30.getString("enter_from_merge");
        String r114 = r30.getString("enter_method");
        if (r24 != null) goto L89;
    L92:
        boolean r25 = true;
    L93:
        if (r25 == true) goto L103;
        if (r114 != null) goto L96;
    L99:
        boolean r26 = true;
    L100:
        if (r26 == true) goto L105;
        r24 = r24 + '-' + r114;
        goto L105
    L96:
        if (StringsKt.isBlank(r114) == true) goto L99;
        r26 = false;
        goto L100
    L103:
        r24 = "";
        goto L105
    L89:
        if (StringsKt.isBlank(r24) == true) goto L92;
        r25 = false;
    L105:
        boolean r115 = r30.getBoolean("key_extra_pull_stream_mute");
        int r116 = r30.getInt("live.intent.extra.VR_ROOM_TYPE");
        String r27 = r23;
        log("start pre pull stream");     // Catch: Exception -> L259
        String r28 = r24;
        int r29 = r30.getInt("live.intent.extra.ITEM_TYPE", -1);     // Catch: Exception -> L259
        if (15 != r29) goto L109;
    L114:
        boolean r31 = true;
    L115:
        Bundle r32 = yt2.a.b(r30, "live.intent.extra.ENTER_LIVE_EXTRA");     // Catch: Exception -> L259
        Object r33 = r30.get("live.intent.extra.ROOM_ID");     // Catch: Exception -> L259
        if (r33 == null) goto L121;
        String r34 = r33.toString();     // Catch: Exception -> L259
        if (r34 == null) goto L121;
        boolean r210 = r115;
    L131:
        if (r34 != null) goto L133;
        r34 = "";
    L133:
        ILivePlayerClient r117 = this.b;     // Catch: Exception -> L259
        if (r117 != null) goto L269;
    L267:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L186
        Object r2 = Result.constructor-impl(new JSONObject(r30.getString("live.intent.extra.EXTRA_PICO_ROOM_BG_INFO", "")));     // Catch: Throwable -> L186
    L189:
        if (Result.isSuccess-impl(r2) == false) goto L191;
        JSONObject r3 = (JSONObject) r2;     // Catch: Exception -> L182
    L193:
        if (Result.exceptionOrNull-impl(r2) == null) goto L195;
        r3 = null;
    L195:
        String r4 = "pre_pull_stream";
        int r5 = r30.getInt("livesdk_live_ai_pre_play", -1);     // Catch: Exception -> L182
        if (r5 != 3) goto L198;
        r4 = "liveai_skylight_pre_pull_stream";
        r30.remove("livesdk_live_ai_pre_play");     // Catch: Exception -> L182
    L202:
        LivePlatformPlayer r6 = this;
        RoomBaseSession r35 = r6.l;     // Catch: Exception -> L257
        if (r35 == null) goto L206;
        r35.getRoom();     // Catch: Exception -> L257
    L206:
        ILivePlayerClient r36 = r6.b;     // Catch: Exception -> L257
        if (r36 == null) goto L251;
        LiveRequest.Builder r37 = new LiveRequest.Builder().triggerType(r4);     // Catch: Exception -> L257
        if (r110 != null) goto L211;
        String r38 = "";
    L212:
        LiveRequest.Builder r39 = r37.streamData(r38);     // Catch: Exception -> L257
        if (r16 == null) goto L216;
        r15 = r16;
    L216:
        LiveRequest r40 = com.bytedance.android.livesdk.performance.a.a(r39.resolution(r15).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r22)).mute(r210).enterLiveSource(r28).enterType(r27).textureRenderMode(r6.c(r30, r111)).vrRecenterEnable(((PlayerInnerDrawerConfig) y6.a.getValue()).getVrRecenterEnable()).enableAdaptiveGrading(((AdaptiveGradingConfig) t9.a.getValue()).getEnableDraw())).build();     // Catch: Exception -> L257
        r40.setVrType(r116);     // Catch: Exception -> L257
        IStrategyService r41 = k.f(IStrategyService.class);     // Catch: Exception -> L257
        if (r41 == null) goto L224;
        LiveData r42 = r41.getFactor("vr_stream_downgrade_level", 0, false, true);     // Catch: Exception -> L257
        if (r42 == null) goto L224;
        Integer r43 = (Integer) r42.getValue();     // Catch: Exception -> L257
        if (r43 == null) goto L224;
        int r44 = r43.intValue();     // Catch: Exception -> L257
    L225:
        r40.setVrStrategy(r44);     // Catch: Exception -> L257
        r40.setVrEffectConfigBuilder(C(r6.b));     // Catch: Exception -> L257
        if (r3 == null) goto L228;
        r40.setPicoInfo(r3);     // Catch: Exception -> L257
    L228:
        r40.setSrScale(B());     // Catch: Exception -> L257
        if (((LiveUnifyBoxConfig) r6.h.getValue()).getQosConstraintMove() == true) goto L238;
        IStrategyService r45 = k.f(IStrategyService.class);     // Catch: Exception -> L257
        if (r45 == null) goto L238;
        LiveData r46 = IStrategyService.a.a(r45, "pullstream_qos_constraint", 0, true, 8);     // Catch: Exception -> L257
        if (r46 == null) goto L238;
        Integer r47 = (Integer) r46.getValue();     // Catch: Exception -> L257
        if (r47 == null) goto L238;
        int r48 = r47.intValue();     // Catch: Exception -> L257
    L239:
        r40.setQosConstraintOpt(r48);     // Catch: Exception -> L257
        if (((LiveUnifyBoxConfig) r6.h.getValue()).getSrMove() == true) goto L249;
        IStrategyService r49 = k.f(IStrategyService.class);     // Catch: Exception -> L257
        if (r49 == null) goto L249;
        LiveData r50 = IStrategyService.a.a(r49, "sharpen_state", -1, true, 8);     // Catch: Exception -> L257
        if (r50 == null) goto L249;
        Integer r51 = (Integer) r50.getValue();     // Catch: Exception -> L257
        if (r51 == null) goto L249;
        int r52 = r51.intValue();     // Catch: Exception -> L257
    L250:
        r40.setSharpenOption(r52);     // Catch: Exception -> L257
        Unit r53 = Unit.INSTANCE;     // Catch: Exception -> L257
        r36.stream(r40, null);     // Catch: Exception -> L257
    L249:
        r52 = -1;
    L238:
        r48 = 0;
    L224:
        r44 = 0;
        goto L225
    L211:
        r38 = r110;
    L251:
        r6.log("prePullStreamReslution=" + r16);     // Catch: Exception -> L257
        if (r30.getBoolean("live.intent.extra.EXTRA_LIVE_PRE_PULL_STREAM") == true) goto L255;
        r30.putBoolean("live.intent.extra.EXTRA_LIVE_PRE_PULL_STREAM", true);
        return true;
    L255:
        return true;
    L257:
        e = e;
    L261:
        r6.log("pre pull stream failed! " + e.getMessage());
        e.printStackTrace();
        return false;
    L198:
        if (r5 != 4) goto L202;
        r4 = "liveai_head_pre_pull_stream";
        r30.remove("livesdk_live_ai_pre_play");     // Catch: Exception -> L182
        goto L202
    L191:
        r3 = null;
    L186:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Exception -> L182
        r2 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L182
    L182:
        e = e;
        r6 = this;
        goto L261
    L269:
        IPlayerLogger r118 = r117.logger();     // Catch: Exception -> L182
        if (r118 == null) goto L267;
        ILivePlayerAppLogger r119 = r118.appLog();     // Catch: Exception -> L182
        if (r119 == null) goto L267;
        Pair[] r120 = new Pair[10];     // Catch: Exception -> L182
        o0.a.getClass();     // Catch: Exception -> L182
        r120[0] = TuplesKt.to("anchor_id", o0.a.c(r30, "anchor_id", "0"));     // Catch: Exception -> L182
        r120[1] = TuplesKt.to("room_id", r34);     // Catch: Exception -> L182
        Object r55 = r30.get("live.intent.extra.REQUEST_ID");     // Catch: Exception -> L182
        if (r55 == null) goto L144;
        String r56 = r55.toString();     // Catch: Exception -> L182
        if (r56 == null) goto L144;
    L145:
        r120[2] = TuplesKt.to("request_id", r56);     // Catch: Exception -> L182
        Object r57 = r30.get("live.intent.extra.LOG_PB");     // Catch: Exception -> L182
        if (r57 == null) goto L149;
        String r58 = r57.toString();     // Catch: Exception -> L182
        if (r58 == null) goto L149;
    L150:
        r120[3] = TuplesKt.to("log_pb", r58);     // Catch: Exception -> L182
        Object r59 = r30.get("video_id");     // Catch: Exception -> L182
        if (r59 == null) goto L154;
        String r60 = r59.toString();     // Catch: Exception -> L182
        if (r60 == null) goto L154;
    L155:
        r120[4] = TuplesKt.to("video_id", r60);     // Catch: Exception -> L182
        Object r61 = r30.get("action_type");     // Catch: Exception -> L182
        if (r61 == null) goto L159;
        String r62 = r61.toString();     // Catch: Exception -> L182
        if (r62 == null) goto L159;
    L160:
        r120[5] = TuplesKt.to("action_type", r62);     // Catch: Exception -> L182
        if (r32 == null) goto L166;
        Object r63 = r32.get("enter_from_merge");     // Catch: Exception -> L182
        if (r63 == null) goto L166;
        String r65 = r63.toString();     // Catch: Exception -> L182
        if (r65 == null) goto L166;
    L167:
        r120[6] = TuplesKt.to("enter_from_merge", r65);     // Catch: Exception -> L182
        if (r32 == null) goto L173;
        Object r66 = r32.get("enter_method");     // Catch: Exception -> L182
        if (r66 == null) goto L173;
        String r67 = r66.toString();     // Catch: Exception -> L182
        if (r67 == null) goto L173;
    L174:
        r120[7] = TuplesKt.to("enter_method", r67);     // Catch: Exception -> L182
        r120[8] = TuplesKt.to("vr_type", String.valueOf(r116));     // Catch: Exception -> L182
        if (r31 == false) goto L177;
        r0 = "1";
    L177:
        r120[9] = TuplesKt.to("is_vs", r0);     // Catch: Exception -> L182
        Map r68 = MapsKt.mutableMapOf(r120);     // Catch: Exception -> L182
        Object r69 = r30.get("live.intent.extra.EXTRA_PULL_DEFAULT_RESOLUTION_STRATEGY");     // Catch: Exception -> L182
        if (r69 == null) goto L180;
        r68.put("resolution_strategy", r69.toString());     // Catch: Exception -> L182
    L180:
        Unit r70 = Unit.INSTANCE;     // Catch: Exception -> L182
        r119.injectPlayStartParams(r68);     // Catch: Exception -> L182
    L173:
        r67 = "";
    L166:
        r65 = "";
    L159:
        r62 = "";
    L154:
        r60 = "";
    L149:
        r58 = "";
    L144:
        r56 = "";
    L121:
        r210 = r115;
        Long r71 = Long.valueOf(this.o);     // Catch: Exception -> L259
        if (r71.longValue() <= 0) goto L124;
        boolean r121 = true;
    L125:
        if (r121 == true) goto L128;
        r71 = null;
    L128:
        if (r71 == null) goto L130;
        r34 = String.valueOf(r71.longValue());     // Catch: Exception -> L259
        goto L131
    L130:
        r34 = null;
        goto L131
    L124:
        r121 = false;
        goto L125
    L109:
        if (16 == r29) goto L114;
        if (17 == r29) goto L114;
        r31 = false;
    L259:
        e = e;
        r6 = this;
        goto L261
    L80:
        if (r24.length() == 0) goto L83;
        r113 = false;
        goto L85
    L64:
        if (r30.getLong("live.intent.extra.LOAD_DURATION", 0) > 0) goto L70;
        Bundle r122 = yt2.a.b(r30, "live.intent.extra.ENTER_LIVE_EXTRA");
        if (r122 != null) goto L69;
    L71:
        boolean r72 = false;
    L72:
        if (r72 == false) goto L74;
        r23 = "draw";
        goto L75
    L74:
        r23 = "click";
        goto L75
    L69:
        if (r122.getLong("live.intent.extra.LOAD_DURATION", 0) <= 0) goto L71;
    L70:
        r72 = true;
        goto L72
    L57:
        if (r30.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL) != VSConstants.VS_FIRST_SHOW) goto L59;
        boolean r73 = true;
    L60:
        g(r73);
        goto L61
    L59:
        r73 = false;
    L50:
        if (TextUtils.isEmpty(r17) == true) goto L264;
        if (TextUtils.isEmpty(r18) == false) goto L54;
    L264:
        return false;
    L36:
        if (r111.getCompoundSceneType() == 3) goto L39;
        return false;
    L28:
        if (r112.length() == 0) goto L31;
        r7 = false;
    L41:
        r21 = false;
        goto L43
    L40:
        r22 = r9;
        goto L41
    L22:
        r112 = null;
    L266:
        return false;
    L5:
        r10 = true;
        goto L7
    }

    @Override // as0.a
    public final void t(Context r3) {
        if ((!Intrinsics.areEqual(r3, this.d)) == false) goto L5;
        log("bind activity context : " + r3);
    L5:
        this.d = r3;
    }

    @Override // as0.a
    public final void v(Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, "bundle");
        boolean r0 = r9.getBoolean("live.intent.extra.IS_PSEUDO_LIVING", false);
        int r2 = r9.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL);
        int r3 = VSConstants.LIVE_NORMAL;
        if (r2 == r3) goto L6;
        r0 = false;
    L6:
        if (r9.getInt(VSConstants.EXTRA_ITEM_TYPE, r3) != VSConstants.VS_FIRST_SHOW) goto L8;
        boolean r4 = true;
    L9:
        boolean r5 = r9.getBoolean("live_player_stop_barrier", false);
        boolean r6 = !TextUtils.isEmpty(yt2.a.e(r9, "live.intent.extra.PULL_SHARE_URL"));
        boolean r10 = r9.getBoolean("share_player", r6);
        if (r6 == false) goto L50;
        if (r10 == false) goto L51;
        LivePlayerScene r11 = LivePlayerScene.INSTANCE;
        r11.getPREVIEW();
        ILivePlayerClient r7 = z().getClientWithIdentifier(String.valueOf(this.o));
        if (r7 != null) goto L15;
    L19:
        boolean r8 = false;
    L21:
        if (LivePlatformPlayerManager.g().getEnableV2() == false) goto L24;
        if (r8 == true) goto L24;
        g(r4);
        return;
    L24:
        if (r7 == null) goto L55;
        if (r0 == false) goto L28;
        r7.stop();
        return;
    L28:
        r7.setStopBarrier(r5);
        if (k() == false) goto L32;
        return;
    L32:
        if (r7.canShare() == true) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(this.b, r7) == false) goto L38;
        return;
    L38:
        if ((r7.getCurrentState() instanceof State.Playing) == true) goto L41;
        r7.stop();
        return;
    L41:
        if (this.b == null) goto L45;
        log("cur use share player! release not need player client!");
        ILivePlayerClient r1 = this.b;
        if (r1 == null) goto L45;
        r1.stop();
    L45:
        this.c = true;
        this.b = r7;
        r7.setShouldDestroy(false);
        ILivePlayerClient r12 = this.b;
        if (r12 == null) goto L48;
        r12.setUseScene(r11.getINNER_DRAW());
    L48:
        log("use shared player client");
        return;
    L55:
        return;
    L15:
        if (Intrinsics.areEqual(r7.context().getUseScene(), r11.getPREVIEW()) == false) goto L19;
        if (((PlayerInnerDrawerConfig) this.k.getValue()).getLynxSharePlayerAdapter() == false) goto L19;
        r8 = true;
        goto L21
    L51:
        return;
    L50:
        return;
    L8:
        r4 = false;
        goto L9
    }

    public final int c(Bundle r6, IBaseStreamUrl r7) {
        boolean r0 = true;
        if (r7 == null) goto L8;
        if (r7.isCompoundScene() != true) goto L8;
        return 1;
    L8:
        if (r7 != null) goto L30;
        if (r6 == null) goto L12;
        String r8 = r6.getString("live.intent.extra.PULL_ORIGIN_STREAM_URL_JSON");
    L13:
        if (r8 == null) goto L26;
        int r4 = d.a;
        if (Build.VERSION.SDK_INT < 24) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
        boolean r9 = false;
    L22:
        if (r9 == false) goto L26;
        if (StringsKt.contains$default(r8, "\"kind\":2", false, 2, null) == false) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L30;
        return 1;
    L21:
        r9 = ((PlayerTextureRenderConfig) wh0.a.getValue()).mDisableInnerPrePull;
        goto L22
    L18:
        r5 = false;
    L26:
        r10 = false;
        goto L27
    L12:
        r8 = null;
    L30:
        if (k() == true) goto L32;
    L35:
        boolean r11 = true;
    L36:
        if (r11 == false) goto L46;
        int r12 = d.a;
        if (Build.VERSION.SDK_INT >= 24) goto L41;
        r0 = false;
    L41:
        if (r0 == true) goto L43;
        boolean r13 = false;
    L44:
        if (r13 == false) goto L46;
        return 2;
    L43:
        r13 = ((PlayerTextureRenderConfig) wh0.a.getValue()).mDisableInnerPrePull;
    L46:
        return 0;
    L32:
        if (d.a() == true) goto L35;
        r11 = false;
        goto L36
    }

    @Override // as0.a
    public final boolean e(Context r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        as0.a r0 = LivePlatformPlayerManager.b();
        if (r0 == null) goto L5;
        Context r1 = r0.y();
    L6:
        boolean r2 = Intrinsics.areEqual(r1, r8);
        boolean r3 = false;
        if (r9 != null) goto L9;
    L43:
        if (r2 == false) goto L45;
        log("same context !skip pre create surface!");
    L45:
        return false;
    L9:
        if (this.o <= 0) goto L43;
        if (r2 == true) goto L43;
        int r4 = r9.getInt("live.intent.extra.ITEM_TYPE", -1);
        if (15 != r4) goto L15;
    L42:
        return r3;
    L15:
        if (16 == r4) goto L42;
        if (17 == r4) goto L42;
        v(r9);
        if (k() == false) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual("type_with_feed", r9.getString("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_TYPE")) == false) goto L25;
    L28:
        log("pre create surface");
        if (r9.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL) != VSConstants.VS_FIRST_SHOW) goto L31;
        boolean r5 = true;
    L32:
        g(r5);
        ILivePlayerClient r6 = this.b;
        if (r6 == null) goto L35;
        r3 = r6.preCreateSurface(r8);
    L35:
        if (r3 == false) goto L40;
        ILivePlayerClient r10 = this.b;
        if (r10 == null) goto L40;
        int r7 = is0.b.a;
        r10.registerPlayerFeature(is0.b.a.b("pre_create_surface"));
    L40:
        if (r9.getBoolean("live.intent.extra.EXTRA_LIVE_PRE_PULL_STREAM") == true) goto L42;
        r9.putBoolean("live.intent.extra.EXTRA_LIVE_PRE_PULL_STREAM", r3);
        goto L42
    L31:
        r5 = false;
        goto L32
    L25:
        if (Intrinsics.areEqual("type_no_feed", r9.getString("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_TYPE")) == true) goto L28;
        return false;
    L5:
        r1 = null;
        goto L6
    }

    @Override // as0.a
    public final void f(boolean r4, EndReason r5) {
        if (Intrinsics.areEqual(r5, EndReason.USER_CLOSE.INSTANCE) == true) goto L30;
        EndReason.JUMP_TO_OTHER_MIX_ROOM r0 = EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE;
        if (Intrinsics.areEqual(r5, r0) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.JUMP_TO_OTHER.INSTANCE) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.FINAL_CLEANUP.INSTANCE) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.PING_KICK_OUT.INSTANCE) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.USER_KICK_OUT.INSTANCE) == true) goto L30;
        if (Intrinsics.areEqual(r5, r0) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.FORCE_LOGIN_CANCEL.INSTANCE) == true) goto L30;
        if (Intrinsics.areEqual(r5, new EndReason.LIVE_END(false)) == true) goto L30;
        if (Intrinsics.areEqual(r5, new EndReason.LIVE_END_NO_INTERCEPT(false)) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.SLIDE_OUT.INSTANCE) == true) goto L30;
        if ((r5 instanceof EndReason.LIVE_DISTRIBUTION_EXIT) == true) goto L30;
        if (Intrinsics.areEqual(r5, EndReason.NEW_ROOM_CREATE.INSTANCE) == true) goto L30;
    L33:
        ILivePlayerClient r6 = this.b;
        if (r6 == null) goto L40;
        IRoomEventHub r7 = r6.getEventHub();
        if (r7 == null) goto L40;
        MutableLiveData r8 = r7.getReset();
        if (r8 == null) goto L40;
        r8.setValue(Boolean.valueOf(r4));
    L40:
        if (r4 == false) goto L72;
        if (LivePlatformPlayerManager.g().getEnableV2() == true) goto L44;
        ILivePlayerClient r9 = this.b;
        if (r9 == null) goto L70;
        r9.release();
    L70:
        this.c = false;
        this.b = null;
    L87:
        z().checkAudioMixedEvent(this.b, 3);
        return;
    L44:
        if (m() == true) goto L48;
        LivePlayerView r10 = A();
        if (r10 == null) goto L48;
        r10.disableDelayStopOrRelease();
    L48:
        LivePlayerView r11 = A();
        if (r11 == null) goto L51;
        r11.release();
    L55:
        if (((PlayerInnerDrawerConfig) this.k.getValue()).getPlayerReleaseCheck() == false) goto L70;
        if (A() == null) goto L70;
        LivePlayerView r12 = A();
        if (r12 == null) goto L61;
        ILivePlayerClient r13 = r12.getClient();
    L63:
        if ((!Intrinsics.areEqual(r13, this.b)) == false) goto L70;
        ILivePlayerClient r14 = this.b;
        if (r14 == null) goto L70;
        r14.release();
        goto L70
    L61:
        r13 = null;
        goto L63
    L51:
        ILivePlayerClient r15 = this.b;
        if (r15 == null) goto L55;
        r15.release();
        goto L55
    L72:
        if (LivePlatformPlayerManager.g().getEnableV2() == false) goto L79;
        LivePlayerView r16 = A();
        if (r16 == null) goto L76;
        r16.stop();
    L83:
        if (((PlayerConfig) LivePlatformPlayerManager.f.getValue()).getRemoveClientWhenStop() == false) goto L87;
        ILivePlayerClient r17 = this.b;
        if (r17 == null) goto L87;
        z().destroyClient(r17);
        goto L87
    L76:
        ILivePlayerClient r18 = this.b;
        if (r18 == null) goto L83;
        r18.stop();
        goto L83
    L79:
        ILivePlayerClient r19 = this.b;
        if (r19 == null) goto L83;
        r19.stop();
    L30:
        ILivePlayerClient r20 = this.b;
        if (r20 == null) goto L33;
        r20.setLiveRoomState(false);
        goto L33
    }

    @Override // as0.a
    public final void l(Context r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "context");
        if (Build.VERSION.SDK_INT < 29) goto L165;
        boolean r5 = r19 instanceof Activity;
        if (r5 == false) goto L166;
        ILivePlayerClient r0 = this.b;
        if (r0 == null) goto L163;
        if (r0.isVrLive() != true) goto L163;
        return;
    L163:
        Method r1 = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Exception -> L22
        r1.setAccessible(true);     // Catch: Exception -> L22
        View r9 = ((Activity) r19).getWindow().getDecorView();     // Catch: Exception -> L22
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L22
        Thread r10 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L22
        if (r10 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r10, "getDecorView");     // Catch: Exception -> L22
    L17:
        Object r2 = r1.invoke(r9, new Object[0]);     // Catch: Exception -> L22
        Method r11 = a().getDeclaredMethod("getSurfaceControl", new Class[0]);     // Catch: Exception -> L22
        r11.setAccessible(true);     // Catch: Exception -> L22
        Object r3 = r11.invoke(r2, new Object[0]);     // Catch: Exception -> L22
        if (r3 == null) goto L21;
        SurfaceControl r12 = (SurfaceControl) r3;     // Catch: Exception -> L22
    L24:
        if (r12 != null) goto L26;
        return;
    L26:
        if (r12.isValid() == true) goto L29;
        return;
    L29:
        if (r20 == null) goto L104;
        String r4 = yt2.a.e(r20, "live.intent.extra.PULL_STREAM_DATA");
        String r13 = yt2.a.e(r20, "live.intent.extra.PULL_SHARE_URL");
        if (TextUtils.isEmpty(r13) == true) goto L34;
        r4 = r13;
    L34:
        if (r4 != null) goto L36;
    L39:
        boolean r14 = true;
    L40:
        if (r14 == true) goto L104;
        JSONObject r6 = StreamDataUtil.INSTANCE.getStreamDataObject(r4);     // Catch: JSONException -> L79
        JSONObject r15 = r6.optJSONObject("common");     // Catch: JSONException -> L79
        String r16 = "";
        if (r15 == null) goto L49;
        JSONObject r17 = r15.optJSONObject("common_sdk_params");     // Catch: JSONException -> L79
        if (r17 == null) goto L49;
        String r18 = r17.optString("main");     // Catch: JSONException -> L79
        if (r18 == null) goto L49;
    L51:
        if (r18.length() <= 0) goto L53;
        boolean r110 = true;
    L54:
        if (r110 == false) goto L56;
        JSONObject r111 = new JSONObject(r18);     // Catch: JSONException -> L79
    L57:
        JSONObject r7 = r6.optJSONObject("data");     // Catch: JSONException -> L79
        if (r7 == null) goto L65;
        JSONObject r8 = r7.optJSONObject("origin");     // Catch: JSONException -> L79
        if (r8 == null) goto L65;
        JSONObject r21 = r8.optJSONObject("main");     // Catch: JSONException -> L79
        if (r21 == null) goto L65;
        String r22 = r21.optString("sdk_params");     // Catch: JSONException -> L79
        if (r22 == null) goto L65;
    L66:
        JSONObject r112 = new JSONObject(r22);     // Catch: JSONException -> L79
        if (r111 != null) goto L70;
    L74:
        String r23 = r112.optString("resolution");     // Catch: JSONException -> L79
        if (r23 == null) goto L78;
    L77:
        r16 = r23;
    L78:
        String r113 = r16;
    L81:
        if (r113 == null) goto L83;
        List r24 = StringsKt.split$default(r113, new char[]{'x'}, false, 0, 6, null);
    L84:
        List r25 = r24;
        if (r25 != null) goto L87;
    L90:
        boolean r26 = true;
    L91:
        if (r26 == true) goto L104;
        if (r24.size() != 2) goto L104;
        Integer r27 = StringsKt.toIntOrNull((String) ListProtector.get(r24, 0));
        if (r27 == null) goto L98;
        int r28 = r27.intValue();
    L99:
        Integer r29 = StringsKt.toIntOrNull((String) ListProtector.get(r24, 1));
        if (r29 == null) goto L102;
        int r30 = r29.intValue();
    L103:
        Pair r31 = TuplesKt.to(Integer.valueOf(r28), Integer.valueOf(r30));
    L105:
        if (r31 != null) goto L108;
        return;
    L108:
        if (((Number) r31.getFirst()).intValue() < ((Number) r31.getSecond()).intValue()) goto L110;
        return;
    L110:
        if (((Number) r31.getFirst()).intValue() != 0) goto L112;
        return;
    L112:
        if (((Number) r31.getSecond()).intValue() == 0) goto L176;
        if (r20 == null) goto L116;
        r20.putBoolean("live_head_enter_smooth", true);
    L116:
        IMiddleHostService r32 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r32 == null) goto L123;
        IMiddleWareHostContext r33 = r32.appContext();
        if (r33 == null) goto L123;
        if (r33.isTransparentStatusBar() != true) goto L123;
        boolean r34 = true;
    L124:
        if (r5 == false) goto L136;
        t r35 = t.a;
        int r114 = t.i();
        int r36 = r35.e(r19);
        Activity r115 = (Activity) r19;
        int r116 = t.g(r115);
        if (r34 == false) goto L129;
        int r117 = t.f(r115);
    L130:
        int r118 = r117 - r36;
        int r37 = ((Number) r31.getFirst()).intValue();
        float r119 = r118;
        float r120 = r116;
        float r121 = r119 / r120;
        float r38 = ((Number) r31.getSecond()).intValue();
        float r39 = r37;
        if ((r38 / r39) <= r121) goto L133;
        r118 = (int) (r38 * (r120 / r39));
    L134:
        r31 = TuplesKt.to(Integer.valueOf(r116), Integer.valueOf(r118));
        goto L136
    L133:
        r116 = (int) (r39 * (r119 / r38));
        goto L134
    L129:
        r117 = t.f(r115) - r114;
    L136:
        if (((Number) r31.getFirst()).intValue() > 0) goto L138;
        return;
    L138:
        if (((Number) r31.getSecond()).intValue() > 0) goto L141;
        return;
    L141:
        if (k() == true) goto L148;
        if (r20 != null) goto L144;
    L146:
        boolean r40 = false;
    L147:
        g(r40);
        goto L148
    L144:
        if (r20.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL) != VSConstants.VS_FIRST_SHOW) goto L146;
        r40 = true;
    L148:
        ILivePlayerClient r41 = this.b;
        if (r41 == null) goto L171;
        SurfaceControl r42 = r41.useSurfaceControl(((Number) r31.getFirst()).intValue(), ((Number) r31.getSecond()).intValue());
        if (r42 != null) goto L154;
        return;
    L154:
        if (r12.isValid() == true) goto L156;
        return;
    L156:
        if (r42.isValid() == false) goto L173;
        int r43 = ((Number) r31.getFirst()).intValue();
        t r122 = t.a;
        int r44 = (-(r43 - t.g((Activity) r19))) / 2;
        if (r34 == false) goto L160;
        int r45 = 0;
    L161:
        new SurfaceControl.Transaction().reparent(r42, r12).setVisibility(r42, true).setGeometry(r42, null, new Rect(r44, r45, ((Number) r31.getFirst()).intValue(), ((Number) r31.getSecond()).intValue()), 0).apply();
        return;
    L160:
        r45 = t.i();
        goto L161
    L173:
        return;
    L171:
        return;
    L123:
        r34 = false;
        goto L124
    L176:
        return;
    L102:
        r30 = 0;
        goto L103
    L98:
        r28 = 0;
        goto L99
    L87:
        if (r25.isEmpty() == true) goto L90;
        r26 = false;
        goto L91
    L83:
        r24 = null;
        goto L84
    L70:
        if (r111.has("resolution") != true) goto L74;
        r23 = r111.optString("resolution");     // Catch: JSONException -> L79
        if (r23 != null) goto L77;
    L65:
        r22 = "";
        goto L66
    L56:
        r111 = null;
        goto L57
    L53:
        r110 = false;
    L49:
        r18 = "";
    L79:
        e = move-exception;
        ALogger.e("LivePlatformPlayer", "parse videoSize error", e);
        r113 = null;
        goto L81
    L36:
        if (r4.length() == 0) goto L39;
        r14 = false;
    L104:
        r31 = null;
        goto L105
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceControl");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ALogger.e("LivePlatformPlayer", "get surfaceControl error", e);
        r12 = null;
        goto L24
    L166:
        return;
    }

    @Override // as0.a
    public final boolean u(String r3, RoomSession r4) {
        Intrinsics.checkNotNullParameter(r3, "resolution");
        Intrinsics.checkNotNullParameter(r4, "session");
        LiveRequest r5 = new LiveRequest.Builder().streamData(r4.getPullData()).resolution(r3).textureRenderMode(c(r4.getExtra(), r4.getStreamUrl())).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r4.getStreamType())).build();
        StreamUrl r0 = r4.getStreamUrl();
        if (r0 == null) goto L5;
        int r6 = r0.getVrType();
    L6:
        r5.setVrType(r6);
        r5.setVrEffectConfigBuilder(C(this.b));
        ILivePlayerClient r7 = this.b;
        if (r7 != null) goto L9;
        return false;
    L9:
        return r7.prePrepare(r5);
    L5:
        r6 = r4.getExtra().getInt("live.intent.extra.VR_ROOM_TYPE", 0);
        goto L6
    }

    public final LivePlayerConfig b(long r18, boolean r20, boolean r21) {
        if (r20 == false) goto L5;
        PlayerClientType r1 = PlayerClientType.FIRST_SHOW;
    L7:
        if (this.f != null) goto L10;
        this.f = new LivePlayerConfig(LivePlayerScene.INSTANCE.getINNER_DRAW(), String.valueOf(r18), r1, true, null, true, false, null, false, 0, false, 976, null);
    L10:
        if (r21 == false) goto L12;
        IRenderView.RenderViewType r2 = IRenderView.RenderViewType.SURFACE_VIEW;
    L13:
        IRenderView.RenderViewType r10 = r2;
        LivePlayerConfig r3 = this.f;
        if (r3 == null) goto L16;
        r3.setRenderViewType(r10);
    L16:
        LivePlayerConfig r4 = this.f;
        if (r4 == null) goto L19;
        return r4;
    L19:
        return new LivePlayerConfig(LivePlayerScene.INSTANCE.getINNER_DRAW(), String.valueOf(r18), r1, true, null, true, false, r10, false, 0, false, 848, null);
    L12:
        r2 = IRenderView.RenderViewType.TEXTURE_VIEW;
        goto L13
    L5:
        r1 = PlayerClientType.NORMAL;
        goto L7
    }

    @Override // as0.a
    public final boolean x(LiveMode r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "streamType");
        if (((Boolean) fn.a.getValue()).booleanValue() == false) goto L12;
        if (k() == true) goto L7;
    L19:
        boolean r9 = false;
    L20:
        if (r7 == false) goto L22;
    L21:
        boolean r10 = true;
    L29:
        if (r9 == false) goto L33;
        if (r10 == false) goto L34;
        return true;
    L34:
        return false;
    L33:
        return false;
    L22:
        ILivePlayerClient r11 = this.b;
        if (r11 == null) goto L28;
        if (r11 == null) goto L28;
        if (r11.isRtsStream() == false) goto L21;
    L28:
        r10 = false;
        goto L29
    L7:
        if (r4 == LiveMode.AUDIO) goto L19;
        if (r5 == false) goto L19;
        if (r6 == false) goto L19;
    L10:
        r9 = true;
        goto L20
    L12:
        if (k() == false) goto L19;
        if (r4 == LiveMode.AUDIO) goto L19;
        if (r5 == false) goto L19;
        if (r6 == false) goto L19;
        if (r8 == true) goto L19;
        goto L19
    }

    @Override // as0.a
    public final LivePlayerView s(Context r3, long r4, boolean r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r7 == false) goto L29;
        ILivePlayerClient r0 = this.b;
        if (r0 == null) goto L7;
        IRenderView r1 = r0.getRenderView();
    L9:
        if ((r1 instanceof SurfaceView) == true) goto L29;
        if (r8 == true) goto L29;
        ILivePlayerClient r10 = this.b;
        if (r10 == null) goto L18;
        IRenderView r11 = r10.getRenderView();
        if (r11 == null) goto L18;
        View r12 = r11.getSelfView();
        if (r12 == null) goto L18;
        r12.setVisibility(8);
    L18:
        ILivePlayerClient r13 = this.b;
        if (r13 == null) goto L29;
        ILivePlayerMultiRenderController r14 = r13.multiRenderController();
        if (r14 == null) goto L29;
        if (r14.isEnable() != true) goto L29;
        ILivePlayerClient r15 = this.b;
        if (r15 == null) goto L29;
        IExtraRenderView r16 = r15.getExtraRenderView();
        if (r16 == null) goto L29;
        r16.setVisibility(8);
        goto L29
    L7:
        r1 = null;
    L29:
        LivePlayerConfig r5 = b(r4, false, r6);
        if (k() == false) goto L34;
        if (r6 == false) goto L34;
        if (r7 == true) goto L34;
        r5.setRenderViewType(IRenderView.RenderViewType.TEXTURE_VIEW);
    L34:
        r5.setClient(g(false));
        r5.setReusePreSceneTextureRenderView(r9);
        LivePlayerView r17 = new LivePlayerView(r3, r5);
        if (((PlayerInnerDrawerConfig) this.k.getValue()).getPlatformLeakOptimize() == false) goto L37;
        this.i = new WeakReference(r17);
    L38:
        return r17;
    L37:
        this.j = r17;
        goto L38
    }
}
