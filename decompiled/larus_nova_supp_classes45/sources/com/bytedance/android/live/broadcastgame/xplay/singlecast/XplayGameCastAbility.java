package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.api.xplay.q;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.broadcastgame.api.xplay.s;
import com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService;
import com.bytedance.android.live.broadcastgame.xplay.XplayApi;
import com.bytedance.android.live.broadcastgame.xplay.XplayErrorCode;
import com.bytedance.android.live.broadcastgame.xplay.XplayException;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.live.broadcastgame.xplay.e;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.broadcastgame.xplay.servermergecast.XplayRTCManager;
import com.bytedance.android.live.broadcastgame.xplay.servermergecast.XplayRTCManager$mRtcListener$2;
import com.bytedance.android.live.broadcastgame.xplay.servermergecast.f;
import com.bytedance.android.live.broadcastgame.xplay.servermergecast.g;
import com.bytedance.android.live.broadcastgame.xplay.servermergecast.h;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.wz0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.rtc.PublicStreamType;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayGameCastAbility implements o {
    public static final /* synthetic */ int j = 0;
    public final CompositeDisposable a;
    public IXplayGameCastService.IGameCastSession b;
    public final p c;
    public final IXplayCoreService d;
    public final e e;
    public final IXplayGameCastService f;
    public final k20.b g;
    public final XplayRTCManager h;
    public final XplayMonitorSession i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ XplayGameCastAbility a;

        public b(XplayGameCastAbility r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            XplayException r6 = (XplayException) r5;
            XplayLog.c("XplayGameCastAbility", "failed rollback to single cast game");
            XplayMonitorSession r0 = this.a.i;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "throwable");
            r0.j(0, r6.getErrorInfo());
            final XplayGameCastAbility r7 = this.a;
            p r1 = r7.c;
            s r2 = r1.j;
            if (r2 != null) goto L5;
        L7:
            r7.h.a();
            r7.d.updateEnableVideoFrame(true);
            r7.d.R();
            r7.d(true);
            if (v.a() == false) goto L10;
            f2.c("回退到客户端合流", 0);
        L10:
            f2.g();
            return;
        L5:
            if (r2.h != true) goto L7;
            q1.h(r1, 2131923520, s1.B(2131923521), false, new XplayGameCastAbility$showQuitDialog$1(r7));
        }
    }

    public final class c implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final Pair<Integer, Integer> a() {
        IXplayCoreService.a r0 = this.d.U();
        if (r0 != null) goto L6;
        XplayLog.b("XplayGameCastAbility", "cannot calculate stream size because startParams is null");
        return null;
    L6:
        Pair r3 = TuplesKt.to(Integer.valueOf(r0.c), Integer.valueOf(r0.d));
        Pair r1 = TuplesKt.to(Integer.valueOf(r0.e), Integer.valueOf(r0.f));
        if (f(r3, "displaySize") == true) goto L10;
        return null;
    L10:
        if (f(r3, "contentRatio") == true) goto L12;
        return null;
    L12:
        double r4 = Math.min(((double) ((Number) r3.getFirst()).intValue()) / ((Number) r1.getFirst()).doubleValue(), ((double) ((Number) r3.getSecond()).intValue()) / ((Number) r1.getSecond()).doubleValue());
        Pair<Integer, Integer> r2 = TuplesKt.to(Integer.valueOf(MathKt.roundToInt(((Number) r1.getFirst()).doubleValue() * r4)), Integer.valueOf(MathKt.roundToInt(((Number) r1.getSecond()).doubleValue() * r4)));
        int r5 = XplayLog.a;
        XplayLog.c("XplayGameCastAbility", "displaySize = " + r3 + ", contentRatio = " + r1 + ", streamSize = " + r2);
        return r2;
    }

    public final void onStart() {
        XplayApi.j r0 = this.e.getRtcInfo();
        if (r0 == null) goto L179;
        if (r0.b() != null) goto L7;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L179;
        if (q1.d() == false) goto L179;
        q0 r5 = this.c.h.l;
        if (r5 == null) goto L179;
        if (r5.f() == true) goto L179;
        XplayLog.c("XplayGameCastAbility", "start server merge single cast");
        Pair<Integer, Integer> r1 = a();
        if (r1 == null) goto L177;
        XplayRTCManager r6 = this.h;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "xplayCanvasSize");
        Intrinsics.checkNotNullParameter(r0, "rtcInfo");
        XplayLog.c("XplayRTCManager", "start join RTC room, rtcExtInfo: " + r0);
        r6.f = r1;
        XplayApi.k r2 = r0.b();
        ei6.a r7 = null;
        if (r2 == null) goto L40;
        String r3 = r2.b();
        if (r3 == null) goto L40;
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        if (TextUtils.isEmpty(r3) == true) goto L40;
        r r11 = new r(0);     // Catch: Exception -> L37
        JSONObject r12 = new JSONObject(r3);     // Catch: Exception -> L37
        JSONObject r13 = r12.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L37
        if (r13 == null) goto L38;
        String r14 = r13.optString("rtc_app_id");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r14, "<set-?>");     // Catch: Exception -> L37
        r11.b = r14;     // Catch: Exception -> L37
        String r15 = r13.optString("rtc_token");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r15, "<set-?>");     // Catch: Exception -> L37
        r11.g = r15;     // Catch: Exception -> L37
        r11.c = r13.optInt("rtc_vendor");     // Catch: Exception -> L37
        r11.e = Base64.decode(r13.optString("rtc_app_sign"), 0);     // Catch: Exception -> L37
        String r16 = r13.optString("rtc_channel_id");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r16, "<set-?>");     // Catch: Exception -> L37
        r11.f = r16;     // Catch: Exception -> L37
        String r17 = r13.optString("rtc_user_id");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r17, "<set-?>");     // Catch: Exception -> L37
        r11.i = r17;     // Catch: Exception -> L37
        r11.j = r13.optInt("rtc_user_id_mode");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter("byte", "<set-?>");     // Catch: Exception -> L37
        r11.d = "byte";     // Catch: Exception -> L37
        String r18 = r13.optString("user_id");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r18, "<set-?>");     // Catch: Exception -> L37
        r11.h = r18;     // Catch: Exception -> L37
    L38:
        String r19 = r12.optString("rtc_business_id");     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r19, "<set-?>");     // Catch: Exception -> L37
        r11.k = r19;     // Catch: Exception -> L37
        Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Exception -> L37
        r11.a = r3;     // Catch: Exception -> L37
    L41:
        r6.a = r11;
        XplayApi.i r8 = r0.a();
        if (r8 == null) goto L50;
        String r9 = r8.a();
        if (r9 == null) goto L50;
        PublishSubject<Unit> r21 = q1.a;
        Intrinsics.checkNotNullParameter(r9, "rtcExtInfo");
        if (TextUtils.isEmpty(r9) == true) goto L50;
        q r22 = new q(0);     // Catch: Exception -> L49
        JSONObject r23 = new JSONObject(r9);     // Catch: Exception -> L49
        String r24 = r23.optString("wtnToken");     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r24, "<set-?>");     // Catch: Exception -> L49
        r22.a = r24;     // Catch: Exception -> L49
        String r25 = r23.optString("wtnStreamId");     // Catch: Exception -> L49
        Intrinsics.checkNotNullParameter(r25, "<set-?>");     // Catch: Exception -> L49
        r22.b = r25;     // Catch: Exception -> L49
    L51:
        r6.b = r22;
        if (r22 == null) goto L54;
        String r26 = r22.a;
    L56:
        if (r2.a(r26) == false) goto L68;
        q r27 = r6.b;
        if (r27 == null) goto L60;
        String r28 = r27.b;
    L62:
        if (r2.a(r28) == false) goto L68;
        s r29 = r6.n.j;
        if (r29 == null) goto L68;
        if (r29.g != true) goto L68;
        boolean r31 = true;
    L69:
        r6.e = r31;
        s r32 = r6.n.j;
        if (r32 != null) goto L72;
    L74:
        XplayLog.c("XplayRTCManager", "start send sei");
        RxUtilKt.c(Observable.interval(2000, TimeUnit.MILLISECONDS).subscribe(new f(r6)), r6.i);
    L76:
        if (r6.d == true) goto L172;
        int r33 = XplayLog.a;
        XplayLog.c("XplayRTCManager", "start init rtc engine, xplay rtc engine config: " + r6.a);
        RoomContext r34 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        p r110 = r6.n;
        Pair<Integer, Integer> r111 = r6.f;
        if (r111 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("xplayCanvasSize");
    L81:
        r6.c = new g(r110, r111, r6.q, r6.a);
        r r35 = r6.a;
        if (r35 == null) goto L172;
        fi6.a r36 = new fi6.a();
        r36.f = r6.c;
        if (r34 == null) goto L92;
        m r112 = r34.getRoom();
        if (r112 == null) goto L92;
        Room r113 = (Room) r112.getValue();
        if (r113 == null) goto L92;
        StreamUrl r114 = r113.getStreamUrl();
        if (r114 == null) goto L92;
        String r115 = r114.getRtmpPushUrl();
    L93:
        r36.e = r115;
        r36.h(TTMiddlewareLiveSDK.getContext());
        r36.m(r35.a);
        r36.S = 5;
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r36.w = "douyin_live";
        r36.g(Character.ANCHOR);
        r36.n(StreamType.VIDEO);
        r36.O = false;
        IMiddleWareHostContext r116 = k.f(IMiddleWareHostContext.class);
        if (r116 == null) goto L96;
        String r117 = r116.getChannel();
    L97:
        String r118 = String.valueOf(r117);
        Intrinsics.checkNotNullParameter(r118, "channel");
        r36.y = r118;
        IMiddleWareHostContext r119 = k.f(IMiddleWareHostContext.class);
        if (r119 == null) goto L100;
        Integer r120 = Integer.valueOf(r119.appId());
    L101:
        String r121 = String.valueOf(r120);
        Intrinsics.checkNotNullParameter(r121, "id");
        r36.z = r121;
        IMiddleWareHostContext r122 = k.f(IMiddleWareHostContext.class);
        if (r122 == null) goto L104;
        String r123 = r122.getVersionCode();
    L105:
        String r124 = String.valueOf(r123);
        Intrinsics.checkNotNullParameter(r124, "version");
        r36.A = r124;
        IMiddleWareHostContext r125 = k.f(IMiddleWareHostContext.class);
        if (r125 == null) goto L108;
        Integer r126 = Integer.valueOf(r125.getUpdateVersionCode());
    L109:
        String r127 = String.valueOf(r126);
        Intrinsics.checkNotNullParameter(r127, "version");
        r36.B = r127;
        r36.j(MixStreamType.SERVER_MIX);
        r36.W = false;
        g r128 = r6.c;
        if (r128 == null) goto L120;
        boolean r129 = r6.e;
        q r130 = r6.b;
        if (r130 == null) goto L114;
        String r131 = r130.b;
    L115:
        Intrinsics.checkNotNullParameter(r36, "config");
        r128.a = r36;
        r128.c = r129;
        r128.f = r131;
        s r132 = r128.h.j;
        if (r132 == null) goto L120;
        if (r132.g != true) goto L120;
        XplayLog.c("XplayStreamMixer", "start send sei");
        RxUtilKt.c(Observable.interval(2000, TimeUnit.MILLISECONDS).subscribe(new h(r128)), r128.g);
        goto L120
    L114:
        r131 = null;
    L120:
        if (r34 == null) goto L126;
        j r37 = r34.getLiveStream();
        if (r37 == null) goto L126;
        com.bytedance.android.live.pushstream.d r38 = (com.bytedance.android.live.pushstream.d) r37.getValue();
        if (r38 == null) goto L126;
        r7 = r38.g1(r36);
    L126:
        r6.h = r7;
        if (r7 == null) goto L131;
        si6.b r39 = r7.b();
        if (r39 == null) goto L131;
        r39.g(r35.k);
    L131:
        ei6.a r41 = r6.h;
        if (r41 == null) goto L138;
        xi6.c r42 = r41.t();
        if (r42 == null) goto L138;
        com.bytedance.live.livelink.kmp.impl.core.video.b r43 = r42.f();
        if (r43 == null) goto L138;
        r43.j(true);
    L138:
        ei6.a r44 = r6.h;
        if (r44 == null) goto L143;
        gi6.e r45 = r44.getEventManager();
        if (r45 == null) goto L143;
        r45.b((XplayRTCManager$mRtcListener$2.AnonymousClass1) r6.m.getValue());
    L143:
        ei6.a r46 = r6.h;
        if (r46 == null) goto L149;
        vi6.a r47 = r46.v();
        if (r47 == null) goto L149;
        r47.f();
    L149:
        if (r6.e == false) goto L171;
        ei6.a r48 = r6.h;
        if (r48 == null) goto L157;
        xi6.c r49 = r48.t();
        if (r49 == null) goto L157;
        com.bytedance.live.livelink.kmp.impl.core.video.c r51 = r49.d();
        if (r51 == null) goto L157;
        r51.k(true, "mute all video");
    L157:
        ei6.a r52 = r6.h;
        if (r52 == null) goto L162;
        ri6.b r53 = r52.r();
        if (r53 == null) goto L162;
        r53.p(bj6.a.b(r6.h), true, "mute all audio");
    L162:
        q r54 = r6.b;
        if (r54 == null) goto L171;
        String r55 = r54.b;
        if (r55 == null) goto L171;
        ei6.a r56 = r6.h;
        if (r56 == null) goto L171;
        ui6.c r57 = r56.o();
        if (r57 == null) goto L171;
        r57.a(r55, PublicStreamType.VIDEO_AUDIO);
    L171:
        r6.d = true;
        r6.q.c();
        r6.p.f().subscribe(new com.bytedance.android.live.broadcastgame.xplay.servermergecast.e(r6));
        goto L172
    L108:
        r126 = null;
        goto L109
    L104:
        r123 = null;
        goto L105
    L100:
        r120 = null;
        goto L101
    L96:
        r117 = null;
    L92:
        r115 = null;
    L172:
        ei6.a r58 = r6.h;
        if (r58 == null) goto L177;
        si6.b r59 = r58.b();
        if (r59 == null) goto L177;
        si6.a.a(r59, bj6.a.b(r6.h), false, 14);
        goto L177
    L72:
        if (r32.h != true) goto L74;
    L60:
        r28 = null;
    L68:
        r31 = false;
        goto L69
    L54:
        r26 = null;
    L50:
        r22 = null;
    L40:
        r11 = null;
    L177:
        RxUtilKt.c(Observable.merge(this.d.X(), this.h.g).subscribe(new b(this)), this.a);
        return;
    L7:
        if (r2.a(r0.b().b()) == false) goto L17;
        if (r2.a(r0.b().c()) == false) goto L17;
        if (r2.a(r0.b().a()) == false) goto L17;
        if (r0.a() == null) goto L17;
        if (r2.a(r0.a().a()) == false) goto L17;
        r4 = true;
    L179:
        if (q1.d() == false) goto L185;
        this.d.updateEnableVideoFrame(true);
        this.d.R();
        q0 r61 = this.c.h.l;
        if (r61 == null) goto L185;
        if (r61.f() == true) goto L185;
        XplayMonitorSession r62 = this.i;
        XplayException r133 = new XplayException(com.bytedance.android.live.broadcastgame.xplay.q.a.b(com.bytedance.android.live.broadcastgame.xplay.q.c, XplayErrorCode.SERVER_MERGE_CAST_FAILED, null, null, null, 14), false, null, 6, null);
        r62.getClass();
        Intrinsics.checkNotNullParameter(r133, "throwable");
        r62.j(0, r133.getErrorInfo());
    L185:
        XplayLog.c("XplayGameCastAbility", "start native merge single cast");
        d(true);
    }

    public final void onStop() {
        IXplayGameCastService.IGameCastSession r0 = this.b;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.b = null;
        this.h.a();
    }

    public final void d(boolean r8) {
        int r9 = XplayLog.a;
        XplayLog.c("XplayGameCastAbility", "IGameCastAbility.startSingleGameCast requested, currentSession=" + this.b);
        if (this.b == null) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r11 = a();
        if (r11 != null) goto L8;
        return;
    L8:
        JSONObject r1 = null;
        Object r2 = null;
        if (q1.c(this.c.h.b) == true) goto L22;
    L20:
        c(true, r1);
        XplayGameCastService.GameCastSessionImpl r12 = this.f.a(r11);
        r12.c.subscribe(new c(new XplayGameCastAbility$startSingleGameCast$1$1(this)));
        r12.a();
        Unit r0 = Unit.INSTANCE;
        this.b = r12;
        return;
    L22:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L13
        r4.put("game_ratio", ((double) ((Number) r11.getFirst()).intValue()) / ((Number) r11.getSecond()).doubleValue());     // Catch: Throwable -> L13
        r4.put("render_mode", "fill");     // Catch: Throwable -> L13
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r5) == true) goto L19;
        r2 = r5;
    L19:
        r1 = (JSONObject) r2;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static void c(boolean r1, JSONObject r2) {
        PublishSubject<Unit> r0 = q1.a;
        if (((Boolean) wz0.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        ((IInteractGameService) k.n(IInteractGameService.class)).sendGameCastStatusSEI(r1, r2);
    }

    public static boolean f(Pair r1, String r2) {
        if (((Number) r1.getFirst()).intValue() > 0) goto L5;
    L9:
        int r3 = XplayLog.a;
        XplayLog.b("XplayGameCastAbility", "illegal dimension '" + r2 + "': d");
        return false;
    L5:
        if (((Number) r1.getSecond()).intValue() <= 0) goto L9;
        return true;
    }

    public XplayGameCastAbility(p r2, IXplayCoreService r3, e r4, IXplayGameCastService r5, k20.b r6, XplayRTCManager r7, XplayMonitorSession r8) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayCoreService");
        Intrinsics.checkNotNullParameter(r4, "xplayPanelService");
        Intrinsics.checkNotNullParameter(r5, "xplayGameCastService");
        Intrinsics.checkNotNullParameter(r6, "xplayTerminateService");
        Intrinsics.checkNotNullParameter(r7, "xplayRTCManager");
        Intrinsics.checkNotNullParameter(r8, "monitorSession");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.a = new CompositeDisposable();
    }
}
