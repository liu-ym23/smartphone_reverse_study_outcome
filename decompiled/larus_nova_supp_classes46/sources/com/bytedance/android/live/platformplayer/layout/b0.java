package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.AsyncAuthData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveRefreshStreamListener;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements IPaidLiveRefreshStreamListener {
    public final /* synthetic */ LivePlayerWidget a;

    public b0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void requestStream4BuyTicket(IRoom r41, List<? extends VSCameraInfo> r42) {
        if ((r41 instanceof IRoom) == true) goto L5;
        return;
    L5:
        String r12 = "buy_ticket";
        String r11 = "0";
        long r25 = 0;
        if (r41.getStreamUrl() == null) goto L173;
        StringBuilder r2 = new StringBuilder("LivePlayerWidget: refresh room stream for buy ticket, roomId=");
        r2.append(r41.getId());
        r2.append(", currentRoomId=");
        Room r7 = this.a.U2.w();
        if (r7 == null) goto L10;
        Long r8 = Long.valueOf(r7.id);
    L11:
        r2.append(r8);
        ALogger.i("PaidLiveTraceMonitorPaidRefreshStreamAbility", r2.toString());
        if (r41.getId() == 0) goto L172;
        long r9 = r41.getId();
        Room r3 = this.a.U2.w();
        if (r3 == null) goto L172;
        if (r9 != r3.id) goto L172;
        LivePlayerWidget r4 = this.a;
        r4.getClass();
        String r5 = String.valueOf(1);
        com.bytedance.android.livesdk.vscore_api.paidlive.b r6 = jc1.k.n(lu2.f.class).paidLiveUtils();
        Room r10 = r4.U2.w();
        if (r10 == null) goto L21;
        PaidLiveData r13 = r10.getPaidLiveData();
    L23:
        if (r6.v(r13, null) == true) goto L45;
        com.bytedance.android.livesdk.vscore_api.paidlive.g r32 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r14 = new Pair[2];
        StringBuilder r15 = new StringBuilder("room ");
        Room r16 = r4.U2.w();
        if (r16 == null) goto L27;
        Long r17 = Long.valueOf(r16.id);
    L28:
        r15.append(r17);
        r15.append(" no need change stream");
        r14[0] = TuplesKt.to("reason", r15.toString());
        r14[1] = TuplesKt.to("refresh_scene", r5);
        Map r35 = MapsKt.mutableMapOf(r14);
        Map.Entry r18 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r18 == null) goto L35;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r19 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r18.getValue();
        if (r19 == null) goto L35;
        PaidSceneViewEntry r20 = r19.k5();
        if (r20 == null) goto L35;
        String r36 = r20.name();
    L36:
        Map.Entry r21 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r21 == null) goto L43;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r22 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r21.getValue();
        if (r22 == null) goto L43;
        PaidSceneEnum r23 = r22.i0();
        if (r23 == null) goto L43;
        String r37 = r23.name();
    L44:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r32, "paidlive_refresh_stream_fail", null, r35, r36, r37, 2, null);
    L43:
        r37 = null;
    L35:
        r36 = null;
        goto L36
    L27:
        r17 = null;
        goto L28
    L45:
        IBaseStreamUrl r24 = r41.getStreamUrl();
        if (((com.bytedance.android.live.platformplayer.b) r4.ar().invoke()).b() == true) goto L77;
        ILivePlayerClient r26 = r4.dr();
        if (r26 == null) goto L54;
        IRoomEventHub r27 = r26.getEventHub();
        if (r27 == null) goto L54;
        MutableLiveData r28 = r27.getStopped();
        if (r28 == null) goto L54;
        Boolean r29 = (Boolean) r28.getValue();
    L56:
        if (Intrinsics.areEqual(r29, Boolean.TRUE) == false) goto L77;
        ALogger.i("PaidLiveTraceMonitorPaidRefreshStreamAbility", "switchStreamDataForRoom, fragment is not resumed");
        com.bytedance.android.livesdk.vscore_api.paidlive.g r210 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r30 = new Pair[4];
        r30[0] = TuplesKt.to("scene", "room-background");
        r30[1] = TuplesKt.to("refresh_scene", r5);
        String r31 = r41.getCompoundStreamData();
        if (r31 != null) goto L60;
        r31 = "";
    L60:
        r30[2] = TuplesKt.to("stream_data", r31);
        r30[3] = TuplesKt.to("reason", "fragment is not resumed, update room data");
        Map r211 = MapsKt.mutableMapOf(r30);
        Map.Entry r33 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r33 == null) goto L67;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r34 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r33.getValue();
        if (r34 == null) goto L67;
        PaidSceneViewEntry r38 = r34.k5();
        if (r38 == null) goto L67;
        String r212 = r38.name();
    L68:
        Map.Entry r39 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r39 == null) goto L75;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r40 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r39.getValue();
        if (r40 == null) goto L75;
        PaidSceneEnum r43 = r40.i0();
        if (r43 == null) goto L75;
        String r213 = r43.name();
    L76:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r210, "paidlive_refresh_stream_success", null, r211, r212, r213, 2, null);
        r4.os(r41);
    L75:
        r213 = null;
    L67:
        r212 = null;
    L54:
        r29 = null;
    L77:
        ILivePlayerClient r44 = r4.dr();
        if (r44 == null) goto L84;
        IRoomEventHub r45 = r44.getEventHub();
        if (r45 == null) goto L84;
        MutableLiveData r46 = r45.getStopped();
        if (r46 == null) goto L84;
        Boolean r47 = (Boolean) r46.getValue();
    L86:
        if (Intrinsics.areEqual(r47, Boolean.TRUE) == false) goto L107;
        r4.os(r41);
        com.bytedance.android.livesdk.vscore_api.paidlive.g r310 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r48 = new Pair[4];
        r48[0] = TuplesKt.to("scene", "room-stopped");
        r48[1] = TuplesKt.to("refresh_scene", r5);
        String r49 = r41.getCompoundStreamData();
        if (r49 != null) goto L90;
        r49 = "";
    L90:
        r48[2] = TuplesKt.to("stream_data", r49);
        r48[3] = TuplesKt.to("reason", "player is stopped, only update room data");
        Map r311 = MapsKt.mutableMapOf(r48);
        Map.Entry r50 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r50 == null) goto L97;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r51 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r50.getValue();
        if (r51 == null) goto L97;
        PaidSceneViewEntry r52 = r51.k5();
        if (r52 == null) goto L97;
        String r312 = r52.name();
    L98:
        Map.Entry r53 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r53 == null) goto L105;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r54 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r53.getValue();
        if (r54 == null) goto L105;
        PaidSceneEnum r55 = r54.i0();
        if (r55 == null) goto L105;
        String r313 = r55.name();
    L106:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r310, "paidlive_refresh_stream_success", null, r311, r312, r313, 2, null);
    L105:
        r313 = null;
    L97:
        r312 = null;
        goto L98
    L107:
        ILivePlayerClient r56 = r4.dr();
        if (r56 != null) goto L110;
    L150:
        r4.os(r41);
        com.bytedance.android.livesdk.vscore_api.paidlive.g r57 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r110 = new Pair[4];
        r110[0] = TuplesKt.to("scene", "room-not-playing");
        r110[1] = TuplesKt.to("refresh_scene", r5);
        r110[2] = TuplesKt.to("player_state", "not_playing");
        String r58 = r41.getCompoundStreamData();
        if (r58 != null) goto L153;
        r58 = "";
    L153:
        r110[3] = TuplesKt.to("stream_data", r58);
        Map r59 = MapsKt.mutableMapOf(r110);
        Map.Entry r60 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r60 == null) goto L160;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r61 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r60.getValue();
        if (r61 == null) goto L160;
        PaidSceneViewEntry r62 = r61.k5();
        if (r62 == null) goto L160;
        String r63 = r62.name();
    L161:
        Map.Entry r65 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r65 == null) goto L168;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r66 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r65.getValue();
        if (r66 == null) goto L168;
        PaidSceneEnum r67 = r66.i0();
        if (r67 == null) goto L168;
        String r111 = r67.name();
    L169:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r57, "paidlive_refresh_stream_success", null, r59, r63, r111, 2, null);
        r4.Lq(r24, "refresh_paid_stream");
        PaidSceneContext r68 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).u1(PaidSceneEnum.PAID_ROOM);
        if (r68 == null) goto L172;
        r68.setSwitchStreamActionInRoom(new Pair("start_pull", Long.valueOf(System.currentTimeMillis())));
    L168:
        r111 = null;
    L160:
        r63 = null;
        goto L161
    L110:
        if (r56.isPlaying() != true) goto L150;
        r4.os(r41);
        com.bytedance.android.livesdk.vscore_api.paidlive.b r69 = jc1.k.n(lu2.f.class).paidLiveUtils();
        ILivePlayerClient r70 = r4.dr();
        String r71 = r41.getCompoundStreamData();
        NextLiveData r112 = r4.U2.e().getSwitchStreamDataEvent();
        Pair[] r113 = new Pair[6];
        r113[0] = TuplesKt.to("is_preview", "0");
        r113[1] = TuplesKt.to("reason", "buy_ticket");
        IPaidLiveData r114 = com.bytedance.android.live.core.utils.a0.n(((Widget) r4).dataCenter).getPaidLiveData();
        if (r114 == null) goto L117;
        Long r115 = r114.getAsyncAuthAB();
        if (r115 == null) goto L117;
        long r116 = r115.longValue();
    L118:
        r113[2] = TuplesKt.to("async_auth_ab", String.valueOf(r116));
        IPaidLiveData r117 = com.bytedance.android.live.core.utils.a0.n(((Widget) r4).dataCenter).getPaidLiveData();
        if (r117 == null) goto L123;
        Long r118 = r117.needRefreshStream();
        if (r118 == null) goto L123;
        r25 = r118.longValue();
    L123:
        r113[3] = TuplesKt.to("async_auth_operate", String.valueOf(r25));
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.c(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter)) == false) goto L126;
        r11 = "1";
    L126:
        r113[4] = TuplesKt.to("view_right", r11);
        com.bytedance.android.livesdk.vscore_api.paidlive.b r119 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).J0();
        if (r119 == null) goto L129;
        Long r120 = Long.valueOf(r119.w(((Widget) r4).dataCenter));
    L130:
        r113[5] = TuplesKt.to("current_camera_id", String.valueOf(r120.longValue()));
        com.bytedance.android.livesdk.vscore_api.paidlive.b.a.c(r69, r70, r71, r112, MapsKt.mutableMapOf(r113));
        com.bytedance.android.livesdk.vscore_api.paidlive.g r214 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r72 = new Pair[4];
        r72[0] = TuplesKt.to("scene", "room-playing");
        r72[1] = TuplesKt.to("refresh_scene", r5.toString());
        r72[2] = TuplesKt.to("player_state", "playing");
        String r73 = r41.getCompoundStreamData();
        if (r73 != null) goto L133;
        r73 = "";
    L133:
        r72[3] = TuplesKt.to("stream_data", r73);
        Map r314 = MapsKt.mutableMapOf(r72);
        Map.Entry r74 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r74 == null) goto L140;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r75 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r74.getValue();
        if (r75 == null) goto L140;
        PaidSceneViewEntry r76 = r75.k5();
        if (r76 == null) goto L140;
        String r315 = r76.name();
    L141:
        Map.Entry r77 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r4).dataCenter).D2());
        if (r77 == null) goto L148;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r78 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r77.getValue();
        if (r78 == null) goto L148;
        PaidSceneEnum r79 = r78.i0();
        if (r79 == null) goto L148;
        String r316 = r79.name();
    L149:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r214, "paidlive_refresh_stream_success", null, r314, r315, r316, 2, null);
    L148:
        r316 = null;
    L140:
        r315 = null;
        goto L141
    L129:
        r120 = null;
    L117:
        r116 = 0;
    L84:
        r47 = null;
        goto L86
    L21:
        r13 = null;
    L172:
        Unit r80 = Unit.INSTANCE;
    L364:
        if (r80 != null) goto L390;
        com.bytedance.android.livesdk.vscore_api.paidlive.g r81 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("error_msg", "invalid url, empty data");
        r0[1] = TuplesKt.to("refresh_scene", String.valueOf(1));
        String r1 = String.valueOf(r41.getId());
        if (r1 != null) goto L368;
        r1 = "";
    L368:
        r0[2] = TuplesKt.to("room_id", r1);
        com.bytedance.android.livesdk.vscore_api.paidlive.b r82 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).J0();
        if (r82 == null) goto L371;
        Long r83 = Long.valueOf(r82.w(((Widget) this.a).dataCenter));
    L372:
        r0[3] = TuplesKt.to("camera_id", String.valueOf(r83.longValue()));
        Map r121 = MapsKt.mutableMapOf(r0);
        Map.Entry r84 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).D2());
        if (r84 == null) goto L379;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r85 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r84.getValue();
        if (r85 == null) goto L379;
        PaidSceneViewEntry r86 = r85.k5();
        if (r86 == null) goto L379;
        String r122 = r86.name();
    L380:
        Map.Entry r87 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).D2());
        if (r87 == null) goto L387;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r88 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r87.getValue();
        if (r88 == null) goto L387;
        PaidSceneEnum r89 = r88.i0();
        if (r89 == null) goto L387;
        String r123 = r89.name();
    L388:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r81, "paidlive_refresh_stream_fail", null, r121, r122, r123, 2, null);
        Unit r90 = Unit.INSTANCE;
        return;
    L387:
        r123 = null;
    L379:
        r122 = null;
        goto L380
    L371:
        r83 = null;
        goto L372
    L390:
        return;
    L10:
        r8 = null;
        goto L11
    L173:
        Object r91 = "async_auth_ab";
        Object r92 = "view_right";
        Object r93 = "async_auth_operate";
        if (r42 != null) goto L176;
    L363:
        r80 = null;
        goto L364
    L176:
        if ((!r42.isEmpty()) == false) goto L178;
        List<? extends VSCameraInfo> r215 = r42;
    L179:
        if (r215 == null) goto L363;
        Iterator<T> r216 = r215.iterator();
    L182:
        if (r216.hasNext() == false) goto L192;
        Object r217 = r216.next();
        Object r317 = r92;
        Object r318 = r91;
        long r94 = ((VSCameraInfo) r217).cameraId;
        Object r218 = r93;
        com.bytedance.android.livesdk.vscore_api.paidlive.b r95 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).J0();
        String r219 = r12;
        if (r95 != null) goto L186;
    L188:
        boolean r96 = false;
    L189:
        if (r96 == true) goto L193;
        r12 = r219;
        r93 = r218;
        r91 = r318;
        r92 = r317;
    L193:
        VSCameraInfo r97 = (VSCameraInfo) r217;
        if (r97 == null) goto L363;
        ALogger.i("PaidLiveTraceMonitorPaidRefreshStreamAbility", "refresh camera stream for buy ticket, cameraId=" + r97.cameraId);
        LivePlayerWidget r98 = this.a;
        IBaseStreamUrl r99 = r97.streamUrl;
        int r124 = LivePlayerWidget.V2;
        r98.getClass();
        String r125 = String.valueOf(1);
        VSCameraInfo r126 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).J0().l(((Widget) r98).dataCenter);
        com.bytedance.android.livesdk.vscore_api.paidlive.b r127 = jc1.k.n(lu2.f.class).paidLiveUtils();
        if (r126 == null) goto L200;
        IMainVSCameraInfo r100 = r126.castToOrNull(IMainVSCameraInfo.class);
        if (r100 == null) goto L200;
        CameraPaidInfo r101 = r100.getCameraPaidInfo();
    L202:
        if (r127.i(r101, null) == true) goto L225;
        com.bytedance.android.livesdk.vscore_api.paidlive.g r319 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r102 = new Pair[2];
        StringBuilder r103 = new StringBuilder("camera ");
        if (r126 == null) goto L206;
        String r104 = r126.cameraIdStr;
    L207:
        r103.append(r104);
        r103.append(" no need change stream");
        r102[0] = TuplesKt.to("reason", r103.toString());
        r102[1] = TuplesKt.to("refresh_scene", r125);
        Map r320 = MapsKt.mutableMapOf(r102);
        Map.Entry r105 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r105 == null) goto L214;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r106 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r105.getValue();
        if (r106 == null) goto L214;
        PaidSceneViewEntry r107 = r106.k5();
        if (r107 == null) goto L214;
        String r321 = r107.name();
    L215:
        Map.Entry r108 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r108 == null) goto L222;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r109 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r108.getValue();
        if (r109 == null) goto L222;
        PaidSceneEnum r128 = r109.i0();
        if (r128 == null) goto L222;
        String r322 = r128.name();
    L223:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r319, "paidlive_refresh_stream_fail", null, r320, r321, r322, 2, null);
    L360:
        r80 = Unit.INSTANCE;
    L222:
        r322 = null;
    L214:
        r321 = null;
        goto L215
    L206:
        r104 = null;
        goto L207
    L225:
        if (((com.bytedance.android.live.platformplayer.b) r98.ar().invoke()).b() == true) goto L255;
        ILivePlayerClient r129 = r98.dr();
        if (r129 == null) goto L233;
        IRoomEventHub r130 = r129.getEventHub();
        if (r130 == null) goto L233;
        MutableLiveData r131 = r130.getStopped();
        if (r131 == null) goto L233;
        Boolean r132 = (Boolean) r131.getValue();
    L235:
        if (Intrinsics.areEqual(r132, Boolean.TRUE) == false) goto L255;
        ALogger.i("LivePlayer", "switchStreamDataForCamera, fragment is not resumed");
        com.bytedance.android.livesdk.vscore_api.paidlive.g r220 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Map r221 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "room-camera"), TuplesKt.to("refresh_scene", r125.toString()), TuplesKt.to("reason", "fragment is not resumed")});
        Map.Entry r133 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r133 == null) goto L243;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r134 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r133.getValue();
        if (r134 == null) goto L243;
        PaidSceneViewEntry r135 = r134.k5();
        if (r135 == null) goto L243;
        String r222 = r135.name();
    L244:
        Map.Entry r136 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r136 == null) goto L251;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r137 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r136.getValue();
        if (r137 == null) goto L251;
        PaidSceneEnum r138 = r137.i0();
        if (r138 == null) goto L251;
        String r223 = r138.name();
    L252:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r220, "paidlive_refresh_stream_success", null, r221, r222, r223, 2, null);
        if (r99 == null) goto L360;
        r98.U2.b(r99);
    L251:
        r223 = null;
    L243:
        r222 = null;
    L233:
        r132 = null;
    L255:
        Room r139 = (IRoom) vh7.f.c(IRoom.class);
        if (r139 == null) goto L362;
        Room r140 = r139;
        if ((r99 instanceof StreamUrl) == true) goto L260;
        IBaseStreamUrl r141 = null;
    L261:
        r140.setStreamUrl((StreamUrl) r141);
        ILivePlayerClient r142 = r98.dr();
        if (r142 != null) goto L264;
    L265:
        ILivePlayerClient r143 = r98.dr();
        if (r143 == null) goto L272;
        IRoomEventHub r144 = r143.getEventHub();
        if (r144 == null) goto L272;
        MutableLiveData r145 = r144.getStopped();
        if (r145 == null) goto L272;
        Boolean r146 = (Boolean) r145.getValue();
    L274:
        if ((!Intrinsics.areEqual(r146, Boolean.TRUE)) == false) goto L295;
        com.bytedance.android.livesdk.vscore_api.paidlive.g r323 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r147 = new Pair[4];
        r147[0] = TuplesKt.to("scene", "room-camera");
        r147[1] = TuplesKt.to("refresh_scene", r125);
        r147[2] = TuplesKt.to("player_state", "not_playing");
        String r148 = r139.getCompoundStreamData();
        if (r148 != null) goto L278;
        r148 = "";
    L278:
        r147[3] = TuplesKt.to("stream_data", r148);
        Map r324 = MapsKt.mutableMapOf(r147);
        Map.Entry r149 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r149 == null) goto L285;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r150 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r149.getValue();
        if (r150 == null) goto L285;
        PaidSceneViewEntry r151 = r150.k5();
        if (r151 == null) goto L285;
        String r325 = r151.name();
    L286:
        Map.Entry r152 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r152 == null) goto L293;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r153 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r152.getValue();
        if (r153 == null) goto L293;
        PaidSceneEnum r154 = r153.i0();
        if (r154 == null) goto L293;
        String r326 = r154.name();
    L294:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r323, "paidlive_refresh_stream_success", null, r324, r325, r326, 2, null);
        r98.Lq(r99, "refresh_paid_stream");
    L293:
        r326 = null;
    L285:
        r325 = null;
    L295:
        ILivePlayerClient r155 = r98.dr();
        if (r155 == null) goto L302;
        IRoomEventHub r156 = r155.getEventHub();
        if (r156 == null) goto L302;
        MutableLiveData r157 = r156.getStopped();
        if (r157 == null) goto L302;
        Boolean r158 = (Boolean) r157.getValue();
    L303:
        Boolean r159 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r158, r159)) == false) goto L326;
        com.bytedance.android.livesdk.vscore_api.paidlive.b r160 = jc1.k.n(lu2.f.class).paidLiveUtils();
        ILivePlayerClient r161 = r98.dr();
        String r162 = r139.getCompoundStreamData();
        NextLiveData r163 = r98.U2.e().getSwitchStreamDataEvent();
        Pair[] r164 = new Pair[6];
        r164[0] = TuplesKt.to("is_preview", "0");
        r164[1] = TuplesKt.to("reason", r219);
        CameraPaidInfo r165 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).J0().r(((Widget) r98).dataCenter);
        if (r165 == null) goto L310;
        AsyncAuthData r166 = r165.getAsyncAuthData();
        if (r166 == null) goto L310;
        long r167 = r166.asyncAuthAB;
    L311:
        r164[2] = TuplesKt.to(r318, String.valueOf(r167));
        CameraPaidInfo r168 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).J0().r(((Widget) r98).dataCenter);
        if (r168 == null) goto L316;
        AsyncAuthData r169 = r168.getAsyncAuthData();
        if (r169 == null) goto L316;
        r25 = r169.needRefreshStream;
    L316:
        r164[3] = TuplesKt.to(r218, String.valueOf(r25));
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.c(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter)) == false) goto L319;
        Object r170 = "1";
    L320:
        r164[4] = TuplesKt.to(r317, r170);
        com.bytedance.android.livesdk.vscore_api.paidlive.b r171 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).J0();
        if (r171 == null) goto L323;
        Long r172 = Long.valueOf(r171.w(((Widget) r98).dataCenter));
    L324:
        r164[5] = TuplesKt.to("current_camera_id", String.valueOf(r172.longValue()));
        com.bytedance.android.livesdk.vscore_api.paidlive.b.a.c(r160, r161, r162, r163, MapsKt.mutableMapOf(r164));
        goto L326
    L323:
        r172 = null;
        goto L324
    L319:
        r170 = "0";
    L310:
        r167 = 0;
    L326:
        if (r99 == null) goto L328;
        r98.U2.b(r99);
    L328:
        com.bytedance.android.livesdk.vscore_api.paidlive.g r224 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r173 = new Pair[4];
        r173[0] = TuplesKt.to("scene", "room-camera");
        r173[1] = TuplesKt.to("refresh_scene", r125);
        String r174 = r139.getCompoundStreamData();
        if (r174 != null) goto L331;
        r174 = "";
    L331:
        r173[2] = TuplesKt.to("stream_data", r174);
        ILivePlayerClient r175 = r98.dr();
        if (r175 == null) goto L338;
        IRoomEventHub r176 = r175.getEventHub();
        if (r176 == null) goto L338;
        MutableLiveData r177 = r176.getStopped();
        if (r177 == null) goto L338;
        Boolean r178 = (Boolean) r177.getValue();
    L340:
        if ((!Intrinsics.areEqual(r178, r159)) == false) goto L342;
        String r179 = "playing";
    L343:
        r173[3] = TuplesKt.to("player_state", r179);
        Map r225 = MapsKt.mutableMapOf(r173);
        Map.Entry r180 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r180 == null) goto L350;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r181 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r180.getValue();
        if (r181 == null) goto L350;
        PaidSceneViewEntry r182 = r181.k5();
        if (r182 == null) goto L350;
        String r226 = r182.name();
    L351:
        Map.Entry r183 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) r98).dataCenter).D2());
        if (r183 == null) goto L358;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r184 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r183.getValue();
        if (r184 == null) goto L358;
        PaidSceneEnum r185 = r184.i0();
        if (r185 == null) goto L358;
        String r327 = r185.name();
    L359:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r224, "paidlive_refresh_stream_success", null, r225, r226, r327, 2, null);
    L358:
        r327 = null;
    L350:
        r226 = null;
        goto L351
    L342:
        r179 = "stopped";
    L338:
        r178 = null;
    L302:
        r158 = null;
    L272:
        r146 = null;
        goto L274
    L264:
        if (r142.isPlaying() == true) goto L295;
    L260:
        r141 = r99;
        goto L261
    L362:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
    L200:
        r101 = null;
        goto L202
    L186:
        if (r94 != r95.w(((Widget) this.a).dataCenter)) goto L188;
        r96 = true;
        goto L189
    L192:
        r317 = r92;
        r318 = r91;
        r218 = r93;
        r219 = r12;
        r217 = null;
        goto L193
    L178:
        r215 = null;
        goto L179
    }

    public final void requestStream4TempWatch(IRoom r1, List<? extends VSCameraInfo> r2) {
        IPaidLiveRefreshStreamListener.DefaultImpls.requestStream4TempWatch(this, r1, r2);
    }

    public final void requestStreamFail(String r9, int r10) {
        com.bytedance.android.livesdk.vscore_api.paidlive.g r0 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r3 = new Pair[2];
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        r3[0] = TuplesKt.to("error_msg", r9);
        r3[1] = TuplesKt.to("request_scene", String.valueOf(r10));
        Map r4 = MapsKt.mutableMapOf(r3);
        Map.Entry r11 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).D2());
        if (r11 == null) goto L12;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r12 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r11.getValue();
        if (r12 == null) goto L12;
        PaidSceneViewEntry r13 = r12.k5();
        if (r13 == null) goto L12;
        String r5 = r13.name();
    L13:
        Map.Entry r14 = com.bytedance.android.live.core.utils.z0.a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).D2());
        if (r14 == null) goto L20;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r15 = (com.bytedance.android.livesdk.vscore_api.paidlive.e) r14.getValue();
        if (r15 == null) goto L20;
        PaidSceneEnum r16 = r15.i0();
        if (r16 == null) goto L20;
        String r6 = r16.name();
    L21:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r0, "paidlive_refresh_stream_fail", null, r4, r5, r6, 2, null);
        return;
    L20:
        r6 = null;
    L12:
        r5 = null;
        goto L13
    }
}
