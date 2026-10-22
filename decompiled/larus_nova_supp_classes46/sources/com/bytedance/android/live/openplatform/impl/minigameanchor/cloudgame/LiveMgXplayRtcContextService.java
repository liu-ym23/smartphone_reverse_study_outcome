package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import yq0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/cloudgame/LiveMgXplayRtcContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMgXplayRtcContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int k = 0;
    public e.a a;
    public ei6.a b;
    public boolean c;
    public d d;
    public final Set<String> e;
    public int f;
    public int g;
    public final AnchorMiniGameAppLogContextService h;
    public boolean i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final void g() {
        if (this.c == false) goto L36;
        ei6.a r0 = this.b;
        if (r0 == null) goto L9;
        si6.b r1 = r0.b();
        if (r1 == null) goto L9;
        si6.a.b(r1, false, "MgXplay", 3);
    L9:
        Iterator<String> r2 = this.e.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        String r3 = r2.next();
        ei6.a r4 = this.b;
        if (r4 == null) goto L11;
        gi6.e r5 = r4.getEventManager();
        if (r5 == null) goto L11;
        r5.c(r3);
        goto L11
    L17:
        this.e.clear();
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L24;
        j r7 = r6.getLiveStream();
        if (r7 == null) goto L24;
        com.bytedance.android.live.pushstream.d r8 = (com.bytedance.android.live.pushstream.d) r7.getValue();
        if (r8 == null) goto L24;
        r8.r1();
    L24:
        d r9 = this.d;
        if (r9 == null) goto L27;
        r9.a = false;
    L27:
        this.c = false;
        qo0.a.c("LiveMgXplayRtcContextService", "leaveRTCRoom");
        return;
    }

    public LiveMgXplayRtcContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.e = new LinkedHashSet();
        this.h = (AnchorMiniGameAppLogContextService) r2.getService(AnchorMiniGameAppLogContextService.class);
        this.j = LazyKt.lazy(new LiveMgXplayRtcContextService$mRtcListener$2(this));
    }

    public final void i(JsonObject r8, Rect r9) {
        Intrinsics.checkNotNullParameter(r8, "jsonObject");
        Intrinsics.checkNotNullParameter(r9, "liveCastRect");
        if (r8.has("width") == true) goto L5;
        return;
    L5:
        if (r8.has("height") == false) goto L15;
        int r2 = r8.get("width").getAsInt() * r8.get("height").getAsInt();
        double r3 = ((double) r9.width()) / ((double) r9.height());
        int r10 = (int) Math.sqrt(((double) r2) / r3);
        this.g = r10;
        int r4 = (int) (((double) r10) * r3);
        this.f = r4;
        if (r4 > 1920) goto L9;
        if (r10 > 1920) goto L9;
    L12:
        r8.addProperty("width", Integer.valueOf(this.f));
        r8.addProperty("height", Integer.valueOf(this.g));
        int r11 = qo0.a.a;
        qo0.a.c("LiveMgXplayRtcContextService", "canvasW = " + this.f + ", canvasH = " + this.g);
        return;
    L9:
        if (r4 <= r10) goto L11;
        this.f = 1920;
        this.g = (int) (((double) 1920) / r3);
        goto L12
    L11:
        this.g = 1920;
        this.f = (int) (((double) 1920) * r3);
        goto L12
    }

    public static void f(final LiveMgXplayRtcContextService r12, boolean r13, Rect r14) {
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "liveCastRect");
        e.a r1 = r12.a;
        if (r1 == null) goto L7;
        e.b r2 = r1.b();
        if (r2 == null) goto L7;
        String r3 = r2.a();
    L8:
        if (r3 != null) goto L11;
        r12.h("0", "401", "rtc info null", "start");
        return;
    L11:
        if (r12.c == true) goto L138;
        r12.i = r13;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L22;
        j r5 = r4.getLiveStream();
        if (r5 == null) goto L22;
        com.bytedance.android.live.pushstream.d r6 = (com.bytedance.android.live.pushstream.d) r5.getValue();
        if (r6 == null) goto L22;
        d0 r7 = r6.getLiveCore();
        if (r7 == null) goto L22;
        r7.h();
    L22:
        fi6.a r8 = new fi6.a();
        e.a r9 = r12.a;
        if (r9 == null) goto L27;
        e.b r10 = r9.b();
        if (r10 == null) goto L27;
        String r11 = r10.a();
    L28:
        Intrinsics.checkNotNullParameter(r14, "liveCastRect");
        int r0 = qo0.a.a;
        qo0.a.c("LiveMgXplayRtcContextService", "rtcExtInfo = " + r11);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L31
        JsonObject r16 = (JsonObject) GsonHelper.get().fromJson(r11, JsonObject.class);     // Catch: Throwable -> L31
        JsonObject r17 = r16.getAsJsonObject("live_rtc_video_param");     // Catch: Throwable -> L31
        r12.i(r17.getAsJsonObject("rtc_video_param_server_define"), r14);     // Catch: Throwable -> L31
        r12.i(r17.getAsJsonObject("rtc_mix_param").getAsJsonObject("mix_video_param_server"), r14);     // Catch: Throwable -> L31
        String r18 = GsonHelper.get().toJson(r16);     // Catch: Throwable -> L31
        qo0.a.c("LiveMgXplayRtcContextService", "newRtcExtInfo = " + r18);     // Catch: Throwable -> L31
        r11 = r18;
    L33:
        e.a r19 = r12.a;
        if (r19 == null) goto L48;
        e.b r20 = r19.b();
        if (r20 == null) goto L48;
        String r21 = r20.a();
        if (r21 == null) goto L48;
        Intrinsics.checkNotNullParameter(r21, "rtcExtInfo");
        if (TextUtils.isEmpty(r21) == true) goto L48;
        r r22 = new r(0);     // Catch: Exception -> L45
        JSONObject r23 = new JSONObject(r21);     // Catch: Exception -> L45
        JSONObject r24 = r23.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L45
        if (r24 == null) goto L46;
        String r110 = r24.optString("rtc_app_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Exception -> L45
        r22.b = r110;     // Catch: Exception -> L45
        String r111 = r24.optString("rtc_token");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r111, "<set-?>");     // Catch: Exception -> L45
        r22.g = r111;     // Catch: Exception -> L45
        r22.c = r24.optInt("rtc_vendor");     // Catch: Exception -> L45
        r22.e = Base64.decode(r24.optString("rtc_app_sign"), 0);     // Catch: Exception -> L45
        String r112 = r24.optString("rtc_channel_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r112, "<set-?>");     // Catch: Exception -> L45
        r22.f = r112;     // Catch: Exception -> L45
        String r113 = r24.optString("rtc_user_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r113, "<set-?>");     // Catch: Exception -> L45
        r22.i = r113;     // Catch: Exception -> L45
        r22.j = r24.optInt("rtc_user_id_mode");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter("byte", "<set-?>");     // Catch: Exception -> L45
        r22.d = "byte";     // Catch: Exception -> L45
        String r25 = r24.optString("user_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r25, "<set-?>");     // Catch: Exception -> L45
        r22.h = r25;     // Catch: Exception -> L45
    L46:
        String r26 = r23.optString("rtc_business_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r26, "<set-?>");     // Catch: Exception -> L45
        r22.k = r26;     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r21, "<set-?>");     // Catch: Exception -> L45
        r22.a = r21;     // Catch: Exception -> L45
    L49:
        r12.d = new d(r8, r22, new Pair(Integer.valueOf(r12.f), Integer.valueOf(r12.g)), r14);
        if (r4 == null) goto L58;
        m r114 = r4.getRoom();
        if (r114 == null) goto L58;
        Room r115 = (Room) r114.getValue();
        if (r115 == null) goto L58;
        StreamUrl r116 = r115.getStreamUrl();
        if (r116 == null) goto L58;
        String r117 = r116.getRtmpPushUrl();
    L59:
        r8.e = r117;
        r8.f = r12.d;
        r8.j(MixStreamType.SERVER_MIX);
        r8.g(Character.ANCHOR);
        String r118 = String.valueOf(r11);
        Intrinsics.checkNotNullParameter(r118, "info");
        r8.v = r118;
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r8.w = "douyin_live";
        r8.n(StreamType.VIDEO);
        r8.O = false;
        IMiddleWareHostContext r119 = k.f(IMiddleWareHostContext.class);
        if (r119 == null) goto L62;
        String r120 = r119.getChannel();
    L63:
        String r121 = String.valueOf(r120);
        Intrinsics.checkNotNullParameter(r121, "channel");
        r8.y = r121;
        IMiddleWareHostContext r122 = k.f(IMiddleWareHostContext.class);
        if (r122 == null) goto L66;
        Integer r123 = Integer.valueOf(r122.appId());
    L67:
        String r124 = String.valueOf(r123);
        Intrinsics.checkNotNullParameter(r124, "id");
        r8.z = r124;
        IMiddleWareHostContext r125 = k.f(IMiddleWareHostContext.class);
        if (r125 == null) goto L70;
        String r126 = r125.getVersionCode();
    L71:
        String r127 = String.valueOf(r126);
        Intrinsics.checkNotNullParameter(r127, "version");
        r8.A = r127;
        IMiddleWareHostContext r128 = k.f(IMiddleWareHostContext.class);
        if (r128 == null) goto L74;
        Integer r129 = Integer.valueOf(r128.getUpdateVersionCode());
    L75:
        String r130 = String.valueOf(r129);
        Intrinsics.checkNotNullParameter(r130, "version");
        r8.B = r130;
        r8.h(r12.getOpenPlatformContext().getContext());
        r8.W = false;
        r8.p = true;
        LiveWrappedMixedStreamPushMode r27 = LiveWrappedMixedStreamPushMode.ON_START_REQUEST;
        Intrinsics.checkNotNullParameter(r27, "mTargetPushStreamMode");
        r8.q = r27;
        if (r4 == null) goto L82;
        j r28 = r4.getLiveStream();
        if (r28 == null) goto L82;
        com.bytedance.android.live.pushstream.d r29 = (com.bytedance.android.live.pushstream.d) r28.getValue();
        if (r29 == null) goto L82;
        ei6.a r30 = r29.g1(r8);
    L83:
        r12.b = r30;
        if (r30 == null) goto L91;
        si6.b r31 = r30.b();
        if (r31 == null) goto L91;
        if (r22 == null) goto L89;
        String r32 = r22.k;
    L90:
        r31.g(r32);
        goto L91
    L89:
        r32 = null;
    L91:
        ei6.a r33 = r12.b;
        if (r33 == null) goto L98;
        xi6.c r34 = r33.t();
        if (r34 == null) goto L98;
        com.bytedance.live.livelink.kmp.impl.core.video.b r35 = r34.f();
        if (r35 == null) goto L98;
        r35.j(true);
    L98:
        ei6.a r36 = r12.b;
        if (r36 == null) goto L103;
        gi6.e r37 = r36.getEventManager();
        if (r37 == null) goto L103;
        r37.b((LiveMgXplayRtcContextService$mRtcListener$2.AnonymousClass1) r12.j.getValue());
    L103:
        ei6.a r38 = r12.b;
        if (r38 == null) goto L110;
        gi6.e r39 = r38.getEventManager();
        if (r39 == null) goto L110;
        String r40 = r39.a(EventCategory.RTC_ENGINE_EVENT, null, new LiveMgXplayRtcContextService$joinRTCRoom$2(r12));
        if (r40 == null) goto L110;
        r12.e.add(r40);
    L110:
        ei6.a r41 = r12.b;
        if (r41 == null) goto L115;
        vi6.a r42 = r41.v();
        if (r42 == null) goto L115;
        r42.f();
    L115:
        ei6.a r43 = r12.b;
        if (r43 == null) goto L120;
        si6.b r44 = r43.b();
        if (r44 == null) goto L120;
        si6.a.a(r44, bj6.a.b(r12.b), false, 14);
    L120:
        r12.c = true;
        qo0.a.c("LiveMgXplayRtcContextService", "joinRTCRoom");
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r131 = AnchorMiniGameDataContext.a.a();
        if (r131 == null) goto L129;
        m<Rect> r132 = r131.getLittleWindowRect();
        if (r132 == null) goto L129;
        Observable r133 = r132.a();
        if (r133 == null) goto L129;
        Disposable r134 = r133.subscribe(new com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.a(r12));
        if (r134 == null) goto L129;
        r12.autoDispose(r134);
    L129:
        if (r13 == false) goto L137;
        r12.h("1", "", "", "localFirstFrame");
        return;
    L137:
        return;
    L82:
        r30 = null;
        goto L83
    L74:
        r129 = null;
        goto L75
    L70:
        r126 = null;
        goto L71
    L66:
        r123 = null;
        goto L67
    L62:
        r120 = null;
    L58:
        r117 = null;
    L48:
        r22 = null;
    L31:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        r11 = null;
        goto L28
    L138:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void h(String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "status");
        Intrinsics.checkNotNullParameter(r6, "errCode");
        Intrinsics.checkNotNullParameter(r7, "errMsg");
        Intrinsics.checkNotNullParameter(r8, "phase");
        AnchorMiniGameAppLogContextService r2 = this.h;
        HashMap<String, String> r3 = new HashMap();
        r3.put("status", r5);
        r3.put("error_code", r6);
        r3.put("error_msg", r7);
        r3.put("phase", r8);
        Unit r9 = Unit.INSTANCE;
        r2.reportLiveRoomMgAppLog("live_mg_server_merge_start", r3);
    }
}
