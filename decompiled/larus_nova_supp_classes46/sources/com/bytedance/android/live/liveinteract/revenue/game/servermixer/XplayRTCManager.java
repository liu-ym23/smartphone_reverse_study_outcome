package com.bytedance.android.live.liveinteract.revenue.game.servermixer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.utils.l;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.mv0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.LiveWrappedSubscribeConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomState;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomStateChangeReason;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedStreamRemoveReason;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveUgcPlatformHostInvitationConfig;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import dg2.f;
import g10.e;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zf2.k0;
import zf2.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class XplayRTCManager {
    public final CompositeDisposable a;
    public boolean b;
    public String c;
    public final Set<String> d;
    public k0 e;
    public final b f;
    public final j1 g;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ XplayRTCManager a;

        public final void onInitReqSuccess() {
            LinkMicGameContext r0 = LinkMicGameContext.Companion.getContext();
            if (r0 == null) goto L5;
            int r1 = (int) r0.getTargetUiLayout();
        L6:
            ALogger.i("XplayRTCManager", "onInitReqSuccess, targetUiLayout: " + r1);
            if (r1 == 16) goto L11;
            if (r1 == 65) goto L11;
            return;
        L11:
            if (((LiveUgcPlatformHostInvitationConfig) mv0.a.getValue()).getEnabled() == false) goto L15;
            XplayRTCManager.b(this.a, LinkApi.XplayInitCallbackStatus.STATUS_SUCCESS.getValue());
            return;
        L15:
            return;
        L5:
            r1 = 0;
            goto L6
        }

        public final void onInitSuccess() {
            ALogger.i("XplayRTCManager", "onInitSuccess");
        }

        public b(XplayRTCManager r1) {
            this.a = r1;
        }

        public final void c(int r3, JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            if (r3 != 8) goto L14;
            LinkMicGameContext.a r5 = LinkMicGameContext.Companion;
            LinkMicGameContext r6 = r5.getContext();
            if (r6 == null) goto L7;
            int r7 = (int) r6.getTargetUiLayout();
        L8:
            ALogger.i("XplayRTCManager", "IXplayPlayerEventObserver#onPlayerEvent -> EVENT_FIRST_FRAME, targetUiLayout: " + r7);
            if (r7 == 15) goto L11;
            return;
        L11:
            if (r5.d() == false) goto L16;
            XplayRTCManager.b(this.a, LinkApi.XplayInitCallbackStatus.STATUS_SUCCESS.getValue());
            return;
        L16:
            return;
        L7:
            r7 = 0;
            goto L8
        }
    }

    static {
    }

    public final void g() {
        this.b = false;
        this.e = null;
        Iterator<String> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        String r1 = r0.next();
        cg6.a r2 = c();
        if (r2 == null) goto L4;
        g r3 = r2.getRtcManager();
        if (r3 == null) goto L4;
        ei6.a r4 = r3.V0();
        if (r4 == null) goto L4;
        gi6.e r5 = r4.getEventManager();
        if (r5 == null) goto L4;
        r5.c(r1);
        goto L4
    L14:
        this.d.clear();
    }

    public final cg6.a c() {
        return this.g.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    public final void d() {
        if (LinkMicGameContext.Companion.d() == true) goto L6;
        return;
    L6:
        if (je0.d.D() == false) goto L17;
        cg6.a r0 = c();
        if (r0 == null) goto L18;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L19;
        ei6.a r2 = r1.V0();
        if (r2 == null) goto L20;
        ALogger.i("XplayRTCManager", "invalidateSei");
        vi6.a r3 = r2.v();
        if (r3 == null) goto L21;
        r3.f();
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void f() {
        if (this.b == true) goto L5;
        return;
    L5:
        n.a.a(qi0.d.a, true, "leaveXplayRTCRoom", null, 12);
        cg6.a r0 = c();
        if (r0 == null) goto L14;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L14;
        ei6.a r2 = r1.V0();
        if (r2 == null) goto L14;
        si6.b r3 = r2.b();
        if (r3 == null) goto L14;
        r3.h(String.valueOf(this.c), "leaveXplayRTCRoom");
    L14:
        this.b = false;
        this.e = null;
        this.a.clear();
    }

    public XplayRTCManager(j1 r2) {
        Intrinsics.checkNotNullParameter(r2, "scopeProvider");
        this.g = r2;
        this.a = new CompositeDisposable();
        this.d = new LinkedHashSet();
        this.f = new b(this);
    }

    public final void e(String r21) {
        ALogger.i("XplayRTCManager", "joinXplayRTCRoom, rtcExtInfo: " + r21);
        qi0.d r2 = qi0.d.a;
        if (r21 != null) goto L5;
        String r5 = "";
    L6:
        boolean r6 = true;
        n.a.a(r2, true, "joinXplayRTCRoom", r5, 4);
        if (LinkMicGameContext.Companion.d() == true) goto L11;
        ALogger.e("XplayRTCManager", "joinXplayRTCRoom failed, cause: server merge disable");
        n.a.a(r2, true, "joinXplayRTCRoomFailed", "joinXplayRTCRoom failed, cause: server merge disable", 4);
        return;
    L11:
        if (this.b == false) goto L14;
        ALogger.e("XplayRTCManager", "joinXplayRTCRoom failed, cause: isJoinGameRtcRoom");
        n.a.a(r2, true, "joinXplayRTCRoomFailed", "joinXplayRTCRoom failed, cause: isJoinGameRtcRoom", 4);
        return;
    L14:
        qi0.a r9 = qi0.a.j;
        LinkMonitorData r10 = LinkMonitorData.StartMixStream;
        HashMap r7 = new HashMap();
        r7.put("xplay_mix_stream_type", 1);
        Unit r8 = Unit.INSTANCE;
        l.a.a(r9, r10, null, null, 0, null, null, null, null, r7, 254);
        cg6.a r11 = c();
        Integer r12 = null;
        String r13 = null;
        if (r11 == null) goto L19;
        g r14 = r11.getRtcManager();
        if (r14 == null) goto L19;
        ei6.a r15 = r14.V0();
    L20:
        if (r15 != null) goto L23;
        ALogger.e("XplayRTCManager", "joinXplayRTCRoom failed, cause: Client is null");
        n.a.a(r2, true, "joinXplayRTCRoomFailed", "joinXplayRTCRoom failed, cause: Client is null", 4);
        return;
    L23:
        cg6.a r16 = c();
        if (r16 == null) goto L32;
        g r17 = r16.getRtcManager();
        if (r17 == null) goto L32;
        ei6.a r18 = r17.V0();
        if (r18 == null) goto L32;
        ui6.d r19 = r18.l();
        if (r19 == null) goto L32;
        mi6.a r20 = r19.b();
    L33:
        if (r20 != null) goto L36;
        ALogger.e("XplayRTCManager", "joinXplayRTCRoom failed, cause: Client#rtcEngine is null");
        n.a.a(r2, true, "joinXplayRTCRoomFailed", "joinXplayRTCRoom failed, cause: Client#rtcEngine is null", 4);
        return;
    L36:
        if (r21 == null) goto L112;
        cg6.a r3 = c();
        if (r3 == null) goto L113;
        g r4 = r3.getRtcManager();
        if (r4 == null) goto L114;
        ei6.a r22 = r4.V0();
        if (r22 == null) goto L115;
        li6.a r23 = r22.e();
        if (r23 == null) goto L116;
        final li6.c r1 = r23.b(r21);
        if (r1 == null) goto L117;
        cg6.a r24 = c();
        if (r24 == null) goto L52;
        g r25 = r24.getRtcManager();
        if (r25 == null) goto L52;
        ei6.a r26 = r25.V0();
    L53:
        if (r26 == null) goto L72;
        cg6.a r27 = c();
        if (r27 == null) goto L63;
        g r28 = r27.getRtcManager();
        if (r28 == null) goto L63;
        ei6.a r29 = r28.V0();
        if (r29 == null) goto L63;
        ui6.d r30 = r29.l();
        if (r30 == null) goto L63;
        mi6.a r31 = r30.b();
    L64:
        if (r31 == null) goto L72;
        cg6.a r32 = c();
        if (r32 == null) goto L72;
        g r33 = r32.getRtcManager();
        if (r33 == null) goto L72;
        if (r33.isEngineOn() != true) goto L72;
    L73:
        if (r6 == false) goto L118;
        final yf2.d r34 = new yf2.d(LiveWrappedRoomProfile.LIVE, false, false, false, false);
        li6.b r35 = r1.c;
        if (r35 == null) goto L77;
        String r36 = r35.b;
    L78:
        this.c = String.valueOf(r36);
        cg6.a r37 = c();
        if (r37 == null) goto L119;
        g r38 = r37.getRtcManager();
        if (r38 == null) goto L120;
        ei6.a r39 = r38.V0();
        if (r39 == null) goto L121;
        gi6.e r40 = r39.getEventManager();
        if (r40 == null) goto L89;
        String r41 = r40.a(EventCategory.RTC_ROOM_EVENT, null, new XplayRTCManager$joinXplayRTCRoom$$inlined$let$lambda$1(r1, r34, this));
        if (r41 == null) goto L89;
        this.d.add(r41);
    L89:
        gi6.e r42 = r39.getEventManager();
        if (r42 == null) goto L94;
        String r43 = r42.a(EventCategory.RTC_ROOM_EVENT_EX, null, new XplayRTCManager$joinXplayRTCRoom$$inlined$let$lambda$2(r1, r34, this));
        if (r43 == null) goto L94;
        this.d.add(r43);
    L94:
        si6.b r44 = r39.b();
        if (r44 == null) goto L106;
        String r110 = String.valueOf(this.c);
        li6.b r45 = r1.c;
        if (r45 == null) goto L99;
        r13 = r45.d;
    L99:
        String r111 = String.valueOf(r13);
        li6.b r46 = r1.c;
        if (r46 == null) goto L104;
        String r47 = r46.e;
        if (r47 == null) goto L104;
    L105:
        r12 = Integer.valueOf(r44.e(r110, r111, new yf2.e(r47, ""), false, r34));
    L104:
        r47 = "";
    L106:
        StringBuilder r48 = new StringBuilder("joinXplayRTCRoom, result: ");
        if (r12 == null) goto L109;
        int r49 = r12.intValue();
    L110:
        r48.append(r49);
        ALogger.i("XplayRTCManager", r48.toString());
        return;
    L109:
        r49 = -100;
        goto L110
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L77:
        r36 = null;
        goto L78
    L118:
        return;
    L63:
        r31 = null;
    L72:
        r6 = false;
    L52:
        r26 = null;
        goto L53
    L117:
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L112:
        return;
    L32:
        r20 = null;
    L19:
        r15 = null;
        goto L20
    L5:
        r5 = r21;
        goto L6
    }

    public static final void a(XplayRTCManager r27, gi6.b r28) {
        r27.getClass();
        Object r2 = r28.c.get("eventRoomId");
        if ((r2 instanceof String) == true) goto L6;
        r2 = null;
    L6:
        if ((!Intrinsics.areEqual((String) r2, r27.c)) == true) goto L211;
        String r3 = r28.b.a;
        switch(r3.hashCode()) {
            case -1642280985: goto L167;
            case -365409287: goto L141;
            case 290739853: goto L124;
            case 375208499: goto L115;
            case 907966412: goto L88;
            case 1613378754: goto L63;
            case 1630424339: goto L57;
            case 1828836371: goto L30;
            case 1886872389: goto L12;
            default: goto L212;
        };
    L212:
        return;
    L12:
        if (r3.equals("onUserPublishStream") == false) goto L193;
        Object r4 = r28.c.get("streamKey");
        if ((r4 instanceof k0) == true) goto L16;
        r4 = null;
    L16:
        k0 r5 = (k0) r4;
        Object r6 = r28.c.get("type");
        if ((r6 instanceof LiveWrappedMediaStreamType) == true) goto L19;
        r6 = null;
    L19:
        LiveWrappedMediaStreamType r7 = (LiveWrappedMediaStreamType) r6;
        Object r1 = r28.c.get("isScreen");
        if (r1 == null) goto L28;
        boolean r8 = ((Boolean) r1).booleanValue();
        ALogger.i("XplayRTCManager", "onUserPublishStream, streamKey: " + r5 + ", isScreen: " + r8 + ", type: " + r7);
        qi0.d r9 = qi0.d.a;
        n.a.a(r9, true, "onUserPublishStream", "streamKey: " + r5 + ", isScreen: " + r8 + ", type: " + r7, 4);
        if (r7 != LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO) goto L26;
        r27.e = r5;
        ALogger.i("XplayRTCManager", "onPodPublishStream");
        n.a.a(r9, true, "onPodPublishStream", null, 12);
        qi0.a r16 = qi0.a.j;
        LinkMonitorData r17 = LinkMonitorData.MixStreamFirstFrameSuccess;
        HashMap r10 = new HashMap();
        r10.put("xplay_mix_stream_type", 1);
        Unit r11 = Unit.INSTANCE;
        l.a.a(r16, r17, null, null, 0, null, null, null, null, r10, 254);
        if (v.a() == false) goto L26;
        f2.c("全链路服务端合流：启动", 0);
    L26:
        r27.d();
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L193:
        return;
    L30:
        if (r3.equals("onStreamPublishSuccess") == false) goto L195;
        HashMap r12 = r28.c;
        if (r12 == null) goto L34;
        Object r13 = r12.get("uid");
    L36:
        if ((r13 instanceof String) == true) goto L38;
        r13 = null;
    L38:
        String r14 = (String) r13;
        if (r14 != null) goto L41;
        r14 = "";
    L41:
        HashMap r15 = r28.c;
        if (r15 == null) goto L44;
        Object r18 = r15.get("streamIndex");
    L46:
        if ((r18 instanceof LiveWrappedStreamIndex) == true) goto L48;
        r18 = null;
    L48:
        LiveWrappedStreamIndex r19 = (LiveWrappedStreamIndex) r18;
        HashMap r20 = r28.c;
        if (r20 == null) goto L51;
        Object r21 = r20.get("isScreen");
    L52:
        if (r21 == null) goto L55;
        ALogger.i("XplayRTCManager", "onStreamPublishSuccess, rtcUserId: " + r14 + ", streamIndex: " + r19 + ", isScreen: " + ((Boolean) r21).booleanValue());
        r27.d();
        return;
    L55:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L51:
        r21 = null;
        goto L52
    L44:
        r18 = null;
        goto L46
    L34:
        r13 = null;
        goto L36
    L195:
        return;
    L57:
        if (r3.equals("onLeaveRoom") == false) goto L197;
        Object r22 = r28.c.get("stats");
        if ((r22 instanceof f) == true) goto L61;
        r22 = null;
    L61:
        f r23 = (f) r22;
        ALogger.i("XplayRTCManager", "onLeaveRoom");
        n.a.a(qi0.d.a, true, "onLeaveRoom", null, 12);
        r27.g();
        return;
    L197:
        return;
    L63:
        if (r3.equals("onStreamStateChanged") == false) goto L199;
        HashMap r24 = r28.c;
        if (r24 == null) goto L67;
        Object r25 = r24.get("streamKey");
    L69:
        if ((r25 instanceof o0) == true) goto L71;
        r25 = null;
    L71:
        o0 r26 = (o0) r25;
        HashMap r29 = r28.c;
        if (r29 == null) goto L74;
        Object r30 = r29.get("state");
    L75:
        if (r30 == null) goto L86;
        int r31 = ((Integer) r30).intValue();
        HashMap r32 = r28.c;
        if (r32 == null) goto L79;
        Object r33 = r32.get("extraInfo");
    L81:
        if ((r33 instanceof String) == true) goto L83;
        Object r34 = null;
    L84:
        String r35 = (String) r34;
        ALogger.i("XplayRTCManager", "onStreamStateChanged, streamKey: " + r26 + ", state: " + r31);
        r27.d();
        return;
    L83:
        r34 = r33;
        goto L84
    L79:
        r33 = null;
        goto L81
    L86:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L74:
        r30 = null;
        goto L75
    L67:
        r25 = null;
        goto L69
    L199:
        return;
    L88:
        if (r3.equals("onUserUnpublishStream") == false) goto L201;
        HashMap r36 = r28.c;
        if (r36 == null) goto L92;
        Object r37 = r36.get("streamKey");
    L94:
        if ((r37 instanceof k0) == true) goto L96;
        r37 = null;
    L96:
        k0 r38 = (k0) r37;
        HashMap r39 = r28.c;
        if (r39 == null) goto L99;
        Object r40 = r39.get("type");
    L101:
        if ((r40 instanceof LiveWrappedMediaStreamType) == true) goto L103;
        r40 = null;
    L103:
        LiveWrappedMediaStreamType r41 = (LiveWrappedMediaStreamType) r40;
        HashMap r42 = r28.c;
        if (r42 == null) goto L106;
        Object r43 = r42.get("reason");
    L108:
        if ((r43 instanceof LiveWrappedStreamRemoveReason) == true) goto L110;
        r43 = null;
    L110:
        LiveWrappedStreamRemoveReason r44 = (LiveWrappedStreamRemoveReason) r43;
        ALogger.i("XplayRTCManager", "onUserUnpublishStream, streamKey: " + r38 + ", type: " + r41 + ", reason: " + r44);
        n.a.a(qi0.d.a, true, "onUserUnpublishStream", "streamKey: " + r38 + ", type: " + r41 + ", reason: " + r44, 4);
        if (r41 != LiveWrappedMediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO) goto L113;
        r27.e = null;
    L113:
        r27.d();
        return;
    L106:
        r43 = null;
        goto L108
    L99:
        r40 = null;
        goto L101
    L92:
        r37 = null;
        goto L94
    L201:
        return;
    L115:
        if (r3.equals("onUserJoined") == false) goto L203;
        Object r45 = r28.c.get("userInfo");
        if ((r45 instanceof yf2.e) == true) goto L119;
        Object r46 = null;
    L120:
        yf2.e r47 = (yf2.e) r46;
        if (r47 == null) goto L204;
        ALogger.i("XplayRTCManager", "onUserJoined, userInfo: " + r47.a);
        n.a.a(qi0.d.a, true, "onUserJoined", "userInfo: " + r47.a, 4);
        r27.d();
        return;
    L204:
        return;
    L119:
        r46 = r45;
        goto L120
    L203:
        return;
    L124:
        if (r3.equals("onUserLeave") == false) goto L206;
        Object r48 = r28.c.get("uid");
        if ((r48 instanceof String) == true) goto L128;
        r48 = null;
    L128:
        String r49 = (String) r48;
        if (r49 != null) goto L131;
        r49 = "";
    L131:
        Object r50 = r28.c.get("reason");
        if ((r50 instanceof Integer) == true) goto L134;
        Object r51 = null;
    L135:
        Integer r52 = (Integer) r51;
        if (r52 == null) goto L138;
        int r53 = r52.intValue();
    L139:
        ALogger.i("XplayRTCManager", "onUserLeave, rtcUserId: " + r49 + ", reason: " + r53);
        n.a.a(qi0.d.a, true, "onUserLeave", "rtcUserId: " + r49 + ", reason: " + r53, 4);
        r27.d();
        return;
    L138:
        r53 = 0;
        goto L139
    L134:
        r51 = r50;
        goto L135
    L206:
        return;
    L141:
        if (r3.equals("onStreamSubscribed") == false) goto L208;
        Object r54 = r28.c.get("stateCode");
        if ((r54 instanceof Integer) == true) goto L145;
        r54 = null;
    L145:
        Integer r55 = (Integer) r54;
        if (r55 == null) goto L148;
        int r56 = r55.intValue();
    L149:
        Object r57 = r28.c.get("userId");
        if ((r57 instanceof String) == true) goto L152;
        r57 = null;
    L152:
        String r58 = (String) r57;
        if (r58 != null) goto L155;
        r58 = "";
    L155:
        Object r59 = r28.c.get("streamIndex");
        if ((r59 instanceof LiveWrappedStreamIndex) == true) goto L158;
        r59 = null;
    L158:
        LiveWrappedStreamIndex r60 = (LiveWrappedStreamIndex) r59;
        Object r61 = r28.c.get("info");
        if ((r61 instanceof LiveWrappedSubscribeConfig) == true) goto L161;
        r61 = null;
    L161:
        LiveWrappedSubscribeConfig r62 = (LiveWrappedSubscribeConfig) r61;
        StringBuilder r63 = new StringBuilder("onStreamSubscribed, stateCode: ");
        r63.append(r56);
        r63.append(", userId: ");
        r63.append(r58);
        r63.append(", streamIndex: ");
        r63.append(r60);
        r63.append(", subAudio: ");
        if (r62 == null) goto L164;
        Boolean r65 = Boolean.FALSE;
    L165:
        r63.append(r65);
        ALogger.i("XplayRTCManager", r63.toString());
        r27.d();
        return;
    L164:
        r65 = null;
        goto L165
    L148:
        r56 = 0;
        goto L149
    L208:
        return;
    L167:
        if (r3.equals("onRoomStateChangedWithReason") == false) goto L210;
        Object r66 = r28.c.get("roomId");
        if ((r66 instanceof String) == true) goto L171;
        r66 = null;
    L171:
        String r67 = (String) r66;
        Object r68 = r28.c.get("uid");
        if ((r68 instanceof String) == true) goto L174;
        r68 = null;
    L174:
        String r69 = (String) r68;
        Object r70 = r28.c.get("state");
        if ((r70 instanceof LiveWrappedRoomState) == true) goto L177;
        r70 = null;
    L177:
        LiveWrappedRoomState r71 = (LiveWrappedRoomState) r70;
        Object r72 = r28.c.get("reason");
        if ((r72 instanceof LiveWrappedRoomStateChangeReason) == true) goto L180;
        r72 = null;
    L180:
        LiveWrappedRoomStateChangeReason r73 = (LiveWrappedRoomStateChangeReason) r72;
        String r74 = "onRoomStateChangedWithReason, roomId: " + r67 + ", rtcUserId: " + r69 + ", state: " + r71 + ", reason: " + r73;
        ALogger.i("XplayRTCManager", r74);
        n.a.a(qi0.d.a, true, "onRoomStateChangedWithReason", r74, 4);
        if (r71 != LiveWrappedRoomState.JOIN_SUCCESS) goto L186;
        if (LiveWrappedRoomStateChangeReason.JOIN_ROOM != r73) goto L186;
        ALogger.i("XplayRTCManager", "joinGameRtcRoom success");
        r27.b = true;
    L191:
        r27.d();
        return;
    L186:
        if (r71 != LiveWrappedRoomState.JOIN_FAILED) goto L189;
        ALogger.e("XplayRTCManager", "joinGameRtcRoom failed, reason: " + r73);
        r27.b = false;
        r27.g();
        goto L191
    L189:
        if (r71 != LiveWrappedRoomState.LEFT) goto L191;
        ALogger.i("XplayRTCManager", "leaveGameRtcRoom success");
        r27.g();
        goto L191
    L210:
        return;
    }

    public static final void b(XplayRTCManager r11, int r12) {
        r11.getClass();
        ALogger.i("XplayRTCManager", "notifyServerXplayInitCallback, status: " + r12);
        n.a.a(qi0.d.a, true, "notifyServerXplayInitCallback", "initStatus: " + r12, 4);
        long r6 = je0.d.a0();
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).xplayInitCallback(r6, r12, LinkApi.XplayInitCallbackScene.SCENE_DANMU.getValue(), "anchor_init_success").compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r12, r0), new d(r12, r0)), r11.a);
    }
}
