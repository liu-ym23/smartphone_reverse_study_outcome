package com.bytedance.android.live.broadcastgame.xplay;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcast.xplay.XplayMessageType;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livehostapi.business.depend.xplay.CloudGameState;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayApi;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayAudioCallback;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayCloudPlayerCallback;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayInstanceApi;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayPlayerCallback;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayVideoCallback;
import com.bytedance.android.livehostapi.business.depend.xplay.PlayerEvent;
import com.bytedance.android.livehostapi.business.depend.xplay.XplayStartParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ek1;
import com.bytedance.android.livesdk.config.hb;
import com.bytedance.android.livesdk.config.hk1;
import com.bytedance.android.livesdk.config.rz0;
import com.bytedance.android.livesdk.config.s30;
import com.bytedance.android.livesdk.config.x20;
import com.bytedance.android.livesdk.config.yz0;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.z6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.XplayAnchorCustomServerMergeConfig;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.ss.android.ugc.effectmanager.common.utils.MD5Utils;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayCoreService implements com.bytedance.android.scope.o, IXplayCoreService, h10.a {
    public final CompositeDisposable a;
    public final boolean b;
    public IXplayApi c;
    public IXplayInstanceApi d;
    public volatile boolean e;
    public long f;
    public List<Dialog> g;
    public IXplayCoreService.State h;
    public IXplayCoreService.a i;
    public final PublishSubject<IXplayCoreService.State> j;
    public final PublishSubject<XplayException> k;
    public final PublishSubject<com.bytedance.android.live.broadcastgame.api.xplay.g> l;
    public final PublishSubject<XplayException> m;
    public String n;
    public final t o;
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a p;
    public final ek1 q;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p r;
    public final XplayMonitorSession s;
    public final g0 t;
    public final XplayInternalContext u;
    public final k20.e v;
    public final l20.e w;

    public final class XplayPlayerListenerImpl implements IXplayPlayerCallback, IXplayVideoCallback, IXplayAudioCallback {
        public final IXplayInstanceApi a;
        public final /* synthetic */ XplayCoreService b;

        public final void onCloudPlayerList(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "players");
        }

        public final void onInitReqSuccess() {
            XplayLog.a("XplayCoreService", "onInitReqSuccess");
            Iterator r0 = ((ArrayList) s.b()).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((g10.e) r0.next()).onInitReqSuccess();
            goto L4
        }

        public final void onInitSuccess() {
            XplayLog.a("XplayCoreService", "onInitSuccess");
            this.b.h(IXplayCoreService.State.Loaded);
            Iterator r0 = ((ArrayList) s.b()).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((g10.e) r0.next()).onInitSuccess();
            goto L4
        }

        public final void onPlaySuccess() {
            XplayLog.a("XplayCoreService", "onPlaySuccess");
            g0 r0 = this.b.t;
            Map<String, String> r1 = r0.a();
            r1.put("room_live_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
            String r2 = r1.get("source");
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.b = r2;
            r0.c = System.currentTimeMillis();
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_start", r1, new Object[]{Room.class, am2.x.class});
            IXplayInstanceApi r3 = this.b.d;
            CloudGameState r4 = null;
            if (r3 != null) goto L8;
            CloudGameState r5 = null;
        L9:
            if (r5 == null) goto L13;
            String r6 = r5.getRoomId();
            if (r6 == null) goto L13;
            int r7 = InteractGameLocalStatusUtils.a;
            Intrinsics.checkNotNullParameter(r6, "xplayRoomId");
            InteractGameLocalStatusUtils.c("xplay_room_id", r6);
        L13:
            XplayCoreService r8 = this.b;
            com.bytedance.android.live.broadcastgame.api.xplay.s r9 = r8.r.j;
            if (r9 != null) goto L16;
        L26:
            com.bytedance.android.live.broadcastgame.api.xplay.s r11 = this.b.r.j;
            if (r11 != null) goto L29;
            return;
        L29:
            if (r11.j != true) goto L33;
            this.a.disableGestureRecognizer(true);
            return;
        L33:
            return;
        L16:
            if (r9.f != true) goto L26;
            IXplayInstanceApi r12 = r8.d;
            if (r12 == null) goto L21;
            r4 = r12.getCloudGameState();
        L21:
            if (r4 == null) goto L26;
            boolean r13 = r4.isPodReconnect();
            XplayMonitorSession r14 = this.b.s;
            if (r13 == false) goto L25;
            r14.h(1);
            goto L26
        L25:
            r14.h(0);
            goto L26
        L8:
            r5 = r3.getCloudGameState();
            goto L9
        }

        public final void onPlayEvent(final PlayerEvent r21) {
            Intrinsics.checkNotNullParameter(r21, "event");
            int r2 = r21.getData().optInt("reason", 3);
            Iterator r3 = ((ArrayList) s.b()).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((g10.e) r3.next()).c(r21.getCode(), r21.getData());
            goto L4
        L6:
            int r4 = r21.getCode();
            if (r4 != 8) goto L9;
            XplayLog.c("XplayCoreService", "first frame arrived");
            this.b.h(IXplayCoreService.State.Running);
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r0 = this.b.p;
            if (r0 == null) goto L55;
            r0.g();
        L55:
            XplayMonitorSession r1 = this.b.s;
            if (r1.b != null) goto L74;
            long r5 = System.currentTimeMillis() - r1.a;
            r1.k(r5, 1, null);
            JSONObject r6 = new JSONObject();
            r6.put("duration", r5);
            r6.put("retry_count", r1.c);
            Iterator r7 = ((LinkedHashMap) r1.d).entrySet().iterator();
        L60:
            if (r7.hasNext() == false) goto L62;
            Map.Entry r9 = (Map.Entry) r7.next();
            r6.put((String) r9.getKey(), ((Number) r9.getValue()).longValue());
            goto L60
        L62:
            Regex r8 = XplayMonitorSession.f;
            JSONObject r11 = new JSONObject();
            r1.a(r11);
            Unit r12 = Unit.INSTANCE;
            JSONObject r13 = new JSONObject();
            r1.a(r13);
            XplayMonitorSession.Companion.a("ttlive_xplay_duration", r11, r6, r13);
            r1.n("xplayDuraton", 0, r6.toString());
            if (((Boolean) x20.a.getValue()).booleanValue() == true) goto L80;
        L67:
            r1.b = Boolean.TRUE;
            if (r1.e.f != XplayScene.TalkRoom) goto L74;
            IInteractService r14 = jc1.k.f(IInteractService.class);
            if (r14 == null) goto L74;
            com.bytedance.android.live.liveinteract.utils.l r15 = r14.getLinkMicGameFullLinkMonitor();
            if (r15 == null) goto L74;
            com.bytedance.android.live.liveinteract.utils.l.a.a(r15, LinkMonitorData.XplayShowAndFirstFrameSuccess, null, null, 0, null, null, null, null, null, 510);
            goto L74
        L80:
            ThreadPoolHelper.d().execute(new o0(r1, r5));     // Catch: Exception -> L66
        L74:
            XplayMonitorSession r16 = this.b.s;
            r16.getClass();
            IPerformanceManager r17 = jc1.k.n(IPerformanceManager.class);
            Pair[] r18 = new Pair[4];
            r18[0] = TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, r16.e.h.b);
            r18[1] = TuplesKt.to("game_name", r16.e.h.c);
            r18[2] = TuplesKt.to("scene_type", String.valueOf(r16.e.f.getSceneId()));
            if (r16.e.d == false) goto L77;
            String r19 = "anchor";
        L78:
            r18[3] = TuplesKt.to("launch_form", r19);
            r17.onModuleStart("open_platform_xplay", MapsKt.mapOf(r18));
            return;
        L77:
            r19 = "audience";
            goto L78
        L9:
            if (r4 != 9) goto L11;
            XplayCoreService r110 = this.b;
            XplayCoreService.c(r110, r110.r, 2131923513, com.bytedance.android.live.core.utils.s1.C(2131923522, new Object[]{String.valueOf(9)}), true, new XplayCoreService$XplayPlayerListenerImpl$onPlayEvent$5(this, r21));
            XplayMonitorSession r22 = this.b.s;
            q.a r23 = q.c;
            XplayErrorCode r24 = XplayErrorCode.RECEIVE_FIRST_FRAME_TIMEOUT;
            r23.getClass();
            Intrinsics.checkNotNullParameter(r24, "xplayErrorCode");
            r22.d(new XplayException(new q(r24, null), false, null, 6, null));
            return;
        L11:
            if (r4 != 13) goto L13;
            int r25 = XplayLog.a;
            XplayLog.a("XplayCoreService", "performance stats: " + r21.getData());
            JSONObject r26 = r21.getData();
            Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L46
            m20.a r28 = XplayPerfPanelView.o;     // Catch: Throwable -> L46
            int r29 = r26.optInt("videoWidth");     // Catch: Throwable -> L46
            int r31 = r26.optInt("videoHeight");     // Catch: Throwable -> L46
            int r32 = (int) r26.optLong("receivedVideoBitrate");     // Catch: Throwable -> L46
            int r33 = r26.optInt("videoRenderFrameRate");     // Catch: Throwable -> L46
            m20.a r34 = XplayPerfPanelView.o;     // Catch: Throwable -> L46
            r34.a = r29;     // Catch: Throwable -> L46
            r34.b = r31;     // Catch: Throwable -> L46
            r34.c = r33;     // Catch: Throwable -> L46
            r34.d = r32;     // Catch: Throwable -> L46
            Object r35 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
        L48:
            Throwable r36 = Result.exceptionOrNull-impl(r35);
            if (r36 == null) goto L91;
            int r37 = XplayLog.a;
            XplayLog.a("XplayCoreService", "parse performance stats failed, " + r36);
            return;
        L91:
            return;
        L46:
            th = move-exception;
            Result.Companion r38 = Result.Companion;
            r35 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L48
        L13:
            if (r4 != 17) goto L15;
            if (r2 != 3) goto L35;
            XplayCoreService r39 = this.b;
            XplayCoreService.c(r39, r39.r, 2131923534, com.bytedance.android.live.core.utils.s1.B(2131923532), false, new XplayCoreService$XplayPlayerListenerImpl$onPlayEvent$2(this, r21));
        L42:
            this.b.s.i(17, r2);
            return;
        L35:
            if (r2 == 7) goto L40;
            XplayCoreService r41 = this.b;
            if (r41.b == true) goto L39;
            r41.v.a("game exit: code: " + r21.getCode() + ", data: " + r21.getData());
            goto L42
        L39:
            XplayCoreService.c(r41, r41.r, 2131923534, com.bytedance.android.live.core.utils.s1.B(2131923531), false, new XplayCoreService$XplayPlayerListenerImpl$onPlayEvent$3(this, r21));
            goto L42
        L40:
            this.b.v.a("game exit: code: " + r21.getCode() + ", data: " + r21.getData());
            goto L42
        L15:
            if (r4 != 22) goto L17;
            XplayCoreService r42 = this.b;
            XplayCoreService.c(r42, r42.r, 2131923520, com.bytedance.android.live.core.utils.s1.B(2131923521), false, new XplayCoreService$XplayPlayerListenerImpl$onPlayEvent$4(this, r21));
            this.b.s.i(22, r2);
            return;
        L17:
            if (r4 != 40) goto L19;
            this.b.u.getSeiDelay().setValue(Long.valueOf(r21.getData().optLong("sei", 0)));
            return;
        L19:
            if (r4 == 41) goto L21;
            int r43 = XplayLog.a;
            XplayLog.a("XplayCoreService", "onPlayEvent, event=" + r21.getCode() + ", reason=" + r2);
            return;
        L21:
            int r44 = r21.getData().optInt("stream_state", 0);
            int r45 = r21.getData().optInt(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, 0);
            if (r44 == 0) goto L30;
            this.b.m.onNext(new XplayException(q.a.d(q.c, Integer.valueOf(r45), "stream state error"), false, null, 6, null));
            int r46 = XplayLog.a;
            XplayLog.c("XplayCoreService", "server merge stream failed, result: " + r21.getData() + ", error_code: " + r45);
            com.bytedance.android.live.broadcastgame.api.xplay.p r47 = this.b.r;
            if (r47.d == false) goto L30;
            if (r47.f != XplayScene.TalkRoom) goto L30;
            if (q1.e() == false) goto L30;
            XplayCoreService r48 = this.b;
            XplayCoreService.c(r48, r48.r, 2131923534, com.bytedance.android.live.core.utils.s1.B(2131923533), false, new XplayCoreService$XplayPlayerListenerImpl$onPlayEvent$6(this, r21));
        L30:
            int r49 = XplayLog.a;
            XplayLog.c("XplayCoreService", "server merge stream success, result: " + r21.getData() + ", code: " + r21.getCode());
        }

        public final void onVideoFrame(IByteRtcVideoFrame r11) {
            Intrinsics.checkNotNullParameter(r11, "videoFrame");
            int r0 = XplayLog.a;
            XplayLog.a("XplayCoreService", "videoFrame: " + r11);
            t r1 = this.b.o;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r11, "frame");
            if (com.bytedance.android.live.broadcastgame.api.xplay.a.b(r11) == true) goto L5;
        L7:
            long r2 = System.currentTimeMillis();
            long r3 = r2 - r1.f;
            if (r3 < r1.e) goto L10;
            XplayLog.c("XplayFrameProcessor", "frame statistics: interval = " + r3 + ", received = " + r1.g + ", dropped = " + r1.h + ", current = (" + com.bytedance.android.live.broadcastgame.api.xplay.a.a(r11) + ')');
            r1.g = 0;
            r1.h = 0;
            r1.f = r2;
        L10:
            r1.g++;
            if (r1.b == true) goto L13;
        L16:
            boolean r4 = false;
        L17:
            if (r4 == false) goto L19;
            r1.h++;
            return;
        L19:
            s1 r5 = new s1(r11);
            IByteRtcVideoFrame r12 = r5.b;
            String r6 = r12.getPixelFormat();
            if (Intrinsics.areEqual(r6, IByteRtcVideoFrame.PixelFormat.TEXTURE_2D.getStringValue()) == false) goto L23;
        L48:
            r1.i.onNext(r5);
            return;
        L23:
            if (Intrinsics.areEqual(r6, IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue()) == true) goto L48;
            if (((Boolean) z6.a.getValue()).booleanValue() == false) goto L36;
            IByteRtcVideoFrame r7 = r5.b;
            ByteBuffer r8 = null;
            if (r7 == null) goto L30;
            ByteBuffer r9 = r7.getI420ByteBuffer();
        L31:
            if (r9 == null) goto L36;
            IByteRtcVideoFrame r13 = r5.b;
            if (r13 == null) goto L35;
            r8 = r13.getI420ByteBuffer();
        L35:
            r5.a = r8;
            goto L48
        L30:
            r9 = null;
        L36:
            int r14 = r12.getHeight();
            int r15 = r12.getWidth();
            int r16 = (r15 * r14) + ((((r15 + 1) / 2) * ((r14 + 1) / 2)) * 2);
            ByteBuffer r17 = r1.d;
            if (r17 != null) goto L40;
            ByteBuffer r18 = ByteBuffer.allocateDirect(r16);
            r1.d = r18;
        L44:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r19 = ILiveWrappedLivePusher.a.b();
            if (r19 == null) goto L47;
            r19.getYuvHelper();
        L47:
            r18.position(0);
            r5.a = r18;
            goto L48
        L40:
            if (r16 > r17.capacity()) goto L42;
            r17.limit(r16);
            r17.position(0);
        L43:
            r18 = r17;
            goto L44
        L42:
            r17.clear();
            r17 = ByteBuffer.allocateDirect(r16);
            r1.d = r17;
            goto L43
        L13:
            if (r1.c == false) goto L15;
            r1.c = false;
            goto L16
        L15:
            r1.c = true;
            r4 = true;
            goto L17
        L5:
            if (r11.getTextureId() != 0) goto L7;
        }

        public XplayPlayerListenerImpl(XplayCoreService r2, IXplayInstanceApi r3) {
            Intrinsics.checkNotNullParameter(r3, "instance");
            this.b = r2;
            this.a = r3;
        }

        public final void onError(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r5, "message");
            int r0 = XplayLog.a;
            XplayLog.a("XplayCoreService", "onError, message=" + r5 + ", error=" + r4);
            this.b.f(q.a.d(q.c, 199, r4 + ": " + r5));
            if (this.a.isPlaying() == true) goto L6;
            this.b.i();
            return;
        }

        public final void onInitFail(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            int r0 = XplayLog.a;
            XplayLog.a("XplayCoreService", "onInitFail, code=" + r3 + ", error=" + r4);
            this.b.f(q.a.d(q.c, Integer.valueOf(r3), r4));
            this.b.i();
        }

        public final void onPlayFail(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "err");
            int r0 = XplayLog.a;
            XplayLog.a("XplayCoreService", "onPlayFail, code=" + r3 + ", error=" + r4);
            this.b.f(q.a.d(q.c, Integer.valueOf(r3), r4));
            this.b.i();
        }

        public final void onAudioFrame(ByteBuffer r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "buffer");
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
            if (r5 == null) goto L6;
            r5.getTimeUtils();
            return;
        }
    }

    public static final class a {
    }

    public final class b implements IXplayCloudPlayerCallback {
        public final /* synthetic */ XplayCoreService a;

        public final void onVideoFrame(String r1, IByteRtcVideoFrame r2) {
        }

        public b(XplayCoreService r1) {
            this.a = r1;
        }

        public final void onPlaySuccess(String r2) {
            XplayLog.a("XplayCoreService", "cloud player onPlaySuccess");
        }

        public final void onPlayEvent(String r5, PlayerEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            int r7 = r6.getData().optInt("reason", 3);
            int r0 = r6.getCode();
            if (r0 != 8) goto L5;
            XplayLog.c("XplayCoreService", "guide player first frame arrived");
            XplayCoreService r8 = this.a;
            r8.getClass();
            XplayLog.c("XplayCoreService", "switch guide player, guideDuration=" + r8.f + ", state=" + r8.h);
            if (r8.f <= 0) goto L22;
            r8.h(IXplayCoreService.State.SwitchToGuide);
            f2.c(com.bytedance.android.live.core.utils.s1.C(2131923557, new Object[]{Long.valueOf(r8.f)}), 0);
            RxUtilKt.c(RxUtilKt.h(Observable.timer(r8.f, TimeUnit.SECONDS)).subscribe(new p(r8)), r8.a);
            return;
        L22:
            return;
        L5:
            if (r0 != 9) goto L7;
            XplayLog.c("XplayCoreService", "cloud player first frame timeout");
            XplayCoreService.d(this.a);
            return;
        L7:
            if (r0 != 17) goto L9;
            XplayLog.c("XplayCoreService", "cloud player game exit");
            XplayCoreService.d(this.a);
            return;
        L9:
            if (r0 == 22) goto L11;
            int r1 = XplayLog.a;
            XplayLog.a("XplayCoreService", "on cloud player event, event=" + r6.getCode() + ", reason=" + r7);
            return;
        L11:
            XplayLog.c("XplayCoreService", "cloud player connection lost");
            XplayCoreService.d(this.a);
        }

        public final void onError(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Intrinsics.checkNotNullParameter(r4, "message");
            int r5 = XplayLog.a;
            XplayLog.a("XplayCoreService", "cloud player onError, message=" + r4 + ", error=" + r3);
            XplayCoreService.d(this.a);
        }

        public final void onPlayFail(String r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "err");
            int r5 = XplayLog.a;
            XplayLog.a("XplayCoreService", "cloud player onPlayFail, code=" + r3 + ", error=" + r4);
            XplayCoreService.d(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ XplayCoreService a;
        public final /* synthetic */ IXplayCoreService.a b;

        public c(XplayCoreService r1, IXplayCoreService.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r27) {
            IXplayInstanceApi r1 = (IXplayInstanceApi) r27;
            XplayCoreService r2 = this.a;
            IXplayCoreService.a r3 = this.b;
            if (r2.h == IXplayCoreService.State.Stopped) goto L5;
            q.a r4 = q.c;
            XplayErrorCode r5 = XplayErrorCode.STATE_NOT_STOPPED;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "xplayErrorCode");
            r2.f(new q(r5, null));
            return;
        L5:
            int r6 = XplayLog.a;
            XplayLog.c("XplayCoreService", "starting game, params=" + r3);
            r2.h(IXplayCoreService.State.Loading);
            if (r2.b == false) goto L18;
            RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r7 == null) goto L14;
            com.bytedance.live.datacontext.j r8 = r7.getLiveStream();
            if (r8 == null) goto L14;
            com.bytedance.android.live.pushstream.d r9 = (com.bytedance.android.live.pushstream.d) r8.getValue();
            if (r9 == null) goto L14;
            uf2.d0 r11 = r9.A();
        L15:
            if (r11 == null) goto L35;
            r11.h();
        L35:
            r2.i = r3;
            int r12 = f1.a;
            hk1 r13 = f1.a(r2.r.f, r3);
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r14 = ILiveWrappedLivePusher.a.b();
            if (r14 == null) goto L38;
            r14.getGLThreadManager();
        L38:
            int r15 = r13.c();
            r2.o.b = r13.a();
            XplayScene r16 = r2.r.f;
            if (r16 != XplayScene.TalkRoom) goto L41;
        L50:
            boolean r17 = true;
        L52:
            if (r2.b == true) goto L214;
        L56:
            JSONArray r18 = null;
        L57:
            r1.addCallback(new XplayPlayerListenerImpl(r2, r1));
            r1.addCallback(new b(r2));
            XplayStartParams r19 = new XplayStartParams();
            r19.setGameId(r3.a);
            r19.setChannel(r3.b);
            r19.setDisplayWidth(r3.c);
            r19.setDisplayHeight(r3.d);
            r19.setWidthRatio(r3.e);
            r19.setHeightRatio(r3.f);
            Pair[] r110 = new Pair[1];
            List r21 = CollectionsKt.mutableListOf(new String[]{"-screen-fullscreen 1", "-cloud-game 1", "-mobile 1", "-token=" + r3.g, "-open-id=" + r3.h});
            if (r3.o == false) goto L67;
            PublishSubject<Unit> r22 = q1.a;
            if (((Boolean) s30.a.getValue()).booleanValue() == true) goto L62;
        L66:
            r21.add("-width " + r3.c);
            r21.add("-height " + r3.d);
            goto L67
        L62:
            if (r3.c == 0) goto L66;
            if (r3.d == 0) goto L66;
            r21.add("-width 1080");
            r21.add("-height " + ((r3.d * 1080) / r3.c));
        L67:
            r110[0] = TuplesKt.to("StartAppParam", CollectionsKt.joinToString$default(r21, " ", null, null, 0, null, null, 62, null));
            Map r23 = MapsKt.mutableMapOf(r110);
            String r24 = MD5Utils.getMD5String(jta.g.d() + r2.r.e + String.valueOf(System.currentTimeMillis()) + UUID.randomUUID().toString());
            int r25 = XplayLog.a;
            StringBuilder r26 = new StringBuilder("createTraceId: ");
            r26.append(r24);
            XplayLog.c("XplayCoreService", r26.toString());
            r23.put("gamecp_trace_id", r24);
            if (r2.r.d == true) goto L70;
        L80:
            r19.setExtraToGame(r23);
            Pair[] r28 = new Pair[4];
            r28[0] = TuplesKt.to("enter_from", "live_app");
            r28[1] = TuplesKt.to("live_room_id", String.valueOf(r2.r.b));
            r28[2] = TuplesKt.to("open_id", r3.h);
            if (r2.b == false) goto L83;
            String r29 = "true";
        L84:
            r28[3] = TuplesKt.to("is_anchor", r29);
            Map r31 = MapsKt.mutableMapOf(r28);
            r31.putAll(r3.k);
            int r32 = f1.a;
            r31.putAll(f1.a(r2.r.f, r3).b());
            com.bytedance.android.live.broadcastgame.api.xplay.s r33 = r2.r.j;
            if (r33 == null) goto L90;
            if (r33.f != true) goto L90;
            r31.put("support_reconnect", "true");
        L90:
            if (r2.b == true) goto L92;
        L96:
            XplayScene r34 = r2.r.f;
            XplayScene r35 = XplayScene.TalkRoom;
            if (r34 != r35) goto L107;
            IInteractService r36 = jc1.k.f(IInteractService.class);
            if (r36 == null) goto L107;
            if (r36.isGroupLiveGame() != true) goto L107;
            RoomContext r37 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r37 == null) goto L107;
            if (r37.isPrivateRoom() != true) goto L107;
            r31.put("enter_method", "playtogether");
        L107:
            r19.setExtraToServer(r31);
            r19.setEnableRTCMulti(true);
            r19.setMuteAudioPlayback(true);
            if (q1.d() == false) goto L113;
            if (((XplayScene) r2.u.getCurrentScene().getValue()) != XplayScene.Video) goto L113;
        L124:
            boolean r38 = false;
        L126:
            r19.setEnableVideoFrame(r38);
            if (r2.r.f == r35) goto L129;
        L136:
            boolean r39 = true;
        L137:
            r19.setEnableAudioFrame(r39);
            r19.setUseTextureView(r17);
            r19.setEglContext(null);
            r19.setVideoFrameFormat(r15);
            XplayMonitorSession r41 = r2.s;
            r41.getClass();
            LinkedHashMap r42 = new LinkedHashMap();
            r42.put("scene_type", String.valueOf(r41.e.f.getSceneId()));
            com.bytedance.android.live.broadcastgame.api.xplay.p r43 = r41.e;
            if (r43.d == false) goto L140;
            String r44 = "anchor";
        L148:
            r42.put("launch_from", r44);
            r19.setMonitorCommonParams(r42);
            com.bytedance.android.live.broadcastgame.api.model.q0 r45 = r2.r.h.l;
            if (r45 != null) goto L151;
        L153:
            List r46 = new ArrayList();
        L154:
            r19.setCloudPlayers(r46);
            ek1 r47 = r2.q;
            if (r47 != null) goto L157;
        L159:
            boolean r48 = false;
        L160:
            r19.setEnableExternalRender(r48);
            com.bytedance.android.live.broadcastgame.api.xplay.s r49 = r2.r.j;
            if (r49 == null) goto L165;
            XplayGuestType r51 = r49.i;
            if (r51 == null) goto L165;
        L166:
            r19.setRoomGuestType(r51.getGuestType());
            r19.setVideoSimulcast(r18);
            String r52 = "";
            if (r2.r.d == true) goto L169;
        L195:
            String r53 = "";
        L196:
            r19.setForwardInfo(r53);
            String r54 = r2.r.h.b;
            Intrinsics.checkNotNullParameter(r54, "appId");
            XplayAnchorCustomServerMergeConfig r55 = (XplayAnchorCustomServerMergeConfig) ((Map) hb.a.getValue()).get(r54);
            if (r55 != null) goto L199;
            r55 = XplayAnchorCustomServerMergeConfig.Companion.getDEFAULT_ITEM();
        L199:
            XplayAnchorCustomServerMergeConfig.XplaySubscribeMixInfo r56 = r55.getSubscribeMixInfo();
            com.bytedance.android.live.broadcastgame.api.xplay.p r57 = r2.r;
            boolean r58 = r57.d;
            if (r58 == false) goto L203;
            if (r56 == null) goto L203;
            r52 = JsonUtil.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("subscribeStreamType", Integer.valueOf(r56.getSubscribeStreamType())), TuplesKt.to("videoLayout", r56.getVideoLayout()), TuplesKt.to("audioLayout", r56.getAudioLayout()), TuplesKt.to("subscribeRoomId", r2.r.b + "_mix_danmu"), TuplesKt.to("subscribeUserId", r2.r.e + "_anchor")}));
        L209:
            r19.setSubscribeMixInfo(r52);
            r19.setUseFullScreen(r3.o);
            r1.initGame(r19);
            return;
        L203:
            if (r58 == false) goto L209;
            com.bytedance.android.live.broadcastgame.api.xplay.s r0 = r57.j;
            if (r0 == null) goto L209;
            if (r0.g != true) goto L209;
            r52 = JsonUtil.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("subscribeStreamType", 3), TuplesKt.to("videoLayout", "{\"type\":\"mix_game\", \"width\":1080, \"height\":1920, \"renderMode\": 1}"), TuplesKt.to("audioLayout", "{\"type\":\"mix_game\"}"), TuplesKt.to("subscribeRoomId", r2.r.b + "_mix_danmu"), TuplesKt.to("subscribeUserId", r2.r.e + "_anchor")}));
            goto L209
        L169:
            if (q1.d() == true) goto L173;
            if (q1.e() == false) goto L195;
        L173:
            if (((XplayScene) r2.u.getCurrentScene().getValue()) == XplayScene.RevenueLink) goto L195;
            com.bytedance.android.live.broadcastgame.api.model.q0 r59 = r2.r.h.l;
            if (r59 == null) goto L195;
            if (r59.f() == true) goto L195;
            com.bytedance.android.live.broadcastgame.api.xplay.s r61 = r2.r.j;
            if (r61 != null) goto L181;
        L187:
            XplayApi.i r62 = r3.m;
            if (r62 == null) goto L193;
            String r63 = r62.a();
            Intrinsics.checkNotNullParameter(r63, "rtcExtInfo");
            if (TextUtils.isEmpty(r63) == false) goto L212;
        L194:
            r53 = String.valueOf(r63);
            goto L196
        L212:
            JSONObject r64 = new JSONObject(r63);     // Catch: Exception -> L211
            r64.remove("wtnToken");     // Catch: Exception -> L211
            r64.remove("wtnStreamId");     // Catch: Exception -> L211
            r63 = r64.toString();     // Catch: Exception -> L211
            goto L194
        L193:
            r63 = null;
            goto L194
        L181:
            if (r61.g != true) goto L187;
            XplayApi.i r65 = r3.m;
            if (r65 == null) goto L185;
            String r66 = r65.a();
        L186:
            r53 = String.valueOf(r66);
            goto L196
        L185:
            r66 = null;
        L165:
            r51 = XplayGuestType.DEFAULT;
            goto L166
        L157:
            if (r47.c() != true) goto L159;
            r48 = true;
            goto L160
        L151:
            if (r45.f() != true) goto L153;
            r46 = CollectionsKt.mutableListOf(new String[]{"host", "guide"});
            goto L154
        L140:
            com.bytedance.android.live.broadcastgame.api.xplay.s r67 = r43.j;
            if (r67 == null) goto L143;
            XplayGuestType r68 = r67.i;
        L145:
            if (r68 != XplayGuestType.SILENCE) goto L147;
            r44 = "watcher";
            goto L148
        L147:
            r44 = "audience";
            goto L148
        L143:
            r68 = null;
            goto L145
        L129:
            if (r2.b == true) goto L136;
            IInteractService r69 = jc1.k.f(IInteractService.class);
            if (r69 != null) goto L133;
        L135:
            r39 = false;
            goto L137
        L133:
            if (r69.isXplayEnableAudioFrame() != true) goto L135;
        L113:
            if (q1.e() == true) goto L115;
        L117:
            String r71 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
            if (r2.b == true) goto L125;
            com.bytedance.android.live.broadcastgame.api.xplay.s r72 = r2.r.j;
            if (r72 == null) goto L124;
            if (r72.e != true) goto L124;
        L125:
            r38 = true;
            goto L126
        L115:
            if (((XplayScene) r2.u.getCurrentScene().getValue()) != r35) goto L117;
        L92:
            if (q1.e() == false) goto L96;
            int r73 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;
            if (com.bytedance.android.live.broadcastgame.api.interactgame.j.e(r2.r.h.m) == false) goto L96;
            r31.put("cloud_game_pattern", GamePromoteDataContext.GAME_TYPE_MOBILE);
            goto L96
        L83:
            r29 = "false";
            goto L84
        L70:
            if (q1.d() == true) goto L74;
            if (q1.e() == false) goto L80;
        L74:
            if (((XplayScene) r2.u.getCurrentScene().getValue()) == XplayScene.RevenueLink) goto L80;
            com.bytedance.android.live.broadcastgame.api.model.q0 r74 = r2.r.h.l;
            if (r74 == null) goto L80;
            if (r74.f() == true) goto L80;
            r23.put("pushStreamMode", String.valueOf(r3.l));
            goto L80
        L214:
            r18 = new JSONArray(r13.d());     // Catch: Exception -> L55
        L41:
            if (r16 != XplayScene.RevenueLink) goto L45;
            if (r3.j == true) goto L50;
        L45:
            if (r16 != XplayScene.Video) goto L49;
            PublishSubject<Unit> r111 = q1.a;
            if (((Boolean) yz0.a.getValue()).booleanValue() == true) goto L50;
        L49:
            r17 = false;
        L14:
            r11 = null;
            goto L15
        L18:
            if (((XplayScene) r2.u.getCurrentScene().getValue()) != XplayScene.RevenueLink) goto L28;
            RoomContext r75 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r75 == null) goto L24;
            com.bytedance.live.datacontext.n r76 = r75.getGuestLiveCore();
            if (r76 == null) goto L24;
            uf2.d0 r77 = (uf2.d0) r76.getValue();
        L25:
            if (r77 == null) goto L35;
            r77.h();
        L24:
            r77 = null;
            goto L25
        L28:
            if (r2.r.f != XplayScene.TalkRoom) goto L35;
            IInteractService r78 = jc1.k.f(IInteractService.class);
            if (r78 == null) goto L32;
            uf2.d0 r79 = r78.getLiveCore(false);
        L33:
            if (r79 == null) goto L35;
            r79.h();
            goto L35
        L32:
            r79 = null;
            goto L33
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ XplayCoreService a;

        public d(XplayCoreService r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            q.a r0 = q.c;
            XplayErrorCode r1 = XplayErrorCode.XPLAY_PLUGIN_FAILED;
            q r8 = q.a.b(r0, r1, null, null, (Throwable) r7, 6);
            this.a.f(r8);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            XplayLog.c("XplayCoreService", "preload Xplay succeeded");
            ((IXplayInstanceApi) r3).preloadScene();
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            int r0 = XplayLog.a;
            XplayLog.b("XplayCoreService", "preload Xplay failed: " + ((Throwable) r3).getMessage());
        }
    }

    public static final class g<T> implements Predicate {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean test(Object r2) {
            IXplayCoreService.State r3 = (IXplayCoreService.State) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3 != IXplayCoreService.State.Stopped) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ XplayCoreService a;

        public h(XplayCoreService r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            IXplayCoreService.State r7 = (IXplayCoreService.State) r6;
            XplayCoreService r8 = this.a;
            List<Dialog> r0 = r8.g;
            if (r0 == null) goto L26;
            Iterator r1 = ((ArrayList) r0).iterator();
        L6:
            if (r1.hasNext() == false) goto L26;
            Dialog r2 = (Dialog) r1.next();
            if (r2 == null) goto L6;
            Handler r3 = DialogLancet.resolveDialogHandler(r2);
            if (r3 == null) goto L14;
            if (Looper.myLooper() == r3.getLooper()) goto L14;
            r3.post(DialogLancet.createDismissRunnable(r2));
        L14:
            DialogLancet.beforeDialogDismiss(r2);
            r2.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r2);
            goto L6
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r4 == null) goto L23;
            com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r2);
            throw th;
        L26:
            r8.g = null;
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r9 = this.a.p;
            if (r9 == null) goto L41;
            r9.f();
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ XplayCoreService a;

        public i(XplayCoreService r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.broadcastgame.api.xplay.g r12 = (com.bytedance.android.live.broadcastgame.api.xplay.g) r11;
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r0 = this.a.p;
            if ((r0 instanceof com.bytedance.android.live.broadcastgame.xplay.screendetect.f) == true) goto L5;
            r0 = null;
        L5:
            com.bytedance.android.live.broadcastgame.xplay.screendetect.f r1 = (com.bytedance.android.live.broadcastgame.xplay.screendetect.f) r0;
            if (r1 == null) goto L20;
            Intrinsics.checkNotNullParameter(r12, "frame");
            if (r1.d == false) goto L20;
            long r3 = System.currentTimeMillis();
            long r5 = r1.f;
            if (r5 != 0) goto L13;
            r1.f = r3;
            goto L20
        L13:
            long r6 = r3 - r5;
            r1.f = r3;
            long[] r13 = r1.g;
            int r4 = r1.h;
            r13[r4 % r13.length] = r6;
            int r7 = (r4 + 1) % r13.length;
            r1.h = r7;
            if (r7 != 0) goto L18;
            double r8 = 1000.0d / ArraysKt.average(r13);
            StringBuilder r14 = new StringBuilder("final fps: ");
            int r9 = (int) r8;
            r14.append(r9);
            r1.b(r14.toString());
            if (r9 >= r1.h().c()) goto L18;
            com.bytedance.android.live.broadcastgame.xplay.screendetect.f.i(r1, "ttlive_xplay_anchor_screen_detect_fps", r9, null, 4);
        L18:
            r1.j.removeMessages(1);
            r1.j.sendEmptyMessageDelayed(1, r1.h().a());
        L20:
            if (this.a.e == true) goto L29;
            ek1 r15 = this.a.q;
            if (r15 != null) goto L24;
            return;
        L24:
            if (r15.c() != true) goto L31;
            this.a.e = true;
            XplayCoreService r16 = this.a;
            IXplayInstanceApi r2 = r16.d;
            if (r2 == null) goto L32;
            r2.setVideoExternalConfig(r16.q.e(), this.a.q.b(), this.a.q.a(), this.a.q.d());
            return;
        L32:
            return;
        L31:
            return;
        }
    }

    public static final class j<T> implements Predicate {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final boolean test(Object r2) {
            IXplayCoreService.State r3 = (IXplayCoreService.State) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3 != IXplayCoreService.State.Loaded) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ XplayCoreService a;

        public k(XplayCoreService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IXplayCoreService.State r4 = (IXplayCoreService.State) r3;
            XplayCoreService r5 = this.a;
            l20.c r0 = r5.w.a;
            Intrinsics.checkNotNullParameter(r0, "manager");
            IXplayMessageInterface r6 = r5.d;
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.isInitialized() == true) goto L8;
            r6 = null;
        L8:
            if (r6 == null) goto L12;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "xplayMessageInterface");
            r0.a = r6;
            r6.registerReceiveMsgListener(r0);
            return;
        }
    }

    static {
    }

    public final void onStop() {
        this.e = false;
        i();
        this.a.clear();
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r0 = this.p;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        l20.e r1 = this.w;
        XplayMessageType r2 = XplayMessageType.XPLAY_SWITCH_GUIDE_PLAYER;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "type");
        l20.c r3 = r1.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "type");
        r3.b.remove(r2);
        l20.e r4 = this.w;
        XplayMessageType r5 = XplayMessageType.XPLAY_INTERACT_CUSTOM;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "type");
        l20.c r6 = r4.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "type");
        r6.b.remove(r5);
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void I() {
        IXplayInstanceApi r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isInitialized() != true) goto L9;
        r0.showKeyboard(true);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void J() {
        if (this.h == IXplayCoreService.State.Loaded) goto L6;
        q.a r0 = q.c;
        XplayErrorCode r1 = XplayErrorCode.STATE_NOT_LOADED;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "xplayErrorCode");
        f(new q(r1, null));
        return;
    L6:
        IXplayInstanceApi r2 = this.d;
        if (r2 != null) goto L10;
        q.a r3 = q.c;
        XplayErrorCode r4 = XplayErrorCode.XPLAY_INSTANCE_NULL;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "xplayErrorCode");
        f(new q(r4, null));
        h(IXplayCoreService.State.Stopped);
        return;
    L10:
        XplayLog.c("XplayCoreService", "running game");
        r2.playGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final View K() {
        IXplayInstanceApi r0 = this.d;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isInitialized() == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getGameView();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void R() {
        uf2.d0 r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getLiveStream();
        if (r1 == null) goto L9;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r1.getValue();
        if (r2 == null) goto L9;
        r4 = r2.A();
    L9:
        if (r4 == null) goto L12;
        r4.h();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final View Y() {
        IXplayInstanceApi r0 = this.d;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isInitialized() == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getGameGuideView();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final Boolean g() {
        return this.s.b;
    }

    public final void i() {
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "stopGame called, state=" + this.h + ", instance=" + this.d);
        IXplayInstanceApi r1 = this.d;
        if (r1 != null) goto L5;
    L7:
        this.d = null;
        this.i = null;
        h(IXplayCoreService.State.Stopped);
        return;
    L5:
        if (r1.isInitialized() != true) goto L7;
        r1.stopGame();
        goto L7
    }

    public final void onStart() {
        IXplayInstanceApi r0 = this.d;
        if (r0 == null) goto L5;
        Single r1 = Single.just(r0);
    L6:
        RxUtilKt.c(r1.subscribe(e.a, f.a), this.a);
        int r2 = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.c;
        com.bytedance.android.live.broadcastgame.api.xplay.p r3 = this.r;
        long r4 = r3.b;
        String r5 = r3.c;
        com.bytedance.android.live.broadcastgame.api.xplay.l r6 = r3.h;
        this.p = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.C0106a.a(new com.bytedance.android.live.broadcastgame.xplay.screendetect.c(true, r4, r5, r6.d, r6.b, r6.c));
        RxUtilKt.c(this.j.filter(g.a).subscribe(new h(this)), this.a);
        RxUtilKt.c(this.l.subscribe(new i(this)), this.a);
        RxUtilKt.c(this.j.filter(j.a).subscribe(new k(this)), this.a);
        l20.e r7 = this.w;
        XplayMessageType r8 = XplayMessageType.XPLAY_SWITCH_GUIDE_PLAYER;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(this, "listener");
        l20.c r9 = r7.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(this, "listener");
        r9.b.put(r8, this);
        l20.e r11 = this.w;
        XplayMessageType r12 = XplayMessageType.XPLAY_INTERACT_CUSTOM;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(this, "listener");
        l20.c r13 = r11.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(this, "listener");
        r13.b.put(r12, this);
        return;
    L5:
        r1 = Single.create(new o(this));
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void pauseGame() {
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "pauseGame called, state=" + this.h + ", instance=" + this.d);
        IXplayInstanceApi r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isInitialized() != true) goto L11;
        IXplayInstanceApi r2 = this.d;
        if (r2 == null) goto L12;
        r2.pauseGame();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void resumeGame() {
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "resumeGame called, state=" + this.h + ", instance=" + this.d);
        IXplayInstanceApi r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isInitialized() != true) goto L11;
        IXplayInstanceApi r2 = this.d;
        if (r2 == null) goto L12;
        r2.resumeGame();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final PublishSubject L() {
        return this.l;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final PublishSubject N() {
        return this.j;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final IXplayCoreService.a U() {
        return this.i;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final PublishSubject X() {
        return this.m;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final PublishSubject getOnError() {
        return this.k;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final String getRtcExtInfo() {
        return this.n;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final IXplayCoreService.State getState() {
        return this.h;
    }

    public static final void d(XplayCoreService r3) {
        r3.getClass();
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "stop guide player, state=" + r3.h + ", instance=" + r3.d);
        IXplayInstanceApi r1 = r3.d;
        r3.f = 0;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isInitialized() != true) goto L9;
        r1.stopGuideGame();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void S(IXplayCoreService.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        IXplayInstanceApi r0 = this.d;
        if (r0 == null) goto L5;
        Single r1 = Single.just(r0);
    L6:
        RxUtilKt.c(r1.subscribe(new c(this, r3), new d(this)), this.a);
        return;
    L5:
        r1 = Single.create(new o(this));
        goto L6
    }

    @Override // h10.a
    public final void a(a10.d r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "on xplay message, message: " + r8);
        String r1 = r8.a();
        int r2 = r1.hashCode();
        boolean r4 = false;
        a10.a r6 = null;
        if (r2 == (-1678661222)) goto L34;
        if (r2 == (-638597902)) goto L8;
        return;
    L8:
        if (r1.equals("anchor_guide") == false) goto L70;
        a10.e r3 = r8.b();
        if (r3 == null) goto L12;
        String r5 = r3.getType();
    L14:
        if (Intrinsics.areEqual(r5, "step") == false) goto L71;
        a10.e r9 = r8.b();
        if (r9 == null) goto L18;
        a10.a r11 = r9.a();
    L20:
        if ((r11 instanceof a10.b) == false) goto L23;
        r6 = r11;
    L23:
        a10.b r7 = (a10.b) r6;
        if (r7 == null) goto L72;
        com.bytedance.android.live.broadcastgame.api.model.q0 r12 = this.r.h.l;
        if (r12 != null) goto L28;
    L30:
        XplayLog.c("XplayCoreService", "on xplay anchor guide message, step: " + r7.a() + ", isSupportGuidePlayer=" + r4);
        if (r4 == false) goto L73;
        int r13 = r7.a();
        Lazy r14 = LiveOpenGameClient.d;
        RxUtilKt.c(RxUtilKt.i(((XplayApi) LiveOpenGameClient.a.a().a(XplayApi.class)).switchToGuide(this.r.h.b, r13)).subscribe(new m(this), n.a), this.a);
        return;
    L73:
        return;
    L28:
        if (r12.f() != true) goto L30;
        r4 = true;
        goto L30
    L72:
        return;
    L18:
        r11 = null;
        goto L20
    L71:
        return;
    L12:
        r5 = null;
        goto L14
    L70:
        return;
    L34:
        if (r1.equals("interact_custom") == false) goto L75;
        a10.e r15 = r8.b();
        if (r15 == null) goto L38;
        String r16 = r15.getType();
    L40:
        if (Intrinsics.areEqual(r16, "open_lynx_dialog") == false) goto L76;
        a10.e r17 = r8.b();
        if (r17 == null) goto L44;
        a10.a r18 = r17.a();
    L46:
        if ((r18 instanceof a10.c) == false) goto L49;
        r6 = r18;
    L49:
        a10.c r19 = (a10.c) r6;
        if (r19 != null) goto L52;
        return;
    L52:
        if (Intrinsics.areEqual(r19.b(), "true") == false) goto L78;
        Context r21 = this.r.getContext();
        String r22 = r19.a();
        PublishSubject<Unit> r23 = q1.a;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "schema");
        if (r22.length() != 0) goto L56;
        boolean r24 = true;
    L57:
        if (r24 == true) goto L81;
        Uri r25 = new u6(r22).c();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L62
        Object r27 = Result.constructor-impl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(r21, r25, new r1()));     // Catch: Throwable -> L62
    L64:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L79;
        int r29 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("XplayUtils", new Object[]{"lynx dialog start failed, cause: " + r28.getCause() + ", message: " + r28.getMessage()});
        return;
    L79:
        return;
    L62:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L81:
        return;
    L56:
        r24 = false;
        goto L57
    L78:
        return;
    L44:
        r18 = null;
        goto L46
    L76:
        return;
    L38:
        r16 = null;
        goto L40
    }

    public final void f(q r5) {
        int r0 = r5.a();
        boolean r2 = false;
        if (r0 != 2001) goto L5;
        Pair r1 = TuplesKt.to(2131923514, Boolean.FALSE);
    L24:
        boolean r3 = ((Boolean) r1.getSecond()).booleanValue();
        Object r4 = r1.getFirst();
        if (((Number) r4).intValue() == 0) goto L27;
        r2 = true;
    L27:
        String r6 = null;
        if (r2 == true) goto L31;
        r4 = null;
    L31:
        Integer r7 = (Integer) r4;
        if (r7 == null) goto L34;
        r6 = this.r.getContext().getString(r7.intValue());
    L34:
        if (r6 != null) goto L36;
        r6 = "";
    L36:
        XplayException r8 = new XplayException(r5, r3, r6);
        int r9 = XplayLog.a;
        XplayLog.a("XplayCoreService", "error: " + r8);
        this.k.onNext(r8);
        return;
    L5:
        if (r0 != 2005) goto L7;
    L22:
        r1 = TuplesKt.to(2131923524, Boolean.FALSE);
        goto L24
    L7:
        if (r0 != 2007) goto L9;
        r1 = TuplesKt.to(2131923525, Boolean.FALSE);
        goto L24
    L9:
        if (r0 == 2011) goto L22;
        if (r0 != 2024) goto L13;
        r1 = TuplesKt.to(2131923519, Boolean.FALSE);
        goto L24
    L13:
        if (r0 == 2099) goto L19;
        switch(r0) {
            case 2016: goto L18;
            case 2017: goto L17;
            case 2018: goto L16;
            default: goto L15;
        };
    L15:
        r1 = TuplesKt.to(0, Boolean.TRUE);
        goto L24
    L16:
        r1 = TuplesKt.to(2131923518, Boolean.FALSE);
        goto L24
    L17:
        r1 = TuplesKt.to(2131923517, Boolean.FALSE);
        goto L24
    L18:
        r1 = TuplesKt.to(2131923516, Boolean.FALSE);
        goto L24
    L19:
        r1 = TuplesKt.to(2131923530, Boolean.FALSE);
        goto L24
    }

    public final void h(IXplayCoreService.State r3) {
        if (this.h == r3) goto L6;
        int r0 = XplayLog.a;
        XplayLog.a("XplayCoreService", "state changed from " + this.h + " to " + r3);
        this.h = r3;
        this.j.onNext(r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void setRtcExtInfo(String r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void updateEnableAudioFrame(boolean r3) {
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "updateEnableAudioFrame: " + r3);
        IXplayInstanceApi r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isInitialized() == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L12;
        r1.updateEnableAudioFrame(r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService
    public final void updateEnableVideoFrame(boolean r3) {
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "updateEnableVideoFrame: " + r3);
        IXplayInstanceApi r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isInitialized() == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L12;
        r1.updateEnableVideoFrame(r3);
        return;
    }

    public XplayCoreService(com.bytedance.android.live.broadcastgame.api.xplay.p r2, XplayMonitorSession r3, g0 r4, XplayInternalContext r5, k20.e r6, l20.e r7) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "monitorSession");
        Intrinsics.checkNotNullParameter(r4, "xplayLogService");
        Intrinsics.checkNotNullParameter(r5, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r6, "xplayTerminateService");
        Intrinsics.checkNotNullParameter(r7, "xplayMessageService");
        this.r = r2;
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.v = r6;
        this.w = r7;
        CompositeDisposable r8 = new CompositeDisposable();
        this.a = r8;
        this.b = r2.d;
        this.h = IXplayCoreService.State.Stopped;
        this.j = PublishSubject.create();
        this.k = PublishSubject.create();
        PublishSubject<com.bytedance.android.live.broadcastgame.api.xplay.g> r9 = PublishSubject.create();
        this.l = r9;
        this.m = PublishSubject.create();
        t r11 = new t(r9);
        RxUtilKt.c(r11, r8);
        Unit r12 = Unit.INSTANCE;
        this.o = r11;
        int r13 = f1.a;
        XplayScene r14 = r2.f;
        Intrinsics.checkNotNullParameter(r14, "scene");
        Map r15 = (Map) rz0.a.getValue();
        if (r15 != null) goto L5;
        r15 = MapsKt.emptyMap();
    L5:
        int r16 = e1.a[r14.ordinal()];
        if (r16 != 1) goto L8;
        String r17 = "scene_single";
    L16:
        this.q = (ek1) r15.get(r17);
        return;
    L8:
        if (r16 != 2) goto L10;
        r17 = "scene_multi";
        goto L16
    L10:
        if (r16 != 3) goto L13;
        r17 = "scene_interact";
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static final void c(XplayCoreService r2, com.bytedance.android.live.broadcastgame.api.xplay.p r3, int r4, String r5, boolean r6, Function0 r7) {
        r2.getClass();
        if (r3.f != XplayScene.TalkRoom) goto L11;
        com.bytedance.android.live.broadcastgame.api.xplay.s r0 = r3.j;
        if (r0 == null) goto L7;
        XplayGuestType r1 = r0.i;
    L9:
        if (r1 != XplayGuestType.SILENCE) goto L11;
        r7.invoke();
        return;
    L7:
        r1 = null;
    L11:
        com.bytedance.android.livesdk.widget.x0 r8 = q1.h(r3, r4, r5, r6, r7);
        if (r2.g != null) goto L14;
        r2.g = new ArrayList();
    L14:
        List<Dialog> r9 = r2.g;
        if (r9 == null) goto L19;
        ((ArrayList) r9).add(r8);
        return;
    }
}
